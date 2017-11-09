import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Ldi;"
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
               var2.method2106();
            }
         }
      } catch (Exception var4) {
         class33.method396((String)null, var4);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2017970206"
   )
   public static boolean method2168(int var0) {
      return var0 >= class228.field2888.field2887 && var0 <= class228.field2883.field2887 || var0 == class228.field2884.field2887;
   }
}
