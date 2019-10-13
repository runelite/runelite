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

@ObfuscatedName("bh")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("rx")
	@ObfuscatedGetter(
		intValue = 41369600
	)
	static int field455;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lbh;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1510935923
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		longValue = -6691432732698375703L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("r")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1528666585
	)
	@Export("gameCyclesToDo")
	static int gameCyclesToDo;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1545406367
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1198168777
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1818100921
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lfz;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("a")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("t")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -1408016773
	)
	static int field443;
	@ObfuscatedName("av")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		longValue = -3573600455328537839L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		longValue = -7014184548821540431L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("p")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1930363707
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1513929399
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 618502281
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1744199249
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 2108655365
	)
	int field436;
	@ObfuscatedName("ac")
	@ObfuscatedGetter(
		intValue = -569680121
	)
	int field437;
	@ObfuscatedName("az")
	@ObfuscatedGetter(
		intValue = -1457123993
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -587207601
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("ar")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("ab")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("ax")
	volatile boolean field420;
	@ObfuscatedName("al")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("ad")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		longValue = -4063357795447176907L
	)
	volatile long field446;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "Lav;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("am")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("ae")
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
		field443 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field420 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field446 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		WorldMapDecoration.method345(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1753820196"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method955();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "669071767"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				try {
					Thread.sleep(1L);
				} catch (InterruptedException var4) {
				}
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)Lft;",
		garbageValue = "-133806221"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2040782454"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-23270963"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1635814939"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		Skills.method4088();
		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		class43.method838(this.canvas);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "684720685"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field436);
			this.contentHeight = Math.max(var2.highY, this.field437);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			FloorDecoration.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			WallDecoration.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - FloorDecoration.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(FloorDecoration.canvasWidth, WallDecoration.canvasHeight);
			class42.rasterProvider = new RasterProvider(FloorDecoration.canvasWidth, WallDecoration.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field420 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2027797509"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1270672810"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - FloorDecoration.canvasWidth - var1;
		int var4 = this.contentHeight - WallDecoration.canvasHeight - var2;
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

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "147"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		class83.method2069(this.canvas);
		CollisionMap.method3544(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		java.awt.Canvas var1 = this.canvas;
		var1.setFocusTraversalKeysEnabled(false);
		var1.addKeyListener(KeyHandler.KeyHandler_instance);
		var1.addFocusListener(KeyHandler.KeyHandler_instance);
		class43.method838(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method955();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-2112987351"
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
			FloorDecoration.canvasWidth = var1;
			WallDecoration.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			class32.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "338"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		FloorDecoration.canvasWidth = Math.max(var1.getWidth(), this.field436);
		WallDecoration.canvasHeight = Math.max(var1.getHeight(), this.field437);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			FloorDecoration.canvasWidth -= var2.right + var2.left;
			WallDecoration.canvasHeight -= var2.bottom + var2.top;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(FloorDecoration.canvasWidth, WallDecoration.canvasHeight);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.BLACK);
		if (var1 == this.frame) {
			var2 = this.frame.getInsets();
			this.canvas.setLocation(var2.left + this.canvasX, this.canvasY + var2.top);
		} else {
			this.canvas.setLocation(this.canvasX, this.canvasY);
		}

		this.canvas.addFocusListener(this);
		this.canvas.requestFocus();
		this.field420 = true;
		if (class42.rasterProvider != null && FloorDecoration.canvasWidth == class42.rasterProvider.width && WallDecoration.canvasHeight == class42.rasterProvider.height) {
			((RasterProvider)class42.rasterProvider).setComponent(this.canvas);
			class42.rasterProvider.drawFull(0, 0);
		} else {
			class42.rasterProvider = new RasterProvider(FloorDecoration.canvasWidth, WallDecoration.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field446 = class30.currentTimeMillis();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1598778852"
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1775618326"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = class30.currentTimeMillis();
		long var3 = clientTickTimes[WorldMapID.clientTickTimeIdx];
		clientTickTimes[WorldMapID.clientTickTimeIdx] = var1;
		WorldMapID.clientTickTimeIdx = WorldMapID.clientTickTimeIdx + 1 & 31;
		if (0L != var3 && var1 > var3) {
		}

		synchronized(this) {
			TaskHandler.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2138228896"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = class30.currentTimeMillis();
		long var4 = graphicsTickTimes[Varcs.graphicsTickTimeIdx];
		graphicsTickTimes[Varcs.graphicsTickTimeIdx] = var2;
		Varcs.graphicsTickTimeIdx = Varcs.graphicsTickTimeIdx + 1 & 31;
		if (var4 != 0L && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field443 - 1 > 50) {
			field443 -= 50;
			this.field420 = true;
			this.canvas.setSize(FloorDecoration.canvasWidth, WallDecoration.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var7.left, var7.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method957();
		this.draw(this.field420);
		if (this.field420) {
			this.clearBackground();
		}

		this.field420 = false;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "26"
	)
	final void method957() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1152400885"
	)
	final void method955() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "65280"
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

			this.vmethod1307();
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "16"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-60"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1679134607"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "87"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "-67"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (SequenceDefinition.fontHelvetica13 == null) {
				SequenceDefinition.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				FloorOverlayDefinition.loginScreenFontMetrics = this.canvas.getFontMetrics(SequenceDefinition.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, FloorDecoration.canvasWidth, WallDecoration.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class81.field1127 == null) {
					class81.field1127 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class81.field1127.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(SequenceDefinition.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - FloorOverlayDefinition.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class81.field1127, FloorDecoration.canvasWidth / 2 - 152, WallDecoration.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = FloorDecoration.canvasWidth / 2 - 152;
				int var8 = WallDecoration.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(SequenceDefinition.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - FloorOverlayDefinition.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2129811981"
	)
	protected final void method1024() {
		class81.field1127 = null;
		SequenceDefinition.fontHelvetica13 = null;
		FloorOverlayDefinition.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "0"
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

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(B)Ljava/awt/Container;",
		garbageValue = "-78"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(B)Lll;",
		garbageValue = "0"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field436);
		int var3 = Math.max(var1.getHeight(), this.field437);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.left + var4.right;
			var3 -= var4.top + var4.bottom;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "97221829"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2052837160"
	)
	protected abstract void vmethod1307();

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = class30.currentTimeMillis();
			long var1 = 4999L;

			try {
				Thread.sleep(var1);
			} catch (InterruptedException var5) {
			}

			try {
				Thread.sleep(1L);
			} catch (InterruptedException var4) {
			}

			this.kill();
		}
	}

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field420 = true;
			if (class30.currentTimeMillis() - this.field446 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= FloorDecoration.canvasWidth && var2.height >= WallDecoration.canvasHeight) {
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
						for (var3 = 6; var3 < var2.length() && AbstractWorldMapIcon.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (NetSocket.isNumber(var4) && TilePaint.parseInt(var4) < 10) {
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
			clock = ItemContainer.newClock();

			while (0L == stopTimeMs || class30.currentTimeMillis() < stopTimeMs) {
				gameCyclesToDo = clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			class32.RunException_sendStackTrace((String)null, var6);
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
			stopTimeMs = class30.currentTimeMillis() + 4000L;
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field420 = true;
	}

	@ObfuscatedName("ik")
	@ObfuscatedSignature(
		signature = "([Lho;Lho;ZI)V",
		garbageValue = "-55146374"
	)
	@Export("revalidateWidgetScroll")
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth : var1.width;
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight : var1.height;
		FaceNormal.resizeInterface(var0, var1.id, var3, var4, var2);
		if (var1.children != null) {
			FaceNormal.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}

		InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
		if (var5 != null) {
			class247.resizeComponents(var5.group, var3, var4, var2);
		}

		if (var1.contentType == 1337) {
		}

	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "1376272907"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		class4.scrollBarSprites[0].drawAt(var0, var1);
		class4.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field699);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field700);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field702);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field702);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field702);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field702);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field701);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field701);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field701);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field701);
	}
}
