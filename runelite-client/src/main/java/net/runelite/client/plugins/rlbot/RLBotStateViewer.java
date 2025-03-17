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
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JProgressBar;
import java.awt.Component;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Iterator;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Timer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import net.runelite.client.RuneLite;

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
    
    // Store the last generated state so we can refresh if no callback is set
    private JsonNode lastState;
    
    // Path tracking - improve this for better expansion state tracking
    private final Map<DefaultMutableTreeNode, String> nodeToPathMap = new WeakHashMap<>();
    private final Set<String> expandedPaths = new HashSet<>();
    private boolean allowExpansionEvents = true;
    
    // Search-related fields
    private final List<TreePath> searchResults = new ArrayList<>();
    private int currentSearchResultIndex = -1;
    private JLabel searchStatusLabel;
    private JButton prevButton;
    private JButton nextButton;
    private SwingWorker<List<TreePath>, Void> searchWorker;
    private final Map<TreePath, String> searchMatchTexts = new ConcurrentHashMap<>();
    private JProgressBar searchProgressBar;
    private AtomicInteger nodesChecked = new AtomicInteger(0);
    private int totalNodeCount = 0;

    // Tree event handling fields
    private boolean isUpdatingTree = false;

    @Inject
    private RLBotStateViewer()
    {
        super(false);
        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Create search panel with navigation controls
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        
        // Top row: search field and status
        JPanel searchInputPanel = new JPanel(new BorderLayout());
        searchInputPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        
        searchField = new JTextField();
        searchField.setBackground(ColorScheme.DARKER_GRAY_COLOR.brighter());
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setToolTipText("Search for any text in the game state");
        searchInputPanel.add(searchField, BorderLayout.CENTER);
        
        searchStatusLabel = new JLabel("");
        searchStatusLabel.setForeground(Color.LIGHT_GRAY);
        searchInputPanel.add(searchStatusLabel, BorderLayout.EAST);
        
        // Middle row: progress bar for search
        searchProgressBar = new JProgressBar(0, 100);
        searchProgressBar.setStringPainted(true);
        searchProgressBar.setString("Ready");
        searchProgressBar.setVisible(false);
        
        // Bottom row: navigation buttons
        JPanel searchNavPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchNavPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        
        prevButton = new JButton("◀");
        prevButton.setToolTipText("Previous match (Up arrow)");
        prevButton.setEnabled(false);
        prevButton.addActionListener(e -> navigateSearchResults(false));
        
        nextButton = new JButton("▶");
        nextButton.setToolTipText("Next match (Down arrow)");
        nextButton.setEnabled(false);
        nextButton.addActionListener(e -> navigateSearchResults(true));
        
        // Add clear button
        JButton clearButton = new JButton("✕");
        clearButton.setToolTipText("Clear search");
        clearButton.addActionListener(e -> {
            searchField.setText("");
            performSearch();
        });
        
        searchNavPanel.add(prevButton);
        searchNavPanel.add(nextButton);
        searchNavPanel.add(clearButton);
        
        searchPanel.add(searchInputPanel);
        searchPanel.add(searchProgressBar);
        searchPanel.add(searchNavPanel);
        
        add(searchPanel, BorderLayout.NORTH);

        // Add keyboard navigation for search results
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    navigateSearchResults(true);
                    e.consume();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    navigateSearchResults(false);
                    e.consume();
                }
            }
        });

        // Add search listener with delay to prevent UI lockup during typing
        final Timer searchDelayTimer = new Timer(300, e -> performSearch());
        searchDelayTimer.setRepeats(false);
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchDelayTimer.restart();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchDelayTimer.restart();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchDelayTimer.restart();
            }
        });

        rootNode = new DefaultMutableTreeNode("Game State");
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        tree.setRowHeight(20);
        tree.setLargeModel(true);
        
        // Custom cell renderer for search highlighting
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value,
                    boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                
                if (c instanceof JComponent && !currentSearchText.isEmpty()) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                    TreePath path = new TreePath(node.getPath());
                    
                    // Check if this node is in search results
                    boolean isMatch = false;
                    boolean isCurrentMatch = false;
                    
                    if (searchResults.contains(path)) {
                        isMatch = true;
                        isCurrentMatch = searchResults.indexOf(path) == currentSearchResultIndex;
                    }
                    
                    if (isCurrentMatch) {
                        // Current search result gets a stronger highlight
                        setBackground(new Color(255, 200, 0, 180));
                        setOpaque(true);
                    } else if (isMatch) {
                        // Other matches get a regular highlight
                        setBackground(new Color(255, 255, 0, 100));
                        setOpaque(true);
                    } else {
                        // Non-matches are transparent
                        setBackground(null);
                        setOpaque(false);
                    }
                } else {
                    setBackground(null);
                    setOpaque(false);
                }
                return c;
            }
        });

        // Implement a smarter tree expansion listener
        tree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            @Override
            public void treeExpanded(javax.swing.event.TreeExpansionEvent event) {
                if (!allowExpansionEvents || isUpdatingTree) {
                    return;
                }
                
                TreePath path = event.getPath();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                String nodePath = nodeToPathMap.get(node);
                
                if (nodePath != null) {
                    expandedPaths.add(nodePath);
                    logToFile("DEBUG", "Node expanded: " + nodePath + ", total expanded: " + expandedPaths.size());
                }
            }

            @Override
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent event) {
                if (!allowExpansionEvents || isUpdatingTree) {
                    return;
                }
                
                TreePath path = event.getPath();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                String nodePath = nodeToPathMap.get(node);
                
                if (nodePath != null) {
                    expandedPaths.remove(nodePath);
                    logToFile("DEBUG", "Node collapsed: " + nodePath + ", total expanded: " + expandedPaths.size());
                }
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

        // Updated action listener for refresh
        refreshButton.addActionListener(e -> {
            log.info("Refresh button clicked");
            logToFile("INFO", "Refresh button clicked");
            try {
                if (refreshCallback != null) {
                    log.info("Calling refresh callback");
                    logToFile("INFO", "Calling refresh callback");
                    refreshCallback.run();
                } else if (lastState != null) {
                    log.info("Updating state using lastState");
                    logToFile("INFO", "Updating state using lastState");
                    updateState(lastState);
                } else {
                    log.warn("No callback or lastState available for refresh");
                    logToFile("WARN", "No callback or lastState available for refresh");
                }
            } catch (Exception ex) {
                log.error("Error in refresh button handler", ex);
                logToFile("ERROR", "Error in refresh button handler: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    public void setRefreshCallback(Runnable callback)
    {
        this.refreshCallback = callback;
    }

    public void updateState(JsonNode state) {
        if (state == null) {
            log.warn("Received null state in updateState");
            logToFile("WARN", "Received null state in updateState");
            return;
        }

        // Store last state for refresh functionality
        lastState = state;
        
        // Add debug logging
        logToFile("INFO", "updateState called, performing state update");
        
        // Make a defensive copy of expanded paths to restore later
        final Set<String> pathsToRestore = new HashSet<>(expandedPaths);
        
        // Use SwingUtilities to ensure this runs on the EDT
        SwingUtilities.invokeLater(() -> {
            try {
                // Mark that we're updating the tree to prevent user events
                isUpdatingTree = true;
                
                // Freeze tree expansion state tracking while updating
                allowExpansionEvents = false;
                
                // Store expanded paths before update - get current tree state
                storeExpandedPaths();
                
                // Clear tree and prepare for update
                rootNode.removeAllChildren();
                nodeToPathMap.clear(); // Clear our node tracking map
                
                logToFile("INFO", "Building new tree model with state data");
                
                // Process each top-level field in the state
                state.fields().forEachRemaining(entry -> {
                    String key = entry.getKey();
                    JsonNode value = entry.getValue();
                    
                    String nodePath = "root/" + key;
                    DefaultMutableTreeNode node = createNewNode(key, nodePath);
                    addJsonNode(node, value, nodePath);
                    rootNode.add(node);
                });
                
                // Notify the tree model of the change
                treeModel.nodeStructureChanged(rootNode);
                
                logToFile("INFO", "Tree structure updated, now restoring expansion state");
                
                // Always expand the root node
                tree.expandPath(new TreePath(rootNode.getPath()));
                
                // Restore previously expanded paths, plus any that were expanded during this update
                Set<String> combinedPaths = new HashSet<>(pathsToRestore);
                combinedPaths.addAll(expandedPaths);
                restoreExpandedPaths(combinedPaths);
                
                // Keep the current search active if there is one
                if (!currentSearchText.isEmpty()) {
                    searchStatusLabel.setText("State updated (search needs refresh)");
                    prevButton.setEnabled(false);
                    nextButton.setEnabled(false);
                    searchProgressBar.setVisible(false);
                }
                
                revalidate();
                repaint();
                
                logToFile("INFO", "State viewer update completed successfully");
            } catch (Exception e) {
                log.error("Error updating state viewer", e);
                logToFile("ERROR", "Error updating state viewer: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // Always re-enable events even if there's an error
                allowExpansionEvents = true;
                isUpdatingTree = false;
            }
        });
    }

    // Store expanded paths before updating the tree
    private void storeExpandedPaths() {
        // Clear previously stored paths
        expandedPaths.clear();
        
        // Only attempt to store if the root node exists and has a valid path
        if (rootNode == null || rootNode.getPath() == null) {
            logToFile("DEBUG", "Cannot store expanded paths - root node not ready");
            return;
        }
        
        try {
            // Get currently expanded paths directly from the tree
            TreePath rootPath = new TreePath(rootNode.getPath());
            if (tree.isExpanded(rootPath)) {
                Enumeration<TreePath> expanded = tree.getExpandedDescendants(rootPath);
                
                if (expanded != null) {
                    while (expanded.hasMoreElements()) {
                        TreePath path = expanded.nextElement();
                        if (path != null && path.getLastPathComponent() != null) {
                            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                            String nodePath = nodeToPathMap.get(node);
                            if (nodePath != null) {
                                expandedPaths.add(nodePath);
                            }
                        }
                    }
                }
            }
            
            logToFile("DEBUG", "Stored " + expandedPaths.size() + " expanded paths");
        } catch (Exception e) {
            logToFile("ERROR", "Error storing expanded paths: " + e.getMessage());
        }
    }

    // Create a new node with proper path tracking
    private DefaultMutableTreeNode createNewNode(String text, String path) {
        if (text == null) {
            text = "null";
        }
        
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(text);
        if (path != null) {
            nodeToPathMap.put(node, path);
        }
        
        return node;
    }

    // More straightforward version of addJsonNode with improved path tracking
    private void addJsonNode(DefaultMutableTreeNode parent, JsonNode jsonNode, String parentPath) {
        if (jsonNode == null || parent == null || parentPath == null) {
            return;
        }
        
        if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                String path = parentPath + "/" + key;
                
                DefaultMutableTreeNode childNode = createNewNode(key, path);
                addJsonNode(childNode, entry.getValue(), path);
                parent.add(childNode);
            }
        }
        else if (jsonNode.isArray()) {
            int index = 0;
            for (JsonNode element : jsonNode) {
                String path = parentPath + "/[" + index + "]";
                String displayText = "[" + index + "]";
                
                DefaultMutableTreeNode childNode = createNewNode(displayText, path);
                addJsonNode(childNode, element, path);
                parent.add(childNode);
                
                index++;
            }
        }
        else {
            // For leaf nodes (values)
            String value = jsonNode.asText();
            String displayText = (value != null) ? value : "null";
            String path = parentPath + "/value";
            
            DefaultMutableTreeNode valueNode = createNewNode(displayText, path);
            parent.add(valueNode);
        }
    }

    // Improved method to restore expanded paths
    private void restoreExpandedPaths(Set<String> pathsToExpand) {
        if (pathsToExpand == null || pathsToExpand.isEmpty()) {
            logToFile("DEBUG", "No paths to restore");
            return;
        }

        logToFile("DEBUG", "Attempting to restore " + pathsToExpand.size() + " expanded paths");
        
        // First expand paths with fewer segments (parent paths first)
        List<String> sortedPaths = pathsToExpand.stream()
            .sorted(Comparator.comparingInt(p -> p.split("/").length))
            .collect(Collectors.toList());
        
        int successfulRestores = 0;
        
        // Disable expansion tracking during restoration
        boolean previousAllowEvents = allowExpansionEvents;
        allowExpansionEvents = false;
        
        try {
            for (String pathToExpand : sortedPaths) {
                if (expandPathByString(pathToExpand)) {
                    successfulRestores++;
                }
            }
            
            logToFile("DEBUG", "Successfully restored " + successfulRestores + 
                     " of " + pathsToExpand.size() + " paths");
            
            // Store the successfully expanded paths for future reference
            expandedPaths.clear();
            expandedPaths.addAll(pathsToExpand);
        } finally {
            // Always restore previous event tracking state
            allowExpansionEvents = previousAllowEvents;
        }
    }
    
    // Helper method to find and expand a node by its string path
    private boolean expandPathByString(String pathString) {
        if (pathString == null || pathString.isEmpty()) {
            return false;
        }
        
        DefaultMutableTreeNode node = findNodeByPath(pathString);
        if (node != null) {
            TreePath treePath = new TreePath(node.getPath());
            tree.expandPath(treePath);
            logToFile("DEBUG", "Expanded path: " + pathString);
            return true;
        } else {
            logToFile("DEBUG", "Could not find node for path: " + pathString);
            return false;
        }
    }
    
    // Find a node by its string path - more efficient implementation
    private DefaultMutableTreeNode findNodeByPath(String targetPath) {
        if (targetPath == null || targetPath.isEmpty()) {
            return null;
        }
        
        // If looking for root, return it directly
        if (targetPath.equals("root")) {
            return rootNode;
        }
        
        // Split the path into segments
        String[] pathSegments = targetPath.split("/");
        if (pathSegments.length <= 1) {
            return null; // Invalid path
        }
        
        // Start at root and traverse down
        DefaultMutableTreeNode currentNode = rootNode;
        
        // Skip the "root" part (index 0) and start from the first child
        for (int i = 1; i < pathSegments.length; i++) {
            String segment = pathSegments[i];
            
            // For array indices, parse the index
            if (segment.startsWith("[") && segment.endsWith("]")) {
                try {
                    int index = Integer.parseInt(segment.substring(1, segment.length() - 1));
                    if (index >= 0 && index < currentNode.getChildCount()) {
                        currentNode = (DefaultMutableTreeNode) currentNode.getChildAt(index);
                        continue;
                    }
                } catch (NumberFormatException e) {
                    // Not a valid index, fall through to normal search
                }
            }
            
            // Try to find a child with matching text
            boolean found = false;
            for (int j = 0; j < currentNode.getChildCount(); j++) {
                DefaultMutableTreeNode child = (DefaultMutableTreeNode) currentNode.getChildAt(j);
                if (child.getUserObject().toString().equals(segment)) {
                    currentNode = child;
                    found = true;
                    break;
                }
            }
            
            // If no matching child was found, check if we can find the node by path
            if (!found) {
                // Build the path up to this point
                StringBuilder partialPath = new StringBuilder("root");
                for (int j = 1; j <= i; j++) {
                    partialPath.append("/").append(pathSegments[j]);
                }
                
                // See if we can find a direct match in our path map
                for (Map.Entry<DefaultMutableTreeNode, String> entry : nodeToPathMap.entrySet()) {
                    if (entry.getValue().equals(partialPath.toString())) {
                        currentNode = entry.getKey();
                        found = true;
                        break;
                    }
                }
                
                // If we still couldn't find it, this path doesn't exist in the current tree
                if (!found) {
                    return null;
                }
            }
        }
        
        return currentNode;
    }

    /**
     * Performs a search through the state tree using the current search text.
     * Uses a SwingWorker to prevent UI freezing during search.
     */
    private void performSearch() {
        // Cancel any ongoing search
        if (searchWorker != null && !searchWorker.isDone()) {
            searchWorker.cancel(true);
        }
        
        // Get the search text
        currentSearchText = searchField.getText().trim();
        
        // Clear previous search results
        searchResults.clear();
        searchMatchTexts.clear();
        currentSearchResultIndex = -1;
        prevButton.setEnabled(false);
        nextButton.setEnabled(false);
        
        // Reset search progress tracking
        nodesChecked.set(0);
        totalNodeCount = countNodes(rootNode);
        
        // Update status label and progress bar
        searchStatusLabel.setText("Searching...");
        searchProgressBar.setVisible(!currentSearchText.isEmpty());
        searchProgressBar.setValue(0);
        searchProgressBar.setString("Searching...");
        
        // If search is empty, just repaint the tree and update status
        if (currentSearchText.isEmpty()) {
            tree.repaint();
            searchStatusLabel.setText("");
            searchProgressBar.setVisible(false);
            return;
        }
        
        // Log search start
        logToFile("INFO", "Starting search for '" + currentSearchText + "' across " + totalNodeCount + " nodes");
        
        // Use a synchronized list for thread safety
        final List<TreePath> results = new ArrayList<>();
        
        // Create a timer to periodically update the UI with search results
        final Timer updateTimer = new Timer(100, e -> {
            updateSearchResults(results);
            
            // Update progress
            int checked = nodesChecked.get();
            int progressPercent = totalNodeCount > 0 ? (checked * 100 / totalNodeCount) : 0;
            progressPercent = Math.min(progressPercent, 99); // Never show 100% until done
            
            searchProgressBar.setValue(progressPercent);
            searchProgressBar.setString(String.format("Searching... %d%%", progressPercent));
        });
        updateTimer.setRepeats(true);
        updateTimer.start();
        
        // Create and execute a SwingWorker for searching
        searchWorker = new SwingWorker<List<TreePath>, Void>() {
            @Override
            protected List<TreePath> doInBackground() {
                try {
                    // Temporarily disable expansion events during search
                    allowExpansionEvents = false;
                    
                    // Search the tree
                    searchNodeAsync(rootNode, new TreePath(rootNode), results);
                    
                } catch (Exception e) {
                    log.error("Error during search", e);
                    logToFile("ERROR", "Error during search: " + e.getMessage());
                }
                
                return results;
            }
            
            @Override
            protected void done() {
                // Stop the UI update timer
                updateTimer.stop();
                
                // Do a final update of the UI
                updateSearchResults(results);
                
                // Set progress bar to complete
                searchProgressBar.setValue(100);
                searchProgressBar.setString("Search complete");
                
                // Log search completion
                logToFile("INFO", "Search completed, found " + results.size() + " results");
                
                // Handle visibility of progress bar
                Timer hideProgressTimer = new Timer(1500, e -> {
                    searchProgressBar.setVisible(false);
                });
                hideProgressTimer.setRepeats(false);
                hideProgressTimer.start();
                
                // Re-enable expansion events
                allowExpansionEvents = true;
                
                // If search was cancelled, update status
                if (isCancelled()) {
                    searchStatusLabel.setText("Search cancelled");
                    searchProgressBar.setString("Search cancelled");
                    return;
                }
                
                try {
                    List<TreePath> finalResults = get();
                    
                    // If we have results, select the first one
                    if (!finalResults.isEmpty()) {
                        navigateToResult(0);
                    }
                    
                    // Final status update
                    searchStatusLabel.setText(searchResults.size() + " matches");
                    
                    // Update navigation buttons
                    updateSearchNavigation();
                    
                } catch (Exception e) {
                    log.error("Error finalizing search", e);
                    logToFile("ERROR", "Error finalizing search: " + e.getMessage());
                    searchStatusLabel.setText("Search error");
                }
            }
        };
        
        searchWorker.execute();
    }
    
    /**
     * Counts the total number of nodes in the tree for progress tracking
     */
    private int countNodes(DefaultMutableTreeNode node) {
        int count = 1; // Count this node
        
        Enumeration<?> children = node.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
            count += countNodes(child);
        }
        
        return count;
    }

    /**
     * Recursively searches through nodes looking for the search text.
     * Thread-safe version that collects results in a shared list.
     */
    private void searchNodeAsync(DefaultMutableTreeNode node, TreePath path, List<TreePath> results) {
        // Check if search was cancelled
        if (searchWorker.isCancelled()) {
            return;
        }
        
        // Increment the nodes checked counter
        nodesChecked.incrementAndGet();
        
        // Get node text
        String nodeText = node.getUserObject().toString().toLowerCase();
        String searchText = currentSearchText.toLowerCase();
        
        // First check if this node's text matches the search
        boolean nodeMatches = nodeText.contains(searchText);
        
        // If we're looking at a parent node (category or key), also search deeply through child values
        // This ensures we can find matches in deeply nested data structures
        if (!nodeMatches && node.getChildCount() > 0) {
            nodeMatches = deepSearchNode(node, searchText);
        }
        
        if (nodeMatches) {
            synchronized (results) {
                results.add(path);
            }
            searchMatchTexts.put(path, nodeText);
        }
        
        // Search all children
        Enumeration<?> children = node.children();
        while (children.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
            TreePath childPath = path.pathByAddingChild(child);
            searchNodeAsync(child, childPath, results);
        }
    }
    
    /**
     * Deeply searches a node and all its children for the given text.
     * This ensures that searching for a value will highlight parent nodes 
     * that contain the value in their children, making it easier to find
     * matches in the hierarchy.
     */
    private boolean deepSearchNode(DefaultMutableTreeNode node, String searchText) {
        // Check all direct children first
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            String childText = child.getUserObject().toString().toLowerCase();
            
            // If this child matches, return true
            if (childText.contains(searchText)) {
                return true;
            }
            
            // If this child has children, search them too
            if (child.getChildCount() > 0) {
                if (deepSearchNode(child, searchText)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Updates the UI with the current search results
     */
    private void updateSearchResults(List<TreePath> results) {
        // Copy results to avoid concurrent modification
        List<TreePath> currentResults = new ArrayList<>(results);
        
        // Update our search results
        searchResults.clear();
        searchResults.addAll(currentResults);
        
        // Expand paths to results and update UI
        SwingUtilities.invokeLater(() -> {
            try {
                // For each result, make sure the path is expanded
                for (TreePath path : currentResults) {
                    if (path != null && path.getParentPath() != null) {
                        tree.expandPath(path.getParentPath());
                    }
                }
                
                // Update navigation buttons
                updateSearchNavigation();
                
                // Update status
                searchStatusLabel.setText(currentResults.size() + " matches");
                
                // Repaint for highlighting
                tree.repaint();
            } catch (Exception e) {
                log.error("Error updating search results", e);
                logToFile("ERROR", "Error updating search results: " + e.getMessage());
            }
        });
    }

    /**
     * Navigates to the next or previous search result
     */
    private void navigateSearchResults(boolean forward) {
        if (searchResults.isEmpty()) {
            return;
        }
        
        int newIndex;
        if (forward) {
            newIndex = (currentSearchResultIndex + 1) % searchResults.size();
        } else {
            newIndex = (currentSearchResultIndex - 1 + searchResults.size()) % searchResults.size();
        }
        
        navigateToResult(newIndex);
    }
    
    /**
     * Navigates to a specific search result by index
     */
    private void navigateToResult(int index) {
        if (index < 0 || index >= searchResults.size()) {
            return;
        }
        
        currentSearchResultIndex = index;
        TreePath path = searchResults.get(index);
        
        // Expand to make visible
        tree.expandPath(path.getParentPath());
        
        // Select and scroll to the node
        tree.setSelectionPath(path);
        tree.scrollPathToVisible(path);
        
        // Update navigation status
        searchStatusLabel.setText((index + 1) + " of " + searchResults.size());
        
        // Update buttons
        updateSearchNavigation();
        
        // Repaint to update highlighting
        tree.repaint();
    }
    
    /**
     * Updates the enabled state of navigation buttons
     */
    private void updateSearchNavigation() {
        boolean hasResults = !searchResults.isEmpty();
        prevButton.setEnabled(hasResults);
        nextButton.setEnabled(hasResults);
    }

    // Add file logging method similar to the one in RLBotPlugin
    private void logToFile(String level, String message) {
        try {
            String LOG_FILE = new File(RuneLite.RUNELITE_DIR, "rlbot/logs/rlbot-stateviewer.log").getAbsolutePath();
            
            // Create parent directories if they don't exist
            Path logPath = Paths.get(LOG_FILE);
            Files.createDirectories(logPath.getParent());
            
            String logEntry = String.format("%s [%s] %s%n", 
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), 
                level, 
                message);
            Files.write(logPath, 
                       logEntry.getBytes(), 
                       StandardOpenOption.CREATE, 
                       StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
} 