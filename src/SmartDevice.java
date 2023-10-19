import java.time.LocalDate;

/**
 * Escreva uma descrição da classe SmartDevice aqui.
 * 
 * @author (Grupo 12) 
 */

public class SmartDevice {
    
    //Variáveis de instância
    private int id;
    private int codigo_fabricante;
    private float custo_instalacao;
    private boolean estado;
    private float consumo;
    
    /**
     * Construtores da classe SmartDevice
     * Declaração de construtores por omissão (vazio), parametrizado e de cópia
     */
    
    /**
     * Construtor por omissão
     */
    public SmartDevice() {
        this.id = 0;
        this.codigo_fabricante = 0;
        this.custo_instalacao = 0;
        this.estado = false;
        this.consumo = 0;
    }

    /**
     * Construtor parametrizado
     * @param id Identificador do SmartDevice
     * @param codigo_fabricante Código do fabricante do SmartDevice
     * @param custo_instalação Custo da instalação do SmartDevice
     * @param estado Estado do SmartDevice (on, off) 
     * @param consumo Consumo de energia do SmartDevice 
     */    
    public SmartDevice(int id, int codigo_fabricante, float custo_instalacao, boolean estado, float consumo) {
        this.id = id;
        this.codigo_fabricante = codigo_fabricante;
        this.custo_instalacao = custo_instalacao;
        this.estado = estado;
        this.consumo = consumo;
    }

    /**
     * Construtor de cópia
     * Aceita como parâmetro outro SmartDevice e utiliza os métodos 
     * de acesso aos valores das variáveis de instância
     */
    public SmartDevice(SmartDevice um) {
        this.id = um.getId();
        this.codigo_fabricante = um.getCodigo_fabricante();
        this.custo_instalacao = um.getCusto_instalacao();
        this.estado = um.getEstado();
        this.consumo = um.getConsumo();
    }

    
    /**
     * Métodos de instância
     */
    /**
     * Devolve o valor do identificador do SmartDevice
     * 
     * @return valor do identificador do SmartDevice
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devolve o valor do código do fabricante do SmartDevice
     * 
     * @return valor do código do fabricante do SmartDevice
     */
    public int getCodigo_fabricante() {
        return this.codigo_fabricante;
    }

    /**
     * Devolve o valor do custo da instalação do SmartDevice
     * 
     * @return valor do custo da instalação do SmartDevice
     */
    public float getCusto_instalacao() {
        return this.custo_instalacao;
    }

    /**
     * Devolve o estado do SmartDevice 
     * 
     * @return estado do SmartDevice
     */
    public boolean getEstado() {
        return this.estado;
    }

     /**
     * Devolve o valor do consumo do SmartDevice
     * 
     * @return valor do consumo do SmartDevice
     */
    public float getConsumo() {
        return this.consumo;
    }

    /**
     * Atualiza o valor do identificador do SmartDevice
     * 
     * @param id Novo valor do identificador do SmartDevice
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atualiza o valor do código do fabricante do SmartDevice
     * 
     * @param codigo_fabricante Novo valor do código do fabricante do SmartDevice
     */
    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    /**
     * Atualiza o valor do custo de instalação do SmartDevice
     * 
     * @param custo_instalacao Novo valor do custo de instalação do SmartDevice
     */
    public void setCusto_instalacao(float custo_instalacao) {
        this.custo_instalacao = custo_instalacao;
    }

    /**
     * Atualiza o estado do SmartDevice
     * 
     * @param estado Novo estado do SmartDevice
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Atualiza o valor do consumo de energia do SmartDevice
     * 
     * @param consumo Novo valor do consumo de energia do SmartDevice
     */
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    /**
     * Método de igualdade entre dois SmartDevices
     * 
     * @param o SmartDevice que é comparado com o recetor
     * @return boolean True ou False
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o==null) || (this.getClass() != o.getClass() )) return false;
        SmartDevice n = (SmartDevice) o;
        return (this.id == n.getId() && this.codigo_fabricante == n.getCodigo_fabricante()
                && this.custo_instalacao == n.getCusto_instalacao()
                && this.estado == n.getEstado() && this.consumo == n.getConsumo());
    }

    /**
     * Método que devolve a representação em String do SmartDevice
     * 
     * @return String com a informação do SmartDevice
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("SmartDevice:\n");
        sb.append("id: ").append(this.id).append("\nCodigo Fabricante: ").append(this.codigo_fabricante);
        sb.append("\nCusto Instalação: ").append(this.custo_instalacao).append("\nEstado: ");
        if (this.getEstado() == true) sb.append("On");
        else sb.append("Off");
        sb.append("\nConsumo: ").append(this.consumo);
        return sb.toString();
    }

    /**
     * Método que faz uma cópia do objeto recetor da mensagem
     * Para tal invoca o construtor de cópia
     * 
     * @return objeto clone do objeto que recebe a mensagem
     */
    public SmartDevice clone() {
        return new SmartDevice(this);
    }
    
    /**
     * Altera o estado do dispositivo
     */
    public void turnOn() {
        this.setEstado(true);
    }

    /**
     * Altera o estado do dispositivo
     */
    public void turnOff() {
        this.setEstado(false);
    }

    /**
     * Calcula o consumo do dispositivo
     */
    public float calcConsumo(LocalDate data_atual, LocalDate data_antiga) {
        return 0;
    }

    /**
     * Método que devolve a representação em String do SmartDevice
     * para guardar num ficheiro de texto
     */
    public String toStringLog() {
        return "";
    }

}
