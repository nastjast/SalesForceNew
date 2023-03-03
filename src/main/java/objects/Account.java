package objects;

public class Account {

    String accountName;
    String website;
    String option;
    String description;

    public Account(String accountName, String website, String industry, String description) {
        this.accountName = accountName;
        this.website = website;
        this.option = industry;
        this.description=description;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
