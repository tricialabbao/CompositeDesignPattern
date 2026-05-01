package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Department implements EducationalUnit {

    private final String name;
    private final List<EducationalUnit> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(EducationalUnit unit) {
        members.add(unit);
    }

    public void remove(EducationalUnit unit) {
        members.remove(unit);
    }

    public List<EducationalUnit> getMembers() {
        return members;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "Department : " + name);
        System.out.printf (indent + "Students   : %d%n", getStudentCount());
        System.out.printf (indent + "Net Budget : PHP %,.2f%n", getBudget());
        System.out.println(indent + "Members:");
        for (EducationalUnit unit : members) {
            unit.displayDetails(indent + "     ");
        }
    }

    @Override
    public int getStudentCount() {
        return members.stream().mapToInt(EducationalUnit::getStudentCount).sum();
    }

    @Override
    public double getBudget() {
        return members.stream().mapToDouble(EducationalUnit::getBudget).sum();
    }
}