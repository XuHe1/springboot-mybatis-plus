package top.lovezhangli.mbp.core.impl;

import top.lovezhangli.mbp.core.ICodeGenerate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页生成器
 */
@Component("homePage")
public class HomePageCodeGenerate implements ICodeGenerate {
    @Override
    public Map<String, Object> getMapParams() {
        Map model = new HashMap();
        model.put("username", "张三");
        return model;
    }

    @Override
    public Boolean generateCode() {
        String templatePath="D:\\code\\new_hly\\hly_website\\src\\main\\resources\\templates";
        String templateFile="hello.ftl";
        String targetFilePath="D:\\1.html";
        return generateCode(templatePath, templateFile, targetFilePath);
    }
}