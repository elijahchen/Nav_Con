package turntotech.org.navigationcontroller.utility;

/**
 * Created by elijah on 9/15/2016.
 */
public class Company {

    private String companyName;
    private int companyLogo;

    public Company(int icon, String value) {
        companyName = value;
        companyLogo = icon;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyLogo() {
        return companyLogo;
    }

}
