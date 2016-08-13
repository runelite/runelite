import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public abstract class class110 {
   @ObfuscatedName("eq")
   static ModIcon[] field1947;
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
      signature = "(IIILCollisionData;S)Z",
      garbageValue = "150"
   )
   protected abstract boolean vmethod2486(int var1, int var2, int var3, CollisionData var4);

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

      int var6 = Client.field548 + (Client.field549 - Client.field548) * var5 / 100;
      int var7 = 512 * var6 * var3 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.field320) {
         var10 = Client.field320;
         var6 = 334 * var10 * var2 / (512 * var3);
         if(var6 > Client.field492) {
            var6 = Client.field492;
            var8 = 512 * var3 * var6 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1880();
               class82.method1907(var0, var1, var9, var3, -16777216);
               class82.method1907(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field563) {
         var10 = Client.field563;
         var6 = 334 * var10 * var2 / (512 * var3);
         if(var6 < Client.field552) {
            var6 = Client.field552;
            var8 = var2 * var10 * 334 / (512 * var6);
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

      var8 = (Client.field551 - Client.field359) * var5 / 100 + Client.field359;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(var2 != Client.camera2 || Client.camera3 != var3) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = 15 + var12 * 32 + 128;
            int var14 = var13 * 3 + 600;
            int var15 = class94.field1661[var13];
            var11[var12] = var15 * var14 >> 16;
         }

         Region.method2037(var11, 500, 800, var2, var3);
      }

      Client.field556 = var0;
      Client.field557 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "58063347"
   )
   public static class45 method2488(int var0) {
      class45 var1 = (class45)class45.field1035.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class45.field1034.method3411(13, var0);
         var1 = new class45();
         var1.field1037 = var0;
         if(var2 != null) {
            var1.method951(new Buffer(var2));
         }

         class45.field1035.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-44165223"
   )
   static final void method2490() {
      class79.method1777(Client.field466);
      ++class188.field3055;
      if(Client.field474 && Client.field346) {
         int var0 = class143.field2206;
         int var1 = class143.field2209;
         var0 -= Client.field387;
         var1 -= Client.field472;
         if(var0 < Client.field543) {
            var0 = Client.field543;
         }

         if(var0 + Client.field466.width > Client.field543 + Client.field397.width) {
            var0 = Client.field397.width + Client.field543 - Client.field466.width;
         }

         if(var1 < Client.field295) {
            var1 = Client.field295;
         }

         if(Client.field466.height + var1 > Client.field295 + Client.field397.height) {
            var1 = Client.field397.height + Client.field295 - Client.field466.height;
         }

         int var2 = var0 - Client.field347;
         int var3 = var1 - Client.field476;
         int var4 = Client.field466.field2939;
         if(class188.field3055 > Client.field466.field2884 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field390 = true;
         }

         int var5 = var0 - Client.field543 + Client.field397.itemId;
         int var6 = var1 - Client.field295 + Client.field397.scrollY;
         class0 var7;
         if(null != Client.field466.field2928 && Client.field390) {
            var7 = new class0();
            var7.field2 = Client.field466;
            var7.field5 = var5;
            var7.field4 = var6;
            var7.field8 = Client.field466.field2928;
            class16.method203(var7);
         }

         if(class143.field2207 == 0) {
            if(Client.field390) {
               if(Client.field466.field2897 != null) {
                  var7 = new class0();
                  var7.field2 = Client.field466;
                  var7.field5 = var5;
                  var7.field4 = var6;
                  var7.field6 = Client.field470;
                  var7.field8 = Client.field466.field2897;
                  class16.method203(var7);
               }

               if(null != Client.field470 && Sequence.method935(Client.field466) != null) {
                  Client.field337.method2903(29);
                  Client.field337.method2666(Client.field470.item);
                  Client.field337.method2668(Client.field470.index);
                  Client.field337.method2666(Client.field466.item);
                  Client.field337.method2675(Client.field466.id);
                  Client.field337.method2619(Client.field466.index);
                  Client.field337.method2677(Client.field470.id);
               }
            } else if((Client.field412 == 1 || ChatLineBuffer.method680(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               class172.method3514(Client.field387 + Client.field347, Client.field476 + Client.field472);
            } else if(Client.menuOptionCount > 0) {
               int var8 = Client.field347 + Client.field387;
               int var9 = Client.field472 + Client.field476;
               class132.method2973(class75.field1423, var8, var9);
               class75.field1423 = null;
            }

            Client.field466 = null;
         }
      } else if(class188.field3055 > 1) {
         Client.field466 = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;IB)V",
      garbageValue = "0"
   )
   static void method2492(int var0, int var1, int var2, ObjectComposition var3, int var4) {
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
      if(var3.impostorIds != null) {
         var5.field634 = var3;
         var5.method603();
      }

      class24.field630.method3963(var5);
      if(var5.field629 != null) {
         var5.field632 = var5.field631 + (int)(Math.random() * (double)(var5.field625 - var5.field631));
      }

   }
}
