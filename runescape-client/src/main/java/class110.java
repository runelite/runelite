import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public abstract class class110 {
   @ObfuscatedName("eq")
   static class83[] field1947;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1096474791
   )
   public int field1948;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -146250109
   )
   public int field1949;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1950465577
   )
   public int field1950;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1148895045
   )
   public int field1951;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -655490869
   )
   static int field1954;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILclass111;S)Z",
      garbageValue = "150"
   )
   protected abstract boolean vmethod2486(int var1, int var2, int var3, class111 var4);

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-822604602"
   )
   static final void method2487(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field548 + (client.field549 - client.field548) * var5 / 100;
      int var7 = 512 * var6 * var3 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field320) {
         var15 = client.field320;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 > client.field492) {
            var6 = client.field492;
            var8 = 512 * var3 * var6 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1880();
               class82.method1907(var0, var1, var9, var3, -16777216);
               class82.method1907(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field563) {
         var15 = client.field563;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < client.field552) {
            var6 = client.field552;
            var8 = var2 * var15 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class82.method1880();
               class82.method1907(var0, var1, var2, var9, -16777216);
               class82.method1907(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (client.field551 - client.field359) * var5 / 100 + client.field359;
      client.field392 = var8 * var3 * var6 / 85504 << 1;
      if(var2 != client.field558 || client.field559 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + var10 * 32 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = class94.field1661[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class89.method2037(var14, 500, 800, var2, var3);
      }

      client.field556 = var0;
      client.field557 = var1;
      client.field558 = var2;
      client.field559 = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "58063347"
   )
   public static class45 method2488(int var0) {
      class45 var1 = (class45)class45.field1035.method3905((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class45.field1034.method3411(13, var0);
         var1 = new class45();
         var1.field1037 = var0;
         if(var2 != null) {
            var1.method951(new class122(var2));
         }

         class45.field1035.method3907(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-44165223"
   )
   static final void method2490() {
      class79.method1777(client.field466);
      ++class188.field3055;
      if(client.field474 && client.field346) {
         int var0 = class143.field2206;
         int var1 = class143.field2209;
         var0 -= client.field387;
         var1 -= client.field472;
         if(var0 < client.field543) {
            var0 = client.field543;
         }

         if(var0 + client.field466.field2822 > client.field543 + client.field397.field2822) {
            var0 = client.field397.field2822 + client.field543 - client.field466.field2822;
         }

         if(var1 < client.field295) {
            var1 = client.field295;
         }

         if(client.field466.field2823 + var1 > client.field295 + client.field397.field2823) {
            var1 = client.field397.field2823 + client.field295 - client.field466.field2823;
         }

         int var2 = var0 - client.field347;
         int var3 = var1 - client.field476;
         int var4 = client.field466.field2939;
         if(class188.field3055 > client.field466.field2884 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            client.field390 = true;
         }

         int var5 = var0 - client.field543 + client.field397.field2864;
         int var6 = var1 - client.field295 + client.field397.field2850;
         class0 var7;
         if(null != client.field466.field2928 && client.field390) {
            var7 = new class0();
            var7.field2 = client.field466;
            var7.field5 = var5;
            var7.field4 = var6;
            var7.field8 = client.field466.field2928;
            class16.method203(var7);
         }

         if(class143.field2207 == 0) {
            if(client.field390) {
               if(client.field466.field2897 != null) {
                  var7 = new class0();
                  var7.field2 = client.field466;
                  var7.field5 = var5;
                  var7.field4 = var6;
                  var7.field6 = client.field470;
                  var7.field8 = client.field466.field2897;
                  class16.method203(var7);
               }

               if(null != client.field470 && class44.method935(client.field466) != null) {
                  client.field337.method2903(29);
                  client.field337.method2666(client.field470.field2879);
                  client.field337.method2668(client.field470.field2813);
                  client.field337.method2666(client.field466.field2879);
                  client.field337.method2675(client.field466.field2807);
                  client.field337.method2619(client.field466.field2813);
                  client.field337.method2677(client.field470.field2807);
               }
            } else if((client.field412 == 1 || class29.method680(client.field368 - 1)) && client.field368 > 2) {
               class172.method3514(client.field387 + client.field347, client.field476 + client.field472);
            } else if(client.field368 > 0) {
               int var9 = client.field347 + client.field387;
               int var8 = client.field472 + client.field476;
               class132.method2973(class75.field1423, var9, var8);
               class75.field1423 = null;
            }

            client.field466 = null;
         }

      } else {
         if(class188.field3055 > 1) {
            client.field466 = null;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILclass42;IB)V",
      garbageValue = "0"
   )
   static void method2492(int var0, int var1, int var2, class42 var3, int var4) {
      class24 var5 = new class24();
      var5.field621 = var0;
      var5.field635 = var1 * 128;
      var5.field623 = var2 * 128;
      int var6 = var3.field960;
      int var7 = var3.field970;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field970;
         var7 = var3.field960;
      }

      var5.field624 = (var1 + var6) * 128;
      var5.field628 = (var2 + var7) * 128;
      var5.field627 = var3.field989;
      var5.field626 = var3.field990 * 128;
      var5.field631 = var3.field967;
      var5.field625 = var3.field992;
      var5.field629 = var3.field993;
      if(var3.field986 != null) {
         var5.field634 = var3;
         var5.method603();
      }

      class24.field630.method3963(var5);
      if(var5.field629 != null) {
         var5.field632 = var5.field631 + (int)(Math.random() * (double)(var5.field625 - var5.field631));
      }

   }
}
