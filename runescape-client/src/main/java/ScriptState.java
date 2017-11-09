import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      longValue = 6877767530086193577L
   )
   static long field744;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lcw;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -673577491
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("i")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("j")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
