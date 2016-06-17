import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("w")
   @Export("x")
   double field92;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -287165783
   )
   @Export("floor")
   int field93;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 143219243
   )
   @Export("x1")
   int field94;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1903300409
   )
   @Export("y1")
   int field95;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1355967283
   )
   @Export("z1")
   int field96;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -853569895
   )
   @Export("id")
   int field98;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1656075097
   )
   int field99;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1910108943
   )
   @Export("start")
   int field101;
   @ObfuscatedName("o")
   double field102;
   @ObfuscatedName("t")
   @Export("scalar")
   double field103;
   @ObfuscatedName("k")
   @Export("z")
   double field104;
   @ObfuscatedName("z")
   @Export("velocityZ")
   double field105;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 744696539
   )
   @Export("interacting")
   int field106;
   @ObfuscatedName("m")
   @Export("animationSequence")
   class42 field107;
   @ObfuscatedName("v")
   @Export("velocityX")
   double field108;
   @ObfuscatedName("h")
   @Export("velocityY")
   double field109;
   @ObfuscatedName("a")
   @Export("az")
   double field111;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1485253171
   )
   int field112;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 872644123
   )
   int field113;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1704694527
   )
   int field114;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1036332265
   )
   int field115 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -571783269
   )
   int field116 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1714684757
   )
   int field117;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 374302539
   )
   @Export("startTime")
   int field118;
   @ObfuscatedName("n")
   @Export("isMoving")
   boolean field119 = false;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      class43 var1 = class32.method708(this.field98);
      class105 var2 = var1.method908(this.field115);
      if(null == var2) {
         return null;
      } else {
         var2.method2294(this.field113);
         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "95"
   )
   final void method81(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field119) {
         var5 = (double)(var1 - this.field94);
         double var7 = (double)(var2 - this.field95);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field92 = (double)this.field101 * var5 / var9 + (double)this.field94;
         this.field105 = (double)this.field95 + (double)this.field101 * var7 / var9;
         this.field104 = (double)this.field96;
      }

      var5 = (double)(1 + this.field99 - var4);
      this.field102 = ((double)var1 - this.field92) / var5;
      this.field103 = ((double)var2 - this.field105) / var5;
      this.field109 = Math.sqrt(this.field103 * this.field103 + this.field102 * this.field102);
      if(!this.field119) {
         this.field108 = -this.field109 * Math.tan((double)this.field114 * 0.02454369D);
      }

      this.field111 = ((double)var3 - this.field104 - var5 * this.field108) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "524420386"
   )
   final void method82(int var1) {
      this.field119 = true;
      this.field92 += (double)var1 * this.field102;
      this.field105 += (double)var1 * this.field103;
      this.field104 += (double)var1 * 0.5D * this.field111 * (double)var1 + (double)var1 * this.field108;
      this.field108 += (double)var1 * this.field111;
      this.field112 = (int)(Math.atan2(this.field102, this.field103) * 325.949D) + 1024 & 2047;
      this.field113 = (int)(Math.atan2(this.field108, this.field109) * 325.949D) & 2047;
      if(null != this.field107) {
         this.field116 += var1;

         while(true) {
            do {
               do {
                  if(this.field116 <= this.field107.field983[this.field115]) {
                     return;
                  }

                  this.field116 -= this.field107.field983[this.field115];
                  ++this.field115;
               } while(this.field115 < this.field107.field965.length);

               this.field115 -= this.field107.field966;
            } while(this.field115 >= 0 && this.field115 < this.field107.field965.length);

            this.field115 = 0;
         }
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field98 = var1;
      this.field93 = var2;
      this.field94 = var3;
      this.field95 = var4;
      this.field96 = var5;
      this.field118 = var6;
      this.field99 = var7;
      this.field114 = var8;
      this.field101 = var9;
      this.field106 = var10;
      this.field117 = var11;
      this.field119 = false;
      int var12 = class32.method708(this.field98).field990;
      if(var12 != -1) {
         this.field107 = class17.method178(var12);
      } else {
         this.field107 = null;
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1372259324"
   )
   static final void method88(class37 var0) {
      if(var0.field842 != 0) {
         if(var0.field815 != -1) {
            Object var1 = null;
            if(var0.field815 < '耀') {
               var1 = client.field326[var0.field815];
            } else if(var0.field815 >= '耀') {
               var1 = client.field410[var0.field815 - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.field813 - ((class37)var1).field813;
               int var3 = var0.field791 - ((class37)var1).field791;
               if(var2 != 0 || var3 != 0) {
                  var0.field840 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field816) {
               var0.field815 = -1;
               var0.field816 = false;
            }
         }

         if(var0.field817 != -1 && (var0.field808 == 0 || var0.field847 > 0)) {
            var0.field840 = var0.field817;
            var0.field817 = -1;
         }

         int var4 = var0.field840 - var0.field792 & 2047;
         if(var4 == 0 && var0.field816) {
            var0.field815 = -1;
            var0.field816 = false;
         }

         if(var4 != 0) {
            ++var0.field830;
            boolean var6;
            if(var4 > 1024) {
               var0.field792 -= var0.field842;
               var6 = true;
               if(var4 < var0.field842 || var4 > 2048 - var0.field842) {
                  var0.field792 = var0.field840;
                  var6 = false;
               }

               if(var0.field818 == var0.field795 && (var0.field830 > 25 || var6)) {
                  if(var0.field796 != -1) {
                     var0.field818 = var0.field796;
                  } else {
                     var0.field818 = var0.field798;
                  }
               }
            } else {
               var0.field792 += var0.field842;
               var6 = true;
               if(var4 < var0.field842 || var4 > 2048 - var0.field842) {
                  var0.field792 = var0.field840;
                  var6 = false;
               }

               if(var0.field795 == var0.field818 && (var0.field830 > 25 || var6)) {
                  if(var0.field797 != -1) {
                     var0.field818 = var0.field797;
                  } else {
                     var0.field818 = var0.field798;
                  }
               }
            }

            var0.field792 &= 2047;
         } else {
            var0.field830 = 0;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)I",
      garbageValue = "-1634698077"
   )
   static int method89(class167 var0, class167 var1) {
      int var2 = 0;
      if(var0.method3341("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3341("logo", "")) {
         ++var2;
      }

      if(var1.method3341("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3341("titlebox", "")) {
         ++var2;
      }

      if(var1.method3341("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3341("runes", "")) {
         ++var2;
      }

      if(var1.method3341("title_mute", "")) {
         ++var2;
      }

      if(var1.method3285("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3285("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3341("sl_back", "");
      var1.method3341("sl_flags", "");
      var1.method3341("sl_arrows", "");
      var1.method3341("sl_stars", "");
      var1.method3341("sl_button", "");
      return var2;
   }
}
