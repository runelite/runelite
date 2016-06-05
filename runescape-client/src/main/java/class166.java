import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class166 {
   @ObfuscatedName("ch")
   static class146 field2699;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("processLoop")
   static final void method3217() {
      if(client.field300 > 1) {
         --client.field300;
      }

      if(client.field335 > 0) {
         --client.field335;
      }

      if(client.field336) {
         client.field336 = false;
         class141.method2953();
      } else {
         if(!client.field423) {
            client.field429[0] = "Cancel";
            client.field337[0] = "";
            client.field392[0] = 1006;
            client.field294 = 1;
         }

         int var0;
         int var2;
         int var3;
         int var4;
         int var7;
         int var11;
         String var13;
         class173 var25;
         int var26;
         class173 var28;
         String var31;
         int var36;
         int var59;
         long var60;
         int var62;
         boolean var63;
         String var66;
         int var71;
         int var100;
         int var110;
         for(var0 = 0; var0 < 100; ++var0) {
            boolean var1;
            if(null == class51.field1112) {
               var1 = false;
            } else {
               label3246: {
                  String var24;
                  try {
                     var2 = class51.field1112.method2980();
                     if(var2 == 0) {
                        var1 = false;
                        break label3246;
                     }

                     if(client.field329 == -1) {
                        class51.field1112.method2963(client.field327.field2001, 0, 1);
                        client.field327.field2000 = 0;
                        client.field329 = client.field327.method2728();
                        client.field328 = class188.field3059[client.field329];
                        --var2;
                     }

                     if(client.field328 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3246;
                        }

                        class51.field1112.method2963(client.field327.field2001, 0, 1);
                        client.field328 = client.field327.field2001[0] & 255;
                        --var2;
                     }

                     if(client.field328 == -2) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3246;
                        }

                        class51.field1112.method2963(client.field327.field2001, 0, 2);
                        client.field327.field2000 = 0;
                        client.field328 = client.field327.method2470();
                        var2 -= 2;
                     }

                     if(var2 < client.field328) {
                        var1 = false;
                        break label3246;
                     }

                     client.field327.field2000 = 0;
                     class51.field1112.method2963(client.field327.field2001, 0, client.field328);
                     client.field481 = 0;
                     client.field334 = client.field333;
                     client.field333 = client.field390;
                     client.field390 = client.field329;
                     class173 var5;
                     if(client.field329 == 73) {
                        var3 = client.field327.method2513();
                        var4 = client.field327.method2504();
                        var5 = class170.method3344(var3);
                        if(var5.field2871 != 1 || var4 != var5.field2829) {
                           var5.field2871 = 1;
                           var5.field2829 = var4;
                           class20.method547(var5);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 45) {
                        class38.field872 = client.field327.method2613();
                        class143.field2222 = client.field327.method2494();

                        for(var3 = class38.field872; var3 < 8 + class38.field872; ++var3) {
                           for(var4 = class143.field2222; var4 < 8 + class143.field2222; ++var4) {
                              if(null != client.field415[class32.field754][var3][var4]) {
                                 client.field415[class32.field754][var3][var4] = null;
                                 class3.method35(var3, var4);
                              }
                           }
                        }

                        for(class16 var84 = (class16)client.field542.method3797(); var84 != null; var84 = (class16)client.field542.method3779()) {
                           if(var84.field226 >= class38.field872 && var84.field226 < 8 + class38.field872 && var84.field227 >= class143.field2222 && var84.field227 < class143.field2222 + 8 && class32.field754 == var84.field229) {
                              var84.field235 = 0;
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 245) {
                        class38.field872 = client.field327.method2494();
                        class143.field2222 = client.field327.method2494();
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 152) {
                        client.field301 = client.field327.method2494();
                        if(client.field301 == 1) {
                           client.field406 = client.field327.method2470();
                        }

                        if(client.field301 >= 2 && client.field301 <= 6) {
                           if(client.field301 == 2) {
                              client.field307 = 64;
                              client.field523 = 64;
                           }

                           if(client.field301 == 3) {
                              client.field307 = 0;
                              client.field523 = 64;
                           }

                           if(client.field301 == 4) {
                              client.field307 = 128;
                              client.field523 = 64;
                           }

                           if(client.field301 == 5) {
                              client.field307 = 64;
                              client.field523 = 0;
                           }

                           if(client.field301 == 6) {
                              client.field307 = 64;
                              client.field523 = 128;
                           }

                           client.field301 = 2;
                           client.field304 = client.field327.method2470();
                           client.field305 = client.field327.method2470();
                           client.field306 = client.field327.method2494();
                        }

                        if(client.field301 == 10) {
                           client.field506 = client.field327.method2470();
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 175) {
                        var24 = client.field327.method2476();
                        Object[] var95 = new Object[var24.length() + 1];

                        for(var26 = var24.length() - 1; var26 >= 0; --var26) {
                           if(var24.charAt(var26) == 115) {
                              var95[var26 + 1] = client.field327.method2476();
                           } else {
                              var95[var26 + 1] = new Integer(client.field327.method2505());
                           }
                        }

                        var95[0] = new Integer(client.field327.method2505());
                        class0 var74 = new class0();
                        var74.field5 = var95;
                        class171.method3363(var74);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     long var8;
                     if(client.field329 == 156) {
                        var3 = client.field327.method2513();
                        var4 = client.field327.method2505();
                        var26 = client.field327.method2470();
                        if(var26 == '\uffff') {
                           var26 = -1;
                        }

                        var59 = client.field327.method2646();
                        if(var59 == '\uffff') {
                           var59 = -1;
                        }

                        for(var7 = var26; var7 <= var59; ++var7) {
                           var8 = (long)var7 + ((long)var4 << 32);
                           class208 var67 = client.field428.method3748(var8);
                           if(null != var67) {
                              var67.method3870();
                           }

                           client.field428.method3749(new class201(var3), var8);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 164) {
                        class15.method160();
                        client.field448 = client.field327.method2638();
                        client.field479 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     class173 var65;
                     class3 var106;
                     if(client.field329 == 252) {
                        var3 = client.field327.field2000 + client.field328;
                        var4 = client.field327.method2470();
                        var26 = client.field327.method2470();
                        if(client.field442 != var4) {
                           client.field442 = var4;
                           class140.method2945(false);
                           var59 = client.field442;
                           if(class173.method3380(var59)) {
                              class173[] var103 = class216.field3168[var59];

                              for(var62 = 0; var62 < var103.length; ++var62) {
                                 var65 = var103[var62];
                                 if(var65 != null) {
                                    var65.field2898 = 0;
                                    var65.field2767 = 0;
                                 }
                              }
                           }

                           class93.method2123(client.field442);

                           for(var7 = 0; var7 < 100; ++var7) {
                              client.field396[var7] = true;
                           }
                        }

                        class3 var69;
                        for(; var26-- > 0; var69.field66 = true) {
                           var59 = client.field327.method2505();
                           var7 = client.field327.method2470();
                           var62 = client.field327.method2494();
                           var69 = (class3)client.field443.method3748((long)var59);
                           if(var69 != null && var7 != var69.field65) {
                              class44.method912(var69, true);
                              var69 = null;
                           }

                           if(var69 == null) {
                              var69 = class39.method785(var59, var7, var62);
                           }
                        }

                        for(var106 = (class3)client.field443.method3751(); var106 != null; var106 = (class3)client.field443.method3752()) {
                           if(var106.field66) {
                              var106.field66 = false;
                           } else {
                              class44.method912(var106, true);
                           }
                        }

                        client.field428 = new class196(512);

                        while(client.field327.field2000 < var3) {
                           var59 = client.field327.method2505();
                           var7 = client.field327.method2470();
                           var62 = client.field327.method2470();
                           var100 = client.field327.method2505();

                           for(var110 = var7; var110 <= var62; ++var110) {
                              long var70 = ((long)var59 << 32) + (long)var110;
                              client.field428.method3749(new class201(var100), var70);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 138) {
                        client.field500 = client.field327.method2494();
                        client.field501 = client.field327.method2494();
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     String var54;
                     if(client.field329 == 155) {
                        var3 = client.field327.method2613();
                        var4 = client.field327.method2613();
                        var54 = client.field327.method2476();
                        if(var3 >= 1 && var3 <= 8) {
                           if(var54.equalsIgnoreCase("null")) {
                              var54 = null;
                           }

                           client.field461[var3 - 1] = var54;
                           client.field412[var3 - 1] = var4 == 0;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     String var81;
                     if(client.field329 == 184) {
                        var24 = client.field327.method2476();
                        var81 = class223.method3967(class16.method161(class191.method3709(client.field327)));
                        class33.method702(6, var24, var81);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     boolean var56;
                     String var92;
                     if(client.field329 == 80) {
                        while(client.field327.field2000 < client.field328) {
                           var3 = client.field327.method2494();
                           var56 = (var3 & 1) == 1;
                           var54 = client.field327.method2476();
                           var92 = client.field327.method2476();
                           client.field327.method2476();

                           for(var7 = 0; var7 < client.field553; ++var7) {
                              class7 var117 = client.field400[var7];
                              if(var56) {
                                 if(var92.equals(var117.field135)) {
                                    var117.field135 = var54;
                                    var117.field134 = var92;
                                    var5 = null;
                                    break;
                                 }
                              } else if(var54.equals(var117.field135)) {
                                 var117.field135 = var54;
                                 var117.field134 = var92;
                                 var5 = null;
                                 break;
                              }
                           }
                        }

                        client.field475 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 214) {
                        var3 = client.field327.method2513();
                        var4 = client.field327.method2638();
                        var5 = class170.method3344(var3);
                        if(var5.field2893 != var4 || var4 == -1) {
                           var5.field2893 = var4;
                           var5.field2898 = 0;
                           var5.field2767 = 0;
                           class20.method547(var5);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 143) {
                        var3 = client.field327.method2514();
                        var56 = client.field327.method2494() == 1;
                        var5 = class170.method3344(var3);
                        if(var5.field2875 != var56) {
                           var5.field2875 = var56;
                           class20.method547(var5);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 130) {
                        class15.method160();
                        client.field531 = client.field327.method2494();
                        client.field479 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 76) {
                        class143.field2222 = client.field327.method2613();
                        class38.field872 = client.field327.method2623();

                        while(client.field327.field2000 < client.field328) {
                           client.field329 = client.field327.method2494();
                           class155.method3133();
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 236) {
                        class131.field2079 = class6.method68(client.field327.method2494());
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     int var15;
                     int var75;
                     if(client.field329 == 237) {
                        class122 var83 = client.field327;
                        var4 = client.field328;
                        class210 var68 = new class210();
                        var68.field3135 = var83.method2494();
                        var68.field3131 = var83.method2505();
                        var68.field3130 = new int[var68.field3135];
                        var68.field3134 = new int[var68.field3135];
                        var68.field3133 = new Field[var68.field3135];
                        var68.field3132 = new int[var68.field3135];
                        var68.field3136 = new Method[var68.field3135];
                        var68.field3137 = new byte[var68.field3135][][];

                        for(var59 = 0; var59 < var68.field3135; ++var59) {
                           try {
                              var7 = var83.method2494();
                              if(var7 != 0 && var7 != 1 && var7 != 2) {
                                 if(var7 == 3 || var7 == 4) {
                                    var31 = var83.method2476();
                                    var66 = var83.method2476();
                                    var110 = var83.method2494();
                                    String[] var116 = new String[var110];

                                    for(var71 = 0; var71 < var110; ++var71) {
                                       var116[var71] = var83.method2476();
                                    }

                                    String var118 = var83.method2476();
                                    byte[][] var73 = new byte[var110][];
                                    if(var7 == 3) {
                                       for(var75 = 0; var75 < var110; ++var75) {
                                          var15 = var83.method2505();
                                          var73[var75] = new byte[var15];
                                          var83.method2479(var73[var75], 0, var15);
                                       }
                                    }

                                    var68.field3130[var59] = var7;
                                    Class[] var120 = new Class[var110];

                                    for(var15 = 0; var15 < var110; ++var15) {
                                       var120[var15] = class5.method67(var116[var15]);
                                    }

                                    Class var122 = class5.method67(var118);
                                    if(class5.method67(var31).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    Method[] var78 = class5.method67(var31).getDeclaredMethods();
                                    Method[] var17 = var78;

                                    for(int var18 = 0; var18 < var17.length; ++var18) {
                                       Method var19 = var17[var18];
                                       if(var19.getName().equals(var66)) {
                                          Class[] var20 = var19.getParameterTypes();
                                          if(var120.length == var20.length) {
                                             boolean var21 = true;

                                             for(int var22 = 0; var22 < var120.length; ++var22) {
                                                if(var120[var22] != var20[var22]) {
                                                   var21 = false;
                                                   break;
                                                }
                                             }

                                             if(var21 && var122 == var19.getReturnType()) {
                                                var68.field3136[var59] = var19;
                                             }
                                          }
                                       }
                                    }

                                    var68.field3137[var59] = var73;
                                 }
                              } else {
                                 var31 = var83.method2476();
                                 var66 = var83.method2476();
                                 var110 = 0;
                                 if(var7 == 1) {
                                    var110 = var83.method2505();
                                 }

                                 var68.field3130[var59] = var7;
                                 var68.field3132[var59] = var110;
                                 if(class5.method67(var31).getClassLoader() == null) {
                                    throw new SecurityException();
                                 }

                                 var68.field3133[var59] = class5.method67(var31).getDeclaredField(var66);
                              }
                           } catch (ClassNotFoundException var46) {
                              var68.field3134[var59] = -1;
                           } catch (SecurityException var47) {
                              var68.field3134[var59] = -2;
                           } catch (NullPointerException var48) {
                              var68.field3134[var59] = -3;
                           } catch (Exception var49) {
                              var68.field3134[var59] = -4;
                           } catch (Throwable var50) {
                              var68.field3134[var59] = -5;
                           }
                        }

                        class211.field3141.method3815(var68);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 16) {
                        class28.method639();

                        for(var3 = 0; var3 < 2048; ++var3) {
                           client.field405[var3] = null;
                        }

                        class164.method3188(client.field327);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 50) {
                        client.field549 = client.field327.method2494();
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 234) {
                        class15.method160();
                        var3 = client.field327.method2494();
                        var4 = client.field327.method2505();
                        var26 = client.field327.method2494();
                        client.field421[var3] = var4;
                        client.field303[var3] = var26;
                        client.field420[var3] = 1;

                        for(var59 = 0; var59 < 98; ++var59) {
                           if(var4 >= class155.field2324[var59]) {
                              client.field420[var3] = 2 + var59;
                           }
                        }

                        client.field472[++client.field473 - 1 & 31] = var3;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 140) {
                        var3 = client.field327.method2545();
                        var4 = client.field327.method2512();
                        var5 = class170.method3344(var4);
                        if(var5.field2871 != 2 || var3 != var5.field2829) {
                           var5.field2871 = 2;
                           var5.field2829 = var3;
                           class20.method547(var5);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 96) {
                        var3 = client.field327.method2646();
                        byte var77 = client.field327.method2497();
                        class176.field2924[var3] = var77;
                        if(var77 != class176.field2923[var3]) {
                           class176.field2923[var3] = var77;
                        }

                        class76.method1635(var3);
                        client.field512[++client.field469 - 1 & 31] = var3;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 123) {
                        var3 = client.field327.method2545();
                        var4 = client.field327.method2613();
                        var26 = client.field327.method2514();
                        var106 = (class3)client.field443.method3748((long)var26);
                        if(null != var106) {
                           class44.method912(var106, var106.field65 != var3);
                        }

                        class39.method785(var26, var3, var4);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 206) {
                        var3 = client.field327.method2505();
                        var4 = client.field327.method2470();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var5 = class170.method3344(var3);
                        } else {
                           var5 = null;
                        }

                        if(null != var5) {
                           for(var59 = 0; var59 < var5.field2849.length; ++var59) {
                              var5.field2849[var59] = 0;
                              var5.field2868[var59] = 0;
                           }
                        }

                        class15 var113 = (class15)class15.field222.method3748((long)var4);
                        if(var113 != null) {
                           for(var7 = 0; var7 < var113.field220.length; ++var7) {
                              var113.field220[var7] = -1;
                              var113.field221[var7] = 0;
                           }
                        }

                        var59 = client.field327.method2470();

                        for(var7 = 0; var7 < var59; ++var7) {
                           var62 = client.field327.method2504();
                           var100 = client.field327.method2494();
                           if(var100 == 255) {
                              var100 = client.field327.method2505();
                           }

                           if(var5 != null && var7 < var5.field2849.length) {
                              var5.field2849[var7] = var62;
                              var5.field2868[var7] = var100;
                           }

                           class46.method949(var4, var7, var62 - 1, var100);
                        }

                        if(null != var5) {
                           class20.method547(var5);
                        }

                        class15.method160();
                        client.field470[++client.field386 - 1 & 31] = var4 & 32767;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 89) {
                        client.field382 = client.field467;
                        if(client.field328 == 0) {
                           client.field282 = null;
                           client.field510 = null;
                           class19.field274 = 0;
                           class19.field278 = null;
                           client.field329 = -1;
                           var1 = true;
                        } else {
                           client.field510 = client.field327.method2476();
                           long var79 = client.field327.method2474();
                           client.field282 = class76.method1631(var79);
                           class74.field1375 = client.field327.method2469();
                           var26 = client.field327.method2494();
                           if(var26 == 255) {
                              client.field329 = -1;
                              var1 = true;
                           } else {
                              class19.field274 = var26;
                              class24[] var111 = new class24[100];

                              for(var7 = 0; var7 < class19.field274; ++var7) {
                                 var111[var7] = new class24();
                                 var111[var7].field622 = client.field327.method2476();
                                 var111[var7].field621 = class36.method723(var111[var7].field622, class96.field1641);
                                 var111[var7].field615 = client.field327.method2470();
                                 var111[var7].field616 = client.field327.method2469();
                                 client.field327.method2476();
                                 if(var111[var7].field622.equals(class152.field2301.field39)) {
                                    class72.field1356 = var111[var7].field616;
                                 }
                              }

                              var63 = false;
                              var100 = class19.field274;

                              while(var100 > 0) {
                                 var63 = true;
                                 --var100;

                                 for(var110 = 0; var110 < var100; ++var110) {
                                    if(var111[var110].field621.compareTo(var111[var110 + 1].field621) > 0) {
                                       class24 var115 = var111[var110];
                                       var111[var110] = var111[1 + var110];
                                       var111[var110 + 1] = var115;
                                       var63 = false;
                                    }
                                 }

                                 if(var63) {
                                    break;
                                 }
                              }

                              class19.field278 = var111;
                              client.field329 = -1;
                              var1 = true;
                           }
                        }
                        break label3246;
                     }

                     if(client.field329 == 75) {
                        client.field530 = false;

                        for(var3 = 0; var3 < 5; ++var3) {
                           client.field486[var3] = false;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 34) {
                        var3 = client.field327.method2646();
                        class15 var91 = (class15)class15.field222.method3748((long)var3);
                        if(null != var91) {
                           var91.method3870();
                        }

                        client.field470[++client.field386 - 1 & 31] = var3 & 32767;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 18) {
                        class215.method3894(false);
                        client.field327.method2728();
                        var3 = client.field327.method2470();
                        class111.method2391(client.field327, var3);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 94) {
                        var3 = client.field327.method2505();
                        var4 = client.field327.method2470();
                        if(var3 < -70000) {
                           var4 += '耀';
                        }

                        if(var3 >= 0) {
                           var5 = class170.method3344(var3);
                        } else {
                           var5 = null;
                        }

                        for(; client.field327.field2000 < client.field328; class46.method949(var4, var59, var7 - 1, var62)) {
                           var59 = client.field327.method2481();
                           var7 = client.field327.method2470();
                           var62 = 0;
                           if(var7 != 0) {
                              var62 = client.field327.method2494();
                              if(var62 == 255) {
                                 var62 = client.field327.method2505();
                              }
                           }

                           if(var5 != null && var59 >= 0 && var59 < var5.field2849.length) {
                              var5.field2849[var59] = var7;
                              var5.field2868[var59] = var62;
                           }
                        }

                        if(null != var5) {
                           class20.method547(var5);
                        }

                        class15.method160();
                        client.field470[++client.field386 - 1 & 31] = var4 & 32767;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 235) {
                        var3 = client.field327.method2505();
                        class3 var88 = (class3)client.field443.method3748((long)var3);
                        if(null != var88) {
                           class44.method912(var88, true);
                        }

                        if(null != client.field399) {
                           class20.method547(client.field399);
                           client.field399 = null;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 88) {
                        var3 = client.field327.method2638();
                        var4 = client.field327.method2547();
                        var26 = client.field327.method2514();
                        var28 = class170.method3344(var26);
                        if(var28.field2815 != var3 || var28.field2786 != var4 || var28.field2781 != 0 || var28.field2782 != 0) {
                           var28.field2815 = var3;
                           var28.field2786 = var4;
                           var28.field2781 = 0;
                           var28.field2782 = 0;
                           class20.method547(var28);
                           class15.method159(var28);
                           if(var28.field2778 == 0) {
                              class46.method935(class216.field3168[var26 >> 16], var28, false);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     boolean var6;
                     if(client.field329 == 222) {
                        var24 = client.field327.method2476();
                        var4 = client.field327.method2470();
                        byte var108 = client.field327.method2469();
                        var6 = false;
                        if(var108 == -128) {
                           var6 = true;
                        }

                        if(var6) {
                           if(class19.field274 == 0) {
                              client.field329 = -1;
                              var1 = true;
                              break label3246;
                           }

                           var63 = false;

                           for(var7 = 0; var7 < class19.field274 && (!class19.field278[var7].field622.equals(var24) || var4 != class19.field278[var7].field615); ++var7) {
                              ;
                           }

                           if(var7 < class19.field274) {
                              while(var7 < class19.field274 - 1) {
                                 class19.field278[var7] = class19.field278[var7 + 1];
                                 ++var7;
                              }

                              --class19.field274;
                              class19.field278[class19.field274] = null;
                           }
                        } else {
                           client.field327.method2476();
                           class24 var99 = new class24();
                           var99.field622 = var24;
                           var99.field621 = class36.method723(var99.field622, class96.field1641);
                           var99.field615 = var4;
                           var99.field616 = var108;

                           for(var62 = class19.field274 - 1; var62 >= 0; --var62) {
                              var100 = class19.field278[var62].field621.compareTo(var99.field621);
                              if(var100 == 0) {
                                 class19.field278[var62].field615 = var4;
                                 class19.field278[var62].field616 = var108;
                                 if(var24.equals(class152.field2301.field39)) {
                                    class72.field1356 = var108;
                                 }

                                 client.field382 = client.field467;
                                 client.field329 = -1;
                                 var1 = true;
                                 break label3246;
                              }

                              if(var100 < 0) {
                                 break;
                              }
                           }

                           if(class19.field274 >= class19.field278.length) {
                              client.field329 = -1;
                              var1 = true;
                              break label3246;
                           }

                           for(var100 = class19.field274 - 1; var100 > var62; --var100) {
                              class19.field278[var100 + 1] = class19.field278[var100];
                           }

                           if(class19.field274 == 0) {
                              class19.field278 = new class24[100];
                           }

                           class19.field278[1 + var62] = var99;
                           ++class19.field274;
                           if(var24.equals(class152.field2301.field39)) {
                              class72.field1356 = var108;
                           }
                        }

                        client.field382 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     long var12;
                     long var107;
                     if(client.field329 == 168) {
                        var3 = client.field327.method2505();
                        var4 = client.field327.method2505();
                        if(null == class116.field1989 || !class116.field1989.isValid()) {
                           try {
                              Iterator var61 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var61.hasNext()) {
                                 GarbageCollectorMXBean var109 = (GarbageCollectorMXBean)var61.next();
                                 if(var109.isValid()) {
                                    class116.field1989 = var109;
                                    client.field561 = -1L;
                                    client.field476 = -1L;
                                 }
                              }
                           } catch (Throwable var45) {
                              ;
                           }
                        }

                        long var105 = class124.method2746();
                        var7 = -1;
                        if(class116.field1989 != null) {
                           var8 = class116.field1989.getCollectionTime();
                           if(client.field476 != -1L) {
                              var107 = var8 - client.field476;
                              var12 = var105 - client.field561;
                              if(0L != var12) {
                                 var7 = (int)(var107 * 100L / var12);
                              }
                           }

                           client.field476 = var8;
                           client.field561 = var105;
                        }

                        client.field325.method2733(71);
                        client.field325.method2594(class144.field2224);
                        client.field325.method2488(var7);
                        client.field325.method2510(var3);
                        client.field325.method2509(var4);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 69) {
                        var3 = client.field327.method2504();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        class40.method827(var3);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 180) {
                        var3 = client.field327.method2646();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        var4 = client.field327.method2464();
                        class24.method576(var3, var4);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 240) {
                        var3 = client.field327.method2646();
                        var4 = client.field327.method2514();
                        var26 = var3 >> 10 & 31;
                        var59 = var3 >> 5 & 31;
                        var7 = var3 & 31;
                        var62 = (var7 << 3) + (var59 << 11) + (var26 << 19);
                        var65 = class170.method3344(var4);
                        if(var62 != var65.field2797) {
                           var65.field2797 = var62;
                           class20.method547(var65);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 188) {
                        client.field522 = 1;
                        client.field475 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 118) {
                        client.field327.field2000 += 28;
                        if(client.field327.method2490()) {
                           class122.method2732(client.field327, client.field327.field2000 - 28);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 141) {
                        client.field530 = true;
                        class48.field1096 = client.field327.method2494();
                        class84.field1464 = client.field327.method2494();
                        class9.field156 = client.field327.method2470();
                        class144.field2230 = client.field327.method2494();
                        class134.field2095 = client.field327.method2494();
                        if(class134.field2095 >= 100) {
                           var3 = 64 + class48.field1096 * 128;
                           var4 = class84.field1464 * 128 + 64;
                           var26 = class14.method147(var3, var4, class32.field754) - class9.field156;
                           var59 = var3 - class9.field155;
                           var7 = var26 - class13.field205;
                           var62 = var4 - class4.field81;
                           var100 = (int)Math.sqrt((double)(var62 * var62 + var59 * var59));
                           class138.field2164 = (int)(Math.atan2((double)var7, (double)var100) * 325.949D) & 2047;
                           class19.field269 = (int)(Math.atan2((double)var59, (double)var62) * -325.949D) & 2047;
                           if(class138.field2164 < 128) {
                              class138.field2164 = 128;
                           }

                           if(class138.field2164 > 383) {
                              class138.field2164 = 383;
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 233) {
                        var3 = client.field327.method2470();
                        var4 = client.field327.method2494();
                        var26 = client.field327.method2470();
                        if(client.field560 != 0 && var4 != 0 && client.field524 < 50) {
                           client.field525[client.field524] = var3;
                           client.field319[client.field524] = var4;
                           client.field527[client.field524] = var26;
                           client.field529[client.field524] = null;
                           client.field532[client.field524] = 0;
                           ++client.field524;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     class173 var94;
                     if(client.field329 == 161) {
                        var3 = client.field327.method2512();
                        var4 = client.field327.method2512();
                        class3 var58 = (class3)client.field443.method3748((long)var3);
                        var106 = (class3)client.field443.method3748((long)var4);
                        if(var106 != null) {
                           class44.method912(var106, var58 == null || var58.field65 != var106.field65);
                        }

                        if(null != var58) {
                           var58.method3870();
                           client.field443.method3749(var58, (long)var4);
                        }

                        var94 = class170.method3344(var3);
                        if(null != var94) {
                           class20.method547(var94);
                        }

                        var94 = class170.method3344(var4);
                        if(null != var94) {
                           class20.method547(var94);
                           class46.method935(class216.field3168[var94.field2776 >>> 16], var94, true);
                        }

                        if(client.field442 != -1) {
                           var62 = client.field442;
                           if(class173.method3380(var62)) {
                              class13.method140(class216.field3168[var62], 1);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 205) {
                        var3 = client.field327.method2646();
                        var4 = client.field327.method2513();
                        var26 = client.field327.method2470();
                        var59 = client.field327.method2646();
                        var94 = class170.method3344(var4);
                        if(var94.field2789 != var59 || var26 != var94.field2798 || var94.field2830 != var3) {
                           var94.field2789 = var59;
                           var94.field2798 = var26;
                           var94.field2830 = var3;
                           class20.method547(var94);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 176) {
                        for(var3 = 0; var3 < class176.field2923.length; ++var3) {
                           if(class176.field2924[var3] != class176.field2923[var3]) {
                              class176.field2923[var3] = class176.field2924[var3];
                              class76.method1635(var3);
                              client.field512[++client.field469 - 1 & 31] = var3;
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 126) {
                        for(var3 = 0; var3 < class52.field1168; ++var3) {
                           class52 var85 = class21.method557(var3);
                           if(var85 != null) {
                              class176.field2924[var3] = 0;
                              class176.field2923[var3] = 0;
                           }
                        }

                        class15.method160();
                        client.field469 += 32;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 33) {
                        for(var3 = 0; var3 < client.field405.length; ++var3) {
                           if(client.field405[var3] != null) {
                              client.field405[var3].field834 = -1;
                           }
                        }

                        for(var3 = 0; var3 < client.field320.length; ++var3) {
                           if(client.field320[var3] != null) {
                              client.field320[var3].field834 = -1;
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 60) {
                        var3 = client.field327.method2512();
                        var25 = class170.method3344(var3);

                        for(var26 = 0; var26 < var25.field2849.length; ++var26) {
                           var25.field2849[var26] = -1;
                           var25.field2849[var26] = 0;
                        }

                        class20.method547(var25);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     String var16;
                     int var37;
                     long var57;
                     if(client.field329 == 124) {
                        var24 = client.field327.method2476();
                        var60 = (long)client.field327.method2470();
                        var57 = (long)client.field327.method2472();
                        class152[] var114 = new class152[]{class152.field2299, class152.field2294, class152.field2293, class152.field2290, class152.field2291};
                        class152 var64 = (class152)class30.method651(var114, client.field327.method2494());
                        var107 = (var60 << 32) + var57;
                        boolean var72 = false;

                        for(var36 = 0; var36 < 100; ++var36) {
                           if(var107 == client.field487[var36]) {
                              var72 = true;
                              break;
                           }
                        }

                        if(class19.method202(var24)) {
                           var72 = true;
                        }

                        if(!var72 && client.field404 == 0) {
                           client.field487[client.field504] = var107;
                           client.field504 = (1 + client.field504) % 100;
                           var13 = class223.method3967(class16.method161(class191.method3709(client.field327)));
                           byte var76;
                           if(var64.field2297) {
                              var76 = 7;
                           } else {
                              var76 = 3;
                           }

                           if(var64.field2296 != -1) {
                              var37 = var64.field2296;
                              var16 = "<img=" + var37 + ">";
                              class33.method702(var76, var16 + var24, var13);
                           } else {
                              class33.method702(var76, var24, var13);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     boolean var55;
                     if(client.field329 == 37) {
                        var55 = client.field327.method2494() == 1;
                        if(var55) {
                           client.field559 = class124.method2746() - client.field327.method2474();
                           class140.field2179 = new class221(client.field327, true);
                        } else {
                           class140.field2179 = null;
                        }

                        client.field537 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 148) {
                        var3 = client.field327.method2513();
                        var81 = client.field327.method2476();
                        var5 = class170.method3344(var3);
                        if(!var81.equals(var5.field2832)) {
                           var5.field2832 = var81;
                           class20.method547(var5);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 10) {
                        client.field545 = client.field327.method2494();
                        if(client.field545 == 255) {
                           client.field545 = 0;
                        }

                        client.field517 = client.field327.method2494();
                        if(client.field517 == 255) {
                           client.field517 = 0;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 90) {
                        class38.method745(false);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 59) {
                        var3 = client.field327.method2646();
                        if(var3 == '\uffff') {
                           var3 = -1;
                        }

                        var4 = client.field327.method2505();
                        var26 = client.field327.method2505();
                        var28 = class170.method3344(var26);
                        class51 var89;
                        if(!var28.field2775) {
                           if(var3 == -1) {
                              var28.field2871 = 0;
                              client.field329 = -1;
                              var1 = true;
                              break label3246;
                           }

                           var89 = class123.method2743(var3);
                           var28.field2871 = 4;
                           var28.field2829 = var3;
                           var28.field2789 = var89.field1126;
                           var28.field2798 = var89.field1127;
                           var28.field2830 = var89.field1111 * 100 / var4;
                           class20.method547(var28);
                        } else {
                           var28.field2896 = var3;
                           var28.field2897 = var4;
                           var89 = class123.method2743(var3);
                           var28.field2789 = var89.field1126;
                           var28.field2798 = var89.field1127;
                           var28.field2799 = var89.field1144;
                           var28.field2843 = var89.field1110;
                           var28.field2826 = var89.field1130;
                           var28.field2830 = var89.field1111;
                           if(var89.field1131 == 1) {
                              var28.field2834 = 1;
                           } else {
                              var28.field2834 = 2;
                           }

                           if(var28.field2865 > 0) {
                              var28.field2830 = var28.field2830 * 32 / var28.field2865;
                           } else if(var28.field2787 > 0) {
                              var28.field2830 = var28.field2830 * 32 / var28.field2787;
                           }

                           class20.method547(var28);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 203 || client.field329 == 171 || client.field329 == 208 || client.field329 == 58 || client.field329 == 79 || client.field329 == 44 || client.field329 == 100 || client.field329 == 0 || client.field329 == 251 || client.field329 == 38) {
                        class155.method3133();
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 92) {
                        class111.method2391(client.field327, client.field328);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 98) {
                        while(client.field327.field2000 < client.field328) {
                           var55 = client.field327.method2494() == 1;
                           var81 = client.field327.method2476();
                           var54 = client.field327.method2476();
                           var59 = client.field327.method2470();
                           var7 = client.field327.method2494();
                           var62 = client.field327.method2494();
                           boolean var98 = (var62 & 2) != 0;
                           boolean var30 = (var62 & 1) != 0;
                           if(var59 > 0) {
                              client.field327.method2476();
                              client.field327.method2494();
                              client.field327.method2505();
                           }

                           client.field327.method2476();

                           for(var11 = 0; var11 < client.field418; ++var11) {
                              class17 var33 = client.field551[var11];
                              if(!var55) {
                                 if(var81.equals(var33.field239)) {
                                    if(var59 != var33.field249) {
                                       boolean var123 = true;

                                       for(class38 var34 = (class38)client.field552.method3735(); var34 != null; var34 = (class38)client.field552.method3737()) {
                                          if(var34.field865.equals(var81)) {
                                             if(var59 != 0 && var34.field867 == 0) {
                                                var34.method3861();
                                                var123 = false;
                                             } else if(var59 == 0 && var34.field867 != 0) {
                                                var34.method3861();
                                                var123 = false;
                                             }
                                          }
                                       }

                                       if(var123) {
                                          client.field552.method3739(new class38(var81, var59));
                                       }

                                       var33.field249 = var59;
                                    }

                                    var33.field238 = var54;
                                    var33.field237 = var7;
                                    var33.field241 = var98;
                                    var33.field242 = var30;
                                    var25 = null;
                                    break;
                                 }
                              } else if(var54.equals(var33.field239)) {
                                 var33.field239 = var81;
                                 var33.field238 = var54;
                                 var25 = null;
                                 break;
                              }
                           }
                        }

                        client.field522 = 2;
                        client.field475 = client.field467;
                        var55 = false;
                        var4 = client.field418;

                        while(var4 > 0) {
                           var55 = true;
                           --var4;

                           for(var26 = 0; var26 < var4; ++var26) {
                              var6 = false;
                              class17 var86 = client.field551[var26];
                              class17 var112 = client.field551[var26 + 1];
                              if(var86.field249 != client.field478 && var112.field249 == client.field478) {
                                 var6 = true;
                              }

                              if(!var6 && var86.field249 == 0 && var112.field249 != 0) {
                                 var6 = true;
                              }

                              if(!var6 && !var86.field241 && var112.field241) {
                                 var6 = true;
                              }

                              if(!var6 && !var86.field242 && var112.field242) {
                                 var6 = true;
                              }

                              if(var6) {
                                 class17 var9 = client.field551[var26];
                                 client.field551[var26] = client.field551[var26 + 1];
                                 client.field551[1 + var26] = var9;
                                 var55 = false;
                              }
                           }

                           if(var55) {
                              break;
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 11) {
                        class38.method745(true);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 112) {
                        if(client.field442 != -1) {
                           var3 = client.field442;
                           if(class173.method3380(var3)) {
                              class13.method140(class216.field3168[var3], 0);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 253) {
                        client.field530 = true;
                        class95.field1636 = client.field327.method2494();
                        class28.field672 = client.field327.method2494();
                        class96.field1644 = client.field327.method2470();
                        class152.field2300 = client.field327.method2494();
                        class9.field151 = client.field327.method2494();
                        if(class9.field151 >= 100) {
                           class9.field155 = class95.field1636 * 128 + 64;
                           class4.field81 = class28.field672 * 128 + 64;
                           class13.field205 = class14.method147(class9.field155, class4.field81, class32.field754) - class96.field1644;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 166) {
                        class215.method3894(true);
                        client.field327.method2728();
                        var3 = client.field327.method2470();
                        class111.method2391(client.field327, var3);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 192) {
                        var3 = client.field327.method2513();
                        class139.field2168 = class77.field1400.method2857(var3);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 23) {
                        var3 = client.field327.method2504();
                        client.field442 = var3;
                        class140.method2945(false);
                        if(class173.method3380(var3)) {
                           class173[] var82 = class216.field3168[var3];

                           for(var26 = 0; var26 < var82.length; ++var26) {
                              var28 = var82[var26];
                              if(var28 != null) {
                                 var28.field2898 = 0;
                                 var28.field2767 = 0;
                              }
                           }
                        }

                        class93.method2123(client.field442);

                        for(var4 = 0; var4 < 100; ++var4) {
                           client.field396[var4] = true;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     String var27;
                     if(client.field329 == 204) {
                        var24 = client.field327.method2476();
                        client.field289 = var24;

                        try {
                           var81 = client.field280.getParameter(class190.field3077.field3067);
                           var54 = client.field280.getParameter(class190.field3078.field3067);
                           var92 = var81 + "settings=" + var24 + "; version=1; path=/; domain=" + var54;
                           if(var24.length() == 0) {
                              var92 = var92 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                           } else {
                              var27 = var92 + "; Expires=";
                              long var29 = class124.method2746() + 94608000000L;
                              class111.field1963.setTime(new Date(var29));
                              var11 = class111.field1963.get(7);
                              var71 = class111.field1963.get(5);
                              var36 = class111.field1963.get(2);
                              var75 = class111.field1963.get(1);
                              var15 = class111.field1963.get(11);
                              int var38 = class111.field1963.get(12);
                              var37 = class111.field1963.get(13);
                              var31 = class111.field1958[var11 - 1] + ", " + var71 / 10 + var71 % 10 + "-" + class111.field1965[0][var36] + "-" + var75 + " " + var15 / 10 + var15 % 10 + ":" + var38 / 10 + var38 % 10 + ":" + var37 / 10 + var37 % 10 + " GMT";
                              var92 = var27 + var31 + "; Max-Age=" + 94608000L;
                           }

                           class132.method2820(client.field280, "document.cookie=\"" + var92 + "\"");
                        } catch (Throwable var43) {
                           ;
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 212) {
                        class25 var80 = new class25();
                        var80.field640 = client.field327.method2476();
                        var80.field637 = client.field327.method2470();
                        var4 = client.field327.method2505();
                        var80.field645 = var4;
                        class2.method14(45);
                        class51.field1112.method2960();
                        class51.field1112 = null;
                        class75.method1598(var80);
                        client.field329 = -1;
                        var1 = false;
                        break label3246;
                     }

                     if(client.field329 == 87) {
                        class211.method3879();
                        client.field329 = -1;
                        var1 = false;
                        break label3246;
                     }

                     if(client.field329 == 182) {
                        var3 = client.field327.method2494();
                        var4 = client.field327.method2494();
                        var26 = client.field327.method2494();
                        var59 = client.field327.method2494();
                        client.field486[var3] = true;
                        client.field281[var3] = var4;
                        client.field533[var3] = var26;
                        client.field534[var3] = var59;
                        client.field466[var3] = 0;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 91) {
                        var24 = client.field327.method2476();
                        var60 = client.field327.method2474();
                        var57 = (long)client.field327.method2470();
                        var8 = (long)client.field327.method2472();
                        class152[] var10 = new class152[]{class152.field2299, class152.field2294, class152.field2293, class152.field2290, class152.field2291};
                        class152 var32 = (class152)class30.method651(var10, client.field327.method2494());
                        var12 = (var57 << 32) + var8;
                        boolean var14 = false;

                        for(var15 = 0; var15 < 100; ++var15) {
                           if(var12 == client.field487[var15]) {
                              var14 = true;
                              break;
                           }
                        }

                        if(var32.field2298 && class19.method202(var24)) {
                           var14 = true;
                        }

                        if(!var14 && client.field404 == 0) {
                           client.field487[client.field504] = var12;
                           client.field504 = (client.field504 + 1) % 100;
                           String var35 = class223.method3967(class16.method161(class191.method3709(client.field327)));
                           if(var32.field2296 != -1) {
                              var37 = var32.field2296;
                              var16 = "<img=" + var37 + ">";
                              client.method325(9, var16 + var24, var35, class2.method34(var60));
                           } else {
                              client.method325(9, var24, var35, class2.method34(var60));
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 244) {
                        var3 = client.field327.method2505();
                        var4 = client.field327.method2646();
                        var26 = client.field327.method2470();
                        var28 = class170.method3344(var3);
                        var28.field2869 = (var26 << 16) + var4;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 191) {
                        var3 = client.field327.method2481();
                        var56 = client.field327.method2494() == 1;
                        var54 = "";
                        var6 = false;
                        if(var56) {
                           var54 = client.field327.method2476();
                           if(class19.method202(var54)) {
                              var6 = true;
                           }
                        }

                        var27 = client.field327.method2476();
                        if(!var6) {
                           class33.method702(var3, var54, var27);
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 99) {
                        var3 = client.field327.method2513();
                        var4 = client.field327.method2470();
                        var5 = class170.method3344(var3);
                        if(null != var5 && var5.field2778 == 0) {
                           if(var4 > var5.field2823 - var5.field2792) {
                              var4 = var5.field2823 - var5.field2792;
                           }

                           if(var4 < 0) {
                              var4 = 0;
                           }

                           if(var5.field2861 != var4) {
                              var5.field2861 = var4;
                              class20.method547(var5);
                           }
                        }

                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 216) {
                        var3 = client.field327.method2494();
                        if(client.field327.method2494() == 0) {
                           client.field558[var3] = new class220();
                           client.field327.field2000 += 18;
                        } else {
                           --client.field327.field2000;
                           client.field558[var3] = new class220(client.field327, false);
                        }

                        client.field477 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 174) {
                        var3 = client.field327.method2545();
                        var4 = client.field327.method2512();
                        class176.field2924[var3] = var4;
                        if(class176.field2923[var3] != var4) {
                           class176.field2923[var3] = var4;
                        }

                        class76.method1635(var3);
                        client.field512[++client.field469 - 1 & 31] = var3;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 52) {
                        client.field300 = client.field327.method2646() * 30;
                        client.field479 = client.field467;
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     if(client.field329 == 25) {
                        var3 = client.field327.method2505();
                        var25 = class170.method3344(var3);
                        var25.field2871 = 3;
                        var25.field2829 = class152.field2301.field59.method3438();
                        class20.method547(var25);
                        client.field329 = -1;
                        var1 = true;
                        break label3246;
                     }

                     class30.method654("" + client.field329 + "," + client.field333 + "," + client.field334 + "," + client.field328, (Throwable)null);
                     class211.method3879();
                  } catch (IOException var51) {
                     class141.method2953();
                  } catch (Exception var52) {
                     var24 = "" + client.field329 + "," + client.field333 + "," + client.field334 + "," + client.field328 + "," + (class89.field1565 + class152.field2301.field847[0]) + "," + (class152.field2301.field839[0] + client.field358) + ",";

                     for(var4 = 0; var4 < client.field328 && var4 < 50; ++var4) {
                        var24 = var24 + client.field327.field2001[var4] + ",";
                     }

                     class30.method654(var24, var52);
                     class211.method3879();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(client.field462 == 30) {
            while(class109.method2382()) {
               client.field325.method2733(49);
               client.field325.method2453(0);
               var0 = client.field325.field2000;
               class1.method4(client.field325);
               client.field325.method2465(client.field325.field2000 - var0);
            }

            Object var40 = class47.field1082.field204;
            int var102;
            synchronized(class47.field1082.field204) {
               if(!client.field413) {
                  class47.field1082.field206 = 0;
               } else if(class140.field2185 != 0 || class47.field1082.field206 >= 40) {
                  client.field325.method2733(171);
                  client.field325.method2453(0);
                  var102 = client.field325.field2000;
                  var2 = 0;

                  for(var3 = 0; var3 < class47.field1082.field206 && client.field325.field2000 - var102 < 240; ++var3) {
                     ++var2;
                     var4 = class47.field1082.field202[var3];
                     if(var4 < 0) {
                        var4 = 0;
                     } else if(var4 > 502) {
                        var4 = 502;
                     }

                     var26 = class47.field1082.field201[var3];
                     if(var26 < 0) {
                        var26 = 0;
                     } else if(var26 > 764) {
                        var26 = 764;
                     }

                     var59 = var4 * 765 + var26;
                     if(class47.field1082.field202[var3] == -1 && class47.field1082.field201[var3] == -1) {
                        var26 = -1;
                        var4 = -1;
                        var59 = 524287;
                     }

                     if(client.field295 == var26 && client.field296 == var4) {
                        if(client.field297 < 2047) {
                           ++client.field297;
                        }
                     } else {
                        var7 = var26 - client.field295;
                        client.field295 = var26;
                        var62 = var4 - client.field296;
                        client.field296 = var4;
                        if(client.field297 < 8 && var7 >= -32 && var7 <= 31 && var62 >= -32 && var62 <= 31) {
                           var7 += 32;
                           var62 += 32;
                           client.field325.method2454((var7 << 6) + (client.field297 << 12) + var62);
                           client.field297 = 0;
                        } else if(client.field297 < 8) {
                           client.field325.method2455(8388608 + (client.field297 << 19) + var59);
                           client.field297 = 0;
                        } else {
                           client.field325.method2456(var59 + (client.field297 << 19) + -1073741824);
                           client.field297 = 0;
                        }
                     }
                  }

                  client.field325.method2465(client.field325.field2000 - var102);
                  if(var2 >= class47.field1082.field206) {
                     class47.field1082.field206 = 0;
                  } else {
                     class47.field1082.field206 -= var2;

                     for(var3 = 0; var3 < class47.field1082.field206; ++var3) {
                        class47.field1082.field201[var3] = class47.field1082.field201[var2 + var3];
                        class47.field1082.field202[var3] = class47.field1082.field202[var2 + var3];
                     }
                  }
               }
            }

            if(class140.field2185 == 1 || !class101.field1755 && class140.field2185 == 4 || class140.field2185 == 2) {
               long var53 = (class140.field2188 - client.field308) / 50L;
               if(var53 > 4095L) {
                  var53 = 4095L;
               }

               client.field308 = class140.field2188;
               var2 = class140.field2187;
               if(var2 < 0) {
                  var2 = 0;
               } else if(var2 > class41.field966) {
                  var2 = class41.field966;
               }

               var3 = class140.field2190;
               if(var3 < 0) {
                  var3 = 0;
               } else if(var3 > class10.field162) {
                  var3 = class10.field162;
               }

               var4 = (int)var53;
               client.field325.method2733(150);
               client.field325.method2454((var4 << 1) + (class140.field2185 == 2?1:0));
               client.field325.method2454(var3);
               client.field325.method2454(var2);
            }

            if(class137.field2149 > 0) {
               client.field325.method2733(164);
               client.field325.method2454(0);
               var0 = client.field325.field2000;
               long var104 = class124.method2746();

               for(var3 = 0; var3 < class137.field2149; ++var3) {
                  var60 = var104 - client.field508;
                  if(var60 > 16777215L) {
                     var60 = 16777215L;
                  }

                  client.field508 = var104;
                  client.field325.method2507((int)var60);
                  client.field325.method2488(class137.field2146[var3]);
               }

               client.field325.method2471(client.field325.field2000 - var0);
            }

            if(client.field383 > 0) {
               --client.field383;
            }

            if(class137.field2133[96] || class137.field2133[97] || class137.field2133[98] || class137.field2133[99]) {
               client.field497 = true;
            }

            if(client.field497 && client.field383 <= 0) {
               client.field383 = 20;
               client.field497 = false;
               client.field325.method2733(203);
               client.field325.method2502(client.field367);
               client.field325.method2501(client.field302);
            }

            if(class28.field670 && !client.field298) {
               client.field298 = true;
               client.field325.method2733(145);
               client.field325.method2453(1);
            }

            if(!class28.field670 && client.field298) {
               client.field298 = false;
               client.field325.method2733(145);
               client.field325.method2453(0);
            }

            class89.method2047();
            if(client.field462 == 30) {
               for(class16 var127 = (class16)client.field542.method3797(); null != var127; var127 = (class16)client.field542.method3779()) {
                  if(var127.field235 > 0) {
                     --var127.field235;
                  }

                  if(var127.field235 == 0) {
                     if(var127.field224 < 0 || class38.method744(var127.field224, var127.field228)) {
                        class30.method652(var127.field229, var127.field230, var127.field226, var127.field227, var127.field224, var127.field233, var127.field228);
                        var127.method3870();
                     }
                  } else {
                     if(var127.field234 > 0) {
                        --var127.field234;
                     }

                     if(var127.field234 == 0 && var127.field226 >= 1 && var127.field227 >= 1 && var127.field226 <= 102 && var127.field227 <= 102 && (var127.field231 < 0 || class38.method744(var127.field231, var127.field225))) {
                        class30.method652(var127.field229, var127.field230, var127.field226, var127.field227, var127.field231, var127.field232, var127.field225);
                        var127.field234 = -1;
                        if(var127.field231 == var127.field224 && var127.field224 == -1) {
                           var127.method3870();
                        } else if(var127.field224 == var127.field231 && var127.field233 == var127.field232 && var127.field228 == var127.field225) {
                           var127.method3870();
                        }
                     }
                  }
               }

               for(var0 = 0; var0 < client.field524; ++var0) {
                  --client.field527[var0];
                  if(client.field527[var0] >= -10) {
                     class58 var41 = client.field529[var0];
                     if(null == var41) {
                        class58 var133 = (class58)null;
                        var41 = class58.method1206(class42.field1000, client.field525[var0], 0);
                        if(null == var41) {
                           continue;
                        }

                        client.field527[var0] += var41.method1214();
                        client.field529[var0] = var41;
                     }

                     if(client.field527[var0] < 0) {
                        if(client.field532[var0] != 0) {
                           var3 = 128 * (client.field532[var0] & 255);
                           var4 = client.field532[var0] >> 16 & 255;
                           var26 = var4 * 128 + 64 - class152.field2301.field809;
                           if(var26 < 0) {
                              var26 = -var26;
                           }

                           var59 = client.field532[var0] >> 8 & 255;
                           var7 = 64 + 128 * var59 - class152.field2301.field804;
                           if(var7 < 0) {
                              var7 = -var7;
                           }

                           var62 = var7 + var26 - 128;
                           if(var62 > var3) {
                              client.field527[var0] = -100;
                              continue;
                           }

                           if(var62 < 0) {
                              var62 = 0;
                           }

                           var2 = (var3 - var62) * client.field374 / var3;
                        } else {
                           var2 = client.field560;
                        }

                        if(var2 > 0) {
                           class62 var87 = var41.method1207().method1239(class51.field1164);
                           class64 var97 = class64.method1263(var87, 100, var2);
                           var97.method1266(client.field319[var0] - 1);
                           class129.field2065.method1094(var97);
                        }

                        client.field527[var0] = -100;
                     }
                  } else {
                     --client.field524;

                     for(var102 = var0; var102 < client.field524; ++var102) {
                        client.field525[var102] = client.field525[1 + var102];
                        client.field529[var102] = client.field529[1 + var102];
                        client.field319[var102] = client.field319[1 + var102];
                        client.field527[var102] = client.field527[1 + var102];
                        client.field532[var102] = client.field532[var102 + 1];
                     }

                     --var0;
                  }
               }

               if(client.field521 && !class95.method2150()) {
                  if(client.field519 != 0 && client.field520 != -1) {
                     class101.method2235(class103.field1783, client.field520, 0, client.field519, false);
                  }

                  client.field521 = false;
               }

               ++client.field481;
               if(client.field481 > 750) {
                  class141.method2953();
               } else {
                  var0 = class32.field741;
                  int[] var131 = class32.field742;

                  for(var2 = 0; var2 < var0; ++var2) {
                     class2 var90 = client.field405[var131[var2]];
                     if(var90 != null) {
                        class42.method877(var90, 1);
                     }
                  }

                  for(var0 = 0; var0 < client.field293; ++var0) {
                     var102 = client.field322[var0];
                     class34 var39 = client.field320[var102];
                     if(var39 != null) {
                        class42.method877(var39, var39.field772.field881);
                     }
                  }

                  int[] var128 = class32.field742;

                  for(var102 = 0; var102 < class32.field741; ++var102) {
                     class2 var124 = client.field405[var128[var102]];
                     if(var124 != null && var124.field842 > 0) {
                        --var124.field842;
                        if(var124.field842 == 0) {
                           var124.field816 = null;
                        }
                     }
                  }

                  for(var102 = 0; var102 < client.field293; ++var102) {
                     var2 = client.field322[var102];
                     class34 var93 = client.field320[var2];
                     if(var93 != null && var93.field842 > 0) {
                        --var93.field842;
                        if(var93.field842 == 0) {
                           var93.field816 = null;
                        }
                     }
                  }

                  ++client.field330;
                  if(client.field394 != 0) {
                     client.field393 += 20;
                     if(client.field393 >= 400) {
                        client.field394 = 0;
                     }
                  }

                  if(null != client.field291) {
                     ++client.field564;
                     if(client.field564 >= 15) {
                        class20.method547(client.field291);
                        client.field291 = null;
                     }
                  }

                  class173 var130 = class131.field2082;
                  class173 var132 = class24.field617;
                  class131.field2082 = null;
                  class24.field617 = null;
                  client.field459 = null;
                  client.field427 = false;
                  client.field416 = false;
                  client.field505 = 0;

                  while(class131.method2811() && client.field505 < 128) {
                     if(client.field449 >= 2 && class137.field2133[82] && class137.field2142 == 66) {
                        String var125 = class20.method543();
                        class158.field2623.setContents(new StringSelection(var125), (ClipboardOwner)null);
                     } else {
                        client.field507[client.field505] = class137.field2142;
                        client.field562[client.field505] = class24.field625;
                        ++client.field505;
                     }
                  }

                  if(client.field442 != -1) {
                     client.method541(client.field442, 0, 0, class10.field162, class41.field966, 0, 0);
                  }

                  ++client.field467;

                  while(true) {
                     class173 var96;
                     class0 var126;
                     do {
                        var126 = (class0)client.field482.method3789();
                        if(var126 == null) {
                           while(true) {
                              do {
                                 var126 = (class0)client.field483.method3789();
                                 if(null == var126) {
                                    while(true) {
                                       do {
                                          var126 = (class0)client.field395.method3789();
                                          if(var126 == null) {
                                             class59.method1221();
                                             if(class6.field126 == null && null == client.field455) {
                                                var2 = class140.field2185;
                                                if(client.field423) {
                                                   if(var2 != 1 && (class101.field1755 || var2 != 4)) {
                                                      var3 = class140.field2192;
                                                      var4 = class140.field2189;
                                                      if(var3 < class40.field965 - 10 || var3 > class140.field2176 + class40.field965 + 10 || var4 < class27.field668 - 10 || var4 > 10 + class26.field653 + class27.field668) {
                                                         client.field423 = false;
                                                         class31.method675(class40.field965, class27.field668, class140.field2176, class26.field653);
                                                      }
                                                   }

                                                   if(var2 == 1 || !class101.field1755 && var2 == 4) {
                                                      var3 = class40.field965;
                                                      var4 = class27.field668;
                                                      var26 = class140.field2176;
                                                      var59 = class140.field2190;
                                                      var7 = class140.field2187;
                                                      var62 = -1;

                                                      for(var100 = 0; var100 < client.field294; ++var100) {
                                                         var110 = var4 + 31 + 15 * (client.field294 - 1 - var100);
                                                         if(var59 > var3 && var59 < var26 + var3 && var7 > var110 - 13 && var7 < 3 + var110) {
                                                            var62 = var100;
                                                         }
                                                      }

                                                      if(var62 != -1 && var62 >= 0) {
                                                         var100 = client.field425[var62];
                                                         var110 = client.field426[var62];
                                                         var11 = client.field392[var62];
                                                         var71 = client.field502[var62];
                                                         var13 = client.field429[var62];
                                                         String var121 = client.field337[var62];
                                                         class121.method2707(var100, var110, var11, var71, var13, var121, class140.field2190, class140.field2187);
                                                      }

                                                      client.field423 = false;
                                                      var100 = class40.field965;
                                                      var110 = class27.field668;
                                                      var11 = class140.field2176;
                                                      var71 = class26.field653;

                                                      for(var36 = 0; var36 < client.field485; ++var36) {
                                                         if(client.field535[var36] + client.field490[var36] > var100 && client.field490[var36] < var100 + var11 && client.field493[var36] + client.field436[var36] > var110 && client.field436[var36] < var110 + var71) {
                                                            client.field396[var36] = true;
                                                         }
                                                      }
                                                   }
                                                } else {
                                                   label3362: {
                                                      label3465: {
                                                         if((var2 == 1 || !class101.field1755 && var2 == 4) && client.field294 > 0) {
                                                            var3 = client.field392[client.field294 - 1];
                                                            if(var3 == 39 || var3 == 40 || var3 == 41 || var3 == 42 || var3 == 43 || var3 == 33 || var3 == 34 || var3 == 35 || var3 == 36 || var3 == 37 || var3 == 38 || var3 == 1005) {
                                                               var4 = client.field425[client.field294 - 1];
                                                               var26 = client.field426[client.field294 - 1];
                                                               var28 = class170.method3344(var26);
                                                               if(class171.method3362(class138.method2906(var28))) {
                                                                  break label3465;
                                                               }

                                                               var62 = class138.method2906(var28);
                                                               var63 = (var62 >> 29 & 1) != 0;
                                                               if(var63) {
                                                                  break label3465;
                                                               }
                                                            }
                                                         }

                                                         if((var2 == 1 || !class101.field1755 && var2 == 4) && (client.field422 == 1 && client.field294 > 2 || class89.method2048(client.field294 - 1))) {
                                                            var2 = 2;
                                                         }

                                                         if((var2 == 1 || !class101.field1755 && var2 == 4) && client.field294 > 0) {
                                                            var3 = client.field294 - 1;
                                                            if(var3 >= 0) {
                                                               var4 = client.field425[var3];
                                                               var26 = client.field426[var3];
                                                               var59 = client.field392[var3];
                                                               var7 = client.field502[var3];
                                                               var31 = client.field429[var3];
                                                               var66 = client.field337[var3];
                                                               class121.method2707(var4, var26, var59, var7, var31, var66, class140.field2190, class140.field2187);
                                                            }
                                                         }

                                                         if(var2 == 2 && client.field294 > 0) {
                                                            class18.method173(class140.field2190, class140.field2187);
                                                         }
                                                         break label3362;
                                                      }

                                                      if(class6.field126 != null && !client.field402 && client.field422 != 1 && !class89.method2048(client.field294 - 1) && client.field294 > 0) {
                                                         class31.method678(client.field424, client.field315);
                                                      }

                                                      client.field402 = false;
                                                      client.field440 = 0;
                                                      if(null != class6.field126) {
                                                         class20.method547(class6.field126);
                                                      }

                                                      class6.field126 = class170.method3344(var26);
                                                      client.field398 = var4;
                                                      client.field424 = class140.field2190;
                                                      client.field315 = class140.field2187;
                                                      if(client.field294 > 0) {
                                                         class127.method2787(client.field294 - 1);
                                                      }

                                                      class20.method547(class6.field126);
                                                   }
                                                }
                                             }

                                             if(null != client.field455) {
                                                class0.method0();
                                             }

                                             if(null != class6.field126) {
                                                class20.method547(class6.field126);
                                                ++client.field440;
                                                if(class140.field2178 == 0) {
                                                   if(client.field402) {
                                                      if(class6.field126 == class11.field177 && client.field401 != client.field398) {
                                                         class173 var129 = class6.field126;
                                                         byte var101 = 0;
                                                         if(client.field450 == 1 && var129.field2780 == 206) {
                                                            var101 = 1;
                                                         }

                                                         if(var129.field2849[client.field401] <= 0) {
                                                            var101 = 0;
                                                         }

                                                         if(class134.method2842(class138.method2906(var129))) {
                                                            var4 = client.field398;
                                                            var26 = client.field401;
                                                            var129.field2849[var26] = var129.field2849[var4];
                                                            var129.field2868[var26] = var129.field2868[var4];
                                                            var129.field2849[var4] = -1;
                                                            var129.field2868[var4] = 0;
                                                         } else if(var101 == 1) {
                                                            var4 = client.field398;
                                                            var26 = client.field401;

                                                            while(var4 != var26) {
                                                               if(var4 > var26) {
                                                                  var129.method3370(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var26) {
                                                                  var129.method3370(var4 + 1, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var129.method3370(client.field401, client.field398);
                                                         }

                                                         client.field325.method2733(160);
                                                         client.field325.method2488(var101);
                                                         client.field325.method2502(client.field401);
                                                         client.field325.method2502(client.field398);
                                                         client.field325.method2456(class6.field126.field2776);
                                                      }
                                                   } else if((client.field422 == 1 || class89.method2048(client.field294 - 1)) && client.field294 > 2) {
                                                      class18.method173(client.field424, client.field315);
                                                   } else if(client.field294 > 0) {
                                                      class31.method678(client.field424, client.field315);
                                                   }

                                                   client.field564 = 10;
                                                   class140.field2185 = 0;
                                                   class6.field126 = null;
                                                } else if(client.field440 >= 5 && (class140.field2192 > 5 + client.field424 || class140.field2192 < client.field424 - 5 || class140.field2189 > 5 + client.field315 || class140.field2189 < client.field315 - 5)) {
                                                   client.field402 = true;
                                                }
                                             }

                                             if(class86.field1486 != -1) {
                                                var2 = class86.field1486;
                                                var3 = class86.field1492;
                                                client.field325.method2733(44);
                                                client.field325.method2453(5);
                                                client.field325.method2492(class137.field2133[82]?(class137.field2133[81]?2:1):0);
                                                client.field325.method2500(var2 + class89.field1565);
                                                client.field325.method2454(var3 + client.field358);
                                                class86.field1486 = -1;
                                                client.field391 = class140.field2190;
                                                client.field321 = class140.field2187;
                                                client.field394 = 1;
                                                client.field393 = 0;
                                                client.field545 = var2;
                                                client.field517 = var3;
                                             }

                                             if(var130 != class131.field2082) {
                                                if(null != var130) {
                                                   class20.method547(var130);
                                                }

                                                if(class131.field2082 != null) {
                                                   class20.method547(class131.field2082);
                                                }
                                             }

                                             if(var132 != class24.field617 && client.field434 == client.field433) {
                                                if(var132 != null) {
                                                   class20.method547(var132);
                                                }

                                                if(class24.field617 != null) {
                                                   class20.method547(class24.field617);
                                                }
                                             }

                                             if(class24.field617 != null) {
                                                if(client.field433 < client.field434) {
                                                   ++client.field433;
                                                   if(client.field434 == client.field433) {
                                                      class20.method547(class24.field617);
                                                   }
                                                }
                                             } else if(client.field433 > 0) {
                                                --client.field433;
                                             }

                                             class7.method89();
                                             if(client.field530) {
                                                class130.method2793();
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field466[var2];
                                             }

                                             class106.field1879.method188();
                                             var2 = ++class140.field2174 - 1;
                                             var4 = class137.field2153;
                                             if(var2 > 15000 && var4 > 15000) {
                                                client.field335 = 250;
                                                class98.method2153(14500);
                                                client.field325.method2733(12);
                                             }

                                             ++client.field354;
                                             if(client.field354 > 500) {
                                                client.field354 = 0;
                                                var59 = (int)(Math.random() * 8.0D);
                                                if((var59 & 1) == 1) {
                                                   client.field445 += client.field349;
                                                }

                                                if((var59 & 2) == 2) {
                                                   client.field350 += client.field351;
                                                }

                                                if((var59 & 4) == 4) {
                                                   client.field352 += client.field353;
                                                }
                                             }

                                             if(client.field445 < -50) {
                                                client.field349 = 2;
                                             }

                                             if(client.field445 > 50) {
                                                client.field349 = -2;
                                             }

                                             if(client.field350 < -55) {
                                                client.field351 = 2;
                                             }

                                             if(client.field350 > 55) {
                                                client.field351 = -2;
                                             }

                                             if(client.field352 < -40) {
                                                client.field353 = 1;
                                             }

                                             if(client.field352 > 40) {
                                                client.field353 = -1;
                                             }

                                             ++client.field359;
                                             if(client.field359 > 500) {
                                                client.field359 = 0;
                                                var59 = (int)(Math.random() * 8.0D);
                                                if((var59 & 1) == 1) {
                                                   client.field355 += client.field356;
                                                }

                                                if((var59 & 2) == 2) {
                                                   client.field357 += client.field407;
                                                }
                                             }

                                             if(client.field355 < -60) {
                                                client.field356 = 2;
                                             }

                                             if(client.field355 > 60) {
                                                client.field356 = -2;
                                             }

                                             if(client.field357 < -20) {
                                                client.field407 = 1;
                                             }

                                             if(client.field357 > 10) {
                                                client.field407 = -1;
                                             }

                                             for(class38 var119 = (class38)client.field552.method3735(); null != var119; var119 = (class38)client.field552.method3737()) {
                                                if((long)var119.field870 < class124.method2746() / 1000L - 5L) {
                                                   if(var119.field867 > 0) {
                                                      class33.method702(5, "", var119.field865 + " has logged in.");
                                                   }

                                                   if(var119.field867 == 0) {
                                                      class33.method702(5, "", var119.field865 + " has logged out.");
                                                   }

                                                   var119.method3861();
                                                }
                                             }

                                             ++client.field514;
                                             if(client.field514 > 50) {
                                                client.field325.method2733(133);
                                             }

                                             try {
                                                if(null != class51.field1112 && client.field325.field2000 > 0) {
                                                   class51.field1112.method2964(client.field325.field2001, 0, client.field325.field2000);
                                                   client.field325.field2000 = 0;
                                                   client.field514 = 0;
                                                }
                                             } catch (IOException var42) {
                                                class141.method2953();
                                             }

                                             return;
                                          }

                                          var96 = var126.field2;
                                          if(var96.field2777 < 0) {
                                             break;
                                          }

                                          var25 = class170.method3344(var96.field2795);
                                       } while(var25 == null || var25.field2770 == null || var96.field2777 >= var25.field2770.length || var96 != var25.field2770[var96.field2777]);

                                       class171.method3363(var126);
                                    }
                                 }

                                 var96 = var126.field2;
                                 if(var96.field2777 < 0) {
                                    break;
                                 }

                                 var25 = class170.method3344(var96.field2795);
                              } while(null == var25 || var25.field2770 == null || var96.field2777 >= var25.field2770.length || var96 != var25.field2770[var96.field2777]);

                              class171.method3363(var126);
                           }
                        }

                        var96 = var126.field2;
                        if(var96.field2777 < 0) {
                           break;
                        }

                        var25 = class170.method3344(var96.field2795);
                     } while(null == var25 || var25.field2770 == null || var96.field2777 >= var25.field2770.length || var25.field2770[var96.field2777] != var96);

                     class171.method3363(var126);
                  }
               }
            }
         }
      }
   }
}
