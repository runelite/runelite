import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class171 {
   @ObfuscatedName("bx")
   static class184 field2324;
   @ObfuscatedName("bh")
   static class184 field2330;

   class171() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-890180002"
   )
   public static int method3246(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(var7 == 710) {
               var3[var6 + var4] = -120;
            } else if(var7 == 8240) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var6 + var4] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var6 + var4] = -109;
            } else if(var7 == 8221) {
               var3[var4 + var6] = -108;
            } else if(var7 == 8226) {
               var3[var4 + var6] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(var7 == 8482) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var6 + var4] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var4 + var6] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "-2140624886"
   )
   static boolean method3247(class182 var0, int var1) {
      byte[] var2 = var0.method3278(var1);
      if(null == var2) {
         return false;
      } else {
         class47.method890(var2);
         return true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-1"
   )
   static boolean method3248(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
