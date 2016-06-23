import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class52 extends class204 {
   @ObfuscatedName("x")
   public static class193 field1168 = new class193(64);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1797843391
   )
   public int field1169 = 0;
   @ObfuscatedName("bf")
   static class80 field1171;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 1829029353
   )
   static int field1174;
   @ObfuscatedName("l")
   public static int[] field1178;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "1097062820"
   )
   void method1136(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method1137(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1796086066"
   )
   void method1137(class119 var1, int var2) {
      if(var2 == 5) {
         this.field1169 = var1.method2556();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass224;",
      garbageValue = "-33"
   )
   public static class224 method1138(class167 var0, class167 var1, String var2, String var3) {
      int var4 = var0.method3300(var2);
      int var5 = var0.method3301(var4, var3);
      return class124.method2814(var0, var1, var4, var5);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "641550415"
   )
   @Export("sendGameMessage")
   static void method1147(int var0, String var1, String var2) {
      class122.method2795(var0, var1, var2, (String)null);
   }
}
