import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class133 {
   @ObfuscatedName("e")
   static final class133 field2110 = new class133(2);
   @ObfuscatedName("i")
   static final class133 field2111 = new class133(0);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -935084481
   )
   public final int field2112;
   @ObfuscatedName("h")
   public static final class133 field2113 = new class133(1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1960201767"
   )
   static final boolean method2864(int var0, int var1) {
      ObjectComposition var2 = class9.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method842(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class133(int var1) {
      this.field2112 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "23"
   )
   public static File method2865(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class221.field3219 = new File(class152.field2280, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class221.field3219.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class221.field3219, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method4160()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method4157(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.method2544();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2544();
            }

            if(var9 <= 2) {
               var4 = var8.method2553();
               if(var10 == 1) {
                  var5 = var8.method2553();
               }
            } else {
               var4 = var8.method2554();
               if(var10 == 1) {
                  var5 = var8.method2554();
               }
            }

            var7.method4156();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(null != var4) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!class85.method1924(var22, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label125:
         for(int var15 = 0; var15 < FrameMap.field1817.length; ++var15) {
            for(int var16 = 0; var16 < class124.field2050.length; ++var16) {
               File var17 = new File(class124.field2050[var16] + FrameMap.field1817[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class85.method1924(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label125;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class152.field2280 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         XItemContainer.method186(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
