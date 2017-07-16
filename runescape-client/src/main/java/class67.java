import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class67 extends class196 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 831416131
   )
   int field820;
   @ObfuscatedName("j")
   String field817;
   @ObfuscatedName("n")
   short field818;

   class67(String var1, int var2) {
      this.field820 = (int)(class46.currentTimeMs() / 1000L);
      this.field817 = var1;
      this.field818 = (short)var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1445712581"
   )
   public static int method1088(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)Lbv;",
      garbageValue = "82652202"
   )
   static MessageNode method1087(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var2.method1843(var1);
   }
}
