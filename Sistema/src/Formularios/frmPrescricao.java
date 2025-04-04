/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import DAO.PrescricaoDAO;
import Model.Prescricao;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class frmPrescricao extends javax.swing.JFrame {
    private int pres;
    private String Paciente;
    private int prontuario;
    private String prescricaoID;
    private int presc;
    
    public void setPrescricaoID(String prescricaoID) {
    this.prescricaoID = prescricaoID;
}
    private DefaultTableModel defaul;
    private DefaultTableModel defaul1;
    
    public void atualizarCampos(String Paciente,int prontuario) {
        this.prontuario = prontuario;
        this.Paciente = Paciente;
        txtProntuario.setText(String.valueOf(prontuario));
        txtNome.setText(Paciente);
    }
    public void atualizarpresc(int prescricao){
        txtprescricao.setText(String.valueOf(prescricao));
        this.pres = prescricao;
    }
    public void prescclicar(int presc){
        this.presc = presc;
    }

    public frmPrescricao() {
        initComponents();
        defaul = (DefaultTableModel) Tabela.getModel();
        defaul1 = (DefaultTableModel) Tabela1.getModel();
        
        
        
        
        
    }
    public void preencherTabelaMedicamentos(List<Prescricao> lista) {
    DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();

    for (Prescricao p : lista) {
        boolean linhaExistente = false;

        // Verifica se a linha já existe na tabela
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).equals(p.getMedicamentos()) && 
                modelo.getValueAt(i, 1).equals(p.getMedi()) && 
                modelo.getValueAt(i, 2).equals(p.getFrequencia())) {
                linhaExistente = true;
                break;  // Não adiciona se já existir
            }
        }

        // Se a linha não existir, adiciona
        if (!linhaExistente) {
            modelo.addRow(new Object[]{p.getMedicamentos(), p.getMedi(), p.getFrequencia()});
        }
    }
}

