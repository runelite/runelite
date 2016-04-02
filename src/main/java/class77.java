import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bx")
public abstract class class77 {
   @ObfuscatedName("h")
   public Image field1360;
   @ObfuscatedName("f")
   public int[] field1361;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -277444737
   )
   int field1362;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      longValue = 5759189669997494113L
   )
   static long field1365;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 309182205
   )
   public int field1366;
   @ObfuscatedName("o")
   static String[] field1368;
   @ObfuscatedName("aq")
   static int[] field1369;

   @ObfuscatedName("ah")
   public final void method1674() {
      class79.method1821(this.field1361, this.field1366, this.field1362);
   }

   @ObfuscatedName("w")
   public abstract void vmethod1886(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   public abstract void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-585643007"
   )
   static final void method1683() {
      if(client.field430 > 1) {
         --client.field430;
      }

      if(client.field472 > 0) {
         --client.field472;
      }

      if(client.field332) {
         client.field332 = false;
         class4.method46();
      } else {
         if(!client.field331) {
            client.field425[0] = "Cancel";
            client.field426[0] = "";
            client.field301[0] = 1006;
            client.field420 = 1;
         }

         int var0;
         boolean var1;
         int var2;
         String var3;
         int var4;
         int var5;
         int var9;
         int var10;
         int var11;
         int var12;
         int var39;
         int var46;
         int var47;
         int var51;
         class173 var52;
         long var66;
         for(var0 = 0; var0 < 100; ++var0) {
            if(class46.field1040 == null) {
               var1 = false;
            } else {
               label3717: {
                  try {
                     var2 = class46.field1040.method2985();
                     if(var2 == 0) {
                        var1 = false;
                        break label3717;
                     }

                     if(client.field325 == -1) {
                        class46.field1040.method2991(client.field323.field1980, 0, 1);
                        client.field323.field1976 = 0;
                        client.field325 = client.field323.method2766();
                        client.field324 = class188.field3029[client.field325];
                        --var2;
                     }

                     if(client.field324 == -1) {
                        if(var2 <= 0) {
                           var1 = false;
                           break label3717;
                        }

                        class46.field1040.method2991(client.field323.field1980, 0, 1);
                        client.field324 = client.field323.field1980[0] & 255;
                        --var2;
                     }

                     if(-2 == client.field324) {
                        if(var2 <= 1) {
                           var1 = false;
                           break label3717;
                        }

                        class46.field1040.method2991(client.field323.field1980, 0, 2);
                        client.field323.field1976 = 0;
                        client.field324 = client.field323.method2700();
                        var2 -= 2;
                     }

                     if(var2 < client.field324) {
                        var1 = false;
                        break label3717;
                     }

                     client.field323.field1976 = 0;
                     class46.field1040.method2991(client.field323.field1980, 0, client.field324);
                     client.field326 = 0;
                     client.field419 = client.field329;
                     client.field329 = client.field328;
                     client.field328 = client.field325;
                     class173 var118;
                     if(client.field325 == 147) {
                        var39 = client.field323.method2566();
                        var4 = client.field323.method2700();
                        var5 = client.field323.method2561();
                        var118 = class148.method3129(var39);
                        var118.field2811 = var5 + (var4 << 16);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 231) {
                        client.field514 = client.field323.method2523();
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(55 == client.field325) {
                        var39 = client.field323.method2700();
                        var4 = client.field323.method2523();
                        var5 = client.field323.method2700();
                        if(0 != client.field396 && 0 != var4 && client.field383 < 50) {
                           client.field521[client.field383] = var39;
                           client.field522[client.field383] = var4;
                           client.field523[client.field383] = var5;
                           client.field444[client.field383] = null;
                           client.field446[client.field383] = 0;
                           ++client.field383;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 31) {
                        var39 = client.field323.method2557();
                        client.field438 = var39;
                        var4 = client.field438;
                        var5 = class35.field762;
                        var46 = class21.field575;
                        if(class113.method2462(var4)) {
                           class51.method1062(class173.field2837[var4], -1, var5, var46, false);
                        }

                        class25.method624(var39);
                        class209.method3920(client.field438);

                        for(var4 = 0; var4 < 100; ++var4) {
                           client.field483[var4] = true;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     String var50;
                     String var87;
                     if(client.field325 == 40) {
                        var3 = client.field323.method2531();
                        class122 var117 = client.field323;
                        var50 = class76.method1672(var117, 32767);
                        var87 = class223.method4072(class22.method581(var50));
                        class87.method2092(6, var3, var87);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 57) {
                        class50.field1077 = client.field323.method2523();
                        client.field342 = client.field323.method2550();
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(222 == client.field325) {
                        client.field518 = client.field323.method2523();
                        client.field497 = client.field323.method2523();
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     class2 var56;
                     class122 var75;
                     if(client.field325 == 188) {
                        var75 = client.field323;
                        var4 = client.field324;
                        var5 = var75.field1976;
                        class32.field741 = 0;
                        var46 = 0;
                        var75.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if(0 == (class32.field740[var51] & 1)) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var75.method2756(1);
                                 if(var9 == 0) {
                                    var46 = class29.method668(var75);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var75, var51);
                                 }
                              }
                           }
                        }

                        var75.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        var75.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if(0 != (class32.field740[var51] & 1)) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var75.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var75);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var75, var51);
                                 }
                              }
                           }
                        }

                        var75.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        var75.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if((class32.field740[var51] & 1) != 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var75.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var75);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var75, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var75.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        var75.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if(0 == (class32.field740[var51] & 1)) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var75.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var75);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var75, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var75.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        class32.field731 = 0;
                        class32.field733 = 0;

                        for(var47 = 1; var47 < 2048; ++var47) {
                           class32.field740[var47] = (byte)(class32.field740[var47] >> 1);
                           var56 = client.field387[var47];
                           if(var56 != null) {
                              class32.field732[++class32.field731 - 1] = var47;
                           } else {
                              class32.field734[++class32.field733 - 1] = var47;
                           }
                        }

                        class1.method14(var75);
                        if(var75.field1976 - var5 != var4) {
                           throw new RuntimeException(var75.field1976 - var5 + " " + var4);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     boolean var43;
                     String var45;
                     boolean var55;
                     boolean var85;
                     if(215 == client.field325) {
                        while(client.field323.field1976 < client.field324) {
                           var43 = client.field323.method2523() == 1;
                           var50 = client.field323.method2531();
                           var45 = client.field323.method2531();
                           var46 = client.field323.method2700();
                           var47 = client.field323.method2523();
                           var51 = client.field323.method2523();
                           boolean var108 = 0 != (var51 & 2);
                           boolean var81 = (var51 & 1) != 0;
                           if(var46 > 0) {
                              client.field323.method2531();
                              client.field323.method2523();
                              client.field323.method2528();
                           }

                           client.field323.method2531();

                           for(var11 = 0; var11 < client.field545; ++var11) {
                              class17 var88 = client.field547[var11];
                              if(!var43) {
                                 if(var50.equals(var88.field247)) {
                                    if(var46 != var88.field242) {
                                       var85 = true;

                                       for(class38 var104 = (class38)client.field548.method3784(); var104 != null; var104 = (class38)client.field548.method3779()) {
                                          if(var104.field849.equals(var50)) {
                                             if(var46 != 0 && 0 == var104.field858) {
                                                var104.method3911();
                                                var85 = false;
                                             } else if(var46 == 0 && var104.field858 != 0) {
                                                var104.method3911();
                                                var85 = false;
                                             }
                                          }
                                       }

                                       if(var85) {
                                          client.field548.method3778(new class38(var50, var46));
                                       }

                                       var88.field242 = var46;
                                    }

                                    var88.field245 = var45;
                                    var88.field244 = var47;
                                    var88.field241 = var108;
                                    var88.field240 = var81;
                                    var50 = null;
                                    break;
                                 }
                              } else if(var45.equals(var88.field247)) {
                                 var88.field247 = var50;
                                 var88.field245 = var45;
                                 var50 = null;
                                 break;
                              }
                           }

                           if(null != var50 && client.field545 < 400) {
                              class17 var83 = new class17();
                              client.field547[client.field545] = var83;
                              var83.field247 = var50;
                              var83.field245 = var45;
                              var83.field242 = var46;
                              var83.field244 = var47;
                              var83.field241 = var108;
                              var83.field240 = var81;
                              ++client.field545;
                           }
                        }

                        client.field382 = 2;
                        client.field471 = client.field463;
                        var43 = false;
                        var4 = client.field545;

                        while(var4 > 0) {
                           var43 = true;
                           --var4;

                           for(var5 = 0; var5 < var4; ++var5) {
                              var55 = false;
                              class17 var123 = client.field547[var5];
                              class17 var113 = client.field547[var5 + 1];
                              if(var123.field242 != client.field279 && client.field279 == var113.field242) {
                                 var55 = true;
                              }

                              if(!var55 && var123.field242 == 0 && var113.field242 != 0) {
                                 var55 = true;
                              }

                              if(!var55 && !var123.field241 && var113.field241) {
                                 var55 = true;
                              }

                              if(!var55 && !var123.field240 && var113.field240) {
                                 var55 = true;
                              }

                              if(var55) {
                                 class17 var110 = client.field547[var5];
                                 client.field547[var5] = client.field547[1 + var5];
                                 client.field547[var5 + 1] = var110;
                                 var43 = false;
                              }
                           }

                           if(var43) {
                              break;
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(102 == client.field325) {
                        var39 = client.field323.method2663();
                        var4 = client.field323.method2561();
                        class176.field2905[var4] = var39;
                        if(class176.field2903[var4] != var39) {
                           class176.field2903[var4] = var39;
                        }

                        class50.method1012(var4);
                        client.field464[++client.field557 - 1 & 31] = var4;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     class173 var53;
                     if(95 == client.field325) {
                        var39 = client.field323.method2528();
                        var4 = client.field323.method2700();
                        if(var39 < -70000) {
                           var4 += '耀';
                        }

                        if(var39 >= 0) {
                           var53 = class148.method3129(var39);
                        } else {
                           var53 = null;
                        }

                        if(var53 != null) {
                           for(var46 = 0; var46 < var53.field2759.length; ++var46) {
                              var53.field2759[var46] = 0;
                              var53.field2873[var46] = 0;
                           }
                        }

                        class15 var121 = (class15)class15.field216.method3788((long)var4);
                        if(null != var121) {
                           for(var47 = 0; var47 < var121.field219.length; ++var47) {
                              var121.field219[var47] = -1;
                              var121.field217[var47] = 0;
                           }
                        }

                        var46 = client.field323.method2700();

                        for(var47 = 0; var47 < var46; ++var47) {
                           var51 = client.field323.method2550();
                           if(var51 == 255) {
                              var51 = client.field323.method2566();
                           }

                           var9 = client.field323.method2700();
                           if(var53 != null && var47 < var53.field2759.length) {
                              var53.field2759[var47] = var9;
                              var53.field2873[var47] = var51;
                           }

                           class25.method629(var4, var47, var9 - 1, var51);
                        }

                        if(var53 != null) {
                           class9.method133(var53);
                        }

                        class13.method165();
                        client.field481[++client.field467 - 1 & 31] = var4 & 32767;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 205) {
                        class50.field1077 = client.field323.method2549();
                        client.field342 = client.field323.method2550();

                        while(client.field323.field1976 < client.field324) {
                           client.field325 = client.field323.method2523();
                           class106.method2399();
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     boolean var98;
                     if(197 == client.field325) {
                        client.field474 = client.field463;
                        if(0 == client.field324) {
                           client.field505 = null;
                           client.field506 = null;
                           class26.field644 = 0;
                           class90.field1542 = null;
                           client.field325 = -1;
                           var1 = true;
                        } else {
                           client.field506 = client.field323.method2531();
                           long var122 = client.field323.method2529();
                           client.field505 = class148.method3125(var122);
                           class0.field17 = client.field323.method2633();
                           var5 = client.field323.method2523();
                           if(var5 == 255) {
                              client.field325 = -1;
                              var1 = true;
                           } else {
                              class26.field644 = var5;
                              class24[] var120 = new class24[100];

                              for(var47 = 0; var47 < class26.field644; ++var47) {
                                 var120[var47] = new class24();
                                 var120[var47].field609 = client.field323.method2531();
                                 var120[var47].field607 = class122.method2773(var120[var47].field609, client.field283);
                                 var120[var47].field610 = client.field323.method2700();
                                 var120[var47].field608 = client.field323.method2633();
                                 client.field323.method2531();
                                 if(var120[var47].field609.equals(class20.field572.field45)) {
                                    class44.field1012 = var120[var47].field608;
                                 }
                              }

                              var98 = false;
                              var9 = class26.field644;

                              while(var9 > 0) {
                                 var98 = true;
                                 --var9;

                                 for(var10 = 0; var10 < var9; ++var10) {
                                    if(var120[var10].field607.compareTo(var120[1 + var10].field607) > 0) {
                                       class24 var111 = var120[var10];
                                       var120[var10] = var120[var10 + 1];
                                       var120[1 + var10] = var111;
                                       var98 = false;
                                    }
                                 }

                                 if(var98) {
                                    break;
                                 }
                              }

                              class90.field1542 = var120;
                              client.field325 = -1;
                              var1 = true;
                           }
                        }
                        break label3717;
                     }

                     if(client.field325 == 83 || 191 == client.field325 || 177 == client.field325 || client.field325 == 33 || 238 == client.field325 || 245 == client.field325 || client.field325 == 200 || 81 == client.field325 || client.field325 == 203 || 228 == client.field325) {
                        class106.method2399();
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 234) {
                        var39 = client.field323.method2526();
                        var4 = client.field323.method2528();
                        var5 = client.field323.method2560();
                        var118 = class148.method3129(var4);
                        if(var118.field2764 != var5 || var39 != var118.field2886 || 0 != var118.field2760 || 0 != var118.field2761) {
                           var118.field2764 = var5;
                           var118.field2886 = var39;
                           var118.field2760 = 0;
                           var118.field2761 = 0;
                           class9.method133(var118);
                           class90.method2102(var118);
                           if(0 == var118.field2757) {
                              class181.method3515(class173.field2837[var4 >> 16], var118, false);
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(66 == client.field325) {
                        var39 = client.field323.method2523();
                        var4 = client.field323.method2523();
                        var5 = client.field323.method2523();
                        var46 = client.field323.method2523();
                        client.field388[var39] = true;
                        client.field528[var39] = var4;
                        client.field529[var39] = var5;
                        client.field276[var39] = var46;
                        client.field531[var39] = 0;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 117) {
                        var39 = client.field323.method2567();
                        var4 = client.field323.method2587();
                        if('\uffff' == var4) {
                           var4 = -1;
                        }

                        var5 = client.field323.method2567();
                        var118 = class148.method3129(var5);
                        class51 var119;
                        if(!var118.field2809) {
                           if(var4 == -1) {
                              var118.field2798 = 0;
                              client.field325 = -1;
                              var1 = true;
                              break label3717;
                           }

                           var119 = class33.method711(var4);
                           var118.field2798 = 4;
                           var118.field2876 = var4;
                           var118.field2765 = var119.field1097;
                           var118.field2807 = var119.field1098;
                           var118.field2802 = var119.field1096 * 100 / var39;
                           class9.method133(var118);
                        } else {
                           var118.field2822 = var4;
                           var118.field2866 = var39;
                           var119 = class33.method711(var4);
                           var118.field2765 = var119.field1097;
                           var118.field2807 = var119.field1098;
                           var118.field2800 = var119.field1084;
                           var118.field2804 = var119.field1106;
                           var118.field2805 = var119.field1133;
                           var118.field2802 = var119.field1096;
                           if(var119.field1102 == 1) {
                              var118.field2813 = 1;
                           } else {
                              var118.field2813 = 2;
                           }

                           if(var118.field2810 > 0) {
                              var118.field2802 = var118.field2802 * 32 / var118.field2810;
                           } else if(var118.field2766 > 0) {
                              var118.field2802 = var118.field2802 * 32 / var118.field2766;
                           }

                           class9.method133(var118);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(106 == client.field325) {
                        client.field430 = client.field323.method2561() * 30;
                        client.field546 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(129 == client.field325) {
                        class13.method165();
                        client.field443 = client.field323.method2523();
                        client.field546 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     boolean var44;
                     if(client.field325 == 18) {
                        var39 = client.field323.method2566();
                        var44 = client.field323.method2550() == 1;
                        var53 = class148.method3129(var39);
                        if(var53.field2775 != var44) {
                           var53.field2775 = var44;
                           class9.method133(var53);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 75) {
                        var39 = client.field323.method2523();
                        if(client.field323.method2523() == 0) {
                           client.field554[var39] = new class220();
                           client.field323.field1976 += 18;
                        } else {
                           --client.field323.field1976;
                           client.field554[var39] = new class220(client.field323, false);
                        }

                        client.field473 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(232 == client.field325) {
                        var39 = client.field323.method2551();
                        var50 = client.field323.method2531();
                        var5 = client.field323.method2550();
                        if(var5 >= 1 && var5 <= 8) {
                           if(var50.equalsIgnoreCase("null")) {
                              var50 = null;
                           }

                           client.field406[var5 - 1] = var50;
                           client.field407[var5 - 1] = 0 == var39;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(120 == client.field325) {
                        while(client.field323.field1976 < client.field324) {
                           var39 = client.field323.method2523();
                           var44 = 1 == (var39 & 1);
                           var45 = client.field323.method2531();
                           var87 = client.field323.method2531();
                           client.field323.method2531();

                           for(var47 = 0; var47 < client.field549; ++var47) {
                              class7 var109 = client.field550[var47];
                              if(var44) {
                                 if(var87.equals(var109.field141)) {
                                    var109.field141 = var45;
                                    var109.field135 = var87;
                                    var45 = null;
                                    break;
                                 }
                              } else if(var45.equals(var109.field141)) {
                                 var109.field141 = var45;
                                 var109.field135 = var87;
                                 var45 = null;
                                 break;
                              }
                           }

                           if(null != var45 && client.field549 < 400) {
                              class7 var116 = new class7();
                              client.field550[client.field549] = var116;
                              var116.field141 = var45;
                              var116.field135 = var87;
                              ++client.field549;
                           }
                        }

                        client.field471 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(151 == client.field325) {
                        client.field313 = false;

                        for(var39 = 0; var39 < 5; ++var39) {
                           client.field388[var39] = false;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     long var68;
                     if(client.field325 == 94) {
                        var39 = client.field323.method2528();
                        var4 = client.field323.method2528();
                        if(null == class107.field1863 || !class107.field1863.isValid()) {
                           try {
                              Iterator var97 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                              while(var97.hasNext()) {
                                 GarbageCollectorMXBean var115 = (GarbageCollectorMXBean)var97.next();
                                 if(var115.isValid()) {
                                    class107.field1863 = var115;
                                    client.field556 = -1L;
                                    client.field555 = -1L;
                                 }
                              }
                           } catch (Throwable var27) {
                              ;
                           }
                        }

                        long var101 = class140.method2967();
                        var47 = -1;
                        if(class107.field1863 != null) {
                           var68 = class107.field1863.getCollectionTime();
                           if(client.field555 != -1L) {
                              long var76 = var68 - client.field555;
                              long var84 = var101 - client.field556;
                              if(0L != var84) {
                                 var47 = (int)(100L * var76 / var84);
                              }
                           }

                           client.field555 = var68;
                           client.field556 = var101;
                        }

                        client.field321.method2762(162);
                        client.field321.method2555(class144.field2195);
                        client.field321.method2683(var39);
                        client.field321.method2563(var4);
                        client.field321.method2708(var47);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     class3 var6;
                     class173 var92;
                     if(133 == client.field325) {
                        var39 = client.field323.method2663();
                        var4 = client.field323.method2566();
                        class3 var94 = (class3)client.field439.method3788((long)var39);
                        var6 = (class3)client.field439.method3788((long)var4);
                        if(null != var6) {
                           class110.method2446(var6, var94 == null || var94.field69 != var6.field69);
                        }

                        if(null != var94) {
                           var94.method3913();
                           client.field439.method3789(var94, (long)var4);
                        }

                        var92 = class148.method3129(var39);
                        if(var92 != null) {
                           class9.method133(var92);
                        }

                        var92 = class148.method3129(var4);
                        if(var92 != null) {
                           class9.method133(var92);
                           class181.method3515(class173.field2837[var92.field2794 >>> 16], var92, true);
                        }

                        if(client.field438 != -1) {
                           class9.method134(client.field438, 1);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(219 == client.field325) {
                        client.field342 = client.field323.method2549();
                        class50.field1077 = client.field323.method2550();

                        for(var39 = class50.field1077; var39 < 8 + class50.field1077; ++var39) {
                           for(var4 = client.field342; var4 < client.field342 + 8; ++var4) {
                              if(client.field410[class48.field1063][var39][var4] != null) {
                                 client.field410[class48.field1063][var39][var4] = null;
                                 class31.method680(var39, var4);
                              }
                           }
                        }

                        for(class16 var114 = (class16)client.field411.method3825(); var114 != null; var114 = (class16)client.field411.method3827()) {
                           if(var114.field226 >= class50.field1077 && var114.field226 < 8 + class50.field1077 && var114.field227 >= client.field342 && var114.field227 < client.field342 + 8 && class48.field1063 == var114.field239) {
                              var114.field235 = 0;
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(5 == client.field325) {
                        client.field313 = true;
                        class15.field221 = client.field323.method2523();
                        class110.field1931 = client.field323.method2523();
                        class124.field2018 = client.field323.method2700();
                        class29.field671 = client.field323.method2523();
                        class32.field738 = client.field323.method2523();
                        if(class32.field738 >= 100) {
                           var39 = class15.field221 * 128 + 64;
                           var4 = class110.field1931 * 128 + 64;
                           var5 = class59.method1263(var39, var4, class48.field1063) - class124.field2018;
                           var46 = var39 - class19.field273;
                           var47 = var5 - class0.field12;
                           var51 = var4 - class5.field95;
                           var9 = (int)Math.sqrt((double)(var51 * var51 + var46 * var46));
                           class216.field3156 = (int)(Math.atan2((double)var47, (double)var9) * 325.949D) & 2047;
                           class10.field167 = (int)(Math.atan2((double)var46, (double)var51) * -325.949D) & 2047;
                           if(class216.field3156 < 128) {
                              class216.field3156 = 128;
                           }

                           if(class216.field3156 > 383) {
                              class216.field3156 = 383;
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(214 == client.field325) {
                        var39 = client.field323.method2587();
                        var4 = client.field323.method2566();
                        var53 = class148.method3129(var4);
                        if(1 != var53.field2798 || var53.field2876 != var39) {
                           var53.field2798 = 1;
                           var53.field2876 = var39;
                           class9.method133(var53);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(49 == client.field325) {
                        var39 = client.field323.method2587();
                        if('\uffff' == var39) {
                           var39 = -1;
                        }

                        if(var39 == -1 && !client.field427) {
                           class39.method785();
                        } else if(var39 != -1 && client.field516 != var39 && client.field515 != 0 && !client.field427) {
                           class168 var93 = class24.field611;
                           var5 = client.field515;
                           class183.field2958 = 1;
                           class14.field209 = var93;
                           class148.field2219 = var39;
                           class164.field2656 = 0;
                           class96.field1611 = var5;
                           class125.field2030 = false;
                           class209.field3118 = 2;
                        }

                        client.field516 = var39;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 93) {
                        var39 = client.field323.method2527();
                        var4 = client.field323.method2557();
                        if(var4 == '\uffff') {
                           var4 = -1;
                        }

                        class190.method3746(var4);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 246) {
                        class27.method635();
                        client.field325 = -1;
                        var1 = false;
                        break label3717;
                     }

                     if(204 == client.field325) {
                        for(var39 = 0; var39 < class226.field3210; ++var39) {
                           class52 var86 = class35.method732(var39);
                           if(null != var86) {
                              class176.field2905[var39] = 0;
                              class176.field2903[var39] = 0;
                           }
                        }

                        class13.method165();
                        client.field557 += 32;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     int var14;
                     long var65;
                     String var95;
                     long var112;
                     if(client.field325 == 225) {
                        var3 = client.field323.method2531();
                        var66 = client.field323.method2529();
                        var112 = (long)client.field323.method2700();
                        var68 = (long)client.field323.method2527();
                        class152 var74 = (class152)class35.method731(class133.method2849(), client.field323.method2523());
                        var65 = (var112 << 32) + var68;
                        var85 = false;

                        for(var14 = 0; var14 < 100; ++var14) {
                           if(client.field340[var14] == var65) {
                              var85 = true;
                              break;
                           }
                        }

                        if(var74.field2257 && class163.method3234(var3)) {
                           var85 = true;
                        }

                        if(!var85 && 0 == client.field307) {
                           client.field340[client.field500] = var65;
                           client.field500 = (client.field500 + 1) % 100;
                           class122 var107 = client.field323;
                           var95 = class76.method1672(var107, 32767);
                           String var102 = class223.method4072(class22.method581(var95));
                           if(var74.field2258 != -1) {
                              class46.method973(9, class94.method2184(var74.field2258) + var3, var102, class159.method3171(var66));
                           } else {
                              class46.method973(9, var3, var102, class159.method3171(var66));
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 167) {
                        var39 = client.field323.method2663();
                        var52 = class148.method3129(var39);

                        for(var5 = 0; var5 < var52.field2759.length; ++var5) {
                           var52.field2759[var5] = -1;
                           var52.field2759[var5] = 0;
                        }

                        class9.method133(var52);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 181) {
                        var39 = client.field323.method2528();
                        var4 = client.field323.method2700();
                        if(var39 < -70000) {
                           var4 += '耀';
                        }

                        if(var39 >= 0) {
                           var53 = class148.method3129(var39);
                        } else {
                           var53 = null;
                        }

                        for(; client.field323.field1976 < client.field324; class25.method629(var4, var46, var47 - 1, var51)) {
                           var46 = client.field323.method2536();
                           var47 = client.field323.method2700();
                           var51 = 0;
                           if(0 != var47) {
                              var51 = client.field323.method2523();
                              if(var51 == 255) {
                                 var51 = client.field323.method2528();
                              }
                           }

                           if(var53 != null && var46 >= 0 && var46 < var53.field2759.length) {
                              var53.field2759[var46] = var47;
                              var53.field2873[var46] = var51;
                           }
                        }

                        if(null != var53) {
                           class9.method133(var53);
                        }

                        class13.method165();
                        client.field481[++client.field467 - 1 & 31] = var4 & 32767;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 174) {
                        class99.method2219(false);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(82 == client.field325) {
                        var39 = client.field323.method2557();
                        class173.method3423(var39);
                        client.field481[++client.field467 - 1 & 31] = var39 & 32767;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 119) {
                        var39 = client.field323.method2567();
                        var4 = client.field323.method2560();
                        var53 = class148.method3129(var39);
                        if(var53.field2845 != var4 || -1 == var4) {
                           var53.field2845 = var4;
                           var53.field2749 = 0;
                           var53.field2868 = 0;
                           class9.method133(var53);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(241 == client.field325) {
                        class13.method165();
                        client.field365 = client.field323.method2526();
                        client.field546 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 248) {
                        class104.field1759 = class13.method166(client.field323.method2523());
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     long var73;
                     String var78;
                     if(127 == client.field325) {
                        var3 = client.field323.method2531();
                        var66 = (long)client.field323.method2700();
                        var112 = (long)client.field323.method2527();
                        class152 var89 = (class152)class35.method731(class133.method2849(), client.field323.method2523());
                        var73 = var112 + (var66 << 32);
                        boolean var69 = false;

                        for(var12 = 0; var12 < 100; ++var12) {
                           if(var73 == client.field340[var12]) {
                              var69 = true;
                              break;
                           }
                        }

                        if(class163.method3234(var3)) {
                           var69 = true;
                        }

                        if(!var69 && 0 == client.field307) {
                           client.field340[client.field500] = var73;
                           client.field500 = (client.field500 + 1) % 100;
                           class122 var82 = client.field323;
                           var78 = class76.method1672(var82, 32767);
                           var95 = class223.method4072(class22.method581(var78));
                           byte var103;
                           if(var89.field2254) {
                              var103 = 7;
                           } else {
                              var103 = 3;
                           }

                           if(-1 != var89.field2258) {
                              class87.method2092(var103, class94.method2184(var89.field2258) + var3, var95);
                           } else {
                              class87.method2092(var103, var3, var95);
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 159) {
                        var3 = client.field323.method2531();
                        Object[] var64 = new Object[var3.length() + 1];

                        for(var5 = var3.length() - 1; var5 >= 0; --var5) {
                           if(var3.charAt(var5) == 115) {
                              var64[1 + var5] = client.field323.method2531();
                           } else {
                              var64[1 + var5] = new Integer(client.field323.method2528());
                           }
                        }

                        var64[0] = new Integer(client.field323.method2528());
                        class0 var70 = new class0();
                        var70.field11 = var64;
                        class93.method2183(var70);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 198) {
                        var39 = client.field323.method2557();
                        var4 = client.field323.method2566();
                        var53 = class148.method3129(var4);
                        if(null != var53 && var53.field2757 == 0) {
                           if(var39 > var53.field2779 - var53.field2834) {
                              var39 = var53.field2779 - var53.field2834;
                           }

                           if(var39 < 0) {
                              var39 = 0;
                           }

                           if(var53.field2815 != var39) {
                              var53.field2815 = var39;
                              class9.method133(var53);
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 202) {
                        byte var77 = client.field323.method2633();
                        var4 = client.field323.method2557();
                        class176.field2905[var4] = var77;
                        if(class176.field2903[var4] != var77) {
                           class176.field2903[var4] = var77;
                        }

                        class50.method1012(var4);
                        client.field464[++client.field557 - 1 & 31] = var4;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     int var15;
                     String var72;
                     if(15 == client.field325) {
                        var75 = client.field323;
                        var4 = client.field324;
                        class210 var59 = new class210();
                        var59.field3120 = var75.method2523();
                        var59.field3121 = var75.method2528();
                        var59.field3119 = new int[var59.field3120];
                        var59.field3122 = new int[var59.field3120];
                        var59.field3123 = new Field[var59.field3120];
                        var59.field3124 = new int[var59.field3120];
                        var59.field3125 = new Method[var59.field3120];
                        var59.field3126 = new byte[var59.field3120][][];

                        for(var46 = 0; var46 < var59.field3120; ++var46) {
                           try {
                              var47 = var75.method2523();
                              String var96;
                              if(0 != var47 && var47 != 1 && var47 != 2) {
                                 if(var47 == 3 || var47 == 4) {
                                    var72 = var75.method2531();
                                    var96 = var75.method2531();
                                    var10 = var75.method2523();
                                    String[] var67 = new String[var10];

                                    for(var12 = 0; var12 < var10; ++var12) {
                                       var67[var12] = var75.method2531();
                                    }

                                    var78 = var75.method2531();
                                    byte[][] var79 = new byte[var10][];
                                    if(var47 == 3) {
                                       for(var14 = 0; var14 < var10; ++var14) {
                                          var15 = var75.method2528();
                                          var79[var14] = new byte[var15];
                                          var75.method2709(var79[var14], 0, var15);
                                       }
                                    }

                                    var59.field3119[var46] = var47;
                                    Class[] var90 = new Class[var10];

                                    for(var15 = 0; var15 < var10; ++var15) {
                                       var90[var15] = class178.method3461(var67[var15]);
                                    }

                                    Class var99 = class178.method3461(var78);
                                    if(class178.method3461(var72).getClassLoader() == null) {
                                       throw new SecurityException();
                                    }

                                    Method[] var100 = class178.method3461(var72).getDeclaredMethods();
                                    Method[] var105 = var100;

                                    for(int var18 = 0; var18 < var105.length; ++var18) {
                                       Method var19 = var105[var18];
                                       if(var19.getName().equals(var96)) {
                                          Class[] var20 = var19.getParameterTypes();
                                          if(var90.length == var20.length) {
                                             boolean var21 = true;

                                             for(int var22 = 0; var22 < var90.length; ++var22) {
                                                if(var90[var22] != var20[var22]) {
                                                   var21 = false;
                                                   break;
                                                }
                                             }

                                             if(var21 && var99 == var19.getReturnType()) {
                                                var59.field3125[var46] = var19;
                                             }
                                          }
                                       }
                                    }

                                    var59.field3126[var46] = var79;
                                 }
                              } else {
                                 var72 = var75.method2531();
                                 var96 = var75.method2531();
                                 var10 = 0;
                                 if(var47 == 1) {
                                    var10 = var75.method2528();
                                 }

                                 var59.field3119[var46] = var47;
                                 var59.field3124[var46] = var10;
                                 if(class178.method3461(var72).getClassLoader() == null) {
                                    throw new SecurityException();
                                 }

                                 var59.field3123[var46] = class178.method3461(var72).getDeclaredField(var96);
                              }
                           } catch (ClassNotFoundException var28) {
                              var59.field3122[var46] = -1;
                           } catch (SecurityException var29) {
                              var59.field3122[var46] = -2;
                           } catch (NullPointerException var30) {
                              var59.field3122[var46] = -3;
                           } catch (Exception var31) {
                              var59.field3122[var46] = -4;
                           } catch (Throwable var32) {
                              var59.field3122[var46] = -5;
                           }
                        }

                        class211.field3129.method3865(var59);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(161 == client.field325) {
                        class32.field731 = 0;

                        for(var39 = 0; var39 < 2048; ++var39) {
                           class32.field729[var39] = null;
                           class32.field730[var39] = 1;
                        }

                        for(var39 = 0; var39 < 2048; ++var39) {
                           client.field387[var39] = null;
                        }

                        class10.method137(client.field323);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     int var13;
                     if(client.field325 == 123) {
                        var39 = client.field324 + client.field323.field1976;
                        var4 = client.field323.method2700();
                        var5 = client.field323.method2700();
                        if(var4 != client.field438) {
                           client.field438 = var4;
                           var46 = client.field438;
                           var47 = class35.field762;
                           var51 = class21.field575;
                           if(class113.method2462(var46)) {
                              class51.method1062(class173.field2837[var46], -1, var47, var51, false);
                           }

                           class25.method624(client.field438);
                           class209.method3920(client.field438);

                           for(var46 = 0; var46 < 100; ++var46) {
                              client.field483[var46] = true;
                           }
                        }

                        class3 var80;
                        for(; var5-- > 0; var80.field63 = true) {
                           var46 = client.field323.method2528();
                           var47 = client.field323.method2700();
                           var51 = client.field323.method2523();
                           var80 = (class3)client.field439.method3788((long)var46);
                           if(var80 != null && var80.field69 != var47) {
                              class110.method2446(var80, true);
                              var80 = null;
                           }

                           if(var80 == null) {
                              class3 var63 = new class3();
                              var63.field69 = var47;
                              var63.field64 = var51;
                              client.field439.method3789(var63, (long)var46);
                              class25.method624(var47);
                              class173 var71 = class148.method3129(var46);
                              class9.method133(var71);
                              if(null != client.field442) {
                                 class9.method133(client.field442);
                                 client.field442 = null;
                              }

                              for(var13 = 0; var13 < client.field420; ++var13) {
                                 if(class3.method41(client.field301[var13])) {
                                    if(var13 < client.field420 - 1) {
                                       for(var14 = var13; var14 < client.field420 - 1; ++var14) {
                                          client.field425[var14] = client.field425[var14 + 1];
                                          client.field426[var14] = client.field426[var14 + 1];
                                          client.field301[var14] = client.field301[var14 + 1];
                                          client.field391[var14] = client.field391[var14 + 1];
                                          client.field494[var14] = client.field494[1 + var14];
                                          client.field422[var14] = client.field422[var14 + 1];
                                       }
                                    }

                                    --client.field420;
                                 }
                              }

                              class181.method3515(class173.field2837[var46 >> 16], var71, false);
                              class209.method3920(var47);
                              if(client.field438 != -1) {
                                 class9.method134(client.field438, 1);
                              }

                              var80 = var63;
                           }
                        }

                        for(var6 = (class3)client.field439.method3794(); var6 != null; var6 = (class3)client.field439.method3791()) {
                           if(var6.field63) {
                              var6.field63 = false;
                           } else {
                              class110.method2446(var6, true);
                           }
                        }

                        client.field480 = new class196(512);

                        while(client.field323.field1976 < var39) {
                           var46 = client.field323.method2528();
                           var47 = client.field323.method2700();
                           var51 = client.field323.method2700();
                           var9 = client.field323.method2528();

                           for(var10 = var47; var10 <= var51; ++var10) {
                              var65 = ((long)var46 << 32) + (long)var10;
                              client.field480.method3789(new class201(var9), var65);
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(254 == client.field325) {
                        class99.method2219(true);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(150 == client.field325) {
                        var3 = client.field323.method2531();
                        var4 = client.field323.method2700();
                        byte var57 = client.field323.method2633();
                        var55 = false;
                        if(-128 == var57) {
                           var55 = true;
                        }

                        if(var55) {
                           if(class26.field644 == 0) {
                              client.field325 = -1;
                              var1 = true;
                              break label3717;
                           }

                           var98 = false;

                           for(var47 = 0; var47 < class26.field644 && (!class90.field1542[var47].field609.equals(var3) || class90.field1542[var47].field610 != var4); ++var47) {
                              ;
                           }

                           if(var47 < class26.field644) {
                              while(var47 < class26.field644 - 1) {
                                 class90.field1542[var47] = class90.field1542[var47 + 1];
                                 ++var47;
                              }

                              --class26.field644;
                              class90.field1542[class26.field644] = null;
                           }
                        } else {
                           client.field323.method2531();
                           class24 var106 = new class24();
                           var106.field609 = var3;
                           var106.field607 = class122.method2773(var106.field609, client.field283);
                           var106.field610 = var4;
                           var106.field608 = var57;

                           for(var51 = class26.field644 - 1; var51 >= 0; --var51) {
                              var9 = class90.field1542[var51].field607.compareTo(var106.field607);
                              if(var9 == 0) {
                                 class90.field1542[var51].field610 = var4;
                                 class90.field1542[var51].field608 = var57;
                                 if(var3.equals(class20.field572.field45)) {
                                    class44.field1012 = var57;
                                 }

                                 client.field474 = client.field463;
                                 client.field325 = -1;
                                 var1 = true;
                                 break label3717;
                              }

                              if(var9 < 0) {
                                 break;
                              }
                           }

                           if(class26.field644 >= class90.field1542.length) {
                              client.field325 = -1;
                              var1 = true;
                              break label3717;
                           }

                           for(var9 = class26.field644 - 1; var9 > var51; --var9) {
                              class90.field1542[1 + var9] = class90.field1542[var9];
                           }

                           if(class26.field644 == 0) {
                              class90.field1542 = new class24[100];
                           }

                           class90.field1542[var51 + 1] = var106;
                           ++class26.field644;
                           if(var3.equals(class20.field572.field45)) {
                              class44.field1012 = var57;
                           }
                        }

                        client.field474 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(105 == client.field325) {
                        for(var39 = 0; var39 < client.field387.length; ++var39) {
                           if(client.field387[var39] != null) {
                              client.field387[var39].field819 = -1;
                           }
                        }

                        for(var39 = 0; var39 < client.field316.length; ++var39) {
                           if(null != client.field316[var39]) {
                              client.field316[var39].field819 = -1;
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 176) {
                        var39 = client.field323.method2587();
                        var4 = client.field323.method2557();
                        var5 = client.field323.method2587();
                        var46 = client.field323.method2663();
                        var92 = class148.method3129(var46);
                        if(var5 != var92.field2765 || var4 != var92.field2807 || var39 != var92.field2802) {
                           var92.field2765 = var5;
                           var92.field2807 = var4;
                           var92.field2802 = var39;
                           class9.method133(var92);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 97) {
                        var39 = client.field323.method2663();
                        client.field305 = class125.field2028.method2873(var39);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 179) {
                        var3 = client.field323.method2531();
                        var4 = client.field323.method2567();
                        var53 = class148.method3129(var4);
                        if(!var3.equals(var53.field2853)) {
                           var53.field2853 = var3;
                           class9.method133(var53);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 148) {
                        var39 = client.field323.method2528();
                        var52 = class148.method3129(var39);
                        var52.field2798 = 3;
                        var52.field2876 = class20.field572.field35.method3471();
                        class9.method133(var52);
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(135 == client.field325) {
                        var39 = client.field323.method2587();
                        var4 = client.field323.method2663();
                        var53 = class148.method3129(var4);
                        if(2 != var53.field2798 || var53.field2876 != var39) {
                           var53.field2798 = 2;
                           var53.field2876 = var39;
                           class9.method133(var53);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     String var61;
                     if(4 == client.field325) {
                        var3 = client.field323.method2531();
                        class0.field8 = var3;

                        try {
                           var50 = client.field374.getParameter(class190.field3064.field3063);
                           var45 = client.field374.getParameter(class190.field3061.field3063);
                           var87 = var50 + "settings=" + var3 + "; version=1; path=/; domain=" + var45;
                           if(var3.length() == 0) {
                              var87 = var87 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                           } else {
                              var61 = var87 + "; Expires=";
                              var73 = class140.method2967() + 94608000000L;
                              class111.field1943.setTime(new Date(var73));
                              var11 = class111.field1943.get(7);
                              var12 = class111.field1943.get(5);
                              var13 = class111.field1943.get(2);
                              var14 = class111.field1943.get(1);
                              var15 = class111.field1943.get(11);
                              int var16 = class111.field1943.get(12);
                              int var17 = class111.field1943.get(13);
                              var72 = class111.field1937[var11 - 1] + ", " + var12 / 10 + var12 % 10 + "-" + class111.field1936[0][var13] + "-" + var14 + " " + var15 / 10 + var15 % 10 + ":" + var16 / 10 + var16 % 10 + ":" + var17 / 10 + var17 % 10 + " GMT";
                              var87 = var61 + var72 + "; Max-Age=" + 94608000L;
                           }

                           client var91 = client.field374;
                           var72 = "document.cookie=\"" + var87 + "\"";
                           JSObject.getWindow(var91).eval(var72);
                        } catch (Throwable var25) {
                           ;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 210) {
                        var39 = client.field323.method2528();
                        class3 var48 = (class3)client.field439.method3788((long)var39);
                        if(null != var48) {
                           class110.method2446(var48, true);
                        }

                        if(client.field442 != null) {
                           class9.method133(client.field442);
                           client.field442 = null;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 201) {
                        class13.method165();
                        var39 = client.field323.method2567();
                        var4 = client.field323.method2551();
                        var5 = client.field323.method2550();
                        client.field552[var4] = var39;
                        client.field492[var4] = var5;
                        client.field415[var4] = 1;

                        for(var46 = 0; var46 < 98; ++var46) {
                           if(var39 >= class155.field2284[var46]) {
                              client.field415[var4] = var46 + 2;
                           }
                        }

                        client.field468[++client.field469 - 1 & 31] = var4;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 140) {
                        client.field382 = 1;
                        client.field471 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 103) {
                        client.field313 = true;
                        class101.field1734 = client.field323.method2523();
                        class150.field2238 = client.field323.method2523();
                        class116.field1959 = client.field323.method2700();
                        class95.field1601 = client.field323.method2523();
                        class13.field204 = client.field323.method2523();
                        if(class13.field204 >= 100) {
                           class19.field273 = class101.field1734 * 128 + 64;
                           class5.field95 = class150.field2238 * 128 + 64;
                           class0.field12 = class59.method1263(class19.field273, class5.field95, class48.field1063) - class116.field1959;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(233 == client.field325) {
                        client.field432 = client.field323.method2523();
                        if(255 == client.field432) {
                           client.field432 = 0;
                        }

                        client.field513 = client.field323.method2523();
                        if(255 == client.field513) {
                           client.field513 = 0;
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 172) {
                        var39 = client.field323.method2663();
                        var4 = client.field323.method2587();
                        if('\uffff' == var4) {
                           var4 = -1;
                        }

                        var5 = client.field323.method2587();
                        if(var5 == '\uffff') {
                           var5 = -1;
                        }

                        var46 = client.field323.method2528();

                        for(var47 = var5; var47 <= var4; ++var47) {
                           var68 = (long)var47 + ((long)var39 << 32);
                           class208 var58 = client.field480.method3788(var68);
                           if(var58 != null) {
                              var58.method3913();
                           }

                           client.field480.method3789(new class201(var46), var68);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(100 == client.field325) {
                        client.field323.field1976 += 28;
                        if(client.field323.method2545()) {
                           class59.method1253(client.field323, client.field323.field1976 - 28);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(145 == client.field325) {
                        client.field297 = client.field323.method2523();
                        if(1 == client.field297) {
                           client.field298 = client.field323.method2700();
                        }

                        if(client.field297 >= 2 && client.field297 <= 6) {
                           if(client.field297 == 2) {
                              client.field303 = 64;
                              client.field304 = 64;
                           }

                           if(3 == client.field297) {
                              client.field303 = 0;
                              client.field304 = 64;
                           }

                           if(client.field297 == 4) {
                              client.field303 = 128;
                              client.field304 = 64;
                           }

                           if(client.field297 == 5) {
                              client.field303 = 64;
                              client.field304 = 0;
                           }

                           if(client.field297 == 6) {
                              client.field303 = 64;
                              client.field304 = 128;
                           }

                           client.field297 = 2;
                           client.field536 = client.field323.method2700();
                           client.field346 = client.field323.method2700();
                           client.field292 = client.field323.method2523();
                        }

                        if(client.field297 == 10) {
                           client.field299 = client.field323.method2700();
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     class122 var41;
                     if(client.field325 == 186) {
                        class22.method582(false);
                        client.field323.method2766();
                        var39 = client.field323.method2700();
                        var41 = client.field323;
                        var5 = var41.field1976;
                        class32.field741 = 0;
                        var46 = 0;
                        var41.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if((class32.field740[var51] & 1) == 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var41, var51);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if((class32.field740[var51] & 1) != 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(var9 == 0) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var41, var51);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if((class32.field740[var51] & 1) != 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(var9 == 0) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var41, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if((class32.field740[var51] & 1) == 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var41, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        class32.field731 = 0;
                        class32.field733 = 0;

                        for(var47 = 1; var47 < 2048; ++var47) {
                           class32.field740[var47] = (byte)(class32.field740[var47] >> 1);
                           var56 = client.field387[var47];
                           if(var56 != null) {
                              class32.field732[++class32.field731 - 1] = var47;
                           } else {
                              class32.field734[++class32.field733 - 1] = var47;
                           }
                        }

                        class1.method14(var41);
                        if(var41.field1976 - var5 != var39) {
                           throw new RuntimeException(var41.field1976 - var5 + " " + var39);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(30 == client.field325) {
                        for(var39 = 0; var39 < class176.field2903.length; ++var39) {
                           if(class176.field2905[var39] != class176.field2903[var39]) {
                              class176.field2903[var39] = class176.field2905[var39];
                              class50.method1012(var39);
                              client.field464[++client.field557 - 1 & 31] = var39;
                           }
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 47) {
                        var43 = client.field323.method2523() == 1;
                        if(var43) {
                           class1.field31 = class140.method2967() - client.field323.method2529();
                           class10.field168 = new class221(client.field323, true);
                        } else {
                           class10.field168 = null;
                        }

                        client.field364 = client.field463;
                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(142 == client.field325) {
                        var39 = client.field323.method2536();
                        var44 = client.field323.method2523() == 1;
                        var45 = "";
                        var55 = false;
                        if(var44) {
                           var45 = client.field323.method2531();
                           if(class163.method3234(var45)) {
                              var55 = true;
                           }
                        }

                        var61 = client.field323.method2531();
                        if(!var55) {
                           class87.method2092(var39, var45, var61);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 39) {
                        var39 = client.field323.method2663();
                        var4 = client.field323.method2561();
                        var5 = var4 >> 10 & 31;
                        var46 = var4 >> 5 & 31;
                        var47 = var4 & 31;
                        var51 = (var47 << 3) + (var46 << 11) + (var5 << 19);
                        class173 var62 = class148.method3129(var39);
                        if(var51 != var62.field2780) {
                           var62.field2780 = var51;
                           class9.method133(var62);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(221 == client.field325) {
                        class25 var40 = new class25();
                        var40.field623 = client.field323.method2531();
                        var40.field620 = client.field323.method2700();
                        var4 = client.field323.method2528();
                        var40.field621 = var4;
                        class141.method2971(45);
                        class46.field1040.method2982();
                        class46.field1040 = null;
                        class130.method2820(var40);
                        client.field325 = -1;
                        var1 = false;
                        break label3717;
                     }

                     if(226 == client.field325) {
                        if(client.field438 != -1) {
                           class9.method134(client.field438, 0);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(250 == client.field325) {
                        class22.method582(true);
                        client.field323.method2766();
                        var39 = client.field323.method2700();
                        var41 = client.field323;
                        var5 = var41.field1976;
                        class32.field741 = 0;
                        var46 = 0;
                        var41.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if(0 == (class32.field740[var51] & 1)) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var41, var51);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field731; ++var47) {
                           var51 = class32.field732[var47];
                           if(0 != (class32.field740[var51] & 1)) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(0 == var9) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else {
                                    class3.method40(var41, var51);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(var46 != 0) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if((class32.field740[var51] & 1) != 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(var9 == 0) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var41, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        var41.method2755();

                        for(var47 = 0; var47 < class32.field733; ++var47) {
                           var51 = class32.field734[var47];
                           if((class32.field740[var51] & 1) == 0) {
                              if(var46 > 0) {
                                 --var46;
                                 class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                              } else {
                                 var9 = var41.method2756(1);
                                 if(var9 == 0) {
                                    var46 = class29.method668(var41);
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 } else if(class28.method655(var41, var51)) {
                                    class32.field740[var51] = (byte)(class32.field740[var51] | 2);
                                 }
                              }
                           }
                        }

                        var41.method2754();
                        if(0 != var46) {
                           throw new RuntimeException();
                        }

                        class32.field731 = 0;
                        class32.field733 = 0;

                        for(var47 = 1; var47 < 2048; ++var47) {
                           class32.field740[var47] = (byte)(class32.field740[var47] >> 1);
                           var56 = client.field387[var47];
                           if(null != var56) {
                              class32.field732[++class32.field731 - 1] = var47;
                           } else {
                              class32.field734[++class32.field733 - 1] = var47;
                           }
                        }

                        class1.method14(var41);
                        if(var41.field1976 - var5 != var39) {
                           throw new RuntimeException(var41.field1976 - var5 + " " + var39);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     if(client.field325 == 196) {
                        var39 = client.field323.method2523();
                        var4 = client.field323.method2566();
                        var5 = client.field323.method2587();
                        var6 = (class3)client.field439.method3788((long)var4);
                        if(var6 != null) {
                           class110.method2446(var6, var6.field69 != var5);
                        }

                        class3 var7 = new class3();
                        var7.field69 = var5;
                        var7.field64 = var39;
                        client.field439.method3789(var7, (long)var4);
                        class25.method624(var5);
                        class173 var8 = class148.method3129(var4);
                        class9.method133(var8);
                        if(client.field442 != null) {
                           class9.method133(client.field442);
                           client.field442 = null;
                        }

                        for(var9 = 0; var9 < client.field420; ++var9) {
                           if(class3.method41(client.field301[var9])) {
                              if(var9 < client.field420 - 1) {
                                 for(var10 = var9; var10 < client.field420 - 1; ++var10) {
                                    client.field425[var10] = client.field425[var10 + 1];
                                    client.field426[var10] = client.field426[1 + var10];
                                    client.field301[var10] = client.field301[var10 + 1];
                                    client.field391[var10] = client.field391[var10 + 1];
                                    client.field494[var10] = client.field494[var10 + 1];
                                    client.field422[var10] = client.field422[var10 + 1];
                                 }
                              }

                              --client.field420;
                           }
                        }

                        class181.method3515(class173.field2837[var4 >> 16], var8, false);
                        class209.method3920(var5);
                        if(-1 != client.field438) {
                           class9.method134(client.field438, 1);
                        }

                        client.field325 = -1;
                        var1 = true;
                        break label3717;
                     }

                     class1.method16("" + client.field325 + "," + client.field329 + "," + client.field419 + "," + client.field324, (Throwable)null);
                     class27.method635();
                  } catch (IOException var33) {
                     class4.method46();
                  } catch (Exception var34) {
                     var3 = "" + client.field325 + "," + client.field329 + "," + client.field419 + "," + client.field324 + "," + (class20.field572.field842[0] + class85.field1439) + "," + (class6.field128 + class20.field572.field843[0]) + ",";

                     for(var4 = 0; var4 < client.field324 && var4 < 50; ++var4) {
                        var3 = var3 + client.field323.field1980[var4] + ",";
                     }

                     class1.method16(var3, var34);
                     class27.method635();
                  }

                  var1 = true;
               }
            }

            if(!var1) {
               break;
            }
         }

         if(30 == client.field287) {
            while(true) {
               class210 var126 = (class210)class211.field3129.method3866();
               boolean var35;
               if(var126 == null) {
                  var35 = false;
               } else {
                  var35 = true;
               }

               int var127;
               if(!var35) {
                  Object var36 = class32.field728.field195;
                  synchronized(class32.field728.field195) {
                     if(!client.field302) {
                        class32.field728.field196 = 0;
                     } else if(0 != class140.field2146 || class32.field728.field196 >= 40) {
                        client.field321.method2762(249);
                        client.field321.method2565(0);
                        var127 = client.field321.field1976;
                        var2 = 0;

                        for(var39 = 0; var39 < class32.field728.field196 && client.field321.field1976 - var127 < 240; ++var39) {
                           ++var2;
                           var4 = class32.field728.field202[var39];
                           if(var4 < 0) {
                              var4 = 0;
                           } else if(var4 > 502) {
                              var4 = 502;
                           }

                           var5 = class32.field728.field198[var39];
                           if(var5 < 0) {
                              var5 = 0;
                           } else if(var5 > 764) {
                              var5 = 764;
                           }

                           var46 = var5 + var4 * 765;
                           if(-1 == class32.field728.field202[var39] && -1 == class32.field728.field198[var39]) {
                              var5 = -1;
                              var4 = -1;
                              var46 = 524287;
                           }

                           if(var5 == client.field291 && client.field485 == var4) {
                              if(client.field293 < 2047) {
                                 ++client.field293;
                              }
                           } else {
                              var47 = var5 - client.field291;
                              client.field291 = var5;
                              var51 = var4 - client.field485;
                              client.field485 = var4;
                              if(client.field293 < 8 && var47 >= -32 && var47 <= 31 && var51 >= -32 && var51 <= 31) {
                                 var47 += 32;
                                 var51 += 32;
                                 client.field321.method2713(var51 + (client.field293 << 12) + (var47 << 6));
                                 client.field293 = 0;
                              } else if(client.field293 < 8) {
                                 client.field321.method2510(8388608 + (client.field293 << 19) + var46);
                                 client.field293 = 0;
                              } else {
                                 client.field321.method2617(-1073741824 + (client.field293 << 19) + var46);
                                 client.field293 = 0;
                              }
                           }
                        }

                        client.field321.method2524(client.field321.field1976 - var127);
                        if(var2 >= class32.field728.field196) {
                           class32.field728.field196 = 0;
                        } else {
                           class32.field728.field196 -= var2;

                           for(var39 = 0; var39 < class32.field728.field196; ++var39) {
                              class32.field728.field198[var39] = class32.field728.field198[var39 + var2];
                              class32.field728.field202[var39] = class32.field728.field202[var39 + var2];
                           }
                        }
                     }
                  }

                  if(1 == class140.field2146 || !class3.field66 && 4 == class140.field2146 || class140.field2146 == 2) {
                     long var37 = (class140.field2149 - client.field290) / 50L;
                     if(var37 > 4095L) {
                        var37 = 4095L;
                     }

                     client.field290 = class140.field2149;
                     var2 = class140.field2148;
                     if(var2 < 0) {
                        var2 = 0;
                     } else if(var2 > class21.field575) {
                        var2 = class21.field575;
                     }

                     var39 = class140.field2135;
                     if(var39 < 0) {
                        var39 = 0;
                     } else if(var39 > class35.field762) {
                        var39 = class35.field762;
                     }

                     var4 = (int)var37;
                     client.field321.method2762(211);
                     client.field321.method2713((var4 << 1) + (class140.field2146 == 2?1:0));
                     client.field321.method2713(var39);
                     client.field321.method2713(var2);
                  }

                  if(class137.field2119 > 0) {
                     client.field321.method2762(208);
                     client.field321.method2713(0);
                     var0 = client.field321.field1976;
                     long var128 = class140.method2967();

                     for(var39 = 0; var39 < class137.field2119; ++var39) {
                        var66 = var128 - client.field504;
                        if(var66 > 16777215L) {
                           var66 = 16777215L;
                        }

                        client.field504 = var128;
                        client.field321.method2708(class137.field2102[var39]);
                        client.field321.method2543((int)var66);
                     }

                     client.field321.method2519(client.field321.field1976 - var0);
                  }

                  if(client.field296 > 0) {
                     --client.field296;
                  }

                  if(class137.field2103[96] || class137.field2103[97] || class137.field2103[98] || class137.field2103[99]) {
                     client.field477 = true;
                  }

                  if(client.field477 && client.field296 <= 0) {
                     client.field296 = 20;
                     client.field477 = false;
                     client.field321.method2762(186);
                     client.field321.method2554(client.field449);
                     client.field321.method2548(client.field368);
                  }

                  if(class113.field1948 && !client.field312) {
                     client.field312 = true;
                     client.field321.method2762(27);
                     client.field321.method2565(1);
                  }

                  if(!class113.field1948 && client.field312) {
                     client.field312 = false;
                     client.field321.method2762(27);
                     client.field321.method2565(0);
                  }

                  class52.method1083();
                  if(30 != client.field287) {
                     return;
                  }

                  for(class16 var38 = (class16)client.field411.method3825(); var38 != null; var38 = (class16)client.field411.method3827()) {
                     if(var38.field235 > 0) {
                        --var38.field235;
                     }

                     class40 var129;
                     if(var38.field235 == 0) {
                        if(var38.field228 >= 0) {
                           var2 = var38.field228;
                           var39 = var38.field233;
                           var129 = class26.method633(var2);
                           if(11 == var39) {
                              var39 = 10;
                           }

                           if(var39 >= 5 && var39 <= 8) {
                              var39 = 4;
                           }

                           var1 = var129.method791(var39);
                           if(!var1) {
                              continue;
                           }
                        }

                        class143.method3001(var38.field239, var38.field225, var38.field226, var38.field227, var38.field228, var38.field230, var38.field233);
                        var38.method3913();
                     } else {
                        if(var38.field234 > 0) {
                           --var38.field234;
                        }

                        if(var38.field234 == 0 && var38.field226 >= 1 && var38.field227 >= 1 && var38.field226 <= 102 && var38.field227 <= 102) {
                           if(var38.field238 >= 0) {
                              var2 = var38.field238;
                              var39 = var38.field224;
                              var129 = class26.method633(var2);
                              if(11 == var39) {
                                 var39 = 10;
                              }

                              if(var39 >= 5 && var39 <= 8) {
                                 var39 = 4;
                              }

                              var1 = var129.method791(var39);
                              if(!var1) {
                                 continue;
                              }
                           }

                           class143.method3001(var38.field239, var38.field225, var38.field226, var38.field227, var38.field238, var38.field232, var38.field224);
                           var38.field234 = -1;
                           if(var38.field238 == var38.field228 && var38.field228 == -1) {
                              var38.method3913();
                           } else if(var38.field238 == var38.field228 && var38.field232 == var38.field230 && var38.field224 == var38.field233) {
                              var38.method3913();
                           }
                        }
                     }
                  }

                  for(var0 = 0; var0 < client.field383; ++var0) {
                     --client.field523[var0];
                     if(client.field523[var0] >= -10) {
                        class58 var131 = client.field444[var0];
                        if(var131 == null) {
                           class58 var137 = (class58)null;
                           var131 = class58.method1244(class143.field2175, client.field521[var0], 0);
                           if(var131 == null) {
                              continue;
                           }

                           client.field523[var0] += var131.method1241();
                           client.field444[var0] = var131;
                        }

                        if(client.field523[var0] < 0) {
                           if(client.field446[var0] != 0) {
                              var39 = 128 * (client.field446[var0] & 255);
                              var4 = client.field446[var0] >> 16 & 255;
                              var5 = var4 * 128 + 64 - class20.field572.field804;
                              if(var5 < 0) {
                                 var5 = -var5;
                              }

                              var46 = client.field446[var0] >> 8 & 255;
                              var47 = 64 + 128 * var46 - class20.field572.field814;
                              if(var47 < 0) {
                                 var47 = -var47;
                              }

                              var51 = var47 + var5 - 128;
                              if(var51 > var39) {
                                 client.field523[var0] = -100;
                                 continue;
                              }

                              if(var51 < 0) {
                                 var51 = 0;
                              }

                              var2 = client.field519 * (var39 - var51) / var39;
                           } else {
                              var2 = client.field396;
                           }

                           if(var2 > 0) {
                              class62 var134 = var131.method1246().method1279(class49.field1066);
                              class64 var130 = class64.method1322(var134, 100, var2);
                              var130.method1441(client.field522[var0] - 1);
                              class135.field2074.method1128(var130);
                           }

                           client.field523[var0] = -100;
                        }
                     } else {
                        --client.field383;

                        for(var127 = var0; var127 < client.field383; ++var127) {
                           client.field521[var127] = client.field521[1 + var127];
                           client.field444[var127] = client.field444[1 + var127];
                           client.field522[var127] = client.field522[var127 + 1];
                           client.field523[var127] = client.field523[var127 + 1];
                           client.field446[var127] = client.field446[1 + var127];
                        }

                        --var0;
                     }
                  }

                  if(client.field427 && !class149.method3138()) {
                     if(0 != client.field515 && client.field516 != -1) {
                        class99.method2218(class24.field611, client.field516, 0, client.field515, false);
                     }

                     client.field427 = false;
                  }

                  ++client.field326;
                  if(client.field326 > 750) {
                     class4.method46();
                     return;
                  }

                  class43.method902();
                  class1.method15();
                  class7.method106();
                  ++client.field355;
                  if(client.field390 != 0) {
                     client.field389 += 20;
                     if(client.field389 >= 400) {
                        client.field390 = 0;
                     }
                  }

                  if(null != class216.field3158) {
                     ++client.field436;
                     if(client.field436 >= 15) {
                        class9.method133(class216.field3158);
                        class216.field3158 = null;
                     }
                  }

                  class173 var42 = class7.field138;
                  class173 var133 = class98.field1649;
                  class7.field138 = null;
                  class98.field1649 = null;
                  client.field455 = null;
                  client.field459 = false;
                  client.field509 = false;
                  client.field520 = 0;

                  while(class124.method2790() && client.field520 < 128) {
                     if(client.field482 >= 2 && class137.field2103[82] && class141.field2158 == 66) {
                        var3 = "";

                        class35 var124;
                        for(Iterator var132 = class11.field171.iterator(); var132.hasNext(); var3 = var3 + var124.field761 + ':' + var124.field763 + '\n') {
                           var124 = (class35)var132.next();
                        }

                        class16.field236.setContents(new StringSelection(var3), (ClipboardOwner)null);
                     } else {
                        client.field503[client.field520] = class141.field2158;
                        client.field306[client.field520] = class108.field1883;
                        ++client.field520;
                     }
                  }

                  if(client.field438 != -1) {
                     var2 = client.field438;
                     var39 = class35.field762;
                     var4 = class21.field575;
                     if(class113.method2462(var2)) {
                        class40.method806(class173.field2837[var2], -1, 0, 0, var39, var4, 0, 0);
                     }
                  }

                  ++client.field463;

                  while(true) {
                     class0 var49;
                     class173 var135;
                     do {
                        var49 = (class0)client.field478.method3823();
                        if(var49 == null) {
                           while(true) {
                              do {
                                 var49 = (class0)client.field479.method3823();
                                 if(var49 == null) {
                                    while(true) {
                                       do {
                                          var49 = (class0)client.field466.method3823();
                                          if(var49 == null) {
                                             class8.method120();
                                             if(client.field451 != null) {
                                                class52.method1081();
                                             }

                                             if(null != class142.field2170) {
                                                class9.method133(class142.field2170);
                                                ++client.field524;
                                                if(class140.field2136 == 0) {
                                                   if(client.field397) {
                                                      if(class142.field2170 == class143.field2182 && client.field393 != client.field400) {
                                                         class173 var60 = class142.field2170;
                                                         byte var136 = 0;
                                                         if(client.field441 == 1 && 206 == var60.field2833) {
                                                            var136 = 1;
                                                         }

                                                         if(var60.field2759[client.field400] <= 0) {
                                                            var136 = 0;
                                                         }

                                                         if(class8.method115(class75.method1642(var60))) {
                                                            var4 = client.field393;
                                                            var5 = client.field400;
                                                            var60.field2759[var5] = var60.field2759[var4];
                                                            var60.field2873[var5] = var60.field2873[var4];
                                                            var60.field2759[var4] = -1;
                                                            var60.field2873[var4] = 0;
                                                         } else if(var136 == 1) {
                                                            var4 = client.field393;
                                                            var5 = client.field400;

                                                            while(var5 != var4) {
                                                               if(var4 > var5) {
                                                                  var60.method3376(var4 - 1, var4);
                                                                  --var4;
                                                               } else if(var4 < var5) {
                                                                  var60.method3376(1 + var4, var4);
                                                                  ++var4;
                                                               }
                                                            }
                                                         } else {
                                                            var60.method3376(client.field400, client.field393);
                                                         }

                                                         client.field321.method2762(50);
                                                         client.field321.method2548(client.field393);
                                                         client.field321.method2683(class142.field2170.field2794);
                                                         client.field321.method2708(var136);
                                                         client.field321.method2554(client.field400);
                                                      }
                                                   } else {
                                                      label3897: {
                                                         label2804: {
                                                            if(client.field417 != 1) {
                                                               var39 = client.field420 - 1;
                                                               boolean var54;
                                                               if(var39 < 0) {
                                                                  var54 = false;
                                                               } else {
                                                                  var4 = client.field301[var39];
                                                                  if(var4 >= 2000) {
                                                                     var4 -= 2000;
                                                                  }

                                                                  if(1007 == var4) {
                                                                     var54 = true;
                                                                  } else {
                                                                     var54 = false;
                                                                  }
                                                               }

                                                               if(!var54) {
                                                                  break label2804;
                                                               }
                                                            }

                                                            if(client.field420 > 2) {
                                                               class82.method1905(client.field394, client.field375);
                                                               break label3897;
                                                            }
                                                         }

                                                         if(client.field420 > 0) {
                                                            var2 = client.field394;
                                                            var39 = client.field375;
                                                            class44.method945(class177.field2910, var2, var39);
                                                            class177.field2910 = null;
                                                         }
                                                      }
                                                   }

                                                   client.field436 = 10;
                                                   class140.field2146 = 0;
                                                   class142.field2170 = null;
                                                } else if(client.field524 >= 5 && (class140.field2140 > client.field394 + 5 || class140.field2140 < client.field394 - 5 || class140.field2141 > client.field375 + 5 || class140.field2141 < client.field375 - 5)) {
                                                   client.field397 = true;
                                                }
                                             }

                                             if(class86.field1477 != -1) {
                                                var2 = class86.field1477;
                                                var39 = class86.field1481;
                                                client.field321.method2762(155);
                                                client.field321.method2565(5);
                                                client.field321.method2565(class137.field2103[82]?(class137.field2103[81]?2:1):0);
                                                client.field321.method2556(class6.field128 + var39);
                                                client.field321.method2548(var2 + class85.field1439);
                                                class86.field1477 = -1;
                                                client.field421 = class140.field2135;
                                                client.field277 = class140.field2148;
                                                client.field390 = 1;
                                                client.field389 = 0;
                                                client.field432 = var2;
                                                client.field513 = var39;
                                             }

                                             if(class7.field138 != var42) {
                                                if(var42 != null) {
                                                   class9.method133(var42);
                                                }

                                                if(class7.field138 != null) {
                                                   class9.method133(class7.field138);
                                                }
                                             }

                                             if(class98.field1649 != var133 && client.field501 == client.field370) {
                                                if(null != var133) {
                                                   class9.method133(var133);
                                                }

                                                if(null != class98.field1649) {
                                                   class9.method133(class98.field1649);
                                                }
                                             }

                                             if(class98.field1649 != null) {
                                                if(client.field370 < client.field501) {
                                                   ++client.field370;
                                                   if(client.field501 == client.field370) {
                                                      class9.method133(class98.field1649);
                                                   }
                                                }
                                             } else if(client.field370 > 0) {
                                                --client.field370;
                                             }

                                             var2 = class20.field572.field804 + client.field343;
                                             var39 = class20.field572.field814 + client.field345;
                                             if(class25.field629 - var2 < -500 || class25.field629 - var2 > 500 || class42.field981 - var39 < -500 || class42.field981 - var39 > 500) {
                                                class25.field629 = var2;
                                                class42.field981 = var39;
                                             }

                                             if(var2 != class25.field629) {
                                                class25.field629 += (var2 - class25.field629) / 16;
                                             }

                                             if(var39 != class42.field981) {
                                                class42.field981 += (var39 - class42.field981) / 16;
                                             }

                                             if(4 == class140.field2136 && class3.field66) {
                                                var4 = class140.field2141 - client.field319;
                                                client.field366 = var4 * 2;
                                                client.field319 = var4 != -1 && var4 != 1?(client.field319 + class140.field2141) / 2:class140.field2141;
                                                var5 = client.field367 - class140.field2140;
                                                client.field363 = var5 * 2;
                                                client.field367 = -1 != var5 && var5 != 1?(client.field367 + class140.field2140) / 2:class140.field2140;
                                             } else {
                                                if(class137.field2103[96]) {
                                                   client.field363 += (-24 - client.field363) / 2;
                                                } else if(class137.field2103[97]) {
                                                   client.field363 += (24 - client.field363) / 2;
                                                } else {
                                                   client.field363 /= 2;
                                                }

                                                if(class137.field2103[98]) {
                                                   client.field366 += (12 - client.field366) / 2;
                                                } else if(class137.field2103[99]) {
                                                   client.field366 += (-12 - client.field366) / 2;
                                                } else {
                                                   client.field366 /= 2;
                                                }

                                                client.field319 = class140.field2141;
                                                client.field367 = class140.field2140;
                                             }

                                             client.field368 = client.field368 + client.field363 / 2 & 2047;
                                             client.field449 += client.field366 / 2;
                                             if(client.field449 < 128) {
                                                client.field449 = 128;
                                             }

                                             if(client.field449 > 383) {
                                                client.field449 = 383;
                                             }

                                             var4 = class25.field629 >> 7;
                                             var5 = class42.field981 >> 7;
                                             var46 = class59.method1263(class25.field629, class42.field981, class48.field1063);
                                             var47 = 0;
                                             if(var4 > 3 && var5 > 3 && var4 < 100 && var5 < 100) {
                                                for(var51 = var4 - 4; var51 <= 4 + var4; ++var51) {
                                                   for(var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
                                                      var10 = class48.field1063;
                                                      if(var10 < 3 && (class5.field80[1][var51][var9] & 2) == 2) {
                                                         ++var10;
                                                      }

                                                      var11 = var46 - class5.field90[var10][var51][var9];
                                                      if(var11 > var47) {
                                                         var47 = var11;
                                                      }
                                                   }
                                                }
                                             }

                                             var51 = var47 * 192;
                                             if(var51 > 98048) {
                                                var51 = 98048;
                                             }

                                             if(var51 < '耀') {
                                                var51 = '耀';
                                             }

                                             if(var51 > client.field372) {
                                                client.field372 += (var51 - client.field372) / 24;
                                             } else if(var51 < client.field372) {
                                                client.field372 += (var51 - client.field372) / 80;
                                             }

                                             if(client.field313) {
                                                var2 = 64 + class101.field1734 * 128;
                                                var39 = 64 + class150.field2238 * 128;
                                                var4 = class59.method1263(var2, var39, class48.field1063) - class116.field1959;
                                                if(class19.field273 < var2) {
                                                   class19.field273 += (var2 - class19.field273) * class13.field204 / 1000 + class95.field1601;
                                                   if(class19.field273 > var2) {
                                                      class19.field273 = var2;
                                                   }
                                                }

                                                if(class19.field273 > var2) {
                                                   class19.field273 -= (class19.field273 - var2) * class13.field204 / 1000 + class95.field1601;
                                                   if(class19.field273 < var2) {
                                                      class19.field273 = var2;
                                                   }
                                                }

                                                if(class0.field12 < var4) {
                                                   class0.field12 += class95.field1601 + class13.field204 * (var4 - class0.field12) / 1000;
                                                   if(class0.field12 > var4) {
                                                      class0.field12 = var4;
                                                   }
                                                }

                                                if(class0.field12 > var4) {
                                                   class0.field12 -= class95.field1601 + class13.field204 * (class0.field12 - var4) / 1000;
                                                   if(class0.field12 < var4) {
                                                      class0.field12 = var4;
                                                   }
                                                }

                                                if(class5.field95 < var39) {
                                                   class5.field95 += class13.field204 * (var39 - class5.field95) / 1000 + class95.field1601;
                                                   if(class5.field95 > var39) {
                                                      class5.field95 = var39;
                                                   }
                                                }

                                                if(class5.field95 > var39) {
                                                   class5.field95 -= class13.field204 * (class5.field95 - var39) / 1000 + class95.field1601;
                                                   if(class5.field95 < var39) {
                                                      class5.field95 = var39;
                                                   }
                                                }

                                                var2 = 64 + class15.field221 * 128;
                                                var39 = class110.field1931 * 128 + 64;
                                                var4 = class59.method1263(var2, var39, class48.field1063) - class124.field2018;
                                                var5 = var2 - class19.field273;
                                                var46 = var4 - class0.field12;
                                                var47 = var39 - class5.field95;
                                                var51 = (int)Math.sqrt((double)(var5 * var5 + var47 * var47));
                                                var9 = (int)(Math.atan2((double)var46, (double)var51) * 325.949D) & 2047;
                                                var10 = (int)(Math.atan2((double)var5, (double)var47) * -325.949D) & 2047;
                                                if(var9 < 128) {
                                                   var9 = 128;
                                                }

                                                if(var9 > 383) {
                                                   var9 = 383;
                                                }

                                                if(class216.field3156 < var9) {
                                                   class216.field3156 += class29.field671 + (var9 - class216.field3156) * class32.field738 / 1000;
                                                   if(class216.field3156 > var9) {
                                                      class216.field3156 = var9;
                                                   }
                                                }

                                                if(class216.field3156 > var9) {
                                                   class216.field3156 -= class32.field738 * (class216.field3156 - var9) / 1000 + class29.field671;
                                                   if(class216.field3156 < var9) {
                                                      class216.field3156 = var9;
                                                   }
                                                }

                                                var11 = var10 - class10.field167;
                                                if(var11 > 1024) {
                                                   var11 -= 2048;
                                                }

                                                if(var11 < -1024) {
                                                   var11 += 2048;
                                                }

                                                if(var11 > 0) {
                                                   class10.field167 += var11 * class32.field738 / 1000 + class29.field671;
                                                   class10.field167 &= 2047;
                                                }

                                                if(var11 < 0) {
                                                   class10.field167 -= -var11 * class32.field738 / 1000 + class29.field671;
                                                   class10.field167 &= 2047;
                                                }

                                                var12 = var10 - class10.field167;
                                                if(var12 > 1024) {
                                                   var12 -= 2048;
                                                }

                                                if(var12 < -1024) {
                                                   var12 += 2048;
                                                }

                                                if(var12 < 0 && var11 > 0 || var12 > 0 && var11 < 0) {
                                                   class10.field167 = var10;
                                                }
                                             }

                                             for(var2 = 0; var2 < 5; ++var2) {
                                                ++client.field531[var2];
                                             }

                                             class125.field2027.method215();
                                             var2 = ++class140.field2139 - 1;
                                             var4 = class106.method2396();
                                             if(var2 > 15000 && var4 > 15000) {
                                                client.field472 = 250;
                                                class2.method39(14500);
                                                client.field321.method2762(214);
                                             }

                                             ++client.field349;
                                             if(client.field349 > 500) {
                                                client.field349 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if((var5 & 1) == 1) {
                                                   client.field343 += client.field457;
                                                }

                                                if((var5 & 2) == 2) {
                                                   client.field345 += client.field496;
                                                }

                                                if(4 == (var5 & 4)) {
                                                   client.field525 += client.field348;
                                                }
                                             }

                                             if(client.field343 < -50) {
                                                client.field457 = 2;
                                             }

                                             if(client.field343 > 50) {
                                                client.field457 = -2;
                                             }

                                             if(client.field345 < -55) {
                                                client.field496 = 2;
                                             }

                                             if(client.field345 > 55) {
                                                client.field496 = -2;
                                             }

                                             if(client.field525 < -40) {
                                                client.field348 = 1;
                                             }

                                             if(client.field525 > 40) {
                                                client.field348 = -1;
                                             }

                                             ++client.field434;
                                             if(client.field434 > 500) {
                                                client.field434 = 0;
                                                var5 = (int)(Math.random() * 8.0D);
                                                if(1 == (var5 & 1)) {
                                                   client.field350 += client.field351;
                                                }

                                                if((var5 & 2) == 2) {
                                                   client.field352 += client.field399;
                                                }
                                             }

                                             if(client.field350 < -60) {
                                                client.field351 = 2;
                                             }

                                             if(client.field350 > 60) {
                                                client.field351 = -2;
                                             }

                                             if(client.field352 < -20) {
                                                client.field399 = 1;
                                             }

                                             if(client.field352 > 10) {
                                                client.field399 = -1;
                                             }

                                             for(class38 var125 = (class38)client.field548.method3784(); var125 != null; var125 = (class38)client.field548.method3779()) {
                                                if((long)var125.field855 < class140.method2967() / 1000L - 5L) {
                                                   if(var125.field858 > 0) {
                                                      class87.method2092(5, "", var125.field849 + " has logged in.");
                                                   }

                                                   if(var125.field858 == 0) {
                                                      class87.method2092(5, "", var125.field849 + " has logged out.");
                                                   }

                                                   var125.method3911();
                                                }
                                             }

                                             ++client.field347;
                                             if(client.field347 > 50) {
                                                client.field321.method2762(240);
                                             }

                                             try {
                                                if(null != class46.field1040 && client.field321.field1976 > 0) {
                                                   class46.field1040.method2983(client.field321.field1980, 0, client.field321.field1976);
                                                   client.field321.field1976 = 0;
                                                   client.field347 = 0;
                                                }
                                             } catch (IOException var24) {
                                                class4.method46();
                                             }

                                             return;
                                          }

                                          var135 = var49.field2;
                                          if(var135.field2816 < 0) {
                                             break;
                                          }

                                          var52 = class148.method3129(var135.field2774);
                                       } while(var52 == null || var52.field2879 == null || var135.field2816 >= var52.field2879.length || var135 != var52.field2879[var135.field2816]);

                                       class93.method2183(var49);
                                    }
                                 }

                                 var135 = var49.field2;
                                 if(var135.field2816 < 0) {
                                    break;
                                 }

                                 var52 = class148.method3129(var135.field2774);
                              } while(null == var52 || null == var52.field2879 || var135.field2816 >= var52.field2879.length || var135 != var52.field2879[var135.field2816]);

                              class93.method2183(var49);
                           }
                        }

                        var135 = var49.field2;
                        if(var135.field2816 < 0) {
                           break;
                        }

                        var52 = class148.method3129(var135.field2774);
                     } while(var52 == null || null == var52.field2879 || var135.field2816 >= var52.field2879.length || var52.field2879[var135.field2816] != var135);

                     class93.method2183(var49);
                  }
               }

               client.field321.method2762(6);
               client.field321.method2565(0);
               var127 = client.field321.field1976;
               class159.method3176(client.field321);
               client.field321.method2524(client.field321.field1976 - var127);
            }
         }
      }
   }

   @ObfuscatedName("e")
   abstract void vmethod1885(int var1, int var2, Component var3);

   @ObfuscatedName("p")
   public static class224 method1695(class167 var0, class167 var1, int var2, int var3) {
      return !class23.method586(var0, var2, var3)?null:class22.method584(var1.method3280(var2, var3));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IZB)Lclass103;",
      garbageValue = "0"
   )
   public static class103 method1696(class167 var0, class167 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3265(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3261(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3261(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new class103(var0, var1, var2, var3);
         } catch (Exception var10) {
            return null;
         }
      }
   }
}
