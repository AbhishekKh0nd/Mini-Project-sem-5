import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AssignBed {

    public static void assignbed(){
        ArrayList<Beds> fittingBeds = new ArrayList<>(DataBase.bedList.size());


        Patient pa = DataBase.patientList.get(0);
        String paDept = pa.departmentNeeded.Name;
        String pacat = pa.preferred_room;


        for (Beds b : DataBase.bedList) {

            String bcat = b.category;

            if (!b.occupied) {
                if (pacat.equals(bcat)) {
                    fittingBeds.add(b);
                }
            }
        }


        ArrayList<Beds> filteredBeds = new ArrayList<>();
        for (Beds b : fittingBeds) {
            if (b.dept.equals(paDept)){
                filteredBeds.add(b);
            }

        }

        if (filteredBeds.isEmpty()){
            JOptionPane.showMessageDialog(PatientForm.frame, "No beds available" );
        }


        Patient paa = DataBase.patientList.get(0);
        Beds ba = filteredBeds.get(0);
        DataBase.map.put(paa, ba);
        ba.occupied = true;
        fittingBeds.remove(ba);

//        System.out.println(fittingBeds.size());
//        System.out.println(DataBase.map);
        JOptionPane.showMessageDialog(PatientForm.frame, DataBase.map.get(paa).name);
    }

    public static void removePatientAndFreeTheBed(Patient p){

        DataBase.map.get(p).occupied = false;

    }
}
