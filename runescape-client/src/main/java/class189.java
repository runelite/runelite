import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class189 {
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   static {
      new HashMap();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-6542"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class154.validInterfaces[var0]) {
         return true;
      } else if(!UrlRequest.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = UrlRequest.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class154.validInterfaces[var0] = true;
            return true;
         } else {
            if(MouseRecorder.widgets[var0] == null) {
               MouseRecorder.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(MouseRecorder.widgets[var0][var2] == null) {
                  byte[] var3 = UrlRequest.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     MouseRecorder.widgets[var0][var2] = new Widget();
                     MouseRecorder.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        MouseRecorder.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        MouseRecorder.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class154.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