public void preencherTabelaAntibioticos(List<Prescricao> lista) {
    DefaultTableModel modelo = (DefaultTableModel) Tabela1.getModel();

    for (Prescricao p : lista) {
        boolean linhaExistente = false;

        // Verifica se a linha já existe na tabela
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).equals(p.getAntibioticos()) && 
                modelo.getValueAt(i, 1).equals(p.getAnti()) && 
                modelo.getValueAt(i, 2).equals(p.getFrequencia())) {
                linhaExistente = true;
                break;  // Não adiciona se já existir
            }
        }

        // Se a linha não existir, adiciona
        if (!linhaExistente) {
            modelo.addRow(new Object[]{p.getAntibioticos(), p.getAnti(), p.getFrequencia()});
        }
    }
}



         
         
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/istockphoto-1432473911-612x612.jpg"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProntuario = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCOD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNomeMed = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        txtCOD1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        txtNomeAnt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFreqMed = new javax.swing.JTextField();
        txtFreqAnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        txtprescricao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prontuario:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paciente: ");

        txtProntuario.setEnabled(false);

        txtNome.setEnabled(false);

        jLabel3.setText("COD");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome do Medicamento");

        txtNomeMed.setEnabled(false);

        jButton2.setText("Incluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 255, 0));
        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Medicamento", "Frequencia"
            }
        ));
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtNomeAnt.setEnabled(false);

        jButton6.setText("Incluir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("COD");

        jLabel6.setText("Nome do Antibiotico");

        jLabel7.setText("Frequencia:");

        jLabel8.setText("Frequencia:");

        Tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Antibiotico", "Frequencia"
            }
        ));
        Tabela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabela1);

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Editar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCOD1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtNomeAnt)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txtFreqMed, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFreqAnt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton2)))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(txtFreqMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCOD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(txtNomeAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(txtFreqAnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        txtprescricao.setEnabled(false);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("N Prescrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProntuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListarMedicamentos med = new ListarMedicamentos(this);
        med.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.atualizarCampos(Paciente, prontuario);
        this.atualizarpresc(pres);
        PrescricaoDAO dao = new PrescricaoDAO();
        List<Prescricao> listaMedicamentos = dao.listarMedicamentos(prescricaoID);
        List<Prescricao> listaAntibioticos = dao.listarAntibioticos(prescricaoID);
        this.preencherTabelaMedicamentos(listaMedicamentos);
        this.preencherTabelaAntibioticos(listaAntibioticos);
        
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    
    
    String cod = txtCOD.getText();
    String nomeMed = txtNomeMed.getText();
    String freqMed = txtFreqMed.getText();
    
    
    defaul.addRow(new Object[]{cod, nomeMed, freqMed});

    

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        PrescricaoDAO dao = new PrescricaoDAO();
        DefaultTableModel dados = (DefaultTableModel) Tabela.getModel();
        try {
            for (int i = 0; i < dados.getRowCount(); i++) {
                if (dados.getValueAt(i, 0) != null) {
                    try {
                        Prescricao obj = new Prescricao();
                        obj.setPrescricao(pres);
                        
                        String valorCelula = dados.getValueAt(i, 0).toString();
                        int medicamento = Integer.parseInt(valorCelula);
                        obj.setMedicamentos(medicamento);
   
                        String valorCelula2 = dados.getValueAt(i, 2).toString();
                        int Frequencia = Integer.parseInt(valorCelula2);
                        obj.setFrequencia(Frequencia);
                        dao.Salvar(obj);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro na linha " + (i + 1) + ": O valor não é um número válido.");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Todos os exames foram solicitados com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar a tabela: " + e.getMessage());
        }
        DefaultTableModel dado = (DefaultTableModel) Tabela1.getModel();
        try {
            for (int i = 0; i < dado.getRowCount(); i++) {
                if (dado.getValueAt(i, 0) != null) {
                    try {
                        Prescricao obj = new Prescricao();
                        obj.setPrescricao(pres);
                        
                        String valorCelula = dado.getValueAt(i, 0).toString();
                        int Antibiotico = Integer.parseInt(valorCelula);
                        obj.setAntibioticos(Antibiotico);
   
                        String valorCelula2 = dado.getValueAt(i, 2).toString();
                        int Frequencia = Integer.parseInt(valorCelula2);
                        obj.setFrequencia(Frequencia);
                        dao.Salvar(obj);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro na linha " + (i + 1) + ": O valor não é um número válido.");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Todos os exames foram solicitados com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar a tabela: " + e.getMessage());
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ListarAntibiotico ant = new ListarAntibiotico(this);
        ant.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        defaul1.addRow(new Object[]{
         txtCOD1.getText(),
         txtNomeAnt.getText(),
         txtFreqAnt.getText(),
         
        });
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        PrescricaoDAO dao = new PrescricaoDAO();
DefaultTableModel dados = (DefaultTableModel) Tabela.getModel();

try {
    for (int i = 0; i < dados.getRowCount(); i++) {
        if (dados.getValueAt(i, 0) != null) {
            try {
                // Criar um novo objeto a cada iteração para evitar sobrescrita
                Prescricao obj = new Prescricao();
                obj.setPrescricao(presc);

                int medicamento = Integer.parseInt(dados.getValueAt(i, 0).toString());
                obj.setMedicamentos(medicamento);

                int Frequencia = Integer.parseInt(dados.getValueAt(i, 2).toString());
                obj.setFrequencia(Frequencia);

                // Buscar a existência do medicamento antes de inserir ou atualizar
                Prescricao existe = dao.BuscarPorMedicamento(presc, medicamento);

                if (existe != null && existe.getMedicamentos() > 0) {
                    dao.Editar(obj);
                } else {
                    dao.Salvar(obj);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro na linha " + (i + 1) + ": O valor não é um número válido.");
            }
        }
    }

    // Processamento dos antibióticos
    DefaultTableModel dado = (DefaultTableModel) Tabela1.getModel();
    for (int i = 0; i < dado.getRowCount(); i++) {
        if (dado.getValueAt(i, 0) != null) {
            try {
                // Criar um novo objeto a cada iteração
                Prescricao obj = new Prescricao();
                obj.setPrescricao(presc);

                int Antibiotico = Integer.parseInt(dado.getValueAt(i, 0).toString());
                obj.setAntibioticos(Antibiotico);

                int Frequencia = Integer.parseInt(dado.getValueAt(i, 2).toString());
                obj.setFrequencia(Frequencia);

                // Buscar existência antes de inserir ou atualizar
                Prescricao existe = dao.BuscarPorAntibiotico(presc, Antibiotico);

                if (existe != null && existe.getAntibioticos() > 0) {
                    dao.Editar(obj);
                } else {
                    dao.Salvar(obj);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro na linha " + (i + 1) + ": O valor não é um número válido.");
            }
        }
    }

    JOptionPane.showMessageDialog(null, "Prescrições salvas/atualizadas com sucesso!");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erro ao processar a tabela: " + e.getMessage());
}


    }//GEN-LAST:event_jButton7ActionPerformed

    private void TabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaMouseEntered

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
     int row = Tabela.getSelectedRow();
     if (row >= 0) { 
         txtCOD.setText(Tabela.getValueAt(row, 0).toString());
         txtNomeMed.setText(Tabela.getValueAt(row, 1).toString());
         txtFreqMed.setText(Tabela.getValueAt(row, 2).toString());
     }
    }//GEN-LAST:event_TabelaMouseClicked

    private void Tabela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela1MouseClicked
        int row = Tabela1.getSelectedRow();
     if (row >= 0) { 
         txtCOD1.setText(Tabela1.getValueAt(row, 0).toString());
         txtNomeAnt.setText(Tabela1.getValueAt(row, 1).toString());
         txtFreqAnt.setText(Tabela1.getValueAt(row, 2).toString());
     }
    }//GEN-LAST:event_Tabela1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrescricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrescricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrescricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrescricao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new frmPrescricao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tabela;
    public javax.swing.JTable Tabela1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JTextField txtCOD;
    protected javax.swing.JTextField txtCOD1;
    private javax.swing.JTextField txtFreqAnt;
    private javax.swing.JTextField txtFreqMed;
    private javax.swing.JTextField txtNome;
    protected javax.swing.JTextField txtNomeAnt;
    protected javax.swing.JTextField txtNomeMed;
    private javax.swing.JTextField txtProntuario;
    private javax.swing.JTextField txtprescricao;
    // End of variables declaration//GEN-END:variables
}
