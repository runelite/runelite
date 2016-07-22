import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class193 {
   @ObfuscatedName("h")
   static final class193 field3100 = new class193("11", "11");
   @ObfuscatedName("w")
   static final class193 field3101 = new class193("3", "3");
   @ObfuscatedName("e")
   static final class193 field3102 = new class193("7", "7");
   @ObfuscatedName("o")
   static final class193 field3103 = new class193("6", "6");
   @ObfuscatedName("g")
   static final class193 field3104 = new class193("2", "2");
   @ObfuscatedName("l")
   static final class193 field3105 = new class193("9", "9");
   @ObfuscatedName("p")
   static final class193 field3106 = new class193("15", "15");
   @ObfuscatedName("r")
   static final class193 field3107 = new class193("4", "4");
   @ObfuscatedName("x")
   static final class193 field3108 = new class193("5", "5");
   @ObfuscatedName("k")
   static final class193 field3109 = new class193("13", "13");
   @ObfuscatedName("v")
   static final class193 field3110 = new class193("1", "1");
   @ObfuscatedName("s")
   public final String field3111;
   @ObfuscatedName("u")
   public static final class193 field3112 = new class193("12", "12");
   @ObfuscatedName("y")
   public static final class193 field3113 = new class193("14", "14");
   @ObfuscatedName("j")
   static final class193 field3114 = new class193("8", "8");
   @ObfuscatedName("m")
   static final class193 field3115 = new class193("10", "10");

   class193(String var1, String var2) {
      this.field3111 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1550542448"
   )
   public static synchronized long method3805() {
      long var0 = System.currentTimeMillis();
      if(var0 < class93.field1635) {
         class118.field2028 += class93.field1635 - var0;
      }

      class93.field1635 = var0;
      return var0 + class118.field2028;
   }
}
