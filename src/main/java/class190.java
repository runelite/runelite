import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class190 {
   @ObfuscatedName("x")
   public static final class190 field3065 = new class190("3", "3");
   @ObfuscatedName("w")
   public static final class190 field3066 = new class190("7", "7");
   @ObfuscatedName("e")
   public static final class190 field3067 = new class190("9", "9");
   @ObfuscatedName("z")
   public static final class190 field3068 = new class190("2", "2");
   @ObfuscatedName("y")
   public static final class190 field3069 = new class190("14", "14");
   @ObfuscatedName("m")
   public static final class190 field3070 = new class190("12", "12");
   @ObfuscatedName("c")
   public static final class190 field3071 = new class190("13", "13");
   @ObfuscatedName("t")
   public static final class190 field3072 = new class190("15", "15");
   @ObfuscatedName("p")
   public static final class190 field3073 = new class190("5", "5");
   @ObfuscatedName("v")
   public static final class190 field3074 = new class190("4", "4");
   @ObfuscatedName("s")
   public static final class190 field3075 = new class190("10", "10");
   @ObfuscatedName("j")
   public static final class190 field3076 = new class190("6", "6");
   @ObfuscatedName("q")
   public static final class190 field3077 = new class190("8", "8");
   @ObfuscatedName("a")
   public static final class190 field3078 = new class190("1", "1");
   @ObfuscatedName("d")
   public final String field3079;
   @ObfuscatedName("du")
   static byte[][] field3080;
   @ObfuscatedName("l")
   public static final class190 field3081 = new class190("11", "11");

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-740268212"
   )
   static final void method3762() {
      if(client.field405 == 1) {
         class227.field3220[client.field438 / 100].method1699(client.field402 - 8, client.field403 - 8);
      }

      if(client.field405 == 2) {
         class227.field3220[4 + client.field438 / 100].method1699(client.field402 - 8, client.field403 - 8);
      }

      client.field414 = 0;
      int var0 = (class167.field2692.field849 >> 7) + class41.field990;
      int var1 = (class167.field2692.field819 >> 7) + class2.field37;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         client.field414 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         client.field414 = 1;
      }

      if(client.field414 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         client.field414 = 0;
      }

   }

   class190(String var1, String var2) {
      this.field3079 = var2;
   }
}
