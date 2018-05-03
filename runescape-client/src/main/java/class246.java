import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class246 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;B)I",
      garbageValue = "111"
   )
   public static int method4605(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfl;III)Ldk;",
      garbageValue = "-1852813142"
   )
   public static final AbstractSoundSystem method4606(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = MouseRecorder.soundTaskDataProvider.vmethod2215();
            var3.samples = new int[256 * (AbstractSoundSystem.audioHighMemory?2:1)];
            var3.field1545 = var2;
            var3.vmethod2334();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class278.field3550 > 0 && GrandExchangeOffer.task == null) {
               GrandExchangeOffer.task = new SoundTask();
               AbstractSoundSystem.field1555 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1555.scheduleAtFixedRate(GrandExchangeOffer.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(GrandExchangeOffer.task != null) {
               if(GrandExchangeOffer.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               GrandExchangeOffer.task.systems[var1] = var3;
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
