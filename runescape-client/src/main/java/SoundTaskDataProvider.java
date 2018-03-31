import java.io.File;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements class101 {
   @ObfuscatedName("i")
   static File field624;
   @ObfuscatedName("kr")
   @ObfuscatedGetter(
      intValue = 1289056831
   )
   static int field623;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ldz;",
      garbageValue = "-2054148329"
   )
   public AbstractSoundSystem vmethod2095() {
      return new SourceDataSoundSystem();
   }
}
