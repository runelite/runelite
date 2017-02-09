import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("t")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("i")
   @Export("x")
   double x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 23308559
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1096238939
   )
   int field861;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 99525869
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1097925057
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1627913357
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1885520525
   )
   int field865;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1492404913
   )
   int field866;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 344425447
   )
   @Export("start")
   int start;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 91460419
   )
   int field868;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1559954449
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2011135763
   )
   int field870;
   @ObfuscatedName("v")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("a")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   double field873;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1090647699
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("p")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("f")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("z")
   @Export("az")
   double az;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1100701105
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("g")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("m")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -793032181
   )
   int field881 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1976355745
   )
   int field882 = 0;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field865 = var7;
      this.field866 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field870 = var11;
      this.isMoving = false;
      int var12 = XItemContainer.method187(this.id).field2778;
      if(var12 != -1) {
         this.animationSequence = TextureProvider.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1514167547"
   )
   final void method799(int var1) {
      this.isMoving = true;
      this.x += this.field873 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + 0.5D * this.az * (double)var1 * (double)var1;
      this.velocityX += (double)var1 * this.az;
      this.field868 = (int)(Math.atan2(this.field873, this.scalar) * 325.949D) + 1024 & 2047;
      this.field861 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field882 += var1;

         while(true) {
            do {
               do {
                  if(this.field882 <= this.animationSequence.frameLenghts[this.field881]) {
                     return;
                  }

                  this.field882 -= this.animationSequence.frameLenghts[this.field881];
                  ++this.field881;
               } while(this.field881 < this.animationSequence.frameIDs.length);

               this.field881 -= this.animationSequence.frameStep;
            } while(this.field881 >= 0 && this.field881 < this.animationSequence.frameIDs.length);

            this.field881 = 0;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      Spotanim var1 = XItemContainer.method187(this.id);
      Model var2 = var1.method3458(this.field881);
      if(null == var2) {
         return null;
      } else {
         var2.method1577(this.field861);
         return var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-22"
   )
   static final int method803(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-33"
   )
   final void method809(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + var5 * (double)this.start / var9;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field865 - var4);
      this.field873 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field873 * this.field873 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field866 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }
}
