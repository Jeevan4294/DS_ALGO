package my.preparation.skiena;

public class Chapter2 {

	public static void main(String[] args) {
		int a = 1;
		int b = 50000;
		System.out.println("-------- Finding power using recursion -----------");
		long startTime = System.currentTimeMillis();
		long p = powerRec(a,b);
		long endTime = System.currentTimeMillis();
		System.out.println(""+a+"^"+b+" = "+p+" ; "+"Duration : "+(endTime-startTime));

		System.out.println("-------- Finding power using loop -----------");
		startTime = System.currentTimeMillis();
		p = powerLoop(a,b);
		endTime = System.currentTimeMillis();
		System.out.println(""+a+"^"+b+" = "+p+" ; "+"Duration : "+(endTime-startTime));
	}

	private static long powerLoop(int a, int b) {
		long res=1;
		while(b>0) {
			res*=a;
			b=b-1;
		}
		return res;
	}

	private static long powerRec(int a, int b) {
		if(b == 0) return 1;
		if(b%2 == 0) {
			return powerRec(a,b/2)*powerRec(a,b/2);
		}else {
			b = b-1;
			return a*powerRec(a,b/2)*powerRec(a,b/2);
		}
	}
	

}
