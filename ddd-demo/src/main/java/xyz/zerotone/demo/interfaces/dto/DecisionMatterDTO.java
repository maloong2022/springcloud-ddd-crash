package xyz.zerotone.demo.interfaces.dto;

import lombok.Data;

import java.util.Map;

@Data
public class DecisionMatterDTO {
    private Long treeId; // ruleId
    private String userId; // userId
    private Map<String,Object> valMap; //rule value
}
