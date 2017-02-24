import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public abstract class class156 {
   @ObfuscatedName("d")
   static boolean field2120 = false;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "-26"
   )
   abstract byte[] vmethod3042();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1187628193"
   )
   abstract void vmethod3045(byte[] var1);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "956467202"
   )
   static void method3053(GameEngine var0) {
      if(class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4) {
         int var1 = 280 + class41.field839;
         if(class115.field1796 >= var1 && class115.field1796 <= 14 + var1 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(0, 0);
            return;
         }

         if(class115.field1796 >= 15 + var1 && class115.field1796 <= 80 + var1 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(0, 1);
            return;
         }

         int var2 = class41.field839 + 390;
         if(class115.field1796 >= var2 && class115.field1796 <= var2 + 14 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(1, 0);
            return;
         }

         if(class115.field1796 >= var2 + 15 && class115.field1796 <= 80 + var2 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(1, 1);
            return;
         }

         int var3 = 500 + class41.field839;
         if(class115.field1796 >= var3 && class115.field1796 <= var3 + 14 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(2, 0);
            return;
         }

         if(class115.field1796 >= var3 + 15 && class115.field1796 <= 80 + var3 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(2, 1);
            return;
         }

         int var4 = 610 + class41.field839;
         if(class115.field1796 >= var4 && class115.field1796 <= 14 + var4 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(3, 0);
            return;
         }

         if(class115.field1796 >= 15 + var4 && class115.field1796 <= 80 + var4 && class115.field1806 >= 4 && class115.field1806 <= 18) {
            class7.method93(3, 1);
            return;
         }

         if(class115.field1796 >= 708 + class41.field839 && class115.field1806 >= 4 && class115.field1796 <= 50 + 708 + class41.field839 && class115.field1806 <= 20) {
            class41.worldSelectShown = false;
            class5.field60.method4171(class41.field839, 0);
            XGrandExchangeOffer.field57.method4171(class41.field839 + 382, 0);
            XGrandExchangeOffer.field46.method4122(class41.field839 + 382 - XGrandExchangeOffer.field46.originalWidth / 2, 18);
            return;
         }

         if(class41.field868 != -1) {
            World var5 = World.worldList[class41.field868];
            Spotanim.method3482(var5);
            class41.worldSelectShown = false;
            class5.field60.method4171(class41.field839, 0);
            XGrandExchangeOffer.field57.method4171(class41.field839 + 382, 0);
            XGrandExchangeOffer.field46.method4122(class41.field839 + 382 - XGrandExchangeOffer.field46.originalWidth / 2, 18);
            return;
         }
      }

   }
}
