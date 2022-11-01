
import java.util.Scanner;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;


/**
 *
 * @author Adriana
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ClienteDAO dao = new ClienteDAO();
        try (Scanner teclado = new Scanner(System.in)) {
            int opcao;
            do {
                System.out.println("1-Listar 2-Incluir 3-Excluir 0-Sair");
                opcao = teclado.nextInt();
                teclado.nextLine();
                switch(opcao) {
                    case 1 -> {
                        System.out.println("====>Lista de Clientes");
                        
                        for(Cliente c: dao.getCliente()) {
                            System.out.println("Nome: " + c.getNome());
                            System.out.println("Destino: "+ c.getDestino());
                            System.out.println("Idade: "+ c.getIdade());
                            System.out.println("Email:"+ c.getEmail());
                            System.out.println("************************");
                        
                        System.out.println("====>Final da Lista");
                       dao.getCliente();
                       }
                    }
                    case 2 -> {
                        Cliente c = new Cliente();
                        System.out.println("Nome: ");
                        c.setNome(teclado.nextLine());
                        System.out.println("Idade: ");
                        c.setIdade(teclado.nextInt());
                        System.out.println("Email: ");
                        c.setEmail(teclado.nextLine());
                        System.out.println("Destino: ");
                        c.setDestino(teclado.nextLine());
                        System.out.println();
                        dao.save(c);
                    }
                    case 3 -> {
                        System.out.println("Qual o id?");
                        int id = teclado.nextInt();
                        System.out.println();
                        dao.removeById(id);
                    }
                }
            }while(opcao!=0);
        }
	}

}
    

    
    

