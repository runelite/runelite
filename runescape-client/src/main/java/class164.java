import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class164 {
   @ObfuscatedName("k")
   static char[] field2680 = new char[64];
   @ObfuscatedName("q")
   static char[] field2681;
   @ObfuscatedName("f")
   static int[] field2683;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2680[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2680[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2680[var0] = (char)(48 + var0 - 52);
      }

      field2680[62] = 43;
      field2680[63] = 47;
      field2681 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2681[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2681[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2681[var0] = (char)(48 + var0 - 52);
      }

      field2681[62] = 42;
      field2681[63] = 45;
      field2683 = new int[128];

      for(var0 = 0; var0 < field2683.length; ++var0) {
         field2683[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2683[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2683[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2683[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2683;
      field2683[43] = 62;
      var2[42] = 62;
      int[] var1 = field2683;
      field2683[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "-356032534"
   )
   static File method3219(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class221.field3214 = new File(class9.field149, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class221.field3214.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class221.field3214, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method4147()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method4143(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.method2571();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2571();
            }

            if(var9 <= 2) {
               var4 = var8.method2580();
               if(var10 == 1) {
                  var5 = var8.method2580();
               }
            } else {
               var4 = var8.method2566();
               if(var10 == 1) {
                  var5 = var8.method2566();
               }
            }

            var7.method4146();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var23 = new File(var4, "test.dat");
            if(!class18.method178(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label137:
         for(int var15 = 0; var15 < class125.field2076.length; ++var15) {
            for(int var16 = 0; var16 < class22.field587.length; ++var16) {
               File var17 = new File(class22.field587[var16] + class125.field2076[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class18.method178(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label137;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class9.field149 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(var5 != null) {
         var22 = new File(var5);
         var23 = new File(var4);

         try {
            File[] var24 = var22.listFiles();
            File[] var18 = var24;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var23, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var22 = new File(var4);
         var8 = null;

         try {
            FileOnDisk var25 = new FileOnDisk(class221.field3214, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.method2556(3);
            var26.method2556(null != var8?1:0);
            var26.method2564(var22.getPath());
            if(var8 != null) {
               var26.method2564("");
            }

            var25.method4145(var26.payload, 0, var26.offset);
            var25.method4146();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }
}
