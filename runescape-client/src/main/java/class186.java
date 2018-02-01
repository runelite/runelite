import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class186 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -7189931444462308239L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -2972310713895581771L
   )
   @Export("currentTimeMsOffset")
   static long currentTimeMsOffset;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1342826619
   )
   public static int field2505;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lfa;",
      garbageValue = "0"
   )
   public static PacketNode method3627() {
      return PacketNode.field2404 == 0?new PacketNode():PacketNode.packetBufferNodes[--PacketNode.field2404];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "411268024"
   )
   static int method3626(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.intStack[++class80.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class80.intStack[--class80.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class80.intStack[++class80.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(Varcs.grandExchangeEvents != null) {
                  Varcs.grandExchangeEvents.sort(GrandExchangeEvents.field267, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(Varcs.grandExchangeEvents != null) {
                  Varcs.grandExchangeEvents.sort(GrandExchangeEvents.field266, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class80.intStackSize -= 2;
               var13 = class80.intStack[class80.intStackSize] == 1;
               boolean var4 = class80.intStack[class80.intStackSize + 1] == 1;
               if(Varcs.grandExchangeEvents != null) {
                  Client.field841.field820 = var4;
                  Varcs.grandExchangeEvents.sort(Client.field841, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(Varcs.grandExchangeEvents != null) {
                  Varcs.grandExchangeEvents.sort(GrandExchangeEvents.field271, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class80.intStack[--class80.intStackSize] == 1;
               if(Varcs.grandExchangeEvents != null) {
                  Varcs.grandExchangeEvents.sort(GrandExchangeEvents.field268, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class80.intStack[++class80.intStackSize - 1] = Varcs.grandExchangeEvents == null?0:Varcs.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var11.method92();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var11.method91();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  long var5 = ScriptVarType.currentTimeMs() - class37.field473 - var11.field275;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class80.intStack[--class80.intStackSize];
                  var11 = (GrandExchangeEvent)Varcs.grandExchangeEvents.events.get(var3);
                  class80.intStack[++class80.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
