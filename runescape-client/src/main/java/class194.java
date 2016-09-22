import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class194 {
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "0"
   )
   static final void method3776(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field425.method3854(); var10 != null; var10 = (class16)Client.field425.method3869()) {
         if(var10.field232 == var0 && var10.field218 == var1 && var10.field219 == var2 && var3 == var10.field217) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class16();
         var9.field232 = var0;
         var9.field217 = var3;
         var9.field218 = var1;
         var9.field219 = var2;
         class5.method87(var9);
         Client.field425.method3849(var9);
      }

      var9.field223 = var4;
      var9.field225 = var5;
      var9.field231 = var6;
      var9.field227 = var7;
      var9.field224 = var8;
   }
}
