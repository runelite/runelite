import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public enum class222 implements RSEnum {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2819(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2834(1, 0),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2821(2, 0),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2830(3, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2837(9, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2823(4, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2825(5, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2824(6, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2827(7, 1),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2828(8, 1),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2829(12, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2832(13, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2831(14, 2),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2826(15, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2833(16, 2),
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2820(17, 2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2835(18, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2836(19, 2),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2822(20, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2838(21, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2839(10, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2840(11, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   field2841(22, 3);

   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -140182977
   )
   public final int field2842;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class222(int var3, int var4) {
      this.field2842 = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "959363303"
   )
   public int rsOrdinal() {
      return this.field2842;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Liy;",
      garbageValue = "37"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class54.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }
}
