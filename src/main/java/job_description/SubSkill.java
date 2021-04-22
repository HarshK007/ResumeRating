package job_description;

public class SubSkill {
    String name;
    int weight;

    public SubSkill() {
    }

    public SubSkill(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ':' + weight;
    }
}
