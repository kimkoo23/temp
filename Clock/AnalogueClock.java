package Project;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import java.text.*;

class AnalogueClock extends JFrame implements ItemListener, Runnable {

	Image memoryimage;
	// 더블 버퍼링 기법을 위한 메모리상에 화면 사이즈만큼의 이미지 버퍼를 생성
	Graphics mgc;
	// 생성한 이미지 버퍼에 대한 그래픽스 객체를 가져온다.

	int x, y, width, heigh, sx, sy, mx, my, hx, hy, centerX, centerY;
	private String timeZoneStr = "Asia/Seoul";// 타임존 초기화, 시간은 서울로
//메뉴 셋팅//
	private MenuBar mb = new MenuBar();

	private Menu tema = new Menu("테마");

	private CheckboxMenuItem tema1 = new CheckboxMenuItem("테마1");
	private CheckboxMenuItem tema2 = new CheckboxMenuItem("테마2");
	private CheckboxMenuItem tema3 = new CheckboxMenuItem("테마3");
	private CheckboxMenuItem tema4 = new CheckboxMenuItem("테마4", true);
	JComboBox<String> cbb_tema;
	// JLabel lb_print;
	static CheckboxMenuItem beacon = new CheckboxMenuItem("비콘");

	private String imgFile = "images/Clock4.jpg";// 이미지 주소 초기화
	private ImageIcon icon = new ImageIcon(imgFile);
	private Image img = icon.getImage();

	Calendar cal = Calendar.getInstance();

