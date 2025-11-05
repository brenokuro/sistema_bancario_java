package programa;



public class Cliente {

    private static int contador = 1;
    
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        contador++;
    }

    public static int getContador() {
    return contador;
}
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "\nNome: "+nome+"\nCPF: "+cpf+"\nEmail: "+email;
    }
}
