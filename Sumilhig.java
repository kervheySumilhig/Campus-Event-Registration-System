import java.awt.*;
import javax.swing.*;

public class Sumilhig {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Clear Button GUI");
        frame.setSize(400, 400);
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
            "Cybersecurity Seminar"
        };
        JComboBox<String> cmbEvent = new JComboBox<>(events);

        JLabel lblAttendance = new JLabel("Attendance Type:");
        JRadioButton rStudent = new JRadioButton("Student");
        JRadioButton rFaculty = new JRadioButton("Faculty");

        ButtonGroup bgAttendance = new ButtonGroup();
        bgAttendance.add(rStudent);
        bgAttendance.add(rFaculty);

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
        frame.add(rStudent);
        frame.add(rFaculty);

        frame.add(btnClear);

        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtAge.setText("");
            txtCollege.setText("");
            cmbEvent.setSelectedIndex(0);
            bgAttendance.clearSelection();
        });

        frame.setVisible(true);
    }
}
