import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class138 {
   @ObfuscatedName("v")
   static Hashtable field2155 = new Hashtable(16);
   @ObfuscatedName("a")
   static boolean field2158 = false;
   @ObfuscatedName("as")
   static int[] field2159;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(III)Lclass110;",
      garbageValue = "1246372812"
   )
   static class110 method2909(int var0, int var1) {
      Client.field490.field1962 = var0;
      Client.field490.field1960 = var1;
      Client.field490.field1958 = 1;
      Client.field490.field1961 = 1;
      return Client.field490;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "431156531"
   )
   static void method2913() {
      class5.field83 = 99;
      class5.field79 = new byte[4][104][104];
      class26.field653 = new byte[4][104][104];
      class93.field1649 = new byte[4][104][104];
      class5.field80 = new byte[4][104][104];
      class22.field590 = new int[4][105][105];
      class137.field2149 = new byte[4][105][105];
      class5.field81 = new int[105][105];
      class212.field3172 = new int[104];
      class4.field72 = new int[104];
      class212.field3176 = new int[104];
      RSCanvas.field2211 = new int[104];
      class224.field3228 = new int[104];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1290652587"
   )
   public static int method2914(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
