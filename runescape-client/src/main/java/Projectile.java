import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1593576209
   )
   int field864;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1156600217
   )
   int field865;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1663870695
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 164250037
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("p")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1455241233
   )
   int field869;
   @ObfuscatedName("d")
   @Export("az")
   double az;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1975219241
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1658029689
   )
   int field872;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -544208455
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 457347285
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("l")
   @Export("x")
   double x;
   @ObfuscatedName("j")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("c")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2053808501
   )
   int field878;
   @ObfuscatedName("r")
   double field879;
   @ObfuscatedName("u")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1071735405
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("x")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("m")
   @Export("z")
   double z;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 565436717
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1825650351
   )
   @Export("start")
   int start;
   @ObfuscatedName("t")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1647657497
   )
   int field887 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1735690459
   )
   int field888 = 0;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      class190 var1 = Ignore.method193(this.id);
      Model var2 = var1.method3414(this.field887);
      if(var2 == null) {
         return null;
      } else {
         var2.method1553(this.field878);
         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1132491354"
   )
   final void method765(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field865 + 1 - var4);
      this.field879 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field879 * this.field879);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field872);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1694875113"
   )
   final void method766(int var1) {
      this.isMoving = true;
      this.x += this.field879 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += this.velocityX * (double)var1 + this.az * 0.5D * (double)var1 * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field864 = (int)(Math.atan2(this.field879, this.scalar) * 325.949D) + 1024 & 2047;
      this.field878 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field888 += var1;

         while(true) {
            do {
               do {
                  if(this.field888 <= this.animationSequence.frameLenghts[this.field887]) {
                     return;
                  }

                  this.field888 -= this.animationSequence.frameLenghts[this.field887];
                  ++this.field887;
               } while(this.field887 < this.animationSequence.frameIDs.length);

               this.field887 -= this.animationSequence.frameStep;
            } while(this.field887 >= 0 && this.field887 < this.animationSequence.frameIDs.length);

            this.field887 = 0;
         }
      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field865 = var7;
      this.field872 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field869 = var11;
      this.isMoving = false;
      int var12 = Ignore.method193(this.id).field2797;
      if(var12 != -1) {
         this.animationSequence = GameEngine.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }
}
