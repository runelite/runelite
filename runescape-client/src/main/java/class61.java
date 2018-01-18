import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public final class class61 {
   @ObfuscatedName("n")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("v")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 275288353
   )
   static int field729;
   @ObfuscatedName("r")
   static byte[][][] field734;
   @ObfuscatedName("h")
   static byte[][][] field731;
   @ObfuscatedName("d")
   static byte[][][] field733;
   @ObfuscatedName("e")
   static int[][] field730;
   @ObfuscatedName("m")
   static final int[] field727;
   @ObfuscatedName("x")
   static final int[] field735;
   @ObfuscatedName("l")
   static final int[] field736;
   @ObfuscatedName("j")
   static final int[] field737;
   @ObfuscatedName("g")
   static final int[] field744;
   @ObfuscatedName("c")
   static final int[] field739;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -322012431
   )
   static int field740;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1667758635
   )
   static int field732;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field729 = 99;
      field727 = new int[]{1, 2, 4, 8};
      field735 = new int[]{16, 32, 64, 128};
      field736 = new int[]{1, 0, -1, 0};
      field737 = new int[]{0, -1, 0, 1};
      field744 = new int[]{1, -1, -1, 1};
      field739 = new int[]{-1, -1, 1, 1};
      field740 = (int)(Math.random() * 17.0D) - 8;
      field732 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("n")
   public static final void method1077(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-13"
   )
   public static int method1069() {
      return ++MouseInput.mouseIdleTicks - 1;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "255"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = MouseInput.getTileHeight(var0, var1, class7.plane) - var2;
         var0 -= GameEngine.cameraX;
         var3 -= ScriptEvent.cameraZ;
         var1 -= MouseInput.cameraY;
         int var4 = Graphics3D.SINE[SoundTask.cameraPitch];
         int var5 = Graphics3D.COSINE[SoundTask.cameraPitch];
         int var6 = Graphics3D.SINE[class2.cameraYaw];
         int var7 = Graphics3D.COSINE[class2.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportHeight / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(ZLgr;B)V",
      garbageValue = "-30"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         int var2 = var1.readUnsignedShort();
         var3 = var1.method3518();
         var4 = var1.readUnsignedShort();
         WorldMapType3.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               WorldMapType3.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         class214.mapRegions = new int[var4];
         class235.landMapFileIds = new int[var4];
         Huffman.landRegionFileIds = new int[var4];
         UnitPriceComparator.field301 = new byte[var4][];
         Client.field926 = new byte[var4][];
         boolean var16 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var16 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
            for(var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  class214.mapRegions[var4] = var8;
                  class235.landMapFileIds[var4] = ScriptState.indexMaps.getFile("m" + var6 + "_" + var7);
                  Huffman.landRegionFileIds[var4] = ScriptState.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class37.method497(var3, var2, true);
      } else {
         boolean var15 = var1.method3374() == 1;
         var3 = var1.method3337();
         var4 = var1.method3337();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field1118[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field1118[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         WorldMapType3.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               WorldMapType3.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         class214.mapRegions = new int[var5];
         class235.landMapFileIds = new int[var5];
         Huffman.landRegionFileIds = new int[var5];
         UnitPriceComparator.field301 = new byte[var5][];
         Client.field926 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field1118[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(class214.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        class214.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class235.landMapFileIds[var5] = ScriptState.indexMaps.getFile("m" + var13 + "_" + var14);
                        Huffman.landRegionFileIds[var5] = ScriptState.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class37.method497(var4, var3, !var15);
      }

   }
}
