import java.applet.Applet;
import java.awt.Canvas;
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

@ObfuscatedName("eq")
@Implements("GameEngine")
public abstract class class144 extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pp")
   boolean field2174;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1174250019
   )
   static int field2175 = 0;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      longValue = 2728430322233500821L
   )
   static long field2176 = 0L;
   @ObfuscatedName("pa")
   static boolean field2177 = false;
   @ObfuscatedName("qf")
   protected static long[] field2178 = new long[32];
   @ObfuscatedName("rl")
   @ObfuscatedGetter(
      longValue = 2132254675372668091L
   )
   static volatile long field2179 = 0L;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = 877725383
   )
   static int field2180 = 1;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1356472227
   )
   @Export("FPS")
   protected static int field2181 = 0;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 785928665
   )
   protected static int field2182 = 0;
   @ObfuscatedName("qj")
   protected static long[] field2183 = new long[32];
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = -2085652269
   )
   protected static int field2184 = 0;
   @ObfuscatedName("ap")
   static class168 field2185;
   @ObfuscatedName("qd")
   protected static volatile boolean field2186 = true;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -252052447
   )
   static int field2187 = 500;
   @ObfuscatedName("ql")
   protected static boolean field2188 = false;
   @ObfuscatedName("qn")
   protected static volatile boolean field2189 = false;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -480093129
   )
   static int field2190 = 20;
   @ObfuscatedName("rj")
   static volatile boolean field2191 = true;
   @ObfuscatedName("pw")
   static class144 field2192 = null;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1115293753
   )
   @Export("plane")
   static int field2193;

   public final void focusGained(FocusEvent var1) {
      field2191 = true;
      field2186 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2191 = false;
   }

   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "19465"
   )
   void method3045() {
      long var1 = class90.method2090();
      long var3 = field2183[class39.field897];
      field2183[class39.field897] = var1;
      class39.field897 = class39.field897 + 1 & 31;
      if(0L != var3 && var1 > var3) {
         ;
      }

      synchronized(this) {
         class108.field1871 = field2191;
      }

      this.vmethod3054();
   }

   @ObfuscatedName("qr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1109286927"
   )
   void method3046() {
      Container var1 = this.method3057();
      long var2 = class90.method2090();
      long var4 = field2178[class101.field1739];
      field2178[class101.field1739] = var2;
      class101.field1739 = class101.field1739 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var7 = (int)(var2 - var4);
         field2181 = ((var7 >> 1) + 32000) / var7;
      }

      if(++field2187 - 1 > 50) {
         field2187 -= 50;
         field2186 = true;
         class46.field1040.setSize(class45.field1026, class143.field2169);
         class46.field1040.setVisible(true);
         if(class75.field1346 == var1) {
            Insets var6 = class75.field1346.getInsets();
            class46.field1040.setLocation(var6.left + field2184, var6.top + field2182);
         } else {
            class46.field1040.setLocation(field2184, field2182);
         }
      }

      this.vmethod3055();
   }

   @ObfuscatedName("qy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   final synchronized void method3047() {
      if(!field2177) {
         field2177 = true;

         try {
            class46.field1040.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3077();
         } catch (Exception var4) {
            ;
         }

         if(null != class75.field1346) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class40.field924 != null) {
            try {
               class40.field924.method2914();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3059();
      }
   }

   public void start() {
      if(this == field2192 && !field2177) {
         field2176 = 0L;
      }
   }

   public abstract void init();

   public void destroy() {
      if(this == field2192 && !field2177) {
         field2176 = class90.method2090();
         class116.method2459(5000L);
         this.method3047();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2192 && !field2177) {
         field2186 = true;
         if(class136.field2079 != null && class136.field2079.startsWith("1.5") && class90.method2090() - field2179 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(var2 == null || var2.width >= class45.field1026 && var2.height >= class143.field2169) {
               field2189 = true;
            }
         }

      }
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1714457839"
   )
   protected abstract void vmethod3053();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-614007547"
   )
   protected abstract void vmethod3054();

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   protected abstract void vmethod3055();

   public void run() {
      try {
         if(null != class26.field659) {
            String var1 = class26.field659.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class136.field2079;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3056("wrongjava");
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
                  if(class154.method3171(var6)) {
                     int var11 = class9.method117(var6, 10, true);
                     if(var11 < 10) {
                        this.method3056("wrongjava");
                        return;
                     }
                  }
               }

               field2180 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3083();
         this.vmethod3053();

         Object var10;
         try {
            var10 = new class147();
         } catch (Throwable var8) {
            var10 = new class141();
         }

         class109.field1888 = (class133)var10;

         while(field2176 == 0L || class90.method2090() < field2176) {
            class17.field253 = class109.field1888.vmethod3123(field2190, field2180);

            for(int var7 = 0; var7 < class17.field253; ++var7) {
               this.method3045();
            }

            this.method3046();
            class129.method2857(class40.field924, class46.field1040);
         }
      } catch (Exception var9) {
         class7.method94((String)null, var9);
         this.method3056("crash");
      }

      this.method3047();
   }

   @ObfuscatedName("qh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "3"
   )
   protected void method3056(String var1) {
      if(!this.field2174) {
         this.field2174 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-1008722212"
   )
   protected Container method3057() {
      return (Container)(class75.field1346 != null?class75.field1346:this);
   }

   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "(B)Ljava/awt/Dimension;",
      garbageValue = "-58"
   )
   protected Dimension method3058() {
      Container var1 = this.method3057();
      int var2 = Math.max(var1.getWidth(), class104.field1782);
      int var3 = Math.max(var1.getHeight(), class9.field150);
      if(null != class75.field1346) {
         Insets var4 = class75.field1346.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.top + var4.bottom;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-114"
   )
   protected abstract void vmethod3059();

   public void stop() {
      if(this == field2192 && !field2177) {
         field2176 = class90.method2090() + 4000L;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-99828191"
   )
   static char method3064(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   protected abstract void vmethod3077();

   public final void windowActivated(WindowEvent var1) {
   }

   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1643740393"
   )
   protected final synchronized void method3083() {
      Container var1 = this.method3057();
      if(null != class46.field1040) {
         class46.field1040.removeFocusListener(this);
         var1.remove(class46.field1040);
      }

      class45.field1026 = Math.max(var1.getWidth(), class104.field1782);
      class143.field2169 = Math.max(var1.getHeight(), class9.field150);
      Insets var2;
      if(null != class75.field1346) {
         var2 = class75.field1346.getInsets();
         class45.field1026 -= var2.right + var2.left;
         class143.field2169 -= var2.bottom + var2.top;
      }

      class46.field1040 = new class139(this);
      var1.add(class46.field1040);
      class46.field1040.setSize(class45.field1026, class143.field2169);
      class46.field1040.setVisible(true);
      if(class75.field1346 == var1) {
         var2 = class75.field1346.getInsets();
         class46.field1040.setLocation(var2.left + field2184, field2182 + var2.top);
      } else {
         class46.field1040.setLocation(field2184, field2182);
      }

      class46.field1040.addFocusListener(this);
      class46.field1040.requestFocus();
      field2186 = true;
      int var3 = class45.field1026;
      int var4 = class143.field2169;
      Canvas var5 = class46.field1040;

      Object var9;
      try {
         class81 var6 = new class81();
         var6.vmethod1878(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         class75 var7 = new class75();
         var7.vmethod1878(var3, var4, var5);
         var9 = var7;
      }

      if(null != class48.field1049) {
         class48.field1049.vmethod1887(((class77)var9).field1362.getGraphics(), 0, 0);
      }

      class48.field1049 = (class77)var9;
      field2189 = false;
      field2179 = class90.method2090();
   }

   public final void windowOpened(WindowEvent var1) {
   }

   @ObfuscatedName("qc")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-124"
   )
   protected final boolean method3104() {
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
                     this.method3056("invalidhost");
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

   @ObfuscatedName("qj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2092409514"
   )
   protected final void method3110(int var1, int var2, int var3) {
      try {
         if(field2192 != null) {
            ++field2175;
            if(field2175 >= 3) {
               this.method3056("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2192 = this;
         class45.field1026 = var1;
         class143.field2169 = var2;
         class148.field2206 = var3;
         class148.field2210 = this;
         if(class40.field924 == null) {
            class40.field924 = new class136();
         }

         class40.field924.method2917(this, 1);
      } catch (Exception var5) {
         class7.method94((String)null, var5);
         this.method3056("crash");
      }

   }
}
