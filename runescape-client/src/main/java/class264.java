import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
public enum class264 implements class185 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   field3612(1, 0),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   field3606(0, 1),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   field3607(2, 2);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 752978877
   )
   public final int field3609;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 213345935
   )
   final int field3610;

   class264(int var3, int var4) {
      this.field3609 = var3;
      this.field3610 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1940611593"
   )
   public int rsOrdinal() {
      return this.field3610;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1925418882"
   )
   static void method4818(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      Widget.method4169();
      class72.method1144();
   }
}
