package UserInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.TextField;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class GUI_Customer extends JFrame {
	private JComboBox jcbCustomerBox;
	private TableCellRenderer centerRenderer;
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Customer pc = new Process_Customer();
	Connect con = new Connect();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JComboBox comboBox;
	public void getAllCustomer() {
		 ArrayList<Customer> ls =  pc.getListCustomer();
		 for(int i=0;i<ls.size();i++) {
			 Customer c = (Customer) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(c.getMaKH());
			 tbRow.add(c.getName());
			 tbRow.add(c.getAge());
			 tbRow.add(c.getNumberPhone());
			 tbRow.add(c.getAddress());
			 
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
		 
	}
	public void getCustomerbyMaKH(String MaKH) {
		 Model.setRowCount(0);
		 ArrayList<Customer> ls =  pc.getCustomer_byMaKH(MaKH);
		 for(int i=0;i<ls.size();i++) {
			 Customer s = (Customer) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getMaKH());
			 tbRow.add(s.getName());
			 tbRow.add(s.getAge());
			 tbRow.add(s.getNumberPhone());
			 tbRow.add(s.getAddress());
			 
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
		 
	}
	public void LoadData() {
		Connection cn = con.getCon();
		String sqlString = "select * from tb_customer";
		Model.setRowCount(0);
		ArrayList<Customer> ls =  pc.getListCustomer();
		 for(int i=0;i<ls.size();i++) {
			 Customer c = (Customer) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(c.getMaKH());
			 tbRow.add(c.getName());
			 tbRow.add(c.getAge());
			 tbRow.add(c.getNumberPhone());
			 tbRow.add(c.getAddress());
			 
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					GUI_Account frame = new GUI_Account();
//					frame.setVisible(true);
					GUI_Customer frame = new GUI_Customer();
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
	public GUI_Customer() {
		setTitle("Kh??ch h??ng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 643);
		contentPane =  new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(424, 576, 354, 20);
		contentPane.add(lblNewLabel_1);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(SystemColor.textHighlight);
		desktopPane_1.setBounds(10, 0, 1148, 217);
		contentPane.add(desktopPane_1);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(31, 28, 699, 158);
		desktopPane_1.add(desktopPane);
		desktopPane.setBackground(new Color(135, 206, 250));
		
		JLabel lblNewLabel = new JLabel("M?? kh??ch h??ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 24, 130, 20);
		desktopPane.add(lblNewLabel);
		
		JLabel lblTnKhchHng = new JLabel("T??n kh??ch h??ng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnKhchHng.setBounds(20, 68, 130, 20);
		desktopPane.add(lblTnKhchHng);
		
		JLabel lblTuiKhchHng = new JLabel("Tu???i kh??ch h??ng");
		lblTuiKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTuiKhchHng.setBounds(20, 115, 130, 20);
		desktopPane.add(lblTuiKhchHng);
		
		JLabel lblSinThoaik = new JLabel("S??? ??i???n tho???i");
		lblSinThoaik.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoaik.setBounds(369, 24, 130, 20);
		desktopPane.add(lblSinThoaik);
		
		JLabel lblaCh = new JLabel("?????a ch???");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(369, 68, 94, 20);
		desktopPane.add(lblaCh);
		
		textField = new JTextField();
		textField.setBounds(152, 22, 206, 29);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 66, 206, 29);
		desktopPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 113, 206, 29);
		desktopPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(470, 24, 206, 29);
		desktopPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(473, 70, 203, 25);
		desktopPane.add(comboBox);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBounds(772, 28, 347, 158);
		desktopPane_1.add(desktopPane_2);
		desktopPane_2.setBackground(new Color(135, 206, 250));
		
		JButton btnNewButton = new JButton("Th??m");
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(38, 10, 94, 33);
		desktopPane_2.add(btnNewButton);
		
		JButton btnSa = new JButton("S???a");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSa.setBounds(38, 64, 94, 33);
		desktopPane_2.add(btnSa);
		
		JButton btnXa = new JButton("X??a");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXa.setBounds(38, 115, 94, 33);
		desktopPane_2.add(btnXa);
		
		JButton btnTmKim = new JButton("T??m ki???m");
		
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTmKim.setBounds(212, 10, 105, 33);
		desktopPane_2.add(btnTmKim);
		
		JButton btnLmMi = new JButton("L??m m???i");
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLmMi.setBounds(212, 64, 105, 33);
		desktopPane_2.add(btnLmMi);
		
		JButton btnThot = new JButton("Tho??t");
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThot.setBounds(212, 115, 105, 33);
		desktopPane_2.add(btnThot);
		
		JLabel lblNewLabel_2 = new JLabel("Danh s??ch kh??ch h??ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(464, 227, 261, 42);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(21, 280, 1124, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				textField.setText((String) Model.getValueAt(index, 0));
				textField_1.setText((String) Model.getValueAt(index, 1));
				textField_2.setText(String.valueOf(Model.getValueAt(index, 2)));
				textField_3.setText(String.valueOf(Model.getValueAt(index, 3)));
				comboBox.setSelectedItem((String) Model.getValueAt(index, 4));
				textField.enable(false);
			}
		});
		scrollPane.setViewportView(table);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		 try {   
	            Connect cn = new Connect();
	            Connection con = cn.getCon();
	            String sql="select  Address from tb_customer group by Address";
	            PreparedStatement ps=con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            String name = rs.getString("Address");
	            comboBox.addItem(name);            
	        }

	    } catch (Exception e) {
	        System.out.println("null");
	    }
		
		columns.add("M?? Kh??ch H??ng");
		columns.add("H??? v?? T??n");
		columns.add("Tu???i");
		columns.add("S??? ??i???n Tho???i");
		columns.add("?????a ch???");
		getAllCustomer();
		//Th??m
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText().equals("Th??m")) {
					btnNewButton.setText("L??u");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField.enable(true);
				}
				else if (btnNewButton.getText().equals("L??u")) {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
					int kq2=JOptionPane.showConfirmDialog(null, "B???n c?? mu???n L??u?","Th??ng b??o",JOptionPane.YES_NO_OPTION);
					if(kq2==0) {
						if(pc.insertCustomer(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), (String) comboBox.getSelectedItem())) {
							lblNewLabel_1.setText("Th??m th??nh c??ng!");
							lblNewLabel_1.setForeground(Color.BLUE);
							btnNewButton.setText("Th??m");
							LoadData();
							
						}
						else {
							lblNewLabel_1.setText("Th??m th???t b???i!");
							lblNewLabel_1.setForeground(Color.RED);
						}
						
					}
					
				}
				
				
				
			}
			
		});
		//T??m ki???m
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKH = textField.getText();
				getCustomerbyMaKH(maKH);
			}
		});
		//X??a
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq1=JOptionPane.showConfirmDialog(null, "B???n c?? mu???n X??a?","Th??ng b??o",JOptionPane.YES_NO_OPTION);
				if(kq1==0) {
					if(pc.delCustomer(textField.getText())) {
						lblNewLabel_1.setText("X??a th??nh c??ng!");
						lblNewLabel_1.setForeground(Color.BLUE);
						LoadData();
						
					}
					else {
						lblNewLabel_1.setText("X??a th???t b???i!");
						lblNewLabel_1.setForeground(Color.RED);
					}
					
					
				}
				
			}
		});
		//l??m m???i
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.enable(true);
				lblNewLabel_1.setText("");
				btnNewButton.setText("Th??m");
				LoadData();
			}
		});
		//s???a
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pc.updateCustomer(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), (String) comboBox.getSelectedItem())) {
					lblNewLabel_1.setText("S???a th??nh c??ng!");
					lblNewLabel_1.setForeground(Color.BLUE);
					LoadData();
				}
				else {
					lblNewLabel_1.setText("S???a th???t b???i!");
					lblNewLabel_1.setForeground(Color.RED);
				}
			}
		});
		//tho??t
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "B???n c?? mu???n tho??t?","Th??ng b??o",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					GUI_Home home = new GUI_Home();
	                setVisible(false);
	                home.setVisible(true);
	                GUI_Customer frame = new GUI_Customer();
	                frame.setVisible(false);
					
					
				
				}
			}
		});
	}
}
