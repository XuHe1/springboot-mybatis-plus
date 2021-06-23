package top.lovezhangli.mbp.core;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public interface ICodeGenerate {
    /**
     * 根据不同页面的模板，从数据库查询数据，组装参数
     * @return
     */
    Map<String,Object> getMapParams();

    /**
     * 生成静态页面
     * @return
     */
    Boolean generateCode();

    /**
     * 生成静态页面
     * @param templatePath
     * @param templateFile
     * @param targetFilePath
     * @return
     */
    default Boolean generateCode(String templatePath,String templateFile,String targetFilePath){
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        File path = new File(templatePath);
        try {
            cfg.setDirectoryForTemplateLoading(path);
            cfg.setDefaultEncoding("UTF-8");
            Template template = cfg.getTemplate(templateFile);
            Map params = getMapParams();
            FileWriter writer = new FileWriter(new File(targetFilePath));
            template.process(params, writer);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
