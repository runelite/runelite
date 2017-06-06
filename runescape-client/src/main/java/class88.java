import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class88 {
   @ObfuscatedName("r")
   public static String[] field1408;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1164780949
   )
   static int field1418;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1697() {
      Overlay.field3583.reset();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-866825563"
   )
   static MessageNode method1699(int var0) {
      return (MessageNode)class98.field1532.method3475((long)var0);
   }
}
