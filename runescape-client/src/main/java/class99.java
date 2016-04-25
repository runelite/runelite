import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("ItemLayer")
public final class class99 {
   @ObfuscatedName("m")
   @Export("middle")
   class85 field1651;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1492746737
   )
   @Export("hash")
   int field1652;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -733362499
   )
   @Export("y")
   int field1653;
   @ObfuscatedName("z")
   @Export("bottom")
   class85 field1654;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 5603321
   )
   @Export("flags")
   int field1657;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 843424853
   )
   @Export("height")
   int field1658;
   @ObfuscatedName("jz")
   @ObfuscatedGetter(
      intValue = -1729110699
   )
   static int field1659;
   @ObfuscatedName("cs")
   static class143 field1660;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -928188379
   )
   @Export("x")
   int field1663;
   @ObfuscatedName("e")
   @Export("top")
   class85 field1665;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "115"
   )
   static final String method2195(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-405941328"
   )
   static int method2196(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
