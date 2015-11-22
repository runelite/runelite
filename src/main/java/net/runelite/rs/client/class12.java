package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("e")
public class class12 extends class84 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -765128343
   )
   int field175;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -402727575
   )
   int field176;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1138638229
   )
   int field178;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 481310607
   )
   int field179;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1325619223
   )
   int field180;
   @ObfuscatedName("h")
   class42 field181;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2124490871
   )
   int field182;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -872633315
   )
   int field183;
   @ObfuscatedName("z")
   static String field184;
   @ObfuscatedName("bm")
   static class167 field185;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1479683507
   )
   int field186;

   @ObfuscatedName("f")
   protected final class104 vmethod1921() {
      if(null != this.field181) {
         int var1 = client.field286 - this.field175;
         if(var1 > 100 && this.field181.field977 * -1 > 0) {
            var1 = 100;
         }

         label68: {
            do {
               do {
                  if(var1 <= this.field181.field975[this.field182]) {
                     break label68;
                  }

                  var1 -= this.field181.field975[this.field182];
                  ++this.field182;
               } while(this.field182 < this.field181.field973.length);

               this.field182 -= this.field181.field977 * -1;
            } while(this.field182 >= 0 && this.field182 < this.field181.field973.length);

            this.field181 = null;
         }

         this.field175 = client.field286 - var1;
      }

      class40 var12 = class33.method755(this.field180);
      if(var12.field945 != null) {
         var12 = var12.method847();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(1 != this.field183 && this.field183 != 3) {
            var2 = var12.field919;
            var3 = var12.field920;
         } else {
            var2 = var12.field920;
            var3 = var12.field919;
         }

         int var4 = (var2 >> 1) + this.field179;
         int var5 = this.field179 + (1 + var2 >> 1);
         int var6 = (var3 >> 1) + this.field186;
         int var7 = (var3 + 1 >> 1) + this.field186;
         int[][] var8 = class5.field79[this.field178];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (var2 << 6) + (this.field179 << 7);
         int var11 = (this.field186 << 7) + (var3 << 6);
         return var12.method867(this.field176, this.field183, var8, var10, var9, var11, this.field181, this.field182);
      }
   }

   @ObfuscatedName("u")
   static boolean method184(class121 var0, int var1) {
      int var2 = var0.method2786(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(0 == var2) {
         if(var0.method2786(1) != 0) {
            method184(var0, var1);
         }

         var3 = var0.method2786(6);
         var4 = var0.method2786(6);
         boolean var11 = var0.method2786(1) == 1;
         if(var11) {
            class32.field741[++class32.field740 - 1] = var1;
         }

         if(null != client.field397[var1]) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field397[var1] = new class2();
            var12.field58 = var1;
            if(class32.field732[var1] != null) {
               var12.method14(class32.field732[var1]);
            }

            var12.field848 = class32.field738[var1];
            var12.field823 = class32.field735[var1];
            var7 = class32.field737[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field855[0] = class32.field731[var1];
            var12.field56 = (byte)var8;
            var12.method26((var9 << 6) + var3 - class47.field1053, (var10 << 6) + var4 - class161.field2629);
            var12.field54 = false;
            return true;
         }
      } else if(1 == var2) {
         var3 = var0.method2786(2);
         var4 = class32.field737[var1];
         class32.field737[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(2 == var2) {
            var3 = var0.method2786(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field737[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(3 == var5) {
               --var8;
            }

            if(4 == var5) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(6 == var5) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field737[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2786(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field737[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class32.field737[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class84 var9) {
      this.field180 = var1;
      this.field176 = var2;
      this.field183 = var3;
      this.field178 = var4;
      this.field179 = var5;
      this.field186 = var6;
      if(var7 != -1) {
         this.field181 = client.method584(var7);
         this.field182 = 0;
         this.field175 = client.field286 - 1;
         if(this.field181.field969 == 0 && null != var9 && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field181 == this.field181) {
               this.field182 = var10.field182;
               this.field175 = var10.field175;
               return;
            }
         }

         if(var8 && this.field181.field977 * -1 != -1) {
            this.field182 = (int)(Math.random() * (double)this.field181.field973.length);
            this.field175 -= (int)(Math.random() * (double)this.field181.field975[this.field182]);
         }
      }

   }

   @ObfuscatedName("cl")
   static final void method186(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(null != var3) {
            if(var3.field2736 == 0) {
               if(var3.field2806 != null) {
                  method186(var3.field2806, var1);
               }

               class3 var4 = (class3)client.field304.method3836((long)(var3.field2734 * -1));
               if(var4 != null) {
                  class15.method198(var4.field63, var1);
               }
            }

            class0 var5;
            if(0 == var1 && var3.field2835 != null) {
               var5 = new class0();
               var5.field2 = var3;
               var5.field10 = var3.field2835;
               class171.method3458(var5);
            }

            if(1 == var1 && null != var3.field2840) {
               if(var3.field2735 >= 0) {
                  class172 var6 = class48.method1036(var3.field2734 * -1);
                  if(null == var6 || var6.field2806 == null || var3.field2735 >= var6.field2806.length || var6.field2806[var3.field2735] != var3) {
                     continue;
                  }
               }

               var5 = new class0();
               var5.field2 = var3;
               var5.field10 = var3.field2840;
               class171.method3458(var5);
            }
         }
      }

   }

   @ObfuscatedName("dz")
   static final void method187(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field434 + client.field346 & 2047;
         int var8 = class90.field1571[var7];
         int var9 = class90.field1573[var7];
         var8 = var8 * 256 / (256 + client.field348);
         var9 = 256 * var9 / (256 + client.field348);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class23.field601.method1741(4 + var0 + 94 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class9.method153(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("dd")
   static void method188(int var0) {
      for(class200 var1 = (class200)client.field476.method3835(); var1 != null; var1 = (class200)client.field476.method3840()) {
         if((var1.field3104 >> 48 & 65535L) == (long)var0) {
            var1.method3965();
         }
      }

   }

   @ObfuscatedName("u")
   static void method190(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var1 + var0) / 2;
         int var7 = var0;
         class25 var8 = class25.field615[var6];
         class25.field615[var6] = class25.field615[var1];
         class25.field615[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class100.method2307(class25.field615[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class25.field615[var9];
               class25.field615[var9] = class25.field615[var7];
               class25.field615[var7++] = var10;
            }
         }

         class25.field615[var1] = class25.field615[var7];
         class25.field615[var7] = var8;
         method190(var0, var7 - 1, var2, var3, var4, var5);
         method190(1 + var7, var1, var2, var3, var4, var5);
      }

   }
}