	AnalogueClock () {
		setTitle("AnalogueClock");
		setSize(607, 555);
		setVisible(true);
		setResizable(false);// 프레임 크기 변경 못하게
		this.setLayout(null);
		this.init();
		this.start();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void init() {

		JPanel panel_beaconU = new JPanel();
		panel_beaconU.setBounds(502, 0, 100, 100);
		add(panel_beaconU);
		panel_beaconU.setLayout(null);

		JButton btnBCU = new JButton("");
		btnBCU.setIcon(new ImageIcon("images\\beaconUn.jpg"));
		btnBCU.setBounds(0, 0, 100, 100);
		panel_beaconU.add(btnBCU);

		JPanel panel_beaconE = new JPanel();
		panel_beaconE.setBounds(502, 0, 100, 100);
		add(panel_beaconE);
		panel_beaconE.setLayout(null);

		JButton btnBCE = new JButton("");
		btnBCE.setIcon(new ImageIcon("images\\beaconEn.jpg"));
		btnBCE.setBounds(0, 0, 100, 100);
		panel_beaconE.add(btnBCE);

		JPanel cen_panel = new JPanel();
		cen_panel.setBounds(500, 200, 100, 300);
		add(cen_panel);
		cen_panel.setLayout(null);

		JButton koreabtn = new JButton("");
		koreabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		koreabtn.setBounds(0, 0, 50, 50);
		cen_panel.add(koreabtn);
		koreabtn.setIcon(new ImageIcon("images\\korea.jpg"));

		JButton japanbtn = new JButton("");
		japanbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		japanbtn.setIcon(new ImageIcon("images\\japan.jpg"));
		japanbtn.setBounds(50, 0, 50, 50);
		cen_panel.add(japanbtn);

		JButton chinabtn = new JButton("");
		chinabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chinabtn.setIcon(new ImageIcon("images\\china.jpg"));
		chinabtn.setBounds(0, 50, 50, 50);
		cen_panel.add(chinabtn);

		JButton usabtn = new JButton("");
		usabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		usabtn.setIcon(new ImageIcon("images\\usa.jpg"));
		usabtn.setBounds(50, 50, 50, 50);
		cen_panel.add(usabtn);

		JButton canadabtn = new JButton("");
		canadabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		canadabtn.setIcon(new ImageIcon("images\\canada.jpg"));
		canadabtn.setBounds(0, 100, 50, 50);
		cen_panel.add(canadabtn);

		JButton ukbtn = new JButton("");
		ukbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ukbtn.setBounds(50, 100, 50, 50);
		cen_panel.add(ukbtn);
		ukbtn.setIcon(new ImageIcon("images\\uk.jpg"));

		JButton francebtn = new JButton("");
		francebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		francebtn.setIcon(new ImageIcon("images\\france.jpg"));
		francebtn.setBounds(0, 150, 50, 50);
		cen_panel.add(francebtn);

		JButton italybtn = new JButton("");
		italybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		italybtn.setIcon(new ImageIcon("images\\italy.jpg"));
		italybtn.setBounds(50, 150, 50, 50);
		cen_panel.add(italybtn);

		JButton brazilbtn = new JButton("");
		brazilbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		brazilbtn.setIcon(new ImageIcon("images\\brazil.jpg"));
		brazilbtn.setBounds(0, 200, 50, 50);
		cen_panel.add(brazilbtn);

		JButton spainbtn = new JButton("");
		spainbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		spainbtn.setIcon(new ImageIcon("images\\spain.jpg"));
		spainbtn.setBounds(50, 200, 50, 50);
		cen_panel.add(spainbtn);

		JButton egyptbtn = new JButton("");
		egyptbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		egyptbtn.setBounds(0, 250, 50, 50);
		cen_panel.add(egyptbtn);
		egyptbtn.setIcon(new ImageIcon("images\\egypt.jpg"));

		JButton russiabtn = new JButton("");
		russiabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		russiabtn.setIcon(new ImageIcon("images\\russia.jpg"));
		russiabtn.setBounds(50, 250, 50, 50);
		cen_panel.add(russiabtn);

		btnBCU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_beaconU.setVisible(false);
				panel_beaconE.setVisible(true);
				beacon.setState(true);

			}
		});
		btnBCE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_beaconU.setVisible(true);
				panel_beaconE.setVisible(false);
				beacon.setState(false);
			}
		});
		koreabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Asia/Seoul";

			}
		});
		japanbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Asia/Tokyo";

			}
		});
		chinabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Asia/Shanghai";

			}
		});

		usabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "America/Winnipeg";

			}
		});
		canadabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Canada/East-Saskatchewan";

			}
		});
		ukbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Europ/London";

			}
		});
		francebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Etc/GMT+2";

			}
		});
		italybtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Etc/GMT+2";

			}
		});
		brazilbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Brazil/East";

			}
		});
		spainbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Etc/GMT+2";

			}
		});
		egyptbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Etc/GMT+2";

			}
		});
		russiabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timeZoneStr = "Etc/GMT+3";

			}
		});

		tema.add(tema1);
		tema.add(tema2);
		tema.add(tema3);
		tema.add(tema4);
		mb.add(tema);

		this.setMenuBar(mb);
	}

	public void start() {

		tema1.addItemListener(this);
		tema2.addItemListener(this);
		tema3.addItemListener(this);
		tema4.addItemListener(this);

		beacon.addItemListener(this);

	}

	public void paint(Graphics g) {
		super.paint(g);

		Image memoryimage = createImage(500, 600);
		// 더블 버퍼링 기법을 위한 메모리상에 화면 사이즈만큼의 이미지 버퍼를 생성
		Graphics mgc = memoryimage.getGraphics();
		// 생성한 이미지 버퍼에 대한 그래픽스 객체를가져온다.

		mgc.clearRect(0, 25, 500, 500);
		mgc.drawImage(img, 0, 25, this);

		// g.drawImage(img, 0, 51, null);// 배경 이미지를 그린다.
		// g.drawImage(img, 0, 45, this);

		TimeZone tz;
		tz = TimeZone.getTimeZone(timeZoneStr);
		Date date = new Date();

		DateFormat se = new SimpleDateFormat("ss");
		DateFormat mi = new SimpleDateFormat("mm");
		DateFormat ho = new SimpleDateFormat("HH");
		se.setTimeZone(tz);
		mi.setTimeZone(tz);
		ho.setTimeZone(tz);

		int second = Integer.parseInt(se.format(date));
		int minute = Integer.parseInt(mi.format(date));
		int hour = Integer.parseInt(ho.format(date));// 타임존을 변경하여 시분초 변경부분
		System.out.println(second);

		int r = 150; // 반지름
		centerX = 250; // 중심점
		centerY = 275;
		Graphics2D g2 = (Graphics2D) mgc;
		g2.setStroke(new BasicStroke(5));
		sx = centerX + (int) ((r - 10) * Math.cos(Math.PI / 2 - second * (Math.PI / 30)));
		sy = centerY - (int) ((r - 10) * Math.sin(Math.PI / 2 - second * (Math.PI / 30)));
		mgc.setColor(Color.red);
		mgc.drawLine(centerX, centerY, sx, sy);// 초침을 그린다
		mx = centerX + (int) ((r - 30) * Math.cos(Math.PI / 2 - minute * (Math.PI / 30)));
		my = centerY - (int) ((r - 30) * Math.sin(Math.PI / 2 - minute * (Math.PI / 30)));
		mgc.setColor(Color.green);
		mgc.drawLine(centerX, centerY, mx, my);// 분침을 그린다
		hx = centerX + (int) ((r - 70) * Math.cos(Math.PI / 2 - ((hour * 60 + minute) / 10) * (Math.PI / 36)));
		hy = centerY - (int) ((r - 70) * Math.sin(Math.PI / 2 - ((hour * 60 + minute) / 10) * (Math.PI / 36)));
		mgc.setColor(Color.blue);
		mgc.drawLine(centerX, centerY, hx, hy);// 시침을 그린다.

		g.drawImage(memoryimage, 0, 25, this);

	}

	public void run() // 1초에 한번씩 paint메소드 호출
	{
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			repaint();
		}
	}

	public void itemStateChanged(ItemEvent e) {
// TODO Auto-generated method stub

		tema1.setState(false);
		tema2.setState(false);
		tema3.setState(false);
		tema4.setState(false);

		CheckboxMenuItem imsi = (CheckboxMenuItem) e.getSource();
		imsi.setState(true);

		if (tema1.getState()) {
			imgFile = new String("images/Clock1.jpg");
		} else if (tema2.getState()) {
			imgFile = new String("images/Clock2.jpg");

		} else if (tema3.getState()) {
			imgFile = new String("images/Clock3.jpg");
		} else if (tema4.getState()) {
			imgFile = new String("images/Clock4.jpg");
		} // 배경이미지 변경
		icon = new ImageIcon(imgFile);
		img = icon.getImage();// 메뉴 체크를 하면 배경 이미지 주소 바꾸는 부분
	}

	public static void main(String[] args) {
		AnalogueClock clock = new AnalogueClock();
		Thread t = new Thread(clock);
		t.start();// 스레드 처리

		// 스레드 하위클래스로부터 생성하는 방법
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					try {
						Calendar cal = Calendar.getInstance();
						int beaconH = cal.get(Calendar.HOUR_OF_DAY);
						int beaconM = cal.get(Calendar.MINUTE);
						int beaconS = cal.get(Calendar.SECOND);

						if (beacon.getState()) {
							if (((beaconH == 8) || (beaconH == 17)) && (beaconM == 50) && (beaconS == 0)) {
								JOptionPane.showMessageDialog(null, "비콘 출결 시간입니다.");
							}
						}
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t1.start();
	}
}