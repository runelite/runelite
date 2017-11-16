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
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lbt;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1805279961
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 5255846856313481341L
   )
   static long field642;
   @ObfuscatedName("f")
   static boolean field643;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1848829155
   )
   static int field645;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1738457379
   )
   static int field668;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 821703641
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   @Export("timer")
   static Timer timer;
   @ObfuscatedName("q")
   static long[] field639;
   @ObfuscatedName("m")
   static long[] field651;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1586127689
   )
   static int field647;
   @ObfuscatedName("af")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 1336367405630962761L
   )
   static long field671;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -3948492002719578401L
   )
   static long field672;
   @ObfuscatedName("u")
   boolean field644;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1143949989
   )
   protected int field652;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2107458409
   )
   protected int field662;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1282971953
   )
   int field654;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 334867709
   )
   int field655;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1156067215
   )
   int field656;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 781197161
   )
   int field646;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 2084449707
   )
   int field658;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1648534811
   )
   int field659;
   @ObfuscatedName("an")
   java.awt.Frame field660;
   @ObfuscatedName("am")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ar")
   volatile boolean field653;
   @ObfuscatedName("ac")
   boolean field664;
   @ObfuscatedName("as")
   volatile boolean field665;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = 3694174739601561101L
   )
   volatile long field666;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   class49 field667;
   @ObfuscatedName("ap")
   Clipboard field648;
   @ObfuscatedName("ag")
   final EventQueue field669;

   static {
      shell = null;
      shellCount = 0;
      field642 = 0L;
      field643 = false;
      field645 = 20;
      field668 = 1;
      FPS = 0;
      field639 = new long[32];
      field651 = new long[32];
      field647 = 500;
      focused = true;
      field671 = -1L;
      field672 = -1L;
   }

   protected GameEngine() {
      this.field644 = false;
      this.field654 = 0;
      this.field655 = 0;
      this.field653 = true;
      this.field664 = false;
      this.field665 = false;
      this.field666 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field669 = var1;
      class51 var2 = new class51();
      AbstractSoundSystem.field1540 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1314526651"
   )
   protected final void method793(int var1, int var2) {
      if(this.field658 != var1 || var2 != this.field659) {
         this.method900();
      }

      this.field658 = var1;
      this.field659 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "-1368623050"
   )
   final void method794(Object var1) {
      if(this.field669 != null) {
         for(int var2 = 0; var2 < 50 && this.field669.peekEvent() != null; ++var2) {
            GZipDecompressor.method3129(1L);
         }

         if(var1 != null) {
            this.field669.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Lft;",
      garbageValue = "1"
   )
   protected class157 method820() {
      if(this.field667 == null) {
         this.field667 = new class49();
         this.field667.method692(this.canvas);
      }

      return this.field667;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "105"
   )
   protected void method847() {
      this.field648 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "7"
   )
   protected void method812(String var1) {
      this.field648.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1930316560"
   )
   protected final void method797() {
      Frames.method2881();
      class47.method660(this.canvas);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "120"
   )
   protected final void method879() {
      class70.method1050(this.canvas);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-52"
   )
   final void method799() {
      Container var1 = this.container();
      if(var1 != null) {
         class287 var2 = this.method823();
         this.field652 = Math.max(var2.field3791, this.field656);
         this.field662 = Math.max(var2.field3789, this.field646);
         if(this.field652 <= 0) {
            this.field652 = 1;
         }

         if(this.field662 <= 0) {
            this.field662 = 1;
         }

         class66.canvasWidth = Math.min(this.field652, this.field658);
         Item.canvasHeight = Math.min(this.field662, this.field659);
         this.field654 = (this.field652 - class66.canvasWidth) / 2;
         this.field655 = 0;
         this.canvas.setSize(class66.canvasWidth, Item.canvasHeight);
         class236.field3227 = new MainBufferProvider(class66.canvasWidth, Item.canvasHeight, this.canvas);
         if(var1 == this.field660) {
            Insets var3 = this.field660.getInsets();
            this.canvas.setLocation(this.field654 + var3.left, this.field655 + var3.top);
         } else {
            this.canvas.setLocation(this.field654, this.field655);
         }

         this.field653 = true;
         this.vmethod1351();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "62842239"
   )
   protected abstract void vmethod1351();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-578214629"
   )
   void method889() {
      int var1 = this.field654;
      int var2 = this.field655;
      int var3 = this.field652 - class66.canvasWidth - var1;
      int var4 = this.field662 - Item.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field660) {
               Insets var8 = this.field660.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field662);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field652, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field652 - var3, var7, var3, this.field662);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field662 - var4, this.field652, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   final void method802() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field591 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(MouseInput.mouse);
      var2.removeMouseMotionListener(MouseInput.mouse);
      var2.removeFocusListener(MouseInput.mouse);
      MouseInput.field677 = 0;
      if(this.field667 != null) {
         this.field667.method697(this.canvas);
      }

      this.method804();
      class47.method660(this.canvas);
      class70.method1050(this.canvas);
      if(this.field667 != null) {
         this.field667.method692(this.canvas);
      }

      this.method900();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1907954951"
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
         class66.canvasWidth = var1;
         Item.canvasHeight = var2;
         class153.revision = var3;
         class153.field2120 = this;
         if(taskManager == null) {
            taskManager = new Signlink();
         }

         taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         class48.method690((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659245040"
   )
   final synchronized void method804() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class66.canvasWidth = Math.max(var1.getWidth(), this.field656);
      Item.canvasHeight = Math.max(var1.getHeight(), this.field646);
      Insets var2;
      if(this.field660 != null) {
         var2 = this.field660.getInsets();
         class66.canvasWidth -= var2.left + var2.right;
         Item.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class66.canvasWidth, Item.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field660) {
         var2 = this.field660.getInsets();
         this.canvas.setLocation(this.field654 + var2.left, var2.top + this.field655);
      } else {
         this.canvas.setLocation(this.field654, this.field655);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field653 = true;
      if(class236.field3227 != null && class66.canvasWidth == class236.field3227.width && Item.canvasHeight == class236.field3227.height) {
         ((MainBufferProvider)class236.field3227).method777(this.canvas);
         class236.field3227.vmethod5065(0, 0);
      } else {
         class236.field3227 = new MainBufferProvider(class66.canvasWidth, Item.canvasHeight, this.canvas);
      }

      this.field665 = false;
      this.field666 = ChatLineBuffer.currentTimeMs();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-870306748"
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-113022561"
   )
   void method806() {
      long var1 = ChatLineBuffer.currentTimeMs();
      long var3 = field651[Ignore.field788];
      field651[Ignore.field788] = var1;
      Ignore.field788 = Ignore.field788 + 1 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         KeyFocusListener.field608 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "29"
   )
   void method815() {
      Container var1 = this.container();
      long var2 = ChatLineBuffer.currentTimeMs();
      long var4 = field639[InvType.field3334];
      field639[InvType.field3334] = var2;
      InvType.field3334 = InvType.field3334 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field647 - 1 > 50) {
         field647 -= 50;
         this.field653 = true;
         this.canvas.setSize(class66.canvasWidth, Item.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field660) {
            Insets var7 = this.field660.getInsets();
            this.canvas.setLocation(var7.left + this.field654, var7.top + this.field655);
         } else {
            this.canvas.setLocation(this.field654, this.field655);
         }
      }

      if(this.field665) {
         this.method802();
      }

      this.method911();
      this.vmethod1109(this.field653);
      if(this.field653) {
         this.method889();
      }

      this.field653 = false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1187806746"
   )
   final void method911() {
      class287 var1 = this.method823();
      if(this.field652 != var1.field3791 || this.field662 != var1.field3789 || this.field664) {
         this.method799();
         this.field664 = false;
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   final void method900() {
      this.field664 = true;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   final synchronized void method877() {
      if(!field643) {
         field643 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1141();
         } catch (Exception var4) {
            ;
         }

         if(this.field660 != null) {
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

         this.vmethod1104();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "44"
   )
   protected abstract void vmethod1107();

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-3"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1081267098"
   )
   protected abstract void vmethod1109(boolean var1);

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   protected abstract void vmethod1141();

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "1552063024"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class286.field3787 == null) {
            class286.field3787 = new java.awt.Font("Helvetica", 1, 13);
            ItemContainer.field737 = this.canvas.getFontMetrics(class286.field3787);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class66.canvasWidth, Item.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(VarPlayerType.field3337 == null) {
               VarPlayerType.field3337 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = VarPlayerType.field3337.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class286.field3787);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - ItemContainer.field737.stringWidth(var2)) / 2, 22);
            var4.drawImage(VarPlayerType.field3337, class66.canvasWidth / 2 - 152, Item.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class66.canvasWidth / 2 - 152;
            int var8 = Item.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var7 + var1 * 3 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class286.field3787);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - ItemContainer.field737.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1679210514"
   )
   protected final void method796() {
      VarPlayerType.field3337 = null;
      class286.field3787 = null;
      ItemContainer.field737 = null;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1976215814"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field644) {
         this.field644 = true;
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
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-935021450"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field660 != null?this.field660:this);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Lkr;",
      garbageValue = "406247648"
   )
   class287 method823() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field656);
      int var3 = Math.max(var1.getHeight(), this.field646);
      if(this.field660 != null) {
         Insets var4 = this.field660.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.top + var4.bottom;
      }

      return new class287(var2, var3);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-51"
   )
   protected final boolean method824() {
      return this.field660 != null;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1146681035"
   )
   protected abstract void vmethod1104();

   public final void destroy() {
      if(this == shell && !field643) {
         field642 = ChatLineBuffer.currentTimeMs();
         GZipDecompressor.method3129(5000L);
         this.method877();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field643) {
         this.field653 = true;
         if(ChatLineBuffer.currentTimeMs() - this.field666 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class66.canvasWidth && var2.height >= Item.canvasHeight) {
               this.field665 = true;
            }
         }

      }
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field653 = true;
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

   public final void windowIconified(WindowEvent var1) {
   }

   public abstract void init();

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
                  for(var3 = 6; var3 < var2.length() && class276.method4884(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(Frames.method2880(var4)) {
                     int var5 = class61.parseInt(var4, 10, true);
                     if(var5 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field668 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method804();
         this.vmethod1107();

         Object var9;
         try {
            var9 = new NanoTimer();
         } catch (Throwable var7) {
            var9 = new MilliTimer();
         }

         timer = (Timer)var9;

         while(0L == field642 || ChatLineBuffer.currentTimeMs() < field642) {
            FileSystem.field3259 = timer.vmethod2993(field645, field668);

            for(int var6 = 0; var6 < FileSystem.field3259; ++var6) {
               this.method806();
            }

            this.method815();
            this.method794(this.canvas);
         }
      } catch (Exception var8) {
         class48.method690((String)null, var8);
         this.error("crash");
      }

      this.method877();
   }

   public final void start() {
      if(this == shell && !field643) {
         field642 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field643) {
         field642 = ChatLineBuffer.currentTimeMs() + 4000L;
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Ljb;",
      garbageValue = "2147229476"
   )
   public static class261 method935(int var0) {
      class261 var1 = (class261)class261.field3469.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class261.field3460.getConfigData(32, var0);
         var1 = new class261();
         if(var2 != null) {
            var1.method4510(new Buffer(var2));
         }

         class261.field3469.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1800978421"
   )
   static final boolean method809(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
         if(var1) {
            return true;
         } else {
            char[] var2 = class274.field3713;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            var2 = class274.field3716;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var0 == var4) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-95962005"
   )
   static void method925() {
      FileOnDisk var0 = null;

      try {
         var0 = GroundObject.getPreferencesFile("", FileSystem.field3262.field3256, true);
         Buffer var1 = class70.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2368(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-984721447"
   )
   public static int method853(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Ljh;IIIB)V",
      garbageValue = "-11"
   )
   static void method899(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1031 < 50 && Client.field1051 != 0) {
         if(var0.field3656 != null && var1 < var0.field3656.length) {
            int var4 = var0.field3656[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field956[Client.field1031] = var5;
               Client.field986[Client.field1031] = var6;
               Client.field1086[Client.field1031] = 0;
               Client.audioEffects[Client.field1031] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1092[Client.field1031] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1031;
            }
         }
      }
   }
}
