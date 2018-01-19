import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   static Task field501;
   @ObfuscatedName("fi")
   @ObfuscatedGetter(
      intValue = 1665186743
   )
   static int field505;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 18409869
   )
   int field495;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 852412371
   )
   int field494;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2031371177
   )
   int field503;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1354092545
   )
   int field497;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -830929141
   )
   int field498;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1427102431
   )
   int field499;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1596430382"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field437 > this.field498) {
         var1.field437 = this.field498;
      }

      if(var1.field434 < this.field498) {
         var1.field434 = this.field498;
      }

      if(var1.field436 > this.field499) {
         var1.field436 = this.field499;
      }

      if(var1.field440 < this.field499) {
         var1.field440 = this.field499;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field495 && var1 < this.field494 + this.field495?var2 >> 6 == this.field503 && var3 >> 6 == this.field497:false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-870088204"
   )
   public boolean vmethod697(int var1, int var2) {
      return var1 >> 6 == this.field498 && var2 >> 6 == this.field499;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "438384537"
   )
   public int[] vmethod716(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field498 * 64 - this.field503 * 64 + var2, var3 + (this.field499 * 64 - this.field497 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lht;",
      garbageValue = "1662378690"
   )
   public Coordinates vmethod694(int var1, int var2) {
      if(!this.vmethod697(var1, var2)) {
         return null;
      } else {
         int var3 = this.field503 * 64 - this.field498 * 64 + var1;
         int var4 = this.field497 * 64 - this.field499 * 64 + var2;
         return new Coordinates(this.field495, var3, var4);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1961822977"
   )
   public void vmethod700(Buffer var1) {
      this.field495 = var1.readUnsignedByte();
      this.field494 = var1.readUnsignedByte();
      this.field503 = var1.readUnsignedShort();
      this.field497 = var1.readUnsignedShort();
      this.field498 = var1.readUnsignedShort();
      this.field499 = var1.readUnsignedShort();
      this.method505();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "908739394"
   )
   void method505() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIS)V",
      garbageValue = "-788"
   )
   public static void method520(String var0, String var1, int var2, int var3) throws IOException {
      class157.idxCount = var3;
      Bounds.field3817 = var2;

      try {
         SoundTask.osName = System.getProperty("os.name");
      } catch (Exception var29) {
         SoundTask.osName = "Unknown";
      }

      class157.osNameLC = SoundTask.osName.toLowerCase();

      try {
         class153.userHome = System.getProperty("user.home");
         if(class153.userHome != null) {
            class153.userHome = class153.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      try {
         if(class157.osNameLC.startsWith("win")) {
            if(class153.userHome == null) {
               class153.userHome = System.getenv("USERPROFILE");
            }
         } else if(class153.userHome == null) {
            class153.userHome = System.getenv("HOME");
         }

         if(class153.userHome != null) {
            class153.userHome = class153.userHome + "/";
         }
      } catch (Exception var27) {
         ;
      }

      if(class153.userHome == null) {
         class153.userHome = "~/";
      }

      class29.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class153.userHome, "/tmp/", ""};
      class46.field570 = new String[]{".jagex_cache_" + Bounds.field3817, ".file_store_" + Bounds.field3817};
      int var18 = 0;

      label277:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class157.jagexClDat = new File(class153.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var36;
         if(class157.jagexClDat.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class157.jagexClDat, "rw", 10000L);

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
               if(!BoundingBox3D.method51(var36, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label251:
            for(int var19 = 0; var19 < class46.field570.length; ++var19) {
               for(int var20 = 0; var20 < class29.cacheLocations.length; ++var20) {
                  File var21 = new File(class29.cacheLocations[var20] + class46.field570[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && BoundingBox3D.method51(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label251;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class153.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(var8 != null) {
            File var35 = new File(var8);
            var36 = new File(var7);

            try {
               File[] var39 = var35.listFiles();
               File[] var22 = var39;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
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
            FrameMap.method2742(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         class157.field2164 = var5;
         if(!class157.field2164.exists()) {
            class157.field2164.mkdirs();
         }

         File[] var34 = class157.field2164.listFiles();
         if(var34 != null) {
            File[] var37 = var34;

            for(int var23 = 0; var23 < var37.length; ++var23) {
               File var24 = var37[var23];
               if(!BoundingBox3D.method51(var24, false)) {
                  ++var18;
                  continue label277;
               }
            }
         }
         break;
      }

      ScriptEvent.method1108(class157.field2164);

      try {
         File var4 = new File(class153.userHome, "random.dat");
         int var26;
         if(var4.exists()) {
            class157.randomDat = new CacheFile(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label204:
            for(int var25 = 0; var25 < class46.field570.length; ++var25) {
               for(var26 = 0; var26 < class29.cacheLocations.length; ++var26) {
                  File var38 = new File(class29.cacheLocations[var26] + class46.field570[var25] + File.separatorChar + "random.dat");
                  if(var38.exists()) {
                     class157.randomDat = new CacheFile(new FileOnDisk(var38, "rw", 25L), 24, 0);
                     break label204;
                  }
               }
            }
         }

         if(class157.randomDat == null) {
            RandomAccessFile var33 = new RandomAccessFile(var4, "rw");
            var26 = var33.read();
            var33.seek(0L);
            var33.write(var26);
            var33.seek(0L);
            var33.close();
            class157.randomDat = new CacheFile(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var30) {
         ;
      }

      class157.dat2File = new CacheFile(new FileOnDisk(class48.method707("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class157.idx255File = new CacheFile(new FileOnDisk(class48.method707("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class157.idxFiles = new CacheFile[class157.idxCount];

      for(var18 = 0; var18 < class157.idxCount; ++var18) {
         class157.idxFiles[var18] = new CacheFile(new FileOnDisk(class48.method707("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;I)V",
      garbageValue = "-1236974592"
   )
   public static void method525(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }
}
