import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class18 extends Node {
   @ObfuscatedName("x")
   Widget field180;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1517601513
   )
   int field183;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 656316935
   )
   int field184;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1046209895
   )
   int field185;
   @ObfuscatedName("j")
   Widget field186;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1017650469
   )
   int field187;
   @ObfuscatedName("p")
   Object[] field188;
   @ObfuscatedName("g")
   boolean field189;
   @ObfuscatedName("a")
   String field190;
   @ObfuscatedName("di")
   static byte[][] field193;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -638856121
   )
   int field195;
   @ObfuscatedName("ae")
   static class110 field196;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 590477317
   )
   int field198;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "29"
   )
   static final void method190() {
      int var0 = class45.field898;
      int[] var1 = class45.field895;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            class22.method211(var3, 1);
         }
      }

   }
}
