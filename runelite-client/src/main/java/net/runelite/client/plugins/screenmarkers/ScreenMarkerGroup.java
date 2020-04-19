package net.runelite.client.plugins.screenmarkers;

import java.awt.Dimension;
import java.awt.Point;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ScreenMarkerGroup extends ScreenMarkerItem
{
	private static final String DEFAULT_MARKER_NAME = "Marker";
	private static final Dimension DEFAULT_SIZE = new Dimension(2, 2);

	private static final List<ScreenMarkerOverlay> markers = new ArrayList<>();

	private long id;
	private String name;

	public List<ScreenMarkerOverlay> getMarkers()
	{
		return markers;
	}

	@Inject
	private ScreenMarkerCreationOverlay overlay;

	@Getter(AccessLevel.PACKAGE)
	private ScreenMarker currentMarker;

	@Getter
	private boolean creatingScreenMarker = false;
	private Point startLocation = null;

	public ScreenMarkerGroup(long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public void startCreation(Point location)
	{
		currentMarker = new ScreenMarker(
			Instant.now().toEpochMilli(),
			DEFAULT_MARKER_NAME + " " + (markers.size() + 1),
			pluginPanel.getSelectedBorderThickness(),
			pluginPanel.getSelectedColor(),
			pluginPanel.getSelectedFillColor(),
			true
		);

		// Set overlay creator bounds to current position and default size
		startLocation = location;
		overlay.setPreferredLocation(location);
		overlay.setPreferredSize(DEFAULT_SIZE);
		creatingScreenMarker = true;
	}

	public void finishCreation(boolean aborted)
	{
		ScreenMarker marker = currentMarker;
		if (!aborted && marker != null)
		{
			final ScreenMarkerOverlay screenMarkerOverlay = new ScreenMarkerOverlay(marker);
			screenMarkerOverlay.setPreferredLocation(overlay.getBounds().getLocation());
			screenMarkerOverlay.setPreferredSize(overlay.getBounds().getSize());

			markers.add(screenMarkerOverlay);
			overlayManager.saveOverlay(screenMarkerOverlay);
			overlayManager.add(screenMarkerOverlay);
			pluginPanel.rebuild();
			updateConfig();
		}

		creatingScreenMarker = false;
		startLocation = null;
		currentMarker = null;
		setMouseListenerEnabled(false);

		pluginPanel.setCreation(false);
	}
}
