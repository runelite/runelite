import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class182 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -933670171
   )
   static int field2420;
   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "[Lkn;"
   )
   static SpritePixels[] field2421;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Leb;IIB)Ldw;",
      garbageValue = "-13"
   )
   public static final AbstractSoundSystem method3438(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = FrameMap.field2044.vmethod1949();
            var3.samples = new int[256 * (class25.highMemory?2:1)];
            var3.field1633 = var2;
            var3.vmethod2046();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class9.priority > 0 && class164.task == null) {
               class164.task = new SoundTask();
               IndexFile.field2258 = Executors.newScheduledThreadPool(1);
               IndexFile.field2258.scheduleAtFixedRate(class164.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class164.task != null) {
               if(class164.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class164.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
