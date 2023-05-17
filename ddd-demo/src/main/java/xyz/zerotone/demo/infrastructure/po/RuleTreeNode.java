package xyz.zerotone.demo.infrastructure.po;

import lombok.Data;

/**
 * 规则树，节点
 */
@Data
public class RuleTreeNode {
    private Long id;          //主键ID
    private Long treeId;      //规则树ID
    private Integer nodeType; //节点类型；1子叶、2果实
    private String nodeValue; //节点值[nodeType=2]；果实值
    private String ruleKey;   //规则Key
    private String ruleDesc;  //规则描述
}
