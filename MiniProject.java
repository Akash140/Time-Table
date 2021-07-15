
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;


public class MiniProject extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back,ok,show,generate,deletetable,quit,back2;
    JLabel welcome,enterlecture,l1,l2,l3,l4,l5,l6,l7,l15,l16,l17,l18,l19,l20,l21,timelab;
    JTextField enterlec,t1,t2,t3,t4,t5,t6,t7,t15,t16,t17,t18,t19,t20,t21,timefield;
    JPanel main,second,third,fourth;
    Font f,f1;
    JTable jt=new JTable();
    
    static int time,time1=0,time2,time3,time4,time5,time6,time7,time8,time9;
    Cursor handcursor=new Cursor(Cursor.HAND_CURSOR);
    Cursor defaultcursor=new Cursor(Cursor.DEFAULT_CURSOR);
    
    int no=0,n1,n2,n3,n4,n5,n6,n7,id=0,inc=0;
    String sd1,sd2,sd3,sd4,sd5,sd6,sd7,tn1,tn2,tn3,tn4,tn5,tn6,tn7;
    String arr[]=new String[1000];
    String s=null;
    
    static Connection con;
    static Statement st;
    static ResultSet rs;
    static ResultSetMetaData md;
    String lecture="No Lecture";
    String create="CREATE TABLE IF NOT EXISTS timetable(id varchar(10),TIME varchar(60),Monday varchar(40),Tuesday varchar(40),Wednesday varchar(40),Thursday varchar(40),Friday varchar(40))";
    
    ArrayList<String> al=new ArrayList<String>();
    static Iterator<String> it;
     
    void myframe() throws Exception
    {
        
        //First panel
  
        setLayout(null);
        setTitle("Schedule Generator");
        main=new JPanel();
        main.setBounds(0,0,1920,1080);
        main.setLayout(null);
        
        try
        {
           
            st=con.createStatement();
            st.executeUpdate(create);
            for(int i=1;i<9;i++)
            st.executeUpdate("insert into timetable(id) values ('"+i+"')");
            }catch(Exception e){System.out.println(e.getMessage());}
        
        welcome=new JLabel(" Welcome to Schedule Generator ");
        f=new Font("Aerial",Font.BOLD,48);        
        welcome.setFont(f);
        welcome.setBounds(600,100,1000,50);
        main.add(welcome);
       
        
        show=new JButton("Show Table");
        show.setBounds(850,300,200,50);
        show.setToolTipText("Press this Button to show time table");
        show.addActionListener(this);
        show.addMouseListener(new MouseAdapter()
        {
         @Override
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
         @Override
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        });
        
        generate=new JButton("Generate Timetable");
        generate.setBounds(850,430,200,50);
        generate.setToolTipText("Click to Generate new TimeTable but it will delete previously generated TimeTable ");
        generate.addActionListener(this);
        generate.addMouseListener(new MouseAdapter()
        {
         @Override
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
         @Override
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        });
        
        deletetable=new JButton("Delete Table");
        deletetable.setBounds(850,560,200,50);
        deletetable.setToolTipText("Press this Button to Delete time table");
        deletetable.addActionListener(this);
        deletetable.addMouseListener(new MouseAdapter()
        {
         @Override
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
         @Override
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        });
        
       
        main.add(show);
        main.add(generate);
        main.add(deletetable);
        
        setVisible(true);
        add(main);
        
       
        //second panel
       
        setLayout(null);
        second=new JPanel();
        second.setBounds(0,0,1920,1080);
        second.setLayout(null);
        
        back2=new JButton("Back");
        back2.setToolTipText("Main Menu");
        back2.setBounds(20,20,200,50);
        back2.addActionListener(this);
        back2.addMouseListener(new MouseAdapter()
        {
         @Override   
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
        @Override 
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        }); 
        
        //third panel
        
        setLayout(null);
        third=new JPanel();
        third.setBounds(0,0,1920,1080);
        third.setLayout(null);
       
        enterlecture =new JLabel("Enter No. Subjects");
        f=new Font("Aerial",Font.PLAIN,20);
        enterlecture.setFont(f);
        enterlecture.setBounds(200,300,200,50);
        third.add(enterlecture);
        
        enterlec =new JTextField(20);
        enterlec.setBounds(400,300,200,50);
        third.add(enterlec);
        
        timelab=new JLabel("Enter Starting Time ");
        f=new Font("Aerial",Font.PLAIN,20);
        timelab.setFont(f);
        timelab.setBounds(200,500,200,50);
        third.add(timelab);
        
        timefield=new JTextField(20);
        timefield.setBounds(400,500,200,50);
        third.add(timefield);
        
        back=new JButton("Back to Main Menu");
        back.setBounds(20,20,200,50);
        back.setToolTipText("Main Menu");
        back.addActionListener(this);
        back.addMouseListener(new MouseAdapter()
        {
         @Override   
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
        @Override 
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        }); 
        
        ok=new JButton("OK");
        ok.setToolTipText("Go to next page");
        ok.setBounds(400,650,100,50);
        ok.addActionListener(this);
        ok.addMouseListener(new MouseAdapter()
        {
         @Override
         public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
         @Override
        public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        }); 
        
        third.add(back);
        third.add(ok);
        
        third.setVisible(false);
        this.add(third);
        
        //fourth panel
        
        setLayout(null);
        fourth=new JPanel();
        fourth.setBounds(0,0,1920,1080);
        fourth.setLayout(null);
        f1=new Font("Aerial",Font.BOLD,18);        
       
                l1=new JLabel("Subject 1 :");
		l1.setBounds(100, 50, 100, 30);
                l1.setFont(f1);
		
		t1=new JTextField();
		t1.setBounds(220,50,280,30);
		
		l2=new JLabel("Subject 2 :");
		l2.setBounds(100,120,100,30);
                l2.setFont(f1);
		
		t2=new JTextField();
		t2.setBounds(220,120,280,30);
		
		l3=new JLabel("Subject 3 :");
		l3.setBounds(100,200,100,30);
		l3.setFont(f1);
                
		t3=new JTextField();
		t3.setBounds(220,200,280,30);
		
		l4=new JLabel("Subject 4 :");
		l4.setBounds(100,280,100,30);
                l4.setFont(f1);
                
		t4=new JTextField();
		t4.setBounds(220,280,280,30);

		l5=new JLabel("Subject 5 :");
		l5.setBounds(100,360,100,30);
		l5.setFont(f1);
                
		t5=new JTextField();
		t5.setBounds(220,360,280,30);
                
		l6=new JLabel("Subject 6 :");
		l6.setBounds(100,440,100,30);
                l6.setFont(f1);
                
		t6=new JTextField();
		t6.setBounds(220,440,280,30);

		l7=new JLabel("Subject 7 :");
		l7.setBounds(100,520,100,30);
		l7.setFont(f1);
                
		t7=new JTextField();
		t7.setBounds(220,520,280,30);

		l15=new JLabel("Hours Per Week :");
		l15.setBounds(850,50,180,30);
		l15.setFont(f1);
                
		t15=new JTextField();
		t15.setBounds(1050,50,280,30);
		
		l16=new JLabel("Hours Per Week :");
		l16.setBounds(850,120,180,30);
		l16.setFont(f1);
                
		t16=new JTextField();
		t16.setBounds(1050,120,280,30);
		
		l17=new JLabel("Hours Per Week :");
		l17.setBounds(850,200,180,30);
		l17.setFont(f1);
                
		t17=new JTextField();
		t17.setBounds(1050,200,280,30);
		
		l18=new JLabel("Hours Per Week :");
		l18.setBounds(850,280,180,30);
		l18.setFont(f1);
                
		t18=new JTextField();
		t18.setBounds(1050,280,280,30);
		
		l19=new JLabel("Hours Per Week :");
		l19.setBounds(850,360,180,30);
		l19.setFont(f1);
                
		t19=new JTextField();
		t19.setBounds(1050,360,280,30);
		
		l20=new JLabel("Hours Per Week :");
		l20.setBounds(850,440,180,30);
		l20.setFont(f1);
                
		t20=new JTextField();
		t20.setBounds(1050,440,280,30);
		
		l21=new JLabel("Hours Per Week :");
		l21.setBounds(850,520,180,30);
		l21.setFont(f1);
                
		t21=new JTextField();
		t21.setBounds(1050,520,280,30);
		
		
		setLayout(null);
		setVisible(true);
		
                l1.setVisible(false);l2.setVisible(false);l3.setVisible(false);
                l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
                l7.setVisible(false);l15.setVisible(false);
                l16.setVisible(false);l17.setVisible(false);l18.setVisible(false);
                l19.setVisible(false);l20.setVisible(false);l21.setVisible(false);
                        
                t1.setVisible(false);t2.setVisible(false);t3.setVisible(false);
                t4.setVisible(false);t5.setVisible(false);t6.setVisible(false);
                t7.setVisible(false);t15.setVisible(false);
                t16.setVisible(false);t17.setVisible(false);t18.setVisible(false);
                t19.setVisible(false);t20.setVisible(false);t21.setVisible(false);
                      
		fourth.add(l1);fourth.add(t1);fourth.add(l2);
		fourth.add(t2);fourth.add(l3);fourth.add(t3);
                fourth.add(l4);fourth.add(t4);fourth.add(l5);
		fourth.add(t5);fourth.add(l6);fourth.add(t6);
                fourth.add(l7);fourth.add(t7);fourth.add(l15);fourth.add(t15);
                fourth.add(l16);fourth.add(t16);fourth.add(l17);
                fourth.add(t17);fourth.add(l18);fourth.add(t18);
                fourth.add(l19);fourth.add(t19);fourth.add(l20);
                fourth.add(t20);fourth.add(l21);fourth.add(t21);
                
                ok=new JButton("Proceed");
                ok.setToolTipText("Go to next page");
                ok.setBounds(800,600,100,50);
                ok.addActionListener(this);
                ok.addMouseListener(new MouseAdapter()
                {
                @Override   
                public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
                @Override 
                public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
                });
                fourth.add(ok);
        
                back=new JButton("Back to Main Menu");
                back.setToolTipText("Main Menu");
                back.setBounds(500,600,200,50);
                back.addActionListener(this);
                back.addMouseListener(new MouseAdapter()
                {
                @Override   
                public void mouseEntered(MouseEvent me)
                {
                    setCursor(handcursor);
                }
                @Override 
                public void mouseExited(MouseEvent me)
                {
                    setCursor(defaultcursor);
                }
        });
        
        fourth.add(back);
        
                fourth.setVisible(false);
                this.add(fourth);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      if(e.getActionCommand().equalsIgnoreCase("Generate Timetable"))
      {
          try {
               for(int i=0;i<36;i++){
               arr[i]=null;} 
              st.executeUpdate("Delete from timetable");
            for(int x=1;x<9;x++)
            {
            st.executeUpdate("insert into timetable(id) values ('"+x+"')");
            st.executeUpdate("Update timetable set Monday='"+lecture+"' where id="+x+"");
            st.executeUpdate("Update timetable set Tuesday='"+lecture+"' where id="+x+"");
            st.executeUpdate("Update timetable set Wednesday='"+lecture+"' where id="+x+"");
            st.executeUpdate("Update timetable set Thursday='"+lecture+"' where id="+x+"");
            st.executeUpdate("Update timetable set Friday='"+lecture+"' where id="+x+"");
          }
          }  
           catch (SQLException ex)  {}
          third.setVisible(true);
          main.setVisible(false);
          fourth.setVisible(false);
          second.setVisible(false);        
      }
      else if(e.getActionCommand().equalsIgnoreCase("back to main menu"))
      {    
              l1.setVisible(false);l2.setVisible(false);l3.setVisible(false);
              l4.setVisible(false);l5.setVisible(false);l6.setVisible(false);
              l7.setVisible(false);l15.setVisible(false);
              l16.setVisible(false);l17.setVisible(false);l18.setVisible(false);
              l19.setVisible(false);l20.setVisible(false);l21.setVisible(false);
              
              t1.setVisible(false);t2.setVisible(false);t3.setVisible(false);
              t4.setVisible(false);t5.setVisible(false);t6.setVisible(false);
              t7.setVisible(false);t15.setVisible(false);
              t16.setVisible(false);t17.setVisible(false);t18.setVisible(false);
              t19.setVisible(false);t20.setVisible(false);t21.setVisible(false);
              
              enterlec.setText(null);
              main.setVisible(true);
              third.setVisible(false);
              fourth.setVisible(false);    
              second.setVisible(false);
              
             al.removeAll(al);
      }
      else if(e.getActionCommand().equalsIgnoreCase("ok"))
      {
          s=null;
          s=timefield.getText();
          time=Integer.parseInt(s);
        
        if(time==12)
        time=1;
        else
        time1=time;
        
        time1++;
        s=s.concat(":00 - ");
        String s1=Integer.toString(time1);
        s=s.concat(s1);
        s=s.concat(":00 ");
        
        time1=Integer.valueOf(s1);
        if(time1==12)
        time1=1;
        else            
        time2=time1;
        time2++;
        String s2=s1;
        s2=s2.concat(":00 - ");
        String s3=Integer.toString(time2);
        s2=s2.concat(s3);
        s2=s2.concat(":00 ");
        
        time2=Integer.valueOf(s3);
        if(time2==12)
        time2=1;
        else            
        time3=time2;
        time3++;
        String s4=s3;
        s4=s4.concat(":00 - ");
        String s5=Integer.toString(time3);
        s4=s4.concat(s5);
        s4=s4.concat(":00 ");
        
        time3=Integer.valueOf(s5);
        if(time3==12)
        time3=1;
        else            
        time4=time3;
        time4++;
        String s6=s5;
        s6=s6.concat(":00 - ");
        String s7=Integer.toString(time4);
        s6=s6.concat(s7);
        s6=s6.concat(":00 ");
        
        time4=Integer.valueOf(s7);
        if(time4==12)
        time4=1;
        else            
        time5=time4;
        time5++;
        String s8=s7;
        s8=s8.concat(":00 - ");
        String s9=Integer.toString(time5);
        s8=s8.concat(s9);
        s8=s8.concat(":00 ");
        
        time5=Integer.valueOf(s9);
        if(time5==12)
        time5=1;
        else            
        time6=time5;
        time6++;
        String s10=s9;
        s10=s10.concat(":00 - ");
        String s11=Integer.toString(time6);
        s10=s10.concat(s11);
        s10=s10.concat(":00 ");
        
        time6=Integer.valueOf(s11);
        if(time6==12)
        time6=1;
        else            
        time7=time6;
        time7++;
        String s12=s11;
        s12=s12.concat(":00 - ");
        String s13=Integer.toString(time7);
        s12=s12.concat(s13);
        s12=s12.concat(":00 ");
        
        time7=Integer.valueOf(s13);
        if(time7==12)
        time7=1;
        else
        time8=time7;
        time8++;
        String s14=s13;
        s14=s14.concat(":00 - ");
        String s15=Integer.toString(time8);
        s14=s14.concat(s15);
        s14=s14.concat(":00 ");
        
            String ti1="update timetable set TIME='"+s+"' where id=1";
          try {
              st.executeUpdate(ti1);
          
            String ti2="update timetable set TIME='"+s2+"' where id=2";
            st.executeUpdate(ti2);
            String ti3="update timetable set TIME='"+s4+"' where id=3";
            st.executeUpdate(ti3);
            String ti4="update timetable set TIME='"+s6+"' where id=4";
            st.executeUpdate(ti4);
            String ti5="update timetable set TIME='"+s8+"' where id=5";
            st.executeUpdate(ti5);
            String ti6="update timetable set TIME='"+s10+"' where id=6";
            st.executeUpdate(ti6);
            String ti7="update timetable set TIME='"+s12+"' where id=7";
            st.executeUpdate(ti7);
            String ti8="update timetable set TIME='"+s14+"' where id=8";
            st.executeUpdate(ti8);
            } catch (SQLException ex) {}
            time=0;time1=0;time2=0;time3=0;time4=0;time5=0;time6=0;time7=0;
          
          no=0;
          no=Integer.parseInt(enterlec.getText());
          switch(no)
          {
              case 1 :{
                        l1.setVisible(true);
                        t1.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        
                        break;
                       }
              case 2 :
                       {
                       l1.setVisible(true);t1.setVisible(true);
                       l2.setVisible(true);t2.setVisible(true);
                       l15.setVisible(true);t15.setVisible(true);
                       l16.setVisible(true);t16.setVisible(true);
                       }
                        break;
              case 3 :
                       {
                        l1.setVisible(true);t1.setVisible(true);
                        l2.setVisible(true);t2.setVisible(true);
                        l3.setVisible(true);t3.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        l16.setVisible(true);t16.setVisible(true);
                        l17.setVisible(true);t17.setVisible(true);
                        
                       }
                        break;
              case 4 :
                        {
                        l1.setVisible(true);t1.setVisible(true);
                        l2.setVisible(true);t2.setVisible(true);
                        l3.setVisible(true);t3.setVisible(true);
                        l4.setVisible(true);t4.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        l16.setVisible(true);t16.setVisible(true);
                        l17.setVisible(true);t17.setVisible(true);
                        l18.setVisible(true);t18.setVisible(true);
                        }
                        break;
              case 5 :
                        {
                        l1.setVisible(true);t1.setVisible(true);
                        l2.setVisible(true);t2.setVisible(true);
                        l3.setVisible(true);t3.setVisible(true);
                        l4.setVisible(true);t4.setVisible(true);
                        l5.setVisible(true);t5.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        l16.setVisible(true);t16.setVisible(true);
                        l17.setVisible(true);t17.setVisible(true);
                        l18.setVisible(true);t18.setVisible(true);
                        l19.setVisible(true);t19.setVisible(true);
                        }
                        break;
              case 6 :
                        {
                        l1.setVisible(true);t1.setVisible(true);
                        l2.setVisible(true);t2.setVisible(true);
                        l3.setVisible(true);t3.setVisible(true);
                        l4.setVisible(true);t4.setVisible(true);
                        l5.setVisible(true);t5.setVisible(true);
                        l6.setVisible(true);t6.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        l16.setVisible(true);t16.setVisible(true);
                        l17.setVisible(true);t17.setVisible(true);
                        l18.setVisible(true);t18.setVisible(true);
                        l19.setVisible(true);t19.setVisible(true);
                        l20.setVisible(true);t20.setVisible(true);
                        }
                        break;
              case 7 :
                        {
                        l1.setVisible(true);t1.setVisible(true);
                        l2.setVisible(true);t2.setVisible(true);
                        l3.setVisible(true);t3.setVisible(true);
                        l4.setVisible(true);t4.setVisible(true);
                        l5.setVisible(true);t5.setVisible(true);
                        l6.setVisible(true);t6.setVisible(true);
                        l7.setVisible(true);t7.setVisible(true);
                        l15.setVisible(true);t15.setVisible(true);
                        l16.setVisible(true);t16.setVisible(true);
                        l17.setVisible(true);t17.setVisible(true);
                        l18.setVisible(true);t18.setVisible(true);
                        l19.setVisible(true);t19.setVisible(true);
                        l20.setVisible(true);t20.setVisible(true);
                        l21.setVisible(true);t21.setVisible(true);
                        }
                        break;          
          }
          enterlec.setText("");
          timefield.setText("");
          main.setVisible(false);
          third.setVisible(false);
          fourth.setVisible(true);
          second.setVisible(false);
      }
      
      else if(e.getActionCommand().equalsIgnoreCase("Show Table"))
      {
          new table();
          table.main(null);
          main.setVisible(false);
          third.setVisible(false);
          fourth.setVisible(false);
      }
     
      else if(e.getActionCommand().equalsIgnoreCase("back"))
      {
          
          main.setVisible(true);
          third.setVisible(false);
          fourth.setVisible(false);
          
          al.removeAll(al);
      }
      else if(e.getActionCommand().equalsIgnoreCase("Proceed"))
      {
         
          switch(no)
          {
              case 1 :
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {al.add(sd1);}
              
                for(int i=n1;i<35;i++)
                al.add(lecture);
               
                    
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next().toString();
                inc++;
                } 
                
                
                break;
                 
              case 2 :
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {
                al.add(sd1);    
                }
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {
                    al.add(sd2);    
                }
                for(int i=n1+n2;i<35;i++)
                al.add(lecture);
               
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]= it.next().toString();
                inc++;
                }
                
                break;  
                
              case 3 :
                
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {
                al.add(sd1);
                }
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {al.add(sd2);}
                
                
                n3=Integer.parseInt(t17.getText());
                sd3=t3.getText();
                for(int i=0;i<n3;i++)
                {al.add(sd3);}
                
                 for(int i=n1+n2+n3;i<35;i++)
                al.add(lecture);
                
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next();
                inc++;
                }
                
                break;
                
            case 4 :
                
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {al.add(sd1);}
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {al.add(sd2);}
                
                
                n3=Integer.parseInt(t17.getText());
                sd3=t3.getText();
                for(int i=0;i<n3;i++)
                {al.add(sd3);}
                
                
                n4=Integer.parseInt(t18.getText());
                sd4=t4.getText();
                for(int i=0;i<n4;i++)
                {al.add(sd4);}
                
                for(int i=n1+n2+n3+n4;i<35;i++)
                al.add(lecture);
                
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next();
                inc++;
                }
                
                break;
                
            case 5 :
                
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {al.add(sd1);}
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {al.add(sd2);}
                
                
                n3=Integer.parseInt(t17.getText());
                sd3=t3.getText();
                for(int i=0;i<n3;i++)
                {al.add(sd3);}
                
                
                n4=Integer.parseInt(t18.getText());
                sd4=t4.getText();
                for(int i=0;i<n4;i++)
                {al.add(sd4);}
                
                
                n5=Integer.parseInt(t19.getText());
                sd5=t5.getText();
                for(int i=0;i<n5;i++)
                {al.add(sd5);}
                
                for(int i=n1+n2+n3+n4+n5;i<35;i++)
                al.add(lecture);
                
                
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next();
                inc++;
                }
                
                break;
                
            case 6 :
                
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {al.add(sd1);}
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {al.add(sd2);}
                
                
                n3=Integer.parseInt(t17.getText());
                sd3=t3.getText();
                for(int i=0;i<n3;i++)
                { al.add(sd3);}
                
                
                n4=Integer.parseInt(t18.getText());
                sd4=t4.getText();
                for(int i=0;i<n4;i++)
                {al.add(sd4);}
                
                
                n5=Integer.parseInt(t19.getText());
                sd5=t5.getText();
                for(int i=0;i<n5;i++)
                {al.add(sd5);}
                
                
                n6=Integer.parseInt(t20.getText());
                sd6=t6.getText();
                for(int i=0;i<n6;i++)
                {al.add(sd6);}
                
                for(int i=n1+n2+n3+n4+n5+n6;i<35;i++)
                al.add(lecture);
                
                
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next();
                inc++;
                }
                
                break;
                
            case 7 :
                
                n1=Integer.parseInt(t15.getText());
                sd1=t1.getText();
                for(int i=0;i<n1;i++)
                {al.add(sd1);}
                
                
                n2=Integer.parseInt(t16.getText());
                sd2=t2.getText();
                for(int i=0;i<n2;i++)
                {al.add(sd2);}
                
                
                n3=Integer.parseInt(t17.getText());
                sd3=t3.getText();
                for(int i=0;i<n3;i++)
                {al.add(sd3);}
                
                
                n4=Integer.parseInt(t18.getText());
                sd4=t4.getText();
                for(int i=0;i<n4;i++)
                {al.add(sd4);}
                
                
                n5=Integer.parseInt(t19.getText());
                sd5=t5.getText();
                for(int i=0;i<n5;i++)
                {al.add(sd5);}
                
                
                n6=Integer.parseInt(t20.getText());
                sd6=t6.getText();
                for(int i=0;i<n6;i++)
                {al.add(sd6);}
                
                
                n7=Integer.parseInt(t21.getText());
                sd7=t7.getText();
                for(int i=0;i<n7;i++)
                {al.add(sd7);}
                
                for(int i=n1+n2+n3+n4+n5+n6+n7;i<35;i++)
                al.add(lecture);
                
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                Collections.shuffle(al);
                
                it=al.iterator();
                while(it.hasNext())
                {
                arr[inc]=it.next();
                inc++;
                }
                
                break;
                
          }
          
        if(n1+n2+n3+n4+n5+n6+n7>35)
        {
          t1.setText(null);t2.setText(null);t3.setText(null);
          t4.setText(null);t5.setText(null);t6.setText(null);
          t7.setText(null);t15.setText(null);t16.setText(null);
          t17.setText(null);t18.setText(null);t19.setText(null);
          t20.setText(null);t21.setText(null);
          
          al.removeAll(al);
          
          JOptionPane.showMessageDialog(this,"Allocated hours is 35 only");
          main.setVisible(false);
          third.setVisible(false);
          fourth.setVisible(true);
          
        }
        else
        {
      try
      {   
            String br="Break";
            
            String str="update timetable set Monday='"+arr[0]+"' where id=1" ;
            st.executeUpdate(str);
          
          
             String str1="update timetable set Tuesday='"+arr[1]+"' where id=1";;
             st.executeUpdate(str1);
         
          
              String str2="update timetable set Wednesday='"+arr[2]+"' where id=1";
              st.executeUpdate(str2);
            
         
              String str3="update timetable set Thursday='"+arr[3]+"' where id=1";
              st.executeUpdate(str3);
          
          
              String str4="update timetable set Friday='"+arr[4]+"' where id=1";
              st.executeUpdate(str4);
              
              String str5="update timetable set Monday='"+arr[5]+"' where id=2";
              st.executeUpdate(str5);
              
              String str6="update timetable set Tuesday='"+arr[6]+"' where id=2";
             st.executeUpdate(str6);
         
          
              String str7="update timetable set Wednesday='"+arr[7]+"' where id=2";
              st.executeUpdate(str7);
            
         
              String str8="update timetable set Thursday='"+arr[8]+"' where id=2";
              st.executeUpdate(str8);
          
          
              String str9="update timetable set Friday='"+arr[9]+"' where id=2";
             st.executeUpdate(str9);
          
             String str10="update timetable set Monday='"+br+"' where id=3";
            st.executeUpdate(str10);
          
          
             String str11="update timetable set Tuesday='"+br+"' where id=3";
             st.executeUpdate(str11);
         
          
              String str12="update timetable set Wednesday='"+br+"' where id=3";
              st.executeUpdate(str12);
            
         
              String str13="update timetable set Thursday='"+br+"' where id=3";
              st.executeUpdate(str13);
          
              String str14="update timetable set Friday='"+br+"' where id=3";
              st.executeUpdate(str14);
              
              String str15="update timetable set Monday='"+arr[10]+"' where id=4";
              st.executeUpdate(str15);
            
                String str16="update timetable set Tuesday='"+arr[11]+"' where id=4";
             st.executeUpdate(str16);
         
          
              String str17="update timetable set Wednesday='"+arr[12]+"' where id=4";
              st.executeUpdate(str17);
            
         
              String str18="update timetable set Thursday='"+arr[13]+"' where id=4";
              st.executeUpdate(str18);
          
          
              String str19="update timetable set Friday='"+arr[14]+"' where id=4";
             st.executeUpdate(str19);
          
             String str20="update timetable set Monday='"+arr[15]+"' where id=5";
            st.executeUpdate(str20);
          
          
             String str21="update timetable set Tuesday='"+arr[16]+"' where id=5";
             st.executeUpdate(str21);
         
          
              String str22="update timetable set Wednesday='"+arr[17]+"' where id=5";
              st.executeUpdate(str22);
            
         
              String str23="update timetable set Thursday='"+arr[18]+"' where id=5";
              st.executeUpdate(str23);
          
          
              String str24="update timetable set Friday='"+arr[19]+"' where id=5";
              st.executeUpdate(str24);
            
               String str25="update timetable set Monday='"+arr[20]+"' where id=6";
              st.executeUpdate(str25);
              
              String str26="update timetable set Tuesday='"+arr[21]+"' where id=6";
             st.executeUpdate(str26);
         
          
              String str27="update timetable set Wednesday='"+arr[22]+"' where id=6";
              st.executeUpdate(str27);
            
         
              String str28="update timetable set Thursday='"+arr[23]+"' where id=6";
              st.executeUpdate(str28);
          
          
              String str29="update timetable set Friday='"+arr[24]+"' where id=6";
             st.executeUpdate(str29);
          
             String str30="update timetable set Monday='"+arr[25]+"' where id=7";
            st.executeUpdate(str30);
          
          
             String str31="update timetable set Tuesday='"+arr[26]+"' where id=7";
             st.executeUpdate(str31);
         
          
              String str32="update timetable set Wednesday='"+arr[27]+"' where id=7";
              st.executeUpdate(str32);
            
         
              String str33="update timetable set Thursday='"+arr[28]+"' where id=7";
              st.executeUpdate(str33);
          
          
              String str34="update timetable set Friday='"+arr[29]+"' where id=7";
              st.executeUpdate(str34);
              
              String str35="update timetable set Monday='"+arr[30]+"' where id=8";
              st.executeUpdate(str35);
            
                String str36="update timetable set Tuesday='"+arr[31]+"' where id=8";
             st.executeUpdate(str36);
         
          
              String str37="update timetable set Wednesday='"+arr[32]+"' where id=8";
              st.executeUpdate(str37);
            
         
              String str38="update timetable set Thursday='"+arr[33]+"' where id=8";
              st.executeUpdate(str38);
          
          
              String str39="update timetable set Friday='"+arr[34]+"' where id=8";
             st.executeUpdate(str39);
          
          al.removeAll(al);
               
      }    catch(Exception ex){}
      
          new table();
          table.main(null);
          main.setVisible(false);
          third.setVisible(false);
          fourth.setVisible(false);
              
        } 
          
          t1.setText(null);t2.setText(null);t3.setText(null);
          t4.setText(null);t5.setText(null);t6.setText(null);
          t7.setText(null);t15.setText(null);t16.setText(null);
          t17.setText(null);t18.setText(null);t19.setText(null);
          t20.setText(null);t21.setText(null);
          
          
      }
      else if(e.getActionCommand().equalsIgnoreCase("Delete Table"))
      {
          String del="Delete from timetable";
          try {
              al.removeAll(al);
              st.executeUpdate(del);
              JOptionPane.showMessageDialog(this,"Deleted Successfully");    
              } catch (SQLException ex) {}
          
          main.setVisible(true);
          third.setVisible(false);
          fourth.setVisible(false);
          second.setVisible(false); 
      }
    }
      
    public static void main(String[] args)throws Exception
    {        
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        con=DriverManager.getConnection("Jdbc:sqlite:C:\\Users\\HP\\Desktop\\db\\TimeTable.db");
        st=con.createStatement();
        MiniProject miniProject=new MiniProject();
        miniProject.setSize(screensize);
        miniProject.myframe();
    }
}

