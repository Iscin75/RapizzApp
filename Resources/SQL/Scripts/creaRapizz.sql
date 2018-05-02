#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


CREATE DATABASE IF NOT EXISTS rapizz;
USE rapizz;

#------------------------------------------------------------
# Table: assoc_pizzas_ingredients
#------------------------------------------------------------

CREATE TABLE assoc_pizzas_ingredients(
        id             Int NOT NULL ,
        id_pizzas      Int NOT NULL ,
        id_ingredients Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: clients
#------------------------------------------------------------

CREATE TABLE clients(
        id           Int NOT NULL ,
        username     Varchar (20) NOT NULL ,
        password     Varchar (20) NOT NULL ,
        solde        Float NOT NULL ,
        nb_commandes Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: commandes
#------------------------------------------------------------

CREATE TABLE commandes(
        id                Int NOT NULL ,
        tarif             Float NOT NULL ,
        date_commande     Date NOT NULL ,
        id_clients        Int NOT NULL ,
        id_pizzas         Int NOT NULL ,
        id_formats_pizzas Int NOT NULL ,
        id_livraisons     Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: formats_pizzas
#------------------------------------------------------------

CREATE TABLE formats_pizzas(
        id           Int NOT NULL ,
        nom          Varchar (10) NOT NULL ,
        ratio        Float NOT NULL ,
        id_commandes Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ingredients
#------------------------------------------------------------

CREATE TABLE ingredients(
        id  Int NOT NULL ,
        nom Varchar (20) NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: livraisons
#------------------------------------------------------------

CREATE TABLE livraisons(
        id             Int NOT NULL ,
        date_livraison Date NOT NULL ,
        statut         Enum NOT NULL ,
        id_commandes   Int NOT NULL ,
        id_livreur     Int NOT NULL ,
        id_transports  Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: livreur
#------------------------------------------------------------

CREATE TABLE livreur(
        id            Int NOT NULL ,
        nom           Varchar (20) NOT NULL ,
        prenom        Varchar (20) NOT NULL ,
        id_livraisons Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: pizzas
#------------------------------------------------------------

CREATE TABLE pizzas(
        id           Int NOT NULL ,
        nom          Varchar (10) NOT NULL ,
        base_prix    Float NOT NULL ,
        id_commandes Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: transports
#------------------------------------------------------------

CREATE TABLE transports(
        id            Int NOT NULL ,
        nom           Varchar (10) NOT NULL ,
        id_livraisons Int NOT NULL ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;

ALTER TABLE assoc_pizzas_ingredients ADD CONSTRAINT FK_assoc_pizzas_ingredients_id_pizzas FOREIGN KEY (id_pizzas) REFERENCES pizzas(id);
ALTER TABLE assoc_pizzas_ingredients ADD CONSTRAINT FK_assoc_pizzas_ingredients_id_ingredients FOREIGN KEY (id_ingredients) REFERENCES ingredients(id);
ALTER TABLE commandes ADD CONSTRAINT FK_commandes_id_clients FOREIGN KEY (id_clients) REFERENCES clients(id);
ALTER TABLE commandes ADD CONSTRAINT FK_commandes_id_pizzas FOREIGN KEY (id_pizzas) REFERENCES pizzas(id);
ALTER TABLE commandes ADD CONSTRAINT FK_commandes_id_formats_pizzas FOREIGN KEY (id_formats_pizzas) REFERENCES formats_pizzas(id);
ALTER TABLE commandes ADD CONSTRAINT FK_commandes_id_livraisons FOREIGN KEY (id_livraisons) REFERENCES livraisons(id);
ALTER TABLE formats_pizzas ADD CONSTRAINT FK_formats_pizzas_id_commandes FOREIGN KEY (id_commandes) REFERENCES commandes(id);
ALTER TABLE livraisons ADD CONSTRAINT FK_livraisons_id_commandes FOREIGN KEY (id_commandes) REFERENCES commandes(id);
ALTER TABLE livraisons ADD CONSTRAINT FK_livraisons_id_livreur FOREIGN KEY (id_livreur) REFERENCES livreur(id);
ALTER TABLE livraisons ADD CONSTRAINT FK_livraisons_id_transports FOREIGN KEY (id_transports) REFERENCES transports(id);
ALTER TABLE livreur ADD CONSTRAINT FK_livreur_id_livraisons FOREIGN KEY (id_livraisons) REFERENCES livraisons(id);
ALTER TABLE pizzas ADD CONSTRAINT FK_pizzas_id_commandes FOREIGN KEY (id_commandes) REFERENCES commandes(id);
ALTER TABLE transports ADD CONSTRAINT FK_transports_id_livraisons FOREIGN KEY (id_livraisons) REFERENCES livraisons(id);
