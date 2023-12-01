import java.util.Scanner;

class Example {
    public static String[] idArray = new String[0];
    public static String[] nameArray =new String[0];
    public static int[] programmingFundamentalMarksArray = new int[idArray.length];
    public static int[] dbmsMarksArray = new int[idArray.length];
    public static int[] totalArray = new int[0];
    public static double[] avgArray = new double[0];
    public static int[] rankArray = new int[0];


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

    //----------------------------Home--------------------------------------------------

    public static void home() {

        clearConsole();

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("[1] Add New Student\t\t\t\t\t");
        System.out.println("[2] Add New Student With Marks");
        System.out.print("[3] Add Marks\t\t\t\t\t\t");
        System.out.println("[4] Update Student Details");
        System.out.print("[5] Update Students' Marks\t\t\t\t");
        System.out.println("[6] Delete Student");
        System.out.print("[7] Print Student Details\t\t\t\t");
        System.out.println("[8] Print Students' Ranks");
        System.out.print("[9] Best in Programming Fundamentals\t\t\t");
        System.out.println("[10] Best in Database Management Systems");
        System.out.println();



        Scanner scanner = new Scanner(System.in);

        boolean isValid = true;
        do{
            System.out.print("Enter an Option to Continue > ");
            String option = scanner.next();

            if (option.equals("1")) {
                clearConsole();
                addNewStudent();
            } else if (option.equals("2")) {
                clearConsole();
                addNewStudentWithMarks();
            } else if (option.equals("3")) {
                clearConsole();
                addMarks();
            } else if (option.equals("4")) {
                clearConsole();
                updateStudentDetails();
            } else if (option.equals("5")) {
                clearConsole();
                updateStudentMarks();
            } else if (option.equals("6")) {
                clearConsole();
                deleteStudent();
            } else if (option.equals("7")){
                clearConsole();
                printStudentDetails();
            } else if (option.equals("8")){
                clearConsole();
                printStudentsRank();
            } else if (option.equals("9")){
                clearConsole();
                bestInProgrammingFundamentals();
            } else if (option.equals("10")){
                clearConsole();
                bestInDBMS();
            } else{
                System.out.println("Invalid Input");
                isValid = false;
            }
        }while(!isValid);

    }

