import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1609933409
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("n")
   static NodeCache field1534;
   @ObfuscatedName("j")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -818237471
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("p")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1961003509
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("i")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("h")
   @Export("switches")
   class186[] switches;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1367573717
   )
   @Export("stringStackCount")
   int stringStackCount;

   static {
      field1534 = new NodeCache(128);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "389589350"
   )
   static final int method1824() {
      return Client.menuOptionCount <= 0?-1:(Client.field1179 && class50.field624[81] && Client.field1062 != -1?Client.field1062:Client.menuOptionCount - 1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "73"
   )
   public static int method1836(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[Lclass186;",
      garbageValue = "-820043518"
   )
   class186[] method1837(int var1) {
      return new class186[var1];
   }
}
