import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class15 {
   @ObfuscatedName("g")
   public static boolean field164;
   @ObfuscatedName("c")
   static final class15 field165 = new class15();
   @ObfuscatedName("n")
   static final class15 field166 = new class15();
   @ObfuscatedName("q")
   static final class15 field167 = new class15();
   @ObfuscatedName("d")
   static final class15 field168 = new class15();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "1"
   )
   static int method185(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class32.field720[++class32.field715 - 1] = class199.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            World.field674 = 0;
            var3 = PacketBuffer.method2649();
            if(var3 != null) {
               class32.field720[++class32.field715 - 1] = var3.id;
               class32.field720[++class32.field715 - 1] = var3.mask;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.activity;
               class32.field720[++class32.field715 - 1] = var3.location;
               class32.field720[++class32.field715 - 1] = var3.playerCount;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field720[++class32.field715 - 1] = -1;
               class32.field720[++class32.field715 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.field720[++class32.field715 - 1] = 0;
               class32.field720[++class32.field715 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = PacketBuffer.method2649();
            if(var3 != null) {
               class32.field720[++class32.field715 - 1] = var3.id;
               class32.field720[++class32.field715 - 1] = var3.mask;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.activity;
               class32.field720[++class32.field715 - 1] = var3.location;
               class32.field720[++class32.field715 - 1] = var3.playerCount;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field720[++class32.field715 - 1] = -1;
               class32.field720[++class32.field715 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               class32.field720[++class32.field715 - 1] = 0;
               class32.field720[++class32.field715 - 1] = 0;
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var11;
            if(var0 == 6506) {
               var11 = class32.field720[--class32.field715];
               var4 = null;

               for(var5 = 0; var5 < World.field669; ++var5) {
                  if(var11 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class32.field720[++class32.field715 - 1] = var4.id;
                  class32.field720[++class32.field715 - 1] = var4.mask;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.activity;
                  class32.field720[++class32.field715 - 1] = var4.location;
                  class32.field720[++class32.field715 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field720[++class32.field715 - 1] = -1;
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class32.field715 -= 4;
               var11 = class32.field720[class32.field715];
               boolean var15 = class32.field720[class32.field715 + 1] == 1;
               var5 = class32.field720[class32.field715 + 2];
               boolean var6 = class32.field720[class32.field715 + 3] == 1;
               class121.method2304(var11, var15, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field430 = class32.field720[--class32.field715] == 1;
                  return 1;
               } else {
                  int var12;
                  class198 var13;
                  if(var0 == 6513) {
                     class32.field715 -= 2;
                     var11 = class32.field720[class32.field715];
                     var12 = class32.field720[class32.field715 + 1];
                     var13 = class183.method3292(var12);
                     if(var13.method3586()) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Widget.getNpcDefinition(var11).method3831(var12, var13.field2876);
                     } else {
                        class32.field720[++class32.field715 - 1] = Widget.getNpcDefinition(var11).method3806(var12, var13.field2870);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     class32.field715 -= 2;
                     var11 = class32.field720[class32.field715];
                     var12 = class32.field720[class32.field715 + 1];
                     var13 = class183.method3292(var12);
                     if(var13.method3586()) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class26.getObjectDefinition(var11).method3720(var12, var13.field2876);
                     } else {
                        class32.field720[++class32.field715 - 1] = class26.getObjectDefinition(var11).method3694(var12, var13.field2870);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     class32.field715 -= 2;
                     var11 = class32.field720[class32.field715];
                     var12 = class32.field720[class32.field715 + 1];
                     var13 = class183.method3292(var12);
                     if(var13.method3586()) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = class47.getItemDefinition(var11).method3750(var12, var13.field2876);
                     } else {
                        class32.field720[++class32.field715 - 1] = class47.getItemDefinition(var11).method3749(var12, var13.field2870);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     class32.field715 -= 2;
                     var11 = class32.field720[class32.field715];
                     var12 = class32.field720[class32.field715 + 1];
                     var13 = class183.method3292(var12);
                     if(var13.method3586()) {
                        String[] var14 = class32.scriptStringStack;
                        int var7 = ++class32.scriptStringStackSize - 1;
                        class199 var9 = (class199)class199.field2878.get((long)var11);
                        class199 var8;
                        if(var9 != null) {
                           var8 = var9;
                        } else {
                           byte[] var10 = class199.field2883.getConfigData(34, var11);
                           var9 = new class199();
                           if(var10 != null) {
                              var9.method3602(new Buffer(var10));
                           }

                           var9.method3601();
                           class199.field2878.put(var9, (long)var11);
                           var8 = var9;
                        }

                        var14[var7] = var8.method3605(var12, var13.field2876);
                     } else {
                        class32.field720[++class32.field715 - 1] = class119.method2297(var11).method3604(var12, var13.field2870);
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var11 = class32.field720[--class32.field715];
               if(var11 >= 0 && var11 < World.field669) {
                  var4 = World.worldList[var11];
                  class32.field720[++class32.field715 - 1] = var4.id;
                  class32.field720[++class32.field715 - 1] = var4.mask;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.activity;
                  class32.field720[++class32.field715 - 1] = var4.location;
                  class32.field720[++class32.field715 - 1] = var4.playerCount;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field720[++class32.field715 - 1] = -1;
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.field720[++class32.field715 - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "110"
   )
   static final int method186(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1590889977"
   )
   public static char method187(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2103216152"
   )
   static final void method188(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = class187.field2760;
      int var3 = IndexDataBase.field2726;
      if(class112.method2112(var1)) {
         ItemLayer.method1476(class133.widgets[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "758531397"
   )
   static final boolean method189(int var0, int var1) {
      ObjectComposition var2 = class26.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3725(var1);
   }
}
