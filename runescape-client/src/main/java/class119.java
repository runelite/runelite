import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
public abstract class class119 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1243662583
   )
   public int field1852;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1810138857
   )
   public int field1854;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -606318035
   )
   public int field1855;
   @ObfuscatedName("de")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1512401891
   )
   public int field1857;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "245014910"
   )
   protected abstract boolean vmethod2339(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "-121"
   )
   public static int method2340(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "-1697923377"
   )
   public static class158 method2341(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4101()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;B)[Ljava/lang/String;",
      garbageValue = "-8"
   )
   static final String[] method2343(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
