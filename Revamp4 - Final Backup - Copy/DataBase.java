import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DataBase {

    public static String[] database = new String[200];  //WE COPY ALL THE TEXT DATA TO THIS LARGE ARRAY
    public static ArrayList<String> roomList = new ArrayList<>(); // MEKO BHI YAD NAHI ARRA YE KYA KAAM MEE ARRA. JUST DONT TOUCH IT LOL.
    public static String[] roomArray; // THIS IS USED TO STORE ALL "ROOM" DATA - SIMILAR TO HOW database ARRAY IS USED TO STORE ALL DATA.



//^^^^^^^^^^^^^^^^^^^^^^^^^^^ DO NOT TOUCH THESE ARRAYS AND ARRAY LISTS ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


    public static ArrayList<Departments> department = new ArrayList<>(); // <=======  DEPARTMENTS ARRAY LIST. NOTHING SPECIAL. REFER Departments class FOR FURTHER UNDERSTANDING.
    public static ArrayList<Rooms> finalRooms = new ArrayList<Rooms>(); // <======== THIS IS FINAL ROOMS ARRAYLIST
    public static ArrayList<Patient> patientList = new ArrayList<>(); // <======== THIS LIST STORES PATIENT OBJECTS
    public static ArrayList<String> finalRoomsCategoryList = new ArrayList<>();// <====== LIST OF ALL THE CATEGORIES OF ROOM
//    public static String[] roomCategories = finalRoomsCategoryList.toArray(new String[0]);
    public static ArrayList<Beds> bedList = new ArrayList<>(); // <====== LIST OF ALL BEDS

    public static HashMap<Patient, Beds> map = new HashMap<>();

//============================================================================================================

    public static void listToArrayRooms(){           // COPIES ALL DATA FROM roomList ARRAYLIST<> to compRoomsArray ARRAY[]

        roomArray = new String[roomList.size()];

        for (int i = 0; i< getRoomList(roomList); i++){
            roomArray[i] = roomList.get(i);
        }
    }

//====================================================================
    public static int getRoomList(ArrayList<String> completeRooms){     // RETURNS THE SIZE OF completeRooms ARRAYLIST<>
        return completeRooms.size();
    }

//====================================================================

    public static void roomsListToRoomsCategoryList() {

        for (Rooms r : finalRooms){
            if (!finalRoomsCategoryList.contains(r.roomCategory)){
                finalRoomsCategoryList.add(r.roomCategory);
            }
        }
    }

    public static void roomsListToBedsList(){

        for (Rooms r : finalRooms){
            for(String s : r.Beds){
                Beds bed = new Beds(s,false, r.department, r.roomCategory);
                bedList.add(bed);
            }
        }
    }

//=====================================================================

//    public static void createTempPatient(){
//        Departments d = new Departments(1,"DEPARTMENT1");
//        Patient.addP("Allen", 23, "Female",d, "Luxury");
//
//    }
}


