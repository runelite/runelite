package net.runelite.client.plugins.openosrs.externals;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.events.ExternalRepositoryChanged;
import net.runelite.client.plugins.ExternalPluginManager;
import net.runelite.client.ui.ColorScheme;
import org.pf4j.update.UpdateRepository;

public class RepositoryPanel extends JPanel
{
	private final ExternalPluginManager externalPluginManager;

	private final GridBagConstraints c = new GridBagConstraints();

	RepositoryPanel(ExternalPluginManager externalPluginManager, EventBus eventBus)
	{
		this.externalPluginManager = externalPluginManager;

		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setBorder(new EmptyBorder(0, 10, 0, 10));

		createPanel();

		eventBus.subscribe(ExternalRepositoryChanged.class, this, (e) -> createPanel());
	}

	private void createPanel()
	{
		removeAll();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridy = 0;
		c.insets = new Insets(5, 0, 0, 0);

		for (UpdateRepository repository : externalPluginManager.getRepositories())
		{
			final RepositoryBox p = new RepositoryBox(externalPluginManager, repository);
			add(p, c);
			c.gridy++;
		}
	}
}
