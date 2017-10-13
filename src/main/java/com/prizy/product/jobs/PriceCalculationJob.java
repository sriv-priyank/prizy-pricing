package com.prizy.product.jobs;

import com.prizy.product.domain.entity.PricingDetails;
import com.prizy.product.domain.repository.PricingDetailsRepository;
import com.prizy.product.enumeration.StrategyName;
import com.prizy.product.factory.PricingStrategyFactory;
import com.prizy.product.service.PricingService;
import com.prizy.product.service.ProductService;
import com.prizy.product.vo.ProductVO;
import com.prizy.store.service.StorePriceService;
import com.prizy.store.vo.StorePriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


@Component
public class PriceCalculationJob {

    private ExecutorService taskExecutor, jobExecutor;
    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private PricingService pricingService;

    @PostConstruct
    public void init() {
        taskExecutor = Executors.newFixedThreadPool(threadCount);
        jobExecutor = Executors.newSingleThreadExecutor();
        pricingService = pricingStrategyFactory.getStrategy(StrategyName.IDEAL);
    }

    @Scheduled(initialDelay = 0, fixedRate = 3_600_000)
    public long calculatePrices() {
        if (isRunning.compareAndSet(false, true)) {
            jobExecutor.execute(this::calculate);
            return System.currentTimeMillis();
        } else {
            return -1;
        }
    }

    private void calculate() {
        List<ProductVO> products = productService.findAllProducts();
        for (ProductVO product : products) {
            taskExecutor.execute(new PriceCalculationTask(product.getId()));
        }
        isRunning.set(false);
    }

    private class PriceCalculationTask implements Runnable {

        String productId;

        PriceCalculationTask(String productId) {
            this.productId = productId;
        }

        @Override
        public void run() {
            List<StorePriceVO> storePriceVOs = storePriceService.findByProductId(productId);
            if (storePriceVOs.size() < 1)
                return;

            List<Double> prices = storePriceVOs.stream()
                    .map(StorePriceVO::getPrice)
                    .sorted()
                    .collect(Collectors.toList());
            computeAndSavePricingDetails(prices);
        }

        private void computeAndSavePricingDetails(List<Double> prices) {
            Double idealPrice = pricingService.compute(prices, true);

            PricingDetails pricingDetails = new PricingDetails();
            pricingDetails.setId(UUID.randomUUID().toString());
            pricingDetails.setIdealPrice(idealPrice);
            pricingDetails.setAveragePrice(getAverage(prices));
            pricingDetails.setLowestPrice(getLowest(prices));
            pricingDetails.setHighestPrice(getHighest(prices));

            pricingDetailsRepository.save(pricingDetails);
        }

        private Double getLowest(List<Double> priceList) {
            return priceList.get(0);
        }

        private Double getHighest(List<Double> priceList) {
            return priceList.get(priceList.size() - 1);
        }

        private Double getAverage(List<Double> priceList) {
            Double sum = 0d;
            for (int i = 0; i < priceList.size(); i++) {
                sum += priceList.get(i);
            }
            return sum / priceList.size();
        }
    }


    @Autowired
    private PricingStrategyFactory pricingStrategyFactory;

    @Autowired
    private ProductService productService;

    @Autowired
    private StorePriceService storePriceService;

    @Value("${calculationJob.threads:2}")
    private int threadCount;

    @Autowired
    private PricingDetailsRepository pricingDetailsRepository;
}
