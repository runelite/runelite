import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class38 extends class207 {
   @ObfuscatedName("i")
   String field865;
   @ObfuscatedName("g")
   short field867;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 422128949
   )
   int field870 = (int)(class124.method2746() / 1000L);
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1441071469
   )
   static int field872;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1244244997"
   )
   static int method741(int var0) {
      class27 var1 = (class27)class11.field175.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method620();
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "1907699024"
   )
   static final void method742(class39 var0, int var1, int var2, int var3) {
      if(client.field294 < 400) {
         if(null != var0.field907) {
            var0 = var0.method752();
         }

         if(var0 != null) {
            if(var0.field910) {
               if(!var0.field912 || var1 == client.field370) {
                  String var4 = var0.field885;
                  int var8;
                  if(var0.field899 != 0) {
                     int var7 = var0.field899;
                     var8 = class152.field2301.field41;
                     int var9 = var8 - var7;
                     String var10;
                     if(var9 < -9) {
                        var10 = class155.method3132(16711680);
                     } else if(var9 < -6) {
                        var10 = class155.method3132(16723968);
                     } else if(var9 < -3) {
                        var10 = class155.method3132(16740352);
                     } else if(var9 < 0) {
                        var10 = class155.method3132(16756736);
                     } else if(var9 > 9) {
                        var10 = class155.method3132('\uff00');
                     } else if(var9 > 6) {
                        var10 = class155.method3132(4259584);
                     } else if(var9 > 3) {
                        var10 = class155.method3132(8453888);
                     } else if(var9 > 0) {
                        var10 = class155.method3132(12648192);
                     } else {
                        var10 = class155.method3132(16776960);
                     }

                     var4 = var4 + var10 + " " + " (" + "level-" + var0.field899 + ")";
                  }

                  if(client.field379 == 1) {
                     class2.method33("Use", client.field463 + " " + "->" + " " + class155.method3132(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field437) {
                     if((class3.field69 & 2) == 2) {
                        class2.method33(client.field432, client.field441 + " " + "->" + " " + class155.method3132(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field892;
                     if(client.field453) {
                        var5 = class125.method2765(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var6 == 0) {
                                 var11 = 9;
                              }

                              if(var6 == 1) {
                                 var11 = 10;
                              }

                              if(var6 == 2) {
                                 var11 = 11;
                              }

                              if(var6 == 3) {
                                 var11 = 12;
                              }

                              if(var6 == 4) {
                                 var11 = 13;
                              }

                              class2.method33(var5[var6], class155.method3132(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(client.field458 != class20.field570) {
                                 if(client.field458 == class20.field571 || class20.field569 == client.field458 && var0.field899 > class152.field2301.field41) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var12;
                                 }

                                 if(var6 == 1) {
                                    var8 = var12 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(var6 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 class2.method33(var5[var6], class155.method3132(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class2.method33("Examine", class155.method3132(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "16256"
   )
   static final int method743(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-360483329"
   )
   static final boolean method744(int var0, int var1) {
      class40 var2 = class49.method980(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method792(var1);
   }

   class38(String var1, int var2) {
      this.field865 = var1;
      this.field867 = (short)var2;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "0"
   )
   static final void method745(boolean var0) {
      client.field516 = 0;
      client.field323 = 0;
      class18.method175();
      class104.method2252(var0);
      class29.method645();

      int var1;
      for(var1 = 0; var1 < client.field516; ++var1) {
         int var2 = client.field409[var1];
         if(client.field320[var2].field823 != client.field332) {
            client.field320[var2].field772 = null;
            client.field320[var2] = null;
         }
      }

      if(client.field327.field2000 != client.field328) {
         throw new RuntimeException(client.field327.field2000 + "," + client.field328);
      } else {
         for(var1 = 0; var1 < client.field293; ++var1) {
            if(client.field320[client.field322[var1]] == null) {
               throw new RuntimeException(var1 + "," + client.field293);
            }
         }

      }
   }
}
