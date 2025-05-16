
import java.util.PriorityQueue;
/*class Solution {
    public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int i=0;i<nums.length;i++){
         pq.add(nums[i]);
        if(pq.size()>k){
            pq.remove();
        }
    }
        return pq.remove();
    }
}*/ //61 ms
// 59 ms
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i=0; i<nums.length; i++){
            pq.offer(-nums[i]);
        }


        Integer solution = 0 ;
        for(int i=0; i<k ; i++){
            solution = pq.poll();
        }
            return - solution ;
    }
    }

/*class Solution {

    public int findKthLargest(int[] nums, int k) {
        // k-ésimo más grande es el (n - k)-ésimo menor
        int indexToFind = nums.length - k;
        shuffle(nums); // Mezclamos para mejorar el rendimiento del Quickselect
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == indexToFind) {
                return nums[pivotIndex];
            } else if (pivotIndex < indexToFind) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // No debería llegar aquí si la entrada es válida
    }

    // Mezcla aleatoria (Fisher-Yates Shuffle)
    private void shuffle(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(a, i, j);
        }
    }

    //  elige el último como pivote
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}*/
