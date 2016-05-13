import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class22 extends class204 {
   @ObfuscatedName("h")
   public static String[] field583;
   @ObfuscatedName("j")
   int[] field584;
   @ObfuscatedName("p")
   int[] field585;
   @ObfuscatedName("x")
   String[] field586;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1958727045
   )
   int field587;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1714892145
   )
   int field588;
   @ObfuscatedName("s")
   static class193 field589 = new class193(128);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1954581951
   )
   int field590;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 806214141
   )
   int field592;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -175252437
   )
   @Export("baseX")
   static int field594;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "0"
   )
   public static int method569(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(8218 == var7) {
               var3[var4 + var6] = -126;
            } else if(var7 == 402) {
               var3[var4 + var6] = -125;
            } else if(8222 == var7) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(8224 == var7) {
               var3[var6 + var4] = -122;
            } else if(var7 == 8225) {
               var3[var4 + var6] = -121;
            } else if(710 == var7) {
               var3[var6 + var4] = -120;
            } else if(8240 == var7) {
               var3[var4 + var6] = -119;
            } else if(var7 == 352) {
               var3[var6 + var4] = -118;
            } else if(8249 == var7) {
               var3[var4 + var6] = -117;
            } else if(var7 == 338) {
               var3[var6 + var4] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(8216 == var7) {
               var3[var6 + var4] = -111;
            } else if(8217 == var7) {
               var3[var6 + var4] = -110;
            } else if(8220 == var7) {
               var3[var6 + var4] = -109;
            } else if(8221 == var7) {
               var3[var6 + var4] = -108;
            } else if(8226 == var7) {
               var3[var6 + var4] = -107;
            } else if(8211 == var7) {
               var3[var4 + var6] = -106;
            } else if(8212 == var7) {
               var3[var6 + var4] = -105;
            } else if(732 == var7) {
               var3[var6 + var4] = -104;
            } else if(8482 == var7) {
               var3[var4 + var6] = -103;
            } else if(353 == var7) {
               var3[var4 + var6] = -102;
            } else if(8250 == var7) {
               var3[var4 + var6] = -101;
            } else if(339 == var7) {
               var3[var4 + var6] = -100;
            } else if(382 == var7) {
               var3[var4 + var6] = -98;
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

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-84"
   )
   static void method571() {
      if(client.field432) {
         class173 var0 = class45.method932(class159.field2613, client.field307);
         if(var0 != null && var0.field2800 != null) {
            class0 var1 = new class0();
            var1.field8 = var0;
            var1.field12 = var0.field2800;
            class16.method197(var1);
         }

         client.field432 = false;
         class34.method701(var0);
      }

   }
}
