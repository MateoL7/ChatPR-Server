package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ChatWindow;

public class LauncherServer extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		ChatWindow chatWindow = new ChatWindow();
		chatWindow.show();
	}

}
