package main_logic;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opencsv.CSVWriter;
import job_description.JobDescription;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteInCSV {

    public WriteInCSV(){
        // Do nothing.
    }

    public void writeCSV(List<List<Score>> finalscoreArrayList, List<JobDescription> jobDescriptionArrayList) throws IOException {

        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(new FileReader("D:\\Accolite\\Daily Work\\27-01-2021 RealTimeWebDevlopmement\\ResumeParser\\src\\main\\java\\assert\\ResumeDetail.json"));
        JsonObject details = rootNode.getAsJsonObject();


        int count = 0;
        for (List<Score> scoreArrayList : finalscoreArrayList) {

            JobDescription jobDescription = jobDescriptionArrayList.get(count);

            String jdTitle = jobDescription.getJobTitle().replace(" ", "-");

            String filePath = "D:\\Accolite\\Daily Work\\27-01-2021 RealTimeWebDevlopmement\\ResumeParser\\src\\main\\java\\assert\\" + jdTitle + ".csv";

            File file = new File(filePath);
            FileWriter outputfile = new FileWriter(file);
            // create CSVWriter object fileWriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);


            String[] data2 = {"Job Title :", jobDescription.getJobTitle()};
            writer.writeNext(data2);
            writer.writeNext(new String[]{""});
            writer.writeNext(new String[]{"Qualifications Required :", jobDescription.getQualifications().toString()});
            writer.writeNext(new String[]{"Skills Required :", jobDescription.getSkillRequireds().toString()});
            writer.writeNext(new String[]{"Location Preferred :", jobDescription.getLocationRequireds().toString()});
            writer.writeNext(new String[]{"Total Work Experience Required :", jobDescription.getMinWorkExperience() + "-" + jobDescription.getMaxWorkExperience() + " Years"});
            writer.writeNext(new String[]{""});
            writer.writeNext(new String[]{"College Tiers Preferred :", jobDescription.getCollegeTiers().toString()});
            writer.writeNext(new String[]{"Company Tiers Preferred :", jobDescription.getCompanyTiers().toString()});
            writer.writeNext(new String[]{"Company Types Preferred :", jobDescription.getCompanyTypes().toString()});
            writer.writeNext(new String[]{"", "#===================================================================================================================="});
            writer.writeNext(new String[]{" ", "", "Location", "Work Experience", "Min Qualification", "Skills Required", "College", "Company", "Company Tier Weight", "Company Type Weight", "College Tier Weight", "Course Type Weight"});
            writer.writeNext(new String[]{" ", "", jobDescription.getLocationWeight() + "",
                    jobDescription.getWorkExperienceWeight() + "",
                    jobDescription.getMinQualificationWeight() + "",
                    jobDescription.getSkillRequiredWeight() + "",
                    jobDescription.getCollegeWeight() + "",
                    jobDescription.getCompanyWeight() + "",
                    jobDescription.getCompanyTierWeight() + "",
                    jobDescription.getCompanyTypeWeight() + "",
                    jobDescription.getCollegeTierWeight() + "",
                    jobDescription.getCourseTypeWeight() + ""
            });

            writer.writeNext(new String[]{"", "#===================================================================================================================="});
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"", "S no.", "Name", "Job Title", "Educations", "Colleges", "Companies", "Skills", "Locations", "Total Experience", "Email Id", "Scores", "Resume JSON"});
            int tempCount = 1;
            for (Score score : scoreArrayList) {
                //============================================
                JsonElement record = details.get(tempCount + "");
                JsonObject detail = record.getAsJsonObject();
                String singledetail = detail.toString();
                //===========================================
                data.add(new String[]{" ", (tempCount++) + "", score.getName(), score.getJobTitle(), score.getEducations().toString(),
                        score.getColleges().toString(),
                        score.getCompanies().toString(),
                        score.getSkills().toString(),
                        score.getLocations().toString(),
                        score.getTotalWorkExperience() + "",
                        score.getEmail(),
                        score.getObtainedScore() + "",
                        singledetail
                });
            }


            // create FileWriter object with file as parameter
            writer.writeAll(data);
            // closing writer connection
            writer.close();

            count++;
        }
    }
}
