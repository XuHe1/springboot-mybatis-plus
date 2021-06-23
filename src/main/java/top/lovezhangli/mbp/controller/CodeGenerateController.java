package top.lovezhangli.mbp.controller;

import top.lovezhangli.mbp.core.CodeGenerateFactory;
import top.lovezhangli.mbp.core.ICodeGenerate;
import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"前端页面生成"})
@RestController
@RequestMapping("/codeGenerate")
public class CodeGenerateController {
    @RequestMapping("/generate")
    public ResponseBean generate(String pageType){
        ICodeGenerate pageStrategy = CodeGenerateFactory.getPageStrategy(pageType);
        Boolean result = pageStrategy.generateCode();
        return result?new ResponseBean(true, ResponseCode.SUCCESS):new ResponseBean(false, ResponseCode.FAILED);
    }
}
