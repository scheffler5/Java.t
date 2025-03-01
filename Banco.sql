-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospi
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acaomedica`
--

DROP TABLE IF EXISTS `acaomedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acaomedica` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDevolucao` int(10) DEFAULT NULL,
  `IDtbresposta` int(10) DEFAULT NULL,
  `IDtbpergunta` int(10) DEFAULT NULL,
  `IDprofis` int(3) DEFAULT NULL,
  `Evolucao` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_evolucao_idx` (`Evolucao`),
  KEY `fk_profissionais` (`IDprofis`),
  KEY `fk_tbpergunta` (`IDtbpergunta`),
  KEY `fk_tbresposta` (`IDtbresposta`),
  CONSTRAINT `fk_evolucao` FOREIGN KEY (`Evolucao`) REFERENCES `evolucao` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profissionais` FOREIGN KEY (`IDprofis`) REFERENCES `profissionais` (`IDProf`) ON DELETE SET NULL,
  CONSTRAINT `fk_tbpergunta` FOREIGN KEY (`IDtbpergunta`) REFERENCES `tbpergunta` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_tbresposta` FOREIGN KEY (`IDtbresposta`) REFERENCES `tbresposta` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acaomedica`
--

LOCK TABLES `acaomedica` WRITE;
/*!40000 ALTER TABLE `acaomedica` DISABLE KEYS */;
INSERT INTO `acaomedica` VALUES (1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `acaomedica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antibiotico`
--

DROP TABLE IF EXISTS `antibiotico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `antibiotico` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  `Preco` int(30) DEFAULT NULL,
  `Quantidade` int(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antibiotico`
--

LOCK TABLES `antibiotico` WRITE;
/*!40000 ALTER TABLE `antibiotico` DISABLE KEYS */;
INSERT INTO `antibiotico` VALUES (1,'Antibiotico A',20,100),(2,'Antibiotico B',50,200),(3,'Antibiotico C',75,150);
/*!40000 ALTER TABLE `antibiotico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balancocontas`
--

DROP TABLE IF EXISTS `balancocontas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `balancocontas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Mes` varchar(45) DEFAULT NULL,
  `valor` int(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balancocontas`
--

LOCK TABLES `balancocontas` WRITE;
/*!40000 ALTER TABLE `balancocontas` DISABLE KEYS */;
INSERT INTO `balancocontas` VALUES (1,'Janeiro',5000),(2,'Fevereiro',4500),(3,'Março',5500);
/*!40000 ALTER TABLE `balancocontas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cdc`
--

DROP TABLE IF EXISTS `cdc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cdc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CDC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdc`
--

LOCK TABLES `cdc` WRITE;
/*!40000 ALTER TABLE `cdc` DISABLE KEYS */;
INSERT INTO `cdc` VALUES (1,'Leito 101'),(2,'Leito 102'),(3,'Leito 103'),(4,'Sala de Medicamentos - Unidade A'),(5,'Sala de Medicamentos - Unidade B'),(6,'Estoque de Medicamentos - Central'),(7,'Sala de Urgência'),(8,'Sala de Reanimação'),(9,'Laboratório - Exames Gerais'),(10,'Centro Cirúrgico - Bloco A'),(11,'Centro Cirúrgico - Bloco B'),(12,'Maternidade - Leito 1'),(13,'Maternidade - Leito 2'),(14,'Unidade de Terapia Intensiva (UTI)'),(15,'Pronto-Socorro - Área de Atendimento');
/*!40000 ALTER TABLE `cdc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cid10`
--

DROP TABLE IF EXISTS `cid10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cid10` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CID_10` varchar(45) DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cid10`
--

LOCK TABLES `cid10` WRITE;
/*!40000 ALTER TABLE `cid10` DISABLE KEYS */;
INSERT INTO `cid10` VALUES (1,'A00','Cólera'),(2,'A01','Febre tifoide e paratifoide'),(3,'B10','Infecção por herpes simplex'),(4,'C20','Neoplasia maligna do cólon'),(5,'D30','Tumor benigno da mama');
/*!40000 ALTER TABLE `cid10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificacaorisco`
--

DROP TABLE IF EXISTS `classificacaorisco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificacaorisco` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Classificacao` varchar(20) DEFAULT NULL,
  `Cor` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacaorisco`
--

LOCK TABLES `classificacaorisco` WRITE;
/*!40000 ALTER TABLE `classificacaorisco` DISABLE KEYS */;
INSERT INTO `classificacaorisco` VALUES (1,'Emergente','Vermelho'),(2,'Urgente','Amarelo'),(3,'Pouco Urgente','Verde'),(4,'Nao Urgente','Azul');
/*!40000 ALTER TABLE `classificacaorisco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colaboradores`
--

DROP TABLE IF EXISTS `colaboradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colaboradores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `CLThanos` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `DataNascimento` varchar(45) DEFAULT NULL,
  `Salario` varchar(45) DEFAULT NULL,
  `CargaHoraria` varchar(45) DEFAULT NULL,
  `Cargo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colaboradores`
--

LOCK TABLES `colaboradores` WRITE;
/*!40000 ALTER TABLE `colaboradores` DISABLE KEYS */;
INSERT INTO `colaboradores` VALUES (1,'João Silva','123456789','123.456.789-00','01/01/1980','3000','40','Médico'),(2,'Maria Souza','987654321','987.654.321-00','15/05/1990','2500','40','Enfermeira'),(3,'Carlos Pereira','192837465','192.837.465-00','25/08/1985','2200','40','Técnico de Enfermagem');
/*!40000 ALTER TABLE `colaboradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `convenio` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  `ValorPorAtendimento` int(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convenio`
--

LOCK TABLES `convenio` WRITE;
/*!40000 ALTER TABLE `convenio` DISABLE KEYS */;
INSERT INTO `convenio` VALUES (1,'SUS',200),(2,'Particular',300),(3,'Unimed',150);
/*!40000 ALTER TABLE `convenio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dadospacientes`
--

DROP TABLE IF EXISTS `dadospacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dadospacientes` (
  `Registro` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `DataNascimento` varchar(15) DEFAULT NULL,
  `RG` varchar(20) DEFAULT NULL,
  `CartaoSUS` varchar(20) DEFAULT NULL,
  `Pais` varchar(30) DEFAULT NULL,
  `Estado` varchar(3) DEFAULT NULL,
  `Municipio` varchar(45) DEFAULT NULL,
  `Endereco` varchar(100) DEFAULT NULL,
  `CEP` varchar(20) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `NomeMae` varchar(100) DEFAULT NULL,
  `NomePai` varchar(100) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `EstadoCivil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Registro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dadospacientes`
--

LOCK TABLES `dadospacientes` WRITE;
/*!40000 ALTER TABLE `dadospacientes` DISABLE KEYS */;
INSERT INTO `dadospacientes` VALUES (1,'João Silva','15/04/1990','123456789','123456789012','Brasil','SP','São Paulo','Rua das Flores, 123','01010-010','11987654321','joao.silva@email.com','Maria Silva','José Silva','123.456.789-10','Solteiro'),(2,'Maria Oliveira','22/08/1985','987654321','987654321098','Brasil','MG','Belo Horizonte','Avenida dos Trabalhadores, 456','30330-220','31987654322','maria.oliveira@email.com','Ana Oliveira','Carlos Oliveira','987.654.321-00','Casada'),(3,'Carlos Souza','12/11/1979','112233445','112233445566','Brasil','RJ','Rio de Janeiro','Rua da Paz, 789','20530-150','21987654323','carlos.souza@email.com','Joana Souza','Paulo Souza','112.233.445-66','Divorciado'),(4,'Luciana Pereira','05/02/1992','223344556','223344556677','Brasil','SP','Campinas','Rua das Orquídeas, 321','13080-400','19987654324','luciana.pereira@email.com','Rita Pereira','Jorge Pereira','223.344.556-77','Solteira'),(5,'Gabriel lima scheffler','10/11/2005','545.070.983.4','2222.2222.2222.2222','Brasil','PR','Santa Helena','Rua Aroeira, 643','33333-333','(13) 98226-9509','gabrischeffler@gmail.com','Cintia Cavalcanti Lima Scheffler','Mauricio Scheffler','466.318.618-10','Casado'),(6,'Aldo Garcia','25/07/1983','111.111.111.1','1111.1111.1111.1111','Arábia Saudita','AL','Aracaju','Av. Jose Marcio ','80380-000','(49) 99883-8599','AldoAldao@gmail.com','Nila','Gento','555.555.555-55','Casado'),(7,'ggggg','  /  /    ','   .   .   . ','    .    .    .    ','Afeganistão','AL','','','     -   ','(  )      -    ','','','','444.444.444-44','Solteiro');
/*!40000 ALTER TABLE `dadospacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `Preco` int(30) DEFAULT NULL,
  `Quantidade` int(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,'Produto A',100,50),(2,'Produto B',150,30),(3,'Produto C',200,20);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evolucao`
--

DROP TABLE IF EXISTS `evolucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evolucao` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Documentos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evolucao`
--

LOCK TABLES `evolucao` WRITE;
/*!40000 ALTER TABLE `evolucao` DISABLE KEYS */;
INSERT INTO `evolucao` VALUES (1,'Anamnese - Pronto Socorro'),(2,'Evolução Médica - Pronto Socorro'),(3,'Laudo de Cirurgia - Bloco A'),(4,'Evolução Pós-Operatória - Unidade de Cirurgia'),(5,'Relatório de Exames - Laboratório'),(6,'Avaliação Psiquiátrica - Sala de Emergência'),(7,'Anamnese - Unidade de Terapia Intensiva (UTI)'),(8,'Evolução Médica - UTI'),(9,'Relatório de Alta - Maternidade'),(10,'Laudo Radiológico - Sala de Raio-X');
/*!40000 ALTER TABLE `evolucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exame`
--

DROP TABLE IF EXISTS `exame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exame` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exame`
--

LOCK TABLES `exame` WRITE;
/*!40000 ALTER TABLE `exame` DISABLE KEYS */;
INSERT INTO `exame` VALUES (1,'Exame A','50'),(2,'Exame B','70'),(3,'Exame C','90');
/*!40000 ALTER TABLE `exame` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `CNPJ` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'Fornecedor A','12.345.678/0001-90'),(2,'Fornecedor B','23.456.789/0001-10'),(3,'Fornecedor C','34.567.890/0001-20');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leitos`
--

DROP TABLE IF EXISTS `leitos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leitos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  `preço` int(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leitos`
--

LOCK TABLES `leitos` WRITE;
/*!40000 ALTER TABLE `leitos` DISABLE KEYS */;
INSERT INTO `leitos` VALUES (1,'Leito A',500),(2,'Leito B',700),(3,'Leito C',900);
/*!40000 ALTER TABLE `leitos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamentos`
--

DROP TABLE IF EXISTS `medicamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `Preco` int(30) DEFAULT NULL,
  `Quantidade` int(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamentos`
--

LOCK TABLES `medicamentos` WRITE;
/*!40000 ALTER TABLE `medicamentos` DISABLE KEYS */;
INSERT INTO `medicamentos` VALUES (1,'Medicamento A',50,100),(2,'Medicamento B',70,200),(3,'Medicamento C',90,150);
/*!40000 ALTER TABLE `medicamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidocompra`
--

DROP TABLE IF EXISTS `pedidocompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidocompra` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `Preco` int(30) DEFAULT NULL,
  `Quantidade` int(30) DEFAULT NULL,
  `NomeItem` int(11) DEFAULT NULL,
  `Fornecedores_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_pedidocompra_fornecedores` (`Fornecedores_ID`),
  CONSTRAINT `fk_pedidocompra_fornecedores` FOREIGN KEY (`Fornecedores_ID`) REFERENCES `fornecedores` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidocompra`
--

LOCK TABLES `pedidocompra` WRITE;
/*!40000 ALTER TABLE `pedidocompra` DISABLE KEYS */;
INSERT INTO `pedidocompra` VALUES (1,'Pedido A',150,10,1,1),(2,'Pedido B',200,15,2,2),(3,'Pedido C',300,20,3,3);
/*!40000 ALTER TABLE `pedidocompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencia`
--

DROP TABLE IF EXISTS `preferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferencia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencia`
--

LOCK TABLES `preferencia` WRITE;
/*!40000 ALTER TABLE `preferencia` DISABLE KEYS */;
INSERT INTO `preferencia` VALUES (1,'Preferência A'),(2,'Preferência B'),(3,'Preferência C');
/*!40000 ALTER TABLE `preferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prescricao`
--

DROP TABLE IF EXISTS `prescricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prescricao` (
  `ID_Prescricao` int(11) NOT NULL AUTO_INCREMENT,
  `Dosagem` int(10) DEFAULT NULL,
  `Frequencia` varchar(20) DEFAULT NULL,
  `CDC_ID` int(11) DEFAULT NULL,
  `ID_Medicamento` int(11) DEFAULT NULL,
  `ID_Antibiotico` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Prescricao`),
  KEY `fk_prescricao_frequencia` (`Frequencia`),
  KEY `fk_prescricao_cdc` (`CDC_ID`),
  KEY `fk_prescricao_medicamento` (`ID_Medicamento`),
  KEY `fk_prescricao_antibiotico` (`ID_Antibiotico`),
  CONSTRAINT `fk_prescricao_antibiotico` FOREIGN KEY (`ID_Antibiotico`) REFERENCES `antibiotico` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prescricao_cdc` FOREIGN KEY (`CDC_ID`) REFERENCES `cdc` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prescricao_medicamento` FOREIGN KEY (`ID_Medicamento`) REFERENCES `medicamentos` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescricao`
--

LOCK TABLES `prescricao` WRITE;
/*!40000 ALTER TABLE `prescricao` DISABLE KEYS */;
/*!40000 ALTER TABLE `prescricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedimentoscirurgicos`
--

DROP TABLE IF EXISTS `procedimentoscirurgicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procedimentoscirurgicos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) DEFAULT NULL,
  `preco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedimentoscirurgicos`
--

LOCK TABLES `procedimentoscirurgicos` WRITE;
/*!40000 ALTER TABLE `procedimentoscirurgicos` DISABLE KEYS */;
INSERT INTO `procedimentoscirurgicos` VALUES (1,'Procedimento A','500'),(2,'Procedimento B','700'),(3,'Procedimento C','1000');
/*!40000 ALTER TABLE `procedimentoscirurgicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profissionais`
--

DROP TABLE IF EXISTS `profissionais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profissionais` (
  `IDProf` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) DEFAULT NULL,
  `CartaoSUS` int(15) DEFAULT NULL,
  `IDCredencial` varchar(45) DEFAULT NULL,
  `IDespecialidade` varchar(45) DEFAULT NULL,
  `DataNascimento` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) DEFAULT NULL,
  `Função` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDProf`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissionais`
--

LOCK TABLES `profissionais` WRITE;
/*!40000 ALTER TABLE `profissionais` DISABLE KEYS */;
INSERT INTO `profissionais` VALUES (1,'Profissional A',2147483647,'Credencial A','Especialidade A','1980-01-01','123.456.789-00','Médico'),(2,'Profissional B',2147483647,'Credencial B','Especialidade B','1990-02-02','987.654.321-00','Enfermeiro'),(3,'Profissional C',2147483647,'Credencial C','Especialidade C','1985-03-03','111.223.344-00','Técnico de Enfermagem');
/*!40000 ALTER TABLE `profissionais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prontuario`
--

DROP TABLE IF EXISTS `prontuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prontuario` (
  `Prontuario` int(11) NOT NULL AUTO_INCREMENT,
  `IDprof` int(11) DEFAULT NULL,
  `CID10_ID` int(11) DEFAULT NULL,
  `ID_Prescricao` int(11) DEFAULT NULL,
  `classificacaorisco_id` int(11) DEFAULT NULL,
  `cdc_id` int(11) DEFAULT NULL,
  `acaomedica_id` int(11) DEFAULT NULL,
  `ID_usuario` int(11) DEFAULT NULL,
  `Registro` int(11) DEFAULT NULL,
  `Convenio_ID` int(11) DEFAULT NULL,
  `Preferencia_ID` int(11) DEFAULT NULL,
  `Exame_ID` int(11) DEFAULT NULL,
  `ProcedimentoCirurgico_ID` int(11) DEFAULT NULL,
  `Leito_ID` int(11) DEFAULT NULL,
  `Liberacao` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Prontuario`),
  KEY `fk_dadosPaciente_idx` (`Registro`),
  KEY `fk_acaomedica` (`acaomedica_id`),
  KEY `fk_cdc` (`cdc_id`),
  KEY `fk_cid10` (`CID10_ID`),
  KEY `fk_classificacaorisco` (`classificacaorisco_id`),
  KEY `fk_prescricao` (`ID_Prescricao`),
  KEY `fk_profissional` (`IDprof`),
  KEY `fk_usuario` (`ID_usuario`),
  KEY `fk_prontuario_convenios` (`Convenio_ID`),
  KEY `fk_prontuario_preferencia` (`Preferencia_ID`),
  KEY `fk_prontuario_exame` (`Exame_ID`),
  KEY `fk_prontuario_procedimentos` (`ProcedimentoCirurgico_ID`),
  KEY `fk_prontuario_leitos` (`Leito_ID`),
  CONSTRAINT `fk_acaomedica` FOREIGN KEY (`acaomedica_id`) REFERENCES `acaomedica` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_cdc` FOREIGN KEY (`cdc_id`) REFERENCES `cdc` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_cid10` FOREIGN KEY (`CID10_ID`) REFERENCES `cid10` (`ID`) ON DELETE SET NULL,
  CONSTRAINT `fk_classificacaorisco` FOREIGN KEY (`classificacaorisco_id`) REFERENCES `classificacaorisco` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prescricao` FOREIGN KEY (`ID_Prescricao`) REFERENCES `prescricao` (`ID_Prescricao`) ON DELETE SET NULL,
  CONSTRAINT `fk_profissional` FOREIGN KEY (`IDprof`) REFERENCES `profissionais` (`IDProf`) ON DELETE SET NULL,
  CONSTRAINT `fk_prontuario_convenios` FOREIGN KEY (`Convenio_ID`) REFERENCES `convenio` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prontuario_dadospacientes` FOREIGN KEY (`Registro`) REFERENCES `dadospacientes` (`Registro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prontuario_exame` FOREIGN KEY (`Exame_ID`) REFERENCES `exame` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prontuario_leitos` FOREIGN KEY (`Leito_ID`) REFERENCES `leitos` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prontuario_preferencia` FOREIGN KEY (`Preferencia_ID`) REFERENCES `preferencia` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_prontuario_procedimentos` FOREIGN KEY (`ProcedimentoCirurgico_ID`) REFERENCES `procedimentoscirurgicos` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`ID_usuario`) REFERENCES `usuarios` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prontuario`
--

LOCK TABLES `prontuario` WRITE;
/*!40000 ALTER TABLE `prontuario` DISABLE KEYS */;
INSERT INTO `prontuario` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `prontuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbpergunta`
--

DROP TABLE IF EXISTS `tbpergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbpergunta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Pergunta` varchar(45) DEFAULT NULL,
  `TipoPergunta` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_tipopergunta` (`TipoPergunta`),
  CONSTRAINT `fk_tipopergunta` FOREIGN KEY (`TipoPergunta`) REFERENCES `tipopergunta` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbpergunta`
--

LOCK TABLES `tbpergunta` WRITE;
/*!40000 ALTER TABLE `tbpergunta` DISABLE KEYS */;
INSERT INTO `tbpergunta` VALUES (1,'Qual o seu nome?',1),(2,'Qual sua idade?',2),(3,'Qual sua profissão?',3);
/*!40000 ALTER TABLE `tbpergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbresposta`
--

DROP TABLE IF EXISTS `tbresposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbresposta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TBresposta` varchar(45) DEFAULT NULL,
  `tiporesposta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_tiporesposta` (`tiporesposta_id`),
  CONSTRAINT `fk_tiporesposta` FOREIGN KEY (`tiporesposta_id`) REFERENCES `tiporesposta` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbresposta`
--

LOCK TABLES `tbresposta` WRITE;
/*!40000 ALTER TABLE `tbresposta` DISABLE KEYS */;
INSERT INTO `tbresposta` VALUES (1,'Resposta da Pergunta 1',1),(2,'Resposta da Pergunta 2',2),(3,'Resposta da Pergunta 3',3);
/*!40000 ALTER TABLE `tbresposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopergunta`
--

DROP TABLE IF EXISTS `tipopergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipopergunta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATA` date DEFAULT NULL,
  `Texto` tinyblob DEFAULT NULL,
  `Numero` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopergunta`
--

LOCK TABLES `tipopergunta` WRITE;
/*!40000 ALTER TABLE `tipopergunta` DISABLE KEYS */;
INSERT INTO `tipopergunta` VALUES (1,'2025-03-01',_binary 'Texto para Tipo 1',12345),(2,'2025-03-02',_binary 'Texto para Tipo 2',12346),(3,'2025-03-03',_binary 'Texto para Tipo 3',12347);
/*!40000 ALTER TABLE `tipopergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiporesposta`
--

DROP TABLE IF EXISTS `tiporesposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiporesposta` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Respalfa` varchar(45) DEFAULT NULL,
  `Respdata` date DEFAULT NULL,
  `Resphora` time DEFAULT NULL,
  `Resptexto` tinyblob DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiporesposta`
--

LOCK TABLES `tiporesposta` WRITE;
/*!40000 ALTER TABLE `tiporesposta` DISABLE KEYS */;
INSERT INTO `tiporesposta` VALUES (1,'Resposta 1','2025-03-01','12:00:00',_binary 'Texto Resposta 1'),(2,'Resposta 2','2025-03-02','14:00:00',_binary 'Texto Resposta 2'),(3,'Resposta 3','2025-03-03','16:00:00',_binary 'Texto Resposta 3');
/*!40000 ALTER TABLE `tiporesposta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferencia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CDC_ID` int(11) DEFAULT NULL,
  `Estoque_ID` int(11) DEFAULT NULL,
  `Quantidade` int(11) DEFAULT NULL,
  `Data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_transferencia_cdc` (`CDC_ID`),
  KEY `fk_transferencia_estoque` (`Estoque_ID`),
  CONSTRAINT `fk_transferencia_cdc` FOREIGN KEY (`CDC_ID`) REFERENCES `cdc` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_transferencia_estoque` FOREIGN KEY (`Estoque_ID`) REFERENCES `estoque` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencia`
--

LOCK TABLES `transferencia` WRITE;
/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
INSERT INTO `transferencia` VALUES (1,1,1,50,'2025-03-01'),(2,2,1,30,'2025-03-02'),(3,3,2,20,'2025-03-03');
/*!40000 ALTER TABLE `transferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `User` varchar(20) DEFAULT NULL,
  `Nome` varchar(60) DEFAULT NULL,
  `DataNascimento` varchar(10) DEFAULT NULL,
  `CartaoSUS` varchar(20) DEFAULT NULL,
  `CPF` varchar(20) DEFAULT NULL,
  `RG` varchar(20) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Municipio` varchar(100) DEFAULT NULL,
  `Rua` varchar(100) DEFAULT NULL,
  `CEP` varchar(20) DEFAULT NULL,
  `Senha` varchar(45) DEFAULT NULL,
  `Estado` varchar(2) DEFAULT NULL,
  `NivelAcesso` varchar(45) DEFAULT NULL,
  `Funcao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'mmartins','Maria Martins','1985-08-20','2147483647','2147483647','987654321','9876-5432','Santa Helena','Rua B, 456','87654321','123','16','1','2'),(4,'apereira','Ana Pereira','1995-11-30','2147483647','2147483647','564738291','9876-5433','Sorocaba','Rua D, 321','12312312','123','25','7','2'),(6,'gusta','','  /  /    ','   .    .    .    ','   .   .   -  ','  .   .   - ','(  )      -    ','','','     -   ','123','PR','TI','ADMINISTRADOR DE SISTEMA'),(7,'lucas','','  /  /    ','   .    .    .    ','   .   .   -  ','  .   .   - ','(  )      -    ','','','     -   ','123','PR','TI','ADMINISTRADOR DE SISTEMA'),(8,'gabriel','Gabriel Scheffler','10/11/2005','444.4444.4444.4444','466.318.618-10','53.507.098-3','(13) 98226-9509','Santa Helena','Rua Aroeira 643','85999-000','123','PR','MEDICOS','ADMINISTRADOR DE SISTEMA'),(9,'anaRios','Ana Clara Alves Rios scheffler','18/03/2004','111.1111.1111.1111','111.111.111-11','11.111.111-1','(45) 33333-3333','Santa Helena','Rua Aroeira 643','98588-888','000','PR','NUTRICIONISTA','OPERADOR DE SISTEMA'),(10,'gdgdfgdf','','  /  /    ','   .    .    .    ','   .   .   -  ','  .   .   - ','(  )      -    ','','','     -   ','','AC','NIVEL DE ACESSO','FUNÇÃO'),(11,'anaRio','Ana Clara Alves Rios 	','18/03/2004','111.1111.1111.1111','111.111.111-11','11.111.111-1','(45) 33333-3333','Santa Helena','Rua Aroeira 643','98588-888','000','PR','MEDICOS','OPERADOR DE SISTEMA');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-01  1:45:52
