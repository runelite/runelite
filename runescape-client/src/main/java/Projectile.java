import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("ls")
   @ObfuscatedGetter(
      intValue = -2037733061
   )
   static int field1361;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1066538997
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1209246375
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1787909923
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -598384903
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -821265927
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2064399241
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1458881917
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 778126413
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1466748779
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -26934641
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 89622359
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("r")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("d")
   @Export("x")
   double x;
   @ObfuscatedName("v")
   @Export("y")
   double y;
   @ObfuscatedName("s")
   @Export("z")
   double z;
   @ObfuscatedName("t")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("f")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("m")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("x")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("w")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1570963639
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1011167813
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 144003243
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -985313835
   )
   @Export("int6")
   int int6;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.int7 = 0;
      this.int6 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.height = var5;
      this.startMovementCycle = var6;
      this.endCycle = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.interacting = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = IndexFile.getSpotAnimType(this.id).field3425;
      if(var12 != -1) {
         this.animationSequence = Occluder.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2133643415"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.startHeight * var5 / var9 + (double)this.x1;
         this.y = (double)this.startHeight * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityZ * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-122"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += this.velocityX * (double)var1;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * 0.5D * this.heightOffset * (double)var1 + (double)var1 * this.velocityZ;
      this.velocityZ += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLenghts[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLenghts[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   protected final Model getModel() {
      Spotanim var1 = IndexFile.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }
}
