import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class20 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhy;I)Z",
      garbageValue = "1824008881"
   )
   public static boolean method156(class219 var0) {
      return class219.field2779 == var0 || class219.field2778 == var0 || class219.field2780 == var0 || class219.field2781 == var0 || class219.field2782 == var0 || class219.field2785 == var0 || class219.field2784 == var0 || class219.field2783 == var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-950877590"
   )
   static int method155(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1908();
   }
}
