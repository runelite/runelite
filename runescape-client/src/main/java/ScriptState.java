import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = -1741716253
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 536829453
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("i")
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("a")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("t")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2061837013"
   )
   public static int method1103(CharSequence var0) {
      return class181.parseInt(var0, 10, true);
   }
}
