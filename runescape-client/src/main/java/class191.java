import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class191 {
   @ObfuscatedName("gi")
   public static final int[] field3104 = new int[]{0, -2, 0, 0, -2, 3, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, -2, -1, -2, 0, 0, 5, 0, 0, 0, 0, -2, 0, 0, 10, 6, -2, 0, 0, 2, 0, -2, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 2, 0, -2, 0, 0, 0, -1, 0, 0, 0, 0, 0, -2, 10, 4, 0, 0, 0, 0, 0, 0, 1, 0, 4, 0, 4, 0, 2, 0, 8, 0, 0, 0, 6, 0, 6, 0, 0, -2, 0, 0, 4, 0, 5, 0, 2, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 8, 1, 0, -2, 0, 0, -1, 0, 0, 0, 20, 0, -2, 0, 0, -2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 6, 5, 0, 0, 2, 0, 0, 0, 0, 15, -2, 0, -2, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 28, 0, 6, 0, 0, 0, 0, 0, 0, 0, 6, 8, 0, 8, 7, 0, 1, 0, -2, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 2, 0, 0, 0, 0, 12, 0, 0, 0, 4, 0, 6, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 14, 0, 2, 4, 5, 0, 0, 4, 0, -1, 0, 0, 0, 0, 0, 6, 0, -2, 0, 2, 0, -2, 0, 0, 0, 0, 0, 0, 0};

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;Ljava/lang/String;I)I",
      garbageValue = "-658289284"
   )
   public static int method3773(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
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

      var0.method2603(var5.length);
      var0.offset += class225.field3229.method2456(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
