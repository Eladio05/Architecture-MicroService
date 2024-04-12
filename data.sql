Drop table if exists Client, Commande, Paiement, lignecommande,produit

CREATE TABLE Client (
    idClient INT PRIMARY KEY,
    nom TEXT NOT NULL,
    prenom TEXT NOT NULL,
    adresse TEXT NOT NULL
);

-- Table Produits
CREATE TABLE Produit (
    idProduit INT PRIMARY KEY,
    nomProduit TEXT NOT NULL,
    prix FLOAT NOT NULL
);

-- Table Commandes
CREATE TABLE Commande (
    idCommande INT PRIMARY KEY,
    idClient INT NOT NULL REFERENCES Client(idClient),
    dateCommande DATE NOT NULL
);

-- Table LigneCommande pour gérer les relations Commande-Produit
CREATE TABLE LigneCommande (
    idCommande INT NOT NULL REFERENCES Commande(idCommande),
    idProduit INT NOT NULL REFERENCES Produit(idProduit),
    quantite INT NOT NULL,
    PRIMARY KEY (idCommande, idProduit)
);

-- Table Paiements
CREATE TABLE Paiement (
    idPaiement INT PRIMARY KEY,
    idCommande INT NOT NULL REFERENCES Commande(idCommande),
    montant float NOT NULL
);


INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (1, 'Dupont', 'Jean', '123 rue Lafayette, Paris');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (2, 'Martin', 'Alice', '456 avenue Champs-Élysées, Paris');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (3, 'Bernard', 'Marc', '789 boulevard Voltaire, Lyon');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (4, 'Thomas', 'Julie', '321 rue de Rivoli, Marseille');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (5, 'Petit', 'Lucas', '654 rue Saint Antoine, Toulouse');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (6, 'Robert', 'Émilie', '987 rue du Faubourg, Nice');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (7, 'Richard', 'François', '123 rue Royale, Nantes');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (8, 'Durand', 'Charlotte', '456 rue de l’Université, Strasbourg');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (9, 'Moreau', 'Claire', '789 avenue Jean Jaurès, Montpellier');
INSERT INTO Client (idClient, nom, prenom, adresse) VALUES (10, 'Simon', 'Nicolas', '321 boulevard Gambetta, Lille');

INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (1, 'Chaise', 75.0);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (2, 'Table', 150.0);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (3, 'Lampe', 22.5);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (4, 'Ordinateur', 899.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (5, 'Téléphone', 499.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (6, 'Tapis', 89.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (7, 'Coussin', 19.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (8, 'Horloge', 34.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (9, 'Vase', 47.99);
INSERT INTO Produit (idProduit, nomProduit, prix) VALUES (10, 'Livre', 29.99);

INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (1, 1, '2023-04-01');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (2, 2, '2023-04-02');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (3, 3, '2023-04-03');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (4, 4, '2023-04-04');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (5, 5, '2023-04-05');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (6, 6, '2023-04-06');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (7, 7, '2023-04-07');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (8, 8, '2023-04-08');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (9, 9, '2023-04-09');
INSERT INTO Commande (idCommande, idClient, dateCommande) VALUES (10, 10, '2023-04-10');

-- Chaque commande peut maintenant avoir plusieurs lignes pour différents produits.
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (1, 1, 4);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (1, 2, 1);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (2, 3, 2);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (2, 4, 1);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (3, 5, 1);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (4, 6, 3);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (5, 7, 2);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (6, 8, 1);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (7, 9, 1);
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES (8, 10, 5);

INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (1, 1, 500.0);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (2, 2, 922.49);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (3, 3, 499.99);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (4, 4, 269.97);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (5, 5, 39.98);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (6, 6, 34.99);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (7, 7, 47.99);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (8, 8, 149.95);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (9, 9, 34.99);
INSERT INTO Paiement (idPaiement, idCommande, montant) VALUES (10, 10, 749.95);
