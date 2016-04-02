import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class24 extends class208 {
   @ObfuscatedName("w")
   String field607;
   @ObfuscatedName("s")
   @Export("rank")
   byte field608;
   @ObfuscatedName("e")
   @Export("username")
   String field609;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1628518239
   )
   @Export("world")
   int field610;
   @ObfuscatedName("br")
   static class168 field611;

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "869565902"
   )
   static final void method593(class2 var0, int var1, int var2, int var3) {
      if(var0 != class20.field572) {
         if(client.field420 < 400) {
            String var4;
            if(0 == var0.field40) {
               var4 = var0.field46[0] + var0.field45 + var0.field46[1] + class18.method189(var0.field39, class20.field572.field39) + " " + " (" + "level-" + var0.field39 + ")" + var0.field46[2];
            } else {
               var4 = var0.field46[0] + var0.field45 + var0.field46[1] + " " + " (" + "skill-" + var0.field40 + ")" + var0.field46[2];
            }

            int var5;
            if(client.field431 == 1) {
               class11.method156("Use", client.field392 + " " + "->" + " " + class39.method784(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field433) {
               if(8 == (class190.field3048 & 8)) {
                  class11.method156(client.field377, client.field437 + " " + "->" + " " + class39.method784(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(client.field406[var5] != null) {
                     short var6 = 0;
                     if(client.field406[var5].equalsIgnoreCase("Attack")) {
                        if(client.field454 == class20.field569) {
                           continue;
                        }

                        if(client.field454 == class20.field562 || class20.field564 == client.field454 && var0.field39 > class20.field572.field39) {
                           var6 = 2000;
                        }

                        if(class20.field572.field62 != 0 && var0.field62 != 0) {
                           if(var0.field62 == class20.field572.field62) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field407[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + client.field353[var5];
                     class11.method156(client.field406[var5], class39.method784(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field420; ++var5) {
               if(23 == client.field301[var5]) {
                  client.field426[var5] = class39.method784(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("p")
   static final boolean method594(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      class119 var4 = new class119(var0);
      int var5 = -1;

      label85:
      while(true) {
         int var6 = var4.method2536();
         if(0 == var6) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.method2536();
               if(0 == var9) {
                  continue label85;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.method2523() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  class40 var15 = class26.method633(var5);
                  if(22 != var12 || !client.field285 || var15.field922 != 0 || var15.field924 == 1 || var15.field940) {
                     if(!var15.method792()) {
                        ++client.field335;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.method2536();
            if(var9 == 0) {
               break;
            }

            var4.method2523();
         }
      }
   }
}
