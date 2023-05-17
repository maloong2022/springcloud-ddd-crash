package xyz.zerotone.demo.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * 规则树配置信息
 */
@Data
public class RuleTreeConfig {
    private Long id;            //主键ID
    private String ruleKey;     //规则Key
    private String ruleDesc;    //规则描述
    private Integer limitType;  //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String limitMode;   //限制模式 1单选框、2多选框、3日期单录框、4日期范围框、5输入框
    private String permitValue; //限定值
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间
}
