package main_logic;

import job_description.CollegeTier;
import job_description.CollegeTierEnum;
import job_description.JobDescription;
import meta_data.CollegeMapper;
import resume.College;
import resume.Resume;

import java.util.HashMap;
import java.util.Map;

public class GetScoreFromCollege {

    GetScoreFromCollege(){

    }

    public static double getScoreFromCollege (Resume resume, JobDescription jobDescription) {



        int tier1 = 0;
        int tier2 = 0;
        int tier3 = 0;
        double score = 0;
        Map<String, CollegeMapper> mapperCollegeMap = new HashMap<>();
        for (CollegeMapper collegeMapper: Main.collegeMapperArrayList) {
            mapperCollegeMap.put(collegeMapper.getName(), collegeMapper);
        }

        for (College college: resume.getColleges()){
            if(mapperCollegeMap.containsKey(college.getName())){
                for (CollegeTier collegeTier : jobDescription.getCollegeTiers()){
                    if (mapperCollegeMap.get(college.getName()).getCollegeTier().equals(collegeTier.getCollegeTierEnum()) ){
                        if(tier1 != 1 && collegeTier.getCollegeTierEnum().equals(CollegeTierEnum.TIER1)){
                            score = score + collegeTier.getWeight();
                            tier1 = 1;
                        }
                        else if(tier2 != 1 && collegeTier.getCollegeTierEnum().equals(CollegeTierEnum.TIER2)){
                            score = score + collegeTier.getWeight();
                            tier2 = 1;
                        }
                        else if(tier3 != 1 && collegeTier.getCollegeTierEnum().equals(CollegeTierEnum.TIER3)){
                            score = score + collegeTier.getWeight();
                            tier3 = 1;
                        }
                    }
                }
            }
        }
        return (score / jobDescription.getCollegeTierWeight());
    }
}
