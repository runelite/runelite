import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public enum class228 implements RSEnum {
   @ObfuscatedName("a")
   field3155(6, 0),
   @ObfuscatedName("j")
   field3159(5, 1),
   @ObfuscatedName("n")
   field3153(2, 2),
   @ObfuscatedName("r")
   field3154(1, 3),
   @ObfuscatedName("v")
   field3161(4, 4),
   @ObfuscatedName("e")
   field3156(3, 5),
   @ObfuscatedName("l")
   field3157(7, 6),
   @ObfuscatedName("s")
   field3158(0, 7);

   @ObfuscatedName("m")
   static ModIcon field3151;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1559279583
   )
   public final int field3152;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -571644835
   )
   final int field3160;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class228(int var3, int var4) {
      this.field3152 = var3;
      this.field3160 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field3160;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lclass251;",
      garbageValue = "-505208587"
   )
   public static class251 method4068(int var0) {
      class251 var1 = (class251)class251.field3385.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3386.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4380(new Buffer(var2));
         }

         var1.method4379();
         class251.field3385.put(var1, (long)var0);
         return var1;
      }
   }
}
