/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
// import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author KAMUI
 */
public class Connexion  {

    /**
     * Creates new form NewJFrame
     */
    public Connexion() {
        //   initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 /*   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButton1)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            createconnection();
            //System.err.println("vkwjvbw");
        } catch (InterruptedException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
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
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connexion().setVisible(true);
            }
        });  */
        System.out.println("hhhhhhhhhhhh");

    }
    Firestore fr = null;
    public void createconnection() throws InterruptedException, ExecutionException {
        fr =null;
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("C:\\Users\\KAMUI\\IdeaProjects\\projet_gi5_test\\Lpproject\\src\\main\\resources\\searchproject.json");
        } catch (FileNotFoundException ex) {
            System.err.println("mal9ach l fire token");
        }

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<searchprojet>.firebaseio.com/")
                    .build();
        } catch (IOException ex) {

        }
        System.out.println("fin lmochkil");
        FirebaseApp.initializeApp(options);
        fr = FirestoreClient.getFirestore();
      //  Map<String, Object> data = new HashMap<>();  */
        System.out.println("fin lmochkil21111");


    }

//public void insertdata(String nom,String prenom,Map<String ,Object> data){
//
//            try{
//                if(fr != null){
//                    DocumentReference docref =fr.collection(nom).document(prenom);
//                    ApiFuture<WriteResult> result =docref.set(data);
//                    System.out.println(""+result.get().getUpdateTime());
//                    System.out.println("Successful");
//                }
//                else{
//                    System.out.println("our attempt is failed");
//                }
//
//            }catch(InterruptedException | ExecutionException ex){
//
//            }
//    }
public void adduser(User us){

            try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(us.getIdUser()));
                    ApiFuture<WriteResult> result =docref.set(us);
                    System.out.println(""+result.get().getUpdateTime());
                //   DocumentReference docref.collection("activite").document("jamal");
              ///      ApiFuture<WriteResult> res =docref.collection("activite").document("jamal").set(us);


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }

}
   public void updatUser(int id ,String nom,  String password){

            try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(id));
                    ApiFuture<WriteResult> result =docref.update("nom", nom,"password",password);
                    System.out.println(""+result.get().getUpdateTime());
                //   DocumentReference docref.collection("activite").document("jamal");



                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }

}


public void addservice(service n){

    try{
                if(fr != null){

                       DocumentReference docref =fr.collection("data").document("service").collection("serv").document(String.valueOf(n.id));
                    ApiFuture<WriteResult> result =docref.set(n);
                    System.out.println(""+result.get().getUpdateTime());


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }

    //  DocumentReference docref =fr.collection("data").document("service").collection("serv").document("hadk");
      //              ApiFuture<WriteResult> result =docref.set(se);
}


public void addactivite(int id,Activite ac){

   try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(id));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                    ApiFuture<WriteResult> res =docref.collection("activite").document(String.valueOf(ac.getIdActivite())).set(ac);
                    System.out.println(""+res.get().getUpdateTime());
// String.valueOf(ac.getIdActivite())

                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }
}

public void addraport(int id,rapport ra){

   try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(id));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                    ApiFuture<WriteResult> res =docref.collection("rapports").document(String.valueOf(ra.getIdActivite())).set(ra);
                    System.out.println(""+res.get().getUpdateTime());


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }
}



public void addimagesAn(int iduser,int idact,Images im){
     try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(iduser));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                    ApiFuture<WriteResult> res =docref.collection("activite").document(String.valueOf(idact))
                            .collection("images").document(String.valueOf(im.getid())).set(im);
                    System.out.println(""+res.get().getUpdateTime());


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }


}

public void addimagesRa(int iduser,int idact,Images im){
     try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(iduser));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                    ApiFuture<WriteResult> res =docref.collection("rapports").document(String.valueOf(idact))
                            .collection("images").document(String.valueOf(im.getid())).set(im);
                    System.out.println(""+res.get().getUpdateTime());


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }


}

public void updateservice(int id,String n){

    try{
                if(fr != null){

                       DocumentReference docref =fr.collection("data").document("service").collection("serv").document(String.valueOf(id));
                    ApiFuture<WriteResult> result =docref.update("name", n);
                    System.out.println(""+result.get().getUpdateTime());


                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }

    //  DocumentReference docref =fr.collection("data").document("service").collection("serv").document("hadk");
      //              ApiFuture<WriteResult> result =docref.set(se);
}


public void updatactivite(int iduser,int idac,String sujetup,String lieu,String description,Date da,Images img){

   try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(iduser));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                   ApiFuture<WriteResult> res =docref.collection("activite").document(String.valueOf(idac)).update("lieu", lieu,"sujet",sujetup,"nomActivite",description,"Date",da);
                 System.out.println(""+res.get().getUpdateTime());
//

                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }
}

