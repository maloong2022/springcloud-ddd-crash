package xyz.zerotone.demo.domain.tree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.zerotone.demo.application.service.MallTreeService;
import xyz.zerotone.demo.domain.tree.model.aggregates.TreeCollect;
import xyz.zerotone.demo.domain.tree.model.vo.TreeInfo;
import xyz.zerotone.demo.domain.tree.model.vo.TreeRulePoint;
import xyz.zerotone.demo.domain.tree.repository.ITreeRepository;

import javax.annotation.Resource;
import java.util.List;

@Service("mallTreeService")
public class MallTreeServiceImpl implements MallTreeService {

    private Logger logger = LoggerFactory.getLogger(MallTreeServiceImpl.class);

    @Resource
    private ITreeRepository treeRepository;

    @Override
    public TreeCollect queryTreeSummaryInfo(Long treeId) {
        TreeInfo treeInfo = treeRepository.queryTreeInfo(treeId);
        List<TreeRulePoint> treeRulePointList = treeRepository.queryTreeRulePointList(treeId);
        // 封装结果
        TreeCollect treeCollect = new TreeCollect();
        treeCollect.setTreeInfo(treeInfo);
        treeCollect.setTreeRulePointList(treeRulePointList);
        return treeCollect;
    }
}
