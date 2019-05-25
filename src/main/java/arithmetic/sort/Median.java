package arithmetic.sort;

/**
 * 排序求中位数算法
 *
 * @author: yx.zhou
 * @Date: 2019/5/25
 * @Time: 17:30
 */

public class Median {


    /**
     * 有两个有序数组,大小分别为m和n,求这两个数组的中位数
     *
     * @param a [1,4,7]
     * @param b [6,8,9,12]
     * @return
     */
    public double findMedianSortedArrays(int a[], int b[]) {

        int n = a.length + b.length;

        // 如果是偶数个
        if (n % 2 == 0) {

        }
        return 0D;
    }

    /**
     * 二分法查找
     *
     * @param a
     * @param b
     * @param k 不是从零开始的,从1开始
     * @return
     */
    private double findKthBinarySearch(int[] a, int[] b, int k) {

        int aLengh = a.length;

        int bLength = a.length;
        if (a.length == 0) {
            return b[k - 1];
        }
        if (b.length == 0) {
            return a[k - 1];
        }

        int start = Math.min(a[0], b[0]);

        int end = Math.max(a[aLengh - 1], b[bLength - 1]);

        //找到第一个x > = k数量较小或等于x
        while (start + 1 < end) {

        }
    }

    /**
     * 查找小雨或者等于
     *
     * @param arr
     * @param number
     * @return
     */
    private int countSmallerOrEqual(int arr[], int number) {

    }

}
