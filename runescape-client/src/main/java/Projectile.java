import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("oy")
   @ObfuscatedGetter(
      intValue = -989801921
   )
   static int field1380;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 253222545
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1093934655
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 696136279
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 806338563
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1885188655
   )
   @Export("height")
   int height;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1369906141
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1550375669
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 632478681
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -45498235
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1841552807
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -820127231
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("c")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("s")
   @Export("x")
   double x;
   @ObfuscatedName("n")
   @Export("y")
   double y;
   @ObfuscatedName("y")
   @Export("z")
   double z;
   @ObfuscatedName("o")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("r")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("i")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("l")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("m")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -83233913
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -436430029
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -851439171
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 242707913
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
      int var12 = class250.getSpotAnimType(this.id).field3413;
      if(var12 != -1) {
         this.animationSequence = Permission.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-789078756"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + var5 * (double)this.startHeight / var9;
         this.y = (double)this.y1 + var7 * (double)this.startHeight / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - this.velocityZ * var5) / (var5 * var5);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1502627701"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += this.velocityX * (double)var1;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * this.velocityZ + this.heightOffset * 0.5D * (double)var1 * (double)var1;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   protected final Model getModel() {
      Spotanim var1 = class250.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "-1904400185"
   )
   static void method1736(Buffer var0, int var1) {
      byte[] var2 = var0.payload;
      if(Client.field1034 == null) {
         Client.field1034 = new byte[24];
      }

      class194.method3603(var2, var1, Client.field1034, 0, 24);
      class157.method3016(var0, var1);
   }
}
