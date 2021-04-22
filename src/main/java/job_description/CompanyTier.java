package job_description;

public class CompanyTier {

    CompanyTierEnum companyTierEnum;
    int weight;

    public CompanyTier() {
    }

    public CompanyTier(CompanyTierEnum companyTierEnum, int weight) {
        this.companyTierEnum = companyTierEnum;
        this.weight = weight;
    }

    public CompanyTierEnum getCompanyTierEnum() {
        return companyTierEnum;
    }

    public void setCompanyTierEnum(CompanyTierEnum companyTierEnum) {
        this.companyTierEnum = companyTierEnum;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + companyTierEnum +
                ":" + weight +
                "]";
    }
}
