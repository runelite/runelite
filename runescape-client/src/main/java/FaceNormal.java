import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("p")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1687388991
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1647043993
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1365181493
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1904629145
   )
   @Export("z")
   int z;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lii;",
      garbageValue = "-1891722244"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.items.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.item_ref.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.post();
         if(var1.notedTemplate != -1) {
            var1.method4658(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4695(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.field3543 != -1) {
            var1.method4704(getItemDefinition(var1.field3543), getItemDefinition(var1.field3528));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3526 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3537 = 0;
            if(var1.field3510 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3510.getHead(); var4 != null; var4 = var1.field3510.getTail()) {
                  class251 var5 = class182.method3532((int)var4.hash);
                  if(var5.field3389) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3510 = null;
               }
            }
         }

         ItemComposition.items.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "-64"
   )
   static int method2902(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].method100();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.intStack[++class278.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--class278.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class278.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--class278.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class278.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--class278.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class278.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--class278.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method99();
            class81.intStack[++class278.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--class278.intStackSize] == 1;
               if(class207.field2580 != null) {
                  class207.field2580.method75(class13.field289, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--class278.intStackSize] == 1;
               if(class207.field2580 != null) {
                  class207.field2580.method75(class13.field286, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class278.intStackSize -= 2;
               var13 = class81.intStack[class278.intStackSize] == 1;
               boolean var4 = class81.intStack[class278.intStackSize + 1] == 1;
               if(class207.field2580 != null) {
                  class207.field2580.method75(new class93(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--class278.intStackSize] == 1;
               if(class207.field2580 != null) {
                  class207.field2580.method75(class13.field285, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--class278.intStackSize] == 1;
               if(class207.field2580 != null) {
                  class207.field2580.method75(class13.field288, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++class278.intStackSize - 1] = class207.field2580 == null?0:class207.field2580.field290.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.intStack[++class278.intStackSize - 1] = var11.field296;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var11.method84();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var11.method82();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  long var5 = class174.currentTimeMs() - class31.field457 - var11.field293;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.intStack[++class278.intStackSize - 1] = var11.field294.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.intStack[++class278.intStackSize - 1] = var11.field294.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--class278.intStackSize];
                  var11 = (class14)class207.field2580.field290.get(var3);
                  class81.intStack[++class278.intStackSize - 1] = var11.field294.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "-92"
   )
   static final void method2904(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.field1161[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }
}
