package xyz.zerotone.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.zerotone.demo.domain.TreeDTO;

@FeignClient(value = "springcloud-ddd-crash-demo")
public interface MallService {

    @RequestMapping(value = "/api/tree/queryTreeSummaryInfo", method = RequestMethod.POST)
    Object queryTreeSummaryInfo(@RequestBody TreeDTO request);
}
