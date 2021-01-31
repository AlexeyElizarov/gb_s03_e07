public class TestCaseB {


    @Test(priority = 1)
    public void test1(){
        System.out.println("Testing");
    }

    @Test(priority = 50)
    public void test2(){
        System.out.println("Testing");
    }

    @Test(priority = 8)
    public void test8(){
        System.out.println("Testing");
    }

    @Test(priority = 8)
    public void test9(){
        System.out.println("Testing");
    }

    @Test
    public void test3(){
        System.out.println("Testing");
    }

    @BeforeSuite
    public void preprocess2() {
        System.out.println("Preprocessing");
    }

    @BeforeSuite
    public void preprocess() {
        System.out.println("Preprocessing");
    }

    @AfterSuite
    public void postprocess() {
        System.out.println("Postprocessing");
    }

}
