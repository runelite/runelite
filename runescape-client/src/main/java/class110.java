import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public final class class110 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1184985269
   )
   int field1917;
   @ObfuscatedName("u")
   final int field1918 = 16;
   @ObfuscatedName("aj")
   int[] field1919 = new int[16];
   @ObfuscatedName("b")
   final int field1920 = 6;
   @ObfuscatedName("l")
   final int field1921 = 50;
   @ObfuscatedName("d")
   final int field1922 = 18002;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 593629249
   )
   int field1923;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1358418273
   )
   int field1924;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 197884543
   )
   int field1925;
   @ObfuscatedName("x")
   final int field1926 = 258;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1157663691
   )
   int field1927 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 909252675
   )
   int field1928;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1728195921
   )
   int field1929;
   @ObfuscatedName("q")
   byte field1930;
   @ObfuscatedName("as")
   byte[][] field1931 = new byte[6][258];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1862227541
   )
   int field1932;
   @ObfuscatedName("s")
   byte[] field1933;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1474771593
   )
   int field1934;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1804115133
   )
   int field1935 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1609632361
   )
   int field1937;
   @ObfuscatedName("c")
   int[] field1938 = new int[256];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1202874315
   )
   int field1939;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1379042503
   )
   int field1941;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -418317179
   )
   int field1942;
   @ObfuscatedName("am")
   int[][] field1943 = new int[6][258];
   @ObfuscatedName("ao")
   byte[] field1944 = new byte[256];
   @ObfuscatedName("ac")
   byte[] field1945 = new byte[4096];
   @ObfuscatedName("n")
   byte[] field1946;
   @ObfuscatedName("an")
   byte[] field1947 = new byte[18002];
   @ObfuscatedName("al")
   byte[] field1948 = new byte[18002];
   @ObfuscatedName("a")
   int[] field1949 = new int[257];
   @ObfuscatedName("av")
   int[][] field1950 = new int[6][258];
   @ObfuscatedName("az")
   int[][] field1952 = new int[6][258];
   @ObfuscatedName("ai")
   int[] field1953 = new int[6];
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 537512675
   )
   int field1954;
   @ObfuscatedName("ax")
   boolean[] field1955 = new boolean[16];
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1891276365
   )
   static int field1956;
   @ObfuscatedName("ag")
   boolean[] field1957 = new boolean[256];
   @ObfuscatedName("f")
   final int field1958 = 4096;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2062057181"
   )
   static final boolean method2474() {
      if(class172.field2742 == null) {
         return false;
      } else {
         int var17;
         String var18;
         try {
            int var0 = class172.field2742.method3012();
            if(var0 == 0) {
               return false;
            }

            if(client.field325 == -1) {
               class172.field2742.method3036(client.field335.field2000, 0, 1);
               client.field335.field1998 = 0;
               client.field325 = client.field335.method2787();
               client.field419 = class188.field3039[client.field325];
               --var0;
            }

            if(client.field419 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               class172.field2742.method3036(client.field335.field2000, 0, 1);
               client.field419 = client.field335.field2000[0] & 255;
               --var0;
            }

            if(client.field419 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               class172.field2742.method3036(client.field335.field2000, 0, 2);
               client.field335.field1998 = 0;
               client.field419 = client.field335.method2556();
               var0 -= 2;
            }

            if(var0 < client.field419) {
               return false;
            }

            client.field335.field1998 = 0;
            class172.field2742.method3036(client.field335.field2000, 0, client.field419);
            client.field338 = 0;
            client.field417 = client.field483;
            client.field483 = client.field304 * -1;
            client.field304 = client.field325 * -1;
            int var1;
            if(client.field325 == 43) {
               var1 = client.field335.method2696();
               class3 var44 = (class3)client.field448.method3822((long)var1);
               if(null != var44) {
                  class23.method628(var44, true);
               }

               if(null != client.field312) {
                  class39.method818(client.field312);
                  client.field312 = null;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 250) {
               client.field536 = true;
               client.field570 = client.field335.method2554();
               class99.field1685 = client.field335.method2554();
               class45.field1058 = client.field335.method2556();
               class149.field2242 = client.field335.method2554();
               class0.field11 = client.field335.method2554();
               if(class0.field11 >= 100) {
                  class216.field3160 = 64 + client.field570 * 128;
                  class26.field665 = 64 + class99.field1685 * 128;
                  class1.field27 = class74.method1659(class216.field3160, class26.field665, class14.field212) - class45.field1058;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 32) {
               var1 = client.field335.method2588();
               client.field391 = var1;
               class37.method805(false);
               class13.method168(var1);
               class156.method3185(client.field391);

               for(var17 = 0; var17 < 100; ++var17) {
                  client.field516[var17] = true;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 94) {
               class5.method71();
               client.field325 = -1;
               return false;
            }

            if(client.field325 == 73) {
               var1 = client.field335.method2554();
               if(client.field335.method2554() == 0) {
                  client.field564[var1] = new class220();
                  client.field335.field1998 += 18;
               } else {
                  --client.field335.field1998;
                  client.field564[var1] = new class220(client.field335, false);
               }

               client.field562 = client.field563;
               client.field325 = -1;
               return true;
            }

            int var5;
            int var6;
            int var7;
            boolean var42;
            boolean var74;
            if(client.field325 == 137) {
               var18 = client.field335.method2668();
               var17 = client.field335.method2556();
               byte var53 = client.field335.method2538();
               var42 = false;
               if(var53 == -128) {
                  var42 = true;
               }

               if(var42) {
                  if(class96.field1636 == 0) {
                     client.field325 = -1;
                     return true;
                  }

                  var74 = false;

                  for(var5 = 0; var5 < class96.field1636 && (!class35.field792[var5].field629.equals(var18) || var17 != class35.field792[var5].field622); ++var5) {
                     ;
                  }

                  if(var5 < class96.field1636) {
                     while(var5 < class96.field1636 - 1) {
                        class35.field792[var5] = class35.field792[var5 + 1];
                        ++var5;
                     }

                     --class96.field1636;
                     class35.field792[class96.field1636] = null;
                  }
               } else {
                  client.field335.method2668();
                  class24 var69 = new class24();
                  var69.field629 = var18;
                  var69.field624 = class138.method2969(var69.field629, client.field294);
                  var69.field622 = var17;
                  var69.field623 = var53;

                  for(var6 = class96.field1636 - 1; var6 >= 0; --var6) {
                     var7 = class35.field792[var6].field624.compareTo(var69.field624);
                     if(var7 == 0) {
                        class35.field792[var6].field622 = var17;
                        class35.field792[var6].field623 = var53;
                        if(var18.equals(class15.field225.field60)) {
                           class8.field148 = var53;
                        }

                        client.field542 = client.field563;
                        client.field325 = -1;
                        return true;
                     }

                     if(var7 < 0) {
                        break;
                     }
                  }

                  if(class96.field1636 >= class35.field792.length) {
                     client.field325 = -1;
                     return true;
                  }

                  for(var7 = class96.field1636 - 1; var7 > var6; --var7) {
                     class35.field792[var7 + 1] = class35.field792[var7];
                  }

                  if(class96.field1636 == 0) {
                     class35.field792 = new class24[100];
                  }

                  class35.field792[1 + var6] = var69;
                  ++class96.field1636;
                  if(var18.equals(class15.field225.field60)) {
                     class8.field148 = var53;
                  }
               }

               client.field542 = client.field563;
               client.field325 = -1;
               return true;
            }

            boolean var56;
            if(client.field325 == 231) {
               var56 = client.field335.method2554() == 1;
               if(var56) {
                  class8.field145 = class130.method2846() - client.field335.method2560();
                  class136.field2098 = new class221(client.field335, true);
               } else {
                  class136.field2098 = null;
               }

               client.field535 = client.field563;
               client.field325 = -1;
               return true;
            }

            class173 var20;
            if(client.field325 == 232) {
               var1 = client.field335.method2556();
               var17 = client.field335.method2598();
               var20 = class153.method3177(var17);
               if(var20 != null && var20.field2798 == 0) {
                  if(var1 > var20.field2778 - var20.field2888) {
                     var1 = var20.field2778 - var20.field2888;
                  }

                  if(var1 < 0) {
                     var1 = 0;
                  }

                  if(var1 != var20.field2776) {
                     var20.field2776 = var1;
                     class39.method818(var20);
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 69) {
               class32.field753 = 0;

               for(var1 = 0; var1 < 2048; ++var1) {
                  class32.field756[var1] = null;
                  class32.field767[var1] = 1;
               }

               for(var1 = 0; var1 < 2048; ++var1) {
                  client.field302[var1] = null;
               }

               class7.method112(client.field335);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 34) {
               class103.field1771 = client.field335.method2579();
               class12.field188 = client.field335.method2580();
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 225 || client.field325 == 46 || client.field325 == 206 || client.field325 == 229 || client.field325 == 230 || client.field325 == 90 || client.field325 == 138 || client.field325 == 175 || client.field325 == 38 || client.field325 == 16) {
               class1.method8();
               client.field325 = -1;
               return true;
            }

            int var3;
            class173 var67;
            if(client.field325 == 131) {
               var1 = client.field335.method2587();
               var17 = client.field335.method2730();
               var3 = client.field335.method2689();
               var67 = class153.method3177(var17);
               if(var67.field2763 != var3 || var1 != var67.field2753 || var67.field2759 != 0 || var67.field2858 != 0) {
                  var67.field2763 = var3;
                  var67.field2753 = var1;
                  var67.field2759 = 0;
                  var67.field2858 = 0;
                  class39.method818(var67);
                  class47.method1024(var67);
                  if(var67.field2798 == 0) {
                     class75.method1698(class173.field2770[var17 >> 16], var67, false);
                  }
               }

               client.field325 = -1;
               return true;
            }

            int var4;
            if(client.field325 == 106) {
               var17 = client.field335.method2554();
               class130[] var89 = class113.method2495();
               var4 = 0;

               class130 var71;
               while(true) {
                  if(var4 >= var89.length) {
                     var71 = null;
                     break;
                  }

                  class130 var66 = var89[var4];
                  if(var17 == var66.field2065) {
                     var71 = var66;
                     break;
                  }

                  ++var4;
               }

               class47.field1077 = var71;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 36) {
               client.field482 = client.field335.method2554();
               if(client.field482 == 255) {
                  client.field482 = 0;
               }

               client.field522 = client.field335.method2554();
               if(client.field522 == 255) {
                  client.field522 = 0;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 37) {
               for(var1 = 0; var1 < client.field302.length; ++var1) {
                  if(client.field302[var1] != null) {
                     client.field302[var1].field822 = -1;
                  }
               }

               for(var1 = 0; var1 < client.field328.length; ++var1) {
                  if(null != client.field328[var1]) {
                     client.field328[var1].field822 = -1;
                  }
               }

               client.field325 = -1;
               return true;
            }

            int var8;
            if(client.field325 == 65) {
               client.field542 = client.field563;
               if(client.field419 == 0) {
                  client.field514 = null;
                  client.field515 = null;
                  class96.field1636 = 0;
                  class35.field792 = null;
                  client.field325 = -1;
                  return true;
               }

               client.field515 = client.field335.method2668();
               long var57 = client.field335.method2560();
               client.field514 = class126.method2838(var57);
               class183.field2959 = client.field335.method2538();
               var3 = client.field335.method2554();
               if(var3 == 255) {
                  client.field325 = -1;
                  return true;
               }

               class96.field1636 = var3;
               class24[] var80 = new class24[100];

               for(var5 = 0; var5 < class96.field1636; ++var5) {
                  var80[var5] = new class24();
                  var80[var5].field629 = client.field335.method2668();
                  var80[var5].field624 = class138.method2969(var80[var5].field629, client.field294);
                  var80[var5].field622 = client.field335.method2556();
                  var80[var5].field623 = client.field335.method2538();
                  client.field335.method2668();
                  if(var80[var5].field629.equals(class15.field225.field60)) {
                     class8.field148 = var80[var5].field623;
                  }
               }

               var74 = false;
               var7 = class96.field1636;

               while(var7 > 0) {
                  var74 = true;
                  --var7;

                  for(var8 = 0; var8 < var7; ++var8) {
                     if(var80[var8].field624.compareTo(var80[1 + var8].field624) > 0) {
                        class24 var81 = var80[var8];
                        var80[var8] = var80[1 + var8];
                        var80[1 + var8] = var81;
                        var74 = false;
                     }
                  }

                  if(var74) {
                     break;
                  }
               }

               class35.field792 = var80;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 183) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2587();
               var20 = class153.method3177(var1);
               if(var17 != var20.field2756 || var17 == -1) {
                  var20.field2756 = var17;
                  var20.field2876 = 0;
                  var20.field2743 = 0;
                  class39.method818(var20);
               }

               client.field325 = -1;
               return true;
            }

            String var2;
            String var72;
            if(client.field325 == 174) {
               var18 = client.field335.method2668();
               class122 var87 = client.field335;
               var2 = class178.method3498(var87, 32767);
               var72 = class223.method4069(class15.method185(var2));
               class52.method1147(6, var18, var72);
               client.field325 = -1;
               return true;
            }

            class122 var60;
            class2 var75;
            if(client.field325 == 64) {
               var60 = client.field335;
               var17 = client.field419;
               var3 = var60.field1998;
               class32.field765 = 0;
               var4 = 0;
               var60.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var60.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var60);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var60, var6);
                        }
                     }
                  }
               }

               var60.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var60.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var60.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var60);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var60, var6);
                        }
                     }
                  }
               }

               var60.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var60.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var60.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var60);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var60, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var60.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var60.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var60.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var60);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var60, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var60.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class32.field753 = 0;
               class32.field760 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class32.field755[var5] = (byte)(class32.field755[var5] >> 1);
                  var75 = client.field302[var5];
                  if(var75 != null) {
                     class32.field761[++class32.field753 - 1] = var5;
                  } else {
                     class32.field769[++class32.field760 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class32.field765; ++var4) {
                  var5 = class32.field768[var4];
                  var75 = client.field302[var5];
                  var7 = var60.method2554();
                  if((var7 & 8) != 0) {
                     var7 += var60.method2554() << 8;
                  }

                  class103.method2345(var60, var5, var75, var7);
               }

               if(var17 != var60.field1998 - var3) {
                  throw new RuntimeException(var60.field1998 - var3 + " " + var17);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 148) {
               class136.method2930(true);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 23) {
               for(var1 = 0; var1 < class129.field2054; ++var1) {
                  class52 var43 = class158.method3191(var1);
                  if(var43 != null) {
                     class176.field2903[var1] = 0;
                     class176.field2905[var1] = 0;
                  }
               }

               class130.method2848();
               client.field290 += 32;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 55) {
               var18 = client.field335.method2668();
               var17 = client.field335.method2598();
               var20 = class153.method3177(var17);
               if(!var18.equals(var20.field2814)) {
                  var20.field2814 = var18;
                  class39.method818(var20);
               }

               client.field325 = -1;
               return true;
            }

            boolean var11;
            String var68;
            if(client.field325 == 48) {
               while(client.field335.field1998 < client.field419) {
                  var56 = client.field335.method2554() == 1;
                  var2 = client.field335.method2668();
                  var68 = client.field335.method2668();
                  var4 = client.field335.method2556();
                  var5 = client.field335.method2554();
                  var6 = client.field335.method2554();
                  boolean var55 = (var6 & 2) != 0;
                  boolean var47 = (var6 & 1) != 0;
                  if(var4 > 0) {
                     client.field335.method2668();
                     client.field335.method2554();
                     client.field335.method2696();
                  }

                  client.field335.method2668();

                  for(int var51 = 0; var51 < client.field555; ++var51) {
                     class17 var50 = client.field557[var51];
                     if(!var56) {
                        if(var2.equals(var50.field254)) {
                           if(var50.field249 != var4) {
                              var11 = true;

                              for(class38 var54 = (class38)client.field558.method3810(); var54 != null; var54 = (class38)client.field558.method3817()) {
                                 if(var54.field885.equals(var2)) {
                                    if(var4 != 0 && var54.field886 == 0) {
                                       var54.method3936();
                                       var11 = false;
                                    } else if(var4 == 0 && var54.field886 != 0) {
                                       var54.method3936();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 client.field558.method3809(new class38(var2, var4));
                              }

                              var50.field249 = var4;
                           }

                           var50.field248 = var68;
                           var50.field260 = var5;
                           var50.field251 = var55;
                           var50.field252 = var47;
                           var2 = null;
                           break;
                        }
                     } else if(var68.equals(var50.field254)) {
                        var50.field254 = var2;
                        var50.field248 = var68;
                        var2 = null;
                        break;
                     }
                  }

                  if(null != var2 && client.field555 < 400) {
                     class17 var23 = new class17();
                     client.field557[client.field555] = var23;
                     var23.field254 = var2;
                     var23.field248 = var68;
                     var23.field249 = var4;
                     var23.field260 = var5;
                     var23.field251 = var55;
                     var23.field252 = var47;
                     ++client.field555;
                  }
               }

               client.field397 = 2;
               client.field480 = client.field563;
               var56 = false;
               var17 = client.field555;

               while(var17 > 0) {
                  var56 = true;
                  --var17;

                  for(var3 = 0; var3 < var17; ++var3) {
                     var42 = false;
                     class17 var65 = client.field557[var3];
                     class17 var79 = client.field557[var3 + 1];
                     if(var65.field249 != client.field386 && var79.field249 == client.field386) {
                        var42 = true;
                     }

                     if(!var42 && var65.field249 == 0 && var79.field249 != 0) {
                        var42 = true;
                     }

                     if(!var42 && !var65.field251 && var79.field251) {
                        var42 = true;
                     }

                     if(!var42 && !var65.field252 && var79.field252) {
                        var42 = true;
                     }

                     if(var42) {
                        class17 var86 = client.field557[var3];
                        client.field557[var3] = client.field557[var3 + 1];
                        client.field557[1 + var3] = var86;
                        var56 = false;
                     }
                  }

                  if(var56) {
                     break;
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 51) {
               class130.method2848();
               client.field453 = client.field335.method2557();
               client.field527 = client.field563;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 20) {
               var1 = client.field335.method2598();
               var17 = client.field335.method2695();
               var20 = class153.method3177(var1);
               if(var20.field2797 != 2 || var20.field2768 != var17) {
                  var20.field2797 = 2;
                  var20.field2768 = var17;
                  class39.method818(var20);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 191) {
               if(client.field391 != -1) {
                  class34.method767(client.field391, 0);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 176) {
               client.field309 = client.field335.method2556() * 30;
               client.field527 = client.field563;
               client.field325 = -1;
               return true;
            }

            class173 var61;
            if(client.field325 == 214) {
               var1 = client.field335.method2556();
               var17 = client.field335.method2556();
               var3 = client.field335.method2598();
               var4 = client.field335.method2695();
               var61 = class153.method3177(var3);
               if(var4 != var61.field2805 || var61.field2806 != var1 || var61.field2874 != var17) {
                  var61.field2805 = var4;
                  var61.field2806 = var1;
                  var61.field2874 = var17;
                  class39.method818(var61);
               }

               client.field325 = -1;
               return true;
            }

            class173 var37;
            if(client.field325 == 14) {
               var1 = client.field335.method2596();
               var37 = class153.method3177(var1);
               var37.field2797 = 3;
               var37.field2768 = class15.field225.field36.method3516();
               class39.method818(var37);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 217) {
               class77.method1742(client.field335, client.field419);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 96) {
               class12.field188 = client.field335.method2579();
               class103.field1771 = client.field335.method2581();

               for(var1 = class12.field188; var1 < 8 + class12.field188; ++var1) {
                  for(var17 = class103.field1771; var17 < 8 + class103.field1771; ++var17) {
                     if(client.field572[class14.field212][var1][var17] != null) {
                        client.field572[class14.field212][var1][var17] = null;
                        class160.method3204(var1, var17);
                     }
                  }
               }

               for(class16 var63 = (class16)client.field421.method3852(); null != var63; var63 = (class16)client.field421.method3857()) {
                  if(var63.field233 >= class12.field188 && var63.field233 < 8 + class12.field188 && var63.field231 >= class103.field1771 && var63.field231 < class103.field1771 + 8 && var63.field241 == class14.field212) {
                     var63.field239 = 0;
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 211) {
               client.field335.field1998 += 28;
               if(client.field335.method2576()) {
                  var60 = client.field335;
                  var17 = client.field335.field1998 - 28;
                  if(class149.field2241 != null) {
                     try {
                        class149.field2241.method4167(0L);
                        class149.field2241.method4189(var60.field2000, var17, 24);
                     } catch (Exception var32) {
                        ;
                     }
                  }
               }

               client.field325 = -1;
               return true;
            }

            class122 var40;
            if(client.field325 == 33) {
               class32.method745(true);
               client.field335.method2787();
               var1 = client.field335.method2556();
               var40 = client.field335;
               var3 = var40.field1998;
               class32.field765 = 0;
               var4 = 0;
               var40.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var40, var6);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var40, var6);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var40, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var40, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class32.field753 = 0;
               class32.field760 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class32.field755[var5] = (byte)(class32.field755[var5] >> 1);
                  var75 = client.field302[var5];
                  if(var75 != null) {
                     class32.field761[++class32.field753 - 1] = var5;
                  } else {
                     class32.field769[++class32.field760 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class32.field765; ++var4) {
                  var5 = class32.field768[var4];
                  var75 = client.field302[var5];
                  var7 = var40.method2554();
                  if((var7 & 8) != 0) {
                     var7 += var40.method2554() << 8;
                  }

                  class103.method2345(var40, var5, var75, var7);
               }

               if(var1 != var40.field1998 - var3) {
                  throw new RuntimeException(var40.field1998 - var3 + " " + var1);
               }

               client.field325 = -1;
               return true;
            }

            String var12;
            String var15;
            int var16;
            long var41;
            long var62;
            if(client.field325 == 132) {
               var18 = client.field335.method2668();
               var62 = (long)client.field335.method2556();
               var41 = (long)client.field335.method2558();
               class152 var77 = (class152)class14.method177(class9.method135(), client.field335.method2554());
               long var52 = var41 + (var62 << 32);
               boolean var49 = false;

               for(int var82 = 0; var82 < 100; ++var82) {
                  if(var52 == client.field508[var82]) {
                     var49 = true;
                     break;
                  }
               }

               if(class2.method43(var18)) {
                  var49 = true;
               }

               if(!var49 && client.field409 == 0) {
                  client.field508[client.field509] = var52;
                  client.field509 = (1 + client.field509) % 100;
                  class122 var26 = client.field335;
                  String var10 = class178.method3498(var26, 32767);
                  var12 = class223.method4069(class15.method185(var10));
                  byte var13;
                  if(var77.field2261) {
                     var13 = 7;
                  } else {
                     var13 = 3;
                  }

                  if(var77.field2260 != -1) {
                     var16 = var77.field2260;
                     var15 = "<img=" + var16 + ">";
                     class52.method1147(var13, var15 + var18, var12);
                  } else {
                     class52.method1147(var13, var18, var12);
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 213) {
               class136.method2930(false);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 66) {
               class11.method147(client.field335.method2668());
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 82) {
               client.field523 = client.field335.method2554();
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 113) {
               var1 = client.field335.method2588();
               var17 = client.field335.method2596();
               var20 = class153.method3177(var17);
               if(var20.field2797 != 1 || var1 != var20.field2768) {
                  var20.field2797 = 1;
                  var20.field2768 = var1;
                  class39.method818(var20);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 180) {
               class25 var58 = new class25();
               var58.field643 = client.field335.method2668();
               var58.field640 = client.field335.method2556();
               var17 = client.field335.method2696();
               var58.field641 = var17;
               class11.method156(45);
               class172.field2742.method3013();
               class172.field2742 = null;
               class107.method2431(var58);
               client.field325 = -1;
               return false;
            }

            class3 var21;
            if(client.field325 == 147) {
               var1 = client.field335.method2598();
               var17 = client.field335.method2596();
               class3 var84 = (class3)client.field448.method3822((long)var17);
               var21 = (class3)client.field448.method3822((long)var1);
               if(var21 != null) {
                  class23.method628(var21, null == var84 || var21.field64 != var84.field64);
               }

               if(var84 != null) {
                  var84.method3946();
                  client.field448.method3826(var84, (long)var1);
               }

               var61 = class153.method3177(var17);
               if(var61 != null) {
                  class39.method818(var61);
               }

               var61 = class153.method3177(var1);
               if(var61 != null) {
                  class39.method818(var61);
                  class75.method1698(class173.field2770[var61.field2869 >>> 16], var61, true);
               }

               if(client.field391 != -1) {
                  class34.method767(client.field391, 1);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 56) {
               class130.method2848();
               var1 = client.field335.method2579();
               var17 = client.field335.method2598();
               var3 = client.field335.method2580();
               client.field426[var1] = var17;
               client.field424[var1] = var3;
               client.field425[var1] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var17 >= class155.field2287[var4]) {
                     client.field425[var1] = var4 + 2;
                  }
               }

               client.field477[++client.field478 - 1 & 31] = var1;
               client.field325 = -1;
               return true;
            }

            long var45;
            if(client.field325 == 125) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2696();
               if(null == class188.field3049 || !class188.field3049.isValid()) {
                  try {
                     Iterator var83 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var83.hasNext()) {
                        GarbageCollectorMXBean var78 = (GarbageCollectorMXBean)var83.next();
                        if(var78.isValid()) {
                           class188.field3049 = var78;
                           client.field484 = -1L;
                           client.field365 = -1L;
                        }
                     }
                  } catch (Throwable var33) {
                     ;
                  }
               }

               long var48 = class130.method2846();
               var5 = -1;
               if(null != class188.field3049) {
                  var45 = class188.field3049.getCollectionTime();
                  if(-1L != client.field365) {
                     long var46 = var45 - client.field365;
                     long var25 = var48 - client.field484;
                     if(0L != var25) {
                        var5 = (int)(100L * var46 / var25);
                     }
                  }

                  client.field365 = var45;
                  client.field484 = var48;
               }

               client.field333.method2773(184);
               client.field333.method2654(var5);
               client.field333.method2539(var1);
               client.field333.method2593(var17);
               client.field333.method2578(class144.field2194);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 104) {
               client.field536 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  client.field525[var1] = false;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 177) {
               var1 = client.field335.method2598();
               var17 = client.field335.method2556();
               var3 = var17 >> 10 & 31;
               var4 = var17 >> 5 & 31;
               var5 = var17 & 31;
               var6 = (var3 << 19) + (var4 << 11) + (var5 << 3);
               class173 var85 = class153.method3177(var1);
               if(var6 != var85.field2779) {
                  var85.field2779 = var6;
                  class39.method818(var85);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 249) {
               for(var1 = 0; var1 < class176.field2905.length; ++var1) {
                  if(class176.field2903[var1] != class176.field2905[var1]) {
                     class176.field2905[var1] = class176.field2903[var1];
                     class21.method615(var1);
                     client.field408[++client.field290 - 1 & 31] = var1;
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 195) {
               var1 = client.field335.method2556();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var17 = client.field335.method2596();
               var3 = client.field335.method2598();
               var67 = class153.method3177(var17);
               class51 var59;
               if(!var67.field2860) {
                  if(var1 == -1) {
                     var67.field2797 = 0;
                     client.field325 = -1;
                     return true;
                  }

                  var59 = class141.method3001(var1);
                  var67.field2797 = 4;
                  var67.field2768 = var1;
                  var67.field2805 = var59.field1117;
                  var67.field2806 = var59.field1129;
                  var67.field2874 = var59.field1127 * 100 / var3;
                  class39.method818(var67);
               } else {
                  var67.field2764 = var1;
                  var67.field2794 = var3;
                  var59 = class141.method3001(var1);
                  var67.field2805 = var59.field1117;
                  var67.field2806 = var59.field1129;
                  var67.field2746 = var59.field1131;
                  var67.field2803 = var59.field1133;
                  var67.field2804 = var59.field1132;
                  var67.field2874 = var59.field1127;
                  if(var59.field1151 == 1) {
                     var67.field2812 = 1;
                  } else {
                     var67.field2812 = 2;
                  }

                  if(var67.field2809 > 0) {
                     var67.field2874 = var67.field2874 * 32 / var67.field2809;
                  } else if(var67.field2825 > 0) {
                     var67.field2874 = var67.field2874 * 32 / var67.field2825;
                  }

                  class39.method818(var67);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 251) {
               client.field397 = 1;
               client.field480 = client.field563;
               client.field325 = -1;
               return true;
            }

            long var9;
            if(client.field325 == 84) {
               var1 = client.field335.field1998 + client.field419;
               var17 = client.field335.method2556();
               var3 = client.field335.method2556();
               if(var17 != client.field391) {
                  client.field391 = var17;
                  class37.method805(false);
                  class13.method168(client.field391);
                  class156.method3185(client.field391);

                  for(var4 = 0; var4 < 100; ++var4) {
                     client.field516[var4] = true;
                  }
               }

               class3 var24;
               for(; var3-- > 0; var24.field68 = true) {
                  var4 = client.field335.method2696();
                  var5 = client.field335.method2556();
                  var6 = client.field335.method2554();
                  var24 = (class3)client.field448.method3822((long)var4);
                  if(null != var24 && var24.field64 != var5) {
                     class23.method628(var24, true);
                     var24 = null;
                  }

                  if(null == var24) {
                     var24 = class0.method3(var4, var5, var6);
                  }
               }

               for(var21 = (class3)client.field448.method3825(); var21 != null; var21 = (class3)client.field448.method3823()) {
                  if(var21.field68) {
                     var21.field68 = false;
                  } else {
                     class23.method628(var21, true);
                  }
               }

               client.field489 = new class196(512);

               while(client.field335.field1998 < var1) {
                  var4 = client.field335.method2696();
                  var5 = client.field335.method2556();
                  var6 = client.field335.method2556();
                  var7 = client.field335.method2696();

                  for(var8 = var5; var8 <= var6; ++var8) {
                     var9 = (long)var8 + ((long)var4 << 32);
                     client.field489.method3826(new class201(var7), var9);
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 42) {
               class32.method745(false);
               client.field335.method2787();
               var1 = client.field335.method2556();
               var40 = client.field335;
               var3 = var40.field1998;
               class32.field765 = 0;
               var4 = 0;
               var40.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var40, var6);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field753; ++var5) {
                  var6 = class32.field761[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else {
                           class22.method622(var40, var6);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) != 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var40, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               var40.method2775();

               for(var5 = 0; var5 < class32.field760; ++var5) {
                  var6 = class32.field769[var5];
                  if((class32.field755[var6] & 1) == 0) {
                     if(var4 > 0) {
                        --var4;
                        class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                     } else {
                        var7 = var40.method2776(1);
                        if(var7 == 0) {
                           var4 = class51.method1126(var40);
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        } else if(class121.method2766(var40, var6)) {
                           class32.field755[var6] = (byte)(class32.field755[var6] | 2);
                        }
                     }
                  }
               }

               var40.method2791();
               if(var4 != 0) {
                  throw new RuntimeException();
               }

               class32.field753 = 0;
               class32.field760 = 0;

               for(var5 = 1; var5 < 2048; ++var5) {
                  class32.field755[var5] = (byte)(class32.field755[var5] >> 1);
                  var75 = client.field302[var5];
                  if(var75 != null) {
                     class32.field761[++class32.field753 - 1] = var5;
                  } else {
                     class32.field769[++class32.field760 - 1] = var5;
                  }
               }

               for(var4 = 0; var4 < class32.field765; ++var4) {
                  var5 = class32.field768[var4];
                  var75 = client.field302[var5];
                  var7 = var40.method2554();
                  if((var7 & 8) != 0) {
                     var7 += var40.method2554() << 8;
                  }

                  class103.method2345(var40, var5, var75, var7);
               }

               if(var40.field1998 - var3 != var1) {
                  throw new RuntimeException(var40.field1998 - var3 + " " + var1);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 171) {
               var1 = client.field335.method2695();
               class15 var39 = (class15)class15.field229.method3822((long)var1);
               if(var39 != null) {
                  var39.method3946();
               }

               client.field475[++client.field476 - 1 & 31] = var1 & 32767;
               client.field325 = -1;
               return true;
            }

            boolean var64;
            if(client.field325 == 81) {
               Object var10000;
               for(; client.field335.field1998 < client.field419; var10000 = null) {
                  var1 = client.field335.method2554();
                  var64 = (var1 & 1) == 1;
                  var68 = client.field335.method2668();
                  var72 = client.field335.method2668();
                  client.field335.method2668();

                  for(var5 = 0; var5 < client.field559; ++var5) {
                     class7 var22 = client.field560[var5];
                     if(var64) {
                        if(var72.equals(var22.field134)) {
                           var22.field134 = var68;
                           var22.field137 = var72;
                           var20 = null;
                           break;
                        }
                     } else if(var68.equals(var22.field134)) {
                        var22.field134 = var68;
                        var22.field137 = var72;
                        var20 = null;
                        break;
                     }
                  }
               }

               client.field480 = client.field563;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 3) {
               var1 = client.field335.method2588();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               if(var1 == -1 && !client.field526) {
                  class38.method807();
               } else if(var1 != -1 && var1 != client.field315 && client.field524 != 0 && !client.field526) {
                  class168 var38 = class17.field261;
                  var3 = client.field524;
                  class183.field2953 = 1;
                  class20.field582 = var38;
                  class21.field589 = var1;
                  class213.field3145 = 0;
                  class183.field2956 = var3;
                  class20.field583 = false;
                  class183.field2957 = 2;
               }

               client.field315 = var1;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 167) {
               var1 = client.field335.method2558();
               var17 = client.field335.method2588();
               if(var17 == '\uffff') {
                  var17 = -1;
               }

               if(client.field524 != 0 && var17 != -1) {
                  class96.method2261(class152.field2257, var17, 0, client.field524, false);
                  client.field526 = true;
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 178) {
               var1 = client.field335.method2598();
               var37 = class153.method3177(var1);

               for(var3 = 0; var3 < var37.field2889.length; ++var3) {
                  var37.field2889[var3] = -1;
                  var37.field2889[var3] = 0;
               }

               class39.method818(var37);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 74) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2556();
               if(var1 < -70000) {
                  var17 += '耀';
               }

               if(var1 >= 0) {
                  var20 = class153.method3177(var1);
               } else {
                  var20 = null;
               }

               class15 var70 = (class15)class15.field229.method3822((long)var17);
               if(null != var70) {
                  for(var5 = 0; var5 < var70.field221.length; ++var5) {
                     var70.field221[var5] = -1;
                     var70.field223[var5] = 0;
                  }
               }

               var4 = client.field335.method2556();

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = client.field335.method2695();
                  var7 = client.field335.method2579();
                  if(var7 == 255) {
                     var7 = client.field335.method2598();
                  }

                  if(var20 != null && var5 < var20.field2889.length) {
                     var20.field2889[var5] = var6;
                     var20.field2750[var5] = var7;
                  }

                  class26.method677(var17, var5, var6 - 1, var7);
               }

               if(null != var20) {
                  class39.method818(var20);
               }

               class130.method2848();
               client.field475[++client.field476 - 1 & 31] = var17 & 32767;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 8) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2696();
               var3 = client.field335.method2556();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = client.field335.method2588();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var5 = var3; var5 <= var4; ++var5) {
                  var45 = ((long)var1 << 32) + (long)var5;
                  class208 var88 = client.field489.method3822(var45);
                  if(null != var88) {
                     var88.method3946();
                  }

                  client.field489.method3826(new class201(var17), var45);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 47) {
               var1 = client.field335.method2588();
               byte var73 = client.field335.method2538();
               class176.field2903[var1] = var73;
               if(class176.field2905[var1] != var73) {
                  class176.field2905[var1] = var73;
               }

               class21.method615(var1);
               client.field408[++client.field290 - 1 & 31] = var1;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 241) {
               var1 = client.field335.method2554();
               var17 = client.field335.method2554();
               var3 = client.field335.method2554();
               var4 = client.field335.method2554();
               client.field525[var1] = true;
               client.field538[var1] = var17;
               client.field539[var1] = var3;
               client.field540[var1] = var4;
               client.field541[var1] = 0;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 126) {
               var18 = client.field335.method2668();
               Object[] var36 = new Object[var18.length() + 1];

               for(var3 = var18.length() - 1; var3 >= 0; --var3) {
                  if(var18.charAt(var3) == 115) {
                     var36[1 + var3] = client.field335.method2668();
                  } else {
                     var36[var3 + 1] = new Integer(client.field335.method2696());
                  }
               }

               var36[0] = new Integer(client.field335.method2696());
               class0 var76 = new class0();
               var76.field0 = var36;
               class31.method737(var76, 200000);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 135) {
               client.field457 = client.field335.method2554();
               if(client.field457 == 1) {
                  client.field311 = client.field335.method2556();
               }

               if(client.field457 >= 2 && client.field457 <= 6) {
                  if(client.field457 == 2) {
                     client.field316 = 64;
                     client.field317 = 64;
                  }

                  if(client.field457 == 3) {
                     client.field316 = 0;
                     client.field317 = 64;
                  }

                  if(client.field457 == 4) {
                     client.field316 = 128;
                     client.field317 = 64;
                  }

                  if(client.field457 == 5) {
                     client.field316 = 64;
                     client.field317 = 0;
                  }

                  if(client.field457 == 6) {
                     client.field316 = 64;
                     client.field317 = 128;
                  }

                  client.field457 = 2;
                  client.field313 = client.field335.method2556();
                  client.field314 = client.field335.method2556();
                  client.field440 = client.field335.method2554();
               }

               if(client.field457 == 10) {
                  client.field360 = client.field335.method2556();
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 99) {
               var1 = client.field335.method2730();
               class185.field2999 = class7.field136.method2918(var1);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 44) {
               class103.field1771 = client.field335.method2581();
               class12.field188 = client.field335.method2579();

               while(client.field335.field1998 < client.field419) {
                  client.field325 = client.field335.method2554();
                  class1.method8();
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 162) {
               var1 = client.field335.method2696();
               var64 = client.field335.method2579() == 1;
               var20 = class153.method3177(var1);
               if(var20.field2774 != var64) {
                  var20.field2774 = var64;
                  class39.method818(var20);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 166) {
               var1 = client.field335.method2556();
               var17 = client.field335.method2597();
               var3 = client.field335.method2596();
               var67 = class153.method3177(var3);
               var67.field2810 = var1 + (var17 << 16);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 95) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2695();
               class176.field2903[var17] = var1;
               if(var1 != class176.field2905[var17]) {
                  class176.field2905[var17] = var1;
               }

               class21.method615(var17);
               client.field408[++client.field290 - 1 & 31] = var17;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 221) {
               var1 = client.field335.method2567();
               var64 = client.field335.method2554() == 1;
               var68 = "";
               var42 = false;
               if(var64) {
                  var68 = client.field335.method2668();
                  if(class2.method43(var68)) {
                     var42 = true;
                  }
               }

               String var19 = client.field335.method2668();
               if(!var42) {
                  class52.method1147(var1, var68, var19);
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 200) {
               var18 = client.field335.method2668();
               var62 = client.field335.method2560();
               var41 = (long)client.field335.method2556();
               var45 = (long)client.field335.method2558();
               class152 var27 = (class152)class14.method177(class9.method135(), client.field335.method2554());
               var9 = (var41 << 32) + var45;
               var11 = false;

               for(int var28 = 0; var28 < 100; ++var28) {
                  if(var9 == client.field508[var28]) {
                     var11 = true;
                     break;
                  }
               }

               if(var27.field2262 && class2.method43(var18)) {
                  var11 = true;
               }

               if(!var11 && client.field409 == 0) {
                  client.field508[client.field509] = var9;
                  client.field509 = (client.field509 + 1) % 100;
                  class122 var29 = client.field335;
                  var12 = class178.method3498(var29, 32767);
                  String var30 = class223.method4069(class15.method185(var12));
                  if(var27.field2260 != -1) {
                     var16 = var27.field2260;
                     var15 = "<img=" + var16 + ">";
                     class122.method2795(9, var15 + var18, var30, class41.method894(var62));
                  } else {
                     class122.method2795(9, var18, var30, class41.method894(var62));
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 10) {
               var1 = client.field335.method2556();
               var17 = client.field335.method2554();
               var3 = client.field335.method2556();
               class87.method2139(var1, var17, var3);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 31) {
               class130.method2848();
               client.field452 = client.field335.method2554();
               client.field527 = client.field563;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 92) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2556();
               var3 = client.field335.method2581();
               var21 = (class3)client.field448.method3822((long)var1);
               if(null != var21) {
                  class23.method628(var21, var21.field64 != var17);
               }

               class0.method3(var1, var17, var3);
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 71) {
               client.field505 = client.field335.method2554();
               client.field506 = client.field335.method2554();
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 140) {
               client.field536 = true;
               class136.field2091 = client.field335.method2554();
               class44.field1050 = client.field335.method2554();
               class137.field2128 = client.field335.method2556();
               class155.field2289 = client.field335.method2554();
               class89.field1558 = client.field335.method2554();
               if(class89.field1558 >= 100) {
                  var1 = class136.field2091 * 128 + 64;
                  var17 = 64 + class44.field1050 * 128;
                  var3 = class74.method1659(var1, var17, class14.field212) - class137.field2128;
                  var4 = var1 - class216.field3160;
                  var5 = var3 - class1.field27;
                  var6 = var17 - class26.field665;
                  var7 = (int)Math.sqrt((double)(var6 * var6 + var4 * var4));
                  class134.field2082 = (int)(Math.atan2((double)var5, (double)var7) * 325.949D) & 2047;
                  class42.field1018 = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                  if(class134.field2082 < 128) {
                     class134.field2082 = 128;
                  }

                  if(class134.field2082 > 383) {
                     class134.field2082 = 383;
                  }
               }

               client.field325 = -1;
               return true;
            }

            if(client.field325 == 189) {
               var1 = client.field335.method2696();
               var17 = client.field335.method2556();
               if(var1 < -70000) {
                  var17 += '耀';
               }

               if(var1 >= 0) {
                  var20 = class153.method3177(var1);
               } else {
                  var20 = null;
               }

               for(; client.field335.field1998 < client.field419; class26.method677(var17, var4, var5 - 1, var6)) {
                  var4 = client.field335.method2567();
                  var5 = client.field335.method2556();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = client.field335.method2554();
                     if(var6 == 255) {
                        var6 = client.field335.method2696();
                     }
                  }

                  if(null != var20 && var4 >= 0 && var4 < var20.field2889.length) {
                     var20.field2889[var4] = var5;
                     var20.field2750[var4] = var6;
                  }
               }

               if(var20 != null) {
                  class39.method818(var20);
               }

               class130.method2848();
               client.field475[++client.field476 - 1 & 31] = var17 & 32767;
               client.field325 = -1;
               return true;
            }

            if(client.field325 == 30) {
               var1 = client.field335.method2554();
               var2 = client.field335.method2668();
               var3 = client.field335.method2579();
               if(var1 >= 1 && var1 <= 8) {
                  if(var2.equalsIgnoreCase("null")) {
                     var2 = null;
                  }

                  client.field416[var1 - 1] = var2;
                  client.field376[var1 - 1] = var3 == 0;
               }

               client.field325 = -1;
               return true;
            }

            class45.method984("" + client.field325 + "," + client.field483 + "," + client.field417 + "," + client.field419, (Throwable)null);
            class5.method71();
         } catch (IOException var34) {
            if(client.field343 > 0) {
               class5.method71();
            } else {
               class11.method156(40);
               class9.field158 = class172.field2742;
               class172.field2742 = null;
            }
         } catch (Exception var35) {
            var18 = "" + client.field325 + "," + client.field483 + "," + client.field417 + "," + client.field419 + "," + (class172.field2734 + class15.field225.field875[0]) + "," + (class20.field576 + class15.field225.field876[0]) + ",";

            for(var17 = 0; var17 < client.field419 && var17 < 50; ++var17) {
               var18 = var18 + client.field335.field2000[var17] + ",";
            }

            class45.method984(var18, var35);
            class5.method71();
         }

         return true;
      }
   }
}
