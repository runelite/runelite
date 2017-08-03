import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1708369175
   )
   static int field1647;
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fo")
   static byte[][] field1651;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldu;"
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
               var2.method2077();
            }
         }
      } catch (Exception var4) {
         class23.method165((String)null, var4);
      }

   }
}
