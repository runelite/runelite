import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1591270675
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @Export("isMoving")
   boolean isMoving;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 767453335
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1822505173
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("l")
   @Export("x")
   double x;
   @ObfuscatedName("c")
   double field1455;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 871534589
   )
   int field1476;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1297144449
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1444273951
   )
   int field1453;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2067546559
   )
   @Export("rotationY")
   int rotationY;
   @ObfuscatedName("h")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1504905369
   )
   @Export("start")
   int start;
   @ObfuscatedName("m")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 161090977
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @Export("z")
   double z;
   @ObfuscatedName("p")
   @Export("heightOffset")
   double heightOffset;
   @ObfuscatedName("t")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 843517295
   )
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1588875433
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("a")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1872176831
   )
   @Export("slope")
   int slope;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1547643857
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 496929969
   )
   @Export("rotationX")
   int rotationX;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1746319411
   )
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   @Export("animationSequence")
   Sequence animationSequence;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.field1476 = 0;
      this.field1453 = 0;
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
      int var12 = GameEngine.getSpotAnimType(this.id).field3331;
      if(var12 != -1) {
         this.animationSequence = Ignore.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   protected final Model getModel() {
      Spotanim var1 = GameEngine.getSpotAnimType(this.id);
      Model var2 = var1.method4337(this.field1476);
      if(var2 == null) {
         return null;
      } else {
         var2.method2529(this.rotationY);
         return var2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2135658141"
   )
   final void method1784(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.field1455;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += (double)var1 * (double)var1 * this.heightOffset * 0.5D + (double)var1 * this.velocityX;
      this.velocityX += this.heightOffset * (double)var1;
      this.rotationX = (int)(Math.atan2(this.field1455, this.scalar) * 325.949D) + 1024 & 2047;
      this.rotationY = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(this.animationSequence != null) {
         this.field1453 += var1;

         while(true) {
            do {
               do {
                  if(this.field1453 <= this.animationSequence.frameLenghts[this.field1476]) {
                     return;
                  }

                  this.field1453 -= this.animationSequence.frameLenghts[this.field1476];
                  ++this.field1476;
               } while(this.field1476 < this.animationSequence.frameIDs.length);

               this.field1476 -= this.animationSequence.frameStep;
            } while(this.field1476 >= 0 && this.field1476 < this.animationSequence.frameIDs.length);

            this.field1476 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-148077512"
   )
   final void method1792(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.start * var7 / var9 + (double)this.y1;
         this.z = (double)this.height;
      }

      var5 = (double)(this.cycle + 1 - var4);
      this.field1455 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field1455 * this.field1455 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.slope * 0.02454369D);
      }

      this.heightOffset = ((double)var3 - this.z - var5 * this.velocityX) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Ldl;B)V",
      garbageValue = "-17"
   )
   static final void method1790(class120 var0) {
      var0.field1707 = false;
      if(var0.field1704 != null) {
         var0.field1704.field1738 = 0;
      }

      for(class120 var1 = var0.vmethod3906(); var1 != null; var1 = var0.vmethod3908()) {
         method1790(var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method1782() {
      FileOnDisk var0 = null;

      try {
         var0 = TextureProvider.getPreferencesFile("", class29.field424.field3175, true);
         Buffer var1 = MilliTimer.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   static void method1793() {
      class97.field1493 = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class97.field1492[var0] = null;
         class97.field1491[var0] = 1;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "2146943781"
   )
   static int method1783(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
