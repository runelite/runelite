import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1402804307
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -360113143
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1068596879
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("i")
   @Export("x")
   double x;
   @ObfuscatedName("f")
   double field1460;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -549886331
   )
   int field1448;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -408005845
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2118679937
   )
   int field1459;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -482278743
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("u")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("j")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 99771829
   )
   @Export("start")
   int start;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 72243705
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @Export("z")
   double z;
   @ObfuscatedName("h")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("c")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1828248489
   )
   @Export("height")
   int height;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -668549961
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("x")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -657718193
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 476541207
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -847557963
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1471085337
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljl;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1448 = 0;
      this.field1459 = 0;
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
      int var12 = class155.getSpotAnimType(this.id).field3326;
      if(var12 != -1) {
         this.animationSequence = class204.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Leb;",
      garbageValue = "1172124455"
   )
   protected final Model getModel() {
      Spotanim var1 = class155.getSpotAnimType(this.id);
      Model var2 = var1.method4436(this.field1448);
      if(var2 == null) {
         return null;
      } else {
         var2.method2633(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "605217534"
   )
   final void method1818(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1460;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.heightOffset * 0.5D * (double)var1 * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.heightOffset;
      this.rotationX = (int)(Math.atan2(this.field1460, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1459 += var1;

         while(true) {
            do {
               do {
                  if(this.field1459 <= this.animationSequence.frameLenghts[this.field1448]) {
                     return;
                  }

                  this.field1459 -= this.animationSequence.frameLenghts[this.field1448];
                  ++this.field1448;
               } while(this.field1448 < this.animationSequence.frameIDs.length);

               this.field1448 -= this.animationSequence.frameStep;
            } while(this.field1448 >= 0 && this.field1448 < this.animationSequence.frameIDs.length);

            this.field1448 = 0;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2024556585"
   )
   final void method1817(int var1, int var2, int var3, int var4) {
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
      this.field1460 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1460 * this.field1460);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan(0.02454369D * (double)this.slope);
      }

      this.heightOffset = ((double)var3 - this.z - this.velocityX * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-211727128"
   )
   public static int method1828(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-439727079"
   )
   public static boolean method1823() {
      ClassInfo var0 = (ClassInfo)class281.field3766.method3664();
      return var0 != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)V",
      garbageValue = "-609217072"
   )
   public static void method1826(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.field3555 = var0;
      NPCComposition.field3554 = var1;
   }
}
