package xyz.zerotone.demo.domain.tree.model.aggregates;

import lombok.Data;
import xyz.zerotone.demo.domain.tree.model.vo.TreeInfo;
import xyz.zerotone.demo.domain.tree.model.vo.TreeRulePoint;

import java.util.List;

@Data
public class TreeCollect {
    private TreeInfo treeInfo;
    private List<TreeRulePoint> treeRulePointList;
}
