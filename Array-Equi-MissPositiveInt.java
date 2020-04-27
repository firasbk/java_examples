 public static void main(String[] args) {
		int[] A = new int[5];
        A[0] = 2;
        A[1] = 2;
        A[2] = 2;
        A[3] = 2;
        A[4] = 50;
        int cnt = solution(A);
        System.out.println(" result is === "+cnt);
        int[] B = new int[8];
        B[0] = -1;
        B[1] =  3;
        B[2] = -4;
        B[3] =  5;
        B[4] =  1;
        B[5] = -6;
        B[6] =  2;
        B[7] =  1;
        int lef = equi(B);
        int[] C = new int[6];
        C[0] = 1;
        C[1] =  3;
        C[2] = 6;
        C[3] =  4;
        C[4] =  1;
        C[5] = 2;
        int f = found(C);
        System.out.println(" found is === "+f);
        int s = missing(C);
        System.out.println(" missing  is === "+s);

        busyPeriod();
    }

    static int solution(int[] A) {
        int n = A.length;
        int[] L = new int[n + 1];
        L[0] = -1;
        for (int i = 0; i < n; i++) {
            L[i + 1] = A[i];
        }
        int count = 0;
        int pos = (n + 1) / 2;
        int candidate = L[pos];
        for (int i = 1; i <= n; i++) {
            if (L[i] == candidate)
                count = count + 1;
        }
        if (count > pos)
            return candidate;
        return (-1);
    }
    static int equi(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += A[j];
            }
            for (int k = i+1; k < n; k++) {
                sumRight += A[k];
            }
            if(sumLeft == sumRight)
                System.out.println(" equilibruim is === "+i);
        }
        return (-1);
    }

    static int missing(int[] A) {
        Arrays.sort(A);
        //find the first positive integer
        int i = 0, len = A.length;
        while (i < len && A[i++] < 1) ;
        System.out.println(" the index now is "+i);
        --i;
        System.out.println(" the index now is "+i);
		
        //Check if minimum value 1 is present
        if (A[i] != 1)
            return 1;

        //Find the missing element
        int j = 1;
        while (i < len - 1) {
            System.out.println(" the j now is "+j);
            if (j == A[i + 1]) i++;
            else if (++j != A[i + 1])
                return j;
        }

        // If we have reached the end of array, then increment out value
        if (j == A[len - 1])
            j++;
        return j;
    }
	
    static void testList() {
        // Creating a list
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(0, 1); // adds 1 at 0 index
        l1.add(1, 2); // adds 2 at 1 index
        System.out.println(l1); // [1, 2]

        // Creating another list
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        // Will add list l2 from 1 index
        l1.addAll(1, l2);
        System.out.println(l1);

        // Removes element from index 1
        l1.remove(1);
        System.out.println(l1); // [1, 2, 3, 2]

        // Prints element at index 3
        System.out.println(l1.get(3));

        // Replace 0th element with 5
        l1.set(0, 5);
        System.out.println(l1);

        List<String> l = new ArrayList<String>(5);

        l.add("GeeksforGeeks");
        l.add("Practice");
        l.add("GeeksQuiz");
        l.add("IDE");
        l.add("Courses");

        List<String> range = new ArrayList<String>();

        // Return List between 2nd(including)
        // and 4th element(excluding)
        range = l.subList(2, 5);

        System.out.println(range);
    }

}