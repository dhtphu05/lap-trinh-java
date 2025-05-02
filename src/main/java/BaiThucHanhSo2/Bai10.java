package BaiThucHanhSo2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai10 extends Frame {
    MenuBar menuBar;
    Menu fileMenu, editMenu;
    Menu submenu;
    MenuItem newItem, openItem, deleteItem, closeItem;
    MenuItem copyItem, cutItem, pasteItem, protectedItem;
    MenuItem firstItem, secondItem, thirdItem;
    public Bai10(){
        menuBar = new MenuBar();
        fileMenu = new Menu("File");
        editMenu = new Menu("Edit");
        submenu = new Menu("Option");

        newItem = new MenuItem("New");
        openItem = new MenuItem("Open");
        deleteItem = new MenuItem("Delete");
        closeItem = new MenuItem("Close");

        copyItem = new MenuItem("Copy");
        cutItem = new MenuItem("Cut");
        pasteItem = new MenuItem("Paste");
        protectedItem = new MenuItem("Protected");

        firstItem = new MenuItem("1st");
        secondItem = new MenuItem("2nd");
        thirdItem = new MenuItem("3rd");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(deleteItem);
        fileMenu.add(closeItem);

        submenu.add(firstItem);
        submenu.add(secondItem);
        submenu.add(thirdItem);

        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);
        editMenu.add(submenu);
        editMenu.add(protectedItem);

        setMenuBar(menuBar);

        setBounds(300, 300, 600, 400);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

    }
    public static void main(String[] args) {
        new Bai10();
    }
}
