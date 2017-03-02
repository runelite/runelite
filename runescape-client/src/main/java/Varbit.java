import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 585932483
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("l")
   public static NodeCache field2850 = new NodeCache(64);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -882909293
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("b")
   public static class182 field2853;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1776529753
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("dl")
   @Export("region")
   static Region region;
   @ObfuscatedName("ce")
   static class102 field2856;
   @ObfuscatedName("d")
   static int[] field2857;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1109716208"
   )
   public void method3617(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3623(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "89"
   )
   void method3623(Buffer var1, int var2) {
      if(var2 == 1) {
         this.leastSignificantBit = var1.readUnsignedShort();
         this.configId = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "447913376"
   )
   public static byte method3627(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Lclass112;",
      garbageValue = "-375823926"
   )
   public static class112 method3628() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }
}
