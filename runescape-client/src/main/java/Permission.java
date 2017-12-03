import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3273(0, -1, true, false, true),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3277(1, 0, true, true, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3274(2, 1, true, true, false),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3275(3, 2, false, false, true),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3276(4, 3, false, false, true),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   field3281(5, 10, false, false, true);

   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 443042469
   )
   final int field3280;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 266173609
   )
   public final int field3279;
   @ObfuscatedName("g")
   public final boolean field3278;
   @ObfuscatedName("j")
   public final boolean field3272;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3280 = var3;
      this.field3279 = var4;
      this.field3278 = var6;
      this.field3272 = var7;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field3280;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "2047559669"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class34.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }
}
