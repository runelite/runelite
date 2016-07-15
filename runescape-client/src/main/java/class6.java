import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("Projectile")
public final class class6 extends class88 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -567604477
   )
   @Export("floor")
   int field98;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1048949749
   )
   @Export("id")
   int field99;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 108186571
   )
   @Export("y1")
   int field100;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 352282945
   )
   @Export("z1")
   int field101;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1132154771
   )
   int field102;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1472229345
   )
   @Export("startTime")
   int field103;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1287609869
   )
   int field104;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -371672455
   )
   @Export("x1")
   int field105;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1958390673
   )
   @Export("start")
   int field106;
   @ObfuscatedName("x")
   double field107;
   @ObfuscatedName("q")
   @Export("isMoving")
   boolean field108 = false;
   @ObfuscatedName("g")
   @Export("x")
   double field109;
   @ObfuscatedName("j")
   @Export("velocityZ")
   double field110;
   @ObfuscatedName("w")
   @Export("z")
   double field111;
   @ObfuscatedName("k")
   @Export("animationSequence")
   class44 field112;
   @ObfuscatedName("f")
   @Export("scalar")
   double field113;
   @ObfuscatedName("t")
   @Export("velocityY")
   double field114;
   @ObfuscatedName("z")
   @Export("velocityX")
   double field115;
   @ObfuscatedName("y")
   @Export("az")
   double field116;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 975608893
   )
   int field117;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1128200495
   )
   int field118;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -961825089
   )
   int field119 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -134824863
   )
   int field121 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1450003375
   )
   int field122;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 850096035
   )
   static int field123;
   @ObfuscatedName("ir")
   @ObfuscatedGetter(
      intValue = 218652161
   )
   static int field124;
   @ObfuscatedName("qi")
   @ObfuscatedGetter(
      intValue = 1890021581
   )
   static int field125;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1700031493
   )
   @Export("interacting")
   int field127;
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 371572371
   )
   @Export("baseY")
   static int field128;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -1267963751
   )
   static int field129;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2140325382"
   )
   final void method79(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field108) {
         var5 = (double)(var1 - this.field105);
         double var7 = (double)(var2 - this.field100);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field109 = (double)this.field105 + (double)this.field106 * var5 / var9;
         this.field110 = (double)this.field100 + var7 * (double)this.field106 / var9;
         this.field111 = (double)this.field101;
      }

      var5 = (double)(this.field104 + 1 - var4);
      this.field107 = ((double)var1 - this.field109) / var5;
      this.field113 = ((double)var2 - this.field110) / var5;
      this.field114 = Math.sqrt(this.field107 * this.field107 + this.field113 * this.field113);
      if(!this.field108) {
         this.field115 = -this.field114 * Math.tan(0.02454369D * (double)this.field122);
      }

      this.field116 = ((double)var3 - this.field111 - this.field115 * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1884556042"
   )
   final void method80(int var1) {
      this.field108 = true;
      this.field109 += this.field107 * (double)var1;
      this.field110 += this.field113 * (double)var1;
      this.field111 += this.field115 * (double)var1 + (double)var1 * 0.5D * this.field116 * (double)var1;
      this.field115 += (double)var1 * this.field116;
      this.field117 = (int)(Math.atan2(this.field107, this.field113) * 325.949D) + 1024 & 2047;
      this.field118 = (int)(Math.atan2(this.field115, this.field114) * 325.949D) & 2047;
      if(this.field112 != null) {
         this.field121 += var1;

         while(true) {
            do {
               do {
                  if(this.field121 <= this.field112.field1025[this.field119]) {
                     return;
                  }

                  this.field121 -= this.field112.field1025[this.field119];
                  ++this.field119;
               } while(this.field119 < this.field112.field1023.length);

               this.field119 -= this.field112.field1027;
            } while(this.field119 >= 0 && this.field119 < this.field112.field1023.length);

            this.field119 = 0;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "450723488"
   )
   public static boolean method81(int var0) {
      return (var0 & 1) != 0;
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field99 = var1;
      this.field98 = var2;
      this.field105 = var3;
      this.field100 = var4;
      this.field101 = var5;
      this.field103 = var6;
      this.field104 = var7;
      this.field122 = var8;
      this.field106 = var9;
      this.field127 = var10;
      this.field102 = var11;
      this.field108 = false;
      int var12 = class151.method3217(this.field99).field1047;
      if(var12 != -1) {
         this.field112 = class13.method153(var12);
      } else {
         this.field112 = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      class45 var1 = class151.method3217(this.field99);
      class108 var2 = var1.method964(this.field119);
      if(null == var2) {
         return null;
      } else {
         var2.method2400(this.field118);
         return var2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-359961488"
   )
   static void method92() {
      class15.field227 = new class199(32);
   }
}
