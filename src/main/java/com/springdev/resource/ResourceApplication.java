package com.springdev.resource;

import com.springdev.resource.service.CountWords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Map;

@SpringBootApplication
public class ResourceApplication implements CommandLineRunner {

//    @Value("classpath:sample.txt")
//    private Resource resource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CountWords countWords;

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:sample.txt");
        Map<String, Integer> words = countWords.getWordsCount(resource);

        for (String key: words.keySet()){
            System.out.println(key + ": " + words.get(key));
        }
    }
}
