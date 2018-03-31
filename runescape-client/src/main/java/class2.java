import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
final class class2 implements class0 {
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lbk;",
      garbageValue = "697133436"
   )
   static MessageNode method1(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      return var2.getMessage(var1);
   }
}
