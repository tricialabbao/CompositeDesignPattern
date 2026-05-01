package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class College implements EducationalUnit {

    private final String name;
    private final List<EducationalUnit> children = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }

    public void add(EducationalUnit unit) {
        children.add(unit);
    }

    public void remove(EducationalUnit unit) {
        children.remove(unit);
    }

    public List<EducationalUnit> getChildren() {
        return children;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "College     : " + name);
        System.out.printf (indent + "Total Students : %d%n", getStudentCount());
        System.out.printf (indent + "Total Budget   : PHP %,.2f%n", getBudget());
        System.out.println(indent + "Units:");
        for (EducationalUnit child : children) {
            child.displayDetails(indent + "     ");
        }
    }

    @Override
    public int getStudentCount() {
        return children.stream().mapToInt(EducationalUnit::getStudentCount).sum();
    }

    @Override
    public double getBudget() {
        return children.stream().mapToDouble(EducationalUnit::getBudget).sum();
    }
}