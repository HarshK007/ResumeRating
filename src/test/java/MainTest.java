
import job_description.*;
import main_logic.Main;
import main_logic.Score;
import main_logic.WriteInCSV;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import resume.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class MainTest {

    @Before
    public void setUp() {

    }



    @Test
    public void testGetResumeScore_NullCheck(){
        List<List<Score>> result = Main.getResumeScore(new ArrayList<>(), new ArrayList<>());
        ArrayList<ArrayList<Score>> response = new ArrayList<>();

        Assert.assertEquals(result.size(), response.size());
    }

    @Test
    public void testGetResumeScore_SuccessWithEmptyScoreList(){
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJobTitle("SDE");
        ArrayList<JobDescription> jobDescriptionArrayList = new ArrayList<>();
        jobDescriptionArrayList.add(jobDescription);
        List<List<Score>> result = Main.getResumeScore(new ArrayList<>(), jobDescriptionArrayList);
        ArrayList<Score> scoreArrayList = new ArrayList<>();
        ArrayList<ArrayList<Score>> response = new ArrayList<>();
        response.add(scoreArrayList);
        Assert.assertEquals(result,response);
    }

    @Test
    public void testGetResumeScore_Success(){
        JobDescription jobDescription = new JobDescription();
        jobDescription.setJobTitle("SDE");
        jobDescription.setMinQualificationWeight(5);
        jobDescription.setSkillRequiredWeight(2);
        jobDescription.setLocationWeight(3);
        jobDescription.setWorkExperienceWeight(2);
        jobDescription.setCollegeWeight(3);
        jobDescription.setCompanyWeight(2);
        jobDescription.setCourseTypeWeight(5);
        jobDescription.setQualifications(new ArrayList<>());
        jobDescription.setSkillRequireds(new ArrayList<>());
        jobDescription.setLocationRequireds(new ArrayList<>());
        jobDescription.setCollegeTierWeight(2);
        jobDescription.setCompanyTypeWeight(1);
        jobDescription.setCompanyTierWeight(1);

        Resume resume = new Resume();
        resume.setName(new Name());
        resume.setEducations(new ArrayList<Education>());
        resume.setColleges(new ArrayList<>());
        resume.setCompanies(new ArrayList<>());
        resume.setSkills(new ArrayList<>());
        resume.setLocations(new ArrayList<>());
        resume.setTotalWorkExperience(5);
        resume.setEmail("abc@gmail.com");

        ArrayList<Resume> resultArrayList = new ArrayList<>();
        resultArrayList.add(resume);
        ArrayList<JobDescription> jobDescriptionArrayList = new ArrayList<>();
        jobDescriptionArrayList.add(jobDescription);
        List<List<Score>> result = Main.getResumeScore(resultArrayList, jobDescriptionArrayList);

        Assert.assertEquals(0.0, result.get(0).get(0).getObtainedScore(), 0);
    }

    @Test
    public void testComplete() throws IOException {
        ArrayList<JobDescription> jobDescriptionArrayList = new ArrayList<>();
        ArrayList<Resume> resumeArrayList = new ArrayList<>();

        jobDescriptionArrayList.add(
                new JobDescription(
                        "Software Developer Engineer",
                        new ArrayList<>(Arrays.asList(
                                new Qualification("btech",new CourseType(CourseTypeEnum.FULL_TIME,60)),
                                new Qualification("mtech",new CourseType(CourseTypeEnum.PART_TIME,40)))
                        ),
                        new ArrayList<>(Arrays.asList(
                                new SkillRequired("java", 40,
                                        new ArrayList<>(Arrays.asList(
                                                new SubSkill("java", 8),
                                                new SubSkill("spring", 10),
                                                new SubSkill("spring mvc", 12),
                                                new SubSkill("spring boot", 10)
                                            )
                                        )
                                ),
                                new SkillRequired("rdbms", 30,
                                        new ArrayList<>(Arrays.asList(
                                                new SubSkill("rdbms", 5),
                                                new SubSkill("mysql", 10),
                                                new SubSkill("mariadb", 3),
                                                new SubSkill("postgresql", 12)
                                        )
                                        )
                                ),
                                new SkillRequired("nosql", 30,
                                        new ArrayList<>(Arrays.asList(
                                                new SubSkill("nosql", 10),
                                                new SubSkill("redis", 15),
                                                new SubSkill("mongodb", 5)
                                        )
                                        )
                                )
                        )),
                        new ArrayList<>(Arrays.asList(
                                new LocationRequired("delhi",30),
                                new LocationRequired("banglore",70)
                        )),
                        3,
                        5,
                        new ArrayList<>(Arrays.asList(
                                new CollegeTier(CollegeTierEnum.TIER1,50),
                                new CollegeTier(CollegeTierEnum.TIER2,30),
                                new CollegeTier(CollegeTierEnum.TIER3,20)
                        )),
                        new ArrayList<>(Arrays.asList(
                                new CompanyTier(CompanyTierEnum.TIER1,50),
                                new CompanyTier(CompanyTierEnum.TIER2,50)
                        )),
                        new ArrayList<>(Arrays.asList(
                                new CompanyType(CompanyTypeEnum.PRODUCT_BASED,60),
                                new CompanyType(CompanyTypeEnum.SERVICE_BASED,40)
                        )),
                        5,
                        25,
                        10,
                        40,
                        8,
                        12,
                        100,
                        100,
                        100,
                        100

                )
        );

        resumeArrayList.add(
                new Resume(
                        new Name("Harshit", "Kesar"),
                        new ArrayList<>(Arrays.asList(
                                new Education("mca", CourseTypeEnum.FULL_TIME),
                                new Education("bsc", CourseTypeEnum.FULL_TIME))
                        ),
                        new ArrayList<>(Arrays.asList(
                                new College("delhi university"),
                                new College("ip university"))
                        ),
                        new ArrayList<>(Arrays.asList(
                                new Company("microsoft", 2),
                                new Company("tcs", 3))
                        ),
                        new ArrayList<>(Arrays.asList(
                                new Skill("java"),
                                new Skill("couchbase"),
                                new Skill("nosql"),
                                new Skill("mvc"))
                        ),
                        new ArrayList<>(Arrays.asList(
                                new Location("delhi"),
                                new Location("bangalore"))
                        ),
                        4,
                        "harshit.kesar@accolitedigital.com"
                )
        );

        List<List<Score>> result = Main.getResumeScore(resumeArrayList, jobDescriptionArrayList);

        new WriteInCSV().writeCSV(result,jobDescriptionArrayList);

        Assert.assertEquals(31.8, result.get(0).get(0).getObtainedScore(),0);
    }

}
