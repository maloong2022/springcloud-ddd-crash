package xyz.zerotone.demo.domain.rule.service.logic;

import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeLineInfo;
import xyz.zerotone.demo.infrastructure.common.Constants;

import java.util.List;

public abstract class BaseLogic extends LogicConfig implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLineInfo> treeNodeLineInfoList) {
        for (TreeNodeLineInfo nodeLine : treeNodeLineInfoList) {
            if (decisionLogic(matterValue, nodeLine)) return  nodeLine.getNodeIdTo();
        }
        return Constants.Global.TreeNullNode;
    }

    @Override
    public abstract String matterValue(DecisionMatter decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLineInfo nodeLine) {
        switch (nodeLine.getRuleLimitType()) {
            case Constants.RuleLimitType.EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.LT:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.GE:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLine.getRuleLimitValue());
            default:
                return false;
        }
    }
}
