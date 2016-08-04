import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class54 extends class207 {
   @ObfuscatedName("l")
   static class170 field1169;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1511999975
   )
   public int field1170 = 0;
   @ObfuscatedName("g")
   static class196 field1171 = new class196(64);
   @ObfuscatedName("rq")
   protected static boolean field1172;
   @ObfuscatedName("qu")
   @Export("bufferProvider")
   public static class80 field1173;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "1037792829"
   )
   void method1152(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1162(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[Lclass81;",
      garbageValue = "1386923093"
   )
   static class81[] method1153(class170 var0, int var1, int var2) {
      return !class4.method49(var0, var1, var2)?null:class7.method112();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-2092321833"
   )
   static final void method1154(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class136.field2126.method1998(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class136.field2126.method2081(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class23.field619.field1487;
         var11 = 24624 + var1 * 4 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         class42 var13 = class160.method3312(var12);
         if(var13.field950 != -1) {
            class83 var14 = class90.field1611[var13.field950];
            if(null != var14) {
               int var15 = (var13.field960 * 4 - var14.field1498) / 2;
               int var16 = (var13.field970 * 4 - var14.field1503) / 2;
               var14.method1954(48 + var1 * 4 + var15, 48 + 4 * (104 - var2 - var13.field970) + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class136.field2126.method2019(var0, var1, var2);
      if(var5 != 0) {
         var6 = class136.field2126.method2081(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class42 var23 = class160.method3312(var9);
         int var18;
         if(var23.field950 != -1) {
            class83 var19 = class90.field1611[var23.field950];
            if(var19 != null) {
               var12 = (var23.field960 * 4 - var19.field1498) / 2;
               var18 = (var23.field970 * 4 - var19.field1503) / 2;
               var19.method1954(var12 + 48 + var1 * 4, (104 - var2 - var23.field970) * 4 + 48 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = class23.field619.field1487;
            var18 = (103 - var2) * 2048 + 24624 + 4 * var1;
            if(var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[512 + var18 + 1] = var11;
               var17[1024 + var18 + 2] = var11;
               var17[3 + var18 + 1536] = var11;
            } else {
               var17[var18 + 1536] = var11;
               var17[1 + var18 + 1024] = var11;
               var17[512 + var18 + 2] = var11;
               var17[var18 + 3] = var11;
            }
         }
      }

      var5 = class136.field2126.method2014(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class42 var21 = class160.method3312(var6);
         if(var21.field950 != -1) {
            class83 var20 = class90.field1611[var21.field950];
            if(null != var20) {
               var9 = (var21.field960 * 4 - var20.field1498) / 2;
               int var22 = (var21.field970 * 4 - var20.field1503) / 2;
               var20.method1954(var9 + 48 + 4 * var1, (104 - var2 - var21.field970) * 4 + 48 + var22);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-2123186596"
   )
   void method1162(class122 var1, int var2) {
      if(var2 == 2) {
         this.field1170 = var1.method2635();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1654941550"
   )
   public static int method1164(int var0) {
      class50 var1 = class24.method602(var0);
      int var2 = var1.field1119;
      int var3 = var1.field1120;
      int var4 = var1.field1124;
      int var5 = class179.field2959[var4 - var3];
      return class179.field2958[var2] >> var3 & var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1948359571"
   )
   public static int method1165(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)[Lclass81;",
      garbageValue = "737334618"
   )
   public static class81[] method1167(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      return method1153(var0, var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1170310488"
   )
   public static void method1169() {
      class182.field2978.method3910();
   }
}
