import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class49 extends class204 {
   @ObfuscatedName("h")
   static class193 field1069 = new class193(64);
   @ObfuscatedName("m")
   public boolean field1071 = false;
   @ObfuscatedName("j")
   public static class167 field1072;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "431114908"
   )
   void method998(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method999(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "11"
   )
   void method999(class119 var1, int var2) {
      if(2 == var2) {
         this.field1071 = true;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-953143136"
   )
   static final void method1002(class122 var0, int var1) {
      int var2 = var0.field1971;
      class32.field733 = 0;
      class125.method2780(var0);

      for(int var3 = 0; var3 < class32.field733; ++var3) {
         int var4 = class32.field745[var3];
         class2 var5 = client.field396[var4];
         int var6 = var0.method2500();
         if((var6 & 32) != 0) {
            var6 += var0.method2500() << 8;
         }

         byte var7 = -1;
         int var8;
         if((var6 & 128) != 0) {
            var8 = var0.method2500();
            byte[] var9 = new byte[var8];
            class119 var10 = new class119(var9);
            var0.method2511(var9, 0, var8);
            class32.field736[var4] = var10;
            var5.method8(var10);
         }

         int var21;
         if(0 != (var6 & 8)) {
            var8 = var0.method2502();
            if(var8 == '\uffff') {
               var8 = -1;
            }

            var21 = var0.method2500();
            class3.method30(var5, var8, var21);
         }

         if(0 != (var6 & 2)) {
            var5.field819 = var0.method2502();
            if('\uffff' == var5.field819) {
               var5.field819 = -1;
            }
         }

         if((var6 & 1) != 0) {
            var5.field807 = var0.method2508();
            if(var5.field807.charAt(0) == 126) {
               var5.field807 = var5.field807.substring(1);
               class8.method109(2, var5.field58, var5.field807);
            } else if(class47.field1053 == var5) {
               class8.method109(2, var5.field58, var5.field807);
            }

            var5.field846 = false;
            var5.field811 = 0;
            var5.field805 = 0;
            var5.field810 = 150;
         }

         if(0 != (var6 & 4)) {
            var8 = var0.method2502();
            var21 = var0.method2500();
            var5.method743(var8, var21, client.field285);
            var5.field828 = client.field285 + 300;
            var5.field817 = var0.method2500();
            var5.field818 = var0.method2500();
         }

         if((var6 & 64) != 0) {
            var5.field821 = var0.method2502();
            if(0 == var5.field820) {
               var5.field844 = var5.field821;
               var5.field821 = -1;
            }
         }

         if(0 != (var6 & 16)) {
            var8 = var0.method2502();
            class152 var22 = (class152)class104.method2282(class168.method3331(), var0.method2500());
            boolean var23 = var0.method2500() == 1;
            int var11 = var0.method2500();
            int var12 = var0.field1971;
            if(var5.field58 != null && var5.field36 != null) {
               boolean var13 = false;
               if(var22.field2253 && class18.method200(var5.field58)) {
                  var13 = true;
               }

               if(!var13 && client.field395 == 0 && !var5.field56) {
                  class32.field732.field1971 = 0;
                  var0.method2511(class32.field732.field1973, 0, var11);
                  class32.field732.field1971 = 0;
                  class119 var15 = class32.field732;

                  String var16;
                  int var17;
                  try {
                     var17 = var15.method2512();
                     if(var17 > 32767) {
                        var17 = 32767;
                     }

                     byte[] var18 = new byte[var17];
                     var15.field1971 += class163.field2644.method2425(var15.field1973, var15.field1971, var18, 0, var17);
                     String var19 = class139.method2912(var18, 0, var17);
                     var16 = var19;
                  } catch (Exception var20) {
                     var16 = "Cabbage";
                  }

                  var16 = class223.method4005(client.method555(var16));
                  var5.field807 = var16.trim();
                  var5.field811 = var8 >> 8;
                  var5.field805 = var8 & 255;
                  var5.field810 = 150;
                  var5.field846 = var23;
                  var5.field830 = class47.field1053 != var5 && var22.field2253 && client.field481 != "" && var16.toLowerCase().indexOf(client.field481) == -1;
                  if(var22.field2252) {
                     var17 = var23?91:1;
                  } else {
                     var17 = var23?90:2;
                  }

                  if(-1 != var22.field2251) {
                     class8.method109(var17, class7.method106(var22.field2251) + var5.field58, var16);
                  } else {
                     class8.method109(var17, var5.field58, var16);
                  }
               }
            }

            var0.field1971 = var11 + var12;
         }

         if((var6 & 256) != 0) {
            var5.field856 = var0.method2502();
            var8 = var0.method2505();
            var5.field834 = var8 >> 16;
            var5.field833 = client.field285 + (var8 & '\uffff');
            var5.field831 = 0;
            var5.field832 = 0;
            if(var5.field833 > client.field285) {
               var5.field831 = -1;
            }

            if(var5.field856 == '\uffff') {
               var5.field856 = -1;
            }
         }

         if(0 != (var6 & 1024)) {
            var5.field835 = var0.method2670();
            var5.field837 = var0.method2670();
            var5.field813 = var0.method2670();
            var5.field838 = var0.method2670();
            var5.field839 = var0.method2502() + client.field285;
            var5.field801 = var0.method2502() + client.field285;
            var5.field841 = var0.method2502();
            if(var5.field59) {
               var5.field835 += var5.field60;
               var5.field837 += var5.field51;
               var5.field813 += var5.field60;
               var5.field838 += var5.field51;
               var5.field820 = 0;
            } else {
               var5.field835 += var5.field848[0];
               var5.field837 += var5.field822[0];
               var5.field813 += var5.field848[0];
               var5.field838 += var5.field822[0];
               var5.field820 = 1;
            }

            var5.field852 = 0;
         }

         if((var6 & 2048) != 0) {
            var8 = var0.method2502();
            var21 = var0.method2500();
            var5.method743(var8, var21, client.field285);
            var5.field828 = 300 + client.field285;
            var5.field817 = var0.method2500();
            var5.field818 = var0.method2500();
         }

         if(0 != (var6 & 512)) {
            class32.field735[var4] = var0.method2670();
         }

         if((var6 & 4096) != 0) {
            var7 = var0.method2670();
         }

         if(0 != (var6 & 8192)) {
            for(var8 = 0; var8 < 3; ++var8) {
               var5.field61[var8] = var0.method2508();
            }
         }

         if(var5.field59) {
            if(var7 == 127) {
               var5.method13(var5.field60, var5.field51);
            } else {
               byte var24;
               if(var7 != -1) {
                  var24 = var7;
               } else {
                  var24 = class32.field735[var4];
               }

               var5.method26(var5.field60, var5.field51, var24);
            }
         }
      }

      if(var1 != var0.field1971 - var2) {
         throw new RuntimeException(var0.field1971 - var2 + " " + var1);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass22;",
      garbageValue = "-1229643162"
   )
   static class22 method1008(int var0) {
      class22 var1 = (class22)class22.field572.method3704((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class104.field1776.method3217(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field1971 = var3.field1973.length - 12;
            int var4 = var3.method2505();
            var1.field578 = var3.method2502();
            var1.field575 = var3.method2502();
            var1.field577 = var3.method2502();
            var1.field581 = var3.method2502();
            var3.field1971 = 0;
            var3.method2507();
            var1.field576 = new int[var4];
            var1.field571 = new int[var4];
            var1.field574 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1971 < var3.field1973.length - 12; var1.field576[var5++] = var6) {
               var6 = var3.method2502();
               if(var6 == 3) {
                  var1.field574[var5] = var3.method2508();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && var6 != 39) {
                  var1.field571[var5] = var3.method2505();
               } else {
                  var1.field571[var5] = var3.method2500();
               }
            }

            class22.field572.method3706(var1, (long)var0);
            return var1;
         }
      }
   }
}
