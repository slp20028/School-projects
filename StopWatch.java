import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class StopWatch extends JFrame implements ActionListener{
   private final LayoutManager layout;

   private JButton btn0;
   private JButton btn1;
   private JLabel lbl0;
   MyTimer t;
   public StopWatch(){
      super("Add your title here");
      layout = new BorderLayout();
      setLayout(layout);
      btn0 = new JButton("Start");
      btn1 = new JButton("Reset");
      lbl0 = new JLabel("00:00:00");
      Font font = new Font("Courier", Font.BOLD,50);
      lbl0.setHorizontalAlignment(SwingConstants.CENTER);
      t=new MyTimer(lbl0);
      t.start();
      lbl0.setFont(font);
      JPanel panel=new JPanel();
      
      add(lbl0,BorderLayout.NORTH);
      panel.add(btn0);
      panel.add(btn1);
      add(panel, BorderLayout.SOUTH);
      btn0.addActionListener(this);
      btn1.addActionListener(this);
   }

   public void actionPerformed(ActionEvent event){
      //event.getActionCommand() returns the lable on the button
      //event.getSource() returns the button object
      //See sample code below
      if(event.getActionCommand().equals("Start")){
         t.updateStatus(1);
         btn0.setText("Pause");
      }else if(event.getActionCommand().equals("Pause")){
         t.updateStatus(2);
         btn0.setText("Resume");
      }else if(event.getActionCommand().equals("Resume")){
         t.updateStatus(3);
         btn0.setText("Pause");
      }else if(event.getActionCommand().equals("Reset")){
         t.updateStatus(0);
         btn0.setText("Start");
      }
   }
   public static void main(String[] args){
      StopWatch stopWatch = new StopWatch();
      stopWatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      stopWatch.setSize(450, 200);
      stopWatch.setVisible(true);
   }

}
