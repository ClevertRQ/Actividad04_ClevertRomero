package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Cliente;
import model.ClienteModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import reporte.GeneradorReporte;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmReporteClienteLista extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JLabel lblNewLabel;
	private JButton btnFiltrar;
	private JPanel panelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClienteLista frame = new FrmReporteClienteLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmReporteClienteLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI :");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDNI.setBounds(106, 54, 62, 23);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setBounds(274, 51, 380, 26);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFiltrar.setBounds(760, 54, 99, 25);
		contentPane.add(btnFiltrar);
	 
		lblNewLabel = new JLabel("CONSULTA CLIENTE POR DNI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 947, 35);
		contentPane.add(lblNewLabel);
		
		panelReporte = new JPanel();
		panelReporte.setBounds(12, 115, 945, 337);
		contentPane.add(panelReporte);
		panelReporte.setLayout(new BorderLayout(0, 0));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		
		ClienteModel cliente = new ClienteModel();
		List<Cliente> lstData = null;
		
		String dni = txtDNI.getText().trim();
		if(dni.equals("")) {
			lstData = cliente.listaCliente();
		}else {
			lstData = cliente.consultaCliente(dni);
		}
		
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstData);

		String file = "reporteCliente.jasper";
				
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, null);

		JRViewer jRViewer = new JRViewer(jasperPrint);
				
		panelReporte.removeAll();
		panelReporte.add(jRViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
