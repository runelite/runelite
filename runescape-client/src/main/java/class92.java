import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public enum class92 implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   field1408(0),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   field1417(1),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   field1407(2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lcx;"
   )
   field1410(3);

   @ObfuscatedName("k")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1178388631
   )
   final int field1411;
   @ObfuscatedName("j")
   @Export("tt")
   static int[] tt;

   class92(int var3) {
      this.field1411 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field1411;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lew;IIII)Z",
      garbageValue = "974489320"
   )
   public static final boolean method1746(Model var0, int var1, int var2, int var3) {
      if(!class44.method615()) {
         return false;
      } else {
         class97.method1821();
         int var4 = var0.field1944 + var1;
         int var5 = var2 + var0.field1945;
         int var6 = var3 + var0.field1946;
         int var7 = var0.field1939;
         int var8 = var0.field1948;
         int var9 = var0.field1942;
         int var10 = class135.field1986 - var4;
         int var11 = class20.field326 - var5;
         int var12 = class5.field32 - var6;
         return Math.abs(var10) > var7 + class135.field1987?false:(Math.abs(var11) > var8 + class19.field325?false:(Math.abs(var12) > var9 + class64.field790?false:(Math.abs(var12 * class237.field3218 - var11 * SceneTilePaint.field2027) > var9 * class19.field325 + var8 * class64.field790?false:(Math.abs(var10 * SceneTilePaint.field2027 - var12 * class93.field1428) > var7 * class64.field790 + var9 * class135.field1987?false:Math.abs(var11 * class93.field1428 - var10 * class237.field3218) <= var7 * class19.field325 + var8 * class135.field1987))));
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;I)V",
      garbageValue = "-564376346"
   )
   public static void method1747(IndexDataBase var0) {
      class244.field3301 = var0;
   }
}
