package job_description;

public class CompanyType {

    CompanyTypeEnum companyTypeEnum;
    int weight = 0;

    public CompanyType() {
    }

    public CompanyType(CompanyTypeEnum companyTypeEnum, int weight) {
        this.companyTypeEnum = companyTypeEnum;
        this.weight = weight;
    }

    public CompanyTypeEnum getCompanyTypeEnum() {
        return companyTypeEnum;
    }

    public void setCompanyTypeEnum(CompanyTypeEnum companyTypeEnum) {
        this.companyTypeEnum = companyTypeEnum;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + companyTypeEnum +
                ":" + weight +
                "]";
    }
}
