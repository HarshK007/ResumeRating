package job_description;

import java.util.List;

public class JobDescription {
    String jobTitle;
    List<Qualification> qualifications;
    List<SkillRequired> skillRequireds;
    List<LocationRequired> locationRequireds;

    //experiences will be in months
    int minWorkExperience;
    int maxWorkExperience;

    List<CollegeTier> collegeTiers;
    List<CompanyTier> companyTiers;
    List<CompanyType> companyTypes;

    int locationWeight;
    int workExperienceWeight;
    int minQualificationWeight;
    int skillRequiredWeight;
    int collegeWeight;
    int companyWeight;

    //=======
    int companyTierWeight;
    int companyTypeWeight;
    int collegeTierWeight;
    int courseTypeWeight;


    public JobDescription() {
    }

    public JobDescription(String jobTitle, List<Qualification> qualifications, List<SkillRequired> skillRequireds, List<LocationRequired> locationRequireds, int minWorkExperience, int maxWorkExperience, List<CollegeTier> collegeTiers, List<CompanyTier> companyTiers, List<CompanyType> companyTypes, int locationWeight, int workExperienceWeight, int minQualificationWeight, int skillRequiredWeight, int collegeWeight, int companyWeight, int companyTierWeight, int companyTypeWeight, int collegeTierWeight, int courseTypeWeight) {
        this.jobTitle = jobTitle;
        this.qualifications = qualifications;
        this.skillRequireds = skillRequireds;
        this.locationRequireds = locationRequireds;
        this.minWorkExperience = minWorkExperience;
        this.maxWorkExperience = maxWorkExperience;
        this.collegeTiers = collegeTiers;
        this.companyTiers = companyTiers;
        this.companyTypes = companyTypes;
        this.locationWeight = locationWeight;
        this.workExperienceWeight = workExperienceWeight;
        this.minQualificationWeight = minQualificationWeight;
        this.skillRequiredWeight = skillRequiredWeight;
        this.collegeWeight = collegeWeight;
        this.companyWeight = companyWeight;
        this.companyTierWeight = companyTierWeight;
        this.companyTypeWeight = companyTypeWeight;
        this.collegeTierWeight = collegeTierWeight;
        this.courseTypeWeight = courseTypeWeight;
    }


    public int getCollegeTierWeight() {
        return collegeTierWeight;
    }

    public void setCollegeTierWeight(int collegeTierWeight) {
        this.collegeTierWeight = collegeTierWeight;
    }

    public int getCourseTypeWeight() {
        return courseTypeWeight;
    }

    public void setCourseTypeWeight(int courseTypeWeight) {
        this.courseTypeWeight = courseTypeWeight;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<SkillRequired> getSkillRequireds() {
        return skillRequireds;
    }

    public void setSkillRequireds(List<SkillRequired> skillRequireds) {
        this.skillRequireds = skillRequireds;
    }

    public List<LocationRequired> getLocationRequireds() {
        return locationRequireds;
    }

    public void setLocationRequireds(List<LocationRequired> locationRequireds) {
        this.locationRequireds = locationRequireds;
    }

    public int getMinWorkExperience() {
        return minWorkExperience;
    }

    public void setMinWorkExperience(int minWorkExperience) {
        this.minWorkExperience = minWorkExperience;
    }

    public int getMaxWorkExperience() {
        return maxWorkExperience;
    }

    public void setMaxWorkExperience(int maxWorkExperience) {
        this.maxWorkExperience = maxWorkExperience;
    }

    public List<CollegeTier> getCollegeTiers() {
        return collegeTiers;
    }

    public void setCollegeTiers(List<CollegeTier> collegeTiers) {
        this.collegeTiers = collegeTiers;
    }

    public List<CompanyTier> getCompanyTiers() {
        return companyTiers;
    }

    public void setCompanyTiers(List<CompanyTier> companyTiers) {
        this.companyTiers = companyTiers;
    }

    public List<CompanyType> getCompanyTypes() {
        return companyTypes;
    }

    public void setCompanyTypes(List<CompanyType> companyTypes) {
        this.companyTypes = companyTypes;
    }

    public int getLocationWeight() {
        return locationWeight;
    }

    public void setLocationWeight(int locationWeight) {
        this.locationWeight = locationWeight;
    }

    public int getWorkExperienceWeight() {
        return workExperienceWeight;
    }

    public void setWorkExperienceWeight(int workExperienceWeight) {
        this.workExperienceWeight = workExperienceWeight;
    }

    public int getMinQualificationWeight() {
        return minQualificationWeight;
    }

    public void setMinQualificationWeight(int minQualificationWeight) {
        this.minQualificationWeight = minQualificationWeight;
    }

    public int getSkillRequiredWeight() {
        return skillRequiredWeight;
    }

    public void setSkillRequiredWeight(int skillRequiredWeight) {
        this.skillRequiredWeight = skillRequiredWeight;
    }

    public int getCollegeWeight() {
        return collegeWeight;
    }

    public void setCollegeWeight(int collegeWeight) {
        this.collegeWeight = collegeWeight;
    }

    public int getCompanyWeight() {
        return companyWeight;
    }

    public void setCompanyWeight(int companyWeight) {
        this.companyWeight = companyWeight;
    }

    public int getCompanyTierWeight() {
        return companyTierWeight;
    }

    public void setCompanyTierWeight(int companyTierWeight) {
        this.companyTierWeight = companyTierWeight;
    }

    public int getCompanyTypeWeight() {
        return companyTypeWeight;
    }

    public void setCompanyTypeWeight(int companyTypeWeight) {
        this.companyTypeWeight = companyTypeWeight;
    }
}
