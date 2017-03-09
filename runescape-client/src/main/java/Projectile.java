import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2139415793
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -974258615
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("q")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -822122515
   )
   int field887;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1976191119
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 228531551
   )
   int field889 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1921947803
   )
   int field890;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1856124875
   )
   int field891;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1545238857
   )
   @Export("start")
   int start;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1889765937
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 616122905
   )
   int field894;
   @ObfuscatedName("f")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("l")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1437183093
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("r")
   double field898;
   @ObfuscatedName("m")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -774301671
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @Export("z")
   double z;
   @ObfuscatedName("b")
   @Export("az")
   double az;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1144170295
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1281186877
   )
   int field904;
   @ObfuscatedName("p")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -357751917
   )
   int field906 = 0;
   @ObfuscatedName("i")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("v")
   @Export("x")
   double x;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1620387311"
   )
   final void method861(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field898;
      this.velocityZ += this.scalar * (double)var1;
      this.z += 0.5D * this.az * (double)var1 * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.az;
      this.field887 = (int)(Math.atan2(this.field898, this.scalar) * 325.949D) + 1024 & 2047;
      this.field904 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field889 += var1;

         while(true) {
            do {
               do {
                  if(this.field889 <= this.animationSequence.frameLenghts[this.field906]) {
                     return;
                  }

                  this.field889 -= this.animationSequence.frameLenghts[this.field906];
                  ++this.field906;
               } while(this.field906 < this.animationSequence.frameIDs.length);

               this.field906 -= this.animationSequence.frameStep;
            } while(this.field906 >= 0 && this.field906 < this.animationSequence.frameIDs.length);

            this.field906 = 0;
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
      this.field890 = var7;
      this.field891 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field894 = var11;
      this.isMoving = false;
      int var12 = Widget.method3245(this.id).field2792;
      if(var12 != -1) {
         this.animationSequence = class168.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1068336473"
   )
   final void method862(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.x1 + (double)this.start * var5 / var9;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field890 + 1 - var4);
      this.field898 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field898 * this.field898);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.field891);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      Spotanim var1 = Widget.method3245(this.id);
      Model var2 = var1.method3474(this.field906);
      if(null == var2) {
         return null;
      } else {
         var2.method1626(this.field904);
         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1979042051"
   )
   public static void method872() {
      while(true) {
         Deque var1 = class183.field2719;
         class180 var0;
         synchronized(class183.field2719) {
            var0 = (class180)class183.field2717.method2446();
         }

         if(null == var0) {
            return;
         }

         var0.field2685.method3405(var0.field2683, (int)var0.hash, var0.field2681, false);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1389851074"
   )
   public static boolean method873(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
