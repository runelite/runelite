import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
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
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -757806665
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 3229905322763981751L
   )
   static long field705;
   @ObfuscatedName("e")
   static boolean field680;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -161621215
   )
   static int field703;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1661979241
   )
   static int field683;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1263831773
   )
   static int field684;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -411656845
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("u")
   static long[] field687;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -637858799
   )
   static int field688;
   @ObfuscatedName("v")
   static long[] field712;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -88228221
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("aw")
   static java.awt.Font field692;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1155313461
   )
   static int field677;
   @ObfuscatedName("ax")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -7957885442757759869L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 2392403556553432161L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("k")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -589151809
   )
   protected int field678;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1477936905
   )
   protected int field691;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1044430815
   )
   int field682;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1140067853
   )
   int field693;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -684737439
   )
   int field695;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1413507305
   )
   int field676;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 804825563
   )
   int field696;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2022501727
   )
   int field698;
   @ObfuscatedName("au")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("al")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("af")
   volatile boolean field702;
   @ObfuscatedName("aq")
   boolean field700;
   @ObfuscatedName("ae")
   volatile boolean field689;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      longValue = 6374104585820129467L
   )
   volatile long field706;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ag")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("an")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field705 = 0L;
      field680 = false;
      field683 = 20;
      field684 = 1;
      FPS = 0;
      field687 = new long[32];
      field712 = new long[32];
      field677 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field682 = 0;
      this.field693 = 0;
      this.field702 = true;
      this.field700 = false;
      this.field689 = false;
      this.field706 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      SoundTaskDataProvider var2 = new SoundTaskDataProvider();
      AbstractSoundSystem.soundTaskDataProvider = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1995857538"
   )
   public final void method891(int var1, int var2) {
      if(this.field696 != var1 || var2 != this.field698) {
         this.method869();
      }

      this.field696 = var1;
      this.field698 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-460550799"
   )
   final void method851(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            PacketBuffer.method3907(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lft;",
      garbageValue = "629850969"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1109742641"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "857099583"
   )
   protected void method856(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-919127101"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1758255405"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      WallObject.method3134(this.canvas);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method859() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method886();
         this.field678 = Math.max(var2.field3937, this.field695);
         this.field691 = Math.max(var2.field3936, this.field676);
         if(this.field678 <= 0) {
            this.field678 = 1;
         }

         if(this.field691 <= 0) {
            this.field691 = 1;
         }

         canvasWidth = Math.min(this.field678, this.field696);
         class195.canvasHeight = Math.min(this.field691, this.field698);
         this.field682 = (this.field678 - canvasWidth) / 2;
         this.field693 = 0;
         this.canvas.setSize(canvasWidth, class195.canvasHeight);
         class20.rasterProvider = new MainBufferProvider(canvasWidth, class195.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field682, var3.top + this.field693);
         } else {
            this.canvas.setLocation(this.field682, this.field693);
         }

         this.field702 = true;
         this.vmethod1207();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1383330883"
   )
   protected abstract void vmethod1207();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-113326685"
   )
   void method861() {
      int var1 = this.field682;
      int var2 = this.field693;
      int var3 = this.field678 - canvasWidth - var1;
      int var4 = this.field691 - class195.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field691);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field678, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field678 - var3, var7, var3, this.field691);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field691 - var4, this.field678, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-748703777"
   )
   final void method862() {
      method982(this.canvas);
      class19.method148(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
      WallObject.method3134(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method869();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "2"
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
         canvasWidth = var1;
         class195.canvasHeight = var2;
         RunException.revision = var3;
         class199.field2604 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         ItemLayer.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1111266643"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      canvasWidth = Math.max(var1.getWidth(), this.field695);
      class195.canvasHeight = Math.max(var1.getHeight(), this.field676);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         canvasWidth -= var2.right + var2.left;
         class195.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(canvasWidth, class195.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field682 + var2.left, this.field693 + var2.top);
      } else {
         this.canvas.setLocation(this.field682, this.field693);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field702 = true;
      if(class20.rasterProvider != null && canvasWidth == class20.rasterProvider.width && class195.canvasHeight == class20.rasterProvider.height) {
         ((MainBufferProvider)class20.rasterProvider).replaceComponent(this.canvas);
         class20.rasterProvider.drawFull(0, 0);
      } else {
         class20.rasterProvider = new MainBufferProvider(canvasWidth, class195.canvasHeight, this.canvas);
      }

      this.field689 = false;
      this.field706 = PendingSpawn.currentTimeMs();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-24884"
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

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   void method947() {
      long var1 = PendingSpawn.currentTimeMs();
      long var3 = field712[class85.field1299];
      field712[class85.field1299] = var1;
      class85.field1299 = class85.field1299 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         Parameters.field3805 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-335885041"
   )
   void method873() {
      Container var1 = this.container();
      long var2 = PendingSpawn.currentTimeMs();
      long var4 = field687[field688];
      field687[field688] = var2;
      field688 = field688 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field677 - 1 > 50) {
         field677 -= 50;
         this.field702 = true;
         this.canvas.setSize(canvasWidth, class195.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.field682, var7.top + this.field693);
         } else {
            this.canvas.setLocation(this.field682, this.field693);
         }
      }

      if(this.field689) {
         this.method862();
      }

      this.method868();
      this.methodDraw(this.field702);
      if(this.field702) {
         this.method861();
      }

      this.field702 = false;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   final void method868() {
      Bounds var1 = this.method886();
      if(this.field678 != var1.field3937 || this.field691 != var1.field3936 || this.field700) {
         this.method859();
         this.field700 = false;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2062472888"
   )
   final void method869() {
      this.field700 = true;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "104115635"
   )
   final synchronized void method870() {
      if(!field680) {
         field680 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1201();
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

         this.vmethod1196();
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   protected abstract void setUp();

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-500765769"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1293800771"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-25189"
   )
   protected abstract void vmethod1201();

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "-2"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(field692 == null) {
            field692 = new java.awt.Font("Helvetica", 1, 13);
            class7.field231 = this.canvas.getFontMetrics(field692);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, canvasWidth, class195.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class88.field1323 == null) {
               class88.field1323 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class88.field1323.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(field692);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class7.field231.stringWidth(var2)) / 2, 22);
            var4.drawImage(class88.field1323, canvasWidth / 2 - 152, class195.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = canvasWidth / 2 - 152;
            int var8 = class195.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(field692);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class7.field231.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   protected final void method883() {
      class88.field1323 = null;
      field692 = null;
      class7.field231 = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2085679714"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-2083939625"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Llj;",
      garbageValue = "-672982820"
   )
   Bounds method886() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field695);
      int var3 = Math.max(var1.getHeight(), this.field676);
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
      garbageValue = "-118"
   )
   protected final boolean method908() {
      return this.frame != null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   protected abstract void vmethod1196();

   public final void destroy() {
      if(this == shell && !field680) {
         field705 = PendingSpawn.currentTimeMs();
         PacketBuffer.method3907(5000L);
         this.method870();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field680) {
         this.field702 = true;
         if(PendingSpawn.currentTimeMs() - this.field706 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= canvasWidth && var2.height >= class195.canvasHeight) {
               this.field689 = true;
            }
         }

      }
   }

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= '0' && var5 <= '9';
                     if(!var4) {
                        break;
                     }
                  }

                  String var14 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var14.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label184: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == '-') {
                              var7 = true;
                              break label184;
                           }

                           if(var12 == '+') {
                              break label184;
                           }
                        }

                        int var20;
                        if(var12 >= '0' && var12 <= '9') {
                           var20 = var12 - '0';
                        } else if(var12 >= 'A' && var12 <= 'Z') {
                           var20 = var12 - '7';
                        } else {
                           if(var12 < 'a' || var12 > 'z') {
                              var6 = false;
                              break;
                           }

                           var20 = var12 - 'W';
                        }

                        if(var20 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var20 = -var20;
                        }

                        int var13 = var20 + var9 * 10;
                        if(var9 != var13 / 10) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6) {
                     int var19 = class132.parseInt(var14, 10, true);
                     if(var19 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field684 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var18;
         try {
            var18 = new NanoTimer();
         } catch (Throwable var16) {
            var18 = new MilliTimer();
         }

         class315.timer = (Timer)var18;

         while(0L == field705 || PendingSpawn.currentTimeMs() < field705) {
            field703 = class315.timer.vmethod3370(field683, field684);

            for(int var15 = 0; var15 < field703; ++var15) {
               this.method947();
            }

            this.method873();
            this.method851(this.canvas);
         }
      } catch (Exception var17) {
         ItemLayer.processClientError((String)null, var17);
         this.error("crash");
      }

      this.method870();
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field702 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowIconified(WindowEvent var1) {
   }

   public final void start() {
      if(this == shell && !field680) {
         field705 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field680) {
         field705 = PendingSpawn.currentTimeMs() + 4000L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-86"
   )
   static void method982(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field637 = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1936304331"
   )
   public static void method983(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "32768"
   )
   public static void method984() {
      try {
         if(class229.field2694 == 1) {
            int var0 = class229.field2690.method4287();
            if(var0 > 0 && class229.field2690.method4266()) {
               var0 -= class284.field3699;
               if(var0 < 0) {
                  var0 = 0;
               }

               class229.field2690.method4305(var0);
               return;
            }

            class229.field2690.method4259();
            class229.field2690.method4257();
            if(class229.field2687 != null) {
               class229.field2694 = 2;
            } else {
               class229.field2694 = 0;
            }

            class5.field36 = null;
            class185.field2500 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class229.field2690.method4259();
         class229.field2694 = 0;
         class5.field36 = null;
         class185.field2500 = null;
         class229.field2687 = null;
      }

   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(IIII)Lbg;",
      garbageValue = "-1320220822"
   )
   static final WidgetNode method985(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.owner = var2;
      Client.componentTable.put(var3, (long)var0);
      class29.method253(var1);
      Widget var4 = class5.getWidget(var0);
      class171.method3363(var4);
      if(Client.field1014 != null) {
         class171.method3363(Client.field1014);
         Client.field1014 = null;
      }

      IndexStoreActionHandler.method4767();
      class183.method3484(Widget.widgets[var0 >> 16], var4, false);
      MapLabel.method367(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class18.loadWidget(var5)) {
            CombatInfo1.method1644(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
