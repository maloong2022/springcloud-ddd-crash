package xyz.zerotone.demo.infrastructure.repository.mysql;

import org.springframework.stereotype.Repository;
import xyz.zerotone.demo.domain.rule.model.aggregates.TreeRuleRich;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeInfo;
import xyz.zerotone.demo.domain.rule.model.vo.TreeNodeLineInfo;
import xyz.zerotone.demo.domain.rule.model.vo.TreeRoot;
import xyz.zerotone.demo.domain.rule.repository.IRuleRepository;
import xyz.zerotone.demo.infrastructure.common.Constants;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeDao;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeNodeDao;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeNodeLineDao;
import xyz.zerotone.demo.infrastructure.po.RuleTree;
import xyz.zerotone.demo.infrastructure.po.RuleTreeNode;
import xyz.zerotone.demo.infrastructure.po.RuleTreeNodeLine;
import xyz.zerotone.demo.infrastructure.util.CacheUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("ruleMysqlRepository")
public class RuleMysqlRepository implements IRuleRepository {

    @Resource
    private RuleTreeDao ruleTreeDao;
    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private RuleTreeNodeLineDao ruleTreeNodeLineDao;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {

        // 规则树
        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(ruleTree.getId());
        treeRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());
        treeRoot.setTreeName(ruleTree.getTreeName());

        // 树节点->树连接线
        Map<Long, TreeNodeInfo> treeNodeMap = new HashMap<>();
        List<RuleTreeNode> ruleTreeNodeList = ruleTreeNodeDao.queryRuleTreeNodeList(treeId);
        for (RuleTreeNode treeNode : ruleTreeNodeList) {
            List<TreeNodeLineInfo> treeNodeLineInfoList = new ArrayList<>();
            if (Constants.NodeType.STEM.equals(treeNode.getNodeType())) {
                List<RuleTreeNodeLine> ruleTreeNodeLineList = queryRuleTreeNodeLineList(treeNode.getTreeId(), treeNode.getId());
                for (RuleTreeNodeLine nodeLine : ruleTreeNodeLineList) {
                    TreeNodeLineInfo treeNodeLineInfo = new TreeNodeLineInfo();
                    treeNodeLineInfo.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    treeNodeLineInfo.setNodeIdTo(nodeLine.getNodeIdTo());
                    treeNodeLineInfo.setRuleLimitType(nodeLine.getRuleLimitType());
                    treeNodeLineInfo.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    treeNodeLineInfoList.add(treeNodeLineInfo);
                }
            }
            TreeNodeInfo treeNodeInfo = new TreeNodeInfo();
            treeNodeInfo.setTreeId(treeNode.getTreeId());
            treeNodeInfo.setTreeNodeId(treeNode.getId());
            treeNodeInfo.setNodeType(treeNode.getNodeType());
            treeNodeInfo.setNodeValue(treeNode.getNodeValue());
            treeNodeInfo.setRuleKey(treeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(treeNode.getRuleDesc());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineInfoList);

            treeNodeMap.put(treeNode.getId(), treeNodeInfo);
        }

        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRoot(treeRoot);
        treeRuleRich.setTreeNodeMap(treeNodeMap);

        // 写入内存[可以放置在创建时写入]
        CacheUtil.cacheMap.put(treeId, treeRuleRich);

        return treeRuleRich;
    }

    private List<RuleTreeNodeLine> queryRuleTreeNodeLineList(Long treeId, Long treeNodeId) {
        RuleTreeNodeLine ruleTreeNodeLineReq = new RuleTreeNodeLine();
        ruleTreeNodeLineReq.setTreeId(treeId);
        ruleTreeNodeLineReq.setNodeIdFrom(treeNodeId);
        return ruleTreeNodeLineDao.queryRuleTreeNodeLineList(ruleTreeNodeLineReq);
    }
}
