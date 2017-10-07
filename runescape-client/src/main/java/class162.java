import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class162 {
   @ObfuscatedName("e")
   static int[][] field2309;
   @ObfuscatedName("p")
   static int[][] field2307;
   @ObfuscatedName("g")
   static int[] field2313;
   @ObfuscatedName("v")
   static int[] field2314;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1019782927
   )
   static int field2311;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -170440649
   )
   static int field2312;

   static {
      field2309 = new int[128][128];
      field2307 = new int[128][128];
      field2313 = new int[4096];
      field2314 = new int[4096];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-546505824"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lez;III)Ldk;",
      garbageValue = "-542905642"
   )
   public static final AbstractSoundSystem method3142(Signlink var0, int var1, int var2) {
      if(class31.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.field1614.vmethod1993();
            var3.samples = new int[(class33.highMemory?2:1) * 256];
            var3.field1620 = var2;
            var3.vmethod2133();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class17.priority > 0 && class88.task == null) {
               class88.task = new SoundTask();
               AbstractSoundSystem.field1633 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1633.scheduleAtFixedRate(class88.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class88.task != null) {
               if(class88.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class88.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1834290959"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class207.method3989(var0, class5.field42);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class207.method3989(var3.name, class5.field42))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class207.method3989(var3.previousName, class5.field42))) {
               return true;
            }
         }

         return false;
      }
   }
}
