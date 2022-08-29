package src.simplejavatexteditor;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


    

class TextEditor  implements ActionListener {
  

    JFrame f;
    JMenuBar menuBar;
    JMenu file,
            edit,
            fonts,
            themes,
            help,
            find,
            about;

    JTextArea textArea;
    JScrollPane scroll;
    JMenuItem darkTheme,
            moonLightTheme,
            defaultTheme,
            save,
            open,
            close,
            print,
            cut,
            copy,
            paste,
            wordWrap,
            New,
            selectAll,
            videoHelp,
            documentHelp,
            quickFind,
            clearFile,
            aboutUs,
            aboutSoftware,
            bold,
            italic,
            fontSize;
    JPanel saveFileOptionWindow;
    JLabel fileLabel, dirLabel;
    JTextField fileName, dirName;

    TextEditor(){
        f = new JFrame("Untitled_1"); //setting the frame
        Image img = Toolkit.getDefaultToolkit().getImage("src\\com\\company\\logo.JPG"); //adding image
        f.setIconImage(img);
        menuBar = new JMenuBar();





    // setup icons - File Menu
         ImageIcon newIcon = new ImageIcon("icons/new.png");
         ImageIcon openIcon = new ImageIcon("icons/open.png");
         ImageIcon saveIcon = new ImageIcon("icons/save.png");
         ImageIcon closeIcon = new ImageIcon("icons/close.png");
         ImageIcon printIcon = new ImageIcon("icons/print.png");



    // setup icons - Edit Menu
         ImageIcon clearIcon = new ImageIcon("icons/clear.png");
         ImageIcon cutIcon = new ImageIcon("icons/cut.png");
         ImageIcon copyIcon = new ImageIcon("icons/copy.png");
         ImageIcon pasteIcon = new ImageIcon("icons/paste.png");
         ImageIcon selectAllIcon = new ImageIcon("icons/selectall.png");
         ImageIcon wordwrapIcon = new ImageIcon("icons/wordwrap.png");
         
    
    //setup icons - fonts
         ImageIcon boldIcon = new ImageIcon("icons/bold.png");
         ImageIcon italicIcon = new ImageIcon("icons/italic.png");
         ImageIcon font_Size = new ImageIcon("icons/font_size.png");
     

    // setup icons - Search Menu
         ImageIcon searchIcon = new ImageIcon("icons/search.png");

    // setup icons - About Menu
         ImageIcon aboutMeIcon = new ImageIcon("icons/about_me.png");
         ImageIcon aboutIcon = new ImageIcon("icons/about.png");

    // setup icons - Theme Menu
         ImageIcon darkIcon = new ImageIcon("icons/dark.png");
         ImageIcon moonlightIcon = new ImageIcon("icons/moonlight.png");
         ImageIcon defaultIcon = new ImageIcon("icons/default.png");






// -----------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------
        //menues
        file = new JMenu("File");
        edit = new JMenu("Edit");
        fonts= new JMenu("Fonts");
        themes = new JMenu("Themes");
        help = new JMenu("Help");
        find = new JMenu("Search");
        about = new JMenu("About");

        //adding menues to menubar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(fonts);
        menuBar.add(themes);
        menuBar.add(find);
        menuBar.add(about);

        f.setJMenuBar(menuBar);

        //adding submenus to file
        save = new JMenuItem("Save",saveIcon);
        open = new JMenuItem("Open",openIcon);       //file menu
        New = new JMenuItem("New",newIcon);
        close = new JMenuItem("Exit",closeIcon);
        print = new JMenuItem("Print",printIcon);
        file.add(open);
        file.add(New);
        file.add(save);
        file.add(close);
        file.add(print);
        //adding submenus to edit
        cut = new JMenuItem("Cut",cutIcon);
        copy = new JMenuItem("Copy",copyIcon);        //edit menu
        paste = new JMenuItem("Paste",pasteIcon);
        selectAll = new JMenuItem("Select all",selectAllIcon);
        clearFile = new JMenuItem("Clear", clearIcon);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(clearFile);

        //adding submenus to fonts
        bold = new JMenuItem("Bold",boldIcon);
        italic = new JMenuItem("Italic",italicIcon);
        fontSize = new JMenuItem("Font size",font_Size);
        wordWrap = new JMenuItem("Word-Wrap",wordwrapIcon);

        fonts.add(bold);
        fonts.add(italic);
        fonts.add(fontSize);
        fonts.add(wordWrap);





        //adding submenus to find
        quickFind = new JMenuItem("Quick", searchIcon);
        find.add(quickFind);

        //adding submenus to about
        aboutUs = new JMenuItem("About Us", aboutMeIcon);
        aboutSoftware = new JMenuItem("About Software", aboutIcon);  
        about.add(aboutUs);
        about.add(aboutSoftware);


        //adding themes
        darkTheme = new JMenuItem("Dark Theme",darkIcon);
        moonLightTheme = new JMenuItem("Moonlight Theme",moonlightIcon);
        defaultTheme = new JMenuItem("Default Theme",defaultIcon);
        themes.add(darkTheme);
        themes.add(moonLightTheme);
        themes.add(defaultTheme);

        //help menu
        videoHelp = new JMenuItem("Video Reference");
        documentHelp = new JMenuItem("Documentation");
        help.add(videoHelp);
        help.add(documentHelp);

        //Textarea
        textArea = new JTextArea(32,88);
        f.add(textArea);

        //scrollpane
        scroll = new JScrollPane(textArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        f.add(scroll);

        //adding event listeners for cut , copy & paste
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        fontSize.addActionListener(this); //change the font size
        open.addActionListener(this); //open the file
        save.addActionListener(this); //Save the file
        New.addActionListener(this); //Create the new document
        darkTheme.addActionListener(this); //dark theme
        moonLightTheme.addActionListener(this); //moonlight theme
        defaultTheme.addActionListener(this); // default theme
        videoHelp.addActionListener(this); //video help option
        documentHelp.addActionListener(this); //document help option
        close.addActionListener(this); //close the window
        clearFile.addActionListener(this);// Clear File (Code)
        quickFind.addActionListener(this);
        bold.addActionListener(this);
        italic.addActionListener(this);
        print.addActionListener(this);
        // wordWrap.addActionListener(this);

    wordWrap.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        // If wrapping is false then after clicking on menuitem the word wrapping will be enabled
        /* Setting word wrapping to true */
        // else  if wrapping is true then after clicking on menuitem the word wrapping will be disabled
        /* Setting word wrapping to false */
        textArea.setLineWrap(!textArea.getLineWrap());
    }
    });

       
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {}

            @Override
            public void windowClosing(WindowEvent e) {
                int confirmExit = JOptionPane.showConfirmDialog(f,"Do you want to exit?","Confirm Before Saving...",JOptionPane.YES_NO_OPTION);

                if (confirmExit == JOptionPane.YES_OPTION)
                    f.dispose();
                else if (confirmExit == JOptionPane.NO_OPTION)
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {}

            @Override
            public void windowIconified(WindowEvent windowEvent) {}

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {}

            @Override
            public void windowActivated(WindowEvent windowEvent) {}

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {}
        });

        //Keyboard Listeners
        KeyListener k = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_S && e.isControlDown())
                    saveTheFile(); //Saving the file
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        };
        textArea.addKeyListener(k);

        //Default Operations for frame
        f.setSize(1000,596);
        f.setResizable(false);
        f.setLocation(250,100);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Copy paste operations
        if (e.getSource()==cut)
            textArea.cut();
        if (e.getSource()==copy)
            textArea.copy();
        if (e.getSource()==paste)
            textArea.paste();
        if (e.getSource()==selectAll)
            textArea.selectAll();

        //change the fontsize by value
        if (e.getSource()==fontSize){

            String sizeOfFont = JOptionPane.showInputDialog(f,"Enter Font Size",JOptionPane.OK_CANCEL_OPTION);
                if (sizeOfFont != null){
                    int convertSizeOfFont = Integer.parseInt(sizeOfFont);
                    Font font = new Font(Font.SANS_SERIF,Font.PLAIN,convertSizeOfFont);
                    textArea.setFont(font);
                }
        }
            // ----------------------------------------------------------------
         if (e.getSource()==aboutUs){

            String sizeOfFont = JOptionPane.showInputDialog(f,"Enter Font Size",JOptionPane.OK_CANCEL_OPTION);
                if (sizeOfFont != null){
                     int convertSizeOfFont = Integer.parseInt(sizeOfFont);
                     Font font = new Font(Font.SANS_SERIF,Font.PLAIN,convertSizeOfFont);
                     textArea.setFont(font);
                }
        }
    

        // -----------------------------------------------------------------
        //Open the file
        if (e.getSource()==open){
            JFileChooser chooseFile = new JFileChooser();
            int i = chooseFile.showOpenDialog(f);
            if (i == JFileChooser.APPROVE_OPTION){
                File file = chooseFile.getSelectedFile(); //select the file
                String filePath = file.getPath(); //get the file path
                String fileNameToShow = file.getName(); //get the file name
                f.setTitle(fileNameToShow);

               try {
                   BufferedReader readFile = new BufferedReader(new FileReader(filePath));
                   String tempString1 = "";
                   String tempString2 = "";

                   while ((tempString1 = readFile.readLine()) != null)
                        tempString2 += tempString1 + "\n";

                   textArea.setText(tempString2);
                   readFile.close();
               }catch (Exception ae){
                   ae.printStackTrace();
               }
            }
        }


        //Save the file
        if (e.getSource()==save) saveTheFile();


        //New menu operations
        if (e.getSource()==New) textArea.setText("");


        //Exit from the window
        if (e.getSource()==close) System.exit(1);


        // // Clear File (Code)
        if (e.getSource() == clearFile) textArea.setText("");


        if (e.getSource() == quickFind) {
            new Find(textArea);
        } // About Me
        // if (e.getSource() == aboutMe)  // About Software
        // if (e.getSource() == aboutSoftware)         

        // If the source of the event was the "Bold" button
        else if (e.getSource() == bold) {
            if (textArea.getFont().getStyle() == Font.BOLD) {
                textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
            } else {
                textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));
            }
        }
        // If the source of the event was the "Italic" button
        if (e.getSource() == italic) {
            if (textArea.getFont().getStyle() == Font.ITALIC) {
                textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
            } else {
                textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC));
            }
        }

    
        else if (e.getSource()==print){
            try {
                // print the file
                textArea.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(f, evt.getMessage());
            }
        }

        //themes area
        if (e.getSource()==darkTheme){
            textArea.setBackground(Color.DARK_GRAY);        //dark Theme
            textArea.setForeground(Color.WHITE);
        }

        if (e.getSource()==moonLightTheme){
            textArea.setBackground(new Color(107, 169, 255));
            textArea.setForeground(Color.black);
        }

        if (e.getSource() == defaultTheme){
            textArea.setBackground(new Color(255, 255, 255));
            textArea.setForeground(Color.black);
        }

        

        
    }

//Save the file
    public void saveTheFile(){
        saveFileOptionWindow = new JPanel(new GridLayout(2,1));
        fileLabel = new JLabel("Filename      :- ");
        dirLabel = new JLabel("Save File To :- ");
        fileName = new JTextField();
        dirName = new JTextField();

        saveFileOptionWindow.add(fileLabel);
        saveFileOptionWindow.add(fileName);
        saveFileOptionWindow.add(dirLabel);
        saveFileOptionWindow.add(dirName);

        JOptionPane.showMessageDialog(f,saveFileOptionWindow); //show the saving dialogue box
        String fileContent = textArea.getText();
        String filePath = dirName.getText();

        try {
            BufferedWriter writeContent = new BufferedWriter(new FileWriter(filePath));
            writeContent.write(fileContent);
            writeContent.close();
            JOptionPane.showMessageDialog(f,"File Successfully saved!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
