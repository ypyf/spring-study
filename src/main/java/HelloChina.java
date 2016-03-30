public class HelloChina {
    private String message;
    private int count;

    public void init() {
        System.out.println("call bean init method");
    }

    public void destroy() {
        System.out.println("call bean destroy method");
    }

    public void setCount(int count){
        this.count  = count;
    }

    public void getCount(){
        System.out.println("Your Count : " + count);
    }

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
