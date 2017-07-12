import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1736306513
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1817799481
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2067635937
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1823579883
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1357057649
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2007494435
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @Export("z")
   double z;
   @ObfuscatedName("n")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -31159979
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2061054323
   )
   @Export("start")
   int start;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2052544207
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("z")
   @Export("x")
   double x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -792591837
   )
   @Export("height")
   int height;
   @ObfuscatedName("l")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("m")
   double field1496;
   @ObfuscatedName("b")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("f")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("d")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("u")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -733277651
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 611016309
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2080305339
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -994171845
   )
   int field1504;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1443928059
   )
   int field1505;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1339556864"
   )
   final void method1758(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1496 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1496 * this.field1496);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "17131905"
   )
   final void method1759(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1496;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * 0.5D * this.heightOffset * (double)var1;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1496, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1505 += var1;

         while(true) {
            do {
               do {
                  if(this.field1505 <= this.animationSequence.frameLenghts[this.field1504]) {
                     return;
                  }

                  this.field1505 -= this.animationSequence.frameLenghts[this.field1504];
                  ++this.field1504;
               } while(this.field1504 < this.animationSequence.frameIDs.length);

               this.field1504 -= this.animationSequence.frameStep;
            } while(this.field1504 >= 0 && this.field1504 < this.animationSequence.frameIDs.length);

            this.field1504 = 0;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1914243094"
   )
   protected final Model getModel() {
      Spotanim var1 = Renderable.getSpotAnimType(this.id);
      Model var2 = var1.method4338(this.field1504);
      if(var2 == null) {
         return null;
      } else {
         var2.method2503(this.rotationY);
         return var2;
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1504 = 0;
      this.field1505 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startTime = var6;
      this.cycle = var7;
      this.slope = var8;
      this.start = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = Renderable.getSpotAnimType(this.id).field3332;
      if(var12 != -1) {
         this.animationSequence = class224.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "965279355"
   )
   static void method1767(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field1312[var5]) {
            var2[var4] = World.field1312[var5];
            var3[var4] = World.field1318[var5];
            ++var4;
         }
      }

      World.field1312 = var2;
      World.field1318 = var3;
      class9.method48(World.worldList, 0, World.worldList.length - 1, World.field1312, World.field1318);
   }

   @ObfuscatedName("i")
   static final int method1768(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(0.0D != var2) {
         double var12;
         if(var4 < 0.5D) {
            var12 = var4 * (1.0D + var2);
         } else {
            var12 = var2 + var4 - var2 * var4;
         }

         double var14 = var4 * 2.0D - var12;
         double var16 = var0 + 0.3333333333333333D;
         if(var16 > 1.0D) {
            --var16;
         }

         double var18 = var0 - 0.3333333333333333D;
         if(var18 < 0.0D) {
            ++var18;
         }

         if(var16 * 6.0D < 1.0D) {
            var6 = var14 + 6.0D * (var12 - var14) * var16;
         } else if(2.0D * var16 < 1.0D) {
            var6 = var12;
         } else if(3.0D * var16 < 2.0D) {
            var6 = var14 + 6.0D * (var12 - var14) * (0.6666666666666666D - var16);
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = var14 + 6.0D * (var12 - var14) * var0;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(3.0D * var0 < 2.0D) {
            var8 = 6.0D * (0.6666666666666666D - var0) * (var12 - var14) + var14;
         } else {
            var8 = var14;
         }

         if(6.0D * var18 < 1.0D) {
            var10 = var14 + 6.0D * (var12 - var14) * var18;
         } else if(var18 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var18 * 3.0D < 2.0D) {
            var10 = (var12 - var14) * (0.6666666666666666D - var18) * 6.0D + var14;
         } else {
            var10 = var14;
         }
      }

      int var20 = (int)(256.0D * var6);
      int var13 = (int)(var8 * 256.0D);
      int var21 = (int)(var10 * 256.0D);
      int var15 = var21 + (var13 << 8) + (var20 << 16);
      return var15;
   }
}
