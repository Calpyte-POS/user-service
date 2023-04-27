package com.calpyte.user.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class Mapper  {


   public Mapper(){

   }


   public static <T> T map(Object object, Class<T> clazz) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         Gson gson = new GsonBuilder().create();
         String json = mapper.writeValueAsString(object);
         return gson.fromJson(json, clazz);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public static <T> List<T> mapList(Object object, List<T> type) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(object);

         Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
         type = gson.fromJson(json, new TypeToken<List<T>>() {
         }.getType());
         return type;

      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }



}
