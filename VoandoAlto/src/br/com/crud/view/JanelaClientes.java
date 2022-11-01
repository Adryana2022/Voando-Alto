package br.com.crud.view;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Adriana
 */
public class JanelaClientes extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private final ClienteDAO dao = new ClienteDAO();
	private final Cliente atual = new Cliente();
	
	private TableModel getTableModel() {
		List<Cliente> lista = dao.getCliente();
		Object[][] dados = new Object[lista.size()][4];
		for(int i=0; i<lista.size(); i++) {
			dados[i][0] = lista.get(i).getNome();
			dados[i][1] = lista.get(i).getIdade();
			dados[i][2] = lista.get(i).getEmail();
			dados[i][3] = lista.get(i).getDestino();
		}
		return new DefaultTableModel(
	              dados,
	              new String [] {
	                   "Nome", "Idade", "Email", "Destino"
	              });
	}
	
	private void preencherPainel() {
		txtNome.setText(atual.getNome());
		spnIdade.setValue(atual.getIdade());
                txtEmail.setText(atual.getEmail());
                txtDestino.setText(atual.getDestino());
	}
	
	
    public JanelaClientes() {
        initComponents();
        initEventos();
    }
    
    private void initEventos() {
    	tblCliente.addMouseListener(
    		new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				super.mouseClicked(e);
    				int row = tblClientes.rowAtPoint(e.getPoint());
    				TableModel modelo = tblClientes.getModel();
    				if (row>=0) {
    					
    					atual.setNome((String)modelo.getValueAt(row,1));
    					atual.setIdade((int)modelo.getValueAt(row,2));
    				
    					preencherPainel();
    				}
    			}
			});
    	
    	btnNovo.addActionListener((ActionEvent e) -> {
       
            atual.setNome("");
            atual.setIdade(0);
            preencherPainel();
            });
    	
    	btnSalvar.addActionListener((var e) -> {
            atual.setNome(txtNome.getText());
            atual.setIdade((int)spnIdade.getValue());
            
            });
    	
    	btnExcluir.addActionListener((ActionEvent e) -> {
            if(atual.getNome()!=0) {
                dao.removeByNome(atual.getNome());
                atual.setNome("");
                atual.setIdade(0);
                preencherPainel();
            }
            });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        tblContatos = new JTable();
        jPanel1 = new JPanel();
        lblId = new JLabel();
        jLabel2 = new JLabel();
        txtNome = new JTextField();
        jLabel3 = new JLabel();
        spnIdade = new JSpinner();
        btnNovo = new JButton();
        btnExcluir = new JButton();
        btnSalvar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tblCliente.setModel(getTableModel());
            Component tblCliente = null;
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jLabel2.setText("Nome");
        jLabel3.setText("Idade");
        btnNovo.setText("NOVO");
        btnExcluir.setText("EXCLUIR");
        btnSalvar.setText("SALVAR");
        preencherPainel();

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spnIdade, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                                .addComponent(btnNovo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblId)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spnIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        pack();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new JanelaClientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JSpinner spnIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration                   

    private static class tblClientes {

        public tblClientes() {
        }
    }
}