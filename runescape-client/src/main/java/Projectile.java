import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("v")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1287578977
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -979938673
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1302806347
   )
   int field1456;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 200158761
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1283959955
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("a")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2080507783
   )
   int field1460;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 559392947
   )
   int field1461;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -172562981
   )
   @Export("start")
   int start;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -476855323
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("x")
   @Export("x")
   double x;
   @ObfuscatedName("y")
   @Export("z")
   double z;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1390800789
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("s")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("r")
   double field1471;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1633541773
   )
   int field1472;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1574467381
   )
   int field1473;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1355988503
   )
   int field1474;
   @ObfuscatedName("q")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1959677931
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1246880499
   )
   int field1477;
   @ObfuscatedName("t")
   @Export("az")
   double az;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1726192196"
   )
   final void method1726(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = var5 * (double)this.start / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + (double)this.start * var7 / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field1460 + 1 - var4);
      this.field1471 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.scalar * this.scalar + this.field1471 * this.field1471);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field1461 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - var5 * this.velocityX) / (var5 * var5);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1475488148"
   )
   final void method1727(int var1) {
      this.isMoving = true;
      this.x += this.field1471 * (double)var1;
      this.velocityZ += this.scalar * (double)var1;
      this.z += this.velocityX * (double)var1 + (double)var1 * (double)var1 * 0.5D * this.az;
      this.velocityX += this.az * (double)var1;
      this.field1456 = (int)(Math.atan2(this.field1471, this.scalar) * 325.949D) + 1024 & 2047;
      this.field1474 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1477 += var1;

         while(true) {
            do {
               do {
                  if(this.field1477 <= this.animationSequence.frameLenghts[this.field1472]) {
                     return;
                  }

                  this.field1477 -= this.animationSequence.frameLenghts[this.field1472];
                  ++this.field1472;
               } while(this.field1472 < this.animationSequence.frameIDs.length);

               this.field1472 -= this.animationSequence.frameStep;
            } while(this.field1472 >= 0 && this.field1472 < this.animationSequence.frameIDs.length);

            this.field1472 = 0;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   protected final Model getModel() {
      Spotanim var1 = class100.method1840(this.id);
      Model var2 = var1.method4358(this.field1472);
      if(var2 == null) {
         return null;
      } else {
         var2.method2525(this.field1474);
         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-557417802"
   )
   static int method1729(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      } else {
         var3 = var2?class278.field3737:class37.field515;
      }

      if(var0 == 1927) {
         if(class83.field1344 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2761 == null) {
            return 0;
         } else {
            class69 var4 = new class69();
            var4.field824 = var3;
            var4.field833 = var3.field2761;
            var4.field832 = class83.field1344 + 1;
            Client.field1115.method3634(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2121067068"
   )
   public static void method1734(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LScript;",
      garbageValue = "90"
   )
   static Script method1735(int var0) {
      Script var1 = (Script)Script.field1534.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = GroundObject.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class21.method175(var2);
            Script.field1534.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Lclass178;IS)Lclass178;",
      garbageValue = "-2750"
   )
   public static class178 method1737(class178[] var0, int var1) {
      class178[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class178 var4 = var2[var3];
         if(var1 == var4.vmethod5059()) {
            return var4;
         }
      }

      return null;
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1472 = 0;
      this.field1477 = 0;
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field1460 = var7;
      this.field1461 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field1473 = var11;
      this.isMoving = false;
      int var12 = class100.method1840(this.id).field3340;
      if(var12 != -1) {
         this.animationSequence = class169.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }
}
