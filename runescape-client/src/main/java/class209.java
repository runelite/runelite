import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class209 {
   @ObfuscatedName("d")
   byte[] field2588;
   @ObfuscatedName("x")
   byte[] field2585;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1492364017
   )
   int field2593;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1644148619
   )
   int field2592;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -851752569
   )
   int field2587;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 840864273
   )
   int field2589;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1321848455
   )
   int field2590;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1718237069
   )
   int field2591;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1785749747
   )
   int field2586;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "7"
   )
   static void method3829(Component var0) {
      var0.removeKeyListener(KeyFocusListener.keyboard);
      var0.removeFocusListener(KeyFocusListener.keyboard);
      KeyFocusListener.field614 = -1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "14722447"
   )
   static void method3827() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3308 == 0) {
            class184.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            class184.IndexStoreActionHandler_thread.setDaemon(true);
            class184.IndexStoreActionHandler_thread.start();
            class184.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3308 = 600;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILce;ZB)I",
      garbageValue = "38"
   )
   static int method3828(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         ItemContainer var8;
         if(var0 == 3301) {
            GrandExchangeEvents.intStackSize -= 2;
            var3 = class82.intStack[GrandExchangeEvents.intStackSize];
            var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
            var5 = class82.intStack;
            var6 = ++GrandExchangeEvents.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            GrandExchangeEvents.intStackSize -= 2;
            var3 = class82.intStack[GrandExchangeEvents.intStackSize];
            var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
            var5 = class82.intStack;
            var6 = ++GrandExchangeEvents.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = 0;
            } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
               var7 = var8.stackSizes[var4];
            } else {
               var7 = 0;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3303) {
            GrandExchangeEvents.intStackSize -= 2;
            var3 = class82.intStack[GrandExchangeEvents.intStackSize];
            var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
            class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class96.method1898(var3, var4);
            return 1;
         } else if(var0 == 3304) {
            var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
            class82.intStack[++GrandExchangeEvents.intStackSize - 1] = AttackOption.method1777(var3).size;
            return 1;
         } else if(var0 == 3305) {
            var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
            class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.boostedSkillLevels[var3];
            return 1;
         } else if(var0 == 3306) {
            var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
            class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.realSkillLevels[var3];
            return 1;
         } else if(var0 == 3307) {
            var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
            class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.skillExperiences[var3];
            return 1;
         } else {
            int var9;
            if(var0 == 3308) {
               var3 = class233.plane;
               var4 = (class181.localPlayer.x >> 7) + IndexDataBase.baseX;
               var9 = (class181.localPlayer.y >> 7) + Occluder.baseY;
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = (var4 << 14) + var9 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class82.intStack[--GrandExchangeEvents.intStackSize];
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               GrandExchangeEvents.intStackSize -= 2;
               var3 = class82.intStack[GrandExchangeEvents.intStackSize] + 32768;
               var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
               var5 = class82.intStack;
               var6 = ++GrandExchangeEvents.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = -1;
               } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                  var7 = var8.itemIds[var4];
               } else {
                  var7 = -1;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 != 3314) {
               if(var0 == 3315) {
                  GrandExchangeEvents.intStackSize -= 2;
                  var3 = class82.intStack[GrandExchangeEvents.intStackSize] + 32768;
                  var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = class96.method1898(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.rights;
                  } else {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.field931;
                  return 1;
               } else if(var0 == 3318) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field1079) {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 1;
                  } else {
                     class82.intStack[++GrandExchangeEvents.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = Client.flags;
                  return 1;
               } else if(var0 == 3325) {
                  GrandExchangeEvents.intStackSize -= 4;
                  var3 = class82.intStack[GrandExchangeEvents.intStackSize];
                  var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
                  var9 = class82.intStack[GrandExchangeEvents.intStackSize + 2];
                  var6 = class82.intStack[GrandExchangeEvents.intStackSize + 3];
                  var3 += var4 << 14;
                  var3 += var9 << 28;
                  var3 += var6;
                  class82.intStack[++GrandExchangeEvents.intStackSize - 1] = var3;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               GrandExchangeEvents.intStackSize -= 2;
               var3 = class82.intStack[GrandExchangeEvents.intStackSize] + 32768;
               var4 = class82.intStack[GrandExchangeEvents.intStackSize + 1];
               var5 = class82.intStack;
               var6 = ++GrandExchangeEvents.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }
}
