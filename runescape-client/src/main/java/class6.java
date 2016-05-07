import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("Projectile")
public final class class6 extends class85 {
   @ObfuscatedName("m")
   double field103;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1551576731
   )
   int field104;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1802403789
   )
   int field105;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1785876883
   )
   int field106;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 771544961
   )
   int field107;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -458672663
   )
   int field108;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1794818475
   )
   int field109;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2070774807
   )
   int field110;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1959069117
   )
   int field111;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -417276451
   )
   int field112;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -977923133
   )
   int field113;
   @ObfuscatedName("i")
   double field114;
   @ObfuscatedName("r")
   @Export("velocityZ")
   double field115;
   @ObfuscatedName("a")
   @Export("velocityX")
   double field116;
   @ObfuscatedName("e")
   double field117;
   @ObfuscatedName("h")
   @Export("scalar")
   double field118;
   @ObfuscatedName("z")
   @Export("velocityY")
   double field119;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 766396619
   )
   int field120 = 0;
   @ObfuscatedName("w")
   double field121;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -957985811
   )
   int field122;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1109988801
   )
   int field123;
   @ObfuscatedName("f")
   @Export("animationSequence")
   class42 field124;
   @ObfuscatedName("t")
   @Export("isMoving")
   boolean field125 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -875901675
   )
   int field126 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1427833467
   )
   int field127;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1386097319"
   )
   final void method91(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.field125) {
         var5 = (double)(var1 - this.field111);
         double var7 = (double)(var2 - this.field105);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.field114 = (double)this.field111 + (double)this.field110 * var5 / var9;
         this.field115 = var7 * (double)this.field110 / var9 + (double)this.field105;
         this.field103 = (double)this.field106;
      }

      var5 = (double)(1 + this.field109 - var4);
      this.field117 = ((double)var1 - this.field114) / var5;
      this.field118 = ((double)var2 - this.field115) / var5;
      this.field119 = Math.sqrt(this.field118 * this.field118 + this.field117 * this.field117);
      if(!this.field125) {
         this.field116 = -this.field119 * Math.tan((double)this.field104 * 0.02454369D);
      }

      this.field121 = ((double)var3 - this.field103 - this.field116 * var5) * 2.0D / (var5 * var5);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "460794441"
   )
   final void method92(int var1) {
      this.field125 = true;
      this.field114 += (double)var1 * this.field117;
      this.field115 += this.field118 * (double)var1;
      this.field103 += (double)var1 * this.field121 * 0.5D * (double)var1 + (double)var1 * this.field116;
      this.field116 += (double)var1 * this.field121;
      this.field122 = (int)(Math.atan2(this.field117, this.field118) * 325.949D) + 1024 & 2047;
      this.field123 = (int)(Math.atan2(this.field116, this.field119) * 325.949D) & 2047;
      if(this.field124 != null) {
         this.field126 += var1;

         while(true) {
            do {
               do {
                  if(this.field126 <= this.field124.field999[this.field120]) {
                     return;
                  }

                  this.field126 -= this.field124.field999[this.field120];
                  ++this.field120;
               } while(this.field120 < this.field124.field986.length);

               this.field120 -= this.field124.field991;
            } while(this.field120 >= 0 && this.field120 < this.field124.field986.length);

            this.field120 = 0;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass22;",
      garbageValue = "-1383376789"
   )
   static class22 method93(int var0) {
      class22 var1 = (class22)class22.field589.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class9.field155.method3239(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field2005 = var3.field2007.length - 12;
            int var4 = var3.method2497();
            var1.field587 = var3.method2584();
            var1.field588 = var3.method2584();
            var1.field592 = var3.method2584();
            var1.field590 = var3.method2584();
            var3.field2005 = 0;
            var3.method2539();
            var1.field584 = new int[var4];
            var1.field585 = new int[var4];
            var1.field586 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field2005 < var3.field2007.length - 12; var1.field584[var5++] = var6) {
               var6 = var3.method2584();
               if(var6 == 3) {
                  var1.field586[var5] = var3.method2500();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && 39 != var6) {
                  var1.field585[var5] = var3.method2497();
               } else {
                  var1.field585[var5] = var3.method2492();
               }
            }

            class22.field589.method3745(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      class43 var1 = class179.method3492(this.field113);
      class105 var2 = var1.method879(this.field120);
      if(var2 == null) {
         return null;
      } else {
         var2.method2296(this.field123);
         return var2;
      }
   }

   class6(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.field113 = var1;
      this.field108 = var2;
      this.field111 = var3;
      this.field105 = var4;
      this.field106 = var5;
      this.field127 = var6;
      this.field109 = var7;
      this.field104 = var8;
      this.field110 = var9;
      this.field112 = var10;
      this.field107 = var11;
      this.field125 = false;
      int var12 = class179.method3492(this.field113).field1008;
      if(var12 != -1) {
         this.field124 = class4.method42(var12);
      } else {
         this.field124 = null;
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1783032829"
   )
   static void method96() {
      for(int var0 = 0; var0 < client.field496; ++var0) {
         if(class56.method1205(client.field422[var0])) {
            if(var0 < client.field496 - 1) {
               for(int var1 = var0; var1 < client.field496 - 1; ++var1) {
                  client.field424[var1] = client.field424[var1 + 1];
                  client.field425[var1] = client.field425[1 + var1];
                  client.field422[var1] = client.field422[1 + var1];
                  client.field378[var1] = client.field378[var1 + 1];
                  client.field420[var1] = client.field420[var1 + 1];
                  client.field421[var1] = client.field421[var1 + 1];
               }
            }

            --client.field496;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2107922874"
   )
   public static boolean method97(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   static void method98() {
      for(class23 var0 = (class23)class23.field615.method3812(); var0 != null; var0 = (class23)class23.field615.method3817()) {
         if(var0.field611 != null) {
            var0.method573();
         }
      }

   }
}
