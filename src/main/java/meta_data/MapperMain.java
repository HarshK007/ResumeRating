package meta_data;

import job_description.CollegeTierEnum;
import job_description.CompanyTierEnum;
import job_description.CompanyTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class MapperMain {

    MapperMain(){
        // Do nothing
    }

    public static List<CompanyMapper> createCompanyMapper() {
        //company mapper
        List<CompanyMapper> companyMapperArrayList =  new ArrayList<>();
        companyMapperArrayList.add(new CompanyMapper("microsoft", CompanyTierEnum.TIER1, CompanyTypeEnum.PRODUCT_BASED));
        companyMapperArrayList.add(new CompanyMapper("wipro", CompanyTierEnum.TIER2, CompanyTypeEnum.SERVICE_BASED));
        companyMapperArrayList.add(new CompanyMapper("oracle", CompanyTierEnum.TIER1, CompanyTypeEnum.PRODUCT_BASED));
        companyMapperArrayList.add(new CompanyMapper("adobe", CompanyTierEnum.TIER1, CompanyTypeEnum.PRODUCT_BASED));
        companyMapperArrayList.add(new CompanyMapper("tCS", CompanyTierEnum.TIER1, CompanyTypeEnum.SERVICE_BASED));
        companyMapperArrayList.add(new CompanyMapper("infosys", CompanyTierEnum.TIER2, CompanyTypeEnum.SERVICE_BASED));

        return companyMapperArrayList;
    }

    public static List<CollegeMapper> createCollegeMapper() {
        //college mapper
        List<CollegeMapper> collegeMapperArrayList = new ArrayList<>();
        collegeMapperArrayList.add(new CollegeMapper("delhi technical university", CollegeTierEnum.TIER1));
        collegeMapperArrayList.add(new CollegeMapper("delhi university", CollegeTierEnum.TIER2));
        collegeMapperArrayList.add(new CollegeMapper("ip university", CollegeTierEnum.TIER3));
        collegeMapperArrayList.add(new CollegeMapper("nit tirchy", CollegeTierEnum.TIER1));
        collegeMapperArrayList.add(new CollegeMapper("nit delhi", CollegeTierEnum.TIER2));
        collegeMapperArrayList.add(new CollegeMapper("iit delhi", CollegeTierEnum.TIER1));

        return collegeMapperArrayList;
    }
}
