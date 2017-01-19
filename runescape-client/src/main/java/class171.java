import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class171 {
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "96"
   )
   static final void method3148(int var0, int var1) {
      int var2 = class16.field187.method3722("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = class16.field187.method3722(class3.method38(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = 22 + Client.menuOptionCount * 15;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class16.field186) {
         var4 = class16.field186 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > ChatMessages.field907) {
         var5 = ChatMessages.field907 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      Client.menuX = var4;
      class6.menuY = var5;
      class5.menuWidth = var2;
      ChatMessages.menuHeight = Client.menuOptionCount * 15 + 22;
   }
}
