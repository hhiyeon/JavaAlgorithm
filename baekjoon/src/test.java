public class test {
    public static void main(String[] args) {
        // 조건식 ? 값 또는 연산식(true) : 값 또는 연산식(false)
        // (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
        // ‘C’ = 5/9 x (F - 32)’
        // (int)((5/9f * (fahrenheit - 32))*100 + 0.5) / 100f
        //
        int fahrenheit = 100;
        float celcius = (int)((5/9f * (fahrenheit - 32))*100 + 0.5) / 100f;

        System.out.println("Fahrenheit:"+fahrenheit);
        System.out.println("Celcius:"+celcius);
    }
}
