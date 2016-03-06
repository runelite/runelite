package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ak")
public class class27 {
   @ObfuscatedName("l")
   class35[] field665 = new class35[100];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1397478785
   )
   int field668;

   @ObfuscatedName("j")
   class35 method639(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field665[99];

      for(int var6 = this.field668; var6 > 0; --var6) {
         if(100 != var6) {
            this.field665[var6] = this.field665[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3853();
         var5.method3835();
         var5.method737(var1, var2, var4, var3);
      }

      this.field665[0] = var5;
      if(this.field668 < 100) {
         ++this.field668;
      }

      return var5;
   }

   @ObfuscatedName("a")
   int method640() {
      return this.field668;
   }

   @ObfuscatedName("l")
   class35 method643(int var1) {
      return var1 >= 0 && var1 < this.field668?this.field665[var1]:null;
   }

   @ObfuscatedName("z")
   static final void method648() {
      if(class209.field3115 != null) {
         class209.field3115.method2948();
         class209.field3115 = null;
      }

      class18.method191();
      class107.field1906.method1875();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field346[var0].method2341();
      }

      System.gc();
      class182.field2957 = 1;
      class182.field2955 = null;
      class125.field2043 = -1;
      class7.field138 = -1;
      class75.field1388 = 0;
      class11.field182 = false;
      class3.field62 = 2;
      client.field453 = -1;
      client.field527 = false;

      for(class23 var1 = (class23)class23.field615.method3773(); null != var1; var1 = (class23)class23.field615.method3772()) {
         if(var1.field604 != null) {
            class17.field252.method1137(var1.field604);
            var1.field604 = null;
         }

         if(var1.field606 != null) {
            class17.field252.method1137(var1.field606);
            var1.field606 = null;
         }
      }

      class23.field615.method3767();
      client.method556(10);
   }

   @ObfuscatedName("br")
   static final void method649(boolean var0) {
      client.field413 = 0;
      client.field327 = 0;
      class12.method151();
      class51.method1079(var0);
      class6.method91();

      int var1;
      for(var1 = 0; var1 < client.field413; ++var1) {
         int var2 = client.field414[var1];
         if(client.field394 != client.field324[var2].field858) {
            client.field324[var2].field779 = null;
            client.field324[var2] = null;
         }
      }

      if(client.field332 != client.field293.field1998) {
         throw new RuntimeException(client.field293.field1998 + "," + client.field332);
      } else {
         for(var1 = 0; var1 < client.field561; ++var1) {
            if(null == client.field324[client.field326[var1]]) {
               throw new RuntimeException(var1 + "," + client.field561);
            }
         }

      }
   }

   @ObfuscatedName("k")
   public static final class78 method650(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(2 == var4 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1118.method3711(var6);
         if(null != var8) {
            return var8;
         }
      }

      class51 var9 = class22.method581(var0);
      if(var1 > 1 && null != var9.field1149) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1150[var11] && var9.field1150[var11] != 0) {
               var10 = var9.field1149[var11];
            }
         }

         if(var10 != -1) {
            var9 = class22.method581(var10);
         }
      }

      class104 var19 = var9.method1032(1);
      if(var19 == null) {
         return null;
      } else {
         class78 var20 = null;
         if(var9.field1152 != -1) {
            var20 = method650(var9.field1148, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(-1 != var9.field1161) {
            var20 = method650(var9.field1160, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1426;
         int var13 = class79.field1423;
         int var14 = class79.field1424;
         int[] var15 = new int[4];
         class79.method1772(var15);
         var8 = new class78(36, 32);
         class79.method1768(var8.field1412, 36, 32);
         class79.method1774();
         class90.method2114();
         class90.method2062(16, 16);
         class90.field1570 = false;
         int var16 = var9.field1126;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class90.field1587[var9.field1127] * var16 >> 16;
         int var18 = class90.field1590[var9.field1127] * var16 >> 16;
         var19.method2261();
         var19.method2289(0, var9.field1128, var9.field1142, var9.field1127, var9.field1130, var9.field1163 + var19.field1461 / 2 + var17, var9.field1163 + var18);
         if(-1 != var9.field1161) {
            var20.method1706(0, 0);
         }

         if(var2 >= 1) {
            var8.method1684(1);
         }

         if(var2 >= 2) {
            var8.method1684(16777215);
         }

         if(var3 != 0) {
            var8.method1700(var3);
         }

         class79.method1768(var8.field1412, 36, 32);
         if(var9.field1152 != -1) {
            var20.method1706(0, 0);
         }

         if(1 == var4 || var4 == 2 && var9.field1134 == 1) {
            class20.field580.method3967(class92.method2135(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1118.method3713(var8, var6);
         }

         class79.method1768(var12, var13, var14);
         class79.method1795(var15);
         class90.method2114();
         class90.field1570 = true;
         return var8;
      }
   }
}
