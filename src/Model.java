import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Escreva uma descrição da classe SmartSpeaker aqui.
 * 
 * @author (Grupo 12)
 */
public class Model {
    //Variáveis de instância
    private Map<Integer, Comunidade> comunidades = new HashMap<Integer, Comunidade>();
    private Map<Integer, Supplier> suppliers = new HashMap<Integer, Supplier>();
    private int nrcomunidades;
    private int nrsuppliers;
    private LocalDate data_atual;
    private LocalDate data_antiga;

    /**
    * Construtores da classe Model
    * Declaração do construtor por omissão (vazio)
    */
    public Model() {
        this.comunidades = new HashMap<Integer, Comunidade>();
        this.data_atual = LocalDate.now();
        this.data_antiga = LocalDate.now();
        this.suppliers = new HashMap<Integer, Supplier>();
        this.nrcomunidades = 0;
        this.nrsuppliers = 0;
    }

    /**
    * Método que devolve a representação em String dos suppliers
    * @return String com a informação dos suppliers
    */
    public String showSuppliers() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Supplier> entry : this.suppliers.entrySet()) {
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
    * Método para adicionar um Supplier
    * @param nome String com o nome do supplier
    * @param custo Float com o custo cobrado por kWh
    */
    public void addSupplier(String nome, float custo) {
        suppliers.put(nrsuppliers, new Supplier(nrsuppliers, nome, custo));
        this.nrsuppliers++;
    }

    /**
    * Método que devolve a representação em String das Comunidades
    * @return String com a informação das comunidades
    */
    public String showComunidades() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Comunidade> entry : this.comunidades.entrySet()) {
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
    * Método para adicionar uma comunidade
    */
    public void addComunidade() {
        Map<Integer, House> casas = new HashMap<Integer, House>();
        this.comunidades.put(nrcomunidades, new Comunidade(nrcomunidades, casas));
        this.nrcomunidades++;
    }

    /**
    * Método que devolve a representação em String das casas de uma comunidade
    * @param n Id da comunidade
    * @return String com a informação das casas
    */
    public String verCasasComunidade(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(comunidades.get(n).toString());
        return sb.toString();
    }

    /**
     * Método para adicionar uma casa
     * @param n Id da comunidade
     * @param nome Nome do propriatário
     * @param nif Nif do propriatário
     * @param fornecedor Nome do fornecedor de energia
     */
    public void addHouse(int n, String nome, int nif, String fornecedor) {
        if(comunidades.containsKey(n) == false) {
            this.addComunidade();
        }

        Supplier s = new Supplier();
        for (HashMap.Entry<Integer, Supplier> entry : suppliers.entrySet()) {
            if(entry.getValue().getNome().equals(fornecedor)) {
                s = entry.getValue();
            }
        }
        comunidades.get(n).addHouse(nome, nif,s);
    }

    /**
     * Método que devolve uma string com todos os dispositivos de uma casa
     * @param n Id da comunidade
     * @param idCasa Id da casa
     * @return String com a informação sobre os dispositivos
     */
    public String showDispositivos(int n, int idCasa) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, House> casas = comunidades.get(n).getCasas();
        for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
            if (entry.getKey() == idCasa)
                sb.append(entry.getValue().toString());
        }
        return sb.toString();
    }

    /**
     * Método para adicionar um dispositivo
     * @param i Id da comunidade
     * @param j Id da Casa
     * @param div Divisão em que se encontra
     * @param args Argumentos para o dispositivo
     */
    public void addDispositivo(int i, int j, String div, String[] args) {
        if(comunidades.containsKey(i) == false) {
            this.addComunidade();
        }
        Map<Integer, House> casas = comunidades.get(i).getCasas();
        switch (Integer.parseInt(args[0])) {
            case 1:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartBulb(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),
                                Integer.parseInt(args[7]), div);
                    }
                }
                break;
            case 2:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartCamera(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]), div);
                    }
                }
                break;
            case 3:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartSpeaker(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Integer.parseInt(args[5]), args[6],
                                args[7], div);
                    }
                }
                break;
            case 4:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartTv(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),
                                Integer.parseInt(args[7]), Float.parseFloat(args[8]), div);
                    }
                }
                break;
            case 5:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartVacuum(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),
                                Integer.parseInt(args[7]), div);
                    }
                }
                break;
            case 6:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartAc(Integer.parseInt(args[1]), Float.parseFloat(args[2]), args[3],
                                Float.parseFloat(args[4]), Float.parseFloat(args[5]),args[6],div);
                    }
                }
                break;
            default:
        }
    }

    /**
     * Método para ligar todos os dispositivos de uma casa
     * @param idregiao Id da comunidade
     * @param idcasa Id da casa
     */
    public void turnAllOn(int idregiao, int idcasa) {
        comunidades.get(idregiao).turnAllOn(idcasa);
    }

    /**
     * Método para desligar todos os dispositivos de uma casa
     * @param idregiao Id da comuniade
     * @param idcasa Id da casa
     */
    public void turnAllOff(int idregiao, int idcasa) {
        comunidades.get(idregiao).turnAllOff(idcasa);
    }

    /**
     * Método para ligar um dispositivo
     * @param idregiao Id da comunidade
     * @param idcasa Id da casa
     * @param idd Id do dispositivo
     */
    public void turnOneOn(int idregiao, int idcasa, int idd) {
        comunidades.get(idregiao).turnOneOn(idcasa, idd);
    }

    /**
     * Método para desligar um dispositivo
     * @param idregiao Id da comunidade
     * @param idcasa Id da casa
     * @param idd Id do dispositivo
     */
    public void turnOneOff(int idregiao, int idcasa, int idd) {
        comunidades.get(idregiao).turnOneOff(idcasa, idd);
    }

    /**
     * Método para alterar a data
     * @param n Número de dias a avançar
     */
    public void changeData(int n) {
        this.data_antiga = this.data_atual;
        this.data_atual = this.data_atual.plusDays(n);
    }

    /**
     * Método para calcular o consumo de um dispositivo
     * @param idregiao Id da comunidade
     * @param idcasa Id da casa
     * @param idd Id do dispositivo
     * @return
     */
    public float calcConsumoDispositivo(int idregiao, int idcasa, int idd) {
        return comunidades.get(idregiao).calcConsumoDispositivo(idcasa, idd,data_antiga,data_atual);
    }

    /**
     * Método para adicionar dispositivos provenientes de um estado guardado
     * @param m tipo de dispositivo
     * @param i Id da comunidade
     * @param j Id da casa
     * @param div Divisão onde está o dispositivo
     * @param args Argumentos do dispositivo
     */
    public void addDispositivoLog(int m,int i, int j, String div, String[] args) {
        if(comunidades.containsKey(i) == false) {
            this.addComunidade();
        }
        String[] arr = {"On","Off"};
        Random random = new Random();
        Map<Integer, House> casas = comunidades.get(i).getCasas();
        switch (m) {
            case 1:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartBulb(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                                Float.parseFloat(args[2]), div);
                    }
                }
                break;
            case 2:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartCamera(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Integer.parseInt(args[0]), Integer.parseInt(args[1]), div);
                    }
                }
                break;
            case 3:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartSpeaker(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Integer.parseInt(args[0]), args[1],
                                args[2], div);
                    }
                }
                break;
            case 4:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartTv(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                                Integer.parseInt(args[2]), Float.parseFloat(args[3]), div);
                    }
                }
                break;
            case 5:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartVacuum(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                                Integer.parseInt(args[2]), div);
                    }
                }
                break;
            case 6:
                for (HashMap.Entry<Integer, House> entry : casas.entrySet()) {
                    if (entry.getKey() == j) {
                        entry.getValue().addSmartAc(ThreadLocalRandom.current().nextInt(1, 100 + 1)
                        , 1 + new Random().nextFloat() * (100 - 1), arr[random.nextInt(arr.length)],
                        1 + new Random().nextFloat() * (300 - 1), Float.parseFloat(args[0]),args[1],div);
                    }
                }
                break;
            default:
        }
    }

    /**
     * Método que devolve informações sobre os suppliers para ser guardado o estado
     * @return String com a informação do dispositivo
     */
    public String showSuppliersLog() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Supplier> entry : this.suppliers.entrySet()) {
            sb.append(entry.getValue().toStringLog());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Método que devolve informações sobre os comunidades para ser guardado o estado
     * @return String com a inrformação do dispositivo
     */
    public String showComunidadesLog() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Comunidade> entry : this.comunidades.entrySet()) {
            sb.append(entry.getValue().toStringLog());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Método para calcular o consumo em euros de um dispositivo
     * @param idregiao Id da comunidade
     * @param idcasa Id da casa
     * @param idd Id do dispositivo
     * @return Valor do consumo em euros
     */
    public float calcConsumoDispositivoEur(int idregiao, int idcasa, int idd) {
        return comunidades.get(idregiao).calcConsumoDispositivoEur(idcasa, idd,data_antiga,data_atual);
    }

    /**
     * Método para devolver os dias que foram avançadas desde a ultima vez
     * @return Número de dias que foram avançados
     */
    public int getDays() {
        return (int) ChronoUnit.DAYS.between(data_antiga, data_atual);
    }

    /**
     * Método para calcular o consumo em kWh de uma casa
     * @param idregiao Id comunidade
     * @param idcasa Id casa
     * @return valor em kWh do consumo de energia da casa
     */
    public float calcConsumoCasa(int idregiao, int idcasa) {
        return comunidades.get(idregiao).calcConsumoCasa(idcasa,data_antiga,data_atual);
    }

    /**
     * Método para calcular o consumo em euros de uma casa
     * @param idregiao Id comunidade
     * @param idcasa Id casa
     * @return valor em euros do consumo de energia da casa
     */
    public float calcConsumoCasaEur(int idregiao, int idcasa) {
        return comunidades.get(idregiao).calcConsumoCasaEur(idcasa,data_antiga,data_atual);
    }

}
