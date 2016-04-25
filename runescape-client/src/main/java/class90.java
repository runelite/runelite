import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class90 {
   @ObfuscatedName("n")
   public static short[] field1545;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZI)I",
      garbageValue = "470409900"
   )
   static int method2084(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field625;
         int var5 = var1.field625;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field623 - var1.field623:(var2 == 3?(var0.field620.equals("-")?(var1.field620.equals("-")?0:(var3?-1:1)):(var1.field620.equals("-")?(var3?1:-1):var0.field620.compareTo(var1.field620))):(4 == var2?(var0.method602()?(var1.method602()?0:1):(var1.method602()?-1:0)):(5 == var2?(var0.method603()?(var1.method603()?0:1):(var1.method603()?-1:0)):(6 == var2?(var0.method605()?(var1.method605()?0:1):(var1.method605()?-1:0)):(var2 == 7?(var0.method599()?(var1.method599()?0:1):(var1.method599()?-1:0)):var0.field618 - var1.field618)))));
      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "-818308451"
   )
   static final void method2085(class39 var0, int var1, int var2, int var3) {
      if(client.field415 < 400) {
         if(var0.field892 != null) {
            var0 = var0.method759();
         }

         if(var0 != null) {
            if(var0.field880) {
               if(!var0.field897 || client.field379 == var1) {
                  String var4 = var0.field867;
                  int var8;
                  if(var0.field865 != 0) {
                     int var7 = var0.field865;
                     var8 = class47.field1053.field41;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class219.method3968(16711680);
                     } else if(var9 < -6) {
                        var6 = class219.method3968(16723968);
                     } else if(var9 < -3) {
                        var6 = class219.method3968(16740352);
                     } else if(var9 < 0) {
                        var6 = class219.method3968(16756736);
                     } else if(var9 > 9) {
                        var6 = class219.method3968('\uff00');
                     } else if(var9 > 6) {
                        var6 = class219.method3968(4259584);
                     } else if(var9 > 3) {
                        var6 = class219.method3968(8453888);
                     } else if(var9 > 0) {
                        var6 = class219.method3968(12648192);
                     } else {
                        var6 = class219.method3968(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field865 + ")";
                  }

                  if(client.field280 == 1) {
                     class125.method2769("Use", client.field427 + " " + "->" + " " + class219.method3968(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field511) {
                     if((class11.field174 & 2) == 2) {
                        class125.method2769(client.field362, client.field313 + " " + "->" + " " + class219.method3968(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field882;
                     if(client.field444) {
                        var5 = class50.method1017(var5);
                     }

                     int var11;
                     if(var5 != null) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(var5[var11] != null && !var5[var11].equalsIgnoreCase("Attack")) {
                              byte var10 = 0;
                              if(0 == var11) {
                                 var10 = 9;
                              }

                              if(var11 == 1) {
                                 var10 = 10;
                              }

                              if(2 == var11) {
                                 var10 = 11;
                              }

                              if(3 == var11) {
                                 var10 = 12;
                              }

                              if(4 == var11) {
                                 var10 = 13;
                              }

                              class125.method2769(var5[var11], class219.method3968(16776960) + var4, var10, var1, var2, var3);
                           }
                        }
                     }

                     if(null != var5) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(null != var5[var11] && var5[var11].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(client.field335 != class20.field565) {
                                 if(client.field335 == class20.field559 || client.field335 == class20.field563 && var0.field865 > class47.field1053.field41) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var11 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var11 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(2 == var11) {
                                    var8 = var12 + 11;
                                 }

                                 if(3 == var11) {
                                    var8 = 12 + var12;
                                 }

                                 if(4 == var11) {
                                    var8 = 13 + var12;
                                 }

                                 class125.method2769(var5[var11], class219.method3968(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class125.method2769("Examine", class219.method3968(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1379225819"
   )
   static final void method2086(int var0) {
      if(var0 >= 0) {
         int var1 = client.field385[var0];
         int var2 = client.field417[var0];
         int var3 = client.field418[var0];
         int var4 = client.field502[var0];
         String var5 = client.field420[var0];
         String var6 = client.field290[var0];
         class1.method7(var1, var2, var3, var4, var5, var6, class140.field2135, class140.field2136);
      }
   }
}
