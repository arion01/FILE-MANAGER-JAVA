package Utils;

public interface IFILE {
	
	void createFile(String filename);
	void readFile(String filename);
	void writeFile(String filename,String text);
	void deleteFile(String filename);
	void createFolder(String filename);
	void deleteFolder(String filename);
	
}
