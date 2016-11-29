/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionrentabilite;

import java.awt.Color;
import java.sql.*;
/**
 *
 * @author Valoo22
 */
public class FenRentabilite extends javax.swing.JDialog 
    {
        Connection conn1;
        /**
         * Creates new form FenRentabilite
         */
        public FenRentabilite() 
            {
                initComponents();
                TSession.getTableHeader().setReorderingAllowed(false);
            }
        public FenRentabilite(Connection conn)
            {
                try
                    {  
                        initComponents();
                        TSession.getTableHeader().setReorderingAllowed(false);
                        conn1 = conn;
                        lblMarge.setText("");
                        Statement stmt = conn.createStatement();
                        ResultSet rs  = stmt.executeQuery("SELECT DISTINCT s.id, libelle, date_debut, nb_inscrits, nb_places, round(nb_inscrits*100/nb_places,2) as TauxRemplissage FROM session_formation s, formation f WHERE date_debut > CURRENT_DATE AND s.formation_id = f.id");
                        int lig = 0;
                        //vider
                        for(int i=0; i < TSession.getRowCount();i++)
                            {
                                for(int col=0;col <TSession.getColumnCount();col++)
                                    {
                                        TSession.setValueAt(null,i,col);
                                    }
                            }
                        while (rs.next())
                            {
                                for(int col=0;col <TSession.getColumnCount();col++)
                                    {
                                        TSession.setValueAt(rs.getObject(col+1),lig,col);
                                    }
                                lig++;
                            }
                        rs.close();
                    }
                catch(SQLException SQL)
                    {
                        System.out.println("erreur SQL: " + SQL.getMessage());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lblTitre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TSession = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TClient = new javax.swing.JTable();
        lblTMarge = new javax.swing.JLabel();
        lblMarge = new javax.swing.JLabel();
        pbTauxRemplissage = new javax.swing.JProgressBar();
        lblTauxRemplissage = new javax.swing.JLabel();
        btnRetourMenu = new javax.swing.JButton();
        bynQuitter = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de la rentabilité");

        lblTitre.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblTitre.setText("Gestion de la Rentabilité");
        lblTitre.setFocusable(false);
        lblTitre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TSession.setModel(new ModeleJTableRenta());
        TSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TSessionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TSession);

        TClient.setModel(new ModeleJTableRenta2());
        jScrollPane3.setViewportView(TClient);

        lblTMarge.setText("Marge : ");

        lblMarge.setText("*");

        pbTauxRemplissage.setForeground(new java.awt.Color(153, 153, 255));
        pbTauxRemplissage.setString("");

        lblTauxRemplissage.setText("Taux de remplissage :");

        btnRetourMenu.setText("Retour au Menu");
        btnRetourMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourMenuActionPerformed(evt);
            }
        });

        bynQuitter.setText("Quitter");
        bynQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bynQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(lblTitre)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pbTauxRemplissage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTMarge)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblMarge, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblTauxRemplissage)
                                    .addComponent(btnRetourMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bynQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 95, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitre)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTMarge)
                            .addComponent(lblMarge))
                        .addGap(1, 1, 1)
                        .addComponent(lblTauxRemplissage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbTauxRemplissage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRetourMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bynQuitter)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TSessionMouseClicked
        if (TSession.getValueAt(TSession.getSelectedRow(), 0) != null)
            {
                String num_sess = (TSession.getValueAt(TSession.getSelectedRow(), 0).toString());
                try
                    { 
                        Statement stmt = conn1.createStatement();
                        ResultSet rs  = stmt.executeQuery("SELECT nom, taux_horaire FROM client, statut, inscription WHERE statut.id = client.statut_id AND client.id = inscription.client_id AND session_formation_id =" + num_sess);
                        int lig = 0;
                        //vider[[
                        for(int i=0; i < TClient.getRowCount();i++)
                            {
                                for(int col=0;col <TClient.getColumnCount();col++)
                                    {
                                        TClient.setValueAt(null,i,col);
                                    }
                            }
                        //]]
                        while (rs.next())
                            {
                                for(int col=0;col <TClient.getColumnCount();col++)
                                    {
                                        TClient.setValueAt(rs.getObject(col+1),lig,col);
                                    }
                                lig++;
                            }
                        rs.close();
                        //on récupère la formation :
                        int ligne=0;
                        ligne=TSession.getSelectedRow();
                        Object cellule = TSession.getValueAt(ligne,0);
                        Object tr = TSession.getValueAt(ligne,5);
                        String sttr = tr.toString();
                        double inttr = Double.parseDouble(sttr);
                        int restr = (int) inttr;
                        //jLabel3.setText(cellule.toString());
                        String num = "";
                        num = cellule.toString(); 
                        pbTauxRemplissage.setValue(restr);
                        pbTauxRemplissage.setStringPainted(true);
                        /***********************************************/
                        try
                            {      
                                //on prend le cumul
                                System.out.println("num formation : " + num);
                                Statement stmt1 = conn1.createStatement();
                                ResultSet rs2 =  stmt1.executeQuery("Select sum(taux_horaire) as revenu_session from statut st, session_formation s, client c, inscription i where s.id = i.session_formation_id and c.id = i.id and c.statut_id = st.id and s.id = " + num);
                                rs2.next(); // car le premier rsultat est en position 1 et on est en 0
                                System.out.println("cumul :"+rs2.getFloat(1));
                                //on prend le cout de revien
                                Statement stmt2 = conn1.createStatement();
                                ResultSet rs3 = stmt2.executeQuery("Select coutrevient from formation, session_formation where formation.id = session_formation.formation_id and session_formation.id = " + num );
                                rs3.next();
                                System.out.println("cout de revient : "+rs3.getFloat(1));
                                //marge = cout de revien - cumul
                                float marge = ( rs2.getFloat(1) - rs3.getFloat(1));
                                System.out.println("marge : "+  marge);
                                //on affiche
                                    if (marge < 0)
                                        {
                                            lblMarge.setForeground (Color.red);
                                            lblMarge.setText(""+marge);
                                            //couleur de la progressbar
                                            //jProgressBar1.setForeground(Color.red);
                                        } 
                                    else 
                                        {
                                            lblMarge.setForeground (Color.blue);
                                            lblMarge.setText(""+marge);
                                           //jProgressBar1.setForeground(Color.blue);
                                        }
                                    rs2.close();
                            }
                        catch (SQLException sqle)
                            {
                                System.out.print("Erreur SQL : " + sqle.getMessage());
                            }
                        /*********************************************/
                    }
                catch(SQLException SQL)
                    {
                        System.out.println("erreur SQL: " + SQL.getMessage());
                    }
            }         
        else
            {
                //on vide si on click sur rien
                for(int i=0; i < TClient.getRowCount();i++)
                    {
                        for(int col=0;col <TClient.getColumnCount();col++)
                            {
                                TClient.setValueAt(null,i,col);
                            }
                    }
                lblMarge.setText("");
                System.out.println("vide");     
            }
    }//GEN-LAST:event_TSessionMouseClicked

    private void btnRetourMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetourMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRetourMenuActionPerformed

    private void bynQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bynQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bynQuitterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TClient;
    private javax.swing.JTable TSession;
    private javax.swing.JButton btnRetourMenu;
    private javax.swing.JButton bynQuitter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblMarge;
    private javax.swing.JLabel lblTMarge;
    private javax.swing.JLabel lblTauxRemplissage;
    private javax.swing.JLabel lblTitre;
    private javax.swing.JProgressBar pbTauxRemplissage;
    // End of variables declaration//GEN-END:variables
}
