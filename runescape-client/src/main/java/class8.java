import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public final class class8 extends class9 {
   @ObfuscatedName("ij")
   @ObfuscatedGetter(
      intValue = -1452340649
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 157905185
   )
   final int field235;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -380353877
   )
   final int field232;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 111188613
   )
   final int field233;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2045071129
   )
   final int field231;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 870551071
   )
   final int field234;

   public class8(int var1, int var2, int var3, int var4, int var5) {
      this.field235 = var1;
      this.field232 = var2;
      this.field233 = var3;
      this.field231 = var4;
      this.field234 = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775908210"
   )
   final void vmethod55() {
      Rasterizer2D.drawRectangle(this.field235 + Rasterizer2D.draw_region_x, this.field232 + Rasterizer2D.drawingAreaTop, this.field233 - this.field235, this.field231 - this.field232, this.field234);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "752843580"
   )
   public static void method40(String var0, String var1, int var2, int var3) throws IOException {
      class155.field2218 = var3;
      class155.field2227 = var2;

      try {
         class155.osName = System.getProperty("os.name");
      } catch (Exception var30) {
         class155.osName = "Unknown";
      }

      Friend.osNameLC = class155.osName.toLowerCase();

      try {
         class60.userHome = System.getProperty("user.home");
         if(class60.userHome != null) {
            class60.userHome = class60.userHome + "/";
         }
      } catch (Exception var29) {
         ;
      }

      try {
         if(Friend.osNameLC.startsWith("win")) {
            if(class60.userHome == null) {
               class60.userHome = System.getenv("USERPROFILE");
            }
         } else if(class60.userHome == null) {
            class60.userHome = System.getenv("HOME");
         }

         if(class60.userHome != null) {
            class60.userHome = class60.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      if(class60.userHome == null) {
         class60.userHome = "~/";
      }

      class152.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class60.userHome, "/tmp/", ""};
      class73.field853 = new String[]{".jagex_cache_" + class155.field2227, ".file_store_" + class155.field2227};
      int var4 = 0;

      label292:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class155.field2221 = new File(class60.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var37;
         if(class155.field2221.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class155.field2221, "rw", 10000L);

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
               var37 = new File(var7);
               if(!var37.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var37 = new File(var7, "test.dat");
               if(!WorldMapData.method354(var37, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label266:
            for(int var18 = 0; var18 < class73.field853.length; ++var18) {
               for(int var19 = 0; var19 < class152.cacheLocations.length; ++var19) {
                  File var20 = new File(class152.cacheLocations[var19] + class73.field853[var18] + File.separatorChar + var0 + File.separatorChar);
                  if(var20.exists() && WorldMapData.method354(new File(var20, "test.dat"), true)) {
                     var7 = var20.toString();
                     var9 = true;
                     break label266;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class60.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var36;
         if(var8 != null) {
            var36 = new File(var8);
            var37 = new File(var7);

            try {
               File[] var40 = var36.listFiles();
               File[] var21 = var40;

               for(int var14 = 0; var14 < var21.length; ++var14) {
                  File var15 = var21[var14];
                  File var16 = new File(var37, var15.getName());
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
            var36 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var41 = new FileOnDisk(class155.field2221, "rw", 10000L);
               Buffer var42 = new Buffer(500);
               var42.putByte(3);
               var42.putByte(var11 != null?1:0);
               var42.putCESU8(var36.getPath());
               if(var11 != null) {
                  var42.putCESU8("");
               }

               var41.write(var42.payload, 0, var42.offset);
               var41.close();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         File var5 = new File(var7);
         class155.field2217 = var5;
         if(!class155.field2217.exists()) {
            class155.field2217.mkdirs();
         }

         File[] var35 = class155.field2217.listFiles();
         if(var35 != null) {
            File[] var38 = var35;

            for(int var22 = 0; var22 < var38.length; ++var22) {
               File var23 = var38[var22];
               if(!WorldMapData.method354(var23, false)) {
                  ++var4;
                  continue label292;
               }
            }
         }
         break;
      }

      class71.method1128(class155.field2217);

      try {
         File var24 = new File(class60.userHome, "random.dat");
         int var25;
         if(var24.exists()) {
            class155.field2223 = new CacheFile(new FileOnDisk(var24, "rw", 25L), 24, 0);
         } else {
            label219:
            for(int var26 = 0; var26 < class73.field853.length; ++var26) {
               for(var25 = 0; var25 < class152.cacheLocations.length; ++var25) {
                  File var39 = new File(class152.cacheLocations[var25] + class73.field853[var26] + File.separatorChar + "random.dat");
                  if(var39.exists()) {
                     class155.field2223 = new CacheFile(new FileOnDisk(var39, "rw", 25L), 24, 0);
                     break label219;
                  }
               }
            }
         }

         if(class155.field2223 == null) {
            RandomAccessFile var34 = new RandomAccessFile(var24, "rw");
            var25 = var34.read();
            var34.seek(0L);
            var34.write(var25);
            var34.seek(0L);
            var34.close();
            class155.field2223 = new CacheFile(new FileOnDisk(var24, "rw", 25L), 24, 0);
         }
      } catch (IOException var31) {
         ;
      }

      class155.field2224 = new CacheFile(new FileOnDisk(class118.method2190("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class155.field2228 = new CacheFile(new FileOnDisk(class118.method2190("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class155.field2226 = new CacheFile[class155.field2218];

      for(var4 = 0; var4 < class155.field2218; ++var4) {
         class155.field2226[var4] = new CacheFile(new FileOnDisk(class118.method2190("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lii;",
      garbageValue = "2101636461"
   )
   @Export("getInventory")
   public static InvType getInventory(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class181.field2407.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }
}
