package xyz.zerotone.demo.domain.tree.model.vo;

import lombok.Data;

@Data
public class TreeRulePoint {
    private String ruleKey;      //规则Key
    private String ruleDesc;     //规则描述

    public TreeRulePoint() {
    }

    public TreeRulePoint(String ruleKey, String ruleDesc) {
        this.ruleKey = ruleKey;
        this.ruleDesc = ruleDesc;
    }
}
