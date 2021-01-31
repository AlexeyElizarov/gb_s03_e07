public class TestCaseD {


    @Test(priority = 3)
    public void test1(){
        System.out.println("Testing");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Testing");
    }

    @Test(priority = 7)
    public void test3(){
        System.out.println("Testing");
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
