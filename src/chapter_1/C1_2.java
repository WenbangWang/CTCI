package chapter_1;

/**
 * Reverse a string or char array in place with bit manipulation.
 */
public class C1_2 {

    public static void main(String[] args) {
        char [] charArray = "abcdefghijklmn".toCharArray();

        System.out.println(reverseBit(charArray));
    }

    private static char [] reverseBit(char[] charArray) {
        int head = 0;
        int tail = charArray.length-1;

        while(tail > head) {
            charArray[head] = (char) (charArray[head] ^ charArray[tail]);
            charArray[tail] = (char) (charArray[head] ^ charArray[tail]);
            charArray[head] = (char) (charArray[head++] ^ charArray[tail--]);
        }

        return charArray;
    }

    private  static char [] reverse(char[] charArray) {
        for(int i=0; i<charArray.length/2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length-i-1];
            charArray[charArray.length-i-1] = temp;
        }

        return charArray;
    }
}
