import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("bt")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1439508269
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1158573529
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 991023063
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1119827965
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1573561567
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 605915465
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1272594263
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 920585167
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1384783005
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -990446129
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -63013963
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("c")
   @Export("x")
   double x;
   @ObfuscatedName("v")
   @Export("y")
   double y;
   @ObfuscatedName("u")
   @Export("z")
   double z;
   @ObfuscatedName("j")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("k")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("z")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("w")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("s")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -872780041
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1156315373
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -119124103
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -242547001
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
      int var12 = MapLabel.getSpotAnimType(this.id).field3494;
      if(var12 != -1) {
         this.animationSequence = class158.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "101"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.startHeight / var9 + (double)this.x1;
         this.y = var7 * (double)this.startHeight / var9 + (double)this.y1;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2145608755"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += (double)var1 * this.velocityY;
      this.z += 0.5D * this.heightOffset * (double)var1 * (double)var1 + this.velocityZ * (double)var1;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   protected final Model getModel() {
      Spotanim var1 = MapLabel.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public static boolean method1969(int var0) {
      return var0 >= WorldMapDecorationType.field3000.rsOrdinal && var0 <= WorldMapDecorationType.field2985.rsOrdinal;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "98"
   )
   static final void method1968(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class62.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var1][var3 + var2] = class62.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class62.tileHeights[var0][var3 + var1][var2] = class62.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class62.tileHeights[var0][var1 - 1][var2] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class62.tileHeights[var0][var1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class62.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class62.tileHeights[var0][var1][var2] = class62.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }
}
