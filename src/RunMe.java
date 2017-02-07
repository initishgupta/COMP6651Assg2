
import java.io.File;


import java.util.Scanner;

public class RunMe {

	public static void main(String[] args) {
		ModernArtStijl modernArt = new ModernArtStijl();
		Scanner in = new Scanner(System.in);
		String inputFileName = null;
        System.out.print("Enter Input File Name: ");
        String stringScanned;
        int paintBrushChangedRequired;
        try{
        	inputFileName = in.nextLine();
        }
        catch(Exception exception)
        {
         System.out.println("Exception Caught: "+exception.getMessage());	
        }
        in.close();
        final long startTime = System.nanoTime();
        try {
			Scanner sc = new Scanner(new File("./InputFiles/"+inputFileName+".txt"));
			while (sc.hasNext()) {
				stringScanned = sc.next();
				paintBrushChangedRequired = modernArt.minimumPaintBrushChange(stringScanned);
				System.out.println(paintBrushChangedRequired);

			}
			sc.close();
	}
        catch (Exception e) {
			System.out.println("Exception Caught" + e.getMessage());
		} 
        final long endTime = System.nanoTime();
	
		System.out.println("Program Took: " + ((endTime - startTime) / 1000000) + " milliseconds");

}
}