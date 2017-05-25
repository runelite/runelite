import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class31 {
   @ObfuscatedName("hy")
   @ObfuscatedGetter(
      intValue = 517821809
   )
   static int field439;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2125906299
   )
   final int field440;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1643991493
   )
   final int field441;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1996954985
   )
   final int field445;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 346311287
   )
   static int field446;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "349834550"
   )
   static int method266(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         class83.intStack[++class83.intStackSize - 1] = var3 + var4;
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
         class83.intStack[++class83.intStackSize - 1] = var3 * var4;
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
         class83.intStack[++class83.intStackSize - 1] = (var4 - var3) * (var7 - var5) / (var6 - var5) + var3;
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

   class31(int var1, int var2, int var3) {
      this.field445 = var1;
      this.field440 = var2;
      this.field441 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2116777066"
   )
   static int method267(int var0, Script var1, boolean var2) {
      Widget var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++class83.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++class83.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++class83.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++class83.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-619366965"
   )
   static final void method269(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            if(var6) {
               Client.field1037 = Client.menuOptionCount;
            }

            ++Client.menuOptionCount;
         }

      }
   }
}
