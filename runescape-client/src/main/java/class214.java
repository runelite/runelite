import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class214 {
   @ObfuscatedName("m")
   static final class214 field3145 = new class214("11", "11");
   @ObfuscatedName("u")
   static final class214 field3146 = new class214("2", "2");
   @ObfuscatedName("x")
   static final class214 field3147 = new class214("5", "5");
   @ObfuscatedName("q")
   static final class214 field3148 = new class214("10", "10");
   @ObfuscatedName("d")
   static final class214 field3149 = new class214("4", "4");
   @ObfuscatedName("k")
   static final class214 field3150 = new class214("14", "14");
   @ObfuscatedName("j")
   static final class214 field3151 = new class214("8", "8");
   @ObfuscatedName("g")
   static final class214 field3152 = new class214("13", "13");
   @ObfuscatedName("s")
   static final class214 field3153 = new class214("1", "1");
   @ObfuscatedName("p")
   static final class214 field3154 = new class214("12", "12");
   @ObfuscatedName("o")
   static final class214 field3155 = new class214("3", "3");
   @ObfuscatedName("c")
   static final class214 field3156 = new class214("15", "15");
   @ObfuscatedName("h")
   public static final class214 field3157 = new class214("7", "7");
   @ObfuscatedName("r")
   public static final class214 field3158 = new class214("9", "9");
   @ObfuscatedName("a")
   static final class214 field3159 = new class214("6", "6");
   @ObfuscatedName("i")
   public final String field3160;

   class214(String var1, String var2) {
      this.field3160 = var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "1148623757"
   )
   public static int method3963(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
