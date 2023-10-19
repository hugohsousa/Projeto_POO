
/**
 * Escreva uma descrição da classe Supplier aqui.
 * 
 * @author (Grupo 12) 
 */
public class Supplier {
    
    //Variáveis de instância
    private int id;
    private String nome;
    private float custo;
    
    /**
     * /**
     * Construtores da classe SmartDevice
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
     */
    
    /**
     * Construtor por omissão
     */
    public Supplier() {
        this.id = 0;
        this.nome = "";
        this.custo = 0;
    }

    /**
     * Construtor parametrizado
     * @param id Identificador do Supplier
     * @param nome Nome do Supplier
     * @param custo Custo do Supplier
     */
    public Supplier(int id, String nome, float custo) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro Supplier e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public Supplier(Supplier um) {
        this.id = um.getId();
        this.nome = um.getNome();
        this.custo = um.getCusto();
    }

    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor do identificador do Supplier
     * 
     * @return valor do identificador do Supplier
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devolve o nome do Supplier
     * 
     * @return nome do Supplier
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve o valor do custo do Supplier
     * 
     * @return valor do custo do Supplier
     */
    public float getCusto() {
        return this.custo;
    }

    /**
     * Atualiza o valor do identificador do Supplier
     * 
     * @param id Novo valor do identificador do Supplier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atualiza o nome do Supplier
     * 
     * @param nome Novo nome do Supplier
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atualiza o valor do custo do Supplier
     * 
     * @param custo Novo valor do custo do Supplier
     */
    public void setCusto(float custo) {
        this.custo = custo;
    }

    /**
     * Método de igualdade entre dois Supplier
     * 
     * @param o Supplier que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        Supplier n = (Supplier) o;
        return (this.id == n.getId() && this.nome.equals(n.getNome()) && this.custo == n.getCusto());
    }

    /**
     * Método que devolve a representação em String do Supplier
     * 
     * @return String com a informação do Supplier
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fornecedor: ").append(this.id);
        sb.append("\nNome: ").append(this.nome.toString());
        sb.append("\nCusto: ").append(this.custo).append("\n");
        return sb.toString();
    }
    
    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public Supplier clone() {
        return new Supplier(this);
    }

    /**
     * Método que devolve a representação em String do Ssupplier
     * para guardar num ficheiro de texto
     */
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fornecedor:").append(this.nome);
        return sb.toString();
    }  
}
