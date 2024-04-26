Drop table if exists Client, Commande, Paiement, lignecommande,produit;

CREATE TABLE Client (
    idClient SERIAL PRIMARY KEY,
    nom TEXT NOT NULL,
    prenom TEXT NOT NULL,
    adresse TEXT NOT NULL,
    identifiant text not null,
    motdepasse text not null
);

-- Table Produits
CREATE TABLE Produit (
    idProduit SERIAL PRIMARY KEY,
    nomProduit TEXT NOT NULL,
    description text not null,
    prix FLOAT NOT NULL,
    urlImage text not null

);

-- Table Commandes
CREATE TABLE Commande (
    idCommande SERIAL PRIMARY KEY,
    idClient INT NOT NULL REFERENCES Client(idClient),
    dateCommande DATE NOT NULL
);

-- Table LigneCommande pour g�rer les relations Commande-Produit
CREATE TABLE LigneCommande (
    idCommande INT NOT NULL REFERENCES Commande(idCommande),
    idProduit INT NOT NULL REFERENCES Produit(idProduit),
    quantite INT NOT NULL,
    PRIMARY KEY (idCommande, idProduit)
);

-- Table Paiements
CREATE TABLE Paiement (
    idPaiement SERIAL PRIMARY KEY,
    idCommande INT NOT NULL REFERENCES Commande(idCommande),
    montant float NOT NULL
);


-- Insérer les clients
INSERT INTO Client (nom, prenom, adresse, identifiant, motdepasse) VALUES
('Dupont', 'Jean', '123 rue Lafayette, Paris', 'jeand', 'password123'),
('Martin', 'Alice', '456 avenue Champs-Élysées, Paris', 'aliceM', 'password123'),
('Bernard', 'Marc', '789 boulevard Voltaire, Lyon', 'marcB', 'password123'),
('Thomas', 'Julie', '321 rue de Rivoli, Marseille', 'julieT', 'password123'),
('Petit', 'Lucas', '654 rue Saint Antoine, Toulouse', 'lucasP', 'password123'),
('Robert', 'Émilie', '987 rue du Faubourg, Nice', 'emilieR', 'password123'),
('Richard', 'François', '123 rue Royale, Nantes', 'francoisR', 'password123'),
('Durand', 'Charlotte', '456 rue de l''Université, Strasbourg', 'charlotteD', 'password123'),
('Moreau', 'Claire', '789 avenue Jean Jaurès, Montpellier', 'claireM', 'password123'),
('Simon', 'Nicolas', '321 boulevard Gambetta, Lille', 'nicolasS', 'password123');

-- Insérer les produits
INSERT INTO Produit (nomProduit, description, prix, urlImage) VALUES
('Chaise', 'Une belle chaise confortable', 75.0, '/assets/image_produit/chaise.png'),
('Table', 'Table en bois robuste', 150.0, '/assets/image_produit/table.png'),
('Lampe', 'Lampe de bureau moderne', 22.5, '/assets/image_produit/lampe.png'),
('Ordinateur', 'Ordinateur de dernière génération', 899.99, '/assets/image_produit/ordinateur.png'),
('Téléphone', 'Téléphone intelligent haute performance', 499.99, '/assets/image_produit/telephone.png'),
('Tapis', 'Tapis doux et élégant', 89.99, '/assets/image_produit/tapis.png'),
('Coussin', 'Coussin confortable pour votre canapé', 19.99, '/assets/image_produit/coussin.png'),
('Horloge', 'Horloge murale classique', 34.99, '/assets/image_produit/horloge.png'),
('Vase', 'Vase décoratif en céramique', 47.99, '/assets/image_produit/vase.png'),
('Livre', 'Livre captivant et enrichissant', 29.99, '/assets/image_produit/livre.png');

-- Insérer les commandes
INSERT INTO Commande (idClient, dateCommande) VALUES 
(1, '2023-04-01'), (2, '2023-04-02'), (3, '2023-04-03'), (4, '2023-04-04'),
(5, '2023-04-05'), (6, '2023-04-06'), (7, '2023-04-07'), (8, '2023-04-08'),
(9, '2023-04-09'), (10, '2023-04-10');

-- Insérer les lignes de commande
INSERT INTO LigneCommande (idCommande, idProduit, quantite) VALUES 
(1, 1, 4), (1, 2, 1), (2, 3, 2), (2, 4, 1), 
(3, 5, 1), (4, 6, 3), (5, 7, 2), (6, 8, 1), 
(7, 9, 1), (8, 10, 5);

-- Insérer les paiements
INSERT INTO Paiement (idCommande, montant) VALUES 
(1, 500.0), (2, 922.49), (3, 499.99), (4, 269.97), 
(5, 39.98), (6, 34.99), (7, 47.99), (8, 149.95), 
(9, 34.99), (10, 749.95);



SELECT setval('client_idclient_seq', (SELECT MAX(idClient) FROM Client));
SELECT setval('produit_idproduit_seq', (SELECT MAX(idProduit) FROM produit));
SELECT setval('commande_idcommande_seq', (SELECT MAX(idCommande) FROM commande));
SELECT setval('paiement_idpaiement_seq', (SELECT MAX(idPaiement) FROM paiement));