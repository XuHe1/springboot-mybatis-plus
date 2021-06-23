package top.lovezhangli.mbp.controller;


import top.lovezhangli.mbp.entity.WebContentType;
import top.lovezhangli.mbp.service.IContentTypeService;
import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Xu He
 * @since 2021-05-06
 */
@Api(tags = {"内容类型"})
@RestController
@RequestMapping("/content-type")
public class ContentTypeController {

    @Autowired
    private IContentTypeService contentTypeService;

    @ApiOperation("查询所有")
    @GetMapping
    public ResponseBean<List<WebContentType>> list() {
        List<WebContentType> webContentTypes = contentTypeService.list();
        return new ResponseBean(true,webContentTypes, ResponseCode.SUCCESS);
    }

}
