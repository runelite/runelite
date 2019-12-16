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
import java.security.SecureRandom;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bj")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lfl;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lbj;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -641610179
	)
	@Export("GameShell_redundantStartThreadCount")
	static int GameShell_redundantStartThreadCount;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		longValue = 9100784568139966685L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("e")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1686581025
	)
	@Export("gameCyclesToDo")
	static int gameCyclesToDo;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 777361689
	)
	@Export("cycleDurationMillis")
	static int cycleDurationMillis;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -224666491
	)
	@Export("fiveOrOne")
	static int fiveOrOne;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1353428271
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("l")
	@Export("graphicsTickTimes")
	static long[] graphicsTickTimes;
	@ObfuscatedName("j")
	@Export("clientTickTimes")
	static long[] clientTickTimes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1909325521
	)
	@Export("clientTickTimeIdx")
	static int clientTickTimeIdx;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 2131484097
	)
	static int field442;
	@ObfuscatedName("ag")
	@Export("null_string")
	protected static String null_string;
	@ObfuscatedName("aj")
	@Export("volatileFocus")
	static volatile boolean volatileFocus;
	@ObfuscatedName("ax")
	@Export("hasFocus")
	protected static boolean hasFocus;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		longValue = -7455668371205512405L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("ap")
	@ObfuscatedGetter(
		longValue = 4016569584123468349L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("a")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1294552549
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1325726667
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 301736505
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -380682277
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 177005865
	)
	int field422;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = -973414545
	)
	int field419;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1421773905
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -1295726035
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("au")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("ah")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("aq")
	volatile boolean field441;
	@ObfuscatedName("ar")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("az")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		longValue = -550233093924080547L
	)
	volatile long field418;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "Lad;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("ae")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("ad")
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
		this.field418 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		FriendLoginUpdate.method5300(new DevicePcmPlayerProvider());
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-472959783"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method936();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;B)V",
		garbageValue = "-24"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				ServerBuild.method4111(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Lfs;",
		garbageValue = "-1343369981"
	)
	@Export("mouseWheel")
	protected MouseWheel mouseWheel() {
		if (this.mouseWheelHandler == null) {
			this.mouseWheelHandler = new MouseWheelHandler();
			this.mouseWheelHandler.addTo(this.canvas);
		}

		return this.mouseWheelHandler;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2116975887"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;S)V",
		garbageValue = "-9007"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	@Export("setUpKeyboard")
	protected final void setUpKeyboard() {
		WorldMapData_1.method722();
		GrandExchangeOfferTotalQuantityComparator.method93(this.canvas);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-57"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		java.awt.Canvas var1 = this.canvas;
		var1.addMouseListener(MouseHandler.MouseHandler_instance);
		var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-92"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field422);
			this.contentHeight = Math.max(var2.highY, this.field419);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			GrandExchangeOfferTotalQuantityComparator.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			AttackOption.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - GrandExchangeOfferTotalQuantityComparator.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight);
			IgnoreList.rasterProvider = new RasterProvider(GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field441 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1309389764"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "14"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - GrandExchangeOfferTotalQuantityComparator.canvasWidth - var1;
		int var4 = this.contentHeight - AttackOption.canvasHeight - var2;
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

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1861012974"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		ArchiveDiskAction.method4120(this.canvas);
		java.awt.Canvas var1 = this.canvas;
		var1.removeMouseListener(MouseHandler.MouseHandler_instance);
		var1.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var1.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButtonVolatile = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		GrandExchangeOfferTotalQuantityComparator.method93(this.canvas);
		java.awt.Canvas var2 = this.canvas;
		var2.addMouseListener(MouseHandler.MouseHandler_instance);
		var2.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.addFocusListener(MouseHandler.MouseHandler_instance);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method936();
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "1709387242"
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
			GrandExchangeOfferTotalQuantityComparator.canvasWidth = var1;
			AttackOption.canvasHeight = var2;
			RunException.RunException_revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			DesktopPlatformInfoProvider.RunException_sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1793942402"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		GrandExchangeOfferTotalQuantityComparator.canvasWidth = Math.max(var1.getWidth(), this.field422);
		AttackOption.canvasHeight = Math.max(var1.getHeight(), this.field419);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			GrandExchangeOfferTotalQuantityComparator.canvasWidth -= var2.left + var2.right;
			AttackOption.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight);
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
		this.field441 = true;
		if (IgnoreList.rasterProvider != null && GrandExchangeOfferTotalQuantityComparator.canvasWidth == IgnoreList.rasterProvider.width && AttackOption.canvasHeight == IgnoreList.rasterProvider.height) {
			((RasterProvider)IgnoreList.rasterProvider).setComponent(this.canvas);
			IgnoreList.rasterProvider.drawFull(0, 0);
		} else {
			IgnoreList.rasterProvider = new RasterProvider(GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field418 = WorldMapID.currentTimeMillis();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-1830524310"
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

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-25"
	)
	@Export("clientTick")
	void clientTick() {
		long var1 = WorldMapID.currentTimeMillis();
		long var3 = clientTickTimes[clientTickTimeIdx];
		clientTickTimes[clientTickTimeIdx] = var1;
		clientTickTimeIdx = clientTickTimeIdx + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			hasFocus = volatileFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2091999250"
	)
	@Export("graphicsTick")
	void graphicsTick() {
		Container var1 = this.container();
		long var2 = WorldMapID.currentTimeMillis();
		long var4 = graphicsTickTimes[class30.graphicsTickTimeIdx];
		graphicsTickTimes[class30.graphicsTickTimeIdx] = var2;
		class30.graphicsTickTimeIdx = class30.graphicsTickTimeIdx + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field442 - 1 > 50) {
			field442 -= 50;
			this.field441 = true;
			this.canvas.setSize(GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight);
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

		this.method998();
		this.draw(this.field441);
		if (this.field441) {
			this.clearBackground();
		}

		this.field441 = false;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-1"
	)
	final void method998() {
		Bounds var1 = this.getFrameContentBounds();
		if (var1.highX != this.contentWidth || var1.highY != this.contentHeight || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "24"
	)
	final void method936() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "12"
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

			this.vmethod1290();
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "557803519"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1971545072"
	)
	@Export("doCycle")
	protected abstract void doCycle();

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-1655647135"
	)
	@Export("draw")
	protected abstract void draw(boolean var1);

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1818676977"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "58"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (NetSocket.fontHelvetica13 == null) {
				NetSocket.fontHelvetica13 = new java.awt.Font("Helvetica", 1, 13);
				WorldMapSprite.loginScreenFontMetrics = this.canvas.getFontMetrics(NetSocket.fontHelvetica13);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, GrandExchangeOfferTotalQuantityComparator.canvasWidth, AttackOption.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (class189.field2333 == null) {
					class189.field2333 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = class189.field2333.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(NetSocket.fontHelvetica13);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - WorldMapSprite.loginScreenFontMetrics.stringWidth(var2)) / 2, 22);
				var4.drawImage(class189.field2333, GrandExchangeOfferTotalQuantityComparator.canvasWidth / 2 - 152, AttackOption.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = GrandExchangeOfferTotalQuantityComparator.canvasWidth / 2 - 152;
				int var8 = AttackOption.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(NetSocket.fontHelvetica13);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - WorldMapSprite.loginScreenFontMetrics.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "21"
	)
	protected final void method947() {
		class189.field2333 = null;
		NetSocket.fontHelvetica13 = null;
		WorldMapSprite.loginScreenFontMetrics = null;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-2001390999"
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

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "-1758438210"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		signature = "(I)Llh;",
		garbageValue = "1983468330"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field422);
		int var3 = Math.max(var1.getHeight(), this.field419);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.right + var4.left;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "67"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1677674321"
	)
	protected abstract void vmethod1290();

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field441 = true;
			if (WorldMapID.currentTimeMillis() - this.field418 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= GrandExchangeOfferTotalQuantityComparator.canvasWidth && var2.height >= AttackOption.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = WorldMapID.currentTimeMillis();
			ServerBuild.method4111(5000L);
			this.kill();
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
						for (var3 = 6; var3 < var2.length() && class237.isDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (SecureRandomFuture.isNumber(var4) && ArchiveDiskActionHandler.parseInt(var4) < 10) {
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
			Varps.clock = class30.method540();

			while (0L == stopTimeMs || WorldMapID.currentTimeMillis() < stopTimeMs) {
				gameCyclesToDo = Varps.clock.wait(cycleDurationMillis, fiveOrOne);

				for (int var5 = 0; var5 < gameCyclesToDo; ++var5) {
					this.clientTick();
				}

				this.graphicsTick();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			DesktopPlatformInfoProvider.RunException_sendStackTrace((String)null, var6);
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

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = WorldMapID.currentTimeMillis() + 4000L;
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

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public abstract void init();

	public final void windowIconified(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "115447225"
	)
	static SecureRandom method1069() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-693907391"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var1 = UserComparator9.method3319(var0);
		int var2 = var1.baseVar;
		int var3 = var1.startBit;
		int var4 = var1.endBit;
		int var5 = Varps.Varps_masks[var4 - var3];
		return Varps.Varps_main[var2] >> var3 & var5;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "907753362"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "-1840068050"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "34"
	)
	static int method1068(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == ScriptOpcodes.IF_GETINVOBJECT) {
			var3 = Tile.getWidget(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETINVCOUNT) {
			var3 = Tile.getWidget(Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_HASSUB) {
			int var5 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTOP) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("kd")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-12664"
	)
	@Export("Widget_resetModelFrames")
	static final void Widget_resetModelFrames(int var0) {
		if (MusicPatch.loadInterface(var0)) {
			Widget[] var1 = UserComparator7.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-120"
	)
	@Export("FriendSystem_invalidateIgnoreds")
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

		if (Calendar.clanChat != null) {
			Calendar.clanChat.invalidateIgnoreds();
		}

	}
}
