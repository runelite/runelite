import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class49 extends class204 {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1388803171
   )
   protected static int field1097;
   @ObfuscatedName("w")
   public static class193 field1098 = new class193(64);
   @ObfuscatedName("d")
   public boolean field1099 = false;
   @ObfuscatedName("a")
   public static class167 field1101;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)Lclass77;",
      garbageValue = "-1690261689"
   )
   public static class77 method1098(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1971(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1971(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-903967199"
   )
   void method1105(class119 var1, int var2) {
      if(2 == var2) {
         this.field1099 = true;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIZB)Lclass78;",
      garbageValue = "-68"
   )
   public static final class78 method1109(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(2 == var4 && 1 != var1) {
         var4 = 1;
      }

      long var6 = ((long)var3 << 42) + ((long)var4 << 40) + ((long)var1 << 16) + (long)var0 + ((long)var2 << 38);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1146.method3840(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class11.method178(var0);
      if(var1 > 1 && null != var9.field1153) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1154[var11] && var9.field1154[var11] != 0) {
               var10 = var9.field1153[var11];
            }
         }

         if(var10 != -1) {
            var9 = class11.method178(var10);
         }
      }

      class105 var21 = var9.method1132(1);
      if(var21 == null) {
         return null;
      } else {
         class78 var22 = null;
         if(var9.field1156 != -1) {
            var22 = method1109(var9.field1155, 10, 1, 0, 0, true);
            if(var22 == null) {
               return null;
            }
         } else if(-1 != var9.field1128) {
            var22 = method1109(var9.field1130, var1, var2, var3, 0, false);
            if(null == var22) {
               return null;
            }
         } else if(var9.field1144 != -1) {
            var22 = method1109(var9.field1119, var1, 0, 0, 0, false);
            if(var22 == null) {
               return null;
            }
         }

         int[] var12 = class79.field1413;
         int var13 = class79.field1417;
         int var14 = class79.field1414;
         int[] var15 = new int[4];
         class79.method1931(var15);
         var8 = new class78(36, 32);
         class79.method1942(var8.field1411, 36, 32);
         class79.method1893();
         class91.method2169();
         class91.method2172(16, 16);
         class91.field1573 = false;
         if(-1 != var9.field1144) {
            var22.method1798(0, 0);
         }

         int var16 = var9.field1148;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(2 == var2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class91.field1593[var9.field1131] * var16 >> 16;
         int var18 = var16 * class91.field1594[var9.field1131] >> 16;
         var21.method2418();
         var21.method2420(0, var9.field1132, var9.field1121, var9.field1131, var9.field1134, var17 + var21.field1465 / 2 + var9.field1114, var9.field1114 + var18);
         if(-1 != var9.field1128) {
            var22.method1798(0, 0);
         }

         if(var2 >= 1) {
            var8.method1876(1);
         }

         if(var2 >= 2) {
            var8.method1876(16777215);
         }

         if(var3 != 0) {
            var8.method1794(var3);
         }

         class79.method1942(var8.field1411, 36, 32);
         if(-1 != var9.field1156) {
            var22.method1798(0, 0);
         }

         if(1 == var4 || var4 == 2 && var9.field1136 == 1) {
            class224 var19 = class51.field1159;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4116(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1146.method3842(var8, var6);
         }

         class79.method1942(var12, var13, var14);
         class79.method1949(var15);
         class91.method2169();
         class91.field1573 = true;
         return var8;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;S)V",
      garbageValue = "17851"
   )
   public void method1110(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method1105(var1, var2);
      }
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1828679099"
   )
   static final void method1111(class173 var0, int var1, int var2) {
      if(null == client.field465 && !client.field433) {
         if(null != var0) {
            class173 var4 = class4.method52(var0);
            if(var4 == null) {
               var4 = var0.field2788;
            }

            if(null != var4) {
               client.field465 = var0;
               var4 = class4.method52(var0);
               if(null == var4) {
                  var4 = var0.field2788;
               }

               client.field409 = var4;
               client.field464 = var1;
               client.field485 = var2;
               class11.field184 = 0;
               client.field476 = false;
               if(client.field434 > 0) {
                  class16.method214(client.field434 - 1);
               }

               return;
            }
         }

      }
   }
}
