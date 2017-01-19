import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1530328407
   )
   @Export("height")
   int height;
   @ObfuscatedName("p")
   public static String[] field1210;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 858775773
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("a")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("g")
   @Export("top")
   Renderable top;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 229433945
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -700930213
   )
   static int field1216;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1539425809
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1180651757
   )
   @Export("hash")
   int hash;

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-424486447"
   )
   static final void method1423() {
      for(class33 var0 = (class33)Client.field426.method2330(); var0 != null; var0 = (class33)Client.field426.method2346()) {
         if(var0.field742 == class118.plane && !var0.field749) {
            if(Client.gameCycle >= var0.field748) {
               var0.method669(Client.field533);
               if(var0.field749) {
                  var0.unlink();
               } else {
                  class0.region.method1713(var0.field742, var0.field741, var0.field744, var0.field745, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1279483704"
   )
   public static int method1424(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(var7 == 8218) {
               var3[var6 + var4] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var6 + var4] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }
}
