import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("dt")
   @Export("host")
   static String host;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -694715359
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -218460973
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 927536955
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 869766095
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -715790761
   )
   @Export("height")
   int height;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1196467841
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -20443961
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 728016351
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 356552955
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1949591217
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1821054993
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("a")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("w")
   @Export("x")
   double x;
   @ObfuscatedName("n")
   @Export("y")
   double y;
   @ObfuscatedName("l")
   @Export("z")
   double z;
   @ObfuscatedName("s")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("v")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("q")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("r")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("j")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -197184165
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 226844767
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 747017145
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -677208147
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
      int var12 = class86.getSpotAnimType(this.id).field3497;
      if(var12 != -1) {
         this.animationSequence = CombatInfo1.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
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
         this.y = (double)this.y1 + (double)this.startHeight * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityY * this.velocityY + this.velocityX * this.velocityX);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = ((double)var3 - this.z - var5 * this.velocityZ) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "37"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.velocityX;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * (double)var1 * this.heightOffset * 0.5D + this.velocityZ * (double)var1;
      this.velocityZ += this.heightOffset * (double)var1;
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   protected final Model getModel() {
      Spotanim var1 = class86.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1626830208"
   )
   static final void method1944(int var0) {
      class132.Viewport_entityIdsAtMouse[++class132.Viewport_entityCountAtMouse - 1] = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;Ljf;Ljf;B)V",
      garbageValue = "54"
   )
   public static void method1938(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      UrlRequest.widgetIndex = var0;
      Friend.field3864 = var1;
      Widget.field2815 = var2;
      DynamicObject.field1471 = var3;
      MouseRecorder.widgets = new Widget[UrlRequest.widgetIndex.size()][];
      class154.validInterfaces = new boolean[UrlRequest.widgetIndex.size()];
   }
}
