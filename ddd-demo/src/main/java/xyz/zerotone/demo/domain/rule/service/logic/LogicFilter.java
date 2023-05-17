package xyz.zerotone.demo.domain.rule.service.logic;


import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeLineInfo;

import java.util.List;

public interface LogicFilter {
    /**
     * 逻辑决策器
     * @param matterValue          决策值
     * @param treeNodeLineInfoList 决策节点
     * @return                     下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLineInfo> treeNodeLineInfoList);

    /**
     * 获取决策值
     *
     * @param decisionMatter 决策物料
     * @return               决策值
     */
    String matterValue(DecisionMatter decisionMatter);
}
