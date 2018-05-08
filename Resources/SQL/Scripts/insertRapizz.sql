use rapizz;

INSERT INTO transports (id, nom) VALUES
    (1, 'Voiture'),
    (2, 'Scooter');

INSERT INTO livreur (id, nom,prenom) VALUES
    (1, 'Moua', 'Paul'),
    (2, 'Siarri', 'Nicolas'),
    (3, 'Lefebvre', 'Pierre'),
    (4, 'Meunier', 'Eric');

INSERT INTO clients (id, nom, prenom, adresse, ville, solde, nb_commandes) VALUES
    (1,'Jouniot','Alexandre', '22 Rue des Champs Elysees', 'Paris' ,120,7),
    (2,'Xiao', 'Yurui', '127 Place de la Bastille', 'Paris',27,10),
    (3,'Dupont','Jean','96 Parc des Sauges','Marne-La-Vallee', 0, 2),
    (4,'Mercier','Antoine', '37 Bis Rue des Rosiers','Lognes' ,10,9),
    (5,'Lezin', 'Anthony','12 Rue de Londres', 'Bordeaux' , 32,5),
    (6,'Bagayoko','David','24 Rue des artistes', 'Nantes', 0, 0);

INSERT INTO ingredients (id, nom) VALUES
    (1,'Mozzarella'),
    (2,'Sauce barbecue'),
    (3,'Pepperoni'),
    (4,'Oignons'),
    (5,'Boeuf'),
    (6,'Poulet'),
    (7,'Bacon'),
    (8,'Emmental'),
    (9,'Sauce tomate'),
    (10,'Creme fraiche'),
    (11,'Chevre'),
    (12,'Ananas'),
    (13,'Miel'),
    (14,'Saumon'),
    (15,'Pomme de terre'),
    (16,'Merguez'),
    (17,'Kebab'),
    (18,'Champignons'),
    (19,'Jambon'),
    (20,'Origan'),
    (21,'Reblochon'),
    (22,'Lardons'),
    (23,'Poivron'),
    (24,'Figue'),
    (25,'Olive');

INSERT INTO pizzas (id, nom, base_prix) VALUES
    (1,'Spicy Dallas Burger',16.0),
    (2,'Figue - Chevre',16.0),
    (3,'Saumon Ecossais',16.0),
    (4,'Cannibale', 15.0),
    (5,'Bacon Groovy',15.0),
    (6,'Street Kebab',15.0),
    (7,'Forestiere',15.0),
    (8,'Indienne',15.0),
    (9,'Chickenita Pepperoni', 15.0),
    (10,'Hypnotika',15.0),
    (11,'Hawaienne',15.0),
    (12,'Savoyarde',15.0),
    (13,'4 Fromages',15.0),
    (14,'Extravaganzza',15.0);

INSERT INTO formats_pizzas (id, nom,ratio) VALUES
    (1,'Naine',0.33),
    (2,'Humaine',1.0),
    (3,'Ogresse',1.33);

INSERT INTO livraisons (id, livreur, date_livraison, transport, statut) VALUES
    (1,(SELECT id FROM livreur WHERE nom='Moua'), '2018-05-07 12:38:05', (SELECT id FROM transports WHERE nom='Voiture'), 'terminée') ,
    (2,(SELECT id FROM livreur WHERE nom='Moua'), '2018-05-07 13:18:27', (SELECT id FROM transports WHERE nom='Voiture'), 'terminée') ,
    (3,(SELECT id FROM livreur WHERE nom='Meunier'), '2018-05-07 13:38:12' , (SELECT id FROM transports WHERE nom='Scooter'), 'terminée') ,
    (4,(SELECT id FROM livreur WHERE nom='Moua'), '2018-05-07 14:48:45' , (SELECT id FROM transports WHERE nom='Scooter'), 'terminée') ,
    (5,(SELECT id FROM livreur WHERE nom='Lefebvre'), '2018-05-08 11:57:25' , (SELECT id FROM transports WHERE nom='Voiture'), 'terminée') ,
    (6,(SELECT id FROM livreur WHERE nom='Meunier'), '2018-05-08 12:03:25', (SELECT id FROM transports WHERE nom='Voiture'), 'terminée') ,
    (7,(SELECT id FROM livreur WHERE nom='Meunier'),null , (SELECT id FROM transports WHERE nom='Scooter'), 'en cours') ,
    (8,(SELECT id FROM livreur WHERE nom='Siarri'), null , (SELECT id FROM transports WHERE nom='Voiture'), 'en cours') ,
    (9,(SELECT id FROM livreur WHERE nom='Moua'),null , (SELECT id FROM transports WHERE nom='Scooter'), 'en cours') ,
    (10,(SELECT id FROM livreur WHERE nom='Lefebvre'),null , (SELECT id FROM transports WHERE nom='Voiture'), 'en cours');

