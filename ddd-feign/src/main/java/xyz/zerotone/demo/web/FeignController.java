package xyz.zerotone.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zerotone.demo.domain.TreeDTO;
import xyz.zerotone.demo.service.MallService;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private MallService mallService;

    @GetMapping(value = "api/queryTreeSummaryInfo")
    public String queryTreeSummaryInfo(Long treeId) {
        return mallService.queryTreeSummaryInfo(new TreeDTO(treeId)).toString();
    }

}