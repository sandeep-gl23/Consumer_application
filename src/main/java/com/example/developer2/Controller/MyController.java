package com.example.developer2.Controller;

import com.example.developer2.Entity.Field;
import com.example.developer2.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fields")
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping()
    public ResponseEntity<List<Field>> getFields()
    {
        return myService.getFields();
    }

}
