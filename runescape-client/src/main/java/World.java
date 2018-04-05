import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("World")
public class World {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lbg;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -424784559
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -14543449
   )
   static int field1228;
   @ObfuscatedName("i")
   static int[] field1229;
   @ObfuscatedName("u")
   static int[] field1230;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1897600479
   )
   @Export("id")
   int id;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1012104283
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1050559099
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("n")
   @Export("address")
   String address;
   @ObfuscatedName("l")
   @Export("activity")
   String activity;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1410695007
   )
   @Export("location")
   int location;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 787163651
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1228 = 0;
      field1229 = new int[]{1, 1, 1, 1};
      field1230 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1781168548"
   )
   boolean method1683() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-5"
   )
   boolean method1684() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1581657485"
   )
   boolean method1685() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "836677950"
   )
   boolean method1686() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-52"
   )
   boolean method1687() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-88"
   )
   boolean method1688() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lei;IIII)V",
      garbageValue = "-2017413840"
   )
   public static final void method1723(Model var0, int var1, int var2, int var3) {
      if(SoundTask.boundingBox3DContainsMouse(var0, var1, var2, var3)) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -65281));
      } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
         class7.boundingBoxes.addFirst(new BoundingBox3D(var0, var1, var2, var3, -16776961));
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1905996853"
   )
   public static int method1701(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-857965030"
   )
   static int method1695(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         class81.intStack[++WorldComparator.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++WorldComparator.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++WorldComparator.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++WorldComparator.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--WorldComparator.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++WorldComparator.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--WorldComparator.intStackSize] == 1;
               if(class55.grandExchangeEvents != null) {
                  class55.grandExchangeEvents.sort(GrandExchangeEvents.field285, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--WorldComparator.intStackSize] == 1;
               if(class55.grandExchangeEvents != null) {
                  class55.grandExchangeEvents.sort(GrandExchangeEvents.field290, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               WorldComparator.intStackSize -= 2;
               var13 = class81.intStack[WorldComparator.intStackSize] == 1;
               boolean var4 = class81.intStack[WorldComparator.intStackSize + 1] == 1;
               if(class55.grandExchangeEvents != null) {
                  Client.field1134.field865 = var4;
                  class55.grandExchangeEvents.sort(Client.field1134, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--WorldComparator.intStackSize] == 1;
               if(class55.grandExchangeEvents != null) {
                  class55.grandExchangeEvents.sort(GrandExchangeEvents.field283, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--WorldComparator.intStackSize] == 1;
               if(class55.grandExchangeEvents != null) {
                  class55.grandExchangeEvents.sort(GrandExchangeEvents.field288, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++WorldComparator.intStackSize - 1] = class55.grandExchangeEvents == null?0:class55.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.intStack[++WorldComparator.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var11.method81();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var11.method79();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  long var5 = class64.method1118() - class71.field834 - var11.field292;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++KeyFocusListener.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.intStack[++WorldComparator.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.intStack[++WorldComparator.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--WorldComparator.intStackSize];
                  var11 = (GrandExchangeEvent)class55.grandExchangeEvents.events.get(var3);
                  class81.intStack[++WorldComparator.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-259070536"
   )
   public static void method1724(boolean var0) {
      if(var0 != class158.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         class158.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-140326637"
   )
   static boolean method1722() {
      return (Client.playerNameMask & 2) != 0;
   }
}
