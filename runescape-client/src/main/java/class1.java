import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class1 {
   @ObfuscatedName("h")
   static final class1 field0;
   @ObfuscatedName("u")
   static final class1 field2;
   @ObfuscatedName("q")
   static final class1 field3;
   @ObfuscatedName("g")
   static final class1 field4;
   @ObfuscatedName("v")
   static final class1 field5;
   @ObfuscatedName("t")
   static final class1 field6;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -809369807
   )
   final int field7;
   @ObfuscatedName("i")
   static final class1 field8;
   @ObfuscatedName("cr")
   @Export("indexInterfaces")
   static IndexData indexInterfaces;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class1(int var1) {
      this.field7 = var1;
   }

   static {
      field8 = new class1(0);
      field0 = new class1(5);
      field2 = new class1(3);
      field3 = new class1(2);
      field4 = new class1(6);
      field5 = new class1(1);
      field6 = new class1(4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "1"
   )
   public static int method0(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1625342230"
   )
   static void method1(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class234 var4 = (class234)class238.field3259.method3615(var2);
      if(var4 != null) {
         class238.field3247.method3540(var4);
      }
   }
}
