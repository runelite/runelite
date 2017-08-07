import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class221 {
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(Lcp;IS)V",
      garbageValue = "-26196"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class113.method2110(var0.x, var0.y, var1);
   }
}
