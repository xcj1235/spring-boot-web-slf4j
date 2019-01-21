package com.mkyong;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkyong.LogUtils;

@Controller
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {

		logger.debug("Welcome {}", "testing");
		LogUtils.trace("トレースログです");
		LogUtils.debug("デバッグログです");
		LogUtils.info("情報ログです");
		LogUtils.warn("警告ログです");
		LogUtils.error("エラーログです");
		model.put("message", this.message);
		return "welcome";
	}

}