package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
//import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/webhook")
public class HelloWorldController {

    @SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody String obj) throws JsonParseException, JsonMappingException, IOException{
         //String n="Sakshi";
    	//Gson gson = new GsonBuilder().setPrettyPrinting().create();
         //String n=obj1.getString("result");
    	//Date d=new Date();
    	ObjectMapper objectMapper = new ObjectMapper();
    	byte[] mapData = obj.getBytes();
    	//Map<String,String> myMap = new HashMap<String, String>();
    	//myMap = objectMapper.readValue(mapData, HashMap.class);
         return new WebhookResponse("Hello! "+mapData[0] , "Text " + obj);
    }//webhookResponse
}
