public class ex19 {
    
    public static void main(String[] args) {
        // 형 변환 ex
        short[] array = {(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));

        byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
        
        for(int i = 0; i < transformedArray.length; i++) {
            System.out.println(transformedArray[i]);
        }

        for(int i = 0; i < expectedArray.length; i++) {
            System.out.println(expectedArray[i]);
        }
    }

    public static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformArray = new byte[array.length];
        
        for(int i = 0; i < array.length; i++) {
            transformArray[i] = function.applyAsByte(array[i]);
        }

        return transformArray;
    }
}
