import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1453953673
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1295067965
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1133414197
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -844554133
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1699302103
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 101924957
   )
   int field1454;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2140854015
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("n")
   @Export("x")
   double x;
   @ObfuscatedName("r")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("l")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -403776305
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("q")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1906452711
   )
   int field1461;
   @ObfuscatedName("a")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("g")
   @Export("z")
   double z;
   @ObfuscatedName("v")
   double field1464;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1317787629
   )
   @Export("height")
   int height;
   @ObfuscatedName("k")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 270489799
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -688098511
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -699318341
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("x")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("s")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -472215583
   )
   int field1473;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -974777433
   )
   @Export("start")
   int start;
   @ObfuscatedName("ip")
   static Widget field1475;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1461 = 0;
      this.field1473 = 0;
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
      this.field1454 = var11;
      this.isMoving = false;
      int var12 = Area.method4176(this.id).field3335;
      if(var12 != -1) {
         this.animationSequence = GameEngine.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "473347932"
   )
   final void method1653(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + var5 * (double)this.start / var9;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1464 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1464 * this.field1464 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "619710816"
   )
   final void method1654(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1464;
      this.velocityZ += this.scalar * (double)var1;
      this.z += 0.5D * this.heightOffset * (double)var1 * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1464, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1473 += var1;

         while(true) {
            do {
               do {
                  if(this.field1473 <= this.animationSequence.frameLenghts[this.field1461]) {
                     return;
                  }

                  this.field1473 -= this.animationSequence.frameLenghts[this.field1461];
                  ++this.field1461;
               } while(this.field1461 < this.animationSequence.frameIDs.length);

               this.field1461 -= this.animationSequence.frameStep;
            } while(this.field1461 >= 0 && this.field1461 < this.animationSequence.frameIDs.length);

            this.field1461 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   protected final Model getModel() {
      Spotanim var1 = Area.method4176(this.id);
      Model var2 = var1.method4213(this.field1461);
      if(var2 == null) {
         return null;
      } else {
         var2.method2407(this.rotationY);
         return var2;
      }
   }
}
