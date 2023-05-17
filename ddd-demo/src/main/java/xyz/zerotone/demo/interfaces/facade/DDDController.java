package xyz.zerotone.demo.interfaces.facade;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import xyz.zerotone.demo.application.service.MallRuleService;
import xyz.zerotone.demo.application.service.MallTreeService;
import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.model.vo.EngineResult;
import xyz.zerotone.demo.domain.tree.model.aggregates.TreeCollect;
import xyz.zerotone.demo.interfaces.dto.DecisionMatterDTO;
import xyz.zerotone.demo.interfaces.dto.TreeDTO;

import javax.annotation.Resource;

@EnableEurekaClient
@RestController
public class DDDController {
    private Logger logger = LoggerFactory.getLogger(DDDController.class);


    @Resource
    private MallTreeService mallTreeService;
    @Resource
    private MallRuleService mallRuleService;


    /**
     * 测试接口：http://localhost:8081/api/tree/queryTreeSummaryInfo
     * 请求参数：{"treeId":10001}
     */
    @RequestMapping(path = "/api/tree/queryTreeSummaryInfo", method = RequestMethod.POST)
    public TreeCollect queryTreeSummaryInfo(@RequestBody TreeDTO request) {
        String reqStr = JSON.toJSONString(request);
        try {
            logger.info("查询规则树信息{}Begin req：{}", request.getTreeId(), reqStr);
            TreeCollect treeCollect = mallTreeService.queryTreeSummaryInfo(request.getTreeId());
            logger.info("查询规则树信息{}End res：{}", request.getTreeId(), JSON.toJSON(treeCollect));
            return treeCollect;
        } catch (Exception e) {
            logger.error("查询规则树信息{}Error req：{}", request.getTreeId(), reqStr, e);
            return null;
        }
    }

    /**
     * 测试接口：http://localhost:8081/api/tree/decisionRuleTree
     * 请求参数：{"treeId":10001,"userId":"fuzhengwei","valMap":{"gender":"man","age":"25"}}
     */
    @RequestMapping(path = "/api/tree/decisionRuleTree", method = RequestMethod.POST)
    public EngineResult decisionRuleTree(@RequestBody DecisionMatterDTO request) {
        String reqStr = JSON.toJSONString(request);
        try {
            logger.info("规则树行为信息决策{}Begin req：{}", request.getTreeId(), reqStr);
            DecisionMatter decisionMatter = new DecisionMatter();
            decisionMatter.setTreeId(request.getTreeId());
            decisionMatter.setUserId(request.getUserId());
            decisionMatter.setValMap(request.getValMap());
            EngineResult engineResult = mallRuleService.process(decisionMatter);
            logger.info("规则树行为信息决策{}End res：{}", request.getTreeId(), JSON.toJSON(engineResult));
            return engineResult;
        } catch (Exception e) {
            logger.error("规则树行为信息决策{}Error req：{}", request.getTreeId(), reqStr, e);
            return new EngineResult(false);
        }
    }
}
