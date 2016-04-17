import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class188 {
   @ObfuscatedName("gl")
   public static final int[] field3057 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 6, 8, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 0, 2, 6, 5, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 6, 0, 0, 20, 0, -2, 0, 0, 0, 0, 6, 0, 0, 0, -2, 0, 0, -2, 14, 6, 0, 0, 0, 0, 0, 0, 7, 3, 0, 3, 0, -2, 0, 0, 5, 0, -1, -1, -2, 0, 5, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2, 0, 0, 0, 0, 0, 6, -2, 0, 8, 0, 0, 0, 0, -2, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 2, 6, -2, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 2, 0, -2, 0, 0, 0, 0, -1, 0, 0, 28, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, -2, 0, 7, 0, 4, 0, 2, 4, 0, 1, -2, 0, 2, 10, 0, 0, 0, 8, 12, 0, -2, 0, 6, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 15, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 4, 0, 0, 10, 2, 0, 0, 0, 0, 0, 0, 6, -2, 6, 0, -2, 0};

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "-209408628"
   )
   static final void method3828(class2 var0, int var1, int var2, int var3) {
      if(class5.field93 != var0) {
         if(client.field434 < 400) {
            String var4;
            int var7;
            if(0 == var0.field39) {
               String var5 = var0.field55[0] + var0.field58 + var0.field55[1];
               var7 = var0.field38;
               int var8 = class5.field93.field38;
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

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field38 + ")" + var0.field55[2];
            } else {
               var4 = var0.field55[0] + var0.field58 + var0.field55[1] + " " + " (" + "skill-" + var0.field39 + ")" + var0.field55[2];
            }

            int var10;
            if(1 == client.field448) {
               class23.method671("Use", client.field378 + " " + "->" + " " + class139.method3046(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field447) {
               if(8 == (class161.field2636 & 8)) {
                  class23.method671(client.field297, client.field534 + " " + "->" + " " + class139.method3046(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(client.field317[var10] != null) {
                     short var12 = 0;
                     if(client.field317[var10].equalsIgnoreCase("Attack")) {
                        if(client.field322 == class20.field585) {
                           continue;
                        }

                        if(class20.field580 == client.field322 || client.field322 == class20.field587 && var0.field38 > class5.field93.field38) {
                           var12 = 2000;
                        }

                        if(class5.field93.field63 != 0 && var0.field63 != 0) {
                           if(var0.field63 == class5.field93.field63) {
                              var12 = 2000;
                           } else {
                              var12 = 0;
                           }
                        }
                     } else if(client.field422[var10]) {
                        var12 = 2000;
                     }

                     boolean var11 = false;
                     var7 = client.field420[var10] + var12;
                     class23.method671(client.field317[var10], class139.method3046(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.field434; ++var10) {
               if(23 == client.field437[var10]) {
                  client.field440[var10] = class139.method3046(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-23369511"
   )
   static void method3829(int var0) {
      for(class201 var1 = (class201)client.field495.method3871(); null != var1; var1 = (class201)client.field495.method3867()) {
         if((var1.field3125 >> 48 & 65535L) == (long)var0) {
            var1.method3998();
         }
      }

   }
}
