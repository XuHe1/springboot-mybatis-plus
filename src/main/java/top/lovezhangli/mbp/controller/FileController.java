package top.lovezhangli.mbp.controller;

import top.lovezhangli.mbp.vo.ResponseBean;
import top.lovezhangli.mbp.vo.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * Desc: FileController
 * Author: Xu He
 * created: 2021/5/6 9:40
 */
@Api(tags = {"文件相关"})
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${file.baseDir}")
    private String baseDir;
    @Value("${file.urlPrefix}")
    private String urlPrefix;

    @ApiOperation("上传图片")
    @PostMapping
    public ResponseBean upload(@RequestParam("file") MultipartFile file) {
        long size = file.getSize();
        // 判断大小

        String suffix = "." + file.getOriginalFilename().split("\\.")[1];
        String filename = UUID.randomUUID() + suffix;
        File destFile = new File(baseDir + filename);

        try ( InputStream in = file.getInputStream();
               FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.flush();


        } catch (Exception e) {

        }

        String fileUrl = urlPrefix +filename;
        return new ResponseBean(true,fileUrl,ResponseCode.SUCCESS);
    }
}
