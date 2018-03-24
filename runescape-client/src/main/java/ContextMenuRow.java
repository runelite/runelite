import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("t")
   @Export("option")
   String option;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1856524257
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1992101739
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1540753369
   )
   @Export("type")
   int type;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1066373001
   )
   @Export("identifier")
   int identifier;
}
