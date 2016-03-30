import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("m")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 420459489
   )
   int field113;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1274390663
   )
   int field114 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1628661773
   )
   int field115;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 923254047
   )
   int field116 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1155463829
   )
   int field117;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -331106435
   )
   int field118;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 691460085
   )
   int field119;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2019939969
   )
   int field120;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1361073145
   )
   int field121;
   @ObfuscatedName("i")
   @Export("velocityY")
   double field122;
   @ObfuscatedName("s")
   @Export("isMoving")
   boolean field123 = false;
   @ObfuscatedName("j")
   double field124;
   @ObfuscatedName("q")
   @Export("velocityZ")
   double field125;
   @ObfuscatedName("a")
   double field126;
   @ObfuscatedName("d")
   double field127;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 874157703
   )
   int field128;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2066101403
   )
   int field129;
   @ObfuscatedName("u")
   @Export("scalar")
   double field130;
   @ObfuscatedName("h")
   double field131;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1180413319
   )
   int field132;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2092099863
   )
   int field133;
   @ObfuscatedName("o")
   @Export("velocityX")
   double field134;
   @ObfuscatedName("r")
   @Export("animationSequence")
   class42 field135;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1147178609
   )
   int field136;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -627743015
   )
   static int field137;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1230835763
   )
   int field138;

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field129 = var1;
      this.field113 = var2;
      this.field138 = var3;
      this.field115 = var4;
      this.field136 = var5;
      this.field118 = var6;
      this.field119 = var7;
      this.field120 = var8;
      this.field121 = var9;
      this.field128 = var10;
      this.field117 = var11;
      this.field123 = false;
      int var12 = class29.method669(this.field129).field1018;
      if(var12 != -1) {
         this.field135 = class96.method2187(var12);
      } else {
         this.field135 = null;
      }

   }

   @ObfuscatedName("w")
   final void method95(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field123) {
         var5 = (double)(var1 - this.field138);
         double var7 = (double)(var2 - this.field115);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.field124 = (double)this.field138 + (double)this.field121 * var5 / var9;
         this.field125 = (double)this.field121 * var7 / var9 + (double)this.field115;
         this.field126 = (double)this.field136;
      }

      var5 = (double)(1 + this.field119 - var4);
      this.field127 = ((double)var1 - this.field124) / var5;
      this.field130 = ((double)var2 - this.field125) / var5;
      this.field122 = Math.sqrt(this.field127 * this.field127 + this.field130 * this.field130);
      if(!this.field123) {
         this.field134 = -this.field122 * Math.tan((double)this.field120 * 0.02454369D);
      }

      this.field131 = 2.0D * ((double)var3 - this.field126 - this.field134 * var5) / (var5 * var5);
   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      class43 var1 = class29.method669(this.field129);
      class105 var2 = var1.method937(this.field116);
      if(var2 == null) {
         return null;
      } else {
         var2.method2314(this.field133);
         return var2;
      }
   }

   @ObfuscatedName("x")
   final void method99(int var1) {
      this.field123 = true;
      this.field124 += (double)var1 * this.field127;
      this.field125 += (double)var1 * this.field130;
      this.field126 += (double)var1 * this.field134 + (double)var1 * 0.5D * this.field131 * (double)var1;
      this.field134 += (double)var1 * this.field131;
      this.field132 = (int)(Math.atan2(this.field127, this.field130) * 325.949D) + 1024 & 2047;
      this.field133 = (int)(Math.atan2(this.field134, this.field122) * 325.949D) & 2047;
      if(this.field135 != null) {
         this.field114 += var1;

         while(true) {
            do {
               do {
                  if(this.field114 <= this.field135.field997[this.field116]) {
                     return;
                  }

                  this.field114 -= this.field135.field997[this.field116];
                  ++this.field116;
               } while(this.field116 < this.field135.field995.length);

               this.field116 -= this.field135.field999;
            } while(this.field116 >= 0 && this.field116 < this.field135.field995.length);

            this.field116 = 0;
         }
      }
   }

   @ObfuscatedName("w")
   public static void method100(File var0) {
      class135.field2096 = var0;
      if(!class135.field2096.exists()) {
         throw new RuntimeException("");
      } else {
         class135.field2100 = true;
      }
   }
}
