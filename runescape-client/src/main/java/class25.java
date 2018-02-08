import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class25 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   public static class215 field356;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1782488247
   )
   int field355;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Coordinates field353;

   @ObfuscatedSignature(
      signature = "(ILhv;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field355 = var1;
      this.field353 = var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ldb;I)V",
      garbageValue = "1799719292"
   )
   static final void method184(TaskDataNode var0) {
      var0.field1628 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4311(); var1 != null; var1 = var0.vmethod4312()) {
         method184(var1);
      }

   }
}
