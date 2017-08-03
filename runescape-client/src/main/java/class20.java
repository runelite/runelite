import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("l")
public class class20 {
   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   static class89 field317;

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lhn;I)V",
      garbageValue = "-1569749647"
   )
   static final void method145(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1156 == -1) {
            Client.field1156 = var0.spriteId;
            Client.field1157 = var0.field2665;
         }

         if(Client.field1155.isFemale) {
            var0.spriteId = Client.field1156;
         } else {
            var0.spriteId = Client.field1157;
         }

      } else if(var1 == 325) {
         if(Client.field1156 == -1) {
            Client.field1156 = var0.spriteId;
            Client.field1157 = var0.field2665;
         }

         if(Client.field1155.isFemale) {
            var0.spriteId = Client.field1157;
         } else {
            var0.spriteId = Client.field1156;
         }

      } else if(var1 == 327) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.rotationX = 150;
         var0.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;S)Z",
      garbageValue = "-8136"
   )
   static boolean method144(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field651.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class56.field653;
            Object[] var5 = new Object[]{(new URL(class56.field653.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method794(class56.field653, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lin;IIII)V",
      garbageValue = "-1659236311"
   )
   static final void method142(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3542) {
               if(!var0.field3564 || Client.field1051 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + DecorativeObject.method2921(var0.combatLevel, class224.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3564 && Client.field1030) {
                     class164.addMenuEntry("Examine", CacheFile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class164.addMenuEntry("Use", Client.field1037 + " " + "->" + " " + CacheFile.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((class96.field1481 & 2) == 2) {
                        class164.addMenuEntry(Client.field972, Client.field1042 + " " + "->" + " " + CacheFile.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3564 && Client.field1030?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.field969) {
                        var6 = FileOnDisk.method1920(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class164.addMenuEntry(var6[var7], CacheFile.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class91.field1393 != Client.field918) {
                                 if(class91.field1384 == Client.field918 || class91.field1386 == Client.field918 && var0.combatLevel > class224.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class164.addMenuEntry(var6[var7], CacheFile.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3564 || !Client.field1030) {
                        class164.addMenuEntry("Examine", CacheFile.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "2039351064"
   )
   static int method143(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         int var4 = class83.intStack[class83.intStackSize + 1];
         if(!Client.field1130) {
            Client.field977 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class83.intStack[++class83.intStackSize - 1] = Client.field977;
         return 1;
      } else if(var0 == 5506) {
         class83.intStack[++class83.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class83.intStack[--class83.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field907 = var3;
         return 1;
      } else if(var0 == 5531) {
         class83.intStack[++class83.intStackSize - 1] = Client.field907;
         return 1;
      } else {
         return 2;
      }
   }
}
