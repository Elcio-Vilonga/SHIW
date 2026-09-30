package co.protops.elvilon;

public class Password {
    // ATRIBUTOS
    private int id;
    private String title;
    private String username;
    private String password;
    public String obs;

    // CONSTRUTORES
    public Password() { }
    public Password(String title, String username, String password) {
        setTitle(title);
        setUsername(username);
//        this.password = password;
        setPassword(password);
    }

    public Password(int id, String title, String username, String password) {
//        this.id = id;
        setId(id);
        setTitle(title);
        setUsername(username);
//        this.password = password;
        setPassword(password);
    }


    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title.toUpperCase(); }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    // GETTERS
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPass() { return hiddenPassword(password); }

    // METODOS
    private String hiddenPassword(String password) {
        int qtd = password.length();
        String pass = password.substring(0,2) +"xxx"+ password.substring(qtd-1,qtd);
        return pass;
    }

//    public void buscarPorId(int id) {
//        System.out.println(getId() +". "+ getTitle());
//    }
}