    //----------------------------Home--------------------------------------------------
    //---------------------------Add new student------------------------------------------
    public static void addNewStudent() {

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        String option;
        String id;
        boolean updateAgain = false;
        do {
            boolean isExist = false;
            do {
                System.out.println();
                System.out.print("Enter Student ID : ");
                id = input.next();

                for (int i = 0; i < idArray.length; i++) {
                    if (idArray[i].equals(id)) {
                        isExist = true;
                        System.out.println("The Student ID already exists");
                        System.out.println();
                        break;
                    } else {
                        isExist = false;
                    }
                }
            } while (isExist);
            System.out.print("Enter Student Name : ");
            String name = input.next();

            String[] tempId = new String[idArray.length + 1];
            String[] tempName = new String[nameArray.length + 1];
            int[] tempPfMarks = new int[idArray.length + 1];
            int[] tempDbmsMarks = new int[idArray.length + 1];

            for (int i = 0; i < idArray.length; i++) {
                tempId[i] = idArray[i];
                tempName[i] = nameArray[i];
                tempPfMarks[i] = programmingFundamentalMarksArray[i];
                tempDbmsMarks[i] = dbmsMarksArray[i];
            }
            tempId[tempId.length - 1] = id;
            tempName[tempName.length - 1] = name;
            tempPfMarks[tempPfMarks.length - 1] = -1;
            tempDbmsMarks[tempDbmsMarks.length - 1] = -1;


            idArray = tempId;
            nameArray = tempName;
            programmingFundamentalMarksArray = tempPfMarks;
            dbmsMarksArray = tempDbmsMarks;



            boolean isValid = true;
            do{
                System.out.print("Student has been added successfully. Do you want to add a new student (y/n) : ");
                option = input.next();
                if (option.equals("y")) {
                    updateAgain = true;
                }else if(option.equals("n")){
                    home();
                }else{
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);

        } while (updateAgain);


    }
    //---------------------------Add new student------------------------------------------

    //----------------------------get marks method----------------------------------------------

    public static int setMarks(boolean isValid, Scanner object) {
        int marks = -1;
        if (isValid) {
            int input = object.nextInt();
            if (input >= 0 && input <= 100) {
                marks = input;
            } else {
                System.out.println("Invalid marks, please enter correct marks.");
                System.out.println();
            }
        }
        return marks;
    }

    //----------------------------get marks method----------------------------------------------

    //----------------------------Check marks method--------------------------------------------

    public static boolean checkMarks(Scanner object){
        boolean isValid;
            if (object.hasNextInt()){
                isValid = true;
                
            }else{
                System.out.println("Invalid Input, please enter a number");
                System.out.println();
                isValid = false;
                object.next();
            }
        return isValid;        
    }
    //----------------------------Check marks method--------------------------------------------


    //---------------------------Add new student with marks--------------------------------
    public static void addNewStudentWithMarks() {

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        String option;
        String id;
        boolean updateAgain = false;
        do {
            boolean isExist = false;
            do {
                System.out.println();
                System.out.print("Enter Student ID : ");
                id = input.next();

                for (int i = 0; i < idArray.length; i++) {
                    if (idArray[i].equals(id)) {
                        isExist = true;
                        System.out.println("The Student ID already exists");
                        break;
                    } else {
                        isExist = false;
                    }
                }
            } while (isExist);
            System.out.print("Enter Student Name : ");
            String name = input.next();

            int pfMarks;
            boolean isValid;
           do {
                isValid = true;
                System.out.print("Programming Fundamentals Marks: ");
                isValid = checkMarks(input);
                pfMarks = setMarks(isValid, input);
            } while (!isValid || pfMarks > 100 || pfMarks < 0);

            int dbmsMarks;
            do {
                isValid = true;
                System.out.print("Database Management System Marks: ");
                isValid = checkMarks(input);
                dbmsMarks = setMarks(isValid, input); 
            } while (!isValid || dbmsMarks > 100 || dbmsMarks < 0);

            String[] tempId = new String[idArray.length + 1];
            String[] tempName = new String[nameArray.length + 1];
            int[] tempPfMarks = new int[idArray.length + 1];
            int[] tempDbmsMarks = new int[idArray.length + 1];

            for (int i = 0; i < idArray.length; i++) {
                tempId[i] = idArray[i];
                tempName[i] = nameArray[i];
                tempPfMarks[i] = programmingFundamentalMarksArray[i];
                tempDbmsMarks[i] = dbmsMarksArray[i];
            }
            tempId[tempId.length - 1] = id;
            tempName[tempName.length - 1] = name;
            tempPfMarks[tempId.length - 1] = pfMarks;
            tempDbmsMarks[tempId.length - 1] = dbmsMarks;

            idArray = tempId;
            nameArray = tempName;
            programmingFundamentalMarksArray = tempPfMarks;
            dbmsMarksArray = tempDbmsMarks;


            do{
                isValid = true;
                System.out.println();
                System.out.print("Student has been added successfully. Do you want to add a new student (y/n) : ");
                option = input.next();
                if (option.equals("y")) {
                    updateAgain = true;
                }else if(option.equals("n")){
                    home();
                }else{
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);


        } while (updateAgain);


    }


    //---------------------------Add new student with marks--------------------------------

    //---------------------------Add Marks------------------------------------------------------

    public static void addMarks() {

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tADD MARKS\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        String id;
        int index = 0;
        String option;

        boolean addAnother = false;
        do {


            //--------------search whether marks have been already added-------------------------------------
            boolean isValid;
            do {
                boolean isExist = false;
                boolean searchAgain = false;
                do {
                    System.out.println();
                    System.out.print("Enter Student ID : ");
                    id = input.next();

                    for (int i = 0; i < idArray.length; i++) {
                        if (id.equals(idArray[i])) {
                            isExist = true;
                            index = i;
                        }
                    }
                    if (isExist) {
                        searchAgain = false;
                    } else {
                        do{
                            isValid = true;
                            System.out.print("Invalid Student ID. Do you want to search again (y/n) : ");
                            option = input.next();
                            if (option.equals("y"))
                                searchAgain = true;
                            else if (option.equals("n"))
                                home();
                            else {
                                System.out.println("Invalid Input. Enter y/n");
                                isValid = false;
                            }
                        }while(!isValid);
                    }
                } while (searchAgain);

                System.out.println("Student Name : " + nameArray[index]);
                System.out.println();

                if (programmingFundamentalMarksArray[index] == -1) {
                    addAnother = false;
                } else {
                    System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [4] UPDATE MARKS option.");
                    System.out.println();
                    do{
                        isValid = true;
                        System.out.print("Do you want to add marks for another student? (y/n) : ");
                        option = input.next();
                        if (option.equals("y")) {
                            addAnother = true;
                        } else if(option.equals("n")){
                            home();
                        } else {
                            System.out.println("Invalid Input. Enter y/n");
                            isValid = false;
                        }
                    }while(!isValid);
                }
            } while (addAnother);

            int pfMarks;
            do {
                isValid = true;
                System.out.print("Programming Fundamentals Marks: ");
                isValid = checkMarks(input);
                pfMarks = setMarks(isValid, input);
            } while (!isValid || pfMarks > 100 || pfMarks < 0);

            int dbmsMarks;
            do {
                isValid = true;
                System.out.print("Database Management System Marks: ");
                isValid = checkMarks(input);
                dbmsMarks = setMarks(isValid, input); 
            } while (!isValid || dbmsMarks > 100 || dbmsMarks < 0);

            //-----enter marks into array starts----------------------

            programmingFundamentalMarksArray[index] = pfMarks;
            dbmsMarksArray[index] = dbmsMarks;

            //-----enter marks into array ends------------------------

            do{
                isValid = true;
                System.out.println();
                System.out.print("Marks have been added. Do you want to add marks for another student (y/n) : ");
                option = input.next();
                if(option.equals("y")){
                    addAnother = true;
                } else if (option.equals("n")){
                    home();
                } else {
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);
            System.out.println();
        } while (addAnother);


    }

    //---------------------------Add Marks------------------------------------------------------

//-------------------------------Update student detais------------------------------------------------------------

    public static void updateStudentDetails() {

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tUPDATE STUDENTS' DETAILS\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");


        Scanner input = new Scanner(System.in);

        String option;
        boolean searchAgain;
        do {
            searchAgain = false;
            boolean isExists = false;
            boolean isValid;
            int index = 0;
            do {
                System.out.println();
                System.out.print("Enter Student ID : ");
                String id = input.next();

                for (int i = 0; i < idArray.length; i++) {
                    if (id.equals(idArray[i])) {
                        isExists = true;
                        index = i;
                        break;
                    }
                }
                if (isExists) {
                    searchAgain = false;
                } else {
                    do{
                        isValid = true;
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                        option = input.next();
                        if (option.equals("y")) {
                            searchAgain = true;
                        } else if (option.equals("n")){
                            home();
                        } else {
                            System.out.println("Invalid Input. Enter y/n");
                            isValid = false;
                        }
                    }while(!isValid);
                }
            } while (searchAgain);

            System.out.println("Student Name : " + nameArray[index]);
            System.out.println();
            System.out.print("Enter the new student name : ");
            String name = input.next();

            nameArray[index] = name;

            do{
                isValid = true;
                System.out.println();
                System.out.print("Student details has been updated successfully.\nDo you want to update another student details? (y/n) : ");
                option = input.next();

                if (option.equals("y")) {
                    searchAgain = true;
                } else if (option.equals("n")){
                    home();
                } else {
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);
            System.out.println();
        } while (searchAgain);



    }

    //-------------------------------Update student details------------------------------------------------------------

    //-------------------------------Update student marks--------------------------------------------------------

    public static void updateStudentMarks() {

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tUPDATE STUDENTS' MARKS\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        String option;
        boolean updateAgain = false;
        do {
            int index = 0;
            boolean anotherStudent;
            boolean isValid;
            do {
                anotherStudent = false;
                boolean isExists = false;
                boolean searchAgain = false;
                do {
                    System.out.println();
                    System.out.print("Enter Student ID : ");
                    String id = input.next();

                    for (int i = 0; i < idArray.length; i++) {
                        if (id.equals(idArray[i])) {
                            isExists = true;
                            index = i;
                            break;
                        }
                    }
                    if (isExists) {
                        searchAgain = false;
                    } else {
                        do{
                            isValid = true;
                            System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                            option = input.next();
                            if (option.equals("y")) {
                                searchAgain = true;
                            } else if(option.equals("n")){
                                home();
                            } else {
                                System.out.println("Invalid Input. Enter y/n");
                                isValid = false;
                            }
                        }while(!isValid);
                    }
                } while (searchAgain);

                System.out.println("Student Name : " + nameArray[index]);
                System.out.println();
                if (programmingFundamentalMarksArray[index] == -1 && dbmsMarksArray[index] == -1) {

                    do{
                        isValid = true;
                        System.out.print("This student's marks yet to be added. Do you want to update marks of another student? (y/n) : ");
                        option = input.next();
                        if (option.equals("y"))
                            anotherStudent = true;
                        else if(option.equals("n"))
                            home();
                        else{
                            System.out.println("Invalid Input. Enter y/n");
                            isValid = false;
                        }
                    }while(!isValid);
                }
            } while (anotherStudent);

            System.out.println("Programming Fundamental Marks : " + programmingFundamentalMarksArray[index]);
            System.out.println("Database Management Systems Marks : " + dbmsMarksArray[index]);
            System.out.println();

            
            int pfMarks;
            do {
                isValid = true;
                System.out.print("Enter new Programming Fundamental Marks : ");
                isValid = checkMarks(input);
                pfMarks = setMarks(isValid, input);
                programmingFundamentalMarksArray[index] = pfMarks;
            } while (!isValid || pfMarks > 100 || pfMarks < 0);

            int dbmsMarks;
            do {
                isValid = true;
                System.out.print("Enter new Database Management System Marks : ");
                isValid = checkMarks(input);
                dbmsMarks = setMarks(isValid, input);
                dbmsMarksArray[index] = dbmsMarks;
            } while (!isValid || dbmsMarks > 100 || dbmsMarks < 0);

            System.out.println();
            do{
                isValid = true;
                System.out.print("Marks have been updated successfully.\nDo you want to update marks for another student? (y/n) : ");
                option = input.next();
                if (option.equals("y")) {
                    updateAgain = true;
                }else if(option.equals("n")){
                    home();
                }else{
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);
        } while (updateAgain);

    }

    //-------------------------------Update student marks--------------------------------------------------------

    //----------------------------------delete method----------------------------------------------------

    public static int[] delete(int[] arr,int index){

        int[] tempArr = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            tempArr[i] = arr[i];
        }
        for (int i = index; i < arr.length - 1; i++) {
            tempArr[i] = arr[i + 1];
        }
        return tempArr;

    }


    public static String[] delete(String[] arr,int index){

        String[] tempArr = new String[arr.length - 1];

        for (int i = 0; i < index; i++) {
            tempArr[i] = arr[i];
        }
        for (int i = index; i < arr.length - 1; i++) {
            tempArr[i] = arr[i + 1];
        }
        return tempArr;

    }

    //----------------------------------delete method----------------------------------------------------

    //--------------------------------Delete student-------------------------------------------------------------

    public static void deleteStudent() {

        System.out.println("-----------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tDELETE STUDENT\t\t\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);
        String option;
        boolean deleteAnother;

        do {
            deleteAnother = false;
            boolean isExists = false;
            boolean searchAgain = false;
            boolean isValid;
            int index = 0;
            do {
                System.out.println();
                System.out.print("Enter Student ID : ");
                String id = input.next();

                for (int i = 0; i < idArray.length; i++) {
                    if (id.equals(idArray[i])) {
                        isExists = true;
                        index = i;
                        break;
                    }
                }
                if (isExists) {
                    searchAgain = false;
                } else {
                    do{
                        isValid = true;
                        System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                        option = input.next();
                        if (option.equals("y")) {
                            searchAgain = true;
                        }else if(option.equals("n")){
                            home();
                        }else {
                            System.out.println("Invalid input. Enter y/n");
                            isValid = false;
                        }
                    } while (!isValid);
                }
            } while (searchAgain);

            idArray = delete(idArray,index);
            nameArray = delete(nameArray,index);
            programmingFundamentalMarksArray = delete(programmingFundamentalMarksArray,index);
            dbmsMarksArray = delete(dbmsMarksArray,index);


            do{
                isValid = true;
                System.out.print("Student has been deleted successfully.\nDo you want to delete another student? (y/n) : ");
                option = input.next();
                if (option.equals("y")) {
                    deleteAnother = true;
                }else if(option.equals("n")){
                    home();
                }else{
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);
        } while (deleteAnother);


    }

    //--------------------------------Delete student-------------------------------------------------------------

    //--------------------------------find total---------------------------------------------------------------

    public static void findTotal() {

        int[] modPfmArray = modifyArrays(programmingFundamentalMarksArray);
        int[] modDbmsArray = modifyArrays(dbmsMarksArray);

        totalArray = new int[modPfmArray.length];
        for(int i = 0; i < modPfmArray.length; i++){
            totalArray[i] = modPfmArray[i] + modDbmsArray[i];
        }

    }

    //--------------------------------find total---------------------------------------------------------------

    //-------------------------------find avarage-----------------------------------------------------------------

    public static void findAverage() {
        double[] tempAvg = new double[totalArray.length];
        for (int i = 0; i < totalArray.length; i++) {
            tempAvg[i] = totalArray[i] / 2.0;
        }
        avgArray = tempAvg;
    }

    //-------------------------------find avarage-----------------------------------------------------------------

    //----------------------------------find rank---------------------------------------------------------

    public static void findRank() {

        double[] sortAvg = new double[avgArray.length];
        int index;

        for (int i = 0; i < avgArray.length; i++) {
            sortAvg[i] = avgArray[i];
        }

        for (int j = sortAvg.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (sortAvg[i] > sortAvg[i + 1]) {
                    double t = sortAvg[i];
                    sortAvg[i] = sortAvg[i + 1];
                    sortAvg[i + 1] = t;
                }
            }
        }



        int[] tempRank = new int[avgArray.length];

        for (int i = 0; i < sortAvg.length; i++) {
            for (int j = 0; j < avgArray.length; j++) {
                if (sortAvg[i] != avgArray[j]) {
                    continue;
                } else {
                    index = j;
                    tempRank[index] = avgArray.length - i;
                    rankArray = tempRank;
                }
            }
        }

    }

    //----------------------------------find rank---------------------------------------------------------

    //----------------------------------print student-------------------------------------------------------

    public static void printStudentDetails(){

        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tPRINT STUDENTS' DETAILS\t\t\t\t\t\t\t|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        String option;
        boolean updateAgain = false;
        do{
            int index = 0;
            boolean anotherStudent = false;
            boolean isValid;
            do{

                boolean isExists = false;
                boolean searchAgain = false;
                do{
                    System.out.println();
                    System.out.print("Enter Student ID : ");
                    String id = input.next();

                    for(int i = 0; i < idArray.length; i++){
                        if(id.equals(idArray[i])){
                            isExists = true;
                            index = i;
                            break;
                        }
                    }
                    if(isExists){
                        searchAgain = false;
                    }else{
                        do{
                            isValid = true;
                            System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                            option = input.next();
                            if(option.equals("y")){
                                searchAgain = true;
                            }else if (option.equals("n")){
                                home();
                            } else {
                                System.out.println("Invalid Input. Enter y/n");
                                isValid = false;
                            }
                        } while (!isValid);
                    }
                }while(searchAgain);

                System.out.println("Student Name : " + nameArray[index]);
                System.out.println();
                if(programmingFundamentalMarksArray[index] == -1 && dbmsMarksArray[index] == -1){
                    do{
                        isValid = true;
                        System.out.print("This student's marks yet to be added.\nDo you want to search another student? (y/n) : ");
                        option = input.next();
                        if(option.equals("y"))
                            anotherStudent = true;
                        else if(option.equals("n"))
                            home();
                        else{
                            System.out.println("Invalid Input.");
                            isValid = false;
                        }
                    } while (!isValid);
                }else{
                    anotherStudent = false;
                }
            }while(anotherStudent);

            //print student
            System.out.println("+---------------------------------------+-------------------------------+");
            System.out.println("|Programming Fundamentals Marks\t\t|" + "\t\t" + programmingFundamentalMarksArray[index] + "\t\t|");
            System.out.println("|Database Management System Marks\t|" + "\t\t" + dbmsMarksArray[index] + "\t\t|");
            findTotal();

            int newIndex = -1;
            for(int i = 0; i < index + 1; i++){
                if(programmingFundamentalMarksArray[i] == -1){
                    continue;
                }else{
                    newIndex += 1;
                }
            }

            System.out.println("|Total Marks\t\t\t\t|" + "\t\t" + totalArray[newIndex] + "\t\t|");
            findAverage();
            System.out.println("|Average Marks\t\t\t\t|" + "\t\t" + avgArray[newIndex] + "\t\t|");
            findRank();

            int max = 0;
            for(int i = 0; i < rankArray.length; i++){
                if(rankArray[i] > max){
                    max = rankArray[i];
                }
            }


            System.out.println("|Rank\t\t\t\t\t|" + "\t\t" + ((rankArray[newIndex] == 1)? "1 (First)\t|" : (rankArray[newIndex] == 2) ? " 2 (Second)\t|" : (rankArray[newIndex] == 3) ? "3 (Third)\t|" : (rankArray[newIndex] == max) ? rankArray[newIndex] + " (Last)\t|" : (rankArray[newIndex]) + "\t|\t"));
            System.out.println("+---------------------------------------+-------------------------------+");


            System.out.println();


            do{
                isValid = true;
                System.out.print("Do you want to search another student details? (y/n) : ");
                option = input.next();
                if(option.equals("y")){
                    updateAgain = true;
                }else if(option.equals("n")){
                    home();
                }else{
                    System.out.println("Invalid Input. Enter y/n");
                    isValid = false;
                }
            }while(!isValid);
        }while(updateAgain);


    }
    //--------------------------------------------Print student details--------------------------------------------------

    //------------------------------------------modify int array method start----------------------------------------------------
    public static int[] modifyArrays(int[] arr){
        int[] modArr = new int[0];
        for(int i = 0; i < arr.length; i++){ //eliminate students without marks
            if(arr[i] != -1){
                int[] tempArr = new int[modArr.length + 1];
                for(int j = 0; j < modArr.length; j++){
                    tempArr[j] = modArr[j];
                }
                tempArr[tempArr.length - 1] = arr[i];


                modArr = tempArr;
            }
        }
        return modArr;
    }
//---------------------------------------------Modify int array method ends----------------------------------------------------

    //------------------------------------------Modify string array method start-----------------------------------------------

    public static String[] modifyArrays(String[] arr){
        String[] modArr = new String[0];
        for(int i = 0; i < arr.length; i++){ //eliminate students without marks
            if(programmingFundamentalMarksArray[i] != -1){
                String[] tempArr = new String[modArr.length + 1];
                for(int j = 0; j < modArr.length; j++){
                    tempArr[j] = modArr[j];
                }
                tempArr[tempArr.length - 1] = arr[i];


                modArr = tempArr;
            }
        }
        return modArr;
    }



    //------------------------------------------Modify string array method start-----------------------------------------------



    //------------------------------------------sort array method-----------------------------------------------------------

    public static int[][] sortArray(int[] arr){
        int[][] sortArr = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            sortArr[i][0] = i;
            sortArr[i][1] = arr[i];
        }

        for(int j = arr.length - 1; j >= 0; j--){
            for(int i = 0; i < j; i++){
                if(sortArr[i][1] < sortArr[i + 1][1]){
                    int[] t = sortArr[i];
                    sortArr[i] = sortArr[i + 1];
                    sortArr[i + 1] = t;
                }
            }
        }
        return sortArr;
    }

    //------------------------------------------sort array method-----------------------------------------------------------

    //--------------------------------------Back to main menu method start----------------------------------------------------

    public static void backToMain(){
        Scanner input = new Scanner(System.in);
        String option;
        boolean goBack;
        do{
            System.out.print("Do you want to go back to main menu? (y/n) : ");
            option = input.next();
            if (option.equals("y")){
                goBack = true;
                clearConsole();
                home();
            }else if(option.equals("n")){
                goBack = false;
            }else{
                goBack = false;
                System.out.println("Invalid Input");
            }
        }while(!goBack);
    }

//--------------------------------------Back to main menu method ends----------------------------------------------------

    //-------------------------------------------Print student rank-----------------------------------------------------

    public static void printStudentsRank(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tPRINT STUDENTS' RANKS\t\t\t\t\t\t\t|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        String[] modIdArray = modifyArrays(idArray);
        String[] modNameArray = modifyArrays(nameArray);



        findTotal();
        findAverage();
        findRank();

        int[][] rankArrCopy = new int[rankArray.length][2];

        for(int i = 0; i < rankArrCopy.length; i++){
            rankArrCopy[i][0] = i;
            rankArrCopy[i][1] = rankArray[i];
        }

    

        for(int j = rankArrCopy.length - 1; j >= 0; j--){
            for(int i = 0; i < j; i++){
                if(rankArrCopy[i][1] > rankArrCopy[i+1][1]){
                    int[] t = rankArrCopy[i];
                    rankArrCopy[i] = rankArrCopy[i+1];
                    rankArrCopy[i+1] = t;
                }
            }
        }

        System.out.println();
        System.out.println("+-------+-------+-----------------------+---------------+---------------+");
        System.out.println("|Rank\t|ID\t|Name\t\t\t|Total Marks\t|Avg. Marks\t|");
        for(int i = 0; i < modIdArray.length; i++){
            System.out.println("|" + rankArrCopy[i][1] + "\t" + "|" + modIdArray[rankArrCopy[i][0]] + "\t" + "|" + modNameArray[rankArrCopy[i][0]] + "\t\t\t" + "|" + totalArray[rankArrCopy[i][0]] + "\t\t|" + avgArray[rankArrCopy[i][0]] + "\t\t|");
        }
        System.out.println("+-------+-------+-----------------------+---------------+---------------+");
        System.out.println();

        backToMain();

    }

    //-------------------------------------------Print student rank-----------------------------------------------------



    //--------------------------------------------Best in Programming Fundamentals----------------------------------------

    public static void bestInProgrammingFundamentals(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t\t\t\t\t|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        String[] modIdArray = modifyArrays(idArray);
        String[] modNameArray = modifyArrays(nameArray);
        int[] modPrfArray = modifyArrays(programmingFundamentalMarksArray);
        int[] modDbmsArray = modifyArrays(dbmsMarksArray);


        int[][] prfSortArr = sortArray(modPrfArray);

        System.out.println("+-------+-------+---------------+---------------+");
        System.out.println("|ID\t|Name\t|PF Marks\t|DBMS Marks\t|");
        for(int i = 0; i < modIdArray.length; i++){
            System.out.println("|" + modIdArray[prfSortArr[i][0]] + "\t|" + modNameArray[prfSortArr[i][0]] + "\t|" + modPrfArray[prfSortArr[i][0]] + "\t\t|" + modDbmsArray[prfSortArr[i][0]] + "\t\t|");
        }
        System.out.println("+-------+-------+---------------+---------------+");
        System.out.println();

        backToMain();

    }

    //--------------------------------------------Best in Programming Fundamentals----------------------------------------
//------------------------------------------------Best in DBMS---------------------------------------------------------

    public static void bestInDBMS(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEMS\t\t\t\t\t\t\t|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        String[] modIdArray = modifyArrays(idArray);
        String[] modNameArray = modifyArrays(nameArray);
        int[] modPrfArray = modifyArrays(programmingFundamentalMarksArray);
        int[] modDbmsArray = modifyArrays(dbmsMarksArray);


        int[][] dbmsSortArr = sortArray(modDbmsArray);



        System.out.println("+-------+-------+---------------+---------------+");
        System.out.println("|ID\t|Name\t|DBMS Marks\t|PF Marks\t|");
        for(int i = 0; i < modIdArray.length; i++){
            System.out.println("|" + modIdArray[dbmsSortArr[i][0]] + "\t|" + modNameArray[dbmsSortArr[i][0]] + "\t|" + modDbmsArray[dbmsSortArr[i][0]] + "\t\t|" + modPrfArray[dbmsSortArr[i][0]] + "\t\t|");
        }
        System.out.println("+-------+-------+---------------+---------------+");

        backToMain();

    }

    //------------------------------------------------Best in DBMS---------------------------------------------------------
    public static void main(String args[]) {

        home();

    }
}