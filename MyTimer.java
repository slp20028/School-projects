import javax.swing.*;
public class MyTimer extends Thread{
   int status=0;
   long m=0, s=0, ms=0;
   JLabel lbl;
   public MyTimer(JLabel l){
      lbl=l;
   }
   public void run(){
      while(true){
         try{
            sleep(10);
         }catch(Exception e){}
         switch(status){
            case 1: startTimer(); break;
            case 2: pause(); break;
            case 3: resumeTimer(); break;
            case 0: resetTimer();
         }
      }
   }
   private void resetTimer(){
      m=s=ms=0;
      status=0;
      lbl.setText("00:00:00");
   }
   private void resumeTimer(){
      startTimer();
   }
   private void pause(){
      
   }
   private void startTimer(){
      ms++;
      if(ms==100){
         s++;
         ms=0;
      }
      if(s==60){
         m++;
         s=0;
      }
      String tmp="";
      if(m<10) tmp = "0"+m;
      else tmp =""+m;
      if(s<10) tmp += ":0"+s;
      else tmp += ":"+s;
      if(ms<10) tmp += ":0"+ms;
      else tmp += ":"+ms;
      lbl.setText(tmp);
   }
   public void updateStatus(int status){
      this.status=status;
   }
}
