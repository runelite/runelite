package net.runelite.rs.client;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public final class class138 extends Canvas {
   @ObfuscatedName("iv")
   @ObfuscatedGetter(
      intValue = 1035273299
   )
   static int field2124;
   @ObfuscatedName("j")
   Component field2127;

   public final void update(Graphics var1) {
      this.field2127.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2127.paint(var1);
   }

   class138(Component var1) {
      this.field2127 = var1;
   }

   @ObfuscatedName("h")
   static final void method2977(class118 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class5.field86[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.method2536();
            if(0 == var7) {
               if(0 == var1) {
                  class5.field79[0][var2][var3] = -class72.method1598(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class5.field79[var1][var2][var3] = class5.field79[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.method2536();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class5.field79[0][var2][var3] = -var8 * 8;
               } else {
                  class5.field79[var1][var2][var3] = class5.field79[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class164.field2645[var1][var2][var3] = var0.method2537();
               class5.field76[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class133.field2058[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class5.field86[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class5.field85[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.method2536();
            if(0 == var7) {
               break;
            }

            if(var7 == 1) {
               var0.method2536();
               break;
            }

            if(var7 <= 49) {
               var0.method2536();
            }
         }
      }

   }
}
