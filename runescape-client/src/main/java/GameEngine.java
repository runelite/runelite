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

@ObfuscatedName("bn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1066350733
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 7179673697890746775L
   )
   static long field637;
   @ObfuscatedName("a")
   static boolean field653;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1293351733
   )
   static int field632;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1262464337
   )
   static int field633;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -48897765
   )
   static int field634;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1104482499
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("n")
   static long[] field636;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -199005675
   )
   static int field639;
   @ObfuscatedName("l")
   static long[] field638;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -785497347
   )
   static int field650;
   @ObfuscatedName("aq")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -9079398486391623801L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = 4955020771486176391L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("t")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1232693661
   )
   protected int field656;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -19020615
   )
   protected int field640;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -438310959
   )
   int field641;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -777605801
   )
   int field642;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1061314879
   )
   int field643;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1690333971
   )
   int field647;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1081481951
   )
   int field645;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 40413121
   )
   int field646;
   @ObfuscatedName("ax")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("ae")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ah")
   volatile boolean field649;
   @ObfuscatedName("am")
   boolean field630;
   @ObfuscatedName("af")
   volatile boolean field629;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 8450931186367628607L
   )
   volatile long field652;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("ad")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ab")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field637 = 0L;
      field653 = false;
      field633 = 20;
      field634 = 1;
      FPS = 0;
      field636 = new long[32];
      field638 = new long[32];
      field650 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field641 = 0;
      this.field642 = 0;
      this.field649 = true;
      this.field630 = false;
      this.field629 = false;
      this.field652 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      SoundTaskDataProvider var2 = new SoundTaskDataProvider();
      DecorativeObject.soundTaskDataProvider = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   protected final void method824(int var1, int var2) {
      if(this.field645 != var1 || var2 != this.field646) {
         this.method953();
      }

      this.field645 = var1;
      this.field646 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-588566327"
   )
   final void method825(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class1.method3(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lfj;",
      garbageValue = "1823741253"
   )
   @Export("mouseWheel")
   protected class158 mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-987203330"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1449191865"
   )
   protected void method912(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1288446896"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      GrandExchangeOffer.method125();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1925685105"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      BoundingBox3DDrawMode.method71(this.canvas);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   final void method918() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method855();
         this.field656 = Math.max(var2.field3833, this.field643);
         this.field640 = Math.max(var2.field3834, this.field647);
         if(this.field656 <= 0) {
            this.field656 = 1;
         }

         if(this.field640 <= 0) {
            this.field640 = 1;
         }

         WorldMapType1.canvasWidth = Math.min(this.field656, this.field645);
         class263.canvasHeight = Math.min(this.field640, this.field646);
         this.field641 = (this.field656 - WorldMapType1.canvasWidth) / 2;
         this.field642 = 0;
         this.canvas.setSize(WorldMapType1.canvasWidth, class263.canvasHeight);
         CombatInfo2.rasterProvider = new MainBufferProvider(WorldMapType1.canvasWidth, class263.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field641, this.field642 + var3.top);
         } else {
            this.canvas.setLocation(this.field641, this.field642);
         }

         this.field649 = true;
         this.vmethod1196();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   protected abstract void vmethod1196();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   void method833() {
      int var1 = this.field641;
      int var2 = this.field642;
      int var3 = this.field656 - WorldMapType1.canvasWidth - var1;
      int var4 = this.field640 - class263.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field640);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field656, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field656 - var3, var7, var3, this.field640);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field640 - var4, this.field656, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1100478905"
   )
   final void method829() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field588 = -1;
      ItemLayer.method2561(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      BoundingBox3DDrawMode.method71(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method953();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "41"
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
         WorldMapType1.canvasWidth = var1;
         class263.canvasHeight = var2;
         RunException.revision = var3;
         RunException.field2101 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class89.method1900((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-140186665"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      WorldMapType1.canvasWidth = Math.max(var1.getWidth(), this.field643);
      class263.canvasHeight = Math.max(var1.getHeight(), this.field647);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         WorldMapType1.canvasWidth -= var2.left + var2.right;
         class263.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(WorldMapType1.canvasWidth, class263.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field641, var2.top + this.field642);
      } else {
         this.canvas.setLocation(this.field641, this.field642);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field649 = true;
      if(CombatInfo2.rasterProvider != null && WorldMapType1.canvasWidth == CombatInfo2.rasterProvider.width && class263.canvasHeight == CombatInfo2.rasterProvider.height) {
         ((MainBufferProvider)CombatInfo2.rasterProvider).replaceComponent(this.canvas);
         CombatInfo2.rasterProvider.drawFull(0, 0);
      } else {
         CombatInfo2.rasterProvider = new MainBufferProvider(WorldMapType1.canvasWidth, class263.canvasHeight, this.canvas);
      }

      this.field629 = false;
      this.field652 = ScriptVarType.currentTimeMs();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1608581646"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method952() {
      long var1 = ScriptVarType.currentTimeMs();
      long var3 = field638[class213.field2590];
      field638[class213.field2590] = var1;
      class213.field2590 = class213.field2590 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class18.field305 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1853397877"
   )
   void method839() {
      Container var1 = this.container();
      long var2 = ScriptVarType.currentTimeMs();
      long var4 = field636[field639];
      field636[field639] = var2;
      field639 = field639 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field650 - 1 > 50) {
         field650 -= 50;
         this.field649 = true;
         this.canvas.setSize(WorldMapType1.canvasWidth, class263.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field641 + var7.left, this.field642 + var7.top);
         } else {
            this.canvas.setLocation(this.field641, this.field642);
         }
      }

      if(this.field629) {
         this.method829();
      }

      this.method840();
      this.methodDraw(this.field649);
      if(this.field649) {
         this.method833();
      }

      this.field649 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1883130675"
   )
   final void method840() {
      Bounds var1 = this.method855();
      if(var1.field3833 != this.field656 || var1.field3834 != this.field640 || this.field630) {
         this.method918();
         this.field630 = false;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "922572175"
   )
   final void method953() {
      this.field630 = true;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1977502380"
   )
   final synchronized void method842() {
      if(!field653) {
         field653 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1365();
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

         this.vmethod1185();
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2126532400"
   )
   protected abstract void setUp();

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1531470648"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "868698548"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "951535909"
   )
   protected abstract void vmethod1365();

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1743338563"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class233.field2921 == null) {
            class233.field2921 = new java.awt.Font("Helvetica", 1, 13);
            BoundingBox.field238 = this.canvas.getFontMetrics(class233.field2921);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, WorldMapType1.canvasWidth, class263.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(ISAACCipher.field2516 == null) {
               ISAACCipher.field2516 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = ISAACCipher.field2516.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class233.field2921);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - BoundingBox.field238.stringWidth(var2)) / 2, 22);
            var4.drawImage(ISAACCipher.field2516, WorldMapType1.canvasWidth / 2 - 152, class263.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = WorldMapType1.canvasWidth / 2 - 152;
            int var8 = class263.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class233.field2921);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - BoundingBox.field238.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-624424918"
   )
   protected final void method852() {
      ISAACCipher.field2516 = null;
      class233.field2921 = null;
      BoundingBox.field238 = null;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-449319949"
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
      garbageValue = "-1910125786"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)Lkw;",
      garbageValue = "-63"
   )
   Bounds method855() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field643);
      int var3 = Math.max(var1.getHeight(), this.field647);
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
      garbageValue = "852421468"
   )
   protected final boolean method856() {
      return this.frame != null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-951477235"
   )
   protected abstract void vmethod1185();

   public final void destroy() {
      if(this == shell && !field653) {
         field637 = ScriptVarType.currentTimeMs();
         class1.method3(5000L);
         this.method842();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field653) {
         this.field649 = true;
         if(ScriptVarType.currentTimeMs() - this.field652 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= WorldMapType1.canvasWidth && var2.height >= class263.canvasHeight) {
               this.field629 = true;
            }
         }

      }
   }

   public void run() {
      try {
         if(class192.javaVendor != null) {
            String var1 = class192.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class150.javaVersion;
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

                        int var13 = var9 * 10 + var18;
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
                     int var17 = BoundingBox3DDrawMode.parseInt(var14, 10, true);
                     if(var17 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field634 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         class310.timer = class65.method1071();

         while(field637 == 0L || ScriptVarType.currentTimeMs() < field637) {
            field632 = class310.timer.vmethod3176(field633, field634);

            for(int var15 = 0; var15 < field632; ++var15) {
               this.method952();
            }

            this.method839();
            this.method825(this.canvas);
         }
      } catch (Exception var16) {
         class89.method1900((String)null, var16);
         this.error("crash");
      }

      this.method842();
   }

   public final void start() {
      if(this == shell && !field653) {
         field637 = 0L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field649 = true;
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

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void windowActivated(WindowEvent var1) {
   }

   public final void stop() {
      if(this == shell && !field653) {
         field637 = ScriptVarType.currentTimeMs() + 4000L;
      }
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   static void method981() {
      class61.field686 = 99;
      class25.field352 = new byte[4][104][104];
      class61.field687 = new byte[4][104][104];
      class61.field688 = new byte[4][104][104];
      IndexFile.field2159 = new byte[4][104][104];
      class61.field690 = new int[4][105][105];
      class29.field392 = new byte[4][105][105];
      Item.field1371 = new int[105][105];
      class31.field413 = new int[104];
      BaseVarType.field24 = new int[104];
      class61.field685 = new int[104];
      ItemLayer.field1669 = new int[104];
      Ignore.field3688 = new int[104];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lbi;",
      garbageValue = "-1890045282"
   )
   static World method982() {
      return World.field1176 < World.worldCount?class89.worldList[++World.field1176 - 1]:null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static final void method983() {
      class63.method1054("You can\'t add yourself to your own ignore list");
   }
}
