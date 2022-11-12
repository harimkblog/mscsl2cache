package upg.mscs.orml2cache.datagen;

import upg.mscs.orml2cache.entity.Address;
import upg.mscs.orml2cache.entity.Course;
import upg.mscs.orml2cache.entity.Department;
import upg.mscs.orml2cache.entity.Student;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashSet;

public class StudentGen {
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\Harim\\OneDrive\\Documents\\personal\\work\\mscsl2cache\\files\\student.csv";
        String file2 = "C:\\Users\\Harim\\OneDrive\\Documents\\personal\\work\\mscsl2cache\\files\\student-course.csv";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            try(BufferedOutputStream out2 = new BufferedOutputStream(new FileOutputStream(file2))) {
                out.write(String.join(",", "id", "name", "address_id", "department_id").getBytes());
                out.write("\n".getBytes());
                out2.write(String.join(",", "students_id", "courses_id").getBytes());
                out2.write("\n".getBytes());

                int deptId = -1, courseId = -1;
                int mod = 10;
                for (int i = 0; i < 100000; ++i) {
                    Student s = new Student();
                    s.setId(i);
                    s.setName("student " + i);
                    Address a = new Address();
                    a.setId(i);
                    s.setAddress(a);
                    if (i % mod == 0) {
                        ++deptId; ++courseId; mod += 2;
                    }
                    if (deptId == 1000) deptId = 0;
                    if (courseId == 1000) { courseId = 0; mod = 10; }
                    Department d = new Department();
                    d.setId(deptId);
                    s.setDepartment(d);
                    Course c = new Course();
                    c.setId(courseId); HashSet<Course> hs = new HashSet<>(); hs.add(c); s.setCourses(hs);
                    out.write(s.toString().getBytes());
                    out.write("\n".getBytes());
                    out2.write(s.studentCourseMap().getBytes());
                    out2.write("\n".getBytes());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
