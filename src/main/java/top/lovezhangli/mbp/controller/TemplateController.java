package top.lovezhangli.mbp.controller;


import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xu He
 * @since 2021-05-06
 */
@RestController
@RequestMapping("/templates")
@ApiIgnore
public class TemplateController {
    @PostMapping
    public ResponseBean generate(@RequestParam("contentIds") List<Integer> contentIds) {
        for (Integer contentId: contentIds) {

        }

        return new ResponseBean(true, ResponseCode.SUCCESS);
    }
}
