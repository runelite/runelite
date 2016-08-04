import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class93 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1262482351
   )
   static int field1634;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lclass134;",
      garbageValue = "-67"
   )
   public static class134 method2162() {
      try {
         return new class148();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass41;IIIB)V",
      garbageValue = "-15"
   )
   static final void method2163(class41 var0, int var1, int var2, int var3) {
      if(client.field368 < 400) {
         if(var0.field937 != null) {
            var0 = var0.method820();
         }

         if(var0 != null) {
            if(var0.field940) {
               if(!var0.field942 || var1 == client.field555) {
                  String var4 = var0.field912;
                  if(var0.field920 != 0) {
                     var4 = var4 + class136.method3003(var0.field920, class3.field65.field37) + " " + " (" + "level-" + var0.field920 + ")";
                  }

                  if(client.field439 == 1) {
                     class107.method2394("Use", client.field447 + " " + "->" + " " + class16.method205(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field448) {
                     if((class27.field675 & 2) == 2) {
                        class107.method2394(client.field306, client.field452 + " " + "->" + " " + class16.method205(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field927;
                     if(client.field464) {
                        var5 = class19.method241(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(var6 == 1) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(var6 == 3) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class107.method2394(var5[var6], class16.method205(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class21.field589 != client.field420) {
                                 if(client.field420 == class21.field587 || class21.field590 == client.field420 && var0.field920 > class3.field65.field37) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(var6 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var9;
                                 }

                                 class107.method2394(var5[var6], class16.method205(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class107.method2394("Examine", class16.method205(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
