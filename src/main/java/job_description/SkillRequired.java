package job_description;

import java.util.List;

public class SkillRequired {
    String name;
    int weight;
    List<SubSkill> subSkills;

    public SkillRequired() {
    }

    public SkillRequired(String name, int weight, List<SubSkill> subSkills) {
        this.name = name;
        this.weight = weight;
        this.subSkills = subSkills;
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

    public List<SubSkill> getSubSkills() {
        return subSkills;
    }

    public void setSubSkills(List<SubSkill> subSkills) {
        this.subSkills = subSkills;
    }

    @Override
    public String toString() {
        return name + ':' + weight + subSkills;
    }
}
