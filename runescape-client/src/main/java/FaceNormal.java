import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Lbz;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1965721985
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -688009131
   )
   @Export("y")
   int y;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -966970701
   )
   @Export("z")
   int z;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfd;Lgr;B)Lgg;",
      garbageValue = "-102"
   )
   public static PacketNode method3078(ClientPacket var0, ISAACCipher var1) {
      PacketNode var2;
      if(PacketNode.field2496 == 0) {
         var2 = new PacketNode();
      } else {
         var2 = PacketNode.packetBufferNodes[--PacketNode.field2496];
      }

      var2.clientPacket = var0;
      var2.field2492 = var0.packetLength;
      if(var2.field2492 == -1) {
         var2.packetBuffer = new PacketBuffer(260);
      } else if(var2.field2492 == -2) {
         var2.packetBuffer = new PacketBuffer(10000);
      } else if(var2.field2492 <= 18) {
         var2.packetBuffer = new PacketBuffer(20);
      } else if(var2.field2492 <= 98) {
         var2.packetBuffer = new PacketBuffer(100);
      } else {
         var2.packetBuffer = new PacketBuffer(260);
      }

      var2.packetBuffer.setIsaacCipher(var1);
      var2.packetBuffer.putOpcode(var2.clientPacket.packetId);
      var2.field2494 = 0;
      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "0"
   )
   static int method3077(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--SceneTilePaint.intStackSize];
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--SceneTilePaint.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
               if(Client.grandExchangeEvents != null) {
                  Client.grandExchangeEvents.sort(GrandExchangeEvents.field268, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
               if(Client.grandExchangeEvents != null) {
                  Client.grandExchangeEvents.sort(GrandExchangeEvents.field267, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               SceneTilePaint.intStackSize -= 2;
               var13 = class81.intStack[SceneTilePaint.intStackSize] == 1;
               boolean var4 = class81.intStack[SceneTilePaint.intStackSize + 1] == 1;
               if(Client.grandExchangeEvents != null) {
                  Client.field1057.field854 = var4;
                  Client.grandExchangeEvents.sort(Client.field1057, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
               if(Client.grandExchangeEvents != null) {
                  Client.grandExchangeEvents.sort(GrandExchangeEvents.field271, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
               if(Client.grandExchangeEvents != null) {
                  Client.grandExchangeEvents.sort(GrandExchangeEvents.field270, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.grandExchangeEvents == null?0:Client.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var11.method92();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var11.method88();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  long var5 = ScriptVarType.method28() - class265.field3431 - var11.field278;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--SceneTilePaint.intStackSize];
                  var11 = (GrandExchangeEvent)Client.grandExchangeEvents.events.get(var3);
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   static void method3076() {
      Client.field902.method2036(method3078(ClientPacket.field2380, Client.field902.field1475));
      Client.field930 = 0;
   }
}
