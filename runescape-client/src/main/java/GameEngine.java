import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qs")
   protected static long[] field1755 = new long[32];
   @ObfuscatedName("pf")
   @ObfuscatedGetter(
      intValue = 56455379
   )
   static int field1756 = 0;
   @ObfuscatedName("pu")
   static GameEngine field1757 = null;
   @ObfuscatedName("qv")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("pq")
   boolean field1759;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = 1240566879
   )
   static int field1760 = 20;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 31946187
   )
   static int field1761 = 1;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      longValue = -1497060114115567215L
   )
   static volatile long field1762 = 0L;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 1907070649
   )
   @Export("FPS")
   protected static int field1763 = 0;
   @ObfuscatedName("pp")
   static boolean field1764 = false;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -250565317
   )
   protected static int field1765 = 0;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 1183789379
   )
   protected static int field1766 = 0;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = 6742997064584860177L
   )
   static long field1767 = 0L;
   @ObfuscatedName("qq")
   public static volatile boolean field1768 = true;
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = -1264219335
   )
   static int field1769 = 500;
   @ObfuscatedName("qn")
   protected static boolean field1770 = false;
   @ObfuscatedName("qd")
   protected static volatile boolean field1771 = false;
   @ObfuscatedName("qh")
   protected static long[] field1772 = new long[32];
   @ObfuscatedName("rq")
   static volatile boolean field1773 = true;

   @ObfuscatedName("rj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-116"
   )
   protected final synchronized void method2058() {
      Container var1 = this.method2074();
      if(null != class165.canvas) {
         class165.canvas.removeFocusListener(this);
         var1.remove(class165.canvas);
      }

      class0.field1 = Math.max(var1.getWidth(), class138.field1905);
      class65.field1099 = Math.max(var1.getHeight(), class110.field1740);
      Insets var2;
      if(null != GameObject.field1615) {
         var2 = GameObject.field1615.getInsets();
         class0.field1 -= var2.left + var2.right;
         class65.field1099 -= var2.top + var2.bottom;
      }

      class165.canvas = new RSCanvas(this);
      var1.add(class165.canvas);
      class165.canvas.setSize(class0.field1, class65.field1099);
      class165.canvas.setVisible(true);
      if(var1 == GameObject.field1615) {
         var2 = GameObject.field1615.getInsets();
         class165.canvas.setLocation(field1765 + var2.left, field1766 + var2.top);
      } else {
         class165.canvas.setLocation(field1765, field1766);
      }

      class165.canvas.addFocusListener(this);
      class165.canvas.requestFocus();
      field1768 = true;
      int var3 = class0.field1;
      int var4 = class65.field1099;
      Canvas var5 = class165.canvas;

      Object var6;
      try {
         MainBufferProvider var7 = new MainBufferProvider();
         var7.init(var3, var4, var5);
         var6 = var7;
      } catch (Throwable var9) {
         SecondaryBufferProvider var8 = new SecondaryBufferProvider();
         var8.init(var3, var4, var5);
         var6 = var8;
      }

      if(null != bufferProvider) {
         bufferProvider.draw(((BufferProvider)var6).image.getGraphics(), 0, 0);
      }

      bufferProvider = (BufferProvider)var6;
      field1771 = false;
      field1762 = class9.method117();
   }

   public void run() {
      try {
         if(class103.field1661 != null) {
            String var1 = class103.field1661.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class103.field1655;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method2073("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class186.method3412(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = MessageNode.method202(var4, 10, true);
                  if(var5 && class16.method183(var4) < 10) {
                     this.method2073("wrongjava");
                     return;
                  }
               }

               field1761 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method2058();
         this.vmethod2086();

         Object var8;
         try {
            var8 = new class98();
         } catch (Throwable var6) {
            var8 = new class99();
         }

         class8.field79 = (class109)var8;

         label85:
         while(true) {
            Canvas var9;
            class103 var10;
            int var11;
            do {
               if(0L != field1767 && class9.method117() >= field1767) {
                  break label85;
               }

               CombatInfoListHolder.field753 = class8.field79.vmethod2004(field1760, field1761);

               for(var11 = 0; var11 < CombatInfoListHolder.field753; ++var11) {
                  this.method2060();
               }

               this.method2061();
               var10 = class44.field881;
               var9 = class165.canvas;
            } while(null == var10.field1659);

            for(var11 = 0; var11 < 50 && var10.field1659.peekEvent() != null; ++var11) {
               VertexNormal.method1598(1L);
            }

            if(var9 != null) {
               var10.field1659.postEvent(new ActionEvent(var9, 1001, "dummy"));
            }
         }
      } catch (Exception var7) {
         class174.method3240((String)null, var7);
         this.method2073("crash");
      }

      this.method2062();
   }

   @ObfuscatedName("sz")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14152"
   )
   void method2060() {
      long var1 = class9.method117();
      long var3 = field1755[class13.field143];
      field1755[class13.field143] = var1;
      class13.field143 = 1 + class13.field143 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class20.field219 = field1773;
      }

      this.packetHandler();
   }

   @ObfuscatedName("sc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method2061() {
      Container var1 = this.method2074();
      long var2 = class9.method117();
      long var4 = field1772[class167.field2167];
      field1772[class167.field2167] = var2;
      class167.field2167 = class167.field2167 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field1763 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field1769 - 1 > 50) {
         field1769 -= 50;
         field1768 = true;
         class165.canvas.setSize(class0.field1, class65.field1099);
         class165.canvas.setVisible(true);
         if(var1 == GameObject.field1615) {
            Insets var7 = GameObject.field1615.getInsets();
            class165.canvas.setLocation(field1765 + var7.left, var7.top + field1766);
         } else {
            class165.canvas.setLocation(field1765, field1766);
         }
      }

      this.vmethod2066();
   }

   @ObfuscatedName("sr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   final synchronized void method2062() {
      if(!field1764) {
         field1764 = true;

         try {
            class165.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod2157();
         } catch (Exception var4) {
            ;
         }

         if(null != GameObject.field1615) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != class44.field881) {
            try {
               class44.field881.method1913();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod2076();
      }

   }

   public void start() {
      if(this == field1757 && !field1764) {
         field1767 = 0L;
      }

   }

   public void destroy() {
      if(field1757 == this && !field1764) {
         field1767 = class9.method117();
         VertexNormal.method1598(5000L);
         this.method2062();
      }

   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field1757 && !field1764) {
         field1768 = true;
         if(null != class103.field1655 && class103.field1655.startsWith("1.5") && class9.method117() - field1762 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class0.field1 && var2.height >= class65.field1099) {
               field1771 = true;
            }
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
      field1773 = true;
      field1768 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "329861939"
   )
   protected abstract void vmethod2066();

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public abstract void init();

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("sg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1232224253"
   )
   protected void method2073(String var1) {
      if(!this.field1759) {
         this.field1759 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("sm")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-376033967"
   )
   protected Container method2074() {
      return (Container)(null != GameObject.field1615?GameObject.field1615:this);
   }

   @ObfuscatedName("sp")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1815654329"
   )
   protected Dimension method2075() {
      Container var1 = this.method2074();
      int var2 = Math.max(var1.getWidth(), class138.field1905);
      int var3 = Math.max(var1.getHeight(), class110.field1740);
      if(null != GameObject.field1615) {
         Insets var4 = GameObject.field1615.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1839628547"
   )
   protected abstract void vmethod2076();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   protected abstract void vmethod2086();

   @ObfuscatedName("ru")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-1"
   )
   protected final void method2087(int var1, int var2, int var3) {
      try {
         if(null != field1757) {
            ++field1756;
            if(field1756 >= 3) {
               this.method2073("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field1757 = this;
         class0.field1 = var1;
         class65.field1099 = var2;
         class88.field1530 = var3;
         class101.field1639 = this;
         if(null == class44.field881) {
            class44.field881 = new class103();
         }

         class44.field881.method1916(this, 1);
      } catch (Exception var5) {
         class174.method3240((String)null, var5);
         this.method2073("crash");
      }

   }

   @ObfuscatedName("se")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "127"
   )
   protected final boolean method2091() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if(var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if(var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method2073("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2124210957"
   )
   static final boolean method2120(int var0, int var1) {
      ObjectComposition var2 = Tile.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3596(var1);
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public void stop() {
      if(this == field1757 && !field1764) {
         field1767 = class9.method117() + 4000L;
      }

   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void focusLost(FocusEvent var1) {
      field1773 = false;
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   protected abstract void packetHandler();

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   protected abstract void vmethod2157();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1195555928"
   )
   public static int method2160(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }
}
