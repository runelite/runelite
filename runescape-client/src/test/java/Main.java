
import java.io.IOException;
import javax.swing.JFrame;

public class Main extends JFrame
{
	public Main() throws IOException
	{
		this.setSize(800, 600);
		Client client = new Client();
		ConfigLoader config = new ConfigLoader();
		config.fetch();
		client.setStub(new RSStub(config, client));
		this.add(client);
		client.init();
		client.start();
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException
	{
		new Main();
	}
}
