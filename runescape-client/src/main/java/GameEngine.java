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
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lbr;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 60240113
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -913012492403471363L
   )
   static long field681;
   @ObfuscatedName("h")
   static boolean field690;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1358189331
   )
   protected static int field684;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1664774939
   )
   static int field685;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 27652031
   )
   static int field686;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2089018307
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("s")
   protected static long[] field688;
   @ObfuscatedName("q")
   protected static long[] field709;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1242943529
   )
   static int field701;
   @ObfuscatedName("ar")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = 3200677801939245755L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -4075566322970891317L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("m")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1944145387
   )
   protected int field680;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1970926539
   )
   protected int field712;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1308349639
   )
   int field692;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 467302983
   )
   int field693;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1361875675
   )
   int field678;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1305317501
   )
   int field694;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1306612159
   )
   int field696;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -853633709
   )
   int field689;
   @ObfuscatedName("al")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("ah")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("af")
   volatile boolean field700;
   @ObfuscatedName("az")
   boolean field702;
   @ObfuscatedName("aa")
   volatile boolean field703;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = 5712031493198951111L
   )
   volatile long field704;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ad")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("au")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field681 = 0L;
      field690 = false;
      field685 = 20;
      field686 = 1;
      FPS = 0;
      field688 = new long[32];
      field709 = new long[32];
      field701 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field692 = 0;
      this.field693 = 0;
      this.field700 = true;
      this.field702 = false;
      this.field703 = false;
      this.field704 = 0L;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1281290674"
   )
   protected final void method894(int var1, int var2) {
      if(this.field696 != var1 || var2 != this.field689) {
         this.method911();
      }

      this.field696 = var1;
      this.field689 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-331719639"
   )
   final void method1002(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            ScriptVarType.method11(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lfp;",
      garbageValue = "87"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1571907589"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-819149785"
   )
   protected void method898(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "482242427"
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

      class23.method186(this.canvas);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-28"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2073481005"
   )
   final void method901() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method925();
         this.field680 = Math.max(var2.field3942, this.field678);
         this.field712 = Math.max(var2.field3944, this.field694);
         if(this.field680 <= 0) {
            this.field680 = 1;
         }

         if(this.field712 <= 0) {
            this.field712 = 1;
         }

         MapLabel.canvasWidth = Math.min(this.field680, this.field696);
         FloorUnderlayDefinition.canvasHeight = Math.min(this.field712, this.field689);
         this.field692 = (this.field680 - MapLabel.canvasWidth) / 2;
         this.field693 = 0;
         this.canvas.setSize(MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         MapCacheArchiveNames.rasterProvider = new MainBufferProvider(MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field692, var3.top + this.field693);
         } else {
            this.canvas.setLocation(this.field692, this.field693);
         }

         this.field700 = true;
         this.vmethod1262();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "318028838"
   )
   protected abstract void vmethod1262();

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-288810703"
   )
   void method903() {
      int var1 = this.field692;
      int var2 = this.field693;
      int var3 = this.field680 - MapLabel.canvasWidth - var1;
      int var4 = this.field712 - FloorUnderlayDefinition.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field712);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field680, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field680 - var3, var7, var3, this.field712);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field712 - var4, this.field680, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1848317849"
   )
   final void method904() {
      CacheFile.method2545(this.canvas);
      Canvas var1 = this.canvas;
      var1.removeMouseListener(MouseInput.mouse);
      var1.removeMouseMotionListener(MouseInput.mouse);
      var1.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      class23.method186(this.canvas);
      Canvas var2 = this.canvas;
      var2.addMouseListener(MouseInput.mouse);
      var2.addMouseMotionListener(MouseInput.mouse);
      var2.addFocusListener(MouseInput.mouse);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method911();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-27"
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
         MapLabel.canvasWidth = var1;
         FloorUnderlayDefinition.canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2198 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         AttackOption.processClientError((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1245071601"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      MapLabel.canvasWidth = Math.max(var1.getWidth(), this.field678);
      FloorUnderlayDefinition.canvasHeight = Math.max(var1.getHeight(), this.field694);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         MapLabel.canvasWidth -= var2.right + var2.left;
         FloorUnderlayDefinition.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field692 + var2.left, this.field693 + var2.top);
      } else {
         this.canvas.setLocation(this.field692, this.field693);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field700 = true;
      if(MapCacheArchiveNames.rasterProvider != null && MapLabel.canvasWidth == MapCacheArchiveNames.rasterProvider.width && FloorUnderlayDefinition.canvasHeight == MapCacheArchiveNames.rasterProvider.height) {
         ((MainBufferProvider)MapCacheArchiveNames.rasterProvider).replaceComponent(this.canvas);
         MapCacheArchiveNames.rasterProvider.drawFull(0, 0);
      } else {
         MapCacheArchiveNames.rasterProvider = new MainBufferProvider(MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
      }

      this.field703 = false;
      this.field704 = class64.method1118();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "7"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-96555552"
   )
   void method1015() {
      long var1 = class64.method1118();
      long var3 = field709[AttackOption.field1348];
      field709[AttackOption.field1348] = var1;
      AttackOption.field1348 = AttackOption.field1348 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         PlayerComposition.field2798 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-69993785"
   )
   void method910() {
      Container var1 = this.container();
      long var2 = class64.method1118();
      long var4 = field688[class250.field3022];
      field688[class250.field3022] = var2;
      class250.field3022 = class250.field3022 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field701 - 1 > 50) {
         field701 -= 50;
         this.field700 = true;
         this.canvas.setSize(MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field692 + var7.left, var7.top + this.field693);
         } else {
            this.canvas.setLocation(this.field692, this.field693);
         }
      }

      if(this.field703) {
         this.method904();
      }

      this.method932();
      this.methodDraw(this.field700);
      if(this.field700) {
         this.method903();
      }

      this.field700 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1050559099"
   )
   final void method932() {
      Bounds var1 = this.method925();
      if(this.field680 != var1.field3942 || var1.field3944 != this.field712 || this.field702) {
         this.method901();
         this.field702 = false;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   final void method911() {
      this.field702 = true;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "130977673"
   )
   final synchronized void method912() {
      if(!field690) {
         field690 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1256();
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

         this.vmethod1251();
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   protected abstract void setUp();

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-66"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   protected abstract void vmethod1256();

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1629716786"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(SoundTask.field1600 == null) {
            SoundTask.field1600 = new java.awt.Font("Helvetica", 1, 13);
            ChatLineBuffer.field1479 = this.canvas.getFontMetrics(SoundTask.field1600);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, MapLabel.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(TotalQuantityComparator.field304 == null) {
               TotalQuantityComparator.field304 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = TotalQuantityComparator.field304.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(SoundTask.field1600);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - ChatLineBuffer.field1479.stringWidth(var2)) / 2, 22);
            var4.drawImage(TotalQuantityComparator.field304, MapLabel.canvasWidth / 2 - 152, FloorUnderlayDefinition.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = MapLabel.canvasWidth / 2 - 152;
            int var8 = FloorUnderlayDefinition.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(SoundTask.field1600);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - ChatLineBuffer.field1479.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1257094214"
   )
   protected final void method922() {
      TotalQuantityComparator.field304 = null;
      SoundTask.field1600 = null;
      ChatLineBuffer.field1479 = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-144198557"
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

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-824656928"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Llx;",
      garbageValue = "-406138616"
   )
   Bounds method925() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field678);
      int var3 = Math.max(var1.getHeight(), this.field694);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1262559321"
   )
   protected final boolean method926() {
      return this.frame != null;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-242123961"
   )
   protected abstract void vmethod1251();

   public final void destroy() {
      if(this == shell && !field690) {
         field681 = class64.method1118();
         ScriptVarType.method11(5000L);
         this.method912();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field690) {
         this.field700 = true;
         if(class64.method1118() - this.field704 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= MapLabel.canvasWidth && var2.height >= FloorUnderlayDefinition.canvasHeight) {
               this.field703 = true;
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
                  for(var3 = 6; var3 < var2.length() && class64.method1111(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(class7.method27(var4)) {
                     int var5 = class150.parseInt(var4, 10, true);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field686 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();

         Object var9;
         try {
            var9 = new NanoTimer();
         } catch (Throwable var7) {
            var9 = new MilliTimer();
         }

         UrlRequester.timer = (Timer)var9;

         while(field681 == 0L || class64.method1118() < field681) {
            field684 = UrlRequester.timer.vmethod3328(field685, field686);

            for(int var6 = 0; var6 < field684; ++var6) {
               this.method1015();
            }

            this.method910();
            this.method1002(this.canvas);
         }
      } catch (Exception var8) {
         AttackOption.processClientError((String)null, var8);
         this.error("crash");
      }

      this.method912();
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void start() {
      if(this == shell && !field690) {
         field681 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field690) {
         field681 = class64.method1118() + 4000L;
      }
   }

   @Export("focusGained")
   @Hook("focusGained")
   @ObfuscatedName("focusGained")
   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field700 = true;
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

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "3"
   )
   public static boolean method984() {
      long var0 = class64.method1118();
      int var2 = (int)(var0 - BoundingBox3DDrawMode.field270);
      BoundingBox3DDrawMode.field270 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class264.field3416 += var2;
      if(class264.NetCache_pendingResponsesCount == 0 && class264.NetCache_pendingPriorityResponsesCount == 0 && class264.NetCache_pendingWritesCount == 0 && class264.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(class264.NetCache_socket == null) {
         return false;
      } else {
         try {
            if(class264.field3416 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class264.NetCache_pendingPriorityResponsesCount < 200 && class264.NetCache_pendingPriorityWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingPriorityWrites.first();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3337(var4.payload, 0, 4);
                  class264.NetCache_pendingPriorityResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingPriorityWritesCount;
                  ++class264.NetCache_pendingPriorityResponsesCount;
               }

               while(class264.NetCache_pendingResponsesCount < 200 && class264.NetCache_pendingWritesCount > 0) {
                  var3 = (FileRequest)class264.NetCache_pendingWritesQueue.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class264.NetCache_socket.vmethod3337(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class264.NetCache_pendingResponses.put(var3, var3.hash);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingResponsesCount;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class264.NetCache_socket.vmethod3334();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class264.field3416 = 0;
                  byte var5 = 0;
                  if(class49.currentRequest == null) {
                     var5 = 8;
                  } else if(class264.field3426 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class264.NetCache_responseHeaderBuffer.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class264.NetCache_socket.vmethod3348(class264.NetCache_responseHeaderBuffer.payload, class264.NetCache_responseHeaderBuffer.offset, var6);
                     if(class264.field3429 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class264.NetCache_responseHeaderBuffer.payload[var7 + class264.NetCache_responseHeaderBuffer.offset] ^= class264.field3429;
                        }
                     }

                     class264.NetCache_responseHeaderBuffer.offset += var6;
                     if(class264.NetCache_responseHeaderBuffer.offset < var5) {
                        break;
                     }

                     if(class49.currentRequest == null) {
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                        var7 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var8 = class264.NetCache_responseHeaderBuffer.readUnsignedShort();
                        int var9 = class264.NetCache_responseHeaderBuffer.readUnsignedByte();
                        var10 = class264.NetCache_responseHeaderBuffer.readInt();
                        long var11 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var11);
                        class264.field3419 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class264.NetCache_pendingResponses.get(var11);
                           class264.field3419 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class49.currentRequest = var13;
                        class47.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + class49.currentRequest.padding);
                        class47.NetCache_responseArchiveBuffer.putByte(var9);
                        class47.NetCache_responseArchiveBuffer.putInt(var10);
                        class264.field3426 = 8;
                        class264.NetCache_responseHeaderBuffer.offset = 0;
                     } else if(class264.field3426 == 0) {
                        if(class264.NetCache_responseHeaderBuffer.payload[0] == -1) {
                           class264.field3426 = 1;
                           class264.NetCache_responseHeaderBuffer.offset = 0;
                        } else {
                           class49.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class47.NetCache_responseArchiveBuffer.payload.length - class49.currentRequest.padding;
                     var7 = 512 - class264.field3426;
                     if(var7 > var6 - class47.NetCache_responseArchiveBuffer.offset) {
                        var7 = var6 - class47.NetCache_responseArchiveBuffer.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class264.NetCache_socket.vmethod3348(class47.NetCache_responseArchiveBuffer.payload, class47.NetCache_responseArchiveBuffer.offset, var7);
                     if(class264.field3429 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class47.NetCache_responseArchiveBuffer.payload[class47.NetCache_responseArchiveBuffer.offset + var8] ^= class264.field3429;
                        }
                     }

                     class47.NetCache_responseArchiveBuffer.offset += var7;
                     class264.field3426 += var7;
                     if(var6 == class47.NetCache_responseArchiveBuffer.offset) {
                        if(class49.currentRequest.hash == 16711935L) {
                           FrameMap.NetCache_reference = class47.NetCache_responseArchiveBuffer;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var17 = class264.NetCache_indexCaches[var8];
                              if(var17 != null) {
                                 FrameMap.NetCache_reference.offset = var8 * 8 + 5;
                                 var10 = FrameMap.NetCache_reference.readInt();
                                 int var18 = FrameMap.NetCache_reference.readInt();
                                 var17.setInformation(var10, var18);
                              }
                           }
                        } else {
                           class264.NetCache_crc.reset();
                           class264.NetCache_crc.update(class47.NetCache_responseArchiveBuffer.payload, 0, var6);
                           var8 = (int)class264.NetCache_crc.getValue();
                           if(var8 != class49.currentRequest.crc) {
                              try {
                                 class264.NetCache_socket.vmethod3331();
                              } catch (Exception var20) {
                                 ;
                              }

                              ++class264.field3430;
                              class264.NetCache_socket = null;
                              class264.field3429 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class264.field3430 = 0;
                           class264.field3431 = 0;
                           class49.currentRequest.index.write((int)(class49.currentRequest.hash & 65535L), class47.NetCache_responseArchiveBuffer.payload, 16711680L == (class49.currentRequest.hash & 16711680L), class264.field3419);
                        }

                        class49.currentRequest.unlink();
                        if(class264.field3419) {
                           --class264.NetCache_pendingPriorityResponsesCount;
                        } else {
                           --class264.NetCache_pendingResponsesCount;
                        }

                        class264.field3426 = 0;
                        class49.currentRequest = null;
                        class47.NetCache_responseArchiveBuffer = null;
                     } else {
                        if(class264.field3426 != 512) {
                           break;
                        }

                        class264.field3426 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var21) {
            try {
               class264.NetCache_socket.vmethod3331();
            } catch (Exception var19) {
               ;
            }

            ++class264.field3431;
            class264.NetCache_socket = null;
            return false;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "122"
   )
   @Export("byteArrayToObject")
   public static Object byteArrayToObject(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.directBufferUnavailable) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.directBufferUnavailable = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "18"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
