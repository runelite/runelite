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
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bw")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("ra")
	@ObfuscatedGetter(
		intValue = 714484919
	)
	static int field446;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lbw;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2058939599
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -5623486627210401515L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("u")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -205705569
	)
	protected static int field413;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1354464911
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -986211423
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1118839049
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	@Export("clock")
	protected static Clock clock;
	@ObfuscatedName("p")
	protected static long[] field423;
	@ObfuscatedName("g")
	protected static long[] field417;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = 868948239
	)
	static int field436;
	@ObfuscatedName("aq")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		longValue = -299899639913478455L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		longValue = 3151603748493899241L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("dk")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive12")
	static Archive archive12;
	@ObfuscatedName("eg")
	@ObfuscatedGetter(
		intValue = -225444477
	)
	static int field425;
	@ObfuscatedName("n")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -2070164479
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1790253551
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1852258925
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 115241741
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1396606465
	)
	int field429;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = 1761285899
	)
	int field428;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 554974645
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 890524941
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("aj")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("an")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("at")
	volatile boolean field435;
	@ObfuscatedName("ao")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("ac")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		longValue = -267626387501554735L
	)
	volatile long field424;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "Laq;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("aa")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("ap")
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
		field423 = new long[32];
		field417 = new long[32];
		field436 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field435 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field424 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		ViewportMouse.method2891(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1609844156"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method880();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "1177266220"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				UserList.sleepMillis(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Lfo;",
		garbageValue = "61"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "976986957"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "406545365"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		if (TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
			KeyHandler.KeyHandler_keyCodes[186] = 57;
			KeyHandler.KeyHandler_keyCodes[187] = 27;
			KeyHandler.KeyHandler_keyCodes[188] = 71;
			KeyHandler.KeyHandler_keyCodes[189] = 26;
			KeyHandler.KeyHandler_keyCodes[190] = 72;
			KeyHandler.KeyHandler_keyCodes[191] = 73;
			KeyHandler.KeyHandler_keyCodes[192] = 58;
			KeyHandler.KeyHandler_keyCodes[219] = 42;
			KeyHandler.KeyHandler_keyCodes[220] = 74;
			KeyHandler.KeyHandler_keyCodes[221] = 43;
			KeyHandler.KeyHandler_keyCodes[222] = 59;
			KeyHandler.KeyHandler_keyCodes[223] = 28;
		} else {
			KeyHandler.KeyHandler_keyCodes[44] = 71;
			KeyHandler.KeyHandler_keyCodes[45] = 26;
			KeyHandler.KeyHandler_keyCodes[46] = 72;
			KeyHandler.KeyHandler_keyCodes[47] = 73;
			KeyHandler.KeyHandler_keyCodes[59] = 57;
			KeyHandler.KeyHandler_keyCodes[61] = 27;
			KeyHandler.KeyHandler_keyCodes[91] = 42;
			KeyHandler.KeyHandler_keyCodes[92] = 74;
			KeyHandler.KeyHandler_keyCodes[93] = 43;
			KeyHandler.KeyHandler_keyCodes[192] = 28;
			KeyHandler.KeyHandler_keyCodes[222] = 58;
			KeyHandler.KeyHandler_keyCodes[520] = 59;
		}

		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1643960217"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		SecureRandomFuture.method2061(this.canvas);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1946782906"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field429);
			this.contentHeight = Math.max(var2.highY, this.field428);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			KitDefinition.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			class30.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - KitDefinition.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(KitDefinition.canvasWidth, class30.canvasHeight);
			SpotAnimationDefinition.rasterProvider = new RasterProvider(KitDefinition.canvasWidth, class30.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, var3.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field435 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1917236425"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "159297486"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - KitDefinition.canvasWidth - var1;
		int var4 = this.contentHeight - class30.canvasHeight - var2;
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

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-715138989"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		ParamDefinition.method4420(this.canvas);
		class195.method3629(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
		java.awt.Canvas var2 = this.canvas;
		var2.addMouseListener(MouseHandler.MouseHandler_instance);
		var2.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method880();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-56"
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
			KitDefinition.canvasWidth = var1;
			class30.canvasHeight = var2;
			class208.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			class3.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "5178053"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		KitDefinition.canvasWidth = Math.max(var1.getWidth(), this.field429);
		class30.canvasHeight = Math.max(var1.getHeight(), this.field428);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			KitDefinition.canvasWidth -= var2.right + var2.left;
			class30.canvasHeight -= var2.bottom + var2.top;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(KitDefinition.canvasWidth, class30.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(this.canvasX + var2.left, var2.top + this.canvasY);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.field435 = true;
		if (SpotAnimationDefinition.rasterProvider != null && KitDefinition.canvasWidth == SpotAnimationDefinition.rasterProvider.width && class30.canvasHeight == SpotAnimationDefinition.rasterProvider.height) {
			((RasterProvider)SpotAnimationDefinition.rasterProvider).setComponent(this.canvas);
			SpotAnimationDefinition.rasterProvider.drawFull(0, 0);
		} else {
			SpotAnimationDefinition.rasterProvider = new RasterProvider(KitDefinition.canvasWidth, class30.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field424 = SequenceDefinition.method4686();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2140072733"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "276918533"
	)
	void method877() {
		long var1 = SequenceDefinition.method4686();
		long var3 = field417[class319.field3846];
		field417[class319.field3846] = var1;
		class319.field3846 = class319.field3846 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			class3.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1961975804"
	)
	void method878() {
		Container var1 = this.container();
		long var2 = SequenceDefinition.method4686();
		long var4 = field423[class40.field330];
		field423[class40.field330] = var2;
		class40.field330 = class40.field330 + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field436 - 1 > 50) {
			field436 -= 50;
			this.field435 = true;
			this.canvas.setSize(KitDefinition.canvasWidth, class30.canvasHeight);
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

		this.method925();
		this.draw(this.field435);
		if (this.field435) {
			this.clearBackground();
		}

		this.field435 = false;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "63"
	)
	final void method925() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1905198552"
	)
	final void method880() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-97"
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

			this.vmethod1655();
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1264140224"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "712398470"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "2115085971"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1993845226"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZI)V",
		garbageValue = "-1643615386"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (WorldMapData_1.fontHelvetica13 == null) {
				WorldMapData_1.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				HealthBarUpdate.loginScreenFontMetrics = this.canvas.getFontMetrics(WorldMapData_1.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, KitDefinition.canvasWidth, class30.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (GrandExchangeOfferUnitPriceComparator.field74 == null) {
					GrandExchangeOfferUnitPriceComparator.field74 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = GrandExchangeOfferUnitPriceComparator.field74.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(WorldMapData_1.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - HealthBarUpdate.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(GrandExchangeOfferUnitPriceComparator.field74, KitDefinition.canvasWidth / 2 - 152, class30.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = KitDefinition.canvasWidth / 2 - 152;
				int var8 = class30.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(WorldMapData_1.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - HealthBarUpdate.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1281252486"
	)
	protected final void method891() {
		GrandExchangeOfferUnitPriceComparator.field74 = null;
		WorldMapData_1.fontHelvetica13 = null;
		HealthBarUpdate.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-1919436562"
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

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "-133476889"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(B)Llh;",
		garbageValue = "0"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field429);
		int var3 = Math.max(var1.getHeight(), this.field428);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1028625375"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1142845100"
	)
	protected abstract void vmethod1655();

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = SequenceDefinition.method4686();
			UserList.sleepMillis(5000L);
			this.kill();
		}
	}

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field435 = true;
			if (SequenceDefinition.method4686() - this.field424 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= KitDefinition.canvasWidth && var2.height >= class30.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void start() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = SequenceDefinition.method4686() + 4000L;
		}
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field435 = true;
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public final void windowIconified(WindowEvent var1) {
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
						for (var3 = 6; var3 < var2.length() && NetCache.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (TaskHandler.isNumber(var4) && WallDecoration.parseInt(var4) < 10) {
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
			clock = Bounds.newClock();

			while (stopTimeMs == 0L || SequenceDefinition.method4686() < stopTimeMs) {
				field413 = clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < field413; ++var5) {
					this.method877();
				}

				this.method878();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class3.RunException_sendStackTrace((String)null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lif;",
		garbageValue = "-2072465026"
	)
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition)KitDefinition.KitDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class297.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			KitDefinition.KitDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I[BLkv;I)V",
		garbageValue = "-651832532"
	)
	static void method1005(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3124 == 0) {
				class13.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class13.ArchiveDiskActionHandler_thread.setDaemon(true);
				class13.ArchiveDiskActionHandler_thread.start();
				class13.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3124 = 600;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/io/File;ZB)Z",
		garbageValue = "1"
	)
	@Export("testReadWritePermissions")
	public static boolean testReadWritePermissions(File var0, boolean var1) {
		try {
			RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
			int var3 = var2.read();
			var2.seek(0L);
			var2.write(var3);
			var2.seek(0L);
			var2.close();
			if (var1) {
				var0.delete();
			}

			return true;
		} catch (Exception var4) {
			return false;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lls;",
		garbageValue = "-575278819"
	)
	static Sprite[] method897() {
		Sprite[] var0 = new Sprite[class325.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class325.SpriteBuffer_spriteCount; ++var1) {
			Sprite var2 = var0[var1] = new Sprite();
			var2.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
			var2.height = class325.SpriteBuffer_spriteHeight;
			var2.xOffset = class325.SpriteBuffer_xOffsets[var1];
			var2.yOffset = class325.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class325.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = class225.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = WorldMapSection1.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class325.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		UserComparator7.SpriteBuffer_clear();
		return var0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "853473447"
	)
	static int method1003(int var0, Script var1, boolean var2) {
		Widget var3 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("id")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "153547504"
	)
	@Export("resumePauseWidget")
	static void resumePauseWidget(int var0, int var1) {
		PacketBufferNode var2 = MenuAction.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeIntLE16(var0);
		var2.packetBuffer.method5443(var1);
		Client.packetWriter.addNode(var2);
	}
}
