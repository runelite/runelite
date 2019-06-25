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
   @Export("__is_m")
   __is_m("runescape", "RuneScape", 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("__is_f")
   __is_f("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("__is_q")
   __is_q("game3", "Game 3", 2),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("__is_w")
  __is_w("game4", "Game 4", 3),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("__is_o")
   __is_o("game5", "Game 5", 4),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("__is_u")
   __is_u("oldscape", "RuneScape 2007", 5);
   
   @ObfuscatedName("g")
   @Export("name")
   public final String name;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1688917715
   )
   @Export("id")
   final int id;
   
   StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("ordinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lih;",
      garbageValue = "-2058685786"
   )
   public static UnderlayDefinition method4550(int var0) {
      UnderlayDefinition var1 = (UnderlayDefinition)UnderlayDefinition.UnderlayDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = UnderlayDefinition.UnderlayDefinition_indexCache.takeRecord(1, var0);
         var1 = new UnderlayDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2), var0);
         }

         var1.init();
         UnderlayDefinition.UnderlayDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
