package googleplacesapiclient;

import static googleplacesapiclient.Utils.isDouble;
import static googleplacesapiclient.Utils.isInteger;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientJFrame extends javax.swing.JFrame {

    public ClientJFrame() {

        initComponents();
        initTypesHashTable();
        this.pageToken = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        latitudeField = new javax.swing.JTextField();
        longitudeField = new javax.swing.JTextField();
        radiusField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoriesJList = new javax.swing.JList();
        openCheckBox = new javax.swing.JCheckBox();
        retrieveButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        poisJList = new javax.swing.JList();
        photoPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        distanceField = new javax.swing.JLabel();
        ratingField = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        poisCategoryField = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        poiTypesJList = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Points of Interest Explorer");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Latitude:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Longitude:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Radius (m):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Category:");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("Select a category for your POIs");

        categoriesJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Lodgings", "Food-Restaurants", "Cafes", "Night Clubs", "Car Rentals", "Museums", "Churches", "Hospitals", "Pharmacies", "Police Stations", "Post Offices" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        categoriesJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        categoriesJList.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(categoriesJList);

        openCheckBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        openCheckBox.setText("Open Now");

        retrieveButton.setText("Retrieve POIs");
        retrieveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Points of Interest in category:");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        poisJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        poisJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poisJListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(poisJList);

        photoPanel.setMaximumSize(new java.awt.Dimension(400, 200));
        photoPanel.setMinimumSize(new java.awt.Dimension(400, 200));

        photoLabel.setMaximumSize(new java.awt.Dimension(315, 200));
        photoLabel.setPreferredSize(new java.awt.Dimension(315, 200));

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(photoPanelLayout.createSequentialGroup()
                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Distance (m):");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Rating:");

        addressField.setEditable(false);

        poisCategoryField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        poisCategoryField.setForeground(new java.awt.Color(0, 0, 255));

        iconLabel.setMaximumSize(new java.awt.Dimension(35, 35));
        iconLabel.setPreferredSize(new java.awt.Dimension(35, 35));

        poiTypesJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(poiTypesJList);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("POI's Types:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("POI's Main Type:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(openCheckBox)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(latitudeField)
                            .addComponent(longitudeField)
                            .addComponent(radiusField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addComponent(retrieveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(poisCategoryField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(59, 59, 59)
                                            .addComponent(ratingField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel9))
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(distanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                        .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                                .addGap(10, 10, 10)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(poisCategoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(latitudeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(longitudeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(openCheckBox)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(retrieveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(distanceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void retrieveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveButtonActionPerformed
        
        if(CheckForInputErrors()) {
            return;
        }
        clearInfo();
        
        latitude = Double.valueOf(latitudeField.getText());
        longitude = Double.valueOf(longitudeField.getText());
        radius = Integer.valueOf(radiusField.getText());
        opennow = openCheckBox.isSelected();
        category = typesHashTable.get(categoriesJList.getSelectedValue());
        poisCategoryField.setText(categoriesJList.getSelectedValue().toString());
        
        ArrayList<POI> pois = getNearbyPOIs(latitude, longitude, radius, category, opennow);
        
        DefaultListModel<POI> listModel = new DefaultListModel<>();
        for(POI poi: pois){
            listModel.addElement(poi);
        }
        poisJList.setModel(listModel);
    }//GEN-LAST:event_retrieveButtonActionPerformed

    private void clearInfo() {
        
        distanceField.setText("");
        addressField.setText("");
        ratingField.setText("");
        iconLabel.setVisible(false);
        photoLabel.setVisible(false);
        poiTypesJList.setModel(new DefaultListModel<>());
    }
    
    private void poisJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poisJListMouseClicked
        
        POI selected_poi = (POI) poisJList.getModel().getElementAt(poisJList.getSelectedIndex());
        distanceField.setText(selected_poi.getDistance().toString());
        addressField.setText(selected_poi.getAddress());
        
        if(selected_poi.getRating() != null) {
            ratingField.setText(selected_poi.getRating().toString());
        }
        else {
            ratingField.setText("");
        }
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(Object type: selected_poi.getTypes()){
            listModel.addElement((String) type);
        }
        poiTypesJList.setModel(listModel);
        
        setIconLabel(selected_poi.getIcon(), this.iconLabel);
        
        if(selected_poi.getPhotoReference() != null) {
            
            int height = photoLabel.getPreferredSize().height > selected_poi.getPhotoMaxHeight() ? selected_poi.getPhotoMaxHeight() : photoLabel.getPreferredSize().height;
            int width = photoLabel.getPreferredSize().width > selected_poi.getPhotoMaxWidth() ? selected_poi.getPhotoMaxWidth() : photoLabel.getPreferredSize().width;
            ImageIcon imageIcon = HttpGetPhotoResult(BuildPlacePhotoUrl(height, width, selected_poi.getPhotoReference()));
            if (imageIcon != null) {
                photoLabel.setIcon(imageIcon);
                photoLabel.setVisible(true);
            }
            else {
                photoLabel.setVisible(false);
            }
        }
    }//GEN-LAST:event_poisJListMouseClicked

    private void setIconLabel(String icon_url, JLabel jLabel) {
        
        try {
            
            ImageIcon imageIcon = new ImageIcon(new URL(icon_url));
            
            // resize imageIcon
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(jLabel.getPreferredSize().width, jLabel.getPreferredSize().height,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
            
            jLabel.setIcon(imageIcon);
            jLabel.setVisible(true);
        }
        catch (IOException ex) {
            Logger.getLogger(ClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            jLabel.setVisible(false);
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
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientJFrame().setVisible(true);
        });
    }

    public ArrayList<POI> getNearbyPOIs(Double latitude, Double longitude, Integer radius, String type, Boolean open) {
        
        String result;
        ArrayList<POI> poisArrayList = new ArrayList<POI>();
        
        result = HttpGetJsonResult(BuildNearbySearchUrl(latitude, longitude, radius, open, type));
        System.out.println(result);
        poisArrayList.addAll(JsonStringToPoisArrayList(result));
        
        // the code in comments is for fetching the next pages if they do exist, i.e. totally 3 pages or 60 pois (20 pois/page)
        Integer counter = 1;
        while(!this.pageToken.equals("") && counter < 3) {
            // After some trials i found that a delay must happen for the next_token_page to be activated
            // see forum https://stackoverflow.com/questions/21265756/paging-on-google-places-api-returns-status-invalid-request
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException ex) {
                //Logger.getLogger(ClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            result = HttpGetJsonResult(BuildNearbySearchNextPageUrl());
            System.out.println(result);
            poisArrayList.addAll(JsonStringToPoisArrayList(result));
            counter++;
        }
        
        for(POI poi: poisArrayList){
            poi.setDistance(calculateDistance(poi.getLatitude(),poi.getLongitude(),this.latitude,this.longitude));
        }
        return poisArrayList;
    }    
    
    private String HttpGetJsonResult(String url) {
        
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response;
        HttpGet request = new HttpGet(url);
        
        try {
            response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode()+ " " + response.getStatusLine().getReasonPhrase());   // 200 OK
            HttpEntity entity = response.getEntity();  
            result = EntityUtils.toString(entity);
            
            httpClient.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    private ImageIcon HttpGetPhotoResult(String url) {
        
        ImageIcon imageIcon = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse response;
        HttpGet request = new HttpGet(url);
        
        try {
            response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode()+ " " + response.getStatusLine().getReasonPhrase());   // 200 OK
            HttpEntity entity = response.getEntity();
            
            InputStream instream = entity.getContent();
            BufferedImage buffered_image = ImageIO.read(instream);
            imageIcon = new ImageIcon(buffered_image);
            
            instream.close();
            httpClient.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageIcon;
    }
    
    private String BuildPlacePhotoUrl(Integer maxheight, Integer maxwidth, String photoreference) {
        
        String url = "https://maps.googleapis.com/maps/api/place/photo?";
        url += "maxwidth=" + maxwidth.toString() + "&maxheight=" + maxheight + "&photoreference=" + photoreference + "&key=" + this.API_KEY;
        System.out.println("ulr=" + url);
        return url;
    }
    
    private String BuildNearbySearchUrl(Double latitude, Double longitude, Integer radius, Boolean open, String type) {
    
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        url += "location=" + latitude.toString() + "," + longitude.toString();
        url += "&radius=" + radius.toString() + "&opennow=" + open.toString() + "&types=" + type + "&language=en" + "&key=" + this.API_KEY;
        System.out.println("ulr=" + url);
        return url;
    }
    
    private String BuildNearbySearchNextPageUrl() {
        
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
        url += "pagetoken=" + this.pageToken + "&key=" + this.API_KEY;
        System.out.println("ulr=" + url);
        return url;
    }    
    
    private ArrayList<POI> JsonStringToPoisArrayList(String json) {
        
        ArrayList<POI> arrayList = new ArrayList<POI>();
        
        if(json.isEmpty()) {
            return arrayList;
        }
        JSONObject json_obj;
        try {
            json_obj = new JSONObject(json);
        }
        catch(JSONException e) {
            return arrayList;
        }
        
        if(json_obj.has("next_page_token")) {
            this.pageToken = json_obj.getString("next_page_token");
        }
        else {
            this.pageToken = "";
        }
        
        if(!json_obj.getString("status").equals("OK")) {
            return arrayList;
        }
        
        JSONArray results_array = json_obj.getJSONArray("results");
        
        for (int i = 0; i < results_array.length(); i++) {
            
            JSONObject results_array_obj = results_array.getJSONObject(i);
            
            List<Object> types_list = results_array_obj.getJSONArray("types").toList();
            
            // this checks if the selected category is involved in types' list of POI
            // It's not necessary to run this piece of code
            if(!types_list.contains(category)){
                continue;
            }
            
            String place_id = results_array_obj.getString("place_id");
            String name = results_array_obj.getString("name");
            String address = results_array_obj.getString("vicinity");
            Float rating = results_array_obj.has("rating") ? results_array_obj.getFloat("rating") : null;
            
            Double lat = results_array_obj.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
            Double lng = results_array_obj.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
            
            String photo_reference;
            Integer photo_width, photo_height;
            
            if(results_array_obj.has("photos")) {
                photo_reference = results_array_obj.getJSONArray("photos").getJSONObject(0).getString("photo_reference");
                photo_width = results_array_obj.getJSONArray("photos").getJSONObject(0).getInt("width");
                photo_height = results_array_obj.getJSONArray("photos").getJSONObject(0).getInt("height");
            }
            else {
                photo_reference = null;
                photo_width = null;
                photo_height = null;
            }
            
            String icon = results_array_obj.has("icon") ? results_array_obj.getString("icon") : "";
            POI poi = new POI(place_id, name, lat, lng, address, rating, photo_reference, photo_width, photo_height);
            
            poi.setIcon(icon);
            poi.setTypes(types_list);
            arrayList.add(poi);
        }
        
        return arrayList;
    }
    
    // Visit this link http://www.geodatasource.com/developers/java
    private int calculateDistance(Double lat1,Double lon1,Double lat2,Double lon2) {
        
        Double theta = lon1 - lon2;
        Double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344; // in Kilometers
        dist = dist * 1000; // in Meters
        return dist.intValue();
    }
    
    /* This function converts decimal degrees to radians */
    private double deg2rad(double deg) {
        
        return (deg * Math.PI / 180.0);
    }
    
    /* This function converts radians to decimal degrees */
    private double rad2deg(double rad) {
        
        return (rad * 180 / Math.PI);
    }
    
    private void initTypesHashTable() {
        
        typesHashTable = new Hashtable<String, String>();
        // https://developers.google.com/places/supported_types
        typesHashTable.put("Lodgings", "lodging");
        typesHashTable.put("Food-Restaurants", "restaurant"); // food type is not supported in the type filter of a place search.
        typesHashTable.put("Cafes", "cafe");
        typesHashTable.put("Night Clubs", "night_club");
        typesHashTable.put("Car Rentals", "car_rental");
        typesHashTable.put("Museums", "museum");
        typesHashTable.put("Churches", "church");
        typesHashTable.put("Hospitals", "hospital");
        typesHashTable.put("Pharmacies", "pharmacy");
        typesHashTable.put("Police Stations", "police");
        typesHashTable.put("Post Offices", "post_office");
    }
    
    private boolean CheckForInputErrors() {
        
        if(latitudeField.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(rootPane, "Latitude field is empty!", "Error: Latitude", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(!isDouble(latitudeField.getText())) {
            
            JOptionPane.showMessageDialog(rootPane, "Latitude field cannot be converted to Double!", "Error: Latitude", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(longitudeField.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(rootPane, "Longitude field is empty!", "Error: Longitude", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(!isDouble(longitudeField.getText())) {
            
            JOptionPane.showMessageDialog(rootPane, "Longitude field cannot be converted to Double!", "Error: Longitude", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(radiusField.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(rootPane, "Radius field is empty!", "Error: Radius", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(!isInteger(radiusField.getText())) {
            
            JOptionPane.showMessageDialog(rootPane, "Radius field cannot be converted to Integer!", "Error: Radius", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(Integer.parseInt(radiusField.getText()) > 50000) {
            
            JOptionPane.showMessageDialog(rootPane, "Radius cannot be greater than 50000 meters!", "Error: Radius", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if(categoriesJList.getSelectedIndex() == -1) {
            
            JOptionPane.showMessageDialog(rootPane, "Please select a category!", "Error: Category", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        return false;
    }
    
    private final String API_KEY = ""; // put your own api_key here
    private String pageToken;
    private Hashtable<String, String> typesHashTable;
    private Double latitude;
    private Double longitude;
    private Integer radius;
    private boolean opennow;
    private String category;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JList<String> categoriesJList;
    private javax.swing.JLabel distanceField;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField latitudeField;
    private javax.swing.JTextField longitudeField;
    private javax.swing.JCheckBox openCheckBox;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JList<String> poiTypesJList;
    private javax.swing.JLabel poisCategoryField;
    private javax.swing.JList<POI> poisJList;
    private javax.swing.JTextField radiusField;
    private javax.swing.JLabel ratingField;
    private javax.swing.JButton retrieveButton;
    // End of variables declaration//GEN-END:variables
}
