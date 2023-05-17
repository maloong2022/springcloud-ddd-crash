package xyz.zerotone.demo.domain.rule.service.engine;


import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.EngineResult;

public interface EngineFilter {
    EngineResult process(final DecisionMatter matter) throws Exception;
}
