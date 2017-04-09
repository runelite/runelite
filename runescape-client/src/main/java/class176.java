import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public final class class176 {
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "781259460"
   )
   static final void method3314(int var0) {
      if(Ignore.method178(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2344 = 0;
               var3.field2342 = 0;
            }
         }
      }

   }

   class176() throws Throwable {
      throw new Error();
   }
}
