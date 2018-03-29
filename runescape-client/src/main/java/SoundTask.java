import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("mo")
   @ObfuscatedGetter(
      intValue = 640825907
   )
   static int field1582;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Ldz;"
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
               var2.method2222();
            }
         }
      } catch (Exception var4) {
         UrlRequest.processClientError((String)null, var4);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;B)V",
      garbageValue = "-4"
   )
   public static void method2259(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-593472705"
   )
   static final int method2260(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
