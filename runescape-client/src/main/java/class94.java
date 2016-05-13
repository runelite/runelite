import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("DecorativeObject")
public final class class94 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1875260573
   )
   int field1610;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1742848005
   )
   @Export("x")
   int field1612;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1845292713
   )
   int field1613;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -369791811
   )
   int field1614;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 75319361
   )
   int field1616;
   @ObfuscatedName("b")
   @Export("renderable1")
   public class85 field1617;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -723096351
   )
   @Export("hash")
   public int field1619 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 189281381
   )
   @Export("floor")
   int field1620;
   @ObfuscatedName("k")
   @Export("renderable2")
   public class85 field1622;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2136198699
   )
   int field1623 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -994627517
   )
   @Export("y")
   int field1625;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1491820662"
   )
   static final void method2144() {
      for(int var0 = 0; var0 < client.field317; ++var0) {
         int var1 = client.field318[var0];
         class34 var2 = client.field515[var1];
         if(null != var2) {
            class72.method1550(var2, var2.field782.field887);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(CS)B",
      garbageValue = "12014"
   )
   public static byte method2145(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(8364 == var0) {
            var1 = -128;
         } else if(8218 == var0) {
            var1 = -126;
         } else if(402 == var0) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(8230 == var0) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(8225 == var0) {
            var1 = -121;
         } else if(710 == var0) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(8249 == var0) {
            var1 = -117;
         } else if(338 == var0) {
            var1 = -116;
         } else if(381 == var0) {
            var1 = -114;
         } else if(8216 == var0) {
            var1 = -111;
         } else if(8217 == var0) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(8226 == var0) {
            var1 = -107;
         } else if(8211 == var0) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(732 == var0) {
            var1 = -104;
         } else if(8482 == var0) {
            var1 = -103;
         } else if(353 == var0) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(382 == var0) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZS)V",
      garbageValue = "0"
   )
   static void method2146(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2729.method3777(var6);
      if(var8 == null) {
         var8 = (class172)class171.field2726.method3777(var6);
         if(var8 == null) {
            var8 = (class172)class171.field2734.method3777(var6);
            if(null != var8) {
               if(var5) {
                  var8.method3876();
                  class171.field2729.method3778(var8, var6);
                  --class171.field2745;
                  ++class171.field2730;
               }
            } else {
               if(!var5) {
                  var8 = (class172)class171.field2736.method3777(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2752 = var0;
               var8.field2748 = var3;
               var8.field2750 = var4;
               if(var5) {
                  class171.field2729.method3778(var8, var6);
                  ++class171.field2730;
               } else {
                  class171.field2743.method3860(var8);
                  class171.field2734.method3778(var8, var6);
                  ++class171.field2745;
               }
            }
         }
      }

   }
}
