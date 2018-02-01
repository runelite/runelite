import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1576911331
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -457745123
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1947095667
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1340050615
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 311139067
   )
   @Export("height")
   int height;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -541020193
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 163260799
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1371338451
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1130892069
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1491332981
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1941728137
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("x")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("q")
   @Export("x")
   double x;
   @ObfuscatedName("v")
   @Export("y")
   double y;
   @ObfuscatedName("n")
   @Export("z")
   double z;
   @ObfuscatedName("y")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("d")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("l")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("f")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("k")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 265069775
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1109372395
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1612697559
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -548242029
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
      int var12 = GrandExchangeEvents.getSpotAnimType(this.id).field3395;
      if(var12 != -1) {
         this.animationSequence = CacheFile.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1797761383"
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
      this.scalar = Math.sqrt(this.velocityY * this.velocityY + this.velocityX * this.velocityX);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityZ) / (var5 * var5);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1992456317"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += this.velocityY * (double)var1;
      this.z += (double)var1 * (double)var1 * 0.5D * this.heightOffset + (double)var1 * this.velocityZ;
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   protected final Model getModel() {
      Spotanim var1 = GrandExchangeEvents.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1116857099"
   )
   static void method1916() {
      if(Client.spellSelected) {
         Widget var0 = class31.getWidgetChild(class35.field464, Client.field963);
         if(var0 != null && var0.field2830 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2830;
            class87.method1851(var1);
         }

         Client.spellSelected = false;
         class60.method1015(var0);
      }
   }
}
