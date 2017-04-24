package leetcode;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int c = Integer.parseInt(as[0]);
        int d = Integer.parseInt(as[1].substring(0, as[1].length() - 1));
        int e = Integer.parseInt(bs[0]);
        int f = Integer.parseInt(bs[1].substring(0, bs[1].length() - 1));
        return String.format("%d+%di", c*e - d*f, e*d + c*f);
    }
}
