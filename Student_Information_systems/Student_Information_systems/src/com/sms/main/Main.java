package com.sms.main;

import java.util.Scanner;

import com.sms.entities.*;

public class MainClass {

    int r;

    public static void main(String[] args) {
        int idCount = 1, i, idParticulars, choice, max = 0, maxCourse;
        Boolean value = false;
        Scanner scanInput = new Scanner(System.in);
        StudentStructure[] student = new StudentStructure[10];
        while (true) {
            try {
                System.out.println("choose your option:");
                System.out.println("1:Add new Student\n2:Delete\n3:Modify Details\n4:View All\n5:View Specific\n6:Exit");
                choice = Integer.parseInt(scanInput.nextLine());
                switch (choice) {

                    case 1:

                        StudentStructure studentTemp = new StudentStructure();                    //assigning the values by input
                        try {
                            studentTemp.id = idCount++;
                            System.out.println("Enter the name of Student " + (max + 1));
                            studentTemp.name = String.valueOf(scanInput.nextLine());
                            System.out.println("Enter the address of Student " + (max + 1));
                            studentTemp.address = scanInput.nextLine();
                            System.out.println("Enter the class of Student " + (max + 1));
                            studentTemp.section = scanInput.nextLine();
                            System.out.println("Enter the  age Student " + (max + 1));
                            studentTemp.age = Integer.parseInt(scanInput.nextLine());
                            System.out.println("Enter the Number of courses of Student " + (max + 1));
                            maxCourse = Integer.parseInt(scanInput.nextLine());
                            studentTemp.numCourses = maxCourse;
                            studentTemp.course = new Subject[maxCourse];
                            //input for number of courses

                            for (i = 0; i < maxCourse; i++) {
                                try {
                                    studentTemp.course[i] = new Subject();
                                    System.out.println("Enter the name of " + (i + 1) + " course of Student " + (max + 1));
                                    studentTemp.course[i].name = scanInput.nextLine();
                                    System.out.println("Enter the id of " + (i + 1) + " course of Student " + (max + 1));
                                    studentTemp.course[i].courseId = scanInput.nextLine();
                                    System.out.println("Enter the Credits of " + (i + 1) + " course of Student " + (max + 1));
                                    studentTemp.course[i].credits = Integer.parseInt(scanInput.nextLine());
                                } catch (NumberFormatException exp) {
                                    System.out.println("Entred Incorrect Value");
                                    i--;
                                }
                            }

                            student[max] = studentTemp;
                            max++;
                        } catch (NumberFormatException exp) {
                            idCount--;
                            System.out.println("Entred Incorrect Value");

                        }

                        break;
                    //for deleting the user // just shifting the next student data to previous one and leaving the last
                    case 2:
                        System.out.println("Enter the id of the Student");
                        try {
                            idParticulars = Integer.parseInt(scanInput.nextLine());
                            if (idParticulars < idCount) {
                                for (i = 0; i < max; i++) {
                                    if (student[i].id == idParticulars) {
                                        value = true;
                                        break;
                                    }

                                }
                                if (value) {
                                    try {
                                        for (int j = i; j < max; j++) {
                                            student[j] = student[j + 1];
                                        }
                                        max--;
                                        System.out.println("Student Removed");
                                        value = false;
                                    } catch (NumberFormatException exp) {
                                        System.out.println(exp);
                                    }
                                } else {
                                    System.out.println("Student Not present");
                                }

                            } else {
                                System.out.println("Invalid id");
                            }

                        } catch (NumberFormatException exp) {
                            System.out.println("Enter correct ID Format");
                        }

                        break;

                    //modify one student
                    case 3:

                        try {
                            System.out.println("enter Student's ID");

                            idParticulars = Integer.parseInt(scanInput.nextLine());
                            if (idParticulars < idCount) {
                                for (i = 0; i < max; i++) {
                                    if (student[i].id == idParticulars) {
                                        value = true;
                                        break;
                                    }
                                }
                                if (value) {
                                    try {
                                        System.out.println("choose what to Modify:");
                                        System.out.println("1:Name\n2:Class\n3:Address\n4:Age\n5:Cancel");
                                        choice = Integer.parseInt(scanInput.nextLine());
                                        switch (choice) {
                                            case 1:
                                                System.out.println("Enter the Name");
                                                student[i].name = scanInput.nextLine();
                                                break;
                                            case 2:
                                                System.out.println("Enter the Class");
                                                student[i].section = scanInput.nextLine();
                                                break;
                                            case 3:
                                                System.out.println("Enter the Address");
                                                student[i].address = scanInput.nextLine();
                                                break;
                                            case 4:
                                                System.out.println("Enter the Age");
                                                student[i].age = Integer.parseInt(scanInput.nextLine());
                                                break;
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Choose valid option");
                                        }
                                        value = false;
                                    } catch (NumberFormatException exp) {
                                        System.out.println(exp);
                                    }
                                } else {
                                    System.out.println("Student ID not found");
                                }

                            } else {
                                System.out.println("Invalid id");
                            }

                        } catch (NumberFormatException exp) {
                            System.out.println("You Entered an incorrect id format");
                        }

                        break;
                    //show details for all

                    case 4:
                        if (max>0) {
                            System.out.println("ID" + "\t" + "Name" );
                            for (i = 0; i < max; i++) {
                                System.out.print(student[i].id + "\t" + student[i].name );
                                 System.out.println("");
                            }
                        } else {
                            System.out.println("Record Empty");
                        }

                        break;
                    case 5://view specific

                        try {
                            System.out.println("enter Student's ID");

                            idParticulars = Integer.parseInt(scanInput.nextLine());
                            if (idParticulars < idCount) {

                                for (i = 0; i < max; i++) {
                                    if (student[i].id == idParticulars) {
                                        value = true;
                                        break;
                                    }
                                }

                                if (value) {
                                    System.out.println("ID" + "\t" + "Name" + "\t" + "Class" + "\t" + "Address " + "\t" + " Age" + "\t" + " Courses");
                                    System.out.print(student[i].id + "\t" + student[i].name + "\t" + student[i].section + "\t" + student[i].address + "\t" + student[i].age + "\t");

                                    if(student[i].numCourses>0)
                                    {
                                    for (int j = 0; j < student[i].numCourses; j++) {
                                        System.out.print("("+student[i].course[j].courseId+","+student[i].course[j].name+","+student[i].course[j].credits+")");
                                    }}
                                    else
                                        System.out.print("No Courses alloted");
                                    System.out.println();
                                    value = false;
                                }
                            } else {
                                System.out.println("Invalid id");
                            }
                        } catch (NumberFormatException exp) {
                            System.out.println("Enter correct id");
                        }
                        break;

                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choose valid option");
                }
            } catch (NumberFormatException exp) {
                System.out.println(exp);
            }
        }

    }

}
