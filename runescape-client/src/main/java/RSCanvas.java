import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = -8878391
   )
   static int field676;
   @ObfuscatedName("i")
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
      signature = "(CI)Z",
      garbageValue = "1694446009"
   )
   public static boolean method828(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
