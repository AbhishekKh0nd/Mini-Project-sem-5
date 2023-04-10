import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadData.readDataDept();
        ReadData.readDataRooms();
        ReadData.sliceDeptBeds();
        DataBase.roomsListToRoomsCategoryList();
        DataBase.roomsListToBedsList();

        PatientForm p = new PatientForm();

    }
}
