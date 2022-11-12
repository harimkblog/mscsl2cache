package upg.mscs.orml2cache.datagen;

import upg.mscs.orml2cache.entity.Address;
import upg.mscs.orml2cache.entity.Student;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class AddressGen {
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\Harim\\OneDrive\\Documents\\personal\\work\\mscsl2cache\\files\\address.csv";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(String.join(",", "id", "street_address", "city", "state", "country").getBytes());
            out.write("\n".getBytes());
            for (int i = 0; i < 100000; ++i) {
                Address a = new Address();
                a.setId(i);
                a.setCity("city " + i);
                a.setStreetAddress("address " + i);
                if (i % 2 == 0) a.setState("NJ");
                else a.setState("NY");
                a.setCountry("USA");
                out.write(a.toString().getBytes());
                out.write("\n".getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
