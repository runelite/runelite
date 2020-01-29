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

@ObfuscatedName("bf")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lff;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lbf;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 196022413
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = 528235064491181747L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("i")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1437299021
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1661201835
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 71022173
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("v")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1251279017
	)
	@Export("graphicsTickTimeIdx")
	static int graphicsTickTimeIdx;
	@ObfuscatedName("k")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("ax")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -2072327309
	)
	static int field467;
	@ObfuscatedName("ao")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("ag")
	@ObfuscatedGetter(
		longValue = 8963656007047949345L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		longValue = 9016661795378889985L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("bw")
	static String field477;
	@ObfuscatedName("g")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1999078243
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1778726039
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1382967399
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2050862529
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 2042423139
	)
	int field459;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 96857059
	)
	int field464;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -460678809
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = 875531909
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("au")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("ay")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("aa")
	volatile boolean field466;
	@ObfuscatedName("ak")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("ac")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		longValue = -8817424516804380497L
	)
	volatile long field470;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("ad")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("am")
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
		graphicsTickTimes = new long[32];
		clientTickTimes = new long[32];
		field467 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field466 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field470 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		UserComparator9.method3462(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-184957247"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method947();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "-1941582772"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				FriendLoginUpdate.method5325(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)Lfi;",
		garbageValue = "-1591236478"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "75"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "794890574"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1563804954"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		UserComparator4.method3451();
		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1024883115"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1230297818"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field459);
			this.contentHeight = Math.max(var2.highY, this.field464);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			Username.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			WorldMapData_1.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - Username.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(Username.canvasWidth, WorldMapData_1.canvasHeight);
			DevicePcmPlayerProvider.rasterProvider = new RasterProvider(Username.canvasWidth, WorldMapData_1.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field466 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1781530375"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1864888047"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - Username.canvasWidth - var1;
		int var4 = this.contentHeight - WorldMapData_1.canvasHeight - var2;
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

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-557275570"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		java.awt.Canvas var1 = this.canvas;
		var1.removeKeyListener(KeyHandler.KeyHandler_instance);
		var1.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field387 = -1;
		java.awt.Canvas var2 = this.canvas;
		var2.removeMouseListener(MouseHandler.MouseHandler_instance);
		var2.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		java.awt.Canvas var3 = this.canvas;
		var3.setFocusTraversalKeysEnabled(false);
		var3.addKeyListener(KeyHandler.KeyHandler_instance);
		var3.addFocusListener(KeyHandler.KeyHandler_instance);
		BuddyRankComparator.method3505(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method947();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "0"
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
			Username.canvasWidth = var1;
			WorldMapData_1.canvasHeight = var2;
			GZipDecompressor.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			class225.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "6"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		Username.canvasWidth = Math.max(var1.getWidth(), this.field459);
		WorldMapData_1.canvasHeight = Math.max(var1.getHeight(), this.field464);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			Username.canvasWidth -= var2.left + var2.right;
			WorldMapData_1.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(Username.canvasWidth, WorldMapData_1.canvasHeight);
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
		this.field466 = true;
		if (DevicePcmPlayerProvider.rasterProvider != null && Username.canvasWidth == DevicePcmPlayerProvider.rasterProvider.width && WorldMapData_1.canvasHeight == DevicePcmPlayerProvider.rasterProvider.height) {
			((RasterProvider)DevicePcmPlayerProvider.rasterProvider).setComponent(this.canvas);
			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
		} else {
			DevicePcmPlayerProvider.rasterProvider = new RasterProvider(Username.canvasWidth, WorldMapData_1.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field470 = WorldMapIcon_0.currentTimeMillis();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1249538229"
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

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "34"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = WorldMapIcon_0.currentTimeMillis();
		long var3 = clientTickTimes[class14.clientTickTimeIdx];
		clientTickTimes[class14.clientTickTimeIdx] = var1;
		class14.clientTickTimeIdx = class14.clientTickTimeIdx + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			GrandExchangeOfferTotalQuantityComparator.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "44654688"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = WorldMapIcon_0.currentTimeMillis();
		long var4 = graphicsTickTimes[graphicsTickTimeIdx];
		graphicsTickTimes[graphicsTickTimeIdx] = var2;
		graphicsTickTimeIdx = graphicsTickTimeIdx + 1 & 31;
		if (var4 != 0L && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field467 - 1 > 50) {
			field467 -= 50;
			this.field466 = true;
			this.canvas.setSize(Username.canvasWidth, WorldMapData_1.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var7.left, this.canvasY + var7.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method938();
		this.draw(this.field466);
		if (this.field466) {
			this.clearBackground();
		}

		this.field466 = false;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "847743243"
	)
	final void method938() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || var1.highY != this.contentHeight || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-92"
	)
	final void method947() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-46"
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

			this.vmethod1478();
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "159835862"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1684911639"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1486807503"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2144356516"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZI)V",
		garbageValue = "-1421329320"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (fontHelvetica13 == null) {
				fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class42.loginScreenFontMetrics = this.canvas.getFontMetrics(fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, Username.canvasWidth, WorldMapData_1.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (WorldMapRegion.field254 == null) {
					WorldMapRegion.field254 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = WorldMapRegion.field254.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class42.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(WorldMapRegion.field254, Username.canvasWidth / 2 - 152, WorldMapData_1.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = Username.canvasWidth / 2 - 152;
				int var8 = WorldMapData_1.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class42.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-36"
	)
	protected final void method952() {
		WorldMapRegion.field254 = null;
		fontHelvetica13 = null;
		class42.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-33"
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

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "103754322"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)Lll;",
		garbageValue = "1892805538"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field459);
		int var3 = Math.max(var1.getHeight(), this.field464);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "101"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-2"
	)
	protected abstract void vmethod1478();

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field466 = true;
			if (WorldMapIcon_0.currentTimeMillis() - this.field470 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= Username.canvasWidth && var2.height >= WorldMapData_1.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = WorldMapIcon_0.currentTimeMillis();
			FriendLoginUpdate.method5325(5000L);
			this.kill();
		}
	}

	public final void start() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field466 = true;
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = WorldMapIcon_0.currentTimeMillis() + 4000L;
		}
	}

	public abstract void init();

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public void run() {
		try {
			if (TaskHandler.javaVendor != null) {
				String var1 = TaskHandler.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = class216.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length() && class14.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (class248.isNumber(var4) && VerticalAlignment.parseInt(var4) < 10) {
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
			clock = Client.method1432();

			while (stopTimeMs == 0L || WorldMapIcon_0.currentTimeMillis() < stopTimeMs) {
				Fonts.gameCyclesToDo = clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < Fonts.gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class225.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lii;II)Lgr;",
		garbageValue = "-1004911552"
	)
	static MusicPatch method1067(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		return var2 == null ? null : new MusicPatch(var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "-32048125"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + TextureProvider.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIZII)J",
		garbageValue = "1623349797"
	)
	@Export("calculateTag")
	public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
		long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var5 |= 65536L;
		}

		return var5;
	}

	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "856923102"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		if (var0 == -3) {
			Tiles.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			Tiles.setLoginResponseString("Error connecting to server.", "Please try using a different world.", "");
		} else if (var0 == -1) {
			Tiles.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1193 = 1;
		} else if (var0 == 4) {
			Login.loginIndex = 12;
			Login.field1165 = 0;
		} else if (var0 == 5) {
			Login.field1193 = 2;
			Tiles.setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			Tiles.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			Tiles.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			Tiles.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			Tiles.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			Tiles.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			Tiles.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			Tiles.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			Tiles.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			Tiles.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			Tiles.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			Tiles.setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			Login.loginIndex = 12;
			Login.field1165 = 1;
		} else if (var0 == 19) {
			Tiles.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			Tiles.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			Tiles.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			Tiles.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			Tiles.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			Tiles.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			Tiles.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			Tiles.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			Tiles.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			Tiles.setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			Tiles.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			Tiles.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				Tiles.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				Projectile.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				Tiles.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				Projectile.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				Tiles.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		Projectile.updateGameState(10);
	}
}
