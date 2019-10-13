import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MouseHandler")
public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	@Export("MouseHandler_instance")
	static MouseHandler MouseHandler_instance;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1294175143
	)
	@Export("MouseHandler_idleCycles")
	public static volatile int MouseHandler_idleCycles;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -528827615
	)
	@Export("MouseHandler_currentButtonVolatile")
	static volatile int MouseHandler_currentButtonVolatile;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 965678779
	)
	@Export("MouseHandler_xVolatile")
	static volatile int MouseHandler_xVolatile;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1390089149
	)
	@Export("MouseHandler_yVolatile")
	static volatile int MouseHandler_yVolatile;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		longValue = -6736454451996007549L
	)
	@Export("MouseHandler_millis")
	public static long MouseHandler_millis;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		longValue = -1086707197767215489L
	)
	@Export("MouseHandler_lastMovedVolatile")
	static volatile long MouseHandler_lastMovedVolatile;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1174248655
	)
	@Export("MouseHandler_currentButton")
	public static int MouseHandler_currentButton;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -180428827
	)
	@Export("MouseHandler_x")
	public static int MouseHandler_x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 97221829
	)
	@Export("MouseHandler_y")
	public static int MouseHandler_y;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1906360683
	)
	@Export("MouseHandler_lastButtonVolatile")
	static volatile int MouseHandler_lastButtonVolatile;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1404319225
	)
	@Export("MouseHandler_lastPressedXVolatile")
	static volatile int MouseHandler_lastPressedXVolatile;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 955503415
	)
	@Export("MouseHandler_lastPressedYVolatile")
	static volatile int MouseHandler_lastPressedYVolatile;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = -1390704279211599925L
	)
	@Export("MouseHandler_lastPressedTimeMillisVolatile")
	static volatile long MouseHandler_lastPressedTimeMillisVolatile;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1367970229
	)
	@Export("MouseHandler_lastButton")
	public static int MouseHandler_lastButton;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 371149673
	)
	@Export("MouseHandler_lastPressedX")
	public static int MouseHandler_lastPressedX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1499115361
	)
	@Export("MouseHandler_lastPressedY")
	public static int MouseHandler_lastPressedY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		longValue = -6248133867474392459L
	)
	@Export("MouseHandler_lastPressedTimeMillis")
	public static long MouseHandler_lastPressedTimeMillis;
	@ObfuscatedName("ge")
	@Export("regions")
	static int[] regions;

	static {
		MouseHandler_instance = new MouseHandler();
		MouseHandler_idleCycles = 0;
		MouseHandler_currentButtonVolatile = 0;
		MouseHandler_xVolatile = -1;
		MouseHandler_yVolatile = -1;
		MouseHandler_lastMovedVolatile = -1L;
		MouseHandler_currentButton = 0;
		MouseHandler_x = 0;
		MouseHandler_y = 0;
		MouseHandler_millis = 0L;
		MouseHandler_lastButtonVolatile = 0;
		MouseHandler_lastPressedXVolatile = 0;
		MouseHandler_lastPressedYVolatile = 0;
		MouseHandler_lastPressedTimeMillisVolatile = 0L;
		MouseHandler_lastButton = 0;
		MouseHandler_lastPressedX = 0;
		MouseHandler_lastPressedY = 0;
		MouseHandler_lastPressedTimeMillis = 0L;
	}

	MouseHandler() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/event/MouseEvent;I)I",
		garbageValue = "1818791609"
	)
	@Export("getButton")
	final int getButton(MouseEvent var1) {
		int var2 = var1.getButton();
		if (!var1.isAltDown() && var2 != 2) {
			return !var1.isMetaDown() && var2 != 3 ? 1 : 2;
		} else {
			return 4;
		}
	}

	public final synchronized void mouseMoved(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_xVolatile = var1.getX();
			MouseHandler_yVolatile = var1.getY();
			MouseHandler_lastMovedVolatile = var1.getWhen();
		}

	}

	public final synchronized void mouseReleased(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_currentButtonVolatile = 0;
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final void mouseClicked(MouseEvent var1) {
		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void mouseDragged(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_currentButtonVolatile = 0;
		}

	}

	public final synchronized void mouseEntered(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void mouseExited(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_xVolatile = -1;
			MouseHandler_yVolatile = -1;
			MouseHandler_lastMovedVolatile = var1.getWhen();
		}

	}

	public final synchronized void mousePressed(MouseEvent var1) {
		if (MouseHandler_instance != null) {
			MouseHandler_idleCycles = 0;
			MouseHandler_lastPressedXVolatile = var1.getX();
			MouseHandler_lastPressedYVolatile = var1.getY();
			MouseHandler_lastPressedTimeMillisVolatile = class30.currentTimeMillis();
			MouseHandler_lastButtonVolatile = this.getButton(var1);
			if (MouseHandler_lastButtonVolatile != 0) {
				MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
			}
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}
}
