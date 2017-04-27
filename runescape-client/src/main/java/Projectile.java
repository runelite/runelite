import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 954403915
   )
   @Export("start")
   int start;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1074598025
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1517408139
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("s")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 429619863
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 450126803
   )
   int field852;
   @ObfuscatedName("k")
   @Export("z")
   double z;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1541271271
   )
   int field854;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 743427941
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("i")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -889539439
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("w")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -534615289
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @Export("az")
   double az;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1936932509
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1127639645
   )
   int field862;
   @ObfuscatedName("a")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("r")
   @Export("x")
   double x;
   @ObfuscatedName("f")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("j")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1777091223
   )
   int field867;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1048626895
   )
   int field868;
   @ObfuscatedName("e")
   double field869;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1296823433
   )
   int field870 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1353304391
   )
   int field871 = 0;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = 1311412687536399997L
   )
   static long field872;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1046707191"
   )
   final void method810(int var1) {
      this.isMoving = true;
      this.x += this.field869 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * this.velocityX + (double)var1 * 0.5D * this.az * (double)var1;
      this.velocityX += (double)var1 * this.az;
      this.field867 = (int)(Math.atan2(this.field869, this.scalar) * 325.949D) + 1024 & 2047;
      this.field868 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field871 += var1;

         while(true) {
            do {
               do {
                  if(this.field871 <= this.animationSequence.frameLenghts[this.field870]) {
                     return;
                  }

                  this.field871 -= this.animationSequence.frameLenghts[this.field870];
                  ++this.field870;
               } while(this.field870 < this.animationSequence.frameIDs.length);

               this.field870 -= this.animationSequence.frameStep;
            } while(this.field870 >= 0 && this.field870 < this.animationSequence.frameIDs.length);

            this.field870 = 0;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      Spotanim var1 = class190.method3462(this.id);
      Model var2 = var1.method3478(this.field870);
      if(var2 == null) {
         return null;
      } else {
         var2.method1581(this.field868);
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
      this.field862 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field852 = var11;
      this.isMoving = false;
      int var12 = class190.method3462(this.id).field2811;
      if(var12 != -1) {
         this.animationSequence = NPCComposition.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILclass119;LCollisionData;I)Z",
      garbageValue = "65536"
   )
   public static final boolean method813(int var0, int var1, class119 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class118.field1845[var6][var7] = 99;
      class118.field1843[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class118.field1846[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class118.field1847[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class118.field1846[var11];
         var5 = class118.field1847[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod2294(2, var4, var5, var3)) {
            class118.field1844 = var4;
            class118.field1842 = var5;
            return true;
         }

         int var15 = class118.field1843[var16][var17] + 1;
         if(var16 > 0 && class118.field1845[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17] = 2;
            class118.field1843[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class118.field1845[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17] = 8;
            class118.field1843[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class118.field1845[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class118.field1846[var18] = var4;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16][var17 - 1] = 1;
            class118.field1843[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class118.field1845[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class118.field1846[var18] = var4;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16][var17 + 1] = 4;
            class118.field1843[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class118.field1845[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17 - 1] = 3;
            class118.field1843[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class118.field1845[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17 - 1] = 9;
            class118.field1843[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class118.field1845[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class118.field1846[var18] = var4 - 1;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 - 1][var17 + 1] = 6;
            class118.field1843[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class118.field1845[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class118.field1846[var18] = var4 + 1;
            class118.field1847[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class118.field1845[var16 + 1][var17 + 1] = 12;
            class118.field1843[var16 + 1][var17 + 1] = var15;
         }
      }

      class118.field1844 = var4;
      class118.field1842 = var5;
      return false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "1844997219"
   )
   public static void method817(Applet var0, String var1) {
      class114.field1793 = var0;
      class114.field1788 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "835220841"
   )
   final void method818(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field854 + 1 - var4);
      this.field869 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field869 * this.field869);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field862 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }
}
