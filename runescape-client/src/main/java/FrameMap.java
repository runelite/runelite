import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -228200901
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -398157133
   )
   @Export("count")
   int count;
   @ObfuscatedName("i")
   @Export("types")
   int[] types;
   @ObfuscatedName("j")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-193308165"
   )
   public static boolean method2777(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-1094614565"
   )
   static int method2778(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class285.field3789:Friend.field768;
      if(var0 == 1800) {
         class82.intStack[++class56.intStackSize - 1] = GraphicsObject.method1747(Preferences.getWidgetConfig(var3));
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
            } else {
               class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = class82.intStack[--class56.intStackSize];
         --var4;
         if(var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            class82.scriptStringStack[++class24.scriptStringStackSize - 1] = var3.actions[var4];
         } else {
            class82.scriptStringStack[++class24.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ler;IIB)Ldi;",
      garbageValue = "-23"
   )
   public static final AbstractSoundSystem method2779(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.field1567.vmethod2015();
            var3.samples = new int[(AbstractSoundSystem.highMemory?2:1) * 256];
            var3.field1544 = var2;
            var3.vmethod2113();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               AbstractSoundSystem.field1546 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1546.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
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
