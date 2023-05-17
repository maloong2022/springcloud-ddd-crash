package xyz.zerotone.demo.domain.tree.repository;


import xyz.zerotone.demo.domain.tree.model.vo.TreeInfo;
import xyz.zerotone.demo.domain.tree.model.vo.TreeRulePoint;

import java.util.List;

public interface ITreeRepository {
    TreeInfo queryTreeInfo(Long treeId);

    List<TreeRulePoint> queryTreeRulePointList(Long treeId);
}
