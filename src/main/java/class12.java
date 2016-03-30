import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class12 extends class85 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1454793193
   )
   int field193;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -663598315
   )
   int field194;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1040992979
   )
   int field195;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1162060837
   )
   int field196;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1042624511
   )
   int field197;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1470975447
   )
   int field198;
   @ObfuscatedName("m")
   class42 field199;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 17273673
   )
   int field200;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = 1092523355
   )
   static int field202;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 816411243
   )
   int field204;

   @ObfuscatedName("cf")
   static final void method155(int var0, int var1, int var2, int var3, int var4) {
      client.field371[0].method1855(var0, var1);
      client.field371[1].method1855(var0, var3 + var1 - 16);
      class79.method1800(var0, 16 + var1, 16, var3 - 32, client.field312);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      class79.method1800(var0, var6 + 16 + var1, 16, var5, client.field569);
      class79.method1789(var0, var1 + 16 + var6, var5, client.field375);
      class79.method1789(var0 + 1, var6 + 16 + var1, var5, client.field375);
      class79.method1787(var0, var6 + 16 + var1, 16, client.field375);
      class79.method1787(var0, var6 + 17 + var1, 16, client.field375);
      class79.method1789(var0 + 15, 16 + var1 + var6, var5, client.field374);
      class79.method1789(var0 + 14, var1 + 17 + var6, var5 - 1, client.field374);
      class79.method1787(var0, var6 + var1 + 15 + var5, 16, client.field374);
      class79.method1787(1 + var0, 14 + var1 + var6 + var5, 15, client.field374);
   }

   @ObfuscatedName("de")
   static final void method156() {
      client.field318.method2757(232);
      client.field318.method2573(0);
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field196 = var1;
      this.field194 = var2;
      this.field195 = var3;
      this.field197 = var4;
      this.field193 = var5;
      this.field198 = var6;
      if(var7 != -1) {
         this.field199 = class96.method2187(var7);
         this.field200 = 0;
         this.field204 = client.field305 - 1;
         if(0 == this.field199.field1008 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field199 == var10.field199) {
               this.field200 = var10.field200;
               this.field204 = var10.field204;
               return;
            }
         }

         if(var8 && this.field199.field999 != -1) {
            this.field200 = (int)(Math.random() * (double)this.field199.field995.length);
            this.field204 -= (int)(Math.random() * (double)this.field199.field997[this.field200]);
         }
      }

   }

   @ObfuscatedName("t")
   protected final class105 vmethod1901() {
      if(null != this.field199) {
         int var1 = client.field305 - this.field204;
         if(var1 > 100 && this.field199.field999 > 0) {
            var1 = 100;
         }

         label68: {
            do {
               do {
                  if(var1 <= this.field199.field997[this.field200]) {
                     break label68;
                  }

                  var1 -= this.field199.field997[this.field200];
                  ++this.field200;
               } while(this.field200 < this.field199.field995.length);

               this.field200 -= this.field199.field999;
            } while(this.field200 >= 0 && this.field200 < this.field199.field995.length);

            this.field199 = null;
         }

         this.field204 = client.field305 - var1;
      }

      class40 var12 = class22.method592(this.field196);
      if(null != var12.field943) {
         var12 = var12.method842();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field195 != 1 && this.field195 != 3) {
            var2 = var12.field979;
            var3 = var12.field942;
         } else {
            var2 = var12.field942;
            var3 = var12.field979;
         }

         int var4 = (var2 >> 1) + this.field193;
         int var5 = this.field193 + (1 + var2 >> 1);
         int var6 = this.field198 + (var3 >> 1);
         int var7 = this.field198 + (1 + var3 >> 1);
         int[][] var8 = class5.field96[this.field197];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var5][var6] + var8[var4][var6] >> 2;
         int var10 = (this.field193 << 7) + (var2 << 6);
         int var11 = (this.field198 << 7) + (var3 << 6);
         return var12.method829(this.field194, this.field195, var8, var10, var9, var11, this.field199, this.field200);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-309125537"
   )
   static final void method159() {
      int var0 = class3.field78 * 128 + 64;
      int var1 = 64 + class47.field1084 * 128;
      int var2 = class43.method938(var0, var1, class82.field1437) - field202;
      if(class148.field2249 < var0) {
         class148.field2249 += class0.field13 * (var0 - class148.field2249) / 1000 + class137.field2143;
         if(class148.field2249 > var0) {
            class148.field2249 = var0;
         }
      }

      if(class148.field2249 > var0) {
         class148.field2249 -= class137.field2143 + class0.field13 * (class148.field2249 - var0) / 1000;
         if(class148.field2249 < var0) {
            class148.field2249 = var0;
         }
      }

      if(class156.field2333 < var2) {
         class156.field2333 += class137.field2143 + class0.field13 * (var2 - class156.field2333) / 1000;
         if(class156.field2333 > var2) {
            class156.field2333 = var2;
         }
      }

      if(class156.field2333 > var2) {
         class156.field2333 -= (class156.field2333 - var2) * class0.field13 / 1000 + class137.field2143;
         if(class156.field2333 < var2) {
            class156.field2333 = var2;
         }
      }

      if(class173.field2868 < var1) {
         class173.field2868 += (var1 - class173.field2868) * class0.field13 / 1000 + class137.field2143;
         if(class173.field2868 > var1) {
            class173.field2868 = var1;
         }
      }

      if(class173.field2868 > var1) {
         class173.field2868 -= (class173.field2868 - var1) * class0.field13 / 1000 + class137.field2143;
         if(class173.field2868 < var1) {
            class173.field2868 = var1;
         }
      }

      var0 = 64 + class18.field277 * 128;
      var1 = class36.field813 * 128 + 64;
      var2 = class43.method938(var0, var1, class82.field1437) - class29.field699;
      int var3 = var0 - class148.field2249;
      int var4 = var2 - class156.field2333;
      int var5 = var1 - class173.field2868;
      int var6 = (int)Math.sqrt((double)(var5 * var5 + var3 * var3));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class29.field698 < var7) {
         class29.field698 += (var7 - class29.field698) * class28.field687 / 1000 + class10.field184;
         if(class29.field698 > var7) {
            class29.field698 = var7;
         }
      }

      if(class29.field698 > var7) {
         class29.field698 -= class28.field687 * (class29.field698 - var7) / 1000 + class10.field184;
         if(class29.field698 < var7) {
            class29.field698 = var7;
         }
      }

      int var9 = var8 - class16.field237;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class16.field237 += var9 * class28.field687 / 1000 + class10.field184;
         class16.field237 &= 2047;
      }

      if(var9 < 0) {
         class16.field237 -= -var9 * class28.field687 / 1000 + class10.field184;
         class16.field237 &= 2047;
      }

      int var10 = var8 - class16.field237;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class16.field237 = var8;
      }

   }
}
