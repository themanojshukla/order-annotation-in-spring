package com.jstobigdata.order_annotation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class CollectionInjectionExampleMain {

	public static void main(String[] args) {
		SpringApplication.run(CollectionInjectionExampleMain.class, args);
	}

	@Bean
	public CommandLineRunner demo(List<NotificationHandler> handlers) {
		return (args) -> handlers.forEach(NotificationHandler::send);
	}

}

interface NotificationHandler { void send(); }

@Service
@Order(1)
class SmsNotification implements NotificationHandler {

	@Override
	public void send() {
		System.out.println("SMS Notification Handler");
	}

}

@Service
@Order(2)
class SlackNotification implements NotificationHandler {

	@Override
	public void send() {
		System.out.println("Slack Notification Handler");
	}

}

@Service
@Order(3)
class EmailNotification implements NotificationHandler {

	@Override
	public void send() {
		System.out.println("Email Notification Handler");
	}

}
