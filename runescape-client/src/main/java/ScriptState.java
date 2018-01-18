import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("invokedFromScript")
   Script invokedFromScript;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1058908433
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("y")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("r")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;

   ScriptState() {
      this.invokedFromPc = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-97"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }
}
