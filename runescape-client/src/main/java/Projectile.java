import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1417970667
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -671188891
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1044215599
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 12615359
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1757081889
   )
   @Export("height")
   int height;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2135214987
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -505807597
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1038255533
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1672859719
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1191235675
   )
   @Export("start")
   int start;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1886408397
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("a")
   @Export("xPos")
   double x;
   @ObfuscatedName("q")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("j")
   @Export("zPos")
   double z;
   @ObfuscatedName("m")
   double field1380;
   @ObfuscatedName("h")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("c")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("y")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("p")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -952532987
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1820396211
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1569547373
   )
   int field1388;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -661176939
   )
   int field1389;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1388 = 0;
      this.field1389 = 0;
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
      int var12 = class245.getSpotAnimType(this.id).field3387;
      if(var12 != -1) {
         this.animationSequence = class90.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "22"
   )
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1380 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1380 * this.field1380 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1382275676"
   )
   final void method1739(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1380;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.heightOffset * 0.5D * (double)var1 * (double)var1 + this.velocityX * (double)var1;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1380, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1389 += var1;

         while(true) {
            do {
               do {
                  if(this.field1389 <= this.animationSequence.frameLenghts[this.field1388]) {
                     return;
                  }

                  this.field1389 -= this.animationSequence.frameLenghts[this.field1388];
                  ++this.field1388;
               } while(this.field1388 < this.animationSequence.frameIDs.length);

               this.field1388 -= this.animationSequence.frameStep;
            } while(this.field1388 >= 0 && this.field1388 < this.animationSequence.frameIDs.length);

            this.field1388 = 0;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   protected final Model getModel() {
      Spotanim var1 = class245.getSpotAnimType(this.id);
      Model var2 = var1.method4321(this.field1388);
      if(var2 == null) {
         return null;
      } else {
         var2.method2521(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Liy;",
      garbageValue = "983077217"
   )
   public static BuildType method1741(int var0) {
      BuildType[] var1 = new BuildType[]{BuildType.BUILD_LIVE, BuildType.WIP, BuildType.LIVE, BuildType.RC};
      BuildType[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         BuildType var4 = var2[var3];
         if(var0 == var4.ordinal) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1543977319"
   )
   static final void method1737() {
      if(Client.field1081 != class28.plane) {
         Client.field1081 = class28.plane;
         int var0 = class28.plane;
         int[] var1 = GraphicsObject.field1280.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
                  Client.region.method2722(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
                  Client.region.method2722(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         GraphicsObject.field1280.method5168();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
                  class269.method4754(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
                  class269.method4754(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.field1075 = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               int var7 = Client.region.method2717(class28.plane, var5, var6);
               if(var7 != 0) {
                  var7 = var7 >> 14 & 32767;
                  int var8 = ClientPacket.getObjectDefinition(var7).mapIconId;
                  if(var8 >= 0) {
                     Client.mapIcons[Client.field1075] = Area.mapAreaType[var8].getMapIcon(false);
                     Client.field1060[Client.field1075] = var5;
                     Client.field891[Client.field1075] = var6;
                     ++Client.field1075;
                  }
               }
            }
         }

         class236.field3227.setRaster();
      }

   }
}
