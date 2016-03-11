import java.awt.Canvas;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class125 {
   @ObfuscatedName("qy")
   public static Canvas field2039;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1459211651
   )
   static int field2040;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2030628743
   )
   public static int field2043;

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "([Lclass172;IIIZB)V",
      garbageValue = "-70"
   )
   static void method2744(class172[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class172 var6 = var0[var5];
         if(null != var6 && var1 == var6.field2778) {
            class24.method595(var6, var2, var3, var4);
            class10.method126(var6, var2, var3);
            if(var6.field2829 > var6.field2782 - var6.field2774) {
               var6.field2829 = var6.field2782 - var6.field2774;
            }

            if(var6.field2829 < 0) {
               var6.field2829 = 0;
            }

            if(var6.field2886 > var6.field2783 - var6.field2890) {
               var6.field2886 = var6.field2783 - var6.field2890;
            }

            if(var6.field2886 < 0) {
               var6.field2886 = 0;
            }

            if(var6.field2849 == 0) {
               class13.method154(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "21"
   )
   public static void method2748(String var0, String var1, int var2, int var3) throws IOException {
      class148.field2239 = var3;
      class13.field200 = var2;

      try {
         class148.field2246 = System.getProperty("os.name");
      } catch (Exception var20) {
         class148.field2246 = "Unknown";
      }

      class35.field790 = class148.field2246.toLowerCase();

      try {
         class26.field663 = System.getProperty("user.home");
         if(null != class26.field663) {
            class26.field663 = class26.field663 + "/";
         }
      } catch (Exception var19) {
         ;
      }

      try {
         if(class35.field790.startsWith("win")) {
            if(null == class26.field663) {
               class26.field663 = System.getenv("USERPROFILE");
            }
         } else if(class26.field663 == null) {
            class26.field663 = System.getenv("HOME");
         }

         if(class26.field663 != null) {
            class26.field663 = class26.field663 + "/";
         }
      } catch (Exception var18) {
         ;
      }

      if(class26.field663 == null) {
         class26.field663 = "~/";
      }

      class95.field1642 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class26.field663, "/tmp/", ""};
      class45.field1038 = new String[]{".jagex_cache_" + class13.field200, ".file_store_" + class13.field200};
      int var4 = 0;

      label277:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class148.field2237 = new File(class26.field663, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var33;
         if(class148.field2237.exists()) {
            try {
               class226 var10 = new class226(class148.field2237, "rw", 10000L);

               class118 var11;
               int var12;
               for(var11 = new class118((int)var10.method4067()); var11.field1998 < var11.field1995.length; var11.field1998 += var12) {
                  var12 = var10.method4068(var11.field1995, var11.field1998, var11.field1995.length - var11.field1998);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.field1998 = 0;
               var12 = var11.method2453();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.method2453();
               }

               if(var12 <= 2) {
                  var7 = var11.method2443();
                  if(var13 == 1) {
                     var8 = var11.method2443();
                  }
               } else {
                  var7 = var11.method2463();
                  if(1 == var13) {
                     var8 = var11.method2463();
                  }
               }

               var10.method4069();
            } catch (IOException var23) {
               var23.printStackTrace();
            }

            if(null != var7) {
               var33 = new File(var7);
               if(!var33.exists()) {
                  var7 = null;
               }
            }

            if(null != var7) {
               var33 = new File(var7, "test.dat");
               if(!class128.method2755(var33, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && 0 == var4) {
            label252:
            for(int var30 = 0; var30 < class45.field1038.length; ++var30) {
               for(int var35 = 0; var35 < class95.field1642.length; ++var35) {
                  File var37 = new File(class95.field1642[var35] + class45.field1038[var30] + File.separatorChar + var0 + File.separatorChar);
                  if(var37.exists() && class128.method2755(new File(var37, "test.dat"), true)) {
                     var7 = var37.toString();
                     var9 = true;
                     break label252;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class26.field663 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(var8 != null) {
            File var32 = new File(var8);
            var33 = new File(var7);

            try {
               File[] var38 = var32.listFiles();
               File[] var39 = var38;

               for(int var14 = 0; var14 < var39.length; ++var14) {
                  File var15 = var39[var14];
                  File var16 = new File(var33, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var22) {
               var22.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            class143.method2982(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         class148.field2236 = var5;
         if(!class148.field2236.exists()) {
            class148.field2236.mkdirs();
         }

         File[] var27 = class148.field2236.listFiles();
         if(var27 != null) {
            File[] var34 = var27;

            for(int var29 = 0; var29 < var34.length; ++var29) {
               File var31 = var34[var29];
               if(!class128.method2755(var31, false)) {
                  ++var4;
                  continue label277;
               }
            }
         }
         break;
      }

      class141.method2924(class148.field2236);

      try {
         File var24 = new File(class26.field663, "random.dat");
         int var28;
         if(var24.exists()) {
            class148.field2241 = new class227(new class226(var24, "rw", 25L), 24, 0);
         } else {
            label205:
            for(int var25 = 0; var25 < class45.field1038.length; ++var25) {
               for(var28 = 0; var28 < class95.field1642.length; ++var28) {
                  File var36 = new File(class95.field1642[var28] + class45.field1038[var25] + File.separatorChar + "random.dat");
                  if(var36.exists()) {
                     class148.field2241 = new class227(new class226(var36, "rw", 25L), 24, 0);
                     break label205;
                  }
               }
            }
         }

         if(null == class148.field2241) {
            RandomAccessFile var26 = new RandomAccessFile(var24, "rw");
            var28 = var26.read();
            var26.seek(0L);
            var26.write(var28);
            var26.seek(0L);
            var26.close();
            class148.field2241 = new class227(new class226(var24, "rw", 25L), 24, 0);
         }
      } catch (IOException var21) {
         ;
      }

      class148.field2243 = new class227(new class226(class44.method940("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class148.field2240 = new class227(new class226(class44.method940("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class128.field2055 = new class227[class148.field2239];

      for(var4 = 0; var4 < class148.field2239; ++var4) {
         class128.field2055[var4] = new class227(new class226(class44.method940("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }
}
