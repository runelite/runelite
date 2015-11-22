package net.runelite.rs.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("y")
public class class18 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2001994109
   )
   int field245;
   @ObfuscatedName("m")
   class145 field246;
   @ObfuscatedName("f")
   DataInputStream field247;
   @ObfuscatedName("l")
   byte[] field248 = new byte[4];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 744153633
   )
   int field249;
   @ObfuscatedName("a")
   byte[] field250;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 1984434181618787155L
   )
   long field251;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 772449011
   )
   protected static int field252;
   @ObfuscatedName("he")
   @ObfuscatedGetter(
      intValue = 257549687
   )
   static int field253;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1568980231
   )
   static int field254;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 378806119
   )
   int field256;

   @ObfuscatedName("j")
   byte[] method218() throws IOException {
      if(class92.method2177() > this.field251) {
         throw new IOException();
      } else {
         if(0 == this.field245) {
            if(this.field246.field2198 == 2) {
               throw new IOException();
            }

            if(1 == this.field246.field2198) {
               this.field247 = (DataInputStream)this.field246.field2204;
               this.field245 = 1;
            }
         }

         int var1;
         if(1 == this.field245) {
            var1 = this.field247.available();
            if(var1 > 0) {
               if(var1 + this.field249 > 4) {
                  var1 = 4 - this.field249;
               }

               this.field249 += this.field247.read(this.field248, this.field249, var1);
               if(this.field249 == 4) {
                  int var2 = (new class118(this.field248)).method2541();
                  this.field250 = new byte[var2];
                  this.field245 = 2;
               }
            }
         }

         if(2 == this.field245) {
            var1 = this.field247.available();
            if(var1 > 0) {
               if(var1 + this.field256 > this.field250.length) {
                  var1 = this.field250.length - this.field256;
               }

               this.field256 += this.field247.read(this.field250, this.field256, var1);
               if(this.field250.length == this.field256) {
                  return this.field250;
               }
            }
         }

         return null;
      }
   }

   class18(class135 var1, URL var2) {
      this.field246 = var1.method2917(var2);
      this.field245 = 0;
      this.field251 = class92.method2177() + 30000L;
   }

   @ObfuscatedName("cj")
   static final void method221(class172[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class172 var9 = var0[var8];
         if(var9 != null && (!var9.field2733 || 0 == var9.field2736 || var9.field2812 || class7.method126(var9) != 0 || var9 == client.field448 || var9.field2738 == 1338) && var9.field2742 == var1 && (!var9.field2733 || !class153.method3195(var9))) {
            int var10 = var9.field2846 + var6;
            int var11 = var7 + var9.field2748;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2736 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(9 == var9.field2736) {
               var16 = var10;
               var17 = var11;
               var18 = var9.field2749 + var10;
               var19 = var9.field2750 + var11;
               if(var18 < var10) {
                  var16 = var18;
                  var18 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var18;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var18 < var4?var18:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.field2749 + var10;
               var17 = var11 + var9.field2750;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(client.field447 == var9) {
               client.field455 = true;
               client.field456 = var10;
               client.field457 = var11;
            }

            if(!var9.field2733 || var12 < var14 && var13 < var15) {
               var16 = class139.field2134;
               var17 = class139.field2135;
               if(0 != class139.field2140) {
                  var16 = class139.field2130;
                  var17 = class139.field2142;
               }

               if(var9.field2738 == 1337) {
                  if(!client.field532 && !client.field500 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class38.method804(var16, var17, var12, var13);
                  }
               } else {
                  int var22;
                  int var23;
                  int var25;
                  int var33;
                  int var36;
                  int var37;
                  if(1338 == var9.field2738) {
                     if((0 == client.field510 || 3 == client.field510) && (1 == class139.field2140 || !class33.field752 && 4 == class139.field2140)) {
                        class174 var35 = var9.method3464(true);
                        if(null != var35) {
                           var19 = class139.field2130 - var10;
                           var33 = class139.field2142 - var11;
                           if(var35.method3510(var19, var33)) {
                              var19 -= var35.field2882 / 2;
                              var33 -= var35.field2877 / 2;
                              var36 = client.field346 + client.field434 & 2047;
                              var22 = class90.field1571[var36];
                              var23 = class90.field1573[var36];
                              var22 = (client.field348 + 256) * var22 >> 8;
                              var23 = var23 * (256 + client.field348) >> 8;
                              var37 = var33 * var22 + var19 * var23 >> 11;
                              var25 = var33 * var23 - var19 * var22 >> 11;
                              int var26 = var37 + class0.field12.field846 >> 7;
                              int var27 = class0.field12.field834 - var25 >> 7;
                              client.field318.method2785(171);
                              client.field318.method2521(18);
                              client.field318.method2522(class161.field2629 + var27);
                              client.field318.method2632(class136.field2114[82]?(class136.field2114[81]?2:1):0);
                              client.field318.method2730(class47.field1053 + var26);
                              client.field318.method2521(var19);
                              client.field318.method2521(var33);
                              client.field318.method2522(client.field434);
                              client.field318.method2521(57);
                              client.field318.method2521(client.field346);
                              client.field318.method2521(client.field348);
                              client.field318.method2521(89);
                              client.field318.method2522(class0.field12.field846);
                              client.field318.method2522(class0.field12.field834);
                              client.field318.method2521(63);
                              client.field537 = var26;
                              client.field294 = var27;
                           }
                        }
                     }
                  } else {
                     if(!client.field500 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        class40.method863(var9, var16 - var10, var17 - var11);
                     }

                     if(var9.field2736 == 0) {
                        if(!var9.field2733 && class153.method3195(var9) && class3.field65 != var9) {
                           continue;
                        }

                        method221(var0, var9.field2734 * -1, var12, var13, var14, var15, var10 - var9.field2755, var11 - var9.field2762);
                        if(null != var9.field2806) {
                           method221(var9.field2806, var9.field2734 * -1, var12, var13, var14, var15, var10 - var9.field2755, var11 - var9.field2762);
                        }

                        class3 var28 = (class3)client.field304.method3836((long)(var9.field2734 * -1));
                        if(null != var28) {
                           if(0 == var28.field61 && class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15 && !client.field500 && !client.field442) {
                              for(class0 var30 = (class0)client.field473.method3871(); null != var30; var30 = (class0)client.field473.method3873()) {
                                 if(var30.field1) {
                                    var30.method3965();
                                    var30.field2.field2859 = false;
                                 }
                              }

                              if(class25.field625 == 0) {
                                 client.field447 = null;
                                 client.field448 = null;
                              }

                              if(!client.field500) {
                                 client.field297[0] = "Cancel";
                                 client.field422[0] = "";
                                 client.field419[0] = 1006;
                                 client.field416 = 1;
                              }
                           }

                           class190.method3798(var28.field63, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.field2733) {
                        class0 var29;
                        if(!var9.field2865) {
                           if(var9.field2747 && class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15) {
                              for(var29 = (class0)client.field473.method3871(); var29 != null; var29 = (class0)client.field473.method3873()) {
                                 if(var29.field1 && var29.field2.field2807 == var29.field10) {
                                    var29.method3965();
                                 }
                              }
                           }
                        } else if(class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15) {
                           for(var29 = (class0)client.field473.method3871(); null != var29; var29 = (class0)client.field473.method3873()) {
                              if(var29.field1) {
                                 var29.method3965();
                                 var29.field2.field2859 = false;
                              }
                           }

                           if(class25.field625 == 0) {
                              client.field447 = null;
                              client.field448 = null;
                           }

                           if(!client.field500) {
                              client.field297[0] = "Cancel";
                              client.field422[0] = "";
                              client.field419[0] = 1006;
                              client.field416 = 1;
                           }
                        }

                        boolean var31;
                        if(class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15) {
                           var31 = true;
                        } else {
                           var31 = false;
                        }

                        boolean var32 = false;
                        if((1 == class139.field2133 || !class33.field752 && 4 == class139.field2133) && var31) {
                           var32 = true;
                        }

                        boolean var20 = false;
                        if((1 == class139.field2140 || !class33.field752 && 4 == class139.field2140) && class139.field2130 >= var12 && class139.field2142 >= var13 && class139.field2130 < var14 && class139.field2142 < var15) {
                           var20 = true;
                        }

                        if(var20) {
                           class23.method625(var9, class139.field2130 - var10, class139.field2142 - var11);
                        }

                        if(null != client.field447 && client.field447 != var9 && var31 && class30.method713(class7.method126(var9))) {
                           client.field451 = var9;
                        }

                        if(var9 == client.field448) {
                           client.field452 = true;
                           client.field453 = var10;
                           client.field454 = var11;
                        }

                        if(var9.field2812) {
                           class0 var21;
                           if(var31 && client.field472 != 0 && var9.field2807 != null) {
                              var21 = new class0();
                              var21.field1 = true;
                              var21.field2 = var9;
                              var21.field4 = client.field472;
                              var21.field10 = var9.field2807;
                              client.field473.method3868(var21);
                           }

                           if(null != client.field447 || null != class1.field26 || client.field500) {
                              var20 = false;
                              var32 = false;
                              var31 = false;
                           }

                           if(!var9.field2830 && var20) {
                              var9.field2830 = true;
                              if(var9.field2814 != null) {
                                 var21 = new class0();
                                 var21.field1 = true;
                                 var21.field2 = var9;
                                 var21.field3 = class139.field2130 - var10;
                                 var21.field4 = class139.field2142 - var11;
                                 var21.field10 = var9.field2814;
                                 client.field473.method3868(var21);
                              }
                           }

                           if(var9.field2830 && var32 && var9.field2815 != null) {
                              var21 = new class0();
                              var21.field1 = true;
                              var21.field2 = var9;
                              var21.field3 = class139.field2134 - var10;
                              var21.field4 = class139.field2135 - var11;
                              var21.field10 = var9.field2815;
                              client.field473.method3868(var21);
                           }

                           if(var9.field2830 && !var32) {
                              var9.field2830 = false;
                              if(var9.field2855 != null) {
                                 var21 = new class0();
                                 var21.field1 = true;
                                 var21.field2 = var9;
                                 var21.field3 = class139.field2134 - var10;
                                 var21.field4 = class139.field2135 - var11;
                                 var21.field10 = var9.field2855;
                                 client.field475.method3868(var21);
                              }
                           }

                           if(var32 && null != var9.field2817) {
                              var21 = new class0();
                              var21.field1 = true;
                              var21.field2 = var9;
                              var21.field3 = class139.field2134 - var10;
                              var21.field4 = class139.field2135 - var11;
                              var21.field10 = var9.field2817;
                              client.field473.method3868(var21);
                           }

                           if(!var9.field2859 && var31) {
                              var9.field2859 = true;
                              if(var9.field2759 != null) {
                                 var21 = new class0();
                                 var21.field1 = true;
                                 var21.field2 = var9;
                                 var21.field3 = class139.field2134 - var10;
                                 var21.field4 = class139.field2135 - var11;
                                 var21.field10 = var9.field2759;
                                 client.field473.method3868(var21);
                              }
                           }

                           if(var9.field2859 && var31 && null != var9.field2798) {
                              var21 = new class0();
                              var21.field1 = true;
                              var21.field2 = var9;
                              var21.field3 = class139.field2134 - var10;
                              var21.field4 = class139.field2135 - var11;
                              var21.field10 = var9.field2798;
                              client.field473.method3868(var21);
                           }

                           if(var9.field2859 && !var31) {
                              var9.field2859 = false;
                              if(var9.field2820 != null) {
                                 var21 = new class0();
                                 var21.field1 = true;
                                 var21.field2 = var9;
                                 var21.field3 = class139.field2134 - var10;
                                 var21.field4 = class139.field2135 - var11;
                                 var21.field10 = var9.field2820;
                                 client.field475.method3868(var21);
                              }
                           }

                           if(null != var9.field2831) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2831;
                              client.field357.method3868(var21);
                           }

                           class0 var24;
                           if(var9.field2825 != null && client.field461 > var9.field2764) {
                              if(var9.field2826 != null && client.field461 - var9.field2764 <= 32) {
                                 label908:
                                 for(var36 = var9.field2764; var36 < client.field461; ++var36) {
                                    var22 = client.field460[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2826.length; ++var23) {
                                       if(var22 == var9.field2826[var23]) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field10 = var9.field2825;
                                          client.field473.method3868(var24);
                                          break label908;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class0();
                                 var21.field2 = var9;
                                 var21.field10 = var9.field2825;
                                 client.field473.method3868(var21);
                              }

                              var9.field2764 = client.field461;
                           }

                           if(var9.field2827 != null && client.field530 > var9.field2861) {
                              if(var9.field2757 != null && client.field530 - var9.field2861 <= 32) {
                                 label884:
                                 for(var36 = var9.field2861; var36 < client.field530; ++var36) {
                                    var22 = client.field508[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2757.length; ++var23) {
                                       if(var9.field2757[var23] == var22) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field10 = var9.field2827;
                                          client.field473.method3868(var24);
                                          break label884;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class0();
                                 var21.field2 = var9;
                                 var21.field10 = var9.field2827;
                                 client.field473.method3868(var21);
                              }

                              var9.field2861 = client.field530;
                           }

                           if(var9.field2829 != null && client.field465 > var9.field2862) {
                              if(var9.field2794 != null && client.field465 - var9.field2862 <= 32) {
                                 label860:
                                 for(var36 = var9.field2862; var36 < client.field465; ++var36) {
                                    var22 = client.field464[var36 & 31];

                                    for(var23 = 0; var23 < var9.field2794.length; ++var23) {
                                       if(var22 == var9.field2794[var23]) {
                                          var24 = new class0();
                                          var24.field2 = var9;
                                          var24.field10 = var9.field2829;
                                          client.field473.method3868(var24);
                                          break label860;
                                       }
                                    }
                                 }
                              } else {
                                 var21 = new class0();
                                 var21.field2 = var9;
                                 var21.field10 = var9.field2829;
                                 client.field473.method3868(var21);
                              }

                              var9.field2862 = client.field465;
                           }

                           if(client.field466 > var9.field2818 * -1 && var9.field2834 != null) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2834;
                              client.field473.method3868(var21);
                           }

                           if(client.field458 > var9.field2818 * -1 && null != var9.field2836) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2836;
                              client.field473.method3868(var21);
                           }

                           if(client.field468 > var9.field2818 * -1 && null != var9.field2754) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2754;
                              client.field473.method3868(var21);
                           }

                           if(client.field469 > var9.field2818 * -1 && null != var9.field2842) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2842;
                              client.field473.method3868(var21);
                           }

                           if(client.field470 > var9.field2818 * -1 && var9.field2843 != null) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2843;
                              client.field473.method3868(var21);
                           }

                           if(client.field471 > var9.field2818 * -1 && var9.field2838 != null) {
                              var21 = new class0();
                              var21.field2 = var9;
                              var21.field10 = var9.field2838;
                              client.field473.method3868(var21);
                           }

                           var9.field2818 = client.field459 * -1;
                           if(null != var9.field2732) {
                              for(var36 = 0; var36 < client.field497; ++var36) {
                                 class0 var34 = new class0();
                                 var34.field2 = var9;
                                 var34.field7 = client.field495[var36];
                                 var34.field8 = client.field498[var36];
                                 var34.field10 = var9.field2732;
                                 client.field473.method3868(var34);
                              }
                           }
                        }
                     }

                     if(!var9.field2733 && null == client.field447 && null == class1.field26 && !client.field500) {
                        if((var9.field2847 >= 0 || var9.field2813 != 0) && class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15) {
                           if(var9.field2847 >= 0) {
                              class3.field65 = var0[var9.field2847];
                           } else {
                              class3.field65 = var9;
                           }
                        }

                        if(var9.field2736 == 8 && class139.field2134 >= var12 && class139.field2135 >= var13 && class139.field2134 < var14 && class139.field2135 < var15) {
                           class8.field140 = var9;
                        }

                        if(var9.field2765 > var9.field2750) {
                           var18 = var10 + var9.field2749;
                           var19 = var9.field2750;
                           var33 = var9.field2765;
                           var36 = class139.field2134;
                           var22 = class139.field2135;
                           if(client.field358) {
                              client.field359 = 32;
                           } else {
                              client.field359 = 0;
                           }

                           client.field358 = false;
                           if(1 == class139.field2133 || !class33.field752 && 4 == class139.field2133) {
                              if(var36 >= var18 && var36 < 16 + var18 && var22 >= var11 && var22 < 16 + var11) {
                                 var9.field2762 -= 4;
                                 class42.method942(var9);
                              } else if(var36 >= var18 && var36 < 16 + var18 && var22 >= var11 + var19 - 16 && var22 < var11 + var19) {
                                 var9.field2762 += 4;
                                 class42.method942(var9);
                              } else if(var36 >= var18 - client.field359 && var36 < client.field359 + 16 + var18 && var22 >= var11 + 16 && var22 < var11 + var19 - 16) {
                                 var23 = var19 * (var19 - 32) / var33;
                                 if(var23 < 8) {
                                    var23 = 8;
                                 }

                                 var37 = var22 - var11 - 16 - var23 / 2;
                                 var25 = var19 - 32 - var23;
                                 var9.field2762 = var37 * (var33 - var19) / var25;
                                 class42.method942(var9);
                                 client.field358 = true;
                              }
                           }

                           if(0 != client.field472) {
                              var23 = var9.field2749;
                              if(var36 >= var18 - var23 && var22 >= var11 && var36 < var18 + 16 && var22 <= var19 + var11) {
                                 var9.field2762 += client.field472 * 45;
                                 class42.method942(var9);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   public static boolean method222(CharSequence var0) {
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

         label89: {
            char var7 = var0.charAt(var6);
            if(var6 == 0) {
               if(45 == var7) {
                  var2 = true;
                  break label89;
               }

               if(var7 == 43) {
                  break label89;
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

            int var8 = 10 * var4 + var9;
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
}
