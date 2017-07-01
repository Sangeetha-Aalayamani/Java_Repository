package bank.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import bank.account.exceptions.InvalidAccountNumberException;
import bank.account.exceptions.InvalidDepositAmountException;
import bank.account.exceptions.InvalidInterestRateException;
import bank.account.exceptions.InvalidOverdraftLimitException;
import bank.account.exceptions.InvalidWithdrawAmountException;
import bank.constants.Constants;
/**
 * 
 * @author sangeetha
 *
 */
public class MainAccount implements Constants {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);

		int choice,subChoice, i, overdraftLimit, count = 0;
		int month, year, interestMonth, interestYear;
		double deposit;
		String accNum;
		boolean check, flag;
		float interest;

		Account object = null;
		String[] accNumber = new String[100];
	
		FileOutputStream fout = null;
		ObjectOutputStream oout = null;
		FileInputStream fin = null;
		ObjectInputStream oin = null;
		File f;

		/**
		 * Enter the current month and year
		 */
		System.out.print(" Enter Current Month : ");
		month = input.nextInt();
		System.out.print(" Enter Current Year : ");
		year = input.nextInt();

		while (true) {
			
			System.out.println("\n****************************************");
			System.out.println("\n*********BANK ACCOUNT SYSTEM***********");
			System.out.println(" 1) Create an Account ");
			System.out.println(" 2) Deposit money ");
			System.out.println(" 3) withdraw Money ");
			System.out.println(" 4) Change Overdraft limit ");
			System.out.println(" 5) Check Balance ");
			System.out.println(" 6) Add Interest to all account.");
			System.out.println(" 7) Change Interest rate");
			System.out.println(" 8) Delete an Account ");
			System.out.println(" 9) Exit ");
			System.out.println("****************************************");
			
			System.out.print(" Enter Your Choice : ");
			choice = input.nextInt();
			
			switch (choice) {
			
			case CREATE_ACCOUNT:
				
				// Types of account
				System.out.println(" 1. Savings Account ");
				System.out.println(" 2. Current Account ");
				
				System.out.print(" Enter Your Choice : ");
				subChoice = input.nextInt();
				switch (subChoice) {
				case SAVINGS_ACCOUNT:
					
					flag = true;
					accNum = ""; 
					
					// the while loop will run until the inputs are valid one
					while (flag) {
						System.out.print(" Enter Account Number :");
						accNum = input.next();
						
						System.out.print(" Enter Deposit amount : ");
						deposit = input.nextDouble();
						
						try {
							object = new SavingsAccount(accNum, deposit); // /creating object and putting the statement in while loop

							System.out.println(" Account created Successfully.");
							flag = false;
							
						} catch (InvalidAccountNumberException iae) 
						{
							iae.printStackTrace();
						} catch (InvalidDepositAmountException ide) {
							ide.printStackTrace();
						}
					}				
					object.setDate(month, year);

					try {
						fout = new FileOutputStream(accNum + ".ser");
						oout = new ObjectOutputStream(fout);
						oout.writeObject(object);
						oout.flush();
						
						
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (fout != null) {
								oout.close();
								fout.close();
								oout = null;
								fout = null;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						accNumber[count] = accNum;
						count++;
					}
					break;
					
					
				case CURRENT_ACCOUNT:
					flag = true;
					accNum = "";
					while (flag) {
						
						System.out.print(" Enter Account Number :");
						accNum = input.next();
						
						System.out.print(" Enter Deposit amount : ");
						deposit = input.nextLong();
						
						System.out.print(" Enter overdraft limit : ");
						overdraftLimit = input.nextInt();
						try {
							
							object = new CurrentAccount(accNum, deposit, overdraftLimit);
							System.out.println(" Account created Successfully.");
							flag = false;
							
						} catch (InvalidAccountNumberException ex) {
							ex.printStackTrace();
						} catch (InvalidDepositAmountException ex) {
							ex.printStackTrace();
						} catch (InvalidOverdraftLimitException ex) {
							ex.printStackTrace();
						}
					}

					object.setDate(month, year);

					try {
						fout = new FileOutputStream(accNum + ".ser");
						oout = new ObjectOutputStream(fout);
						oout.writeObject(object);
						oout.flush();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (fout != null) {
								oout.close();
								fout.close();
								oout = null;
								fout = null;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					accNumber[count] = accNum;
					count++;

					break;
				default:
					System.out.println(" Wrong Choice!!! Please Enter correct choice."); 
				}
				break;
				
			case DEPOSIT: 
				// Deposit money
				System.out.print(" Enter Account Number : ");
				accNum = input.next();
				f = new File(accNum + ".ser");
				if (f.exists()) {
					try {
						fin = new FileInputStream(accNum + ".ser");
						oin = new ObjectInputStream(fin);

						object = (Account) oin.readObject();
						System.out.print(" Enter Deposit Amount : ");
						deposit = input.nextDouble();
						try {
							object.deposited(deposit);
							System.out.println(" The amount has deposited successfully.");
						} // the deposited amount will be stored in the object						
						catch (InvalidDepositAmountException ide) {
							ide.printStackTrace();
						}

						fout = new FileOutputStream(accNum + ".ser");
						oout = new ObjectOutputStream(fout);
						oout.writeObject(object);
						oout.flush();
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (fout != null) {
								oin.close();
								fin.close();
								oin = null;
								fin = null;
								oout.close();
								fout.close();
								oout = null;
								fout = null;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				} else
					System.out.println("Account does not exist.");
				break;
								
			case WITHDRAWAL: 
				// withdrawing money
				System.out.print(" Enter Account Number : ");
				accNum = input.next();
				f = new File(accNum + ".ser");
				if (f.exists()) {
					try {
						fin = new FileInputStream(accNum + ".ser");
						oin = new ObjectInputStream(fin);
						object = (Account) oin.readObject();
						System.out.print(" Enter amount to withdraw : ");
						deposit = input.nextLong(); 
						
						try {
							object.withdraw(deposit);
							System.out.println(" The Amount " + deposit+ " has been withdrawn successfully."); 
						} 
						
						catch (InvalidWithdrawAmountException ex) {
							ex.printStackTrace();
						}

						fout = new FileOutputStream(accNum + ".ser");
						oout = new ObjectOutputStream(fout);
						oout.writeObject(object);
						oout.flush();
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (fout != null) {
								oin.close();
								fin.close();
								oin = null;
								fin = null;
								oout.close();
								fout.close();
								oout = null;
								fout = null;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				} else
					System.out.println("Account does not exists.");

				break;
				
				
			case OVERDRAFT_LIMIT: 
				
				// change overdraft limit
				System.out.print(" Enter Account Number : ");
				accNum = input.next();
				f = new File(accNum + ".ser");
				if (f.exists()) {
					try {
						fin = new FileInputStream(accNum + ".ser");
						oin = new ObjectInputStream(fin);

						object = (Account) oin.readObject();

						System.out.print(" Enter new overdraft limit : ");
						overdraftLimit = input.nextInt();
						try {
							object.setOverdraft(overdraftLimit);
							System.out
									.println("Overdraft changed Successfully.");
						} catch (InvalidOverdraftLimitException ex) {
							ex.printStackTrace();
						}

						fout = new FileOutputStream(accNum + ".ser");
						oout = new ObjectOutputStream(fout);
						oout.writeObject(object);
						oout.flush();
					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (fout != null) {
								oin.close();
								fin.close();
								oin = null;
								fin = null;
								oout.close();
								fout.close();
								oout = null;
								fout = null;
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				} else
					System.out.println("Account does not exist.");
				break;
				
			case CHECK_BALANCE: 
				// check Balance
				System.out.print(" Enter Account Number : ");
				accNum = input.next();
				f = new File(accNum + ".ser");
				if (f.exists()) {

					try {
						fin = new FileInputStream(accNum + ".ser");
						oin = new ObjectInputStream(fin);

						object = (Account) oin.readObject();
						System.out.print(" Balance in the account is : "+ object.getAmount());

					} catch (ClassNotFoundException ex) {
						ex.printStackTrace();
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} catch (IOException ex) {
						ex.printStackTrace();
					} finally {
						try {
							oin.close();
							fin.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}

						oin = null;
						fin = null;
					}
				} else
					System.out.println("Account does not exist.");

				break;
				
				
			case ADD_INTEREST:
				System.out.print(" Enter Current Month : ");
				interestMonth = input.nextInt();
				
				System.out.print(" Enter Current Year : ");
				interestYear = input.nextInt();
				check = false;
				
				for (i = 0; i < accNumber.length; i++) {
					f = new File(accNumber[i] + ".ser");
					if (f.exists()) {
						try {
							fin = new FileInputStream(accNumber[i] + ".ser");
							oin = new ObjectInputStream(fin);
							object = (Account) oin.readObject();
							
							if (!object.getType()) // adding interest to all account.
								check = object.addInterest(interestMonth, interestYear);
								fout = new FileOutputStream(accNumber[i] + ".ser");
								oout = new ObjectOutputStream(fout);
								oout.writeObject(object);
								oout.flush();
						} catch (ClassNotFoundException ex) {
							ex.printStackTrace();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						} catch (IOException ex) {
							ex.printStackTrace();
						} finally {
							try {
								if (fout != null) {
									oin.close();
									fin.close();
									oin = null;
									fin = null;
									oout.close();
									fout.close();
									oout = null;
									fout = null;
								}
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}

					}
				}
				if (check)
					System.out.println(" The Interest has been added to every account.");
				else
					System.out.println(" The Interest has not been added.");

				break;
				
			case CHANGE_INTEREST:
				
				System.out.print(" Enter new Interest rate : ");
				interest = input.nextFloat();
				for (i = 0; i < accNumber.length; i++) {
					f = new File(accNumber[i] + ".ser");
					if (f.exists()) {
						try {
							fin = new FileInputStream(accNumber[i] + ".ser");
							oin = new ObjectInputStream(fin);
							object = (Account) oin.readObject();
							try {
								object.setInterest(interest);
							} catch (InvalidInterestRateException ex) {
								ex.printStackTrace();
							}

							fout = new FileOutputStream(accNumber[i] + ".ser");
							oout = new ObjectOutputStream(fout);
							oout.writeObject(object);
							oout.flush();
						} catch (ClassNotFoundException ex) {
							ex.printStackTrace();
						} catch (FileNotFoundException ex) {
							ex.printStackTrace();
						} catch (IOException ex) {
							ex.printStackTrace();
						} finally {
							try {
								if (fout != null) {
									oin.close();
									fin.close();
									oin = null;
									fin = null;
									oout.close();
									fout.close();
									oout = null;
									fout = null;
								}
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}

					}
				}
				System.out.println(" The interest rate has been changed successfully.");
				break;

			case DELETE_ACCOUNT: //delete account
				
				System.out.print(" Enter Account Number you want to delete : ");
				accNum = input.next();
				f = null;
				f = new File(accNum + ".ser");
				if (f.exists()) {
					f.delete();
					System.out.println(" The Account deleted Successfully.");
				} else
					System.out.println(" Account does not exist.");
				break;
				
			case EXIT:
				System.out.println("Exit");
				System.exit(0); // exit
			default:
				System.out.println(" Wrong Input!!! Please Enter valid Input(1 to 9).");
			}
		}
	}
}
