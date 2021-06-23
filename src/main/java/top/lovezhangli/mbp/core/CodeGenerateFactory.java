package top.lovezhangli.mbp.core;

import top.lovezhangli.mbp.util.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeGenerateFactory {
    public static ICodeGenerate getPageStrategy(String pageType) {
        ICodeGenerate codeGenerate = null;
        try {
            String value = PageEnum.getValue(pageType);
            if(value==null){
                log.error("通过页面类型未获取到页面类型枚举,pageType={}",pageType);
                return null;
            }
            codeGenerate = (ICodeGenerate) SpringContextUtils.getBean(value);
        } catch (Exception e) {
            log.error("获取页面生成器异常,",e);
        }
        return codeGenerate;
    }
}
