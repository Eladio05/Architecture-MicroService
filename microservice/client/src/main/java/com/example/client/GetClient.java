package com.example.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Arrays;

@RestController
public class GetClient {

    public static class Client {
        private long id;
        private String mail;

        public Client(long id, String mail) {
            this.id = id;
            this.mail = mail;
        }

        @JsonProperty
        public long getId() {
            return id;
        }

        @JsonProperty
        public String getNom() {
            return mail;
        }

    }

    @GetMapping("/client")
    public List<Client> getListeClients() {
        return Arrays.asList(
            new Client(1, "johnWeak@yahoo.com"),
            new Client(2, "TonyStark@bing.com"),
            new Client(3, "christianClavier@msn.com")
        );
    }
}