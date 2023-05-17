package xyz.zerotone.demo.infrastructure.repository.cache;

import org.springframework.stereotype.Repository;
import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;
import xyz.zerotone.demo.domain.rule.repository.IRuleRepository;
import xyz.zerotone.demo.infrastructure.util.CacheUtil;

@Repository("ruleCacheRepository")
public class RuleCacheRepository implements IRuleRepository {

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        return (TreeRuleRich) CacheUtil.cacheMap.get(treeId);
    }
}
