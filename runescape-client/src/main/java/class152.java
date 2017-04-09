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
         String var5;
         if(var0 == 4101) {
            class32.scriptStringStackSize -= 2;
            var3 = class32.scriptStringStack[class32.scriptStringStackSize];
            var5 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + var5;
            return 1;
         } else {
            int var6;
            int var7;
            int var8;
            int var21;
            if(var0 == 4102) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.field743[--class30.field713];
               String[] var18 = class32.scriptStringStack;
               var6 = ++class32.scriptStringStackSize - 1;
               String var19;
               if(var4 < 0) {
                  var19 = Integer.toString(var4);
               } else {
                  var7 = var4;
                  String var20;
                  if(var4 < 0) {
                     var20 = Integer.toString(var4, 10);
                  } else {
                     var8 = 2;

                     for(var21 = var4 / 10; var21 != 0; ++var8) {
                        var21 /= 10;
                     }

                     char[] var24 = new char[var8];
                     var24[0] = 43;

                     for(int var22 = var8 - 1; var22 > 0; --var22) {
                        int var23 = var7;
                        var7 /= 10;
                        int var25 = var23 - var7 * 10;
                        if(var25 >= 10) {
                           var24[var22] = (char)(var25 + 87);
                        } else {
                           var24[var22] = (char)(var25 + 48);
                        }
                     }

                     var20 = new String(var24);
                  }

                  var19 = var20;
               }

               var18[var6] = var3 + var19;
               return 1;
            } else if(var0 == 4103) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.toLowerCase();
               return 1;
            } else {
               int var9;
               if(var0 == 4104) {
                  var9 = class32.field743[--class30.field713];
                  long var17 = 86400000L * ((long)var9 + 11745L);
                  class32.field752.setTime(new Date(var17));
                  var6 = class32.field752.get(5);
                  var21 = class32.field752.get(2);
                  var8 = class32.field752.get(1);
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var6 + "-" + class32.field744[var21] + "-" + var8;
                  return 1;
               } else if(var0 == 4105) {
                  class32.scriptStringStackSize -= 2;
                  var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                  var5 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                  if(Projectile.localPlayer.composition != null && Projectile.localPlayer.composition.isFemale) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5;
                  } else {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var9 = class32.field743[--class30.field713];
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Integer.toString(var9);
                  return 1;
               } else if(var0 == 4107) {
                  class32.scriptStringStackSize -= 2;
                  class32.field743[++class30.field713 - 1] = class8.method89(ChatLineBuffer.method939(class32.scriptStringStack[class32.scriptStringStackSize], class32.scriptStringStack[class32.scriptStringStackSize + 1], Client.field308));
                  return 1;
               } else {
                  Font var10;
                  byte[] var11;
                  if(var0 == 4108) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class30.field713 -= 2;
                     var4 = class32.field743[class30.field713];
                     var7 = class32.field743[class30.field713 + 1];
                     var11 = class5.field56.getConfigData(var7, 0);
                     var10 = new Font(var11);
                     class32.field743[++class30.field713 - 1] = var10.method3921(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class30.field713 -= 2;
                     var4 = class32.field743[class30.field713];
                     var7 = class32.field743[class30.field713 + 1];
                     var11 = class5.field56.getConfigData(var7, 0);
                     var10 = new Font(var11);
                     class32.field743[++class30.field713 - 1] = var10.method3908(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class32.scriptStringStackSize -= 2;
                     var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                     var5 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                     if(class32.field743[--class30.field713] == 1) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
                     } else {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5;
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
                     boolean var12;
                     char var13;
                     int[] var14;
                     if(var0 == 4113) {
                        var9 = class32.field743[--class30.field713];
                        var14 = class32.field743;
                        var7 = ++class30.field713 - 1;
                        var13 = (char)var9;
                        if(var13 >= 32 && var13 <= 126) {
                           var12 = true;
                        } else if(var13 >= 160 && var13 <= 255) {
                           var12 = true;
                        } else if(var13 != 8364 && var13 != 338 && var13 != 8212 && var13 != 339 && var13 != 376) {
                           var12 = false;
                        } else {
                           var12 = true;
                        }

                        var14[var7] = var12?1:0;
                        return 1;
                     } else if(var0 != 4114) {
                        if(var0 == 4115) {
                           var9 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = FrameMap.method1734((char)var9)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var9 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = class204.method3835((char)var9)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           if(var3 != null) {
                              class32.field743[++class30.field713 - 1] = var3.length();
                           } else {
                              class32.field743[++class30.field713 - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           class30.field713 -= 2;
                           var4 = class32.field743[class30.field713];
                           var7 = class32.field743[class30.field713 + 1];
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.substring(var4, var7);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           StringBuilder var15 = new StringBuilder(var3.length());
                           boolean var16 = false;

                           for(var6 = 0; var6 < var3.length(); ++var6) {
                              var13 = var3.charAt(var6);
                              if(var13 == 60) {
                                 var16 = true;
                              } else if(var13 == 62) {
                                 var16 = false;
                              } else if(!var16) {
                                 var15.append(var13);
                              }
                           }

                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var15.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           var4 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class32.scriptStringStackSize -= 2;
                           var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                           var5 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                           var7 = class32.field743[--class30.field713];
                           class32.field743[++class30.field713 - 1] = var3.indexOf(var5, var7);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var9 = class32.field743[--class30.field713];
                        var14 = class32.field743;
                        var7 = ++class30.field713 - 1;
                        var13 = (char)var9;
                        var12 = var13 >= 48 && var13 <= 57 || var13 >= 65 && var13 <= 90 || var13 >= 97 && var13 <= 122;
                        var14[var7] = var12?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
