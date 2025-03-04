
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField= new JTextField();
    JButton[] numButtons=new JButton[10];
    JButton [] funcButtons=new JButton[9];
    JButton add=new JButton("+");
     JButton sub=new JButton("-");
     JButton mul=new JButton("*");
     JButton div=new JButton("/");
     JButton dec=new JButton(".");
     JButton equ=new JButton("=");
     JButton del=new JButton("DEL");
     JButton clear=new JButton("CLR");
     JButton neg=new JButton("(-)");
    Font myFont=new Font("Arial",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    JPanel panel;
 Calculator(){
     JFrame frame=new JFrame("CALCULATOR");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(700, 675);
     frame.setVisible(true);
     frame.setLayout(null);
     frame.setLocationRelativeTo(null);

     
     textField.setBounds(100,30,500,50);
     textField.setFocusable(true);
     textField.setFont(myFont);
     textField.setEditable(false);
     

 

     funcButtons[0]=add;
     funcButtons[1]=sub;
     funcButtons[2]=mul;
     funcButtons[3]=div;
     funcButtons[4]=dec;
     funcButtons[5]=equ;
     funcButtons[6]=del;
     funcButtons[7]=clear;
     funcButtons[8]=neg;

     for(int i=0;i<9;i++){
        funcButtons[i].addActionListener(this);
        funcButtons[i].setFont(myFont);
        funcButtons[i].setFocusable(false);
       
     }
     for(int j=0;j<10;j++){
        
        numButtons[j]=new JButton(String.valueOf(j));
        numButtons[j].setFont(myFont);
        numButtons[j].setFocusable(false);
        numButtons[j].addActionListener(this);
     }

     

     JPanel panel=new JPanel();
     panel.setBounds(100,100,500,440);
     panel.setBackground(Color.pink);
     panel.setVisible(true);
     panel.setLayout(new GridLayout(4,4,10,10));
     panel.add(numButtons[0]);
     panel.add(numButtons[1]);
     panel.add(numButtons[2]);
     panel.add(numButtons[3]);
     panel.add(add);
     panel.add(numButtons[4]);
     panel.add(numButtons[5]);
     panel.add(numButtons[6]);
     panel.add(numButtons[7]);
     panel.add(sub);
     panel.add(numButtons[8]);
     panel.add(numButtons[9]);
     panel.add(mul);
     panel.add(div);
     panel.add(dec);
     panel.add(neg);
     panel.add(equ);

     clear.setBounds(100,570,100,50);
     del.setBounds(450,570,100,50);
     

     
     
     
     


    
     frame.setResizable(false);
     
     
     frame.add(del);
     frame.add(clear);
     frame.add(panel);
     frame.add(textField);
     frame.setVisible(true);
     
     
    
     
    
 }

 public static void main(String[] args) {
    Calculator calc=new Calculator();
}

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int j=0;j<10;j++){
            if (e.getSource()==numButtons[j]) {
                textField.setText(textField.getText().concat(String.valueOf(j)));
            }
        }
       if (e.getSource()==dec) {
        textField.setText(textField.getText().concat("."));
       }
       if (e.getSource()==add){
         num1=Double.parseDouble(textField.getText());
         textField.setText("");
         operator='+';
       }
       if (e.getSource()==mul){
        num1=Double.parseDouble(textField.getText());
        operator= '*';
        textField.setText("");
       }
       if (e.getSource()==div){
        num1=Double.parseDouble(textField.getText());
        operator= '/';
        textField.setText("");
       }
       if (e.getSource()==sub){
        num1=Double.parseDouble(textField.getText());
        operator= '-';
        textField.setText("");
       }
       if (e.getSource()==neg){
        double negative=Double.parseDouble(textField.getText());
        negative*=-1;
        num1=negative;
    
       }
       if(e.getSource()==equ){
        num2=Double.parseDouble(textField.getText());
        textField.setText("");
        switch (operator) {
            case '+':
                result=num1+num2;
                break;
        
            case '-':
            result=num1-num2;
                break;
                
            case '*':
            result=num1*num2;
                break;
                
            case '/':
            result=num1/num2;
                break;
                
        }
        textField.setText(textField.getText().concat(String.valueOf(result)));
        num1=result;
       }
       if (e.getSource()==clear){
        textField.setText("");
       }
       if (e.getSource()==del){
        String delete=textField.getText();
        textField.setText("");
        for(int i=0;i<delete.length()-1;i++){
            textField.setText(textField.getText()+delete.charAt(i));
        }
       }
    }
 
}

