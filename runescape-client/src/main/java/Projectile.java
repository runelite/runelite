import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1333934925
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1619932681
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1438528669
   )
   int field853;
   @ObfuscatedName("w")
   @Export("z")
   double z;
   @ObfuscatedName("p")
   double field855;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 210052677
   )
   int field856;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1531555625
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("j")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1492939355
   )
   int field859;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1043773017
   )
   @Export("start")
   int start;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1361471741
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("n")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("m")
   @Export("x")
   double x;
   @ObfuscatedName("q")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1364514733
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -537469845
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("i")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("z")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("e")
   @Export("az")
   double az;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 581494449
   )
   int field871;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -41058917
   )
   int field872;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 235064711
   )
   int field873 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1199334297
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1987175071
   )
   int field875 = 0;
   @ObfuscatedName("rm")
   protected static String field877;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "345452940"
   )
   public static void method756() {
      try {
         class104.field1688.method1362();

         for(int var0 = 0; var0 < class107.field1728; ++var0) {
            FaceNormal.field1560[var0].method1362();
         }

         class104.field1682.method1362();
         class104.field1684.method1362();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("s")
   public static final void method757(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            Friend.method151(var0 - 1L);
            Friend.method151(1L);
         } else {
            Friend.method151(var0);
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-931774484"
   )
   final void method758(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field855;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * 0.5D * this.az * (double)var1 + this.velocityX * (double)var1;
      this.velocityX += this.az * (double)var1;
      this.field871 = (int)(Math.atan2(this.field855, this.scalar) * 325.949D) + 1024 & 2047;
      this.field853 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field875 += var1;

         while(true) {
            do {
               do {
                  if(this.field875 <= this.animationSequence.frameLenghts[this.field873]) {
                     return;
                  }

                  this.field875 -= this.animationSequence.frameLenghts[this.field873];
                  ++this.field873;
               } while(this.field873 < this.animationSequence.frameIDs.length);

               this.field873 -= this.animationSequence.frameStep;
            } while(this.field873 >= 0 && this.field873 < this.animationSequence.frameIDs.length);

            this.field873 = 0;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-87"
   )
   final void method759(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = var7 * (double)this.start / var9 + (double)this.y1;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field872 + 1 - var4);
      this.field855 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field855 * this.field855 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field859 * 0.02454369D);
      }

      this.az = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field872 = var7;
      this.field859 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field856 = var11;
      this.isMoving = false;
      int var12 = class48.method844(this.id).field2801;
      if(var12 != -1) {
         this.animationSequence = class110.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "32"
   )
   public static int method763(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      class190 var1 = class48.method844(this.id);
      Model var2 = var1.method3353(this.field873);
      if(null == var2) {
         return null;
      } else {
         var2.method1531(this.field853);
         return var2;
      }
   }
}
