import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public abstract class class107 {
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -578324613
   )
   static int field1880;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 46543181
   )
   public int field1881;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -509944673
   )
   public int field1883;
   @ObfuscatedName("qm")
   static class133 field1884;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 236807255
   )
   public int field1885;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2078467505
   )
   public int field1886;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIIB)V",
      garbageValue = "99"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method2427(class2 var0, int var1, int var2, int var3) {
      if(var0 != class15.field225) {
         if(client.field429 < 400) {
            String var4;
            if(var0.field41 == 0) {
               var4 = var0.field39[0] + var0.field60 + var0.field39[1] + class13.method171(var0.field40, class15.field225.field40) + " " + " (" + "level-" + var0.field40 + ")" + var0.field39[2];
            } else {
               var4 = var0.field39[0] + var0.field60 + var0.field39[1] + " " + " (" + "skill-" + var0.field41 + ")" + var0.field39[2];
            }

            int var5;
            if(client.field353 == 1) {
               class154.method3182("Use", client.field441 + " " + "->" + " " + class164.method3251(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field442) {
               if((class84.field1465 & 8) == 8) {
                  class154.method3182(client.field445, client.field446 + " " + "->" + " " + class164.method3251(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(null != client.field416[var5]) {
                     short var6 = 0;
                     if(client.field416[var5].equalsIgnoreCase("Attack")) {
                        if(class20.field575 == client.field318) {
                           continue;
                        }

                        if(class20.field574 == client.field318 || class20.field573 == client.field318 && var0.field40 > class15.field225.field40) {
                           var6 = 2000;
                        }

                        if(class15.field225.field57 != 0 && var0.field57 != 0) {
                           if(class15.field225.field57 == var0.field57) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(client.field376[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = client.field415[var5] + var6;
                     class154.method3182(client.field416[var5], class164.method3251(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < client.field429; ++var5) {
               if(client.field329[var5] == 23) {
                  client.field435[var5] = class164.method3251(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILclass108;B)Z",
      garbageValue = "-45"
   )
   protected abstract boolean vmethod2428(int var1, int var2, int var3, class108 var4);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1942035726"
   )
   static int method2430(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var1 * var5;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "-1018059717"
   )
   @Export("selectWorld")
   static void method2431(class25 var0) {
      if(var0.method646() != client.field410) {
         client.field410 = var0.method646();
         boolean var1 = var0.method646();
         if(class131.field2066 != var1) {
            class42.method937();
            class131.field2066 = var1;
         }
      }

      class3.field66 = var0.field643;
      client.field386 = var0.field640;
      client.field291 = var0.field641;
      class228.field3230 = client.field293 == 0?'ꩊ':var0.field640 + '鱀';
      class18.field262 = client.field293 == 0?443:var0.field640 + '썐';
      class15.field224 = class228.field3230;
   }
}
