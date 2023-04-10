import java.util.ArrayList;

public class Patient {

    String patientName;
    int age;
    String gender;
    Departments departmentNeeded;
    String preferred_room;

    public static ArrayList<Patient> patientsList= new ArrayList<>();

//    public static String[] dept = {"Dept1", "Dept2", "Dept3", "Dept4"};

    public Patient(){
        //empty constructor
    }


    public Patient (String name, int age, String gender, Departments d, String preferred){  //patient cunstructor

        this.age = age;
        this.gender = gender;
        this.patientName = name;
        this.departmentNeeded = d;
        this.preferred_room = preferred;
    }

    public static void addP(String name, int age, String gender, Departments d, String preferred){  //1. TAKE INPUT OF PATIENT DATA
                                                                                               //2. CREATE PATIENT OBJECT WITH THAT DATA
                                                                                               //3. ADD THAT OBJECT TO patientList (REFER DATABASE CLASS FOR THIS LIST.)
        Patient p = new Patient(name, age, gender, d, preferred);
        DataBase.patientList.add(p);

    }
}
