import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("Size")
public class Size {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final Size field362;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final Size field368;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static final Size field364;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("rssocket")
   static class169 rssocket;
   @ObfuscatedName("r")
   final String field363;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1088121047
   )
   final int field373;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2217877
   )
   final int field367;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2084145105
   )
   final int field366;

   static {
      field362 = new Size("SMALL", 2, 0, 4);
      field368 = new Size("MEDIUM", 1, 1, 2);
      field364 = new Size("LARGE", 0, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field363 = var1;
      this.field373 = var2;
      this.field367 = var3;
      this.field366 = var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(FI)Z",
      garbageValue = "809355235"
   )
   boolean method176(float var1) {
      return var1 >= (float)this.field366;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lo;",
      garbageValue = "1624835589"
   )
   static Size[] method179() {
      return new Size[]{field368, field362, field364};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lo;",
      garbageValue = "64332280"
   )
   static Size method177(int var0) {
      Size[] var1 = method179();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Size var3 = var1[var2];
         if(var0 == var3.field367) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgb;IB)Z",
      garbageValue = "-26"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class93.field1414[++class93.field1410 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field845 = var1;
            if(class93.field1412[var1] != null) {
               var6.decodeApperance(class93.field1412[var1]);
            }

            var6.orientation = class93.Players_orientations[var1];
            var6.interacting = class93.Players_targetIndices[var1];
            var7 = class93.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class93.field1404[var1];
            var6.field844 = (byte)var8;
            var6.method1149((var9 << 13) + var3 - WorldMapType1.baseX, (var10 << 13) + var4 - Enum.baseY);
            var6.field840 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class93.Players_regions[var1];
         class93.Players_regions[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class93.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class93.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class93.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class93.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1800609619"
   )
   static final int method185(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-60"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class36.plane][var0][var1];
      if(var2 == null) {
         class86.region.removeGroundItemPile(class36.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = class251.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class86.region.removeGroundItemPile(class36.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class86.region.addItemPile(class36.plane, var0, var1, class35.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class36.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(Liw;Ljx;IIZI)V",
      garbageValue = "1364358210"
   )
   static final void method175(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = IndexFile.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.menuBooleanArray[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1287404734"
   )
   static final void method187() {
      Client.field1041 = Client.cycleCntr;
   }
}
