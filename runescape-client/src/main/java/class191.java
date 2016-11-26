import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class191 extends CacheableNode {
   @ObfuscatedName("d")
   public static NodeCache field2811 = new NodeCache(64);
   @ObfuscatedName("n")
   public static class182 field2812;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1140659525
   )
   int field2813 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 161708187
   )
   public int field2814;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1334391659
   )
   public int field2815;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 480854775
   )
   public int field2816;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1018335135
   )
   public int field2817;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-56"
   )
   public void method3529(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3531(var1, var3, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "987572503"
   )
   void method3531(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2813 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "86305397"
   )
   void method3532(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field2815 = (int)(var14 * 256.0D);
      this.field2816 = (int)(256.0D * var16);
      if(this.field2815 < 0) {
         this.field2815 = 0;
      } else if(this.field2815 > 255) {
         this.field2815 = 255;
      }

      if(this.field2816 < 0) {
         this.field2816 = 0;
      } else if(this.field2816 > 255) {
         this.field2816 = 255;
      }

      if(var16 > 0.5D) {
         this.field2817 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2817 = (int)(512.0D * var16 * var14);
      }

      if(this.field2817 < 1) {
         this.field2817 = 1;
      }

      this.field2814 = (int)((double)this.field2817 * var12);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1326115727"
   )
   public void method3536() {
      this.method3532(this.field2813);
   }
}
