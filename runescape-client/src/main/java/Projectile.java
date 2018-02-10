import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -30234031
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -955439205
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 422799389
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1044833441
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1902036031
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1663431895
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 724017815
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1297832527
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1769762109
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -223044381
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1623181563
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("l")
   @Export("x")
   double x;
   @ObfuscatedName("f")
   @Export("y")
   double y;
   @ObfuscatedName("q")
   @Export("z")
   double z;
   @ObfuscatedName("r")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("x")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("u")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("b")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("p")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1805145307
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2082851155
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 64091035
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 973766365
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
      int var12 = CollisionData.getSpotAnimType(this.id).field3404;
      if(var12 != -1) {
         this.animationSequence = FileRequest.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1602937388"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.startHeight / var9 + (double)this.x1;
         this.y = (double)this.startHeight * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityX * this.velocityX + this.velocityY * this.velocityY);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - var5 * this.velocityZ) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "20"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += this.velocityX * (double)var1;
      this.y += (double)var1 * this.velocityY;
      this.z += this.velocityZ * (double)var1 + (double)var1 * this.heightOffset * 0.5D * (double)var1;
      this.velocityZ += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLenghts[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLenghts[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Les;",
      garbageValue = "-25440425"
   )
   protected final Model getModel() {
      Spotanim var1 = CollisionData.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lge;II)Lge;",
      garbageValue = "294807194"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZS)I",
      garbageValue = "-32055"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1685476825"
   )
   static void method1943(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1943(var0, var1, var2, var5 - 1);
         method1943(var0, var1, var5 + 1, var3);
      }

   }
}
