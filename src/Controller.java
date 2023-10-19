import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Escreva uma descrição da classe SmartSpeaker aqui.
 * 
 * @author (Grupo 12)
 */
public class Controller {
    //Variáveis de instância
    private Model model;
    /**
     * Construtor parametrizado
     * @param model Model que será usado pelo controller
     */
    public Controller(Model model) {
        this.model = model;
    }

    /**
    * Método que devolve a representação em String das Comunidades
    * @return String com a informação das comunidades
    */
    public String showComunidades() {     
        return model.showComunidades();
    }

    /**
    * Método para adicionar uma comunidade
    */
    public void addComunidade() {
        model.addComunidade();
    }

    /**
    * Método que devolve a representação em String das casas de uma comunidade
    * @param text Informação da comunidade
    * @return String com a informação das casas
    */
    public String verCasasComunidade(String text) {
        return model.verCasasComunidade(Integer.parseInt(text));
    }

    /**
    * Método para adicionar uma casa
    * @param args Argumentos para ciar a casa
    */
    public void addHouse(String[] args) {
        model.addHouse(Integer.parseInt(args[0]),args[1],Integer.parseInt(args[2]),args[3]);
    }

    /**
    * Método que devolve a representação em String dos dispositivos de uma casa
    * @return String com a informação dos dispositivos
    */
    public String showDispositivos(String idregiao, String idCasa) {
        return model.showDispositivos(Integer.parseInt(idregiao),Integer.parseInt(idCasa));
    }

    /**
    * Método para adicionar um SmartDevice
    * @param args Argumentos para ciar o SmartDevice
    */
    public void addDispositivo(String[] ids, String[] args) {
        model.addDispositivo(Integer.parseInt(ids[0]),Integer.parseInt(ids[1]),ids[2],args);
    }

    /**
    * Método que devolve a representação em String dos suppliers
    * @return String com a informação dos suppliers
    */
    public String showSuppliers() {
        return model.showSuppliers();
    }

    /**
    * Método para adicionar um Supplier
    * @param args Argumentos para ciar o Supplier
    */
    public void addSupplier(String[] args) {
        if(args.length == 2) {
            model.addSupplier(args[0],Float.parseFloat(args[1]));
        } else {
            model.addSupplier(args[0],0 + new Random().nextFloat() * (1 - 0));
        };
    }

    /**
    * Método para ligar todos os dispositivos de uma casa
    * @param args Argumentos para encontrar a casa
    */
    public void turnAllOn(String[] args) {
        model.turnAllOn(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }

    /**
    * Método para desligar todos os dispositivos de uma casa
    * @param args Argumentos para encontrar a casa
    */
    public void turnAllOff(String[] args) {
        model.turnAllOff(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }

    /**
    * Método para ligar um dispositivo de uma casa
    * @param args Argumentos para encontrar a casa e o dispositivo
    */
    public void turnOneOn(String[] args) {
        model.turnOneOn(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    }

    /**
    * Método para desligar um dispositivo de uma casa
    * @param args Argumentos para encontrar a casa e o dispositivo
    */
    public void turnOneOff(String[] args) {
        model.turnOneOff(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    }

    /**
    * Método para alterar a data do programa
    * @param input Número de dias a avançar
    */
    public void changeData(String input) {
        model.changeData(Integer.parseInt(input));
    }

    /**
    * Método para calcular o consumo de um dispositivo
    * @param args Argumentos para encontrar o dispositivo
    * @return Valor em kWh do consumo
    */
    public float calcConsumoDispositivo(String[] args) {
        return model.calcConsumoDispositivo(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    }

    /**
    * Método para calcular o consumo em euros de um dispositivo
    * @param args Argumentos para encontrar o dispositivo
    * @return Valor em euros do consumo
    */
    public float calcConsumoDispositivoEur(String[] args) {
        return model.calcConsumoDispositivoEur(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
    }

    /**
    * Método para carregar um ficheiro com dados
    * @param string Nome do ficheiro
    * @throws FileNotFoundException Exceção caso o ficheiro não exista
    * @throws IOException Exceção caso falhe a escrita
    */
    public void loadFile(String string) throws FileNotFoundException, IOException {
        int c = 0;
        int casa = 0;
        String divisao = "";
        File file = new File(string);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String args[] = line.split(":",20);
                if(args[0].equals("Fornecedor")) {
                    args = args[1].split(",",2);
                    if(args.length == 2) model.addSupplier(args[0],Float.parseFloat(args[1]));
                    else model.addSupplier(args[0],0 + new Random().nextFloat() * (1 - 0));
                }
                if(args[0].equals("Casa")) {
                    args = args[1].split(",",3);
                    model.addHouse(c,args[0],Integer.parseInt(args[1]),args[2]);
                    casa++;
                }
                if(args[0].equals("Comunidade: ")) {
                    model.addComunidade();
                    c++;
                }
                if(args[0].equals("Divisao")) {
                    divisao = args[1];
                }
                if(args[0].equals("SmartBulb")) {
                    args = args[1].split(",",10);
                    if(args[0].equals("Warm")) {
                        args[0] = "1";
                    }
                    if(args[0].equals("Neutral")) {
                        args[0] = "0";
                    }
                    if(args[0].equals("Cold")) {
                        args[0] = "-1";
                    }
                    model.addDispositivoLog(1,c, casa, divisao, args);
                }
                if(args[0].equals("SmartCamera")) {
                    args = args[1].split(",",10);
                    String n[] = args[0].split("x",2);
                    if(n.length == 2) {
                        n[0] = n[0].replace("(","");
                        n[1] = n[1].replace(")","");
                        args[0] = Integer.toString(Integer.parseInt(n[0])*Integer.parseInt(n[1]));
                    }
                    model.addDispositivoLog(2,c, casa, divisao, args);
                }
                if(args[0].equals("SmartSpeaker")) {
                    args = args[1].split(",",10);
                    model.addDispositivoLog(3,c, casa, divisao, args);
                }
                if(args[0].equals("SmartTv")) {
                    args = args[1].split(",",10);
                    model.addDispositivoLog(4,c, casa, divisao, args);
                }
                if(args[0].equals("SmartVacuum")) {
                    args = args[1].split(",",10);
                    model.addDispositivoLog(5,c, casa, divisao, args);
                }
                if(args[0].equals("SmartAc")) {
                    args = args[1].split(",",10);
                    model.addDispositivoLog(6,c, casa, divisao, args);
                }
            }
        }
    }

    /**
     * Método para guardar o estado do programa em um ficheiro
     * @param string Nome do ficheiro
     * @throws IOException Exceção caso a escrita falhe
     */
    public void saveFile(String string) throws IOException {
        FileWriter myWriter = new FileWriter(string);
        String suppliers = model.showSuppliersLog();
        myWriter.write(suppliers);

        String c = model.showComunidadesLog();
        myWriter.write(c);

        myWriter.close();
    }

    /**
    * Método para calcular o número de dias avançados
    * @return Devolve um int com o número de dias foram avançados
    */
    public int getDays() {
        return model.getDays();
    }

    /**
    * Método para calcular o consumo de uma casa
    * @param args Argumentos para encontrar a casa
    * @return Valor em kWh do consumo
    */
    public float calcConsumoCasa(String[] args) {
        return model.calcConsumoCasa(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }

    /**
    * Método para calcular o consumo de uma casa
    * @param args Argumentos para encontrar de uma casa
    * @return Valor em euros do consumo
    */
    public float calcConsumoCasaEur(String[] args) {
        return model.calcConsumoCasaEur(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}

