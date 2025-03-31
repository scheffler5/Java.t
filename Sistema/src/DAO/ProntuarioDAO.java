/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Classificacao;
import Model.FluxoPref;
import Model.Pacientes;
import Model.Preferencia;
import Model.Profi;
import Model.Prontuario;
import Model.User;
import SYS.JDBC.ConexaoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.util.concurrent.TimeUnit;

public class ProntuarioDAO {
    
    private Connection conn;
    
    public ProntuarioDAO(){
        
        this.conn = new ConexaoBanco().pegarConexao();
    }

    
    public Prontuario BuscarPaciente(String Prontuario){
        try {
            String aql = "Select * from prontuario where Registro =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Prontuario);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setRegistro(rs.getInt("Registro"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar  Registro  "+ e);
            }
        return null;
    }
    public Prontuario BuscarConvenio(String Prontuario){
        try {
            String aql = "Select * from prontuario where Convenio_ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Prontuario);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setConvenio(rs.getInt("Convenio_ID"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar  Convenio  "+ e);
            }
        return null;
    }
    public void Salvar(Prontuario obj){
        try {
            String sql = "insert into prontuario(Registro,IDprof,cdc_id,Convenio_ID,Preferencia_ID)"
                    + "Values(?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getRegistro());
            stmt.setInt(2, obj.getIDprof());
            stmt.setInt(3, obj.getCdc());
            stmt.setInt(4, obj.getConvenio());
            stmt.setInt(5, obj.getPreferencia());
            
           
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Prontuario cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro de cadastro de prontuario"+e);
        }
    }
    

