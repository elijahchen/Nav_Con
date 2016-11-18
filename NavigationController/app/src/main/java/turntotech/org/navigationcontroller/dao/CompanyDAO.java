package turntotech.org.navigationcontroller.dao;

import java.util.List;

/**
 * Created by elijah on 11/17/2016.
 */

public interface CompanyDAO {

    public List<Company> getAllCompanies();
    public Company getCompany(int id);
    public void updateCompany(Company company);
    public void deleteCompany(int id);
    public void addCompany(String companyName);

}
