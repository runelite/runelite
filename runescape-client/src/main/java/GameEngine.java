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

@ObfuscatedName("bd")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1767721475
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 8724876113085575369L
   )
   static long field660;
   @ObfuscatedName("d")
   static boolean field692;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 876757279
   )
   static int field666;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 127895267
   )
   static int field690;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 588963553
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("t")
   static long[] field673;
   @ObfuscatedName("a")
   static long[] field689;
   @ObfuscatedName("ag")
   static java.awt.Font field676;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2078871221
   )
   static int field680;
   @ObfuscatedName("aq")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = -4159530777100722497L
   )
   @Export("garbageCollectorLastCollectionTime")
   static long garbageCollectorLastCollectionTime;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 4051514173255065559L
   )
   @Export("garbageCollectorLastCheckTimeMs")
   static long garbageCollectorLastCheckTimeMs;
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 2065939819
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("s")
   @Export("hasErrored")
   boolean hasErrored;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1611910291
   )
   protected int field668;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -717901183
   )
   protected int field669;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1212490443
   )
   int field670;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1881261339
   )
   int field658;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1348149971
   )
   int field678;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 127325775
   )
   int field661;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -77872485
   )
   int field663;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 497817263
   )
   int field675;
   @ObfuscatedName("af")
   @Export("frame")
   java.awt.Frame frame;
   @ObfuscatedName("az")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ae")
   volatile boolean field687;
   @ObfuscatedName("ax")
   boolean field681;
   @ObfuscatedName("ah")
   volatile boolean field679;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = -6639434391334137827L
   )
   volatile long field683;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   @Export("mouseWheelHandler")
   MouseWheelHandler mouseWheelHandler;
   @ObfuscatedName("al")
   @Export("clipboard")
   Clipboard clipboard;
   @ObfuscatedName("ay")
   @Export("eventQueue")
   final EventQueue eventQueue;

   static {
      shell = null;
      shellCount = 0;
      field660 = 0L;
      field692 = false;
      field666 = 20;
      field690 = 1;
      FPS = 0;
      field673 = new long[32];
      field689 = new long[32];
      field680 = 500;
      focused = true;
      garbageCollectorLastCollectionTime = -1L;
      garbageCollectorLastCheckTimeMs = -1L;
   }

   protected GameEngine() {
      this.hasErrored = false;
      this.field670 = 0;
      this.field658 = 0;
      this.field687 = true;
      this.field681 = false;
      this.field679 = false;
      this.field683 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.eventQueue = var1;
      class27.method209(new SoundTaskDataProvider());
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public final void method832(int var1, int var2) {
      if(this.field663 != var1 || var2 != this.field675) {
         this.method849();
      }

      this.field663 = var1;
      this.field675 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "831855861"
   )
   final void method924(Object var1) {
      if(this.eventQueue != null) {
         for(int var2 = 0; var2 < 50 && this.eventQueue.peekEvent() != null; ++var2) {
            class61.method1077(1L);
         }

         if(var1 != null) {
            this.eventQueue.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Lfk;",
      garbageValue = "127"
   )
   @Export("mouseWheel")
   protected MouseWheel mouseWheel() {
      if(this.mouseWheelHandler == null) {
         this.mouseWheelHandler = new MouseWheelHandler();
         this.mouseWheelHandler.addTo(this.canvas);
      }

      return this.mouseWheelHandler;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1446017177"
   )
   @Export("setUpClipboard")
   protected void setUpClipboard() {
      this.clipboard = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-14497"
   )
   protected void method835(String var1) {
      this.clipboard.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   @Export("setUpKeyboard")
   protected final void setUpKeyboard() {
      class133.method2654();
      ClanMember.method1168(this.canvas);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1441154991"
   )
   @Export("setUpMouse")
   protected final void setUpMouse() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   final void method838() {
      Container var1 = this.container();
      if(var1 != null) {
         Bounds var2 = this.method863();
         this.field668 = Math.max(var2.field3818, this.field678);
         this.field669 = Math.max(var2.field3819, this.field661);
         if(this.field668 <= 0) {
            this.field668 = 1;
         }

         if(this.field669 <= 0) {
            this.field669 = 1;
         }

         class87.canvasWidth = Math.min(this.field668, this.field663);
         class25.canvasHeight = Math.min(this.field669, this.field675);
         this.field670 = (this.field668 - class87.canvasWidth) / 2;
         this.field658 = 0;
         this.canvas.setSize(class87.canvasWidth, class25.canvasHeight);
         class35.rasterProvider = new MainBufferProvider(class87.canvasWidth, class25.canvasHeight, this.canvas);
         if(var1 == this.frame) {
            Insets var3 = this.frame.getInsets();
            this.canvas.setLocation(var3.left + this.field670, var3.top + this.field658);
         } else {
            this.canvas.setLocation(this.field670, this.field658);
         }

         this.field687 = true;
         this.vmethod1214();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "41"
   )
   protected abstract void vmethod1214();

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1725763807"
   )
   void method964() {
      int var1 = this.field670;
      int var2 = this.field658;
      int var3 = this.field668 - class87.canvasWidth - var1;
      int var4 = this.field669 - class25.canvasHeight - var2;
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
               var10.fillRect(var6, var7, var1, this.field669);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field668, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field668 - var3, var7, var3, this.field669);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field669 - var4, this.field668, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121457195"
   )
   final void method841() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field611 = -1;
      class44.method625(this.canvas);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.removeFrom(this.canvas);
      }

      this.replaceCanvas();
      ClanMember.method1168(this.canvas);
      Canvas var2 = this.canvas;
      var2.addMouseListener(MouseInput.mouse);
      var2.addMouseMotionListener(MouseInput.mouse);
      var2.addFocusListener(MouseInput.mouse);
      if(this.mouseWheelHandler != null) {
         this.mouseWheelHandler.addTo(this.canvas);
      }

      this.method849();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2129649285"
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
         class87.canvasWidth = var1;
         class25.canvasHeight = var2;
         UnitPriceComparator.revision = var3;
         RunException.field2140 = this;
         if(class179.taskManager == null) {
            class179.taskManager = new Signlink();
         }

         class179.taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         Bounds.method5132((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1196318541"
   )
   @Export("replaceCanvas")
   final synchronized void replaceCanvas() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class87.canvasWidth = Math.max(var1.getWidth(), this.field678);
      class25.canvasHeight = Math.max(var1.getHeight(), this.field661);
      Insets var2;
      if(this.frame != null) {
         var2 = this.frame.getInsets();
         class87.canvasWidth -= var2.left + var2.right;
         class25.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new GameCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class87.canvasWidth, class25.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.frame) {
         var2 = this.frame.getInsets();
         this.canvas.setLocation(var2.left + this.field670, this.field658 + var2.top);
      } else {
         this.canvas.setLocation(this.field670, this.field658);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field687 = true;
      if(class35.rasterProvider != null && class87.canvasWidth == class35.rasterProvider.width && class25.canvasHeight == class35.rasterProvider.height) {
         ((MainBufferProvider)class35.rasterProvider).replaceComponent(this.canvas);
         class35.rasterProvider.drawFull(0, 0);
      } else {
         class35.rasterProvider = new MainBufferProvider(class87.canvasWidth, class25.canvasHeight, this.canvas);
      }

      this.field679 = false;
      this.field683 = class60.currentTimeMs();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2146401460"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "274492581"
   )
   void method846() {
      long var1 = class60.currentTimeMs();
      long var3 = field689[class11.field254];
      field689[class11.field254] = var1;
      class11.field254 = class11.field254 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         Buffer.field2533 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-903656436"
   )
   void method847() {
      Container var1 = this.container();
      long var2 = class60.currentTimeMs();
      long var4 = field673[class41.field541];
      field673[class41.field541] = var2;
      class41.field541 = class41.field541 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field680 - 1 > 50) {
         field680 -= 50;
         this.field687 = true;
         this.canvas.setSize(class87.canvasWidth, class25.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.frame) {
            Insets var7 = this.frame.getInsets();
            this.canvas.setLocation(this.field670 + var7.left, var7.top + this.field658);
         } else {
            this.canvas.setLocation(this.field670, this.field658);
         }
      }

      if(this.field679) {
         this.method841();
      }

      this.method915();
      this.methodDraw(this.field687);
      if(this.field687) {
         this.method964();
      }

      this.field687 = false;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "441146614"
   )
   final void method915() {
      Bounds var1 = this.method863();
      if(this.field668 != var1.field3818 || var1.field3819 != this.field669 || this.field681) {
         this.method838();
         this.field681 = false;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   final void method849() {
      this.field681 = true;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-792212694"
   )
   final synchronized void method854() {
      if(!field692) {
         field692 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1179();
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

         if(class179.taskManager != null) {
            try {
               class179.taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1174();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-987954535"
   )
   protected abstract void setUp();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1066705400"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1982006370"
   )
   protected abstract void methodDraw(boolean var1);

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod1179();

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "38"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(field676 == null) {
            field676 = new java.awt.Font("Helvetica", 1, 13);
            class96.field1428 = this.canvas.getFontMetrics(field676);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class87.canvasWidth, class25.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(IndexDataBase.field3320 == null) {
               IndexDataBase.field3320 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = IndexDataBase.field3320.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(field676);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class96.field1428.stringWidth(var2)) / 2, 22);
            var4.drawImage(IndexDataBase.field3320, class87.canvasWidth / 2 - 152, class25.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class87.canvasWidth / 2 - 152;
            int var8 = class25.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(field676);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class96.field1428.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1673543398"
   )
   protected final void method860() {
      IndexDataBase.field3320 = null;
      field676 = null;
      class96.field1428 = null;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1774429799"
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1668111885"
   )
   @Export("container")
   Container container() {
      return (Container)(this.frame != null?this.frame:this);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Lkk;",
      garbageValue = "1146774471"
   )
   Bounds method863() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field678);
      int var3 = Math.max(var1.getHeight(), this.field661);
      if(this.frame != null) {
         Insets var4 = this.frame.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Bounds(var2, var3);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "978489840"
   )
   protected final boolean method864() {
      return this.frame != null;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   protected abstract void vmethod1174();

   public final void destroy() {
      if(this == shell && !field692) {
         field660 = class60.currentTimeMs();
         class61.method1077(5000L);
         this.method854();
      }
   }

   @Export("paint")
   @ObfuscatedName("paint")
   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field692) {
         this.field687 = true;
         if(class60.currentTimeMs() - this.field683 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class87.canvasWidth && var2.height >= class25.canvasHeight) {
               this.field679 = true;
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
                  for(var3 = 6; var3 < var2.length() && class215.method4023(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(AbstractByteBuffer.method3585(var4)) {
                     int var5 = PacketNode.parseInt(var4, 10, true);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field690 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.replaceCanvas();
         this.setUp();
         Signlink.timer = class36.method491();

         while(field660 == 0L || class60.currentTimeMs() < field660) {
            class40.field523 = Signlink.timer.vmethod3129(field666, field690);

            for(int var6 = 0; var6 < class40.field523; ++var6) {
               this.method846();
            }

            this.method847();
            this.method924(this.canvas);
         }
      } catch (Exception var7) {
         Bounds.method5132((String)null, var7);
         this.error("crash");
      }

      this.method854();
   }

   public final void start() {
      if(this == shell && !field692) {
         field660 = 0L;
      }
   }

   @Export("update")
   @ObfuscatedName("update")
   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field687 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("init")
   public abstract void init();

   public final void stop() {
      if(this == shell && !field692) {
         field660 = class60.currentTimeMs() + 4000L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeiconified(WindowEvent var1) {
   }
}
