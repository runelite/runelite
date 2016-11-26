import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1834976407
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 873101675
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -518344479
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1005765541
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 271621471
   )
   int field857;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1494892477
   )
   int field858;
   @ObfuscatedName("s")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1932745293
   )
   int field860;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1033216201
   )
   int field861;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 56742311
   )
   @Export("start")
   int start;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -948862619
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("l")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("y")
   @Export("x")
   double x;
   @ObfuscatedName("e")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 363285603
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("f")
   double field868;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1656103297
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("i")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1583494867
   )
   int field872 = 0;
   @ObfuscatedName("x")
   @Export("z")
   double z;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1426575027
   )
   int field874;
   @ObfuscatedName("k")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 512009185
   )
   int field876 = 0;
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -1618632517
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("md")
   static SpritePixels field879;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1089851115
   )
   static int field880;
   @ObfuscatedName("a")
   @Export("az")
   double az;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1816688148"
   )
   final void method808(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field860 - var4);
      this.field868 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field868 * this.field868);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field861);
      }

      this.az = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2097849187"
   )
   final void method809(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field868;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * (double)var1 * 0.5D * this.az + (double)var1 * this.velocityX;
      this.velocityX += this.az * (double)var1;
      this.field874 = (int)(Math.atan2(this.field868, this.scalar) * 325.949D) + 1024 & 2047;
      this.field857 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field872 += var1;

         while(true) {
            do {
               do {
                  if(this.field872 <= this.animationSequence.frameLenghts[this.field876]) {
                     return;
                  }

                  this.field872 -= this.animationSequence.frameLenghts[this.field876];
                  ++this.field876;
               } while(this.field876 < this.animationSequence.frameIDs.length);

               this.field876 -= this.animationSequence.frameStep;
            } while(this.field876 >= 0 && this.field876 < this.animationSequence.frameIDs.length);

            this.field876 = 0;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   protected final Model getModel() {
      class190 var1 = class179.method3320(this.id);
      Model var2 = var1.method3510(this.field876);
      if(null == var2) {
         return null;
      } else {
         var2.method1593(this.field857);
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
      this.field860 = var7;
      this.field861 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field858 = var11;
      this.isMoving = false;
      int var12 = class179.method3320(this.id).field2800;
      if(var12 != -1) {
         this.animationSequence = class9.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "-74"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method637() != Client.isMembers) {
         Client.isMembers = var0.method637();
         boolean var1 = var0.method637();
         if(var1 != ItemComposition.isMembersWorld) {
            ItemComposition.field2945.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            ItemComposition.isMembersWorld = var1;
         }
      }

      class18.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class20.field219 = Client.field443 == 0?'ꩊ':'鱀' + var0.id;
      class36.field770 = Client.field443 == 0?443:var0.id + '썐';
      class5.field55 = class20.field219;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1448512452"
   )
   static final int method818(int var0, int var1) {
      int var2 = class60.method1136(var0 - 1, var1 - 1) + class60.method1136(var0 + 1, var1 - 1) + class60.method1136(var0 - 1, 1 + var1) + class60.method1136(var0 + 1, 1 + var1);
      int var3 = class60.method1136(var0 - 1, var1) + class60.method1136(1 + var0, var1) + class60.method1136(var0, var1 - 1) + class60.method1136(var0, var1 + 1);
      int var4 = class60.method1136(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }
}
