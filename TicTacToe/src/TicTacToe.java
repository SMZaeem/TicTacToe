import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener
{

    Random random = new Random();
    JFrame myframe = new JFrame();
    JPanel button_panel = new JPanel();
    JPanel title_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    JLabel textfield = new JLabel();
   // JPanel endpanel = new JPanel();
    boolean turn;
    TicTacToe()
    {
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(700,700);
        myframe.getContentPane().setBackground(new Color(50,50,50));
        myframe.setLayout(new BorderLayout());
        myframe.setVisible(true);

        textfield.setBackground(new Color(2,2,2));
        textfield.setForeground(new Color(200,200,0));
        textfield.setFont(new Font("Cooper Black",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        textfield.setOpaque(true);
        textfield.setSize(700,20);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,700,70);
        title_panel.add(textfield);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        //button_panel.setVisible(true);
        /*endpanel.setLayout(new BorderLayout());
        endpanel.setBackground(new Color(34,113,44));
        endpanel.setVisible(true);
        endpanel.setBounds(0,0,700,700);*/


        myframe.add(button_panel);
        myframe.add(title_panel,BorderLayout.NORTH);

        for(int i=0;i<9;i++)
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Cooper Black",Font.BOLD,75));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        firstturn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(turn)
                {
                    if (buttons[i].getText().equals(""))
                    {
                        buttons[i].setForeground(new Color(0, 0, 200));
                        buttons[i].setText("X");
                        turn = false;
                        textfield.setText("O's turn");
                        checks();
                    }
                }
                else
                {
                    if (buttons[i].getText().equals(""))
                    {
                        buttons[i].setForeground(new Color(200, 0, 0));
                        buttons[i].setText("O");
                        turn = true;
                        textfield.setText("X's turn");
                        checks();
                    }
                }
            }

        }

    }
    void firstturn()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0)
        {
            turn = true;
            textfield.setText("X's turn");
           // System.out.println(random);
        }
        else{
            turn = false;
            textfield.setText("O's turn");
        }

    }
    public void checks()
    {
        //check X win conditions
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))
        ) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2,4,6);
        }
    }



    public void xWins(int a , int b , int c)
    {
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        textfield.setText("X is the winner");
        //myframe.add(endpanel);
        for(int i = 0; i<9;i++)
        {
            buttons[i].setEnabled(false);
        }


    }
    public void oWins(int a , int b , int c)
    {
        buttons[a].setBackground(Color.CYAN);
        buttons[b].setBackground(Color.CYAN);
        buttons[c].setBackground(Color.CYAN);

        textfield.setText("O is the winner");
        //myframe.add(endpanel);
        for(int i = 0; i<9;i++)
        {
            buttons[i].setEnabled(false);
        }



    }
}
