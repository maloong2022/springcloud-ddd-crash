package xyz.zerotone.demo.infrastructure.po;

import lombok.Data;

/**
 * 规则树，节点，连线
 */
@Data
public class RuleTreeNodeLine {
    private Long id;              //主键ID
    private Long treeId;          //规则树ID
    private Long nodeIdFrom;      //节点From
    private Long nodeIdTo;        //节点To
    private Integer ruleLimitType;//限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String ruleLimitValue;//限定值
}
