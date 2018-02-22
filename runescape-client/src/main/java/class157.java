import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public enum class157 implements Enumerated {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   field2117(2, 0),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   field2115(1, 1),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   field2119(0, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfl;"
   )
   field2113(3, 3);

   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 1096410111
   )
   static int field2116;
   @ObfuscatedName("fg")
   static byte[][] field2120;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1812021069
   )
   public final int field2114;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -291439357
   )
   final int field2118;

   class157(int var3, int var4) {
      this.field2114 = var3;
      this.field2118 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1578971771"
   )
   public int rsOrdinal() {
      return this.field2118;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljr;",
      garbageValue = "1628560269"
   )
   public static class271 method3163(int var0) {
      class271 var1 = (class271)class271.field3474.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class271.field3476.getConfigData(11, var0);
         var1 = new class271();
         if(var2 != null) {
            var1.method4861(new Buffer(var2));
         }

         var1.method4862();
         class271.field3474.put(var1, (long)var0);
         return var1;
      }
   }
}
