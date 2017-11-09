import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1925541385
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1654916001
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1939866175
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1408473039
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 193258677
   )
   @Export("height")
   int height;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 143988245
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1939925167
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2132663715
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1823724001
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1341585345
   )
   @Export("start")
   int start;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1854641947
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("a")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("y")
   @Export("x")
   double x;
   @ObfuscatedName("w")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("k")
   @Export("z")
   double z;
   @ObfuscatedName("t")
   double field1370;
   @ObfuscatedName("h")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("u")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("r")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("g")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1850496665
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -794608333
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1252737865
   )
   int field1385;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1100779017
   )
   int field1394;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1385 = 0;
      this.field1394 = 0;
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
      int var12 = class285.getSpotAnimType(this.id).field3386;
      if(var12 != -1) {
         this.animationSequence = ItemLayer.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "182301144"
   )
   final void method1839(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1370 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1370 * this.field1370 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-160642639"
   )
   final void method1836(int var1) {
      this.isMoving = true;
      this.x += this.field1370 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + 0.5D * this.heightOffset * (double)var1 * (double)var1;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1370, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1394 += var1;

         while(true) {
            do {
               do {
                  if(this.field1394 <= this.animationSequence.frameLenghts[this.field1385]) {
                     return;
                  }

                  this.field1394 -= this.animationSequence.frameLenghts[this.field1385];
                  ++this.field1385;
               } while(this.field1385 < this.animationSequence.frameIDs.length);

               this.field1385 -= this.animationSequence.frameStep;
            } while(this.field1385 >= 0 && this.field1385 < this.animationSequence.frameIDs.length);

            this.field1385 = 0;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   protected final Model getModel() {
      Spotanim var1 = class285.getSpotAnimType(this.id);
      Model var2 = var1.method4520(this.field1385);
      if(var2 == null) {
         return null;
      } else {
         var2.method2626(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-735247921"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }
}
