package main_logic;

import job_description.JobDescription;
import job_description.JobDescriptionMain;
import meta_data.CollegeMapper;
import meta_data.CompanyMapper;
import meta_data.MapperMain;
import resume.Resume;
import resume.ResumeMain;


import java.io.IOException;
import java.util.*;

public class Main {
    static final List<CompanyMapper> companyMapperArrayList = MapperMain.createCompanyMapper();
    static final List<CollegeMapper> collegeMapperArrayList = MapperMain.createCollegeMapper();

    public static void main(String[] args) throws IOException {

        List<Resume> resumeArrayList = ResumeMain.createResume();
        List<JobDescription> jobDescriptionArrayList = JobDescriptionMain.createJobDescription();
        List<List<Score>> finalscoreArrayList = getResumeScore(resumeArrayList, jobDescriptionArrayList);

        new WriteInCSV().writeCSV(finalscoreArrayList,jobDescriptionArrayList);

    }

    public static List<List<Score>> getResumeScore(List<Resume> resumeArrayList, List<JobDescription> jobDescriptionArrayList) {
        List<List<Score>> finalScore = new ArrayList<>();

        for(JobDescription jobDescription: jobDescriptionArrayList){
            List<Score> scoreList = new ArrayList<>();
            for(Resume resume: resumeArrayList) {
                Score score = new Score();
                score.setName(resume.getName().getFname());
                score.setJobTitle(jobDescription.getJobTitle());
                score.setEducations(resume.getEducations());
                score.setColleges(resume.getColleges());
                score.setCompanies(resume.getCompanies());
                score.setSkills(resume.getSkills());
                score.setLocations(resume.getLocations());
                score.setTotalWorkExperience(resume.getTotalWorkExperience());
                score.setEmail(resume.getEmail());

                double calculateScore =
                        (GetScoreFromMinQualificaton.getScoreFromMinQualification(resume, jobDescription) * jobDescription.getMinQualificationWeight()) +
                        (GetScoreFromSkillAndWeightage.getScoreFromSkillAndWeightage(resume, jobDescription) * jobDescription.getSkillRequiredWeight()) +
                        (GetScoreFromLocation.getScoreFromLocation(resume, jobDescription) * jobDescription.getLocationWeight()) +
                        (GetScoreFromWorkExperience.getScoreFromWorkExperience(resume, jobDescription) * jobDescription.getWorkExperienceWeight()) +
                        (GetScoreFromCollege.getScoreFromCollege(resume, jobDescription) * jobDescription.getCollegeWeight()) +
                        (GetScoreFromCompany.getScoreFromCompany(resume, jobDescription) * jobDescription.getCompanyWeight());
                score.setObtainedScore(calculateScore);
                scoreList.add(score);
            }
            finalScore.add(scoreList);
        }
        return finalScore;
    }












}
