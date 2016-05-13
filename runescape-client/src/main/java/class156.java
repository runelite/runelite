import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class156 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "636470818"
   )
   static char method3145(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1151420888"
   )
   static String method3146(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "([Lclass173;IIIIIIIB)V",
      garbageValue = "30"
   )
   static final void method3147(class173[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         class173 var9 = var0[var8];
         if(null != var9 && (!var9.field2764 || 0 == var9.field2767 || var9.field2845 || class48.method962(var9) != 0 || client.field288 == var9 || 1338 == var9.field2887) && var9.field2784 == var1 && (!var9.field2764 || !class85.method1892(var9))) {
            int var10 = var6 + var9.field2768;
            int var11 = var9.field2779 + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            if(var9.field2767 == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(9 == var9.field2767) {
               var16 = var10;
               var17 = var11;
               var19 = var9.field2886 + var10;
               var18 = var11 + var9.field2781;
               if(var19 < var10) {
                  var16 = var19;
                  var19 = var10;
               }

               if(var18 < var11) {
                  var17 = var18;
                  var18 = var11;
               }

               ++var19;
               ++var18;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var19 < var4?var19:var4;
               var15 = var18 < var5?var18:var5;
            } else {
               var16 = var9.field2886 + var10;
               var17 = var9.field2781 + var11;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == client.field450) {
               client.field458 = true;
               client.field559 = var10;
               client.field460 = var11;
            }

            if(!var9.field2764 || var12 < var14 && var13 < var15) {
               var16 = class140.field2162;
               var17 = class140.field2163;
               if(class140.field2159 != 0) {
                  var16 = class140.field2169;
                  var17 = class140.field2170;
               }

               if(1337 == var9.field2887) {
                  if(!client.field287 && !client.field418 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class12.method160(var16, var17, var12, var13);
                  }
               } else {
                  int var20;
                  int var21;
                  if(1338 == var9.field2887) {
                     if((0 == client.field293 || client.field293 == 3) && (class140.field2159 == 1 || !class89.field1563 && 4 == class140.field2159)) {
                        class175 var30 = var9.method3404(true);
                        if(var30 != null) {
                           var18 = class140.field2169 - var10;
                           int var34 = class140.field2170 - var11;
                           if(var30.method3427(var18, var34)) {
                              var18 -= var30.field2914 / 2;
                              var34 -= var30.field2909 / 2;
                              var21 = client.field364 + client.field410 & 2047;
                              var19 = class91.field1596[var21];
                              var20 = class91.field1597[var21];
                              var19 = var19 * (256 + client.field353) >> 8;
                              var20 = var20 * (256 + client.field353) >> 8;
                              int var32 = var18 * var20 + var34 * var19 >> 11;
                              int var35 = var34 * var20 - var19 * var18 >> 11;
                              int var37 = class106.field1881.field823 + var32 >> 7;
                              int var36 = class106.field1881.field813 - var35 >> 7;
                              client.field322.method2737(156);
                              client.field322.method2477(18);
                              client.field322.method2681(class137.field2120[82]?(class137.field2120[81]?2:1):0);
                              client.field322.method2624(class22.field594 + var37);
                              client.field322.method2557(var36 + class114.field1981);
                              client.field322.method2477(var18);
                              client.field322.method2477(var34);
                              client.field322.method2661(client.field364);
                              client.field322.method2477(57);
                              client.field322.method2477(client.field410);
                              client.field322.method2477(client.field353);
                              client.field322.method2477(89);
                              client.field322.method2661(class106.field1881.field823);
                              client.field322.method2661(class106.field1881.field813);
                              client.field322.method2477(63);
                              client.field512 = var37;
                              client.field513 = var36;
                           }
                        }
                     }
                  } else {
                     if(!client.field418 && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                        class167.method3266(var9, var16 - var10, var17 - var11);
                     }

                     if(var9.field2767 == 0) {
                        if(!var9.field2764 && class85.method1892(var9) && class4.field78 != var9) {
                           continue;
                        }

                        method3147(var0, var9.field2826, var12, var13, var14, var15, var10 - var9.field2786, var11 - var9.field2787);
                        if(var9.field2847 != null) {
                           method3147(var9.field2847, var9.field2826, var12, var13, var14, var15, var10 - var9.field2786, var11 - var9.field2787);
                        }

                        class3 var22 = (class3)client.field308.method3777((long)var9.field2826);
                        if(null != var22) {
                           if(var22.field62 == 0 && class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15 && !client.field418 && !client.field535) {
                              for(class0 var23 = (class0)client.field283.method3812(); null != var23; var23 = (class0)client.field283.method3817()) {
                                 if(var23.field1) {
                                    var23.method3898();
                                    var23.field8.field2888 = false;
                                 }
                              }

                              if(0 == class56.field1188) {
                                 client.field450 = null;
                                 client.field288 = null;
                              }

                              if(!client.field418) {
                                 client.field424[0] = "Cancel";
                                 client.field425[0] = "";
                                 client.field422[0] = 1006;
                                 client.field496 = 1;
                              }
                           }

                           class123.method2770(var22.field69, var12, var13, var14, var15, var10, var11);
                        }
                     }

                     if(var9.field2764) {
                        class0 var29;
                        if(!var9.field2898) {
                           if(var9.field2877 && class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15) {
                              for(var29 = (class0)client.field283.method3812(); null != var29; var29 = (class0)client.field283.method3817()) {
                                 if(var29.field1 && var29.field12 == var29.field8.field2843) {
                                    var29.method3898();
                                 }
                              }
                           }
                        } else if(class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15) {
                           for(var29 = (class0)client.field283.method3812(); var29 != null; var29 = (class0)client.field283.method3817()) {
                              if(var29.field1) {
                                 var29.method3898();
                                 var29.field8.field2888 = false;
                              }
                           }

                           if(0 == class56.field1188) {
                              client.field450 = null;
                              client.field288 = null;
                           }

                           if(!client.field418) {
                              client.field424[0] = "Cancel";
                              client.field425[0] = "";
                              client.field422[0] = 1006;
                              client.field496 = 1;
                           }
                        }

                        boolean var31;
                        if(class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15) {
                           var31 = true;
                        } else {
                           var31 = false;
                        }

                        boolean var24 = false;
                        if((class140.field2161 == 1 || !class89.field1563 && 4 == class140.field2161) && var31) {
                           var24 = true;
                        }

                        boolean var25 = false;
                        if((1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) && class140.field2169 >= var12 && class140.field2170 >= var13 && class140.field2169 < var14 && class140.field2170 < var15) {
                           var25 = true;
                        }

                        if(var25) {
                           class129.method2810(var9, class140.field2169 - var10, class140.field2170 - var11);
                        }

                        if(null != client.field450 && client.field450 != var9 && var31) {
                           var19 = class48.method962(var9);
                           boolean var26 = 0 != (var19 >> 20 & 1);
                           if(var26) {
                              client.field454 = var9;
                           }
                        }

                        if(var9 == client.field288) {
                           client.field455 = true;
                           client.field456 = var10;
                           client.field457 = var11;
                        }

                        if(var9.field2845) {
                           class0 var33;
                           if(var31 && client.field475 != 0 && null != var9.field2843) {
                              var33 = new class0();
                              var33.field1 = true;
                              var33.field8 = var9;
                              var33.field4 = client.field475;
                              var33.field12 = var9.field2843;
                              client.field283.method3807(var33);
                           }

                           if(client.field450 != null || null != class25.field626 || client.field418) {
                              var25 = false;
                              var24 = false;
                              var31 = false;
                           }

                           if(!var9.field2891 && var25) {
                              var9.field2891 = true;
                              if(var9.field2872 != null) {
                                 var33 = new class0();
                                 var33.field1 = true;
                                 var33.field8 = var9;
                                 var33.field14 = class140.field2169 - var10;
                                 var33.field4 = class140.field2170 - var11;
                                 var33.field12 = var9.field2872;
                                 client.field283.method3807(var33);
                              }
                           }

                           if(var9.field2891 && var24 && null != var9.field2880) {
                              var33 = new class0();
                              var33.field1 = true;
                              var33.field8 = var9;
                              var33.field14 = class140.field2162 - var10;
                              var33.field4 = class140.field2163 - var11;
                              var33.field12 = var9.field2880;
                              client.field283.method3807(var33);
                           }

                           if(var9.field2891 && !var24) {
                              var9.field2891 = false;
                              if(var9.field2849 != null) {
                                 var33 = new class0();
                                 var33.field1 = true;
                                 var33.field8 = var9;
                                 var33.field14 = class140.field2162 - var10;
                                 var33.field4 = class140.field2163 - var11;
                                 var33.field12 = var9.field2849;
                                 client.field478.method3807(var33);
                              }
                           }

                           if(var24 && var9.field2850 != null) {
                              var33 = new class0();
                              var33.field1 = true;
                              var33.field8 = var9;
                              var33.field14 = class140.field2162 - var10;
                              var33.field4 = class140.field2163 - var11;
                              var33.field12 = var9.field2850;
                              client.field283.method3807(var33);
                           }

                           if(!var9.field2888 && var31) {
                              var9.field2888 = true;
                              if(var9.field2851 != null) {
                                 var33 = new class0();
                                 var33.field1 = true;
                                 var33.field8 = var9;
                                 var33.field14 = class140.field2162 - var10;
                                 var33.field4 = class140.field2163 - var11;
                                 var33.field12 = var9.field2851;
                                 client.field283.method3807(var33);
                              }
                           }

                           if(var9.field2888 && var31 && var9.field2852 != null) {
                              var33 = new class0();
                              var33.field1 = true;
                              var33.field8 = var9;
                              var33.field14 = class140.field2162 - var10;
                              var33.field4 = class140.field2163 - var11;
                              var33.field12 = var9.field2852;
                              client.field283.method3807(var33);
                           }

                           if(var9.field2888 && !var31) {
                              var9.field2888 = false;
                              if(null != var9.field2853) {
                                 var33 = new class0();
                                 var33.field1 = true;
                                 var33.field8 = var9;
                                 var33.field14 = class140.field2162 - var10;
                                 var33.field4 = class140.field2163 - var11;
                                 var33.field12 = var9.field2853;
                                 client.field478.method3807(var33);
                              }
                           }

                           if(var9.field2793 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2793;
                              client.field328.method3807(var33);
                           }

                           class0 var27;
                           if(null != var9.field2808 && client.field464 > var9.field2893) {
                              if(null != var9.field2771 && client.field464 - var9.field2893 <= 32) {
                                 label517:
                                 for(var21 = var9.field2893; var21 < client.field464; ++var21) {
                                    var19 = client.field463[var21 & 31];

                                    for(var20 = 0; var20 < var9.field2771.length; ++var20) {
                                       if(var19 == var9.field2771[var20]) {
                                          var27 = new class0();
                                          var27.field8 = var9;
                                          var27.field12 = var9.field2808;
                                          client.field283.method3807(var27);
                                          break label517;
                                       }
                                    }
                                 }
                              } else {
                                 var33 = new class0();
                                 var33.field8 = var9;
                                 var33.field12 = var9.field2808;
                                 client.field283.method3807(var33);
                              }

                              var9.field2893 = client.field464;
                           }

                           if(null != var9.field2860 && client.field446 > var9.field2894) {
                              if(var9.field2758 != null && client.field446 - var9.field2894 <= 32) {
                                 label493:
                                 for(var21 = var9.field2894; var21 < client.field446; ++var21) {
                                    var19 = client.field465[var21 & 31];

                                    for(var20 = 0; var20 < var9.field2758.length; ++var20) {
                                       if(var19 == var9.field2758[var20]) {
                                          var27 = new class0();
                                          var27.field8 = var9;
                                          var27.field12 = var9.field2860;
                                          client.field283.method3807(var27);
                                          break label493;
                                       }
                                    }
                                 }
                              } else {
                                 var33 = new class0();
                                 var33.field8 = var9;
                                 var33.field12 = var9.field2860;
                                 client.field283.method3807(var33);
                              }

                              var9.field2894 = client.field446;
                           }

                           if(null != var9.field2862 && client.field468 > var9.field2895) {
                              if(null != var9.field2863 && client.field468 - var9.field2895 <= 32) {
                                 label469:
                                 for(var21 = var9.field2895; var21 < client.field468; ++var21) {
                                    var19 = client.field467[var21 & 31];

                                    for(var20 = 0; var20 < var9.field2863.length; ++var20) {
                                       if(var19 == var9.field2863[var20]) {
                                          var27 = new class0();
                                          var27.field8 = var9;
                                          var27.field12 = var9.field2862;
                                          client.field283.method3807(var27);
                                          break label469;
                                       }
                                    }
                                 }
                              } else {
                                 var33 = new class0();
                                 var33.field8 = var9;
                                 var33.field12 = var9.field2862;
                                 client.field283.method3807(var33);
                              }

                              var9.field2895 = client.field468;
                           }

                           if(client.field469 > var9.field2806 && var9.field2867 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2867;
                              client.field283.method3807(var33);
                           }

                           if(client.field470 > var9.field2806 && var9.field2869 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2869;
                              client.field283.method3807(var33);
                           }

                           if(client.field451 > var9.field2806 && var9.field2870 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2870;
                              client.field283.method3807(var33);
                           }

                           if(client.field438 > var9.field2806 && var9.field2875 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2875;
                              client.field283.method3807(var33);
                           }

                           if(client.field563 > var9.field2806 && null != var9.field2792) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2792;
                              client.field283.method3807(var33);
                           }

                           if(client.field474 > var9.field2806 && var9.field2782 != null) {
                              var33 = new class0();
                              var33.field8 = var9;
                              var33.field12 = var9.field2782;
                              client.field283.method3807(var33);
                           }

                           var9.field2806 = client.field462;
                           if(null != var9.field2868) {
                              for(var21 = 0; var21 < client.field500; ++var21) {
                                 class0 var28 = new class0();
                                 var28.field8 = var9;
                                 var28.field7 = client.field408[var21];
                                 var28.field3 = client.field501[var21];
                                 var28.field12 = var9.field2868;
                                 client.field283.method3807(var28);
                              }
                           }
                        }
                     }

                     if(!var9.field2764 && client.field450 == null && null == class25.field626 && !client.field418) {
                        if((var9.field2761 >= 0 || 0 != var9.field2827) && class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15) {
                           if(var9.field2761 >= 0) {
                              class4.field78 = var0[var9.field2761];
                           } else {
                              class4.field78 = var9;
                           }
                        }

                        if(8 == var9.field2767 && class140.field2162 >= var12 && class140.field2163 >= var13 && class140.field2162 < var14 && class140.field2163 < var15) {
                           class26.field664 = var9;
                        }

                        if(var9.field2858 > var9.field2781) {
                           class106.method2367(var9, var9.field2886 + var10, var11, var9.field2781, var9.field2858, class140.field2162, class140.field2163);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1077801450"
   )
   static final void method3148(int var0) {
      if(class188.method3731(var0)) {
         class173[] var1 = class217.field3171[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            class173 var3 = var1[var2];
            if(var3 != null) {
               var3.field2834 = 0;
               var3.field2754 = 0;
            }
         }
      }

   }
}
