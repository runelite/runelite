import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class140 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 975889837
   )
   public static int field2144 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 602068609
   )
   @Export("mouseIdleTicks")
   public static volatile int field2145 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -802366445
   )
   public static int field2146 = 0;
   @ObfuscatedName("f")
   @Export("mouse")
   public static class140 field2147 = new class140();
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -864740639
   )
   static int field2148;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -209582203
   )
   public static volatile int field2149 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1699530949
   )
   public static volatile int field2150 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -161869087
   )
   public static int field2151 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -897992063
   )
   public static volatile int field2152 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1405193985
   )
   public static volatile int field2153 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1312140499
   )
   public static volatile int field2154 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 2967234535569701361L
   )
   public static volatile long field2155 = 0L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 539472283
   )
   public static int field2156 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 63792933
   )
   public static volatile int field2157 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2127917129
   )
   public static int field2158 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 2534691362631492207L
   )
   public static long field2159 = 0L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1617077177
   )
   public static int field2161 = 0;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != field2147) {
         field2145 = 0;
         field2153 = var1.getX();
         field2157 = var1.getY();
         field2155 = class130.method2846();
         if(var1.isAltDown()) {
            field2152 = 4;
            field2154 = 4;
         } else if(var1.isMetaDown()) {
            field2152 = 2;
            field2154 = 2;
         } else {
            field2152 = 1;
            field2154 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(field2147 != null) {
         field2145 = 0;
         field2154 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2147 != null) {
         field2145 = 0;
         field2149 = var1.getX();
         field2150 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(field2147 != null) {
         field2145 = 0;
         field2149 = -1;
         field2150 = -1;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(field2147 != null) {
         field2145 = 0;
         field2149 = var1.getX();
         field2150 = var1.getY();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2147) {
         field2154 = 0;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != field2147) {
         field2145 = 0;
         field2149 = var1.getX();
         field2150 = var1.getY();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CIB)C",
      garbageValue = "0"
   )
   static char method3000(char var0, int var1) {
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
}
