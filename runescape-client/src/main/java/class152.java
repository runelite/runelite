import java.awt.Component;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public final class class152 {
   @ObfuscatedName("am")
   boolean[] field2069 = new boolean[256];
   @ObfuscatedName("h")
   final int field2070 = 6;
   @ObfuscatedName("aq")
   byte[] field2071 = new byte[256];
   @ObfuscatedName("ar")
   int[][] field2072 = new int[6][258];
   @ObfuscatedName("r")
   final int field2073 = 50;
   @ObfuscatedName("o")
   final int field2074 = 18002;
   @ObfuscatedName("l")
   byte[] field2075;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2004760733
   )
   int field2076 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1912144007
   )
   int field2077;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -969418231
   )
   int field2078;
   @ObfuscatedName("f")
   final int field2079 = 4096;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 271857575
   )
   int field2080;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 574577161
   )
   int field2081;
   @ObfuscatedName("d")
   byte field2082;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 991893387
   )
   int field2083;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -616689523
   )
   int field2084;
   @ObfuscatedName("iv")
   static Widget field2085;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1465621033
   )
   int field2086;
   @ObfuscatedName("aw")
   byte[] field2087 = new byte[18002];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1656895461
   )
   int field2088;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1001872961
   )
   int field2089;
   @ObfuscatedName("b")
   int[] field2090 = new int[256];
   @ObfuscatedName("u")
   final int field2091 = 258;
   @ObfuscatedName("t")
   int[] field2092 = new int[257];
   @ObfuscatedName("i")
   final int field2093 = 16;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1508519889
   )
   int field2094;
   @ObfuscatedName("an")
   boolean[] field2095 = new boolean[16];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2033030507
   )
   int field2096 = 0;
   @ObfuscatedName("ah")
   byte[] field2097 = new byte[4096];
   @ObfuscatedName("ag")
   int[] field2098 = new int[16];
   @ObfuscatedName("ab")
   byte[] field2099 = new byte[18002];
   @ObfuscatedName("w")
   byte[] field2100;
   @ObfuscatedName("ax")
   byte[][] field2101 = new byte[6][258];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1356079915
   )
   int field2102;
   @ObfuscatedName("ak")
   int[][] field2103 = new int[6][258];
   @ObfuscatedName("ai")
   int[][] field2104 = new int[6][258];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1277267533
   )
   int field2105;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 171419531
   )
   int field2106;
   @ObfuscatedName("ap")
   int[] field2108 = new int[6];

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-230624345"
   )
   public static void method2848(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1829 = 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1512014547"
   )
   public static boolean method2849(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-27"
   )
   static int method2850(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
         var4 = class32.field743[--class30.field713];
         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var27;
         if(var0 == 4101) {
            class32.scriptStringStackSize -= 2;
            var3 = class32.scriptStringStack[class32.scriptStringStackSize];
            var27 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + var27;
            return 1;
         } else {
            int var25;
            if(var0 == 4102) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.field743[--class30.field713];
               String[] var5 = class32.scriptStringStack;
               var25 = ++class32.scriptStringStackSize - 1;
               String var8;
               if(var4 < 0) {
                  var8 = Integer.toString(var4);
               } else {
                  int var10 = var4;
                  String var9;
                  if(var4 < 0) {
                     var9 = Integer.toString(var4, 10);
                  } else {
                     int var11 = 2;

                     for(int var12 = var4 / 10; var12 != 0; ++var11) {
                        var12 /= 10;
                     }

                     char[] var13 = new char[var11];
                     var13[0] = 43;

                     for(int var14 = var11 - 1; var14 > 0; --var14) {
                        int var15 = var10;
                        var10 /= 10;
                        int var16 = var15 - 10 * var10;
                        if(var16 >= 10) {
                           var13[var14] = (char)(87 + var16);
                        } else {
                           var13[var14] = (char)(var16 + 48);
                        }
                     }

                     var9 = new String(var13);
                  }

                  var8 = var9;
               }

               var5[var25] = var3 + var8;
               return 1;
            } else if(var0 == 4103) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.toLowerCase();
               return 1;
            } else {
               int var18;
               if(var0 == 4104) {
                  var18 = class32.field743[--class30.field713];
                  long var20 = 86400000L * ((long)var18 + 11745L);
                  class32.field752.setTime(new Date(var20));
                  var25 = class32.field752.get(5);
                  int var26 = class32.field752.get(2);
                  int var22 = class32.field752.get(1);
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var25 + "-" + class32.field744[var26] + "-" + var22;
                  return 1;
               } else if(var0 == 4105) {
                  class32.scriptStringStackSize -= 2;
                  var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                  var27 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                  if(null != Projectile.localPlayer.composition && Projectile.localPlayer.composition.isFemale) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var27;
                  } else {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var18 = class32.field743[--class30.field713];
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Integer.toString(var18);
                  return 1;
               } else if(var0 == 4107) {
                  class32.scriptStringStackSize -= 2;
                  class32.field743[++class30.field713 - 1] = class8.method89(ChatLineBuffer.method939(class32.scriptStringStack[class32.scriptStringStackSize], class32.scriptStringStack[class32.scriptStringStackSize + 1], Client.field308));
                  return 1;
               } else {
                  Font var19;
                  int var23;
                  byte[] var24;
                  if(var0 == 4108) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class30.field713 -= 2;
                     var4 = class32.field743[class30.field713];
                     var23 = class32.field743[class30.field713 + 1];
                     var24 = class5.field56.getConfigData(var23, 0);
                     var19 = new Font(var24);
                     class32.field743[++class30.field713 - 1] = var19.method3921(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class30.field713 -= 2;
                     var4 = class32.field743[class30.field713];
                     var23 = class32.field743[1 + class30.field713];
                     var24 = class5.field56.getConfigData(var23, 0);
                     var19 = new Font(var24);
                     class32.field743[++class30.field713 - 1] = var19.method3908(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class32.scriptStringStackSize -= 2;
                     var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                     var27 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                     if(class32.field743[--class30.field713] == 1) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
                     } else {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var27;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = FontTypeFace.method3900(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     var4 = class32.field743[--class30.field713];
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else {
                     boolean var6;
                     char var7;
                     int[] var17;
                     if(var0 == 4113) {
                        var18 = class32.field743[--class30.field713];
                        var17 = class32.field743;
                        var23 = ++class30.field713 - 1;
                        var7 = (char)var18;
                        if(var7 >= 32 && var7 <= 126) {
                           var6 = true;
                        } else if(var7 >= 160 && var7 <= 255) {
                           var6 = true;
                        } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                           var6 = false;
                        } else {
                           var6 = true;
                        }

                        var17[var23] = var6?1:0;
                        return 1;
                     } else if(var0 != 4114) {
                        if(var0 == 4115) {
                           var18 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = FrameMap.method1734((char)var18)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var18 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = class204.method3835((char)var18)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           if(null != var3) {
                              class32.field743[++class30.field713 - 1] = var3.length();
                           } else {
                              class32.field743[++class30.field713 - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           class30.field713 -= 2;
                           var4 = class32.field743[class30.field713];
                           var23 = class32.field743[1 + class30.field713];
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.substring(var4, var23);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           StringBuilder var28 = new StringBuilder(var3.length());
                           boolean var29 = false;

                           for(var25 = 0; var25 < var3.length(); ++var25) {
                              var7 = var3.charAt(var25);
                              if(var7 == 60) {
                                 var29 = true;
                              } else if(var7 == 62) {
                                 var29 = false;
                              } else if(!var29) {
                                 var28.append(var7);
                              }
                           }

                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var28.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           var4 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class32.scriptStringStackSize -= 2;
                           var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                           var27 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
                           var23 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = var3.indexOf(var27, var23);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var18 = class32.field743[--class30.field713];
                        var17 = class32.field743;
                        var23 = ++class30.field713 - 1;
                        var7 = (char)var18;
                        var6 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                        var17[var23] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
