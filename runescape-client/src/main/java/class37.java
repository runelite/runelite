import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class37 {
   @ObfuscatedName("bc")
   static IndexData field805;
   @ObfuscatedName("cf")
   public static char field810;
   @ObfuscatedName("op")
   @ObfuscatedGetter(
      intValue = 1941165649
   )
   static int field813;

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static void method762() {
      Client.menuOptionCount = 0;
      Client.field449 = -1;
      Client.isMenuOpen = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1469028888"
   )
   public static byte[] method763(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class41.method814(var3):var3;
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3076();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
