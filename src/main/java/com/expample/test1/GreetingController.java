package com.expample.test1;

 import com.expample.test1.domain.Message;
 import com.expample.test1.repos.MessageRepo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestParam;


 import java.util.Map;

@Controller
 public class GreetingController {
        @Autowired
        private MessageRepo messageRepo;

        @GetMapping("/greeting")
        public String greeting(
                @RequestParam(name = "name",required = false, defaultValue = "World") String name,
                Map<String, Object> model) {
            model.put("name", name);
            return "greeting";
        }
        @GetMapping
        public String main(Map<String, Object> model){
            Iterable<Message> messages  = messageRepo.findAll();

            model.put("messages", messages);

            return "main";
        }
        @PostMapping("/main")
        public String add(@RequestParam String frst, @RequestParam String last, Map<String, Object> model ){
            Message message = new Message(frst, last);

            messageRepo.save(message);

            Iterable<Message> messages = messageRepo.findAll();

            model.put("messages", message);

            return "main";

        }


 }