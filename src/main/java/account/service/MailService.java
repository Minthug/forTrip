package account.service;


import account.entity.Account;
import global.utils.ConfigUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.username}")
    private String email;
//    private final JavaMailSender

    public void sendMail(Account account) throws MessagingException, UnsupportedEncodingException, UnknownHostException {
//        MimeMessage message = javaMailSender.createMimeMessage();
        String hostAddress = InetAddress.getLocalHost().getHostAddress(); // Server address
        StringBuilder address = new StringBuilder();

        if (ConfigUtils.IS_DEV) {
            address.append("http://localhost");
        } else {
            address.append("https://").append(hostAddress);
        }

        address.append("/account/checkEmail?email=").append(account.getEmail()).append("$code=")
                .append(account.getEmailCode());

//        message.addRecipients(RecipientType.TO, member.getEmail()); // 보내는 대상
//        message.setSubject("chu-chu 회원가입 이메일 인증"); // 제목
//
//        message.setText(mailTemplate(address.toString()), "UTF-8", "html");// 내용, charset 타입, subtype
//        message.setFrom(new InternetAddress(email, "ChuChu_Admin")); // 보내는 사람
//
//        javaMailSender.send(message); // 메일 발송
    }

    /*
    인증 메일 템플릿
     */
    private String mailTemplate(String address) {
        String msg = "";
        msg += "<div style='margin:100px;'>";
        msg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msg += "<h3>회원가입 인증 링크를 클릭하세요.</h3>";
        msg += "<div style='font-size:130%'>";
        msg += "<a href=" + address + ">이메일 인증하기</a><div><br/> ";
        msg += "</div>";

        return msg;
    }
}
