package Lab2;

public class SimpleObject {

    private String name;
    private int param;

    public SimpleObject(){
        name = "withoutName";
        param = 0;
    }

    public SimpleObject(String name,int param){
        this.name = name;
        this.param = param;
    }

    @Annotation(2)
    public void setName (String name) {
        this.name = name;
        System.out.println("setName Method, new name is " + name);
    }

    public String getName () {
        System.out.println("getName Method,new name is " + name);
        return name;
    }

    @Annotation(2)
    protected void increaseParam (int multiplier) {
        param *= multiplier;
        System.out.println("increaseParam Method, new param is " + param);
    }
    @Annotation(5)
    protected void reverseName () {
        name = new StringBuilder(name).reverse().toString();
        System.out.println("reverseName Method, new name is " + name);
    }

    @Annotation(2)
    private void setParam (int param) {
        this.param = param;
        System.out.println("setParam Method, new param is " + param);
    }

    private int getParam () {
        System.out.println("getParam Method,new param is " + param);
        return param;
    }

    @Annotation(3)
    private void bigChange (String name, int param) {
        this.name = name;
        this.param = param;
        System.out.println("bigChange Method, new name is " + name + ", param is " + param);
    }
}
