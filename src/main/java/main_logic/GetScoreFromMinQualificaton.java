package main_logic;

import job_description.CourseTypeEnum;
import job_description.JobDescription;
import job_description.Qualification;
import resume.Education;
import resume.Resume;

import java.util.HashMap;
import java.util.Map;

public class GetScoreFromMinQualificaton {

    GetScoreFromMinQualificaton(){

    }

    public static double getScoreFromMinQualification(Resume resume, JobDescription jobDescription) {
        boolean isFullTimeMatched = false;
        boolean isPartTimeMatched = false;
        boolean isDistanceLearningMatched = false;
        double score = 0.0;
        Map<String, Qualification> jdQualificationsMap = new HashMap<>();
        for(Qualification qualification: jobDescription.getQualifications()){
            jdQualificationsMap.put(qualification.getCourseName(), qualification);
        }

        for(Education education: resume.getEducations()) {
            if(jdQualificationsMap.containsKey(education.getCourseName()) && education.getCourseType().equals(jdQualificationsMap.get(education.getCourseName()).getCourseType().getCourseTypeEnum()) ) {
                    if(!isFullTimeMatched && education.getCourseType().equals(CourseTypeEnum.FULL_TIME)){
                        score = score + jdQualificationsMap.get(education.getCourseName()).getCourseType().getWeight();
                        isFullTimeMatched = true;
                    }
                    else if(!isPartTimeMatched && education.getCourseType().equals(CourseTypeEnum.PART_TIME)){
                        score = score + jdQualificationsMap.get(education.getCourseName()).getCourseType().getWeight();
                        isPartTimeMatched = true;
                    }
                    else if(!isDistanceLearningMatched && education.getCourseType().equals(CourseTypeEnum.DISTANCE_LEARNING)){
                        score = score + jdQualificationsMap.get(education.getCourseName()).getCourseType().getWeight();
                        isDistanceLearningMatched = true;
                    }
            }
        }
        return (score / jobDescription.getCourseTypeWeight());
    }

}
