package com.heroku.shiiinykt_twilio_sample;



import com.twilio.twiml.Say;
import com.twilio.twiml.VoiceResponse;

import static spark.Spark.*;


public class TwilioSample {
	
	 public static void main(final String[] args) {
		 port(Integer.valueOf(System.getenv("PORT")));
		 
		 get("/index", (req, res) -> {
			 res.type("application/xml");
			 
			 VoiceResponse voiceResponse = new VoiceResponse.Builder()
		                .say(new Say.Builder("Hello Monkey").build())
		                .build();
			 return voiceResponse.toXml();
		 });

	 }

}
