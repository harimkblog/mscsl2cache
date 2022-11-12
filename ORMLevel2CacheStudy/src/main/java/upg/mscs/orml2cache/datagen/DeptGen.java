package upg.mscs.orml2cache.datagen;

import upg.mscs.orml2cache.entity.Department;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class DeptGen {

    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\Harim\\OneDrive\\Documents\\personal\\work\\mscsl2cache\\files\\dept.csv";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(String.join(",", "id", "name").getBytes());
            out.write("\n".getBytes());
            for(int i =0; i<1000;++i) {
                Department d = new Department();
                d.setId(i);
                d.setName("dept" + i);
                out.write(d.toString().getBytes());
                out.write("\n".getBytes());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
