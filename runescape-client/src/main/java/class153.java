import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class153 {
   @ObfuscatedName("b")
   static final class153 field2265 = new class153("WIP", 2);
   @ObfuscatedName("u")
   static final class153 field2266 = new class153("BUILDLIVE", 3);
   @ObfuscatedName("x")
   static final class153 field2267 = new class153("RC", 1);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -406772093
   )
   final int field2270;
   @ObfuscatedName("f")
   static final class153 field2272 = new class153("LIVE", 0);
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 2051271317
   )
   public static int field2274;
   @ObfuscatedName("l")
   public final String field2275;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class153(String var1, int var2) {
      this.field2275 = var1;
      this.field2270 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass173;",
      garbageValue = "-121520415"
   )
   public static class173 method3177(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class173.field2770[var1] == null || class173.field2770[var1][var2] == null) {
         boolean var3 = class135.method2897(var1);
         if(!var3) {
            return null;
         }
      }

      return class173.field2770[var1][var2];
   }
}
