import java.util.Date;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class161 {
   @ObfuscatedName("qf")
   protected static class109 field2129;
   @ObfuscatedName("ar")
   static int[] field2130;

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "74248613"
   )
   static final void method3112() {
      int var0 = class45.field934;
      int[] var1 = class45.field925;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            WidgetNode.method205(var3, 1);
         }
      }

   }

   class161() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "81"
   )
   static int method3119(int var0, Script var1, boolean var2) {
      String var3;
      int var21;
      if(var0 == 4100) {
         var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
         var21 = class32.field756[--class32.field752];
         class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3 + var21;
         return 1;
      } else {
         String var28;
         if(var0 == 4101) {
            class9.scriptStringStackSize -= 2;
            var3 = class32.scriptStringStack[class9.scriptStringStackSize];
            var28 = class32.scriptStringStack[1 + class9.scriptStringStackSize];
            class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3 + var28;
            return 1;
         } else if(var0 == 4102) {
            var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
            var21 = class32.field756[--class32.field752];
            class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3 + class119.method2328(var21, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
            class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var22;
            int var32;
            if(var0 == 4104) {
               var22 = class32.field756[--class32.field752];
               long var23 = 86400000L * ((long)var22 + 11745L);
               class32.field757.setTime(new Date(var23));
               var32 = class32.field757.get(5);
               int var33 = class32.field757.get(2);
               int var8 = class32.field757.get(1);
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var32 + "-" + class32.field761[var33] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class9.scriptStringStackSize -= 2;
               var3 = class32.scriptStringStack[class9.scriptStringStackSize];
               var28 = class32.scriptStringStack[1 + class9.scriptStringStackSize];
               if(class22.localPlayer.composition != null && class22.localPlayer.composition.isFemale) {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var28;
               } else {
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var22 = class32.field756[--class32.field752];
               class32.scriptStringStack[++class9.scriptStringStackSize - 1] = Integer.toString(var22);
               return 1;
            } else if(var0 == 4107) {
               class9.scriptStringStackSize -= 2;
               int[] var31 = class32.field756;
               var21 = ++class32.field752 - 1;
               String var42 = class32.scriptStringStack[class9.scriptStringStackSize];
               String var25 = class32.scriptStringStack[class9.scriptStringStackSize + 1];
               int var9 = Client.field409;
               int var10 = var42.length();
               int var11 = var25.length();
               int var12 = 0;
               int var13 = 0;
               byte var14 = 0;
               byte var15 = 0;

               label421:
               while(true) {
                  if(var12 - var14 >= var10 && var13 - var15 >= var11) {
                     int var37 = Math.min(var10, var11);

                     int var38;
                     char var41;
                     for(var38 = 0; var38 < var37; ++var38) {
                        char var39 = var42.charAt(var38);
                        var41 = var25.charAt(var38);
                        if(var39 != var41 && Character.toUpperCase(var39) != Character.toUpperCase(var41)) {
                           var39 = Character.toLowerCase(var39);
                           var41 = Character.toLowerCase(var41);
                           if(var41 != var39) {
                              var32 = class186.method3449(var39, var9) - class186.method3449(var41, var9);
                              break label421;
                           }
                        }
                     }

                     var38 = var10 - var11;
                     if(var38 != 0) {
                        var32 = var38;
                     } else {
                        for(int var40 = 0; var40 < var37; ++var40) {
                           var41 = var42.charAt(var40);
                           char var20 = var25.charAt(var40);
                           if(var20 != var41) {
                              var32 = class186.method3449(var41, var9) - class186.method3449(var20, var9);
                              break label421;
                           }
                        }

                        var32 = 0;
                     }
                     break;
                  }

                  if(var12 - var14 >= var10) {
                     var32 = -1;
                     break;
                  }

                  if(var13 - var15 >= var11) {
                     var32 = 1;
                     break;
                  }

                  char var16;
                  if(var14 != 0) {
                     var16 = (char)var14;
                     boolean var35 = false;
                  } else {
                     var16 = var42.charAt(var12++);
                  }

                  char var17;
                  if(var15 != 0) {
                     var17 = (char)var15;
                     boolean var36 = false;
                  } else {
                     var17 = var25.charAt(var13++);
                  }

                  byte var18;
                  if(var16 == 198) {
                     var18 = 69;
                  } else if(var16 == 230) {
                     var18 = 101;
                  } else if(var16 == 223) {
                     var18 = 115;
                  } else if(var16 == 338) {
                     var18 = 69;
                  } else if(var16 == 339) {
                     var18 = 101;
                  } else {
                     var18 = 0;
                  }

                  var14 = var18;
                  byte var19;
                  if(var17 == 198) {
                     var19 = 69;
                  } else if(var17 == 230) {
                     var19 = 101;
                  } else if(var17 == 223) {
                     var19 = 115;
                  } else if(var17 == 338) {
                     var19 = 69;
                  } else if(var17 == 339) {
                     var19 = 101;
                  } else {
                     var19 = 0;
                  }

                  var15 = var19;
                  var16 = XClanMember.method277(var16, var9);
                  var17 = XClanMember.method277(var17, var9);
                  if(var16 != var17 && Character.toUpperCase(var16) != Character.toUpperCase(var17)) {
                     var16 = Character.toLowerCase(var16);
                     var17 = Character.toLowerCase(var17);
                     if(var16 != var17) {
                        var32 = class186.method3449(var16, var9) - class186.method3449(var17, var9);
                        break;
                     }
                  }
               }

               byte var34;
               if(var32 > 0) {
                  var34 = 1;
               } else if(var32 < 0) {
                  var34 = -1;
               } else {
                  var34 = 0;
               }

               var31[var21] = var34;
               return 1;
            } else {
               int var5;
               Font var26;
               byte[] var27;
               if(var0 == 4108) {
                  var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class32.field752 -= 2;
                  var21 = class32.field756[class32.field752];
                  var5 = class32.field756[class32.field752 + 1];
                  var27 = class140.field1965.getConfigData(var5, 0);
                  var26 = new Font(var27);
                  class32.field756[++class32.field752 - 1] = var26.method3879(var3, var21);
                  return 1;
               } else if(var0 == 4109) {
                  var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class32.field752 -= 2;
                  var21 = class32.field756[class32.field752];
                  var5 = class32.field756[1 + class32.field752];
                  var27 = class140.field1965.getConfigData(var5, 0);
                  var26 = new Font(var27);
                  class32.field756[++class32.field752 - 1] = var26.method3930(var3, var21);
                  return 1;
               } else if(var0 == 4110) {
                  class9.scriptStringStackSize -= 2;
                  var3 = class32.scriptStringStack[class9.scriptStringStackSize];
                  var28 = class32.scriptStringStack[1 + class9.scriptStringStackSize];
                  if(class32.field756[--class32.field752] == 1) {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3;
                  } else {
                     class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var28;
                  }

                  return 1;
               } else if(var0 == 4111) {
                  var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = FontTypeFace.method3880(var3);
                  return 1;
               } else if(var0 == 4112) {
                  var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                  var21 = class32.field756[--class32.field752];
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3 + (char)var21;
                  return 1;
               } else {
                  int[] var4;
                  boolean var6;
                  char var7;
                  if(var0 == 4113) {
                     var22 = class32.field756[--class32.field752];
                     var4 = class32.field756;
                     var5 = ++class32.field752 - 1;
                     var7 = (char)var22;
                     if(var7 >= 32 && var7 <= 126) {
                        var6 = true;
                     } else if(var7 >= 160 && var7 <= 255) {
                        var6 = true;
                     } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                        var6 = false;
                     } else {
                        var6 = true;
                     }

                     var4[var5] = var6?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var22 = class32.field756[--class32.field752];
                     class32.field756[++class32.field752 - 1] = Projectile.method873((char)var22)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var22 = class32.field756[--class32.field752];
                     var4 = class32.field756;
                     var5 = ++class32.field752 - 1;
                     var7 = (char)var22;
                     var6 = var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     var4[var5] = var6?1:0;
                     return 1;
                  } else if(var0 != 4116) {
                     if(var0 == 4117) {
                        var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                        if(null != var3) {
                           class32.field756[++class32.field752 - 1] = var3.length();
                        } else {
                           class32.field756[++class32.field752 - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 4118) {
                        var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                        class32.field752 -= 2;
                        var21 = class32.field756[class32.field752];
                        var5 = class32.field756[class32.field752 + 1];
                        class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3.substring(var21, var5);
                        return 1;
                     } else if(var0 == 4119) {
                        var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                        StringBuilder var29 = new StringBuilder(var3.length());
                        boolean var30 = false;

                        for(var32 = 0; var32 < var3.length(); ++var32) {
                           var7 = var3.charAt(var32);
                           if(var7 == 60) {
                              var30 = true;
                           } else if(var7 == 62) {
                              var30 = false;
                           } else if(!var30) {
                              var29.append(var7);
                           }
                        }

                        class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var29.toString();
                        return 1;
                     } else if(var0 == 4120) {
                        var3 = class32.scriptStringStack[--class9.scriptStringStackSize];
                        var21 = class32.field756[--class32.field752];
                        class32.field756[++class32.field752 - 1] = var3.indexOf(var21);
                        return 1;
                     } else if(var0 == 4121) {
                        class9.scriptStringStackSize -= 2;
                        var3 = class32.scriptStringStack[class9.scriptStringStackSize];
                        var28 = class32.scriptStringStack[1 + class9.scriptStringStackSize];
                        var5 = class32.field756[--class32.field752];
                        class32.field756[++class32.field752 - 1] = var3.indexOf(var28, var5);
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var22 = class32.field756[--class32.field752];
                     var4 = class32.field756;
                     var5 = ++class32.field752 - 1;
                     var7 = (char)var22;
                     var6 = var7 >= 48 && var7 <= 57;
                     var4[var5] = var6?1:0;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "664866071"
   )
   public static void method3120(class182 var0) {
      class186.field2762 = var0;
   }
}
