package Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Files implements IFILE {
	
	private static String path;

	public Files(String path){
		this.path = path;
	}
	
	
	@Override
	public void createFile(String filename){
		
	    File file = new File(path + filename);	
		
		try{
			
			if(file.createNewFile()){			
				file.createNewFile();		
				System.out.println("Файл успешно создан");
			}
			
		}catch(IOException e){
			System.out.println("Files : " + e);
		}
	}

	@Override
	public void readFile(String filename){
		
		File file = new File(path + filename);
		BufferedReader reader;
		
		try {
			
			reader = new BufferedReader(new InputStreamReader(
									new FileInputStream(file),StandardCharsets.UTF_8));								
			String line;
			
			try {
				while ((line = reader.readLine()) != null){
					System.out.println(line);
				}
			}catch (IOException e){
				System.out.println("Files : " + e);	
			 }
	     }catch(FileNotFoundException e){
			System.out.println("Files : " + e);	
		  }
        
	}

	@Override
	public void writeFile(String filename , String text) {
		
		File file = new File(path + filename);	
		
		try {
			
			FileWriter writer = new FileWriter(file,false);
			writer.write(text);	
			writer.append("\n");	
			writer.flush();
			
		}catch(IOException e){
			System.out.println("Files : " + e);	
		}
	}

	@Override
	public void deleteFile(String filename) {
		File file = new File(path + filename);
		
		try{
			
			if(file.delete()){
				System.out.println("Файл " + filename + " " + "успешно удален");
			}else{
				System.out.println("Файл " + filename + " " + "не найден");
			}
			
		}catch(Exception e){
			System.out.println("Files : " + e);	
		}
	}

	@Override
	public void createFolder(String folder_name){
		File file = new File(path + folder_name);
		
		try{
			
			if(file.mkdir()){
				System.out.println("Папка успешна создана, путь : "  + path);
			}
			
		}catch(Exception e){
			System.out.println("Files : " + e);
		}
	}

	@Override
	public void deleteFolder(String folder_name){
		File file = new File(path + folder_name);
		try{

			if(file.delete()){
				System.out.println("Папка " + folder_name + " " + "успешно удалена");
			}else{
				System.out.println("Папка " + folder_name + " " + "не найдена");
			 }

		}catch(Exception e){
			System.out.println("Files : " + e);
		 }
	}
}
