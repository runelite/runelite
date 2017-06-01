import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class36 {
   @ObfuscatedName("i")
   static final class36 field501;
   @ObfuscatedName("n")
   @Export("worldServersDownload")
   static class77 worldServersDownload;
   @ObfuscatedName("c")
   static final class36 field505;
   @ObfuscatedName("cz")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -624473377
   )
   final int field509;

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "913884613"
   )
   static final void method481(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(RSSocket.method2986(var0)) {
         class158.field2287 = null;
         Friend.gameDraw(CombatInfo1.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class158.field2287 != null) {
            Friend.gameDraw(class158.field2287, -1412584499, var1, var2, var3, var4, class225.field3134, WorldMapData.field463, var7);
            class158.field2287 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1135[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1135[var8] = true;
            }
         }

      }
   }

   static {
      field501 = new class36(0);
      field505 = new class36(1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class36(int var1) {
      this.field509 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1379685016"
   )
   static int method482(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-531974147"
   )
   static int method483(int var0, Script var1, boolean var2) {
      int var20;
      String var22;
      if(var0 == 4100) {
         var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
         var20 = class83.intStack[--class83.intStackSize];
         class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22 + var20;
         return 1;
      } else {
         String var33;
         if(var0 == 4101) {
            class51.scriptStringStackSize -= 2;
            var22 = class83.scriptStringStack[class51.scriptStringStackSize];
            var33 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22 + var33;
            return 1;
         } else if(var0 == 4102) {
            var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
            var20 = class83.intStack[--class83.intStackSize];
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22 + RSCanvas.method774(var20, true);
            return 1;
         } else if(var0 == 4103) {
            var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
            class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22.toLowerCase();
            return 1;
         } else {
            int var3;
            int var8;
            int var26;
            if(var0 == 4104) {
               var3 = class83.intStack[--class83.intStackSize];
               long var4 = 86400000L * ((long)var3 + 11745L);
               class83.field1366.setTime(new Date(var4));
               var26 = class83.field1366.get(5);
               int var27 = class83.field1366.get(2);
               var8 = class83.field1366.get(1);
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var26 + "-" + class83.field1367[var27] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class51.scriptStringStackSize -= 2;
               var22 = class83.scriptStringStack[class51.scriptStringStackSize];
               var33 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
               if(World.localPlayer.composition != null && World.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var33;
               } else {
                  class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22;
               }

               return 1;
            } else if(var0 == 4106) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.scriptStringStack[++class51.scriptStringStackSize - 1] = Integer.toString(var3);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  class51.scriptStringStackSize -= 2;
                  int[] var37 = class83.intStack;
                  var20 = ++class83.intStackSize - 1;
                  String var35 = class83.scriptStringStack[class51.scriptStringStackSize];
                  String var36 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
                  var8 = Client.field1077;
                  int var9 = var35.length();
                  int var10 = var36.length();
                  int var11 = 0;
                  int var12 = 0;
                  char var13 = 0;
                  char var14 = 0;

                  label355:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var30 = Math.min(var9, var10);

                        char var18;
                        int var31;
                        for(var31 = 0; var31 < var30; ++var31) {
                           char var17 = var35.charAt(var31);
                           var18 = var36.charAt(var31);
                           if(var18 != var17 && Character.toUpperCase(var17) != Character.toUpperCase(var18)) {
                              var17 = Character.toLowerCase(var17);
                              var18 = Character.toLowerCase(var18);
                              if(var18 != var17) {
                                 var5 = XClanMember.method1141(var17, var8) - XClanMember.method1141(var18, var8);
                                 break label355;
                              }
                           }
                        }

                        var31 = var9 - var10;
                        if(var31 != 0) {
                           var5 = var31;
                        } else {
                           for(int var32 = 0; var32 < var30; ++var32) {
                              var18 = var35.charAt(var32);
                              char var19 = var36.charAt(var32);
                              if(var19 != var18) {
                                 var5 = XClanMember.method1141(var18, var8) - XClanMember.method1141(var19, var8);
                                 break label355;
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
                        boolean var28 = false;
                     } else {
                        var15 = var35.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = var14;
                        boolean var29 = false;
                     } else {
                        var16 = var36.charAt(var12++);
                     }

                     var13 = class82.method1599(var15);
                     var14 = class82.method1599(var16);
                     var15 = class217.method4040(var15, var8);
                     var16 = class217.method4040(var16, var8);
                     if(var16 != var15 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var16 != var15) {
                           var5 = XClanMember.method1141(var15, var8) - XClanMember.method1141(var16, var8);
                           break;
                        }
                     }
                  }

                  var37[var20] = class222.method4064(var5);
                  return 1;
               } else {
                  byte[] var23;
                  Font var24;
                  if(var0 == 4108) {
                     var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                     class83.intStackSize -= 2;
                     var20 = class83.intStack[class83.intStackSize];
                     var5 = class83.intStack[class83.intStackSize + 1];
                     var23 = class20.field324.getConfigData(var5, 0);
                     var24 = new Font(var23);
                     class83.intStack[++class83.intStackSize - 1] = var24.method4765(var22, var20);
                     return 1;
                  } else if(var0 == 4109) {
                     var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                     class83.intStackSize -= 2;
                     var20 = class83.intStack[class83.intStackSize];
                     var5 = class83.intStack[class83.intStackSize + 1];
                     var23 = class20.field324.getConfigData(var5, 0);
                     var24 = new Font(var23);
                     class83.intStack[++class83.intStackSize - 1] = var24.method4730(var22, var20);
                     return 1;
                  } else if(var0 == 4110) {
                     class51.scriptStringStackSize -= 2;
                     var22 = class83.scriptStringStack[class51.scriptStringStackSize];
                     var33 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
                     if(class83.intStack[--class83.intStackSize] == 1) {
                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22;
                     } else {
                        class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var33;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = FontTypeFace.method4776(var22);
                     return 1;
                  } else if(var0 == 4112) {
                     var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                     var20 = class83.intStack[--class83.intStackSize];
                     class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22 + (char)var20;
                     return 1;
                  } else {
                     boolean var6;
                     char var7;
                     int[] var21;
                     if(var0 == 4113) {
                        var3 = class83.intStack[--class83.intStackSize];
                        var21 = class83.intStack;
                        var5 = ++class83.intStackSize - 1;
                        var7 = (char)var3;
                        if(var7 >= 32 && var7 <= 126) {
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
                     } else if(var0 != 4114) {
                        if(var0 == 4115) {
                           var3 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = FaceNormal.method2865((char)var3)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var3 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = class207.method3855((char)var3)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                           if(var22 != null) {
                              class83.intStack[++class83.intStackSize - 1] = var22.length();
                           } else {
                              class83.intStack[++class83.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                           class83.intStackSize -= 2;
                           var20 = class83.intStack[class83.intStackSize];
                           var5 = class83.intStack[class83.intStackSize + 1];
                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var22.substring(var20, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                           StringBuilder var34 = new StringBuilder(var22.length());
                           boolean var25 = false;

                           for(var26 = 0; var26 < var22.length(); ++var26) {
                              var7 = var22.charAt(var26);
                              if(var7 == 60) {
                                 var25 = true;
                              } else if(var7 == 62) {
                                 var25 = false;
                              } else if(!var25) {
                                 var34.append(var7);
                              }
                           }

                           class83.scriptStringStack[++class51.scriptStringStackSize - 1] = var34.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var22 = class83.scriptStringStack[--class51.scriptStringStackSize];
                           var20 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = var22.indexOf(var20);
                           return 1;
                        } else if(var0 == 4121) {
                           class51.scriptStringStackSize -= 2;
                           var22 = class83.scriptStringStack[class51.scriptStringStackSize];
                           var33 = class83.scriptStringStack[class51.scriptStringStackSize + 1];
                           var5 = class83.intStack[--class83.intStackSize];
                           class83.intStack[++class83.intStackSize - 1] = var22.indexOf(var33, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var3 = class83.intStack[--class83.intStackSize];
                        var21 = class83.intStack;
                        var5 = ++class83.intStackSize - 1;
                        var7 = (char)var3;
                        var6 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                        var21[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
