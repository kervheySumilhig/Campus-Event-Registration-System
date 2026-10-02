import java.awt.*;
import javax.swing.*;

public class Sumilhig{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campus Event Registration System");
        frame.setSize(400, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

      
        JLabel lblName = new JLabel("Participant Name:");  
        JTextField txtName = new JTextField(30);  

        JLabel lblAge = new JLabel("Age:");  
        JTextField txtAge = new JTextField(30);  

        JLabel lblCollege = new JLabel("College/Department:");  
        JTextField txtCollege = new JTextField(30);  


        JLabel lblEvent = new JLabel("Event Category:");  
        String[] events = {  
            "Select Event", 
            "Programming Competition", 
            "Web Design Challenge", 
            "Cybersecurity Seminar", 
            "AI and Emerging Technologies", 
            "IT Quiz Bowl"  
        };  
        JComboBox<String> cmbEvent = new JComboBox<>(events);  

        JLabel lblAttendance = new JLabel("Attendance Type:");  
        JRadioButton rStudentPart = new JRadioButton("Student Participant");  
        JRadioButton rStudentAud = new JRadioButton("Student Audience");  
        JRadioButton rFaculty = new JRadioButton("Faculty/Staff");   

        ButtonGroup bgAttendance = new ButtonGroup();  
        bgAttendance.add(rStudentPart);  
        bgAttendance.add(rStudentAud);  
        bgAttendance.add(rFaculty);  
   
   
        JLabel lblWorkshops = new JLabel("Workshops to Attend:");  
        JCheckBox cbJava = new JCheckBox("Java Programming");  
        JCheckBox cbWeb = new JCheckBox("Web Development");  
        JCheckBox cbCyber = new JCheckBox("Cybersecurity");  
        JCheckBox cbAI = new JCheckBox("Artificial Intelligence");  
        JCheckBox cbDB = new JCheckBox("Database Management");  

  
        JLabel lblNotes = new JLabel("Special Request or Notes:");  
        JTextArea txtNotes = new JTextArea(5, 30);  
        txtNotes.setLineWrap(true);  
        txtNotes.setWrapStyleWord(true);  

        JButton btnRegister = new JButton("REGISTER");  
        JButton btnClear = new JButton("CLEAR");  
           

        frame.add(lblName);  
        frame.add(txtName);  
        frame.add(lblAge);  
        frame.add(txtAge);  
        frame.add(lblCollege);  
        frame.add(txtCollege);  
        
        frame.add(lblEvent);  
        frame.add(cmbEvent);  
        
        frame.add(lblAttendance);  
        frame.add(rStudentPart);  
        frame.add(rStudentAud);  
        frame.add(rFaculty);  
        
        frame.add(lblWorkshops);  
        frame.add(cbJava);  
        frame.add(cbWeb);  
        frame.add(cbCyber);  
        frame.add(cbAI);  
        frame.add(cbDB);  
        
        frame.add(lblNotes);  
        frame.add(txtNotes); 
         
        frame.add(btnRegister);  
        frame.add(btnClear);  
              
   
        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtAge.setText("");
            txtCollege.setText("");
            cmbEvent.setSelectedIndex(0);
            bgAttendance.clearSelection();
            cbJava.setSelected(false);
            cbWeb.setSelected(false);
            cbCyber.setSelected(false);
            cbAI.setSelected(false);
            cbDB.setSelected(false);
            txtNotes.setText("");
        });

  
        btnRegister.addActionListener(e -> {  
            String name = txtName.getText().trim();  
            String ageText = txtAge.getText().trim();  
            String college = txtCollege.getText().trim();
            String eventCat = cmbEvent.getSelectedItem().toString();  
            
          
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Participant Name cannot be empty.");
                return;
            }

         
            if (ageText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Age cannot be empty.");
                return;
            }
            
            int age = 0;
            try {
                age = Integer.parseInt(ageText);
                if (age <= 0) {
                    JOptionPane.showMessageDialog(frame, "Age must be greater than zero.");
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Age must contain a valid whole number.");
                return;
            }

         
            if (college.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "College/Department cannot be empty.");
                return;
            }

        
            if (eventCat.equals("Select Event")) {
                JOptionPane.showMessageDialog(frame, "Please select an Event Category.");
                return;
            }
              
     
            String attendance = "";  
            if (rStudentPart.isSelected()) {  
               attendance = "Student Participant";  
            } else if (rStudentAud.isSelected()) {  
               attendance = "Student Audience";  
            } else if (rFaculty.isSelected()) {  
               attendance = "Faculty/Staff";  
            } else {
               JOptionPane.showMessageDialog(frame, "Please select an Attendance Type.");
               return;
            }
               
        
            String workshops = "";  
            if (cbJava.isSelected()) workshops += "- Java Programming\n";  
            if (cbWeb.isSelected()) workshops += "- Web Development\n";  
            if (cbCyber.isSelected()) workshops += "- Cybersecurity\n";  
            if (cbAI.isSelected()) workshops += "- Artificial Intelligence\n";  
            if (cbDB.isSelected()) workshops += "- Database Management\n";
            
            if (workshops.isEmpty()) {
                workshops = "- None\n";
            }

          
            String notes = txtNotes.getText().trim();
            if (notes.isEmpty()) {
                notes = "None";
            }

         
            String summaryMessage = "Registration Successful!\n\n" +
                                    "Participant Name: " + name + "\n" +
                                    "Age: " + age + "\n" +
                                    "College/Department: " + college + "\n" +
                                    "Event Category: " + eventCat + "\n" +
                                    "Attendance Type: " + attendance + "\n\n" +
                                    "Workshops:\n" + workshops + "\n" +
                                    "Special Request:\n" + notes;

            JOptionPane.showMessageDialog(frame, summaryMessage);
        });

    
        frame.setVisible(true);
    }
}
