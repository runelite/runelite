import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("g")
   @Export("osName")
   static String osName;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1287342727
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1328833299
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("t")
   @Export("option")
   String option;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 344581557
   )
   @Export("type")
   int type;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1806237659
   )
   @Export("identifier")
   int identifier;
}
