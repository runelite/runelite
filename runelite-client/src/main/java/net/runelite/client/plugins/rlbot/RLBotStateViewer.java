package net.runelite.client.plugins.rlbot;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Component;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Iterator;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

@Slf4j
@Singleton
public class RLBotStateViewer extends PluginPanel
{
    private final JTree tree;
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode rootNode;
    private final JTextField searchField;
    private Runnable refreshCallback;
    private String currentSearchText = "";

    @Inject
    private RLBotStateViewer()
    {
        super(false);
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Create search panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        searchField = new JTextField();
        searchField.setBackground(ColorScheme.DARKER_GRAY_COLOR.brighter());
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchPanel.add(searchField, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);

        // Add search listener
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
        });

        rootNode = new DefaultMutableTreeNode("Game State");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        
        // Custom cell renderer for search highlighting
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value,
                    boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                
                if (c instanceof JComponent && !currentSearchText.isEmpty()) {
                    JComponent jc = (JComponent) c;
                    if (value.toString().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        jc.setBackground(new Color(255, 255, 0, 100));
                        jc.setOpaque(true);
                    } else {
                        jc.setBackground(null);
                        jc.setOpaque(false);
                    }
                }
                return c;
            }
        });

        // Add tree to a scroll pane
        final JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setPreferredSize(new Dimension(400, 400));
        treeScrollPane.setBackground(ColorScheme.DARK_GRAY_COLOR);
        add(treeScrollPane, BorderLayout.CENTER);

        // Create bottom panel for refresh button
        final JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize refresh button
        final JButton refreshButton = new JButton("Refresh");
        refreshButton.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        refreshButton.setForeground(ColorScheme.LIGHT_GRAY_COLOR);
        bottomPanel.add(refreshButton);

        // Set refresh callback
        refreshButton.addActionListener(e -> {
            if (refreshCallback != null) {
                refreshCallback.run();
            }
        });
    }

    public void setRefreshCallback(Runnable callback)
    {
        this.refreshCallback = callback;
    }

    public void updateState(JsonNode state)
    {
        if (state == null) return;

        SwingUtilities.invokeLater(() -> {
            // Clear the root node
            rootNode.removeAllChildren();

            // Process each top-level field in the state
            state.fields().forEachRemaining(entry -> {
                String key = entry.getKey();
                JsonNode value = entry.getValue();
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(key);
                addJsonNode(node, value);
                rootNode.add(node);
            });

            // Notify the tree model of the change
            treeModel.nodeStructureChanged(rootNode);
            
            // Expand root node by default
            tree.expandPath(new TreePath(rootNode.getPath()));
        });
    }

    private void addJsonNode(DefaultMutableTreeNode parent, JsonNode jsonNode) {
        if (jsonNode.isObject()) {
            jsonNode.fields().forEachRemaining(entry -> {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(entry.getKey());
                addJsonNode(node, entry.getValue());
                parent.add(node);
            });
        }
        else if (jsonNode.isArray()) {
            int index = 0;
            for (JsonNode element : jsonNode) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("[" + index + "]");
                addJsonNode(node, element);
                parent.add(node);
                index++;
            }
        }
        else {
            parent.add(new DefaultMutableTreeNode(jsonNode.asText()));
        }
    }

    private void performSearch() {
        currentSearchText = searchField.getText().trim();
        if (currentSearchText.isEmpty()) {
            // Just collapse all nodes except root
            for (int i = tree.getRowCount() - 1; i > 0; i--) {
                tree.collapseRow(i);
            }
        } else {
            // Expand paths to matching nodes and collapse others
            expandMatchingNodes(rootNode, new TreePath(rootNode));
        }
        tree.repaint();
    }

    private boolean expandMatchingNodes(DefaultMutableTreeNode node, TreePath path) {
        boolean containsMatch = false;
        
        // Check if current node matches
        if (node.getUserObject().toString().toLowerCase().contains(currentSearchText.toLowerCase())) {
            containsMatch = true;
        }
        
        // Check children
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            TreePath childPath = path.pathByAddingChild(child);
            if (expandMatchingNodes(child, childPath)) {
                containsMatch = true;
            }
        }
        
        // Expand path if this node or any children contain a match
        if (containsMatch) {
            tree.expandPath(path);
        }
        
        return containsMatch;
    }
} 