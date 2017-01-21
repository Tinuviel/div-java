import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Lovisa Colérus
 * 2016
 *
 */

public class MusicReader {
	public static void main(String[] args){
		long fileLength;
		try{
			RandomAccessFile file = new RandomAccessFile(args[0], "rw");
			fileLength = file.length();
			file.seek(fileLength - 125);
			System.out.print("Title: ");
			for(int i = 0; i<30; i++){
				System.out.print((char)file.readByte());
			}
			
			System.out.println("\nArtist: ");
			for(int i = 0; i < 30; i++){
				System.out.print((char)file.readByte());
			}
			
			System.out.println("\nAlbum: ");
			for(int i = 0; i < 30; i++){
				System.out.print((char)file.readByte());
			}
			
			
			System.out.println("\nYear: ");
			for(int i = 0; i < 4; i++){
				System.out.print((char)file.readByte());
			}
			
			file.close();
		}catch(IOException e){
				System.out.print("File not found!");
		}
		
		
		
		
	}
}
