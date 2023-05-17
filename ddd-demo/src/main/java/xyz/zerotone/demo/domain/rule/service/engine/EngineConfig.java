package xyz.zerotone.demo.domain.rule.service.engine;

import lombok.Data;
import xyz.zerotone.demo.domain.rule.service.logic.LogicFilter;
import xyz.zerotone.demo.domain.rule.service.logic.impl.UserAgeFilter;
import xyz.zerotone.demo.domain.rule.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }
}
