import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class50 extends class207 {
   @ObfuscatedName("g")
   public static class196 field1117 = new class196(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1737875485
   )
   public int field1119;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1857654723
   )
   public int field1120;
   @ObfuscatedName("eg")
   static class81[] field1121;
   @ObfuscatedName("m")
   static class176 field1122;
   @ObfuscatedName("ch")
   static class149 field1123;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 349225909
   )
   public int field1124;
   @ObfuscatedName("l")
   public static class170 field1125;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "409075097"
   )
   void method1060(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1119 = var1.method2635();
         this.field1120 = var1.method2633();
         this.field1124 = var1.method2633();
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-9"
   )
   public static int method1067(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-49"
   )
   public static void method1068(boolean var0) {
      if(class55.field1198 != var0) {
         class55.field1186.method3910();
         class55.field1222.method3910();
         class55.field1177.method3910();
         class55.field1198 = var0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "15"
   )
   public void method1075(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method1060(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)Z",
      garbageValue = "-121"
   )
   static boolean method1076(class125 var0, int var1) {
      int var2 = var0.method2907(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2907(1) != 0) {
            method1076(var0, var1);
         }

         var3 = var0.method2907(6);
         var4 = var0.method2907(6);
         boolean var12 = var0.method2907(1) == 1;
         if(var12) {
            class34.field779[++class34.field785 - 1] = var1;
         }

         if(client.field302[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var11 = client.field302[var1] = new class2();
            var11.field53 = var1;
            if(class34.field791[var1] != null) {
               var11.method29(class34.field791[var1]);
            }

            var11.field882 = class34.field788[var1];
            var11.field844 = class34.field780[var1];
            var7 = class34.field790[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field888[0] = class34.field781[var1];
            var11.field52 = (byte)var8;
            var11.method19((var9 << 6) + var3 - class0.field11, (var10 << 6) + var4 - class21.field592);
            var11.field45 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2907(2);
         var4 = class34.field790[var1];
         class34.field790[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2907(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class34.field790[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class34.field790[var1] = (var7 << 28) + (var8 << 14) + var9;
            return false;
         } else {
            var3 = var0.method2907(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class34.field790[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var6 & 255;
            class34.field790[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "-849204031"
   )
   static void method1077(int var0, int var1, int var2, int var3, String var4) {
      class176 var5 = class151.method3265(var1, var2);
      if(var5 != null) {
         if(var5.field2907 != null) {
            class0 var6 = new class0();
            var6.field2 = var5;
            var6.field14 = var0;
            var6.field0 = var4;
            var6.field8 = var5.field2907;
            class16.method203(var6);
         }

         boolean var10 = true;
         if(var5.field2811 > 0) {
            var10 = class126.method2917(var5);
         }

         if(var10) {
            int var8 = class2.method39(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  client.field337.method2903(181);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 2) {
                  client.field337.method2903(136);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 3) {
                  client.field337.method2903(114);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 4) {
                  client.field337.method2903(149);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 5) {
                  client.field337.method2903(96);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 6) {
                  client.field337.method2903(157);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 7) {
                  client.field337.method2903(110);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 8) {
                  client.field337.method2903(109);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 9) {
                  client.field337.method2903(143);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

               if(var0 == 10) {
                  client.field337.method2903(212);
                  client.field337.method2728(var1);
                  client.field337.method2619(var2);
                  client.field337.method2619(var3);
               }

            }
         }
      }
   }
}
