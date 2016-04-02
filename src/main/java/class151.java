import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class151 {
   @ObfuscatedName("dq")
   @Export("region")
   static class86 field2250;

   @ObfuscatedName("e")
   public static class190[] method3149() {
      return new class190[]{class190.field3060, class190.field3058, class190.field3061, class190.field3050, class190.field3051, class190.field3053, class190.field3054, class190.field3052, class190.field3062, class190.field3055, class190.field3056, class190.field3064, class190.field3059, class190.field3049, class190.field3057};
   }

   @ObfuscatedName("w")
   public static int method3150(class119 var0, String var1) {
      int var2 = var0.field1976;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(8364 == var7) {
               var5[var6] = -128;
            } else if(8218 == var7) {
               var5[var6] = -126;
            } else if(var7 == 402) {
               var5[var6] = -125;
            } else if(var7 == 8222) {
               var5[var6] = -124;
            } else if(var7 == 8230) {
               var5[var6] = -123;
            } else if(var7 == 8224) {
               var5[var6] = -122;
            } else if(8225 == var7) {
               var5[var6] = -121;
            } else if(var7 == 710) {
               var5[var6] = -120;
            } else if(8240 == var7) {
               var5[var6] = -119;
            } else if(var7 == 352) {
               var5[var6] = -118;
            } else if(8249 == var7) {
               var5[var6] = -117;
            } else if(338 == var7) {
               var5[var6] = -116;
            } else if(var7 == 381) {
               var5[var6] = -114;
            } else if(8216 == var7) {
               var5[var6] = -111;
            } else if(8217 == var7) {
               var5[var6] = -110;
            } else if(8220 == var7) {
               var5[var6] = -109;
            } else if(var7 == 8221) {
               var5[var6] = -108;
            } else if(var7 == 8226) {
               var5[var6] = -107;
            } else if(8211 == var7) {
               var5[var6] = -106;
            } else if(8212 == var7) {
               var5[var6] = -105;
            } else if(var7 == 732) {
               var5[var6] = -104;
            } else if(8482 == var7) {
               var5[var6] = -103;
            } else if(353 == var7) {
               var5[var6] = -102;
            } else if(var7 == 8250) {
               var5[var6] = -101;
            } else if(var7 == 339) {
               var5[var6] = -100;
            } else if(var7 == 382) {
               var5[var6] = -98;
            } else if(376 == var7) {
               var5[var6] = -97;
            } else {
               var5[var6] = 63;
            }
         } else {
            var5[var6] = (byte)var7;
         }
      }

      var0.method2521(var5.length);
      var0.field1976 += class222.field3180.method2458(var5, 0, var5.length, var0.field1980, var0.field1976);
      return var0.field1976 - var2;
   }
}
