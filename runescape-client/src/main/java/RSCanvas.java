import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   public static Buffer field678;
   @ObfuscatedName("d")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1533576356"
   )
   static void method810(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class138.worldList[var6];
         class138.worldList[var6] = class138.worldList[var1];
         class138.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class138.worldList[var9];
            int var12 = MilliTimer.method3004(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = MilliTimer.method3004(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class138.worldList[var9];
               class138.worldList[var9] = class138.worldList[var7];
               class138.worldList[var7++] = var14;
            }
         }

         class138.worldList[var1] = class138.worldList[var7];
         class138.worldList[var7] = var8;
         method810(var0, var7 - 1, var2, var3, var4, var5);
         method810(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
