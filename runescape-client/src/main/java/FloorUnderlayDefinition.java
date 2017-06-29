import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1296539987
   )
   public int field3348;
   @ObfuscatedName("w")
   static NodeCache field3349;
   @ObfuscatedName("i")
   static IndexDataBase field3350;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1365747369
   )
   public int field3351;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -595513481
   )
   public int field3353;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 916749019
   )
   public int field3354;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2073712485
   )
   int field3355;

   FloorUnderlayDefinition() {
      this.field3355 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1007376124"
   )
   void method4359(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3355 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method4360(int var1) {
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
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field3348 = (int)(256.0D * var14);
      this.field3353 = (int)(var16 * 256.0D);
      if(this.field3348 < 0) {
         this.field3348 = 0;
      } else if(this.field3348 > 255) {
         this.field3348 = 255;
      }

      if(this.field3353 < 0) {
         this.field3353 = 0;
      } else if(this.field3353 > 255) {
         this.field3353 = 255;
      }

      if(var16 > 0.5D) {
         this.field3354 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field3354 = (int)(512.0D * var16 * var14);
      }

      if(this.field3354 < 1) {
         this.field3354 = 1;
      }

      this.field3351 = (int)((double)this.field3354 * var12);
   }

   static {
      field3349 = new NodeCache(64);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-452961936"
   )
   void method4368() {
      this.method4360(this.field3355);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1080723488"
   )
   void method4378(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4359(var1, var3, var2);
      }
   }
}
