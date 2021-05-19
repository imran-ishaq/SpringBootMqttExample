package com.gaoyf.mqtt.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
	
	private String message;
	
	private int status;
	
	private JsonNode data;

	public Response(int status, String message, JsonNode data) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}
	
	public String toString() {
		Response node = new Response();
		node.setMessage(this.message);
		node.setStatus(this.status);
		JsonNode jNode = new ObjectMapper().convertValue(node, JsonNode.class);
		return jNode.toString();
		
	}

}
