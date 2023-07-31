package com.views;

import java.util.Scanner;

import com.model.Book;
import com.services.BookServices;
import com.services.BookServicesImpl;

public class ExecuteClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ExecuteClass dummy = new ExecuteClass();
		String c = "y";
		do {
			System.out.println("Enter operation index");
			System.out.println("1. Add Book");
			System.out.println("2. Delete Book");
			System.out.println("3. Edit Book");
			System.out.println("4. Show all entries");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				dummy.add();
				dummy.show();
				break;
			}
			
			case 2: {
				dummy.delete();
				dummy.show();
				break;
			}
			
			case 3: {
				dummy.edit();
				break;
			}
			
			case 4: {
				dummy.show();
				break;
			}
			
			default:
				System.out.println("Illegal choice");;
			}
			
			System.out.println("Do you want to continue operation? (y/n): ");
			c = sc.next();
		} while(c.equals("y"));
	}
	
	void add() {
		BookServices bs = new BookServicesImpl();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		do {
			Book bk = new Book();
			System.out.print("Enter Name of Book: "); bk.setName(sc.next());
			System.out.print("Enter Author of Book: "); bk.setAuthor(sc.next());
			System.out.print("Enter Publisher of Book: "); bk.setPublisher(sc.next());
			System.out.print("Enter Edition of Book: "); bk.setEdition(sc.nextInt());
			bs.add(bk);
			
			System.out.println("Do you want to continue adding books? (y/n): "); choice = sc.next();
		} while (choice.equals("y"));
	}
	
	void edit() {
		BookServices bs = new BookServicesImpl();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		int id;
		do {
			Book bk = new Book();
			System.out.print("Enter ID of Book you want to edit: "); id = sc.nextInt();
			System.out.print("Enter edited Name of Book: "); bk.setName(sc.next());
			System.out.print("Enter edited Author of Book: "); bk.setAuthor(sc.next());
			System.out.print("Enter edited Publisher of Book: "); bk.setPublisher(sc.next());
			System.out.print("Enter edited Edition of Book: "); bk.setEdition(sc.nextInt());
			bs.edit(bk, id);
			
			System.out.println("Do you want to continue editing entries? (y/n): "); choice = sc.next();
		} while (choice.equals("y"));
	}
	
	void delete() {
		BookServices bs = new BookServicesImpl();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		int id;
		do {
			System.out.print("Enter ID of Book you want to delete: "); id = sc.nextInt();
			bs.delete(id);
			
			System.out.println("Do you want to continue deleting books? (y/n): "); choice = sc.next();
		} while (choice.equals("y"));
	}
	
	void show() {
		BookServices bs = new BookServicesImpl();
		bs.show();
	}
	
}
