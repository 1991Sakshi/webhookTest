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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/webhook")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody String obj) throws JsonParseException, JsonMappingException, IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
    	byte[] mapData = obj.getBytes();
    	Map<String,String> myMap = new HashMap<String,String>();
 	myMap = objectMapper.readValue(mapData, HashMap.class);
    return new WebhookResponse("Hello!" , "Text " +obj);
   }//webhookResponse
}
