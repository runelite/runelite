import java.io.File;
import java.io.IOException;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class116 {
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1635338703
   )
   static int field1959;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 1958156993
   )
   protected static int field1961;
   @ObfuscatedName("e")
   Inflater field1964;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIILclass86;[Lclass108;I)V",
      garbageValue = "-892444613"
   )
   static final void method2469(byte[] var0, int var1, int var2, class86 var3, class108[] var4) {
      class119 var5 = new class119(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2536();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2536();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.method2523();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class5.field80[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               class108 var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class0.method1(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   class116(int var1, int var2, int var3) {
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("w")
   public static boolean method2473(CharSequence var0) {
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;
      int var5 = var0.length();
      int var6 = 0;

      boolean var1;
      while(true) {
         if(var6 >= var5) {
            var1 = var3;
            break;
         }

         label92: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(var7 == 45) {
                  var2 = true;
                  break label92;
               }

               if(43 == var7) {
                  break label92;
               }
            }

            int var9;
            if(var7 >= 48 && var7 <= 57) {
               var9 = var7 - 48;
            } else if(var7 >= 65 && var7 <= 90) {
               var9 = var7 - 55;
            } else {
               if(var7 < 97 || var7 > 122) {
                  var1 = false;
                  break;
               }

               var9 = var7 - 87;
            }

            if(var9 >= 10) {
               var1 = false;
               break;
            }

            if(var2) {
               var9 = -var9;
            }

            int var8 = var9 + var4 * 10;
            if(var8 / 10 != var4) {
               var1 = false;
               break;
            }

            var4 = var8;
            var3 = true;
         }

         ++var6;
      }

      return var1;
   }

   @ObfuscatedName("w")
   static File method2474(String var0, String var1, int var2) {
      String var3 = 0 == var2?"":"" + var2;
      class149.field2226 = new File(class35.field765, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      class119 var8;
      File var20;
      if(class149.field2226.exists()) {
         try {
            class227 var7 = new class227(class149.field2226, "rw", 10000L);

            int var9;
            for(var8 = new class119((int)var7.method4115()); var8.field1976 < var8.field1980.length; var8.field1976 += var9) {
               var9 = var7.method4121(var8.field1980, var8.field1976, var8.field1980.length - var8.field1976);
               if(-1 == var9) {
                  throw new IOException();
               }
            }

            var8.field1976 = 0;
            var9 = var8.method2523();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.method2523();
            }

            if(var9 <= 2) {
               var4 = var8.method2532();
               if(var10 == 1) {
                  var5 = var8.method2532();
               }
            } else {
               var4 = var8.method2624();
               if(1 == var10) {
                  var5 = var8.method2624();
               }
            }

            var7.method4114();
         } catch (IOException var17) {
            var17.printStackTrace();
         }

         if(null != var4) {
            var20 = new File(var4);
            if(!var20.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var20 = new File(var4, "test.dat");
            if(!class18.method184(var20, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label138:
         for(int var18 = 0; var18 < class77.field1368.length; ++var18) {
            for(int var21 = 0; var21 < class109.field1891.length; ++var21) {
               File var22 = new File(class109.field1891[var21] + class77.field1368[var18] + File.separatorChar + var0 + File.separatorChar);
               if(var22.exists() && class18.method184(new File(var22, "test.dat"), true)) {
                  var4 = var22.toString();
                  var6 = true;
                  break label138;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class35.field765 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
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
            class227 var24 = new class227(class149.field2226, "rw", 10000L);
            class119 var26 = new class119(500);
            var26.method2565(3);
            var26.method2565(null != var8?1:0);
            var26.method2516(var19.getPath());
            if(null != var8) {
               var26.method2516(var8.getPath());
            }

            var24.method4113(var26.field1980, 0, var26.field1976);
            var24.method4114();
         } catch (IOException var15) {
            var15.printStackTrace();
         }
      }

      return new File(var4);
   }

   @ObfuscatedName("e")
   public void method2475(class119 var1, byte[] var2) {
      if(var1.field1980[var1.field1976] == 31 && var1.field1980[1 + var1.field1976] == -117) {
         if(null == this.field1964) {
            this.field1964 = new Inflater(true);
         }

         try {
            this.field1964.setInput(var1.field1980, var1.field1976 + 10, var1.field1980.length - (8 + var1.field1976 + 10));
            this.field1964.inflate(var2);
         } catch (Exception var4) {
            this.field1964.reset();
            throw new RuntimeException("");
         }

         this.field1964.reset();
      } else {
         throw new RuntimeException("");
      }
   }
}
