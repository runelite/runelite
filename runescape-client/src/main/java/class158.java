import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class158 {
   @ObfuscatedName("bd")
   static class168 field2578;

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method3134(boolean var0) {
      for(int var1 = 0; var1 < client.field314; ++var1) {
         class34 var2 = client.field517[client.field459[var1]];
         int var3 = 536870912 + (client.field459[var1] << 14);
         if(var2 != null && var2.vmethod742() && var0 == var2.field761.field864 && var2.field761.method760()) {
            int var4 = var2.field816 >> 7;
            int var5 = var2.field840 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field795 == 1 && (var2.field816 & 127) == 64 && 64 == (var2.field840 & 127)) {
                  if(client.field473 == client.field520[var4][var5]) {
                     continue;
                  }

                  client.field520[var4][var5] = client.field473;
               }

               if(!var2.field761.field880) {
                  var3 -= Integer.MIN_VALUE;
               }

               class35.field771.method2009(class28.field655, var2.field816, var2.field840, class148.method3106(var2.field816 + (var2.field795 * 64 - 64), var2.field795 * 64 - 64 + var2.field840, class28.field655), var2.field795 * 64 - 64 + 60, var2, var2.field796, var3, var2.field843);
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2114158116"
   )
   static final boolean method3135(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field418[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
