
public class MySpecialLinkedListUtils {
	LinkedListNode h;
	public static void addNode(LinkedListNode n,MySpecialLinkedListUtils t) {
		LinkedListNode i=t.h;
		LinkedListNode prev=i;
		while(i!=null) {
			prev=i;
			i=i.next;
		}
		prev.next=n;
	}
	public static double[] summary(LinkedListNode head) {
		LinkedListNode i=head;
		int j=0;
		double sum=0;
		double max;
		double min;
		if(i!=null) {
			max=i.value;
			min=i.value;
		}
		while(i!=null) {
			sum=sum+i.value;
			j++;
			if(i.value>max) {
				max=i.value;
			}
			if(i.value<min) {
				min=i.value;
			}
			i=i.next;
		}
		double avg=sum/j;
		double median;
		if(j/2==0) {
			LinkedListNode o=head;
			for(int u=0;u<(j/2)-1;u++) {
				o=o.next;
			}
			median =(o.value+o.next.value)/2;
		}
		if(j/2!=0) {
			LinkedListNode o=head;
			for(int u=0;u<(j/2)-1;u++) {
				o=o.next;
			}
			median=o.value;
		}
		double summ[]=new double[5];
		summ[0]=sum;
		summ[1]=avg;
		summ[2]=median;
		summ[3]=max;
		summ[4]=min;
		return summ;
	}
	public static LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode i=head;
		LinkedListNode previous =null;
		LinkedListNode next =head;
		while(i!=null) {
			next=i.getNext();
			i.next=previous;
			previous=i;
			i=next;
		}
		head=previous;
		return head;
	}
	public static LinkedListNode evenIndexedElements (LinkedListNode head) {
		int j=0;
		LinkedListNode i=head;
		MySpecialLinkedListUtils even;
		i=i.next;
		while(i!=null) {
			if(j%2==0) {
				addNode(i,even);
			}
			i=i.next;
			j++;
		}
		return  even.h;
	}
	public static LinkedListNode removeCentralNode(LinkedListNode head) {
		LinkedListNode i=head;
		i=i.next;
		int j=0;
		while(i!=null) {
			i=i.next;
			j++;
		}
		LinkedListNode w=head;
		if(j%2==0) {
			for(int q=1;q<j/2;q++) {
				w=w.next;
			}
			w.next=w.next.next;
		}
		else {
			for(int q=1;q<=j/2;q++) {
				w=w.next;
			}
			w.next=w.next.next;
		}
		return head;
	}
	public static boolean palindrome(LinkedListNode head) {
		LinkedListNode i=head.next;
		int j=0;
		while(i!=null) {
			i=i.next;
			j++;
		}
		int arr[]=new int[j];
		LinkedListNode r=head.next;
		for(int y=0;y<j;y++) {
			arr[y]=r.value;
			r=r.next;
		}
		int pal=0;
		for(int y=0;y<j/2;y++) {
			if(arr[y]!=arr[j-y-1]) {
				pal=1;
				break;
			}
		}
		if(pal==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void merge(int arr[], int l, int m, int r) { 
	    int i, j, k; 
	    int n1 = m - l + 1; 
	    int n2 =  r - m;
	    int L[]=new int[n1]; 
	    int R[]=new int [n2];
	    for (i = 0; i < n1; i++) 
	        L[i] = arr[l + i]; 
	    for (j = 0; j < n2; j++) 
	        R[j] = arr[m + 1+ j];
	    i = 0; 
	    j = 0; 
	    k = l; 
	    while (i < n1 && j < n2) 
	    { 
	        if (L[i] <= R[j]) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	        } 
	        else
	        { 
	            arr[k] = R[j]; 
	            j++; 
	        } 
	        k++; 
	    } 
	    while (i < n1) 
	    { 
	        arr[k] = L[i]; 
	        i++; 
	        k++; 
	    } 
	    while (j < n2) 
	    { 
	        arr[k] = R[j]; 
	        j++; 
	        k++; 
	    } 
	}
	public static void mergeSortofarray(int a[], int l, int r){ 
	    if (l < r) 
	    {	int m = l+(r-l)/2; 
	    	mergeSortofarray(a, l, m); 
	        mergeSortofarray(a, m+1, r); 
	        merge(a, l, m, r); 
	    } 
	}
	public static LinkedListNode mergeSort(LinkedListNode head) {
		LinkedListNode i=head.next;
		int j=0;
		while(i!=null) {
			i=i.next;
			j++;
		}
		int b[]=new int[j];
		LinkedListNode r=head.next;
		for(int y=0;y<j;y++) {
			b[y]=r.value;
			r=r.next;
		}
		mergeSortofarray(b,0,j-1);
		LinkedListNode op=head.next;
		for(int y=0;y<j;y++) {
			op.value=b[y];
			op=op.next;
		}
		return head;
	}
	public static LinkedListNode insertionSort(LinkedListNode head) {
        LinkedListNode i=head;
        LinkedListNode ins=head.next;
        while(ins!=null) {
        i=head;
        while(i!=null){
        	
        	if(ins.value<i.value) {
        	int temp;
            temp =ins.value;
            ins.value=i.value;
            i.value=temp;
            }
            i=i.next;
        }
        ins=ins.next;
        }
        return head;
    }
}
