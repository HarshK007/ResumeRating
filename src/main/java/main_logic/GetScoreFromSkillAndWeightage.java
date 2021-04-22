package main_logic;

import job_description.JobDescription;
import job_description.SkillRequired;
import job_description.SubSkill;
import resume.Resume;
import resume.Skill;

import java.util.HashMap;
import java.util.Map;

public class GetScoreFromSkillAndWeightage {

    GetScoreFromSkillAndWeightage(){

    }

    public static double getScoreFromSkillAndWeightage(Resume resume, JobDescription jobDescription) {

        double obtainedScore = 0;
        double totalScore = 0;
        Map<String, Skill> resumeSkillMap = new HashMap<>();
        for (Skill skill: resume.getSkills()) {
            resumeSkillMap.put(skill.getName(), skill);
        }

        for (SkillRequired skillRequired: jobDescription.getSkillRequireds()) {
            for (SubSkill subSkill: skillRequired.getSubSkills()){
                if (resumeSkillMap.containsKey(subSkill.getName())){
                    obtainedScore = obtainedScore + subSkill.getWeight();
                }
            }
            totalScore = totalScore + skillRequired.getWeight();
        }
        if (totalScore == 0){
            return 0;
        }
        return (obtainedScore/totalScore);
    }
}
