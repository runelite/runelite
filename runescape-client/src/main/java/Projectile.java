import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -951207149
   )
   @Export("start")
   int start;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1928765913
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -789799643
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -780733715
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1532456599
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1332682673
   )
   int field103;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -779210207
   )
   int field104 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1493603357
   )
   int field105;
   @ObfuscatedName("q")
   @Export("x")
   double x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -71273945
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -806964143
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("v")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("t")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1369090827
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1972841269
   )
   int field112 = 0;
   @ObfuscatedName("g")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("u")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("a")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("e")
   @Export("az")
   double az;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -520600391
   )
   int field118;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 686003265
   )
   int field119;
   @ObfuscatedName("y")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("s")
   double field121;
   @ObfuscatedName("dz")
   @Export("region")
   static Region region;
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = 1326977417
   )
   static int field123;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1387625619
   )
   int field124;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1482331734"
   )
   final void method101(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field105 - var4);
      this.field121 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field121 * this.field121 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field124 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "106"
   )
   final void method102(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field121;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.velocityX * (double)var1 + this.az * 0.5D * (double)var1 * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field118 = (int)(Math.atan2(this.field121, this.scalar) * 325.949D) + 1024 & 2047;
      this.field119 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field112 += var1;

         while(true) {
            do {
               do {
                  if(this.field112 <= this.animationSequence.field999[this.field104]) {
                     return;
                  }

                  this.field112 -= this.animationSequence.field999[this.field104];
                  ++this.field104;
               } while(this.field104 < this.animationSequence.field1001.length);

               this.field104 -= this.animationSequence.field1002;
            } while(this.field104 >= 0 && this.field104 < this.animationSequence.field1001.length);

            this.field104 = 0;
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
      this.field105 = var7;
      this.field124 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field103 = var11;
      this.isMoving = false;
      int var12 = Renderable.method1946(this.id).field1017;
      if(var12 != -1) {
         this.animationSequence = class113.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "-1120809307"
   )
   static final void method106(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method27();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var7 = ChatMessages.method243(var4, var5, var0.method27(), class51.method1054(var1, var2), Client.collisionMaps[var0.field47], true, Client.field506, Client.field561);
            if(var7 >= 1) {
               for(int var8 = 0; var8 < var7 - 1; ++var8) {
                  var0.method23(Client.field506[var8], Client.field561[var8], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   protected final Model getModel() {
      class45 var1 = Renderable.method1946(this.id);
      Model var2 = var1.method906(this.field104);
      if(var2 == null) {
         return null;
      } else {
         var2.method2372(this.field119);
         return var2;
      }
   }
}
