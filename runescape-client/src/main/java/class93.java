import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class93 {
   @ObfuscatedName("b")
   static byte[] field1415;
   @ObfuscatedName("z")
   static byte[] field1416;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgg;"
   )
   static Buffer[] field1404;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -805461385
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("s")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1406271711
   )
   static int field1409;
   @ObfuscatedName("c")
   static int[] field1410;
   @ObfuscatedName("h")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("i")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("o")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1177450001
   )
   static int field1414;
   @ObfuscatedName("r")
   static int[] field1413;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static Buffer field1402;

   static {
      field1415 = new byte[2048];
      field1416 = new byte[2048];
      field1404 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1409 = 0;
      field1410 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1414 = 0;
      field1413 = new int[2048];
      field1402 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IS)Ljava/io/File;",
      garbageValue = "8073"
   )
   public static File method2023(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class167.jagexClDat = new File(class167.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class167.jagexClDat.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!BoundingBox.method50(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label121:
         for(int var15 = 0; var15 < PendingSpawn.field1134.length; ++var15) {
            for(int var16 = 0; var16 < WorldMapDecoration.cacheLocations.length; ++var16) {
               File var17 = new File(WorldMapDecoration.cacheLocations[var16] + PendingSpawn.field1134[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && BoundingBox.method50(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label121;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class167.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         Tile.method2778(new File(var4), (File)null);
      }

      return new File(var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1242777685"
   )
   static void method2036() {
      class332.indexedSpriteOffsetXs = null;
      WorldComparator.indexedSpriteOffsetYs = null;
      class332.indexSpriteWidths = null;
      GrandExchangeEvents.indexedSpriteHeights = null;
      class332.indexedSpritePalette = null;
      ChatPlayer.spritePixels = null;
   }
}
