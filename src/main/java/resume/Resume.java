package resume;

import java.util.List;

public class Resume {
    Name name;
    List<Education> educations;
    List<College> colleges;
    List<Company> companies;
    List<Skill> skills;
    List<Location> locations;
    int totalWorkExperience;
    String email;

    public Resume() {
    }

    public Resume(Name name, List<Education> educations, List<College> colleges, List<Company> companies, List<Skill> skills, List<Location> locations, int totalWorkExperience, String email) {
        this.name = name;
        this.educations = educations;
        this.colleges = colleges;
        this.companies = companies;
        this.skills = skills;
        this.locations = locations;
        this.totalWorkExperience = totalWorkExperience;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getTotalWorkExperience() {
        return totalWorkExperience;
    }

    public void setTotalWorkExperience(int totalWorkExperience) {
        this.totalWorkExperience = totalWorkExperience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
