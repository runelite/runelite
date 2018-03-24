import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3438(1, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3439(0, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   field3437(2, 2);

   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -893377425
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1129689051
   )
   final int field3441;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3441 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field3441;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljr;",
      garbageValue = "646736533"
   )
   public static Varbit method4748(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-454617599"
   )
   public static boolean method4747(char var0) {
      return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
