import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bn")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfq;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lbn;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1940635317
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 2410955799989226407L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("u")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1724469587
	)
	static int field423;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1078745495
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -325181045
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 701410381
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("s")
	static long[] field427;
	@ObfuscatedName("e")
	static long[] field418;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1973184751
	)
	@Export("canvasHeight")
	public static int canvasHeight;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -768939705
	)
	static int field441;
	@ObfuscatedName("aq")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		longValue = -1516080543148200363L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		longValue = 7898189613285103621L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("j")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2138791277
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1076406639
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 476057871
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1400407449
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1347803341
	)
	int field435;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		intValue = 1534587989
	)
	int field428;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		intValue = -1315283541
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -350694385
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("al")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("as")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("ad")
	volatile boolean field440;
	@ObfuscatedName("aj")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("ab")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		longValue = -1097911056419616917L
	)
	volatile long field444;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("ah")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("aa")
	@Export("eventQueue")
	final EventQueue eventQueue;

	static {
		gameShell = null;
		GameShell_redundantStartThreadCount = 0;
		stopTimeMs = 0L;
		isKilled = false;
		cycleDurationMillis = 20;
		fiveOrOne = 1;
		fps = 0;
		field427 = new long[32];
		field418 = new long[32];
		field441 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field440 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field444 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		HealthBar.pcmPlayerProvider = var2;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "952185183"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method909();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "-1820035626"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				FriendsList.sleepMillis(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Lfa;",
		garbageValue = "718088180"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1139058082"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1159772374"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1206227036"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		class3.method38();
		class237.method4317(this.canvas);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-553241238"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "88"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field435);
			this.contentHeight = Math.max(var2.highY, this.field428);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			GraphicsDefaults.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - GraphicsDefaults.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(GraphicsDefaults.canvasWidth, canvasHeight);
			DevicePcmPlayerProvider.rasterProvider = new RasterProvider(GraphicsDefaults.canvasWidth, canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field440 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1419567103"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-89"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - GraphicsDefaults.canvasWidth - var1;
		int var4 = this.contentHeight - canvasHeight - var2;
		if (var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
			try {
				Container var5 = this.container();
				int var6 = 0;
				int var7 = 0;
				if (var5 == this.frame) {
					Insets var8 = this.frame.getInsets();
					var6 = var8.left;
					var7 = var8.top;
				}

				Graphics var10 = var5.getGraphics();
				var10.setColor(Color.black);
				if (var1 > 0) {
					var10.fillRect(var6, var7, var1, this.contentHeight);
				}

				if (var2 > 0) {
					var10.fillRect(var6, var7, this.contentWidth, var2);
				}

				if (var3 > 0) {
					var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
				}

				if (var4 > 0) {
					var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
				}
			} catch (Exception var9) {
			}
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-121"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		java.awt.Canvas var1 = this.canvas;
		var1.removeKeyListener(KeyHandler.KeyHandler_instance);
		var1.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field366 = -1;
		java.awt.Canvas var2 = this.canvas;
		var2.removeMouseListener(MouseHandler.MouseHandler_instance);
		var2.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		class237.method4317(this.canvas);
		java.awt.Canvas var3 = this.canvas;
		var3.addMouseListener(MouseHandler.MouseHandler_instance);
		var3.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var3.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method909();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1169859735"
	)
	@Export("startThread")
	protected final void startThread(int var1, int var2, int var3) {
		try {
			if (gameShell != null) {
				++GameShell_redundantStartThreadCount;
				if (GameShell_redundantStartThreadCount >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameShell = this;
			GraphicsDefaults.canvasWidth = var1;
			canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			class188.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "595873296"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		GraphicsDefaults.canvasWidth = Math.max(var1.getWidth(), this.field435);
		canvasHeight = Math.max(var1.getHeight(), this.field428);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			GraphicsDefaults.canvasWidth -= var2.left + var2.right;
			canvasHeight -= var2.bottom + var2.top;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(GraphicsDefaults.canvasWidth, canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(this.canvasX + var2.left, this.canvasY + var2.top);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.field440 = true;
		if (DevicePcmPlayerProvider.rasterProvider != null && GraphicsDefaults.canvasWidth == DevicePcmPlayerProvider.rasterProvider.width && canvasHeight == DevicePcmPlayerProvider.rasterProvider.height) {
			((RasterProvider)DevicePcmPlayerProvider.rasterProvider).setComponent(this.canvas);
			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
		} else {
			DevicePcmPlayerProvider.rasterProvider = new RasterProvider(GraphicsDefaults.canvasWidth, canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field444 = SoundCache.method2480();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1396106184"
	)
	@Export("checkHost")
	protected final boolean checkHost() {
		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
			if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
				if (var1.endsWith("127.0.0.1")) {
					return true;
				} else {
					while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
						var1 = var1.substring(0, var1.length() - 1);
					}

					if (var1.endsWith("192.168.1.")) {
						return true;
					} else {
						this.error("invalidhost");
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "731379125"
	)
	void method1016() {
		long var1 = SoundCache.method2480();
		long var3 = field418[Username.field3594];
		field418[Username.field3594] = var1;
		Username.field3594 = Username.field3594 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			PendingSpawn.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "39"
	)
	void method900() {
		Container var1 = this.container();
		long var2 = SoundCache.method2480();
		long var4 = field427[class185.field2306];
		field427[class185.field2306] = var2;
		class185.field2306 = class185.field2306 + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field441 - 1 > 50) {
			field441 -= 50;
			this.field440 = true;
			this.canvas.setSize(GraphicsDefaults.canvasWidth, canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(var7.left + this.canvasX, var7.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method901();
		this.draw(this.field440);
		if (this.field440) {
			this.clearBackground();
		}

		this.field440 = false;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "22"
	)
	final void method901() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "30"
	)
	final void method909() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "591639772"
	)
	@Export("kill")
	final synchronized void kill() {
		if (!isKilled) {
			isKilled = true;

			try {
				this.canvas.removeFocusListener(this);
			} catch (Exception var5) {
			}

			try {
				this.kill0();
			} catch (Exception var4) {
			}

			if (this.frame != null) {
				try {
					System.exit(0);
				} catch (Throwable var3) {
				}
			}

			if (taskHandler != null) {
				try {
					taskHandler.close();
				} catch (Exception var2) {
				}
			}

			this.vmethod1248();
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "77"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2117082118"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-2055189627"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "890859408"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "-82"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class51.fontHelvetica13 == null) {
				class51.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				KeyHandler.loginScreenFontMetrics = this.canvas.getFontMetrics(class51.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, GraphicsDefaults.canvasWidth, canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class42.field358 == null) {
					class42.field358 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class42.field358.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class51.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - KeyHandler.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class42.field358, GraphicsDefaults.canvasWidth / 2 - 152, canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = GraphicsDefaults.canvasWidth / 2 - 152;
				int var8 = canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class51.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - KeyHandler.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1405214029"
	)
	protected final void method915() {
		class42.field358 = null;
		class51.fontHelvetica13 = null;
		KeyHandler.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1941506741"
	)
	@Export("error")
	protected void error(String var1) {
		if (!this.hasErrored) {
			this.hasErrored = true;
			System.out.println("error_game_" + var1);

			try {
				this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
			} catch (Exception var3) {
			}

		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "1795602674"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)Llr;",
		garbageValue = "-894568011"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field435);
		int var3 = Math.max(var1.getHeight(), this.field428);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.left + var4.right;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(S)Z",
		garbageValue = "219"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "792262956"
	)
	protected abstract void vmethod1248();

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field440 = true;
			if (SoundCache.method2480() - this.field444 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= GraphicsDefaults.canvasWidth && var2.height >= canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = SoundCache.method2480();
			FriendsList.sleepMillis(5000L);
			this.kill();
		}
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = TaskHandler.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && Actor.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (DynamicObject.isNumber(var4) && IgnoreList.parseInt(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					fiveOrOne = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();
			FriendSystem.clock = UserComparator6.newClock();

			while (stopTimeMs == 0L || SoundCache.method2480() < stopTimeMs) {
				field423 = FriendSystem.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < field423; ++var5) {
					this.method1016();
				}

				this.method900();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class188.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void start() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field440 = true;
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public abstract void init();

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = SoundCache.method2480() + 4000L;
		}
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	@ObfuscatedName("x")
	public static double method1020(double var0, double var2, double var4) {
		return ObjectDefinition.method4645((var0 - var2) / var4) / var4;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lbs;II)V",
		garbageValue = "116530330"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (Calendar.isWorldMapEvent(var0.type)) {
			class32.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = WorldMapSection1.WorldMapElement_get(class32.worldMapEvent.mapElement);
			var3 = PlayerAppearance.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = Tiles.getScript(var17);
		}

		if (var3 != null) {
			class160.Interpreter_intStackSize = 0;
			TextureProvider.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1067 = false;

			try {
				int var10;
				try {
					Interpreter.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					class14.Interpreter_stringLocals = new String[var3.localStringCount];
					int var9 = 0;

					int var11;
					String var18;
					for (var10 = 1; var10 < var2.length; ++var10) {
						if (var2[var10] instanceof Integer) {
							var11 = (Integer)var2[var10];
							if (var11 == -2147483647) {
								var11 = var0.mouseX;
							}

							if (var11 == -2147483646) {
								var11 = var0.mouseY;
							}

							if (var11 == -2147483645) {
								var11 = var0.widget != null ? var0.widget.id : -1;
							}

							if (var11 == -2147483644) {
								var11 = var0.opIndex;
							}

							if (var11 == -2147483643) {
								var11 = var0.widget != null ? var0.widget.childIndex : -1;
							}

							if (var11 == -2147483642) {
								var11 = var0.dragTarget != null ? var0.dragTarget.id : -1;
							}

							if (var11 == -2147483641) {
								var11 = var0.dragTarget != null ? var0.dragTarget.childIndex : -1;
							}

							if (var11 == -2147483640) {
								var11 = var0.keyTyped;
							}

							if (var11 == -2147483639) {
								var11 = var0.keyPressed;
							}

							Interpreter.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							class14.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1066 = var0.field550;

					while (true) {
						++var10;
						if (var10 > var1) {
							throw new RuntimeException();
						}

						++var17;
						int var29 = var5[var17];
						int var20;
						if (var29 >= 100) {
							boolean var32;
							if (var3.intOperands[var17] == 1) {
								var32 = true;
							} else {
								var32 = false;
							}

							var20 = WorldMapAreaData.method670(var29, var3, var32);
							switch(var20) {
							case 0:
								return;
							case 1:
							default:
								break;
							case 2:
								throw new IllegalStateException();
							}
						} else if (var29 == ScriptOpcodes.ICONST) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
							Players.method2123(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.RETURN) {
							if (Interpreter.Interpreter_frameDepth == 0) {
								return;
							}

							ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
							var3 = var34.script;
							var5 = var3.opcodes;
							var6 = var3.intOperands;
							var17 = var34.pc;
							Interpreter.Interpreter_intLocals = var34.intLocals;
							class14.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = WorldMapCacheName.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							WorldMapData_1.method703(var11, Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							class160.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							Interpreter.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = class14.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							class14.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							TextureProvider.Interpreter_stringStackSize -= var11;
							String var31 = WorldMapRegion.method515(Interpreter.Interpreter_stringStack, TextureProvider.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--class160.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--TextureProvider.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = BoundaryObject.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									BoundaryObject.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
									if (var21 < 0 || var21 > 5000) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrayLengths[var11] = var21;
									byte var22 = -1;
									if (var20 == 105) {
										var22 = 0;
									}

									for (var15 = 0; var15 < var21; ++var15) {
										Interpreter.Interpreter_arrays[var11][var15] = var22;
									}
								} else if (var29 == ScriptOpcodes.GET_ARRAY_INT) {
									var11 = var6[var17];
									var20 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									class160.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = BoundaryObject.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									BoundaryObject.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = BoundaryObject.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									BoundaryObject.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = Tiles.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (class160.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (TextureProvider.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								class160.Interpreter_intStackSize -= var12.intArgumentCount;
								TextureProvider.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = Interpreter.Interpreter_intLocals;
								var19.stringLocals = class14.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								Interpreter.Interpreter_intLocals = var13;
								class14.Interpreter_stringLocals = var14;
							}
						}
					}
				} catch (Exception var27) {
					StringBuilder var24 = new StringBuilder(30);
					var24.append("").append(var3.key).append(" ");

					for (var10 = Interpreter.Interpreter_frameDepth - 1; var10 >= 0; --var10) {
						var24.append("").append(Interpreter.Interpreter_frames[var10].script.key).append(" ");
					}

					var24.append("").append(var7);
					class188.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1067) {
					Interpreter.field1068 = true;
					GrandExchangeEvent.method73();
					Interpreter.field1068 = false;
					Interpreter.field1067 = false;
				}

			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lkf;Lkf;Lkf;I)V",
		garbageValue = "2116870106"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (GraphicsDefaults.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		VarcInt.loginBoxCenter = Login.loginBoxX + 180;
		int var6;
		int var7;
		int var10;
		int var18;
		byte var23;
		int var24;
		int var36;
		int var48;
		if (Login.worldSelectOpen) {
			if (class162.worldSelectBackSprites == null) {
				Archive var35 = WorldMapDecoration.archive8;
				var36 = var35.getGroupId("sl_back");
				var6 = var35.getFileId(var36, "");
				Sprite[] var34 = PendingSpawn.SpriteBuffer_getSpriteArray(var35, var36, var6);
				class162.worldSelectBackSprites = var34;
			}

			if (PlayerType.worldSelectFlagSprites == null) {
				PlayerType.worldSelectFlagSprites = GrandExchangeOfferNameComparator.method122(WorldMapDecoration.archive8, "sl_flags", "");
			}

			if (FileSystem.worldSelectArrows == null) {
				FileSystem.worldSelectArrows = GrandExchangeOfferNameComparator.method122(WorldMapDecoration.archive8, "sl_arrows", "");
			}

			if (class226.worldSelectStars == null) {
				class226.worldSelectStars = GrandExchangeOfferNameComparator.method122(WorldMapDecoration.archive8, "sl_stars", "");
			}

			if (class2.worldSelectLeftSprite == null) {
				class2.worldSelectLeftSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(WorldMapDecoration.archive8, "leftarrow", "");
			}

			if (WorldMapRectangle.worldSelectRightSprite == null) {
				WorldMapRectangle.worldSelectRightSprite = Interpreter.SpriteBuffer_getIndexedSpriteByName(WorldMapDecoration.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (class226.worldSelectStars != null) {
				class226.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				class226.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (FileSystem.worldSelectArrows != null) {
				var48 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					FileSystem.worldSelectArrows[2].drawAt(var48, 4);
				} else {
					FileSystem.worldSelectArrows[0].drawAt(var48, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					FileSystem.worldSelectArrows[3].drawAt(var48 + 15, 4);
				} else {
					FileSystem.worldSelectArrows[1].drawAt(var48 + 15, 4);
				}

				var0.draw("World", var48 + 32, 17, 16777215, -1);
				var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					FileSystem.worldSelectArrows[2].drawAt(var24, 4);
				} else {
					FileSystem.worldSelectArrows[0].drawAt(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					FileSystem.worldSelectArrows[3].drawAt(var24 + 15, 4);
				} else {
					FileSystem.worldSelectArrows[1].drawAt(var24 + 15, 4);
				}

				var0.draw("Players", var24 + 32, 17, 16777215, -1);
				var36 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					FileSystem.worldSelectArrows[2].drawAt(var36, 4);
				} else {
					FileSystem.worldSelectArrows[0].drawAt(var36, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					FileSystem.worldSelectArrows[3].drawAt(var36 + 15, 4);
				} else {
					FileSystem.worldSelectArrows[1].drawAt(var36 + 15, 4);
				}

				var0.draw("Location", var36 + 32, 17, 16777215, -1);
				var6 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					FileSystem.worldSelectArrows[2].drawAt(var6, 4);
				} else {
					FileSystem.worldSelectArrows[0].drawAt(var6, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					FileSystem.worldSelectArrows[3].drawAt(var6 + 15, 4);
				} else {
					FileSystem.worldSelectArrows[1].drawAt(var6 + 15, 4);
				}

				var0.draw("Type", var6 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (class162.worldSelectBackSprites != null) {
				var23 = 88;
				byte var51 = 19;
				var36 = 765 / (var23 + 1) - 1;
				var6 = 480 / (var51 + 1);

				int var40;
				do {
					var7 = var6;
					var40 = var36;
					if (var6 * (var36 - 1) >= World.World_count) {
						--var36;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}
				} while(var7 != var6 || var36 != var40);

				var7 = (765 - var23 * var36) / (var36 + 1);
				if (var7 > 5) {
					var7 = 5;
				}

				var40 = (480 - var51 * var6) / (var6 + 1);
				if (var40 > 5) {
					var40 = 5;
				}

				int var9 = (765 - var23 * var36 - var7 * (var36 - 1)) / 2;
				var10 = (480 - var51 * var6 - var40 * (var6 - 1)) / 2;
				int var11 = (var6 + World.World_count - 1) / var6;
				Login.worldSelectPagesCount = var11 - var36;
				if (class2.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					class2.worldSelectLeftSprite.drawAt(8, canvasHeight / 2 - class2.worldSelectLeftSprite.subHeight / 2);
				}

				if (WorldMapRectangle.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					WorldMapRectangle.worldSelectRightSprite.drawAt(GraphicsDefaults.canvasWidth - WorldMapRectangle.worldSelectRightSprite.subWidth - 8, canvasHeight / 2 - WorldMapRectangle.worldSelectRightSprite.subHeight / 2);
				}

				int var41 = var10 + 23;
				int var42 = var9 + Login.xPadding;
				int var31 = 0;
				boolean var32 = false;
				int var43 = Login.worldSelectPage;

				int var44;
				for (var44 = var6 * var43; var44 < World.World_count && var43 - Login.worldSelectPage < var36; ++var44) {
					World var33 = World.World_worlds[var44];
					boolean var45 = true;
					String var20 = Integer.toString(var33.population);
					if (var33.population == -1) {
						var20 = "OFF";
						var45 = false;
					} else if (var33.population > 1980) {
						var20 = "FULL";
						var45 = false;
					}

					int var22 = 0;
					byte var21;
					if (var33.isBeta()) {
						if (var33.isMembersOnly()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var33.isDeadman()) {
						var22 = 16711680;
						if (var33.isMembersOnly()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var33.isPvp()) {
						if (var33.isMembersOnly()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var33.isMembersOnly()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var42 && MouseHandler.MouseHandler_y >= var41 && MouseHandler.MouseHandler_x < var23 + var42 && MouseHandler.MouseHandler_y < var41 + var51 && var45) {
						Login.hoveredWorldIndex = var44;
						class162.worldSelectBackSprites[var21].drawTransOverlayAt(var42, var41, 128, 16777215);
						var32 = true;
					} else {
						class162.worldSelectBackSprites[var21].drawAt(var42, var41);
					}

					if (PlayerType.worldSelectFlagSprites != null) {
						PlayerType.worldSelectFlagSprites[(var33.isMembersOnly() ? 8 : 0) + var33.location].drawAt(var42 + 29, var41);
					}

					var0.drawCentered(Integer.toString(var33.id), var42 + 15, var51 / 2 + var41 + 5, var22, -1);
					var1.drawCentered(var20, var42 + 60, var51 / 2 + var41 + 5, 268435455, -1);
					var41 = var41 + var40 + var51;
					++var31;
					if (var31 >= var6) {
						var41 = var10 + 23;
						var42 = var42 + var7 + var23;
						var31 = 0;
						++var43;
					}
				}

				if (var32) {
					var44 = var1.stringWidth(World.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					var18 = var1.ascent + 8;
					int var46 = MouseHandler.MouseHandler_y + 25;
					if (var46 + var18 > 480) {
						var46 = MouseHandler.MouseHandler_y - 25 - var18;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var44 / 2, var46, var44, var18, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var44 / 2, var46, var44, var18, 0);
					var1.drawCentered(World.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var46 + var1.ascent + 4, 0, -1);
				}
			}

			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			class191.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			HealthBar.logoSprite.drawAt(Login.xPadding + 382 - HealthBar.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var23 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
				var24 = 253 - var23;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
			}

			String var25;
			short var47;
			short var49;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var47 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
				var48 = var47 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
				var48 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
				var48 += 15;
				var48 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var48, 16777215, 0);
					var49 = 200;

					for (var25 = VerticalAlignment.method4328(); var0.stringWidth(var25) > var49; var25 = var25.substring(0, var25.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var25), Login.loginBoxX + 180 - 70, var48, 16777215, 0);
					var48 += 15;
					var0.draw("Password: " + TextureProvider.method2727(Login.Login_password), Login.loginBoxX + 180 - 108, var48, 16777215, 0);
					var48 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var5;
				if (Login.loginIndex == 0) {
					var47 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var47, 16776960, 0);
					var48 = var47 + 30;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 291;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var24 = Login.loginBoxX + 180 + 80;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var47 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16777215, 0);
					var48 = var47 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16777215, 0);
					var48 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16777215, 0);
					var48 += 15;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 321;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180 + 80;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
				} else if (Login.loginIndex == 2) {
					var47 = 201;
					var0.drawCentered(Login.Login_response1, VarcInt.loginBoxCenter, var47, 16776960, 0);
					var48 = var47 + 15;
					var0.drawCentered(Login.Login_response2, VarcInt.loginBoxCenter, var48, 16776960, 0);
					var48 += 15;
					var0.drawCentered(Login.Login_response3, VarcInt.loginBoxCenter, var48, 16776960, 0);
					var48 += 15;
					var48 += 7;
					var0.draw("Login: ", VarcInt.loginBoxCenter - 110, var48, 16777215, 0);
					var49 = 200;

					for (var25 = VerticalAlignment.method4328(); var0.stringWidth(var25) > var49; var25 = var25.substring(1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? UserComparator7.colorStartTag(16776960) + "|" : ""), VarcInt.loginBoxCenter - 70, var48, 16777215, 0);
					var48 += 15;
					String var27 = "Password: ";
					String var28 = Login.Login_password;
					String var29 = HealthBarDefinition.method4481('*', var28.length());
					var0.draw(var27 + var29 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? UserComparator7.colorStartTag(16776960) + "|" : ""), VarcInt.loginBoxCenter - 108, var48, 16777215, 0);
					var48 += 15;
					var47 = 277;
					var10 = VarcInt.loginBoxCenter + -117;
					boolean var12 = Client.Login_isUsernameRemembered;
					boolean var13 = Login.field1169;
					IndexedSprite var30 = var12 ? (var13 ? WorldMapDecoration.field202 : Login.options_buttons_2Sprite) : (var13 ? Login.field1153 : GrandExchangeOfferWorldComparator.options_buttons_0Sprite);
					var30.drawAt(var10, var47);
					var10 = var10 + var30.subWidth + 5;
					var1.draw("Remember username", var10, var47 + 13, 16776960, 0);
					var10 = VarcInt.loginBoxCenter + 24;
					boolean var16 = Actor.clientPreferences.hideUsername;
					boolean var17 = Login.field1170;
					IndexedSprite var15 = var16 ? (var17 ? WorldMapDecoration.field202 : Login.options_buttons_2Sprite) : (var17 ? Login.field1153 : GrandExchangeOfferWorldComparator.options_buttons_0Sprite);
					var15.drawAt(var10, var47);
					var10 = var10 + var15.subWidth + 5;
					var1.draw("Hide username", var10, var47 + 13, 16776960, 0);
					var48 = var47 + 15;
					var18 = VarcInt.loginBoxCenter - 80;
					short var19 = 321;
					class191.titlebuttonSprite.drawAt(var18 - 73, var19 - 20);
					var0.drawCentered("Login", var18, var19 + 5, 16777215, 0);
					var18 = VarcInt.loginBoxCenter + 80;
					class191.titlebuttonSprite.drawAt(var18 - 73, var19 - 20);
					var0.drawCentered("Cancel", var18, var19 + 5, 16777215, 0);
					var47 = 357;
					switch(Login.field1161) {
					case 2:
						class51.field405 = "Having trouble logging in?";
						break;
					default:
						class51.field405 = "Can't login? Click here.";
					}

					MusicPatchNode2.field2369 = new Bounds(VarcInt.loginBoxCenter, var47, var1.stringWidth(class51.field405), 11);
					class51.field411 = new Bounds(VarcInt.loginBoxCenter, var47, var1.stringWidth("Still having trouble logging in?"), 11);
					var1.drawCentered(class51.field405, VarcInt.loginBoxCenter, var47, 16777215, 0);
				} else if (Login.loginIndex == 3) {
					var47 = 201;
					var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var47, 16776960, 0);
					var48 = var47 + 20;
					var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var48, 16776960, 0);
					var48 += 15;
					var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var48, 16776960, 0);
					var48 += 15;
					var24 = Login.loginBoxX + 180;
					var5 = 276;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180;
					var5 = 326;
					class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
				} else {
					short var8;
					if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var47 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16777215, 0);
						var48 = var47 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16777215, 0);
						var48 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16777215, 0);
						var48 += 15;
						var0.draw("PIN: " + TextureProvider.method2727(class81.otp) + (Client.cycle % 40 < 20 ? UserComparator7.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var48, 16777215, 0);
						var48 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var48, 16776960, 0);
						var48 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var48, 16776960, 0);
						var24 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						var36 = var48 - var0.ascent;
						IndexedSprite var26;
						if (Login.field1183) {
							var26 = Login.options_buttons_2Sprite;
						} else {
							var26 = GrandExchangeOfferWorldComparator.options_buttons_0Sprite;
						}

						var26.drawAt(var24, var36);
						var48 += 15;
						var7 = Login.loginBoxX + 180 - 80;
						var8 = 321;
						class191.titlebuttonSprite.drawAt(var7 - 73, var8 - 20);
						var0.drawCentered("Continue", var7, var8 + 5, 16777215, 0);
						var7 = Login.loginBoxX + 180 + 80;
						class191.titlebuttonSprite.drawAt(var7 - 73, var8 - 20);
						var0.drawCentered("Cancel", var7, var8 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var8 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var47 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
						var48 = var47 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var48 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var48, 16777215, 0);
						var49 = 174;

						for (var25 = VerticalAlignment.method4328(); var0.stringWidth(var25) > var49; var25 = var25.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var25) + (Client.cycle % 40 < 20 ? UserComparator7.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var48, 16777215, 0);
						var48 += 15;
						var6 = Login.loginBoxX + 180 - 80;
						short var38 = 321;
						class191.titlebuttonSprite.drawAt(var6 - 73, var38 - 20);
						var0.drawCentered("Recover", var6, var38 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180 + 80;
						class191.titlebuttonSprite.drawAt(var6 - 73, var38 - 20);
						var0.drawCentered("Back", var6, var38 + 5, 16777215, 0);
						var38 = 356;
						var1.drawCentered("Still having trouble logging in?", VarcInt.loginBoxCenter, var38, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var47 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16776960, 0);
						var48 = var47 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 321;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var47 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var47, 16776960, 0);
						var48 = var47 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var47 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var47, 16776960, 0);
						var48 = var47 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var47 = 201;
						String var4 = "";
						var25 = "";
						String var50 = "";
						switch(Login.field1156) {
						case 0:
							var4 = "Your account has been disabled.";
							var25 = Strings.field2863;
							var50 = "";
							break;
						case 1:
							var4 = "Account locked as we suspect it has been stolen.";
							var25 = Strings.field3016;
							var50 = "";
							break;
						default:
							WorldMapID.method520(false);
						}

						var0.drawCentered(var4, Login.loginBoxX + 180, var47, 16776960, 0);
						var48 = var47 + 15;
						var2.drawCentered(var25, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var2.drawCentered(var50, Login.loginBoxX + 180, var48, 16776960, 0);
						var48 += 15;
						var7 = Login.loginBoxX + 180;
						var8 = 276;
						class191.titlebuttonSprite.drawAt(var7 - 73, var8 - 20);
						var0.drawCentered("Support Page", var7, var8 + 5, 16777215, 0);
						var7 = Login.loginBoxX + 180;
						var8 = 326;
						class191.titlebuttonSprite.drawAt(var7 - 73, var8 - 20);
						var0.drawCentered("Back", var7, var8 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var47 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var47, 16777215, 0);
						var48 = var47 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var48, 16777215, 0);
						var48 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var48, 16777215, 0);
						var48 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 301;
						class191.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var3 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var3);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, canvasHeight);
				UserComparator5.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				UserComparator5.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var3);
			}

			FileSystem.title_muteSprite[Actor.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == class43.clientLanguage) {
				if (GrandExchangeOfferWorldComparator.field32 != null) {
					var48 = Login.xPadding + 5;
					var49 = 463;
					byte var39 = 100;
					byte var37 = 35;
					GrandExchangeOfferWorldComparator.field32.drawAt(var48, var49);
					var0.drawCentered("World" + " " + Client.worldId, var39 / 2 + var48, var37 / 2 + var49 - 2, 16777215, 0);
					if (RouteStrategy.World_request != null) {
						var1.drawCentered("Loading...", var39 / 2 + var48, var37 / 2 + var49 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var39 / 2 + var48, var37 / 2 + var49 + 12, 16777215, 0);
					}
				} else {
					GrandExchangeOfferWorldComparator.field32 = Interpreter.SpriteBuffer_getIndexedSpriteByName(WorldMapDecoration.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1651164441"
	)
	public static int method951(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}
}
