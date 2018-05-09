package unit14;

public class AtCounter {
	   private char[][] atMat;
	   private int atCount;
	   
		public AtCounter()
		{
			atCount=0;
			atMat = new char[][]{		{'@','-','@','-','-','@','-','@','@','@'},
										{'@','@','@','-','@','@','-','@','-','@'},
										{'-','-','-','-','-','-','-','@','@','@'},
										{'-','@','@','@','@','@','-','@','-','@'},
										{'-','@','-','@','-','@','-','@','-','@'},
										{'@','@','@','@','@','@','-','@','@','@'},
										{'-','@','-','@','-','@','-','-','-','@'},
										{'-','@','@','@','-','@','-','-','-','-'},
										{'-','@','-','@','-','@','-','@','@','@'},
										{'-','@','@','@','@','@','-','@','@','@'}};
		}

		public int countAts(int r, int c)
		{
			int rnew = r;
			int cnew = c;
			if(((r>=0 && r<atMat.length) && (c>=0 && c<atMat.length)) && (atMat[r][c] == '@')){
				atCount++;
				atMat[r][c] = 'x';
				
				countAts(++rnew, cnew);
				rnew = r;
				cnew = c;
				countAts(rnew, ++cnew);
				rnew = r;
				cnew = c;
				countAts(rnew, --cnew);		
				rnew = r;
				cnew = c;
				countAts(--rnew, cnew);				
			}

			return atCount;

			}

}

