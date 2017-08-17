import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("nt")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static class277 field1488;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -342947493
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 408146155
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -972585597
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("i")
   @Export("x")
   double x;
   @ObfuscatedName("e")
   double field1482;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1092119451
   )
   int field1467;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1414249725
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1435655149
   )
   int field1487;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -279315733
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("s")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("a")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -383937431
   )
   @Export("start")
   int start;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 220012145
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("r")
   @Export("z")
   double z;
   @ObfuscatedName("t")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("y")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1064381565
   )
   @Export("height")
   int height;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -517844985
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("v")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1902475437
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1157741107
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1685281693
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 11452685
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1467 = 0;
      this.field1487 = 0;
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
      int var12 = class36.getSpotAnimType(this.id).field3316;
      if(var12 != -1) {
         this.animationSequence = PendingSpawn.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   protected final Model getModel() {
      Spotanim var1 = class36.getSpotAnimType(this.id);
      Model var2 = var1.method4367(this.field1467);
      if(var2 == null) {
         return null;
      } else {
         var2.method2537(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1727449227"
   )
   final void method1769(int var1) {
      this.isMoving = true;
      this.x += this.field1482 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + (double)var1 * this.heightOffset * 0.5D * (double)var1;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1482, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1487 += var1;

         while(true) {
            do {
               do {
                  if(this.field1487 <= this.animationSequence.frameLenghts[this.field1467]) {
                     return;
                  }

                  this.field1487 -= this.animationSequence.frameLenghts[this.field1467];
                  ++this.field1467;
               } while(this.field1467 < this.animationSequence.frameIDs.length);

               this.field1467 -= this.animationSequence.frameStep;
            } while(this.field1467 >= 0 && this.field1467 < this.animationSequence.frameIDs.length);

            this.field1467 = 0;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-71"
   )
   final void method1768(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1482 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1482 * this.field1482 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;Ljava/lang/String;B)Ljr;",
      garbageValue = "-6"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!FileOnDisk.method2386(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite var7 = new IndexedSprite();
         var7.width = class287.field3779;
         var7.originalHeight = ISAACCipher.field2435;
         var7.offsetX = class287.field3781[0];
         var7.offsetY = class211.offsetsY[0];
         var7.originalWidth = class266.field3647[0];
         var7.height = class287.field3782[0];
         var7.palette = class287.field3783;
         var7.pixels = class274.spritePixels[0];
         class287.field3781 = null;
         class211.offsetsY = null;
         class266.field3647 = null;
         class287.field3782 = null;
         class287.field3783 = null;
         class274.spritePixels = null;
         var5 = var7;
      }

      return var5;
   }
}
