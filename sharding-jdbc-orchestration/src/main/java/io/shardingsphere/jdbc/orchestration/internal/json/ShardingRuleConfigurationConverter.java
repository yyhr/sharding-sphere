/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.jdbc.orchestration.internal.json;

import io.shardingsphere.core.api.algorithm.masterslave.MasterSlaveLoadBalanceAlgorithm;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.ShardingStrategyConfiguration;
import io.shardingsphere.core.keygen.KeyGenerator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Sharding rule configuration json converter.
 *
 * @author zhangliang
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShardingRuleConfigurationConverter {
    
    static {
        GsonFactory.registerTypeAdapter(ShardingStrategyConfiguration.class, new ShardingStrategyConfigurationGsonTypeAdapter());
        GsonFactory.registerTypeAdapter(KeyGenerator.class, new KeyGeneratorGsonTypeAdapter());
        GsonFactory.registerTypeAdapter(MasterSlaveLoadBalanceAlgorithm.class, new MasterSlaveLoadBalanceAlgorithmGsonTypeAdapter());
    }
    
    /**
     * Convert sharding rule configuration to json.
     * 
     * @param shardingRuleConfig sharding rule configuration
     * @return sharding rule configuration json string
     */
    public static String toJson(final ShardingRuleConfiguration shardingRuleConfig) {
        return GsonFactory.getGson().toJson(shardingRuleConfig);
    }
    
    /**
     * Convert sharding rule configuration from json.
     *
     * @param json sharding rule configuration json string
     * @return sharding rule configuration
     */
    public static ShardingRuleConfiguration fromJson(final String json) {
        return GsonFactory.getGson().fromJson(json, ShardingRuleConfiguration.class);
    }
}
