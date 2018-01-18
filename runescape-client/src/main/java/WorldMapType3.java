import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("no")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("pl")
   @ObfuscatedGetter(
      intValue = -1126744871
   )
   static int field377;
   @ObfuscatedName("fl")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1226229589
   )
   int field364;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 101385943
   )
   int field371;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1430199113
   )
   int field363;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1656113805
   )
   int field375;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 453284339
   )
   int field365;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2136348737
   )
   int field366;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1387538095
   )
   int field367;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1416218523
   )
   int field368;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -807259023
   )
   int field369;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1280452907
   )
   int field380;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -64361901
   )
   int field362;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -201280573
   )
   int field372;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1476401385
   )
   int field373;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1882315767
   )
   int field370;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1596430382"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field437 > this.field365) {
         var1.field437 = this.field365;
      }

      if(var1.field434 < this.field365) {
         var1.field434 = this.field365;
      }

      if(var1.field436 > this.field366) {
         var1.field436 = this.field366;
      }

      if(var1.field440 < this.field366) {
         var1.field440 = this.field366;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field364 && var1 < this.field364 + this.field371?var2 >= (this.field363 << 6) + (this.field367 << 3) && var2 <= (this.field363 << 6) + (this.field369 << 3) + 7 && var3 >= (this.field375 << 6) + (this.field368 << 3) && var3 <= (this.field375 << 6) + (this.field380 << 3) + 7:false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-870088204"
   )
   public boolean vmethod697(int var1, int var2) {
      return var1 >= (this.field365 << 6) + (this.field362 << 3) && var1 <= (this.field365 << 6) + (this.field373 << 3) + 7 && var2 >= (this.field366 << 6) + (this.field372 << 3) && var2 <= (this.field366 << 6) + (this.field370 << 3) + 7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "438384537"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field365 * 64 - this.field363 * 64 + var2 + (this.field362 * 8 - this.field367 * 8), var3 + (this.field366 * 64 - this.field375 * 64) + (this.field372 * 8 - this.field368 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1662378690"
   )
   public Coordinates vmethod694(int var1, int var2) {
      if(!this.vmethod697(var1, var2)) {
         return null;
      } else {
         int var3 = this.field363 * 64 - this.field365 * 64 + (this.field367 * 8 - this.field362 * 8) + var1;
         int var4 = this.field375 * 64 - this.field366 * 64 + var2 + (this.field368 * 8 - this.field372 * 8);
         return new Coordinates(this.field364, var3, var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1961822977"
   )
   public void vmethod700(Buffer var1) {
      this.field364 = var1.readUnsignedByte();
      this.field371 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedShort();
      this.field367 = var1.readUnsignedByte();
      this.field369 = var1.readUnsignedByte();
      this.field375 = var1.readUnsignedShort();
      this.field368 = var1.readUnsignedByte();
      this.field380 = var1.readUnsignedByte();
      this.field365 = var1.readUnsignedShort();
      this.field362 = var1.readUnsignedByte();
      this.field373 = var1.readUnsignedByte();
      this.field366 = var1.readUnsignedShort();
      this.field372 = var1.readUnsignedByte();
      this.field370 = var1.readUnsignedByte();
      this.method182();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-475266551"
   )
   void method182() {
   }

   @ObfuscatedName("n")
   static final int method199(double var0, double var2, double var4) {
      double var6 = var4;
      double var8 = var4;
      double var10 = var4;
      if(var2 != 0.0D) {
         double var12;
         if(var4 < 0.5D) {
            var12 = (var2 + 1.0D) * var4;
         } else {
            var12 = var2 + var4 - var2 * var4;
         }

         double var14 = 2.0D * var4 - var12;
         double var16 = 0.3333333333333333D + var0;
         if(var16 > 1.0D) {
            --var16;
         }

         double var20 = var0 - 0.3333333333333333D;
         if(var20 < 0.0D) {
            ++var20;
         }

         if(6.0D * var16 < 1.0D) {
            var6 = var16 * (var12 - var14) * 6.0D + var14;
         } else if(var16 * 2.0D < 1.0D) {
            var6 = var12;
         } else if(var16 * 3.0D < 2.0D) {
            var6 = var14 + (var12 - var14) * (0.6666666666666666D - var16) * 6.0D;
         } else {
            var6 = var14;
         }

         if(var0 * 6.0D < 1.0D) {
            var8 = 6.0D * (var12 - var14) * var0 + var14;
         } else if(2.0D * var0 < 1.0D) {
            var8 = var12;
         } else if(var0 * 3.0D < 2.0D) {
            var8 = var14 + 6.0D * (0.6666666666666666D - var0) * (var12 - var14);
         } else {
            var8 = var14;
         }

         if(var20 * 6.0D < 1.0D) {
            var10 = var20 * 6.0D * (var12 - var14) + var14;
         } else if(var20 * 2.0D < 1.0D) {
            var10 = var12;
         } else if(var20 * 3.0D < 2.0D) {
            var10 = var14 + (var12 - var14) * (0.6666666666666666D - var20) * 6.0D;
         } else {
            var10 = var14;
         }
      }

      int var22 = (int)(var6 * 256.0D);
      int var13 = (int)(var8 * 256.0D);
      int var23 = (int)(256.0D * var10);
      int var15 = var23 + (var13 << 8) + (var22 << 16);
      return var15;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "-45"
   )
   static int method175(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class82.intStack[--class82.intStackSize];
         class82.intStack[++class82.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class82.intStack[--class82.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class82.intStack[++class82.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class18.grandExchangeEvents != null) {
                  class18.grandExchangeEvents.sort(GrandExchangeEvents.field266, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class18.grandExchangeEvents != null) {
                  class18.grandExchangeEvents.sort(GrandExchangeEvents.field265, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class82.intStackSize -= 2;
               var13 = class82.intStack[class82.intStackSize] == 1;
               boolean var4 = class82.intStack[class82.intStackSize + 1] == 1;
               if(class18.grandExchangeEvents != null) {
                  Client.field1130.field862 = var4;
                  class18.grandExchangeEvents.sort(Client.field1130, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class18.grandExchangeEvents != null) {
                  class18.grandExchangeEvents.sort(GrandExchangeEvents.field264, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class82.intStack[--class82.intStackSize] == 1;
               if(class18.grandExchangeEvents != null) {
                  class18.grandExchangeEvents.sort(GrandExchangeEvents.field267, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class82.intStack[++class82.intStackSize - 1] = class18.grandExchangeEvents == null?0:class18.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var11.method83();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var11.method78();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  long var5 = class60.currentTimeMs() - Fonts.field3716 - var11.field274;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class82.intStack[--class82.intStackSize];
                  var11 = (GrandExchangeEvent)class18.grandExchangeEvents.events.get(var3);
                  class82.intStack[++class82.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
