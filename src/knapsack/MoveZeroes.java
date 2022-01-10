package knapsack;
public class MoveZeroes {
public static void main(String[] args) {
	int[] nums = {0,1,0,3,12};
	moveZero(nums);
	for(int i : nums)
		System.out.print(i+" ");
}
static void moveZero(int[] nums) {
	int counter = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] != 0) {
			int temp = nums[counter];
			nums[counter] = nums[i];
			nums[i] = temp;
			counter++;
		}
	}
}
}
