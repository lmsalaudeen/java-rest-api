package com.cbfacademy.apiassessment.blog;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONHandlerWithGSON {
    public static List<Blog> readFile (String fileName) {
        // Gson gson = new GsonBuilder()
        //     .excludeFieldsWithoutExposeAnnotation()
        //     .create();
        Gson gson = new Gson();
        List<Blog> blogs = new ArrayList<>();
        try (Reader reader = new FileReader(fileName)){
            blogs = Arrays.asList(gson.fromJson(reader, Blog[].class));
            // employees.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return blogs;     
    }

    public static void save(List<Blog> blogs, String outputFile) {
       
        try {
             // create a writer
            // FileWriter writer = new FileWriter((outputFile)); 
            // BufferedWriter bw = new BufferedWriter(writer);

            Writer writer = Files.newBufferedWriter(Paths.get(outputFile));
            // convert employee object to JSON string, and write to file
            Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();
            gson.toJson(blogs, writer); 
            // close writer
            // bw.close();
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }   
    }
}
