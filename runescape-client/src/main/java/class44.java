import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class44 {
   @ObfuscatedName("oy")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1979957493
   )
   int field563;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 389145917
   )
   int field561;
   @ObfuscatedName("b")
   int[][] field562;
   @ObfuscatedName("z")
   int[][] field567;
   @ObfuscatedName("n")
   int[][] field564;
   @ObfuscatedName("l")
   int[][] field560;

   class44(int var1, int var2) {
      this.field563 = var1;
      this.field561 = var2;
      this.field562 = new int[var1][var2];
      this.field567 = new int[var1][var2];
      this.field564 = new int[var1][var2];
      this.field560 = new int[var1][var2];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIILjv;I)V",
      garbageValue = "-1824856081"
   )
   void method671(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field563 && var2 - var3 <= this.field561) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field563, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field561, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field562[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field567[var9][var10] += var4.saturation;
                     this.field564[var9][var10] += var4.lightness;
                     ++this.field560[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1587196262"
   )
   int method664(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field563 && var2 < this.field561) {
         if(this.field564[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field562[var1][var2] / this.field560[var1][var2];
            int var4 = this.field567[var1][var2] / this.field560[var1][var2];
            int var5 = this.field564[var1][var2] / this.field560[var1][var2];
            return GrandExchangeEvents.method83((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Liz;",
      garbageValue = "-1946226186"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = UnitPriceComparator.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("kb")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "29"
   )
   static boolean method670() {
      return Client.rights >= 2;
   }
}
