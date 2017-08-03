import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class210 extends CacheableNode {
   @ObfuscatedName("y")
   public final int[] field2578;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1451912833
   )
   public final int field2580;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -341233541
   )
   public final int field2581;
   @ObfuscatedName("x")
   public final int[] field2579;

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2580 = var1;
      this.field2581 = var2;
      this.field2579 = var3;
      this.field2578 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-108"
   )
   public boolean method3933(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2578.length) {
         int var3 = this.field2578[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2579[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "644811150"
   )
   static int method3932(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].method97();
         return 1;
      } else if(var0 == 3904) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class83.intStack[--class83.intStackSize];
         class83.intStack[++class83.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method103();
            class83.intStack[++class83.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method103();
            class83.intStack[++class83.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method103();
            class83.intStack[++class83.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class83.intStack[--class83.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method103();
            class83.intStack[++class83.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(CombatInfo2.field3350 != null) {
                  CombatInfo2.field3350.method73(class13.field275, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(CombatInfo2.field3350 != null) {
                  CombatInfo2.field3350.method73(class13.field266, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class83.intStackSize -= 2;
               var13 = class83.intStack[class83.intStackSize] == 1;
               boolean var4 = 1 == class83.intStack[class83.intStackSize + 1];
               if(CombatInfo2.field3350 != null) {
                  CombatInfo2.field3350.method73(new class95(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(CombatInfo2.field3350 != null) {
                  CombatInfo2.field3350.method73(class13.field265, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class83.intStack[--class83.intStackSize] == 1;
               if(CombatInfo2.field3350 != null) {
                  CombatInfo2.field3350.method73(class13.field268, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class83.intStack[++class83.intStackSize - 1] = CombatInfo2.field3350 == null?0:CombatInfo2.field3350.field270.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field277;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var11.method79();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var11.method83();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  long var5 = BuildType.currentTimeMs() - class51.field622 - var11.field278;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field279.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field279.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class83.intStack[--class83.intStackSize];
                  var11 = (class14)CombatInfo2.field3350.field270.get(var3);
                  class83.intStack[++class83.intStackSize - 1] = var11.field279.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
