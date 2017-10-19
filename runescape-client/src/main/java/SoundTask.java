import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -306760097
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ldk;"
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
               var2.method2059();
            }
         }
      } catch (Exception var4) {
         class46.method680((String)null, var4);
      }

   }
}
