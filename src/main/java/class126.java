import java.applet.Applet;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public class class126 {
   @ObfuscatedName("aq")
   static class146 field2039;
   @ObfuscatedName("a")
   static Applet field2041;
   @ObfuscatedName("k")
   static int[] field2042;

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "433661805"
   )
   static final void method2930(class39 var0, int var1, int var2, int var3) {
      if(client.field434 < 400) {
         if(var0.field916 != null) {
            var0 = var0.method862();
         }

         if(null != var0) {
            if(var0.field898) {
               if(!var0.field921 || client.field460 == var1) {
                  String var4 = var0.field917;
                  int var8;
                  if(var0.field905 != 0) {
                     int var7 = var0.field905;
                     var8 = class5.field93.field38;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class139.method3046(16711680);
                     } else if(var9 < -6) {
                        var6 = class139.method3046(16723968);
                     } else if(var9 < -3) {
                        var6 = class139.method3046(16740352);
                     } else if(var9 < 0) {
                        var6 = class139.method3046(16756736);
                     } else if(var9 > 9) {
                        var6 = class139.method3046('\uff00');
                     } else if(var9 > 6) {
                        var6 = class139.method3046(4259584);
                     } else if(var9 > 3) {
                        var6 = class139.method3046(8453888);
                     } else if(var9 > 0) {
                        var6 = class139.method3046(12648192);
                     } else {
                        var6 = class139.method3046(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field905 + ")";
                  }

                  if(1 == client.field448) {
                     class23.method671("Use", client.field378 + " " + "->" + " " + class139.method3046(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field447) {
                     if(2 == (class161.field2636 & 2)) {
                        class23.method671(client.field297, client.field534 + " " + "->" + " " + class139.method3046(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field906;
                     if(client.field463) {
                        var5 = class89.method2163(var5);
                     }

                     int var11;
                     if(null != var5) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(var5[var11] != null && !var5[var11].equalsIgnoreCase("Attack")) {
                              byte var10 = 0;
                              if(var11 == 0) {
                                 var10 = 9;
                              }

                              if(1 == var11) {
                                 var10 = 10;
                              }

                              if(2 == var11) {
                                 var10 = 11;
                              }

                              if(3 == var11) {
                                 var10 = 12;
                              }

                              if(var11 == 4) {
                                 var10 = 13;
                              }

                              class23.method671(var5[var11], class139.method3046(16776960) + var4, var10, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(null != var5[var11] && var5[var11].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class20.field585 != client.field508) {
                                 if(class20.field580 == client.field508 || client.field508 == class20.field587 && var0.field905 > class5.field93.field38) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var11 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(1 == var11) {
                                    var8 = 10 + var12;
                                 }

                                 if(2 == var11) {
                                    var8 = var12 + 11;
                                 }

                                 if(var11 == 3) {
                                    var8 = var12 + 12;
                                 }

                                 if(4 == var11) {
                                    var8 = var12 + 13;
                                 }

                                 class23.method671(var5[var11], class139.method3046(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class23.method671("Examine", class139.method3046(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2132873739"
   )
   public static void method2934() {
      Object var0 = class170.field2705;
      synchronized(class170.field2705) {
         if(class170.field2706 != 0) {
            class170.field2706 = 1;

            try {
               class170.field2705.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lclass37;II)V",
      garbageValue = "1385934853"
   )
   static final void method2935(class37 var0, int var1) {
      class7.method140(var0.field844, var0.field819, var1);
   }
}
