import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bo")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("i")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1184594601
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("j")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;
   @ObfuscatedName("ag")
   protected static boolean field760;
   @ObfuscatedName("n")
   @Export("invokedFromScript")
   Script invokedFromScript;

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
