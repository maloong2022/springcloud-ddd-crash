package xyz.zerotone.demo.domain.rule.repository;


import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;

public interface IRuleRepository {
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
