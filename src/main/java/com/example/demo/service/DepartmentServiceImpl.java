package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Department;
import com.example.demo.repository.DepartmentRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class.getName());

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		System.out.println("Save started");
		log.info("Save started");
		
		return departmentRepository.save(department);

	}

	@Override
	public List<Department> fetchDepartmentList() {
		log.info("Fetch started");
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		log.info("Update started");
		Department dept = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && department.getDepartmentName() != null) {
			dept.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentAdd()) && department.getDepartmentAdd() != null) {
			dept.setDepartmentAdd(department.getDepartmentAdd());
		}

		if (Objects.nonNull(department.getDpartmentCode()) && department.getDpartmentCode() != null) {
			dept.setDpartmentCode(department.getDpartmentCode());
		}

		return departmentRepository.save(dept);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		log.info("Delete started");
		departmentRepository.deleteById(departmentId);

	}
	
	@Override
	public void sendEmail() {
		final String username = "sindhujaa98@gmail.com";
        final String password = "ANIRUDH11";

        // Array of recipients
        List<String> recipients = Arrays.asList("sindhujaa98@gmail.com");
        
        // Email SMTP server details
        String host = "smtp.gmail.com"; 

        // Set up properties for the mail session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set the "From" field
            message.setFrom(new InternetAddress(username));

            // Dynamically add recipients
            
            InternetAddress[] recipientAddresses = recipients.stream()
                .map(email -> {
                    try {
                        return new InternetAddress(email);
                    } catch (AddressException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .toArray(InternetAddress[]::new);
            message.setRecipients(Message.RecipientType.TO, recipientAddresses);
            
            
            // Set the subject and body of the email
            message.setSubject("Test Email");
            message.setText("Test Email to me");
            
//            message.

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
	}

}
