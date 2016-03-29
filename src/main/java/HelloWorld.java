public class HelloWorld {
    private String message;

    public void init() {
        System.out.println("call bean init method");
    }

    public void destroy() {
        System.out.println("call bean destroy method");
    }

    public void setMessage(String message){
        this.message  = message;
    }

    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
