import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class190 {
   @ObfuscatedName("z")
   public static final class190 field3062 = new class190("13", "13");
   @ObfuscatedName("a")
   public static final class190 field3063 = new class190("15", "15");
   @ObfuscatedName("m")
   public static final class190 field3064 = new class190("9", "9");
   @ObfuscatedName("d")
   public static final class190 field3065 = new class190("14", "14");
   @ObfuscatedName("x")
   public static final class190 field3066 = new class190("11", "11");
   @ObfuscatedName("e")
   public static final class190 field3067 = new class190("2", "2");
   @ObfuscatedName("i")
   public static final class190 field3068 = new class190("10", "10");
   @ObfuscatedName("c")
   public static final class190 field3069 = new class190("3", "3");
   @ObfuscatedName("l")
   public static final class190 field3070 = new class190("6", "6");
   @ObfuscatedName("h")
   public static final class190 field3071 = new class190("4", "4");
   @ObfuscatedName("u")
   public static final class190 field3072 = new class190("12", "12");
   @ObfuscatedName("r")
   public static final class190 field3073 = new class190("8", "8");
   @ObfuscatedName("n")
   public static final class190 field3074 = new class190("1", "1");
   @ObfuscatedName("j")
   public static final class190 field3075 = new class190("7", "7");
   @ObfuscatedName("p")
   public static final class190 field3076 = new class190("5", "5");
   @ObfuscatedName("q")
   public final String field3077;

   class190(String var1, String var2) {
      this.field3077 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "45"
   )
   public static File method3699(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class149.field2212 = new File(class89.field1529, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class119 var8;
      File var20;
      if(class149.field2212.exists()) {
         try {
            class227 var7 = new class227(class149.field2212, "rw", 10000L);

            int var9;
            for(var8 = new class119((int)var7.method4092()); var8.field1971 < var8.field1973.length; var8.field1971 += var9) {
               var9 = var7.method4093(var8.field1973, var8.field1971, var8.field1973.length - var8.field1971);
               if(-1 == var9) {
                  throw new IOException();
               }
            }

            var8.field1971 = 0;
            var9 = var8.method2500();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2500();
            }

            if(var9 <= 2) {
               var4 = var8.method2509();
               if(1 == var10) {
                  var5 = var8.method2509();
               }
            } else {
               var4 = var8.method2510();
               if(var10 == 1) {
                  var5 = var8.method2510();
               }
            }

            var7.method4088();
         } catch (IOException var17) {
            var17.printStackTrace();
         }

         if(null != var4) {
            var20 = new File(var4);
            if(!var20.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var20 = new File(var4, "test.dat");
            if(!class134.method2840(var20, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label138:
         for(int var18 = 0; var18 < class124.field2007.length; ++var18) {
            for(int var21 = 0; var21 < class19.field268.length; ++var21) {
               File var22 = new File(class19.field268[var21] + class124.field2007[var18] + File.separatorChar + var0 + File.separatorChar);
               if(var22.exists() && class134.method2840(new File(var22, "test.dat"), true)) {
                  var4 = var22.toString();
                  var6 = true;
                  break label138;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class89.field1529 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      File var19;
      if(var5 != null) {
         var19 = new File(var5);
         var20 = new File(var4);

         try {
            File[] var23 = var19.listFiles();
            File[] var25 = var23;

            for(int var11 = 0; var11 < var25.length; ++var11) {
               File var12 = var25[var11];
               File var13 = new File(var20, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var16) {
            var16.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         var19 = new File(var4);
         var8 = null;

         try {
            class227 var24 = new class227(class149.field2212, "rw", 10000L);
            class119 var26 = new class119(500);
            var26.method2503(3);
            var26.method2503(null != var8?1:0);
            var26.method2569(var19.getPath());
            if(var8 != null) {
               //var26.method2569(var8.getPath());
            }

            var24.method4097(var26.field1973, 0, var26.field1971);
            var24.method4088();
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      return new File(var4);
   }
}
