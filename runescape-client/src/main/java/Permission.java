import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
@Implements("Permission")
public enum Permission implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3155(0, -1, true, false, true),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3153(1, 0, true, true, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3154(2, 1, true, true, false),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3152(3, 2, false, false, true),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3156(4, 3, false, false, true),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   field3157(5, 10, false, false, true);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1519154251
   )
   final int field3158;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 928346617
   )
   public final int field3159;
   @ObfuscatedName("i")
   public final boolean field3160;
   @ObfuscatedName("r")
   public final boolean field3161;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3158 = var3;
      this.field3159 = var4;
      this.field3160 = var6;
      this.field3161 = var7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1661971028"
   )
   public int rsOrdinal() {
      return this.field3158;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "406109113"
   )
   public static Enum method4099(int var0) {
      Enum var1 = (Enum)Enum.field3376.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3375.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.field3376.put(var1, (long)var0);
         return var1;
      }
   }
}
