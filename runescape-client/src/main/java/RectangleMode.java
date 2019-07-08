import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("RectangleMode")
public enum RectangleMode implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("SOLID")
   SOLID(0, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("GRADIENT_COLOR")
   GRADIENT_COLOR(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llj;"
   )
   @Export("GRADIENT_ALPHA")
   GRADIENT_ALPHA(2, 2);

   @ObfuscatedName("d")
   @Export("musicTrackBoolean")
   public static boolean musicTrackBoolean;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1391612747
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1204297807
   )
   @Export("id")
   final int id;

   private RectangleMode(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;ZB)V",
      garbageValue = "1"
   )
   @Export("setObjectDefinitionArchives")
   public static void setObjectDefinitionArchives(AbstractArchive var0, AbstractArchive var1, boolean isLowDetail) {
      ObjectDefinition.ObjectDefinition_archive = var0;
      ObjectDefinition.field640 = var1;
      ObjectDefinition.ObjectDefinition_isLowDetail = isLowDetail;
   }
}
