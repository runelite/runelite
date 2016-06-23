import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class43 extends class204 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -981503957
   )
   public int field1020 = -1;
   @ObfuscatedName("u")
   public static class167 field1021;
   @ObfuscatedName("s")
   short[] field1022;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -542405463
   )
   int field1023;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -161758727
   )
   int field1024;
   @ObfuscatedName("x")
   static class193 field1025 = new class193(64);
   @ObfuscatedName("b")
   static class193 field1026 = new class193(30);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -911636335
   )
   int field1027 = 128;
   @ObfuscatedName("g")
   short[] field1028;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1936490465
   )
   int field1029 = 128;
   @ObfuscatedName("r")
   short[] field1030;
   @ObfuscatedName("m")
   short[] field1032;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -373923935
   )
   int field1033 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 558439375
   )
   int field1034 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1691976959
   )
   int field1035 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -320354041
   )
   static int field1036;
   @ObfuscatedName("f")
   public static class167 field1038;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "811347910"
   )
   void method940(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method953(var1, var2);
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIII)V",
      garbageValue = "2030898171"
   )
   static final void method946(class173 var0, int var1, int var2, int var3) {
      class8.method114();
      class175 var4 = var0.method3454(false);
      if(var4 != null) {
         class79.method1848(var1, var2, var1 + var4.field2900, var2 + var4.field2901);
         if(client.field523 != 2 && client.field523 != 5) {
            int var5 = client.field500 + client.field374 & 2047;
            int var6 = 48 + class15.field225.field837 / 32;
            int var7 = 464 - class15.field225.field880 / 32;
            class178.field2911.method1774(var1, var2, var4.field2900, var4.field2901, var6, var7, var5, 256 + client.field363, var4.field2898, var4.field2899);

            int var8;
            int var10;
            int var18;
            for(var8 = 0; var8 < client.field517; ++var8) {
               var18 = 2 + 4 * client.field518[var8] - class15.field225.field837 / 32;
               var10 = 2 + 4 * client.field519[var8] - class15.field225.field880 / 32;
               class160.method3199(var1, var2, var18, var10, client.field520[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var18 = 0; var18 < 104; ++var18) {
                  class199 var17 = client.field572[class14.field212][var8][var18];
                  if(var17 != null) {
                     var11 = var8 * 4 + 2 - class15.field225.field837 / 32;
                     var12 = 4 * var18 + 2 - class15.field225.field880 / 32;
                     class160.method3199(var1, var2, var11, var12, class111.field1959[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < client.field494; ++var8) {
               class34 var9 = client.field328[client.field330[var8]];
               if(null != var9 && var9.vmethod790()) {
                  class39 var22 = var9.field782;
                  if(var22 != null && var22.field910 != null) {
                     var22 = var22.method813();
                  }

                  if(null != var22 && var22.field897 && var22.field926) {
                     var11 = var9.field837 / 32 - class15.field225.field837 / 32;
                     var12 = var9.field880 / 32 - class15.field225.field880 / 32;
                     class160.method3199(var1, var2, var11, var12, class111.field1959[1], var4);
                  }
               }
            }

            var8 = class32.field753;
            int[] var20 = class32.field761;

            for(var10 = 0; var10 < var8; ++var10) {
               class2 var19 = client.field302[var20[var10]];
               if(null != var19 && var19.vmethod790() && !var19.field46 && var19 != class15.field225) {
                  var12 = var19.field837 / 32 - class15.field225.field837 / 32;
                  int var13 = var19.field880 / 32 - class15.field225.field880 / 32;
                  boolean var14 = false;
                  if(class90.method2140(var19.field60, true)) {
                     var14 = true;
                  }

                  boolean var15 = false;

                  for(int var16 = 0; var16 < class96.field1636; ++var16) {
                     if(var19.field60.equals(class35.field792[var16].field629)) {
                        var15 = true;
                        break;
                     }
                  }

                  boolean var21 = false;
                  if(class15.field225.field57 != 0 && var19.field57 != 0 && class15.field225.field57 == var19.field57) {
                     var21 = true;
                  }

                  if(var14) {
                     class160.method3199(var1, var2, var12, var13, class111.field1959[3], var4);
                  } else if(var21) {
                     class160.method3199(var1, var2, var12, var13, class111.field1959[4], var4);
                  } else if(var15) {
                     class160.method3199(var1, var2, var12, var13, class111.field1959[5], var4);
                  } else {
                     class160.method3199(var1, var2, var12, var13, class111.field1959[2], var4);
                  }
               }
            }

            if(client.field457 != 0 && client.field301 % 20 < 10) {
               if(client.field457 == 1 && client.field311 >= 0 && client.field311 < client.field328.length) {
                  class34 var23 = client.field328[client.field311];
                  if(null != var23) {
                     var11 = var23.field837 / 32 - class15.field225.field837 / 32;
                     var12 = var23.field880 / 32 - class15.field225.field880 / 32;
                     class44.method982(var1, var2, var11, var12, class5.field104[1], var4);
                  }
               }

               if(client.field457 == 2) {
                  var10 = client.field313 * 4 - class172.field2734 * 4 + 2 - class15.field225.field837 / 32;
                  var11 = client.field314 * 4 - class20.field576 * 4 + 2 - class15.field225.field880 / 32;
                  class44.method982(var1, var2, var10, var11, class5.field104[1], var4);
               }

               if(client.field457 == 10 && client.field360 >= 0 && client.field360 < client.field302.length) {
                  class2 var24 = client.field302[client.field360];
                  if(null != var24) {
                     var11 = var24.field837 / 32 - class15.field225.field837 / 32;
                     var12 = var24.field880 / 32 - class15.field225.field880 / 32;
                     class44.method982(var1, var2, var11, var12, class5.field104[1], var4);
                  }
               }
            }

            if(client.field482 != 0) {
               var10 = client.field482 * 4 + 2 - class15.field225.field837 / 32;
               var11 = 2 + client.field522 * 4 - class15.field225.field880 / 32;
               class160.method3199(var1, var2, var10, var11, class5.field104[0], var4);
            }

            if(!class15.field225.field46) {
               class79.method1854(var1 + var4.field2900 / 2 - 1, var2 + var4.field2901 / 2 - 1, 3, 3, 16777215);
            }
         } else {
            class79.method1867(var1, var2, 0, var4.field2898, var4.field2899);
         }

         client.field493[var3] = true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lclass105;",
      garbageValue = "369810144"
   )
   public final class105 method952(int var1) {
      class105 var2 = (class105)field1026.method3797((long)this.field1024);
      if(var2 == null) {
         class100 var3 = class100.method2280(field1021, this.field1023, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(null != this.field1032) {
            for(var4 = 0; var4 < this.field1032.length; ++var4) {
               var3.method2341(this.field1032[var4], this.field1028[var4]);
            }
         }

         if(null != this.field1022) {
            for(var4 = 0; var4 < this.field1022.length; ++var4) {
               var3.method2300(this.field1022[var4], this.field1030[var4]);
            }
         }

         var2 = var3.method2290(this.field1034 + 64, 850 + this.field1035, -30, -50, -30);
         field1026.method3788(var2, (long)this.field1024);
      }

      class105 var5;
      if(this.field1020 != -1 && var1 != -1) {
         var5 = class34.method768(this.field1020).method927(var2, var1);
      } else {
         var5 = var2.method2355(true);
      }

      if(this.field1029 != 128 || this.field1027 != 128) {
         var5.method2353(this.field1029, this.field1027, this.field1029);
      }

      if(this.field1033 != 0) {
         if(this.field1033 == 90) {
            var5.method2383();
         }

         if(this.field1033 == 180) {
            var5.method2383();
            var5.method2383();
         }

         if(this.field1033 == 270) {
            var5.method2383();
            var5.method2383();
            var5.method2383();
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "14"
   )
   void method953(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1023 = var1.method2556();
      } else if(var2 == 2) {
         this.field1020 = var1.method2556();
      } else if(var2 == 4) {
         this.field1029 = var1.method2556();
      } else if(var2 == 5) {
         this.field1027 = var1.method2556();
      } else if(var2 == 6) {
         this.field1033 = var1.method2556();
      } else if(var2 == 7) {
         this.field1034 = var1.method2554();
      } else if(var2 == 8) {
         this.field1035 = var1.method2554();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2554();
            this.field1032 = new short[var3];
            this.field1028 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1032[var4] = (short)var1.method2556();
               this.field1028[var4] = (short)var1.method2556();
            }
         } else if(var2 == 41) {
            var3 = var1.method2554();
            this.field1022 = new short[var3];
            this.field1030 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1022[var4] = (short)var1.method2556();
               this.field1030[var4] = (short)var1.method2556();
            }
         }
      }

   }
}
