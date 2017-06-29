import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class202 {
   @ObfuscatedName("w")
   byte[] field2494;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1351230933
   )
   int field2495;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1151603289
   )
   int field2497;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -726322569
   )
   int field2498;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1900812197
   )
   int field2499;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 603848023
   )
   int field2500;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -575311255
   )
   int field2501;
   @ObfuscatedName("i")
   byte[] field2503;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 689800859
   )
   int field2504;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "59"
   )
   public static Widget method3650(int var0, int var1) {
      Widget var2 = PacketBuffer.method3403(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
