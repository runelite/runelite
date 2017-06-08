import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public final class class61 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1668572971
   )
   static int field735;
   @ObfuscatedName("p")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 783022885
   )
   static int field737;
   @ObfuscatedName("q")
   static final int[] field738;
   @ObfuscatedName("f")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("h")
   static int[][] field740;
   @ObfuscatedName("e")
   static int[] field741;
   @ObfuscatedName("o")
   static int[] field742;
   @ObfuscatedName("a")
   static int[] field743;
   @ObfuscatedName("v")
   static final int[] field744;
   @ObfuscatedName("t")
   static final int[] field745;
   @ObfuscatedName("w")
   static final int[] field746;
   @ObfuscatedName("n")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("et")
   @ObfuscatedGetter(
      intValue = -1571013333
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("k")
   static final int[] field749;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -38904883
   )
   static int field750;
   @ObfuscatedName("fg")
   @Export("region")
   static Region region;
   @ObfuscatedName("l")
   static final int[] field752;
   @ObfuscatedName("dz")
   static IndexData field753;
   @ObfuscatedName("c")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field737 = 99;
      field744 = new int[]{1, 2, 4, 8};
      field745 = new int[]{16, 32, 64, 128};
      field746 = new int[]{1, 0, -1, 0};
      field752 = new int[]{0, -1, 0, 1};
      field738 = new int[]{1, -1, -1, 1};
      field749 = new int[]{-1, -1, 1, 1};
      field750 = (int)(Math.random() * 17.0D) - 8;
      field735 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1197521584"
   )
   static int method1021(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3200) {
         class165.intStackSize -= 3;
         var3 = class83.intStack[class165.intStackSize];
         int var4 = class83.intStack[class165.intStackSize + 1];
         int var5 = class83.intStack[class165.intStackSize + 2];
         if(Client.field1155 != 0 && var4 != 0 && Client.field1077 < 50) {
            Client.field1158[Client.field1077] = var3;
            Client.field1159[Client.field1077] = var4;
            Client.field1049[Client.field1077] = var5;
            Client.field1162[Client.field1077] = null;
            Client.field1101[Client.field1077] = 0;
            ++Client.field1077;
         }

         return 1;
      } else if(var0 != 3201) {
         if(var0 == 3202) {
            class165.intStackSize -= 2;
            class11.method73(class83.intStack[class165.intStackSize], class83.intStack[class165.intStackSize + 1]);
            return 1;
         } else {
            return 2;
         }
      } else {
         var3 = class83.intStack[--class165.intStackSize];
         if(var3 == -1 && !Client.field1154) {
            class203.field2517.method3728();
            class203.field2515 = 1;
            class203.field2516 = null;
         } else if(var3 != -1 && var3 != Client.field1153 && Client.field1030 != 0 && !Client.field1154) {
            class54.method775(2, class54.indexTrack1, var3, 0, Client.field1030, false);
         }

         Client.field1153 = var3;
         return 1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-422488235"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field3444.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field3442.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field3449 = var0;
         if(var2 != null) {
            var1.method4540(new Buffer(var2));
         }

         var1.method4544();
         if(var1.isSolid) {
            var1.field3459 = 0;
            var1.field3460 = false;
         }

         ObjectComposition.field3444.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;I)V",
      garbageValue = "-2111517277"
   )
   static void method1047(Font var0, Font var1) {
      if(class47.field599 == null) {
         class47.field599 = class271.method4937(Client.indexSprites, "sl_back", "");
      }

      if(WorldMapType3.field394 == null) {
         WorldMapType3.field394 = class41.method582(Client.indexSprites, "sl_flags", "");
      }

      if(class4.field38 == null) {
         class4.field38 = class41.method582(Client.indexSprites, "sl_arrows", "");
      }

      if(class90.field1405 == null) {
         class90.field1405 = class41.method582(Client.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method5040(class92.field1417, 23, 765, 480, 0);
      Rasterizer2D.method4974(class92.field1417, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4974(class92.field1417 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4825("Select a world", class92.field1417 + 62, 15, 0, -1);
      if(class90.field1405 != null) {
         class90.field1405[1].method5066(class92.field1417 + 140, 1);
         var1.method4785("Members only world", class92.field1417 + 152, 10, 16777215, -1);
         class90.field1405[0].method5066(class92.field1417 + 140, 12);
         var1.method4785("Free world", class92.field1417 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class4.field38 != null) {
         int var2 = class92.field1417 + 280;
         if(World.field1294[0] == 0 && World.field1299[0] == 0) {
            class4.field38[2].method5066(var2, 4);
         } else {
            class4.field38[0].method5066(var2, 4);
         }

         if(World.field1294[0] == 0 && World.field1299[0] == 1) {
            class4.field38[3].method5066(var2 + 15, 4);
         } else {
            class4.field38[1].method5066(var2 + 15, 4);
         }

         var0.method4785("World", var2 + 32, 17, 16777215, -1);
         int var3 = class92.field1417 + 390;
         if(World.field1294[0] == 1 && World.field1299[0] == 0) {
            class4.field38[2].method5066(var3, 4);
         } else {
            class4.field38[0].method5066(var3, 4);
         }

         if(World.field1294[0] == 1 && World.field1299[0] == 1) {
            class4.field38[3].method5066(var3 + 15, 4);
         } else {
            class4.field38[1].method5066(var3 + 15, 4);
         }

         var0.method4785("Players", var3 + 32, 17, 16777215, -1);
         var4 = class92.field1417 + 500;
         if(World.field1294[0] == 2 && World.field1299[0] == 0) {
            class4.field38[2].method5066(var4, 4);
         } else {
            class4.field38[0].method5066(var4, 4);
         }

         if(World.field1294[0] == 2 && World.field1299[0] == 1) {
            class4.field38[3].method5066(var4 + 15, 4);
         } else {
            class4.field38[1].method5066(var4 + 15, 4);
         }

         var0.method4785("Location", var4 + 32, 17, 16777215, -1);
         var5 = class92.field1417 + 610;
         if(World.field1294[0] == 3 && World.field1299[0] == 0) {
            class4.field38[2].method5066(var5, 4);
         } else {
            class4.field38[0].method5066(var5, 4);
         }

         if(World.field1294[0] == 3 && World.field1299[0] == 1) {
            class4.field38[3].method5066(var5 + 15, 4);
         } else {
            class4.field38[1].method5066(var5 + 15, 4);
         }

         var0.method4785("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method5040(class92.field1417 + 708, 4, 50, 16, 0);
      var1.method4825("Cancel", class92.field1417 + 708 + 25, 16, 16777215, -1);
      class92.field1443 = -1;
      if(class47.field599 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.field1297) {
               --var4;
            }

            if((var5 - 1) * var4 >= World.field1297) {
               --var5;
            }

            if((var5 - 1) * var4 >= World.field1297) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var22) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var22 - (var5 - 1) * var7) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class92.field1417;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field1297; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1560()) {
               if(var15.method1518()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1522()) {
               var19 = 16711680;
               if(var15.method1518()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1554()) {
               if(var15.method1518()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1518()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class59.field729 >= var11 && class59.field715 >= var10 && class59.field729 < var21 + var11 && class59.field715 < var10 + var22 && var16) {
               class92.field1443 = var14;
               class47.field599[var18].method5109(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class47.field599[var18].method5164(var11, var10);
            }

            if(WorldMapType3.field394 != null) {
               WorldMapType3.field394[(var15.method1518()?8:0) + var15.location].method5066(var11 + 29, var10);
            }

            var0.method4825(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4825(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 += var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4780(World.worldList[class92.field1443].activity) + 6;
            int var20 = var1.field3652 + 8;
            Rasterizer2D.method5040(class59.field729 - var14 / 2, class59.field715 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.method4976(class59.field729 - var14 / 2, class59.field715 + 20 + 5, var14, var20, 0);
            var1.method4825(World.worldList[class92.field1443].activity, class59.field729, var1.field3652 + class59.field715 + 20 + 5 + 4, 0, -1);
         }
      }

      class47.field601.vmethod5052(0, 0);
   }
}
