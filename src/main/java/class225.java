import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public abstract class class225 {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "1165501547"
   )
   static final void method4107(class39 var0, int var1, int var2, int var3) {
      if(client.field420 < 400) {
         if(var0.field888 != null) {
            var0 = var0.method762();
         }

         if(null != var0) {
            if(var0.field891) {
               if(!var0.field896 || var1 == client.field327) {
                  String var4 = var0.field863;
                  if(var0.field880 != 0) {
                     var4 = var4 + class18.method189(var0.field880, class20.field572.field39) + " " + " (" + "level-" + var0.field880 + ")";
                  }

                  if(client.field431 == 1) {
                     class11.method156("Use", client.field392 + " " + "->" + " " + class39.method784(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field433) {
                     if(2 == (class190.field3048 & 2)) {
                        class11.method156(client.field377, client.field437 + " " + "->" + " " + class39.method784(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field878;
                     if(client.field539) {
                        var5 = class9.method130(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(1 == var6) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(3 == var6) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class11.method156(var5[var6], class39.method784(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(class20.field569 != client.field488) {
                                 if(class20.field562 == client.field488 || class20.field564 == client.field488 && var0.field880 > class20.field572.field39) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(1 == var6) {
                                    var8 = 10 + var9;
                                 }

                                 if(var6 == 2) {
                                    var8 = 11 + var9;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var9;
                                 }

                                 if(4 == var6) {
                                    var8 = var9 + 13;
                                 }

                                 class11.method156(var5[var6], class39.method784(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class11.method156("Examine", class39.method784(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }
}
