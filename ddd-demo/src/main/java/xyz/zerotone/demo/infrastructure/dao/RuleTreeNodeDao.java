package xyz.zerotone.demo.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.zerotone.demo.infrastructure.po.RuleTreeNode;

import java.util.List;

@Mapper
public interface RuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    int queryTreeNodeCount(Long treeId);

    List<RuleTreeNode> queryTreeRulePoint(Long treeId);

}