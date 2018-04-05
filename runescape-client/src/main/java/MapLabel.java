import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 843972681
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("o")
   @Export("text")
   String text;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1110346963
   )
   int field470;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -279191477
   )
   int field469;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILe;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field470 = var2;
      this.field469 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-950710445"
   )
   static final int method410() {
      return class132.Viewport_mouseY;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1373634048"
   )
   static final void method411(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1072[var4] = true;
         }
      }

   }
}
