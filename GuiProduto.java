package semana06;
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GuiProduto extends JPanel {
    private JButton btGravar;
    private JButton btLer;
    private JLabel lbCodigo;
    private JLabel lbDescricao;
    private JLabel lbValor;
    private JTextField tfCodigo;
    private JTextField tfDescricao;
    private JTextField tfValor;
    private Produto produto;

    public GuiProduto() {
        //construct components
        btGravar = new JButton ("Gravar");
        btLer = new JButton ("Ler");
        lbCodigo = new JLabel ("Código: ");
        lbDescricao = new JLabel ("Descrição:");
        lbValor = new JLabel ("Valor:");
        tfCodigo = new JTextField (5);
        tfDescricao = new JTextField (5);
        tfValor = new JTextField (5);
        produto = new Produto();

        //adjust size and set layout
        setPreferredSize (new Dimension (488, 281));
        setLayout (null);

        //add components
        add (btGravar);
        add (btLer);
        add (lbCodigo);
        add (lbDescricao);
        add (lbValor);
        add (tfCodigo);
        add (tfDescricao);
        add (tfValor);

        //set component bounds (only needed by Absolute Positioning)
        btGravar.setBounds (55, 240, 100, 20);
        btLer.setBounds (165, 240, 100, 20);
        lbCodigo.setBounds (60, 55, 100, 25);
        lbDescricao.setBounds (55, 110, 100, 25);
        lbValor.setBounds (60, 165, 100, 25);
        tfCodigo.setBounds (130, 55, 100, 25);
        tfDescricao.setBounds (130, 110, 325, 25);
        tfValor.setBounds (130, 165, 100, 25);
        
        
        btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto.setCodigo(Integer.parseInt(tfCodigo.getText()));
				produto.setDescricao(tfDescricao.getText());
				produto.setValor(Double.parseDouble(tfValor.getText()));
				JOptionPane.showMessageDialog(btGravar, produto.persisteProduto());
				
			}
		});
    
    btLer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	produto.setCodigo(Integer.parseInt(tfCodigo.getText()));

            JOptionPane.showMessageDialog(btLer, produto.lerObjeto());
        }
    });
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame ("GuiProduto");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiProduto());
        frame.pack();
        frame.setVisible (true);
    }
}
