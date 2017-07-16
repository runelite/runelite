import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 363033299
   )
   static int field771;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1316567765
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcg;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
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
