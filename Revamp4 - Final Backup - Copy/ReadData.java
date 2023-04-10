import java.io.IOException;
import java.util.HashSet;

public class ReadData {

    public static ReadFile Rf = new ReadFile();

     static int i = 0;

    public static void readDataDept() throws IOException {            // THIS FUNCTION STARTS READING THE FILE AND SAVES DEPARTMENT DATA (FIRST PART IN tt.txt)
                                                                      // AND SAVES IT INTO ARRAY LIST OF DEPARTMENT OBJECT TYPE
        Rf.readToAllData();
        String s = null;
        while(!(s = DataBase.database[i]).equals("===========")) {
            Departments d = new Departments(i,s);
            DataBase.department.add(d);
            i++;
        }
        DataBase.department.remove(0);
    }



    public static void readDataRooms() throws IOException {         //1. AFTER READING ALL DEPARTMENTS, REMAINING DATA IS ALL ABOUT ROOMS,
                                                                    //2. SO, THIS FUNCTION READS ENTIRE REMAINING DATA AND STORES IT INTO ARRAY LIST CALLED completeRooms (SEE IT IN DataBase class)
                                                                    //3. THIS SAME ARRAYLIST IS FURTHER STORED INTO ARRAY CALLED compRoomsArray (SEE IT IN DataBase class)
        int l = DataBase.department.size() + 1;

        String s = "";
        while(!( s = DataBase.database[l+1]).equals("===========")){
            DataBase.roomList.add(s);
            l++;
        }
        DataBase.listToArrayRooms(); // THIS FUNCTION DOES THE THING DISCUSSED INT PT NUMBER 3.
    }

    public static void sliceDeptBeds(){  //1. THIS FUNCTION SLICES THE LIST AT "------------" AND CATEGORISES THEM AT DEPARTMENT LEVEL.
                                         //2. THESE PARTITIONS ARE USED TO CREATE ROOM OBJECT SUCH THAT ALL ROOMS HAVE APPROPRIATE DEPARTMENTS.

        int i = 1;
        String d = null;
        while (i != DataBase.roomArray.length - 3) {

            if (i <= 1) {
                d = DataBase.roomArray[0];
            } else {
                if (DataBase.roomArray[i].equals("-----------")) {
                    d = DataBase.roomArray[i + 1];
                    i = i + 2;
                }
            }


            String abc = DataBase.roomArray[i + 2];
            String[] w = abc.split(" ");

            Rooms r = new Rooms(d, DataBase.roomArray[i], DataBase.roomArray[i + 1], w);
            DataBase.finalRooms.add(r);
            i = i + 3;
        }

    }





// ALL PRINT FUNCTIONS FROM HERE, THESE ARE JUST TO TEST THE CODE AS WE GO ALONG THE PROJECT
//===================================================================================================================
//===================================================================================================================



    public static void printDept(){                          // PRINTS ENTIRE dept ARRAYLIST, SHOWING ITS Name AND id
                                                             // (SEE DataBase class for dept array list and Department class for Name and id variables)
        for (int i = 0; i<DataBase.department.size(); i++){
            System.out.println(DataBase.department.get(i).Name + " " + DataBase.department.get(i).id);
        }
    }



    public static void printCompleteRooms(){                 //PRINTS completeRooms ARRAY LIST.

            System.out.println(DataBase.roomList);

    }



//    public static void printRoom(){                          //PRINTS room ARRAY LIST.(SEE DataBase class FOR room ARRAYLIST<>)
//        for (int i =0; i<DataBase.room.size(); i++) {
//            System.out.print(DataBase.room.get(i).department + " ");
//        }
//    }
//
//
//    public static void printRoomDepartment(){               //PRINTS categories of every room in arraylist room.
//
//        for(Rooms s : DataBase.room){
//            System.out.println(s.roomCategory);
//        }
//
//    }


    public static void printcompRoomArray(){                         //PRINTS ARRAY[] compRoomsArray.
        for(int i = 0; i<DataBase.roomArray.length; i++){
            System.out.println(DataBase.roomArray[i]);
        }
    }

}
