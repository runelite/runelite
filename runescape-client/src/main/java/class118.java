import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class118 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 818407197
   )
   static int field1863;
   @ObfuscatedName("u")
   static int[][] field1865 = new int[128][128];
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -465967023
   )
   static int field1866;
   @ObfuscatedName("m")
   static int[] field1867 = new int[4096];
   @ObfuscatedName("ny")
   static class65 field1868;
   @ObfuscatedName("n")
   static int[] field1869 = new int[4096];
   @ObfuscatedName("h")
   static int[][] field1870 = new int[128][128];

   class118() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "1503903794"
   )
   public static Widget method2354(int var0, int var1) {
      Widget var2 = FaceNormal.method1932(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
