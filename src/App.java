
import java.util.Scanner;

class App {

    public static Scanner input = new Scanner(System.in);

    public static String[] studentIdAr = new String[0];

    public static String[] studentNames = new String[0];

    public static int[] PRFmarks = new int[0];

    public static int[] DBMSmarks = new int[0];

    public static int[] Total;

    public static double[] Average;

    public static double[] avgDuplicate;

    public static int[] rank = new int[0];

    public static int[] rankForPRF;

    public static int[] rankForDBMS;

    // public static int studentsWithMarksCount = 0;

    public static boolean shouldContinue = false;

    public static char check = 'Y';

    public static void header(int i) {
        System.out.println(
                "--------------------------------------------------------------------------------------------------------");
        headerTopicSelection(i);
        System.out.println(
                "--------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void headerTopicSelection(int i) {
        switch (i) {
            case 0:

                System.out.println(
                        "|                                WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                               |");
                break;

            case 1:

                System.out.println(
                        "|                                            ADD NEW STUDENT                                           |");
                break;

            case 2:

                System.out.println(
                        "|                                       ADD NEW STUDENT WITH MARKS                                     |");
                break;

            case 3:

                System.out.println(
                        "|                                               ADD MARKS                                              |");
                break;

            case 4:

                System.out.println(
                        "|                                        UPDATE STUDENT DETAILS                                        |");
                break;

            case 5:

                System.out.println(
                        "|                                             UPDATE MARKS                                             |");
                break;

            case 6:

                System.out.println(
                        "|                                            DELETE STUDENT                                            |");
                break;

            case 7:

                System.out.println(
                        "|                                        PRINT STUDENT DETAILS                                         |");
                break;

            case 8:

                System.out.println(
                        "|                                         PRINT STUDENTS RANKS                                         |");
                break;

            case 9:
                System.out.println(
                        "|                                   BEST IN PROGRAMMING FUNDAMENTALS                                    |");
                break;

            case 10:
                System.out.println(
                        "|                                  BEST IN DATABASE MANAGEMENT SYSTEM                                  |");
                break;

        }
    }

    public static char Y_or_n(int i) {
        System.out.println();

        switch (i) {
            case 1:
            case 2:
                System.out.print("Student has been added successfully. Do you want to add a new student? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;
            case 3:
                System.out.print("Marks have been added. Do you want to add marks for another student? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 4:
                System.out.print(
                        "Student details has been updated successfully. Do you want to update another student's details? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 45:
                System.out.print(
                        "Invalid Student ID. Do you want to search again? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 5:
                System.out.print(
                        "Marks have been updated successfully. \nDo you want to update another student's marks? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 55:
                System.out.print(
                        "This student's marks are yet to be added. \nDo you want to update another student's marks? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;
            case 6:
                System.out.print(
                        "Student details has been deleted successfully. \nDo you want to delete another student's details? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 7:
                System.out.print(
                        "Do you want to search another student details? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 75:
                System.out.print(
                        "Marks are yet to be added. \n\nDo you want to search another student details? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

            case 8:
                System.out.print(
                        "Do you want to go back to the main menu? (\u001B[32mY\u001B[37m/\u001B[31mN\u001B[37m): ");
                break;

        }
        // default>> (opt) System.out.print("Student has been added successfully. Do you

        check = input.next().charAt(0);
        System.out.println();
        return check;
    }

    public static int countingTheStudentsWithMarks() {
        int tempCount = 0;
        for (int i = 0; i < studentIdAr.length; i++) {
            if (PRFmarks[i] != -1 && DBMSmarks[i] != -1) {
                tempCount++;
            }
        }
        return tempCount;

    }


    public static void gettingDB_rank() {

        int[] tempDB = new int[DBMSmarks.length];
        for (int i = 0; i < studentIdAr.length; i++) {
            tempDB[i] = DBMSmarks[i];
        }

        for (int j = tempDB.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (tempDB[i] > tempDB[i + 1]) {
                    int t = tempDB[i];
                    tempDB[i] = tempDB[i + 1];
                    tempDB[i + 1] = t;
                }

            }
        }

        rankForDBMS = new int[studentIdAr.length];

        for (int i = tempDB.length - 1, rank = 0; i >= 0; i--, rank++) {

            for (int j = 0; j < DBMSmarks.length; j++) {

                if (tempDB[i] == DBMSmarks[j]) {

                    rankForDBMS[j] = rank + 1;

                    break;
                }

            }
        }
    }

    public static void N10_bestInDB() {

        header(10);
        // countingTheStudentsWithMarks();

        System.out.println(
                "+---------+--------------------------+-------------+-------------+");
        System.out.println(
                "| ID      | NAME                     | DBMS Marks  | PRF Marks   |");
        System.out.println(
                "+---------+--------------------------+-------------+-------------+");
        check = 'n';
        do {
            for (int i = 1; i <= countingTheStudentsWithMarks(); i++) {

                // gettingRank();
                gettingDB_rank();

                System.out.print("|");

                if (countingTheStudentsWithMarks() > 0) {

                    // System.out.printf(" %-8d|", i);

                    for (int j = 0; j < studentIdAr.length; j++) {

                        if (rankForDBMS[j] == i) {

                            System.out.printf(" %-8s|", studentIdAr[j]);
                            System.out.printf(" %-25s|", studentNames[j]);
                            System.out.printf("%12d |", DBMSmarks[j]);
                            System.out.printf("%12d |", PRFmarks[j]);
                            break;

                        }
                    }
                }
                System.out.println();
            }
            System.out.println(
                    "+---------+--------------------------+-------------+-------------+");

            check = Y_or_n(8);

        } while (check == 'N' || check == 'n');

    }

    public static void gettingPRF_rank() {
        int[] tempPRF = new int[PRFmarks.length];
        for (int i = 0; i < studentIdAr.length; i++) {
            tempPRF[i] = PRFmarks[i];
        }

        for (int j = tempPRF.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (tempPRF[i] > tempPRF[i + 1]) {
                    int t = tempPRF[i];
                    tempPRF[i] = tempPRF[i + 1];
                    tempPRF[i + 1] = t;
                }
            }
        }

        rankForPRF = new int[studentIdAr.length];

        for (int i = tempPRF.length - 1, rank = 0; i >= 0; i--, rank++) {

            for (int j = 0; j < PRFmarks.length; j++) {

                if (tempPRF[i] == PRFmarks[j]) {

                    rankForPRF[j] = rank + 1;

                    break;
                }

            }
        }

    }

    public static void N9_bestInPRF() {

        header(9);

        System.out.println(
                "+---------+--------------------------+-----------+-----------+");
        System.out.println(
                "| ID      | NAME                     | PRF Marks | DBMS Marks|");
        System.out.println(
                "+---------+--------------------------+-----------+-----------+");
        check = 'n';
        do {
            for (int i = 1; i <= countingTheStudentsWithMarks(); i++) {

                gettingPRF_rank();

                System.out.print("|");

                if (countingTheStudentsWithMarks() > 0) {

                    // System.out.printf(" %-8d|", i);

                    for (int j = 0; j < studentIdAr.length; j++) {

                        if (rankForPRF[j] == i) {

                            System.out.printf(" %-8s|", studentIdAr[j]);
                            System.out.printf(" %-25s|", studentNames[j]);
                            System.out.printf("%10d |", PRFmarks[j]);
                            System.out.printf("%10d |", DBMSmarks[j]);
                            break;

                        }
                    }

                }
                System.out.println();
            }
            System.out.println(
                    "+---------+--------------------------+-----------+-----------+");

            check = Y_or_n(8);

        } while (check == 'N' || check == 'n');

    }

    public static void N8_printStudentRanks() {
        header(8);
        countingTheStudentsWithMarks();

        System.out.println(
                "+---------+-----------+------------------------------+----------------------+----------------------+");
        System.out.println(
                "| Rank    | ID        | NAME                         | Total Marks          | Avg. Marks           |");
        System.out.println(
                "+---------+-----------+------------------------------+----------------------+----------------------+");
        check = 'n';
        do {
            for (int i = 1; i <= countingTheStudentsWithMarks(); i++) {

                gettingRank();

                System.out.print("|");

                if (countingTheStudentsWithMarks() > 0) {

                    System.out.printf(" %-8d|", i);

                    for (int j = 0; j < studentIdAr.length; j++) {

                        if (rank[j] == i) {

                            System.out.printf(" %-10s|", studentIdAr[j]);
                            System.out.printf(" %-29s|", studentNames[j]);
                            System.out.printf("%21d |", Total[j]);
                            System.out.printf("%21.2f |", Average[j]);
                            break;

                        }
                    }

                }
                System.out.println();
            }
            System.out.println(
                    "+---------+-----------+------------------------------+----------------------+----------------------+");

            check = Y_or_n(8);

        } while (check == 'N' || check == 'n');

    }

    public static void processMarks() { // // try to create these without temp arrays with
        int[] tempTot = new int[studentIdAr.length];
        double[] tempAvg = new double[studentIdAr.length];
        double[] tempAvgDuplicate = new double[studentIdAr.length];

        for (int i = 0; i < studentIdAr.length; i++) {

            tempTot[i] = PRFmarks[i] + DBMSmarks[i];
            tempAvg[i] = (double) tempTot[i] / 2;
            tempAvgDuplicate[i] = tempAvg[i];
        }

        Total = tempTot;
        Average = tempAvg;
        avgDuplicate = tempAvgDuplicate;

    }



    public static void storeRank() { // bubble sort for now

        processMarks();

        for (int j = avgDuplicate.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (avgDuplicate[i] > avgDuplicate[i + 1]) {
                    double t = avgDuplicate[i];
                    avgDuplicate[i] = avgDuplicate[i + 1];
                    avgDuplicate[i + 1] = t;
                }

            }
        }

    }

    public static void gettingRank() { // try to create these without temp arrays with
        storeRank();

        int tempRank[] = new int[studentIdAr.length];

        for (int i = tempRank.length - 1, rank = 0; i >= 0; i--, rank++) {

            for (int j = 0; j < tempRank.length; j++) {

                if (avgDuplicate[i] == Average[j]) {

                    tempRank[j] = rank + 1;

                    break;
                }

            }
        }

        rank = tempRank;
    }

    public static void N7_printStudentDetails() {
        header(7);

        check = 'n';
        do {
            System.out.print("Enter student ID\t: ");
            int index = searchStudent(input.next() + input.nextLine());

            if (index >= 0) {
                if (areMarksAdded(index)) {
                    gettingRank();

                    System.out.println("Student Name\t\t: " + studentNames[index]);
                    // System.out.println();
                    System.out.println("+----------------------------------------+-------------------------" + "+");
                    System.out.printf("| Programming Fundamentals Marks         |%25d", PRFmarks[index]);
                    System.out.println("|");
                    System.out.printf("| Database Management System Marks       |%25d", DBMSmarks[index]);
                    System.out.println("|");
                    System.out.printf("| Total Marks                            |%25d", Total[index]);
                    System.out.println("|");
                    System.out.printf("| Avg. Marks                             |%25.2f", Average[index]);
                    System.out.println("|");
                    System.out.printf("| Rank                                   |%25d", rank[index]);
                    System.out.println("|");
                    System.out.println("+----------------------------------------+-------------------------" + "+");

                    check = Y_or_n(7);

                } else {
                    check = Y_or_n(75);
                }

            } else {

                check = Y_or_n(45);
            }
        } while (check == 'Y' || check == 'y');
    }

    public static void deleteData(int index) {

        String[] tempID = new String[studentIdAr.length - 1];
        String[] tempNames = new String[studentIdAr.length - 1];
        int[] tempPRF = new int[studentIdAr.length - 1];
        int[] tempDB = new int[studentIdAr.length - 1];

        for (int i = 0; i < index; i++) {
            tempID[i] = studentIdAr[i];
            tempNames[i] = studentNames[i];
            tempPRF[i] = PRFmarks[i];
            tempDB[i] = DBMSmarks[i];

        }
        for (int i = index + 1; i < studentIdAr.length; i++) {

            tempID[i - 1] = studentIdAr[i];
            tempNames[i - 1] = studentNames[i];
            tempPRF[i - 1] = PRFmarks[i];
            tempDB[i - 1] = DBMSmarks[i];

        }
        studentIdAr = tempID;
        studentNames = tempNames;
        PRFmarks = tempPRF;
        DBMSmarks = tempDB;

    }

    public static void N6_deleteStudent() {
        header(6);
        check = 'n';
        do {
            System.out.print("Enter Student ID   : ");
            int index = searchStudent(input.next() + input.nextLine());
            if (index >= 0) {

                deleteData(index);

                check = Y_or_n(6);

            } else {
                check = Y_or_n(45);
            }
        } while (check == 'Y' || check == 'y');
    }

    public static boolean areMarksAdded(int index) {


        return (!(PRFmarks[index] == -1 || DBMSmarks[index] == -1));
    }

    public static void N5_update_Marks() {
        header(5);
        check = 'n';
        do {
            System.out.print("Enter Student ID   : ");
            int index = searchStudent(input.next() + input.nextLine());
            if (index >= 0) {
                System.out.println("Enter Student Name : " + studentNames[index]);
                System.out.println();

                if (areMarksAdded(index)) {

                    // "enter new " option should be there
                    // overload the addingm2index method or parameterise it

                    System.out.println("Programming Fundamentals Marks   : " + PRFmarks[index]);
                    System.out.println("Database Management System Marks : " + DBMSmarks[index]);
                    System.out.println();
                    addingMarksToIndex(index , true);
                    check = Y_or_n(5);

                } else {
                    check = Y_or_n(55);
                }

                /*
                 * System.out.print("Enter the new student name : ");
                 * studentNames[index] = sc.next() + sc.nextLine();
                 */

                // check = Y_or_n(4);

            } else {
                check = Y_or_n(45);
            }
        } while (check == 'Y' || check == 'y');

    }

    public static void N4_updateStudentDetails() {
        header(4);
        check = 'n';
        do {
            System.out.print("Enter Student ID   : ");
            int index = searchStudent(input.next() + input.nextLine());
            if (index >= 0) {
                System.out.println("Enter Student Name : " + studentNames[index]);
                System.out.println();

                System.out.print("Enter the new student name : ");
                studentNames[index] = input.next() + input.nextLine();

                check = Y_or_n(4);

            } else {
                check = Y_or_n(45);
            }
        } while (check == 'Y' || check == 'y');
    }

    public static int searchStudent(String sID) {
        for (int i = 0; i < studentIdAr.length; i++) {
            if (studentIdAr[i].equals(sID)) {

                // addingMarksToIndex(i);
                return i;
            }
        }
        return -1;
    }

    public static void addingMarksToIndex(int i , boolean b) {
        String st = b? "Enter new " : "" ;
        int mark;
        do {
            System.out.print(st+"Programming Fundamentals Marks   : ");
            mark = input.nextInt();
        } while (!marksValidity(mark));

        PRFmarks[i] = mark;

        do {
            System.out.print(st+"Database Management System Marks : ");
            mark = input.nextInt();
        } while (!marksValidity(mark));

        DBMSmarks[i] = mark;

    }

    public static void N3_addMarks() {
        header(3);
        check = 'n';
        do {
            System.out.print("Enter Student ID   : ");
            int index = searchStudent(input.next() + input.nextLine());
            if (index >= 0) {
                System.out.println("Enter Student Name : " + studentNames[index]);
                System.out.println();
                if (areMarksAdded(index)) {
                    System.out.println("This student's marks have been already added.");
                    System.out.println("If you wanna update marks, please use [5] Update Marks option.");
                } else {
                    addingMarksToIndex(index, false);
                }

                check = Y_or_n(3);

            } else {
                check = Y_or_n(45);
            }
        } while (check == 'Y' || check == 'y');
    }

    public static void setMarks(int PFDmark, int DBmark) {
        int temp1[] = new int[PRFmarks.length + 1];
        int temp2[] = new int[PRFmarks.length + 1];

        for (int i = 0; i < PRFmarks.length; i++) {
            temp1[i] = PRFmarks[i];
            temp2[i] = DBMSmarks[i];
        }
        temp1[temp1.length - 1] = PFDmark;
        temp2[temp2.length - 1] = DBmark;

        PRFmarks = temp1;
        DBMSmarks = temp2;
    }

    public static boolean marksValidity(int marks) {
        if (marks > -1 && marks < 101) {
            return true;
        } else {
            System.out.println("Invalid marks. Please enter correct marks.");
            System.out.println();
            return false;
        }
    }

    public static void storeName(String name) {
        String[] temp = new String[studentNames.length + 1];
        for (int i = 0; i < studentNames.length; i++) {
            temp[i] = studentNames[i];
        }
        temp[temp.length - 1] = name;
        studentNames = temp;
    }

    public static boolean checkForDuplicatesIn_studentIdAr(String st) {
        for (int i = 0; i < studentIdAr.length; i++) {
            if (studentIdAr[i].equals(st)) {
                return false;
            }
        }
        return true;
    }

    public static boolean setValue(String st) {

        if (checkForDuplicatesIn_studentIdAr(st)) {
            String[] temp = new String[studentIdAr.length + 1];
            for (int i = 0; i < studentIdAr.length; i++) {
                temp[i] = studentIdAr[i];
            }
            temp[studentIdAr.length] = st;
            studentIdAr = temp;

            return false;
            // has to be stored in an array
        } else {
            // System.out.println("Student ID already exists");
            return true;
        }
    }

    public static void addMarks() {
        int PRFmark;
        int DBMSmark;

        do {
            System.out.print("Programming Fundamentals Marks   : ");
            PRFmark = input.nextInt();
        } while (!marksValidity(PRFmark));

        // setMarks(marks, PRFmarks);

        do {
            System.out.print("Database Management System Marks : ");
            DBMSmark = input.nextInt();
        } while (!marksValidity(DBMSmark));

        setMarks(PRFmark, DBMSmark);

    }

    public static void N2_addNewStudentWithMarks() {

        header(2);

        check = 'Y';
        do {
            do {
                addStudentDetails();

            } while (shouldContinue);

            addMarks();
            check = Y_or_n(2);

        } while (check == 'Y' || check == 'y');
    }

    public static boolean addStudentDetails() {
        shouldContinue = false;

        System.out.print("Enter Student ID   : ");
        // String tempStudentID = sc.next()+ sc.nextLine();

        if (setValue(input.next() + input.nextLine())) {
            System.out.println("The Student ID already exists");
            System.out.println();
            shouldContinue = true;

        } else {
            System.out.print("Enter Student Name : ");
            storeName(input.next() + input.nextLine());

            System.out.println();

        }
        return shouldContinue;

    }

    public static void N1_addNewStudent() {
        header(1);

        check = 'Y';
        while (check == 'Y' || check == 'y') {
            do {
                addStudentDetails();

            } while (shouldContinue);

            setMarks(-1, -1);

            check = Y_or_n(1);
        }


    }

    public static void homeScreen() {
        clearConsole();
        header(0);

        System.out.println("[1]  Add New Student" + "\t\t\t\t\t\t" + "[2]  Add New Student With Marks");
        System.out.println("[3]  Add Marks" + "\t\t\t\t\t\t\t" + "[4]  Update Student Details");
        System.out.println("[5]  Update Marks" + "\t\t\t\t\t\t" + "[6]  Delete Student ");
        System.out.println("[7]  Print Student Details" + "\t\t\t\t\t" + "[8]  Print Student Ranks");
        System.out.println(
                "[9]  Best in Progamming Fundamentals" + "\t\t\t\t" + "[10] Best in Database Management System");
        System.out.println();


        System.out.print("Enter an option to continue > ");
    }

    public static void main(String[] args) {

        for (;;) {
            homeScreen();
            int fieldChoose = input.nextInt();
            clearConsole();

            switch (fieldChoose) {
                case 1:
                    N1_addNewStudent();
                    break;

                case 2:
                    N2_addNewStudentWithMarks();
                    break;

                case 3:
                    N3_addMarks();
                    break;

                case 4:
                    N4_updateStudentDetails();
                    break;

                case 5:
                    N5_update_Marks();
                    break;

                case 6:
                    N6_deleteStudent();
                    break;

                case 7:
                    N7_printStudentDetails();
                    break;

                case 8:
                    N8_printStudentRanks();
                    break;

                case 9:
                    N9_bestInPRF();
                    break;

                case 10:
                    N10_bestInDB();
                    break;



            }
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}