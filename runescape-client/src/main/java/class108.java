import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class108 {
   @ObfuscatedName("f")
   static Widget field1738;

   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "801064237"
   )
   static void method2130(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < SecondaryBufferProvider.field3217; ++var4) {
         ItemComposition var5 = ChatLineBuffer.getItemDefinition(var4);
         if((!var1 || var5.field2998) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class119.field1855 = -1;
               class41.field838 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[2 * var2.length];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class41.field838 = var2;
      class185.field2767 = 0;
      class119.field1855 = var3;
      String[] var9 = new String[class119.field1855];

      for(int var8 = 0; var8 < class119.field1855; ++var8) {
         var9[var8] = ChatLineBuffer.getItemDefinition(var2[var8]).name;
      }

      TextureProvider.method1518(var9, class41.field838);
   }

   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-53482878"
   )
   static void method2131() {
      Client.menuOptionCount = 0;
      Client.field436 = -1;
      Client.isMenuOpen = false;
   }
}
