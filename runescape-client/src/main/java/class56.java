import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
public class class56 extends class207 {
   @ObfuscatedName("ae")
   static class171 field1231;
   @ObfuscatedName("e")
   public static class196 field1233 = new class196(64);
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 720970751
   )
   public int field1234 = 0;
   @ObfuscatedName("m")
   static class170 field1235;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1926864461
   )
   public static int field1239;
   @ObfuscatedName("k")
   static class157 field1240;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-5"
   )
   void method1193(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1194(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "2069578247"
   )
   void method1194(class122 var1, int var2) {
      if(var2 == 5) {
         this.field1234 = var1.method2706();
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lclass32;III)V",
      garbageValue = "-656628900"
   )
   static final void method1198(class32 var0, int var1, int var2) {
      class35.method729(var0.field725, var0.field720, var0.field722, var0.field724, var0.field723, var0.field723, var1, var2);
   }
}
