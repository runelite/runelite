import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -573838589
   )
   @Export("id")
   int id;
   @ObfuscatedName("l")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1138217201
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2091226203
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("t")
   @Export("x")
   double x;
   @ObfuscatedName("c")
   double field1483;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1618689309
   )
   int field1491;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -792329275
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -177096181
   )
   int field1475;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1262026531
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("y")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("z")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 844878909
   )
   @Export("start")
   int start;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 227775355
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @Export("z")
   double z;
   @ObfuscatedName("p")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("e")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1128531143
   )
   @Export("height")
   int height;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -580496361
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("u")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1248228191
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1559593109
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1719673903
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1673574673
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1491 = 0;
      this.field1475 = 0;
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
      int var12 = class15.getSpotAnimType(this.id).field3332;
      if(var12 != -1) {
         this.animationSequence = class216.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   protected final Model getModel() {
      Spotanim var1 = class15.getSpotAnimType(this.id);
      Model var2 = var1.method4339(this.field1491);
      if(var2 == null) {
         return null;
      } else {
         var2.method2525(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1463529363"
   )
   final void method1770(int var1) {
      this.isMoving = true;
      this.x += this.field1483 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * this.heightOffset * 0.5D * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1483, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1475 += var1;

         while(true) {
            do {
               do {
                  if(this.field1475 <= this.animationSequence.frameLenghts[this.field1491]) {
                     return;
                  }

                  this.field1475 -= this.animationSequence.frameLenghts[this.field1491];
                  ++this.field1491;
               } while(this.field1491 < this.animationSequence.frameIDs.length);

               this.field1491 -= this.animationSequence.frameStep;
            } while(this.field1491 >= 0 && this.field1491 < this.animationSequence.frameIDs.length);

            this.field1491 = 0;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "579161439"
   )
   final void method1768(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + var5 * (double)this.start / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1483 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1483 * this.field1483 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }
}
