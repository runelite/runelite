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
   @Export("worldMap0")
   static WorldMap worldMap0;
   @ObfuscatedName("ar")
   static FontMetrics field1162;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;Lir;I)V",
      garbageValue = "1583108922"
   )
   public static void method1172(AbstractIndexCache var0, AbstractIndexCache var1, AbstractIndexCache var2) {
      HitSplatDefinition.field382 = var0;
      HitSplatDefinition.field383 = var1;
      HitSplatDefinition.field384 = var2;
   }
}
