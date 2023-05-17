package xyz.zerotone.demo.domain.rule.model.vo;

import lombok.Data;

import java.util.Map;

/**
 *决策物料
 */
@Data
public class DecisionMatter {
    private Long treeId;                //规则树ID
    private String userId;              //用户ID
    private Map<String, Object> valMap; //决策值
}
