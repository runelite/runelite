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

@ObfuscatedName("bg")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lff;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lbg;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1568380543
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = -3934802970152503561L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("v")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1371255407
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1482162353
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 808514129
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lfk;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("h")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("j")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = 1342168007
	)
	static int field442;
	@ObfuscatedName("af")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		longValue = -177025641845415175L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		longValue = -5558564081282193119L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("l")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -204703651
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 392229745
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1066655429
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1472937073
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 656950483
	)
	int field435;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 144301553
	)
	int field419;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1666707357
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -298093883
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("ag")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("ak")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("av")
	volatile boolean field441;
	@ObfuscatedName("ax")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("al")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		longValue = 1167951270454872895L
	)
	volatile long field445;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "Laf;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("ah")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("an")
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
		field442 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field441 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field445 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		class297.method5550(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2135691733"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method1012();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "1374052820"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				ClanChat.method5367(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Lfl;",
		garbageValue = "304684246"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1135938442"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "18"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-36"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		GrandExchangeEvents.method110();
		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-878530927"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-31"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field435);
			this.contentHeight = Math.max(var2.highY, this.field419);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			class286.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			FloorUnderlayDefinition.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - class286.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(class286.canvasWidth, FloorUnderlayDefinition.canvasHeight);
			AbstractWorldMapData.rasterProvider = new RasterProvider(class286.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field441 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2060332880"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-77"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - class286.canvasWidth - var1;
		int var4 = this.contentHeight - FloorUnderlayDefinition.canvasHeight - var2;
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

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1138022384"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		java.awt.Canvas var1 = this.canvas;
		var1.removeKeyListener(KeyHandler.KeyHandler_instance);
		var1.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field380 = -1;
		KeyHandler.method914(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		java.awt.Canvas var2 = this.canvas;
		var2.setFocusTraversalKeysEnabled(false);
		var2.addKeyListener(KeyHandler.KeyHandler_instance);
		var2.addFocusListener(KeyHandler.KeyHandler_instance);
		java.awt.Canvas var3 = this.canvas;
		var3.addMouseListener(MouseHandler.MouseHandler_instance);
		var3.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var3.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method1012();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-122"
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
			class286.canvasWidth = var1;
			FloorUnderlayDefinition.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			User.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1386190897"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		class286.canvasWidth = Math.max(var1.getWidth(), this.field435);
		FloorUnderlayDefinition.canvasHeight = Math.max(var1.getHeight(), this.field419);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			class286.canvasWidth -= var2.left + var2.right;
			FloorUnderlayDefinition.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(class286.canvasWidth, FloorUnderlayDefinition.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(var2.left + this.canvasX, var2.top + this.canvasY);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.field441 = true;
		if (AbstractWorldMapData.rasterProvider != null && class286.canvasWidth == AbstractWorldMapData.rasterProvider.width && FloorUnderlayDefinition.canvasHeight == AbstractWorldMapData.rasterProvider.height) {
			((RasterProvider)AbstractWorldMapData.rasterProvider).setComponent(this.canvas);
			AbstractWorldMapData.rasterProvider.drawFull(0, 0);
		} else {
			AbstractWorldMapData.rasterProvider = new RasterProvider(class286.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field445 = PlayerAppearance.currentTimeMillis();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "927173753"
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

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = PlayerAppearance.currentTimeMillis();
		long var3 = clientTickTimes[class49.clientTickTimeIdx];
		clientTickTimes[class49.clientTickTimeIdx] = var1;
		class49.clientTickTimeIdx = class49.clientTickTimeIdx + 1 & 31;
		if (0L != var3 && var1 > var3) {
		}

		synchronized(this) {
			class30.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "4"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = PlayerAppearance.currentTimeMillis();
		long var4 = graphicsTickTimes[Messages.graphicsTickTimeIdx];
		graphicsTickTimes[Messages.graphicsTickTimeIdx] = var2;
		Messages.graphicsTickTimeIdx = Messages.graphicsTickTimeIdx + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field442 - 1 > 50) {
			field442 -= 50;
			this.field441 = true;
			this.canvas.setSize(class286.canvasWidth, FloorUnderlayDefinition.canvasHeight);
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

		this.method1011();
		this.draw(this.field441);
		if (this.field441) {
			this.clearBackground();
		}

		this.field441 = false;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2098606310"
	)
	final void method1011() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "65535"
	)
	final void method1012() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "26"
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

			this.vmethod1393();
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1799342365"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-127"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1361952953"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1838623985"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "74"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (GrandExchangeOffer.fontHelvetica13 == null) {
				GrandExchangeOffer.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class30.loginScreenFontMetrics = this.canvas.getFontMetrics(GrandExchangeOffer.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, class286.canvasWidth, FloorUnderlayDefinition.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (World.field996 == null) {
					World.field996 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = World.field996.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(GrandExchangeOffer.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class30.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(World.field996, class286.canvasWidth / 2 - 152, FloorUnderlayDefinition.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = class286.canvasWidth / 2 - 152;
				int var8 = FloorUnderlayDefinition.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(GrandExchangeOffer.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class30.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "807770545"
	)
	protected final void method1029() {
		World.field996 = null;
		GrandExchangeOffer.fontHelvetica13 = null;
		class30.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-32"
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "-1606453002"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "-1228957997"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field435);
		int var3 = Math.max(var1.getHeight(), this.field419);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.left + var4.right;
			var3 -= var4.top + var4.bottom;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "95"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-22"
	)
	protected abstract void vmethod1393();

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = PlayerAppearance.currentTimeMillis();
			ClanChat.method5367(5000L);
			this.kill();
		}
	}

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field441 = true;
			if (PlayerAppearance.currentTimeMillis() - this.field445 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= class286.canvasWidth && var2.height >= FloorUnderlayDefinition.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
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
						for (var3 = 6; var3 < var2.length() && ClientPacket.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (AbstractWorldMapData.isNumber(var4) && ClientPreferences.parseInt(var4) < 10) {
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

			Object var8;
			try {
				var8 = new NanoClock();
			} catch (Throwable var6) {
				var8 = new MilliClock();
			}

			clock = (Clock)var8;

			while (stopTimeMs == 0L || PlayerAppearance.currentTimeMillis() < stopTimeMs) {
				ArchiveLoader.gameCyclesToDo = clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < ArchiveLoader.gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var7) {
			User.RunException_sendStackTrace((String)null, var7);
			this.error("crash");
		}

		this.kill();
	}

	public final void start() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = PlayerAppearance.currentTimeMillis() + 4000L;
		}
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field441 = true;
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1395167338"
	)
	static void method1141() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				FloorUnderlayDefinition.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				FloorUnderlayDefinition.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-459731769"
	)
	static int method1142(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = PacketBufferNode.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class96.field1301 : ReflectionCheck.field1310;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1080 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field550 = Interpreter.field1080 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}
}
