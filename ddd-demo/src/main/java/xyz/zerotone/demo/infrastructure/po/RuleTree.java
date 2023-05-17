package xyz.zerotone.demo.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * 规则树
 */
@Data
public class RuleTree {

    private Long id;             //主键ID
    private String treeName;     //规则树名称
    private String treeDesc;     //规则树描述
    private Long treeRootNodeId; //规则树根ID
    private Date createTime;     //创建时间
    private Date updateTime;     //更新时间
}
