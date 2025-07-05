package com.Sheru.BTech_V0.Controllers;

import com.Sheru.BTech_V0.Entities.Feed;
import com.Sheru.BTech_V0.Entities.Video_CSE;
import com.Sheru.BTech_V0.Entities.Video_ECE;
import com.Sheru.BTech_V0.Repositories.MongoDB_CSE;
import com.Sheru.BTech_V0.Repositories.MongoDB_ECE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class API_Controller {

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping("/data/feedback_form")
    public void getuserfeedback(@RequestBody Feed feed){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rahuleblm@gmail.com");
        message.setTo("rahuleblm@gmail.com");
        message.setText("Feedback From: "+feed.getName()+"\nemail: "+feed.getEmail()+"\nRating: "+feed.getRating()
        +"Comments: "+feed.getComments());
        message.setSubject("New Feedback from: " + feed.getName());

        javaMailSender.send(message);
    }

    @Autowired
    MongoDB_CSE repo_cse;
    @Autowired
    MongoDB_ECE repo_ece;

//    CSE

    @PostMapping("/v0/data/CSE")
    public ResponseEntity<?> SendDataToRepo_CSE(@RequestBody Video_CSE videoCSE){
        videoCSE.setAllowed(true);
        Video_CSE save = repo_cse.save(videoCSE);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/v0/data/CSE")
    public List<Video_CSE> getdatafromrepo_CSE(){
        List<Video_CSE> list = repo_cse.findAll();
        List<Video_CSE> getlist = new ArrayList<>();
        for(int i = 0;i< list.size();i++){
            if(list.get(i).getAllowed() == true){
                getlist.add(list.get(i));
            }
        }
        return getlist;
    }

//    ECE

    @PostMapping("/v0/data/ECE")
    public ResponseEntity<?> SendDataToRepo_ECE(@RequestBody Video_ECE videoCSE){
        videoCSE.setAllowed(true);
        Video_ECE save = repo_ece.save(videoCSE);
        return ResponseEntity.ok(save);
    }
    @GetMapping("/v0/data/ECE")
    public List<Video_ECE> getdatafromrepo_ECE(){
        List<Video_ECE> list = repo_ece.findAll();
        List<Video_ECE> getlist = new ArrayList<>();
        for(int i = 0;i< list.size();i++){
            if(list.get(i).getAllowed() == true){
                getlist.add(list.get(i));
            }
        }
        return getlist;
    }



}
