import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class67 extends class196 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -379164305
   )
   int field830;
   @ObfuscatedName("c")
   String field831;
   @ObfuscatedName("jh")
   @ObfuscatedGetter(
      intValue = -2007399023
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("bg")
   static String field833;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1501244789
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("e")
   short field835;

   class67(String var1, int var2) {
      this.field830 = (int)(XGrandExchangeOffer.method96() / 1000L);
      this.field831 = var1;
      this.field835 = (short)var2;
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1679970097"
   )
   static final int method1080() {
      return Client.menuOptionCount <= 0?-1:(Client.field1078 && class50.field645[81] && Client.field1090 != -1?Client.field1090:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-45"
   )
   static int method1081(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var4 + var3;
         return 1;
      } else if(var0 == 4001) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var4 * var3;
         return 1;
      } else if(var0 == 4003) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class83.intStackSize -= 5;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var5 = class83.intStack[class83.intStackSize + 2];
         int var6 = class83.intStack[class83.intStackSize + 3];
         int var7 = class83.intStack[class83.intStackSize + 4];
         class83.intStack[++class83.intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 * var4 / 100 + var3;
         return 1;
      } else if(var0 == 4008) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         if(var3 == 0) {
            class83.intStack[++class83.intStackSize - 1] = 0;
         } else if(var4 == 0) {
            class83.intStack[++class83.intStackSize - 1] = Integer.MAX_VALUE;
         } else {
            class83.intStack[++class83.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
         }

         return 1;
      } else if(var0 == 4014) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class83.intStackSize -= 3;
         long var11 = (long)class83.intStack[class83.intStackSize];
         long var13 = (long)class83.intStack[class83.intStackSize + 1];
         long var9 = (long)class83.intStack[class83.intStackSize + 2];
         class83.intStack[++class83.intStackSize - 1] = (int)(var9 * var11 / var13);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(Lclass76;I)V",
      garbageValue = "-883196519"
   )
   static final void method1083(class76 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field1216 == 0) {
         var1 = class1.region.method2704(var0.field1225, var0.field1217, var0.field1224);
      }

      if(var0.field1216 == 1) {
         var1 = class1.region.method2701(var0.field1225, var0.field1217, var0.field1224);
      }

      if(var0.field1216 == 2) {
         var1 = class1.region.method2702(var0.field1225, var0.field1217, var0.field1224);
      }

      if(var0.field1216 == 3) {
         var1 = class1.region.method2703(var0.field1225, var0.field1217, var0.field1224);
      }

      if(var1 != 0) {
         int var5 = class1.region.method2835(var0.field1225, var0.field1217, var0.field1224, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1222 = var2;
      var0.field1221 = var3;
      var0.field1220 = var4;
   }
}
