package com.niuguanqun.springbootdemoemail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("306565163@qq.com", "test simple mail", " hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("306565163@qq.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        //excel附件
//        String filePath = "c:\\Users\\Administrator\\Desktop\\绩效牛冠群\\9月员工绩效考核评估表-牛冠群.xlsx";

        //word附件
        String filePath = "c:\\Users\\Administrator\\Desktop\\新华产业.docx";

        //pdf附件
//        String filePath = "c:\\Users\\Administrator\\Desktop\\10.pdf";

        //图片附件
//        String filePath = "c:\\Users\\Administrator\\Desktop\\美容.png";

        //音频附件
//        String filePath = "E:\\google_download\\music\\弱水三千.mp3";

        //视频附件
//        String filePath = "E:\\google_download\\music\\弱水三千.mp3";

        mailService.sendAttachmentsMail("306565163@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "ngq001";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "c:\\Users\\Administrator\\Desktop\\钣喷.png";

        mailService.sendInlineResourceMail("306565163@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("306565163@qq.com", "主题：这是模板邮件", emailContent);
    }
}