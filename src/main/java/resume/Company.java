package resume;

public class Company {
    String name;
    int monthsWorked;

    public Company() {
    }

    public Company(String name, int monthsWorked) {
        this.name = name;
        this.monthsWorked = monthsWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthsWorked() {
        return monthsWorked;
    }

    public void setMonthsWorked(int monthsWorked) {
        this.monthsWorked = monthsWorked;
    }

    @Override
    public String toString() {
        return ""+name + ':' +  monthsWorked;
    }
}
