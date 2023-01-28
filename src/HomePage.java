/**
 * @author Cynthia Valdes
 * @description
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        super("Home");
        initComponents();
        conn = javaconnect.ConnecrDb();
        AssignOriginalAmount();
        welcome();
    }
    
    public void AssignOriginalAmount(){
        String assign = "Select * from Account where ID = ?";
        try{
            pst = conn.prepareStatement(assign);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            if(rs.next()){
                overallAmount.setOriginalAmount(rs.getFloat("OriginalAmt"));
                String displayOriginalAmt = rs.getString("OriginalAmt");
                originalamt_label.setText(displayOriginalAmt);
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e); 
        }
    }
    
    public void overallAmountCounter() {
        String originalOverallAmount = "Select Count() from Purchases where ID = ?";
        try{
            pst = conn.prepareStatement(originalOverallAmount);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            int amt = rs.getInt(1);
            overallAmount.setAmtCount(amt);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void lastOverallAmount() {
        String currentOverallAmount = "SELECT * FROM Purchases where ID = ? ORDER BY PID DESC  limit 1";
        try{
            pst = conn.prepareStatement(currentOverallAmount);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            if(rs.next()){
                overallAmount.setOverallAmount(rs.getFloat("OverallAmt"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void displayCurrentAmount(){
        String displaySummary = "SELECT * FROM Purchases where ID = ? ORDER BY PID DESC  limit 1";
        try{
            pst = conn.prepareStatement(displaySummary);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            if(rs.next()){
                currentOverallAmt_label.setText(rs.getString("OverallAmt"));
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        String clear = "Delete from Purchases where ID = ?";
        try{
            pst = conn.prepareStatement(clear);
            pst.setInt(1, userInfo.getID());
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void SummaryDisplay(){
        summary_textarea.setText(null);
        String displayOriginalAmt = String.valueOf(overallAmount.getOriginalAmount());
        originalamt_label.setText(displayOriginalAmt);
        displayCurrentAmount();
        String housingDisplay = "Select * from Purchases where ID = ?";
        try{
            pst = conn.prepareStatement(housingDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                summary_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void HousingDisplay(){
        Housing_textarea.setText(null);
        String housingDisplay = "Select * from Purchases where ID = ? and Type = 'Housing'";
        try{
            pst = conn.prepareStatement(housingDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Housing_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void EntertainmentDisplay(){
        Entertainment_textarea.setText(null);
        String entertainmentDisplay = "Select * from Purchases where ID = ? and Type = 'Entertainment'";
        try{
            pst = conn.prepareStatement(entertainmentDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Entertainment_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void RecreationDisplay(){
        Recreation_textarea.setText(null);
        String recreationDisplay = "Select * from Purchases where ID = ? and Type = 'Recreation'";
        try{
            pst = conn.prepareStatement(recreationDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Recreation_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void FoodDisplay(){
        Food_textarea.setText(null);
        String foodDisplay = "Select * from Purchases where ID = ? and Type = 'Food'";
        try{
            pst = conn.prepareStatement(foodDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Food_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void TransportationDisplay(){
        Transportation_textarea.setText(null);
        String transportationDisplay = "Select * from Purchases where ID = ? and Type = 'Transportation'";
        try{
            pst = conn.prepareStatement(transportationDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Transportation_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void TripsDisplay(){
        Trips_textarea.setText(null);
        String tripsDisplay = "Select * from Purchases where ID = ? and Type = 'Trips'";
        try{
            pst = conn.prepareStatement(tripsDisplay);
            pst.setInt(1, userInfo.getID());
            rs = pst.executeQuery();
            
            while(rs.next()){
                String displayName = rs.getString("Name");
                String displayPrice = rs.getString("Price");
                Trips_textarea.append(displayName + " - " + displayPrice + "\n");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        home_panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        overallamt_textfield = new javax.swing.JTextField();
        clearall_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        summary_panel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        originalamt_label = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currentOverallAmt_label = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        summary_textarea = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        housing_panel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Housing_textarea = new javax.swing.JTextArea();
        add_button_housing = new javax.swing.JButton();
        addname_textfield_housing = new javax.swing.JTextField();
        addprice_textfield_housing = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        entertainment_panel = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Entertainment_textarea = new javax.swing.JTextArea();
        add_button_entertainment = new javax.swing.JButton();
        addname_textfield_entertainment = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        addprice_textfield_entertainment = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        recreation_panel = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Recreation_textarea = new javax.swing.JTextArea();
        add_button_recreation = new javax.swing.JButton();
        addname_textfield_recreation = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        addprice_textfield_recreation = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        food_panel = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Food_textarea = new javax.swing.JTextArea();
        add_button_food = new javax.swing.JButton();
        addname_textfield_food = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        addprice_textfield_food = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        transportation_panel = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Transportation_textarea = new javax.swing.JTextArea();
        add_button_transportation = new javax.swing.JButton();
        addname_textfield_transportation = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        addprice_textfield_transportation = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        trips_panel = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Trips_textarea = new javax.swing.JTextArea();
        add_button_trips = new javax.swing.JButton();
        addname_textfield_trips = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        addprice_textfield_trips = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setText("PERSONAL FINANCE SYSTEM");

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        home_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (2).jpg")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel9.setText("Welcome,");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel2.setText("If you would like to update your overall amount, insert here. This will clear all inputs.");

        clearall_button.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        clearall_button.setText("CLEAR ALL");
        clearall_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearall_buttonActionPerformed(evt);
            }
        });

        update_button.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        update_button.setText("UPDATE");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel11.setText("If you would like to clear all inputs from all tabs please click here.");

        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel25.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\coolborder.png")); // NOI18N

        name_label.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        name_label.setText("name_label");

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(home_panelLayout.createSequentialGroup()
                        .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23))
                        .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                                        .addComponent(clearall_button)
                                        .addGap(241, 241, 241)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(name_label)
                                        .addGap(247, 247, 247))))
                            .addGroup(home_panelLayout.createSequentialGroup()
                                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(home_panelLayout.createSequentialGroup()
                                        .addGap(314, 314, 314)
                                        .addComponent(update_button))
                                    .addGroup(home_panelLayout.createSequentialGroup()
                                        .addGap(274, 274, 274)
                                        .addComponent(overallamt_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(home_panelLayout.createSequentialGroup()
                                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(home_panelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(home_panelLayout.createSequentialGroup()
                                            .addGap(102, 102, 102)
                                            .addComponent(jLabel21))
                                        .addGroup(home_panelLayout.createSequentialGroup()
                                            .addGap(184, 184, 184)
                                            .addComponent(jLabel11))))
                                .addContainerGap())))
                    .addGroup(home_panelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(home_panelLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(home_panelLayout.createSequentialGroup()
                        .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_label)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, home_panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(overallamt_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearall_button, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("HOME", home_panel);

        summary_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel27.setText("jLabel3");

        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel29.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel34.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (3).jpg")); // NOI18N

        originalamt_label.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel10.setText("Original Overall Amount:");

        jLabel12.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        jLabel12.setText("Current Overall Amount:");

        currentOverallAmt_label.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N

        summary_textarea.setEditable(false);
        summary_textarea.setColumns(20);
        summary_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        summary_textarea.setRows(5);
        summary_textarea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        jScrollPane4.setViewportView(summary_textarea);

        jLabel26.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 204));
        jLabel26.setText("Summary Of Finances");

        jLabel31.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\verticalborder (2).png")); // NOI18N
        jLabel31.setText("jLabel31");

        javax.swing.GroupLayout summary_panelLayout = new javax.swing.GroupLayout(summary_panel);
        summary_panel.setLayout(summary_panelLayout);
        summary_panelLayout.setHorizontalGroup(
            summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(summary_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(summary_panelLayout.createSequentialGroup()
                        .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30))
                        .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(summary_panelLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(summary_panelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(summary_panelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summary_panelLayout.createSequentialGroup()
                                        .addComponent(originalamt_label, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summary_panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentOverallAmt_label, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        summary_panelLayout.setVerticalGroup(
            summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, summary_panelLayout.createSequentialGroup()
                .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(summary_panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(summary_panelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(summary_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(summary_panelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(originalamt_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentOverallAmt_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(summary_panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("SUMMARY", summary_panel);

        housing_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel17.setText("jLabel3");

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Housing_textarea.setEditable(false);
        Housing_textarea.setColumns(20);
        Housing_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Housing_textarea.setRows(5);
        jScrollPane1.setViewportView(Housing_textarea);

        add_button_housing.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_housing.setText("ADD");
        add_button_housing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_housingActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel4.setText("NAME");

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel6.setText("PRICE");

        javax.swing.GroupLayout housing_panelLayout = new javax.swing.GroupLayout(housing_panel);
        housing_panel.setLayout(housing_panelLayout);
        housing_panelLayout.setHorizontalGroup(
            housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(housing_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(housing_panelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(housing_panelLayout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(add_button_housing)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_housing, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_housing, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(housing_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel4)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel6))))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(housing_panelLayout.createSequentialGroup()
                        .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        housing_panelLayout.setVerticalGroup(
            housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(housing_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(housing_panelLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(housing_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_housing))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, housing_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_housing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_housing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("HOUSING", housing_panel);

        entertainment_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Entertainment_textarea.setEditable(false);
        Entertainment_textarea.setColumns(20);
        Entertainment_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Entertainment_textarea.setRows(5);
        jScrollPane2.setViewportView(Entertainment_textarea);

        add_button_entertainment.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_entertainment.setText("ADD");
        add_button_entertainment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_entertainmentActionPerformed(evt);
            }
        });

        jLabel37.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel5.setText("NAME");

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel7.setText("PRICE");

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel38.setText("jLabel3");

        jLabel39.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel40.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        javax.swing.GroupLayout entertainment_panelLayout = new javax.swing.GroupLayout(entertainment_panel);
        entertainment_panel.setLayout(entertainment_panelLayout);
        entertainment_panelLayout.setHorizontalGroup(
            entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entertainment_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entertainment_panelLayout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(entertainment_panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(add_button_entertainment)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_entertainment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_entertainment, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(entertainment_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel5)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel7))))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(entertainment_panelLayout.createSequentialGroup()
                        .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel36)
                            .addComponent(jLabel40))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        entertainment_panelLayout.setVerticalGroup(
            entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entertainment_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entertainment_panelLayout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(entertainment_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_entertainment))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entertainment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_entertainment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_entertainment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("ENTERTAINMENT", entertainment_panel);

        recreation_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel41.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Recreation_textarea.setEditable(false);
        Recreation_textarea.setColumns(20);
        Recreation_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Recreation_textarea.setRows(5);
        jScrollPane3.setViewportView(Recreation_textarea);

        add_button_recreation.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_recreation.setText("ADD");
        add_button_recreation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_recreationActionPerformed(evt);
            }
        });

        jLabel42.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel43.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel43.setText("NAME");

        jLabel44.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel44.setText("PRICE");

        jLabel45.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel45.setText("jLabel3");

        jLabel66.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel67.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        javax.swing.GroupLayout recreation_panelLayout = new javax.swing.GroupLayout(recreation_panel);
        recreation_panel.setLayout(recreation_panelLayout);
        recreation_panelLayout.setHorizontalGroup(
            recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recreation_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recreation_panelLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recreation_panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(add_button_recreation)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_recreation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_recreation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(recreation_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel43)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel44))))
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(recreation_panelLayout.createSequentialGroup()
                        .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel41)
                            .addComponent(jLabel67))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        recreation_panelLayout.setVerticalGroup(
            recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recreation_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recreation_panelLayout.createSequentialGroup()
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(jLabel44))
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(recreation_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_recreation))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recreation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_recreation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_recreation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("RECREATION", recreation_panel);

        food_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel68.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Food_textarea.setEditable(false);
        Food_textarea.setColumns(20);
        Food_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Food_textarea.setRows(5);
        jScrollPane9.setViewportView(Food_textarea);

        add_button_food.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_food.setText("ADD");
        add_button_food.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_foodActionPerformed(evt);
            }
        });

        jLabel69.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel70.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel70.setText("NAME");

        jLabel71.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel71.setText("PRICE");

        jLabel72.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel72.setText("jLabel3");

        jLabel73.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel74.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        javax.swing.GroupLayout food_panelLayout = new javax.swing.GroupLayout(food_panel);
        food_panel.setLayout(food_panelLayout);
        food_panelLayout.setHorizontalGroup(
            food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(food_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(food_panelLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(food_panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(add_button_food)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_food, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_food, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(food_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel70)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel71))))
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(food_panelLayout.createSequentialGroup()
                        .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel73)
                            .addComponent(jLabel68)
                            .addComponent(jLabel74))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        food_panelLayout.setVerticalGroup(
            food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(food_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(food_panelLayout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel70)
                        .addComponent(jLabel71))
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(food_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_food))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, food_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_food, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("FOOD", food_panel);

        transportation_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel75.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Transportation_textarea.setEditable(false);
        Transportation_textarea.setColumns(20);
        Transportation_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Transportation_textarea.setRows(5);
        jScrollPane10.setViewportView(Transportation_textarea);

        add_button_transportation.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_transportation.setText("ADD");
        add_button_transportation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_transportationActionPerformed(evt);
            }
        });

        jLabel76.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel77.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel77.setText("NAME");

        jLabel78.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel78.setText("PRICE");

        jLabel79.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel79.setText("jLabel3");

        jLabel80.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel81.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        javax.swing.GroupLayout transportation_panelLayout = new javax.swing.GroupLayout(transportation_panel);
        transportation_panel.setLayout(transportation_panelLayout);
        transportation_panelLayout.setHorizontalGroup(
            transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transportation_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transportation_panelLayout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(transportation_panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(add_button_transportation)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_transportation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_transportation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(transportation_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel77)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel78))))
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transportation_panelLayout.createSequentialGroup()
                        .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(jLabel75)
                            .addComponent(jLabel81))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transportation_panelLayout.setVerticalGroup(
            transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transportation_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transportation_panelLayout.createSequentialGroup()
                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel77)
                        .addComponent(jLabel78))
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(transportation_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_transportation))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transportation_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_transportation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_transportation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("TRANSPORTATION", transportation_panel);

        trips_panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel82.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jScrollPane11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));

        Trips_textarea.setEditable(false);
        Trips_textarea.setColumns(20);
        Trips_textarea.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        Trips_textarea.setRows(5);
        jScrollPane11.setViewportView(Trips_textarea);

        add_button_trips.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        add_button_trips.setText("ADD");
        add_button_trips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button_tripsActionPerformed(evt);
            }
        });

        jLabel83.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel84.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel84.setText("NAME");

        jLabel85.setFont(new java.awt.Font("Baskerville Old Face", 0, 12)); // NOI18N
        jLabel85.setText("PRICE");

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\border.png")); // NOI18N
        jLabel86.setText("jLabel3");

        jLabel87.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        jLabel88.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\planet (4).jpg")); // NOI18N

        javax.swing.GroupLayout trips_panelLayout = new javax.swing.GroupLayout(trips_panel);
        trips_panel.setLayout(trips_panelLayout);
        trips_panelLayout.setHorizontalGroup(
            trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trips_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trips_panelLayout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(trips_panelLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(add_button_trips)
                                .addGap(44, 44, 44)
                                .addComponent(addname_textfield_trips, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(addprice_textfield_trips, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(trips_panelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(jLabel84)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel85))))
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(trips_panelLayout.createSequentialGroup()
                        .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addComponent(jLabel82)
                            .addComponent(jLabel88))
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trips_panelLayout.setVerticalGroup(
            trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trips_panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trips_panelLayout.createSequentialGroup()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel84)
                        .addComponent(jLabel85))
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trips_panelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(add_button_trips))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trips_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addname_textfield_trips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addprice_textfield_trips, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("TRIPS", trips_panel);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\moodyblues3.jpg")); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\moodyblues3.jpg")); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\cabba\\Pictures\\PF_Images\\moodyblues3.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane2)
                .addContainerGap())
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

        setSize(new java.awt.Dimension(848, 516));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        clear();
        try{
            float newOriginalAmt = Float.valueOf(overallamt_textfield.getText());
            String updateOverall = "update Account set OriginalAmt ='" + newOriginalAmt + "'where ID = ?";
            pst = conn.prepareStatement(updateOverall);
            pst.setInt(1, userInfo.getID());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated Overall Amount.");
            overallAmount.setOriginalAmount(newOriginalAmt);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void add_button_housingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_housingActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_housing.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_housing.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Housing");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_housingActionPerformed

    private void add_button_entertainmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_entertainmentActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_entertainment.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_entertainment.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Entertainment");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_entertainmentActionPerformed

    private void add_button_recreationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_recreationActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_recreation.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_recreation.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Recreation");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_recreationActionPerformed

    private void add_button_foodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_foodActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_food.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_food.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Food");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_foodActionPerformed

    private void add_button_transportationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_transportationActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_transportation.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_transportation.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Transportation");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_transportationActionPerformed

    private void add_button_tripsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button_tripsActionPerformed
        overallAmountCounter();
        lastOverallAmount();
        String sql = "insert into Purchases(Name,Price,OverallAmt,ID, Type) values (?,?,?,?,?)";
        try {
            float price = Float.valueOf(addprice_textfield_trips.getText());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, addname_textfield_trips.getText());
            pst.setFloat(2, price);
            if(overallAmount.getAmtCount() == 0){
                pst.setFloat(3, overallAmount.getOriginalAmount() - price);
            } else {
                pst.setFloat(3, overallAmount.getOverallAmount() - price);
            }
            pst.setInt(4, userInfo.getID());
            pst.setString(5, "Trips");
           
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added Succesfully.");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_add_button_tripsActionPerformed

    private void clearall_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearall_buttonActionPerformed
        String clearAll = "Delete From Purchases where ID = ?";
        try{
            pst = conn.prepareStatement(clearAll);
            pst.setInt(1, userInfo.getID());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Succesfully Deleted!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_clearall_buttonActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        SummaryDisplay();
        HousingDisplay();
        EntertainmentDisplay();
        RecreationDisplay();
        FoodDisplay();
        TransportationDisplay();
        TripsDisplay();
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void welcome(){
        String sql = "Select * from Account where User = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, userInfo.getUsername());
            rs = pst.executeQuery();
            
            if(rs.next()){
                String add = rs.getString("First_Name");
                name_label.setText(add);
                rs.close();
                pst.close();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Entertainment_textarea;
    private javax.swing.JTextArea Food_textarea;
    private javax.swing.JTextArea Housing_textarea;
    private javax.swing.JTextArea Recreation_textarea;
    private javax.swing.JTextArea Transportation_textarea;
    private javax.swing.JTextArea Trips_textarea;
    private javax.swing.JButton add_button_entertainment;
    private javax.swing.JButton add_button_food;
    private javax.swing.JButton add_button_housing;
    private javax.swing.JButton add_button_recreation;
    private javax.swing.JButton add_button_transportation;
    private javax.swing.JButton add_button_trips;
    private javax.swing.JTextField addname_textfield_entertainment;
    private javax.swing.JTextField addname_textfield_food;
    private javax.swing.JTextField addname_textfield_housing;
    private javax.swing.JTextField addname_textfield_recreation;
    private javax.swing.JTextField addname_textfield_transportation;
    private javax.swing.JTextField addname_textfield_trips;
    private javax.swing.JTextField addprice_textfield_entertainment;
    private javax.swing.JTextField addprice_textfield_food;
    private javax.swing.JTextField addprice_textfield_housing;
    private javax.swing.JTextField addprice_textfield_recreation;
    private javax.swing.JTextField addprice_textfield_transportation;
    private javax.swing.JTextField addprice_textfield_trips;
    private javax.swing.JButton clearall_button;
    private javax.swing.JLabel currentOverallAmt_label;
    private javax.swing.JPanel entertainment_panel;
    private javax.swing.JPanel food_panel;
    private javax.swing.JPanel home_panel;
    private javax.swing.JPanel housing_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel originalamt_label;
    private javax.swing.JTextField overallamt_textfield;
    private javax.swing.JPanel recreation_panel;
    private javax.swing.JPanel summary_panel;
    private javax.swing.JTextArea summary_textarea;
    private javax.swing.JPanel transportation_panel;
    private javax.swing.JPanel trips_panel;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables

}
