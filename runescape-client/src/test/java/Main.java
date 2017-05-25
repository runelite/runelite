
import java.io.IOException;
import javax.swing.JFrame;

public class Main extends JFrame
{
	private static final int WIDTH = 765;
	private static final int HEIGHT = 503;

	public Main() throws IOException
	{
		this.setSize(800, 600);
		Client client = new Client();

		ConfigLoader config = new ConfigLoader();
		config.fetch();

		client.setStub(new RSStub(config, client));

		this.add(client);

		client.setSize(WIDTH, HEIGHT);

		client.init();
		client.start();
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException
	{
		new Main();
	}
}
