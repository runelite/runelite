import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fq")
public class class177 {
   @ObfuscatedName("cv")
   static class142 field2911;
   @ObfuscatedName("c")
   static class13 field2912;

   @ObfuscatedName("l")
   public static int method3431(class118 var0, String var1) {
      int var2 = var0.field1998;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(8218 == var7) {
            var5[var6] = -126;
         } else if(402 == var7) {
            var5[var6] = -125;
         } else if(8222 == var7) {
            var5[var6] = -124;
         } else if(8230 == var7) {
            var5[var6] = -123;
         } else if(8224 == var7) {
            var5[var6] = -122;
         } else if(8225 == var7) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(352 == var7) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(381 == var7) {
            var5[var6] = -114;
         } else if(8216 == var7) {
            var5[var6] = -111;
         } else if(8217 == var7) {
            var5[var6] = -110;
         } else if(8220 == var7) {
            var5[var6] = -109;
         } else if(8221 == var7) {
            var5[var6] = -108;
         } else if(8226 == var7) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
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
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.method2590(var5.length);
      var0.field1998 += class221.field3175.method2391(var5, 0, var5.length, var0.field1995, var0.field1998);
      return var0.field1998 - var2;
   }
}
