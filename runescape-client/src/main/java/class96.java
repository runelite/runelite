import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class96 {
   @ObfuscatedName("o")
   static int[] field1495;
   @ObfuscatedName("f")
   static Buffer[] field1497;
   @ObfuscatedName("j")
   static byte[] field1498;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -466304283
   )
   static int field1499;
   @ObfuscatedName("c")
   static int[] field1501;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1704062751
   )
   static int field1502;
   @ObfuscatedName("i")
   static byte[] field1503;
   @ObfuscatedName("g")
   static int[] field1504;
   @ObfuscatedName("e")
   static int[] field1505;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -167942927
   )
   static int field1507;
   @ObfuscatedName("a")
   static int[] field1508;
   @ObfuscatedName("y")
   static Buffer field1509;
   @ObfuscatedName("h")
   static int[] field1511;

   static {
      field1503 = new byte[2048];
      field1498 = new byte[2048];
      field1497 = new Buffer[2048];
      field1499 = 0;
      field1501 = new int[2048];
      field1502 = 0;
      field1511 = new int[2048];
      field1504 = new int[2048];
      field1505 = new int[2048];
      field1495 = new int[2048];
      field1507 = 0;
      field1508 = new int[2048];
      field1509 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "781200762"
   )
   public static int method1764(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var4 + var6] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var4 + var6] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(var7 == 8224) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(var7 == 710) {
               var3[var4 + var6] = -120;
            } else if(var7 == 8240) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var4 + var6] = -114;
            } else if(var7 == 8216) {
               var3[var6 + var4] = -111;
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
               var3[var6 + var4] = -103;
            } else if(var7 == 353) {
               var3[var4 + var6] = -102;
            } else if(var7 == 8250) {
               var3[var4 + var6] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var6 + var4] = -98;
            } else if(var7 == 376) {
               var3[var4 + var6] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}
