import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
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
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lbf;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1861919181
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -2009048396564091949L
   )
   static long field671;
   @ObfuscatedName("k")
   static boolean field686;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -620059689
   )
   static int field668;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1746932275
   )
   static int field684;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1932926835
   )
   static int field663;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -799673495
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("l")
   static long[] field667;
   @ObfuscatedName("b")
   static long[] field664;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 900388677
   )
   static int field680;
   @ObfuscatedName("ad")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("av")
   static GarbageCollectorMXBean field688;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = 2020306385097555121L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = 1035849672202840579L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -313835119
   )
   static int field673;
   @ObfuscatedName("z")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -652886167
   )
   protected int field669;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -434007429
   )
   protected int field670;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1256192051
   )
   int field660;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1680198637
   )
   int field657;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -386316083
   )
   int field672;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1022801171
   )
   int field674;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1248344631
   )
   int field675;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -49707385
   )
   int field676;
   @ObfuscatedName("ak")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("as")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("aa")
   volatile boolean field692;
   @ObfuscatedName("am")
   boolean field681;
   @ObfuscatedName("aq")
   volatile boolean field682;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -3131599746005155453L
   )
   volatile long field665;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lau;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ag")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ay")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field671 = 0L;
      field686 = false;
      field684 = 20;
      field663 = 1;
      FPS = 0;
      field667 = new long[32];
      field664 = new long[32];
      field680 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field660 = 0;
      this.field657 = 0;
      this.field692 = true;
      this.field681 = false;
      this.field682 = false;
      this.field665 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      SoundTaskDataProvider var2 = new SoundTaskDataProvider();
      class21.soundTaskDataProvider = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "33"
   )
   protected final void method899(int var1, int var2) {
      if(this.field675 != var1 || var2 != this.field676) {
         this.method893();
      }

      this.field675 = var1;
      this.field676 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "533953574"
   )
   final void method877(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class163.method3223(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Lfz;",
      garbageValue = "702940158"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1956896479"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "120"
   )
   protected void method902(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1115910435"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      if(class241.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.KeyHandler_keyCodes[186] = 57;
         KeyFocusListener.KeyHandler_keyCodes[187] = 27;
         KeyFocusListener.KeyHandler_keyCodes[188] = 71;
         KeyFocusListener.KeyHandler_keyCodes[189] = 26;
         KeyFocusListener.KeyHandler_keyCodes[190] = 72;
         KeyFocusListener.KeyHandler_keyCodes[191] = 73;
         KeyFocusListener.KeyHandler_keyCodes[192] = 58;
         KeyFocusListener.KeyHandler_keyCodes[219] = 42;
         KeyFocusListener.KeyHandler_keyCodes[220] = 74;
         KeyFocusListener.KeyHandler_keyCodes[221] = 43;
         KeyFocusListener.KeyHandler_keyCodes[222] = 59;
         KeyFocusListener.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyFocusListener.KeyHandler_keyCodes[44] = 71;
         KeyFocusListener.KeyHandler_keyCodes[45] = 26;
         KeyFocusListener.KeyHandler_keyCodes[46] = 72;
         KeyFocusListener.KeyHandler_keyCodes[47] = 73;
         KeyFocusListener.KeyHandler_keyCodes[59] = 57;
         KeyFocusListener.KeyHandler_keyCodes[61] = 27;
         KeyFocusListener.KeyHandler_keyCodes[91] = 42;
         KeyFocusListener.KeyHandler_keyCodes[92] = 74;
         KeyFocusListener.KeyHandler_keyCodes[93] = 43;
         KeyFocusListener.KeyHandler_keyCodes[192] = 28;
         KeyFocusListener.KeyHandler_keyCodes[222] = 58;
         KeyFocusListener.KeyHandler_keyCodes[520] = 59;
      }

      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1759232204"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Spotanim.method4799(this.canvas);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1359016038"
   )
   final void method883() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method903();
         this.field669 = Math.max(var2.field3936, this.field672);
         this.field670 = Math.max(var2.field3937, this.field674);
         if(this.field669 <= 0) {
            this.field669 = 1;
         }

         if(this.field670 <= 0) {
            this.field670 = 1;
         }

         Sequence.canvasWidth = Math.min(this.field669, this.field675);
         class45.canvasHeight = Math.min(this.field670, this.field676);
         this.field660 = (this.field669 - Sequence.canvasWidth) / 2;
         this.field657 = 0;
         this.canvas.setSize(Sequence.canvasWidth, class45.canvasHeight);
         class324.rasterProvider = new MainBufferProvider(Sequence.canvasWidth, class45.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field660, this.field657 + var3.top);
         } else {
            this.canvas.setLocation(this.field660, this.field657);
         }

         this.field692 = true;
         this.vmethod1266();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "779213061"
   )
   protected abstract void vmethod1266();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2114903280"
   )
   void method885() {
      int var1 = this.field660;
      int var2 = this.field657;
      int var3 = this.field669 - Sequence.canvasWidth - var1;
      int var4 = this.field670 - class45.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field670);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field669, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field669 - var3, var7, var3, this.field670);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field670 - var4, this.field669, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2120795827"
   )
   final void method921() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field610 = -1;
      class66.method1096(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      Spotanim.method4799(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method893();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "97"
   )
   @Export("initialize")
   protected final void initialize(int var1, int var2, int var3) {
      try {
         if(shell != null) {
            ++shellCount;
            if(shellCount >= 3) {
               this.error("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         shell = this;
         Sequence.canvasWidth = var1;
         class45.canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2178 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         UrlRequest.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-645526426"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      Sequence.canvasWidth = Math.max(var1.getWidth(), this.field672);
      class45.canvasHeight = Math.max(var1.getHeight(), this.field674);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         Sequence.canvasWidth -= var2.right + var2.left;
         class45.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(Sequence.canvasWidth, class45.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field660 + var2.left, this.field657 + var2.top);
      } else {
         this.canvas.setLocation(this.field660, this.field657);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field692 = true;
      if(class324.rasterProvider != null && Sequence.canvasWidth == class324.rasterProvider.width && class45.canvasHeight == class324.rasterProvider.height) {
         ((MainBufferProvider)class324.rasterProvider).replaceComponent(this.canvas);
         class324.rasterProvider.drawFull(0, 0);
      } else {
         class324.rasterProvider = new MainBufferProvider(Sequence.canvasWidth, class45.canvasHeight, this.canvas);
      }

      this.field682 = false;
      this.field665 = ScriptVarType.method28();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "543565598"
   )
   @Export("isValidHost")
   protected final boolean isValidHost() {
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1903590145"
   )
   void method927() {
      long var1 = ScriptVarType.method28();
      long var3 = field664[FriendManager.field1251];
      field664[FriendManager.field1251] = var1;
      FriendManager.field1251 = FriendManager.field1251 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         MapIcon.field508 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1141037424"
   )
   void method891() {
      Container var1 = this.container();
      long var2 = ScriptVarType.method28();
      long var4 = field667[class173.field2242];
      field667[class173.field2242] = var2;
      class173.field2242 = class173.field2242 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field680 - 1 > 50) {
         field680 -= 50;
         this.field692 = true;
         this.canvas.setSize(Sequence.canvasWidth, class45.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.field660, var7.top + this.field657);
         } else {
            this.canvas.setLocation(this.field660, this.field657);
         }
      }

      if(this.field682) {
         this.method921();
      }

      this.method892();
      this.methodDraw(this.field692);
      if(this.field692) {
         this.method885();
      }

      this.field692 = false;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1244876463"
   )
   final void method892() {
      Bounds var1 = this.method903();
      if(this.field669 != var1.field3936 || var1.field3937 != this.field670 || this.field681) {
         this.method883();
         this.field681 = false;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-276359656"
   )
   final void method893() {
      this.field681 = true;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-16711936"
   )
   final synchronized void method894() {
      if(!field686) {
         field686 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1200();
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

         if(taskManager != null) {
            try {
               taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1332();
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1009107514"
   )
   protected abstract void setUp();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-299387202"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1270270830"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1577184348"
   )
   protected abstract void vmethod1200();

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "1952519462"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(IndexFile.field2249 == null) {
            IndexFile.field2249 = new java.awt.Font("Helvetica", 1, 13);
            CacheFile.field1676 = this.canvas.getFontMetrics(IndexFile.field2249);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, Sequence.canvasWidth, class45.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(Size.field348 == null) {
               Size.field348 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = Size.field348.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(IndexFile.field2249);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - CacheFile.field1676.stringWidth(var2)) / 2, 22);
            var4.drawImage(Size.field348, Sequence.canvasWidth / 2 - 152, class45.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = Sequence.canvasWidth / 2 - 152;
            int var8 = class45.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(IndexFile.field2249);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - CacheFile.field1676.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-324614284"
   )
   protected final void method907() {
      Size.field348 = null;
      IndexFile.field2249 = null;
      CacheFile.field1676 = null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1241225209"
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "103"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Llg;",
      garbageValue = "-36406200"
   )
   Bounds method903() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field672);
      int var3 = Math.max(var1.getHeight(), this.field674);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1529267663"
   )
   protected final boolean method988() {
      return this.frame != null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   protected abstract void vmethod1332();

   public final void destroy() {
      if(this == shell && !field686) {
         field671 = ScriptVarType.method28();
         class163.method3223(5000L);
         this.method894();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field686) {
         this.field692 = true;
         if(ScriptVarType.method28() - this.field665 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= Sequence.canvasWidth && var2.height >= class45.canvasHeight) {
               this.field682 = true;
            }
         }

      }
   }

   public void run() {
      try {
         if(class241.javaVendor != null) {
            String var1 = class241.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class1.method0(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(Nameable.method5280(var4)) {
                     int var5 = FrameMap.parseInt(var4, 10, true);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field663 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         RunException.timer = PendingSpawn.method1581();

         while(field671 == 0L || ScriptVarType.method28() < field671) {
            field668 = RunException.timer.vmethod3312(field684, field663);

            for(int var6 = 0; var6 < field668; ++var6) {
               this.method927();
            }

            this.method891();
            this.method877(this.canvas);
         }
      } catch (Exception var7) {
         UrlRequest.processClientError((String)null, var7);
         this.error("crash");
      }

      this.method894();
   }

   public final void stop() {
      if(this == shell && !field686) {
         field671 = ScriptVarType.method28() + 4000L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @Export("focusGained")
   @Hook("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field692 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void start() {
      if(this == shell && !field686) {
         field671 = 0L;
      }
   }
}
