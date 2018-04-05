import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -303070873
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -145538057
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1411450965
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -164278337
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1911002073
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Leb;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("w")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 863769661
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -365059857
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("s")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("v")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("q")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1234362029
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1417207541
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1805773899
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -794476337
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lej;"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1831471603"
   )
   public static void method2684(String var0, String var1, int var2, int var3) throws IOException {
      class37.idxCount = var3;
      BoundingBox.field253 = var2;

      try {
         ContextMenuRow.osName = System.getProperty("os.name");
      } catch (Exception var30) {
         ContextMenuRow.osName = "Unknown";
      }

      class25.osNameLC = ContextMenuRow.osName.toLowerCase();

      try {
         NPC.userHome = System.getProperty("user.home");
         if(NPC.userHome != null) {
            NPC.userHome = NPC.userHome + "/";
         }
      } catch (Exception var29) {
         ;
      }

      try {
         if(class25.osNameLC.startsWith("win")) {
            if(NPC.userHome == null) {
               NPC.userHome = System.getenv("USERPROFILE");
            }
         } else if(NPC.userHome == null) {
            NPC.userHome = System.getenv("HOME");
         }

         if(NPC.userHome != null) {
            NPC.userHome = NPC.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      if(NPC.userHome == null) {
         NPC.userHome = "~/";
      }

      WorldMapData.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", NPC.userHome, "/tmp/", ""};
      Resampler.field1627 = new String[]{".jagex_cache_" + BoundingBox.field253, ".file_store_" + BoundingBox.field253};
      int var18 = 0;

      File var5;
      label279:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class167.jagexClDat = new File(NPC.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var38;
         if(class167.jagexClDat.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);

               Buffer var11;
               int var12;
               for(var11 = new Buffer((int)var10.length()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.read(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var11.getJagString();
                  if(var13 == 1) {
                     var8 = var11.getJagString();
                  }
               } else {
                  var7 = var11.getCESU8();
                  if(var13 == 1) {
                     var8 = var11.getCESU8();
                  }
               }

               var10.close();
            } catch (IOException var33) {
               var33.printStackTrace();
            }

            if(var7 != null) {
               var38 = new File(var7);
               if(!var38.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var38 = new File(var7, "test.dat");
               if(!WorldComparator.method70(var38, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label254:
            for(int var19 = 0; var19 < Resampler.field1627.length; ++var19) {
               for(int var20 = 0; var20 < WorldMapData.cacheLocations.length; ++var20) {
                  File var21 = new File(WorldMapData.cacheLocations[var20] + Resampler.field1627[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && WorldComparator.method70(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label254;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = NPC.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(var8 != null) {
            File var37 = new File(var8);
            var38 = new File(var7);

            try {
               File[] var40 = var37.listFiles();
               File[] var22 = var40;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var38, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var32) {
               var32.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            class110.method2284(new File(var7), (File)null);
         }

         var5 = new File(var7);
         class241.field2807 = var5;
         if(!class241.field2807.exists()) {
            class241.field2807.mkdirs();
         }

         File[] var34 = class241.field2807.listFiles();
         if(var34 != null) {
            File[] var39 = var34;

            for(int var23 = 0; var23 < var39.length; ++var23) {
               File var24 = var39[var23];
               if(!WorldComparator.method70(var24, false)) {
                  ++var18;
                  continue label279;
               }
            }
         }
         break;
      }

      File var4 = class241.field2807;
      class170.field2233 = var4;
      if(!class170.field2233.exists()) {
         throw new RuntimeException("");
      } else {
         class170.field2234 = true;

         try {
            var5 = new File(NPC.userHome, "random.dat");
            int var26;
            if(var5.exists()) {
               class167.randomDat = new CacheFile(new FileOnDisk(var5, "rw", 25L), 24, 0);
            } else {
               label205:
               for(int var25 = 0; var25 < Resampler.field1627.length; ++var25) {
                  for(var26 = 0; var26 < WorldMapData.cacheLocations.length; ++var26) {
                     File var36 = new File(WorldMapData.cacheLocations[var26] + Resampler.field1627[var25] + File.separatorChar + "random.dat");
                     if(var36.exists()) {
                        class167.randomDat = new CacheFile(new FileOnDisk(var36, "rw", 25L), 24, 0);
                        break label205;
                     }
                  }
               }
            }

            if(class167.randomDat == null) {
               RandomAccessFile var35 = new RandomAccessFile(var5, "rw");
               var26 = var35.read();
               var35.seek(0L);
               var35.write(var26);
               var35.seek(0L);
               var35.close();
               class167.randomDat = new CacheFile(new FileOnDisk(var5, "rw", 25L), 24, 0);
            }
         } catch (IOException var31) {
            ;
         }

         class167.dat2File = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class167.idx255File = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         Size.idxFiles = new CacheFile[class37.idxCount];

         for(int var27 = 0; var27 < class37.idxCount; ++var27) {
            Size.idxFiles[var27] = new CacheFile(new FileOnDisk(MessageNode.method1176("main_file_cache.idx" + var27), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lje;",
      garbageValue = "1930939086"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }
}
