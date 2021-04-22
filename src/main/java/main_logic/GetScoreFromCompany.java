package main_logic;

import job_description.*;
import meta_data.CompanyMapper;
import resume.Company;
import resume.Resume;

import java.util.HashMap;
import java.util.Map;

public class GetScoreFromCompany {

    GetScoreFromCompany(){

    }

    public static double getScoreFromCompany (Resume resume, JobDescription jobDescription) {
        double score = 0.0;
        int tier1 = 0;
        int tier2 = 0;
        int prodBased = 0;
        int servBased = 0;

        Map<String, CompanyMapper> companyMapperMap = new HashMap<>();
        for (CompanyMapper companyMapper: Main.companyMapperArrayList) {
            companyMapperMap.put(companyMapper.getName(), companyMapper);
        }

        for (Company company: resume.getCompanies()) {
            if (companyMapperMap.containsKey(company.getName())) {
                for(CompanyTier companyTier: jobDescription.getCompanyTiers()) {
                    if (companyMapperMap.get(company.getName()).getCompanyTier().equals(companyTier.getCompanyTierEnum())) {
                        if (tier1 != 1 && companyTier.getCompanyTierEnum().equals(CompanyTierEnum.TIER1)){
                            score = score + companyTier.getWeight();
                            tier1 = 1;
                        }
                        else if (tier2 != 1 && companyTier.getCompanyTierEnum().equals(CompanyTierEnum.TIER2)){
                            score = score + companyTier.getWeight();
                            tier2 = 1;
                        }
                    }
                }
                for(CompanyType companyType: jobDescription.getCompanyTypes()) {
                    if(companyMapperMap.get(company.getName()).getCompanyType().equals(companyType.getCompanyTypeEnum())) {
                        if (prodBased != 1 && companyType.getCompanyTypeEnum().equals(CompanyTypeEnum.PRODUCT_BASED)){
                            score = score + companyType.getWeight();
                            prodBased = 1;
                        }
                        else if (servBased != 1 && companyType.getCompanyTypeEnum().equals(CompanyTypeEnum.SERVICE_BASED)){
                            score = score + companyType.getWeight();
                            servBased = 1;
                        }
                    }
                }
            }
        }

        return (score / (jobDescription.getCompanyTierWeight() + jobDescription.getCompanyTypeWeight()));
    }
}
