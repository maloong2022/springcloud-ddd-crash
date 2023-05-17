package xyz.zerotone.demo.domain.rule.model.aggregates;

import lombok.Data;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeInfo;
import xyz.zerotone.demo.domain.rule.model.vo.TreeRoot;

import java.util.Map;

/**
 * 规则树聚合
 */
@Data
public class TreeRuleRich {
    private TreeRoot treeRoot;                          //树根信息
    private Map<Long, TreeNodeInfo> treeNodeMap;        //树节点ID -> 子节点
}
