import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("FloorUnderlayDefinition")
public class FloorUnderlayDefinition extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 957213823
   )
   public int field3329;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2012076615
   )
   public int field3330;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1102459069
   )
   int field3331;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1027347385
   )
   public int field3332;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1781253061
   )
   public int field3333;
   @ObfuscatedName("i")
   static IndexDataBase field3334;
   @ObfuscatedName("h")
   static NodeCache field3336;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "190318818"
   )
   void method4422(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if(var3 == 0) {
            return;
         }

         this.method4438(var1, var3, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1832788667"
   )
   void method4423() {
      this.method4426(this.field3331);
   }

   static {
      field3336 = new NodeCache(64);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-104"
   )
   void method4426(int var1) {
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
            var14 = (var10 - var8) / (var8 + var10);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field3329 = (int)(var14 * 256.0D);
      this.field3330 = (int)(256.0D * var16);
      if(this.field3329 < 0) {
         this.field3329 = 0;
      } else if(this.field3329 > 255) {
         this.field3329 = 255;
      }

      if(this.field3330 < 0) {
         this.field3330 = 0;
      } else if(this.field3330 > 255) {
         this.field3330 = 255;
      }

      if(var16 > 0.5D) {
         this.field3333 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field3333 = (int)(512.0D * var14 * var16);
      }

      if(this.field3333 < 1) {
         this.field3333 = 1;
      }

      this.field3332 = (int)((double)this.field3333 * var12);
   }

   FloorUnderlayDefinition() {
      this.field3331 = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "161086689"
   )
   void method4438(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field3331 = var1.read24BitInt();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass165;B)V",
      garbageValue = "-2"
   )
   public static void method4441(class165 var0) {
      class265.field3655 = var0;
   }
}
