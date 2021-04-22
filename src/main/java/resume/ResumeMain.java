package resume;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ResumeMain {

    ResumeMain(){

    }


    public static List<Resume> createResume() throws FileNotFoundException {
        List<Resume> resumeArrayList = new ArrayList<>();


        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(new FileReader("D:\\Accolite\\Daily Work\\27-01-2021 RealTimeWebDevlopmement\\ResumeParser\\src\\main\\java\\assert\\ResumeDetail.json"));

        if (rootNode.isJsonObject()){
            JsonObject details = rootNode.getAsJsonObject();

            for(int i=1;i<=details.size();i++){
                JsonElement record = details.get(i+"");
                JsonObject detail = record.getAsJsonObject();
                String singledetail = detail.toString();
                Resume resume = gson.fromJson(singledetail, Resume.class);
                resumeArrayList.add(resume);
            }
        }

        return resumeArrayList;
    }
}
