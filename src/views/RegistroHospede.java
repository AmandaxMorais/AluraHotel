package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import controller.HospedeController;
import controller.ReservasController;
import model.HospedeModelo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class RegistroHospede extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtTelefone;
	private JTextField txtNreserva;
	private JDateChooser txtDataN;
	private Date date;
	private JComboBox<Object> ComboNacionalidade;
	private Integer idHospede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroHospede frame = new RegistroHospede();
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
	public RegistroHospede(Integer idHospede, Integer idReserva) {
		this.idHospede = idHospede;
		Tela();
		HospedeCarregar(idHospede, idReserva);

	}

	public RegistroHospede() {
		Tela();
		pegaReserva();
	}

	public void Tela() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/imagens/pessoa.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		txtNome = new JTextField();
		txtNome.setBackground(Color.WHITE);
		txtNome.setColumns(10);
		txtNome.setBounds(556, 155, 255, 33);
		contentPane.add(txtNome);

		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(Color.WHITE);
		txtSobrenome.setBounds(556, 222, 255, 33);
		contentPane.add(txtSobrenome);

		txtDataN = new JDateChooser(null, "yyyy-MM-dd");
		txtDataN.setBounds(556, 286, 255, 33);
		contentPane.add(txtDataN);

		ComboNacionalidade = new JComboBox<>();
		ComboNacionalidade.setFont(new Font("Arial", Font.PLAIN, 14));
		ComboNacionalidade.setModel(new DefaultComboBoxModel<Object>(new Object[] { "Afghanistan ??? Afeganist??o",
				"Afghan ??? afeg??o", "Andorra ??? Andorra", "Andorran ??? andorrano", "Angola ??? Angola", "Angolan ??? angolano",
				"Antigua e Barbuda ??? Ant??gua e Barbuda", "Antiguan/Barbudan ??? antiguano", "Algeria ??? Arg??lia",
				"Algerian ??? argelino", "Argentina ??? Argentina", "Argentinian ??? argentino", "Armenia ??? Arm??nia",
				"Armenian ??? arm??nio", "Australia ??? Austr??lia", "Australian ??? australiano", "Austria ??? ??ustria",
				"Austrian ??? austr??aco", "Azerbaijan ??? Azerbaij??o", "Azerbaijani ??? azeri", "The Bahamas ??? Bahamas",
				"Bahamian ??? bahamense", "Bangladesh ??? Bangladesh", "Bangladeshi ??? banglad??s", "Barbados ??? Barbados",
				"Barbadian ??? barbadiano", "Bahrain ??? Bar??m", "Bahraini ??? baremita", "Belarus ??? Bielorr??ssia",
				"Belarusian ??? bielorrusso", "Belgium ??? B??lgica", "Belgian ??? belga", "Belize ??? Belize",
				"Belizean ??? belizenho", "Benin ??? Benim", "Beninese ??? beninense", "Bolivia ??? Bol??via",
				"Bolivian ??? boliviano", "Bosnia; Bosnia and Herzegovina ??? B??snia; B??snia e Herzegovina",
				"Bosnian ??? b??snio", "Botswana ??? Botsuana", "Motswana ??? bechuano", "Brazil ??? Brasil",
				"Brazilian ??? brasileiro", "Brunei ??? Brunei", "Bruneian ??? bruneano", "Bulgaria ??? Bulg??ria",
				"Bulgarian ??? b??lgaro", "BurkinaFaso ??? BurkinaFaso", "Burkinab?? ??? burquinense", "Burundi ??? Burundi",
				"Burundian ??? burund??s", "Bhutan ??? But??o", "Bhutanese ??? butanense", "Cape Verde ??? Cabo Verde",
				"Cape Verdean ??? cabo-verdiano", "Cameroon ??? Camar??es", "Cameroonian ??? camaronense",
				"Cambodia ??? Camboja", "Cambodian ??? cambojano", "", "Canada ??? Canad??", "Canadian ??? canadense", "",
				"Central African Republic ??? Rep??blica Centro-Africana", "Central-african ??? centroafricano", "",
				"Chad ??? Chade", "Chadian ??? chadiano", "", "China ??? China", "Chinese ??? chin??s", "", "Chile ??? Chile",
				"Chilean ??? chileno", "", "Cook Islands ??? Ilhas Cook", "Cook Islander ??? cookiano", "",
				"Colombia ??? Col??mbia", "Colombian ??? colombiano", "", "Comoros ??? Comores", "Comoran ??? comoriano", "",
				"Costa Rica ??? Costa Rica", "Costa Rican ??? costa-riquenho", "", "Croatia ??? Cro??cia", "Croatian ??? croata",
				"", "Cuba ??? Cuba", "Cuban ??? Cubano", "", "Cyprus ??? Chipre", "Cypriot ??? cipriota", "",
				"Czech Republic ??? Rep??blica Tcheca", "Czech ??? tcheco", "",
				"Democratic Republic of Congo ??? Rep??blica Democr??tica do Congo", "Congolese ??? congolense", "",
				"Denmark ??? Dinamarca", "Danish ??? dinamarqu??s", "", "Djibouti ??? Djibuti", "Djiboutian ??? djibutiense", "",
				"Dominica ??? Dominica", "Dominican ??? dominiquense", "", "Dominican Republic ??? Rep??blica Dominicana",
				"Dominican ??? dominicano", "", "East Timor ??? Timor Leste", "East Timorese ??? timorense", "",
				"Ecuador ??? Equador", "Ecuadorian ??? equatoriano", "", "Egypt ??? Egito", "Egyptian ??? eg??pcio", "",
				"El Salvador ??? El Salvador", "Salvadorean ??? salvadorenho", "", "England ??? Inglaterra",
				"English ??? ingl??s", "", "Equatorial Guinea ??? Guin?? Equatorial", "Equatoguinean ??? guin??u-equatoriano",
				"", "Eritrea ??? Eritreia", "Eritrean ??? eritreu", "", "Est??nia ??? Est??nia", "Estonian ??? estoniano", "",
				"Fiji ??? Fiji", "Fijian ??? fijiano", "", "Finland ??? Finl??ndia", "Finnish ??? finland??s", "",
				"France ??? Fran??a", "French ??? franc??s", "", "Gabon ??? Gab??o", "Gabonese ??? gabonense", "",
				"Gambia ??? G??mbia", "Gambian ??? gambiano", "", "Georgia ??? Ge??rgia", "Georgian ??? ge??rgico", "",
				"Germany ??? Alemanha", "German ??? alem??o", "", "Grenada ??? Granada", "Grenadian ??? granadino", "",
				"Greece ??? Gr??cia", "Greek ??? grego", "", "Guatemala ??? Guatemala", "Guatemalan ??? guatemalteco", "",
				"Guinea ??? Guin??", "Guinean ??? guineano", "", "Guinea???Bissau ??? Guin??Bissau", "Bissau???guinean ??? guineense",
				"", "Guyana ??? Guiana", "Guyanese ??? guianense", "", "Haiti ??? Haiti", "Haitian ??? haitiano", "",
				"Holland ??? Holanda", "Dutch ??? holand??s", "", "Honduras ??? Honduras", "Honduran ??? hondurenho", "",
				"Hungary ??? Hungria", "Hungarian ??? h??ngaro", "", "Iceland ??? Isl??ndia", "Icelander ??? island??s", "",
				"India ??? ??ndia", "Indian ??? indiano", "", "Indonesia ??? Indon??sia", "Indonesian ??? indon??sio", "",
				"Iran ??? Ir??", "Iranian ??? iraniano", "", "Ireland ??? Irlanda", "Irish ??? irland??s", "", "Israel ??? Israel",
				"Israeli ??? israelita", "", "Italy ??? It??lia", "Italian ??? italiano", "", "Ivory Coast ??? Costa do Marfim",
				"Ivorian??? costa-marfinense", "", "Jamaica ??? Jamaica", "Jamaican ??? jamaicano", "", "Japan ??? Jap??o",
				"Japanese ??? japon??s", "", "Jordan ??? Jord??nia", "Jordanian ??? jord??o", "", "Kazakhstan ??? Cazaquist??o",
				"Kazakh ??? cazaque", "", "Kenya ??? Qu??nia", "Kenyan ??? queniano", "", "Kiribati ??? Quiribati",
				"I-kiribati ??? quiribatiano", "", "Kyrgyzstan ??? Quirguist??o", "Kyrgyzstani ??? quirguistan??s", "",
				"Kwait ??? Kuwait", "Kwaiti ??? kuwaitiano", "", "Laos ??? Laos", "Laotian ??? laosiano", "",
				"Latvia ??? Let??nia", "Latvian ??? letoniano", "", "Lebanon ??? L??bano", "Lebanese ??? liban??s", "",
				"Lesotho ??? Lesoto", "Basotho ??? lesotiano", "", "Liberia ??? Lib??ria", "Liberian ??? liberiano", "",
				"Liechtenstein ??? Liechtenstein", "Liechtensteiner ??? liechtensteinense", "", "Lithuania ??? Litu??nia",
				"Lithuanian ??? lituano", "", "Luxembourg ??? Luxemburgo", "Luxembourgish ??? luxemburgu??s", "",
				"Lybia ??? L??bia", "Lybian ??? l??bio", "", "Macedonia ??? Maced??nia", "Macedonian ??? maced??nio", "",
				"Madagascar ??? Madagascar", "Malagasy ??? madagascarense", "", "Malaysia ??? Mal??sia", "Malaysian ??? malaio",
				"", "Malawi ??? Malaui", "Malawian ??? malauiano", "", "Maldives ??? Maldivas", "Maldivian ??? maldivo", "",
				"Mali ??? M??li", "Malian ??? maliano", "", "Malta ??? Malta", "Maltese ??? malt??s", "", "Mauritius ??? Maur??cio",
				"Mauritian ??? mauriciano", "", "Mauritia ??? Maurit??nia", "Mauritanian ??? mauritano", "",
				"Marshall Island ??? Ilhas Marshall", "Marshall Islander ??? marshallino", "",
				"Micronesia/Federated States of Micronesia ??? Estados Federados da Micron??sia",
				"Micronesian ??? micron??sio", "", "Mexico ??? M??xico", "Mexican ??? mexicano", "", "Morocco ??? Marrocos",
				"Moroccan ??? marroquino", "", "Moldova ??? Moldavia", "Moldovan ??? mold??vio", "", "Monaco ??? M??naco",
				"Monacan ??? monegasco", "", "Mongolia ??? Mong??lia", "Mongolian ??? mongol", "", "Montenegro ??? Montenegro",
				"Montenegrin ??? montenegrino", "", "Mozambique ??? Mo??ambique", "Mozambican ??? mo??ambicano", "",
				"Myanmar ??? Myanmar", "Burmese ??? birman??s", "", "Namibia ??? Nam??bia", "Namibian ??? namibiano", "",
				"Nauru ??? Nauru", "Nauruan ??? nauruano", "", "Nepal ??? Nepal", "Nepali ??? nepal??s", "",
				"New Zealand ??? Nova Zel??ndia", "NewZealander ??? neozeland??s", "", "Nicaragua ??? Nicar??gua",
				"Nicaraguan ??? nicaraguense", "", "Niger ??? N??ger", "Nigerien ??? nigerino", "", "Nigeria ??? Nig??ria",
				"Nigerian ??? nigeriano", "", "Niue ??? Niue", "Niuean ??? niuano", "", "North Korea ??? Cor??ia do Norte",
				"North korean ??? norte-coreano", "", "Norway ??? Noruega", "Norwegian ??? noruegu??s", "", "Oman ??? Om??",
				"Omani ??? omanense", "", "Palestine ??? Palestina", "Palestinian ??? palestino", "", "Pakistan ??? Paquist??o",
				"Pakistanese ??? paquistan??s", "", "Palau ??? Palau", "Palauan ??? palauense", "", "Panama ??? Panam??",
				"Panamanian ??? panamenho", "", "Papua New Guinea ??? Papua Nova Guin??", "Papua New Guinean ??? papu??sio", "",
				"Paraguay ??? Paraguai", "Paraguayan ??? paraguaio", "", "Peru ??? Peru", "Peruvian ??? peruano", "",
				"Philippines ??? Philippines", "Philippine ??? filipino", "", "Poland ??? Pol??nia", "Polish ??? polon??s", "",
				"Portugal ??? Portugal", "Portuguese ??? portugu??s", "", "Qatar ??? Catar", "Qatari ??? catarense", "",
				"Romania ??? Rom??nia", "Romanian ??? romeno", "", "Russia ??? R??ssia", "Russian ??? russo", "",
				"Rwanda ??? Ruanda", "Rwandan ??? ruand??s", "", "Samoa ??? Samoa", "Samoan ??? samoano", "",
				"Saint Lucia ??? Santa L??cia", "Saint Lucian ??? santa-lucense", "",
				"Saint Kitts and Nevis ??? S??o Crist??v??o e Nevis", "Kittian ??? s??o-cristovense", "",
				"San Marino ??? S??o Marino", "San Marinan ??? s??o-marinense", "",
				"Sao Tom?? and Principe ??? S??o Tom?? e Pr??ncipe", "Sao Tomean ??? s??o-tomense", "",
				"Saint Vincent and the Grenadines ??? S??o Vicente e Granadinas", "Vicentinian ??? s??o-vicentino", "",
				"Scotland ??? Esc??cia", "Scottish ??? escoc??s", "", "Senegal ??? Senegal", "Senegalese ??? senegalense", "",
				"Serbia ??? S??rvia", "Serbian ??? s??rvio", "", "Seychelles ??? Seicheles", "Seychellois ??? seichelense", "",
				"Sierra Leone ??? Serra Leoa", "Sierra Leonean ??? serra-leon??s", "", "Singapore ??? Singapura",
				"Singaporean ??? singapurense", "", "Slovakia ??? Eslov??quia", "Slovak ??? eslovaco", "",
				"Solomon Islands ??? Ilhas Salom??o", "Solomon Islander ??? salom??nico", "", "Somalia ??? Som??lia",
				"Somali ??? somali", "", "South Africa ??? ??frica do Sul", "South African ??? sul???africano", "",
				"South Korea ??? Cor??ia do Sul", "Korean ??? coreano", "", "South Sudan ??? Sud??o do Sul",
				"South Sudanese ??? sul-sudanense", "", "Spain ??? Espanha", "Spanish ??? espanhol", "",
				"Sri Lanka ??? Sri Lanka", "Sri Lankan ??? srilank??s", "", "Sudan ??? Sud??o", "Sudanese ??? sudanense", "",
				"Suriname ??? Suriname", "Surinamese ??? surinam??s", "", "Swaziland ??? Suazil??ndia", "Swazi ??? suazi", "",
				"Sweden ??? Su??cia", "Swedish ??? sueco", "", "Switzerland ??? Su????a", "Swiss ??? su????o", "", "Syria ??? S??ria",
				"Syrian ??? s??rio", "", "Tajikistan ??? Tadiquist??o", "Tajiki ??? tajique", "Tanzanian ??? tanzaniano",
				"Thailand ??? Tail??ndia", "Thai ??? tailand??s", "Togo ??? Togo", "Togolese ??? togol??s", "Tonga ??? Tonga",
				"Tongan ??? tongan??s", "Trinidad and Tobago ??? Trindade e Tobago", "Trinidadian ??? trinit??rio", "",
				"Tunisia ??? Tun??sia", "Tunisian ??? tunisiano", "Turkmenistan ??? Turcomenist??o", "Turkmen ??? turcomeno",
				"Turkey ??? Turquia", "Turkish ??? turco", "Tuvalu ??? Tuvalu", "Tuvaluan ??? tuvaluano", "Ukraine ??? Ucr??nia",
				"Ukrainian ??? ucraniano", "Uganda ??? Uganda", "Ugandan ??? ugand??s", "Uruguay ??? Uruguai",
				"Uruguayan ??? uruguaio", "United Arab Emirates ??? Emirados ??rabes Unidos", "Emirati ??? ??rabe",
				"United Kingdom ??? Reino Unido", "British ??? brit??nico", "United States of America ??? Estados Unidos",
				"American ??? americano", "Uzbekistan ??? Usbequist??o", "Uzbek ??? uzbeque", "Vanuatu ??? Vanuatu",
				"Ni-vanuatu ??? vanuatuano", "Venezuela ??? Venezuela", "Venezuelan ??? venezuelano", "Vietnam ??? Vietn??",
				"Vietnamese ??? vietnamita", "Wales ??? Pa??s de Gales", "Welsh ??? gal??s", "Yemen ??? I??men",
				"Yemeni ??? iemenita", "Zambia ??? Z??mbia", "Zambian ??? zambiano", "Zimbabwe ??? Zimb??bue",
				"Zimbabwean ??? zimbabueano" }));
		ComboNacionalidade.setBounds(556, 355, 255, 33);
		contentPane.add(ComboNacionalidade);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(558, 130, 253, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Sobrenome");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(556, 199, 255, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(556, 261, 255, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nacionalidade");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(556, 330, 255, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagens/registro.png")));
		lblNewLabel.setBounds(0, 11, 502, 556);
		contentPane.add(lblNewLabel);

		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagens/cancelar.png")));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(764, 543, 54, 41);
		contentPane.add(btnCancelar);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarOuAlterar(idHospede);
			}
		});
		btnSalvar.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagens/disquete.png")));
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setBounds(700, 543, 54, 41);
		contentPane.add(btnSalvar);

		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});

		btnSair.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagens/encerrar-sessao-32-px.png")));
		btnSair.setBackground(SystemColor.menu);
		btnSair.setBounds(828, 543, 54, 41);
		contentPane.add(btnSair);

		JLabel lblNewLabel_1_2 = new JLabel("Telefone");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(558, 399, 253, 14);
		contentPane.add(lblNewLabel_1_2);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBackground(Color.WHITE);
		txtTelefone.setBounds(556, 424, 255, 33);
		contentPane.add(txtTelefone);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegistroHospede.class.getResource("/imagens/Ha-100px.png")));
		lblNewLabel_2.setBounds(780, 11, 104, 107);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Registro de H??spede");
		lblNewLabel_4.setIcon(null);
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(556, 79, 198, 42);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2_1 = new JLabel("N??mero de Reserva");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(558, 460, 253, 14);
		contentPane.add(lblNewLabel_1_2_1);

		txtNreserva = new JTextField();
		txtNreserva.setEnabled(false);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(Color.WHITE);
		txtNreserva.setBounds(556, 485, 255, 33);
		contentPane.add(txtNreserva);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 502, 595);
		contentPane.add(panel);
	}

	public void HospedeCarregar(Integer idHospede, Integer idReserva) {

		txtNreserva.setText(Integer.toString(idReserva));

		HospedeController hospedeController = new HospedeController();
		List<HospedeModelo> hospedes = hospedeController.listar();

		hospedes.forEach(hospede -> {
			if (hospede.getIdHospede() == idHospede) {
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(hospede.getDataNascimento());
					System.out.println(hospede.getDataNascimento());
					txtNome.setText(hospede.getNome());
					txtSobrenome.setText(hospede.getSobrenome());
					txtTelefone.setText(hospede.getTelefone());
					txtDataN.setDate(date);
					ComboNacionalidade.setSelectedItem(hospede.getNacionalidade());
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		});
	}

	private void salvarOuAlterar(Integer id) {

		List<Integer> checkId = new ArrayList<>();

		HospedeController hospedeController = new HospedeController();
		List<HospedeModelo> hospedes = hospedeController.listar();
		hospedes.forEach(hospede -> {
			checkId.add(hospede.getIdHospede());
		});

		if (checkId.contains(id)) {
			alterarHospede();
		} else {
			adicionarHospede();
		}
	}

	private void adicionarHospede() {
		if (infoHospede() != null) {
			HospedeController hc = new HospedeController();
			hc.salvar(infoHospede());

			Sucesso sucesso = new Sucesso();
			sucesso.setVisible(true);

			dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		}
	}

	private void alterarHospede() {
		if (infoHospede() != null) {
			HospedeController hc = new HospedeController();
			hc.alterar(infoHospede());

			JOptionPane.showMessageDialog(null, "H??spede alterado com sucesso");

			Buscar buscar = new Buscar();
			buscar.setVisible(true);

			dispose();

		} else {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		}
	}

	private HospedeModelo infoHospede() {
		try {
			String DNascimento = new SimpleDateFormat("yyyy-MM-dd").format(txtDataN.getDate());

			HospedeModelo hospedeModelo = new HospedeModelo(
					txtNome.getText(),
					txtSobrenome.getText(),
					DNascimento,
					ComboNacionalidade.getSelectedItem().toString(),
					txtTelefone.getText(),
					Integer.parseInt(txtNreserva.getText()));

			return hospedeModelo;

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
			System.out.println(e1);
		}

		return null;
	}

	private void pegaReserva() {
		ReservasController rc = new ReservasController();
		Integer IdReserva = rc.listar().get(rc.listar().size() - 1).getId();
		txtNreserva.setText(Integer.toString(IdReserva));
	}

}
