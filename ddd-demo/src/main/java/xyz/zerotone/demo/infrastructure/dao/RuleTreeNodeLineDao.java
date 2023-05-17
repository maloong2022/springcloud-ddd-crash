package xyz.zerotone.demo.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.zerotone.demo.infrastructure.po.RuleTreeNodeLine;

import java.util.List;

@Mapper
public interface RuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    int queryTreeNodeLineCount(Long treeId);

}