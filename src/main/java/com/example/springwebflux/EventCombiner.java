package com.example.springwebflux;

import java.time.LocalDateTime;

import reactor.core.publisher.Flux;

public class EventCombiner {
	private MessageDetails messageDetails;
	private LocalDateTime date;

	public EventCombiner(MessageDetails string, LocalDateTime date) {
		super();
		this.messageDetails = string;
		this.date = date;
	}

	public MessageDetails getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(MessageDetails messageDetails) {
		this.messageDetails = messageDetails;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	
	


	

}
