package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("Arabic")) {
            greeting = "Marhaba";
        } else if (l.equals("Bosnian")) {
            greeting = "Zdravo";
        } else if (l.equals("English")) {
            greeting = "Hello";
        } else if (l.equals("French")) {
            greeting = "Bonjour";
        } else if (l.equals("German")) {
            greeting = "Hallo";
        }
        return  "<html>" +
                "<body>" +
                "<br>" +
                "<h1>You choose to be greeted in " + l + "!</h1>" +
                "<h2>" + greeting + " " + n + "!</h2>" +
                "</body>" +
                "</html>";
    }


    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" +
                "Name: " + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language'>" +
                "<option value = 'Arabic'>Arabic</option>" +
                "<option value = 'Bosnian'>Bosnian</option>" +
                "<option value = 'English'>English</option>" +
                "<option value = 'French'>French</option>" +
                "<option value = 'German'>German</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