INSERT INTO commandes (id, client, pizza, taille, tarif, date_commande, livraison) VALUES
    (1,(SELECT id FROM clients WHERE nom = 'Jouniot'), (SELECT id FROM pizzas WHERE nom='Savoyarde'), (SELECT id FROM formats_pizzas WHERE nom='Naine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Savoyarde') * (SELECT ratio FROM formats_pizzas WHERE nom='Naine'), '2018-05-07 12:18:05', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-07 12:38:05')),
    (2,(SELECT id FROM clients WHERE nom = 'Xiao'), (SELECT id FROM pizzas WHERE nom='Cannibale'), (SELECT id FROM formats_pizzas WHERE nom='Humaine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Cannibale') * (SELECT ratio FROM formats_pizzas WHERE nom='Humaine'), '2018-05-07 12:38:05', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-07 13:18:27')),
    (3,(SELECT id FROM clients WHERE nom = 'Mercier'), (SELECT id FROM pizzas WHERE nom='Extravaganzza'), (SELECT id FROM formats_pizzas WHERE nom='Ogresse'), 
        (SELECT base_prix FROM pizzas WHERE nom='Extravaganzza') * (SELECT ratio FROM formats_pizzas WHERE nom='Ogresse'), '2018-05-07 13:18:05', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-07 13:38:12')),
    (4,(SELECT id FROM clients WHERE nom = 'Lezin'), (SELECT id FROM pizzas WHERE nom='Forestiere'), (SELECT id FROM formats_pizzas WHERE nom='Humaine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Forestiere') * (SELECT ratio FROM formats_pizzas WHERE nom='Humaine'), '2018-05-07 14:38:45', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-07 14:48:45')),
    (5,(SELECT id FROM clients WHERE nom = 'Bagayoko'), (SELECT id FROM pizzas WHERE nom='Indienne'), (SELECT id FROM formats_pizzas WHERE nom='Ogresse'), 
        (SELECT base_prix FROM pizzas WHERE nom='Indienne') * (SELECT ratio FROM formats_pizzas WHERE nom='Ogresse'), '2018-05-08 11:50:25', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-08 11:57:25')),
    (6,(SELECT id FROM clients WHERE nom = 'Xiao'), (SELECT id FROM pizzas WHERE nom='Hawaienne'), (SELECT id FROM formats_pizzas WHERE nom='Naine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Hawaienne') * (SELECT ratio FROM formats_pizzas WHERE nom='Naine'), '2018-05-08 12:00:25', 
        (SELECT id FROM livraisons WHERE date_livraison='2018-05-08 12:03:25')),
    (7,(SELECT id FROM clients WHERE nom = 'Jouniot'), (SELECT id FROM pizzas WHERE nom='Hypnotika'), (SELECT id FROM formats_pizzas WHERE nom='Naine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Hypnotika') * (SELECT ratio FROM formats_pizzas WHERE nom='Naine'), '2018-05-08 13:00:25', 7),
    (8,(SELECT id FROM clients WHERE nom = 'Lezin'), (SELECT id FROM pizzas WHERE nom='Figue - Chevre'), (SELECT id FROM formats_pizzas WHERE nom='Humaine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Figue - Chevre') * (SELECT ratio FROM formats_pizzas WHERE nom='Humaine'), '2018-05-08 13:23:25', 8),
    (9,(SELECT id FROM clients WHERE nom = 'Mercier'), (SELECT id FROM pizzas WHERE nom='4 Fromages'), (SELECT id FROM formats_pizzas WHERE nom='Ogresse'), 
        (SELECT base_prix FROM pizzas WHERE nom='4 Fromages') * (SELECT ratio FROM formats_pizzas WHERE nom='Ogresse'), '2018-05-08 14:23:25', 9),
    (10,(SELECT id FROM clients WHERE nom = 'Lezin'), (SELECT id FROM pizzas WHERE nom='Chickenita Pepperoni'), (SELECT id FROM formats_pizzas WHERE nom='Naine'), 
        (SELECT base_prix FROM pizzas WHERE nom='Chickenita Pepperoni') * (SELECT ratio FROM formats_pizzas WHERE nom='Naine'), '2018-05-08 15:23:25', 10);

INSERT INTO assoc_pizzas_ingredients (pizza, ingredient) VALUES
    (1,2),(1,1),(1,3),(1,4),(1,5),(1,6),(1,7),
    (2,10),(2,1),(2,11),(2,7),(2,24),(2,4),
    (3,10),(3,1),(3,14),(3,15),(3,4),
    (4,2),(4,1),(4,6),(4,16),(4,5),
    (5,10),(5,1),(5,6),(5,4),(5,7),(5,2),
    (6,10),(6,1),(6,4),(6,9),(6,17),
    (7,10),(7,1),(7,22),(7,4),(7,19),(7,18),(7,20),
    (8,10),(8,1),(8,4),(8,6),(8,18),(8,8),
    (9,9),(9,1),(9,6),(9,3),(9,8),
    (10,9),(10,1),(10,18),(10,16),(10,6),(10,10),
    (11,9),(11,1),(11,19),(11,12),
    (12,10),(12,1),(12,22),(12,15),(12,21),(12,20),
    (13,9),(13,1),(13,11),(13,8),
    (14,9),(14,1),(14,3),(14,19),(14,18),(14,4),(14,23),(14,25),(14,5);









