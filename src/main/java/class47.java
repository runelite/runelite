import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class47 extends class203 {
   @ObfuscatedName("l")
   static class192 field1066 = new class192(64);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 554714029
   )
   public int field1067;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2117552577
   )
   public int field1068;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1910301391
   )
   public int field1069;
   @ObfuscatedName("ni")
   static class56 field1070;
   @ObfuscatedName("j")
   public static class166 field1073;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 387028045
   )
   static int field1074;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass118;B)V",
      garbageValue = "-118"
   )
   void method968(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method969(var1, var2);
      }
   }

   @ObfuscatedName("a")
   void method969(class118 var1, int var2) {
      if(var2 == 1) {
         this.field1067 = var1.method2455();
         this.field1068 = var1.method2453();
         this.field1069 = var1.method2453();
      }

   }

   @ObfuscatedName("o")
   public static boolean method980(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("j")
   static void method981() {
      class5.field90 = (byte[][][])null;
      class114.field1972 = (byte[][][])null;
      class5.field84 = (byte[][][])null;
      class5.field85 = (byte[][][])null;
      class75.field1383 = (int[][][])null;
      class5.field97 = (byte[][][])null;
      class50.field1103 = (int[][])null;
      class18.field264 = null;
      class114.field1974 = null;
      class5.field86 = null;
      class5.field87 = null;
      class171.field2744 = null;
   }
}
