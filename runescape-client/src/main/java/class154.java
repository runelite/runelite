import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class154 {
   @ObfuscatedName("r")
   static ModIcon field2317;
   @ObfuscatedName("x")
   static class183 field2324;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1536367100"
   )
   static int method3187(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method673();
   }
}
