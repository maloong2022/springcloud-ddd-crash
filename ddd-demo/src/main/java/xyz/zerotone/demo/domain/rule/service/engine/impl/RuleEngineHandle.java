package xyz.zerotone.demo.domain.rule.service.engine.impl;

import org.springframework.stereotype.Service;
import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;
import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.EngineResult;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeInfo;
import xyz.zerotone.demo.domain.rule.repository.IRuleRepository;
import xyz.zerotone.demo.domain.rule.service.engine.EngineBase;

import javax.annotation.Resource;

@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {
    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatter matter) throws Exception {
        //决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) throw new RuntimeException("Tree Rule is null!");
        //决策节点
        TreeNodeInfo treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);
        //决策结果
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }
}
