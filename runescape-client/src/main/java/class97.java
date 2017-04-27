import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class97 implements class134 {
   @ObfuscatedName("c")
   public static final class97 field1619 = new class97(0, 1);
   @ObfuscatedName("n")
   public static final class97 field1620 = new class97(3, 2);
   @ObfuscatedName("d")
   public static final class97 field1621 = new class97(1, 0);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -871963227
   )
   public final int field1622;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -143718531
   )
   final int field1623;
   @ObfuscatedName("q")
   public static final class97 field1626 = new class97(2, 3);
   @ObfuscatedName("gi")
   static Widget field1627;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1622 = var1;
      this.field1623 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1946751124"
   )
   public int vmethod4163() {
      return this.field1623;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass188;",
      garbageValue = "-1291448846"
   )
   public static class188 method1933(int var0) {
      class188 var1 = (class188)class188.field2775.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class188.field2781.getConfigData(5, var0);
         var1 = new class188();
         if(var2 != null) {
            var1.method3424(new Buffer(var2));
         }

         class188.field2775.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-466540281"
   )
   public static void method1934(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.field2799 = var0;
      Spotanim.field2800 = var1;
   }
}
