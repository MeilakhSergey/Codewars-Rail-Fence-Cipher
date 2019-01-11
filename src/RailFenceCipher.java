public class RailFenceCipher {
    public static void main(String[] args) {
//        String code = encode("1234567890", 3);
//        System.out.println(code);
        System.out.println(decode("H !e,Wdloollr", 4));
    }

    static String encode(String line, int railAmount) {
        if ("".equals(line) || line == null) {
            return "";
        }

        int[] des = new int[railAmount];
        des[0] = railAmount * 2 - 2;
        des[des.length-1] = des[0];
        for (int i = 1; i < des.length - 1; i++) {
            des[i] = des[i-1] - 2;
        }

        StringBuilder result = new StringBuilder(line.length());
        for (int i = 0; i < railAmount; i++) {
            int k = i;
            while (k < line.length()) {
                result.append(line.charAt(k));
                k += des[i];
                if (i > 0 && i < railAmount - 1) {
                    des[i] = des[0] - des[i];
                }
            }
        }
        return result.toString();
    }

    static String decode(String line, int railAmount) {
        if ("".equals(line) || line == null) {
            return "";
        }

        int[] des = new int[railAmount];
        des[0] = railAmount * 2 - 2;
        des[des.length-1] = des[0];
        for (int i = 1; i < des.length - 1; i++) {
            des[i] = des[i-1] - 2;
        }

        StringBuilder result = new StringBuilder(line);
        int z = 0;
        for (int i = 0; i < railAmount; i++) {
            int k = i;
            while (k < line.length()) {
                result.replace(k, k+1, String.valueOf(line.charAt(z)));
                z++;
                k += des[i];
                if (i > 0 && i < railAmount - 1) {
                    des[i] = des[0] - des[i];
                }
            }
        }
        return result.toString();
    }
}
