import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class224 {
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static final void method4097() {
      for(class76 var0 = (class76)Client.field1046.method3622(); var0 != null; var0 = (class76)Client.field1046.method3608()) {
         if(var0.field1213 > 0) {
            --var0.field1213;
         }

         if(var0.field1213 == 0) {
            if(var0.field1202 < 0 || class24.method203(var0.field1202, var0.field1214)) {
               class35.method492(var0.field1203, var0.field1199, var0.field1200, var0.field1201, var0.field1202, var0.field1211, var0.field1214);
               var0.unlink();
            }
         } else {
            if(var0.field1212 > 0) {
               --var0.field1212;
            }

            if(var0.field1212 == 0 && var0.field1200 >= 1 && var0.field1201 >= 1 && var0.field1200 <= 102 && var0.field1201 <= 102 && (var0.field1205 < 0 || class24.method203(var0.field1205, var0.field1207))) {
               class35.method492(var0.field1203, var0.field1199, var0.field1200, var0.field1201, var0.field1205, var0.field1208, var0.field1207);
               var0.field1212 = -1;
               if(var0.field1202 == var0.field1205 && var0.field1202 == -1) {
                  var0.unlink();
               } else if(var0.field1205 == var0.field1202 && var0.field1211 == var0.field1208 && var0.field1207 == var0.field1214) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
