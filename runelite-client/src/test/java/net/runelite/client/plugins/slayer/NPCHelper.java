package net.runelite.client.plugins.slayer;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.Actor;
import net.runelite.api.Model;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Node;
import net.runelite.api.Point;
import net.runelite.api.SpritePixels;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;

public class NPCHelper
{

	public static NPC newNPC(String name, int combatLevel)
	{
		return new NPC() {
			@Override
			public int getId() {
				return 0;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public int getCombatLevel() {
				return combatLevel;
			}

			@Override
			public int getIndex() {
				return 0;
			}

			@Override
			public NPCComposition getComposition() {
				return null;
			}

			@Override
			public NPCComposition getTransformedComposition() {
				return null;
			}

			@Override
			public boolean isDead() {
				return false;
			}

			@Override
			public Actor getInteracting() {
				return null;
			}

			@Override
			public int getHealthRatio() {
				return 0;
			}

			@Override
			public int getHealth() {
				return 0;
			}

			@Override
			public WorldPoint getWorldLocation() {
				return null;
			}

			@Override
			public LocalPoint getLocalLocation() {
				return null;
			}

			@Override
			public void setIdlePoseAnimation(int animation) {

			}

			@Override
			public void setPoseAnimation(int animation) {

			}

			@Override
			public int getOrientation() {
				return 0;
			}

			@Override
			public int getAnimation() {
				return 0;
			}

			@Override
			public void setAnimation(int animation) {

			}

			@Override
			public void setActionFrame(int actionFrame) {

			}

			@Override
			public int getGraphic() {
				return 0;
			}

			@Override
			public void setGraphic(int graphic) {

			}

			@Override
			public void setSpotAnimFrame(int spotAnimFrame) {

			}

			@Override
			public int getModelHeight() {
				return 0;
			}

			@Override
			public Polygon getCanvasTilePoly() {
				return null;
			}

			@Override
			public Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset) {
				return null;
			}

			@Override
			public Point getCanvasImageLocation(BufferedImage image, int zOffset) {
				return null;
			}

			@Override
			public Point getCanvasSpriteLocation(SpritePixels sprite, int zOffset) {
				return null;
			}

			@Override
			public Point getMinimapLocation() {
				return null;
			}

			@Override
			public int getLogicalHeight() {
				return 0;
			}

			@Override
			public Polygon getConvexHull() {
				return null;
			}

			@Override
			public WorldArea getWorldArea() {
				return null;
			}

			@Override
			public String getOverhead() {
				return null;
			}

			@Override
			public Model getModel() {
				return null;
			}

			@Override
			public void setModelHeight(int modelHeight) {

			}

			@Override
			public void draw(int orientation, int pitchSin, int pitchCos, int yawSin, int yawCos, int x, int y, int z, long hash) {

			}

			@Override
			public Node getNext() {
				return null;
			}

			@Override
			public Node getPrevious() {
				return null;
			}

			@Override
			public long getHash() {
				return 0;
			}
		};
	}

}
