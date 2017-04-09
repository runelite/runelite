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
      } catch (Exception var23) {
         class33.field767 = "Unknown";
      }

      class49.field972 = class33.field767.toLowerCase();

      try {
         Sequence.field3074 = System.getProperty("user.home");
         if(Sequence.field3074 != null) {
            Sequence.field3074 = Sequence.field3074 + "/";
         }
      } catch (Exception var22) {
         ;
      }

      try {
         if(class49.field972.startsWith("win")) {
            if(Sequence.field3074 == null) {
               Sequence.field3074 = System.getenv("USERPROFILE");
            }
         } else if(Sequence.field3074 == null) {
            Sequence.field3074 = System.getenv("HOME");
         }

         if(Sequence.field3074 != null) {
            Sequence.field3074 = Sequence.field3074 + "/";
         }
      } catch (Exception var21) {
         ;
      }

      if(Sequence.field3074 == null) {
         Sequence.field3074 = "~/";
      }

      Frames.field1594 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Sequence.field3074, "/tmp/", ""};
      class15.field173 = new String[]{".jagex_cache_" + class104.field1715, ".file_store_" + class104.field1715};
      int var4 = 0;

      File var5;
      label259:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class104.field1708 = new File(Sequence.field3074, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var10;
         File var11;
         int var12;
         if(class104.field1708.exists()) {
            try {
               FileOnDisk var13 = new FileOnDisk(class104.field1708, "rw", 10000L);

               for(var10 = new Buffer((int)var13.method1449()); var10.offset < var10.payload.length; var10.offset += var12) {
                  var12 = var13.method1450(var10.payload, var10.offset, var10.payload.length - var10.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var10.offset = 0;
               var12 = var10.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var14 = 0;
               if(var12 > 1) {
                  var14 = var10.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var10.method2876();
                  if(var14 == 1) {
                     var8 = var10.method2876();
                  }
               } else {
                  var7 = var10.method2859();
                  if(var14 == 1) {
                     var8 = var10.method2859();
                  }
               }

               var13.method1448();
            } catch (IOException var26) {
               var26.printStackTrace();
            }

            if(var7 != null) {
               var11 = new File(var7);
               if(!var11.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var11 = new File(var7, "test.dat");
               if(!class60.method1174(var11, true)) {
                  var7 = null;
               }
            }
         }

         int var32;
         File var33;
         if(var7 == null && var4 == 0) {
            label233:
            for(var32 = 0; var32 < class15.field173.length; ++var32) {
               for(var12 = 0; var12 < Frames.field1594.length; ++var12) {
                  var33 = new File(Frames.field1594[var12] + class15.field173[var32] + File.separatorChar + var0 + File.separatorChar);
                  if(var33.exists() && class60.method1174(new File(var33, "test.dat"), true)) {
                     var7 = var33.toString();
                     var9 = true;
                     break label233;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = Sequence.field3074 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var15;
         File[] var16;
         File[] var17;
         if(var8 != null) {
            var15 = new File(var8);
            var11 = new File(var7);

            try {
               var16 = var15.listFiles();
               var17 = var16;

               for(var32 = 0; var32 < var17.length; ++var32) {
                  var33 = var17[var32];
                  File var18 = new File(var11, var33.getName());
                  boolean var19 = var33.renameTo(var18);
                  if(!var19) {
                     throw new IOException();
                  }
               }
            } catch (Exception var25) {
               var25.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var15 = new File(var7);
            var10 = null;

            try {
               FileOnDisk var34 = new FileOnDisk(class104.field1708, "rw", 10000L);
               Buffer var35 = new Buffer(500);
               var35.putByte(3);
               var35.putByte(var10 != null?1:0);
               var35.method2860(var15.getPath());
               if(var10 != null) {
                  var35.method2860("");
               }

               var34.method1447(var35.payload, 0, var35.offset);
               var34.method1448();
            } catch (IOException var20) {
               var20.printStackTrace();
            }
         }

         var5 = new File(var7);
         class167.field2200 = var5;
         if(!class167.field2200.exists()) {
            class167.field2200.mkdirs();
         }

         var16 = class167.field2200.listFiles();
         if(var16 != null) {
            var17 = var16;

            for(var32 = 0; var32 < var17.length; ++var32) {
               var33 = var17[var32];
               if(!class60.method1174(var33, false)) {
                  ++var4;
                  continue label259;
               }
            }
         }
         break;
      }

      File var27 = class167.field2200;
      class107.field1752 = var27;
      if(!class107.field1752.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1753 = true;

         int var31;
         try {
            var5 = new File(Sequence.field3074, "random.dat");
            if(var5.exists()) {
               class104.field1712 = new class72(new FileOnDisk(var5, "rw", 25L), 24, 0);
            } else {
               label184:
               for(int var28 = 0; var28 < class15.field173.length; ++var28) {
                  for(var31 = 0; var31 < Frames.field1594.length; ++var31) {
                     File var30 = new File(Frames.field1594[var31] + class15.field173[var28] + File.separatorChar + "random.dat");
                     if(var30.exists()) {
                        class104.field1712 = new class72(new FileOnDisk(var30, "rw", 25L), 24, 0);
                        break label184;
                     }
                  }
               }
            }

            if(class104.field1712 == null) {
               RandomAccessFile var29 = new RandomAccessFile(var5, "rw");
               var31 = var29.read();
               var29.seek(0L);
               var29.write(var31);
               var29.seek(0L);
               var29.close();
               class104.field1712 = new class72(new FileOnDisk(var5, "rw", 25L), 24, 0);
            }
         } catch (IOException var24) {
            ;
         }

         class104.field1713 = new class72(new FileOnDisk(class6.method78("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class104.field1714 = new class72(new FileOnDisk(class6.method78("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         WidgetNode.field186 = new class72[class0.field3];

         for(var31 = 0; var31 < class0.field3; ++var31) {
            WidgetNode.field186[var31] = new class72(new FileOnDisk(class6.method78("main_file_cache.idx" + var31), "rw", 1048576L), 6000, 0);
         }

      }
   }
}
