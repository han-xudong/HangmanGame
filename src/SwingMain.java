import java.util.ArrayList;
import java.util.Random;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SwingMain {
    
	public void CreateJFrame() {
		JFrame jf = new JFrame("Game Loading..."); //实例化一个JFrame对象
		jf.setSize(700, 490);//大小
		jf.setLocationRelativeTo(null);//放在中间
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭方式
		
		
		
		try {
			//读取words.txt中单词并保存
			JPanel panel = new JPanel(null);
			JLabel j1 = new JLabel("Please input the absolute path of words.txt: ");
			Font font1 = new Font("Times New Roman", Font.ITALIC, 18);
			j1.setFont(font1);
			j1.setBounds(25, 100, 400, 20);
			j1.setVisible(true);
			panel.add(j1);
			
			//文本框及读取
			final JTextField textField1 = new JTextField(20);
			textField1.setText("words.txt");
			textField1.setBounds(25, 125, 400,20);
			textField1.setVisible(true);
			panel.add(textField1);
			
			//button 确认1
			final JButton enter1 = new JButton("enter");
			Font font2 = new Font("Times New Roman", Font.ITALIC, 12);
			enter1.setFont(font2);
			enter1.setBorderPainted(true);
			enter1.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					String path1 = textField1.getText();
					FileProcessing fileProcessing = new FileProcessing(path1); 
					WordMessage[] thelist = fileProcessing.getWordList().toArray(new WordMessage[fileProcessing.getWordList().size()]);
					Sorting sorting = new Sorting(thelist);
					WordMessage[] wordlist = sorting.getlist();
					wordLevel(wordlist);
					//按键变暗确认
					enter1.setEnabled(false);
				}
			});
			enter1.setBounds(440,125,65,20);
			enter1.setVisible(true);
			panel.add(enter1);
			
			
			JLabel j3 = new JLabel("Please input the absolute path of rankedWords.txt you want: ");
			j3.setFont(font1);
			j3.setBounds(25, 200, 500, 20);
			j3.setVisible(true);
			panel.add(j3);
			
			//文本框及读取
			final JTextField textField2 = new JTextField(20);
			textField2.setText("rankedWords.txt");
			textField2.setBounds(25, 225, 400,20);
			textField2.setVisible(true);
			panel.add(textField2);
			
			//jk2
			JFrame jf2 = new JFrame("Level-choosing...");
			jf2.setSize(450, 490);
			jf2.setLocationRelativeTo(null);
			jf2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
			//panel 2
			JPanel panel2 = new JPanel(null);
			jf2.setContentPane(panel2);
			final JButton bteasy = new JButton("Easy");
			final JButton btmedium = new JButton("Medium");
			final JButton bthard = new JButton("Hard");
			jf2.setContentPane(panel2);
			jf2.getContentPane().setBackground(Color.white);
			
			//button start
			final JButton btstart = new JButton("start");
			Font font3 = new Font("Times New Roman", Font.BOLD,16);
			btstart.setFont(font3);
			btstart.setBorderPainted(true);
			btstart.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					jf.setVisible(false);
					jf2.setVisible(true);
					panel2.setVisible(true);
					bteasy.setVisible(true);
					btmedium.setVisible(true);
					bthard.setVisible(true);
				}
			});
			btstart.setBounds(300,290,70,25);
			
			//button 确认2
			final JButton enter2 = new JButton("enter");
			enter2.setFont(font2);
			enter2.setBorderPainted(true);
			enter2.repaint();
			enter2.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					String path1 = textField1.getText();
					FileProcessing fileProcessing = new FileProcessing(path1); 
					WordMessage[] thelist = fileProcessing.getWordList().toArray(new WordMessage[fileProcessing.getWordList().size()]);
					Sorting sorting = new Sorting(thelist);
					WordMessage[] wordlist = sorting.getlist();
					wordLevel(wordlist);
					String wpath = textField2.getText();
					@SuppressWarnings("unused")
					FileWriting fileWriting = new FileWriting(wpath, wordlist);
					//弹出窗口确认
					enter2.setEnabled(false);
					btstart.setVisible(true);
					btstart.setEnabled(true);
					panel.add(btstart);
					panel.repaint();
				}
			});
			enter2.setBounds(440,225,65,20);
			enter2.setVisible(true);
			panel.add(enter2);
			
			
			//背景填色
			jf.setContentPane(panel);
			jf.getContentPane().setBackground(Color.white);
			
			//frame可视
			jf.setContentPane(panel);
			panel.setVisible(true);
			jf.setVisible(true); 
			
			
			
			//button easy操作
			bteasy.setFont(font3);
			bteasy.setBorderPainted(true);
			bteasy.setBounds(178,105,90,25);
			panel2.add(bteasy);
			bteasy.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					jf2.setVisible(false);
					
					String path1 = textField1.getText();
					FileProcessing fileProcessing = new FileProcessing(path1); 
					WordMessage[] thelist = fileProcessing.getWordList().toArray(new WordMessage[fileProcessing.getWordList().size()]);
					Sorting sorting = new Sorting(thelist);
					WordMessage[] wordlist = sorting.getlist();
					wordLevel(wordlist);
					String chosenlevel = "easy";
					SwingPlay(wordlist,chosenlevel);
				}
			});
				
			//button medium操作
			btmedium.setFont(new Font("Times New Roman", Font.BOLD,14));
			btmedium.setBorderPainted(true);
			btmedium.setBounds(178,205,90,25);
			panel2.add(btmedium);
			btmedium.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					jf2.setVisible(false);
					
					String path1 = textField1.getText();
					FileProcessing fileProcessing = new FileProcessing(path1); 
					WordMessage[] thelist = fileProcessing.getWordList().toArray(new WordMessage[fileProcessing.getWordList().size()]);
					Sorting sorting = new Sorting(thelist);
					WordMessage[] wordlist = sorting.getlist();
					String chosenlevel = "medium";
					wordLevel(wordlist);
					SwingPlay(wordlist,chosenlevel);
				}
			});
			
			//button hard操作
			bthard.setFont(font3);
			bthard.setBorderPainted(true);
			bthard.setBounds(178,305,90,25);
			panel2.add(bthard);
			bthard.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					jf2.setVisible(false);
					String path1 = textField1.getText();
					FileProcessing fileProcessing = new FileProcessing(path1); 
					WordMessage[] thelist = fileProcessing.getWordList().toArray(new WordMessage[fileProcessing.getWordList().size()]);
					Sorting sorting = new Sorting(thelist);
					WordMessage[] wordlist = sorting.getlist();
					wordLevel(wordlist);
					String chosenlevel = "hard";
					SwingPlay(wordlist,chosenlevel);
				}
			});	
		}catch (Exception e) {
					e.printStackTrace();
		} 
	}
			
	
	public static void wordLevel(WordMessage[] wordlist) {
		double ls = wordlist[0].getDifficultyScore();
		double hs = wordlist[wordlist.length - 1].getDifficultyScore();
		for(int i = 0 ; i < wordlist.length ; i++) {
			wordlist[i].setLevel(ls, hs);
		}
	}
	
	int life = 6;
	public int getLife() {
		return life;
	}
	public void setLife() {
		life--;
	}
	
	ArrayList<Character> inputChars = new ArrayList<Character>();
	public void setInputChars(Character c) {
		inputChars.add(c);
	}
	public ArrayList<Character> getInputChars(){
		return inputChars;
	}
	
	ArrayList<Character> wrongChars = new ArrayList<Character>();
	public void setWrongChars(Character c) {
		wrongChars.add(c);
	}
	public ArrayList<Character> getWrongChars(){
		return wrongChars;
	}
	
	
	
	//SwingPlay开始
	public void SwingPlay(WordMessage[] wordlist,String chosenlevel) {
		JFrame jf3 = new JFrame("Hangman");
		jf3.setSize(820, 490);
		jf3.setLocationRelativeTo(null);
		jf3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//窗口关闭方式可能会改动
		jf3.setVisible(true);
		JPanel panel3 = new JPanel(null);
		jf3.setContentPane(panel3);
		jf3.setContentPane(panel3);
		jf3.getContentPane().setBackground(Color.white);
		panel3.setVisible(true);
			
		//图片
		JLabel label1 = new JLabel();
		label1.setIcon(new ImageIcon("gengar.png"));
	    label1.setBounds(50, 15, 205, 400);
		label1.setVisible(true);
	    panel3.add(label1);
	        
	    //输入字母提示
	    JLabel label2 = new JLabel("Input a letter:");
	    Font font = new Font("Times New Roman", Font.BOLD, 18);
	    label2.setFont(font);
	    label2.setBounds(300, 260, 350, 165);
		label2.setVisible(true);
	    panel3.add(label2);
	        
	    //输入字母
	    JTextField textfield3 = new JTextField(6);
	    textfield3.setBounds(435,335,70,20);
	    textfield3.setVisible(true);
	    panel3.add(textfield3);
	        
	    //文本提示
	    JLabel label3 = new JLabel("Try your best to save the guy!");
	    label3.setFont(font);
	    label3.setBounds(299, 50, 350, 165);
		label3.setVisible(true);
	    panel3.add(label3);
	        
	    //显示word
	    JLabel label4 = new JLabel("The game word: ");
	    label4.setFont(font);
	    label4.setBounds(299, 90, 350, 165);
	    label4.setVisible(true);
	    panel3.add(label4);
	        
	    //显示错误  
	    JLabel label5 = new JLabel("All Misses: None for now");
	    label5.setFont(font);
	    label5.setBounds(299, 130, 350, 165);
		label5.setVisible(true);
	    panel3.add(label5);
	        
	    //显示剩余机会
	    JLabel label6 = new JLabel("You still have 6 chance(s)");
	    label6.setFont(font);
	    label6.setBounds(299, 170, 350, 165);
		label6.setVisible(true);
	    panel3.add(label6);
	        
	    //留给   结果
	    JLabel label7 = new JLabel("       H~E~L~P M~E");
	    label7.setFont(font);
	    label7.setBounds(299, 212, 550, 165);
	    label7.setVisible(true);
	    panel3.add(label7);
	        
	    //按钮
	    final JButton enter3 = new JButton("Enter");
		enter3.setFont(new Font("Times New Roman", Font.BOLD, 10));
		enter3.setBorderPainted(true);
		enter3.setBounds(520, 335, 60, 20);
		enter3.setVisible(true);
		panel3.add(enter3);
	        
			
		String theWord = getWord(chosenlevel,wordlist);
		System.out.print(theWord);
		char[] theChars = theWord.toCharArray();
		char[] empty = new char[theChars.length];
		String space = "";
		for(int i = 0 ; i < empty.length ; i++) {
			empty[i] = '_';
			space = space+" _";
		}
		label4.setText("The game word:" + space);
			
			
			
		//按键enter影响开始
		enter3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 while(true) {
						char[] charArray = new char[1];
						textfield3.getText().getChars(0, 1, charArray, 0);
						char c = charArray[0];
						boolean existInput = false;
						for(int i = 0 ; i < getInputChars().size() ; i++) {
							if(getInputChars().get(i).equals(c)) {
								existInput = true;
								label3.setText("You have already input this letter.");
								if(life == 0) {
									label6.setText("You have no chance now.");
									String sorry = "Sorry.Game Over. ";
									String right = "The right answer is " + theWord +".";
									label7.setText(sorry + right);
									label1.setIcon(new ImageIcon("gengarlose.png"));
									enter3.setEnabled(false);
									break;
								}
								break;
							}
						}
						if(!existInput) {
							setInputChars(c);
						}
						if(!existInput) {
							int wrong = 0;
							for(int i = 0 ; i < theChars.length ; i++) {
								if(c == theChars[i]) {
									empty[i] = c;
								}else {
									wrong++;
								}
							}
							if(wrong != theChars.length) {
					            //加入猜对后的显示
								label3.setText("Right guess!");
								String s1 = "";
								for(int i = 0 ; i < empty.length ; i++) {
										s1 = s1 +" "+empty[i];
								}
								label4.setText("The game word:"+s1);	
								int full = 0;
								for(int i = 0 ; i < empty.length ; i++) {
									if(empty[i] != '_') {
										full++;
									}
								}
								if(full == empty.length) {
									String congratulation = "Congratulations! You win the game \u263a";
									label7.setText(congratulation);
									label1.setIcon(new ImageIcon("gengarwin.png"));
									enter3.setEnabled(false);
									break;
								}
							}else {
								label3.setText("Wrong guess.");
								setWrongChars(c);
								String s2 = "";
								for(int i = 0 ; i < getWrongChars().size() ; i++) {
									s2 = s2 +" "+ getWrongChars().get(i);
								}
								label5.setText("All misses:" + s2);
								setLife();
								String chance = "You still have "+ getLife() +" chance(s)";
								label6.setText(chance);
								int layer = 7-getLife();
								String picture = "gengar"+layer+".png";
								label1.setIcon(new ImageIcon(picture));
								if(life == 0) {
									label6.setText("You have no chance now.");
									String sorry = "Sorry.Game Over. ";
									String right = "The right answer is " + theWord +".";
									label7.setText(sorry + right);
									label1.setIcon(new ImageIcon("gengarlose.png"));
									enter3.setEnabled(false);
									break;
								}
								break;
							}
						}else {
							String chance = "You still have "+ getLife() +" chance(s)";
							label6.setText(chance);
							if(life == 0) {
								label6.setText("You have no chance now.");
								String sorry = "Sorry.Game Over. ";
								String right = "The right answer is " + theWord +".";
								label7.setText(sorry + right);
								label1.setIcon(new ImageIcon("gengarlose.png"));
								enter3.setEnabled(false);
								break;
							}
							break;
						}		
					}
					textfield3.setText("");
					textfield3.requestFocusInWindow();
					//按键enter影响结束
				}
			});
			jf3.getRootPane().setDefaultButton(enter3);
		}
		
		public String getWord(String chosenlevel,WordMessage[] list) {
			ArrayList<WordMessage> easywords = new ArrayList<WordMessage>();
			ArrayList<WordMessage> mediumwords = new ArrayList<WordMessage>();
			ArrayList<WordMessage> hardwords = new ArrayList<WordMessage>();
			wordLevel(list);
			for(int i = 0 ; i < list.length ; i++) {
				if(list[i].getLevel().equals("easy")) {
					easywords.add(list[i]);
				}else if(list[i].getLevel().equals("medium")) {
					mediumwords.add(list[i]);
				}else if(list[i].getLevel().equals("hard")){
					hardwords.add(list[i]);
				}
			}
			Random random = new Random();
			if(chosenlevel.equals("easy")) {
				return easywords.get(random.nextInt(easywords.size())).getWord();
			}else if(chosenlevel.equals("medium")) {
				return mediumwords.get(random.nextInt(mediumwords.size())).getWord();
			}else {
				return hardwords.get(random.nextInt(hardwords.size())).getWord();
			}
			
		}

	//SwingPlay结束
	
	public static void main(String[] args) {
		new SwingMain().CreateJFrame();
		}

}
