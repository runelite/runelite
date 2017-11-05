import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static Font field1477;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1678202477
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1050211361
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -982908351
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1674214801
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -525535745
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2115642663
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 638081473
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -568836761
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1598907541
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 343296353
   )
   @Export("start")
   int start;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1592107829
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("n")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("u")
   @Export("x")
   double x;
   @ObfuscatedName("t")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("a")
   @Export("z")
   double z;
   @ObfuscatedName("i")
   double field1472;
   @ObfuscatedName("h")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("b")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("j")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("y")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1742145553
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1959397141
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -470678751
   )
   int field1475;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1194250143
   )
   int field1474;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1475 = 0;
      this.field1474 = 0;
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
      int var12 = class244.getSpotAnimType(this.id).field3325;
      if(var12 != -1) {
         this.animationSequence = NPCComposition.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-254687675"
   )
   final void method1777(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1472 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1472 * this.field1472);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "7943"
   )
   final void method1778(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1472;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.velocityX * (double)var1 + (double)var1 * (double)var1 * 0.5D * this.heightOffset;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1472, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1474 += var1;

         while(true) {
            do {
               do {
                  if(this.field1474 <= this.animationSequence.frameLenghts[this.field1475]) {
                     return;
                  }

                  this.field1474 -= this.animationSequence.frameLenghts[this.field1475];
                  ++this.field1475;
               } while(this.field1475 < this.animationSequence.frameIDs.length);

               this.field1475 -= this.animationSequence.frameStep;
            } while(this.field1475 >= 0 && this.field1475 < this.animationSequence.frameIDs.length);

            this.field1475 = 0;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Leh;",
      garbageValue = "0"
   )
   protected final Model getModel() {
      Spotanim var1 = class244.getSpotAnimType(this.id);
      Model var2 = var1.method4404(this.field1475);
      if(var2 == null) {
         return null;
      } else {
         var2.method2582(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;III)[Ljo;",
      garbageValue = "-2121031601"
   )
   static IndexedSprite[] method1782(IndexDataBase var0, int var1, int var2) {
      if(!class261.method4822(var0, var1, var2)) {
         return null;
      } else {
         IndexedSprite[] var4 = new IndexedSprite[class287.field3805];

         for(int var5 = 0; var5 < class287.field3805; ++var5) {
            IndexedSprite var6 = var4[var5] = new IndexedSprite();
            var6.width = class287.field3809;
            var6.originalHeight = class287.field3807;
            var6.offsetX = class287.field3808[var5];
            var6.offsetY = class21.offsetsY[var5];
            var6.originalWidth = class287.field3806[var5];
            var6.height = class56.field700[var5];
            var6.palette = class114.field1675;
            var6.pixels = class227.spritePixels[var5];
         }

         class249.method4493();
         return var4;
      }
   }
}
