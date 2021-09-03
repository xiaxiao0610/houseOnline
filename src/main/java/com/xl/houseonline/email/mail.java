package com.xl.houseonline.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


public class mail {

    public static void main(String[] args) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.addRecipients(Message.RecipientType.TO, "1397820148@qq.com");//设置收信人
//        mimeMessage.addRecipients(Message.RecipientType.CC, "1397820148@qq.com");//抄送

//        Address g13726210510@163.com;
        mimeMessage.setFrom(new InternetAddress("g13726210510@163.com"));//邮件发送人
        mimeMessage.setSubject("测试邮件主题");//邮件主题
        mimeMessage.setContent("Hello,这是一封测试邮件", "text/html;charset=utf-8");//正文
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", "g13726210510@163.com", "ZEUDITJAYVGGMMTX");
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());//发送邮件，第二个参数为收件人
        transport.close();

    }
}
