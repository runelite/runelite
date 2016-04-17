import java.applet.Applet;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
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

@ObfuscatedName("et")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1572198301
   )
   @Export("FPS")
   protected static int field2185 = 0;
   @ObfuscatedName("ru")
   static volatile boolean field2186 = true;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = 8534675747906742033L
   )
   static long field2187 = 0L;
   @ObfuscatedName("pi")
   static class144 field2188 = null;
   @ObfuscatedName("ry")
   @ObfuscatedGetter(
      longValue = -898507085196287233L
   )
   static volatile long field2189 = 0L;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -80192263
   )
   static int field2190 = 20;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 1123475695
   )
   protected static int field2191 = 0;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 666650335
   )
   protected static int field2192 = 0;
   @ObfuscatedName("po")
   boolean field2193;
   @ObfuscatedName("qp")
   protected static long[] field2194 = new long[32];
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 490189751
   )
   static int field2195 = 1;
   @ObfuscatedName("qt")
   protected static long[] field2196 = new long[32];
   @ObfuscatedName("qi")
   public static volatile boolean field2197 = true;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = -1154129441
   )
   static int field2198 = 500;
   @ObfuscatedName("qw")
   protected static boolean field2199 = false;
   @ObfuscatedName("qe")
   protected static volatile boolean field2200 = false;
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 139851433
   )
   static int field2201 = 0;
   @ObfuscatedName("pr")
   static boolean field2203 = false;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 555662919
   )
   @Export("baseX")
   static int field2204;

   @ObfuscatedName("th")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-815198596"
   )
   protected final boolean method3116() {
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
                     this.method3127("invalidhost");
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

   public void run() {
      try {
         if(class136.field2096 != null) {
            String var1 = class136.field2096.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2092;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3127("wrongjava");
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

                  String var11 = var2.substring(6, var3);
                  boolean var12 = class160.method3282(var11, 10, true);
                  if(var12) {
                     int var6 = class158.method3265(var11, 10, true);
                     if(var6 < 10) {
                        this.method3127("wrongjava");
                        return;
                     }
                  }
               }

               field2195 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3120();
         this.vmethod3123();

         Object var9;
         try {
            var9 = new class147();
         } catch (Throwable var7) {
            var9 = new class141();
         }

         class48.field1091 = (class133)var9;

         while(field2187 == 0L || class127.method2941() < field2187) {
            class49.field1097 = class48.field1091.vmethod3217(field2190, field2195);

            for(int var10 = 0; var10 < class49.field1097; ++var10) {
               this.method3117();
            }

            this.method3178();
            class121.method2860(class107.field1874, class158.field2585);
         }
      } catch (Exception var8) {
         class22.method655((String)null, var8);
         this.method3127("crash");
      }

      this.method3119();
   }

   @ObfuscatedName("tk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1987280514"
   )
   void method3117() {
      long var1 = class127.method2941();
      long var3 = field2194[class99.field1680];
      field2194[class99.field1680] = var1;
      class99.field1680 = class99.field1680 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class121.field2010 = field2186;
      }

      this.vmethod3186();
   }

   @ObfuscatedName("to")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-97"
   )
   final synchronized void method3119() {
      if(!field2203) {
         field2203 = true;

         try {
            class158.field2585.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3126();
         } catch (Exception var4) {
            ;
         }

         if(null != class32.field760) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class107.field1874 != null) {
            try {
               class107.field1874.method3007();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3121();
      }
   }

   public void start() {
      if(this == field2188 && !field2203) {
         field2187 = 0L;
      }
   }

   public void stop() {
      if(this == field2188 && !field2203) {
         field2187 = class127.method2941() + 4000L;
      }
   }

   public void destroy() {
      if(this == field2188 && !field2203) {
         field2187 = class127.method2941();
         class4.method55(5000L);
         this.method3119();
      }
   }

   @ObfuscatedName("sz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-734427952"
   )
   protected final synchronized void method3120() {
      Container var1 = this.method3128();
      if(null != class158.field2585) {
         class158.field2585.removeFocusListener(this);
         var1.remove(class158.field2585);
      }

      class37.field876 = Math.max(var1.getWidth(), class191.field3076);
      class98.field1671 = Math.max(var1.getHeight(), class30.field719);
      Insets var2;
      if(class32.field760 != null) {
         var2 = class32.field760.getInsets();
         class37.field876 -= var2.right + var2.left;
         class98.field1671 -= var2.top + var2.bottom;
      }

      class158.field2585 = new class139(this);
      var1.add(class158.field2585);
      class158.field2585.setSize(class37.field876, class98.field1671);
      class158.field2585.setVisible(true);
      if(class32.field760 == var1) {
         var2 = class32.field760.getInsets();
         class158.field2585.setLocation(var2.left + field2192, field2191 + var2.top);
      } else {
         class158.field2585.setLocation(field2192, field2191);
      }

      class158.field2585.addFocusListener(this);
      class158.field2585.requestFocus();
      field2197 = true;
      class77 var3 = class49.method1098(class37.field876, class98.field1671, class158.field2585);
      if(class28.field695 != null) {
         class28.field695.vmethod1970(var3.field1396.getGraphics(), 0, 0);
      }

      class28.field695 = var3;
      field2200 = false;
      field2189 = class127.method2941();
   }

   public final synchronized void paint(Graphics var1) {
      if(field2188 == this && !field2203) {
         field2197 = true;
         if(null != class136.field2092 && class136.field2092.startsWith("1.5") && class127.method2941() - field2189 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class37.field876 && var2.height >= class98.field1671) {
               field2200 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2186 = true;
      field2197 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2186 = false;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-610835257"
   )
   protected abstract void vmethod3121();

   public abstract void init();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1394036163"
   )
   protected abstract void vmethod3123();

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1216940837"
   )
   protected abstract void vmethod3125();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1302076508"
   )
   protected abstract void vmethod3126();

   @ObfuscatedName("tx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "382634120"
   )
   protected void method3127(String var1) {
      if(!this.field2193) {
         this.field2193 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("ti")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1193059349"
   )
   protected Container method3128() {
      return (Container)(null != class32.field760?class32.field760:this);
   }

   @ObfuscatedName("tr")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1055086463"
   )
   protected Dimension method3129() {
      Container var1 = this.method3128();
      int var2 = Math.max(var1.getWidth(), class191.field3076);
      int var3 = Math.max(var1.getHeight(), class30.field719);
      if(class32.field760 != null) {
         Insets var4 = class32.field760.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass108;I)V",
      garbageValue = "-1923124849"
   )
   static final void method3145(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class108[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var2 + var9 < 103 && var10 + var3 > 0 && var10 + var3 < 103) {
               var8[var1].field1896[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      class119 var13 = new class119(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var10 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  class10.method170(var13, var1, var2 + class99.method2287(var11 & 7, var12 & 7, var7), var3 + class13.method194(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class10.method170(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIIZB)V",
      garbageValue = "-98"
   )
   public static void method3157(class167 var0, int var1, int var2, int var3, boolean var4) {
      class183.field2967 = 1;
      class114.field1965 = var0;
      class183.field2963 = var1;
      class183.field2968 = var2;
      class183.field2966 = var3;
      class90.field1568 = var4;
      class59.field1228 = 10000;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("ts")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1287584840"
   )
   void method3178() {
      Container var1 = this.method3128();
      long var2 = class127.method2941();
      long var4 = field2196[class43.field1033];
      field2196[class43.field1033] = var2;
      class43.field1033 = class43.field1033 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var6 = (int)(var2 - var4);
         field2185 = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2198 - 1 > 50) {
         field2198 -= 50;
         field2197 = true;
         class158.field2585.setSize(class37.field876, class98.field1671);
         class158.field2585.setVisible(true);
         if(var1 == class32.field760) {
            Insets var7 = class32.field760.getInsets();
            class158.field2585.setLocation(field2192 + var7.left, var7.top + field2191);
         } else {
            class158.field2585.setLocation(field2192, field2191);
         }
      }

      this.vmethod3125();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-992510431"
   )
   protected abstract void vmethod3186();

   @ObfuscatedName("si")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "765"
   )
   protected final void method3200(int var1, int var2, int var3) {
      try {
         if(field2188 != null) {
            ++field2201;
            if(field2201 >= 3) {
               this.method3127("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2188 = this;
         class37.field876 = var1;
         class98.field1671 = var2;
         class148.field2217 = var3;
         class126.field2041 = this;
         if(null == class107.field1874) {
            class107.field1874 = new class136();
         }

         class107.field1874.method2991(this, 1);
      } catch (Exception var5) {
         class22.method655((String)null, var5);
         this.method3127("crash");
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }
}
