package com.heroku.shiiinykt_twilio_sample;



import com.twilio.twiml.Say;
import com.twilio.twiml.VoiceResponse;

import static spark.Spark.*;


public class TwilioSample {
	
	 public static void main(final String[] args) {
			
		 get("/index", (req, res) -> {
			 res.type("application/xml");
			 
			 VoiceResponse voiceResponse = new VoiceResponse.Builder()
		                .say(new Say.Builder("Hello Monkey").build())
		                .build();
			 return voiceResponse.toXml();
		 });

	 }

}
