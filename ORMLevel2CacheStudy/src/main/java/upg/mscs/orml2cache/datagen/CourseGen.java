package upg.mscs.orml2cache.datagen;

import upg.mscs.orml2cache.entity.Course;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class CourseGen {
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\Harim\\OneDrive\\Documents\\personal\\work\\mscsl2cache\\files\\course.dat";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            for(int i =0; i<1000;++i) {
                Course c = new Course();
                c.setId(i);
                c.setName("course " + i);
                out.write(c.toString().getBytes());
                out.write("\n".getBytes());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
