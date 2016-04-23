import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class159 implements class112 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 571939257
   )
   public final int field2589;
   @ObfuscatedName("h")
   public static final class159 field2590 = new class159(3, 1);
   @ObfuscatedName("m")
   public static final class159 field2591 = new class159(0, 2);
   @ObfuscatedName("z")
   public static final class159 field2592 = new class159(1, 3);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 327316875
   )
   final int field2594;
   @ObfuscatedName("j")
   public static final class159 field2595 = new class159(2, 0);

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   class159(int var1, int var2) {
      this.field2589 = var1;
      this.field2594 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int vmethod3136() {
      return this.field2594;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1746808348"
   )
   public static int method3139(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "24"
   )
   public static void method3140() {
      try {
         class149.field2217.method4118();

         for(int var0 = 0; var0 < class10.field166; ++var0) {
            class15.field221[var0].method4118();
         }

         class149.field2218.method4118();
         class149.field2215.method4118();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-686830520"
   )
   static final void method3141() {
      client.field395 = 0;
      int var0 = (class47.field1053.field816 >> 7) + class187.field3014;
      int var1 = (class47.field1053.field840 >> 7) + class0.field12;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field395 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field395 = 1;
      }

      if(client.field395 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field395 = 0;
      }

   }
}
