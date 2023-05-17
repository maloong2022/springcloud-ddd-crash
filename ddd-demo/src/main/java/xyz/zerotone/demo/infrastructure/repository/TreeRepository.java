package xyz.zerotone.demo.infrastructure.repository;

import org.springframework.stereotype.Repository;
import xyz.zerotone.demo.domain.tree.model.vo.TreeInfo;
import xyz.zerotone.demo.domain.tree.model.vo.TreeRulePoint;
import xyz.zerotone.demo.domain.tree.repository.ITreeRepository;
import xyz.zerotone.demo.infrastructure.repository.mysql.TreeMysqlRepository;

import javax.annotation.Resource;
import java.util.List;

@Repository("treeRepository")
public class TreeRepository implements ITreeRepository {

    @Resource
    private TreeMysqlRepository treeMysqlRepository;

    @Override
    public TreeInfo queryTreeInfo(Long treeId) {
        return treeMysqlRepository.queryTreeInfo(treeId);
    }

    @Override
    public List<TreeRulePoint> queryTreeRulePointList(Long treeId) {
        return treeMysqlRepository.queryTreeRulePointList(treeId);
    }
}
