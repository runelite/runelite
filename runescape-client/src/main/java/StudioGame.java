import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("StudioGame")
public enum StudioGame implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field887("runescape", "RuneScape", 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field888("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field889("game3", "Game 3", 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field890("game4", "Game 4", 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field891("game5", "Game 5", 4),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field892("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("g")
   @Export("name")
   public final String name;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1688917715
   )
   @Export("id")
   final int id;

   private StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lih;",
      garbageValue = "-2058685786"
   )
   public static FloorUnderlayDefinition method4550(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var0);
         var1 = new FloorUnderlayDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.postDecode();
         FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
