package CompositeDesignPattern;

public class NewEraUniversityClient {
    public static void main(String[] args) {
        College newEraUniversity = new College("New Era University");
        College cics = new College("College of Informatics and Computing Studies");
        College coa = new College("College of Accountancy");

        Department deptCS = new Department("Department of Computer Science");
        Department deptIT = new Department("Department of Information Technology");
        Department deptAccounting = new Department("Department of Accountancy");

        Teacher teacher1 = new Teacher("Maria Salazar", "Data Structures and Algorithm", 50000);
        Teacher teacher2 = new Teacher("Juan Gomez Dela Paz", "Information Management", 55000);
        Teacher teacher3 = new Teacher("Luningning Reyes", "Intermediate Accounting", 60000);

        Student student1 = new Student("Pablo Reyes", "23-12022-222", 15000);
        Student student2 = new Student("Aljhon Dela Cruz", "23-12022-223", 15000);
        Student student3 = new Student("Coleen Baltazar", "23-12022-224", 12000);
        Student student4 = new Student("John Marc Poblacion", "23-12022-225", 16000);

        deptCS.add(teacher1);
        deptCS.add(student1);
        deptCS.add(student2);
        deptIT.add(teacher2);
        deptIT.add(student3);
        deptAccounting.add(teacher3);
        deptAccounting.add(student4);
        cics.add(deptCS);
        cics.add(deptIT);
        coa.add(deptAccounting);
        newEraUniversity.add(cics);
        newEraUniversity.add(coa);

        System.out.println("--- University Organizational Structure ---\n");
        newEraUniversity.displayDetails("");

        System.out.println("\n--- University Metrics ---");
        System.out.println("Total University Enrolled Students: " + newEraUniversity.getStudentCount());
        System.out.printf("Total University Budget: \u20b1%,.2f%n", newEraUniversity.getBudget());

        System.out.println("\n---College of Accountancy---");
        System.out.println("Accountancy Students: " + coa.getStudentCount());
        System.out.printf("Accountancy Budget: \u20b1%,.2f%n", coa.getBudget());

        System.out.println("\n---College of Informatics and Computing Science---");
        System.out.println("CICS Students: " + cics.getStudentCount());
        System.out.printf("CICS Budget: \u20b1%,.2f%n", cics.getBudget());
    }
}