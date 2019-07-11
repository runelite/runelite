import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class60 {
   @ObfuscatedName("sz")
   @ObfuscatedSignature(
      signature = "Llz;"
   )
   @Export("worldMap")
   static WorldMap worldMap;
   @ObfuscatedName("ar")
   static FontMetrics field1162;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;I)V",
      garbageValue = "1583108922"
   )
   @Export("setHitSplatDefinitionArchives")
   public static void setHitSplatDefinitionArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
      HitSplatDefinition.HitSplatDefinition_archive = var0;
      HitSplatDefinition.HitSplatDefinition_spritesArchive = var1;
      HitSplatDefinition.HitSplatDefinition_fontsArchive = var2;
   }
}