//public List<Prontuario> listar() {
//    List<Prontuario> lista = new ArrayList<>();
//    String sql = "SELECT "
//         + "fluxopref.Prontuario, "
//         + "pa.Nome AS PacienteNome, "
//         + "su.classificacao, "
//         + "pr.Nome AS PreferenciaNome, "
//         + "fluxopref.Data AS LastDate, "
//         + "fluxopref.Hora AS LastTime "
//         + "FROM fluxopref fluxopref "
//         + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
//         + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
//         + "JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
//         + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
//         + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";
//
//    try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
//         ResultSet rs = stmt.executeQuery()) {
//
//        while (rs.next()) {
//            Prontuario obj = new Prontuario();
//            Pacientes dado = new Pacientes();
//            Classificacao cla = new Classificacao();
//            Preferencia pre = new Preferencia();
//            FluxoPref flu = new FluxoPref();
//
//            obj.setProntuario(rs.getInt("fluxopref.Prontuario"));
//            cla.setClassificacao(rs.getString("su.classificacao"));
//            dado.setNome(rs.getString("PacienteNome"));
//            pre.setNome(rs.getString("PreferenciaNome"));
//
//            // Recuperando Data e Hora como Timestamp
//            Timestamp timestamp = rs.getTimestamp("LastDate");
//            if (timestamp != null) {
//                flu.setDate(timestamp.toLocalDateTime());
//            }
//
//            // Calculando tempo de espera
//            Timestamp dataAtual = new Timestamp(System.currentTimeMillis());
//            Timestamp dataEntrada = rs.getTimestamp("LastDate");
//
//            if (dataEntrada != null) {
//                long diffInMillies = dataAtual.getTime() - dataEntrada.getTime();
//                long diffInMinutes = TimeUnit.MILLISECONDS.toHours(diffInMillies);
//                obj.setTempoEspera(diffInMinutes);
//            }
//
//            obj.setDado(dado);
//            obj.setCla(cla);
//            obj.setPre(pre);
//            obj.setFlu(flu);
//
//            lista.add(obj);
//        }
//    } catch (Exception e) {
//        // Logar a exceção ou lançar uma exceção personalizada
//        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e);
//        e.printStackTrace(); // Para depuração
//    }
//    return lista;
//}
    
    public List<Prontuario> listar() {
    List<Prontuario> lista = new ArrayList<>();
    String sql = "SELECT "
         + "fluxopref.Prontuario, "
         + "pa.Nome AS PacienteNome, "
         + "su.classificacao, "
         + "pr.Nome AS PreferenciaNome, "
         + "fluxopref.Data AS LastDate, "
         + "fluxopref.Hora AS LastTime "
         + "FROM fluxopref fluxopref "
         + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
         + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
         + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
         + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
         + "WHERE p.Liberacao = 0 "
         + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

    try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("fluxopref.Prontuario"));
            cla.setClassificacao(rs.getString("su.classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            
            
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");

            // Recuperando Data e Hora separadamente
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            // Convertendo java.sql.Date para java.time.LocalDate
            LocalDate localDate = data != null ? data.toLocalDate() : null;

            // Convertendo java.sql.Time para java.time.LocalTime
            LocalTime localTime = hora != null ? hora.toLocalTime() : null;

            // Combinando Data e Hora em um LocalDateTime
            if (localDate != null && localTime != null) {
                LocalDateTime dataHora = LocalDateTime.of(localDate, localTime);
                flu.setDate(dataHora); // Define a data e hora no objeto FluxoPref
            }

            // Calculando tempo de espera em horas
            LocalDateTime dataAtual = LocalDateTime.now(); // Data e hora atuais
            LocalDateTime dataEntrada = flu.getDate(); // Data e hora de entrada

            if (dataEntrada != null) {
                long diffInMillies = Duration.between(dataEntrada, dataAtual).toMillis();
                long diffInHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillies); // Convertendo para horas
                obj.setTempoEspera(diffInHours); // Definindo o tempo de espera em horas
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }
    } catch (Exception e) {
        // Logar a exceção ou lançar uma exceção personalizada
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e);
        e.printStackTrace(); // Para depuração
    }
    return lista;
}
    
    

    public List<Prontuario> Filtrar24horas() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE TIMESTAMP(fluxopref.Data, fluxopref.Hora) >= NOW() - INTERVAL 24 HOUR "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        //stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
    public List<Prontuario> FiltrarIdade() {
        List<Prontuario> lista = new ArrayList<>();
        
        try {
            String sql = "SELECT "
                    + "fluxopref.Prontuario, "
                    + "pa.Nome AS PacienteNome, "
                    + "pa.DataNascimento AS Nascimento, "
                    + "su.classificacao, "
                    + "pr.Nome AS PreferenciaNome, "
                    + "fluxopref.Data AS LastDate, "
                    + "fluxopref.Hora AS LastTime "
                    + "FROM fluxopref fluxopref "
                    + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                    + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                    + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                    + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                    + "WHERE p.Liberacao = 0 "
                    + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Prontuario obj = new Prontuario();
                Pacientes dado = new Pacientes();
                Classificacao cla = new Classificacao();
                Preferencia pre = new Preferencia();
                FluxoPref flu = new FluxoPref();

                obj.setProntuario(rs.getInt("Prontuario"));
                cla.setClassificacao(rs.getString("classificacao"));
                dado.setNome(rs.getString("PacienteNome"));
                pre.setNome(rs.getString("PreferenciaNome"));
                String classificacao = rs.getString("classificacao");
                cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");

                // 🟢 Pegando a data de nascimento (String) do banco e convertendo para LocalDate
                String dataNascimentoStr = rs.getString("Nascimento");
                if (dataNascimentoStr != null && !dataNascimentoStr.isEmpty()) {
                    // Definindo o formato correto da data
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    
                    // Converte a String para LocalDate
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
                    
                    // 🟢 Calculando a idade
                    int idade = Period.between(dataNascimento, LocalDate.now()).getYears();

                    // 🟢 Convertendo idade para String para exibição na tabela
                    dado.setIdade(String.valueOf(idade));
                } else {
                    dado.setIdade("Desconhecido"); // Caso a data de nascimento seja nula ou inválida
                }

                java.sql.Date data = rs.getDate("LastDate");
                java.sql.Time hora = rs.getTime("LastTime");

                if (data != null && hora != null) {
                    LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                    flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                    // 🟢 Calculando tempo de espera em minutos
                    long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                    obj.setTempoEspera(diffInMinutes);
                }

                obj.setDado(dado);
                obj.setCla(cla);
                obj.setPre(pre);
                obj.setFlu(flu);

                lista.add(obj);
            }

            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
        }
        
        return null;
    }
    public List<Prontuario> FiltrarNome(String user) {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE pa.Nome LIKE ? "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
public List<Prontuario> FiltrarProntuario(String user) {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE fluxopref.Prontuario LIKE ? "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
 public List<Prontuario> FiltrarCrianca() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE pr.Nome LIKE 'Criança' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
} 
 public List<Prontuario> FiltrarIdoso() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE pr.Nome LIKE 'Idoso' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
 public List<Prontuario> FiltrarGravida() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE pr.Nome LIKE 'Gravida' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
 public List<Prontuario> FiltrarAdulto() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE pr.Nome LIKE 'Adulto' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
 public List<Prontuario> FiltrarEmergencia() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE su.classificacao LIKE 'Emergencia' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}  
