package com.example.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    private ClientBDD clientBDD;


    @GetMapping(value = "/Clients")
    public List<Client> listeClient() {
        return clientBDD.findAll();
    }

    @GetMapping(value = "/Clients/{id}")
    public ResponseEntity<Client> afficherClient(@PathVariable String id) {
        Optional<Client> client = clientBDD.findById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/Clients/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable String id) {
        if (clientBDD.existsById(id)) {
            clientBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/Clients")
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        Client nouveauClient = clientBDD.save(client);
        return new ResponseEntity<>(nouveauClient, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/Clients")
    public ResponseEntity<Void> supprimerTousClients() {
        clientBDD.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
