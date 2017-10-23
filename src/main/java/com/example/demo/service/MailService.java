package com.example.demo.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    Configuration configuration; //freeMarker configuration

    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("271711192@qq.com");
        message.setTo("271711192@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("271711192@qq.com");
        helper.setTo("271711192@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");
        FileSystemResource file = new FileSystemResource(new File("logs/error.log"));
        helper.addAttachment("附件-1.log", file);
        helper.addAttachment("附件-2.log", file);
        mailSender.send(mimeMessage);
    }

    public void sendModelMails() throws  Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("271711192@qq.com");
        helper.setTo("271711192@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashMap<>();
        model.put("username", "liaozhiwei");
        Template t = configuration.getTemplate("ftl/mailVelocity.ftl"); // freeMarker template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        helper.setText(content, true);
        mailSender.send(mimeMessage);
    }
}
