/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6461_t3_project1;

/**
 *
 * @author yiqian
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class ControlPanel extends JFrame{
   
   private JFrame frame;
   
   private JPanel panel_memory,panel_mfranddeposit,panel_deposit,panel_control,panel_consoletext,panel_clearbutton,panel_left,panel_Pc,panel_Mfr,panel_Ir,panel_lastline,panel_console,Registerset0,Registerset1,Registerset2,Registerset3,Index_Reg1_set,Index_Reg2_set,Index_Reg3_set,Mar_set,Mbr_set;
   
   private JLabel[] Cc,Mfr,Ir,Register1,Register2,Register3,Register0,Index_Reg1,Index_Reg2,Index_Reg3,Mar,Mbr;
   
   private JLabel label_Pc,label_Cc,label_Mfr,label_Ir,label_opcode,label_PC,label_CC, label_R1,label_R0,label_R2,label_R3,label_IX_R1,label_IX_R2,label_IX_R3,label_Mar,label_Mbr,label_Address;
   
   private JLabel label_Pc_val,label_Ir_val,label_R1_value,label_R0_value,label_R2_value,label_R3_value,label_CC_val, label_PC_val,label_opcode_val,
                    label_IX_R1_val,label_IX_R2_val,label_IX_R3_val,label_Mar_val,label_Mbr_val,label_Value;
   
   private JTextField text_Pc,text_Ir,text_R1,text_R0,text_R2,text_R3,text_IX_R1,text_IX_R2,text_IX_R3,text_Mar,text_Mbr,text_Address,text_Val;
   
   private JTextArea text_console;
   
   private JButton button_run,button_halt,button_deposit,button_singlestep,button_console,button_memory,button_IPL;
   private JLabel[] Pc;
   
   private String getTextPC, getTextR0, getTextR1, getTextR2, getTextR3, getTextX1, getTextX2, getTextX3, getTextMAR, getTextMBR, getTextIR;
   private String getKey;
   
   public String ConsoleString = "";
   
   public int PCstore;
   Memory mainMemorystore;
   
   boolean Single = false, Continue = true;
   

    private void initComponents(CPU cpu, Memory mainMemory, int CPU_PC, String CPU_R0, String CPU_R1, String CPU_R2, String CPU_R3, int CPU_X1, int CPU_X2, int CPU_X3, int CPU_MAR, String CPU_MBR, int CPU_MFR, String CPU_CC, String CPU_IR)
    {
        this.frame = new JFrame("part1");
        this.frame.setLayout(new BorderLayout(10,10));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocation(500,50);
        this.frame.setResizable(false);
        this.panel_left=new JPanel(new GridLayout(14,1));
        
        
        //PC
        this.panel_Pc=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Pc=new JLabel[20];
        this.label_Pc=new JLabel("PC");
        this.label_Pc.setPreferredSize(new Dimension(30,10));
        this.label_Pc_val=new JLabel("val");
        this.text_Pc=new JTextField();
        this.text_Pc.setPreferredSize(new Dimension(80,30));
             
        this.panel_Pc.add(this.label_Pc);
        for(int i=0; i<16;i++)
        {
            this.Pc[i]=new JLabel("");
            this.Pc[i].setPreferredSize(new Dimension(10,10));
            if(i<12)
            this.Pc[i].setOpaque(true);
            this.Pc[i].setBackground(Color.white);
        }

        for(int i=0;i<16;i++)
            this.panel_Pc.add(this.Pc[i]);       
        this.panel_Pc.add(this.label_Pc_val);
        this.panel_Pc.add(this.text_Pc);
        this.panel_left.add(this.panel_Pc);



        //Register 0 panel
        this.Registerset0=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Register0=new JLabel[20];
        this.label_R0=new JLabel("R0");
        this.label_R0.setPreferredSize(new Dimension(30,10));
        this.label_R0_value=new JLabel("val");
        this.text_R0=new JTextField();
        this.text_R0.setPreferredSize(new Dimension(80,30));
        //this.button_R0=new JButton("deposit");       
        this.Registerset0.add(this.label_R0);
        for(int i=0; i<16;i++)
        {
            this.Register0[i]=new JLabel("");
            this.Register0[i].setPreferredSize(new Dimension(10,10));
            this.Register0[i].setOpaque(true);
            this.Register0[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Registerset0.add(this.Register0[i]);       
        this.Registerset0.add(this.label_R0_value);
        this.Registerset0.add(this.text_R0);
        this.panel_left.add(this.Registerset0);





        // register1 panel
        this.Registerset1=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Register1=new JLabel[20];
        this.label_R1=new JLabel("R1");
        this.label_R1.setPreferredSize(new Dimension(30,10));
        this.label_R1_value=new JLabel("val");
        this.text_R1=new JTextField();
        this.text_R1.setPreferredSize(new Dimension(80,30));       
        this.Registerset1.add(this.label_R1);
        for(int i=0; i<16;i++)
        {
            this.Register1[i]=new JLabel("");
            this.Register1[i].setPreferredSize(new Dimension(10,10));
            this.Register1[i].setOpaque(true);
            this.Register1[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Registerset1.add(this.Register1[i]);       
        this.Registerset1.add(this.label_R1_value);
        this.Registerset1.add(this.text_R1);
        this.panel_left.add(this.Registerset1);


        //register2 panel
         
        this.Registerset2=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Register2=new JLabel[20];
        this.label_R2=new JLabel("R2");
        this.label_R2.setPreferredSize(new Dimension(30,10));
        this.label_R2_value=new JLabel("val");
        this.text_R2=new JTextField();
        this.text_R2.setPreferredSize(new Dimension(80,30));           
        this.Registerset2.add(this.label_R2);
        for(int i=0; i<16;i++)
        {
            this.Register2[i]=new JLabel("");
            this.Register2[i].setPreferredSize(new Dimension(10,10));
            this.Register2[i].setOpaque(true);
            this.Register2[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Registerset2.add(this.Register2[i]);       
        this.Registerset2.add(this.label_R2_value);
        this.Registerset2.add(this.text_R2);        
        this.panel_left.add(this.Registerset2);

        //register3 panel
        this.Registerset3=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Register3=new JLabel[20];
        this.label_R3=new JLabel("R3");
        this.label_R3.setPreferredSize(new Dimension(30,10));
        this.label_R3_value=new JLabel("val");
        this.text_R3=new JTextField();
        this.text_R3.setPreferredSize(new Dimension(80,30));              
        this.Registerset3.add(this.label_R3);
        for(int i=0; i<16;i++)
        {
            this.Register3[i]=new JLabel("");
            this.Register3[i].setPreferredSize(new Dimension(10,10));
            this.Register3[i].setOpaque(true);
            this.Register3[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Registerset3.add(this.Register3[i]);       
        this.Registerset3.add(this.label_R3_value);
        this.Registerset3.add(this.text_R3);       
        this.panel_left.add(this.Registerset3);

        //index register 1 panel
        this.Index_Reg1_set=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Index_Reg1=new JLabel[16];
        this.label_IX_R1=new JLabel("X1");
        this.label_IX_R1.setPreferredSize(new Dimension(30,10));
        this.label_IX_R1_val=new JLabel("val");
        this.text_IX_R1=new JTextField();
        this.text_IX_R1.setPreferredSize(new Dimension(80,30));               
        this.Index_Reg1_set.add(this.label_IX_R1);
        for(int i=0; i<16;i++)
        {
            this.Index_Reg1[i]=new JLabel("");
            this.Index_Reg1[i].setPreferredSize(new Dimension(10,10));
            this.Index_Reg1[i].setOpaque(true);
            this.Index_Reg1[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Index_Reg1_set.add(this.Index_Reg1[i]);       
        this.Index_Reg1_set.add(this.label_IX_R1_val);
        this.Index_Reg1_set.add(this.text_IX_R1);       
        this.panel_left.add(this.Index_Reg1_set);


        //index register 2 panel

        this.Index_Reg2_set=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Index_Reg2=new JLabel[16];
        this.label_IX_R2=new JLabel("X2");
        this.label_IX_R2.setPreferredSize(new Dimension(30,10));
        this.label_IX_R2_val=new JLabel("val");
        this.text_IX_R2=new JTextField();
        this.text_IX_R2.setPreferredSize(new Dimension(80,30));         
        this.Index_Reg2_set.add(this.label_IX_R2);
        for(int i=0; i<16;i++)
        {
            this.Index_Reg2[i]=new JLabel("");
            this.Index_Reg2[i].setPreferredSize(new Dimension(10,10));
            this.Index_Reg2[i].setOpaque(true);
            this.Index_Reg2[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Index_Reg2_set.add(this.Index_Reg2[i]);       
        this.Index_Reg2_set.add(this.label_IX_R2_val);
        this.Index_Reg2_set.add(this.text_IX_R2);        
        this.panel_left.add(this.Index_Reg2_set);

        //index register 3 panel
        this.Index_Reg3_set=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Index_Reg3=new JLabel[16];
        this.label_IX_R3=new JLabel("X3");
        this.label_IX_R3.setPreferredSize(new Dimension(30,10));
        this.label_IX_R3_val=new JLabel("val");
        this.text_IX_R3=new JTextField();
        this.text_IX_R3.setPreferredSize(new Dimension(80,30));              
        this.Index_Reg3_set.add(this.label_IX_R3);
        for(int i=0; i<16;i++)
        {
            this.Index_Reg3[i]=new JLabel("");
            this.Index_Reg3[i].setPreferredSize(new Dimension(10,10));
            this.Index_Reg3[i].setOpaque(true);
            this.Index_Reg3[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Index_Reg3_set.add(this.Index_Reg3[i]);       
        this.Index_Reg3_set.add(this.label_IX_R3_val);
        this.Index_Reg3_set.add(this.text_IX_R3);        
        this.panel_left.add(this.Index_Reg3_set);


        //MAR panel

        this.Mar_set=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Mar=new JLabel[20];
        this.label_Mar=new JLabel("MAR");
        this.label_Mar.setPreferredSize(new Dimension(30,10));
        this.label_Mar_val=new JLabel("val");
        this.text_Mar=new JTextField();
        this.text_Mar.setPreferredSize(new Dimension(80,30));
        this.Mar_set.add(label_Mar);
        for(int i=0; i<16;i++)
        {
            this.Mar[i]=new JLabel("");
            this.Mar[i].setPreferredSize(new Dimension(10,10));
            this.Mar[i].setOpaque(true);
            this.Mar[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Mar_set.add(this.Mar[i]);       
        this.Mar_set.add(this.label_Mar_val);
        this.Mar_set.add(this.text_Mar);
        this.panel_left.add(this.Mar_set);



        //MBR panel

        this.Mbr_set=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Mbr=new JLabel[20];
        this.label_Mbr=new JLabel("MBR");
        this.label_Mbr.setPreferredSize(new Dimension(30,10));
        this.label_Mbr_val=new JLabel("val");
        this.text_Mbr=new JTextField();
        this.text_Mbr.setPreferredSize(new Dimension(80,30));          
        this.Mbr_set.add(this.label_Mbr);
        for(int i=0; i<16;i++)
        {
            this.Mbr[i]=new JLabel("");
            this.Mbr[i].setPreferredSize(new Dimension(10,10));
            this.Mbr[i].setOpaque(true);
            this.Mbr[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.Mbr_set.add(this.Mbr[i]);       
        this.Mbr_set.add(this.label_Mbr_val);
        this.Mbr_set.add(this.text_Mbr);        
        this.panel_left.add(this.Mbr_set);

        
        

        //IR panel
        this.panel_Ir=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.Ir=new JLabel[20];
        this.label_Ir=new JLabel("IR");
        this.label_Ir.setPreferredSize(new Dimension(30,10));
        this.label_Ir_val=new JLabel("val");
        this.text_Ir=new JTextField();
        this.text_Ir.setPreferredSize(new Dimension(80,30));            
        this.panel_Ir.add(this.label_Ir);
        for(int i=0; i<16;i++)
        {
            this.Ir[i]=new JLabel("");
            this.Ir[i].setPreferredSize(new Dimension(10,10));
            this.Ir[i].setOpaque(true);
            this.Ir[i].setBackground(Color.white);
        }
        for(int i=0;i<16;i++)
            this.panel_Ir.add(this.Ir[i]);       
        this.panel_Ir.add(this.label_Ir_val);
        this.panel_Ir.add(this.text_Ir);        
        this.panel_left.add(this.panel_Ir);


        //MFR CC singlestep run and halt button  panel

        this.panel_Mfr=new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        this.panel_deposit=new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        this.panel_mfranddeposit=new JPanel(new BorderLayout());
        
        this.button_deposit=new JButton("Deposit");
        this.button_deposit.setPreferredSize(new Dimension(100, 50));
        this.Mfr=new JLabel[20];
        this.Cc=new JLabel[5];
        this.label_Cc=new JLabel("CC");
        this.label_Cc.setPreferredSize(new Dimension(20,10));
        this.label_Mfr=new JLabel("MFR");
        this.label_Mfr.setPreferredSize(new Dimension(30,10));    
        this.panel_Mfr.add(this.label_Mfr);
        
        for(int i=0; i<15;i++)
        {
            this.Mfr[i]=new JLabel("");
            this.Mfr[i].setPreferredSize(new Dimension(10,10));
            if(i<5)
            this.Mfr[i].setOpaque(true);
            this.Mfr[i].setBackground(Color.white);
        }
        for(int i=0;i<4;i++)
            this.panel_Mfr.add(this.Mfr[i]);   

        this.panel_Mfr.add(this.label_Cc);
        for(int i=0; i<4;i++)
        {
            this.Cc[i]=new JLabel("");
            this.Cc[i].setPreferredSize(new Dimension(10,10));
            this.Cc[i].setOpaque(true);
            this.Cc[i].setBackground(Color.white);
        }
        for(int i=0;i<4;i++)
            this.panel_Mfr.add(this.Cc[i]);         
        
        this.panel_deposit.add(this.button_deposit);
        this.button_deposit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextPC = text_Pc.getText();
                getTextR0 = text_R0.getText();
                getTextR1 = text_R1.getText();
                getTextR2 = text_R2.getText();
                getTextR3 = text_R3.getText();
                getTextX1 = text_IX_R1.getText();
                getTextX2 = text_IX_R2.getText();
                getTextX3 = text_IX_R3.getText();
                getTextMAR = text_Mar.getText();
                getTextMBR = text_Mbr.getText();
                getTextIR = text_Ir.getText();
                
                ShowNumberR(cpu, getTextR0, getTextR1, getTextR2, getTextR3, CPU_R0, CPU_R1, CPU_R2, CPU_R3, false);
                ShowNumberX(cpu, getTextX1, getTextX2, getTextX3, CPU_X1, CPU_X2, CPU_X3, false);
                ShowNumberO(cpu, getTextPC, getTextMAR, getTextMBR, getTextIR, CPU_PC, CPU_MAR, CPU_MBR, CPU_IR, false);
            }
        });
        this.panel_mfranddeposit.add(this.panel_Mfr,BorderLayout.CENTER);
        this.panel_mfranddeposit.add(this.panel_deposit,BorderLayout.EAST);      
        this.panel_left.add(this.panel_mfranddeposit);


       //panel memory
        this.panel_memory=new JPanel(null);
        this.panel_memory.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));       
        this.label_Address=new JLabel("Address:");
        this.text_Address=new JTextField();
        this.text_Address.setPreferredSize(new Dimension(80, 30));     
        this.label_Value=new JLabel("Value:");
        this.text_Val=new JTextField();
        this.text_Val.setPreferredSize(new Dimension(100, 30));
        this.button_memory=new JButton("Deposit / Search");
        this.button_memory.setPreferredSize(new Dimension(170, 50));
        this.panel_memory.add(this.label_Address);
        this.panel_memory.add(this.text_Address);
        this.panel_memory.add(this.label_Value);
        this.panel_memory.add(this.text_Val);
        this.panel_memory.add(this.button_memory);
        this.button_memory.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Mem");
                getKey = text_Address.getText();
                SearchINAddress(mainMemory, getKey);
            }
        });
        this.panel_memory.setPreferredSize(new Dimension(30, 1500));
        this.panel_left.add(this.panel_memory);



         //panel control by single step run halt
        this.panel_control=new JPanel(new FlowLayout(FlowLayout.RIGHT,30,10));
        this.button_IPL=new JButton("IPL");
        this.button_IPL.setBorder(BorderFactory.createRaisedBevelBorder());
        this.button_IPL.setBackground(Color.white);
        this.button_IPL.setPreferredSize(new Dimension(150, 50));
        this.button_singlestep=new JButton("Single");
        this.button_singlestep.setPreferredSize(new Dimension(100, 50));
        this.button_singlestep.setBackground(Color.yellow);
        this.button_run=new JButton("Run");
        this.button_run.setBackground(Color.green);
        this.button_run.setPreferredSize(new Dimension(100, 50));
        this.button_halt=new JButton("Halt");
        this.button_halt.setPreferredSize(new Dimension(100, 50));
        this.button_halt.setBackground(Color.red);

        
        this.panel_control.add(this.button_singlestep);
        this.panel_control.add(this.button_run);
        this.panel_control.add(this.button_halt);
        this.panel_control.add(this.button_IPL);
        this.panel_left.add(this.panel_control);
        
        this.button_singlestep.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sin");
                setSingle();
                SingleRun(cpu);
            }
        });
        
        this.button_run.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Run");
                Run(cpu);
            }
        });
        
        this.button_halt.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Halt");
                Halt();
            }
        });

        this.button_IPL.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("IPL");
                execute(cpu, mainMemory,6, true, false);
            }
        });


        //console  right part
        this.panel_console=new JPanel(new BorderLayout(10,20));
        this.text_console=new JTextArea();
        this.text_console.setPreferredSize(new Dimension(400, 700));
        this.button_console=new JButton("CLEAR");
        this.button_console.setPreferredSize(new Dimension(100, 35));
        this.panel_clearbutton=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.panel_consoletext=new JPanel(new BorderLayout(10,20));
        this.panel_consoletext.add(this.text_console,BorderLayout.CENTER);         
        this.panel_clearbutton.add(this.button_console);        
        this.panel_clearbutton.setPreferredSize(new Dimension(100, 50));        
        this.panel_console.add(this.panel_consoletext,BorderLayout.NORTH);            
        this.panel_console.add(this.panel_clearbutton,BorderLayout.SOUTH);
        this.text_console.setLineWrap(true);
        
        this.button_console.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clear");
                ConsoleString = "";
                text_console.setText("");
            }
        });
        
        //this.panel_left.add(this.panel_console);
        this.frame.add(panel_console,BorderLayout.EAST);
          
       
        //last line
        this.panel_lastline=new JPanel(new FlowLayout(FlowLayout.CENTER,25,10));
        this.label_opcode=new JLabel("OPCODE:");
        this.label_opcode_val=new JLabel("");
        this.label_PC=new JLabel("PC:");
        this.label_PC_val=new JLabel("");
        this.label_CC=new JLabel("CC:");
        this.label_CC_val=new JLabel("");
        this.panel_lastline.add(label_opcode);
        this.panel_lastline.add(label_opcode_val);
        this.panel_lastline.add(label_PC);
        this.panel_lastline.add(label_PC_val);
        this.panel_lastline.add(label_CC);
        this.panel_lastline.add(label_CC_val);
        this.panel_lastline.setPreferredSize(new Dimension(100, 50));
        this.panel_console.add(this.panel_lastline,BorderLayout.CENTER);

        
        this.panel_left.setPreferredSize(new Dimension(900, 900));
        
        //create borderline
        this.panel_left.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Rigester"));
        this.panel_console.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"User console"));
       
        
        
        
        this.frame.add(panel_left,BorderLayout.CENTER);
        this.frame.setVisible(true);
        this.frame.pack();
    } 


    
    public ControlPanel(CPU cpu, Memory mainMemory, int CPU_PC, String CPU_R0, String CPU_R1, String CPU_R2, String CPU_R3, int CPU_X1, int CPU_X2, int CPU_X3, int CPU_MAR, String CPU_MBR, int CPU_MFR, String CPU_CC, String CPU_IR)
    {
        initComponents(cpu, mainMemory, CPU_PC, CPU_R0, CPU_R1, CPU_R2, CPU_R3, CPU_X1, CPU_X2, CPU_X3, CPU_MAR, CPU_MBR, CPU_MFR, CPU_CC, CPU_IR);
    }
 
    public void execute(CPU cpu, Memory mainMemory, int memoryLocation, boolean Continue, boolean Single) {
        if(Continue){
            //initialize PC
            cpu.setPC(memoryLocation);
            if(mainMemory.getValue(cpu.getPC()) == null){
                return;
            }
            //put location from PC to MAR ,it needs 1 clock
            cpu.setMAR(cpu.getMAR());
            cpu.clock++;
            //MCU uses the address in the MAR to fetch a word from memory and place it in MBR
            cpu.setMBR(mainMemory.getValue(cpu.getMAR()));
            cpu.clock++;
            //The contents of MBR are moved to the IR. This takes 1 cycle.
            cpu.setIR(cpu.getMBR());
            cpu.clock++;
            System.out.println(cpu.getPC());
            System.out.println(cpu.getMAR());
            System.out.println(cpu.getMBR());
            System.out.println(cpu.getIR());
            ShowNumberR(cpu, cpu.getR0(),cpu.getR1(), cpu.getR2(), cpu.getR3(),"0", "0", "0", "0", true);
            ShowNumberX(cpu, "", "", "", cpu.getX1(),cpu.getX2(), cpu.getX3(), true);
            ShowNumberO(cpu, "", "", cpu.getMBR(), cpu.getIR(), cpu.getPC(), cpu.getMAR(), "0", "0", true);
            ShowNumberZ(cpu.getMFR(), cpu.getCC());    
            System.out.println(cpu.clock);
            
            //extract the opcode, R(registerSelect), IX, I, address from the IR.
            //we transfer long to int for saving space of memory,
            //instructions below show the transfer process: string of binary number -> long -> int
            cpu.opcode = Integer.parseInt(String.valueOf(Long.valueOf(cpu.getIR())/100000/100000),2);
            cpu.registerSelect = Integer.parseInt(String.valueOf(Long.valueOf(cpu.getIR())/100000000%100),2);
            cpu.IX = Integer.parseInt(String.valueOf(Long.valueOf(cpu.getIR())/1000000%100),2);
            cpu.I = Integer.parseInt(String.valueOf(Long.valueOf(cpu.getIR())/100000%10));
            cpu.address = Integer.parseInt(String.valueOf(Long.valueOf(cpu.getIR())%100000),2);
            cpu.clock++;
            //determine the class of opcode
            switch (cpu.opcode){
                case 1: cpu.LDR(mainMemory, cpu.registerSelect, cpu.IX, cpu.I, cpu.address);
                break;
                case 2: cpu.STR(mainMemory, cpu.registerSelect, cpu.IX, cpu.I, cpu.address);
                break;
                case 3: cpu.LDA(mainMemory, cpu.registerSelect, cpu.IX, cpu.I, cpu.address);
                break;
                case 41: cpu.LDX(mainMemory, cpu.IX, cpu.I, cpu.address);
                break;
                case 42: cpu.STX(mainMemory, cpu.IX, cpu.I, cpu.address);
                break;

            }
            cpu.setPC(cpu.getPC()+1);
            if(Single){
                Continue = false;
                PCstore = cpu.getPC();
                mainMemorystore = mainMemory;                
            }
            execute(cpu, mainMemory, cpu.getPC(), Continue, Single);
        }
        else{
            PCstore = cpu.getPC();
            mainMemorystore = mainMemory;
        }
        
    }
    
    
    public static void main(String[] args) {
        Memory mainMemory = new Memory();
        CPU cpu = new CPU();
        
        //put the instructions and required data into main memory
        cpu.setIndexRegister(2, 1000);//initialize index register
        cpu.setIndexRegister(1, 700);
        cpu.setIndexRegister(0, 500);
        cpu.setGeneralRegister(0, "");
        cpu.setGeneralRegister(1, "");
        cpu.setGeneralRegister(2, "");
        cpu.setGeneralRegister(3, "");
        cpu.setMBR("0");
        cpu.setIR("0");
        mainMemory.setValue(6, "0000011100011111");//store instruction LDR 3,0,31
        mainMemory.setValue(31, "1110011001101101");//store the required data to location 31
        mainMemory.setValue(7, "0000101101010101");//store instruction STR 3,0,21
        mainMemory.setValue(8, "0000111001010001");//store instruction LDA 2,0,17
        mainMemory.setValue(9, "1010010010001100");//store instruction LDX 2,12
        mainMemory.setValue(712, "0000001110011001");//store the required data to location 712
        mainMemory.setValue(10, "1010100001011001");//store instruction STX, 1, 25
        //put the instruction from memory to CPU and execute
        //cpu.execute(mainMemory,6);


        //GUI show        
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new ControlPanel(cpu, mainMemory, cpu.getPC(), cpu.getR0(), cpu.getR1(), cpu.getR2(), cpu.getR3(), cpu.getX1(), cpu.getX2(), cpu.getX3(), cpu.getMAR(), cpu.getMBR(), cpu.getMFR(), cpu.getCC(), cpu.getIR());
            }
        });


        //to do: GUI and ROM Loader program
    }
    
    public void Halt(){
        Continue = false;
    }
    
    public void Run(CPU cpu){
        Continue = true;
        Single = false;
        execute(cpu, mainMemorystore, PCstore, Continue, Single);
    }
    
    public void setSingle(){
        Single = true;
    }
    
    public void SingleRun(CPU cpu){
        Continue = true;
        execute(cpu, mainMemorystore, PCstore, Continue, Single);
    }
    
    private void ShowNumberO(CPU cpu, String TextPC, String TextMAR, String TextMBR, String TextIR, int CPU_PC, int CPU_MAR, String CPU_MBR, String CPU_IR, boolean showO){
        int NumPC, NumMAR, NumMBR, NumIR;
        //show PC
        if(!(TextPC.equals(""))){
            NumPC = Integer.parseInt(TextPC);
            if(NumPC>0 && NumPC<4096){
                NumPC = NumPC;
                cpu.setPC(NumPC);                
                ConsoleString = ConsoleString + "\r\nchange PC to "+TextPC;
                this.text_console.setText(ConsoleString);
            }
            else{
                NumPC = CPU_PC;
            }
        }
        else{
            NumPC = CPU_PC;
        }
        for(int i=11; i>=0; i--){
            if(NumPC%2==1){
                if(showO){this.Pc[i].setBackground(Color.blue);}
                else{this.Pc[i].setBackground(Color.red);}
            }
            else{
                this.Pc[i].setBackground(Color.white);
            }
            NumPC/=2;
        }
        
        //show MAR
        if(!(TextMAR.equals(""))){
            NumMAR = Integer.parseInt(TextMAR);
            if(NumMAR>0 && NumMAR<65536){
                NumMAR = NumMAR;
                cpu.setMAR(NumMAR);
            }
            else{
                NumMAR = CPU_MAR;
            }
        }
        else{
            NumMAR = CPU_MAR;
        }
        for(int i=15; i>=0; i--){
            if(NumMAR%2==1){
                if(showO){this.Mar[i].setBackground(Color.blue);}
                else{this.Mar[i].setBackground(Color.red);}
            }
            else{
                this.Mar[i].setBackground(Color.white);
            }
            NumMAR/=2;
        }
            
        //show MBR
        if(!(TextMAR.equals(""))){
            NumMBR = Integer.parseInt(TextMBR);
            if(NumMBR>0 && NumMBR<65536){
                NumMBR = NumMBR;
                cpu.setMBR(TextMBR);
            }
            else{
                NumMBR = Integer.parseInt(CPU_MBR);
            }
        }
        else{
            NumMBR = Integer.parseInt(CPU_MBR);
        }
        for(int i=15; i>=0; i--){
            if(NumMBR%2==1){
                if(showO){this.Mbr[i].setBackground(Color.blue);}
                else{this.Mbr[i].setBackground(Color.red);}
            }
            else{
                this.Mbr[i].setBackground(Color.white);
            }
            NumMBR/=2;
        }
        
        //show IR
        if(!(TextIR.equals(""))){
            NumIR = Integer.parseInt(TextIR);
            if(NumIR>0 && NumIR<65536){
                NumIR = NumIR;
                cpu.setIR(TextIR);
            }
            else{
                NumIR = Integer.parseInt(CPU_IR);
            }
        }
        else{
            NumIR = Integer.parseInt(CPU_IR);
        }
        for(int i=15; i>=0; i--){
            if(NumIR%2==1){
                if(showO){this.Ir[i].setBackground(Color.blue);}
                else{this.Ir[i].setBackground(Color.red);}
            }
            else{
                this.Ir[i].setBackground(Color.white);
            }
            NumIR/=2;
        }        

    }
    
    private void ShowNumberR(CPU cpu, String TextR0, String TextR1, String TextR2, String TextR3, String CPU_R0, String CPU_R1, String CPU_R2, String CPU_R3, boolean showR){
        int NumR0, NumR1, NumR2, NumR3;
        //show R0
        if(!(TextR0.equals(""))){
            NumR0 = Integer.parseInt(TextR0);
            if(NumR0>0 && NumR0<65536){
                NumR0 = NumR0;
                cpu.setGeneralRegister(0, TextR0);
            }
            else{
                NumR0 = Integer.parseInt(CPU_R0);
            }
        }
        else{
            NumR0 = Integer.parseInt(CPU_R0);
        }
        for(int i=15; i>=0; i--){
            if(NumR0%2==1){
                if(showR){this.Register0[i].setBackground(Color.blue);}
                else{this.Register0[i].setBackground(Color.red);}
            }
            else{
                this.Register0[i].setBackground(Color.white);
            }
            NumR0/=2;
        }
        
        //show R1
        if(!(TextR1.equals(""))){
            NumR1 = Integer.parseInt(TextR1);
            if(NumR1>0 && NumR1<65536){
                NumR1 = NumR1;
                cpu.setGeneralRegister(1, TextR1);
            }
            else{
                NumR1 = Integer.parseInt(CPU_R1);
            }
        }
        else{
            NumR1 = Integer.parseInt(CPU_R1);
        }
        for(int i=15; i>=0; i--){
            if(NumR1%2==1){
                if(showR){this.Register1[i].setBackground(Color.blue);}
                else{this.Register1[i].setBackground(Color.red);}
            }
            else{
                this.Register1[i].setBackground(Color.white);
            }
            NumR1/=2;
        }
        
        //show R2
        if(!(TextR2.equals(""))){
            NumR2 = Integer.parseInt(TextR2);
            if(NumR2>0 && NumR2<65536){
                NumR2 = NumR2;
                cpu.setGeneralRegister(1, TextR1);
            }
            else{
                NumR2 = Integer.parseInt(CPU_R2);
            }
        }
        else{
            NumR2 = Integer.parseInt(CPU_R2);
        }
        for(int i=15; i>=0; i--){
            if(NumR2%2==1){
                if(showR){this.Register2[i].setBackground(Color.blue);}
                else{this.Register2[i].setBackground(Color.red);}
            }
            else{
                this.Register2[i].setBackground(Color.white);
            }
            NumR2/=2;
        }
        
        //show R3
        if(!(TextR3.equals(""))){
            NumR3 = Integer.parseInt(TextR3);
            if(NumR3>0 && NumR3<65536){
                NumR3 = NumR3;
                cpu.setGeneralRegister(3, TextR3);
            }
            else{
                NumR3 = Integer.parseInt(CPU_R1);
            }
        }
        else{
            NumR3 = Integer.parseInt(CPU_R3);
        }
        for(int i=15; i>=0; i--){
            if(NumR3%2==1){
                if(showR){this.Register3[i].setBackground(Color.blue);}
                else{this.Register3[i].setBackground(Color.red);}
            }
            else{
                this.Register3[i].setBackground(Color.white);
            }
            NumR3/=2;
        }
        
    }
    
    private void ShowNumberX(CPU cpu, String TextX1, String TextX2, String TextX3, int CPU_X1, int CPU_X2, int CPU_X3, boolean showX){
        int NumX1, NumX2, NumX3;
        //show X1
        if(!(TextX1.equals(""))){
            NumX1 = Integer.parseInt(TextX1);
            if(NumX1>0 && NumX1<65536){
                NumX1 = NumX1;
                cpu.setIndexRegister(0, NumX1);
            }
            else{
                NumX1 = CPU_X1;
            }
        }
        else{
            NumX1 = CPU_X1;
        }
        for(int i=15; i>=0; i--){
            if(NumX1%2==1){
                if(showX){this.Index_Reg1[i].setBackground(Color.blue);}
                else{this.Index_Reg1[i].setBackground(Color.red);}
            }
            else{
                this.Index_Reg1[i].setBackground(Color.white);
            }
            NumX1/=2;
        }
        
        //show X2
        if(!(TextX2.equals(""))){
            NumX2 = Integer.parseInt(TextX2);
            if(NumX2>0 && NumX2<65536){
                NumX2 = NumX2;
                cpu.setIndexRegister(1, NumX2);
            }
            else{
                NumX2 = CPU_X2;
            }
        }
        else{
            NumX2 = CPU_X2;
        }
        for(int i=15; i>=0; i--){
            if(NumX2%2==1){
                if(showX){this.Index_Reg2[i].setBackground(Color.blue);}
                else{this.Index_Reg2[i].setBackground(Color.red);}
            }
            else{
                this.Index_Reg2[i].setBackground(Color.white);
            }
            NumX2/=2;
        }

        //show X3
        if(!(TextX3.equals(""))){
            NumX3 = Integer.parseInt(TextX3);
            if(NumX3>0 && NumX3<65536){
                NumX3 = NumX3;
                cpu.setIndexRegister(2, NumX3);
            }
            else{
                NumX3 = CPU_X3;
            }
        }
        else{
            NumX3 = CPU_X3;
        }
        for(int i=15; i>=0; i--){
            if(NumX3%2==1){
                if(showX){this.Index_Reg3[i].setBackground(Color.blue);}
                else{this.Index_Reg3[i].setBackground(Color.red);}
            }
            else{
                this.Index_Reg3[i].setBackground(Color.white);
            }
            NumX3/=2;
        }
        
    }
    
    private void ShowNumberZ(int CPU_MFR, String CPU_CC){
        int NumMFR, NumCC;
        //show MFR
        NumMFR = CPU_MFR;
        for(int i=3; i>=0; i--){
            if(NumMFR%2==1){
                this.Mfr[i].setBackground(Color.blue);
            }
            else{
                this.Mfr[i].setBackground(Color.white);                
            }
            NumMFR/=2;
        }
        
        //show CC
        NumCC = Integer.parseInt(CPU_CC);;
        for(int i=3; i>=0; i--){
            if(NumCC%2==1){
                this.Cc[i].setBackground(Color.blue);
            }
            else{
                this.Cc[i].setBackground(Color.white);                
            }
            NumCC/=2;
        }

    }
    
    private void SearchINAddress(Memory mainMemory, String keyIN){
        if(keyIN==""){
            this.text_Val.setText("");
        }
        else{
            int key = Integer.parseInt(keyIN);
            String result, result2;
            result = mainMemory.getValue(key);
            result2 = String.valueOf(Integer.parseInt(result, 2));
            this.text_Val.setText(result2);
        }
        
    }
    
    private void DepositINAddress(Memory mainMemory, String keyIN, String AddIN){       
        int key = Integer.parseInt(keyIN);
        int Address = Integer.parseInt(AddIN, 2);
        String Add = String.valueOf(Address);
        mainMemory.setValue(key, Add);
    }
    
}
