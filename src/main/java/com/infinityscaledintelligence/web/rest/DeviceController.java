package com.infinityscaledintelligence.web.rest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.infinityscaledintelligence.domain.entity.Device;
import org.infinityscaledintelligence.domain.messaging.ChannelFactory;
import org.infinityscaledintelligence.domain.messaging.ChannelType;
import org.infinityscaledintelligence.domain.messaging.MessageContext;
import org.infinityscaledintelligence.domain.messaging.PointToPointChannel;
import org.openinfinity.core.annotation.AuditTrail;
import org.openinfinity.core.annotation.Log;
import org.openinfinity.core.annotation.Log.LogLevel;
import org.openinfinity.core.aspect.ArgumentStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class DeviceController {
	
	private Validator validator;
	private PointToPointChannel<MessageContext> outboundPointToPointChannel;
	private PointToPointChannel<MessageContext> inboundPointToPointChannel;
	
	public DeviceController(HttpServletRequest httpServletRequest) {
		outboundPointToPointChannel = ChannelFactory.getPointToPointChannel(ChannelType.INTERNAL_OUTBOUND,"outbound" + httpServletRequest.getSession().getId());
		//inboundPointToPointChannel = ChannelFactory.getPointToPointChannel("inbound" + httpServletRequest.getSession().getId());
	}
	
	@Log(level=LogLevel.INFO)
	@AuditTrail(argumentStrategy=ArgumentStrategy.ALL)
	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		return "application/application";
	}
	
	@Log(level=LogLevel.INFO)
	@AuditTrail(argumentStrategy=ArgumentStrategy.ALL)
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> create(@Valid @RequestBody Device<?> device, HttpServletResponse response) {
		long startTime = System.currentTimeMillis();
		System.out.println("Creating account..");
//		Set<ConstraintViolation<String>> failures = validator.validate(device);
//		if (!failures.isEmpty()) {
//			System.out.println("Failures found..");
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//			return validationMessages(failures);
//		} else {
//			MessageContext messageContext = new MessageContext(device);
//			messageContext.setDevice(device);
//			outboundPointToPointChannel.send(messageContext);
//			return Collections.singletonMap("id", "success");
//		}
		return null;
	}
	
	@Log(level=LogLevel.INFO)
	@AuditTrail(argumentStrategy=ArgumentStrategy.ALL)
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Device<?> get(@PathVariable Long id) {
		// TODO look for the rxtx java lib by netflix
		MessageContext messageContext = inboundPointToPointChannel.receive();
	return null;
		//	return messageContext.getDevice();
	}
	
	private Map<String, String> fieldValidationMessage(Set<ConstraintViolation<String>> failures) {
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<String> failure : failures) {
			System.out.println("Adding failure: " + failure.getPropertyPath().toString() + " : " + failure.getMessage());
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		return failureMessages;
	}
	
	private Map<String, String> validationMessages(Set<ConstraintViolation<Device<?>>> failures) {
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<Device<?>> failure : failures) {
			System.out.println("Adding failure: " + failure.getPropertyPath().toString() + " : " + failure.getMessageTemplate());
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		return failureMessages;
	}

}