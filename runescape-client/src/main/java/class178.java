import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class178 {
   @ObfuscatedName("j")
   public final String field2676;
   @ObfuscatedName("d")
   public static final class178 field2677 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("h")
   public static final class178 field2678 = new class178("RC", 1);
   @ObfuscatedName("p")
   public static final class178 field2679 = new class178("WIP", 2);
   @ObfuscatedName("q")
   public static final class178 field2680 = new class178("LIVE", 0);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -225919257
   )
   public final int field2681;
   @ObfuscatedName("u")
   public static class60 field2682;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "1214247524"
   )
   public static String method3288(int var0, boolean var1) {
      return var1 && var0 >= 0?RSCanvas.method2143(var0, 10, var1):Integer.toString(var0);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2676 = var1;
      this.field2681 = var2;
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1894842355"
   )
   static final boolean method3289(Widget var0) {
      if(var0.field2318 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2318.length; ++var1) {
            int var2 = class159.method3096(var0, var1);
            int var3 = var0.field2319[var1];
            if(var0.field2318[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2318[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2318[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
