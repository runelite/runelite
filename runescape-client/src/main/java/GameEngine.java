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
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1928838887
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 4273892077386248755L
   )
   static long field671;
   @ObfuscatedName("i")
   static boolean field650;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1637929409
   )
   protected static int field652;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 207082845
   )
   static int field653;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 69857241
   )
   static int field654;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 751299671
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("f")
   protected static long[] field675;
   @ObfuscatedName("r")
   protected static long[] field676;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -473141697
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -40310251
   )
   static int field670;
   @ObfuscatedName("av")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = -768435105453212617L
   )
   @Export("garbageCollectorLastCollectionTime")
   protected static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = -9074749867395502949L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   protected static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("t")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1467490317
   )
   protected int field658;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 150702889
   )
   protected int field659;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1252143259
   )
   int field660;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1155665937
   )
   int field661;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2128317217
   )
   int field663;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2083407993
   )
   int field664;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 341850625
   )
   int field674;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2125061563
   )
   int field666;
   @ObfuscatedName("af")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("as")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ax")
   volatile boolean field665;
   @ObfuscatedName("ai")
   boolean field656;
   @ObfuscatedName("ab")
   volatile boolean field672;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 6924673411452804443L
   )
   volatile long field673;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Laa;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ae")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ao")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field671 = 0L;
      field650 = false;
      field653 = 20;
      field654 = 1;
      FPS = 0;
      field675 = new long[32];
      field676 = new long[32];
      field670 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field660 = 0;
      this.field661 = 0;
      this.field665 = true;
      this.field656 = false;
      this.field672 = false;
      this.field673 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      SoundTaskDataProvider var2 = new SoundTaskDataProvider();
      class27.soundTaskDataProvider = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-757743575"
   )
   protected final void method806(int var1, int var2) {
      if(this.field674 != var1 || var2 != this.field666) {
         this.method863();
      }

      this.field674 = var1;
      this.field666 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "1814695890"
   )
   final void method807(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            Tile.method2712(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Lfa;",
      garbageValue = "430534495"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1086898719"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "195365664"
   )
   protected void method810(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2005820196"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      VarPlayerType.method4667();
      Preferences.method1678(this.canvas);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1142061946"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-67564327"
   )
   final void method854() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method838();
         this.field658 = Math.max(var2.field3858, this.field663);
         this.field659 = Math.max(var2.field3859, this.field664);
         if(this.field658 <= 0) {
            this.field658 = 1;
         }

         if(this.field659 <= 0) {
            this.field659 = 1;
         }

         canvasWidth = Math.min(this.field658, this.field674);
         IndexFile.canvasHeight = Math.min(this.field659, this.field666);
         this.field660 = (this.field658 - canvasWidth) / 2;
         this.field661 = 0;
         this.canvas.setSize(canvasWidth, IndexFile.canvasHeight);
         class22.rasterProvider = new MainBufferProvider(canvasWidth, IndexFile.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(this.field660 + var3.left, var3.top + this.field661);
         } else {
            this.canvas.setLocation(this.field660, this.field661);
         }

         this.field665 = true;
         this.vmethod1446();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected abstract void vmethod1446();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "795525130"
   )
   void method922() {
      int var1 = this.field660;
      int var2 = this.field661;
      int var3 = this.field658 - canvasWidth - var1;
      int var4 = this.field659 - IndexFile.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field659);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field658, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field658 - var3, var7, var3, this.field659);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field659 - var4, this.field658, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1011144234"
   )
   final void method911() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field614 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(MouseInput.mouse);
      var2.removeMouseMotionListener(MouseInput.mouse);
      var2.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Preferences.method1678(this.canvas);
      BoundingBox3D.method53(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method863();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "7"
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
         IndexFile.canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2122 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         GrandExchangeEvent.method78((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2132964903"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      canvasWidth = Math.max(var1.getWidth(), this.field663);
      IndexFile.canvasHeight = Math.max(var1.getHeight(), this.field664);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         canvasWidth -= var2.left + var2.right;
         IndexFile.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(canvasWidth, IndexFile.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(this.field660 + var2.left, this.field661 + var2.top);
      } else {
         this.canvas.setLocation(this.field660, this.field661);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field665 = true;
      if(class22.rasterProvider != null && canvasWidth == class22.rasterProvider.width && IndexFile.canvasHeight == class22.rasterProvider.height) {
         ((MainBufferProvider)class22.rasterProvider).replaceComponent(this.canvas);
         class22.rasterProvider.drawFull(0, 0);
      } else {
         class22.rasterProvider = new MainBufferProvider(canvasWidth, IndexFile.canvasHeight, this.canvas);
      }

      this.field672 = false;
      this.field673 = SceneTilePaint.currentTimeMs();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "20"
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

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "22"
   )
   void method890() {
      long var1 = SceneTilePaint.currentTimeMs();
      long var3 = field676[class168.field2235];
      field676[class168.field2235] = var1;
      class168.field2235 = class168.field2235 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class3.field14 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1190901335"
   )
   void method822() {
      Container var1 = this.container();
      long var2 = SceneTilePaint.currentTimeMs();
      long var4 = field675[Permission.field3274];
      field675[Permission.field3274] = var2;
      Permission.field3274 = Permission.field3274 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field670 - 1 > 50) {
         field670 -= 50;
         this.field665 = true;
         this.canvas.setSize(canvasWidth, IndexFile.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(var7.left + this.field660, this.field661 + var7.top);
         } else {
            this.canvas.setLocation(this.field660, this.field661);
         }
      }

      if(this.field672) {
         this.method911();
      }

      this.method823();
      this.methodDraw(this.field665);
      if(this.field665) {
         this.method922();
      }

      this.field665 = false;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method823() {
      Bounds var1 = this.method838();
      if(this.field658 != var1.field3858 || this.field659 != var1.field3859 || this.field656) {
         this.method854();
         this.field656 = false;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "320054051"
   )
   final void method863() {
      this.field656 = true;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "646928136"
   )
   final synchronized void method825() {
      if(!field650) {
         field650 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1183();
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

         this.vmethod1177();
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1602825637"
   )
   protected abstract void setUp();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "74"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2126801819"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   protected abstract void vmethod1183();

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "53"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(CombatInfo2.field3457 == null) {
            CombatInfo2.field3457 = new java.awt.Font("Helvetica", 1, 13);
            CacheFile.field1462 = this.canvas.getFontMetrics(CombatInfo2.field3457);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, canvasWidth, IndexFile.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(NameableContainer.field3712 == null) {
               NameableContainer.field3712 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = NameableContainer.field3712.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(CombatInfo2.field3457);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - CacheFile.field1462.stringWidth(var2)) / 2, 22);
            var4.drawImage(NameableContainer.field3712, canvasWidth / 2 - 152, IndexFile.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = canvasWidth / 2 - 152;
            int var8 = IndexFile.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(CombatInfo2.field3457);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - CacheFile.field1462.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "69"
   )
   protected final void method835() {
      NameableContainer.field3712 = null;
      CombatInfo2.field3457 = null;
      CacheFile.field1462 = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "13"
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1758162738"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Lkk;",
      garbageValue = "1875074020"
   )
   Bounds method838() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field663);
      int var3 = Math.max(var1.getHeight(), this.field664);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "17"
   )
   protected final boolean method839() {
      return this.frame != null;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-395723204"
   )
   protected abstract void vmethod1177();

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field650) {
         this.field665 = true;
         if(SceneTilePaint.currentTimeMs() - this.field673 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= canvasWidth && var2.height >= IndexFile.canvasHeight) {
               this.field672 = true;
            }
         }

      }
   }

   public final void destroy() {
      if(this == shell && !field650) {
         field671 = SceneTilePaint.currentTimeMs();
         Tile.method2712(5000L);
         this.method825();
      }
   }

   public final void start() {
      if(this == shell && !field650) {
         field671 = 0L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field665 = true;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public void run() {
      try {
         if(class188.javaVendor != null) {
            String var1 = class188.javaVendor.toLowerCase();
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

                     label177: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == '-') {
                              var7 = true;
                              break label177;
                           }

                           if(var12 == '+') {
                              break label177;
                           }
                        }

                        int var18;
                        if(var12 >= '0' && var12 <= '9') {
                           var18 = var12 - '0';
                        } else if(var12 >= 'A' && var12 <= 'Z') {
                           var18 = var12 - '7';
                        } else {
                           if(var12 < 'a' || var12 > 'z') {
                              var6 = false;
                              break;
                           }

                           var18 = var12 - 'W';
                        }

                        if(var18 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var18 = -var18;
                        }

                        int var13 = var18 + var9 * 10;
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
                     int var17 = Projectile.parseInt(var14, 10, true);
                     if(var17 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field654 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         WorldMapType2.timer = FaceNormal.method3115();

         while(0L == field671 || SceneTilePaint.currentTimeMs() < field671) {
            field652 = WorldMapType2.timer.vmethod3288(field653, field654);

            for(int var15 = 0; var15 < field652; ++var15) {
               this.method890();
            }

            this.method822();
            this.method807(this.canvas);
         }
      } catch (Exception var16) {
         GrandExchangeEvent.method78((String)null, var16);
         this.error("crash");
      }

      this.method825();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void stop() {
      if(this == shell && !field650) {
         field671 = SceneTilePaint.currentTimeMs() + 4000L;
      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();
}
