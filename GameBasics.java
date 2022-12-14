package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GameBasics extends JFrame {
	public static final int HEIGHT = 800; 
	public static final int WIDTH = 650;
	
	public static final JPanel Grid = new JPanel();
	
	GameBasics(){
		setTitle("NumPuz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(100,100,1000,800);
        Container c = getContentPane();
        


        
//-----------      Menu     -------------------------
        //Creating a JPanel for the Menu
        JPanel menu = new JPanel();
        menu.setLayout(null);
        
        //Adding Title of the game to menu
        JLabel label = new JLabel("NUMPUZ");
        label.setForeground(Color.white);;
        label.setBounds(150,0,300,50);
        menu.add(label);
        
        //Adding Mode (Design or Play)
        JRadioButton design = new JRadioButton();
       design.setBounds(135, 30, 120, 50);
       design.setText("Design");
       design.setForeground(Color.white);
       design.setBackground(Color.black);
       menu.add(design);
       JRadioButton play = new JRadioButton();
       play.setBounds(250, 30, 80, 50);
       play.setText("Play");
       play.setForeground(Color.white);
       play.setBackground(Color.black);
        menu.add(play);
        JLabel lbl = new JLabel("Mode");
        lbl.setForeground(Color.white);
        lbl.setBounds(40, 30, 150, 50);
        menu.add(lbl);
        
        //Adding dimension options
        JLabel lbl2 = new JLabel("Dim:");
        lbl2.setForeground(Color.white);
        lbl2.setBounds(40, 85, 150, 50);
        menu.add(lbl2);
        String d[] = {"3", "4", "5"};
        JComboBox dim = new JComboBox(d);
        dim.setBounds(90, 90, 70, 40);
        dim.setForeground(Color.black);
        dim.setBackground(Color.white);
        menu.add(dim);
        dim.addActionListener(dim);
        
        //Adding Show and Hide buttons
        JButton show = new JButton("Show");
        show.setBounds(170, 90, 70, 40);
        show.setForeground(Color.black);
        menu.add(show);
        JButton hide = new JButton("Hide");
        hide.setBounds(250, 90, 70, 40);
        hide.setForeground(Color.black);
        menu.add(hide);
        
        //Adding Save, Load, and Rand buttons
        JButton save = new JButton("Save");
        save.setBounds(90, 140, 70, 40);
        save.setForeground(Color.black);
        menu.add(save);
        JButton load = new JButton("Load");
        load.setBounds(170, 140, 70, 40);
        load.setForeground(Color.black);
        menu.add(load);
        JButton rand = new JButton("Rand");
        rand.setBounds(250, 140, 70, 40);
        rand.setForeground(Color.black);
        menu.add(rand);
        
        //Adding Type options
        JLabel lType = new JLabel("Type:");
        lType.setForeground(Color.white);
        lType.setBounds(40, 185, 150, 50);
        menu.add(lType);
        String t[] = {"Number", "Text"};
        JComboBox type = new JComboBox(t);
        type.setBounds(90, 190, 110, 40);
        type.setForeground(Color.black);
        type.setBackground(Color.white);
        menu.add(type);
        
        //Adding Finish button
        JButton finish = new JButton("Finish");
        finish.setBounds(220, 190, 100, 40);
        finish.setForeground(Color.black);
        menu.add(finish);
        
        //Adding Moves and Points text areas
        JTextArea  move = new JTextArea();
        move.setBounds(90, 240, 80, 40);
        menu.add(move);
        JLabel moves = new JLabel("Moves:");
        moves.setForeground(Color.white);
        moves.setBounds(30,250,60,15);
        menu.add(moves);
        JTextArea point = new JTextArea();
        point.setBounds(240, 240, 80, 40);
        menu.add(point);
        JLabel points = new JLabel("Points:");
        points.setForeground(Color.white);
        points.setBounds(180,250,60,15);
        menu.add(points);
    
        //Adding Console text Area
        JTextArea console = new JTextArea();
        console.setBounds(70, 350, 250, 300);
        menu.add(console);
        
        //Adding time text area
        JTextArea timeV = new JTextArea("0");
        timeV.setBounds(190, 700, 40, 20);
        menu.add(timeV);
        
        //Adding Time label
        JLabel time = new JLabel("Time:");
        time.setForeground(Color.white);
        time.setBounds(140,700,60,15);
        menu.add(time);
        
        //Adding reset button
        JButton reset = new JButton("Reset");
        reset.setBounds(155, 735, 70, 20);
        reset.setForeground(Color.black);
        menu.add(reset);
        
        // changing the background color of the panel to yellow
        menu.setBackground(Color.black);
        menu.setBounds(650,0,350,1000);
//----------------------------------------------------
        
        
       
        dim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) dim.getSelectedItem();
                switch (s) {
                case "3":
                	Grid.removeAll();
                	Grid.revalidate();
                	Grid.repaint();
                	c.add(create_grid(3,3));;
                	break;

               case "4":
               		Grid.removeAll();
            	    Grid.revalidate();
               	    Grid.repaint();
            	    c.add(create_grid(4,4));
                   	break;
                   
               case "5":
               		Grid.removeAll();
               		Grid.revalidate();
               		Grid.repaint();
            	    c.add(create_grid(5,5));
                    break;
                }
            }
        });
    
        
        
       
        
      //adding the panel to the Container of the JFrame
        c.add(menu);
        setVisible(true);

	}
	
	
//-----------      Grid     ----------------------------
	public JPanel create_grid(int h, int w) {
		//JPanel Grid = new JPanel();
        GridLayout grid = new GridLayout(w, h);
        Grid.setLayout(grid);
        Grid.setBounds(0, 0, WIDTH, HEIGHT);
        JButton[] buttons = new JButton[h*w];
        String count;
        for(int i=1;i<(h*w);i++)
        {

        	count = String.valueOf(i);

           buttons[i]=new JButton();
            buttons[i].setText(count);
            buttons[i].setBackground(Color.LIGHT_GRAY);
        }



       for(int i=1;i<(h*w);i++)
        {



           Grid.add(buttons[i]);
        }
       return Grid;
	}
//--------------------------------------------------

	

	 public static void main(String[] args) {
		 new GameBasics();
		 
	    }
	}