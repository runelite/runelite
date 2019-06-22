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
   @Export("__ba_q")
   static int __ba_q;
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
   @Export("__ba_l")
   static int __ba_l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1698831905
   )
   @Export("__ba_e")
   static int __ba_e;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 425367827
   )
   @Export("__ba_d")
   static int __ba_d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1789653893
   )
   @Export("fps")
   protected static int fps;
   @ObfuscatedName("a")
   @Export("__ba_a")
   static long[] __ba_a;
   @ObfuscatedName("j")
   @Export("__ba_j")
   static long[] __ba_j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2078849253
   )
   @Export("__ba_s")
   static int __ba_s;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1042005999
   )
   @Export("__ba_aw")
   static int __ba_aw;
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
   @Export("__ah")
   volatile boolean __ah;
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
      this.__ah = true;
      this.resizeCanvasNextFrame = false;
      this.isCanvasInvalid = false;
      this.canvasSetTimeMs = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
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
      if(this.maxCanvasWidth != var1 || var2 != this.maxCanvasHeight) {
         this.__ay_96();
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
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class203.method4010(1L);
         }

         if(var1 != null) {
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
      if(this.mouseWheelHandler == null) {
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
      if(TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
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
      if(var1 != null) {
         Bounds var2 = this.getFrameContentBounds();
         this.contentWidth = Math.max(var2.__q, this.contentWidth0);
         this.contentHeight = Math.max(var2.__w, this.contentHeight0);
         if(this.contentWidth <= 0) {
            this.contentWidth = 1;
         }

         if(this.contentHeight <= 0) {
            this.contentHeight = 1;
         }

         SoundCache.canvasWidth = Math.min(this.contentWidth, this.maxCanvasWidth);
         Huffman.canvasHeight = Math.min(this.contentHeight, this.maxCanvasHeight);
         this.canvasX = (this.contentWidth - SoundCache.canvasWidth) / 2;
         this.canvasY = 0;
         this.canvas.setSize(SoundCache.canvasWidth, Huffman.canvasHeight);
         class197.rasterProvider = new RasterProvider(SoundCache.canvasWidth, Huffman.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.canvasX + var3.left, var3.top + this.canvasY);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }

         this.__ah = true;
         this.__j_113();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1773624745"
   )
   @Export("__j_113")
   protected abstract void __j_113();

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
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.frame) {
               Insets var8 = this.frame.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.contentHeight);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.contentWidth, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.contentWidth - var3, var7, var3, this.contentHeight);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.contentHeight - var4, this.contentWidth, var4);
            }
         } catch (Exception var9) {
            ;
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
      KeyHandler.__an_cw = -1;
      java.awt.Canvas var2 = this.canvas;
      var2.removeMouseListener(MouseHandler.MouseHandler_instance);
      var2.removeMouseMotionListener(MouseHandler.MouseHandler_instance);
      var2.removeFocusListener(MouseHandler.MouseHandler_instance);
      MouseHandler.MouseHandler_currentButton0 = 0;
      if(this.mouseWheelHandler != null) {
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
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.__ay_96();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "559367680"
   )
   @Export("startThread")
   protected final void startThread(int var1, int var2, int var3) {
      try {
         if(gameShell != null) {
            ++__ba_q;
            if(__ba_q >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         gameShell = this;
         SoundCache.canvasWidth = var1;
         Huffman.canvasHeight = var2;
         RunException.revision = var3;
         RunException.applet = this;
         if(taskHandler == null) {
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
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      SoundCache.canvasWidth = Math.max(var1.getWidth(), this.contentWidth0);
      Huffman.canvasHeight = Math.max(var1.getHeight(), this.contentHeight0);
      Insets var2;
      if(this.frame != null) {
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
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.canvasX, var2.top + this.canvasY);
      } else {
         this.canvas.setLocation(this.canvasX, this.canvasY);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.__ah = true;
      if(class197.rasterProvider != null && SoundCache.canvasWidth == class197.rasterProvider.width && Huffman.canvasHeight == class197.rasterProvider.height) {
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
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                  var1 = var1.substring(0, var1.length() - 1);
               }

               if(var1.endsWith("192.168.1.")) {
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
   @Export("__av_93")
   void __av_93() {
      long var1 = class203.currentTimeMs();
      long var3 = __ba_j[__ba_s];
      __ba_j[__ba_s] = var1;
      __ba_s = __ba_s + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class230.__hy_az = hasFocus;
      }

      this.__al_111();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   @Export("__ar_94")
   void __ar_94() {
      Container var1 = this.container();
      long var2 = class203.currentTimeMs();
      long var4 = __ba_a[GrandExchangeEvents.__g_z];
      __ba_a[GrandExchangeEvents.__g_z] = var2;
      GrandExchangeEvents.__g_z = GrandExchangeEvents.__g_z + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         fps = ((var6 >> 1) + 32000) / var6;
      }

      if(++__ba_aw - 1 > 50) {
         __ba_aw -= 50;
         this.__ah = true;
         this.canvas.setSize(SoundCache.canvasWidth, Huffman.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.canvasX, this.canvasY + var7.top);
         } else {
            this.canvas.setLocation(this.canvasX, this.canvasY);
         }
      }

      if(this.isCanvasInvalid) {
         this.replaceCanvas();
      }

      this.__ac_95();
      this.methodDraw(this.__ah);
      if(this.__ah) {
         this.clearBackground();
      }

      this.__ah = false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1999661001"
   )
   @Export("__ac_95")
   final void __ac_95() {
      Bounds var1 = this.getFrameContentBounds();
      if(var1.__q != this.contentWidth || this.contentHeight != var1.__w || this.resizeCanvasNextFrame) {
         this.resizeCanvas();
         this.resizeCanvasNextFrame = false;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1147427427"
   )
   @Export("__ay_96")
   final void __ay_96() {
      this.resizeCanvasNextFrame = true;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1252384656"
   )
   @Export("kill")
   final synchronized void kill() {
      if(!isKilled) {
         isKilled = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.kill0();
         } catch (Exception var4) {
            ;
         }

         if(this.frame != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(taskHandler != null) {
            try {
               taskHandler.close();
            } catch (Exception var2) {
               ;
            }
         }

         this.__au_110();
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
   @Export("__al_111")
   protected abstract void __al_111();

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "106302203"
   )
   @Export("methodDraw")
   protected abstract void methodDraw(boolean var1);

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
         if(class231.__hb_av == null) {
            class231.__hb_av = new java.awt.Font("Helvetica", 1, 13);
            class60.__bo_ar = this.canvas.getFontMetrics(class231.__hb_av);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, SoundCache.canvasWidth, Huffman.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(PlayerType.__ij_ak == null) {
               PlayerType.__ij_ak = this.canvas.createImage(304, 34);
            }

            Graphics var6 = PlayerType.__ij_ak.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class231.__hb_av);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class60.__bo_ar.stringWidth(var2)) / 2, 22);
            var4.drawImage(PlayerType.__ij_ak, SoundCache.canvasWidth / 2 - 152, Huffman.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = SoundCache.canvasWidth / 2 - 152;
            int var8 = Huffman.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class231.__hb_av);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class60.__bo_ar.stringWidth(var2)) / 2, var8 + 22);
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
   @Export("__ad_108")
   protected final void __ad_108() {
      PlayerType.__ij_ak = null;
      class231.__hb_av = null;
      class60.__bo_ar = null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "39"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.hasErrored) {
         this.hasErrored = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
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
      return (Container)(this.frame != null?this.frame:this);
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
      if(this.frame != null) {
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
   @Export("__au_110")
   protected abstract void __au_110();

   @Export("__destroy_99")
   @ObfuscatedName("destroy")
   public final void __destroy_99() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = class203.currentTimeMs();
         class203.method4010(5000L);
         this.kill();
      }

   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == gameShell && !isKilled) {
         this.__ah = true;
         if(class203.currentTimeMs() - this.canvasSetTimeMs > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= SoundCache.canvasWidth && var2.height >= Huffman.canvasHeight) {
               this.isCanvasInvalid = true;
            }
         }
      }

   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         if(TaskHandler.javaVendor != null) {
            String var1 = TaskHandler.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = TaskHandler.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class159.method3394(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(UserComparator4.method3336(var4) && MouseHandler.method1085(var4) < 10) {
                     this.error("wrongjava");
                     return;
                  }
               }

               __ba_d = 5;
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

         while(0L == stopTimeMs || class203.currentTimeMs() < stopTimeMs) {
            __ba_l = UserComparator6.clock.wait(__ba_e, __ba_d);

            for(int var8 = 0; var8 < __ba_l; ++var8) {
               this.__av_93();
            }

            this.__ar_94();
            this.post(this.canvas);
         }
      } catch (Exception var6) {
         NPCDefinition.sendStackTrace((String)null, var6);
         this.error("crash");
      }

      this.kill();
   }

   @Export("__start_97")
   @ObfuscatedName("start")
   public final void __start_97() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = 0L;
      }

   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @Export("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      hasFocus = true;
      this.__ah = true;
   }

   @Export("windowActivated")
   @ObfuscatedName("windowActivated")
   public final void windowActivated(WindowEvent var1) {
   }

   @Export("windowClosed")
   @ObfuscatedName("windowClosed")
   public final void windowClosed(WindowEvent var1) {
   }

   @Export("windowClosing")
   @ObfuscatedName("windowClosing")
   public final void windowClosing(WindowEvent var1) {
      this.__destroy_99();
   }

   @Export("windowDeiconified")
   @ObfuscatedName("windowDeiconified")
   public final void windowDeiconified(WindowEvent var1) {
   }

   @Export("windowOpened")
   @ObfuscatedName("windowOpened")
   public final void windowOpened(WindowEvent var1) {
   }

   @Export("__init_109")
   @ObfuscatedName("init")
   public abstract void __init_109();

   @Export("__stop_98")
   @ObfuscatedName("stop")
   public final void __stop_98() {
      if(this == gameShell && !isKilled) {
         stopTimeMs = class203.currentTimeMs() + 4000L;
      }

   }

   @Export("windowIconified")
   @ObfuscatedName("windowIconified")
   public final void windowIconified(WindowEvent var1) {
   }

   @Export("windowDeactivated")
   @ObfuscatedName("windowDeactivated")
   public final void windowDeactivated(WindowEvent var1) {
   }

   @Export("focusLost")
   @ObfuscatedName("focusLost")
   public final void focusLost(FocusEvent var1) {
      hasFocus = false;
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "17"
   )
   @Export("updateGameState")
   static void updateGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            TextureProvider.client.__ad_108();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.__client_ex = 0;
            Client.__client_ej = 0;
            Client.timer.__q_455(var0);
            if(var0 != 20) {
               class15.method184(false);
            }
         }

         if(var0 != 20 && var0 != 40 && ClientParameter.__ji_fp != null) {
            ClientParameter.__ji_fp.close();
            ClientParameter.__ji_fp = null;
         }

         if(Client.gameState == 25) {
            Client.__client_gh = 0;
            Client.__client_fe = 0;
            Client.__client_fn = 1;
            Client.__client_fk = 0;
            Client.__client_gp = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class2.method27(class16.indexCache10, WorldMapSection3.indexCache8, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class2.method27(class16.indexCache10, WorldMapSection3.indexCache8, false, 4);
            } else {
               class80.method2015();
            }
         } else {
            class2.method27(class16.indexCache10, WorldMapSection3.indexCache8, true, 0);
         }

         Client.gameState = var0;
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
      return !var3 && var0.onOp == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   static {
      gameShell = null;
      __ba_q = 0;
      stopTimeMs = 0L;
      isKilled = false;
      __ba_e = 20;
      __ba_d = 1;
      fps = 0;
      __ba_a = new long[32];
      __ba_j = new long[32];
      __ba_aw = 500;
      hasFocus = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }
}
