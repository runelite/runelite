import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("o")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1729383583
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -483383559
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -259039691
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 442184935
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -412344075
   )
   int field1452;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1246154211
   )
   int field1453;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1929186067
   )
   int field1454;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -795804643
   )
   int field1455;
   @ObfuscatedName("s")
   @Export("az")
   double az;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 132704047
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("e")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -530892083
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("x")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1014864827
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   double field1462;
   @ObfuscatedName("m")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("d")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("b")
   @Export("x")
   double x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 291750247
   )
   @Export("start")
   int start;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2043091363
   )
   int field1468;
   @ObfuscatedName("w")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 681944853
   )
   int field1470;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1630799267
   )
   int field1471;
   @ObfuscatedName("r")
   @Export("isMoving")
   boolean isMoving;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-12047"
   )
   public static void method1781() {
      NPCComposition.field3544.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1979228761"
   )
   final void method1782(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field1454 + 1 - var4);
      this.field1462 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1462 * this.field1462 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field1455 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1453 = 0;
      this.field1471 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field1454 = var7;
      this.field1455 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field1452 = var11;
      this.isMoving = false;
      int var12 = class203.method3752(this.id).field3319;
      if(var12 != -1) {
         this.animationSequence = class165.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1208682604"
   )
   protected final Model getModel() {
      Spotanim var1 = class203.method3752(this.id);
      Model var2 = var1.method4407(this.field1453);
      if(var2 == null) {
         return null;
      } else {
         var2.method2549(this.field1468);
         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "28"
   )
   final void method1791(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1462;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * (double)var1 * this.az * 0.5D + (double)var1 * this.velocityX;
      this.velocityX += this.az * (double)var1;
      this.field1470 = (int)(Math.atan2(this.field1462, this.scalar) * 325.949D) + 1024 & 2047;
      this.field1468 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1471 += var1;

         while(true) {
            do {
               do {
                  if(this.field1471 <= this.animationSequence.frameLenghts[this.field1453]) {
                     return;
                  }

                  this.field1471 -= this.animationSequence.frameLenghts[this.field1453];
                  ++this.field1453;
               } while(this.field1453 < this.animationSequence.frameIDs.length);

               this.field1453 -= this.animationSequence.frameStep;
            } while(this.field1453 >= 0 && this.field1453 < this.animationSequence.frameIDs.length);

            this.field1453 = 0;
         }
      }
   }
}
