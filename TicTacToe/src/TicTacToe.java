/*
 * 
 * 
 * ARTIFICIAL INTELLIGENT --- X --- CODED BY AJITH KP
 * 
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TicTacToe extends JFrame {
    JPanel l = new JPanel(new GridLayout(1, 1, 0, 0));
    JPanel b = new JPanel(new GridLayout(3, 3, 5, 5));
    JLabel lbl = new JLabel("Coded By Ajith Kp");
    JTextField flds[] = new JTextField[9];
    boolean pl = false;
    TextHandle hld = new TextHandle();
    TicTacToe()
    {
        super("TicTacToe --- AJITH KP");
        setLayout(new BorderLayout());
        Random r = new Random();
        int n = r.nextInt(10);
        if(n%2==0)
        {
            pl = true;
        }
        else
        {
            pl = false;
        }
        for(int i=0;i<9;i++)
        {
            flds[i] = new JTextField();
            flds[i].addMouseListener(hld);
            flds[i].setForeground(Color.BLACK);
            flds[i].setHorizontalAlignment(JLabel.CENTER);
            flds[i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.red));
            flds[i].setBackground(Color.CYAN);
            flds[i].setFont(new Font("Times New Roma", Font.BOLD, 25));
            flds[i].setEditable(false);
            b.add(flds[i]);
        }
        lbl.setForeground(Color.BLUE);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.green));
        lbl.setHorizontalAlignment(JLabel.CENTER);
        l.add(lbl);
        add(l, BorderLayout.NORTH);
        add(b, BorderLayout.CENTER);
        if(pl==true)
        {
            comp();
        }
    }
    public class TextHandle extends MouseAdapter 
    {
        @Override
        public void mouseClicked(MouseEvent e) {    
            if(pl==false)
            {
                JTextField fld = (JTextField) e.getSource();
                if(fld.getText().equals(""))
                {
                    fld.setForeground(Color.red);
                    fld.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
                    fld.setText("X");
                    char c = finish();
                    if(c=='U')
                    {
                        lbl.setText("You have won");
                        disable();
                        return;
                    }
                    else if(c=='O')
                    {
                        lbl.setText("Game Over. No one won");
                        disable();
                        return;
                    }
                    pl = true;
                    comp();
                }
            }
            return;
        }
    }
    public void disable()
    {
        for(int i=0;i<9;i++)flds[i].addMouseListener(null);
    }
    public void comp()
    {
        if(pl==true)
        {
            int n = bestClic();
            flds[n].setForeground(Color.blue);
            flds[n].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE));
            flds[n].setText("O");
            char c = finish();
            if(c=='C')
            {
                lbl.setText("Computer has won");
                disable();
                return;
            }
            else if(c=='O')
            {
                lbl.setText("Game Over. No one won");
                disable();
                return;
            }
            pl = false;
        }
        return;
    }
    public int bestClic()
    {
        int num = 0;
        if(flds[4].getText().equals(""))
        {
            num = 4;
        }
        else
        {
            num = free();
        }
        return num;
    }
    public int free()
    {
        int n = 0;
        int c1, c2, c3, r1, r2, r3, x1, x2;
        c1 = c2 = c3 = r1 = r2 = r3 = x1 = x2 = 0;
        for(int i=0;i<9;i++)
        {
            if(i%3==0)
            {
                if(flds[i].getText().equals("O"))
                {
                    c1++;
                }
            }
            if(i%3==1)
            {
                if(flds[i].getText().equals("O"))
                {
                    c2++;
                }
            }
            if(i%3==2)
            {
                if(flds[i].getText().equals("O"))
                {
                    c3++;
                }
            }
            if(i<3)
            {
                if(flds[i].getText().equals("O"))
                {
                    r1++;
                }
            }
            else if(i<6)
            {
                if(flds[i].getText().equals("O"))
                {
                    r2++;
                }
            }
            else if(i<9)
            {
                if(flds[i].getText().equals("O"))
                {
                    r3++;
                }
            }
            if(i==0||i==4||i==8)
            {
                if(flds[i].getText().equals("O"))
                {
                    x1++;
                }
            }
            if(i==2||i==4||i==6)
            {
                if(flds[i].getText().equals("O"))
                {
                    x2++;
                }
            }
        }
        if(c1==2 && freeCell("c1")>0)
        {
            return freeCell("c1");
        }
        else if(c2==2 && freeCell("c2")>0)
        {
            return freeCell("c2");
        }
        else if(c3==2 && freeCell("c3")>0)
        {
            return freeCell("c3");
        }
        else if(r1==2 && freeCell("r1")>0)
        {
            return freeCell("r1");
        }
        else if(r2==2 && freeCell("r2")>0)
        {
            return freeCell("r2");
        }
        else if(r3==2 && freeCell("r3")>0)
        {
            return freeCell("r3");
        }
        else if(x1==2 && freeCell("x1")>0)
        {
            return freeCell("x1");
        }
        else if(x2==2 && freeCell("x2")>0)
        {
            return freeCell("x2");
        }
        else
        {              
            c1 = c2 = c3 = r1 = r2 = r3 = x1 = x2 = 0;
            for(int i=0;i<9;i++)
            {
                if(i%3==0)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        c1++;
                    }
                }
                if(i%3==1)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        c2++;
                    }
                }
                if(i%3==2)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        c3++;
                    }
                }
                if(i<3)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        r1++;
                    }
                }
                else if(i<6)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        r2++;
                    }
                }
                else if(i<9)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        r3++;
                    }
                }
                if(i==0||i==4||i==8)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        x1++;
                    }
                }
                if(i==2||i==4||i==6)
                {
                    if(flds[i].getText().equals("X"))
                    {
                        x2++;
                    }
                }
            }
            if(c1==2  && freeCell("c1")>0)
            {
                return freeCell("c1");
            }
            else if(c2==2 && freeCell("c2")>0)
            {
                return freeCell("c2");
            }
            else if(c3==2 && freeCell("c3")>0)
            {
                return freeCell("c3");
            }
            else if(r1==2 && freeCell("r1")>0)
            {
                return freeCell("r1");
            }
            else if(r2==2 && freeCell("r2")>0)
            {
                return freeCell("r2");
            }
            else if(r3==2 && freeCell("r3")>0)
            {
                return freeCell("r3");
            }
            else if(x1==2 && freeCell("x1")>0)
            {
                return freeCell("x1");
            }
            else if(x2==2 && freeCell("x2")>0)
            {
                return freeCell("x2");
            }
            else
            {
                return findBest();
            }
        }        
        //return n;
    }
    public int findBest()
    {
        int num = 0;
        if(flds[0].getText().equals(""))
        {
            return 0;
        }
        if(flds[2].getText().equals(""))
        {
            return 2;
        }
        if(flds[6].getText().equals(""))
        {
            return 6;
        }
        if((flds[8]).getText().equals(""))
        {
            return 8;
        }
        for(int i=0;i<9;i++)
        {
            if(flds[i].getText().equals(""))
            {
                return i;
            }
        }
        return num;
    }
    public int freeCell(String s)
    {
        int num = 0;
        if(s.equals("c1"))
        {
            for(int i=0;i<9;i++)
            {
                if(i%3==0)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("c2"))
        {
            for(int i=0;i<9;i++)
            {
                if(i%3==1)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("c3"))
        {
            for(int i=0;i<9;i++)
            {
                if(i%3==2)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("r1"))
        {
            for(int i=0;i<9;i++)
            {
                if(i<3)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("r2"))
        {
            for(int i=0;i<9;i++)
            {
                if(i<6 && i>2)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("r3"))
        {
            for(int i=0;i<9;i++)
            {
                if(i<9 && i>5)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("x1"))
        {
            for(int i=0;i<9;i++)
            {
                if(i==0||i==4||i==8)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        else if(s.equals("x2"))
        {
            for(int i=0;i<9;i++)
            {
                if(i==2||i==4||i==6)
                {
                    if(flds[i].getText().equals(""))
                    {
                        return i;
                    }
                }
            }
        }
        return num;
    }
    public char finish()
    {
        //int num = 0;
        char win = 'N';
        int c1, c2, c3, r1, r2, r3, x1, x2;
        c1 = c2 = c3 = r1 = r2 = r3 = x1 = x2 = 0;
        for(int i=0;i<9;i++)
        {
            if(i%3==0)
            {
                if(flds[i].getText().equals("X"))
                {
                    c1++;
                }
            }
            if(i%3==1)
            {
                if(flds[i].getText().equals("X"))
                {
                    c2++;
                }
            }
            if(i%3==2)
            {
                if(flds[i].getText().equals("X"))
                {
                    c3++;
                }
            }
            if(i<3)
            {
                if(flds[i].getText().equals("X"))
                {
                    r1++;
                }
            }
            else if(i<6)
            {
                if(flds[i].getText().equals("X"))
                {
                    r2++;
                }
            }
            else if(i<9)
            {
                if(flds[i].getText().equals("X"))
                {
                    r3++;
                }
            }
            if(i==0 || i==4 || i==8)
            {
                if(flds[i].getText().equals("X"))
                {
                    x1++;
                }
            }
            if(i==2 || i==4 || i==6)
            {
                if(flds[i].getText().equals("X"))
                {
                    x2++;
                }
            }
        }
        if(c1 == 3|| c2 == 3|| c3 == 3 || r1 == 3 || r2 == 3 || r3 == 3 || x1 == 3 || x2 == 3)
        {
            return 'U';
        }
        c1 = c2 = c3 = r1 = r2 = r3 = x1 = x2 = 0;
        for(int i=0;i<9;i++)
        {
            if(i%3==0)
            {
                if(flds[i].getText().equals("O"))
                {
                    c1++;
                }
            }
            if(i%3==1)
            {
                if(flds[i].getText().equals("O"))
                {
                    c2++;
                }
            }
            if(i%3==2)
            {
                if(flds[i].getText().equals("O"))
                {
                    c3++;
                }
            }
            if(i<3)
            {
                if(flds[i].getText().equals("O"))
                {
                    r1++;
                }
            }
            else if(i<6)
            {
                if(flds[i].getText().equals("O"))
                {
                    r2++;
                }
            }
            else if(i<9)
            {
                if(flds[i].getText().equals("O"))
                {
                    r3++;
                }
            }
            if(i==0 || i==4 || i==8)
            {
                if(flds[i].getText().equals("O"))
                {
                    x1++;
                }
            }
            if(i==2 || i==4 || i==6)
            {
                if(flds[i].getText().equals("O"))
                {
                    x2++;
                }
            }
        }
        if(c1 == 3|| c2 == 3|| c3 == 3 || r1 == 3 || r2 == 3 || r3 == 3 || x1 == 3 || x2 == 3)
        {
            return 'C';
        }
        int cnt = 0;
        for(int i=0;i<9;i++)
        {
            if(flds[i].getText().equals(""))
            {
                cnt++;
            }
        }
        if(cnt==0)
        {
            win = 'O';
        }
        return win;
    }
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.setVisible(true);
        t.setSize(350, 370);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}