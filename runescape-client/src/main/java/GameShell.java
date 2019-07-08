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

@ObfuscatedName("ba")
@Implements("GameShell")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   @Export("taskHandler")
   protected static TaskHandler taskHandler;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lba;"
   )
   @Export("gameShell")
   static GameShell gameShell;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -281664295
   )
   static int field361;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 5666519919949401915L
   )
   @Export("stopTimeMs")
   static long stopTimeMs;
   @ObfuscatedName("u")
   @Export("isKilled")
   static boolean isKilled;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1179083285
   )
   static int field362;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1698831905
   )
   static int field363;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 425367827
   )
   static int field364;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1789653893
   )
   @Export("fps")
   protected static int fps;
   @ObfuscatedName("a")
   static long[] field365;
   @ObfuscatedName("j")
   static long[] field366;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2078849253
   )
   static int field367;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1042005999
   )
   static int field368;
   @ObfuscatedName("an")
   @Export("hasFocus")
   static volatile boolean hasFocus;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      longValue = 1013162399149344707L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      longValue = -3607118089363666005L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("kl")
   @ObfuscatedGetter(
      intValue = 1875936371
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("g")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1854329683
   )
   @Export("contentWidth")
   protected int contentWidth;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -628781469
   )
   @Export("contentHeight")
   protected int contentHeight;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 781373219
   )
   @Export("canvasX")
   int canvasX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 198681537
   )
   @Export("canvasY")
   int canvasY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 740831949
   )
   @Export("contentWidth0")
   int contentWidth0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2057041525
   )
   @Export("contentHeight0")
   int contentHeight0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2071955075
   )
   @Export("maxCanvasWidth")
   int maxCanvasWidth;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1911308233
   )
   @Export("maxCanvasHeight")
   int maxCanvasHeight;
   @ObfuscatedName("ac")
   @Export("frame")
   Frame frame;
   @ObfuscatedName("ay")
   @Export("canvas")
   java.awt.Canvas canvas;
   @ObfuscatedName("ah")
   volatile boolean field369;
   @ObfuscatedName("al")
   @Export("resizeCanvasNextFrame")
   boolean resizeCanvasNextFrame;
   @ObfuscatedName("ab")
   @Export("isCanvasInvalid")
   volatile boolean isCanvasInvalid;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = 956221087975405011L
   )
   @Export("canvasSetTimeMs")
   volatile long canvasSetTimeMs;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("as")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("am")
   @Export("eventQueue")
   final EventQueue eventQueue;

   protected GameShell() {
      this.hasErrored = false;
      this.canvasX = 0;
      this.canvasY = 0;
      this.field369 = true;
      this.resizeCanvasNextFrame = false;
      this.isCanvasInvalid = false;
      this.canvasSetTimeMs = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
      }

      this.eventQueue = var1;
      DevicePcmPlayerProvider var2 = new DevicePcmPlayerProvider();
      class65.pcmPlayerProvider = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-90"
   )
   @Export("setMaxCanvasSize")
   protected final void setMaxCanvasSize(int var1, int var2) {
      if (this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
         this.method111();
      }

      this.maxCanvasWidth = var1;
      this.maxCanvasHeight = var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1799804313"
   )
   @Export("post")
   final void post(Object var1) {
      if (this.eventQueue != null) {
         for (int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class203.method4010(1L);
         }

         if (var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lfv;",
      garbageValue = "-83"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if (this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-443545586"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1151252237"
   )
   @Export("clipboardSetString")
   protected void clipboardSetString(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1806283276"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "312180645"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      java.awt.Canvas var1 = this.canvas;
      var1.addMouseListener(MouseHandler.MouseHandler_instance);
      var1.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var1.addFocusListener(MouseHandler.MouseHandler_instance);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-338689747"
   )
   @Export("resizeCanvas")
   final void resizeCanvas() {
      Container var1 = this.container();
      if (var1 != null) {
         Bounds var2 = this.getFrameContentBounds();
         this.contentWidth = Math.max(var2.field43, this.contentWidth0);
         this.contentHeight = Math.max(var2.field44, this.contentHeight0);
         if (this.contentWidth <= 0) {
            this.contentWidth = 1;
         }

         if (this.contentHeight <= 0) {
            this.contentHeight = 1;
         }

         SoundCache.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
         Huffman.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
         this.canvasX = (this.contentWidth - SoundCache.canvasWidth) / 2;
         this.canvasY = 0;
         this.canvas.setSize(SoundCache.canvasWidth, Huffman.canvasHeight);
         class197.rasterProvider = new RasterProvider(SoundCache.canvasWidth, Huffman.canvasHeight, this.canvas);
         if (var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }

         this.field369 = true;
         this.vmethod107();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1773624745"
   )
   protected abstract void vmethod107();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   @Export("clearBackground")
   void clearBackground() {
      int var1 = this.canvasX;
      int var2 = this.canvasY;
      int var3 = this.contentWidth - SoundCache.canvasWidth - var1;
      int var4 = this.contentHeight - Huffman.canvasHeight - var2;
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
      garbageValue = "-1897767688"
   )
   @Export("replaceCanvas")
   final void replaceCanvas() {
      java.awt.Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyHandler.KeyHandler_instance);
      var1.removeFocusListener(KeyHandler.KeyHandler_instance);
      KeyHandler.field448 = -1;
      java.awt.Canvas var2 = this.canvas;
      var2.removeMouseListener(MouseHandler.MouseHandler_instance);
      var2.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
      var2.removeFocusListener(MouseHandler.MouseHandler_instance);
      MouseHandler.MouseHandler_currentButton0 = 0;
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.addCanvas();
      java.awt.Canvas var3 = this.canvas;
      var3.setFocusTraversalKeysEnabled(false);
      var3.addKeyListener(KeyHandler.KeyHandler_instance);
      var3.addFocusListener(KeyHandler.KeyHandler_instance);
      java.awt.Canvas var4 = this.canvas;
      var4.addMouseListener(MouseHandler.MouseHandler_instance);
      var4.addMouseMotionListener(MouseHandler.MouseHandler_instance);
      var4.addFocusListener(MouseHandler.MouseHandler_instance);
      if (this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method111();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "559367680"
   )
   @Export("startThread")
   protected final void startThread(int width, int height, int revision) {
      try {
         if (gameShell != null) {
            ++field361;
            if (field361 >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         gameShell = this;
         SoundCache.canvasWidth = width;
         Huffman.canvasHeight = height;
         RunException.revision = revision;
         RunException.applet = this;
         if (taskHandler == null) {
            taskHandler = new TaskHandler();
         }

         taskHandler.newThreadTask(this, 1);
      } catch (Exception var5) {
         NPCDefinition.sendStackTrace((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   @Export("addCanvas")
   final synchronized void addCanvas() {
      Container var1 = this.container();
      if (this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      SoundCache.canvasWidth = Math.max(var1.getWidth(), this.contentWidth0);
      Huffman.canvasHeight = Math.max(var1.getHeight(), this.contentHeight0);
      Insets var2;
      if (this.frame != null) {
         var2 = this.frame.getInsets();
         SoundCache.canvasWidth -= var2.right + var2.left;
         Huffman.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new Canvas(this);
      var1.setBackground(Color.BLACK);
      var1.setLayout((LayoutManager)null);
      var1.add(this.canvas);
      this.canvas.setSize(SoundCache.canvasWidth, Huffman.canvasHeight);
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
      this.field369 = true;
      if (class197.rasterProvider != null && SoundCache.canvasWidth == class197.rasterProvider.width && Huffman.canvasHeight == class197.rasterProvider.height) {
         ((RasterProvider)class197.rasterProvider).setComponent(this.canvas);
         class197.rasterProvider.drawFull(0, 0);
      } else {
         class197.rasterProvider = new RasterProvider(SoundCache.canvasWidth, Huffman.canvasHeight, this.canvas);
      }

      this.isCanvasInvalid = false;
      this.canvasSetTimeMs = class203.currentTimeMs();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
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
   void method108() {
      long var1 = class203.currentTimeMs();
      long var3 = field366[field367];
      field366[field367] = var1;
      field367 = field367 + 1 & 31;
      if (var3 != 0L && var1 > var3) {
      }

      synchronized(this) {
         class230.field1138 = hasFocus;
      }

      this.doCycle();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   void method109() {
      Container var1 = this.container();
      long var2 = class203.currentTimeMs();
      long var4 = field365[GrandExchangeEvents.field375];
      field365[GrandExchangeEvents.field375] = var2;
      GrandExchangeEvents.field375 = GrandExchangeEvents.field375 + 1 & 31;
      if (var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         fps = ((var6 >> 1) + 32000) / var6;
      }

      if (++field368 - 1 > 50) {
         field368 -= 50;
         this.field369 = true;
         this.canvas.setSize(SoundCache.canvasWidth, Huffman.canvasHeight);
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

      this.method110();
      this.draw(this.field369);
      if (this.field369) {
         this.clearBackground();
      }

      this.field369 = false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1999661001"
   )
   final void method110() {
      Bounds var1 = this.getFrameContentBounds();
      if (var1.field43 != this.contentWidth || this.contentHeight != var1.field44 || this.resizeCanvasNextFrame) {
         this.resizeCanvas();
         this.resizeCanvasNextFrame = false;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1147427427"
   )
   final void method111() {
      this.resizeCanvasNextFrame = true;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252384656"
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

         this.vmethod114();
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1297880469"
   )
   @Export("setUp")
   protected abstract void setUp();

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1445885427"
   )
   @Export("doCycle")
   protected abstract void doCycle();

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "106302203"
   )
   @Export("draw")
   protected abstract void draw(boolean var1);

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1879956387"
   )
   @Export("kill0")
   protected abstract void kill0();

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "41"
   )
   @Export("drawInitial")
   protected final void drawInitial(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if (WorldMapDecorationType.field1140 == null) {
            WorldMapDecorationType.field1140 = new java.awt.Font("Helvetica", 1, 13);
            class60.field1162 = this.canvas.getFontMetrics(WorldMapDecorationType.field1140);
         }

         if (var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, SoundCache.canvasWidth, Huffman.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if (PlayerType.field730 == null) {
               PlayerType.field730 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = PlayerType.field730.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(WorldMapDecorationType.field1140);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class60.field1162.stringWidth(var2)) / 2, 22);
            var4.drawImage(PlayerType.field730, SoundCache.canvasWidth / 2 - 152, Huffman.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = SoundCache.canvasWidth / 2 - 152;
            int var8 = Huffman.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(WorldMapDecorationType.field1140);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class60.field1162.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1283386969"
   )
   protected final void method113() {
      PlayerType.field730 = null;
      WorldMapDecorationType.field1140 = null;
      class60.field1162 = null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "39"
   )
   @Export("error")
   protected void error(String type) {
      if (!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + type);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + type + ".ws"), "_self");
         } catch (Exception var3) {
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-46071869"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null ? this.frame : this);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "-1214277427"
   )
   @Export("getFrameContentBounds")
   Bounds getFrameContentBounds() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.contentWidth0);
      int var3 = Math.max(var1.getHeight(), this.contentHeight0);
      if (this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-111"
   )
   @Export("hasFrame")
   protected final boolean hasFrame() {
      return this.frame != null;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1860808291"
   )
   protected abstract void vmethod114();

   public final void destroy() {
      if (this == gameShell && !isKilled) {
         stopTimeMs = class203.currentTimeMs();
         class203.method4010(5000L);
         this.kill();
      }

   }

   public final synchronized void paint(Graphics var1) {
      if (this == gameShell && !isKilled) {
         this.field369 = true;
         if (class203.currentTimeMs() - this.canvasSetTimeMs > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if (var2 == null || var2.width >= SoundCache.canvasWidth && var2.height >= Huffman.canvasHeight) {
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
                  for (var3 = 6; var3 < var2.length() && class159.isCharDigit(var2.charAt(var3)); ++var3) {
                  }

                  String var4 = var2.substring(6, var3);
                  if (UserComparator4.method3336(var4) && MouseHandler.method1085(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               field364 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.addCanvas();
         this.setUp();

         Object var7;
         try {
            var7 = new NanoClock();
         } catch (Throwable var5) {
            var7 = new MilliClock();
         }

         UserComparator6.clock = (Clock)var7;

         while (0L == stopTimeMs || class203.currentTimeMs() < stopTimeMs) {
            field362 = UserComparator6.clock.wait(field363, field364);

            for (int var8 = 0; var8 < field362; ++var8) {
               this.method108();
            }

            this.method109();
            this.post(this.canvas);
         }
      } catch (Exception var6) {
         NPCDefinition.sendStackTrace((String)null, var6);
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
      hasFocus = true;
      this.field369 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void stop() {
      if (this == gameShell && !isKilled) {
         stopTimeMs = class203.currentTimeMs() + 4000L;
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      hasFocus = false;
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "17"
   )
   @Export("updateGameState")
   static void updateGameState(int gameState) {
      if (gameState != Client.gameState) {
         if (Client.gameState == 0) {
            TextureProvider.client.method113();
         }

         if (gameState == 20 || gameState == 40 || gameState == 45) {
            Client.loginState = 0;
            Client.field168 = 0;
            Client.field169 = 0;
            Client.timer.method331(gameState);
            if (gameState != 20) {
               class15.method184(false);
            }
         }

         if (gameState != 20 && gameState != 40 && ClientParameter.field341 != null) {
            ClientParameter.field341.close();
            ClientParameter.field341 = null;
         }

         if (Client.gameState == 25) {
            Client.field181 = 0;
            Client.field177 = 0;
            Client.field178 = 1;
            Client.field179 = 0;
            Client.field180 = 1;
         }

         if (gameState != 5 && gameState != 10) {
            if (gameState == 20) {
               class2.method27(class16.archive10, WorldMapSection1.archive8, true, Client.gameState == 11 ? 4 : 0);
            } else if (gameState == 11) {
               class2.method27(class16.archive10, WorldMapSection1.archive8, false, 4);
            } else {
               class80.method2015();
            }
         } else {
            class2.method27(class16.archive10, WorldMapSection1.archive8, true, 0);
         }

         Client.gameState = gameState;
      }

   }

   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "(Lho;II)Ljava/lang/String;",
      garbageValue = "2016931356"
   )
   static String method1060(Widget var0, int var1) {
      int var2 = class1.getWidgetClickMask(var0);
      boolean var3 = (var2 >> var1 + 1 & 1) != 0;
      return !var3 && var0.onOp == null ? null : (var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null);
   }

   static {
      gameShell = null;
      field361 = 0;
      stopTimeMs = 0L;
      isKilled = false;
      field363 = 20;
      field364 = 1;
      fps = 0;
      field365 = new long[32];
      field366 = new long[32];
      field368 = 500;
      hasFocus = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }
}
