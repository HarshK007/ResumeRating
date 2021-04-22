package job_description;

public class Qualification {
    String courseName;
    CourseType courseType;

    public Qualification() {
    }

    public Qualification(String courseName, CourseType courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "["+ courseName  +
                ", " + courseType +
                ']';
    }
}
