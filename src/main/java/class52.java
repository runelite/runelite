import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class52 extends class203 {
   @ObfuscatedName("a")
   public static class166 field1156;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 305692239
   )
   public static int field1157;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1632219837
   )
   public int field1159 = 0;
   @ObfuscatedName("j")
   static class80[] field1160;
   @ObfuscatedName("f")
   static class192 field1164 = new class192(64);

   @ObfuscatedName("a")
   static int method1093(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ class118.field1981[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("r")
   void method1100(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(var2 == 0) {
            return;
         }

         this.method1104(var1, var2);
      }
   }

   @ObfuscatedName("f")
   void method1104(class118 var1, int var2) {
      if(5 == var2) {
         this.field1159 = var1.method2514();
      }

   }
}
