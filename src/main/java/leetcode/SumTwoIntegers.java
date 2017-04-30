package leetcode;

public class SumTwoIntegers {
    public int getSum(int a, int b) {
        int res = 0, carryin = 0, k = 0;
        while ((a != 0) || (b != 0)) {
            int bitA = a & 1, bitB = b & 1;
            int c = carryin ^ bitA ^ bitB;
            int carryout = (bitA & bitB) | (bitA & carryin) | (bitB & carryin);
            res |= (c << k);
            carryin = carryout;
            k++;
            a >>>= 1;
            b >>>= 1;
        }
        if (k < 32) {
            res |= (carryin << k);
        }
        return res;
    }
}
