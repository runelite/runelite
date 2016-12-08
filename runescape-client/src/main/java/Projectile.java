import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1957621309
   )
   int field862 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2046741383
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -228037813
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 690118413
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 137658045
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 493474617
   )
   int field867;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1381390325
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -823279867
   )
   int field869;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1358721749
   )
   int field870;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1152400689
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("y")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("j")
   @Export("x")
   double x;
   @ObfuscatedName("f")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1321035255
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("i")
   double field877;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1735476251
   )
   int field878;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 441561327
   )
   int field879 = 0;
   @ObfuscatedName("d")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("s")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1579512553
   )
   int field882;
   @ObfuscatedName("p")
   @Export("z")
   double z;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1260598543
   )
   @Export("start")
   int start;
   @ObfuscatedName("t")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("w")
   @Export("az")
   double az;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1237335585
   )
   static int field887;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-502786128"
   )
   static final void method765(int var0, int var1) {
      int var2 = Ignore.field218.method3774("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class208 var4 = Ignore.field218;
         String var8;
         if(Client.menuTargets[var3].length() > 0) {
            var8 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var8 = Client.menuOptions[var3];
         }

         int var6 = var4.method3774(var8);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var7 = var0 - var2 / 2;
      if(var7 + var2 > TextureProvider.field1200) {
         var7 = TextureProvider.field1200 - var2;
      }

      if(var7 < 0) {
         var7 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class94.field1584) {
         var5 = class94.field1584 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      GameObject.menuX = var7;
      class109.menuY = var5;
      class3.menuWidth = var2;
      class30.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-21351771"
   )
   final void method766(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field869 - var4);
      this.field877 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field877 * this.field877);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field870 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2012894523"
   )
   final void method767(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field877;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * (double)var1 * this.az * 0.5D + this.velocityX * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field882 = (int)(Math.atan2(this.field877, this.scalar) * 325.949D) + 1024 & 2047;
      this.field878 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field862 += var1;

         while(true) {
            do {
               do {
                  if(this.field862 <= this.animationSequence.frameLenghts[this.field879]) {
                     return;
                  }

                  this.field862 -= this.animationSequence.frameLenghts[this.field879];
                  ++this.field879;
               } while(this.field879 < this.animationSequence.frameIDs.length);

               this.field879 -= this.animationSequence.frameStep;
            } while(this.field879 >= 0 && this.field879 < this.animationSequence.frameIDs.length);

            this.field879 = 0;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      class190 var1 = NPCComposition.method3645(this.id);
      Model var2 = var1.method3387(this.field879);
      if(null == var2) {
         return null;
      } else {
         var2.method1542(this.field878);
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIZIZS)V",
      garbageValue = "-7188"
   )
   static void method772(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class143.method2643(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method772(var0, var7 - 1, var2, var3, var4, var5);
         method772(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "92"
   )
   static String method775(int var0) {
      return Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "623263307"
   )
   public static final boolean method776(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1855[var6][var7] = 99;
      class118.field1856[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1853[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1859[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class118.field1853[var11];
         var5 = class118.field1859[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2239(2, var4, var5, var3)) {
            class118.field1863 = var4;
            class168.field2197 = var5;
            return true;
         }

         int var15 = class118.field1856[var16][var17] + 1;
         if(var16 > 0 && class118.field1855[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][1 + var14] & 19136824) == 0) {
            class118.field1853[var18] = var4 - 1;
            class118.field1859[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1855[var16 - 1][var17] = 2;
            class118.field1856[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class118.field1855[1 + var16][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[2 + var13][var14 + 1] & 19136992) == 0) {
            class118.field1853[var18] = var4 + 1;
            class118.field1859[var18] = var5;
            var18 = 1 + var18 & 4095;
            class118.field1855[var16 + 1][var17] = 8;
            class118.field1856[1 + var16][var17] = var15;
         }

         if(var17 > 0 && class118.field1855[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class118.field1853[var18] = var4;
            class118.field1859[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1855[var16][var17 - 1] = 1;
            class118.field1856[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class118.field1855[var16][var17 + 1] == 0 && (var12[var13][2 + var14] & 19136824) == 0 && (var12[1 + var13][2 + var14] & 19136992) == 0) {
            class118.field1853[var18] = var4;
            class118.field1859[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class118.field1855[var16][1 + var17] = 4;
            class118.field1856[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1855[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class118.field1853[var18] = var4 - 1;
            class118.field1859[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1855[var16 - 1][var17 - 1] = 3;
            class118.field1856[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class118.field1855[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class118.field1853[var18] = 1 + var4;
            class118.field1859[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class118.field1855[var16 + 1][var17 - 1] = 9;
            class118.field1856[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class118.field1855[var16 - 1][1 + var17] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class118.field1853[var18] = var4 - 1;
            class118.field1859[var18] = var5 + 1;
            var18 = 1 + var18 & 4095;
            class118.field1855[var16 - 1][1 + var17] = 6;
            class118.field1856[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class118.field1855[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][2 + var14] & 19137016) == 0 && (var12[2 + var13][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][1 + var14] & 19136995) == 0) {
            class118.field1853[var18] = 1 + var4;
            class118.field1859[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1855[var16 + 1][1 + var17] = 12;
            class118.field1856[var16 + 1][var17 + 1] = var15;
         }
      }

      class118.field1863 = var4;
      class168.field2197 = var5;
      return false;
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field869 = var7;
      this.field870 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field867 = var11;
      this.isMoving = false;
      int var12 = NPCComposition.method3645(this.id).field2803;
      if(var12 != -1) {
         this.animationSequence = class31.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }
}
