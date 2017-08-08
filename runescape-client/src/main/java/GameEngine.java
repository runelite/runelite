import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FontMetrics;
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

@ObfuscatedName("bp")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("as")
   @Export("focused")
   static volatile boolean focused;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lbp;"
   )
   @Export("shell")
   static GameEngine shell;
   @ObfuscatedName("v")
   static boolean field699;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -131803323
   )
   @Export("shellCount")
   static int shellCount;
   @ObfuscatedName("ao")
   static FontMetrics field690;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 3613364392240978055L
   )
   static long field685;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1839310257
   )
   static int field676;
   @ObfuscatedName("m")
   protected static long[] field708;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1285634807
   )
   static int field695;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 360123707
   )
   static int field681;
   @ObfuscatedName("s")
   protected static long[] field679;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1009919321
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -436734383
   )
   static int field694;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -7832579130014228281L
   )
   protected static long field702;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 4363310108160574925L
   )
   protected static long field703;
   @ObfuscatedName("fs")
   static byte[][] field709;
   @ObfuscatedName("fp")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 1443390805
   )
   static int field672;
   @ObfuscatedName("am")
   Clipboard field683;
   @ObfuscatedName("aq")
   final EventQueue field700;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   class49 field671;
   @ObfuscatedName("av")
   boolean field698;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1763577703
   )
   int field684;
   @ObfuscatedName("z")
   boolean field675;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1007462709
   )
   int field686;
   @ObfuscatedName("al")
   java.awt.Frame field691;
   @ObfuscatedName("ae")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 606692523
   )
   int field680;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1636696801
   )
   protected int field682;
   @ObfuscatedName("ax")
   volatile boolean field693;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1449226537
   )
   int field689;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -188578675
   )
   int field673;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1936648951
   )
   protected int field704;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2062564639
   )
   int field674;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = 2800995672739218843L
   )
   volatile long field697;
   @ObfuscatedName("ac")
   volatile boolean field696;

   static {
      shell = null;
      shellCount = 0;
      field685 = 0L;
      field699 = false;
      field676 = 20;
      field695 = 1;
      FPS = 0;
      field679 = new long[32];
      field708 = new long[32];
      field694 = 500;
      focused = true;
      field702 = -1L;
      field703 = -1L;
   }

   protected GameEngine() {
      this.field675 = false;
      this.field684 = 0;
      this.field680 = 0;
      this.field693 = true;
      this.field698 = false;
      this.field696 = false;
      this.field697 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field700 = var1;
      class51 var2 = new class51();
      FrameMap.field2044 = var2;
   }

   public final void destroy() {
      if(this == shell && !field699) {
         field685 = class170.currentTimeMs();
         class41.method585(5000L);
         this.method905();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(this == shell && !field699) {
         this.field693 = true;
         if(class170.currentTimeMs() - this.field697 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= NPC.canvasWidth && var2.height >= InvType.canvasHeight) {
               this.field696 = true;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1941405283"
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-1288381978"
   )
   class279 method937() {
      Container var1 = this.container();
      int var2 = Math.max(var1.getWidth(), this.field673);
      int var3 = Math.max(var1.getHeight(), this.field674);
      if(this.field691 != null) {
         Insets var4 = this.field691.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new class279(var2, var3);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Container;",
      garbageValue = "127"
   )
   @Export("container")
   Container container() {
      return (Container)(this.field691 != null?this.field691:this);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "18"
   )
   @Export("error")
   protected void error(String var1) {
      if(!this.field675) {
         this.field675 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "911150887"
   )
   final void method856() {
      this.field698 = true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "512835385"
   )
   final synchronized void method850() {
      Container var1 = this.container();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      NPC.canvasWidth = Math.max(var1.getWidth(), this.field673);
      InvType.canvasHeight = Math.max(var1.getHeight(), this.field674);
      Insets var2;
      if(this.field691 != null) {
         var2 = this.field691.getInsets();
         NPC.canvasWidth -= var2.right + var2.left;
         InvType.canvasHeight -= var2.top + var2.bottom;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(NPC.canvasWidth, InvType.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(var1 == this.field691) {
         var2 = this.field691.getInsets();
         this.canvas.setLocation(this.field684 + var2.left, var2.top + this.field680);
      } else {
         this.canvas.setLocation(this.field684, this.field680);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field693 = true;
      if(class19.field322 != null && NPC.canvasWidth == class19.field322.width && InvType.canvasHeight == class19.field322.height) {
         ((MainBufferProvider)class19.field322).method819(this.canvas);
         class19.field322.vmethod5051(0, 0);
      } else {
         class19.field322 = new MainBufferProvider(NPC.canvasWidth, InvType.canvasHeight, this.canvas);
      }

      this.field696 = false;
      this.field697 = class170.currentTimeMs();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1232631027"
   )
   protected abstract void vmethod1184();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "718340220"
   )
   final void method845() {
      Container var1 = this.container();
      if(var1 != null) {
         class279 var2 = this.method937();
         this.field682 = Math.max(var2.field3724, this.field673);
         this.field704 = Math.max(var2.field3725, this.field674);
         if(this.field682 <= 0) {
            this.field682 = 1;
         }

         if(this.field704 <= 0) {
            this.field704 = 1;
         }

         NPC.canvasWidth = Math.min(this.field682, this.field686);
         InvType.canvasHeight = Math.min(this.field704, this.field689);
         this.field684 = (this.field682 - NPC.canvasWidth) / 2;
         this.field680 = 0;
         this.canvas.setSize(NPC.canvasWidth, InvType.canvasHeight);
         class19.field322 = new MainBufferProvider(NPC.canvasWidth, InvType.canvasHeight, this.canvas);
         if(var1 == this.field691) {
            Insets var3 = this.field691.getInsets();
            this.canvas.setLocation(var3.left + this.field684, var3.top + this.field680);
         } else {
            this.canvas.setLocation(this.field684, this.field680);
         }

         this.field693 = true;
         this.vmethod1432();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1931230529"
   )
   protected abstract void vmethod1181();

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1646188162"
   )
   final synchronized void method905() {
      if(!field699) {
         field699 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1184();
         } catch (Exception var4) {
            ;
         }

         if(this.field691 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class15.taskManager != null) {
            try {
               class15.taskManager.join();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1178();
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected final void method867() {
      MessageNode.field868 = null;
      class61.field745 = null;
      field690 = null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2048513642"
   )
   protected abstract void vmethod1178();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1499260405"
   )
   protected final void method943() {
      class91.method1739();
      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(KeyFocusListener.keyboard);
      var1.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "16"
   )
   protected final void method841() {
      Occluder.method2932(this.canvas);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2073888540"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lfw;",
      garbageValue = "1453850609"
   )
   protected class157 method840() {
      if(this.field671 == null) {
         this.field671 = new class49();
         this.field671.method731(this.canvas);
      }

      return this.field671;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "24798517"
   )
   void method854() {
      Container var1 = this.container();
      long var2 = class170.currentTimeMs();
      long var4 = field679[class271.field3666];
      field679[class271.field3666] = var2;
      class271.field3666 = class271.field3666 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field694 - 1 > 50) {
         field694 -= 50;
         this.field693 = true;
         this.canvas.setSize(NPC.canvasWidth, InvType.canvasHeight);
         this.canvas.setVisible(true);
         if(var1 == this.field691) {
            Insets var7 = this.field691.getInsets();
            this.canvas.setLocation(var7.left + this.field684, this.field680 + var7.top);
         } else {
            this.canvas.setLocation(this.field684, this.field680);
         }
      }

      if(this.field696) {
         this.method848();
      }

      this.method855();
      this.vmethod1183(this.field693);
      if(this.field693) {
         this.method891();
      }

      this.field693 = false;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   void method899() {
      long var1 = class170.currentTimeMs();
      long var3 = field708[field681];
      field708[field681] = var1;
      field681 = field681 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class7.field226 = focused;
      }

      this.packetHandler();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZB)V",
      garbageValue = "7"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(class61.field745 == null) {
            class61.field745 = new java.awt.Font("Helvetica", 1, 13);
            field690 = this.canvas.getFontMetrics(class61.field745);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, NPC.canvasWidth, InvType.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(MessageNode.field868 == null) {
               MessageNode.field868 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = MessageNode.field868.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(class61.field745);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - field690.stringWidth(var2)) / 2, 22);
            var4.drawImage(MessageNode.field868, NPC.canvasWidth / 2 - 152, InvType.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = NPC.canvasWidth / 2 - 152;
            int var8 = InvType.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(class61.field745);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - field690.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;I)V",
      garbageValue = "314966236"
   )
   final void method839(Object var1) {
      if(this.field700 != null) {
         for(int var2 = 0; var2 < 50 && this.field700.peekEvent() != null; ++var2) {
            class41.method585(1L);
         }

         if(var1 != null) {
            this.field700.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   protected void method954() {
      this.field683 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-33090392"
   )
   public final void method838(int var1, int var2) {
      if(this.field686 != var1 || var2 != this.field689) {
         this.method856();
      }

      this.field686 = var1;
      this.field689 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1588282718"
   )
   protected abstract void vmethod1432();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-782662593"
   )
   final void method848() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(KeyFocusListener.keyboard);
      var1.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field634 = -1;
      class237.method4205(this.canvas);
      if(this.field671 != null) {
         this.field671.method732(this.canvas);
      }

      this.method850();
      Canvas var2 = this.canvas;
      var2.setFocusTraversalKeysEnabled(false);
      var2.addKeyListener(KeyFocusListener.keyboard);
      var2.addFocusListener(KeyFocusListener.keyboard);
      Occluder.method2932(this.canvas);
      if(this.field671 != null) {
         this.field671.method731(this.canvas);
      }

      this.method856();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "733820969"
   )
   final void method855() {
      class279 var1 = this.method937();
      if(var1.field3724 != this.field682 || this.field704 != var1.field3725 || this.field698) {
         this.method845();
         this.field698 = false;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2104820235"
   )
   protected abstract void vmethod1183(boolean var1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   void method891() {
      int var1 = this.field684;
      int var2 = this.field680;
      int var3 = this.field682 - NPC.canvasWidth - var1;
      int var4 = this.field704 - InvType.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.container();
            int var6 = 0;
            int var7 = 0;
            if(var5 == this.field691) {
               Insets var8 = this.field691.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field704);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field682, var2);
            }

            if(var3 > 0) {
               var10.fillRect(var6 + this.field682 - var3, var7, var3, this.field704);
            }

            if(var4 > 0) {
               var10.fillRect(var6, var7 + this.field704 - var4, this.field682, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-58190208"
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
         NPC.canvasWidth = var1;
         InvType.canvasHeight = var2;
         class153.revision = var3;
         class153.field2201 = this;
         if(class15.taskManager == null) {
            class15.taskManager = new Signlink();
         }

         class15.taskManager.createRunnable(this, 1);
      } catch (Exception var5) {
         NPC.method1722((String)null, var5);
         this.error("crash");
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "459005754"
   )
   protected final boolean method871() {
      return this.field691 != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1836514651"
   )
   protected void method858(String var1) {
      this.field683.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   public final void start() {
      if(this == shell && !field699) {
         field685 = 0L;
      }
   }

   public final void stop() {
      if(this == shell && !field699) {
         field685 = class170.currentTimeMs() + 4000L;
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void focusGained(FocusEvent var1) {
      focused = true;
      this.field693 = true;
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

   public void run() {
      try {
         if(Signlink.javaVendor != null) {
            String var1 = Signlink.javaVendor.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class276.javaVersion;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.error("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= 48 && var5 <= 57;
                     if(!var4) {
                        break;
                     }
                  }

                  String var6 = var2.substring(6, var3);
                  if(class252.method4461(var6)) {
                     int var9 = class245.parseInt(var6, 10, true);
                     if(var9 < 10) {
                        this.error("wrongjava");
                        return;
                     }
                  }
               }

               field695 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method850();
         this.vmethod1181();
         class233.timer = GraphicsObject.method1693();

         while(field685 == 0L || class170.currentTimeMs() < field685) {
            class211.field2580 = class233.timer.vmethod3018(field676, field695);

            for(int var7 = 0; var7 < class211.field2580; ++var7) {
               this.method899();
            }

            this.method854();
            this.method839(this.canvas);
         }
      } catch (Exception var8) {
         NPC.method1722((String)null, var8);
         this.error("crash");
      }

      this.method905();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "-575128025"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3322.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILfg;Lfo;B)Z",
      garbageValue = "-47"
   )
   public static final boolean method983(int var0, int var1, class164 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class163.field2285[var6][var7] = 99;
      class163.field2289[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class163.field2283[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class163.field2284[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class163.field2283[var11];
         var5 = class163.field2284[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3095(1, var4, var5, var3)) {
            class163.field2287 = var4;
            class72.field858 = var5;
            return true;
         }

         int var15 = class163.field2289[var16][var17] + 1;
         if(var16 > 0 && class163.field2285[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class163.field2283[var18] = var4 - 1;
            class163.field2284[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 - 1][var17] = 2;
            class163.field2289[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class163.field2285[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class163.field2283[var18] = var4 + 1;
            class163.field2284[var18] = var5;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 + 1][var17] = 8;
            class163.field2289[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class163.field2285[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2283[var18] = var4;
            class163.field2284[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16][var17 - 1] = 1;
            class163.field2289[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && 0 == class163.field2285[var16][var17 + 1] && (var12[var13][var14 + 1] & 19136800) == 0) {
            class163.field2283[var18] = var4;
            class163.field2284[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16][var17 + 1] = 4;
            class163.field2289[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class163.field2285[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2283[var18] = var4 - 1;
            class163.field2284[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 - 1][var17 - 1] = 3;
            class163.field2289[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && 0 == class163.field2285[var16 + 1][var17 - 1] && (var12[var13 + 1][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class163.field2283[var18] = var4 + 1;
            class163.field2284[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 + 1][var17 - 1] = 9;
            class163.field2289[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && 0 == class163.field2285[var16 - 1][var17 + 1] && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class163.field2283[var18] = var4 - 1;
            class163.field2284[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 - 1][var17 + 1] = 6;
            class163.field2289[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class163.field2285[var16 + 1][var17 + 1] == 0 && 0 == (var12[var13 + 1][var14 + 1] & 19136992) && 0 == (var12[var13 + 1][var14] & 19136896) && 0 == (var12[var13][var14 + 1] & 19136800)) {
            class163.field2283[var18] = var4 + 1;
            class163.field2284[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class163.field2285[var16 + 1][var17 + 1] = 12;
            class163.field2289[var16 + 1][var17 + 1] = var15;
         }
      }

      class163.field2287 = var4;
      class72.field858 = var5;
      return false;
   }
}
