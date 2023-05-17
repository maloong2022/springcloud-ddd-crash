package xyz.zerotone.demo.domain.rule.service.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;
import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.EngineResult;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeInfo;
import xyz.zerotone.demo.domain.rule.model.vo.TreeRoot;
import xyz.zerotone.demo.domain.rule.service.logic.LogicFilter;

import java.util.Map;

public class EngineBase extends EngineConfig implements EngineFilter{
    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public EngineResult process(DecisionMatter matter) throws Exception {
        throw new RuntimeException("未实现规则引擎服务");
    }

    protected TreeNodeInfo engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatter matter) {
        TreeRoot treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeInfo> treeNodeMap = treeRuleRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNodeInfo treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            String ruleKey = treeNodeInfo.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String matterValue = logicFilter.matterValue(matter);
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }
}
