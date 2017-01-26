import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public final class class205 {
   @ObfuscatedName("p")
   static final char[] field3077 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-1493145105"
   )
   public static int method3806(CharSequence var0) {
      return class206.method3819(var0, 10, true);
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "-73"
   )
   static void method3818(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(null != var6 && var1 == var6.parentId) {
            ChatMessages.method861(var6, var2, var3, var4);
            class189.method3451(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               Renderable.method1892(var0, var6, var4);
            }
         }
      }

   }

   class205() throws Throwable {
      throw new Error();
   }
}
