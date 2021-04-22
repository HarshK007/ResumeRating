package job_description;

public class CourseType {

    CourseTypeEnum courseTypeEnum;
    int weight = 0;

    public CourseType(CourseTypeEnum courseTypeEnum, int weight) {
        this.courseTypeEnum = courseTypeEnum;
        this.weight = weight;
    }

    public CourseType() {
    }

    public CourseTypeEnum getCourseTypeEnum() {
        return courseTypeEnum;
    }

    public void setCourseTypeEnum(CourseTypeEnum courseTypeEnum) {
        this.courseTypeEnum = courseTypeEnum;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + courseTypeEnum +
                ":" + weight +
                ']';
    }
}
