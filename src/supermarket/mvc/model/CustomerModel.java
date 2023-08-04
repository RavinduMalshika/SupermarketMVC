package supermarket.mvc.model;

public class CustomerModel {
    private String custId, custTitle, custName, dob, custAddress, city, province, postalCode;
    private Double salary;

    public CustomerModel() {
    }

    public CustomerModel(String custId, String custTitle, String custName, String dob, String custAddress, String city, String province, String postalCode, Double salary) {
        this.custId = custId;
        this.custTitle = custTitle;
        this.custName = custName;
        this.dob = dob;
        this.custAddress = custAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.salary = salary;
    }

    
    
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustTitle() {
        return custTitle;
    }

    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "custId=" + custId + ", custTitle=" + custTitle + ", custName=" + custName + ", dob=" + dob + ", custAddress=" + custAddress + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode + ", salary=" + salary + '}';
    }
}
