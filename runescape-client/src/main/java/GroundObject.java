import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1506916085
   )
   static int field1777;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1965082411
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1859990251
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -295969207
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -91861459
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -693958347
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Ldx;",
      garbageValue = "7"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class156.field2147, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(field1777 == 33) {
         var4 = "_rc";
      } else if(field1777 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class168.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Leq;III)Ldo;",
      garbageValue = "1997357690"
   )
   public static final AbstractSoundSystem method2494(Signlink var0, int var1, int var2) {
      if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.field1540.vmethod1919();
            var3.samples = new int[256 * (AbstractSoundSystem.highMemory?2:1)];
            var3.field1546 = var2;
            var3.vmethod2029();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               FaceNormal.field2035 = Executors.newScheduledThreadPool(1);
               FaceNormal.field2035.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(AbstractSoundSystem.task != null) {
               if(AbstractSoundSystem.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               AbstractSoundSystem.task.systems[var1] = var3;
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
