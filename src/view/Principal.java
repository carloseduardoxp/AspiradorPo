package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Agente;
import modelo.Busca;
import modelo.BuscaLargura;
import modelo.BuscaProfundidade;
import modelo.StatusAmbiente;
import util.Observavel;

public class Principal extends javax.swing.JFrame implements ActionListener,Observavel {
	

	private static final long serialVersionUID = 1L;
	private JButton btnAlterar;
    private JButton btnExecutar;
    private ButtonGroup btnGroupRadio;
    private JLabel lblEstadoInicialX;
    private JLabel lblEstadoInicialY;
    private JLabel lblPosicoesX;
    private JLabel lblPosicoesY;
    private JPanel pnlParametros;
    private JRadioButton radioLargura;
    private JRadioButton radioProfundidade;
    private JScrollPane scrLog;
    private JTextField txtEstadoInicialX;
    private JTextField txtEstadoInicialY;
    private JTextArea txtLog;
    private JTextField txtPosicoesX;
    private JTextField txtPosicoesY;
    
    private JPanel pnlBotoes;
    
	private JButton[][] botoes;

    public Principal() {
    	super("Agente Aspirador de Pó");
        initComponents();
    }

    private void initComponents() {
    	pnlBotoes = new JPanel();
    	pnlBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGroupRadio = new javax.swing.ButtonGroup();
        pnlParametros = new javax.swing.JPanel();
        lblPosicoesX = new javax.swing.JLabel();
        txtPosicoesY = new javax.swing.JTextField();
        lblPosicoesY = new javax.swing.JLabel();
        txtEstadoInicialX = new javax.swing.JTextField();
        lblEstadoInicialX = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        txtPosicoesX = new javax.swing.JTextField();
        txtEstadoInicialY = new javax.swing.JTextField();
        lblEstadoInicialY = new javax.swing.JLabel();
        btnExecutar = new javax.swing.JButton();
        radioLargura = new javax.swing.JRadioButton();
        radioProfundidade = new javax.swing.JRadioButton();
        scrLog = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlParametros.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPosicoesX.setText("Posições X:");

        txtPosicoesY.setText("2");

        lblPosicoesY.setText("Posições Y:");

        txtEstadoInicialX.setText("0");

        lblEstadoInicialX.setText("Estado Inicial X:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txtPosicoesX.setText("2");

        txtEstadoInicialY.setText("0");

        lblEstadoInicialY.setText("Estado Inicial Y:");

        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        btnGroupRadio.add(radioLargura);
        radioLargura.setSelected(true);
        radioLargura.setText("Busca Largura");

        btnGroupRadio.add(radioProfundidade);
        radioProfundidade.setText("Busca Profundidade");

        javax.swing.GroupLayout pnlParametrosLayout = new javax.swing.GroupLayout(pnlParametros);
        pnlParametros.setLayout(pnlParametrosLayout);
        pnlParametrosLayout.setHorizontalGroup(
            pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParametrosLayout.createSequentialGroup()
                        .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoInicialX)
                            .addComponent(lblPosicoesX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPosicoesX, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadoInicialX, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlParametrosLayout.createSequentialGroup()
                        .addComponent(lblEstadoInicialY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstadoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParametrosLayout.createSequentialGroup()
                        .addComponent(lblPosicoesY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPosicoesY, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radioProfundidade)
                        .addComponent(radioLargura)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar)
                .addContainerGap())
            .addGroup(pnlParametrosLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnExecutar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlParametrosLayout.setVerticalGroup(
            pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParametrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosicoesX)
                    .addComponent(txtPosicoesY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosicoesY)
                    .addComponent(btnAlterar)
                    .addComponent(txtPosicoesX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParametrosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstadoInicialX)
                            .addComponent(txtEstadoInicialX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlParametrosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(radioLargura)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlParametrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioProfundidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnExecutar)
                .addContainerGap())
        );

        txtLog.setColumns(20);
        txtLog.setRows(5);
        txtLog.setText("Log\n");
        scrLog.setViewportView(txtLog);

        btnAlterarActionPerformed(null);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlParametros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrLog, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    private JPanel criarPanelBotoes() {
    	if (botoes != null) {
    		for (int i = 0; i < botoes.length;i++) {
            	for (int j = 0;j<botoes[i].length;j++) {
            		pnlBotoes.remove(botoes[i][j]);
            	}
        	}	
    	}        
    	Integer x = Integer.parseInt(txtPosicoesX.getText());
    	Integer y = Integer.parseInt(txtPosicoesY.getText());
    	botoes = new JButton[x][y];

        pnlBotoes.setLayout(new GridLayout(x, y));
        for (int i = 0; i < x;i++) {
        	for (int j = 0;j<y;j++) {
        		botoes[i][j] = new JButton(StatusAmbiente.SUJO.getCaractere()+"["+i+","+j+"]");        		
        		botoes[i][j].addActionListener(this);
        		pnlBotoes.add(botoes[i][j]);        		
        	}
        }
        return pnlBotoes;
	}
    
	@Override
    public void actionPerformed(ActionEvent be) {
    	String texto = be.getActionCommand();
    	if (texto.contains(",")) {
    		Integer x = getNumero(texto.split(",")[0]);
            Integer y = getNumero(texto.split(",")[1]);
            String caractere = texto.split("\\[")[0];
            if (StatusAmbiente.LIMPO.getCaractere().toString().equals(caractere)) {
            	botoes[x][y].setText(StatusAmbiente.SUJO.getCaractere()+"["+x+","+y+"]");
            } else {
            	botoes[x][y].setText(StatusAmbiente.LIMPO.getCaractere()+"["+x+","+y+"]");
            }	
    	}
        
    }
	
	private Integer getNumero(String string) {
		String numero = "";
		for (Character c: string.toCharArray()) {
			if (c >= '0' && c<= '9') {
				numero += c;
			}
		}
		return Integer.parseInt(numero);
	}

	private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {
		Integer xInicial = Integer.parseInt(txtEstadoInicialX.getText());
		Integer yInicial = Integer.parseInt(txtEstadoInicialY.getText());
		Busca busca;
		if (radioLargura.isSelected()) {
			busca = new BuscaLargura(this);
		} else {
			busca = new BuscaProfundidade(this);
		}		
		Integer posX = Integer.parseInt(txtPosicoesX.getText());
		Integer posY = Integer.parseInt(txtPosicoesY.getText());
		StatusAmbiente[][] status = new StatusAmbiente[posX][posY];
		for (int i = 0; i < posX;i++) {
			for (int j = 0;j < posY;j++) {
				Character c = botoes[i][j].getText().charAt(0);
				if (c == StatusAmbiente.LIMPO.getCaractere()) {
					status[i][j] = StatusAmbiente.LIMPO;	
				} else {
					status[i][j] = StatusAmbiente.SUJO;
				}
				 
			}
		}
		Agente agente = new Agente(xInicial,yInicial,busca,status,this,posX,posY);
		Thread thread = new Thread(agente);
		thread.start();
    }

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
    	criarPanelBotoes();
    	pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

	@Override
	public void notifica(String texto) {
		txtLog.append(texto+"\n");		
	}

	@Override
	public void notifica(StatusAmbiente s, Integer x, Integer y) {
		botoes[x][y].setText(s.getCaractere()+"["+x+","+y+"]");		
	}

}
