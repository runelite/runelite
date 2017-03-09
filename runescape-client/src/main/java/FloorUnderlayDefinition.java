import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("j")
   public static NodeCache field2802 = new NodeCache(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 962900265
   )
   int field2803 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -973475125
   )
   public int field2804;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1838757921
   )
   public int field2805;
   @ObfuscatedName("x")
   public static class182 field2806;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 545715775
   )
   public int field2807;
   @ObfuscatedName("l")
   public static class181 field2808;
   @ObfuscatedName("id")
   static Widget field2809;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1293987099
   )
   public int field2810;
   @ObfuscatedName("ad")
   static class184 field2811;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1593143330"
   )
   void method3486() {
      this.method3491(this.field2803);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-747181484"
   )
   void method3487(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3488(var1, var3, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIB)V",
      garbageValue = "-67"
   )
   void method3488(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field2803 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "47892784"
   )
   void method3491(int var1) {
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
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field2805 = (int)(256.0D * var14);
      this.field2804 = (int)(var16 * 256.0D);
      if(this.field2805 < 0) {
         this.field2805 = 0;
      } else if(this.field2805 > 255) {
         this.field2805 = 255;
      }

      if(this.field2804 < 0) {
         this.field2804 = 0;
      } else if(this.field2804 > 255) {
         this.field2804 = 255;
      }

      if(var16 > 0.5D) {
         this.field2807 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field2807 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field2807 < 1) {
         this.field2807 = 1;
      }

      this.field2810 = (int)((double)this.field2807 * var12);
   }
}
