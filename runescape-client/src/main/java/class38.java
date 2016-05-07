import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class38 extends class207 {
   @ObfuscatedName("p")
   short field874;
   @ObfuscatedName("j")
   String field875;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 389432139
   )
   int field877 = (int)(class12.method162() / 1000L);
   @ObfuscatedName("po")
   public static class136 field878;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-1097"
   )
   static boolean method734() {
      try {
         if(null == class87.field1537) {
            class87.field1537 = new class18(field878, new URL(client.field481));
         } else {
            byte[] var0 = class87.field1537.method207();
            if(var0 != null) {
               class119 var1 = new class119(var0);
               class25.field628 = var1.method2584();
               class25.field636 = new class25[class25.field628];

               class25 var3;
               for(int var2 = 0; var2 < class25.field628; var3.field638 = var2++) {
                  var3 = class25.field636[var2] = new class25();
                  var3.field632 = var1.method2584();
                  var3.field633 = var1.method2497();
                  var3.field635 = var1.method2500();
                  var3.field641 = var1.method2500();
                  var3.field637 = var1.method2492();
                  var3.field634 = var1.method2495();
               }

               class7.method100(class25.field636, 0, class25.field636.length - 1, class25.field631, class25.field627);
               class87.field1537 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class87.field1537 = null;
      }

      return false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lclass82;",
      garbageValue = "-1593921584"
   )
   public static class82[] method735() {
      return new class82[]{class82.field1436, class82.field1441, class82.field1437, class82.field1434, class82.field1435};
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-324294347"
   )
   static final void method736(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(client.field493 && var0 != class21.field581) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = client.field339.method1964(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = client.field339.method1922(var0, var2, var3);
         }

         if(2 == var1) {
            var7 = client.field339.method1944(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = client.field339.method1924(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = client.field339.method1925(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            class40 var12;
            if(var1 == 0) {
               client.field339.method1900(var0, var2, var3);
               var12 = class9.method120(var13);
               if(var12.field941 != 0) {
                  client.field340[var0].method2408(var2, var3, var14, var15, var12.field963);
               }
            }

            if(var1 == 1) {
               client.field339.method1913(var0, var2, var3);
            }

            if(2 == var1) {
               client.field339.method1914(var0, var2, var3);
               var12 = class9.method120(var13);
               if(var2 + var12.field939 > 103 || var12.field939 + var3 > 103 || var2 + var12.field966 > 103 || var3 + var12.field966 > 103) {
                  return;
               }

               if(0 != var12.field941) {
                  client.field340[var0].method2379(var2, var3, var12.field939, var12.field966, var15, var12.field963);
               }
            }

            if(3 == var1) {
               client.field339.method1915(var0, var2, var3);
               var12 = class9.method120(var13);
               if(1 == var12.field941) {
                  client.field340[var0].method2381(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && 2 == (class5.field90[1][var2][var3] & 2)) {
               var11 = var0 + 1;
            }

            class11.method154(var0, var11, var2, var3, var4, var5, var6, client.field339, client.field340[var0]);
         }
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "1"
   )
   static final void method737(class3 var0, boolean var1) {
      int var2 = var0.field69;
      int var3 = (int)var0.field3125;
      var0.method3898();
      class1.method8(var2);
      class113.method2434(var2);
      class173 var4 = class29.method645(var3);
      if(var4 != null) {
         class34.method701(var4);
      }

      class6.method96();
      if(-1 != client.field412) {
         class87.method2065(client.field412, 1);
      }

   }

   class38(String var1, int var2) {
      this.field875 = var1;
      this.field874 = (short)var2;
   }
}
