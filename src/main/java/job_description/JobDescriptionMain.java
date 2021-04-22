package job_description;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import driver.XLtoJSONs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobDescriptionMain {

    JobDescriptionMain(){

    }


    public static List<JobDescription> createJobDescription() throws IOException {
        List<JobDescription> jobDescriptionArrayList = new ArrayList<>();

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        List<String> jdList = XLtoJSONs.xLsToJson();
        for(String currentjd: jdList){
            JsonElement rootNode = parser.parse(currentjd);

            if (rootNode.isJsonObject()){
                JsonObject details = rootNode.getAsJsonObject();
                String singledetail = details.toString();
                JobDescription jd = gson.fromJson(singledetail, JobDescription.class);
                jobDescriptionArrayList.add(jd);

            }
        }

        return jobDescriptionArrayList;
    }
}
