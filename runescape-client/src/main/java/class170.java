import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class170 {
   @ObfuscatedName("d")
   public static boolean field2214;
   @ObfuscatedName("z")
   public static File field2212;
   @ObfuscatedName("n")
   static Hashtable field2211;
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;

   static {
      field2214 = false;
      field2211 = new Hashtable(16);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lji;",
      garbageValue = "-1896360317"
   )
   public static class279 method3339(int var0) {
      class279 var1 = (class279)class279.field3548.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class279.field3550.getConfigData(34, var0);
         var1 = new class279();
         if(var2 != null) {
            var1.method5047(new Buffer(var2));
         }

         var1.method5046();
         class279.field3548.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Liw;I)Ljava/lang/String;",
      garbageValue = "-1543809572"
   )
   static String method3340(Widget var0) {
      int var2 = class85.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
