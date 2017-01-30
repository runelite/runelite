import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class203 {
   @ObfuscatedName("p")
   static final char[] field3069 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "1329615568"
   )
   static File method3795(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1682 = new File(ChatLineBuffer.field971, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      Buffer var8;
      File var23;
      if(class104.field1682.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1682, "rw", 10000L);

            int var9;
            for(var8 = new Buffer((int)var7.method1418()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1405(var8.payload, var8.offset, var8.payload.length - var8.offset);
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
               var4 = var8.method2825();
               if(var10 == 1) {
                  var5 = var8.method2825();
               }
            } else {
               var4 = var8.method2861();
               if(var10 == 1) {
                  var5 = var8.method2861();
               }
            }

            var7.method1403();
         } catch (IOException var21) {
            var21.printStackTrace();
         }

         if(var4 != null) {
            var23 = new File(var4);
            if(!var23.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var23 = new File(var4, "test.dat");
            if(!class22.method216(var23, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label138:
         for(int var15 = 0; var15 < class174.field2633.length; ++var15) {
            for(int var16 = 0; var16 < class60.field1084.length; ++var16) {
               File var17 = new File(class60.field1084[var16] + class174.field2633[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class22.method216(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label138;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = ChatLineBuffer.field971 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
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
            FileOnDisk var25 = new FileOnDisk(class104.field1682, "rw", 10000L);
            Buffer var26 = new Buffer(500);
            var26.method2799(3);
            var26.method2799(var8 != null?1:0);
            var26.method2807(var22.getPath());
            if(null != var8) {
               var26.method2807("");
            }

            var25.method1402(var26.payload, 0, var26.offset);
            var25.method1403();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }

   class203() throws Throwable {
      throw new Error();
   }
}
