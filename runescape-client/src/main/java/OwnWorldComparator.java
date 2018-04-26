import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("rc")
   @ObfuscatedGetter(
      intValue = 1719665307
   )
   static int field846;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -762851217
   )
   public static int field847;
   @ObfuscatedName("g")
   boolean field848;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;B)I",
      garbageValue = "-128"
   )
   int method1257(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field848) {
            if(Client.world == var1.world) {
               return -1;
            }

            if(var2.world == Client.world) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1257((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "2111023658"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "1444963918"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1538239685"
   )
   public static int method1266(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "423078279"
   )
   public static String method1264(CharSequence var0) {
      String var1 = Resampler.method2393(GameSocket.method3443(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "16777215"
   )
   static int method1265(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].type();
         return 1;
      } else if(var0 == 3904) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class81.intStack[--class171.intStackSize];
         class81.intStack[++class171.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class81.intStack[--class171.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class171.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class81.intStack[--class171.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class171.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class81.intStack[--class171.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class171.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class81.intStack[--class171.intStackSize];
            var12 = Client.grandExchangeOffers[var3].status();
            class81.intStack[++class171.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class81.intStack[--class171.intStackSize] == 1;
               if(WorldMapType2.grandExchangeEvents != null) {
                  WorldMapType2.grandExchangeEvents.sort(GrandExchangeEvents.field282, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class81.intStack[--class171.intStackSize] == 1;
               if(WorldMapType2.grandExchangeEvents != null) {
                  WorldMapType2.grandExchangeEvents.sort(GrandExchangeEvents.field281, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class171.intStackSize -= 2;
               var13 = class81.intStack[class171.intStackSize] == 1;
               boolean var4 = class81.intStack[class171.intStackSize + 1] == 1;
               if(WorldMapType2.grandExchangeEvents != null) {
                  Client.field1118.field848 = var4;
                  WorldMapType2.grandExchangeEvents.sort(Client.field1118, var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class81.intStack[--class171.intStackSize] == 1;
               if(WorldMapType2.grandExchangeEvents != null) {
                  WorldMapType2.grandExchangeEvents.sort(GrandExchangeEvents.field283, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class81.intStack[--class171.intStackSize] == 1;
               if(WorldMapType2.grandExchangeEvents != null) {
                  WorldMapType2.grandExchangeEvents.sort(GrandExchangeEvents.field279, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class81.intStack[++class171.intStackSize - 1] = WorldMapType2.grandExchangeEvents == null?0:WorldMapType2.grandExchangeEvents.events.size();
               return 1;
            } else {
               GrandExchangeEvent var11;
               if(var0 == 3920) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class171.intStackSize - 1] = var11.world;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var11.method86();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var11.method85();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  long var5 = class289.method5267() - class33.field455 - var11.field287;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class81.scriptStringStack[++class81.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class171.intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class171.intStackSize - 1] = var11.grandExchangeOffer.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class81.intStack[--class171.intStackSize];
                  var11 = (GrandExchangeEvent)WorldMapType2.grandExchangeEvents.events.get(var3);
                  class81.intStack[++class171.intStackSize - 1] = var11.grandExchangeOffer.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "38"
   )
   static final void method1260(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var12 * var9 - var11 * var5 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var8 * var12 + var10 * var11 >> 16;
         var10 = var12 * var10 - var11 * var8 >> 16;
         var8 = var13;
      }

      UrlRequest.cameraX = var0 - var8;
      class86.cameraZ = var1 - var9;
      Signlink.cameraY = var2 - var10;
      class18.cameraPitch = var3;
      class33.cameraYaw = var4;
      if(Client.field926 == 1 && Client.rights >= 2 && Client.gameCycle % 50 == 0 && (Size.field367 >> 7 != class265.localPlayer.x >> 7 || class236.field2783 >> 7 != class265.localPlayer.y >> 7)) {
         var11 = class265.localPlayer.field831;
         var12 = (Size.field367 >> 7) + ClientPacket.baseX;
         var13 = (class236.field2783 >> 7) + MapIconReference.baseY;
         MapIcon.method596(var12, var13, var11, true);
      }

   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Liz;IB)Ljava/lang/String;",
      garbageValue = "3"
   )
   static String method1256(Widget var0, int var1) {
      return !DecorativeObject.method3163(class1.getWidgetClickMask(var0), var1) && var0.onOpListener == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
