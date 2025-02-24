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
import java.util.ArrayList;
import java.util.List;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.DragAndDropReorderPane;
import java.util.HashMap;
import java.util.Map;
import java.lang.Runnable;
import javax.swing.JComponent;

@Slf4j
@Singleton
public class RLBotStateViewer extends PluginPanel
{
    private final JTree tree;
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode rootNode;
    private final JTextField searchField;
    private Runnable refreshCallback;
    private final Map<String, Boolean> expansionState = new HashMap<>();
    private final Color HIGHLIGHT_COLOR = new Color(255, 255, 0, 100);
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
                
                if (c instanceof JComponent) {
                    JComponent jc = (JComponent) c;
                    if (!currentSearchText.isEmpty() && value.toString().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        jc.setBackground(HIGHLIGHT_COLOR);
                        jc.setOpaque(true);
                    } else {
                        jc.setBackground(null);
                        jc.setOpaque(false);
                    }
                }
                return c;
            }
        });
        
        // Add tree expansion listener to track expansion state
        tree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            @Override
            public void treeExpanded(javax.swing.event.TreeExpansionEvent event) {
                TreePath path = event.getPath();
                expansionState.put(getPathString(path), true);
            }

            @Override
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent event) {
                TreePath path = event.getPath();
                expansionState.put(getPathString(path), false);
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

    private String getPathString(TreePath path) {
        StringBuilder sb = new StringBuilder();
        Object[] pathElements = path.getPath();
        for (Object element : pathElements) {
            if (sb.length() > 0) {
                sb.append("/");
            }
            sb.append(element.toString());
        }
        return sb.toString();
    }

    public void setRefreshCallback(Runnable callback)
    {
        this.refreshCallback = callback;
    }

    public void updateState(JsonNode state)
    {
        if (state == null) return;

        SwingUtilities.invokeLater(() -> {
            // Save current expansion state
            saveExpansionState(rootNode, new TreePath(rootNode));

            // Clear the root node
            rootNode.removeAllChildren();

            // Get the interfaces array from state
            JsonNode interfaces = state.get("interfaces");
            if (interfaces != null && interfaces.isArray()) {
                // Process root widgets first
                for (JsonNode widget : interfaces) {
                    if (widget != null && widget.has("type")) {
                        String type = widget.get("type").asText();
                        if (type.equals("R")) { // Root widget
                            DefaultMutableTreeNode childNode = addWidget("R", widget);
                            if (childNode != null) {
                                rootNode.add(childNode);
                            }
                        }
                    }
                }
            }

            // Notify the tree model of the change
            treeModel.nodeStructureChanged(rootNode);

            // Restore expansion state and ensure interfaces are expanded
            restoreExpansionState(rootNode, new TreePath(rootNode));
            expandInterfaceNodes(rootNode, new TreePath(rootNode));
        });
    }

    private DefaultMutableTreeNode addWidget(String type, JsonNode widget) {
        if (widget == null) {
            return null;
        }

        // Create node with ID and type
        String nodeLabel = "[" + type + "] ";
        if (widget.has("id")) {
            nodeLabel += widget.get("id").asText();
        }
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(nodeLabel);

        // Add all properties as children
        widget.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();
            
            if (key.equals("children")) {
                if (value != null && value.isArray()) {
                    for (int i = 0; i < value.size(); i++) {
                        JsonNode child = value.get(i);
                        if (child != null) {
                            DefaultMutableTreeNode childNode = addWidget("D", child);
                            if (childNode != null) {
                                node.add(childNode);
                            }
                        }
                    }
                }
            } else if (key.equals("staticChildren")) {
                if (value != null && value.isArray()) {
                    for (int i = 0; i < value.size(); i++) {
                        JsonNode child = value.get(i);
                        if (child != null) {
                            DefaultMutableTreeNode childNode = addWidget("S", child);
                            if (childNode != null) {
                                node.add(childNode);
                            }
                        }
                    }
                }
            } else if (key.equals("nestedChildren")) {
                if (value != null && value.isArray()) {
                    for (int i = 0; i < value.size(); i++) {
                        JsonNode child = value.get(i);
                        if (child != null) {
                            DefaultMutableTreeNode childNode = addWidget("N", child);
                            if (childNode != null) {
                                node.add(childNode);
                            }
                        }
                    }
                }
            } else {
                // Add other properties as leaf nodes
                String valueStr = value.isNull() ? "null" : value.asText();
                node.add(new DefaultMutableTreeNode(key + ": " + valueStr));
            }
        });

        return node;
    }

    private void saveExpansionState(DefaultMutableTreeNode node, TreePath path) {
        if (tree.isExpanded(path)) {
            expansionState.put(getPathString(path), true);
        }
        
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            saveExpansionState(child, path.pathByAddingChild(child));
        }
    }

    private void restoreExpansionState(DefaultMutableTreeNode node, TreePath path) {
        Boolean expanded = expansionState.get(getPathString(path));
        if (expanded != null && expanded) {
            tree.expandPath(path);
        }
        
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            restoreExpansionState(child, path.pathByAddingChild(child));
        }
    }

    private void expandInterfaceNodes(DefaultMutableTreeNode node, TreePath path) {
        Object userObject = node.getUserObject();
        String nodeStr = userObject.toString();
        
        // Auto-expand interface-related nodes
        if (nodeStr.equals("interfaces") || 
            nodeStr.startsWith("[") || // Array indices
            (node.getParent() != null && isInterfaceAncestor((DefaultMutableTreeNode)node.getParent()))) {
            tree.expandPath(path);
            expansionState.put(getPathString(path), true);
        }
        
        // Recursively expand children
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            expandInterfaceNodes(child, path.pathByAddingChild(child));
        }
    }

    private boolean isInterfaceAncestor(DefaultMutableTreeNode node) {
        if (node == null) return false;
        String nodeStr = node.getUserObject().toString();
        if (nodeStr.equals("interfaces")) return true;
        if (node.getParent() != null) {
            return isInterfaceAncestor((DefaultMutableTreeNode)node.getParent());
        }
        return false;
    }

    private void performSearch() {
        currentSearchText = searchField.getText().trim();
        if (currentSearchText.isEmpty()) {
            // Reset all nodes to default state
            restoreExpansionState(rootNode, new TreePath(rootNode));
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