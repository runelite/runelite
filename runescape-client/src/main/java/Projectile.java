import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2043248991
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2124256245
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2107652749
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -907443465
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1488125527
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 108042257
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1138123993
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 735840465
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1250579769
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1696015263
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -975613781
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("d")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("s")
   @Export("x")
   double x;
   @ObfuscatedName("p")
   @Export("y")
   double y;
   @ObfuscatedName("g")
   @Export("z")
   double z;
   @ObfuscatedName("y")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("c")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("e")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("t")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("u")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1302634119
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -35397649
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1323424599
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1430258759
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
      int var12 = ScriptState.getSpotAnimType(this.id).field3292;
      if(var12 != -1) {
         this.animationSequence = class137.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1299764784"
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
         this.y = (double)this.y1 + (double)this.startHeight * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityZ) / (var5 * var5);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-30"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * (double)var1 * this.heightOffset * 0.5D + (double)var1 * this.velocityZ;
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   protected final Model getModel() {
      Spotanim var1 = ScriptState.getSpotAnimType(this.id);
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
      signature = "(II)I",
      garbageValue = "1530086257"
   )
   static int method1900(int var0) {
      MessageNode var1 = (MessageNode)class83.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class83.field1205.sentinel?-1:((MessageNode)var1.next).id);
   }
}
