package com.heroku.shiiinykt_twilio_sample;



import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import com.twilio.twiml.Say;
import com.twilio.twiml.Say.Language;
import com.twilio.twiml.VoiceResponse;

import spark.ModelAndView;
import spark.template.pebble.PebbleTemplateEngine;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;


public class TwilioSample {
	
	 public static void main(final String[] args) {
		 port(Integer.valueOf(System.getenv("PORT")));
		 
		 get("/index", (req, res) -> {
			 res.type("application/xml");
			 Map<String, Object> attributes = new HashMap<>();

			 return new ModelAndView(attributes, "templates/index.peb");
		 }, getTemplateEngine());

	 }

		public static PebbleTemplateEngine getTemplateEngine() {
			Loader loader = new ClasspathLoader();
			loader.setPrefix(null);
			return new PebbleTemplateEngine(loader);
		}

}
