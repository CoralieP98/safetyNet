package safetyNet.safetyNet.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.stereotype.Component;
import com.jsoniter.JsonIterator;
import com.jsoniter.ValueType;
import org.junit.Test;
import safetyNet.safetyNet.model.Data;
import safetyNet.safetyNet.model.Person;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.*;

@Component
public class DataHandler {

    private final Data data;

    public DataHandler() {
//        this.data = data;
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            this.data = objectMapper.readValue(new File("src/main/resources/data.json"), Data.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Data getData(){
        return data;
    }









//    public void parseData()throws Exception{
//
//        Person person= new Person();
//
//        Object ob=new JSONParser().parse(new FileReader("C:\\Users\\Admin DEV\\IdeaProjects\\safetyNet\\src\\main\\resources\\meh.json"));
//
//        JSONObject js =(JSONObject) ob;
//
//        JSONArray array= new JSONArray(js.getString("persons"));
//
//
////        person.setFirstName((String)js.get("firstName"));
////        person.setLastName((String)js.get("lastName"));
////        person.setAddress((String)js.get("address"));
////        person.setCity((String)js.get("city"));
////        person.setZip((String)js.get("zip"));
////        person.setPhone((String)js.get("phone"));
////        person.setEmail((String)js.get("email"));
//
//
//    }


//    public void parseData()throws Exception{
//        Person person=new Person();
////        String input="{ \"firstName\":\"John\", \"lastName\":\"Boyd\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }";
//
//        JsonIterator iterator= JsonIterator.parse(String.valueOf(new FileReader("C:\\Users\\Admin DEV\\IdeaProjects\\safetyNet\\src\\main\\resources\\data.json")));
////        JsonIterator iterator= JsonIterator.parse(input);
//        JsonIterator ji = (JSONObject) iterator;
//
//        for (String field= iterator.readObject();field!=null;field= iterator.readObject()){
//            switch (field){
//                case "firstName":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setFirstName(iterator.readString());
//                    }
//                    continue;
//                case "lastName":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setLastName(iterator.readString());
//                    }
//                    continue;
//                case "address":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setAddress(iterator.readString());
//                    }
//                    continue;
//                case "city":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setCity(iterator.readString());
//                    }
//                    continue;
//                case "zip":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setZip(iterator.readString());
//                    }
//                    continue;
//                case "phone":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setPhone(iterator.readString());
//                    }
//                    continue;
//                case "email":
//                    if (iterator.whatIsNext()== ValueType.STRING){
//                        person.setEmail(iterator.readString());
//                    }
//                    continue;
//                default:
//                    iterator.skip();
//            }
//        }
//    }
}
