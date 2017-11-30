import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("SoundTaskDataProvider")
public class SoundTaskDataProvider implements TaskDataProvider {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ldn;",
      garbageValue = "524047309"
   )
   public AbstractSoundSystem taskData() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "16711680"
   )
   public static boolean method753(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
