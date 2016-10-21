import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1720002487
   )
   int field1506;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1040825521
   )
   int field1507;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -766432365
   )
   int field1508;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "1480221152"
   )
   public static class56 method1951(int var0) {
      class56 var1 = (class56)class56.field1209.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class56.field1208.method3304(16, var0);
         var1 = new class56();
         if(var2 != null) {
            var1.method1158(new Buffer(var2));
         }

         class56.field1209.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-1861425371"
   )
   static File method1952(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class152.field2282 = new File(class152.field2278, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      int var11;
      File var27;
      if(class152.field2282.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class152.field2282, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method4206()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method4193(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.method2656();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2656();
            }

            if(var9 <= 2) {
               var4 = var8.method2517();
               if(var10 == 1) {
                  var5 = var8.method2517();
               }
            } else {
               var4 = var8.method2612();
               if(var10 == 1) {
                  var5 = var8.method2612();
               }
            }

            var7.method4191();
         } catch (IOException var25) {
            var25.printStackTrace();
         }

         if(var4 != null) {
            var27 = new File(var4);
            if(!var27.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var27 = new File(var4, "test.dat");

            boolean var28;
            try {
               RandomAccessFile var15 = new RandomAccessFile(var27, "rw");
               var11 = var15.read();
               var15.seek(0L);
               var15.write(var11);
               var15.seek(0L);
               var15.close();
               var27.delete();
               var28 = true;
            } catch (Exception var23) {
               var28 = false;
            }

            if(!var28) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label156:
         for(int var16 = 0; var16 < class43.field982.length; ++var16) {
            for(int var17 = 0; var17 < class75.field1398.length; ++var17) {
               File var18 = new File(class75.field1398[var17] + class43.field982[var16] + File.separatorChar + var0 + File.separatorChar);
               if(var18.exists()) {
                  File var19 = new File(var18, "test.dat");

                  boolean var29;
                  try {
                     RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
                     int var13 = var12.read();
                     var12.seek(0L);
                     var12.write(var13);
                     var12.seek(0L);
                     var12.close();
                     var19.delete();
                     var29 = true;
                  } catch (Exception var22) {
                     var29 = false;
                  }

                  if(var29) {
                     var4 = var18.toString();
                     var6 = true;
                     break label156;
                  }
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class152.field2278 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var26;
      if(null != var5) {
         var26 = new File(var5);
         var27 = new File(var4);

         try {
            File[] var33 = var26.listFiles();
            File[] var31 = var33;

            for(var11 = 0; var11 < var31.length; ++var11) {
               File var30 = var31[var11];
               File var20 = new File(var27, var30.getName());
               boolean var14 = var30.renameTo(var20);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var24) {
            var24.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var26 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var34 = new FileOnDisk(class152.field2282, "rw", 10000L);
            Buffer var32 = new Buffer(500);
            var32.method2518(3);
            var32.method2518(var8 != null?1:0);
            var32.method2552(var26.getPath());
            if(null != var8) {
               var32.method2552("");
            }

            var34.method4190(var32.payload, 0, var32.offset);
            var34.method4191();
         } catch (IOException var21) {
            var21.printStackTrace();
         }
      }

      return new File(var4);
   }
}
