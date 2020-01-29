/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author stroe
 */
public class Facturi extends javax.swing.JFrame {
Connection conn=null;
    OraclePreparedStatement pst=null,pst1=null,pst2=null;
    OracleResultSet rs=null;
    /**
     * Creates new form Facturi
     */
    public Facturi() {
         super("Facturi");
        initComponents();
        conn=JavaConnectDB.ConnecrDB();
       Show_Products_In_JTable();
    }
    
    int pos =0;
    
    //resetare campuri 
     public void clearFields(){
        cod.setText(null);
        denumire.setText(null);
        pret.setText(null);
        codc.setText(null);
        nume.setText(null);
        nr.setText(null);
        cantitate.setText(null);
        pretfact.setText(null);
        titular.setText(null);
        numar.setText(null);
        cvc.setText(null);
        expcard.setText(null);
        datafact.setText(null);
    }

     
     //Verificati campurile de intrare
    
    public boolean checkInputs(){
        if(        
                    cod.getText()==null
                || denumire.getText()==null
                || pret.getText()==null
                || codc.getText()==null
                || nume.getText()==null
                || nr.getText()==null
                || cantitate.getText()==null
                || pretfact.getText()==null
                || titular.getText()==null
                || numar.getText()==null
                || cvc.getText()==null
                || expcard.getText()==null
                || datafact.getText()==null
                ){
                    return false;
              }else{
                    try{
                        Float.parseFloat(numar.getText());
                        return true;
                    }catch(Exception ex){
                        return false;
                    }
        }   
        
    }
    
    
    
    
    //Afisarea datelor in Tabla
     //         1 -- Umplerea listei cu datele
    
