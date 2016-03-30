public class Book {
    private String title;

    public void init() {
        System.out.println("call bean book init method");
    }

    public void destroy() {
        System.out.println("call bean book destroy method");
    }

    public void setTitle(String title){
        this.title  = title;
    }

    public void getTitle(){
        System.out.println("Book title : " + title);
    }
}
