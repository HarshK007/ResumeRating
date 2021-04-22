package meta_data;

import job_description.CollegeTierEnum;

public class CollegeMapper {
    String name;
    CollegeTierEnum collegeTierEnum;

    public CollegeMapper() {
    }

    public CollegeMapper(String name, CollegeTierEnum collegeTierEnum) {
        this.name = name;
        this.collegeTierEnum = collegeTierEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollegeTierEnum getCollegeTier() {
        return collegeTierEnum;
    }

    public void setCollegeTier(CollegeTierEnum collegeTierEnum) {
        this.collegeTierEnum = collegeTierEnum;
    }
}
