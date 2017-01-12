
import java.lang.Math;

public class Program1 {

    private Double cONST_PI = null;
    private Double wORK_1 = 0.0;
    private Double wORK_2 = 0.0;
    private Double pRINT_LINE = null;

    // Manually added
    private final Double zERO = 0.0;

    public static void main(String[] args) {
        Program1 job = new Program1();
        job.a_PARA();
    }

    public void a_PARA() {
        wORK_1 = 123.46;
        wORK_2 = wORK_2 + 2;

        // Manually-added
        Double wORK_3 = 12.34;

        wORK_2 = wORK_3 * 3;
        c_PARA();
    }

    public void b_PARA() {
        cONST_PI = Math.PI;
        Double eDT_ID = zERO;
    }

    public void c_PARA() {
        b_PARA();

        // Added
        System.out.println("Done");
    }

}
