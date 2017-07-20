import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class157 {
   @ObfuscatedName("c")
   static boolean field2220;
   @ObfuscatedName("i")
   static Hashtable field2217;
   @ObfuscatedName("ed")
   @ObfuscatedGetter(
      longValue = -531109440243321561L
   )
   static long field2215;
   @ObfuscatedName("o")
   static File field2216;

   static {
      field2220 = false;
      field2217 = new Hashtable(16);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "4"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2371) {
         class20.field321 += class175.field2371 - var0;
      }

      class175.field2371 = var0;
      return class20.field321 + var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IS)Lio;",
      garbageValue = "4110"
   )
   public static Overlay method2908(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1251924090"
   )
   static void method2907(int var0) {
      if(var0 != -1) {
         if(class9.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2698 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field831 = var3.field2698;
                  class17.method123(var4, 2000000);
               }
            }

         }
      }
   }
}
