import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public enum class150 implements RSEnum {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2119(1, 0),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2117(0, 1),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2116(2, 2),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   field2120(3, 3);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 712590095
   )
   public final int field2118;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2146134293
   )
   final int field2121;

   class150(int var3, int var4) {
      this.field2118 = var3;
      this.field2121 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "369425307"
   )
   public int rsOrdinal() {
      return this.field2121;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Len;II)V",
      garbageValue = "-2140711963"
   )
   public static final void method3029(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1850; ++var2) {
         if(var0.field1856[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1900[var3];
            int var7 = Model.field1900[var4];
            int var8 = Model.field1900[var5];
            class3.method7(Model.field1884[var3], Model.field1884[var4], Model.field1884[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;I)[Lko;",
      garbageValue = "794038294"
   )
   public static IndexedSprite[] method3023(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class81.method1694(var0, var3, var4);
   }
}
