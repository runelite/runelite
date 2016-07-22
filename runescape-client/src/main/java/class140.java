import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class140 implements KeyListener, FocusListener {
   @ObfuscatedName("cu")
   public static int[] field2158 = new int[128];
   @ObfuscatedName("ck")
   public static int[] field2165 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cn")
   static char[] field2174 = new char[128];
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 142372281
   )
   public static int field2176 = 0;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 1494403671
   )
   public static int field2177 = 0;
   @ObfuscatedName("cy")
   public static int[] field2178 = new int[128];
   @ObfuscatedName("ca")
   static int[] field2179 = new int[128];
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -227828521
   )
   public static int field2180 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -853508189
   )
   public static int field2181 = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1959523949
   )
   public static int field2183 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1404585709
   )
   public static int field2184 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1637629225
   )
   @Export("keyboardIdleTicks")
   public static volatile int field2185 = 0;
   @ObfuscatedName("ch")
   public static boolean[] field2186 = new boolean[112];
   @ObfuscatedName("m")
   @Export("keyboard")
   public static class140 field2189 = new class140();

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != field2189) {
         field2185 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2165.length) {
            var2 = field2165[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2177 >= 0 && var2 >= 0) {
            field2158[field2177] = ~var2;
            field2177 = 1 + field2177 & 127;
            if(field2176 == field2177) {
               field2177 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2189) {
         field2177 = -1;
      }

   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(null != field2189) {
         field2185 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2165.length) {
            var2 = field2165[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2177 >= 0 && var2 >= 0) {
            field2158[field2177] = var2;
            field2177 = field2177 + 1 & 127;
            if(field2176 == field2177) {
               field2177 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2183 + 1 & 127;
            if(field2180 != var3) {
               field2179[field2183] = var2;
               field2174[field2183] = 0;
               field2183 = var3;
            }
         }

         var3 = var1.getModifiers();
         if((var3 & 10) != 0 || var2 == 85 || var2 == 10) {
            var1.consume();
         }
      }

   }

   public final void keyTyped(KeyEvent var1) {
      if(field2189 != null) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && var2 != '\uffff' && class41.method826(var2)) {
            int var3 = 1 + field2183 & 127;
            if(field2180 != var3) {
               field2179[field2183] = -1;
               field2174[field2183] = var2;
               field2183 = var3;
            }
         }
      }

      var1.consume();
   }

   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZB)V",
      garbageValue = "121"
   )
   protected static final void method2982(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class112.field1965.getGraphics();
         if(null == class147.field2264) {
            class147.field2264 = new Font("Helvetica", 1, 13);
            class7.field124 = class112.field1965.getFontMetrics(class147.field2264);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class12.field174, class19.field264);
         }

         if(var2 == null) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class17.field233 == null) {
               class17.field233 = class112.field1965.createImage(304, 34);
            }

            Graphics var5 = class17.field233.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - var0 * 3, 30);
            var5.setFont(class147.field2264);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - class7.field124.stringWidth(var1)) / 2, 22);
            var4.drawImage(class17.field233, class12.field174 / 2 - 152, class19.field264 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class12.field174 / 2 - 152;
            int var7 = class19.field264 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, 2 + var7, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(var0 * 3 + var6 + 2, var7 + 2, 300 - var0 * 3, 30);
            var4.setFont(class147.field2264);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - class7.field124.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class112.field1965.repaint();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-7"
   )
   static int method2983(int var0, int var1, int var2) {
      return (class5.field78[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class5.field78[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)[Lclass83;",
      garbageValue = "0"
   )
   static class83[] method2984(class170 var0, int var1, int var2) {
      return !class33.method708(var0, var1, var2)?null:class106.method2364();
   }
}
