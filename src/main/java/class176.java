import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class176 {
   @ObfuscatedName("d")
   @Export("widgetSettings")
   public static int[] field2905;
   @ObfuscatedName("w")
   @Export("settings")
   public static int[] field2906;
   @ObfuscatedName("a")
   static int[] field2909 = new int[32];
   @ObfuscatedName("bp")
   static class168 field2911;

   static {
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2909[var1] = var0 - 1;
         var0 += var0;
      }

      field2906 = new int[2000];
      field2905 = new int[2000];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "0"
   )
   public static int method3533(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
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
            } else if(8224 == var7) {
               var3[var4 + var6] = -122;
            } else if(8225 == var7) {
               var3[var4 + var6] = -121;
            } else if(710 == var7) {
               var3[var4 + var6] = -120;
            } else if(8240 == var7) {
               var3[var6 + var4] = -119;
            } else if(352 == var7) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(381 == var7) {
               var3[var4 + var6] = -114;
            } else if(8216 == var7) {
               var3[var4 + var6] = -111;
            } else if(var7 == 8217) {
               var3[var4 + var6] = -110;
            } else if(8220 == var7) {
               var3[var4 + var6] = -109;
            } else if(8221 == var7) {
               var3[var6 + var4] = -108;
            } else if(var7 == 8226) {
               var3[var6 + var4] = -107;
            } else if(8211 == var7) {
               var3[var6 + var4] = -106;
            } else if(var7 == 8212) {
               var3[var6 + var4] = -105;
            } else if(var7 == 732) {
               var3[var4 + var6] = -104;
            } else if(8482 == var7) {
               var3[var4 + var6] = -103;
            } else if(var7 == 353) {
               var3[var6 + var4] = -102;
            } else if(8250 == var7) {
               var3[var4 + var6] = -101;
            } else if(339 == var7) {
               var3[var4 + var6] = -100;
            } else if(382 == var7) {
               var3[var4 + var6] = -98;
            } else if(376 == var7) {
               var3[var4 + var6] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var4 + var6] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILclass167;IIIZI)V",
      garbageValue = "2062165051"
   )
   public static void method3536(int var0, class167 var1, int var2, int var3, int var4, boolean var5) {
      class183.field2967 = 1;
      class114.field1965 = var1;
      class183.field2963 = var2;
      class183.field2968 = var3;
      class183.field2966 = var4;
      class90.field1568 = var5;
      class59.field1228 = var0;
   }
}
