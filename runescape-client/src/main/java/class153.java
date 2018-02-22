import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class153 extends class283 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1383545203
   )
   static int field2091;
   @ObfuscatedName("k")
   static int[] field2093;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lkt;"
   )
   @Export("fontBold12")
   static Font fontBold12;
   @ObfuscatedName("b")
   final boolean field2094;

   public class153(boolean var1) {
      this.field2094 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-2127766052"
   )
   int method3135(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field2094?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field2094?1:-1;
      }

      return this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3135((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1165390461"
   )
   public static int method3140(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }
}
