package xyz.zerotone.demo.infrastructure.repository.mysql;

import org.springframework.stereotype.Service;
import xyz.zerotone.demo.domain.tree.model.vo.TreeInfo;
import xyz.zerotone.demo.domain.tree.model.vo.TreeRulePoint;
import xyz.zerotone.demo.domain.tree.repository.ITreeRepository;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeDao;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeNodeDao;
import xyz.zerotone.demo.infrastructure.dao.RuleTreeNodeLineDao;
import xyz.zerotone.demo.infrastructure.po.RuleTree;
import xyz.zerotone.demo.infrastructure.po.RuleTreeNode;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("treeMysqlRepository")
public class TreeMysqlRepository implements ITreeRepository {

    @Resource
    private RuleTreeDao ruleTreeDao;
    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private RuleTreeNodeLineDao ruleTreeNodeLineDao;

    @Override
    public TreeInfo queryTreeInfo(Long treeId) {

        // 查询规则树简要信息
        RuleTree ruleTree = ruleTreeDao.queryTreeSummaryInfo(treeId);
        int nodeCount = ruleTreeNodeDao.queryTreeNodeCount(treeId);
        int nodeLineCount = ruleTreeNodeLineDao.queryTreeNodeLineCount(treeId);

        TreeInfo treeInfo = new TreeInfo();
        treeInfo.setTreeId(treeId);
        treeInfo.setTreeName(ruleTree.getTreeName());
        treeInfo.setTreeDesc(ruleTree.getTreeDesc());
        treeInfo.setNodeCount(nodeCount);
        treeInfo.setLineCount(nodeLineCount);

        return treeInfo;
    }

    @Override
    public List<TreeRulePoint> queryTreeRulePointList(Long treeId) {
        List<RuleTreeNode> treeNodeList = ruleTreeNodeDao.queryTreeRulePoint(treeId);
        List<TreeRulePoint> treeRulePointList = new ArrayList<>(treeNodeList.size());
        for (RuleTreeNode treeNode : treeNodeList) {
            treeRulePointList.add(new TreeRulePoint(treeNode.getRuleKey(),treeNode.getRuleDesc()));
        }
        return treeRulePointList;
    }
}
