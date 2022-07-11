package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("96jeanvs@gmail.com");
        message.setSubject("Teste");
        message.setText("Testando");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo("96jeanvs@gmail.com");
        helper.setSubject("Teste Attachment");
        helper.setText("Chegou a imagem?");

//        File file1 = new File("src/main/resources/imagem.png");
//        FileSystemResource file = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);

        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.png").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

        emailSender.send(message);
    }

    public void sendEmailCriarPessoa(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Bem Vindo ao App");
            mimeMessageHelper.setText(geContentFromTemplateCriarPessoa(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplateCriarPessoa(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("emailCriarPessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendEmailAlterarPessoa(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("App - Atualização de dados");
            mimeMessageHelper.setText(geContentFromTemplateAlterarPessoa(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplateAlterarPessoa(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("emailAlterarPessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendEmailDeletarPessoa(Pessoa pessoa) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("App - Estamos de portas abertas");
            mimeMessageHelper.setText(geContentFromTemplateDeletarPessoa(pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

    public String geContentFromTemplateDeletarPessoa(Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("emailDeletarPessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
