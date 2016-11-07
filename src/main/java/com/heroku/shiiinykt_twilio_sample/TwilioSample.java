package com.heroku.shiiinykt_twilio_sample;



import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;

import spark.ModelAndView;
import spark.template.pebble.PebbleTemplateEngine;
import spark.utils.StringUtils;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TwilioSample {

	private static String MESSAGE_KEY = "message";
	private static Map<String, String> MESSAGE_CACHE = new ConcurrentHashMap<>();
	
	public static void main(final String[] args) {
		port(Integer.valueOf(System.getenv("PORT")));

		staticFileLocation("/public"); 

		get("/", (req, res) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put(MESSAGE_KEY, MESSAGE_CACHE.get(MESSAGE_KEY));
			
			return new ModelAndView(attributes, "templates/index.peb");
		}, getTemplateEngine());

		post("/", (req, res) ->{

			if(StringUtils.isNotEmpty(req.queryParams(MESSAGE_KEY))) {
				MESSAGE_CACHE.put(MESSAGE_KEY, req.queryParams(MESSAGE_KEY));
			}

			res.redirect("/", 301);
			return "";
		});
		
		get("/callback", (req, res) -> {
			res.type("application/xml");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put(MESSAGE_KEY, MESSAGE_CACHE.get(MESSAGE_KEY));
			
			return new ModelAndView(attributes, "templates/callback.peb");
		}, getTemplateEngine());

	}

	public static PebbleTemplateEngine getTemplateEngine() {
		Loader loader = new ClasspathLoader();
		loader.setPrefix(null);
		return new PebbleTemplateEngine(loader);
	}

}
