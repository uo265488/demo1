package giis.demo.tkrun.views.revisor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import giis.demo.tkrun.controllers.revisor.RevisorController;

public class RevisorMenu extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id_revisor;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JButton btnNewButton_1_1;

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//	try {
//	    RevisorMenu dialog = new RevisorMenu();
//	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//	    dialog.setVisible(true);
//	} catch (Exception e) {
//	    e.printStackTrace();
//	}
//    }

    /**
     * Create the dialog.
     */
    public RevisorMenu(int id_revisor) {
	setModal(true);
	this.id_revisor = id_revisor;
	setResizable(false);
	setBounds(100, 100, 338, 300);
	getContentPane().setLayout(null);
	getContentPane().add(getBtnNewButton());
	getContentPane().add(getBtnNewButton_1());
	getContentPane().add(getBtnNewButton_1_1());
    }

    private JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("Ver articulos revisados");
	    btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    RevisorAsignadosView rav = new RevisorAsignadosView(new RevisorController(), id_revisor);
		    rav.setVisible(true);
		}
	    });
	    btnNewButton.setBounds(79, 42, 164, 30);
	}
	return btnNewButton;
    }

    private JButton getBtnNewButton_1() {
	if (btnNewButton_1 == null) {
	    btnNewButton_1 = new JButton("Ver articulos pendientes");
	    btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	    });
	    btnNewButton_1.setBounds(79, 114, 164, 30);
	}
	return btnNewButton_1;
    }

    private JButton getBtnNewButton_1_1() {
	if (btnNewButton_1_1 == null) {
	    btnNewButton_1_1 = new JButton("Revisar articulos");
	    btnNewButton_1_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    RevisorView rv = new RevisorView(new RevisorController());
		    rv.setVisible(true);
		}
	    });
	    btnNewButton_1_1.setBounds(79, 186, 164, 30);
	}
	return btnNewButton_1_1;
    }
}
