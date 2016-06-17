import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class38 extends class207 {
   @ObfuscatedName("ga")
   static class173 field849;
   @ObfuscatedName("j")
   short field851;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1759632413
   )
   int field853 = (int)(class90.method2090() / 1000L);
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 899876261
   )
   static int field854;
   @ObfuscatedName("u")
   static class80 field855;
   @ObfuscatedName("g")
   String field856;

   class38(String var1, int var2) {
      this.field856 = var1;
      this.field851 = (short)var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZZS)I",
      garbageValue = "1"
   )
   public static int method765(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class171.field2711 + class171.field2713;
      return var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass167;IIB)Z",
      garbageValue = "2"
   )
   public static boolean method766(class167 var0, int var1, int var2) {
      byte[] var3 = var0.method3266(var1, var2);
      if(null == var3) {
         return false;
      } else {
         class135.method2911(var3);
         return true;
      }
   }
}
