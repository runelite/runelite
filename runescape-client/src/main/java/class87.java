import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class87 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -874900193
   )
   int field1392;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -387911131
   )
   int field1391;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 322599251
   )
   int field1390;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1636713985
   )
   int field1393;
   @ObfuscatedName("q")
   String field1394;

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "5"
   )
   static String method1776(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }
}
