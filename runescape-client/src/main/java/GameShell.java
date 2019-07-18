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

@ObfuscatedName("bz")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lfs;"
	)
	@Export("taskHandler")
	protected static TaskHandler taskHandler;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lbz;"
	)
	@Export("gameShell")
	static GameShell gameShell;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 308300489
	)
	static int field466;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = -2144214957557478601L
	)
	@Export("stopTimeMs")
	static long stopTimeMs;
	@ObfuscatedName("l")
	@Export("isKilled")
	static boolean isKilled;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 658052799
	)
	static int field449;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 798302801
	)
	static int field448;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 369880599
	)
	static int field443;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1519220993
	)
	@Export("fps")
	protected static int fps;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("v")
	static long[] field452;
	@ObfuscatedName("a")
	static long[] field453;
	@ObfuscatedName("ae")
	@ObfuscatedGetter(
		intValue = 1067662057
	)
	static int field465;
	@ObfuscatedName("au")
	@Export("hasFocus")
	static volatile boolean hasFocus;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		longValue = -5454616642198733289L
	)
	@Export("garbageCollectorLastCollectionTime")
	static long garbageCollectorLastCollectionTime;
	@ObfuscatedName("am")
	@ObfuscatedGetter(
		longValue = -449195260368923757L
	)
	@Export("garbageCollectorLastCheckTimeMs")
	static long garbageCollectorLastCheckTimeMs;
	@ObfuscatedName("b")
	@Export("hasErrored")
	boolean hasErrored;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 93625917
	)
	@Export("contentWidth")
	protected int contentWidth;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1254319767
	)
	@Export("contentHeight")
	protected int contentHeight;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 508992057
	)
	@Export("canvasX")
	int canvasX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -374740257
	)
	@Export("canvasY")
	int canvasY;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1498137065
	)
	int field476;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -606153011
	)
	int field459;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -107216011
	)
	@Export("maxCanvasWidth")
	int maxCanvasWidth;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = -559664859
	)
	@Export("maxCanvasHeight")
	int maxCanvasHeight;
	@ObfuscatedName("ag")
	@Export("frame")
	Frame frame;
	@ObfuscatedName("ar")
	@Export("canvas")
	java.awt.Canvas canvas;
	@ObfuscatedName("ax")
	volatile boolean field464;
	@ObfuscatedName("ao")
	@Export("resizeCanvasNextFrame")
	boolean resizeCanvasNextFrame;
	@ObfuscatedName("aj")
	@Export("isCanvasInvalid")
	volatile boolean isCanvasInvalid;
	@ObfuscatedName("at")
	@ObfuscatedGetter(
		longValue = -2360419381324286669L
	)
	volatile long field468;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "Lau;"
	)
	@Export("mouseWheelHandler")
	MouseWheelHandler mouseWheelHandler;
	@ObfuscatedName("aa")
	@Export("clipboard")
	Clipboard clipboard;
	@ObfuscatedName("an")
	@Export("eventQueue")
	final EventQueue eventQueue;

	static {
		gameShell = null;
		field466 = 0;
		stopTimeMs = 0L;
		isKilled = false;
		field448 = 20;
		field443 = 1;
		fps = 0;
		field452 = new long[32];
		field453 = new long[32];
		field465 = 500;
		hasFocus = true;
		garbageCollectorLastCollectionTime = -1L;
		garbageCollectorLastCheckTimeMs = -1L;
	}

	protected GameShell() {
		this.hasErrored = false;
		this.canvasX = 0;
		this.canvasY = 0;
		this.field464 = true;
		this.resizeCanvasNextFrame = false;
		this.isCanvasInvalid = false;
		this.field468 = 0L;
		EventQueue var1 = null;

		try {
			var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}

		this.eventQueue = var1;
		DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
		class32.pcmPlayerProvider = var2;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "34519869"
	)
	@Export("setMaxCanvasSize")
	protected final void setMaxCanvasSize(int var1, int var2) {
		if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
			this.method890();
		}

		this.maxCanvasWidth = var1;
		this.maxCanvasHeight = var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;I)V",
		garbageValue = "1151565468"
	)
	@Export("post")
	final void post(Object var1) {
		if (this.eventQueue != null) {
			for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
				EnumDefinition.method4550(1L);
			}

			if (var1 != null) {
				this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
			}

		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)Lfj;",
		garbageValue = "24"
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
		signature = "(I)V",
		garbageValue = "-661756545"
	)
	@Export("setUpClipboard")
	protected void setUpClipboard() {
		this.clipboard = this.getToolkit().getSystemClipboard();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "54"
	)
	@Export("clipboardSetString")
	protected void clipboardSetString(String var1) {
		this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-454668122"
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

		class81.method1990(this.canvas);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1746094131"
	)
	@Export("setUpMouse")
	protected final void setUpMouse() {
		WorldMapIcon_0.method200(this.canvas);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-517749579"
	)
	@Export("resizeCanvas")
	final void resizeCanvas() {
		Container var1 = this.container();
		if (var1 != null) {
			Bounds var2 = this.getFrameContentBounds();
			this.contentWidth = Math.max(var2.highX, this.field476);
			this.contentHeight = Math.max(var2.highY, this.field459);
			if (this.contentWidth <= 0) {
				this.contentWidth = 1;
			}

			if (this.contentHeight <= 0) {
				this.contentHeight = 1;
			}

			GrandExchangeEvent.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
			ParamDefinition.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
			this.canvasX = (this.contentWidth - GrandExchangeEvent.canvasWidth) / 2;
			this.canvasY = 0;
			this.canvas.setSize(GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight);
			MusicPatchPcmStream.rasterProvider = new RasterProvider(GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight, this.canvas);
			if (var1 == this.frame) {
				Insets var3 = this.frame.getInsets();
				this.canvas.setLocation(var3.left + this.canvasX, this.canvasY + var3.top);
			} else {
				this.canvas.setLocation(this.canvasX, this.canvasY);
			}

			this.field464 = true;
			this.resizeGame();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "869486116"
	)
	@Export("resizeGame")
	protected abstract void resizeGame();

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-42"
	)
	@Export("clearBackground")
	void clearBackground() {
		int var1 = this.canvasX;
		int var2 = this.canvasY;
		int var3 = this.contentWidth - GrandExchangeEvent.canvasWidth - var1;
		int var4 = this.contentHeight - ParamDefinition.canvasHeight - var2;
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "165240301"
	)
	@Export("replaceCanvas")
	final void replaceCanvas() {
		java.awt.Canvas var1 = this.canvas;
		var1.removeKeyListener(KeyHandler.KeyHandler_instance);
		var1.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field398 = -1;
		java.awt.Canvas var2 = this.canvas;
		var2.removeMouseListener(MouseHandler.MouseHandler_instance);
		var2.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
		var2.removeFocusListener(MouseHandler.MouseHandler_instance);
		MouseHandler.MouseHandler_currentButton0 = 0;
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.removeFrom(this.canvas);
		}

		this.addCanvas();
		class81.method1990(this.canvas);
		WorldMapIcon_0.method200(this.canvas);
		if (this.mouseWheelHandler != null) {
			this.mouseWheelHandler.addTo(this.canvas);
		}

		this.method890();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "-1542260379"
	)
	@Export("startThread")
	protected final void startThread(int var1, int var2, int var3) {
		try {
			if (gameShell != null) {
				++field466;
				if (field466 >= 3) {
					this.error("alreadyloaded");
					return;
				}

				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}

			gameShell = this;
			GrandExchangeEvent.canvasWidth = var1;
			ParamDefinition.canvasHeight = var2;
			RunException.revision = var3;
			RunException.RunException_applet = this;
			if (taskHandler == null) {
				taskHandler = new TaskHandler();
			}

			taskHandler.newThreadTask(this, 1);
		} catch (Exception var5) {
			HitSplatDefinition.sendStackTrace((String)null, var5);
			this.error("crash");
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1073262022"
	)
	@Export("addCanvas")
	final synchronized void addCanvas() {
		Container var1 = this.container();
		if (this.canvas != null) {
			this.canvas.removeFocusListener(this);
			var1.remove(this.canvas);
		}

		GrandExchangeEvent.canvasWidth = Math.max(var1.getWidth(), this.field476);
		ParamDefinition.canvasHeight = Math.max(var1.getHeight(), this.field459);
		Insets var2;
		if (this.frame != null) {
			var2 = this.frame.getInsets();
			GrandExchangeEvent.canvasWidth -= var2.right + var2.left;
			ParamDefinition.canvasHeight -= var2.top + var2.bottom;
		}

		this.canvas = new Canvas(this);
		var1.setBackground(Color.BLACK);
		var1.setLayout((LayoutManager)null);
		var1.add(this.canvas);
		this.canvas.setSize(GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight);
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
		this.field464 = true;
		if (MusicPatchPcmStream.rasterProvider != null && GrandExchangeEvent.canvasWidth == MusicPatchPcmStream.rasterProvider.width && ParamDefinition.canvasHeight == MusicPatchPcmStream.rasterProvider.height) {
			((RasterProvider)MusicPatchPcmStream.rasterProvider).setComponent(this.canvas);
			MusicPatchPcmStream.rasterProvider.drawFull(0, 0);
		} else {
			MusicPatchPcmStream.rasterProvider = new RasterProvider(GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight, this.canvas);
		}

		this.isCanvasInvalid = false;
		this.field468 = DirectByteArrayCopier.currentTimeMs();
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-878010075"
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1989434416"
	)
	void method953() {
		long var1 = DirectByteArrayCopier.currentTimeMs();
		long var3 = field453[SpotAnimationDefinition.field3248];
		field453[SpotAnimationDefinition.field3248] = var1;
		SpotAnimationDefinition.field3248 = SpotAnimationDefinition.field3248 + 1 & 31;
		if (var3 != 0L && var1 > var3) {
		}

		synchronized(this) {
			class267.field3557 = hasFocus;
		}

		this.doCycle();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1190727122"
	)
	void method910() {
		Container var1 = this.container();
		long var2 = DirectByteArrayCopier.currentTimeMs();
		long var4 = field452[VerticalAlignment.field3192];
		field452[VerticalAlignment.field3192] = var2;
		VerticalAlignment.field3192 = VerticalAlignment.field3192 + 1 & 31;
		if (0L != var4 && var2 > var4) {
			int var6 = (int)(var2 - var4);
			fps = ((var6 >> 1) + 32000) / var6;
		}

		if (++field465 - 1 > 50) {
			field465 -= 50;
			this.field464 = true;
			this.canvas.setSize(GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight);
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

		this.method970();
		this.draw(this.field464);
		if (this.field464) {
			this.clearBackground();
		}

		this.field464 = false;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2058666477"
	)
	final void method970() {
		Bounds var1 = this.getFrameContentBounds();
		if (this.contentWidth != var1.highX || var1.highY != this.contentHeight || this.resizeCanvasNextFrame) {
			this.resizeCanvas();
			this.resizeCanvasNextFrame = false;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "501361759"
	)
	final void method890() {
		this.resizeCanvasNextFrame = true;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-95"
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

			this.vmethod1273();
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2070235141"
	)
	@Export("setUp")
	protected abstract void setUp();

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-3"
	)
	protected abstract void doCycle();

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-5"
	)
	protected abstract void draw(boolean var1);

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1344457794"
	)
	@Export("kill0")
	protected abstract void kill0();

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;ZB)V",
		garbageValue = "-111"
	)
	@Export("drawInitial")
	protected final void drawInitial(int var1, String var2, boolean var3) {
		try {
			Graphics var4 = this.canvas.getGraphics();
			if (class313.field3844 == null) {
				class313.field3844 = new java.awt.Font("Helvetica", 1, 13);
				GrandExchangeOfferAgeComparator.field80 = this.canvas.getFontMetrics(class313.field3844);
			}

			if (var3) {
				var4.setColor(Color.black);
				var4.fillRect(0, 0, GrandExchangeEvent.canvasWidth, ParamDefinition.canvasHeight);
			}

			Color var5 = new Color(140, 17, 17);

			try {
				if (NetFileRequest.field3125 == null) {
					NetFileRequest.field3125 = this.canvas.createImage(304, 34);
				}

				Graphics var6 = NetFileRequest.field3125.getGraphics();
				var6.setColor(var5);
				var6.drawRect(0, 0, 303, 33);
				var6.fillRect(2, 2, var1 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(1, 1, 301, 31);
				var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
				var6.setFont(class313.field3844);
				var6.setColor(Color.white);
				var6.drawString(var2, (304 - GrandExchangeOfferAgeComparator.field80.stringWidth(var2)) / 2, 22);
				var4.drawImage(NetFileRequest.field3125, GrandExchangeEvent.canvasWidth / 2 - 152, ParamDefinition.canvasHeight / 2 - 18, (ImageObserver)null);
			} catch (Exception var9) {
				int var7 = GrandExchangeEvent.canvasWidth / 2 - 152;
				int var8 = ParamDefinition.canvasHeight / 2 - 18;
				var4.setColor(var5);
				var4.drawRect(var7, var8, 303, 33);
				var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
				var4.setColor(Color.black);
				var4.drawRect(var7 + 1, var8 + 1, 301, 31);
				var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
				var4.setFont(class313.field3844);
				var4.setColor(Color.white);
				var4.drawString(var2, var7 + (304 - GrandExchangeOfferAgeComparator.field80.stringWidth(var2)) / 2, var8 + 22);
			}
		} catch (Exception var10) {
			this.canvas.repaint();
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "11"
	)
	protected final void method885() {
		NetFileRequest.field3125 = null;
		class313.field3844 = null;
		GrandExchangeOfferAgeComparator.field80 = null;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-54"
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

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		signature = "(I)Ljava/awt/Container;",
		garbageValue = "2083877937"
	)
	@Export("container")
	Container container() {
		return (Container)(this.frame != null ? this.frame : this);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		signature = "(I)Lls;",
		garbageValue = "-357178622"
	)
	@Export("getFrameContentBounds")
	Bounds getFrameContentBounds() {
		Container var1 = this.container();
		int var2 = Math.max(var1.getWidth(), this.field476);
		int var3 = Math.max(var1.getHeight(), this.field459);
		if (this.frame != null) {
			Insets var4 = this.frame.getInsets();
			var2 -= var4.left + var4.right;
			var3 -= var4.bottom + var4.top;
		}

		return new Bounds(var2, var3);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "285080873"
	)
	@Export("hasFrame")
	protected final boolean hasFrame() {
		return this.frame != null;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-779141254"
	)
	protected abstract void vmethod1273();

	public final synchronized void paint(Graphics var1) {
		if (this == gameShell && !isKilled) {
			this.field464 = true;
			if (DirectByteArrayCopier.currentTimeMs() - this.field468 > 1000L) {
				Rectangle var2 = var1.getClipBounds();
				if (var2 == null || var2.width >= GrandExchangeEvent.canvasWidth && var2.height >= ParamDefinition.canvasHeight) {
					this.isCanvasInvalid = true;
				}
			}

		}
	}

	public final void destroy() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = DirectByteArrayCopier.currentTimeMs();
			EnumDefinition.method4550(5000L);
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
						for (var3 = 6; var3 < var2.length() && class49.isCharDigit(var2.charAt(var3)); ++var3) {
						}

						String var4 = var2.substring(6, var3);
						if (class192.method3677(var4) && class3.parseInt(var4) < 10) {
							this.error("wrongjava");
							return;
						}
					}

					field443 = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addCanvas();
			this.setUp();
			clock = class173.method3589();

			while (0L == stopTimeMs || DirectByteArrayCopier.currentTimeMs() < stopTimeMs) {
				field449 = clock.wait(field448, field443);

				for (int var5 = 0; var5 < field449; ++var5) {
					this.method953();
				}

				this.method910();
				this.post(this.canvas);
			}
		} catch (Exception var6) {
			HitSplatDefinition.sendStackTrace((String)null, var6);
			this.error("crash");
		}

		this.kill();
	}

	public final void windowDeiconified(WindowEvent var1) {
	}

	public final void start() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = 0L;
		}
	}

	public final void stop() {
		if (this == gameShell && !isKilled) {
			stopTimeMs = DirectByteArrayCopier.currentTimeMs() + 4000L;
		}
	}

	public final void update(Graphics var1) {
		this.paint(var1);
	}

	public final void focusGained(FocusEvent var1) {
		hasFocus = true;
		this.field464 = true;
	}

	public final void focusLost(FocusEvent var1) {
		hasFocus = false;
	}

	public final void windowActivated(WindowEvent var1) {
	}

	public final void windowClosed(WindowEvent var1) {
	}

	public final void windowClosing(WindowEvent var1) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent var1) {
	}

	public final void windowOpened(WindowEvent var1) {
	}

	public final void windowIconified(WindowEvent var1) {
	}

	public abstract void init();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)Lij;",
		garbageValue = "-91"
	)
	@Export("getNpcDefinition")
	public static NPCDefinition getNpcDefinition(int var0) {
		NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCDefinition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCDefinition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
