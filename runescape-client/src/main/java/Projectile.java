import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   static Task field1402;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1240281537
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1321171591
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 618916399
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1688211213
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1815078191
   )
   @Export("height")
   int height;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1791832385
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -380019885
   )
   @Export("startMovementCycle")
   int startMovementCycle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -642293845
   )
   @Export("endCycle")
   int endCycle;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 956359293
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1165447961
   )
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 361345737
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("a")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("e")
   @Export("x")
   double x;
   @ObfuscatedName("f")
   @Export("y")
   double y;
   @ObfuscatedName("l")
   @Export("z")
   double z;
   @ObfuscatedName("m")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("b")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("h")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("t")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("v")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 694303613
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 918511865
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1132435881
   )
   @Export("int7")
   int int7;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 508222089
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
      int var12 = class249.getSpotAnimType(this.id).field3494;
      if(var12 != -1) {
         this.animationSequence = ISAACCipher.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "21"
   )
   @Export("moveProjectile")
   @Hook("projectileMoved")
   final void moveProjectile(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.startHeight * var5 / var9 + (double)this.x1;
         this.y = (double)this.startHeight * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.endCycle + 1 - var4);
      this.velocityX = ((double)var1 - this.x) / var5;
      this.velocityY = ((double)var2 - this.y) / var5;
      this.scalar = Math.sqrt(this.velocityY * this.velocityY + this.velocityX * this.velocityX);
      if(!this.isMoving) {
         this.velocityZ = -this.scalar * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityZ * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1151361699"
   )
   @Export("update")
   final void update(int var1) {
      this.isMoving = true;
      this.x += this.velocityX * (double)var1;
      this.y += (double)var1 * this.velocityY;
      this.z += (double)var1 * this.velocityZ + this.heightOffset * 0.5D * (double)var1 * (double)var1;
      this.velocityZ += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityZ, this.scalar) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.int6 += var1;

         while(true) {
            do {
               do {
                  if(this.int6 <= this.animationSequence.frameLengths[this.int7]) {
                     return;
                  }

                  this.int6 -= this.animationSequence.frameLengths[this.int7];
                  ++this.int7;
               } while(this.int7 < this.animationSequence.frameIDs.length);

               this.int7 -= this.animationSequence.frameStep;
            } while(this.int7 >= 0 && this.int7 < this.animationSequence.frameIDs.length);

            this.int7 = 0;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   protected final Model getModel() {
      Spotanim var1 = class249.getSpotAnimType(this.id);
      Model var2 = var1.getModel(this.int7);
      if(var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)Lcx;",
      garbageValue = "40"
   )
   @Export("newScript")
   static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method2009(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(var8 > 0?WallObject.nextPowerOfTwo(var8):1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1368399566"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1420915019"
   )
   static final void method1921(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1106 - Client.field1105) * var5 / 100 + Client.field1105;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1111) {
         var15 = Client.field1111;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field881) {
            var6 = Client.field881;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1112) {
         var15 = Client.field1112;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field926) {
            var6 = Client.field926;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216);
               Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1108 - Client.field876) * var5 / 100 + Client.field876;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportWidth || var3 != Client.viewportHeight) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.buildVisibilityMaps(var14, 500, 800, var2, var3);
      }

      Client.Viewport_xOffset = var0;
      Client.Viewport_yOffset = var1;
      Client.viewportWidth = var2;
      Client.viewportHeight = var3;
   }
}
