CREATE DATABASE bakery_pp;   /*da usare solo una volta*/

use bakery_pp;

CREATE TABLE `utenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  'CF' varchar(16) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,

      `via` varchar(45) NOT NULL,
      `numero civico` int NOT NULL,
      `cap` int NOT NULL,
      `regione` varchar(45) NOT NULL,
      `provincia` varchar(2) NOT NULL,

PRIMARY KEY (`id`)
)

CREATE TABLE `corso` (
                         `idcorso` int NOT NULL AUTO_INCREMENT,
                         `nome` varchar(45) NOT NULL,
                         `luogo` varchar(45) DEFAULT NULL,
                         `descrizione` varchar(500) DEFAULT NULL,
                         `prezzo` double NOT NULL,
                         `data` date DEFAULT NULL,
                         PRIMARY KEY (`idcorso`)
)

CREATE TABLE `prodotto` (
                            `id_prodotto` int NOT NULL AUTO_INCREMENT,
                            `nome_prodotto` varchar(45) NOT NULL,
                            `prezzo` double NOT NULL,
                            'quantita' int,
                            `inOfferta` tinyint DEFAULT NULL,
                            `img_full` varchar(45) DEFAULT NULL,
                            `img_anteprima` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id_prodotto`)
)



