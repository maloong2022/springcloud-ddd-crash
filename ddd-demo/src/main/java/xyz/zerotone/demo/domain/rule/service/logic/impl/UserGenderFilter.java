package xyz.zerotone.demo.domain.rule.service.logic.impl;

import org.springframework.stereotype.Service;
import xyz.zerotone.demo.domain.rule.model.vo.DecisionMatter;
import xyz.zerotone.demo.domain.rule.service.logic.BaseLogic;

@Service("userGenderFilter")
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatter decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
}
