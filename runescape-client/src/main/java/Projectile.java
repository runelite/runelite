import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1588740391
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 344021431
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 901788757
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -26954535
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -651578199
   )
   @Export("height")
   int height;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 887832503
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -24018513
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1927880301
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 537550653
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1523019535
   )
   @Export("start")
   int start;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -601507387
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("u")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("n")
   @Export("x")
   double x;
   @ObfuscatedName("c")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("y")
   @Export("z")
   double z;
   @ObfuscatedName("j")
   double field1392;
   @ObfuscatedName("f")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("s")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("e")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("q")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -16598293
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1297251865
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1103454887
   )
   int field1400;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -622916385
   )
   int field1384;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1400 = 0;
      this.field1384 = 0;
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
      int var12 = class227.getSpotAnimType(this.id).field3393;
      if(var12 != -1) {
         this.animationSequence = class13.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2020665162"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1392 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1392 * this.field1392);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "457742455"
   )
   final void method1817(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1392;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.velocityX * (double)var1 + (double)var1 * 0.5D * this.heightOffset * (double)var1;
      this.velocityX += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.field1392, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1384 += var1;

         while(true) {
            do {
               do {
                  if(this.field1384 <= this.animationSequence.frameLenghts[this.field1400]) {
                     return;
                  }

                  this.field1384 -= this.animationSequence.frameLenghts[this.field1400];
                  ++this.field1400;
               } while(this.field1400 < this.animationSequence.frameIDs.length);

               this.field1400 -= this.animationSequence.frameStep;
            } while(this.field1400 >= 0 && this.field1400 < this.animationSequence.frameIDs.length);

            this.field1400 = 0;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   protected final Model getModel() {
      Spotanim var1 = class227.getSpotAnimType(this.id);
      Model var2 = var1.method4494(this.field1400);
      if(var2 == null) {
         return null;
      } else {
         var2.method2633(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(IIIILky;Lhl;I)V",
      garbageValue = "655580114"
   )
   static final void method1825(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2683 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class3.mapedge.method5280(var15 + (var0 + var5.field2683 / 2 - var17 / 2), var5.field2682 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         ScriptState.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
