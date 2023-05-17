package xyz.zerotone.demo.domain.rule.service.logic.impl;

import org.springframework.stereotype.Service;
import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.service.logic.BaseLogic;

@Service("userAgeFilter")
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatter decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }
}