public void updatrapport(int iduser,int idac,String sujetup,String lieu,String description,Date da,String pdf,Images img){

   try{
                if(fr != null){

                    DocumentReference docref =fr.collection("data").document("user").collection("users").document(String.valueOf(iduser));
                   // ApiFuture<WriteResult> result =docref.set(ac);
                //   DocumentReference docref.collection("activite").document("jamal");
                   ApiFuture<WriteResult> res =docref.collection("activite").document(String.valueOf(idac)).update("lieu", lieu,"sujet",sujetup,"nomActivite",description,"Date",da);
                 System.out.println(""+res.get().getUpdateTime());
//

                    System.out.println("Successful");
                }
                else{
                    System.out.println("our attempt is failed");
                }

            }catch(InterruptedException | ExecutionException ex){

            }
}

   public ArrayList<Activite> voirActivite() throws InterruptedException, ExecutionException {
ArrayList<Activite> acts = new ArrayList<>();
ApiFuture<QuerySnapshot> future = fr.collection("data").document("user").collection("users").get();
// future.get() blocks on response
List<QueryDocumentSnapshot> documents = future.get().getDocuments();
for (QueryDocumentSnapshot document : documents) {
  System.out.println(document.getId());
 ApiFuture<QuerySnapshot> fu = (ApiFuture<QuerySnapshot>) fr.collection("data").document("user").collection("users")
         .document(document.getId()).collection("activite").get();
 System.out.println(document.getId());
 List<QueryDocumentSnapshot> docu = fu.get().getDocuments();
         for (QueryDocumentSnapshot d : docu) {
             Activite activite = new Activite(d.getString("sujet"),d.getString("idCategorie"), d.getString("lieu"), d.getString("date"), d.getString("details"),d.getString("image"));
                 System.out.println(d.getId()+"--**--"+ d.getString("sujet"));
                 acts.add(activite);

         }
   }
   return acts;
   }
public void MesActivite(int iduser) throws InterruptedException, ExecutionException {


 ApiFuture<QuerySnapshot> fu = (ApiFuture<QuerySnapshot>) fr.collection("data").document("user").collection("users")
         .document(String.valueOf(iduser)).collection("activite").get();
 List<QueryDocumentSnapshot> docu = fu.get().getDocuments();
         for (QueryDocumentSnapshot d : docu) {
                 System.out.println(d.getId()+"--**--"+ d.getString("sujet"));

         }
}




public void voirRapport() throws InterruptedException, ExecutionException {

ApiFuture<QuerySnapshot> future = fr.collection("data").document("user").collection("users").get();
// future.get() blocks on response
List<QueryDocumentSnapshot> documents = future.get().getDocuments();
for (QueryDocumentSnapshot document : documents) {
  System.out.println(document.getId());
 ApiFuture<QuerySnapshot> fu = (ApiFuture<QuerySnapshot>) fr.collection("data").document("user").collection("users")
         .document(document.getId()).collection("rapports").get();
 System.out.println(document.getId());
 List<QueryDocumentSnapshot> docu = fu.get().getDocuments();
         for (QueryDocumentSnapshot d : docu) {
                 System.out.println(d.getId());

         }
}

}
public void MesRapports(int iduser) throws InterruptedException, ExecutionException {

 ApiFuture<QuerySnapshot> fu = (ApiFuture<QuerySnapshot>) fr.collection("data").document("user").collection("users")
         .document(String.valueOf(iduser)).collection("rapports").get();
 List<QueryDocumentSnapshot> docu = fu.get().getDocuments();
         for (QueryDocumentSnapshot d : docu) {
                 System.out.println(d.getId()+"--**--"+ d.getString("sujet"));

         }
}


public ArrayList<String> selectService() throws InterruptedException, ExecutionException {
    ArrayList<String> list = new ArrayList<>();

 ApiFuture<QuerySnapshot> fu = (ApiFuture<QuerySnapshot>) fr.collection("data").document("service").collection("serv").get();
 List<QueryDocumentSnapshot> docu = fu.get().getDocuments();
         for (QueryDocumentSnapshot d : docu) {
                 System.out.println(d.getId()+"--**--"+ d.getString("name"));
                 list.add(d.getString("name"));
         }
        return null;

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables



    public void insertdata(String nom,String prenom,Map<String ,Object> data) throws InterruptedException, ExecutionException{

        try{
            if(fr != null){
                DocumentReference docref =fr.collection(nom).document(prenom);
                ApiFuture<WriteResult> result =docref.set(data);
                System.out.println(""+result.get().getUpdateTime());
                System.out.println("Successful");
            }
            else{
                System.out.println("our attempt is failed");
            }

        }catch(InterruptedException | ExecutionException ex){

        }
    }
    public byte[] importimage(Stage stage){
        byte[] imageBytes = new byte[0];
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
        File pngImage = fileChooser.showOpenDialog(stage);
        if (pngImage != null) {
            try {
                 imageBytes = Files.readAllBytes(pngImage.toPath());
            } catch (IOException e) {
                System.err.println("File couldn't be read to byte[].");
            }
        }

        System.out.println(imageBytes.length);

        return imageBytes;

    }
}
