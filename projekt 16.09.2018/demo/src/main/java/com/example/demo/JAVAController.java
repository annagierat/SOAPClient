package com.example.demo;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JAVAController {

    @GetMapping("/")
    public String javaHTML() {return "HTMLDemo";}

    @GetMapping("/contact")
    public String getContact() {return "contact";}

    @PostMapping("/contact")
    public String postContact() {return "contact";}
}
