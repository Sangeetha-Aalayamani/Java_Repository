package com.sms.main;

import java.util.Scanner;
import com.sms.enitities.Student;
import com.sms.enitities.Course;
import com.sms.util.Constants;

public class Main implements Constants
{
   public static int rollno = 1;       
   public static void main(String[] args)
   {
      Scanner obj = new Scanner(System.in);
      int choice , ch = 0, count = 0, j, found = 0;
      int modifyRoll,printRoll,delRoll;
      Student studentObj[] = new Student[20];
      try
      {
        System.out.println("----------------MENU DRIVEN PROGRAM---------------");
        while (ch == 0) 
        {
            System.out.println("1. Add Student details");
            System.out.println("2. Delete Student details");
            System.out.println("3. Modify student details");
            System.out.println("4. Print all Students details");
            System.out.println("5. Print specific Student details");
            System.out.println("6. exit");
            choice = obj.nextInt();
            switch(choice) 
            {
                
                case ADD :
                    if (count > 20) 
                    {
                        System.out.print("MEMORY FULL ");
                    } 
                    else
                    {                       
                        obj.nextLine();
                        studentObj[count] = new Student();
                        System.out.println("enter");
                        studentObj[count].rollNo = rollno++;
                        System.out.print("Student's Name : ");
                        studentObj[count].studentName = obj.nextLine();
                        System.out.print("Student's Branch : ");
                        studentObj[count].branch = obj.nextLine();
                        System.out.print("Student's Percentage : ");
                        studentObj[count].percent = obj.nextInt();
                        System.out.println(" Number of courses : ");
                        studentObj[count].numCourses=obj.nextInt();
                        studentObj[count].courseId = 1;
                        obj.nextLine();
                        for(j=0;j<studentObj[count].numCourses;j++)
                        {
                            studentObj[count].courseObj[j]= new Course();
                            studentObj[count].courseObj[j].courseId=studentObj[count].courseId++;
                            System.out.print("Name of course : ");
                            studentObj[count].courseObj[j].name=obj.nextLine();
                            System.out.print("Description of course : ");
                            studentObj[count].courseObj[j].description=obj.nextLine();
                        }        
                        count++;
                    }
                    break;
                
                
                case DELETE :
                    System.out.print("Student's Roll Numbers are \n");
                    for(j = 0 ; j < count ; j++)
                    {
                        System.out.print(studentObj[j].rollNo+"-"+studentObj[j].studentName+"\n");
                    }
                    obj.nextLine();                  
                    System.out.print("Enter Student's Roll no. you want to delete : ");
                    delRoll = obj.nextInt();
                    if (delRoll == studentObj[count-1].rollNo)
                    {
                        count--;
                    } 
                    else 
                    {
                        for (j= 0; j < count; j++) 
                        {
                            if (delRoll == studentObj[j].rollNo) 
                            {
                                found = j;
                            }
                        }
                        for (j= found;j< count - 1; j++) 
                        {
                            studentObj[j] = studentObj[j+ 1];
                        }
                        count--;
                    }
                    System.out.println("Deleted successfully.");
                    break;
                
                
                case MODIFY :
                    obj.nextLine();
                    System.out.print("Student's Roll Numbers are \n");
                    for(j = 0 ; j < count ; j++)
                    {
                        System.out.print(studentObj[j].rollNo+"-"+studentObj[j].studentName+"\n");
                    }
                    System.out.print("Enter Student's Roll no. you want to modify : ");
                    modifyRoll = obj.nextInt();
                    found = -1;
                    for (j = 0; j < count; j++) 
                    {
                        if (modifyRoll == studentObj[j].rollNo)
                        {
                            found = j;
                        }
                    }
                    if(found == -1)
                        System.out.println("No Student Found");
                    else
                    {
                            obj.nextLine();
                            System.out.print("Enter\n");
                            System.out.print("Student's Name : ");
                            studentObj[found].studentName = obj.nextLine();
                            System.out.print("Student's Branch : ");
                            studentObj[found].branch = obj.nextLine();
                            System.out.print("Student's Percentage : ");
                            studentObj[found].percent = obj.nextInt();
                            System.out.print(" Number of courses : ");
                            studentObj[found].numCourses=obj.nextInt();
                            studentObj[found].courseId = 1;
                            for(j=0;j<studentObj[found].numCourses;j++)
                            {
                                studentObj[found].courseObj[j]=new Course();
                                studentObj[found].courseObj[j].courseId=studentObj[count].courseId++;
                                System.out.print("Name of course : ");
                                studentObj[found].courseObj[j].name=obj.nextLine();
                                System.out.print("Description of course : ");
                                studentObj[found].courseObj[j].description=obj.nextLine();
                            }              
                    }
                    break;
                
                
                case PRINT_ALL :
                    if(count == 0)
                        System.out.println("No records Found.");
                    else
                    {
                        System.out.println("  Roll No.    Student Name");
                        for (j = 0; j < count; j++) 
                        {
                            System.out.println("  " + studentObj[j].rollNo + "\t" + studentObj[j].studentName + "\n");
                        }
                    }
                    break;
                
                
                case PRINT :
                    obj.nextLine();
                    System.out.print("Student's Roll Numbers are \n");
                    for(j = 0 ; j < count ; j++)
                    {
                        System.out.print(studentObj[j].rollNo+"-"+studentObj[j].studentName+"\n");
                    }
                    System.out.print("Enter Student's Roll no. : ");
                    printRoll = obj.nextInt();
                    found = -1;
                    for (j= 0; j < count; j++) 
                    {
                        if (printRoll == studentObj[j].rollNo)
                        {
                            found = j;
                            break;
                        }
                    }
                    if(found == -1)
                        System.out.println("No Student Found");
                    else
                    {
                        System.out.println("\n-------------Student Details--------\nRoll No.   Name   Branch   Percent");
                        System.out.println("  " + studentObj[found].rollNo + "\t" + studentObj[found].studentName + "\t" + studentObj[found].branch + "\t" + studentObj[found].percent + "\n");
                        System.out.println("Course Id   Course name   Course Description");
                        for(j=0;j<studentObj[found].numCourses;j++)
                        {
                            System.out.print(" "+studentObj[found].courseObj[j].courseId+"\t  "+studentObj[found].courseObj[j].name+"\t  "+studentObj[found].courseObj[j].description+"\n");
                        }
                    }
                    break;
                
                
                case EXIT :
                    System.exit(0);
                    break;
                
                
                default:
                    System.out.print("Wrong choice");
                    break;
            }
            System.out.println("Do You wish to continue ? 0-yes/1-No : ");
            ch = obj.nextInt();
        }
      }
      catch(Exception e)
      {
          System.out.println(e+" - Exception Found");
      }
    }
}

