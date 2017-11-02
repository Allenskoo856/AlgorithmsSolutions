package sort;
public class Quicksort {
       public int partition(int A[], int begin, int end){
             int i = begin;
             int j = end;
     
             int pivot = begin;
             int pivotnumber = A[pivot];
             while(i!=j){
                   int temp;
                   while(A[j]>pivotnumber && i<j){
                        j--;

                  }
                   while(A[i]<=pivotnumber && i<j)
                  {
                        i++;
                  }
                  temp = A[i];
                  A[i] = A[j];
                  A[j] = temp;
            }

             if(i == j){
                   int temp;
                  temp =A[pivot];
                  A[pivot] = A[i];
                  A[i] = temp;      
            }
             return i;
      }
       public void sort(int A[], int begin,int end){
             if(begin<end){
                   int q;
                  q = partition(A,begin, end);
                  sort(A,begin, q-1);
                  sort(A,q+1,end);
            }     
      }
       public static void main(String[] args) {
             int array[] = {8,7,1,6,5,4,3,2};
            Quicksort s = new Quicksort();
            s.sort(array, 0, 7);
             for(int i=0;i<array.length;i++){
                  System. out.println("output " + array[i]);
            }
      }
}
