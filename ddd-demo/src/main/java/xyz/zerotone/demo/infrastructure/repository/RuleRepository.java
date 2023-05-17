package xyz.zerotone.demo.infrastructure.repository;

import org.springframework.stereotype.Repository;
import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;
import xyz.zerotone.demo.domain.rule.repository.IRuleRepository;
import xyz.zerotone.demo.infrastructure.repository.cache.RuleCacheRepository;
import xyz.zerotone.demo.infrastructure.repository.mysql.RuleMysqlRepository;

import javax.annotation.Resource;

@Repository("ruleRepository")
public class RuleRepository implements IRuleRepository {

    @Resource(name = "ruleMysqlRepository")
    private RuleMysqlRepository ruleMysqlRepository;
    @Resource(name = "ruleCacheRepository")
    private RuleCacheRepository ruleCacheRepository;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        TreeRuleRich treeRuleRich = ruleCacheRepository.queryTreeRuleRich(treeId);
        if (null != treeRuleRich) return treeRuleRich;
        return ruleMysqlRepository.queryTreeRuleRich(treeId);
    }
}
