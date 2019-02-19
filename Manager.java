import gui.*;
import services.*;
import system.*;
import javax.swing.*;

import java.util.*;

public class Manager{

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Error: Manager <REST API URL>");
			return;
		}
		Manager manager = new Manager();
		Store store = new Store(args[0]);
		Cashier cashier = new Cashier();
		manager.startGui(store,cashier);
	}

	public void startGui(Store store,Cashier cashier){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    // handle exception
                }
                PostView post = new PostView(store.getItemList(),cashier);
                post.setResizable(false);
                post.setVisible(true);
            }
        });   
	}
}