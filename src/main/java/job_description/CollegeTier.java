package job_description;

public class CollegeTier {

    CollegeTierEnum collegeTierEnum;
    int weight;

    public CollegeTier() {
    }

    public CollegeTier(CollegeTierEnum collegeTierEnum, int weight) {
        this.collegeTierEnum = collegeTierEnum;
        this.weight = weight;
    }

    public CollegeTierEnum getCollegeTierEnum() {
        return collegeTierEnum;
    }

    public void setCollegeTierEnum(CollegeTierEnum collegeTierEnum) {
        this.collegeTierEnum = collegeTierEnum;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + collegeTierEnum +
                ":" + weight +
                "]";
    }
}
