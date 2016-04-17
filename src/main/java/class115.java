import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class115 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 4767978062513014489L
   )
   static long field1970;
   @ObfuscatedName("e")
   static class80 field1971;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 3426642628526266425L
   )
   static long field1972;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass144;B)V",
      garbageValue = "44"
   )
   static void method2547(class144 var0) {
      if(1 == class140.field2157 || !class7.field143 && 4 == class140.field2157) {
         int var1 = class31.field723 + 280;
         if(class140.field2160 >= var1 && class140.field2160 <= 14 + var1 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(0, 0);
            return;
         }

         if(class140.field2160 >= var1 + 15 && class140.field2160 <= var1 + 80 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(0, 1);
            return;
         }

         int var2 = 390 + class31.field723;
         if(class140.field2160 >= var2 && class140.field2160 <= 14 + var2 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(1, 0);
            return;
         }

         if(class140.field2160 >= 15 + var2 && class140.field2160 <= var2 + 80 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(1, 1);
            return;
         }

         int var3 = 500 + class31.field723;
         if(class140.field2160 >= var3 && class140.field2160 <= var3 + 14 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(2, 0);
            return;
         }

         if(class140.field2160 >= 15 + var3 && class140.field2160 <= 80 + var3 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(2, 1);
            return;
         }

         int var4 = class31.field723 + 610;
         if(class140.field2160 >= var4 && class140.field2160 <= var4 + 14 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(3, 0);
            return;
         }

         if(class140.field2160 >= 15 + var4 && class140.field2160 <= var4 + 80 && class140.field2159 >= 4 && class140.field2159 <= 18) {
            class50.method1112(3, 1);
            return;
         }

         if(class140.field2160 >= class31.field723 + 708 && class140.field2159 >= 4 && class140.field2160 <= 708 + class31.field723 + 50 && class140.field2159 <= 20) {
            class31.field748 = false;
            class31.field727.method1796(class31.field723, 0);
            class31.field728.method1796(class31.field723 + 382, 0);
            class30.field715.method1962(382 + class31.field723 - class30.field715.field1419 / 2, 18);
            return;
         }

         if(class31.field755 != -1) {
            class25 var5 = class129.field2051[class31.field755];
            class35.method821(var5);
            class31.field748 = false;
            class31.field727.method1796(class31.field723, 0);
            class31.field728.method1796(class31.field723 + 382, 0);
            class30.field715.method1962(382 + class31.field723 - class30.field715.field1419 / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass212;I)I",
      garbageValue = "1665278372"
   )
   static final int method2551(class212 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3148) {
         case 6:
            return 20;
         default:
            return 12;
         }
      }
   }
}
