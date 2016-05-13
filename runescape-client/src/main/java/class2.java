import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("Player")
public final class class2 extends class37 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1830421653
   )
   int field33;
   @ObfuscatedName("j")
   @Export("composition")
   class179 field34;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2106163795
   )
   int field35 = -1;
   @ObfuscatedName("n")
   boolean field36;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1094874875
   )
   int field37;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1411110867
   )
   int field38;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2008501299
   )
   @Export("combatLevel")
   int field39;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1167905329
   )
   int field40;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1504838719
   )
   int field41;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1146635411
   )
   int field42;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 842031619
   )
   int field44;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2028926377
   )
   int field45;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -459984055
   )
   int field46;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1828280989
   )
   int field47;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1036289909
   )
   int field48;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -125741001
   )
   int field49 = -1;
   @ObfuscatedName("u")
   @Export("actions")
   String[] field50 = new String[3];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2061164567
   )
   @Export("totalLevel")
   int field51;
   @ObfuscatedName("w")
   boolean field52;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2040835673
   )
   @Export("team")
   int field53;
   @ObfuscatedName("m")
   @Export("model")
   class105 field54;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2105743795
   )
   int field55;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 834985457
   )
   int field56;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1256540941
   )
   int field57;
   @ObfuscatedName("y")
   boolean field58;
   @ObfuscatedName("s")
   @Export("name")
   String field59;
   @ObfuscatedName("ek")
   static class80[] field60;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1211886249"
   )
   final void method11(class119 var1) {
      var1.field2005 = 0;
      int var2 = var1.method2492();
      this.field35 = var1.method2493();
      this.field49 = var1.method2493();
      int var3 = -1;
      this.field53 = 0;
      int[] var4 = new int[12];

      int var5;
      int var6;
      for(int var7 = 0; var7 < 12; ++var7) {
         var5 = var1.method2492();
         if(0 == var5) {
            var4[var7] = 0;
         } else {
            var6 = var1.method2492();
            var4[var7] = var6 + (var5 << 8);
            if(var7 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2584();
               break;
            }

            if(var4[var7] >= 512) {
               int var8 = class9.method128(var4[var7] - 512).field1153;
               if(var8 != 0) {
                  this.field53 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.method2492();
         if(var6 < 0 || var6 >= class166.field2673[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.field817 = var1.method2584();
      if('\uffff' == super.field817) {
         super.field817 = -1;
      }

      super.field860 = var1.method2584();
      if('\uffff' == super.field860) {
         super.field860 = -1;
      }

      super.field839 = super.field860;
      super.field820 = var1.method2584();
      if('\uffff' == super.field820) {
         super.field820 = -1;
      }

      super.field821 = var1.method2584();
      if(super.field821 == '\uffff') {
         super.field821 = -1;
      }

      super.field847 = var1.method2584();
      if('\uffff' == super.field847) {
         super.field847 = -1;
      }

      super.field855 = var1.method2584();
      if('\uffff' == super.field855) {
         super.field855 = -1;
      }

      super.field850 = var1.method2584();
      if('\uffff' == super.field850) {
         super.field850 = -1;
      }

      this.field59 = var1.method2500();
      if(this == class106.field1881) {
         class148.field2233 = this.field59;
      }

      this.field39 = var1.method2492();
      this.field40 = var1.method2584();
      this.field58 = var1.method2492() == 1;
      if(0 == client.field281 && client.field517 >= 2) {
         this.field58 = false;
      }

      if(this.field34 == null) {
         this.field34 = new class179();
      }

      this.field34.method3457(var4, var9, 1 == var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-67"
   )
   static final int method12(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass105;",
      garbageValue = "1"
   )
   protected final class105 vmethod1888() {
      if(this.field34 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field843 && super.field851 == 0?class4.method42(super.field843):null;
         class42 var2 = -1 == super.field840 || this.field52 || super.field817 == super.field840 && null != var1?null:class4.method42(super.field840);
         class105 var3 = this.field34.method3463(var1, super.field844, var2, super.field861);
         if(null == var3) {
            return null;
         } else {
            var3.method2287();
            super.field816 = var3.field1465;
            class105 var4;
            class105[] var5;
            if(!this.field52 && super.field848 != -1 && -1 != super.field849) {
               var4 = class179.method3492(super.field848).method879(super.field849);
               if(null != var4) {
                  var4.method2297(0, -super.field859, 0);
                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
               }
            }

            if(!this.field52 && this.field54 != null) {
               if(client.field335 >= this.field56) {
                  this.field54 = null;
               }

               if(client.field335 >= this.field51 && client.field335 < this.field56) {
                  var4 = this.field54;
                  var4.method2297(this.field44 - super.field823, this.field45 - this.field41, this.field46 - super.field813);
                  if(512 == super.field862) {
                     var4.method2293();
                     var4.method2293();
                     var4.method2293();
                  } else if(super.field862 == 1024) {
                     var4.method2293();
                     var4.method2293();
                  } else if(super.field862 == 1536) {
                     var4.method2293();
                  }

                  var5 = new class105[]{var3, var4};
                  var3 = new class105(var5, 2);
                  if(512 == super.field862) {
                     var4.method2293();
                  } else if(1024 == super.field862) {
                     var4.method2293();
                     var4.method2293();
                  } else if(1536 == super.field862) {
                     var4.method2293();
                     var4.method2293();
                     var4.method2293();
                  }

                  var4.method2297(super.field823 - this.field44, this.field41 - this.field45, super.field813 - this.field46);
               }
            }

            var3.field1834 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-400697277"
   )
   void method15(int var1, int var2) {
      super.field841 = 0;
      super.field870 = 0;
      super.field869 = 0;
      super.field866[0] = var1;
      super.field863[0] = var2;
      int var3 = this.method20();
      super.field823 = 64 * var3 + 128 * super.field866[0];
      super.field813 = 64 * var3 + super.field863[0] * 128;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1158760359"
   )
   final void method16(int var1, int var2, byte var3) {
      if(super.field841 < 9) {
         ++super.field841;
      }

      for(int var4 = super.field841; var4 > 0; --var4) {
         super.field866[var4] = super.field866[var4 - 1];
         super.field863[var4] = super.field863[var4 - 1];
         super.field868[var4] = super.field868[var4 - 1];
      }

      super.field866[0] = var1;
      super.field863[0] = var2;
      super.field868[0] = var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1677365606"
   )
   final boolean vmethod727() {
      return this.field34 != null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1042734693"
   )
   int method20() {
      return null != this.field34 && this.field34.field2934 != -1?class99.method2179(this.field34.field2934).field887:1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "0"
   )
   static void method27(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(class25.field631[var5] != var0) {
            var2[var4] = class25.field631[var5];
            var3[var4] = class25.field627[var5];
            ++var4;
         }
      }

      class25.field631 = var2;
      class25.field627 = var3;
      class7.method100(class25.field636, 0, class25.field636.length - 1, class25.field631, class25.field627);
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-536647198"
   )
   static final void method29(String var0, int var1) {
      client.field322.method2737(120);
      client.field322.method2477(class30.method647(var0) + 1);
      client.field322.method2516(var1);
      client.field322.method2483(var0);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "68"
   )
   final void method31(int var1, int var2, byte var3) {
      if(-1 != super.field843 && class4.method42(super.field843).field1001 == 1) {
         super.field843 = -1;
      }

      super.field824 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field866[0] >= 0 && super.field866[0] < 104 && super.field863[0] >= 0 && super.field863[0] < 104) {
            if(2 == var3) {
               class2 var4 = this;
               int var5 = super.field866[0];
               int var6 = super.field863[0];
               int var7 = this.method20();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = this.method20();
                  client.field433.field1889 = var1;
                  client.field433.field1898 = var2;
                  client.field433.field1891 = 1;
                  client.field433.field1892 = 1;
                  class10 var9 = client.field433;
                  class10 var10 = var9;
                  class108 var11 = client.field340[this.field55];
                  int[] var12 = client.field497;
                  int[] var13 = client.field560;
                  int var14 = 0;

                  label309:
                  while(true) {
                     int var15;
                     if(var14 >= 128) {
                        int var16;
                        int var17;
                        byte var18;
                        int var19;
                        int var20;
                        int var21;
                        int var22;
                        int var23;
                        int var24;
                        boolean var25;
                        int var26;
                        int var27;
                        int var28;
                        byte var30;
                        if(1 == var8) {
                           var25 = class51.method1046(var5, var6, var9, var11);
                        } else if(var8 == 2) {
                           var16 = var5;
                           var17 = var6;
                           byte var29 = 64;
                           var18 = 64;
                           var19 = var5 - var29;
                           var20 = var6 - var18;
                           class106.field1876[var29][var18] = 99;
                           class106.field1888[var29][var18] = 0;
                           var30 = 0;
                           var21 = 0;
                           class106.field1880[var30] = var5;
                           var28 = var30 + 1;
                           class106.field1886[var30] = var6;
                           int[][] var31 = var11.field1911;

                           boolean var32;
                           label295: {
                              while(var28 != var21) {
                                 var16 = class106.field1880[var21];
                                 var17 = class106.field1886[var21];
                                 var21 = var21 + 1 & 4095;
                                 var26 = var16 - var19;
                                 var27 = var17 - var20;
                                 var22 = var16 - var11.field1907;
                                 var23 = var17 - var11.field1908;
                                 if(var10.vmethod2368(2, var16, var17, var11)) {
                                    class175.field2908 = var16;
                                    class106.field1875 = var17;
                                    var32 = true;
                                    break label295;
                                 }

                                 var24 = class106.field1888[var26][var27] + 1;
                                 if(var26 > 0 && class106.field1876[var26 - 1][var27] == 0 && 0 == (var31[var22 - 1][var23] & 19136782) && (var31[var22 - 1][1 + var23] & 19136824) == 0) {
                                    class106.field1880[var28] = var16 - 1;
                                    class106.field1886[var28] = var17;
                                    var28 = var28 + 1 & 4095;
                                    class106.field1876[var26 - 1][var27] = 2;
                                    class106.field1888[var26 - 1][var27] = var24;
                                 }

                                 if(var26 < 126 && class106.field1876[1 + var26][var27] == 0 && 0 == (var31[var22 + 2][var23] & 19136899) && 0 == (var31[var22 + 2][1 + var23] & 19136992)) {
                                    class106.field1880[var28] = 1 + var16;
                                    class106.field1886[var28] = var17;
                                    var28 = 1 + var28 & 4095;
                                    class106.field1876[1 + var26][var27] = 8;
                                    class106.field1888[1 + var26][var27] = var24;
                                 }

                                 if(var27 > 0 && class106.field1876[var26][var27 - 1] == 0 && 0 == (var31[var22][var23 - 1] & 19136782) && 0 == (var31[var22 + 1][var23 - 1] & 19136899)) {
                                    class106.field1880[var28] = var16;
                                    class106.field1886[var28] = var17 - 1;
                                    var28 = var28 + 1 & 4095;
                                    class106.field1876[var26][var27 - 1] = 1;
                                    class106.field1888[var26][var27 - 1] = var24;
                                 }

                                 if(var27 < 126 && class106.field1876[var26][1 + var27] == 0 && 0 == (var31[var22][2 + var23] & 19136824) && 0 == (var31[1 + var22][2 + var23] & 19136992)) {
                                    class106.field1880[var28] = var16;
                                    class106.field1886[var28] = 1 + var17;
                                    var28 = var28 + 1 & 4095;
                                    class106.field1876[var26][1 + var27] = 4;
                                    class106.field1888[var26][1 + var27] = var24;
                                 }

                                 if(var26 > 0 && var27 > 0 && 0 == class106.field1876[var26 - 1][var27 - 1] && (var31[var22 - 1][var23] & 19136830) == 0 && 0 == (var31[var22 - 1][var23 - 1] & 19136782) && 0 == (var31[var22][var23 - 1] & 19136911)) {
                                    class106.field1880[var28] = var16 - 1;
                                    class106.field1886[var28] = var17 - 1;
                                    var28 = var28 + 1 & 4095;
                                    class106.field1876[var26 - 1][var27 - 1] = 3;
                                    class106.field1888[var26 - 1][var27 - 1] = var24;
                                 }

                                 if(var26 < 126 && var27 > 0 && class106.field1876[1 + var26][var27 - 1] == 0 && (var31[1 + var22][var23 - 1] & 19136911) == 0 && 0 == (var31[2 + var22][var23 - 1] & 19136899) && 0 == (var31[2 + var22][var23] & 19136995)) {
                                    class106.field1880[var28] = 1 + var16;
                                    class106.field1886[var28] = var17 - 1;
                                    var28 = var28 + 1 & 4095;
                                    class106.field1876[var26 + 1][var27 - 1] = 9;
                                    class106.field1888[1 + var26][var27 - 1] = var24;
                                 }

                                 if(var26 > 0 && var27 < 126 && 0 == class106.field1876[var26 - 1][var27 + 1] && 0 == (var31[var22 - 1][1 + var23] & 19136830) && (var31[var22 - 1][2 + var23] & 19136824) == 0 && 0 == (var31[var22][var23 + 2] & 19137016)) {
                                    class106.field1880[var28] = var16 - 1;
                                    class106.field1886[var28] = 1 + var17;
                                    var28 = 1 + var28 & 4095;
                                    class106.field1876[var26 - 1][1 + var27] = 6;
                                    class106.field1888[var26 - 1][var27 + 1] = var24;
                                 }

                                 if(var26 < 126 && var27 < 126 && 0 == class106.field1876[var26 + 1][1 + var27] && (var31[var22 + 1][var23 + 2] & 19137016) == 0 && 0 == (var31[var22 + 2][2 + var23] & 19136992) && (var31[2 + var22][1 + var23] & 19136995) == 0) {
                                    class106.field1880[var28] = 1 + var16;
                                    class106.field1886[var28] = var17 + 1;
                                    var28 = 1 + var28 & 4095;
                                    class106.field1876[1 + var26][1 + var27] = 12;
                                    class106.field1888[1 + var26][var27 + 1] = var24;
                                 }
                              }

                              class175.field2908 = var16;
                              class106.field1875 = var17;
                              var32 = false;
                           }

                           var25 = var32;
                        } else {
                           var25 = class144.method3090(var5, var6, var8, var9, var11);
                        }

                        int var37;
                        label332: {
                           var15 = var5 - 64;
                           var16 = var6 - 64;
                           var17 = class175.field2908;
                           var26 = class106.field1875;
                           if(!var25) {
                              var27 = Integer.MAX_VALUE;
                              var19 = Integer.MAX_VALUE;
                              var30 = 10;
                              var28 = var10.field1889;
                              var21 = var10.field1898;
                              int var38 = var10.field1891;
                              var22 = var10.field1892;

                              for(var23 = var28 - var30; var23 <= var28 + var30; ++var23) {
                                 for(var24 = var21 - var30; var24 <= var21 + var30; ++var24) {
                                    int var39 = var23 - var15;
                                    int var33 = var24 - var16;
                                    if(var39 >= 0 && var33 >= 0 && var39 < 128 && var33 < 128 && class106.field1888[var39][var33] < 100) {
                                       int var34 = 0;
                                       if(var23 < var28) {
                                          var34 = var28 - var23;
                                       } else if(var23 > var28 + var38 - 1) {
                                          var34 = var23 - (var28 + var38 - 1);
                                       }

                                       int var35 = 0;
                                       if(var24 < var21) {
                                          var35 = var21 - var24;
                                       } else if(var24 > var22 + var21 - 1) {
                                          var35 = var24 - (var22 + var21 - 1);
                                       }

                                       int var36 = var35 * var35 + var34 * var34;
                                       if(var36 < var27 || var27 == var36 && class106.field1888[var39][var33] < var19) {
                                          var27 = var36;
                                          var19 = class106.field1888[var39][var33];
                                          var17 = var23;
                                          var26 = var24;
                                       }
                                    }
                                 }
                              }

                              if(var27 == Integer.MAX_VALUE) {
                                 var37 = -1;
                                 break label332;
                              }
                           }

                           if(var17 == var5 && var26 == var6) {
                              var37 = 0;
                           } else {
                              var18 = 0;
                              class106.field1880[var18] = var17;
                              var27 = var18 + 1;
                              class106.field1886[var18] = var26;

                              for(var19 = var20 = class106.field1876[var17 - var15][var26 - var16]; var5 != var17 || var26 != var6; var19 = class106.field1876[var17 - var15][var26 - var16]) {
                                 if(var19 != var20) {
                                    var20 = var19;
                                    class106.field1880[var27] = var17;
                                    class106.field1886[var27++] = var26;
                                 }

                                 if((var19 & 2) != 0) {
                                    ++var17;
                                 } else if((var19 & 8) != 0) {
                                    --var17;
                                 }

                                 if(0 != (var19 & 1)) {
                                    ++var26;
                                 } else if(0 != (var19 & 4)) {
                                    --var26;
                                 }
                              }

                              var28 = 0;

                              while(var27-- > 0) {
                                 var12[var28] = class106.field1880[var27];
                                 var13[var28++] = class106.field1886[var27];
                                 if(var28 >= var12.length) {
                                    break;
                                 }
                              }

                              var37 = var28;
                           }
                        }

                        var14 = var37;
                        if(var37 < 1) {
                           break;
                        }

                        var15 = 0;

                        while(true) {
                           if(var15 >= var14 - 1) {
                              break label309;
                           }

                           var4.method16(client.field497[var15], client.field560[var15], (byte)2);
                           ++var15;
                        }
                     }

                     for(var15 = 0; var15 < 128; ++var15) {
                        class106.field1876[var14][var15] = 0;
                        class106.field1888[var14][var15] = 99999999;
                     }

                     ++var14;
                  }
               }
            }

            this.method16(var1, var2, var3);
         } else {
            this.method15(var1, var2);
         }
      } else {
         this.method15(var1, var2);
      }

   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field50[var1] = "";
      }

      this.field39 = 0;
      this.field40 = 0;
      this.field51 = 0;
      this.field56 = 0;
      this.field52 = false;
      this.field53 = 0;
      this.field58 = false;
      this.field36 = false;
   }
}
