import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1748048509
   )
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 19189559
   )
   @Export("maxTIleX")
   int maxTIleX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -158072071
   )
   @Export("minTileZ")
   int minTileZ;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1248812829
   )
   @Export("maxTileZ")
   int maxTileZ;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1788206283
   )
   @Export("type")
   int type;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1363954155
   )
   @Export("minX")
   int minX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1723998437
   )
   @Export("maxX")
   int maxX;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2133600793
   )
   @Export("minZ")
   int minZ;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1100352767
   )
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2028700473
   )
   @Export("minY")
   int minY;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1943087115
   )
   @Export("maxY")
   int maxY;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 724600299
   )
   @Export("testDirection")
   int testDirection;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1502697593
   )
   int field2059;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1454203423
   )
   int field2048;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -920735549
   )
   @Export("minNormalX")
   int minNormalX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 108490905
   )
   @Export("maxNormalX")
   int maxNormalX;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -544208205
   )
   @Export("minNormalY")
   int minNormalY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1632202737
   )
   @Export("maxNormalY")
   int maxNormalY;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "34"
   )
   public static void method2894(String var0, String var1, int var2, int var3) throws IOException {
      class164.field2212 = var3;
      GroundObject.field1777 = var2;

      try {
         FileRequest.osName = System.getProperty("os.name");
      } catch (Exception var29) {
         FileRequest.osName = "Unknown";
      }

      class19.osNameLC = FileRequest.osName.toLowerCase();

      try {
         class168.userHome = System.getProperty("user.home");
         if(class168.userHome != null) {
            class168.userHome = class168.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      try {
         if(class19.osNameLC.startsWith("win")) {
            if(class168.userHome == null) {
               class168.userHome = System.getenv("USERPROFILE");
            }
         } else if(class168.userHome == null) {
            class168.userHome = System.getenv("HOME");
         }

         if(class168.userHome != null) {
            class168.userHome = class168.userHome + "/";
         }
      } catch (Exception var27) {
         ;
      }

      if(class168.userHome == null) {
         class168.userHome = "~/";
      }

      class7.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class168.userHome, "/tmp/", ""};
      class23.field327 = new String[]{".jagex_cache_" + GroundObject.field1777, ".file_store_" + GroundObject.field1777};
      int var4 = 0;

      label277:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class156.field2154 = new File(class168.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var36;
         if(class156.field2154.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class156.field2154, "rw", 10000L);

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
            } catch (IOException var32) {
               var32.printStackTrace();
            }

            if(var7 != null) {
               var36 = new File(var7);
               if(!var36.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var36 = new File(var7, "test.dat");
               if(!class18.method134(var36, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label252:
            for(int var18 = 0; var18 < class23.field327.length; ++var18) {
               for(int var19 = 0; var19 < class7.cacheLocations.length; ++var19) {
                  File var20 = new File(class7.cacheLocations[var19] + class23.field327[var18] + File.separatorChar + var0 + File.separatorChar);
                  if(var20.exists() && class18.method134(new File(var20, "test.dat"), true)) {
                     var7 = var20.toString();
                     var9 = true;
                     break label252;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class168.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(var8 != null) {
            File var35 = new File(var8);
            var36 = new File(var7);

            try {
               File[] var39 = var35.listFiles();
               File[] var24 = var39;

               for(int var14 = 0; var14 < var24.length; ++var14) {
                  File var15 = var24[var14];
                  File var16 = new File(var36, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var31) {
               var31.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            class18.method130(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         class156.field2147 = var5;
         if(!class156.field2147.exists()) {
            class156.field2147.mkdirs();
         }

         File[] var34 = class156.field2147.listFiles();
         if(var34 != null) {
            File[] var37 = var34;

            for(int var25 = 0; var25 < var37.length; ++var25) {
               File var26 = var37[var25];
               if(!class18.method134(var26, false)) {
                  ++var4;
                  continue label277;
               }
            }
         }
         break;
      }

      class7.method36(class156.field2147);

      try {
         File var21 = new File(class168.userHome, "random.dat");
         int var22;
         if(var21.exists()) {
            class156.field2151 = new CacheFile(new FileOnDisk(var21, "rw", 25L), 24, 0);
         } else {
            label205:
            for(int var23 = 0; var23 < class23.field327.length; ++var23) {
               for(var22 = 0; var22 < class7.cacheLocations.length; ++var22) {
                  File var38 = new File(class7.cacheLocations[var22] + class23.field327[var23] + File.separatorChar + "random.dat");
                  if(var38.exists()) {
                     class156.field2151 = new CacheFile(new FileOnDisk(var38, "rw", 25L), 24, 0);
                     break label205;
                  }
               }
            }
         }

         if(class156.field2151 == null) {
            RandomAccessFile var33 = new RandomAccessFile(var21, "rw");
            var22 = var33.read();
            var33.seek(0L);
            var33.write(var22);
            var33.seek(0L);
            var33.close();
            class156.field2151 = new CacheFile(new FileOnDisk(var21, "rw", 25L), 24, 0);
         }
      } catch (IOException var30) {
         ;
      }

      class156.field2148 = new CacheFile(new FileOnDisk(class275.method4882("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class156.field2153 = new CacheFile(new FileOnDisk(class275.method4882("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class221.field2700 = new CacheFile[class164.field2212];

      for(var4 = 0; var4 < class164.field2212; ++var4) {
         class221.field2700[var4] = new CacheFile(new FileOnDisk(class275.method4882("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lkb;",
      garbageValue = "575718167"
   )
   static SpritePixels method2895() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class295.field3846;
      var0.maxHeight = class224.field2850;
      var0.offsetX = WidgetNode.field774[0];
      var0.offsetY = class285.offsetsY[0];
      var0.width = class295.field3848[0];
      var0.height = class295.field3845[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class70.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class278.field3733[var2[var3] & 255];
      }

      class274.method4876();
      return var0;
   }
}
