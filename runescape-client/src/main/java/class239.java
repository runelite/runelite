import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
public enum class239 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3258(7, 0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3255(6, 1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3262(5, 2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3261(0, 3),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3257(2, 4),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3259(1, 5),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3260(4, 6),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   field3256(3, 7);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -284381801
   )
   public final int field3254;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1328512283
   )
   final int field3263;

   class239(int var3, int var4) {
      this.field3254 = var3;
      this.field3263 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field3263;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgb;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method4279(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Lhq;B)Lhq;",
      garbageValue = "-75"
   )
   static Widget method4280(Widget var0) {
      Widget var1 = class153.method3030(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
