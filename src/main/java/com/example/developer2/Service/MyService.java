package com.example.developer2.Service;

import com.example.developer1.Entity.Info;
import com.example.developer2.Config.AppConstants;
import com.example.developer2.Entity.Field;
import com.example.developer2.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    MyRepository myRepository;

    public ResponseEntity<List<Field>> getFields() {
        List<Field> allFields=myRepository.findAll();
        return new ResponseEntity<>(allFields, HttpStatus.OK);
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME,groupId = "group-2")
    public void changeField(Info info)  {
         Double version=info.getVersion();
         String code=info.getCode();

         Optional<Field> field=myRepository.findByCodeAndVersion(code,version);

         Field updatedField=field.get();

        updatedField.setStatus(true);
        myRepository.save(updatedField);

        System.out.println(info.toString());

    }



}
