import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public abstract class class119 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1881717577
   )
   public int field1874;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 919956173
   )
   public int field1875;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1273051143
   )
   public int field1876;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -1847911375
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = -35476439
   )
   static int field1880;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1272178093
   )
   public int field1882;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "-1"
   )
   protected abstract boolean vmethod2355(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "17891292"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class168.method3249(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "1480974139"
   )
   public static int method2359(byte[] var0, int var1) {
      return RSSocket.method2119(var0, 0, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1606732665"
   )
   public static void method2360(String var0, String var1, int var2, int var3) throws IOException {
      class0.field3 = var3;
      class104.field1715 = var2;

      try {
         class33.field767 = System.getProperty("os.name");
      } catch (Exception var31) {
         class33.field767 = "Unknown";
      }

      class49.field972 = class33.field767.toLowerCase();

      try {
         Sequence.field3074 = System.getProperty("user.home");
         if(Sequence.field3074 != null) {
            Sequence.field3074 = Sequence.field3074 + "/";
         }
      } catch (Exception var30) {
         ;
      }

      try {
         if(class49.field972.startsWith("win")) {
            if(null == Sequence.field3074) {
               Sequence.field3074 = System.getenv("USERPROFILE");
            }
         } else if(null == Sequence.field3074) {
            Sequence.field3074 = System.getenv("HOME");
         }

         if(Sequence.field3074 != null) {
            Sequence.field3074 = Sequence.field3074 + "/";
         }
      } catch (Exception var29) {
         ;
      }

      if(Sequence.field3074 == null) {
         Sequence.field3074 = "~/";
      }

      Frames.field1594 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Sequence.field3074, "/tmp/", ""};
      class15.field173 = new String[]{".jagex_cache_" + class104.field1715, ".file_store_" + class104.field1715};
      int var18 = 0;

      File var5;
      label295:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class104.field1708 = new File(Sequence.field3074, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var39;
         if(class104.field1708.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class104.field1708, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.method1449()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method1450(var11.payload, var11.offset, var11.payload.length - var11.offset);
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
                  var7 = var11.method2876();
                  if(var13 == 1) {
                     var8 = var11.method2876();
                  }
               } else {
                  var7 = var11.method2859();
                  if(var13 == 1) {
                     var8 = var11.method2859();
                  }
               }

               var10.method1448();
            } catch (IOException var34) {
               var34.printStackTrace();
            }

            if(null != var7) {
               var39 = new File(var7);
               if(!var39.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var39 = new File(var7, "test.dat");
               if(!class60.method1174(var39, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label270:
            for(int var19 = 0; var19 < class15.field173.length; ++var19) {
               for(int var20 = 0; var20 < Frames.field1594.length; ++var20) {
                  File var21 = new File(Frames.field1594[var20] + class15.field173[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && class60.method1174(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label270;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = Sequence.field3074 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var38;
         if(var8 != null) {
            var38 = new File(var8);
            var39 = new File(var7);

            try {
               File[] var41 = var38.listFiles();
               File[] var22 = var41;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var39, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var33) {
               var33.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var38 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var42 = new FileOnDisk(class104.field1708, "rw", 10000L);
               Buffer var43 = new Buffer(500);
               var43.putByte(3);
               var43.putByte(var11 != null?1:0);
               var43.method2860(var38.getPath());
               if(var11 != null) {
                  var43.method2860("");
               }

               var42.method1447(var43.payload, 0, var43.offset);
               var42.method1448();
            } catch (IOException var28) {
               var28.printStackTrace();
            }
         }

         var5 = new File(var7);
         class167.field2200 = var5;
         if(!class167.field2200.exists()) {
            class167.field2200.mkdirs();
         }

         File[] var35 = class167.field2200.listFiles();
         if(var35 != null) {
            File[] var40 = var35;

            for(int var23 = 0; var23 < var40.length; ++var23) {
               File var24 = var40[var23];
               if(!class60.method1174(var24, false)) {
                  ++var18;
                  continue label295;
               }
            }
         }
         break;
      }

      File var4 = class167.field2200;
      class107.field1752 = var4;
      if(!class107.field1752.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1753 = true;

         try {
            var5 = new File(Sequence.field3074, "random.dat");
            int var26;
            if(var5.exists()) {
               class104.field1712 = new class72(new FileOnDisk(var5, "rw", 25L), 24, 0);
            } else {
               label221:
               for(int var25 = 0; var25 < class15.field173.length; ++var25) {
                  for(var26 = 0; var26 < Frames.field1594.length; ++var26) {
                     File var37 = new File(Frames.field1594[var26] + class15.field173[var25] + File.separatorChar + "random.dat");
                     if(var37.exists()) {
                        class104.field1712 = new class72(new FileOnDisk(var37, "rw", 25L), 24, 0);
                        break label221;
                     }
                  }
               }
            }

            if(class104.field1712 == null) {
               RandomAccessFile var36 = new RandomAccessFile(var5, "rw");
               var26 = var36.read();
               var36.seek(0L);
               var36.write(var26);
               var36.seek(0L);
               var36.close();
               class104.field1712 = new class72(new FileOnDisk(var5, "rw", 25L), 24, 0);
            }
         } catch (IOException var32) {
            ;
         }

         class104.field1713 = new class72(new FileOnDisk(class6.method78("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class104.field1714 = new class72(new FileOnDisk(class6.method78("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         WidgetNode.field186 = new class72[class0.field3];

         for(int var27 = 0; var27 < class0.field3; ++var27) {
            WidgetNode.field186[var27] = new class72(new FileOnDisk(class6.method78("main_file_cache.idx" + var27), "rw", 1048576L), 6000, 0);
         }

      }
   }
}
