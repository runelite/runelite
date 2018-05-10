import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("ff")
   static byte[][] field1475;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1016013399
   )
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 152782163
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -736197147
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 7654269406186050467L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1231787727
   )
   @Export("height")
   int height;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-1308565855"
   )
   static int method2617(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
         var4 = class69.intStack[--class45.intStackSize];
         class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var35;
         if(var0 == 4101) {
            class83.scriptStringStackSize -= 2;
            var3 = class69.scriptStringStack[class83.scriptStringStackSize];
            var35 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
            class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3 + var35;
            return 1;
         } else if(var0 == 4102) {
            var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
            var4 = class69.intStack[--class45.intStackSize];
            class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3 + MapIcon.method517(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
            class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var8;
            int var21;
            int var29;
            if(var0 == 4104) {
               var21 = class69.intStack[--class45.intStackSize];
               long var22 = (11745L + (long)var21) * 86400000L;
               class69.field1024.setTime(new Date(var22));
               var29 = class69.field1024.get(5);
               int var28 = class69.field1024.get(2);
               var8 = class69.field1024.get(1);
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var29 + "-" + class69.field1018[var28] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class83.scriptStringStackSize -= 2;
               var3 = class69.scriptStringStack[class83.scriptStringStackSize];
               var35 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
               if(MilliTimer.localPlayer.composition != null && MilliTimer.localPlayer.composition.isFemale) {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var35;
               } else {
                  class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var21 = class69.intStack[--class45.intStackSize];
               class69.scriptStringStack[++class83.scriptStringStackSize - 1] = Integer.toString(var21);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  class83.scriptStringStackSize -= 2;
                  int[] var27 = class69.intStack;
                  var4 = ++class45.intStackSize - 1;
                  String var37 = class69.scriptStringStack[class83.scriptStringStackSize];
                  String var38 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
                  var8 = Client.languageId;
                  int var9 = var37.length();
                  int var10 = var38.length();
                  int var11 = 0;
                  int var12 = 0;
                  char var13 = 0;
                  char var14 = 0;

                  label258:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var32 = Math.min(var9, var10);

                        char var18;
                        int var33;
                        for(var33 = 0; var33 < var32; ++var33) {
                           char var17 = var37.charAt(var33);
                           var18 = var38.charAt(var33);
                           if(var18 != var17 && Character.toUpperCase(var17) != Character.toUpperCase(var18)) {
                              var17 = Character.toLowerCase(var17);
                              var18 = Character.toLowerCase(var18);
                              if(var17 != var18) {
                                 var5 = class236.method4597(var17, var8) - class236.method4597(var18, var8);
                                 break label258;
                              }
                           }
                        }

                        var33 = var9 - var10;
                        if(var33 != 0) {
                           var5 = var33;
                        } else {
                           for(int var34 = 0; var34 < var32; ++var34) {
                              var18 = var37.charAt(var34);
                              char var19 = var38.charAt(var34);
                              if(var19 != var18) {
                                 var5 = class236.method4597(var18, var8) - class236.method4597(var19, var8);
                                 break label258;
                              }
                           }

                           var5 = 0;
                        }
                        break;
                     }

                     if(var11 - var13 >= var9) {
                        var5 = -1;
                        break;
                     }

                     if(var12 - var14 >= var10) {
                        var5 = 1;
                        break;
                     }

                     char var15;
                     if(var13 != 0) {
                        var15 = var13;
                        boolean var30 = false;
                     } else {
                        var15 = var37.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = var14;
                        boolean var31 = false;
                     } else {
                        var16 = var38.charAt(var12++);
                     }

                     var13 = class76.method1850(var15);
                     var14 = class76.method1850(var16);
                     var15 = class222.method4446(var15, var8);
                     var16 = class222.method4446(var16, var8);
                     if(var16 != var15 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var16 != var15) {
                           var5 = class236.method4597(var15, var8) - class236.method4597(var16, var8);
                           break;
                        }
                     }
                  }

                  var27[var4] = class183.method3824(var5);
                  return 1;
               } else {
                  byte[] var24;
                  Font var25;
                  if(var0 == 4108) {
                     var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                     class45.intStackSize -= 2;
                     var4 = class69.intStack[class45.intStackSize];
                     var5 = class69.intStack[class45.intStackSize + 1];
                     var24 = TotalQuantityComparator.indexCache13.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class69.intStack[++class45.intStackSize - 1] = var25.method5539(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                     class45.intStackSize -= 2;
                     var4 = class69.intStack[class45.intStackSize];
                     var5 = class69.intStack[class45.intStackSize + 1];
                     var24 = TotalQuantityComparator.indexCache13.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class69.intStack[++class45.intStackSize - 1] = var25.method5538(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class83.scriptStringStackSize -= 2;
                     var3 = class69.scriptStringStack[class83.scriptStringStackSize];
                     var35 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
                     if(class69.intStack[--class45.intStackSize] == 1) {
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3;
                     } else {
                        class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var35;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                     class69.scriptStringStack[++class83.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                     var4 = class69.intStack[--class45.intStackSize];
                     class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else {
                     char var7;
                     if(var0 != 4113) {
                        if(var0 == 4114) {
                           var21 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = class148.method3206((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4115) {
                           var21 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = Frames.method3095((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var21 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = class184.method3830((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           if(var3 != null) {
                              class69.intStack[++class45.intStackSize - 1] = var3.length();
                           } else {
                              class69.intStack[++class45.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           class45.intStackSize -= 2;
                           var4 = class69.intStack[class45.intStackSize];
                           var5 = class69.intStack[class45.intStackSize + 1];
                           class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var3.substring(var4, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           StringBuilder var36 = new StringBuilder(var3.length());
                           boolean var26 = false;

                           for(var29 = 0; var29 < var3.length(); ++var29) {
                              var7 = var3.charAt(var29);
                              if(var7 == '<') {
                                 var26 = true;
                              } else if(var7 == '>') {
                                 var26 = false;
                              } else if(!var26) {
                                 var36.append(var7);
                              }
                           }

                           class69.scriptStringStack[++class83.scriptStringStackSize - 1] = var36.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class69.scriptStringStack[--class83.scriptStringStackSize];
                           var4 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class83.scriptStringStackSize -= 2;
                           var3 = class69.scriptStringStack[class83.scriptStringStackSize];
                           var35 = class69.scriptStringStack[class83.scriptStringStackSize + 1];
                           var5 = class69.intStack[--class45.intStackSize];
                           class69.intStack[++class45.intStackSize - 1] = var3.indexOf(var35, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var21 = class69.intStack[--class45.intStackSize];
                        int[] var20 = class69.intStack;
                        var5 = ++class45.intStackSize - 1;
                        var7 = (char)var21;
                        boolean var6;
                        if(var7 >= ' ' && var7 <= '~') {
                           var6 = true;
                        } else if(var7 >= 160 && var7 <= 255) {
                           var6 = true;
                        } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                           var6 = false;
                        } else {
                           var6 = true;
                        }

                        var20[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
