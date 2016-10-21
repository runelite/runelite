import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1190765247
   )
   int field99;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1899461301
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2062674985
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -781852185
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 729902333
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2144154309
   )
   int field104;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -711770709
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1593955769
   )
   int field106;
   @ObfuscatedName("h")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1854705511
   )
   @Export("start")
   int start;
   @ObfuscatedName("p")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("i")
   @Export("x")
   double x;
   @ObfuscatedName("u")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("x")
   @Export("z")
   double z;
   @ObfuscatedName("d")
   double field114;
   @ObfuscatedName("o")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("j")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("q")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("r")
   @Export("az")
   double az;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 410224449
   )
   int field119;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 924769437
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1805836509
   )
   int field122 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -133172441
   )
   int field123 = 0;
   @ObfuscatedName("gw")
   static Widget field124;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -189825413
   )
   protected static int field125;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 424380451
   )
   @Export("id")
   int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1057236995
   )
   int field127;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field106 = var7;
      this.field127 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field104 = var11;
      this.isMoving = false;
      int var12 = GameEngine.method3084(this.id).field1023;
      if(var12 != -1) {
         this.animationSequence = class62.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-15216"
   )
   final void method82(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(1 + this.field106 - var4);
      this.field114 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field114 * this.field114 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field127 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      class45 var1 = GameEngine.method3084(this.id);
      Model var2 = var1.method921(this.field122);
      if(null == var2) {
         return null;
      } else {
         var2.method2336(this.field99);
         return var2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-116"
   )
   final void method88(int var1) {
      this.isMoving = true;
      this.x += this.field114 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += (double)var1 * this.az * 0.5D * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += this.az * (double)var1;
      this.field119 = (int)(Math.atan2(this.field114, this.scalar) * 325.949D) + 1024 & 2047;
      this.field99 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field123 += var1;

         while(true) {
            do {
               do {
                  if(this.field123 <= this.animationSequence.field994[this.field122]) {
                     return;
                  }

                  this.field123 -= this.animationSequence.field994[this.field122];
                  ++this.field122;
               } while(this.field122 < this.animationSequence.field992.length);

               this.field122 -= this.animationSequence.field996;
            } while(this.field122 >= 0 && this.field122 < this.animationSequence.field992.length);

            this.field122 = 0;
         }
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1260854672"
   )
   static final void method89(int var0, int var1) {
      int var2 = class79.field1434.method4091("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class79.field1434.method4091(class1.method4(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var2 + var4 > class153.field2296) {
         var4 = class153.field2296 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class93.field1616) {
         var5 = class93.field1616 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      class133.menuX = var4;
      class0.menuY = var5;
      class107.menuWidth = var2;
      class85.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-57"
   )
   public static int method90(int var0) {
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

      return var1 + var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1193617934"
   )
   static final void method91(class69 var0) {
      var0.field1313 = false;
      if(null != var0.field1312) {
         var0.field1312.field1309 = 0;
      }

      for(class69 var1 = var0.vmethod3776(); var1 != null; var1 = var0.vmethod3777()) {
         method91(var1);
      }

   }
}
