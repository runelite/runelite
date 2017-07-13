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

@ObfuscatedName("bb")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("at")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("j")
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("v")
   static boolean field684;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1870309865
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6621023120573955311L
   )
   static long field683;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1802224221
   )
   static int field685;
   @ObfuscatedName("c")
   static long[] field700;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1762954181
   )
   static int field687;
   @ObfuscatedName("k")
   static long[] field690;
   @ObfuscatedName("a")
   @Export("taskManager")
   public static Signlink taskManager;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 561374415
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 902004827
   )
   static int field680;
   @ObfuscatedName("av")
   Clipboard field710;
   @ObfuscatedName("ab")
   final EventQueue field709;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -344932241
   )
   int field698;
   @ObfuscatedName("ag")
   boolean field704;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1413412239
   )
   int field692;
   @ObfuscatedName("e")
   boolean field703;
   @ObfuscatedName("as")
   class49 field707;
   @ObfuscatedName("ar")
   java.awt.Frame field682;
   @ObfuscatedName("am")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2142179647
   )
   int field695;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1454796811
   )
   int field691;
   @ObfuscatedName("aw")
   volatile boolean field702;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 711936399
   )
   protected int field699;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 453901719
   )
   int field708;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1486357809
   )
   protected int field693;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2032730863
   )
   int field697;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 3456054863828263071L
   )
   volatile long field706;
   @ObfuscatedName("aj")
   volatile boolean field705;

   static {
      shell = null;
      shellCount = 0;
      field683 = 0L;
      field684 = false;
      field685 = 20;
      field687 = 1;
      FPS = 0;
      field690 = new long[32];
      field700 = new long[32];
      field680 = 500;
      focused = true;
   }

   protected GameEngine() {
      this.field703 = false;
      this.field692 = 0;
      this.field695 = 0;
      this.field702 = true;
      this.field704 = false;
      this.field705 = false;
      this.field706 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field709 = var1;
      class51 var2 = new class51();
      class267.field3666 = var2;
   }

   public final void destroy() {
      if(this == shell && !field684) {
         field683 = class46.currentTimeMs();
         class33.method354(5000L);
         this.method869();
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "2047"
   )
   @Export("isValidHost")
   protected final boolean isValidHost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(var1.endsWith("127.0.0.1")) {
               return true;
            } else {
               while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
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

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field684) {
         this.field702 = true;
         if(class46.currentTimeMs() - this.field706 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class77.canvasWidth && var2.height >= FloorUnderlayDefinition.canvasHeight) {
               this.field705 = true;
            }
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)Lclass278;",
      garbageValue = "-1130280805"
   )
   class278 method913() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field708);
      int var3 = Math.max(var1.getHeight(), this.field697);
      if(this.field682 != null) {
         Insets var4 = this.field682.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(S)Ljava/awt/Container;",
      garbageValue = "8226"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field682 != null?this.field682:this);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2081625025"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field703) {
         this.field703 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   final void method868() {
      this.field704 = true;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1619648467"
   )
   final synchronized void method869() {
      if(!field684) {
         field684 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1148();
         } catch (Exception var4) {
            ;
         }

         if(this.field682 != null) {
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

         this.vmethod1143();
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2009764458"
   )
   final synchronized void method863() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class77.canvasWidth = Math.max(var1.getWidth(), this.field708);
      FloorUnderlayDefinition.canvasHeight = Math.max(var1.getHeight(), this.field697);
      Insets var2;
      if(this.field682 != null) {
         var2 = this.field682.getInsets();
         class77.canvasWidth -= var2.right + var2.left;
         FloorUnderlayDefinition.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class77.canvasWidth, FloorUnderlayDefinition.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field682) {
         var2 = this.field682.getInsets();
         this.canvas.setLocation(var2.left + this.field692, var2.top + this.field695);
      } else {
         this.canvas.setLocation(this.field692, this.field695);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field702 = true;
      if(GZipDecompressor.field2327 != null && class77.canvasWidth == GZipDecompressor.field2327.width && FloorUnderlayDefinition.canvasHeight == GZipDecompressor.field2327.height) {
         ((MainBufferProvider)GZipDecompressor.field2327).method837(this.canvas);
         GZipDecompressor.field2327.vmethod4942(0, 0);
      } else {
         GZipDecompressor.field2327 = new MainBufferProvider(class77.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
      }

      this.field705 = false;
      this.field706 = class46.currentTimeMs();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1865510384"
   )
   protected abstract void vmethod1148();

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "315332154"
   )
   protected abstract void vmethod1145();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "93671150"
   )
   final void method858() {
      Container var1 = this.container();
      if(var1 != null) {
         class278 var2 = this.method913();
         this.field699 = Math.max(var2.field3742, this.field708);
         this.field693 = Math.max(var2.field3743, this.field697);
         if(this.field699 <= 0) {
            this.field699 = 1;
         }

         if(this.field693 <= 0) {
            this.field693 = 1;
         }

         class77.canvasWidth = Math.min(this.field699, this.field698);
         FloorUnderlayDefinition.canvasHeight = Math.min(this.field693, this.field691);
         this.field692 = (this.field699 - class77.canvasWidth) / 2;
         this.field695 = 0;
         this.canvas.setSize(class77.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         GZipDecompressor.field2327 = new MainBufferProvider(class77.canvasWidth, FloorUnderlayDefinition.canvasHeight, this.canvas);
         if(var1 == this.field682) {
            Insets var3 = this.field682.getInsets();
            this.canvas.setLocation(this.field692 + var3.left, var3.top + this.field695);
         } else {
            this.canvas.setLocation(this.field692, this.field695);
         }

         this.field702 = true;
         this.vmethod1273();
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1693720030"
   )
   protected final void method880() {
      Timer.field2258 = null;
      class54.field657 = null;
      PacketBuffer.field2417 = null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1825419509"
   )
   protected abstract void vmethod1143();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1087908065"
   )
   protected final void method856() {
      class15.method92();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   protected final void method857() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(MouseInput.mouse);
      var1.addMouseMotionListener(MouseInput.mouse);
      var1.addFocusListener(MouseInput.mouse);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "78"
   )
   void method870() {
      long var1 = class46.currentTimeMs();
      long var3 = field700[class33.field460];
      field700[class33.field460] = var1;
      class33.field460 = class33.field460 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class21.field339 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Lclass156;",
      garbageValue = "-533671705"
   )
   protected class156 method853() {
      if(this.field707 == null) {
         this.field707 = new class49();
         this.field707.method757(this.canvas);
      }

      return this.field707;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-1050581841"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class54.field657 == null) {
            class54.field657 = new java.awt.Font("Helvetica", 1, 13);
            PacketBuffer.field2417 = this.canvas.getFontMetrics(class54.field657);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class77.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(Timer.field2258 == null) {
               Timer.field2258 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = Timer.field2258.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class54.field657);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - PacketBuffer.field2417.stringWidth(var2)) / 2, 22);
            var4.drawImage(Timer.field2258, class77.canvasWidth / 2 - 152, FloorUnderlayDefinition.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class77.canvasWidth / 2 - 152;
            int var8 = FloorUnderlayDefinition.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class54.field657);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - PacketBuffer.field2417.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1399180527"
   )
   void method866() {
      Container var1 = this.container();
      long var2 = class46.currentTimeMs();
      long var4 = field690[class40.field527];
      field690[class40.field527] = var2;
      class40.field527 = class40.field527 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field680 - 1 > 50) {
         field680 -= 50;
         this.field702 = true;
         this.canvas.setSize(class77.canvasWidth, FloorUnderlayDefinition.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field682) {
            Insets var7 = this.field682.getInsets();
            this.canvas.setLocation(this.field692 + var7.left, this.field695 + var7.top);
         } else {
            this.canvas.setLocation(this.field692, this.field695);
         }
      }

      if(this.field705) {
         this.method953();
      }

      this.method867();
      this.vmethod1415(this.field702);
      if(this.field702) {
         this.method860();
      }

      this.field702 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "542954512"
   )
   final void method973(Object var1) {
      if(this.field709 != null) {
         for(int var2 = 0; var2 < 50 && this.field709.peekEvent() != null; ++var2) {
            class33.method354(1L);
         }

         if(var1 != null) {
            this.field709.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   protected void method854() {
      this.field710 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1986260646"
   )
   protected final void method939(int var1, int var2) {
      if(this.field698 != var1 || var2 != this.field691) {
         this.method868();
      }

      this.field698 = var1;
      this.field691 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2072644177"
   )
   final void method953() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field625 = -1;
      Tile.method2491(this.canvas);
      if(this.field707 != null) {
         this.field707.method753(this.canvas);
      }

      this.method863();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      Canvas var3 = this.canvas;
      var3.addMouseListener(MouseInput.mouse);
      var3.addMouseMotionListener(MouseInput.mouse);
      var3.addFocusListener(MouseInput.mouse);
      if(this.field707 != null) {
         this.field707.method757(this.canvas);
      }

      this.method868();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1539232125"
   )
   final void method867() {
      class278 var1 = this.method913();
      if(this.field699 != var1.field3742 || var1.field3743 != this.field693 || this.field704) {
         this.method858();
         this.field704 = false;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-24450237"
   )
   protected abstract void vmethod1415(boolean var1);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1818172068"
   )
   protected abstract void vmethod1273();

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-461713167"
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
         class77.canvasWidth = var1;
         FloorUnderlayDefinition.canvasHeight = var2;
         class152.revision = var3;
         class152.field2213 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class54.method800((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method860() {
      int var1 = this.field692;
      int var2 = this.field695;
      int var3 = this.field699 - class77.canvasWidth - var1;
      int var4 = this.field693 - FloorUnderlayDefinition.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field682) {
               Insets var8 = this.field682.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field693);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field699, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field699 - var3, var7, var3, this.field693);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field693 - var4, this.field699, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "5120"
   )
   protected void method855(String var1) {
      this.field710.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1611279836"
   )
   protected final boolean method884() {
      return this.field682 != null;
   }

   public final void start() {
      if(this == shell && !field684) {
         field683 = 0L;
      }
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field702 = true;
   }

   public final void focusLost(FocusEvent var1) {
      focused = false;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
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
                  for(var3 = 6; var3 < var2.length() && Huffman.method3068(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class243.method4270(var4, 10, true);
                  if(var5) {
                     int var6 = class267.parseInt(var4, 10, true);
                     if(var6 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field687 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method863();
         this.vmethod1145();

         Object var10;
         try {
            var10 = new NanoTimer();
         } catch (Throwable var8) {
            var10 = new MilliTimer();
         }

         class48.timer = (Timer)var10;

         while(0L == field683 || class46.currentTimeMs() < field683) {
            class277.field3737 = class48.timer.vmethod2980(field685, field687);

            for(int var7 = 0; var7 < class277.field3737; ++var7) {
               this.method870();
            }

            this.method866();
            this.method973(this.canvas);
         }
      } catch (Exception var9) {
         class54.method800((String)null, var9);
         this.error("crash");
      }

      this.method869();
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public final void stop() {
      if(this == shell && !field684) {
         field683 = class46.currentTimeMs() + 4000L;
      }
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "-1268010225"
   )
   public static String method1005(int var0, boolean var1) {
      return var1 && var0 >= 0?class155.method2955(var0, 10, var1):Integer.toString(var0);
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-861758908"
   )
   static final void method944(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.bitsAvail(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.getBits(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field944 - 1] = var1;
               var3.field1263 = Client.gameCycle;
               int var4;
               if(var0) {
                  var4 = Client.secretPacketBuffer2.getBits(8);
                  if(var4 > 127) {
                     var4 -= 256;
                  }
               } else {
                  var4 = Client.secretPacketBuffer2.getBits(5);
                  if(var4 > 15) {
                     var4 -= 32;
                  }
               }

               var3.composition = class224.getNpcDefinition(Client.secretPacketBuffer2.getBits(14));
               int var5 = Client.field1034[Client.secretPacketBuffer2.getBits(3)];
               if(var2) {
                  var3.orientation = var3.angle = var5;
               }

               int var6;
               if(var0) {
                  var6 = Client.secretPacketBuffer2.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.secretPacketBuffer2.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = Client.secretPacketBuffer2.getBits(1);
               int var8 = Client.secretPacketBuffer2.getBits(1);
               if(var8 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var1;
               }

               var3.field1218 = var3.composition.field3557;
               var3.field1267 = var3.composition.field3580;
               if(var3.field1267 == 0) {
                  var3.angle = 0;
               }

               var3.field1251 = var3.composition.field3563;
               var3.field1223 = var3.composition.field3576;
               var3.field1224 = var3.composition.field3565;
               var3.field1225 = var3.composition.field3583;
               var3.idlePoseAnimation = var3.composition.field3562;
               var3.field1220 = var3.composition.field3561;
               var3.field1244 = var3.composition.field3572;
               var3.method1672(var4 + Script.localPlayer.pathX[0], var6 + Script.localPlayer.pathY[0], var7 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         return;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)LScript;",
      garbageValue = "-2062997227"
   )
   static Script method1003(int var0, class219 var1) {
      Script var2 = (Script)Script.field1530.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class265.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class265.indexScripts.method4088(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = NPC.method1676(var5);
               if(var2 != null) {
                  Script.field1530.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2040425303"
   )
   public static final void method972() {
      class134.field1999 = false;
      class134.field1995 = 0;
   }
}
