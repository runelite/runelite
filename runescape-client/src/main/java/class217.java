import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
final class class217 implements Comparator {
   @ObfuscatedName("s")
   @Export("widgets")
   public static class173[][] field3171;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "119"
   )
   int method3941(class214 var1, class214 var2) {
      return var1.field3159.field3176 < var2.field3159.field3176?-1:(var2.field3159.field3176 == var1.field3159.field3176?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3941((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("qs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-645569101"
   )
   protected static final void method3942() {
      class43.field1020.vmethod3104();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2208[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         class144.field2215[var0] = 0L;
      }

      class33.field777 = 0;
   }
}
