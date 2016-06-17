import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class36 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -747703339
   )
   static int field774 = 0;
   @ObfuscatedName("j")
   static int[] field776;
   @ObfuscatedName("d")
   static String[] field778;
   @ObfuscatedName("y")
   static int[][] field779 = new int[5][5000];
   @ObfuscatedName("r")
   static int[] field780 = new int[1000];
   @ObfuscatedName("p")
   static class173 field781;
   @ObfuscatedName("x")
   static int[] field782 = new int[5];
   @ObfuscatedName("u")
   static class14[] field783 = new class14[50];
   @ObfuscatedName("w")
   static Calendar field785 = Calendar.getInstance();
   @ObfuscatedName("z")
   static final String[] field786 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1500883233
   )
   static int field787 = 0;
   @ObfuscatedName("aw")
   static int[] field788;
   @ObfuscatedName("c")
   @Export("chatboxSegments")
   static String[] field789 = new String[1000];

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "635550662"
   )
   static File method751(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class219.field3171 = new File(class119.field1985, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class119 var8;
      File var23;
      if(class219.field3171.exists()) {
         try {
            class227 var7 = new class227(class219.field3171, "rw", 10000L);

            int var9;
            for(var8 = new class119((int)var7.method4113()); var8.field1976 < var8.field1982.length; var8.field1976 += var9) {
               var9 = var7.method4118(var8.field1982, var8.field1976, var8.field1982.length - var8.field1976);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.field1976 = 0;
            var9 = var8.method2514();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2514();
            }

            if(var9 <= 2) {
               var4 = var8.method2527();
               if(var10 == 1) {
                  var5 = var8.method2527();
               }
            } else {
               var4 = var8.method2640();
               if(var10 == 1) {
                  var5 = var8.method2640();
               }
            }

            var7.method4116();
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
            if(!class125.method2830(var23, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label139:
         for(int var15 = 0; var15 < class121.field1993.length; ++var15) {
            for(int var16 = 0; var16 < class149.field2222.length; ++var16) {
               File var17 = new File(class149.field2222[var16] + class121.field1993[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && class125.method2830(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label139;
               }
            }
         }
      }

      if(null == var4) {
         var4 = class119.field1985 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
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
            class227 var25 = new class227(class219.field3171, "rw", 10000L);
            class119 var26 = new class119(500);
            var26.method2650(3);
            var26.method2650(var8 != null?1:0);
            var26.method2507(var22.getPath());
            Object var10000 = null;
            var25.method4127(var26.field1982, 0, var26.field1976);
            var25.method4116();
         } catch (IOException var19) {
            var19.printStackTrace();
         }
      }

      return new File(var4);
   }
}
