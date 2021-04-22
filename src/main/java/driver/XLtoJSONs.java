package driver;

import com.google.gson.Gson;
import job_description.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLtoJSONs {

    XLtoJSONs(){

    }

    public static List<String> xLsToJson() throws IOException {

        final String filePath = "D:\\Accolite\\Daily Work\\27-01-2021 RealTimeWebDevlopmement\\ResumeParser\\src\\main\\java\\assert\\JD_sample.xls";

        FileInputStream fis=new FileInputStream(new File(filePath));

        HSSFWorkbook wb=new HSSFWorkbook(fis);

        HSSFSheet sheet=wb.getSheetAt(0);

        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();

        ArrayList<String> rowList = new ArrayList<>();
        ArrayList<ArrayList<String>> jds = new ArrayList<>();

        for(int i=0;i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            ArrayList<String> valueList = new ArrayList<>();
            for(Cell cell:row){
                if (i==0){
                    rowList.add(cell.getStringCellValue());
                }else {
                    if (formulaEvaluator.evaluateInCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC){
                        valueList.add(cell.getNumericCellValue() + "");
                    }else{
                        valueList.add(cell.getStringCellValue());
                    }
                }
            }
            if (i!=0){
                jds.add(valueList);
            }

        }

        List<String> jobDescriptionList = new ArrayList<>();
        for (ArrayList<String> valueList: jds) {
            JobDescription jobDescription = new JobDescription();
            for (int i = 0; i < rowList.size(); i++) {
                String rowEle = rowList.get(i);
                String value = valueList.get(i);
                if (rowEle.equals("jobTitle")) {
                    jobDescription.setJobTitle(value);
                } else if (rowEle.equals("minWorkExperience")) {
                    jobDescription.setMinWorkExperience((int) Float.parseFloat(value));
                } else if (rowEle.equals("maxWorkExperience")) {
                    jobDescription.setMaxWorkExperience((int) Float.parseFloat(value));
                } else if (rowEle.equals("locations")) {
                    List<LocationRequired> locationRequireds = new ArrayList<>();
                    String[] loc = value.split(", ");
                    for(String locations : loc){
                        String[] loc1 = locations.split(":");
                        locationRequireds.add(new LocationRequired(loc1[0],Integer.parseInt(loc1[1])));
                    }
                    jobDescription.setLocationRequireds(locationRequireds);
                } else if (rowEle.equals("qualifications")) {
                    String[] qual = value.split(",");
                    List<Qualification> qualifications = new ArrayList<>();
                    for (String q : qual) {
                        String[] q1 = q.split(":");
                        String type = q1[1];
                        if (type.equals("FULL_TIME")) {
                            qualifications.add(new Qualification(q1[0], new CourseType(CourseTypeEnum.FULL_TIME,Integer.parseInt(q1[2]))));
                        } else if (type.equals("PART_TIME")) {
                            qualifications.add(new Qualification(q1[0], new CourseType(CourseTypeEnum.PART_TIME,Integer.parseInt(q1[2]))));
                        } else {
                            qualifications.add(new Qualification(q1[0], new CourseType(CourseTypeEnum.DISTANCE_LEARNING,Integer.parseInt(q1[2]))));
                        }
                    }
                    jobDescription.setQualifications(qualifications);
                } else if (rowEle.equals("collegeTiers")) {
                    String[] tiers = value.split(", ");
                    List<CollegeTier> tierList = new ArrayList<>();
                    for (String tier : tiers) {
                        String[] t1 = tier.split(":");
                        if (t1[0].equals("TIER1")) {
                            tierList.add(new CollegeTier(CollegeTierEnum.TIER1,Integer.parseInt(t1[1])));
                        } else if (t1[0].equals("TIER2")) {
                            tierList.add(new CollegeTier(CollegeTierEnum.TIER2,Integer.parseInt(t1[1])));
                        } else if (t1[0].equals("TIER3")) {
                            tierList.add(new CollegeTier(CollegeTierEnum.TIER3,Integer.parseInt(t1[1])));
                        }
                    }
                    jobDescription.setCollegeTiers(tierList);

                } else if (rowEle.equals("companyTiers")) {
                    String[] tiers = value.split(", ");
                    List<CompanyTier> tierList = new ArrayList<>();
                    for (String tier : tiers) {
                        String[] t1 = tier.split(":");
                        if (t1[0].equals("TIER1")) {
                            tierList.add(new CompanyTier(CompanyTierEnum.TIER1,Integer.parseInt(t1[1])));
                        } else if (t1[0].equals("TIER2")) {
                            tierList.add(new CompanyTier(CompanyTierEnum.TIER2,Integer.parseInt(t1[1])));
                        }
                    }
                    jobDescription.setCompanyTiers(tierList);

                } else if (rowEle.equals("companyTypes")) {
                    String[] types = value.split(", ");
                    List<CompanyType> typeList = new ArrayList<>();
                    for (String tier : types) {
                        String[] t1 = tier.split(":");
                        if (t1[0].equals("PRODUCT_BASED")) {
                            typeList.add(new CompanyType(CompanyTypeEnum.PRODUCT_BASED,Integer.parseInt(t1[1])));
                        } else if (t1[0].equals("SERVICE_BASED")) {
                            typeList.add(new CompanyType(CompanyTypeEnum.SERVICE_BASED,Integer.parseInt(t1[1])));
                        }
                    }
                    jobDescription.setCompanyTypes(typeList);
                } else if (rowEle.equals("locationWeight")){
                    jobDescription.setLocationWeight((int) Float.parseFloat(value));

                } else if (rowEle.equals("workExperienceWeight")){
                    jobDescription.setWorkExperienceWeight((int) Float.parseFloat(value));

                } else if (rowEle.equals("minQualificationWeight")){
                    jobDescription.setMinQualificationWeight((int) Float.parseFloat(value));
                } else if (rowEle.equals("skillRequiredWeight")){
                    jobDescription.setSkillRequiredWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("collegeWeight")){
                    jobDescription.setCollegeWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("companyWeight")){
                    jobDescription.setCompanyWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("companyTierWeight")){
                    jobDescription.setCompanyTierWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("companyTypeWeight")){
                    jobDescription.setCompanyTypeWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("collegeTierWeight")){
                    jobDescription.setCollegeTierWeight((int) Float.parseFloat(value));
                }else if (rowEle.equals("courseTypeWeight")){
                    jobDescription.setCourseTypeWeight((int) Float.parseFloat(value));
                }
            }

            String[] mainSkills = valueList.get(8).split(", ");
            String[] subSkills = valueList.get(9).split(",");

            List<SkillRequired> skillRequiredList = new ArrayList<>();

            for (int i = 0; i < mainSkills.length; i++) {

                String skill = mainSkills[i];
                String[] skill1 = skill.split(":");


                String[] subskill = subSkills[i].split(";");


                List<SubSkill> subSkillList = new ArrayList<>();

                for (String sub : subskill) {
                    String[] ssk = sub.split(":");
                    String sk1 = ssk[0].replace("[", "").replace("]", "");
                    String sk2 = ssk[1].replace("[", "").replace("]", "");
                    SubSkill subSkill = new SubSkill(sk1, Integer.parseInt(sk2));
                    subSkillList.add(subSkill);
                }
                skillRequiredList.add(new SkillRequired(skill1[0], Integer.parseInt(skill1[1]), subSkillList));
            }
            jobDescription.setSkillRequireds(skillRequiredList);
            jobDescriptionList.add(new Gson().toJson(jobDescription));
        }

        return jobDescriptionList;
    }
}
