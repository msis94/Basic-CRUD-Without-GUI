public class Detail
{
    private String name;
    private int emp_num;
    private String status;

    public Detail()
    {}

    public Detail(String name, int emp_num, String status)
    {
        this.name = name;
        this.emp_num = emp_num;
        this.status = status;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getEmp_num()
    {
        return emp_num;
    }

    public void setEmp_num(int emp_num)
    {
        this.emp_num = emp_num;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
