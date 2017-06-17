import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1354291957
   )
   int field3348;
   @ObfuscatedName("m")
   public static NodeCache field3349;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 404472127
   )
   public int field3350;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1588248015
   )
   public int field3352;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1527384461
   )
   public int field3353;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -510444187
   )
   public int field3356;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "48"
   )
   void method4225() {
      this.method4228(this.field3348);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method4226(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4232(var1, var3, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "557796266"
   )
   void method4228(int var1) {
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field3350 = (int)(256.0D * var14);
      this.field3352 = (int)(var16 * 256.0D);
      if(this.field3350 < 0) {
         this.field3350 = 0;
      } else if(this.field3350 > 255) {
         this.field3350 = 255;
      }

      if(this.field3352 < 0) {
         this.field3352 = 0;
      } else if(this.field3352 > 255) {
         this.field3352 = 255;
      }

      if(var16 > 0.5D) {
         this.field3353 = (int)(512.0D * (1.0D - var16) * var14);
      } else {
         this.field3353 = (int)(512.0D * var14 * var16);
      }

      if(this.field3353 < 1) {
         this.field3353 = 1;
      }

      this.field3356 = (int)(var12 * (double)this.field3353);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "-1726503559"
   )
   void method4232(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3348 = var1.read24BitInt();
      }

   }

   FloorUnderlayDefinition() {
      this.field3348 = 0;
   }

   static {
      field3349 = new NodeCache(64);
   }
}
