import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class47 extends class204 {
   @ObfuscatedName("h")
   public static class193 field1047 = new class193(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 244618369
   )
   public int field1049;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1342727959
   )
   public int field1050;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2142270605
   )
   public int field1051;
   @ObfuscatedName("hy")
   @Export("localPlayer")
   static class2 field1053;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1658047613
   )
   static int field1055;
   @ObfuscatedName("j")
   public static class167 field1056;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1526679319"
   )
   static boolean method973(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "53"
   )
   void method977(class119 var1, int var2) {
      if(1 == var2) {
         this.field1051 = var1.method2502();
         this.field1049 = var1.method2500();
         this.field1050 = var1.method2500();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lclass25;",
      garbageValue = "-19"
   )
   static class25 method980() {
      return class25.field615 < class25.field614?class25.field616[++class25.field615 - 1]:null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-84"
   )
   public void method981(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(var2 == 0) {
            return;
         }

         this.method977(var1, var2);
      }
   }
}
