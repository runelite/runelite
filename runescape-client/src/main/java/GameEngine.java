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

@ObfuscatedName("bp")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = -7914829546918620097L
   )
   volatile long field709;
   @ObfuscatedName("a")
   static GameEngine field710;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -821574811
   )
   static int field711;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -5020876370700775497L
   )
   static long field712;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1147029519
   )
   int field713;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1635126053
   )
   static int field715;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 490222023
   )
   static int field716;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1322916475
   )
   @Export("FPS")
   protected static int FPS;
   @ObfuscatedName("c")
   static long[] field718;
   @ObfuscatedName("b")
   static long[] field719;
   @ObfuscatedName("i")
   public static Signlink field720;
   @ObfuscatedName("az")
   static volatile boolean field721;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -209340105
   )
   int field722;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 50895319
   )
   int field723;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 912896671
   )
   int field724;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -304810067
   )
   int field725;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1072865313
   )
   protected int field726;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2098646055
   )
   int field727;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -299402503
   )
   protected int field728;
   @ObfuscatedName("ar")
   @Export("canvas")
   Canvas canvas;
   @ObfuscatedName("ay")
   volatile boolean field730;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1828829889
   )
   static int field731;
   @ObfuscatedName("ak")
   boolean field732;
   @ObfuscatedName("aq")
   volatile boolean field733;
   @ObfuscatedName("au")
   java.awt.Frame field734;
   @ObfuscatedName("ac")
   protected static String field735;
   @ObfuscatedName("av")
   class49 field736;
   @ObfuscatedName("aa")
   Clipboard field737;
   @ObfuscatedName("am")
   final EventQueue field738;
   @ObfuscatedName("r")
   static boolean field739;
   @ObfuscatedName("v")
   boolean field740;

   public void run() {
      try {
         if(Signlink.field2253 != null) {
            String var1 = Signlink.field2253.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = Signlink.field2248;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method933("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class22.method159(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class51.method795(var4, 10, true);
                  if(var5 && ScriptState.method1103(var4) < 10) {
                     this.method933("wrongjava");
                     return;
                  }
               }

               field716 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method881();
         this.vmethod1186();

         Object var9;
         try {
            var9 = new class150();
         } catch (Throwable var7) {
            var9 = new class151();
         }

         class46.field625 = (class158)var9;

         while(field712 == 0L || class172.method3128() < field712) {
            class43.field596 = class46.field625.vmethod2964(field715, field716);

            for(int var6 = 0; var6 < class43.field596; ++var6) {
               this.method940();
            }

            this.method884();
            this.method870(this.canvas);
         }
      } catch (Exception var8) {
         class151.method2912((String)null, var8);
         this.method933("crash");
      }

      this.method887();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "255602513"
   )
   public final void method869(int var1, int var2) {
      if(this.field713 != var1 || var2 != this.field724) {
         this.method886();
      }

      this.field713 = var1;
      this.field724 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;B)V",
      garbageValue = "100"
   )
   final void method870(Object var1) {
      if(this.field738 != null) {
         for(int var2 = 0; var2 < 50 && this.field738.peekEvent() != null; ++var2) {
            XItemContainer.method1113(1L);
         }

         if(var1 != null) {
            this.field738.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-124"
   )
   protected final void method875() {
      Canvas var1 = this.canvas;
      var1.addMouseListener(class59.mouse);
      var1.addMouseMotionListener(class59.mouse);
      var1.addFocusListener(class59.mouse);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2085242238"
   )
   final void method876() {
      Container var1 = this.method900();
      if(var1 != null) {
         class278 var2 = this.method901();
         this.field728 = Math.max(var2.field3746, this.field727);
         this.field726 = Math.max(var2.field3744, this.field725);
         if(this.field728 <= 0) {
            this.field728 = 1;
         }

         if(this.field726 <= 0) {
            this.field726 = 1;
         }

         class45.canvasWidth = Math.min(this.field728, this.field713);
         CollisionData.canvasHeight = Math.min(this.field726, this.field724);
         this.field722 = (this.field728 - class45.canvasWidth) / 2;
         this.field723 = 0;
         this.canvas.setSize(class45.canvasWidth, CollisionData.canvasHeight);
         class43.field602 = new MainBufferProvider(class45.canvasWidth, CollisionData.canvasHeight, this.canvas);
         if(this.field734 == var1) {
            Insets var3 = this.field734.getInsets();
            this.canvas.setLocation(var3.left + this.field722, var3.top + this.field723);
         } else {
            this.canvas.setLocation(this.field722, this.field723);
         }

         this.field730 = true;
         this.vmethod1324();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "890021798"
   )
   protected abstract void vmethod1324();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1690381808"
   )
   void method878() {
      int var1 = this.field722;
      int var2 = this.field723;
      int var3 = this.field728 - class45.canvasWidth - var1;
      int var4 = this.field726 - CollisionData.canvasHeight - var2;
      if(var1 > 0 || var3 > 0 || var2 > 0 || var4 > 0) {
         try {
            Container var5 = this.method900();
            int var6 = 0;
            int var7 = 0;
            if(this.field734 == var5) {
               Insets var8 = this.field734.getInsets();
               var6 = var8.left;
               var7 = var8.top;
            }

            Graphics var10 = var5.getGraphics();
            var10.setColor(Color.black);
            if(var1 > 0) {
               var10.fillRect(var6, var7, var1, this.field726);
            }

            if(var2 > 0) {
               var10.fillRect(var6, var7, this.field728, var2);
            }

            if(var3 > 0) {
               var10.fillRect(this.field728 + var6 - var3, var7, var3, this.field726);
            }

            if(var4 > 0) {
               var10.fillRect(var6, this.field726 + var7 - var4, this.field728, var4);
            }
         } catch (Exception var9) {
            ;
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "934301566"
   )
   protected final void method880() {
      class91.field1448 = null;
      Item.field1507 = null;
      class215.field2642 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   final synchronized void method881() {
      Container var1 = this.method900();
      if(this.canvas != null) {
         this.canvas.removeFocusListener(this);
         var1.remove(this.canvas);
      }

      class45.canvasWidth = Math.max(var1.getWidth(), this.field727);
      CollisionData.canvasHeight = Math.max(var1.getHeight(), this.field725);
      Insets var2;
      if(this.field734 != null) {
         var2 = this.field734.getInsets();
         class45.canvasWidth -= var2.left + var2.right;
         CollisionData.canvasHeight -= var2.bottom + var2.top;
      }

      this.canvas = new RSCanvas(this);
      var1.add(this.canvas);
      this.canvas.setSize(class45.canvasWidth, CollisionData.canvasHeight);
      this.canvas.setVisible(true);
      this.canvas.setBackground(Color.BLACK);
      if(this.field734 == var1) {
         var2 = this.field734.getInsets();
         this.canvas.setLocation(var2.left + this.field722, var2.top + this.field723);
      } else {
         this.canvas.setLocation(this.field722, this.field723);
      }

      this.canvas.addFocusListener(this);
      this.canvas.requestFocus();
      this.field730 = true;
      if(class43.field602 != null && class45.canvasWidth == class43.field602.width && CollisionData.canvasHeight == class43.field602.height) {
         ((MainBufferProvider)class43.field602).method852(this.canvas);
         class43.field602.vmethod5007(0, 0);
      } else {
         class43.field602 = new MainBufferProvider(class45.canvasWidth, CollisionData.canvasHeight, this.canvas);
      }

      this.field733 = false;
      this.field709 = class172.method3128();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1622933852"
   )
   protected final boolean method882() {
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
                  this.method933("invalidhost");
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

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   void method884() {
      Container var1 = this.method900();
      long var2 = class172.method3128();
      long var4 = field718[class20.field338];
      field718[class20.field338] = var2;
      class20.field338 = class20.field338 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field731 - 1 > 50) {
         field731 -= 50;
         this.field730 = true;
         this.canvas.setSize(class45.canvasWidth, CollisionData.canvasHeight);
         this.canvas.setVisible(true);
         if(this.field734 == var1) {
            Insets var7 = this.field734.getInsets();
            this.canvas.setLocation(var7.left + this.field722, var7.top + this.field723);
         } else {
            this.canvas.setLocation(this.field722, this.field723);
         }
      }

      if(this.field733) {
         this.method950();
      }

      this.method885();
      this.vmethod1455(this.field730);
      if(this.field730) {
         this.method878();
      }

      this.field730 = false;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "93"
   )
   final void method885() {
      class278 var1 = this.method901();
      if(this.field728 != var1.field3746 || this.field726 != var1.field3744 || this.field732) {
         this.method876();
         this.field732 = false;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1724893476"
   )
   final void method886() {
      this.field732 = true;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-79"
   )
   final synchronized void method887() {
      if(!field739) {
         field739 = true;

         try {
            this.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod1189();
         } catch (Exception var4) {
            ;
         }

         if(this.field734 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(field720 != null) {
            try {
               field720.method2923();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod1184();
      }
   }

   public final void stop() {
      if(field710 == this && !field739) {
         field712 = class172.method3128() + 4000L;
      }
   }

   public final void destroy() {
      if(field710 == this && !field739) {
         field712 = class172.method3128();
         XItemContainer.method1113(5000L);
         this.method887();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(field710 == this && !field739) {
         this.field730 = true;
         if(class172.method3128() - this.field709 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class45.canvasWidth && var2.height >= CollisionData.canvasHeight) {
               this.field733 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field721 = true;
      this.field730 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field721 = false;
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "446180837"
   )
   protected abstract void vmethod1186();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1564860239"
   )
   protected final void method895(int var1, int var2, int var3) {
      try {
         if(field710 != null) {
            ++field711;
            if(field711 >= 3) {
               this.method933("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field710 = this;
         class45.canvasWidth = var1;
         CollisionData.canvasHeight = var2;
         class152.revision = var3;
         class152.field2238 = this;
         if(field720 == null) {
            field720 = new Signlink();
         }

         field720.method2927(this, 1);
      } catch (Exception var5) {
         class151.method2912((String)null, var5);
         this.method933("crash");
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   protected abstract void vmethod1455(boolean var1);

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797794752"
   )
   protected abstract void vmethod1189();

   public abstract void init();

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "1815898623"
   )
   Container method900() {
      return (Container)(this.field734 != null?this.field734:this);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)Lclass278;",
      garbageValue = "31"
   )
   class278 method901() {
      Container var1 = this.method900();
      int var2 = Math.max(var1.getWidth(), this.field727);
      int var3 = Math.max(var1.getHeight(), this.field725);
      if(this.field734 != null) {
         Insets var4 = this.field734.getInsets();
         var2 -= var4.left + var4.right;
         var3 -= var4.bottom + var4.top;
      }

      return new class278(var2, var3);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1781341341"
   )
   protected abstract void vmethod1184();

   static {
      field710 = null;
      field711 = 0;
      field712 = 0L;
      field739 = false;
      field715 = 20;
      field716 = 1;
      FPS = 0;
      field718 = new long[32];
      field719 = new long[32];
      field731 = 500;
      field721 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1612241700"
   )
   protected void method909() {
      this.field737 = this.getToolkit().getSystemClipboard();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lclass156;",
      garbageValue = "0"
   )
   protected class156 method913() {
      if(this.field736 == null) {
         this.field736 = new class49();
         this.field736.method757(this.canvas);
      }

      return this.field736;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1240862834"
   )
   protected final void method919() {
      if(Signlink.field2253.toLowerCase().indexOf("microsoft") != -1) {
         class50.field676[186] = 57;
         class50.field676[187] = 27;
         class50.field676[188] = 71;
         class50.field676[189] = 26;
         class50.field676[190] = 72;
         class50.field676[191] = 73;
         class50.field676[192] = 58;
         class50.field676[219] = 42;
         class50.field676[220] = 74;
         class50.field676[221] = 43;
         class50.field676[222] = 59;
         class50.field676[223] = 28;
      } else {
         class50.field676[44] = 71;
         class50.field676[45] = 26;
         class50.field676[46] = 72;
         class50.field676[47] = 73;
         class50.field676[59] = 57;
         class50.field676[61] = 27;
         class50.field676[91] = 42;
         class50.field676[92] = 74;
         class50.field676[93] = 43;
         class50.field676[192] = 28;
         class50.field676[222] = 58;
         class50.field676[520] = 59;
      }

      Canvas var1 = this.canvas;
      var1.setFocusTraversalKeysEnabled(false);
      var1.addKeyListener(class50.keyboard);
      var1.addFocusListener(class50.keyboard);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-751553860"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "459635123"
   )
   protected void method933(String var1) {
      if(!this.field740) {
         this.field740 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1401465703"
   )
   void method940() {
      long var1 = class172.method3128();
      long var3 = field719[class15.field294];
      field719[class15.field294] = var1;
      class15.field294 = class15.field294 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class21.field342 = field721;
      }

      this.packetHandler();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   final void method950() {
      Canvas var1 = this.canvas;
      var1.removeKeyListener(class50.keyboard);
      var1.removeFocusListener(class50.keyboard);
      class50.field667 = -1;
      Canvas var2 = this.canvas;
      var2.removeMouseListener(class59.mouse);
      var2.removeMouseMotionListener(class59.mouse);
      var2.removeFocusListener(class59.mouse);
      class59.field744 = 0;
      if(this.field736 != null) {
         this.field736.method758(this.canvas);
      }

      this.method881();
      Canvas var3 = this.canvas;
      var3.setFocusTraversalKeysEnabled(false);
      var3.addKeyListener(class50.keyboard);
      var3.addFocusListener(class50.keyboard);
      Canvas var4 = this.canvas;
      var4.addMouseListener(class59.mouse);
      var4.addMouseMotionListener(class59.mouse);
      var4.addFocusListener(class59.mouse);
      if(this.field736 != null) {
         this.field736.method757(this.canvas);
      }

      this.method886();
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;ZI)V",
      garbageValue = "-821348099"
   )
   @Export("drawLoadingScreen")
   protected final void drawLoadingScreen(int var1, String var2, boolean var3) {
      try {
         Graphics var4 = this.canvas.getGraphics();
         if(Item.field1507 == null) {
            Item.field1507 = new java.awt.Font("Helvetica", 1, 13);
            class215.field2642 = this.canvas.getFontMetrics(Item.field1507);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class45.canvasWidth, CollisionData.canvasHeight);
         }

         Color var5 = new Color(140, 17, 17);

         try {
            if(class91.field1448 == null) {
               class91.field1448 = this.canvas.createImage(304, 34);
            }

            Graphics var6 = class91.field1448.getGraphics();
            var6.setColor(var5);
            var6.drawRect(0, 0, 303, 33);
            var6.fillRect(2, 2, var1 * 3, 30);
            var6.setColor(Color.black);
            var6.drawRect(1, 1, 301, 31);
            var6.fillRect(var1 * 3 + 2, 2, 300 - var1 * 3, 30);
            var6.setFont(Item.field1507);
            var6.setColor(Color.white);
            var6.drawString(var2, (304 - class215.field2642.stringWidth(var2)) / 2, 22);
            var4.drawImage(class91.field1448, class45.canvasWidth / 2 - 152, CollisionData.canvasHeight / 2 - 18, (ImageObserver)null);
         } catch (Exception var9) {
            int var7 = class45.canvasWidth / 2 - 152;
            int var8 = CollisionData.canvasHeight / 2 - 18;
            var4.setColor(var5);
            var4.drawRect(var7, var8, 303, 33);
            var4.fillRect(var7 + 2, var8 + 2, var1 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var7 + 1, var8 + 1, 301, 31);
            var4.fillRect(var1 * 3 + var7 + 2, var8 + 2, 300 - var1 * 3, 30);
            var4.setFont(Item.field1507);
            var4.setColor(Color.white);
            var4.drawString(var2, var7 + (304 - class215.field2642.stringWidth(var2)) / 2, var8 + 22);
         }
      } catch (Exception var10) {
         this.canvas.repaint();
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1888858416"
   )
   protected final boolean method967() {
      return this.field734 != null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "4"
   )
   protected void method972(String var1) {
      this.field737.setContents(new StringSelection(var1), (ClipboardOwner)null);
   }

   protected GameEngine() {
      this.field740 = false;
      this.field722 = 0;
      this.field723 = 0;
      this.field730 = true;
      this.field732 = false;
      this.field733 = false;
      this.field709 = 0L;
      EventQueue var1 = null;

      try {
         var1 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var3) {
         ;
      }

      this.field738 = var1;
      class51 var2 = new class51();
      class109.field1660 = var2;
   }

   public final void start() {
      if(field710 == this && !field739) {
         field712 = 0L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }
}
