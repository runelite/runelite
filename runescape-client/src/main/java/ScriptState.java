import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "Lli;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2139558841
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("o")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("j")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
