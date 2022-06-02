import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegForm extends JFrame{

    GridLayout GridLay;
    BorderLayout BorderLay;

    JLabel labelName;
    JTextField inputName;
    JLabel labelSurName;
    JTextField inputSurName;
    JLabel labelGender;
    JRadioButton inputMale;
    JRadioButton inputFemale;
    JLabel labelContact;
    JCheckBox inputSMS;
    JCheckBox inputPhone;
    JLabel labelMemberType;
    JList<String> inputMemberType;
    JLabel labelYear;
    JComboBox<Integer> inputYear;
    JButton SaveButton;
    JButton CancelButton;

    public RegForm() {
        super("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLay = new BorderLayout();
        setLayout(BorderLay);

        south();
        center();
    }

    public void center() {

        JPanel jpCenter = new JPanel();
        add(jpCenter, BorderLayout.CENTER);
        jpCenter.setLayout(null);

        labelName = new JLabel("Name");
        labelName.setBounds(10, 10, 120, 25);

        inputName = new JTextField("");
        inputName.setBounds(140,10,125,25);

        labelSurName = new JLabel("SurName");
        labelSurName.setBounds(10, 45, 120, 25);

        inputSurName = new JTextField("");
        inputSurName.setBounds(140, 45, 125, 25);

        jpCenter.add(labelName);
        jpCenter.add(inputName);
        jpCenter.add(labelSurName);
        jpCenter.add(inputSurName);


        labelGender = new JLabel("Gender");
        labelGender.setBounds(285, 10, 120, 25);

        JPanel jpGender = new JPanel();
        jpGender.setBounds(380,10,240,25);
        jpGender.setLayout(null);

        inputMale = new JRadioButton("Male");
        inputMale.setBounds(0,0,60,25);

        inputFemale = new JRadioButton("Female");
        inputFemale.setBounds(70,0,100,25);

        ButtonGroup RadioButtons = new ButtonGroup();
        RadioButtons.add(inputMale);
        RadioButtons.add(inputFemale);

        jpCenter.add(labelGender);
        jpCenter.add(jpGender);
        jpGender.add(inputMale);
        jpGender.add(inputFemale);


        labelContact = new JLabel("Contact");
        labelContact.setBounds(285, 45, 120, 25);

        JPanel jpContact = new JPanel();
        jpContact.setBounds(380, 45, 240, 25);

        jpContact.setLayout(null);
        inputSMS = new JCheckBox("SMS");
        inputSMS.setBounds(0,0,60,25);
        inputPhone = new JCheckBox("Phone");
        inputPhone.setBounds(70,0,100,25);

        jpCenter.add(labelContact);
        jpCenter.add(jpContact);
        jpContact.add(inputSMS);
        jpContact.add(inputPhone);


        String[] MemberTypes = {
            "Standart",
            "Elite",
            "Super Elite"
        };


        labelMemberType = new JLabel("Membership Type");
        labelMemberType.setBounds(10, 80, 120, 25);

        inputMemberType = new JList<String>(MemberTypes);
        inputMemberType.setBounds(140, 80, 125, 70);

        jpCenter.add(labelMemberType);
        jpCenter.add(inputMemberType);


        labelYear = new JLabel("Year");
        labelYear.setBounds(285, 80, 120, 25);

        Integer[] years = new Integer[101];
        years[0]=1921;
        for (int i = 1; i < years.length; i++) {
            years[i] = years[i-1]+1;
        }

        inputYear = new JComboBox<Integer>(years);
        inputYear.setBounds(380, 80, 120, 25);

        jpCenter.add(labelYear);
        jpCenter.add(inputYear);

    }

    public void south() {

        JPanel jpSouth = new JPanel();
        add(jpSouth, BorderLayout.SOUTH);

        GridLay = new GridLayout();
        jpSouth.setLayout(GridLay);

        SaveButton = new JButton("Save");
        CancelButton = new JButton("Cancel");

        jpSouth.add(SaveButton);
        jpSouth.add(CancelButton);

        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });

        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printMember();
            }
        });
    }

    public void printMember() {

        String member = inputName.getText() + " " + inputSurName.getText() + " ";

        if(inputFemale.isSelected()) {
            member += inputFemale.getText() + " ";
        }
        else{
            //default
            member += inputMale.getText() + " ";
            inputMale.setSelected(true);
        }

        if(inputPhone.isSelected() && inputSMS.isSelected()){
            member += inputPhone.getText() + " " + inputSMS.getText() + " ";
        }
        else if (inputPhone.isSelected()){
            member += inputPhone.getText() + " ";
        }

        else if (inputSMS.isSelected()){
            member += inputSMS.getText() + " ";
        }

        else{
            //default
            member += inputPhone.getText() + " ";
            inputPhone.setSelected(true);
            member += inputSMS.getText() + " ";
            inputSMS.setSelected(true);
        }

        if(inputMemberType.getSelectedValue()!=null){
            member += inputMemberType.getSelectedValue() + " ";
        }else{
            inputMemberType.setSelectedIndex(0);
            member += inputMemberType.getSelectedValue() + " ";
        }

        member += inputYear.getSelectedItem().toString() + " ";

        JOptionPane.showMessageDialog(this, member);

    }

    public void cancel() {

        inputName.setText("");
        inputSurName.setText("");
        inputSMS.setSelected(false);
        inputPhone.setSelected(false);

    }
}
