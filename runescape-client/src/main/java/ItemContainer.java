import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("aq")
   static FontMetrics field737;
   @ObfuscatedName("s")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("r")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1602269656"
   )
   static int method1016(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1846();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1031199157"
   )
   static int method1003(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 4000) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var4 + var3;
         return 1;
      } else if(var0 == 4001) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 * var4;
         return 1;
      } else if(var0 == 4003) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class82.intStackSize -= 5;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         int var5 = class82.intStack[class82.intStackSize + 2];
         int var6 = class82.intStack[class82.intStackSize + 3];
         int var7 = class82.intStack[class82.intStackSize + 4];
         class82.intStack[++class82.intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class82.intStackSize - 1] = 0;
         } else {
            class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         if(var3 == 0) {
            class82.intStack[++class82.intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               class82.intStack[++class82.intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               class82.intStack[++class82.intStackSize - 1] = var3;
               break;
            case 2:
               class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               class82.intStack[++class82.intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               class82.intStack[++class82.intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               class82.intStack[++class82.intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         var4 = class82.intStack[class82.intStackSize + 1];
         class82.intStack[++class82.intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class82.intStackSize -= 3;
         long var9 = (long)class82.intStack[class82.intStackSize];
         long var11 = (long)class82.intStack[class82.intStackSize + 1];
         long var13 = (long)class82.intStack[class82.intStackSize + 2];
         class82.intStack[++class82.intStackSize - 1] = (int)(var13 * var9 / var11);
         return 1;
      } else {
         return 2;
      }
   }
}
