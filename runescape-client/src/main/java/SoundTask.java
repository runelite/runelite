import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lcc;"
   )
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method2192();
            }
         }
      } catch (Exception var4) {
         class43.processClientError((String)null, var4);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "116813309"
   )
   public static boolean method2272(int var0) {
      return (var0 >> 30 & 1) != 0;
   }
}
