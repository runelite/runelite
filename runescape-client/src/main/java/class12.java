import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class12 extends class85 {
   @ObfuscatedName("n")
   class42 field184;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1554171993
   )
   int field186;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2014276433
   )
   int field187;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = -954023765
   )
   static int field188;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1922596175
   )
   int field189;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2093177843
   )
   int field190;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2027993527
   )
   int field191;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1680284775
   )
   int field192;
   @ObfuscatedName("nf")
   static class74 field194;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 815919897
   )
   int field195;
   @ObfuscatedName("qz")
   @Export("bufferProvider")
   public static class77 field196;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1980543031
   )
   int field197;

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field195 = var1;
      this.field190 = var2;
      this.field186 = var3;
      this.field187 = var4;
      this.field197 = var5;
      this.field189 = var6;
      if(var7 != -1) {
         this.field184 = class34.method768(var7);
         this.field191 = 0;
         this.field192 = client.field301 - 1;
         if(this.field184.field1015 == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field184 == var10.field184) {
               this.field191 = var10.field191;
               this.field192 = var10.field192;
               return;
            }
         }

         if(var8 && this.field184.field1014 != -1) {
            this.field191 = (int)(Math.random() * (double)this.field184.field999.length);
            this.field192 -= (int)(Math.random() * (double)this.field184.field1004[this.field191]);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      if(null != this.field184) {
         int var12 = client.field301 - this.field192;
         if(var12 > 100 && this.field184.field1014 > 0) {
            var12 = 100;
         }

         label62: {
            do {
               do {
                  if(var12 <= this.field184.field1004[this.field191]) {
                     break label62;
                  }

                  var12 -= this.field184.field1004[this.field191];
                  ++this.field191;
               } while(this.field191 < this.field184.field999.length);

               this.field191 -= this.field184.field1014;
            } while(this.field191 >= 0 && this.field191 < this.field184.field999.length);

            this.field184 = null;
         }

         this.field192 = client.field301 - var12;
      }

      class40 var1 = class150.method3166(this.field195);
      if(var1.field947 != null) {
         var1 = var1.method850();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field186 != 1 && this.field186 != 3) {
            var2 = var1.field945;
            var3 = var1.field937;
         } else {
            var2 = var1.field937;
            var3 = var1.field945;
         }

         int var4 = (var2 >> 1) + this.field197;
         int var5 = (var2 + 1 >> 1) + this.field197;
         int var6 = this.field189 + (var3 >> 1);
         int var7 = (1 + var3 >> 1) + this.field189;
         int[][] var8 = class5.field99[this.field187];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (var2 << 6) + (this.field197 << 7);
         int var11 = (var3 << 6) + (this.field189 << 7);
         return var1.method848(this.field190, this.field186, var8, var10, var9, var11, this.field184, this.field191);
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-841882350"
   )
   static void method165() {
      if(client.field442) {
         class173 var0 = class172.method3425(class17.field253, client.field443);
         if(var0 != null && null != var0.field2846) {
            class0 var1 = new class0();
            var1.field1 = var0;
            var1.field0 = var0.field2846;
            class31.method737(var1, 200000);
         }

         client.field442 = false;
         class39.method818(var0);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "2077371486"
   )
   public static void method166(class167 var0) {
      class46.field1071 = var0;
   }
}
