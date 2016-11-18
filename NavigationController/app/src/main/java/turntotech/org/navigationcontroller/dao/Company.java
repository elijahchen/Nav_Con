package turntotech.org.navigationcontroller.dao;

/**
 * Created by elijah on 11/17/2016.
 */

public class Company {

    private String companyName;
    private int id;

    Company (String name, int id) {
        this.companyName = name;
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String name) {
        companyName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
