import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class40 implements class158 {
   @ObfuscatedName("c")
   static final class40 field803 = new class40(1);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 794440665
   )
   final int field804;
   @ObfuscatedName("s")
   static final class40 field805 = new class40(0);
   @ObfuscatedName("h")
   static final class40 field806 = new class40(3);
   @ObfuscatedName("bb")
   static class184 field807;
   @ObfuscatedName("f")
   static final class40 field809 = new class40(2);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17064"
   )
   public int vmethod3916() {
      return this.field804;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field804 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-112765615"
   )
   public static String method727(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
