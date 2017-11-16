import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1943177797
   )
   static int field1573;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("listFetcher")
   static class149 listFetcher;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   static Buffer field1574;
   @ObfuscatedName("br")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ldo;"
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
               var2.method2069();
            }
         }
      } catch (Exception var4) {
         class48.method690((String)null, var4);
      }

   }
}
