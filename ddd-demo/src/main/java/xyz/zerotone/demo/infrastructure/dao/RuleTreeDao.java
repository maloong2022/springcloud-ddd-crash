package xyz.zerotone.demo.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.zerotone.demo.infrastructure.po.RuleTree;

@Mapper
public interface RuleTreeDao {

    RuleTree queryRuleTreeByTreeId(Long id);

    RuleTree queryTreeSummaryInfo(Long treeId);

}