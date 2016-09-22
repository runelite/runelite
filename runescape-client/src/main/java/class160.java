import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class160 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "-1481720729"
   )
   static MessageNode method3210(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return var2.method669(var1);
   }
}
