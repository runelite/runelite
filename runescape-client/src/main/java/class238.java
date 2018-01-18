import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class238 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1377991878"
   )
   static int method4273(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
         var4 = class82.intStack[--class82.intStackSize];
         class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var38;
         if(var0 == 4101) {
            FileOnDisk.scriptStringStackSize -= 2;
            var3 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
            var38 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3 + var38;
            return 1;
         } else if(var0 == 4102) {
            var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
            var4 = class82.intStack[--class82.intStackSize];
            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3 + SceneTilePaint.method2741(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
            class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var22;
            int var30;
            if(var0 == 4104) {
               var22 = class82.intStack[--class82.intStackSize];
               long var23 = 86400000L * ((long)var22 + 11745L);
               class82.field1258.setTime(new Date(var23));
               var30 = class82.field1258.get(5);
               int var31 = class82.field1258.get(2);
               int var8 = class82.field1258.get(1);
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var30 + "-" + class82.field1269[var31] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               FileOnDisk.scriptStringStackSize -= 2;
               var3 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
               var38 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
               if(GrandExchangeOffer.localPlayer.composition != null && GrandExchangeOffer.localPlayer.composition.isFemale) {
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var38;
               } else {
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var22 = class82.intStack[--class82.intStackSize];
               class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = Integer.toString(var22);
               return 1;
            } else if(var0 == 4107) {
               FileOnDisk.scriptStringStackSize -= 2;
               int[] var29 = class82.intStack;
               var4 = ++class82.intStackSize - 1;
               String var40 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
               String var26 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
               int var9 = Client.languageId;
               int var10 = var40.length();
               int var11 = var26.length();
               int var12 = 0;
               int var13 = 0;
               char var14 = 0;
               char var15 = 0;

               label305:
               while(true) {
                  if(var12 - var14 >= var10 && var13 - var15 >= var11) {
                     int var35 = Math.min(var10, var11);

                     char var19;
                     int var36;
                     for(var36 = 0; var36 < var35; ++var36) {
                        char var18 = var40.charAt(var36);
                        var19 = var26.charAt(var36);
                        if(var18 != var19 && Character.toUpperCase(var18) != Character.toUpperCase(var19)) {
                           var18 = Character.toLowerCase(var18);
                           var19 = Character.toLowerCase(var19);
                           if(var18 != var19) {
                              var30 = class185.method3555(var18, var9) - class185.method3555(var19, var9);
                              break label305;
                           }
                        }
                     }

                     var36 = var10 - var11;
                     if(var36 != 0) {
                        var30 = var36;
                     } else {
                        for(int var37 = 0; var37 < var35; ++var37) {
                           var19 = var40.charAt(var37);
                           char var20 = var26.charAt(var37);
                           if(var19 != var20) {
                              var30 = class185.method3555(var19, var9) - class185.method3555(var20, var9);
                              break label305;
                           }
                        }

                        var30 = 0;
                     }
                     break;
                  }

                  if(var12 - var14 >= var10) {
                     var30 = -1;
                     break;
                  }

                  if(var13 - var15 >= var11) {
                     var30 = 1;
                     break;
                  }

                  char var16;
                  if(var14 != 0) {
                     var16 = var14;
                     boolean var33 = false;
                  } else {
                     var16 = var40.charAt(var12++);
                  }

                  char var17;
                  if(var15 != 0) {
                     var17 = var15;
                     boolean var34 = false;
                  } else {
                     var17 = var26.charAt(var13++);
                  }

                  var14 = class41.method581(var16);
                  var15 = class41.method581(var17);
                  var16 = Timer.method3134(var16, var9);
                  var17 = Timer.method3134(var17, var9);
                  if(var16 != var17 && Character.toUpperCase(var16) != Character.toUpperCase(var17)) {
                     var16 = Character.toLowerCase(var16);
                     var17 = Character.toLowerCase(var17);
                     if(var17 != var16) {
                        var30 = class185.method3555(var16, var9) - class185.method3555(var17, var9);
                        break;
                     }
                  }
               }

               byte var32;
               if(var30 > 0) {
                  var32 = 1;
               } else if(var30 < 0) {
                  var32 = -1;
               } else {
                  var32 = 0;
               }

               var29[var4] = var32;
               return 1;
            } else {
               int var5;
               Font var25;
               byte[] var27;
               if(var0 == 4108) {
                  var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                  class82.intStackSize -= 2;
                  var4 = class82.intStack[class82.intStackSize];
                  var5 = class82.intStack[class82.intStackSize + 1];
                  var27 = class64.indexCache13.getConfigData(var5, 0);
                  var25 = new Font(var27);
                  class82.intStack[++class82.intStackSize - 1] = var25.method5038(var3, var4);
                  return 1;
               } else if(var0 == 4109) {
                  var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                  class82.intStackSize -= 2;
                  var4 = class82.intStack[class82.intStackSize];
                  var5 = class82.intStack[class82.intStackSize + 1];
                  var27 = class64.indexCache13.getConfigData(var5, 0);
                  var25 = new Font(var27);
                  class82.intStack[++class82.intStackSize - 1] = var25.method5003(var3, var4);
                  return 1;
               } else if(var0 == 4110) {
                  FileOnDisk.scriptStringStackSize -= 2;
                  var3 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
                  var38 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
                  if(class82.intStack[--class82.intStackSize] == 1) {
                     class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3;
                  } else {
                     class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var38;
                  }

                  return 1;
               } else if(var0 == 4111) {
                  var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                  return 1;
               } else if(var0 == 4112) {
                  var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                  var4 = class82.intStack[--class82.intStackSize];
                  class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3 + (char)var4;
                  return 1;
               } else {
                  boolean var6;
                  char var7;
                  int[] var21;
                  if(var0 == 4113) {
                     var22 = class82.intStack[--class82.intStackSize];
                     var21 = class82.intStack;
                     var5 = ++class82.intStackSize - 1;
                     var7 = (char)var22;
                     if(var7 >= ' ' && var7 <= '~') {
                        var6 = true;
                     } else if(var7 >= 160 && var7 <= 255) {
                        var6 = true;
                     } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                        var6 = false;
                     } else {
                        var6 = true;
                     }

                     var21[var5] = var6?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var22 = class82.intStack[--class82.intStackSize];
                     var21 = class82.intStack;
                     var5 = ++class82.intStackSize - 1;
                     var7 = (char)var22;
                     var6 = var7 >= '0' && var7 <= '9' || var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                     var21[var5] = var6?1:0;
                     return 1;
                  } else if(var0 != 4115) {
                     if(var0 == 4116) {
                        var22 = class82.intStack[--class82.intStackSize];
                        class82.intStack[++class82.intStackSize - 1] = class215.method4023((char)var22)?1:0;
                        return 1;
                     } else if(var0 == 4117) {
                        var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                        if(var3 != null) {
                           class82.intStack[++class82.intStackSize - 1] = var3.length();
                        } else {
                           class82.intStack[++class82.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 4118) {
                        var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                        class82.intStackSize -= 2;
                        var4 = class82.intStack[class82.intStackSize];
                        var5 = class82.intStack[class82.intStackSize + 1];
                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var3.substring(var4, var5);
                        return 1;
                     } else if(var0 == 4119) {
                        var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                        StringBuilder var39 = new StringBuilder(var3.length());
                        boolean var28 = false;

                        for(var30 = 0; var30 < var3.length(); ++var30) {
                           var7 = var3.charAt(var30);
                           if(var7 == '<') {
                              var28 = true;
                           } else if(var7 == '>') {
                              var28 = false;
                           } else if(!var28) {
                              var39.append(var7);
                           }
                        }

                        class82.scriptStringStack[++FileOnDisk.scriptStringStackSize - 1] = var39.toString();
                        return 1;
                     } else if(var0 == 4120) {
                        var3 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
                        var4 = class82.intStack[--class82.intStackSize];
                        class82.intStack[++class82.intStackSize - 1] = var3.indexOf(var4);
                        return 1;
                     } else if(var0 == 4121) {
                        FileOnDisk.scriptStringStackSize -= 2;
                        var3 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize];
                        var38 = class82.scriptStringStack[FileOnDisk.scriptStringStackSize + 1];
                        var5 = class82.intStack[--class82.intStackSize];
                        class82.intStack[++class82.intStackSize - 1] = var3.indexOf(var38, var5);
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var22 = class82.intStack[--class82.intStackSize];
                     var21 = class82.intStack;
                     var5 = ++class82.intStackSize - 1;
                     var7 = (char)var22;
                     var6 = var7 >= 'A' && var7 <= 'Z' || var7 >= 'a' && var7 <= 'z';
                     var21[var5] = var6?1:0;
                     return 1;
                  }
               }
            }
         }
      }
   }
}