        public ArrayList<Factura> getFacturaList(){
        
            ArrayList<Factura> faturaList = new ArrayList<Factura>();
            String query = "select * from facturafinala";
            try {
            Statement state=conn.createStatement();
            ResultSet rs=state.executeQuery(query);
            Factura product;
            
            while(rs.next()){
                product=new Factura(rs.getInt("CODPRODUS"),rs.getString("DENPRODUS"),rs.getString("PRETREFERINTA"),rs.getString("CODCLIENT"),rs.getString("NUME"),rs.getString("NRFACTURA"),rs.getString("CANTITATEFACTURA"),rs.getString("PRETFACTURAT"),rs.getString("TITULARCARD"),rs.getString("NUMARCARD"),rs.getString("CVC"),rs.getString("EXPIRARECARD"),rs.getString("DATAFACT"));
                faturaList.add(product);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(VizualizareProduse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return    faturaList;
     
        }
     
     //         2 -- Popularea Tablei
     public void Show_Products_In_JTable(){
         ArrayList<Factura> list = getFacturaList();
         DefaultTableModel model = (DefaultTableModel)factura.getModel();
        
         
         model.setRowCount(0);
         Object[] row = new Object[13];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getcod();
            row[1] = list.get(i).getdenumire();
            row[2] = list.get(i).getpret();
            row[3] = list.get(i).getcodc();
            row[4] = list.get(i).getnume();
            row[5] = list.get(i).getnumar();
            row[6] = list.get(i).getcantitate();
            row[7] = list.get(i).getpretfact();
            row[8] = list.get(i).gettitular();
            row[9] = list.get(i).getnrcad();
            row[10] = list.get(i).getcvc();
            row[11] = list.get(i).getexptcard();
            row[12] = list.get(i).getdatafact();
            
            model.addRow(row);
        }  
         
     }
     
     public void ShowItem(int index){
         cod.setText(Integer.toString(getFacturaList().get(index).getcod()));
         denumire.setText(getFacturaList().get(index).getdenumire());
         pret.setText(getFacturaList().get(index).getpret());
         codc.setText(getFacturaList().get(index).getcodc());
         nume.setText(getFacturaList().get(index).getnume());
         nr.setText(getFacturaList().get(index).getnumar());
         cantitate.setText(getFacturaList().get(index).getcantitate());
         pretfact.setText(getFacturaList().get(index).getpretfact());
         titular.setText(getFacturaList().get(index).gettitular());
         numar.setText(getFacturaList().get(index).getnrcad());
         cvc.setText(getFacturaList().get(index).getcvc());
         expcard.setText(getFacturaList().get(index).getexptcard());
         datafact.setText(getFacturaList().get(index).getdatafact());
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        poza = new javax.swing.JLabel();
        titular = new javax.swing.JTextField();
        pretfact = new javax.swing.JTextField();
        cantitate = new javax.swing.JTextField();
        nume = new javax.swing.JTextField();
        codc = new javax.swing.JTextField();
        pret = new javax.swing.JTextField();
        denumire = new javax.swing.JTextField();
        cod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        factura = new javax.swing.JTable();
        urmatorul = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        inapoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        actualizati = new javax.swing.JButton();
        sterge = new javax.swing.JButton();
        nr = new javax.swing.JTextField();
        numar = new javax.swing.JTextField();
        poza1 = new javax.swing.JLabel();
        poza2 = new javax.swing.JLabel();
        poza3 = new javax.swing.JLabel();
        cvc = new javax.swing.JTextField();
        expcard = new javax.swing.JTextField();
        datafact = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cod Produs");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Denumire Produs");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pret Referinta");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cod Client");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nume");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Numar Factura");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cantitate Factura");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Pret Facturat");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Titular Card");

        poza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        poza.setText("Numar Card");

        titular.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        titular.setPreferredSize(new java.awt.Dimension(6, 25));

        pretfact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cantitate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cantitate.setPreferredSize(new java.awt.Dimension(6, 25));

        nume.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nume.setPreferredSize(new java.awt.Dimension(6, 25));

        codc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        codc.setPreferredSize(new java.awt.Dimension(6, 25));

        pret.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pret.setPreferredSize(new java.awt.Dimension(6, 25));

        denumire.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        denumire.setPreferredSize(new java.awt.Dimension(6, 25));

        cod.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cod.setEnabled(false);
        cod.setPreferredSize(new java.awt.Dimension(6, 25));

        factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Produs", "Denumire Produs", "Pret Referinta", "Cod Client", "Nume", "Numar Factura", "Cantitate Factura", "Pret Facturat", "Titular Card", "Numar Card", "CVC", "Expirare Card", "Data Facturare"
            }
        ));
        factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facturaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(factura);

        urmatorul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        urmatorul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Forward_20px.png"))); // NOI18N
        urmatorul.setText("Urmatorul");
        urmatorul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urmatorulActionPerformed(evt);
            }
        });

        anterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Back_20px.png"))); // NOI18N
        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        inapoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inapoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Back_20px.png"))); // NOI18N
        inapoi.setText("Inapoi");
        inapoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inapoiActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Facturi");

        actualizati.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        actualizati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Update_20px.png"))); // NOI18N
        actualizati.setText("Actualizare");
        actualizati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizatiActionPerformed(evt);
            }
        });

        sterge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sterge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagini/Delete_20px.png"))); // NOI18N
        sterge.setText("Ștergere");
        sterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeActionPerformed(evt);
            }
        });

        nr.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        nr.setPreferredSize(new java.awt.Dimension(6, 25));

        numar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        numar.setPreferredSize(new java.awt.Dimension(6, 25));

        poza1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        poza1.setText("CVC");

        poza2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        poza2.setText("Expirare Card");

        poza3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        poza3.setText("Data Factura");

        cvc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cvc.setPreferredSize(new java.awt.Dimension(6, 25));

        expcard.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        expcard.setPreferredSize(new java.awt.Dimension(6, 25));

        datafact.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        datafact.setPreferredSize(new java.awt.Dimension(6, 25));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Printare Factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poza, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poza1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poza2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(poza3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inapoi)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(actualizati)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sterge)
                        .addGap(143, 143, 143)
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(urmatorul)
                        .addGap(146, 146, 146))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cod, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(denumire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantitate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pretfact)
                            .addComponent(titular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(expcard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cvc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datafact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(855, 855, 855)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel12)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(denumire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(codc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cantitate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pretfact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(poza)
                                    .addComponent(numar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(titular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(poza1)
                            .addComponent(cvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(poza2)
                            .addComponent(expcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datafact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poza3)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inapoi)
                    .addComponent(actualizati)
                    .addComponent(sterge)
                    .addComponent(urmatorul)
                    .addComponent(anterior))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facturaMouseClicked
        // TODO add your handling code here:
        int index=factura.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_facturaMouseClicked

    private void urmatorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urmatorulActionPerformed
        // TODO add your handling code here:
        pos++;

        if(pos>=getFacturaList().size()){
            pos=getFacturaList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_urmatorulActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
        pos--;
        if(pos<0){
            pos=0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_anteriorActionPerformed

    private void inapoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inapoiActionPerformed
        // TODO add your handling code here:
        this.hide();
        Meniu frm=new Meniu();
        frm.setVisible(true);
    }//GEN-LAST:event_inapoiActionPerformed

    private void actualizatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizatiActionPerformed
        // TODO add your handling code here:
        if(checkInputs()){
            String UptadeQuery=null;
            pst=null;
            pst1=null;
                try {
                    //UptadeQuery="UPDATE localizare SET CODPOSTAL=? where CODCLIENT=?";
                    //pst1=(OraclePreparedStatement) conn.prepareStatement(UptadeQuery);
                    //pst1.setString(1, postal.getText());
                    //pst1.executeUpdate();
                    
                    UptadeQuery="UPDATE facturafinala SET DENPRODUS=?, PRETREFERINTA=?, CODCLIENT=?, NUME=?, NRFACTURA=?, CANTITATEFACTURA=?, PRETFACTURAT=?, TITULARCARD=?, NUMARCARD=?, CVC=?, EXPIRARECARD=?, DATAFACT=? WHERE CODPRODUS=?";
                    pst=(OraclePreparedStatement) conn.prepareStatement(UptadeQuery);
                    pst.setString(1, denumire.getText());
                    pst.setString(2, pret.getText());
                    pst.setString(3, codc.getText());
                    pst.setString(4, nume.getText());
                    pst.setString(5, nr.getText());
                    pst.setString(6, cantitate.getText());
                    pst.setString(7, pretfact.getText());
                    pst.setString(8, titular.getText());
                    pst.setString(9, numar.getText());
                    pst.setString(10, cvc.getText());
                    pst.setString(11, expcard.getText());
                    pst.setString(12, datafact.getText());
                    pst.setString(13, cod.getText());
                    pst.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Factura A Fost Actualizata!");
                    clearFields();
                } catch (Exception ex) {
                    Logger.getLogger(AdaugatiClienti.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }//GEN-LAST:event_actualizatiActionPerformed

    private void stergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeActionPerformed
        // TODO add your handling code here:
         if(!cod.getText().equals(""))
        {
            try {
             pst1=(OraclePreparedStatement) conn.prepareStatement("DELETE FROM facturat WHERE NRFACT=? ");
             int id1=Integer.parseInt(nr.getText());
              pst1.setInt(1, id1);
              pst1.executeUpdate();
              
              
              pst2=(OraclePreparedStatement) conn.prepareStatement("DELETE FROM factura WHERE NRFACTURA=? ");
             int id2=Integer.parseInt(nr.getText());
              pst2.setInt(1, id2);
              pst2.executeUpdate();
              
              
                pst=(OraclePreparedStatement) conn.prepareStatement("DELETE FROM facturafinala WHERE NRFACTURA=?");
                int id=Integer.parseInt(nr.getText());
                pst.setInt(1, id);
                pst.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null,"Factura a fost stersa!");
                clearFields();
            } catch (SQLException ex) {
                Logger.getLogger(AdaugatiClienti.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Factura nu a fost stersa!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Factura nu a fost stersa : Nu se șterge id-ul!");
        }
    }//GEN-LAST:event_stergeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         String filePath="C:\\Users\\stroe\\OneDrive\\Documente\\NetBeansProjects\\Magazin Proiect\\factura.txt";
         File file=new File(filePath);
        try {
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("--------------------------------------FACTURA-------------------------------------------------"+"\n|\n|\n");
            bw.write("| Informatii Client                                              Informatii Plata\n");
            bw.write("|  Cod Client:"+cod.getText()+"                                                Nume Titular: "+titular.getText()+"\n");
            bw.write("|  Nume:"+nume.getText()+"                                              Numar Card: "+numar.getText()+"\n");
            bw.write("|  Numar Factura:"+nr.getText()+"                                             CVC: "+cvc.getText()+"\n");
            bw.write("|                                                               Expirare Card: "+expcard.getText()+"\n|\n");
            bw.write("|                               Data Facturare: "+datafact.getText()+"\n|\n");
            
            bw.write("|-----------------------------------------------------------------------------------------------"+"\n");
            bw.write("|  Cod Produs  |"+"  Denumire Produs  |"+"  Cantitate Factura  |"+"  Pret Referinta |\n");
            bw.write("|-----------------------------------------------------------------------------------------------"+"\n");
            bw.write("|     "+cod.getText()+"          "+denumire.getText()+"                 "+cantitate.getText()+"                  "+pret.getText()+" \n");
            bw.write("|-----------------------------------------------------------------------------------------------"+"\n");
            bw.write("|                                                          Total Plata: "+pretfact.getText()+"\n");
            bw.write("|-----------------------------------------------------------------------------------------------"+"\n");
            //bw.write(cod.getText());
         
            JOptionPane.showMessageDialog(null,"Factura printata!");
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(AdaugatiProduse.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Factura neprintata!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Facturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizati;
    private javax.swing.JButton anterior;
    private javax.swing.JTextField cantitate;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField codc;
    private javax.swing.JTextField cvc;
    private javax.swing.JTextField datafact;
    private javax.swing.JTextField denumire;
    private javax.swing.JTextField expcard;
    private javax.swing.JTable factura;
    private javax.swing.JButton inapoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nr;
    private javax.swing.JTextField numar;
    private javax.swing.JTextField nume;
    private javax.swing.JLabel poza;
    private javax.swing.JLabel poza1;
    private javax.swing.JLabel poza2;
    private javax.swing.JLabel poza3;
    private javax.swing.JTextField pret;
    private javax.swing.JTextField pretfact;
    private javax.swing.JButton sterge;
    private javax.swing.JTextField titular;
    private javax.swing.JButton urmatorul;
    // End of variables declaration//GEN-END:variables
}
