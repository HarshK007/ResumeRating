package meta_data;

import job_description.CompanyTierEnum;
import job_description.CompanyTypeEnum;

public class CompanyMapper {
    String name;
    CompanyTierEnum companyTierEnum;
    CompanyTypeEnum companyTypeEnum;

    public CompanyMapper() {
    }

    public CompanyMapper(String name, CompanyTierEnum companyTierEnum, CompanyTypeEnum companyTypeEnum) {
        this.name = name;
        this.companyTierEnum = companyTierEnum;
        this.companyTypeEnum = companyTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyTierEnum getCompanyTier() {
        return companyTierEnum;
    }

    public void setCompanyTier(CompanyTierEnum companyTierEnum) {
        this.companyTierEnum = companyTierEnum;
    }

    public CompanyTypeEnum getCompanyType() {
        return companyTypeEnum;
    }

    public void setCompanyType(CompanyTypeEnum companyTypeEnum) {
        this.companyTypeEnum = companyTypeEnum;
    }
}
