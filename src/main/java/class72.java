import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class72 implements Runnable {
   @ObfuscatedName("cd")
   static class223 field1348;
   @ObfuscatedName("r")
   volatile class56[] field1349 = new class56[2];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1848956025
   )
   static int field1350;
   @ObfuscatedName("n")
   static int[] field1351;
   @ObfuscatedName("a")
   class135 field1352;
   @ObfuscatedName("f")
   volatile boolean field1353 = false;
   @ObfuscatedName("s")
   volatile boolean field1354 = false;
   @ObfuscatedName("al")
   static class145 field1356;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = 259087198703879179L
   )
   static long field1357;

   @ObfuscatedName("f")
   static char method1610(char var0) {
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

   public void run() {
      this.field1354 = true;

      try {
         while(!this.field1353) {
            for(int var1 = 0; var1 < 2; ++var1) {
               class56 var2 = this.field1349[var1];
               if(null != var2) {
                  var2.method1194();
               }
            }

            class103.method2301(10L);
            class106.method2392(this.field1352, (Object)null);
         }
      } catch (Exception var6) {
         class28.method651((String)null, var6);
      } finally {
         this.field1354 = false;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "166405305"
   )
   static void method1613(class0 var0, int var1) {
      Object[] var2 = var0.field8;
      int var3 = ((Integer)var2[0]).intValue();
      class22 var4 = class40.method823(var3);
      if(null != var4) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field596;
         int[] var9 = var4.field597;
         byte var10 = -1;
         class36.field804 = 0;

         int var13;
         try {
            class36.field798 = new int[var4.field599];
            int var11 = 0;
            class36.field799 = new String[var4.field600];
            int var25 = 0;

            int var14;
            String var32;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(-2147483647 == var14) {
                     var14 = var0.field3;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field4;
                  }

                  if(-2147483645 == var14) {
                     var14 = var0.field6 != null?var0.field6.field2800 * -1:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field5;
                  }

                  if(-2147483643 == var14) {
                     var14 = null != var0.field6?var0.field6.field2744:-1;
                  }

                  if(-2147483642 == var14) {
                     var14 = null != var0.field2?var0.field2.field2800 * -1:-1;
                  }

                  if(-2147483641 == var14) {
                     var14 = null != var0.field2?var0.field2.field2744:-1;
                  }

                  if(-2147483640 == var14) {
                     var14 = var0.field7;
                  }

                  if(-2147483639 == var14) {
                     var14 = var0.field10;
                  }

                  class36.field798[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var32 = (String)var2[var13];
                  if(var32.equals("event_opbase")) {
                     var32 = var0.field0;
                  }

                  class36.field799[var25++] = var32;
               }
            }

            var13 = 0;
            class36.field808 = var0.field9;

            label3555:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var24 = var8[var7];
               int var16;
               int var17;
               int var18;
               int var19;
               String var26;
               int[] var28;
               String var44;
               int var49;
               int var63;
               byte var65;
               String var66;
               if(var24 < 100) {
                  if(0 == var24) {
                     class36.field802[var5++] = var9[var7];
                     continue;
                  }

                  if(var24 == 1) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class175.field2890[var14];
                     continue;
                  }

                  if(2 == var24) {
                     var14 = var9[var7];
                     --var5;
                     class175.field2890[var14] = class36.field802[var5];
                     class45.method959(var14);
                     continue;
                  }

                  if(var24 == 3) {
                     class36.field803[var6++] = var4.field598[var7];
                     continue;
                  }

                  if(var24 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var24 == 7) {
                     var5 -= 2;
                     if(class36.field802[var5 + 1] != class36.field802[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(8 == var24) {
                     var5 -= 2;
                     if(class36.field802[1 + var5] == class36.field802[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(9 == var24) {
                     var5 -= 2;
                     if(class36.field802[var5] < class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 10) {
                     var5 -= 2;
                     if(class36.field802[var5] > class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(21 == var24) {
                     if(class36.field804 == 0) {
                        return;
                     }

                     class14 var64 = class36.field797[--class36.field804];
                     var4 = var64.field213;
                     var8 = var4.field596;
                     var9 = var4.field597;
                     var7 = var64.field203;
                     class36.field798 = var64.field207;
                     class36.field799 = var64.field202;
                     continue;
                  }

                  if(var24 == 25) {
                     var14 = var9[var7];
                     class36.field802[var5++] = class126.method2820(var14);
                     continue;
                  }

                  if(var24 == 27) {
                     var14 = var9[var7];
                     --var5;
                     class169.method3396(var14, class36.field802[var5]);
                     continue;
                  }

                  if(var24 == 31) {
                     var5 -= 2;
                     if(class36.field802[var5] <= class36.field802[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var24 == 32) {
                     var5 -= 2;
                     if(class36.field802[var5] >= class36.field802[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(33 == var24) {
                     class36.field802[var5++] = class36.field798[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var24 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class36.field798[var10001] = class36.field802[var5];
                     continue;
                  }

                  if(var24 == 35) {
                     class36.field803[var6++] = class36.field799[var9[var7]];
                     continue;
                  }

                  if(var24 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class36.field799[var10001] = class36.field803[var6];
                     continue;
                  }

                  if(var24 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     String[] var90 = class36.field803;
                     if(0 == var14) {
                        var66 = "";
                     } else if(var14 == 1) {
                        var26 = var90[var6];
                        if(null == var26) {
                           var66 = "null";
                        } else {
                           var66 = var26.toString();
                        }
                     } else {
                        var17 = var6 + var14;
                        var18 = 0;

                        for(var19 = var6; var19 < var17; ++var19) {
                           var44 = var90[var19];
                           if(var44 == null) {
                              var18 += 4;
                           } else {
                              var18 += var44.length();
                           }
                        }

                        StringBuilder var79 = new StringBuilder(var18);

                        for(var49 = var6; var49 < var17; ++var49) {
                           String var51 = var90[var49];
                           if(null == var51) {
                              var79.append("null");
                           } else {
                              var79.append(var51);
                           }
                        }

                        var66 = var79.toString();
                     }

                     class36.field803[var6++] = var66;
                     continue;
                  }

                  if(38 == var24) {
                     --var5;
                     continue;
                  }

                  if(39 == var24) {
                     --var6;
                     continue;
                  }

                  if(40 == var24) {
                     var14 = var9[var7];
                     class22 var93 = class40.method823(var14);
                     var28 = new int[var93.field599];
                     String[] var78 = new String[var93.field600];

                     for(var18 = 0; var18 < var93.field601; ++var18) {
                        var28[var18] = class36.field802[var5 - var93.field601 + var18];
                     }

                     for(var18 = 0; var18 < var93.field595; ++var18) {
                        var78[var18] = class36.field803[var6 - var93.field595 + var18];
                     }

                     var5 -= var93.field601;
                     var6 -= var93.field595;
                     class14 var87 = new class14();
                     var87.field213 = var4;
                     var87.field203 = var7;
                     var87.field207 = class36.field798;
                     var87.field202 = class36.field799;
                     class36.field797[++class36.field804 - 1] = var87;
                     var4 = var93;
                     var8 = var93.field596;
                     var9 = var93.field597;
                     var7 = -1;
                     class36.field798 = var28;
                     class36.field799 = var78;
                     continue;
                  }

                  if(42 == var24) {
                     class36.field802[var5++] = class112.field1958.method219(var9[var7]);
                     continue;
                  }

                  if(43 == var24) {
                     var10001 = var9[var7];
                     --var5;
                     class112.field1958.method217(var10001, class36.field802[var5]);
                     continue;
                  }

                  if(var24 == 44) {
                     var14 = var9[var7] >> 16;
                     var63 = var9[var7] & '\uffff';
                     --var5;
                     var16 = class36.field802[var5];
                     if(var16 >= 0 && var16 <= 5000) {
                        class36.field805[var14] = var16;
                        var65 = -1;
                        if(var63 == 105) {
                           var65 = 0;
                        }

                        var18 = 0;

                        while(true) {
                           if(var18 >= var16) {
                              continue label3555;
                           }

                           class36.field801[var14][var18] = var65;
                           ++var18;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(45 == var24) {
                     var14 = var9[var7];
                     --var5;
                     var63 = class36.field802[var5];
                     if(var63 >= 0 && var63 < class36.field805[var14]) {
                        class36.field802[var5++] = class36.field801[var14][var63];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(46 == var24) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var63 = class36.field802[var5];
                     if(var63 >= 0 && var63 < class36.field805[var14]) {
                        class36.field801[var14][var63] = class36.field802[var5 + 1];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(47 == var24) {
                     var32 = class112.field1958.method224(var9[var7]);
                     if(var32 == null) {
                        var32 = "null";
                     }

                     class36.field803[var6++] = var32;
                     continue;
                  }

                  if(var24 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class112.field1958.method223(var10001, class36.field803[var6]);
                     continue;
                  }
               }

               boolean var38;
               if(1 == var9[var7]) {
                  var38 = true;
               } else {
                  var38 = false;
               }

               class172 var15;
               class172 var30;
               class172 var31;
               boolean var36;
               boolean var55;
               class172 var85;
               int[] var91;
               if(var24 < 1000) {
                  if(var24 == 100) {
                     var5 -= 3;
                     var63 = class36.field802[var5];
                     var16 = class36.field802[var5 + 1];
                     var17 = class36.field802[2 + var5];
                     if(0 == var16) {
                        throw new RuntimeException();
                     }

                     var30 = class92.method2180(var63);
                     if(var30.field2865 == null) {
                        var30.field2865 = new class172[var17 + 1];
                     }

                     if(var30.field2865.length <= var17) {
                        class172[] var75 = new class172[1 + var17];

                        for(var49 = 0; var49 < var30.field2865.length; ++var49) {
                           var75[var49] = var30.field2865[var49];
                        }

                        var30.field2865 = var75;
                     }

                     if(var17 > 0 && null == var30.field2865[var17 - 1]) {
                        throw new RuntimeException("" + (var17 - 1));
                     }

                     class172 var77 = new class172();
                     var77.field2764 = var16;
                     var77.field2762 = (var77.field2800 = var30.field2800) * -1;
                     var77.field2744 = var17;
                     var77.field2742 = true;
                     var30.field2865[var17] = var77;
                     if(var38) {
                        class36.field806 = var77;
                     } else {
                        class20.field584 = var77;
                     }

                     class36.method745(var30);
                     continue;
                  }

                  if(var24 == 101) {
                     var15 = var38?class36.field806:class20.field584;
                     var85 = class92.method2180(var15.field2800 * -1);
                     var85.field2865[var15.field2744] = null;
                     class36.method745(var85);
                     continue;
                  }

                  if(102 == var24) {
                     --var5;
                     var15 = class92.method2180(class36.field802[var5]);
                     var15.field2865 = null;
                     class36.method745(var15);
                     continue;
                  }

                  if(var24 == 200) {
                     var5 -= 2;
                     var63 = class36.field802[var5];
                     var16 = class36.field802[1 + var5];
                     var31 = class13.method183(var63, var16);
                     if(null != var31 && -1 != var16) {
                        class36.field802[var5++] = 1;
                        if(var38) {
                           class36.field806 = var31;
                        } else {
                           class20.field584 = var31;
                        }
                        continue;
                     }

                     class36.field802[var5++] = 0;
                     continue;
                  }

                  if(var24 == 201) {
                     --var5;
                     var15 = class92.method2180(class36.field802[var5]);
                     if(var15 != null) {
                        class36.field802[var5++] = 1;
                        if(var38) {
                           class36.field806 = var15;
                        } else {
                           class20.field584 = var15;
                        }
                     } else {
                        class36.field802[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var60;
                  if(var24 >= 1000 && var24 < 1100 || var24 >= 2000 && var24 < 2100) {
                     var63 = -1;
                     if(var24 >= 2000) {
                        var24 -= 1000;
                        --var5;
                        var63 = class36.field802[var5];
                        var85 = class92.method2180(var63);
                     } else {
                        var85 = var38?class36.field806:class20.field584;
                     }

                     if(1000 == var24) {
                        var5 -= 4;
                        var85.field2743 = class36.field802[var5];
                        var85.field2753 = class36.field802[1 + var5];
                        var85.field2748 = class36.field802[2 + var5];
                        var85.field2749 = class36.field802[var5 + 3];
                        class36.method745(var85);
                        class88.method2099(var85);
                        if(var63 != -1 && 0 == var85.field2764) {
                           class1.method14(class172.field2850[var63 >> 16], var85, false);
                        }
                        continue;
                     }

                     if(var24 == 1001) {
                        var5 -= 4;
                        var85.field2783 = class36.field802[var5];
                        var85.field2755 = class36.field802[var5 + 1];
                        var85.field2750 = class36.field802[2 + var5];
                        var85.field2751 = class36.field802[var5 + 3];
                        class36.method745(var85);
                        class88.method2099(var85);
                        if(-1 != var63 && 0 == var85.field2764) {
                           class1.method14(class172.field2850[var63 >> 16], var85, false);
                        }
                        continue;
                     }

                     if(var24 == 1003) {
                        --var5;
                        var60 = class36.field802[var5] == 1;
                        if(var85.field2763 != var60) {
                           var85.field2763 = var60;
                           class36.method745(var85);
                        }
                        continue;
                     }

                     if(var24 == 1005) {
                        --var5;
                        var85.field2874 = class36.field802[var5] == 1;
                        continue;
                     }

                     if(1006 == var24) {
                        --var5;
                        var85.field2875 = class36.field802[var5] == 1;
                        continue;
                     }
                  } else if((var24 < 1100 || var24 >= 1200) && (var24 < 2100 || var24 >= 2200)) {
                     if((var24 < 1200 || var24 >= 1300) && (var24 < 2200 || var24 >= 2300)) {
                        if((var24 < 1300 || var24 >= 1400) && (var24 < 2300 || var24 >= 2400)) {
                           String var34;
                           int[] var37;
                           if(var24 >= 1400 && var24 < 1500 || var24 >= 2400 && var24 < 2500) {
                              if(var24 >= 2000) {
                                 var24 -= 1000;
                                 --var5;
                                 var15 = class92.method2180(class36.field802[var5]);
                              } else {
                                 var15 = var38?class36.field806:class20.field584;
                              }

                              --var6;
                              var34 = class36.field803[var6];
                              var37 = null;
                              if(var34.length() > 0 && var34.charAt(var34.length() - 1) == 89) {
                                 --var5;
                                 var18 = class36.field802[var5];
                                 if(var18 > 0) {
                                    for(var37 = new int[var18]; var18-- > 0; var37[var18] = class36.field802[var5]) {
                                       --var5;
                                    }
                                 }

                                 var34 = var34.substring(0, var34.length() - 1);
                              }

                              Object[] var76 = new Object[var34.length() + 1];

                              for(var19 = var76.length - 1; var19 >= 1; --var19) {
                                 if(var34.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var76[var19] = class36.field803[var6];
                                 } else {
                                    --var5;
                                    var76[var19] = new Integer(class36.field802[var5]);
                                 }
                              }

                              --var5;
                              var19 = class36.field802[var5];
                              if(var19 != -1) {
                                 var76[0] = new Integer(var19);
                              } else {
                                 var76 = null;
                              }

                              if(1400 == var24) {
                                 var15.field2739 = var76;
                              }

                              if(1401 == var24) {
                                 var15.field2826 = var76;
                              }

                              if(1402 == var24) {
                                 var15.field2825 = var76;
                              }

                              if(1403 == var24) {
                                 var15.field2827 = var76;
                              }

                              if(1404 == var24) {
                                 var15.field2829 = var76;
                              }

                              if(var24 == 1405) {
                                 var15.field2830 = var76;
                              }

                              if(var24 == 1406) {
                                 var15.field2856 = var76;
                              }

                              if(1407 == var24) {
                                 var15.field2756 = var76;
                                 var15.field2835 = var37;
                              }

                              if(var24 == 1408) {
                                 var15.field2840 = var76;
                              }

                              if(1409 == var24) {
                                 var15.field2841 = var76;
                              }

                              if(var24 == 1410) {
                                 var15.field2767 = var76;
                              }

                              if(1411 == var24) {
                                 var15.field2824 = var76;
                              }

                              if(1412 == var24) {
                                 var15.field2828 = var76;
                              }

                              if(var24 == 1414) {
                                 var15.field2836 = var76;
                                 var15.field2833 = var37;
                              }

                              if(1415 == var24) {
                                 var15.field2838 = var76;
                                 var15.field2812 = var37;
                              }

                              if(1416 == var24) {
                                 var15.field2832 = var76;
                              }

                              if(var24 == 1417) {
                                 var15.field2842 = var76;
                              }

                              if(1418 == var24) {
                                 var15.field2811 = var76;
                              }

                              if(1419 == var24) {
                                 var15.field2844 = var76;
                              }

                              if(1420 == var24) {
                                 var15.field2868 = var76;
                              }

                              if(var24 == 1421) {
                                 var15.field2740 = var76;
                              }

                              if(1422 == var24) {
                                 var15.field2847 = var76;
                              }

                              if(1423 == var24) {
                                 var15.field2848 = var76;
                              }

                              if(var24 == 1424) {
                                 var15.field2849 = var76;
                              }

                              if(var24 == 1425) {
                                 var15.field2851 = var76;
                              }

                              if(var24 == 1426) {
                                 var15.field2852 = var76;
                              }

                              if(1427 == var24) {
                                 var15.field2799 = var76;
                              }

                              var15.field2758 = true;
                              continue;
                           }

                           if(var24 < 1600) {
                              var15 = var38?class36.field806:class20.field584;
                              if(var24 == 1500) {
                                 class36.field802[var5++] = var15.field2734;
                                 continue;
                              }

                              if(1501 == var24) {
                                 class36.field802[var5++] = var15.field2757;
                                 continue;
                              }

                              if(var24 == 1502) {
                                 class36.field802[var5++] = var15.field2752;
                                 continue;
                              }

                              if(1503 == var24) {
                                 class36.field802[var5++] = var15.field2759;
                                 continue;
                              }

                              if(var24 == 1504) {
                                 class36.field802[var5++] = var15.field2763?1:0;
                                 continue;
                              }

                              if(1505 == var24) {
                                 class36.field802[var5++] = var15.field2762;
                                 continue;
                              }
                           } else if(var24 < 1700) {
                              var15 = var38?class36.field806:class20.field584;
                              if(1600 == var24) {
                                 class36.field802[var5++] = var15.field2803;
                                 continue;
                              }

                              if(1601 == var24) {
                                 class36.field802[var5++] = var15.field2765;
                                 continue;
                              }

                              if(1602 == var24) {
                                 class36.field803[var6++] = var15.field2778;
                                 continue;
                              }

                              if(var24 == 1603) {
                                 class36.field802[var5++] = var15.field2766;
                                 continue;
                              }

                              if(1604 == var24) {
                                 class36.field802[var5++] = var15.field2813;
                                 continue;
                              }

                              if(1605 == var24) {
                                 class36.field802[var5++] = var15.field2795;
                                 continue;
                              }

                              if(1606 == var24) {
                                 class36.field802[var5++] = var15.field2792;
                                 continue;
                              }

                              if(1607 == var24) {
                                 class36.field802[var5++] = var15.field2794;
                                 continue;
                              }

                              if(var24 == 1608) {
                                 class36.field802[var5++] = var15.field2802;
                                 continue;
                              }

                              if(1609 == var24) {
                                 class36.field802[var5++] = var15.field2773;
                                 continue;
                              }
                           } else if(var24 < 1800) {
                              var15 = var38?class36.field806:class20.field584;
                              if(var24 == 1700) {
                                 class36.field802[var5++] = var15.field2834;
                                 continue;
                              }

                              if(var24 == 1701) {
                                 if(var15.field2834 != -1) {
                                    class36.field802[var5++] = var15.field2862;
                                 } else {
                                    class36.field802[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var24 == 1702) {
                                 class36.field802[var5++] = var15.field2744;
                                 continue;
                              }
                           } else if(var24 < 1900) {
                              var15 = var38?class36.field806:class20.field584;
                              if(var24 == 1800) {
                                 var28 = class36.field802;
                                 var17 = var5++;
                                 var19 = class101.method2294(var15);
                                 var18 = var19 >> 11 & 63;
                                 var28[var17] = var18;
                                 continue;
                              }

                              if(1801 == var24) {
                                 --var5;
                                 var16 = class36.field802[var5];
                                 --var16;
                                 if(var15.field2815 != null && var16 < var15.field2815.length && null != var15.field2815[var16]) {
                                    class36.field803[var6++] = var15.field2815[var16];
                                    continue;
                                 }

                                 class36.field803[var6++] = "";
                                 continue;
                              }

                              if(var24 == 1802) {
                                 if(null == var15.field2814) {
                                    class36.field803[var6++] = "";
                                 } else {
                                    class36.field803[var6++] = var15.field2814;
                                 }
                                 continue;
                              }
                           } else if(var24 >= 1900 && var24 < 2000 || var24 >= 2900 && var24 < 3000) {
                              if(var24 >= 2000) {
                                 var24 -= 1000;
                                 --var5;
                                 var15 = class92.method2180(class36.field802[var5]);
                              } else {
                                 var15 = var38?class36.field806:class20.field584;
                              }

                              if(var24 == 1927) {
                                 if(class36.field808 * 55171549 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var15.field2799 == null) {
                                    return;
                                 }

                                 class0 var84 = new class0();
                                 var84.field6 = var15;
                                 var84.field8 = var15.field2799;
                                 var84.field9 = -837728651 + class36.field808;
                                 client.field292.method3855(var0);
                                 continue;
                              }
                           } else if(var24 < 2600) {
                              --var5;
                              var15 = class92.method2180(class36.field802[var5]);
                              if(var24 == 2500) {
                                 class36.field802[var5++] = var15.field2734;
                                 continue;
                              }

                              if(var24 == 2501) {
                                 class36.field802[var5++] = var15.field2757;
                                 continue;
                              }

                              if(var24 == 2502) {
                                 class36.field802[var5++] = var15.field2752;
                                 continue;
                              }

                              if(var24 == 2503) {
                                 class36.field802[var5++] = var15.field2759;
                                 continue;
                              }

                              if(2504 == var24) {
                                 class36.field802[var5++] = var15.field2763?1:0;
                                 continue;
                              }

                              if(var24 == 2505) {
                                 class36.field802[var5++] = var15.field2762;
                                 continue;
                              }
                           } else if(var24 < 2700) {
                              --var5;
                              var15 = class92.method2180(class36.field802[var5]);
                              if(var24 == 2600) {
                                 class36.field802[var5++] = var15.field2803;
                                 continue;
                              }

                              if(var24 == 2601) {
                                 class36.field802[var5++] = var15.field2765;
                                 continue;
                              }

                              if(2602 == var24) {
                                 class36.field803[var6++] = var15.field2778;
                                 continue;
                              }

                              if(var24 == 2603) {
                                 class36.field802[var5++] = var15.field2766;
                                 continue;
                              }

                              if(var24 == 2604) {
                                 class36.field802[var5++] = var15.field2813;
                                 continue;
                              }

                              if(2605 == var24) {
                                 class36.field802[var5++] = var15.field2795;
                                 continue;
                              }

                              if(var24 == 2606) {
                                 class36.field802[var5++] = var15.field2792;
                                 continue;
                              }

                              if(var24 == 2607) {
                                 class36.field802[var5++] = var15.field2794;
                                 continue;
                              }

                              if(2608 == var24) {
                                 class36.field802[var5++] = var15.field2802;
                                 continue;
                              }

                              if(var24 == 2609) {
                                 class36.field802[var5++] = var15.field2773;
                                 continue;
                              }
                           } else if(var24 < 2800) {
                              if(var24 == 2700) {
                                 --var5;
                                 var15 = class92.method2180(class36.field802[var5]);
                                 class36.field802[var5++] = var15.field2834;
                                 continue;
                              }

                              if(2701 == var24) {
                                 --var5;
                                 var15 = class92.method2180(class36.field802[var5]);
                                 if(var15.field2834 != -1) {
                                    class36.field802[var5++] = var15.field2862;
                                 } else {
                                    class36.field802[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(2702 == var24) {
                                 --var5;
                                 var63 = class36.field802[var5];
                                 class3 var29 = (class3)client.field454.method3824((long)var63);
                                 if(var29 != null) {
                                    class36.field802[var5++] = 1;
                                 } else {
                                    class36.field802[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var24 == 2706) {
                                 class36.field802[var5++] = client.field453;
                                 continue;
                              }
                           } else if(var24 < 2900) {
                              --var5;
                              var15 = class92.method2180(class36.field802[var5]);
                              if(2800 == var24) {
                                 var28 = class36.field802;
                                 var17 = var5++;
                                 var19 = class101.method2294(var15);
                                 var18 = var19 >> 11 & 63;
                                 var28[var17] = var18;
                                 continue;
                              }

                              if(2801 == var24) {
                                 --var5;
                                 var16 = class36.field802[var5];
                                 --var16;
                                 if(var15.field2815 != null && var16 < var15.field2815.length && null != var15.field2815[var16]) {
                                    class36.field803[var6++] = var15.field2815[var16];
                                    continue;
                                 }

                                 class36.field803[var6++] = "";
                                 continue;
                              }

                              if(2802 == var24) {
                                 if(var15.field2814 == null) {
                                    class36.field803[var6++] = "";
                                 } else {
                                    class36.field803[var6++] = var15.field2814;
                                 }
                                 continue;
                              }
                           } else if(var24 < 3200) {
                              if(3100 == var24) {
                                 --var6;
                                 var66 = class36.field803[var6];
                                 class137.method2943(0, "", var66);
                                 continue;
                              }

                              if(3101 == var24) {
                                 var5 -= 2;
                                 class14.method186(class151.field2253, class36.field802[var5], class36.field802[1 + var5]);
                                 continue;
                              }

                              if(3103 == var24) {
                                 client.field301.method2753(138);

                                 for(class3 var71 = (class3)client.field454.method3836(); null != var71; var71 = (class3)client.field454.method3827()) {
                                    if(0 == var71.field62 || 3 == var71.field62) {
                                       class112.method2446(var71, true);
                                    }
                                 }

                                 if(null != client.field431) {
                                    class36.method745(client.field431);
                                    client.field431 = null;
                                 }
                                 continue;
                              }

                              if(3104 == var24) {
                                 --var6;
                                 var66 = class36.field803[var6];
                                 var16 = 0;
                                 if(class187.method3783(var66)) {
                                    var17 = class109.method2432(var66, 10);
                                    var16 = var17;
                                 }

                                 client.field301.method2753(91);
                                 client.field301.method2663(var16);
                                 continue;
                              }

                              if(var24 == 3105) {
                                 --var6;
                                 var66 = class36.field803[var6];
                                 client.field301.method2753(131);
                                 client.field301.method2497(var66.length() + 1);
                                 client.field301.method2503(var66);
                                 continue;
                              }

                              if(3106 == var24) {
                                 --var6;
                                 var66 = class36.field803[var6];
                                 client.field301.method2753(252);
                                 client.field301.method2497(var66.length() + 1);
                                 client.field301.method2503(var66);
                                 continue;
                              }

                              if(var24 == 3107) {
                                 --var5;
                                 var63 = class36.field802[var5];
                                 --var6;
                                 var34 = class36.field803[var6];
                                 class47.method1008(var63, var34);
                                 continue;
                              }

                              if(var24 == 3108) {
                                 var5 -= 3;
                                 var63 = class36.field802[var5];
                                 var16 = class36.field802[var5 + 1];
                                 var17 = class36.field802[2 + var5];
                                 var30 = class92.method2180(var17);
                                 class23.method592(var30, var63, var16);
                                 continue;
                              }

                              if(var24 == 3109) {
                                 var5 -= 2;
                                 var63 = class36.field802[var5];
                                 var16 = class36.field802[1 + var5];
                                 var31 = var38?class36.field806:class20.field584;
                                 class23.method592(var31, var63, var16);
                                 continue;
                              }

                              if(3110 == var24) {
                                 --var5;
                                 class214.field3149 = class36.field802[var5] == 1;
                                 continue;
                              }

                              if(3111 == var24) {
                                 class36.field802[var5++] = class89.field1548.field131?1:0;
                                 continue;
                              }

                              if(3112 == var24) {
                                 --var5;
                                 class89.field1548.field131 = class36.field802[var5] == 1;
                                 class108.method2430();
                                 continue;
                              }

                              if(3113 == var24) {
                                 --var6;
                                 var66 = class36.field803[var6];
                                 --var5;
                                 var36 = class36.field802[var5] == 1;
                                 class32.method710(var66, var36);
                                 continue;
                              }

                              if(var24 == 3115) {
                                 --var5;
                                 var63 = class36.field802[var5];
                                 client.field301.method2753(6);
                                 client.field301.method2498(var63);
                                 continue;
                              }

                              if(3116 == var24) {
                                 --var5;
                                 var63 = class36.field802[var5];
                                 var6 -= 2;
                                 var34 = class36.field803[var6];
                                 var26 = class36.field803[var6 + 1];
                                 if(var34.length() <= 500 && var26.length() <= 500) {
                                    client.field301.method2753(187);
                                    client.field301.method2498(1 + class22.method578(var34) + class22.method578(var26));
                                    client.field301.method2503(var26);
                                    client.field301.method2497(var63);
                                    client.field301.method2503(var34);
                                 }
                                 continue;
                              }
                           } else if(var24 < 3300) {
                              if(var24 == 3200) {
                                 var5 -= 3;
                                 var63 = class36.field802[var5];
                                 var16 = class36.field802[var5 + 1];
                                 var17 = class36.field802[var5 + 2];
                                 if(0 != client.field534 && 0 != var16 && client.field536 < 50) {
                                    client.field326[client.field536] = var63;
                                    client.field538[client.field536] = var16;
                                    client.field539[client.field536] = var17;
                                    client.field541[client.field536] = null;
                                    client.field503[client.field536] = 0;
                                    ++client.field536;
                                 }
                                 continue;
                              }

                              if(var24 == 3201) {
                                 --var5;
                                 var63 = class36.field802[var5];
                                 if(var63 == -1 && !client.field533) {
                                    class182.field2942.method3628();
                                    class182.field2947 = 1;
                                    class182.field2946 = null;
                                 } else if(var63 != -1 && var63 != client.field532 && 0 != client.field531 && !client.field533) {
                                    class35.method735(2, class129.field2054, var63, 0, client.field531, false);
                                 }

                                 client.field532 = var63;
                                 continue;
                              }

                              if(3202 == var24) {
                                 var5 -= 2;
                                 class27.method644(class36.field802[var5]);
                                 continue;
                              }
                           } else {
                              int var21;
                              int var22;
                              if(var24 < 3400) {
                                 if(var24 == 3300) {
                                    class36.field802[var5++] = client.field303;
                                    continue;
                                 }

                                 if(var24 == 3301) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class36.field802[var5++] = class121.method2772(var63, var16);
                                    continue;
                                 }

                                 class15 var20;
                                 if(var24 == 3302) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    var37 = class36.field802;
                                    var18 = var5++;
                                    var20 = (class15)class15.field225.method3824((long)var63);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(var16 >= 0 && var16 < var20.field221.length) {
                                       var19 = var20.field221[var16];
                                    } else {
                                       var19 = 0;
                                    }

                                    var37[var18] = var19;
                                    continue;
                                 }

                                 if(3303 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    var37 = class36.field802;
                                    var18 = var5++;
                                    var20 = (class15)class15.field225.method3824((long)var63);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(-1 == var16) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var20.field221.length; ++var22) {
                                          if(var16 == var20.field215[var22]) {
                                             var21 += var20.field221[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var37[var18] = var19;
                                    continue;
                                 }

                                 if(3304 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var28 = class36.field802;
                                    var17 = var5++;
                                    class50 var42 = (class50)class50.field1097.method3792((long)var63);
                                    class50 var33;
                                    if(null != var42) {
                                       var33 = var42;
                                    } else {
                                       byte[] var35 = class50.field1100.method3263(5, var63);
                                       var42 = new class50();
                                       if(var35 != null) {
                                          var42.method1032(new class118(var35));
                                       }

                                       class50.field1097.method3794(var42, (long)var63);
                                       var33 = var42;
                                    }

                                    var28[var17] = var33.field1098;
                                    continue;
                                 }

                                 if(3305 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field430[var63];
                                    continue;
                                 }

                                 if(3306 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field337[var63];
                                    continue;
                                 }

                                 if(3307 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field290[var63];
                                    continue;
                                 }

                                 if(var24 == 3308) {
                                    var63 = class48.field1078;
                                    var16 = (class151.field2253.field870 >> 7) + class147.field2214;
                                    var17 = class17.field257 + (class151.field2253.field813 >> 7);
                                    class36.field802[var5++] = (var16 << 14) + (var63 << 28) + var17;
                                    continue;
                                 }

                                 if(var24 == 3309) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = var63 >> 14 & 16383;
                                    continue;
                                 }

                                 if(3310 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = var63 >> 28;
                                    continue;
                                 }

                                 if(var24 == 3311) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = var63 & 16383;
                                    continue;
                                 }

                                 if(3312 == var24) {
                                    class36.field802[var5++] = client.field296?1:0;
                                    continue;
                                 }

                                 if(3313 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5] + '耀';
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = class121.method2772(var63, var16);
                                    continue;
                                 }

                                 if(3314 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5] + '耀';
                                    var16 = class36.field802[1 + var5];
                                    var37 = class36.field802;
                                    var18 = var5++;
                                    var20 = (class15)class15.field225.method3824((long)var63);
                                    if(var20 == null) {
                                       var19 = 0;
                                    } else if(var16 >= 0 && var16 < var20.field221.length) {
                                       var19 = var20.field221[var16];
                                    } else {
                                       var19 = 0;
                                    }

                                    var37[var18] = var19;
                                    continue;
                                 }

                                 if(var24 == 3315) {
                                    var5 -= 2;
                                    var63 = '耀' + class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    var37 = class36.field802;
                                    var18 = var5++;
                                    var20 = (class15)class15.field225.method3824((long)var63);
                                    if(null == var20) {
                                       var19 = 0;
                                    } else if(-1 == var16) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var20.field221.length; ++var22) {
                                          if(var16 == var20.field215[var22]) {
                                             var21 += var20.field221[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var37[var18] = var19;
                                    continue;
                                 }

                                 if(var24 == 3316) {
                                    if(client.field460 >= 2) {
                                       class36.field802[var5++] = client.field460;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(3317 == var24) {
                                    class36.field802[var5++] = client.field310;
                                    continue;
                                 }

                                 if(var24 == 3318) {
                                    class36.field802[var5++] = client.field527;
                                    continue;
                                 }

                                 if(var24 == 3321) {
                                    class36.field802[var5++] = client.field458;
                                    continue;
                                 }

                                 if(3322 == var24) {
                                    class36.field802[var5++] = client.field336;
                                    continue;
                                 }

                                 if(var24 == 3323) {
                                    if(client.field471) {
                                       class36.field802[var5++] = 1;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(3324 == var24) {
                                    class36.field802[var5++] = client.field506;
                                    continue;
                                 }
                              } else if(var24 < 3500) {
                                 if(var24 == 3400) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class48 var40 = (class48)class48.field1076.method3792((long)var63);
                                    class48 var43;
                                    if(null != var40) {
                                       var43 = var40;
                                    } else {
                                       byte[] var54 = class48.field1069.method3263(8, var63);
                                       var40 = new class48();
                                       if(var54 != null) {
                                          var40.method1013(new class118(var54));
                                       }

                                       class48.field1076.method3794(var40, (long)var63);
                                       var43 = var40;
                                    }

                                    var40 = var43;
                                    if(115 != var43.field1071) {
                                       ;
                                    }

                                    for(var19 = 0; var19 < var40.field1075; ++var19) {
                                       if(var16 == var40.field1087[var19]) {
                                          class36.field803[var6++] = var40.field1077[var19];
                                          var40 = null;
                                          break;
                                       }
                                    }

                                    if(var40 != null) {
                                       class36.field803[var6++] = var40.field1072;
                                    }
                                    continue;
                                 }

                                 if(3408 == var24) {
                                    var5 -= 4;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    var17 = class36.field802[var5 + 2];
                                    var18 = class36.field802[3 + var5];
                                    class48 var39 = (class48)class48.field1076.method3792((long)var17);
                                    class48 var53;
                                    if(null != var39) {
                                       var53 = var39;
                                    } else {
                                       byte[] var41 = class48.field1069.method3263(8, var17);
                                       var39 = new class48();
                                       if(var41 != null) {
                                          var39.method1013(new class118(var41));
                                       }

                                       class48.field1076.method3794(var39, (long)var17);
                                       var53 = var39;
                                    }

                                    var39 = var53;
                                    if(var53.field1070 == var63 && var53.field1071 == var16) {
                                       for(var21 = 0; var21 < var39.field1075; ++var21) {
                                          if(var18 == var39.field1087[var21]) {
                                             if(var16 == 115) {
                                                class36.field803[var6++] = var39.field1077[var21];
                                             } else {
                                                class36.field802[var5++] = var39.field1080[var21];
                                             }

                                             var39 = null;
                                             break;
                                          }
                                       }

                                       if(null != var39) {
                                          if(var16 == 115) {
                                             class36.field803[var6++] = var39.field1072;
                                          } else {
                                             class36.field802[var5++] = var39.field1073;
                                          }
                                       }
                                       continue;
                                    }

                                    if(115 == var16) {
                                       class36.field803[var6++] = "null";
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var24 < 3700) {
                                 if(3600 == var24) {
                                    if(0 == client.field369) {
                                       class36.field802[var5++] = -2;
                                    } else if(client.field369 == 1) {
                                       class36.field802[var5++] = -1;
                                    } else {
                                       class36.field802[var5++] = client.field562;
                                    }
                                    continue;
                                 }

                                 if(var24 == 3601) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(client.field369 == 2 && var63 < client.field562) {
                                       class36.field803[var6++] = client.field513[var63].field261;
                                       class36.field803[var6++] = client.field513[var63].field248;
                                       continue;
                                    }

                                    class36.field803[var6++] = "";
                                    class36.field803[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 3602) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(2 == client.field369 && var63 < client.field562) {
                                       class36.field802[var5++] = client.field513[var63].field249;
                                       continue;
                                    }

                                    class36.field802[var5++] = 0;
                                    continue;
                                 }

                                 if(var24 == 3603) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(client.field369 == 2 && var63 < client.field562) {
                                       class36.field802[var5++] = client.field513[var63].field250;
                                       continue;
                                    }

                                    class36.field802[var5++] = 0;
                                    continue;
                                 }

                                 if(3604 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class93.method2182(var66, var16);
                                    continue;
                                 }

                                 if(var24 == 3605) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class6.method112(var66);
                                    continue;
                                 }

                                 class17 var52;
                                 String var59;
                                 if(3606 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    if(var66 == null) {
                                       continue;
                                    }

                                    var34 = class128.method2832(var66, class132.field2062);
                                    if(null == var34) {
                                       continue;
                                    }

                                    var17 = 0;

                                    while(true) {
                                       if(var17 >= client.field562) {
                                          continue label3555;
                                       }

                                       var52 = client.field513[var17];
                                       var59 = var52.field261;
                                       var44 = class128.method2832(var59, class132.field2062);
                                       boolean var45;
                                       if(var66 != null && var59 != null) {
                                          if(!var66.startsWith("#") && !var59.startsWith("#")) {
                                             var45 = var34.equals(var44);
                                          } else {
                                             var45 = var66.equals(var59);
                                          }
                                       } else {
                                          var45 = false;
                                       }

                                       if(var45) {
                                          --client.field562;

                                          for(var22 = var17; var22 < client.field562; ++var22) {
                                             client.field513[var22] = client.field513[var22 + 1];
                                          }

                                          client.field496 = client.field479;
                                          client.field301.method2753(9);
                                          client.field301.method2497(class22.method578(var66));
                                          client.field301.method2503(var66);
                                          continue label3555;
                                       }

                                       ++var17;
                                    }
                                 }

                                 if(var24 == 3607) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    if(var66 == null) {
                                       continue;
                                    }

                                    if((client.field509 < 100 || 1 == client.field459) && client.field509 < 400) {
                                       var34 = class128.method2832(var66, class132.field2062);
                                       if(null == var34) {
                                          continue;
                                       }

                                       for(var17 = 0; var17 < client.field509; ++var17) {
                                          class7 var50 = client.field568[var17];
                                          var59 = class128.method2832(var50.field129, class132.field2062);
                                          if(null != var59 && var59.equals(var34)) {
                                             class137.method2943(31, "", var66 + " is already on your ignore list");
                                             continue label3555;
                                          }

                                          if(null != var50.field125) {
                                             var44 = class128.method2832(var50.field125, class132.field2062);
                                             if(null != var44 && var44.equals(var34)) {
                                                class137.method2943(31, "", var66 + " is already on your ignore list");
                                                continue label3555;
                                             }
                                          }
                                       }

                                       for(var17 = 0; var17 < client.field562; ++var17) {
                                          var52 = client.field513[var17];
                                          var59 = class128.method2832(var52.field261, class132.field2062);
                                          if(var59 != null && var59.equals(var34)) {
                                             class137.method2943(31, "", "Please remove " + var66 + " from your friend list first");
                                             continue label3555;
                                          }

                                          if(null != var52.field248) {
                                             var44 = class128.method2832(var52.field248, class132.field2062);
                                             if(var44 != null && var44.equals(var34)) {
                                                class137.method2943(31, "", "Please remove " + var66 + " from your friend list first");
                                                continue label3555;
                                             }
                                          }
                                       }

                                       if(class128.method2832(class151.field2253.field40, class132.field2062).equals(var34)) {
                                          class137.method2943(31, "", "You can\'t add yourself to your own ignore list");
                                       } else {
                                          client.field301.method2753(3);
                                          client.field301.method2497(class22.method578(var66));
                                          client.field301.method2503(var66);
                                       }
                                       continue;
                                    }

                                    class137.method2943(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var24 == 3608) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class51.method1089(var66);
                                    continue;
                                 }

                                 if(var24 == 3609) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class151[] var56 = class211.method3970();

                                    for(var17 = 0; var17 < var56.length; ++var17) {
                                       class151 var48 = var56[var17];
                                       if(var48.field2248 != -1) {
                                          var21 = var48.field2248;
                                          var44 = "<img=" + var21 + ">";
                                          if(var66.startsWith(var44)) {
                                             var66 = var66.substring(6 + Integer.toString(var48.field2248).length());
                                             break;
                                          }
                                       }
                                    }

                                    class36.field802[var5++] = class10.method140(var66, false)?1:0;
                                    continue;
                                 }

                                 String var47;
                                 String[] var80;
                                 if(var24 == 3611) {
                                    if(client.field438 != null) {
                                       var80 = class36.field803;
                                       var16 = var6++;
                                       var47 = client.field438;
                                       var59 = class33.method716(class84.method1913(var47));
                                       if(var59 == null) {
                                          var59 = "";
                                       }

                                       var80[var16] = var59;
                                    } else {
                                       class36.field803[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var24 == 3612) {
                                    if(null != client.field438) {
                                       class36.field802[var5++] = class9.field151;
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 3613) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(client.field438 != null && var63 < class9.field151) {
                                       class36.field803[var6++] = class42.field1003[var63].field624;
                                       continue;
                                    }

                                    class36.field803[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 3614) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(client.field438 != null && var63 < class9.field151) {
                                       class36.field802[var5++] = class42.field1003[var63].field629;
                                       continue;
                                    }

                                    class36.field802[var5++] = 0;
                                    continue;
                                 }

                                 if(3615 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(client.field438 != null && var63 < class9.field151) {
                                       class36.field802[var5++] = class42.field1003[var63].field626;
                                       continue;
                                    }

                                    class36.field802[var5++] = 0;
                                    continue;
                                 }

                                 if(var24 == 3616) {
                                    class36.field802[var5++] = class12.field184;
                                    continue;
                                 }

                                 if(3617 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class41.method867(var66);
                                    continue;
                                 }

                                 if(3618 == var24) {
                                    class36.field802[var5++] = class10.field162;
                                    continue;
                                 }

                                 if(var24 == 3619) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    if(!var66.equals("")) {
                                       client.field301.method2753(53);
                                       client.field301.method2497(class22.method578(var66));
                                       client.field301.method2503(var66);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3620) {
                                    class109.method2431();
                                    continue;
                                 }

                                 if(var24 == 3621) {
                                    if(client.field369 == 0) {
                                       class36.field802[var5++] = -1;
                                    } else {
                                       class36.field802[var5++] = client.field509;
                                    }
                                    continue;
                                 }

                                 if(3622 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(0 != client.field369 && var63 < client.field509) {
                                       class36.field803[var6++] = client.field568[var63].field129;
                                       class36.field803[var6++] = client.field568[var63].field125;
                                       continue;
                                    }

                                    class36.field803[var6++] = "";
                                    class36.field803[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 3623) {
                                    label3331: {
                                       --var6;
                                       var66 = class36.field803[var6];
                                       var26 = "<img=0>";
                                       if(!var66.startsWith(var26)) {
                                          var59 = "<img=1>";
                                          if(!var66.startsWith(var59)) {
                                             break label3331;
                                          }
                                       }

                                       var66 = var66.substring(7);
                                    }

                                    class36.field802[var5++] = class26.method635(var66)?1:0;
                                    continue;
                                 }

                                 if(var24 == 3624) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    if(null != class42.field1003 && var63 < class9.field151 && class42.field1003[var63].field624.equalsIgnoreCase(class151.field2253.field40)) {
                                       class36.field802[var5++] = 1;
                                       continue;
                                    }

                                    class36.field802[var5++] = 0;
                                    continue;
                                 }

                                 if(var24 == 3625) {
                                    if(null != client.field314) {
                                       var80 = class36.field803;
                                       var16 = var6++;
                                       var47 = client.field314;
                                       var59 = class33.method716(class84.method1913(var47));
                                       if(var59 == null) {
                                          var59 = "";
                                       }

                                       var80[var16] = var59;
                                    } else {
                                       class36.field803[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else if(var24 < 4000) {
                                 if(var24 == 3903) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].method4029();
                                    continue;
                                 }

                                 if(var24 == 3904) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].field3163;
                                    continue;
                                 }

                                 if(var24 == 3905) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].field3164;
                                    continue;
                                 }

                                 if(3906 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].field3162;
                                    continue;
                                 }

                                 if(var24 == 3907) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].field3165;
                                    continue;
                                 }

                                 if(var24 == 3908) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = client.field572[var63].field3167;
                                    continue;
                                 }

                                 if(3910 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var16 = client.field572[var63].method4028();
                                    class36.field802[var5++] = 0 == var16?1:0;
                                    continue;
                                 }

                                 if(var24 == 3911) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var16 = client.field572[var63].method4028();
                                    class36.field802[var5++] = 2 == var16?1:0;
                                    continue;
                                 }

                                 if(var24 == 3912) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var16 = client.field572[var63].method4028();
                                    class36.field802[var5++] = var16 == 5?1:0;
                                    continue;
                                 }

                                 if(3913 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var16 = client.field572[var63].method4028();
                                    class36.field802[var5++] = 1 == var16?1:0;
                                    continue;
                                 }

                                 boolean var88;
                                 if(var24 == 3914) {
                                    --var5;
                                    var88 = class36.field802[var5] == 1;
                                    if(null != class165.field2653) {
                                       class165.field2653.method4045(class220.field3171, var88);
                                    }
                                    continue;
                                 }

                                 if(3915 == var24) {
                                    --var5;
                                    var88 = class36.field802[var5] == 1;
                                    if(null != class165.field2653) {
                                       class165.field2653.method4045(class220.field3172, var88);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3916) {
                                    var5 -= 2;
                                    var88 = 1 == class36.field802[var5];
                                    var36 = 1 == class36.field802[var5 + 1];
                                    if(null != class165.field2653) {
                                       class165.field2653.method4045(new class21(var36), var88);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3917) {
                                    --var5;
                                    var88 = class36.field802[var5] == 1;
                                    if(null != class165.field2653) {
                                       class165.field2653.method4045(class220.field3170, var88);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3918) {
                                    --var5;
                                    var88 = class36.field802[var5] == 1;
                                    if(null != class165.field2653) {
                                       class165.field2653.method4045(class220.field3173, var88);
                                    }
                                    continue;
                                 }

                                 if(var24 == 3919) {
                                    class36.field802[var5++] = class165.field2653 == null?0:class165.field2653.field3169.size();
                                    continue;
                                 }

                                 class213 var61;
                                 if(var24 == 3920) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field802[var5++] = var61.field3142;
                                    continue;
                                 }

                                 if(3921 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field803[var6++] = var61.method3985();
                                    continue;
                                 }

                                 if(3922 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field803[var6++] = var61.method3986();
                                    continue;
                                 }

                                 if(var24 == 3923) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    long var57 = class18.method214() - class50.field1096 - var61.field3140;
                                    var19 = (int)(var57 / 3600000L);
                                    var49 = (int)((var57 - (long)(3600000 * var19)) / 60000L);
                                    var21 = (int)((var57 - (long)(var19 * 3600000) - (long)('\uea60' * var49)) / 1000L);
                                    String var46 = var19 + ":" + var49 / 10 + var49 % 10 + ":" + var21 / 10 + var21 % 10;
                                    class36.field803[var6++] = var46;
                                    continue;
                                 }

                                 if(3924 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field802[var5++] = var61.field3139.field3162;
                                    continue;
                                 }

                                 if(3925 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field802[var5++] = var61.field3139.field3164;
                                    continue;
                                 }

                                 if(var24 == 3926) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var61 = (class213)class165.field2653.field3169.get(var63);
                                    class36.field802[var5++] = var61.field3139.field3163;
                                    continue;
                                 }
                              } else if(var24 < 4100) {
                                 if(var24 == 4000) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 + var16;
                                    continue;
                                 }

                                 if(var24 == 4001) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 - var16;
                                    continue;
                                 }

                                 if(4002 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class36.field802[var5++] = var63 * var16;
                                    continue;
                                 }

                                 if(var24 == 4003) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class36.field802[var5++] = var63 / var16;
                                    continue;
                                 }

                                 if(var24 == 4004) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = (int)(Math.random() * (double)var63);
                                    continue;
                                 }

                                 if(4005 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = (int)(Math.random() * (double)(var63 + 1));
                                    continue;
                                 }

                                 if(4006 == var24) {
                                    var5 -= 5;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    var17 = class36.field802[var5 + 2];
                                    var18 = class36.field802[var5 + 3];
                                    var19 = class36.field802[var5 + 4];
                                    class36.field802[var5++] = (var19 - var17) * (var16 - var63) / (var18 - var17) + var63;
                                    continue;
                                 }

                                 if(var24 == 4007) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 + var16 * var63 / 100;
                                    continue;
                                 }

                                 if(4008 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 | 1 << var16;
                                    continue;
                                 }

                                 if(var24 == 4009) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 & -1 - (1 << var16);
                                    continue;
                                 }

                                 if(4010 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class36.field802[var5++] = (var63 & 1 << var16) != 0?1:0;
                                    continue;
                                 }

                                 if(var24 == 4011) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class36.field802[var5++] = var63 % var16;
                                    continue;
                                 }

                                 if(var24 == 4012) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    if(0 == var63) {
                                       class36.field802[var5++] = 0;
                                    } else {
                                       class36.field802[var5++] = (int)Math.pow((double)var63, (double)var16);
                                    }
                                    continue;
                                 }

                                 if(var24 == 4013) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    if(0 == var63) {
                                       class36.field802[var5++] = 0;
                                    } else if(0 == var16) {
                                       class36.field802[var5++] = Integer.MAX_VALUE;
                                    } else {
                                       class36.field802[var5++] = (int)Math.pow((double)var63, 1.0D / (double)var16);
                                    }
                                    continue;
                                 }

                                 if(var24 == 4014) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 & var16;
                                    continue;
                                 }

                                 if(4015 == var24) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[var5 + 1];
                                    class36.field802[var5++] = var63 | var16;
                                    continue;
                                 }
                              } else if(var24 < 4200) {
                                 if(var24 == 4100) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class36.field803[var6++] = var66 + var16;
                                    continue;
                                 }

                                 if(var24 == 4101) {
                                    var6 -= 2;
                                    var66 = class36.field803[var6];
                                    var34 = class36.field803[1 + var6];
                                    class36.field803[var6++] = var66 + var34;
                                    continue;
                                 }

                                 if(var24 == 4102) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class36.field803[var6++] = var66 + class126.method2827(var16, true);
                                    continue;
                                 }

                                 if(4103 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class36.field803[var6++] = var66.toLowerCase();
                                    continue;
                                 }

                                 if(4104 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    long var81 = (11745L + (long)var63) * 86400000L;
                                    class36.field807.setTime(new Date(var81));
                                    var18 = class36.field807.get(5);
                                    var19 = class36.field807.get(2);
                                    var49 = class36.field807.get(1);
                                    class36.field803[var6++] = var18 + "-" + class36.field809[var19] + "-" + var49;
                                    continue;
                                 }

                                 if(4105 == var24) {
                                    var6 -= 2;
                                    var66 = class36.field803[var6];
                                    var34 = class36.field803[1 + var6];
                                    if(null != class151.field2253.field43 && class151.field2253.field43.field2904) {
                                       class36.field803[var6++] = var34;
                                       continue;
                                    }

                                    class36.field803[var6++] = var66;
                                    continue;
                                 }

                                 if(var24 == 4106) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field803[var6++] = Integer.toString(var63);
                                    continue;
                                 }

                                 if(var24 == 4107) {
                                    var6 -= 2;
                                    var91 = class36.field802;
                                    var16 = var5++;
                                    var18 = class124.method2806(class36.field803[var6], class36.field803[var6 + 1]);
                                    if(var18 > 0) {
                                       var65 = 1;
                                    } else if(var18 < 0) {
                                       var65 = -1;
                                    } else {
                                       var65 = 0;
                                    }

                                    var91[var16] = var65;
                                    continue;
                                 }

                                 byte[] var58;
                                 class223 var69;
                                 if(var24 == 4108) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    var5 -= 2;
                                    var16 = class36.field802[var5];
                                    var17 = class36.field802[1 + var5];
                                    var58 = class77.field1391.method3263(var17, 0);
                                    var69 = new class223(var58);
                                    class36.field802[var5++] = var69.method4055(var66, var16);
                                    continue;
                                 }

                                 if(4109 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    var5 -= 2;
                                    var16 = class36.field802[var5];
                                    var17 = class36.field802[var5 + 1];
                                    var58 = class77.field1391.method3263(var17, 0);
                                    var69 = new class223(var58);
                                    class36.field802[var5++] = var69.method4054(var66, var16);
                                    continue;
                                 }

                                 if(4110 == var24) {
                                    var6 -= 2;
                                    var66 = class36.field803[var6];
                                    var34 = class36.field803[1 + var6];
                                    --var5;
                                    if(class36.field802[var5] == 1) {
                                       class36.field803[var6++] = var66;
                                    } else {
                                       class36.field803[var6++] = var34;
                                    }
                                    continue;
                                 }

                                 if(var24 == 4111) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    class36.field803[var6++] = class222.method4130(var66);
                                    continue;
                                 }

                                 if(4112 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class36.field803[var6++] = var66 + (char)var16;
                                    continue;
                                 }

                                 if(4113 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class124.method2805((char)var63)?1:0;
                                    continue;
                                 }

                                 char var67;
                                 if(4114 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var28 = class36.field802;
                                    var17 = var5++;
                                    var67 = (char)var63;
                                    var55 = var67 >= 48 && var67 <= 57 || var67 >= 65 && var67 <= 90 || var67 >= 97 && var67 <= 122;
                                    var28[var17] = var55?1:0;
                                    continue;
                                 }

                                 if(4115 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var28 = class36.field802;
                                    var17 = var5++;
                                    var67 = (char)var63;
                                    var55 = var67 >= 65 && var67 <= 90 || var67 >= 97 && var67 <= 122;
                                    var28[var17] = var55?1:0;
                                    continue;
                                 }

                                 if(4116 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class24.method597((char)var63)?1:0;
                                    continue;
                                 }

                                 if(var24 == 4117) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    if(var66 != null) {
                                       class36.field802[var5++] = var66.length();
                                    } else {
                                       class36.field802[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var24 == 4118) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    var5 -= 2;
                                    var16 = class36.field802[var5];
                                    var17 = class36.field802[1 + var5];
                                    class36.field803[var6++] = var66.substring(var16, var17);
                                    continue;
                                 }

                                 if(4119 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    StringBuilder var74 = new StringBuilder(var66.length());
                                    var60 = false;

                                    for(var18 = 0; var18 < var66.length(); ++var18) {
                                       var67 = var66.charAt(var18);
                                       if(60 == var67) {
                                          var60 = true;
                                       } else if(62 == var67) {
                                          var60 = false;
                                       } else if(!var60) {
                                          var74.append(var67);
                                       }
                                    }

                                    class36.field803[var6++] = var74.toString();
                                    continue;
                                 }

                                 if(var24 == 4120) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class36.field802[var5++] = var66.indexOf(var16);
                                    continue;
                                 }

                                 if(4121 == var24) {
                                    var6 -= 2;
                                    var66 = class36.field803[var6];
                                    var34 = class36.field803[1 + var6];
                                    --var5;
                                    var17 = class36.field802[var5];
                                    class36.field802[var5++] = var66.indexOf(var34, var17);
                                    continue;
                                 }
                              } else if(var24 < 4300) {
                                 if(4200 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field803[var6++] = class75.method1648(var63).field1115;
                                    continue;
                                 }

                                 class51 var68;
                                 if(var24 == 4201) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    var68 = class75.method1648(var63);
                                    if(var16 >= 1 && var16 <= 5 && null != var68.field1129[var16 - 1]) {
                                       class36.field803[var6++] = var68.field1129[var16 - 1];
                                       continue;
                                    }

                                    class36.field803[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 4202) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    var68 = class75.method1648(var63);
                                    if(var16 >= 1 && var16 <= 5 && var68.field1135[var16 - 1] != null) {
                                       class36.field803[var6++] = var68.field1135[var16 - 1];
                                       continue;
                                    }

                                    class36.field803[var6++] = "";
                                    continue;
                                 }

                                 if(var24 == 4203) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class75.method1648(var63).field1143;
                                    continue;
                                 }

                                 if(var24 == 4204) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class75.method1648(var63).field1126 == 1?1:0;
                                    continue;
                                 }

                                 class51 var82;
                                 if(4205 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var82 = class75.method1648(var63);
                                    if(var82.field1120 == -1 && var82.field1145 >= 0) {
                                       class36.field802[var5++] = var82.field1145;
                                       continue;
                                    }

                                    class36.field802[var5++] = var63;
                                    continue;
                                 }

                                 if(4206 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    var82 = class75.method1648(var63);
                                    if(var82.field1120 >= 0 && var82.field1145 >= 0) {
                                       class36.field802[var5++] = var82.field1145;
                                       continue;
                                    }

                                    class36.field802[var5++] = var63;
                                    continue;
                                 }

                                 if(var24 == 4207) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class75.method1648(var63).field1128?1:0;
                                    continue;
                                 }

                                 if(4210 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    class56.method1241(var66, var16 == 1);
                                    class36.field802[var5++] = class31.field751;
                                    continue;
                                 }

                                 if(var24 == 4211) {
                                    if(null != class101.field1757 && class38.field879 < class31.field751) {
                                       class36.field802[var5++] = class101.field1757[++class38.field879 - 1] & '\uffff';
                                       continue;
                                    }

                                    class36.field802[var5++] = -1;
                                    continue;
                                 }

                                 if(var24 == 4212) {
                                    class38.field879 = 0;
                                    continue;
                                 }
                              } else if(var24 < 5100) {
                                 if(var24 == 5000) {
                                    class36.field802[var5++] = client.field512;
                                    continue;
                                 }

                                 if(5001 == var24) {
                                    var5 -= 3;
                                    client.field512 = class36.field802[var5];
                                    class7.field126 = class15.method195(class36.field802[var5 + 1]);
                                    if(class7.field126 == null) {
                                       class7.field126 = class129.field2055;
                                    }

                                    client.field482 = class36.field802[2 + var5];
                                    client.field301.method2753(140);
                                    client.field301.method2497(client.field512);
                                    client.field301.method2497(class7.field126.field2050);
                                    client.field301.method2497(client.field482);
                                    continue;
                                 }

                                 if(var24 == 5002) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    var5 -= 2;
                                    var16 = class36.field802[var5];
                                    var17 = class36.field802[var5 + 1];
                                    client.field301.method2753(235);
                                    client.field301.method2497(class22.method578(var66) + 2);
                                    client.field301.method2503(var66);
                                    client.field301.method2497(var16 - 1);
                                    client.field301.method2497(var17);
                                    continue;
                                 }

                                 if(var24 == 5003) {
                                    var5 -= 2;
                                    var63 = class36.field802[var5];
                                    var16 = class36.field802[1 + var5];
                                    class27 var73 = (class27)class11.field169.get(Integer.valueOf(var63));
                                    class35 var72 = var73.method638(var16);
                                    if(var72 != null) {
                                       class36.field802[var5++] = var72.field789;
                                       class36.field802[var5++] = var72.field788;
                                       class36.field803[var6++] = null != var72.field791?var72.field791:"";
                                       class36.field803[var6++] = var72.field792 != null?var72.field792:"";
                                       class36.field803[var6++] = null != var72.field793?var72.field793:"";
                                    } else {
                                       class36.field802[var5++] = -1;
                                       class36.field802[var5++] = 0;
                                       class36.field803[var6++] = "";
                                       class36.field803[var6++] = "";
                                       class36.field803[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var24 == 5004) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class35 var83 = (class35)class11.field164.method3849((long)var63);
                                    if(null != var83) {
                                       class36.field802[var5++] = var83.field790;
                                       class36.field802[var5++] = var83.field788;
                                       class36.field803[var6++] = var83.field791 != null?var83.field791:"";
                                       class36.field803[var6++] = null != var83.field792?var83.field792:"";
                                       class36.field803[var6++] = var83.field793 != null?var83.field793:"";
                                    } else {
                                       class36.field802[var5++] = -1;
                                       class36.field802[var5++] = 0;
                                       class36.field803[var6++] = "";
                                       class36.field803[var6++] = "";
                                       class36.field803[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(5005 == var24) {
                                    if(null == class7.field126) {
                                       class36.field802[var5++] = -1;
                                    } else {
                                       class36.field802[var5++] = class7.field126.field2050;
                                    }
                                    continue;
                                 }

                                 if(5008 == var24) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    --var5;
                                    var16 = class36.field802[var5];
                                    var26 = var66.toLowerCase();
                                    byte var62 = 0;
                                    if(var26.startsWith("yellow:")) {
                                       var62 = 0;
                                       var66 = var66.substring("yellow:".length());
                                    } else if(var26.startsWith("red:")) {
                                       var62 = 1;
                                       var66 = var66.substring("red:".length());
                                    } else if(var26.startsWith("green:")) {
                                       var62 = 2;
                                       var66 = var66.substring("green:".length());
                                    } else if(var26.startsWith("cyan:")) {
                                       var62 = 3;
                                       var66 = var66.substring("cyan:".length());
                                    } else if(var26.startsWith("purple:")) {
                                       var62 = 4;
                                       var66 = var66.substring("purple:".length());
                                    } else if(var26.startsWith("white:")) {
                                       var62 = 5;
                                       var66 = var66.substring("white:".length());
                                    } else if(var26.startsWith("flash1:")) {
                                       var62 = 6;
                                       var66 = var66.substring("flash1:".length());
                                    } else if(var26.startsWith("flash2:")) {
                                       var62 = 7;
                                       var66 = var66.substring("flash2:".length());
                                    } else if(var26.startsWith("flash3:")) {
                                       var62 = 8;
                                       var66 = var66.substring("flash3:".length());
                                    } else if(var26.startsWith("glow1:")) {
                                       var62 = 9;
                                       var66 = var66.substring("glow1:".length());
                                    } else if(var26.startsWith("glow2:")) {
                                       var62 = 10;
                                       var66 = var66.substring("glow2:".length());
                                    } else if(var26.startsWith("glow3:")) {
                                       var62 = 11;
                                       var66 = var66.substring("glow3:".length());
                                    } else if(client.field298 != 0) {
                                       if(var26.startsWith("yellow:")) {
                                          var62 = 0;
                                          var66 = var66.substring("yellow:".length());
                                       } else if(var26.startsWith("red:")) {
                                          var62 = 1;
                                          var66 = var66.substring("red:".length());
                                       } else if(var26.startsWith("green:")) {
                                          var62 = 2;
                                          var66 = var66.substring("green:".length());
                                       } else if(var26.startsWith("cyan:")) {
                                          var62 = 3;
                                          var66 = var66.substring("cyan:".length());
                                       } else if(var26.startsWith("purple:")) {
                                          var62 = 4;
                                          var66 = var66.substring("purple:".length());
                                       } else if(var26.startsWith("white:")) {
                                          var62 = 5;
                                          var66 = var66.substring("white:".length());
                                       } else if(var26.startsWith("flash1:")) {
                                          var62 = 6;
                                          var66 = var66.substring("flash1:".length());
                                       } else if(var26.startsWith("flash2:")) {
                                          var62 = 7;
                                          var66 = var66.substring("flash2:".length());
                                       } else if(var26.startsWith("flash3:")) {
                                          var62 = 8;
                                          var66 = var66.substring("flash3:".length());
                                       } else if(var26.startsWith("glow1:")) {
                                          var62 = 9;
                                          var66 = var66.substring("glow1:".length());
                                       } else if(var26.startsWith("glow2:")) {
                                          var62 = 10;
                                          var66 = var66.substring("glow2:".length());
                                       } else if(var26.startsWith("glow3:")) {
                                          var62 = 11;
                                          var66 = var66.substring("glow3:".length());
                                       }
                                    }

                                    var26 = var66.toLowerCase();
                                    byte var70 = 0;
                                    if(var26.startsWith("wave:")) {
                                       var70 = 1;
                                       var66 = var66.substring("wave:".length());
                                    } else if(var26.startsWith("wave2:")) {
                                       var70 = 2;
                                       var66 = var66.substring("wave2:".length());
                                    } else if(var26.startsWith("shake:")) {
                                       var70 = 3;
                                       var66 = var66.substring("shake:".length());
                                    } else if(var26.startsWith("scroll:")) {
                                       var70 = 4;
                                       var66 = var66.substring("scroll:".length());
                                    } else if(var26.startsWith("slide:")) {
                                       var70 = 5;
                                       var66 = var66.substring("slide:".length());
                                    } else if(0 != client.field298) {
                                       if(var26.startsWith("wave:")) {
                                          var70 = 1;
                                          var66 = var66.substring("wave:".length());
                                       } else if(var26.startsWith("wave2:")) {
                                          var70 = 2;
                                          var66 = var66.substring("wave2:".length());
                                       } else if(var26.startsWith("shake:")) {
                                          var70 = 3;
                                          var66 = var66.substring("shake:".length());
                                       } else if(var26.startsWith("scroll:")) {
                                          var70 = 4;
                                          var66 = var66.substring("scroll:".length());
                                       } else if(var26.startsWith("slide:")) {
                                          var70 = 5;
                                          var66 = var66.substring("slide:".length());
                                       }
                                    }

                                    client.field301.method2753(246);
                                    client.field301.method2497(0);
                                    var49 = client.field301.field1979;
                                    client.field301.method2497(var16);
                                    client.field301.method2497(var62);
                                    client.field301.method2497(var70);
                                    class123.method2790(client.field301, var66);
                                    client.field301.method2509(client.field301.field1979 - var49);
                                    continue;
                                 }

                                 if(var24 == 5009) {
                                    var6 -= 2;
                                    var66 = class36.field803[var6];
                                    var34 = class36.field803[1 + var6];
                                    client.field301.method2753(253);
                                    client.field301.method2498(0);
                                    var17 = client.field301.field1979;
                                    client.field301.method2503(var66);
                                    class123.method2790(client.field301, var34);
                                    client.field301.method2508(client.field301.field1979 - var17);
                                    continue;
                                 }

                                 if(5015 == var24) {
                                    if(class151.field2253 != null && class151.field2253.field40 != null) {
                                       var66 = class151.field2253.field40;
                                    } else {
                                       var66 = "";
                                    }

                                    class36.field803[var6++] = var66;
                                    continue;
                                 }

                                 if(5016 == var24) {
                                    class36.field802[var5++] = client.field482;
                                    continue;
                                 }

                                 if(5017 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class124.method2802(var63);
                                    continue;
                                 }

                                 if(5018 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class77.method1724(var63);
                                    continue;
                                 }

                                 if(5019 == var24) {
                                    --var5;
                                    var63 = class36.field802[var5];
                                    class36.field802[var5++] = class11.method167(var63);
                                    continue;
                                 }

                                 if(var24 == 5020) {
                                    --var6;
                                    var66 = class36.field803[var6];
                                    if(var66.equalsIgnoreCase("toggleroof")) {
                                       class89.field1548.field131 = !class89.field1548.field131;
                                       class108.method2430();
                                       if(class89.field1548.field131) {
                                          class137.method2943(99, "", "Roofs are now all hidden");
                                       } else {
                                          class137.method2943(99, "", "Roofs will only be removed selectively");
                                       }
                                    }

                                    if(var66.equalsIgnoreCase("displayfps")) {
                                       client.field309 = !client.field309;
                                    }

                                    if(client.field460 >= 2) {
                                       if(var66.equalsIgnoreCase("fpson")) {
                                          client.field309 = true;
                                       }

                                       if(var66.equalsIgnoreCase("fpsoff")) {
                                          client.field309 = false;
                                       }

                                       if(var66.equalsIgnoreCase("gc")) {
                                          System.gc();
                                       }

                                       if(var66.equalsIgnoreCase("clientdrop")) {
                                          if(client.field345 > 0) {
                                             class212.method3982();
                                          } else {
                                             class1.method9(40);
                                             class133.field2069 = class178.field2912;
                                             class178.field2912 = null;
                                          }
                                       }

                                       if(var66.equalsIgnoreCase("errortest") && client.field295 == 2) {
                                          throw new RuntimeException();
                                       }
                                    }

                                    client.field301.method2753(218);
                                    client.field301.method2497(var66.length() + 1);
                                    client.field301.method2503(var66);
                                    continue;
                                 }

                                 if(var24 == 5021) {
                                    --var6;
                                    client.field514 = class36.field803[var6].toLowerCase().trim();
                                    continue;
                                 }

                                 if(5022 == var24) {
                                    class36.field803[var6++] = client.field514;
                                    continue;
                                 }
                              }
                           }
                        } else {
                           if(var24 >= 2000) {
                              var24 -= 1000;
                              --var5;
                              var15 = class92.method2180(class36.field802[var5]);
                           } else {
                              var15 = var38?class36.field806:class20.field584;
                           }

                           if(1300 == var24) {
                              --var5;
                              var16 = class36.field802[var5] - 1;
                              if(var16 >= 0 && var16 <= 9) {
                                 --var6;
                                 var15.method3454(var16, class36.field803[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var24 == 1301) {
                              var5 -= 2;
                              var16 = class36.field802[var5];
                              var17 = class36.field802[var5 + 1];
                              var15.field2816 = class13.method183(var16, var17);
                              continue;
                           }

                           if(1302 == var24) {
                              --var5;
                              var15.field2754 = class36.field802[var5] == 1;
                              continue;
                           }

                           if(1303 == var24) {
                              --var5;
                              var15.field2732 = class36.field802[var5];
                              continue;
                           }

                           if(var24 == 1304) {
                              --var5;
                              var15.field2818 = class36.field802[var5];
                              continue;
                           }

                           if(1305 == var24) {
                              --var6;
                              var15.field2814 = class36.field803[var6];
                              continue;
                           }

                           if(var24 == 1306) {
                              --var6;
                              var15.field2820 = class36.field803[var6];
                              continue;
                           }

                           if(var24 == 1307) {
                              var15.field2815 = null;
                              continue;
                           }
                        }
                     } else {
                        if(var24 >= 2000) {
                           var24 -= 1000;
                           --var5;
                           var15 = class92.method2180(class36.field802[var5]);
                        } else {
                           var15 = var38?class36.field806:class20.field584;
                        }

                        class36.method745(var15);
                        if(1200 == var24 || var24 == 1205 || var24 == 1212) {
                           var5 -= 2;
                           var16 = class36.field802[var5];
                           var17 = class36.field802[var5 + 1];
                           var15.field2834 = var16;
                           var15.field2862 = var17;
                           class51 var27 = class75.method1648(var16);
                           var15.field2792 = var27.field1141;
                           var15.field2802 = var27.field1122;
                           var15.field2794 = var27.field1149;
                           var15.field2790 = var27.field1124;
                           var15.field2793 = var27.field1125;
                           var15.field2795 = var27.field1127;
                           if(1205 == var24) {
                              var15.field2839 = 0;
                           } else if(1212 == var24 | var27.field1126 == 1) {
                              var15.field2839 = 1;
                           } else {
                              var15.field2839 = 2;
                           }

                           if(var15.field2796 > 0) {
                              var15.field2795 = var15.field2795 * 32 / var15.field2796;
                           } else if(var15.field2783 > 0) {
                              var15.field2795 = var15.field2795 * 32 / var15.field2783;
                           }
                           continue;
                        }

                        if(var24 == 1201) {
                           var15.field2784 = 2;
                           --var5;
                           var15.field2846 = class36.field802[var5];
                           continue;
                        }

                        if(1202 == var24) {
                           var15.field2784 = 3;
                           var15.field2846 = class151.field2253.field43.method3521();
                           continue;
                        }
                     }
                  } else {
                     var16 = -1;
                     if(var24 >= 2000) {
                        var24 -= 1000;
                        --var5;
                        var16 = class36.field802[var5];
                        var15 = class92.method2180(var16);
                     } else {
                        var15 = var38?class36.field806:class20.field584;
                     }

                     if(var24 == 1100) {
                        var5 -= 2;
                        var15.field2803 = class36.field802[var5];
                        if(var15.field2803 > var15.field2766 - var15.field2752) {
                           var15.field2803 = var15.field2766 - var15.field2752;
                        }

                        if(var15.field2803 < 0) {
                           var15.field2803 = 0;
                        }

                        var15.field2765 = class36.field802[var5 + 1];
                        if(var15.field2765 > var15.field2813 - var15.field2759) {
                           var15.field2765 = var15.field2813 - var15.field2759;
                        }

                        if(var15.field2765 < 0) {
                           var15.field2765 = 0;
                        }

                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1101) {
                        --var5;
                        var15.field2768 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1102) {
                        --var5;
                        var15.field2772 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(1103 == var24) {
                        --var5;
                        var15.field2773 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1104) {
                        --var5;
                        var15.field2804 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(1105 == var24) {
                        --var5;
                        var15.field2776 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(1106 == var24) {
                        --var5;
                        var15.field2779 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1107) {
                        --var5;
                        var15.field2821 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(1108 == var24) {
                        var15.field2784 = 1;
                        --var5;
                        var15.field2846 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1109) {
                        var5 -= 6;
                        var15.field2790 = class36.field802[var5];
                        var15.field2793 = class36.field802[1 + var5];
                        var15.field2792 = class36.field802[2 + var5];
                        var15.field2802 = class36.field802[var5 + 3];
                        var15.field2794 = class36.field802[var5 + 4];
                        var15.field2795 = class36.field802[var5 + 5];
                        class36.method745(var15);
                        continue;
                     }

                     if(1110 == var24) {
                        --var5;
                        var17 = class36.field802[var5];
                        if(var17 != var15.field2788) {
                           var15.field2788 = var17;
                           var15.field2808 = 0;
                           var15.field2864 = 0;
                           class36.method745(var15);
                        }
                        continue;
                     }

                     if(1111 == var24) {
                        --var5;
                        var15.field2817 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1112) {
                        --var6;
                        var26 = class36.field803[var6];
                        if(!var26.equals(var15.field2778)) {
                           var15.field2778 = var26;
                           class36.method745(var15);
                        }
                        continue;
                     }

                     if(1113 == var24) {
                        --var5;
                        var15.field2831 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1114) {
                        var5 -= 3;
                        var15.field2819 = class36.field802[var5];
                        var15.field2866 = class36.field802[var5 + 1];
                        var15.field2741 = class36.field802[2 + var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(1115 == var24) {
                        --var5;
                        var15.field2785 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(1116 == var24) {
                        --var5;
                        var15.field2780 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1117) {
                        --var5;
                        var15.field2781 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1118) {
                        --var5;
                        var15.field2861 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(var24 == 1119) {
                        --var5;
                        var15.field2843 = class36.field802[var5] == 1;
                        class36.method745(var15);
                        continue;
                     }

                     if(1120 == var24) {
                        var5 -= 2;
                        var15.field2766 = class36.field802[var5];
                        var15.field2813 = class36.field802[var5 + 1];
                        class36.method745(var15);
                        if(var16 != -1 && 0 == var15.field2764) {
                           class1.method14(class172.field2850[var16 >> 16], var15, false);
                        }
                        continue;
                     }

                     if(1121 == var24) {
                        var17 = var15.field2800 * -1;
                        var18 = var15.field2744;
                        client.field301.method2753(159);
                        client.field301.method2652(var17);
                        client.field301.method2545(var18);
                        client.field431 = var15;
                        class36.method745(var15);
                        continue;
                     }

                     if(1122 == var24) {
                        --var5;
                        var15.field2777 = class36.field802[var5];
                        class36.method745(var15);
                        continue;
                     }
                  }
               }

               if(var24 < 5400) {
                  if(var24 == 5306) {
                     var91 = class36.field802;
                     var16 = var5++;
                     var17 = client.field508?2:1;
                     var91[var16] = var17;
                     continue;
                  }

                  if(var24 == 5307) {
                     --var5;
                     var63 = class36.field802[var5];
                     if(1 != var63 && var63 != 2) {
                        continue;
                     }

                     client.field507 = 0L;
                     if(var63 >= 2) {
                        client.field508 = true;
                     } else {
                        client.field508 = false;
                     }

                     class83.method1910();
                     if(client.field552 >= 25) {
                        client.field301.method2753(78);
                        class121 var89 = client.field301;
                        var17 = client.field508?2:1;
                        var89.method2497(var17);
                        client.field301.method2498(class6.field107);
                        client.field301.method2498(class31.field749);
                     }

                     class143.field2190 = true;
                     continue;
                  }

                  if(var24 == 5308) {
                     class36.field802[var5++] = class89.field1548.field133;
                     continue;
                  }

                  if(5309 == var24) {
                     --var5;
                     var63 = class36.field802[var5];
                     if(var63 == 1 || 2 == var63) {
                        class89.field1548.field133 = var63;
                        class108.method2430();
                     }
                     continue;
                  }
               }

               if(var24 < 5600) {
                  if(var24 == 5504) {
                     var5 -= 2;
                     var63 = class36.field802[var5];
                     var16 = class36.field802[var5 + 1];
                     if(!client.field542) {
                        client.field554 = var63;
                        client.field495 = var16;
                     }
                     continue;
                  }

                  if(var24 == 5505) {
                     class36.field802[var5++] = client.field554;
                     continue;
                  }

                  if(var24 == 5506) {
                     class36.field802[var5++] = client.field495;
                     continue;
                  }

                  if(var24 == 5530) {
                     --var5;
                     var63 = class36.field802[var5];
                     if(var63 < 0) {
                        var63 = 0;
                     }

                     client.field333 = var63;
                     continue;
                  }

                  if(5531 == var24) {
                     class36.field802[var5++] = client.field333;
                     continue;
                  }
               }

               if(var24 < 5700 && var24 == 5630) {
                  client.field345 = 250;
               } else {
                  if(var24 < 6300) {
                     if(var24 == 6200) {
                        var5 -= 2;
                        client.field441 = (short)class36.field802[var5];
                        if(client.field441 <= 0) {
                           client.field441 = 256;
                        }

                        client.field550 = (short)class36.field802[1 + var5];
                        if(client.field550 <= 0) {
                           client.field550 = 205;
                        }
                        continue;
                     }

                     if(6201 == var24) {
                        var5 -= 2;
                        client.field551 = (short)class36.field802[var5];
                        if(client.field551 <= 0) {
                           client.field551 = 256;
                        }

                        client.field457 = (short)class36.field802[1 + var5];
                        if(client.field457 <= 0) {
                           client.field457 = 320;
                        }
                        continue;
                     }

                     if(6202 == var24) {
                        var5 -= 4;
                        client.field553 = (short)class36.field802[var5];
                        if(client.field553 <= 0) {
                           client.field553 = 1;
                        }

                        client.field372 = (short)class36.field802[1 + var5];
                        if(client.field372 <= 0) {
                           client.field372 = 32767;
                        } else if(client.field372 < client.field553) {
                           client.field372 = client.field553;
                        }

                        client.field325 = (short)class36.field802[2 + var5];
                        if(client.field325 <= 0) {
                           client.field325 = 1;
                        }

                        client.field556 = (short)class36.field802[3 + var5];
                        if(client.field556 <= 0) {
                           client.field556 = 32767;
                        } else if(client.field556 < client.field325) {
                           client.field556 = client.field325;
                        }
                        continue;
                     }

                     if(6203 == var24) {
                        if(client.field465 != null) {
                           class12.method175(0, 0, client.field465.field2752, client.field465.field2759, false);
                           class36.field802[var5++] = client.field559;
                           class36.field802[var5++] = client.field560;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = -1;
                        }
                        continue;
                     }

                     if(var24 == 6204) {
                        class36.field802[var5++] = client.field551;
                        class36.field802[var5++] = client.field457;
                        continue;
                     }

                     if(6205 == var24) {
                        class36.field802[var5++] = client.field441;
                        class36.field802[var5++] = client.field550;
                        continue;
                     }
                  }

                  if(var24 < 6600) {
                     if(var24 == 6500) {
                        class36.field802[var5++] = class5.method99()?1:0;
                        continue;
                     }

                     class25 var92;
                     if(6501 == var24) {
                        class25.field640 = 0;
                        var92 = class49.method1031();
                        if(null != var92) {
                           class36.field802[var5++] = var92.field638;
                           class36.field802[var5++] = var92.field639;
                           class36.field803[var6++] = var92.field643;
                           class36.field802[var5++] = var92.field644;
                           class36.field802[var5++] = var92.field635;
                           class36.field803[var6++] = var92.field630;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                        }
                        continue;
                     }

                     if(var24 == 6502) {
                        var92 = class49.method1031();
                        if(null != var92) {
                           class36.field802[var5++] = var92.field638;
                           class36.field802[var5++] = var92.field639;
                           class36.field803[var6++] = var92.field643;
                           class36.field802[var5++] = var92.field644;
                           class36.field802[var5++] = var92.field635;
                           class36.field803[var6++] = var92.field630;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                        }
                        continue;
                     }

                     class25 var86;
                     if(6506 == var24) {
                        --var5;
                        var63 = class36.field802[var5];
                        var86 = null;

                        for(var17 = 0; var17 < class25.field634; ++var17) {
                           if(class25.field633[var17].field638 == var63) {
                              var86 = class25.field633[var17];
                              break;
                           }
                        }

                        if(null != var86) {
                           class36.field802[var5++] = var86.field638;
                           class36.field802[var5++] = var86.field639;
                           class36.field803[var6++] = var86.field643;
                           class36.field802[var5++] = var86.field644;
                           class36.field802[var5++] = var86.field635;
                           class36.field803[var6++] = var86.field630;
                        } else {
                           class36.field802[var5++] = -1;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                           class36.field802[var5++] = 0;
                           class36.field802[var5++] = 0;
                           class36.field803[var6++] = "";
                        }
                        continue;
                     }

                     if(6507 == var24) {
                        var5 -= 4;
                        var63 = class36.field802[var5];
                        var36 = 1 == class36.field802[1 + var5];
                        var17 = class36.field802[2 + var5];
                        var55 = 1 == class36.field802[3 + var5];
                        if(null != class25.field633) {
                           class14.method188(0, class25.field633.length - 1, var63, var36, var17, var55);
                        }
                        continue;
                     }

                     if(var24 == 6511) {
                        --var5;
                        var63 = class36.field802[var5];
                        if(var63 >= 0 && var63 < class25.field634) {
                           var86 = class25.field633[var63];
                           class36.field802[var5++] = var86.field638;
                           class36.field802[var5++] = var86.field639;
                           class36.field803[var6++] = var86.field643;
                           class36.field802[var5++] = var86.field644;
                           class36.field802[var5++] = var86.field635;
                           class36.field803[var6++] = var86.field630;
                           continue;
                        }

                        class36.field802[var5++] = -1;
                        class36.field802[var5++] = 0;
                        class36.field803[var6++] = "";
                        class36.field802[var5++] = 0;
                        class36.field802[var5++] = 0;
                        class36.field803[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var23) {
            StringBuilder var12 = new StringBuilder(30);
            var12.append("").append(var4.field3111).append(" ");

            for(var13 = class36.field804 - 1; var13 >= 0; --var13) {
               var12.append("").append(class36.field797[var13].field213.field3111).append(" ");
            }

            var12.append("").append(var10);
            class28.method651(var12.toString(), var23);
         }
      }
   }
}