public List<Prontuario> FiltrarUrgente() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE su.classificacao LIKE 'Urgente' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
public List<Prontuario> FiltrarPoucoUrgente() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE su.classificacao LIKE 'Pouco Urgente' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
public List<Prontuario> FiltrarNaoUrgente() {
    List<Prontuario> lista = new ArrayList<>();
    
    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE su.classificacao LIKE 'Nao Urgente' "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
public List<Prontuario> FiltrarNaoClassificado() {
    List<Prontuario> lista = new ArrayList<>();

    try {
        String sql = "SELECT "
                + "fluxopref.Prontuario, "
                + "pa.Nome AS PacienteNome, "
                + "su.classificacao, "
                + "pr.Nome AS PreferenciaNome, "
                + "fluxopref.Data AS LastDate, "
                + "fluxopref.Hora AS LastTime "
                + "FROM fluxopref "
                + "JOIN prontuario p ON fluxopref.Prontuario = p.Prontuario "
                + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
                + "LEFT JOIN classificacaorisco su ON p.classificacaorisco_id = su.ID "
                + "JOIN preferencia pr ON p.Preferencia_ID = pr.ID "
                + "WHERE p.classificacaorisco_id IS NULL "
                + "AND p.Liberacao = 0 "
                + "ORDER BY fluxopref.Data DESC, fluxopref.Hora DESC;";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario obj = new Prontuario();
            Pacientes dado = new Pacientes();
            Classificacao cla = new Classificacao();
            Preferencia pre = new Preferencia();
            FluxoPref flu = new FluxoPref();

            obj.setProntuario(rs.getInt("Prontuario"));
            cla.setClassificacao(rs.getString("classificacao"));
            dado.setNome(rs.getString("PacienteNome"));
            pre.setNome(rs.getString("PreferenciaNome"));
            
            String classificacao = rs.getString("classificacao");
            cla.setClassificacao(classificacao != null ? classificacao : "Não Classificado");
            
            java.sql.Date data = rs.getDate("LastDate");
            java.sql.Time hora = rs.getTime("LastTime");

            if (data != null && hora != null) {
                LocalDateTime dataEntrada = LocalDateTime.of(data.toLocalDate(), hora.toLocalTime());
                flu.setDate(dataEntrada); // Define a data e hora no objeto FluxoPref

                // Calculando tempo de espera em minutos
                long diffInMinutes = Duration.between(dataEntrada, LocalDateTime.now()).toMinutes();
                obj.setTempoEspera(diffInMinutes); // Agora define o tempo de espera em minutos
            }

            obj.setDado(dado);
            obj.setCla(cla);
            obj.setPre(pre);
            obj.setFlu(flu);

            lista.add(obj);
        }

        return lista;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e.getMessage());
    }
    
    return null;
}
public void EditarClassificacao(Prontuario obj){
        try {
            String sql = "update prontuario set classificacaorisco_id=? WHERE Prontuario=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getClassificacaoRisco());  
            stmt.setInt(2, obj.getProntuario());
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Cadastrar Classificacao de Risco"+e);
        }
    }
public Prontuario BuscarClassificação(String Prontuario){
        try {
            String aql = "Select * from prontuario where Prontuario = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Prontuario);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setClassificacaoRisco(rs.getInt("classificacaorisco_id"));
                obj.setProntuario(rs.getInt("Prontuario"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar  Convenio  "+ e);
            }
        return null;
    }
public void Editar(Prontuario obj){
        try {
            String sql = "update prontuario set Liberacao=? WHERE Prontuario=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getLiberacao());
            stmt.setInt(2, obj.getProntuario());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Paciente Liberado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Liberar o Paciente"+e);
        }
    }
public Prontuario BuscarLiberacao(int user){
        try {
            String aql = "Select * from prontuario where Prontuario = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setInt(1,user);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setProntuario(rs.getInt("Prontuario"));
                obj.setLiberacao(rs.getInt("Liberacao"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
public void EditarLocPac(Prontuario obj){
        try {
            String sql = "update prontuario set cdc_id=? WHERE Prontuario=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCdc());
            stmt.setInt(2, obj.getProntuario());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alteração de localidade realizada com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Liberar o Paciente"+e);
        }
}
public Prontuario BuscarCDC(int user){
        try {
            String aql = "Select * from prontuario where Prontuario = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setInt(1,user);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setProntuario(rs.getInt("Prontuario"));
                obj.setLiberacao(rs.getInt("cdc_id"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }

    
}


 
    
    
    

