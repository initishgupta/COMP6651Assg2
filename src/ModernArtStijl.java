
public class ModernArtStijl {
	
	public int minimumPaintBrushChange(String pattern) {

		int sizeOfPattern = pattern.length();
		int[][] dynamicProgramming = new int[sizeOfPattern][sizeOfPattern];

		for (int i = 0; i < sizeOfPattern; i++) {
			for (int j = 0; j < sizeOfPattern; j++) {
				dynamicProgramming[i][j] = 1000;
			}
		}
		for (int k = 0; k < sizeOfPattern; k++) {
			dynamicProgramming[k][k] = 1; 
		}

		for (int i = 1; i < sizeOfPattern; i++){
		for (int j = 0; j < sizeOfPattern; j++) {

				int divider = j + i;
				if (divider >= sizeOfPattern)
				continue;
				int maxPatternSize = 50;
				for (int k = j; k < divider; k++) {
						maxPatternSize = Math.min(maxPatternSize,dynamicProgramming[j][k] + dynamicProgramming[k + 1][divider]);
					if (pattern.charAt(k) == pattern.charAt(k + 1))
						maxPatternSize = Math.min(maxPatternSize,dynamicProgramming[j][k] + dynamicProgramming[k + 1][divider] - 1);
					if (pattern.charAt(j) == pattern.charAt(divider))
						maxPatternSize = Math.min(maxPatternSize,dynamicProgramming[j][k] + dynamicProgramming[k + 1][divider] - 1);
				}
				dynamicProgramming[j][divider] = maxPatternSize;
			}
	}
		return dynamicProgramming[0][sizeOfPattern - 1];
	}

}
