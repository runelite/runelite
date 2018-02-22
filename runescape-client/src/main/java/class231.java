import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class231 {
   @ObfuscatedName("b")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("q")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("o")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("c")
   static int[] field2738;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "26"
   )
   static void method4370() {
      Object var0 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
         if(IndexStoreActionHandler.field3338 == 0) {
            SoundTask.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
            SoundTask.IndexStoreActionHandler_thread.setDaemon(true);
            SoundTask.IndexStoreActionHandler_thread.start();
            SoundTask.IndexStoreActionHandler_thread.setPriority(5);
         }

         IndexStoreActionHandler.field3338 = 600;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-896331779"
   )
   static final boolean method4364(int var0, int var1) {
      ObjectComposition var2 = Preferences.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4954(var1);
   }
}
