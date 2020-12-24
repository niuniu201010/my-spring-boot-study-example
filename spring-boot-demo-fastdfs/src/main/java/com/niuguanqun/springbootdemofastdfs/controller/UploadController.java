package com.niuguanqun.springbootdemofastdfs.controller;

import com.niuguanqun.springbootdemofastdfs.fastdfs.FastDFSClient;
import com.niuguanqun.springbootdemofastdfs.fastdfs.FastDFSFile;
import org.csource.common.MyException;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.StorageClient1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Controller
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            String path = saveFile(file);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("path_token",
                    "加密后文件请求路径'" + path + "'");


        } catch (Exception e) {
            logger.error("upload file failed", e);
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


    /**
     * 获取访问服务器的token，拼接到地址后面
     *
     * @param filepath      文件路径 group1/M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
     * @param httpSecretKey 秘钥
     * @return 返回token，如： token=078d370098b03e9020b82c829c205e1f&ts=1508141521
     */
    public static String getToken(String filepath, String httpSecretKey) {
        // unix seconds
        int ts = (int) Instant.now().getEpochSecond();
        // token
        String token = "null";
        try {
            token = ProtoCommon.getToken(getFilename(filepath), ts, httpSecretKey);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("token=").append(token);
        sb.append("&ts=").append(ts);

        return sb.toString();
    }

    /**
     * 获取FastDFS文件的名称，如：M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
     *
     * @param fileId 包含组名和文件名，如：group1/M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
     * @return FastDFS 返回的文件名：M00/00/00/wKgzgFnkTPyAIAUGAAEoRmXZPp876.jpeg
     */
    public static String getFilename(String fileId) {
        String[] results = new String[2];
        StorageClient1.split_file_id(fileId, results);
        return results[1];
    }

    /**
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null) {
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            logger.error("upload file Exception!", e);
        }
        if (fileAbsolutePath == null) {
            logger.error("upload file failed,please upload again!");
        }
        //组合uri
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        //加密token
        String token = getToken(fileAbsolutePath[0] + "/" + fileAbsolutePath[1], fastDFSHttpSecretKey);
        return path+"?"+token;
    }

    /**
     * FastDFS秘钥
     */
    @Value("${http.secret_key}")
    private String fastDFSHttpSecretKey;
}