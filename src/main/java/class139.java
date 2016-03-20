import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public class class139 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1968676083
   )
   static volatile int field2133 = -1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -737570728708419453L
   )
   static volatile long field2134 = 0L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1292881431
   )
   public static int field2135 = 0;
   @ObfuscatedName("a")
   static class139 field2136 = new class139();
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1736942731
   )
   static volatile int field2137 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -139584701
   )
   public static int field2138 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 800968501
   )
   public static volatile int field2139 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1197646263
   )
   public static int field2140 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1910810319
   )
   static volatile int field2141 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1669627175
   )
   static volatile int field2142 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 933661595
   )
   static volatile int field2143 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 362033111
   )
   public static int field2145 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -738196837
   )
   public static int field2146 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1746935647
   )
   public static int field2147 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 1240075401276957525L
   )
   public static long field2148 = 0L;
   @ObfuscatedName("qg")
   public static class77 field2149;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -825376543
   )
   static volatile int field2151 = 0;

   @ObfuscatedName("f")
   public static byte[] method2953(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(8364 == var4) {
            var2[var3] = -128;
         } else if(8218 == var4) {
            var2[var3] = -126;
         } else if(402 == var4) {
            var2[var3] = -125;
         } else if(8222 == var4) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(710 == var4) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(8249 == var4) {
            var2[var3] = -117;
         } else if(338 == var4) {
            var2[var3] = -116;
         } else if(381 == var4) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(8217 == var4) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(353 == var4) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(382 == var4) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(field2136 != null) {
         field2139 = 0;
         field2142 = var1.getX();
         field2143 = var1.getY();
         field2134 = class18.method214();
         if(var1.isAltDown()) {
            field2151 = 4;
            field2141 = 4;
         } else if(var1.isMetaDown()) {
            field2151 = 2;
            field2141 = 2;
         } else {
            field2151 = 1;
            field2141 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(field2136 != null) {
         field2139 = 0;
         field2137 = var1.getX();
         field2133 = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(field2136 != null) {
         field2139 = 0;
         field2137 = var1.getX();
         field2133 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(null != field2136) {
         field2141 = 0;
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(null != field2136) {
         field2139 = 0;
         field2137 = var1.getX();
         field2133 = var1.getY();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != field2136) {
         field2139 = 0;
         field2137 = -1;
         field2133 = -1;
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != field2136) {
         field2139 = 0;
         field2141 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   @ObfuscatedName("bd")
   static final void method2980(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class90.field1572[var6];
         var12 = class90.field1578[var6];
         var13 = var9 * var12 - var5 * var11 >> 16;
         var10 = var9 * var11 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(0 != var7) {
         var11 = class90.field1572[var7];
         var12 = class90.field1578[var7];
         var13 = var10 * var11 + var12 * var8 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class44.field1037 = var0 - var8;
      class30.field713 = var1 - var9;
      class17.field254 = var2 - var10;
      class15.field219 = var3;
      class13.field193 = var4;
   }
}
