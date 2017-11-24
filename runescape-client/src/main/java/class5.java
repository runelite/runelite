import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class5 implements class0 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1601924960"
   )
   public static void method20() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "-122"
   )
   static int method19(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var4 + var3;
         return 1;
      } else if(var0 == 4001) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class82.intStack[--class13.intStackSize];
         class82.intStack[++class13.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class82.intStack[--class13.intStackSize];
         class82.intStack[++class13.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class13.intStackSize -= 5;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         int var5 = class82.intStack[class13.intStackSize + 2];
         int var6 = class82.intStack[class13.intStackSize + 3];
         int var7 = class82.intStack[class13.intStackSize + 4];
         class82.intStack[++class13.intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 + var4 * var3 / 100;
         return 1;
      } else if(var0 == 4008) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class13.intStackSize - 1] = 0;
         } else {
            class82.intStack[++class13.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class13.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class82.intStack[++class13.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class82.intStack[++class13.intStackSize - 1] = var3;
               break;
            case 2:
               class82.intStack[++class13.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class82.intStack[++class13.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class82.intStack[++class13.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class82.intStack[++class13.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class13.intStackSize -= 2;
         var3 = class82.intStack[class13.intStackSize];
         var4 = class82.intStack[class13.intStackSize + 1];
         class82.intStack[++class13.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class13.intStackSize -= 3;
         long var9 = (long)class82.intStack[class13.intStackSize];
         long var11 = (long)class82.intStack[class13.intStackSize + 1];
         long var13 = (long)class82.intStack[class13.intStackSize + 2];
         class82.intStack[++class13.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }
}
