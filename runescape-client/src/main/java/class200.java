import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class200 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 431447201
   )
   public int field3033;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 228789859
   )
   public int field3034 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -58796175
   )
   public int field3035 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -194034251
   )
   public int field3036 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -570456291
   )
   public int field3037;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 368881153
   )
   public int field3038;
   @ObfuscatedName("o")
   public static class182 field3039;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -27208669
   )
   public int field3040;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -907149645
   )
   public int field3041;
   @ObfuscatedName("h")
   public boolean field3042 = true;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 606535921
   )
   public int field3043;
   @ObfuscatedName("m")
   public static NodeCache field3044 = new NodeCache(64);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "938074032"
   )
   void method3647() {
      if(this.field3034 != -1) {
         this.method3655(this.field3034);
         this.field3033 = this.field3037;
         this.field3043 = this.field3040;
         this.field3038 = this.field3041;
      }

      this.method3655(this.field3035);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1216029615"
   )
   void method3648(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method3649(var1, var3, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-1594098376"
   )
   void method3649(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3035 = var1.read24BitInt();
      } else if(var2 == 2) {
         this.field3036 = var1.readUnsignedByte();
      } else if(var2 == 5) {
         this.field3042 = false;
      } else if(var2 == 7) {
         this.field3034 = var1.read24BitInt();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2114389389"
   )
   void method3655(int var1) {
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
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field3037 = (int)(var12 * 256.0D);
      this.field3040 = (int)(var14 * 256.0D);
      this.field3041 = (int)(256.0D * var16);
      if(this.field3040 < 0) {
         this.field3040 = 0;
      } else if(this.field3040 > 255) {
         this.field3040 = 255;
      }

      if(this.field3041 < 0) {
         this.field3041 = 0;
      } else if(this.field3041 > 255) {
         this.field3041 = 255;
      }

   }
}
