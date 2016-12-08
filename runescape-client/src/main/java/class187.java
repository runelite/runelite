import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class187 extends CacheableNode {
   @ObfuscatedName("b")
   public static NodeCache field2780 = new NodeCache(64);
   @ObfuscatedName("o")
   static class182 field2781;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -519323429
   )
   public int field2782 = 0;
   @ObfuscatedName("m")
   public static class182 field2783;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1552984993"
   )
   public static void method3346(String var0, String var1, int var2, int var3) throws IOException {
      VertexNormal.field1418 = var3;
      class9.field70 = var2;

      try {
         Frames.field1560 = System.getProperty("os.name");
      } catch (Exception var30) {
         Frames.field1560 = "Unknown";
      }

      class229.field3248 = Frames.field1560.toLowerCase();

      try {
         WallObject.field1541 = System.getProperty("user.home");
         if(null != WallObject.field1541) {
            WallObject.field1541 = WallObject.field1541 + "/";
         }
      } catch (Exception var29) {
         ;
      }

      try {
         if(class229.field3248.startsWith("win")) {
            if(WallObject.field1541 == null) {
               WallObject.field1541 = System.getenv("USERPROFILE");
            }
         } else if(null == WallObject.field1541) {
            WallObject.field1541 = System.getenv("HOME");
         }

         if(null != WallObject.field1541) {
            WallObject.field1541 = WallObject.field1541 + "/";
         }
      } catch (Exception var28) {
         ;
      }

      if(null == WallObject.field1541) {
         WallObject.field1541 = "~/";
      }

      class103.field1677 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", WallObject.field1541, "/tmp/", ""};
      class18.field204 = new String[]{".jagex_cache_" + class9.field70, ".file_store_" + class9.field70};
      int var18 = 0;

      label291:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         Ignore.field210 = new File(WallObject.field1541, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var37;
         if(Ignore.field210.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(Ignore.field210, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.method1389()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method1391(var11.payload, var11.offset, var11.payload.length - var11.offset);
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
                  var7 = var11.method2735();
                  if(var13 == 1) {
                     var8 = var11.method2735();
                  }
               } else {
                  var7 = var11.method2736();
                  if(var13 == 1) {
                     var8 = var11.method2736();
                  }
               }

               var10.method1400();
            } catch (IOException var33) {
               var33.printStackTrace();
            }

            if(var7 != null) {
               var37 = new File(var7);
               if(!var37.exists()) {
                  var7 = null;
               }
            }

            if(null != var7) {
               var37 = new File(var7, "test.dat");
               if(!class138.method2444(var37, true)) {
                  var7 = null;
               }
            }
         }

         if(null == var7 && var18 == 0) {
            label265:
            for(int var19 = 0; var19 < class18.field204.length; ++var19) {
               for(int var20 = 0; var20 < class103.field1677.length; ++var20) {
                  File var21 = new File(class103.field1677[var20] + class18.field204[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && class138.method2444(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label265;
                  }
               }
            }
         }

         if(null == var7) {
            var7 = WallObject.field1541 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var36;
         if(var8 != null) {
            var36 = new File(var8);
            var37 = new File(var7);

            try {
               File[] var40 = var36.listFiles();
               File[] var22 = var40;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
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
               FileOnDisk var41 = new FileOnDisk(Ignore.field210, "rw", 10000L);
               Buffer var42 = new Buffer(500);
               var42.method2815(3);
               var42.method2815(var11 != null?1:0);
               var42.method2719(var36.getPath());
               if(null != var11) {
                  var42.method2719("");
               }

               var41.method1387(var42.payload, 0, var42.offset);
               var41.method1400();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         File var5 = new File(var7);
         class104.field1685 = var5;
         if(!class104.field1685.exists()) {
            class104.field1685.mkdirs();
         }

         File[] var35 = class104.field1685.listFiles();
         if(var35 != null) {
            File[] var38 = var35;

            for(int var23 = 0; var23 < var38.length; ++var23) {
               File var24 = var38[var23];
               if(!class138.method2444(var24, false)) {
                  ++var18;
                  continue label291;
               }
            }
         }
         break;
      }

      class3.method39(class104.field1685);

      try {
         File var4 = new File(WallObject.field1541, "random.dat");
         int var26;
         if(var4.exists()) {
            class104.field1687 = new class72(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label218:
            for(int var25 = 0; var25 < class18.field204.length; ++var25) {
               for(var26 = 0; var26 < class103.field1677.length; ++var26) {
                  File var39 = new File(class103.field1677[var26] + class18.field204[var25] + File.separatorChar + "random.dat");
                  if(var39.exists()) {
                     class104.field1687 = new class72(new FileOnDisk(var39, "rw", 25L), 24, 0);
                     break label218;
                  }
               }
            }
         }

         if(null == class104.field1687) {
            RandomAccessFile var34 = new RandomAccessFile(var4, "rw");
            var26 = var34.read();
            var34.seek(0L);
            var34.write(var26);
            var34.seek(0L);
            var34.close();
            class104.field1687 = new class72(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var31) {
         ;
      }

      class104.field1688 = new class72(new FileOnDisk(class33.method675("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class104.field1689 = new class72(new FileOnDisk(class33.method675("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class104.field1690 = new class72[VertexNormal.field1418];

      for(var18 = 0; var18 < VertexNormal.field1418; ++var18) {
         class104.field1690[var18] = new class72(new FileOnDisk(class33.method675("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "362599884"
   )
   void method3347(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3353(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "8946113"
   )
   void method3353(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2782 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   static final void method3356() {
      Client.field542 = 0;
      int var0 = class107.baseX + (class5.localPlayer.x >> 7);
      int var1 = (class5.localPlayer.y >> 7) + XClanMember.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field542 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field542 = 1;
      }

      if(Client.field542 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field542 = 0;
      }

   }
}
