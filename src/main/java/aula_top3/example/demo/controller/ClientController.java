package aula_top3.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    List <Client> clientes = new ArrayList<Client>();

    @PostConstruct
    public void criarClientes(){
        Client c1 = new Client();
        Client c2 = new Client();
        Client c3 = new Client();

        c1.cod = 1;
        c1.nome = "Tony";
        c1.endereco = "rua Aracoiaba";
        c1.saldo = 200;
    
        c2.cod = 2;
        c2.nome = "Yoda";
        c2.endereco = "rua rua";
        c2.saldo = 300;
        
        c3.cod = 3;
        c3.nome = "Beck";
        c3.endereco = "rua becklandia";
        c3.saldo = 400;
        
        clientes = Arrays.asList(c1,c2,c3);
    }

  @GetMapping("/clientes")
    public List<Client> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{codigo}")
    public Client getClientes1(@PathVariable int codigo){
        Client cli=null;

        for(Client aux: clientes){
            if(aux.cod == codigo){
                cli = aux;
                break;
            }
        }
        return cli;
    }
}