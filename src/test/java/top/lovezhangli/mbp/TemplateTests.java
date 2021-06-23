package top.lovezhangli.mbp;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TemplateTests {

    @Test
    void testTemplate() {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        File path = new File("E:\\IdeaProjects\\hly-website\\src\\main\\resources\\templates");
        try {
            cfg.setDirectoryForTemplateLoading(path);
            cfg.setDefaultEncoding("UTF-8");
            Template template = cfg.getTemplate("hello.ftl");
            Map model = new HashMap();
            model.put("username", "张三");
            FileWriter writer = new FileWriter(new File("E:\\IdeaProjects\\hly-website\\src\\main\\resources\\static\\hello.html"));
            template.process(model, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
