package helloWorld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataSort {
	public static final String VALIDATION = "([a-zA-Z]:)?(\\\\[^<>:\"\\/|\\?\\*].+)+\\\\?";


	public static void main(String[] args){

		People[] array =new People[50];
		Scanner scan=new Scanner(System.in);
		String nameOfFile=getFileName(scan);
		String readFromFile=null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(nameOfFile));

			while((readFromFile = br.readLine()) != null){

				array=createPeople(readFromFile,array);
				array=sortPeople(array);
				
			}
			br.close();

			bw = new BufferedWriter(new FileWriter(nameOfFile));		
			bw.write(combinePeople(array));
			bw.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (NumberFormatException e){
			System.out.println("Data from file is corrupted!");
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Data from file is corrupted!");
		}finally{
			try {
				if(br !=null)
					br.close();
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static String getFileName(Scanner console){
		String nameOfFile;
		Pattern pattern = Pattern.compile(VALIDATION);
		Matcher matcher;
		do{
			System.out.println("Enter file absolute path");
			nameOfFile = console.nextLine();
			matcher = pattern.matcher(nameOfFile);
		}while(matcher.matches() == false);
		return nameOfFile;
	}


	public static People[] createPeople(String readFromFile, People[] array){
		String[] splitted = readFromFile.split("\\*");
		int c=0;
		for(int i=0;i<splitted.length;i=i+4){
			array[c]=new People(Integer.parseInt(splitted[i]), splitted[i+1]+"*"+splitted[i+2]  ,Integer.parseInt(splitted[i+3]));
			c++;
		}
		return array;
	}


	public static People[] sortPeople(People[] array){
		int p=0;
		for(int j=0;j<array.length;j++){
			if(array[j]!=null)
				p++;	
		}
		int  c, d;
		People swap;
		int n=p;
		for (c = 0; c < ( n - 1 ); c++) {
			for (d = 0; d < n - c - 1; d++) {
				if (array[d].getNumber() > array[d+1].getNumber()) 
				{
					swap       = array[d];
					array[d]   = array[d+1];
					array[d+1] = swap;
				}
			}
		}
		return array;
	}


	public static String combinePeople(People[] array){
		String str=new String();
		int p=0;
		for(int j=0;j<array.length;j++){
			if(array[j]!=null)
				p++;	
		}
		for(int i=0;i<p;i++){
			str=str+array[i].getNumber()+"*"+array[i].getName()+"*"+array[i].getBirthDate()+"*";
		}
		return str;
	}
}
