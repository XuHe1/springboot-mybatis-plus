package top.lovezhangli.mbp.controller;


import top.lovezhangli.mbp.entity.WebContent;
import top.lovezhangli.mbp.service.IWebContentService;
import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Xu He
 * @since 2021-05-06
 */
@Slf4j
@Api(tags = {"内容管理"})
@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private IWebContentService contentService;

    @ApiOperation("新增")
    @PostMapping
    public ResponseBean save(@Valid @RequestBody WebContent content) {
        log.debug("Params: {}", content);
        boolean flag = contentService.save(content);
        return flag ? new ResponseBean(true, ResponseCode.SUCCESS) : new ResponseBean(false, ResponseCode.FAILED);
    }

    @ApiOperation("查询单个")
    @GetMapping("/{contentId}")
    public ResponseBean getById(@PathVariable("contentId") Long contentId ) {
        WebContent content = contentService.getById(contentId);
        return new ResponseBean(true, content);
    }
}
