import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class193 {
   @ObfuscatedName("f")
   public static final class193 field3101 = new class193("13", "13");
   @ObfuscatedName("j")
   public static final class193 field3102 = new class193("11", "11");
   @ObfuscatedName("q")
   public static final class193 field3103 = new class193("6", "6");
   @ObfuscatedName("c")
   public static final class193 field3104 = new class193("14", "14");
   @ObfuscatedName("v")
   public static final class193 field3105 = new class193("1", "1");
   @ObfuscatedName("e")
   public static final class193 field3106 = new class193("8", "8");
   @ObfuscatedName("m")
   public static final class193 field3107 = new class193("3", "3");
   @ObfuscatedName("y")
   public static final class193 field3108 = new class193("4", "4");
   @ObfuscatedName("u")
   public static final class193 field3109 = new class193("7", "7");
   @ObfuscatedName("k")
   public static final class193 field3110 = new class193("2", "2");
   @ObfuscatedName("l")
   public static final class193 field3111 = new class193("15", "15");
   @ObfuscatedName("b")
   public static final class193 field3112 = new class193("9", "9");
   @ObfuscatedName("s")
   public final String field3113;
   @ObfuscatedName("g")
   public static final class193 field3114 = new class193("12", "12");
   @ObfuscatedName("p")
   public static final class193 field3115 = new class193("5", "5");
   @ObfuscatedName("h")
   public static final class193 field3116 = new class193("10", "10");

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2047"
   )
   static void method3776() {
      Object var0 = class173.field2757;
      synchronized(class173.field2757) {
         if(class173.field2756 == 0) {
            Item.field699.method2918(new class173(), 5);
         }

         class173.field2756 = 600;
      }
   }

   class193(String var1, String var2) {
      this.field3113 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1012984258"
   )
   public static int method3777(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
