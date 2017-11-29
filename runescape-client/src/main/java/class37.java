import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class37 {
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = 355621363
   )
   static int field488;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 1317363531
   )
   static int field489;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1241125527"
   )
   public static char method508(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1104847124"
   )
   public static int method510(CharSequence var0) {
      return Varcs.parseInt(var0, 10, true);
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(IZZZI)Liv;",
      garbageValue = "104295054"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.dat2File != null) {
         var4 = new IndexFile(var0, class156.dat2File, ItemContainer.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, GrandExchangeOffer.indexStore255, var0, var1, var2, var3);
   }
}
