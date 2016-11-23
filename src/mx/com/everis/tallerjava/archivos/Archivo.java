package mx.com.everis.tallerjava.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivo {

	static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {		
		String ruta="C:\\develope\\projects\\tallerjava";
		String nameFile="holamundo.txt";		
		File path = new File(ruta);
				
		if(!path.exists()){				
			if(path.mkdirs()){				
				System.out.println("Direcotorio creado");				
			}else{
				System.out.println("Direcotorio ya existe");
			}
		}		
		
			if(!new File(path+"\\"+nameFile).exists()){
				File miArchivo = new File(path,nameFile);
				if(miArchivo.createNewFile()){
					System.out.println("Archivo "+path+"\\"+nameFile+" creado.");	
					verifyFile(miArchivo);
					readFile(path+"\\"+nameFile);
					writeFile(path+"\\"+nameFile);
				}else{
					System.out.println("No se pudo crear el archivo.");
				}
			}else{
				System.out.println("El arhivo "+nameFile+" ya existe.");
				verifyFile(new File(path+"\\"+nameFile));
				readFile(path+"\\"+nameFile);
				writeFile(path+"\\"+nameFile);
			}												
	}

	
	public static void verifyFile(File file){
		if(file.isDirectory()){
			System.out.println("Es directorio.");
		}
		if(file.isFile()){
			System.out.println("Es archivo.");
		}
	}
	
	public static void readFile(String path) throws IOException{
		BufferedReader read = new BufferedReader(new FileReader(path));		
		String line;
		while((line=read.readLine())!=null){
			System.out.println(line);
		}		
		read.close();
	}
	public static void writeFile(String path) throws IOException{
		System.out.println("Ingresa una cadena de texto.");
		String cadena=stdIn.readLine();		
		
		PrintWriter print = new PrintWriter(path);		
		print.println(cadena);
		print.close();		
	}
}
