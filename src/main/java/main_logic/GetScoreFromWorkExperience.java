package main_logic;

import job_description.JobDescription;
import resume.Resume;

public class GetScoreFromWorkExperience {

    GetScoreFromWorkExperience(){

    }

    public static double getScoreFromWorkExperience (Resume resume, JobDescription jobDescription) {
        double score = 0;
        if (resume.getTotalWorkExperience() >= jobDescription.getMinWorkExperience()
                && resume.getTotalWorkExperience() < jobDescription.getMaxWorkExperience()){
            score = (double) ( resume.getTotalWorkExperience() - jobDescription.getMinWorkExperience() ) / (jobDescription.getMaxWorkExperience() - jobDescription.getMinWorkExperience()) ;
        }
        return score;
    }
}
