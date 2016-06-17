import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public final class class162 {
   @ObfuscatedName("cw")
   static class224 field2636;
   @ObfuscatedName("pv")
   static class8 field2637;
   @ObfuscatedName("b")
   public static final char[] field2639 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "155292312"
   )
   static final void method3211(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)client.field421.method3844(); null != var10; var10 = (class16)client.field421.method3834()) {
         if(var0 == var10.field232 && var1 == var10.field225 && var2 == var10.field223 && var3 == var10.field224) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field232 = var0;
         var9.field224 = var3;
         var9.field225 = var1;
         var9.field223 = var2;
         class21.method558(var9);
         client.field421.method3819(var9);
      }

      var9.field230 = var4;
      var9.field235 = var5;
      var9.field231 = var6;
      var9.field241 = var7;
      var9.field233 = var8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lclass131;",
      garbageValue = "-1099774951"
   )
   public static class131 method3213() {
      try {
         return new class145();
      } catch (Throwable var1) {
         return null;
      }
   }
}
