import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("ra")
   @ObfuscatedGetter(
      intValue = 678574761
   )
   static int field1569;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Ldr;"
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
               var2.method2210();
            }
         }
      } catch (Exception var4) {
         GroundObject.processClientError((String)null, var4);
      }

   }
}
