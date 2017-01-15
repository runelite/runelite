import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1531169681
   )
   int field847;
   @ObfuscatedName("m")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1287704199
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -774106607
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1284307601
   )
   int field852 = 0;
   @ObfuscatedName("e")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -994137461
   )
   int field854;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1941717231
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -83736015
   )
   @Export("start")
   int start;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 657163077
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -90085581
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("q")
   @Export("x")
   double x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1655918375
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("v")
   @Export("z")
   double z;
   @ObfuscatedName("j")
   @Export("velocityX")
   double field862;
   @ObfuscatedName("p")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("r")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("y")
   @Export("az")
   double az;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -187028555
   )
   int field867;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1662505267
   )
   int field868;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1599335899
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -695469803
   )
   int field871 = 0;
   @ObfuscatedName("pk")
   static short[] field874;
   @ObfuscatedName("w")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1221865571
   )
   int field876;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-113"
   )
   final void method775(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field854 - var4);
      this.field862 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field862 * this.field862);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field847 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1736642287"
   )
   final void method776(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field862;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * 0.5D * this.az * (double)var1 + this.velocityX * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field867 = (int)(Math.atan2(this.field862, this.scalar) * 325.949D) + 1024 & 2047;
      this.field868 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field871 += var1;

         while(true) {
            do {
               do {
                  if(this.field871 <= this.animationSequence.frameLenghts[this.field852]) {
                     return;
                  }

                  this.field871 -= this.animationSequence.frameLenghts[this.field852];
                  ++this.field852;
               } while(this.field852 < this.animationSequence.frameIDs.length);

               this.field852 -= this.animationSequence.frameStep;
            } while(this.field852 >= 0 && this.field852 < this.animationSequence.frameIDs.length);

            this.field852 = 0;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      class190 var1 = class185.method3389(this.id);
      Model var2 = var1.method3446(this.field852);
      if(null == var2) {
         return null;
      } else {
         var2.method1528(this.field868);
         return var2;
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field854 = var7;
      this.field847 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field876 = var11;
      this.isMoving = false;
      int var12 = class185.method3389(this.id).field2772;
      if(var12 != -1) {
         this.animationSequence = CombatInfo2.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }
}
