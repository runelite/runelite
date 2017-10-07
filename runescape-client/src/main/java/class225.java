import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class225 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2079103650"
   )
   static int method4197(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class238.currentRequest != null && var2 == class238.currentRequest.hash?RSCanvas.field678.offset * 99 / (RSCanvas.field678.payload.length - class238.currentRequest.padding) + 1:0;
   }
}
