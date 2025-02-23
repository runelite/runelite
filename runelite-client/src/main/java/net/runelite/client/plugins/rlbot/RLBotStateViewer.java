package net.runelite.client.plugins.rlbot;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Iterator;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.DragAndDropReorderPane;

@Slf4j
@Singleton
public class RLBotStateViewer extends PluginPanel
{
    private final JTree stateTree;
    private DefaultMutableTreeNode root;
    private final JButton refreshButton;

    @Inject
    private RLBotStateViewer()
    {
        super(false);
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Initialize the tree with a root node
        root = new DefaultMutableTreeNode("Game State");
        stateTree = new JTree(root);
        stateTree.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        stateTree.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        stateTree.setRootVisible(true);
        stateTree.setShowsRootHandles(true);

        // Add tree to a scroll pane
        final JScrollPane treeScrollPane = new JScrollPane(stateTree);
        treeScrollPane.setPreferredSize(new Dimension(400, 400));
        treeScrollPane.setBackground(ColorScheme.DARK_GRAY_COLOR);
        add(treeScrollPane, BorderLayout.CENTER);

        // Create bottom panel for refresh button
        final JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize refresh button
        refreshButton = new JButton("Refresh State");
        refreshButton.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        refreshButton.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        bottomPanel.add(refreshButton);
    }

    private DefaultMutableTreeNode addJsonNode(String name, JsonNode node)
    {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(name);

        if (node.isObject())
        {
            Iterator<String> fieldNames = node.fieldNames();
            while (fieldNames.hasNext())
            {
                String fieldName = fieldNames.next();
                JsonNode childNode = node.get(fieldName);
                DefaultMutableTreeNode childTreeNode = addJsonNode(fieldName, childNode);
                if (childTreeNode != null)
                {
                    treeNode.add(childTreeNode);
                }
            }
        }
        else if (node.isArray())
        {
            int index = 0;
            for (JsonNode element : node)
            {
                DefaultMutableTreeNode childTreeNode = addJsonNode("[" + index + "]", element);
                if (childTreeNode != null)
                {
                    treeNode.add(childTreeNode);
                }
                index++;
            }
        }
        else
        {
            // For primitive values, append the value to the node name
            String value = node.asText();
            if (value != null && !value.isEmpty())
            {
                return new DefaultMutableTreeNode(name + ": " + value);
            }
        }

        return treeNode;
    }

    public void updateState(JsonNode state)
    {
        SwingUtilities.invokeLater(() ->
        {
            try
            {
                // Create new root node
                root = new DefaultMutableTreeNode("Game State");

                if (state != null)
                {
                    // Add all state nodes
                    Iterator<String> fieldNames = state.fieldNames();
                    while (fieldNames.hasNext())
                    {
                        String fieldName = fieldNames.next();
                        JsonNode fieldValue = state.get(fieldName);
                        DefaultMutableTreeNode node = addJsonNode(fieldName, fieldValue);
                        if (node != null)
                        {
                            root.add(node);
                        }
                    }
                }

                // Update tree model
                stateTree.setModel(new DefaultTreeModel(root));

                // Expand root node
                stateTree.expandPath(new TreePath(root.getPath()));

                // Repaint tree
                stateTree.repaint();
            }
            catch (Exception e)
            {
                log.error("Error updating state viewer", e);
            }
        });
    }

    public void setRefreshCallback(Runnable callback)
    {
        refreshButton.addActionListener(e -> callback.run());
    }
} 