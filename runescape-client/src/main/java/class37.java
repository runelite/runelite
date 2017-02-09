import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class37 {
   @ObfuscatedName("bz")
   static class184 field786;

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "44"
   )
   public static File method758(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1691 = new File(ChatLineBuffer.field968, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class104.field1691.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1691, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method1420()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1421(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method2918();
               if(var10 == 1) {
                  var5 = var8.method2918();
               }
            } else {
               var4 = var8.method2936();
               if(var10 == 1) {
                  var5 = var8.method2936();
               }
            }

            var7.method1419();
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
            if(!CombatInfo1.method650(var23, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label141:
         for(int var15 = 0; var15 < class104.field1697.length; ++var15) {
            for(int var16 = 0; var16 < FileOnDisk.field1198.length; ++var16) {
               File var17 = new File(FileOnDisk.field1198[var16] + class104.field1697[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && CombatInfo1.method650(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label141;
               }
            }
         }
      }

      if(null == var4) {
         var4 = ChatLineBuffer.field968 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var22;
      if(null != var5) {
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
            FileOnDisk var25 = new FileOnDisk(class104.field1691, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.method2912(3);
            var26.method2912(null != var8?1:0);
            var26.method3033(var22.getPath());
            if(var8 != null) {
               var26.method3033("");
            }

            var25.method1418(var26.payload, 0, var26.offset);
            var25.method1419();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1158491866"
   )
   public static Widget method759(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || Widget.widgets[var1][var2] == null) {
         boolean var3 = class15.method193(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
