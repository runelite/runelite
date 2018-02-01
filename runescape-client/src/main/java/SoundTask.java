import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("objects_ref")
   public static IndexDataBase objects_ref;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2073068985
   )
   public static int field1549;
   @ObfuscatedName("ag")
   protected static String field1547;
   @ObfuscatedName("p")
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
               var2.method2184();
            }
         }
      } catch (Exception var4) {
         class89.method1900((String)null, var4);
      }

   }
}
