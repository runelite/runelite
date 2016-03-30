import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cw")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("ps")
   static GarbageCollectorMXBean field1466;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1118017801
   )
   @Export("modelHeight")
   public int field1467 = 1000;

   @ObfuscatedName("aj")
   void vmethod2318(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1901();
      if(var10 != null) {
         this.field1467 = var10.field1467;
         var10.vmethod2318(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("x")
   public static int method1900(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var4 + var6] = (byte)var7;
         } else if(8364 == var7) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(8222 == var7) {
            var3[var4 + var6] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(8224 == var7) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var4 + var6] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(8240 == var7) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var4 + var6] = -117;
         } else if(338 == var7) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(var7 == 8216) {
            var3[var4 + var6] = -111;
         } else if(8217 == var7) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(8226 == var7) {
            var3[var6 + var4] = -107;
         } else if(8211 == var7) {
            var3[var4 + var6] = -106;
         } else if(8212 == var7) {
            var3[var4 + var6] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(8482 == var7) {
            var3[var6 + var4] = -103;
         } else if(353 == var7) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(339 == var7) {
            var3[var4 + var6] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("t")
   protected class105 vmethod1901() {
      return null;
   }
}
