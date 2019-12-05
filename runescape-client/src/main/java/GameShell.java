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

@ObfuscatedName("bo")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lbo;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1923689957
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		longValue = -711950158356493609L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("z")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 844501225
	)
	@Export("gameCyclesToDo")
	protected static int gameCyclesToDo;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1954278037
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 814037945
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 526235567
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("r")
	@Export("graphicsTickTimes")
	protected static long[] graphicsTickTimes;
	@ObfuscatedName("a")
	@Export("clientTickTimes")
	protected static long[] clientTickTimes;
	@ObfuscatedName("ai")
	@Export("fontHelvetica13")
	static java.awt.Font fontHelvetica13;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -150498005
	)
	static int field459;
	@ObfuscatedName("ap")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		longValue = 7372771313492696971L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		longValue = 6756916101787281109L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("p")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -547568387
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 683939377
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 719542385
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1012759109
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1249070367
	)
	int field442;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = 1228347859
	)
	int field455;
	@ObfuscatedName("ad")
	@ObfuscatedGetter(
		intValue = 895763941
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		intValue = 1882164127
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("ao")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("aw")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("ak")
	volatile boolean field451;
	@ObfuscatedName("ar")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("av")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		longValue = -6875842226424781075L
	)
	volatile long field463;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "Lap;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("ae")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("aj")
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
		field459 = 500;
		volatileFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field451 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field463 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		WorldMapLabel.method433(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "744575449"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method947();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "-391960941"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)Lfk;",
		garbageValue = "-1514990609"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1232345027"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "724915000"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2141966350"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		GrandExchangeOfferNameComparator.method153();
		class14.method178(this.canvas);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-47"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		VarcInt.method4484(this.canvas);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1570451977"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field442);
			this.contentHeight = Math.max(var2.highY, this.field455);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			BoundaryObject.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			WorldMapCacheName.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - BoundaryObject.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight);
			DirectByteArrayCopier.rasterProvider = new RasterProvider(BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field451 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1452127908"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "14"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - BoundaryObject.canvasWidth - var1;
		int var4 = this.contentHeight - WorldMapCacheName.canvasHeight - var2;
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

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1864925789"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		GrandExchangeOffer.method129(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.removeMouseListener(MouseHandler.MouseHandler_instance);
		var1.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		class14.method178(this.canvas);
		VarcInt.method4484(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method947();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIIB)V",
		garbageValue = "-97"
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
			BoundaryObject.canvasWidth = var1;
			WorldMapCacheName.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			Calendar.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1777926819"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		BoundaryObject.canvasWidth = Math.max(var1.getWidth(), this.field442);
		WorldMapCacheName.canvasHeight = Math.max(var1.getHeight(), this.field455);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			BoundaryObject.canvasWidth -= var2.right + var2.left;
			WorldMapCacheName.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight);
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
		this.field451 = true;
		if (DirectByteArrayCopier.rasterProvider != null && BoundaryObject.canvasWidth == DirectByteArrayCopier.rasterProvider.width && WorldMapCacheName.canvasHeight == DirectByteArrayCopier.rasterProvider.height) {
			((RasterProvider)DirectByteArrayCopier.rasterProvider).setComponent(this.canvas);
			DirectByteArrayCopier.rasterProvider.drawFull(0, 0);
		} else {
			DirectByteArrayCopier.rasterProvider = new RasterProvider(BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field463 = TaskHandler.currentTimeMillis();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1146937119"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "22"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = TaskHandler.currentTimeMillis();
		long var3 = clientTickTimes[WorldMapSection2.clientTickTimeIdx];
		clientTickTimes[WorldMapSection2.clientTickTimeIdx] = var1;
		WorldMapSection2.clientTickTimeIdx = WorldMapSection2.clientTickTimeIdx + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			TextureProvider.hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1595065586"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = TaskHandler.currentTimeMillis();
		long var4 = graphicsTickTimes[Coord.graphicsTickTimeIdx];
		graphicsTickTimes[Coord.graphicsTickTimeIdx] = var2;
		Coord.graphicsTickTimeIdx = Coord.graphicsTickTimeIdx + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field459 - 1 > 50) {
			field459 -= 50;
			this.field451 = true;
			this.canvas.setSize(BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight);
			this.canvas.setVisible(true);
			if (var1 == this.frame) {
				Insets var7 = this.frame.getInsets();
				this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}
		}

		if (this.isCanvasInvalid) {
			this.replaceCanvas();
		}

		this.method946();
		this.draw(this.field451);
		if (this.field451) {
			this.clearBackground();
		}

		this.field451 = false;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1393805519"
	)
	final void method946() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || this.contentHeight != var1.highY || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1945680127"
	)
	final void method947() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "887145603"
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

			this.vmethod1301();
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "81"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "776219916"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-24"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-105"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "0"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (fontHelvetica13 == null) {
				fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				class51.loginScreenFontMetrics = this.canvas.getFontMetrics(fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, BoundaryObject.canvasWidth, WorldMapCacheName.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (FriendsList.field3623 == null) {
					FriendsList.field3623 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = FriendsList.field3623.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - class51.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(FriendsList.field3623, BoundaryObject.canvasWidth / 2 - 152, WorldMapCacheName.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = BoundaryObject.canvasWidth / 2 - 152;
				int var8 = WorldMapCacheName.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - class51.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1200081624"
	)
	protected final void method991() {
		FriendsList.field3623 = null;
		fontHelvetica13 = null;
		class51.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "18"
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

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(S)Ljava/awt/Container;",
		garbageValue = "1024"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(B)Llw;",
		garbageValue = "65"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field442);
		int var3 = Math.max(var1.getHeight(), this.field455);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-934815852"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1314130629"
	)
	protected abstract void vmethod1301();

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = TaskHandler.currentTimeMillis();
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
			this.field451 = true;
			if (TaskHandler.currentTimeMillis() - this.field463 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= BoundaryObject.canvasWidth && var2.height >= WorldMapCacheName.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public abstract void init();

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
						for (var3 = 6; var3 < var2.length() && AbstractWorldMapData.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (Interpreter.isNumber(var4) && SoundCache.parseInt(var4) < 10) {
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

			BuddyRankComparator.clock = (Clock)var8;

			while (0L == stopTimeMs || TaskHandler.currentTimeMillis() < stopTimeMs) {
				gameCyclesToDo = BuddyRankComparator.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var7) {
			Calendar.RunException_sendStackTrace((String)null, var7);
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
			stopTimeMs = TaskHandler.currentTimeMillis() + 4000L;
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void focusLost(FocusEvent var1) {
		volatileFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void focusGained(FocusEvent var1) {
		volatileFocus = true;
		this.field451 = true;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "8"
	)
	static int method952(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			var4 = Language.getWidget(var3);
		} else {
			var4 = var2 ? Interpreter.field1090 : class188.field2352;
		}

		if (var0 == ScriptOpcodes.CC_SETPOSITION) {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 3];
			ScriptEvent.invalidateWidget(var4);
			AbstractWorldMapIcon.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				MilliClock.revalidateWidgetScroll(FloorDecoration.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 3];
			ScriptEvent.invalidateWidget(var4);
			AbstractWorldMapIcon.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				MilliClock.revalidateWidgetScroll(FloorDecoration.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) {
			boolean var5 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				ScriptEvent.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1734679245"
	)
	public static void method1074() {
		if (NetCache.NetCache_socket != null) {
			NetCache.NetCache_socket.close();
		}

	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "(IZZZI)Lij;",
		garbageValue = "-1217554678"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, WorldMapSection1.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, class30.masterDisk, var0, var1, var2, var3);
	}
}
