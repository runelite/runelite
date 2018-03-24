import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public enum class158 implements Enumerated {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   field2126(1, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   field2123(2, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   field2124(3, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   field2125(0, 3);

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -623389511
   )
   public final int field2128;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 523422393
   )
   final int field2127;

   class158(int var3, int var4) {
      this.field2128 = var3;
      this.field2127 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int rsOrdinal() {
      return this.field2127;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lkf;",
      garbageValue = "-69"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class2.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1938098369"
   )
   public static int method3176(CharSequence var0) {
      return IndexData.parseInt(var0, 10, true);
   }
}
