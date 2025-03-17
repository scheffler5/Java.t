/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class Prontuario {
    private int Prontuario;
    private int IDprof;
    private int Cid10ID;
    private int IDPrescricao;
    private int ClassificacaoRisco;
    private int cdc;
    private int AcaoMedica;
    private int IDusuario;
    private int Registro;
    private int Convenio;
    private int Preferencia;
    private int Exame;
    private int ProcedimentoCirurgico;
    private int Leito;
    private int Liberacao;
    private long TempoEspera;
    private Pacientes dado;
    private Classificacao cla;
    private Preferencia pre;
    private FluxoPref flu;

    public Pacientes getDado() {
        return dado;
    }

    public void setDado(Pacientes dado) {
        this.dado = dado;
    }

    public Classificacao getCla() {
        return cla;
    }

    public void setCla(Classificacao cla) {
        this.cla = cla;
    }

    public Preferencia getPre() {
        return pre;
    }

    public void setPre(Preferencia pre) {
        this.pre = pre;
    }

    public FluxoPref getFlu() {
        return flu;
    }

    public void setFlu(FluxoPref flu) {
        this.flu = flu;
    }

    public long getTempoEspera() {
        return TempoEspera;
    }

    public void setTempoEspera(long TempoEspera) {
        this.TempoEspera = TempoEspera;
    }

    public int getPreferencia() {
        return Preferencia;
    }

    public void setPreferencia(int Preferencia) {
        this.Preferencia = Preferencia;
    }

    public int getExame() {
        return Exame;
    }

    public void setExame(int Exame) {
        this.Exame = Exame;
    }

    public int getProcedimentoCirurgico() {
        return ProcedimentoCirurgico;
    }

    public void setProcedimentoCirurgico(int ProcedimentoCirurgico) {
        this.ProcedimentoCirurgico = ProcedimentoCirurgico;
    }

    public int getLeito() {
        return Leito;
    }

    public void setLeito(int Leito) {
        this.Leito = Leito;
    }

    public int getLiberacao() {
        return Liberacao;
    }

    public void setLiberacao(int Liberacao) {
        this.Liberacao = Liberacao;
    }

    public int getConvenio() {
        return Convenio;
    }

    public void setConvenio(int Convenio) {
        this.Convenio = Convenio;
    }

    public int getProntuario() {
        return Prontuario;
    }

    public void setProntuario(int Prontuario) {
        this.Prontuario = Prontuario;
    }

    public int getIDprof() {
        return IDprof;
    }

    public void setIDprof(int IDprof) {
        this.IDprof = IDprof;
    }

    public int getCid10ID() {
        return Cid10ID;
    }

    public void setCid10ID(int Cid10ID) {
        this.Cid10ID = Cid10ID;
    }

    public int getIDPrescricao() {
        return IDPrescricao;
    }

    public void setIDPrescricao(int IDPrescricao) {
        this.IDPrescricao = IDPrescricao;
    }

    public int getClassificacaoRisco() {
        return ClassificacaoRisco;
    }

    public void setClassificacaoRisco(int ClassificacaoRisco) {
        this.ClassificacaoRisco = ClassificacaoRisco;
    }

    public int getCdc() {
        return cdc;
    }

    public void setCdc(int cdc) {
        this.cdc = cdc;
    }

    public int getAcaoMedica() {
        return AcaoMedica;
    }

    public void setAcaoMedica(int AcaoMedica) {
        this.AcaoMedica = AcaoMedica;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int Registro) {
        this.Registro = Registro;
    }
    
}
