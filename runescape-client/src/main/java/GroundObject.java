import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2039328017
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 678988997
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1523891371
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -102833949
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -888412317
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "43"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.secretPacketBuffer2.readByteOb1();
         var2 = Client.secretPacketBuffer2.readByteOb1();
         int var3 = Client.secretPacketBuffer2.readUnsignedShort();
         class39.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class39.xteaKeys[var4][var5] = Client.secretPacketBuffer2.readInt();
            }
         }

         WorldListFetcher.mapRegions = new int[var3];
         class66.field807 = new int[var3];
         class222.landRegionFielIds = new int[var3];
         SceneTilePaint.field2003 = new byte[var3][];
         Huffman.field2286 = new byte[var3][];
         boolean var15 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var15 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var15 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (var2 + 6) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var15 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  WorldListFetcher.mapRegions[var3] = var7;
                  class66.field807[var3] = ISAACCipher.indexMaps.getFile("m" + var5 + "_" + var6);
                  class222.landRegionFielIds[var3] = ISAACCipher.indexMaps.getFile("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class14.method71(var1, var2, true);
      } else {
         var1 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         var2 = Client.secretPacketBuffer2.readUnsignedShortOb1();
         boolean var14 = Client.secretPacketBuffer2.method3280() == 1;
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         Client.secretPacketBuffer2.bitAccess();

         int var8;
         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.secretPacketBuffer2.getBits(1);
                  if(var8 == 1) {
                     Client.field1133[var5][var6][var7] = Client.secretPacketBuffer2.getBits(26);
                  } else {
                     Client.field1133[var5][var6][var7] = -1;
                  }
               }
            }
         }

         Client.secretPacketBuffer2.byteAccess();
         class39.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class39.xteaKeys[var5][var6] = Client.secretPacketBuffer2.readInt();
            }
         }

         WorldListFetcher.mapRegions = new int[var4];
         class66.field807 = new int[var4];
         class222.landRegionFielIds = new int[var4];
         SceneTilePaint.field2003 = new byte[var4][];
         Huffman.field2286 = new byte[var4][];
         var4 = 0;

         for(var5 = 0; var5 < 4; ++var5) {
            for(var6 = 0; var6 < 13; ++var6) {
               for(var7 = 0; var7 < 13; ++var7) {
                  var8 = Client.field1133[var5][var6][var7];
                  if(var8 != -1) {
                     int var9 = var8 >> 14 & 1023;
                     int var10 = var8 >> 3 & 2047;
                     int var11 = (var9 / 8 << 8) + var10 / 8;

                     int var12;
                     for(var12 = 0; var12 < var4; ++var12) {
                        if(WorldListFetcher.mapRegions[var12] == var11) {
                           var11 = -1;
                           break;
                        }
                     }

                     if(var11 != -1) {
                        WorldListFetcher.mapRegions[var4] = var11;
                        var12 = var11 >> 8 & 255;
                        int var13 = var11 & 255;
                        class66.field807[var4] = ISAACCipher.indexMaps.getFile("m" + var12 + "_" + var13);
                        class222.landRegionFielIds[var4] = ISAACCipher.indexMaps.getFile("l" + var12 + "_" + var13);
                        ++var4;
                     }
                  }
               }
            }
         }

         class14.method71(var1, var2, !var14);
      }

   }
}
