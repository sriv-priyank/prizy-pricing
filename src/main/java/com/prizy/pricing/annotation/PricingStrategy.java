package com.prizy.pricing.annotation;

import com.prizy.pricing.enumeration.StrategyName;
import com.prizy.pricing.factory.PricingStrategyFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * A strategy is a small(ish) class of code that can be applied in several
 * places or as a way of breaking out complex parts into it's own class so
 * it can be easily tested.
 * If markets or deviceGroups is set, there must always be a default (no
 * markets and no deviceGroups) of the same type.
 * The PricingStrategyFactory will automatically get the correct strategy for the
 * profile of the user.
 * group.
 * @see PricingStrategyFactory
 */
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface PricingStrategy {

    StrategyName strategyName();
}
