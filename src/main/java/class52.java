import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class52 extends class204 {
   @ObfuscatedName("v")
   static int[] field1168;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 955683823
   )
   public static int field1169;
   @ObfuscatedName("d")
   static class193 field1170 = new class193(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1175048413
   )
   public int field1171 = 0;
   @ObfuscatedName("a")
   public static class167 field1173;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1013339079"
   )
   void method1181(class119 var1) {
      while(true) {
         int var2 = var1.method2613();
         if(var2 == 0) {
            return;
         }

         this.method1196(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass167;II)Lclass80;",
      garbageValue = "2003962231"
   )
   public static class80 method1191(class167 var0, int var1) {
      byte[] var3 = var0.method3414(var1);
      boolean var2;
      if(null == var3) {
         var2 = false;
      } else {
         class101.method2372(var3);
         var2 = true;
      }

      return !var2?null:class74.method1700();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "775566592"
   )
   void method1196(class119 var1, int var2) {
      if(5 == var2) {
         this.field1171 = var1.method2615();
      }

   }
}
