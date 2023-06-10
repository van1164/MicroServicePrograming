package com.example.microassignment.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost")
@Controller
@RequestMapping("/")
public class AssignmentController {
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("write")
    public String write(){
        return "write";
    }

    @GetMapping("show")
    @ResponseBody
    public POST write(String id){
        Criteria criteria = new Criteria("id");
        criteria.is(id);
        Query query = new Query(criteria);
      return mongoTemplate.findOne(query,POST.class);
    }
    @GetMapping("")
    @ResponseBody
    public List<POST> home(){
        List<POST> temp =mongoTemplate.findAll(POST.class);
        for(POST t: temp){
            System.out.println("model = " + t);
        }
        return temp;
    }
    @PostMapping("/save")
    public String save(@RequestPart String userName,
                       @RequestPart String password,
                       @RequestPart String title,
                       @RequestPart String content){
        System.out.println("sssssssssssssssssss");
        POST post = new POST(userName,password,title,content);
        mongoTemplate.insert(post);
        return "redirect:/";
    }
}
