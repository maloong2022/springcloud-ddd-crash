package xyz.zerotone.demo.application.service;


import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.EngineResult;

/**
 *  商超规则过滤服务；提供规则树决策功能
 */
public interface MallRuleService {
    /**
     * 决策服务
     * @param matter 决策物料
     * @return       决策结果
     */
    EngineResult process(final DecisionMatter matter);
}
