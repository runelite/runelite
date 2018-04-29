import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -732104975
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 359848501
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 536999447
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1751985509
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1151581845
   )
   @Export("height")
   int height;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2089715635
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1724441275
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1010634339
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1139802107
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -317445129
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1646659611
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("d")
   @Export("x")
   double x;
   @ObfuscatedName("r")
   @Export("y")
   double y;
   @ObfuscatedName("p")
   @Export("z")
   double z;
   @ObfuscatedName("q")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("f")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("j")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("v")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("u")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 891264961
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2106373013
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkc;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1055375069
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 377255623
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
      int var12 = WidgetNode.getSpotAnimType(this.id).field3495;
      if(var12 != -1) {
         this.animationSequence = NPC.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1775511925"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.startHeight * var5 / var9;
         this.y = (double)this.y1 + var7 * (double)this.startHeight / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityY * this.velocityY + this.velocityX * this.velocityX);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - this.velocityZ * var5) / (var5 * var5);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "16256"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * (double)var1 * 0.5D * this.heightOffset + (double)var1 * this.velocityZ;
      this.velocityZ += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLengths[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLengths[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   protected final Model getModel() {
      Spotanim var1 = WidgetNode.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }
}
