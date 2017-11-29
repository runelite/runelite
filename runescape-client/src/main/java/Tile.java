import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1854629971
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -964365923
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1815659089
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1379576209
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2131381875
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lek;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("n")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 297039203
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 467784211
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("j")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("f")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("s")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -418526723
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 559829901
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 686674179
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -852876445
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(ZLgv;I)V",
      garbageValue = "57703707"
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
         var3 = var1.method3333();
         var4 = var1.readUnsignedShort();
         ScriptEvent.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               ScriptEvent.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         VertexNormal.mapRegions = new int[var4];
         class230.landMapFileIds = new int[var4];
         GrandExchangeOffer.landRegionFileIds = new int[var4];
         class29.field400 = new byte[var4][];
         class250.field3386 = new byte[var4][];
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
                  VertexNormal.mapRegions[var4] = var8;
                  class230.landMapFileIds[var4] = PlayerComposition.indexMaps.getFile("m" + var6 + "_" + var7);
                  GrandExchangeOffer.landRegionFileIds[var4] = PlayerComposition.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         FileOnDisk.method2478(var3, var2, true);
      } else {
         boolean var15 = var1.readUnsignedByteNegate() == 1;
         var3 = var1.readUnsignedShort();
         var4 = var1.readUnsignedShortOb1();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field928[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field928[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         ScriptEvent.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               ScriptEvent.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         VertexNormal.mapRegions = new int[var5];
         class230.landMapFileIds = new int[var5];
         GrandExchangeOffer.landRegionFileIds = new int[var5];
         class29.field400 = new byte[var5][];
         class250.field3386 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field928[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(VertexNormal.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        VertexNormal.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        class230.landMapFileIds[var5] = PlayerComposition.indexMaps.getFile("m" + var13 + "_" + var14);
                        GrandExchangeOffer.landRegionFileIds[var5] = PlayerComposition.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         FileOnDisk.method2478(var4, var3, !var15);
      }

   }
}
