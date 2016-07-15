import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("Player")
public final class class2 extends class39 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1410003337
   )
   int field29;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -114754367
   )
   int field30;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1167798877
   )
   int field31 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1241717037
   )
   int field34;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 376475723
   )
   @Export("combatLevel")
   int field35;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1562071073
   )
   int field36;
   @ObfuscatedName("d")
   boolean field37;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -555329977
   )
   @Export("totalLevel")
   int field38;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -219939363
   )
   int field39;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -619196701
   )
   int field40;
   @ObfuscatedName("w")
   @Export("model")
   class108 field41;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2128882489
   )
   int field42;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1083568605
   )
   int field43;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -81890687
   )
   int field44 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 485317939
   )
   int field45;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2071061337
   )
   int field46;
   @ObfuscatedName("a")
   @Export("actions")
   String[] field47 = new String[3];
   @ObfuscatedName("y")
   boolean field48;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2083244357
   )
   @Export("team")
   int field49;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 183872827
   )
   int field50;
   @ObfuscatedName("v")
   boolean field51;
   @ObfuscatedName("e")
   @Export("name")
   String field52;
   @ObfuscatedName("l")
   @Export("composition")
   class182 field53;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -534218177
   )
   int field54;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1020058081
   )
   int field55;
   @ObfuscatedName("ey")
   static class81[] field56;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -739681195
   )
   int field57;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "-63"
   )
   static void method5(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method5(var0, var1, var2, var5 - 1);
         method5(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method7() {
      return this.field53 != null && this.field53.field2958 != -1?class59.method1282(this.field53.field2958).field924:1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      if(this.field53 == null) {
         return null;
      } else {
         class44 var1 = super.field890 != -1 && super.field904 == 0?class13.method153(super.field890):null;
         class44 var2 = super.field900 == -1 || this.field48 || super.field854 == super.field900 && var1 != null?null:class13.method153(super.field900);
         class108 var3 = this.field53.method3583(var1, super.field865, var2, super.field880);
         if(var3 == null) {
            return null;
         } else {
            var3.method2381();
            super.field855 = var3.field1529;
            class108 var4;
            class108[] var5;
            if(!this.field48 && super.field887 != -1 && super.field888 != -1) {
               var4 = class151.method3217(super.field887).method964(super.field888);
               if(var4 != null) {
                  var4.method2390(0, -super.field891, 0);
                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(!this.field48 && this.field41 != null) {
               if(client.field567 >= this.field30) {
                  this.field41 = null;
               }

               if(client.field567 >= this.field38 && client.field567 < this.field30) {
                  var4 = this.field41;
                  var4.method2390(this.field40 - super.field896, this.field43 - this.field50, this.field42 - super.field879);
                  if(super.field889 == 512) {
                     var4.method2387();
                     var4.method2387();
                     var4.method2387();
                  } else if(super.field889 == 1024) {
                     var4.method2387();
                     var4.method2387();
                  } else if(super.field889 == 1536) {
                     var4.method2387();
                  }

                  var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
                  if(super.field889 == 512) {
                     var4.method2387();
                  } else if(super.field889 == 1024) {
                     var4.method2387();
                     var4.method2387();
                  } else if(super.field889 == 1536) {
                     var4.method2387();
                     var4.method2387();
                     var4.method2387();
                  }

                  var4.method2390(super.field896 - this.field40, this.field50 - this.field43, super.field879 - this.field42);
               }
            }

            var3.field1929 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-33"
   )
   final void method9(int var1, int var2, byte var3) {
      if(super.field890 != -1 && class13.method153(super.field890).field1035 == 1) {
         super.field890 = -1;
      }

      super.field878 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.field885[0] >= 0 && super.field885[0] < 104 && super.field906[0] >= 0 && super.field906[0] < 104) {
            if(var3 == 2) {
               class2 var4 = this;
               int var5 = super.field885[0];
               int var6 = super.field906[0];
               int var7 = this.method7();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method7();
                  class110 var10 = class114.method2512(var1, var2);
                  class111 var11 = client.field407[this.field57];
                  int[] var12 = client.field576;
                  int[] var13 = client.field577;
                  int var14 = 0;

                  label790:
                  while(true) {
                     int var15;
                     if(var14 >= 128) {
                        int var16;
                        int var17;
                        byte var18;
                        byte var19;
                        int var20;
                        int var21;
                        byte var22;
                        int var23;
                        int[][] var24;
                        int var25;
                        int var26;
                        int var27;
                        int var28;
                        boolean var34;
                        boolean var35;
                        int var36;
                        int var37;
                        int var39;
                        if(var9 == 1) {
                           var16 = var5;
                           var17 = var6;
                           var18 = 64;
                           var19 = 64;
                           var20 = var5 - var18;
                           var21 = var6 - var19;
                           class109.field1942[var18][var19] = 99;
                           class109.field1943[var18][var19] = 0;
                           var22 = 0;
                           var23 = 0;
                           class109.field1944[var22] = var5;
                           var39 = var22 + 1;
                           class109.field1945[var22] = var6;
                           var24 = var11.field1969;

                           while(true) {
                              if(var23 == var39) {
                                 class30.field722 = var16;
                                 class127.field2088 = var17;
                                 var35 = false;
                                 break;
                              }

                              var16 = class109.field1944[var23];
                              var17 = class109.field1945[var23];
                              var23 = var23 + 1 & 4095;
                              var36 = var16 - var20;
                              var37 = var17 - var21;
                              var25 = var16 - var11.field1965;
                              var26 = var17 - var11.field1966;
                              if(var10.vmethod2464(1, var16, var17, var11)) {
                                 class30.field722 = var16;
                                 class127.field2088 = var17;
                                 var35 = true;
                                 break;
                              }

                              var27 = 1 + class109.field1943[var36][var37];
                              if(var36 > 0 && class109.field1942[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                                 class109.field1944[var39] = var16 - 1;
                                 class109.field1945[var39] = var17;
                                 var39 = var39 + 1 & 4095;
                                 class109.field1942[var36 - 1][var37] = 2;
                                 class109.field1943[var36 - 1][var37] = var27;
                              }

                              if(var36 < 127 && class109.field1942[var36 + 1][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
                                 class109.field1944[var39] = 1 + var16;
                                 class109.field1945[var39] = var17;
                                 var39 = 1 + var39 & 4095;
                                 class109.field1942[1 + var36][var37] = 8;
                                 class109.field1943[var36 + 1][var37] = var27;
                              }

                              if(var37 > 0 && class109.field1942[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class109.field1944[var39] = var16;
                                 class109.field1945[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class109.field1942[var36][var37 - 1] = 1;
                                 class109.field1943[var36][var37 - 1] = var27;
                              }

                              if(var37 < 127 && class109.field1942[var36][var37 + 1] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                                 class109.field1944[var39] = var16;
                                 class109.field1945[var39] = 1 + var17;
                                 var39 = var39 + 1 & 4095;
                                 class109.field1942[var36][var37 + 1] = 4;
                                 class109.field1943[var36][var37 + 1] = var27;
                              }

                              if(var36 > 0 && var37 > 0 && class109.field1942[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class109.field1944[var39] = var16 - 1;
                                 class109.field1945[var39] = var17 - 1;
                                 var39 = 1 + var39 & 4095;
                                 class109.field1942[var36 - 1][var37 - 1] = 3;
                                 class109.field1943[var36 - 1][var37 - 1] = var27;
                              }

                              if(var36 < 127 && var37 > 0 && class109.field1942[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0 && (var24[1 + var25][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class109.field1944[var39] = var16 + 1;
                                 class109.field1945[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class109.field1942[var36 + 1][var37 - 1] = 9;
                                 class109.field1943[var36 + 1][var37 - 1] = var27;
                              }

                              if(var36 > 0 && var37 < 127 && class109.field1942[var36 - 1][1 + var37] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                                 class109.field1944[var39] = var16 - 1;
                                 class109.field1945[var39] = var17 + 1;
                                 var39 = 1 + var39 & 4095;
                                 class109.field1942[var36 - 1][1 + var37] = 6;
                                 class109.field1943[var36 - 1][var37 + 1] = var27;
                              }

                              if(var36 < 127 && var37 < 127 && class109.field1942[var36 + 1][1 + var37] == 0 && (var24[1 + var25][var26 + 1] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][1 + var26] & 19136800) == 0) {
                                 class109.field1944[var39] = var16 + 1;
                                 class109.field1945[var39] = var17 + 1;
                                 var39 = 1 + var39 & 4095;
                                 class109.field1942[1 + var36][1 + var37] = 12;
                                 class109.field1943[var36 + 1][1 + var37] = var27;
                              }
                           }

                           var34 = var35;
                        } else if(var9 == 2) {
                           var34 = class30.method668(var5, var6, var10, var11);
                        } else {
                           var16 = var5;
                           var17 = var6;
                           var18 = 64;
                           var19 = 64;
                           var20 = var5 - var18;
                           var21 = var6 - var19;
                           class109.field1942[var18][var19] = 99;
                           class109.field1943[var18][var19] = 0;
                           var22 = 0;
                           var23 = 0;
                           class109.field1944[var22] = var5;
                           var39 = var22 + 1;
                           class109.field1945[var22] = var6;
                           var24 = var11.field1969;

                           label768:
                           while(true) {
                              label766:
                              while(true) {
                                 do {
                                    do {
                                       do {
                                          label743:
                                          do {
                                             if(var23 == var39) {
                                                class30.field722 = var16;
                                                class127.field2088 = var17;
                                                var35 = false;
                                                break label768;
                                             }

                                             var16 = class109.field1944[var23];
                                             var17 = class109.field1945[var23];
                                             var23 = var23 + 1 & 4095;
                                             var36 = var16 - var20;
                                             var37 = var17 - var21;
                                             var25 = var16 - var11.field1965;
                                             var26 = var17 - var11.field1966;
                                             if(var10.vmethod2464(var9, var16, var17, var11)) {
                                                class30.field722 = var16;
                                                class127.field2088 = var17;
                                                var35 = true;
                                                break label768;
                                             }

                                             var27 = class109.field1943[var36][var37] + 1;
                                             if(var36 > 0 && class109.field1942[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + var9 - 1] & 19136824) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9 - 1) {
                                                      class109.field1944[var39] = var16 - 1;
                                                      class109.field1945[var39] = var17;
                                                      var39 = var39 + 1 & 4095;
                                                      class109.field1942[var36 - 1][var37] = 2;
                                                      class109.field1943[var36 - 1][var37] = var27;
                                                      break;
                                                   }

                                                   if((var24[var25 - 1][var26 + var28] & 19136830) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var36 < 128 - var9 && class109.field1942[1 + var36][var37] == 0 && (var24[var25 + var9][var26] & 19136899) == 0 && (var24[var25 + var9][var9 + var26 - 1] & 19136992) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9 - 1) {
                                                      class109.field1944[var39] = 1 + var16;
                                                      class109.field1945[var39] = var17;
                                                      var39 = 1 + var39 & 4095;
                                                      class109.field1942[1 + var36][var37] = 8;
                                                      class109.field1943[1 + var36][var37] = var27;
                                                      break;
                                                   }

                                                   if((var24[var9 + var25][var28 + var26] & 19136995) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var37 > 0 && class109.field1942[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var9 + var25 - 1][var26 - 1] & 19136899) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9 - 1) {
                                                      class109.field1944[var39] = var16;
                                                      class109.field1945[var39] = var17 - 1;
                                                      var39 = var39 + 1 & 4095;
                                                      class109.field1942[var36][var37 - 1] = 1;
                                                      class109.field1943[var36][var37 - 1] = var27;
                                                      break;
                                                   }

                                                   if((var24[var25 + var28][var26 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var37 < 128 - var9 && class109.field1942[var36][var37 + 1] == 0 && (var24[var25][var26 + var9] & 19136824) == 0 && (var24[var9 + var25 - 1][var9 + var26] & 19136992) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9 - 1) {
                                                      class109.field1944[var39] = var16;
                                                      class109.field1945[var39] = var17 + 1;
                                                      var39 = var39 + 1 & 4095;
                                                      class109.field1942[var36][var37 + 1] = 4;
                                                      class109.field1943[var36][1 + var37] = var27;
                                                      break;
                                                   }

                                                   if((var24[var28 + var25][var9 + var26] & 19137016) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var36 > 0 && var37 > 0 && class109.field1942[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9) {
                                                      class109.field1944[var39] = var16 - 1;
                                                      class109.field1945[var39] = var17 - 1;
                                                      var39 = var39 + 1 & 4095;
                                                      class109.field1942[var36 - 1][var37 - 1] = 3;
                                                      class109.field1943[var36 - 1][var37 - 1] = var27;
                                                      break;
                                                   }

                                                   if((var24[var25 - 1][var26 - 1 + var28] & 19136830) != 0 || (var24[var28 + (var25 - 1)][var26 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var36 < 128 - var9 && var37 > 0 && class109.field1942[1 + var36][var37 - 1] == 0 && (var24[var25 + var9][var26 - 1] & 19136899) == 0) {
                                                var28 = 1;

                                                while(true) {
                                                   if(var28 >= var9) {
                                                      class109.field1944[var39] = var16 + 1;
                                                      class109.field1945[var39] = var17 - 1;
                                                      var39 = var39 + 1 & 4095;
                                                      class109.field1942[var36 + 1][var37 - 1] = 9;
                                                      class109.field1943[var36 + 1][var37 - 1] = var27;
                                                      break;
                                                   }

                                                   if((var24[var9 + var25][var26 - 1 + var28] & 19136995) != 0 || (var24[var28 + var25][var26 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var28;
                                                }
                                             }

                                             if(var36 > 0 && var37 < 128 - var9 && class109.field1942[var36 - 1][1 + var37] == 0 && (var24[var25 - 1][var26 + var9] & 19136824) == 0) {
                                                for(var28 = 1; var28 < var9; ++var28) {
                                                   if((var24[var25 - 1][var26 + var28] & 19136830) != 0 || (var24[var25 - 1 + var28][var9 + var26] & 19137016) != 0) {
                                                      continue label743;
                                                   }
                                                }

                                                class109.field1944[var39] = var16 - 1;
                                                class109.field1945[var39] = var17 + 1;
                                                var39 = var39 + 1 & 4095;
                                                class109.field1942[var36 - 1][var37 + 1] = 6;
                                                class109.field1943[var36 - 1][var37 + 1] = var27;
                                             }
                                          } while(var36 >= 128 - var9);
                                       } while(var37 >= 128 - var9);
                                    } while(class109.field1942[var36 + 1][1 + var37] != 0);
                                 } while((var24[var25 + var9][var26 + var9] & 19136992) != 0);

                                 for(var28 = 1; var28 < var9; ++var28) {
                                    if((var24[var28 + var25][var9 + var26] & 19137016) != 0 || (var24[var25 + var9][var26 + var28] & 19136995) != 0) {
                                       continue label766;
                                    }
                                 }

                                 class109.field1944[var39] = 1 + var16;
                                 class109.field1945[var39] = 1 + var17;
                                 var39 = 1 + var39 & 4095;
                                 class109.field1942[var36 + 1][var37 + 1] = 12;
                                 class109.field1943[var36 + 1][1 + var37] = var27;
                              }
                           }

                           var34 = var35;
                        }

                        int var8;
                        label831: {
                           var15 = var5 - 64;
                           var16 = var6 - 64;
                           var17 = class30.field722;
                           var36 = class127.field2088;
                           if(!var34) {
                              var37 = Integer.MAX_VALUE;
                              var20 = Integer.MAX_VALUE;
                              byte var38 = 10;
                              var39 = var10.field1952;
                              var23 = var10.field1949;
                              int var33 = var10.field1955;
                              var25 = var10.field1951;

                              for(var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                                 for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                                    var28 = var26 - var15;
                                    int var29 = var27 - var16;
                                    if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class109.field1943[var28][var29] < 100) {
                                       int var30 = 0;
                                       if(var26 < var39) {
                                          var30 = var39 - var26;
                                       } else if(var26 > var39 + var33 - 1) {
                                          var30 = var26 - (var39 + var33 - 1);
                                       }

                                       int var31 = 0;
                                       if(var27 < var23) {
                                          var31 = var23 - var27;
                                       } else if(var27 > var25 + var23 - 1) {
                                          var31 = var27 - (var23 + var25 - 1);
                                       }

                                       int var32 = var30 * var30 + var31 * var31;
                                       if(var32 < var37 || var37 == var32 && class109.field1943[var28][var29] < var20) {
                                          var37 = var32;
                                          var20 = class109.field1943[var28][var29];
                                          var17 = var26;
                                          var36 = var27;
                                       }
                                    }
                                 }
                              }

                              if(var37 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label831;
                              }
                           }

                           if(var17 == var5 && var6 == var36) {
                              var8 = 0;
                           } else {
                              var19 = 0;
                              class109.field1944[var19] = var17;
                              var37 = var19 + 1;
                              class109.field1945[var19] = var36;

                              for(var20 = var21 = class109.field1942[var17 - var15][var36 - var16]; var17 != var5 || var36 != var6; var20 = class109.field1942[var17 - var15][var36 - var16]) {
                                 if(var20 != var21) {
                                    var21 = var20;
                                    class109.field1944[var37] = var17;
                                    class109.field1945[var37++] = var36;
                                 }

                                 if((var20 & 2) != 0) {
                                    ++var17;
                                 } else if((var20 & 8) != 0) {
                                    --var17;
                                 }

                                 if((var20 & 1) != 0) {
                                    ++var36;
                                 } else if((var20 & 4) != 0) {
                                    --var36;
                                 }
                              }

                              var39 = 0;

                              while(var37-- > 0) {
                                 var12[var39] = class109.field1944[var37];
                                 var13[var39++] = class109.field1945[var37];
                                 if(var39 >= var12.length) {
                                    break;
                                 }
                              }

                              var8 = var39;
                           }
                        }

                        var14 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var15 = 0;

                        while(true) {
                           if(var15 >= var14 - 1) {
                              break label790;
                           }

                           var4.method11(client.field576[var15], client.field577[var15], (byte)2);
                           ++var15;
                        }
                     }

                     for(var15 = 0; var15 < 128; ++var15) {
                        class109.field1942[var14][var15] = 0;
                        class109.field1943[var14][var15] = 99999999;
                     }

                     ++var14;
                  }
               }
            }

            this.method11(var1, var2, var3);
         } else {
            this.method23(var1, var2);
         }
      } else {
         this.method23(var1, var2);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1852701907"
   )
   final void method11(int var1, int var2, byte var3) {
      if(super.field852 < 9) {
         ++super.field852;
      }

      for(int var4 = super.field852; var4 > 0; --var4) {
         super.field885[var4] = super.field885[var4 - 1];
         super.field906[var4] = super.field906[var4 - 1];
         super.field907[var4] = super.field907[var4 - 1];
      }

      super.field885[0] = var1;
      super.field906[0] = var2;
      super.field907[0] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1693939193"
   )
   static final int method14(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (789221 + 15731 * var2 * var2) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1207274637"
   )
   final boolean vmethod787() {
      return this.field53 != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-2049493606"
   )
   final void method22(class122 var1) {
      var1.field2061 = 0;
      int var2 = var1.method2610();
      this.field31 = var1.method2611();
      this.field44 = var1.method2611();
      int var3 = -1;
      this.field49 = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2610();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2610();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2612();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class9.method108(var4[var5] - 512).field1188;
               if(var8 != 0) {
                  this.field49 = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2610();
         if(var7 < 0 || var7 >= class40.field916[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.field854 = var1.method2612();
      if(super.field854 == '\uffff') {
         super.field854 = -1;
      }

      super.field856 = var1.method2612();
      if(super.field856 == '\uffff') {
         super.field856 = -1;
      }

      super.field857 = super.field856;
      super.field858 = var1.method2612();
      if(super.field858 == '\uffff') {
         super.field858 = -1;
      }

      super.field850 = var1.method2612();
      if(super.field850 == '\uffff') {
         super.field850 = -1;
      }

      super.field860 = var1.method2612();
      if(super.field860 == '\uffff') {
         super.field860 = -1;
      }

      super.field861 = var1.method2612();
      if(super.field861 == '\uffff') {
         super.field861 = -1;
      }

      super.field898 = var1.method2612();
      if(super.field898 == '\uffff') {
         super.field898 = -1;
      }

      this.field52 = var1.method2617();
      if(class118.field2035 == this) {
         class221.field3209 = this.field52;
      }

      this.field35 = var1.method2610();
      this.field36 = var1.method2612();
      this.field51 = var1.method2610() == 1;
      if(client.field399 == 0 && client.field439 >= 2) {
         this.field51 = false;
      }

      if(null == this.field53) {
         this.field53 = new class182();
      }

      this.field53.method3569(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1337767747"
   )
   void method23(int var1, int var2) {
      super.field852 = 0;
      super.field909 = 0;
      super.field908 = 0;
      super.field885[0] = var1;
      super.field906[0] = var2;
      int var3 = this.method7();
      super.field896 = super.field885[0] * 128 + 64 * var3;
      super.field879 = super.field906[0] * 128 + var3 * 64;
   }

   class2() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.field47[var1] = "";
      }

      this.field35 = 0;
      this.field36 = 0;
      this.field38 = 0;
      this.field30 = 0;
      this.field48 = false;
      this.field49 = 0;
      this.field51 = false;
      this.field37 = false;
   }
}
