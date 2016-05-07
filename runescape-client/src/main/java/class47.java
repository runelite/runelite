import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class47 extends class204 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1006337433
   )
   public int field1064;
   @ObfuscatedName("j")
   public static class193 field1065 = new class193(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -227780311
   )
   public int field1066;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1644897565
   )
   public int field1068;
   @ObfuscatedName("s")
   public static class167 field1070;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1761063827
   )
   public static int field1071;
   @ObfuscatedName("nm")
   @ObfuscatedGetter(
      intValue = 1792315973
   )
   static int field1072;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "-37"
   )
   public void method955(class119 var1) {
      while(true) {
         int var2 = var1.method2492();
         if(0 == var2) {
            return;
         }

         this.method961(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "-1857670812"
   )
   void method961(class119 var1, int var2) {
      if(1 == var2) {
         this.field1066 = var1.method2584();
         this.field1064 = var1.method2492();
         this.field1068 = var1.method2492();
      }

   }
}
