package resume;

import job_description.CourseTypeEnum;

public class Education {
    String courseName;
    CourseTypeEnum courseTypeEnum;

    public Education() {
    }

    public Education(String courseName, CourseTypeEnum courseType) {
        this.courseName = courseName;
        this.courseTypeEnum = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseTypeEnum getCourseType() {
        return courseTypeEnum;
    }

    public void setCourseType(CourseTypeEnum courseType) {
        this.courseTypeEnum = courseType;
    }

    @Override
    public String toString() {
        return courseName  +
                ", "+courseTypeEnum;
    }
}

