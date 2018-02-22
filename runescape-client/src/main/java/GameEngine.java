import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
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

@ObfuscatedName("bi")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lbi;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1960156121
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 8345837030110635179L
   )
   static long field625;
   @ObfuscatedName("a")
   static boolean field654;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1184423779
   )
   protected static int field624;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1398661159
   )
   static int field629;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -360072925
   )
   static int field633;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1576753753
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   public static Font field657;
   @ObfuscatedName("v")
   protected static long[] field639;
   @ObfuscatedName("t")
   protected static long[] field634;
   @ObfuscatedName("ak")
   static Image field646;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1687695805
   )
   static int field647;
   @ObfuscatedName("ay")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      longValue = 3347206938434192321L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = 8250831551300795719L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("h")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2095267971
   )
   protected int field652;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1540648959
   )
   protected int field632;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1376630481
   )
   int field637;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1159108555
   )
   int field622;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 181385691
   )
   int field636;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1288617451
   )
   int field640;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1783629357
   )
   int field641;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -452906825
   )
   int field642;
   @ObfuscatedName("af")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("ai")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("aq")
   volatile boolean field645;
   @ObfuscatedName("as")
   boolean field648;
   @ObfuscatedName("az")
   volatile boolean field649;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = -4560052699880793927L
   )
   volatile long field626;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("au")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ac")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field625 = 0L;
      field654 = false;
      field629 = 20;
      field633 = 1;
      FPS = 0;
      field639 = new long[32];
      field634 = new long[32];
      field647 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field637 = 0;
      this.field622 = 0;
      this.field645 = true;
      this.field648 = false;
      this.field649 = false;
      this.field626 = 0L;
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "593131913"
   )
   protected final void method862(int var1, int var2) {
      if(this.field641 != var1 || var2 != this.field642) {
         this.method913();
      }

      this.field641 = var1;
      this.field642 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-702098743"
   )
   final void method936(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class19.method152(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lfu;",
      garbageValue = "-10"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1042165408"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2077598859"
   )
   protected void method866(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "553095563"
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

      BoundingBox2D.method33(this.canvas);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-306920730"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      SoundTaskDataProvider.method800(this.canvas);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1003724794"
   )
   final void method869() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method894();
         this.field652 = Math.max(var2.field3862, this.field636);
         this.field632 = Math.max(var2.field3861, this.field640);
         if(this.field652 <= 0) {
            this.field652 = 1;
         }

         if(this.field632 <= 0) {
            this.field632 = 1;
         }

         class1.canvasWidth = Math.min(this.field652, this.field641);
         class25.canvasHeight = Math.min(this.field632, this.field642);
         this.field637 = (this.field652 - class1.canvasWidth) / 2;
         this.field622 = 0;
         this.canvas.setSize(class1.canvasWidth, class25.canvasHeight);
         class324.rasterProvider = new MainBufferProvider(class1.canvasWidth, class25.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.field637 + var3.left, this.field622 + var3.top);
         } else {
            this.canvas.setLocation(this.field637, this.field622);
         }

         this.field645 = true;
         this.vmethod1242();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1654758683"
   )
   protected abstract void vmethod1242();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-788440659"
   )
   void method871() {
      int var1 = this.field637;
      int var2 = this.field622;
      int var3 = this.field652 - class1.canvasWidth - var1;
      int var4 = this.field632 - class25.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field632);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field652, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field652 - var3, var7, var3, this.field632);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field632 - var4, this.field652, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1753215260"
   )
   final void method872() {
      class23.method189(this.canvas);
      Canvas var1 = this.canvas;
      var1.removeMouseListener(MouseInput.mouse);
      var1.removeMouseMotionListener(MouseInput.mouse);
      var1.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      BoundingBox2D.method33(this.canvas);
      SoundTaskDataProvider.method800(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method913();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2118415891"
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
         class1.canvasWidth = var1;
         class25.canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2147 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class37.method519((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-399941550"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class1.canvasWidth = Math.max(var1.getWidth(), this.field636);
      class25.canvasHeight = Math.max(var1.getHeight(), this.field640);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         class1.canvasWidth -= var2.left + var2.right;
         class25.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class1.canvasWidth, class25.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field637 + var2.left, var2.top + this.field622);
      } else {
         this.canvas.setLocation(this.field637, this.field622);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field645 = true;
      if(class324.rasterProvider != null && class1.canvasWidth == class324.rasterProvider.width && class25.canvasHeight == class324.rasterProvider.height) {
         ((MainBufferProvider)class324.rasterProvider).replaceComponent(this.canvas);
         class324.rasterProvider.drawFull(0, 0);
      } else {
         class324.rasterProvider = new MainBufferProvider(class1.canvasWidth, class25.canvasHeight, this.canvas);
      }

      this.field649 = false;
      this.field626 = class188.currentTimeMs();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1258380665"
   )
   void method861() {
      long var1 = class188.currentTimeMs();
      long var3 = field634[ScriptState.field706];
      field634[ScriptState.field706] = var1;
      ScriptState.field706 = ScriptState.field706 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class166.field2176 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   void method877() {
      Container var1 = this.container();
      long var2 = class188.currentTimeMs();
      long var4 = field639[class87.field1290];
      field639[class87.field1290] = var2;
      class87.field1290 = class87.field1290 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field647 - 1 > 50) {
         field647 -= 50;
         this.field645 = true;
         this.canvas.setSize(class1.canvasWidth, class25.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field637 + var7.left, this.field622 + var7.top);
         } else {
            this.canvas.setLocation(this.field637, this.field622);
         }
      }

      if(this.field649) {
         this.method872();
      }

      this.method878();
      this.methodDraw(this.field645);
      if(this.field645) {
         this.method871();
      }

      this.field645 = false;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1073177757"
   )
   final void method878() {
      Bounds var1 = this.method894();
      if(this.field652 != var1.field3862 || this.field632 != var1.field3861 || this.field648) {
         this.method869();
         this.field648 = false;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-99"
   )
   final void method913() {
      this.field648 = true;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "980354423"
   )
   final synchronized void method880() {
      if(!field654) {
         field654 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1236();
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

         this.vmethod1391();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1837026212"
   )
   protected abstract void setUp();

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1630438028"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1263323561"
   )
   protected abstract void vmethod1236();

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "1642903978"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class56.field613 == null) {
            class56.field613 = new java.awt.Font("Helvetica", 1, 13);
            LoginPacket.field2443 = this.canvas.getFontMetrics(class56.field613);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class1.canvasWidth, class25.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(field646 == null) {
               field646 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = field646.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class56.field613);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - LoginPacket.field2443.stringWidth(var2)) / 2, 22);
            var4.drawImage(field646, class1.canvasWidth / 2 - 152, class25.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class1.canvasWidth / 2 - 152;
            int var8 = class25.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class56.field613);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - LoginPacket.field2443.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1977619922"
   )
   protected final void method891() {
      field646 = null;
      class56.field613 = null;
      LoginPacket.field2443 = null;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-464645661"
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "1050494280"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Llq;",
      garbageValue = "-1639109454"
   )
   Bounds method894() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field636);
      int var3 = Math.max(var1.getHeight(), this.field640);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-75"
   )
   protected final boolean method895() {
      return this.frame != null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-295132082"
   )
   protected abstract void vmethod1391();

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field654) {
         this.field645 = true;
         if(class188.currentTimeMs() - this.field626 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class1.canvasWidth && var2.height >= class25.canvasHeight) {
               this.field649 = true;
            }
         }

      }
   }

   public final void destroy() {
      if(this == shell && !field654) {
         field625 = class188.currentTimeMs();
         class19.method152(5000L);
         this.method880();
      }
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void start() {
      if(this == shell && !field654) {
         field625 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field654) {
         field625 = class188.currentTimeMs() + 4000L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
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

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class21.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && WidgetNode.method1125(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(FriendManager.method1748(var4)) {
                     int var5 = class162.parseInt(var4, 10, true);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field633 = 5;
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

         timer = (Timer)var9;

         while(field625 == 0L || class188.currentTimeMs() < field625) {
            field624 = timer.vmethod3306(field629, field633);

            for(int var6 = 0; var6 < field624; ++var6) {
               this.method861();
            }

            this.method877();
            this.method936(this.canvas);
         }
      } catch (Exception var8) {
         class37.method519((String)null, var8);
         this.error("crash");
      }

      this.method880();
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field645 = true;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1724528267"
   )
   static final void method890(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         int var2 = WorldComparator.method62();
         String var3;
         if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
            var3 = "Use" + " " + Client.lastSelectedItemName + " " + "->";
         } else if(Client.spellSelected && Client.menuOptionCount < 2) {
            var3 = Client.field961 + " " + Client.field962 + " " + "->";
         } else {
            var3 = WorldComparator.method71(var2);
         }

         if(Client.menuOptionCount > 2) {
            var3 = var3 + BoundingBox3D.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
         }

         class153.fontBold12.drawRandomizedMouseoverText(var3, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
      }
   }
}
