import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class214 {
   @ObfuscatedName("m")
   public static final class214 field3158 = new class214("15", "15");
   @ObfuscatedName("d")
   public static final class214 field3159 = new class214("2", "2");
   @ObfuscatedName("o")
   public static final class214 field3160 = new class214("8", "8");
   @ObfuscatedName("p")
   public static final class214 field3161 = new class214("4", "4");
   @ObfuscatedName("j")
   public static final class214 field3162 = new class214("11", "11");
   @ObfuscatedName("n")
   public static final class214 field3163 = new class214("3", "3");
   @ObfuscatedName("r")
   public static final class214 field3164 = new class214("10", "10");
   @ObfuscatedName("c")
   public static final class214 field3165 = new class214("7", "7");
   @ObfuscatedName("i")
   public static final class214 field3166 = new class214("6", "6");
   @ObfuscatedName("q")
   public static final class214 field3167 = new class214("13", "13");
   @ObfuscatedName("h")
   public static final class214 field3168 = new class214("12", "12");
   @ObfuscatedName("s")
   public static final class214 field3169 = new class214("14", "14");
   @ObfuscatedName("u")
   public static final class214 field3170 = new class214("1", "1");
   @ObfuscatedName("b")
   public static final class214 field3171 = new class214("5", "5");
   @ObfuscatedName("v")
   public static final class214 field3172 = new class214("9", "9");
   @ObfuscatedName("f")
   public final String field3173;

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "-125"
   )
   static Widget method3986(Widget var0) {
      Widget var1 = FrameMap.method1746(var0);
      if(var1 == null) {
         var1 = var0.parent;
      }

      return var1;
   }

   class214(String var1, String var2) {
      this.field3173 = var2;
   }
}
