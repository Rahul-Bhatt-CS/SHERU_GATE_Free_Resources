package com.Sheru.BTech_V0.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPage_Controller {
    @GetMapping("/home")
    public String homepage(){
        return "Home.html";
    }
    @GetMapping("/feedback")
    public String feedbackpage(){return "feedback.html";}
    @GetMapping("/gate")
    public String gatelandingpage(){return "Gate_Landing_page.html";}
    @GetMapping("/v0/gatecse")
    public String gatecse(){return "Gate_CSE.html";}
    @GetMapping("/newvideoform_CSE")
    public String videoform(){return "Add_video_CSE.html";}
    @GetMapping("/v0/gateece")
    public String gateece(){return "Gate_ECE.html";}
    @GetMapping("/newvideoform_ECE")
    public String videoformec(){return "Add_video_ECE.html";}
}