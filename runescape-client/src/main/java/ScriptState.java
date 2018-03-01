import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("g")
   static int[] field755;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1554616735
   )
   static int field759;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1513402411
   )
   static int field758;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 61312749
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("n")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("r")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
