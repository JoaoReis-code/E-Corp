/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package e.corp.interfaces;

import e.corp.sistema.cliente.Cliente;
import e.corp.sistema.cliente.Sexo;
import e.corp.sistema.conta.Conta;
import e.corp.sistema.conta.TipoConta;
import e.corp.sistema.crud.Crud;

import javax.swing.*;
import java.time.LocalDate;

import static e.corp.ECorp.contaLogada;

/**
 * @author Jz
 */
public class TelaCadastro extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel animalFavoritoLabel;
    private javax.swing.JTextField animalFavoritoTextField;
    private javax.swing.JLabel anoLabel;
    private javax.swing.JTextField anoTextField;
    private javax.swing.JLabel cadastroLabel;
    private javax.swing.JLabel comidaFavoritaLabel;
    private javax.swing.JTextField comidaFavoritaTextField;
    private javax.swing.JLabel corFavoritaLabel;
    private javax.swing.JTextField corFavoritaTextField;
    private javax.swing.JRadioButton correnteRadioButton;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JLabel dataLabel1;
    private javax.swing.JLabel diaLabel;
    private javax.swing.JTextField diaTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JRadioButton femininoRadioButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JRadioButton masculinoRadioButton;
    private javax.swing.JLabel mesLabel;
    private javax.swing.JTextField mesTextField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JRadioButton poupancaRadioButton;
    private javax.swing.JLabel rendaLabel;
    private javax.swing.JTextField rendaTextField;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JLabel tipoContaLabel;

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/e/corp/interfaces/imagens/icone.png")).getImage());
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cadastroLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        diaLabel = new javax.swing.JLabel();
        sexoLabel = new javax.swing.JLabel();
        rendaLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        cpfTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        diaTextField = new javax.swing.JTextField();
        rendaTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        animalFavoritoLabel = new javax.swing.JLabel();
        animalFavoritoTextField = new javax.swing.JTextField();
        corFavoritaLabel = new javax.swing.JLabel();
        corFavoritaTextField = new javax.swing.JTextField();
        comidaFavoritaLabel = new javax.swing.JLabel();
        comidaFavoritaTextField = new javax.swing.JTextField();
        tipoContaLabel = new javax.swing.JLabel();
        masculinoRadioButton = new javax.swing.JRadioButton();
        femininoRadioButton = new javax.swing.JRadioButton();
        correnteRadioButton = new javax.swing.JRadioButton();
        poupancaRadioButton = new javax.swing.JRadioButton();
        dataLabel1 = new javax.swing.JLabel();
        mesLabel = new javax.swing.JLabel();
        mesTextField = new javax.swing.JTextField();
        anoLabel = new javax.swing.JLabel();
        anoTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("E-Corp");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(248, 248, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel3.setLayout(null);

        cadastroLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        cadastroLabel.setText("INSIRA SEUS DADOS");
        jPanel3.add(cadastroLabel);
        cadastroLabel.setBounds(30, 10, 238, 33);

        cpfLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cpfLabel.setText("Cpf");
        jPanel3.add(cpfLabel);
        cpfLabel.setBounds(30, 70, 200, 20);

        emailLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        emailLabel.setText("Email");
        jPanel3.add(emailLabel);
        emailLabel.setBounds(30, 170, 200, 20);

        diaLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        diaLabel.setText("Dia");
        jPanel3.add(diaLabel);
        diaLabel.setBounds(30, 400, 100, 20);

        sexoLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        sexoLabel.setText("Sexo");
        jPanel3.add(sexoLabel);
        sexoLabel.setBounds(260, 220, 90, 20);

        rendaLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        rendaLabel.setText("Renda mensal");
        jPanel3.add(rendaLabel);
        rendaLabel.setBounds(30, 220, 200, 20);

        nomeTextField.setBackground(new java.awt.Color(248, 248, 255));
        nomeTextField.setBorder(null);
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(nomeTextField);
        nomeTextField.setBounds(30, 140, 200, 19);

        cpfTextField.setBackground(new java.awt.Color(248, 248, 255));
        cpfTextField.setBorder(null);
        jPanel3.add(cpfTextField);
        cpfTextField.setBounds(30, 90, 200, 20);

        emailTextField.setBackground(new java.awt.Color(248, 248, 255));
        emailTextField.setBorder(null);
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(emailTextField);
        emailTextField.setBounds(30, 190, 200, 19);

        diaTextField.setBackground(new java.awt.Color(248, 248, 255));
        diaTextField.setBorder(null);
        jPanel3.add(diaTextField);
        diaTextField.setBounds(30, 420, 100, 19);

        rendaTextField.setBackground(new java.awt.Color(248, 248, 255));
        rendaTextField.setBorder(null);
        rendaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendaTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(rendaTextField);
        rendaTextField.setBounds(30, 240, 200, 19);

        nomeLabel.setBackground(new java.awt.Color(0, 0, 0));
        nomeLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        nomeLabel.setText("Nome");
        jPanel3.add(nomeLabel);
        nomeLabel.setBounds(30, 120, 200, 20);

        animalFavoritoLabel.setBackground(new java.awt.Color(0, 0, 0));
        animalFavoritoLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        animalFavoritoLabel.setText("Animal favorito");
        jPanel3.add(animalFavoritoLabel);
        animalFavoritoLabel.setBounds(260, 70, 190, 20);

        animalFavoritoTextField.setBackground(new java.awt.Color(248, 248, 255));
        animalFavoritoTextField.setBorder(null);
        animalFavoritoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalFavoritoTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(animalFavoritoTextField);
        animalFavoritoTextField.setBounds(260, 90, 200, 19);

        corFavoritaLabel.setBackground(new java.awt.Color(0, 0, 0));
        corFavoritaLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        corFavoritaLabel.setText("Cor favorita");
        jPanel3.add(corFavoritaLabel);
        corFavoritaLabel.setBounds(260, 120, 200, 20);

        corFavoritaTextField.setBackground(new java.awt.Color(248, 248, 255));
        corFavoritaTextField.setBorder(null);
        corFavoritaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corFavoritaTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(corFavoritaTextField);
        corFavoritaTextField.setBounds(260, 140, 200, 19);

        comidaFavoritaLabel.setBackground(new java.awt.Color(0, 0, 0));
        comidaFavoritaLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        comidaFavoritaLabel.setText("Comida favorita");
        jPanel3.add(comidaFavoritaLabel);
        comidaFavoritaLabel.setBounds(260, 170, 200, 20);

        comidaFavoritaTextField.setBackground(new java.awt.Color(248, 248, 255));
        comidaFavoritaTextField.setBorder(null);
        comidaFavoritaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidaFavoritaTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(comidaFavoritaTextField);
        comidaFavoritaTextField.setBounds(260, 190, 200, 19);

        tipoContaLabel.setBackground(new java.awt.Color(0, 0, 0));
        tipoContaLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        tipoContaLabel.setText("Tipo da conta");
        jPanel3.add(tipoContaLabel);
        tipoContaLabel.setBounds(370, 220, 110, 20);

        masculinoRadioButton.setBackground(new java.awt.Color(248, 248, 255));
        masculinoRadioButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        masculinoRadioButton.setText("Masculino");
        masculinoRadioButton.setBorder(null);
        jPanel3.add(masculinoRadioButton);
        masculinoRadioButton.setBounds(260, 240, 110, 19);

        femininoRadioButton.setBackground(new java.awt.Color(248, 248, 255));
        femininoRadioButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        femininoRadioButton.setText("Feminino");
        femininoRadioButton.setBorder(null);
        jPanel3.add(femininoRadioButton);
        femininoRadioButton.setBounds(260, 260, 110, 19);

        correnteRadioButton.setBackground(new java.awt.Color(248, 248, 255));
        correnteRadioButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        correnteRadioButton.setText("Corrente");
        correnteRadioButton.setBorder(null);
        jPanel3.add(correnteRadioButton);
        correnteRadioButton.setBounds(370, 240, 100, 19);

        poupancaRadioButton.setBackground(new java.awt.Color(248, 248, 255));
        poupancaRadioButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        poupancaRadioButton.setText("Poupanca");
        poupancaRadioButton.setBorder(null);
        jPanel3.add(poupancaRadioButton);
        poupancaRadioButton.setBounds(370, 260, 100, 19);

        dataLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        dataLabel1.setText("Data de nascimento");
        jPanel3.add(dataLabel1);
        dataLabel1.setBounds(30, 280, 200, 20);

        mesLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        mesLabel.setText("Mes");
        jPanel3.add(mesLabel);
        mesLabel.setBounds(30, 350, 100, 20);

        mesTextField.setBackground(new java.awt.Color(248, 248, 255));
        mesTextField.setBorder(null);
        mesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(mesTextField);
        mesTextField.setBounds(30, 370, 100, 19);

        anoLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        anoLabel.setText("Ano");
        jPanel3.add(anoLabel);
        anoLabel.setBounds(30, 300, 100, 20);

        anoTextField.setBackground(new java.awt.Color(248, 248, 255));
        anoTextField.setBorder(null);
        jPanel3.add(anoTextField);
        anoTextField.setBounds(30, 320, 100, 19);
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(260, 210, 200, 10);
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(30, 160, 200, 10);
        jPanel3.add(jSeparator3);
        jSeparator3.setBounds(30, 110, 200, 10);
        jPanel3.add(jSeparator4);
        jSeparator4.setBounds(30, 210, 200, 10);
        jPanel3.add(jSeparator5);
        jSeparator5.setBounds(30, 440, 100, 10);
        jPanel3.add(jSeparator6);
        jSeparator6.setBounds(30, 390, 100, 10);
        jPanel3.add(jSeparator7);
        jSeparator7.setBounds(30, 340, 100, 10);
        jPanel3.add(jSeparator8);
        jSeparator8.setBounds(30, 260, 200, 10);
        jPanel3.add(jSeparator10);
        jSeparator10.setBounds(260, 110, 200, 10);
        jPanel3.add(jSeparator11);
        jSeparator11.setBounds(260, 160, 200, 10);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jButton3.setBackground(new java.awt.Color(248, 248, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Proximo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/e/corp/interfaces/imagens/logo pequena.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 131, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(480, 0, 320, 500);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void rendaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rendaTextFieldActionPerformed

    private void animalFavoritoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalFavoritoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animalFavoritoTextFieldActionPerformed

    private void corFavoritaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corFavoritaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corFavoritaTextFieldActionPerformed

    private void comidaFavoritaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidaFavoritaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comidaFavoritaTextFieldActionPerformed

    private void mesTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesTextFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cpf = cpfTextField.getText();
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String renda = rendaTextField.getText();
        String ano = anoTextField.getText();
        String mes = mesTextField.getText();
        String dia = diaTextField.getText();
        String animalFavorito = animalFavoritoTextField.getText();
        String comidaFavorita = comidaFavoritaTextField.getText();
        String corFavorita = corFavoritaTextField.getText();
        Sexo sexo = null;
        TipoConta tipoConta = null;

        if (masculinoRadioButton.isSelected()) {
            sexo = Sexo.MASCULINO;
        }
        if (femininoRadioButton.isSelected()) {
            sexo = Sexo.FEMININO;
        }
        if (poupancaRadioButton.isSelected()) {
            tipoConta = TipoConta.POUPANCA;
        }
        if (correnteRadioButton.isSelected()) {
            tipoConta = TipoConta.CORRENTE;
        }

        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() ||
                renda.isEmpty() || ano.isEmpty() || mes.isEmpty() ||
                dia.isEmpty() || animalFavorito.isEmpty() ||
                comidaFavorita.isEmpty() || corFavorita.isEmpty() ||
                sexo == null || tipoConta == null) {

            JOptionPane.showMessageDialog(null, "Todos os campos precisam estar preenchidos");
        } else {
            try {
                LocalDate dataNascimento = LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));

                Cliente cliente = new Cliente(nome, cpf, email, dataNascimento, sexo, Double.parseDouble(renda));
                Conta conta = new Conta(cliente, tipoConta, corFavorita, comidaFavorita, animalFavorito);
                Crud.add(conta);
                Crud.add(cliente);
                contaLogada = conta;

                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");

                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
                tela.setLocationRelativeTo(null);
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    // End of variables declaration//GEN-END:variables
}
