import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class50 extends class207 {
   @ObfuscatedName("w")
   static class196 field1105 = new class196(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -370183675
   )
   public int field1106;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1852347823
   )
   public int field1107;
   @ObfuscatedName("m")
   public static class170 field1108;
   @ObfuscatedName("x")
   public static short[] field1111;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1713246561
   )
   public int field1112;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 1850693327
   )
   static int field1113;
   @ObfuscatedName("br")
   static class171 field1115;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "106"
   )
   public static int method1046() {
      return class140.field2185;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-39"
   )
   void method1048(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1112 = var1.method2706();
         this.field1107 = var1.method2556();
         this.field1106 = var1.method2556();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-1948679675"
   )
   void method1049(class122 var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.method1048(var1, var2);
      }
   }
}
