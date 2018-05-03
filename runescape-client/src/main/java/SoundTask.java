import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("g")
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
               var2.method2328();
            }
         }
      } catch (Exception var4) {
         class253.processClientError((String)null, var4);
      }

   }
}
