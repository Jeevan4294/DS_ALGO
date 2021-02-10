package my.preparation.skiena;

public class Chapter1 {

	public static void main(String[] args) {
		int a[] = {'J','E','E','V','A','N','K','A','R','I','B','E','E','M','A','R','E','D','D','Y'};
		
		InsertionSort(a);
		
		//SelectionSort(a);
		
		print(a);
		
	}

	private static int[] SelectionSort(int[] a) {
		if(a.length <= 1) return a;
		int i,j,tmp,ix;
		int l=a.length;
		for(i=0;i<l;i++) {
			tmp = a[i];
			ix=-1;
			for(j=i;j<l;j++) {
				if(a[j]<tmp) {
					tmp = a[j];
					ix=j;
				}
			}
			if(ix != -1) {
				tmp = a[ix];
				a[ix] = a[i];
				a[i] = tmp;
			}
			print(a);
			System.out.println();
		}
		return a;
	}

	private static int[] InsertionSort(int[] a) {
		if(a.length <= 1) return a;
		int i,j,tmp;
		int l=a.length;
		for(i = 1;i<l;i++) {
			j=i;
			while(j>0 && a[j]<a[j-1]) {
				tmp = a[j-1];
				a[j-1] = a[j];
				a[j] = tmp;
				j--;
			}
			print(a);
			System.out.println();
		}
		return a;
	}

	private static void print(int[] a) {
		if(a.length == 0) return;
		System.out.print((char)a[0]);
		for (int i=1,l=a.length;i<l;i++) {
			System.out.print(","+(char)a[i]);
		}		
	}
	
}
