import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("clock")
   static Clock clock;
   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field937;
   @ObfuscatedName("m")
   final boolean field938;

   public UserComparator6(boolean var1) {
      this.field938 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "750521759"
   )
   int method348(Buddy var1, Buddy var2) {
      return var1.world0 != 0 && var2.world0 != 0 ? (this.field938 ? var1.username().compareTo0(var2.username()) : var2.username().compareTo0(var1.username())) : this.method12(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method348((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1968376475"
   )
   static final void method3390(int var0, int var1, int var2, int var3) {
      for (int var4 = var1; var4 <= var3 + var1; ++var4) {
         for (int var5 = var0; var5 <= var0 + var2; ++var5) {
            if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Tiles.field909[0][var5][var4] = 127;
               if (var0 == var5 && var5 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
               }

               if (var5 == var0 + var2 && var5 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
               }

               if (var4 == var1 && var4 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
               }

               if (var3 + var1 == var4 && var4 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
