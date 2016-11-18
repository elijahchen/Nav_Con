package turntotech.org.navigationcontroller.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elijah on 11/17/2016.
 */

public class ImplementCompanyDAO implements CompanyDAO {

    List<Company> companies;

    public ImplementCompanyDAO(){
        companies = new ArrayList<Company>();
//        Company apple = new Company("Apple", 0);
//        Company samsung = new Company("Samsung", 1);
//        Company huawei = new Company("Huawei", 2);
//        Company xiaomi = new Company("XiaoMi", 3);
//        companies.add(apple);
//        companies.add(samsung);
//        companies.add(huawei);
//        companies.add(xiaomi);

        addCompany("Apple");
        addCompany("Samsung");
        addCompany("Huawei");
        addCompany("XiaoMi");



    }

    @Override
    public List<Company> getAllCompanies() {
        return companies;
    }

    @Override
    public Company getCompany(int id) {
        return companies.get(id);
    }

    @Override
    public void updateCompany(Company company) {
        companies.get(company.getId()).setCompanyName(company.getCompanyName());
    }

    @Override
    public void deleteCompany(int id) {
        companies.remove(id);
    }

    @Override
    public void addCompany(String companyName) {
        Company company = new Company(companyName, companies.size()+1);
            companies.add(company);
    }
}
