package com.prizy.product.jobs.tasks;

import com.prizy.product.domain.entity.PricingDetails;
import com.prizy.product.domain.repository.PricingDetailsRepository;
import com.prizy.product.enumeration.StrategyName;
import com.prizy.product.factory.PricingStrategyFactory;
import com.prizy.product.service.PricingService;
import com.prizy.store.service.StorePriceService;
import com.prizy.store.vo.StorePriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component("PriceCalculationTask")
@Scope("prototype")
public class PriceCalculationTask implements Runnable {

    private String productId;
    private PricingService pricingService;

    public PriceCalculationTask(String productId) {
        this.productId = productId;
    }

    @PostConstruct
    public void init() {
        this.pricingService = pricingStrategyFactory.getStrategy(
                StrategyName.valueOf(pricingStrategy));
    }

    @Override
    public void run() {
        List<StorePriceVO> storePriceVOs = storePriceService.findByProductId(productId);
        if (storePriceVOs.size() < 1)
            return;

        computeAndSavePricingDetails(extractPriceList(storePriceVOs));
    }

    List<Double> extractPriceList(List<StorePriceVO> vos) {
        return vos.stream()
                .map(StorePriceVO::getPrice)
                .sorted()
                .collect(Collectors.toList());
    }

    void computeAndSavePricingDetails(List<Double> prices) {
        PricingDetails pricingDetails = computePricingDetails(prices);
        pricingDetailsRepository.save(pricingDetails);
    }

    PricingDetails computePricingDetails(List<Double> prices) {
        Double idealPrice = pricingService.compute(prices, true);

        PricingDetails pricingDetails = new PricingDetails();
        pricingDetails.setId(UUID.randomUUID().toString());
        pricingDetails.setIdealPrice(idealPrice);
        pricingDetails.setAveragePrice(getAverage(prices));
        pricingDetails.setLowestPrice(getLowest(prices));
        pricingDetails.setHighestPrice(getHighest(prices));

        return pricingDetails;
    }

    private Double getLowest(List<Double> priceList) {
        if (priceList.size() < 1)
            return null;
        return priceList.get(0);
    }

    private Double getHighest(List<Double> priceList) {
        if (priceList.size() < 1)
            return null;
        return priceList.get(priceList.size() - 1);
    }

    private Double getAverage(List<Double> priceList) {
        if (priceList.size() < 1)
            return null;

        Double sum = 0d;
        for (int i = 0; i < priceList.size(); i++) {
            sum += priceList.get(i);
        }
        return sum / priceList.size();
    }


    private StorePriceService storePriceService;

    @Autowired
    public void setStorePriceService(StorePriceService storePriceService) {
        this.storePriceService = storePriceService;
    }

    private PricingDetailsRepository pricingDetailsRepository;

    @Autowired
    public void setPricingDetailsRepository(PricingDetailsRepository pricingDetailsRepository) {
        this.pricingDetailsRepository = pricingDetailsRepository;
    }

    private PricingStrategyFactory pricingStrategyFactory;

    @Autowired
    public void setPricingStrategyFactory(PricingStrategyFactory pricingStrategyFactory) {
        this.pricingStrategyFactory = pricingStrategyFactory;
    }

    public void setPricingService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Value("${pricing.strategy:}")
    private String pricingStrategy;
}