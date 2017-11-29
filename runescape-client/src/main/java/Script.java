import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static NodeCache field1441;
   @ObfuscatedName("x")
   @Export("instructions")
   int[] instructions;
   @ObfuscatedName("k")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("z")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1795118161
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1953259733
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1511242489
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -880079915
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Lgi;"
   )
   @Export("switches")
   IterableHashTable[] switches;

   static {
      field1441 = new NodeCache(128);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[Lgi;",
      garbageValue = "-986713251"
   )
   IterableHashTable[] method1900(int var1) {
      return new IterableHashTable[var1];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-470540463"
   )
   public static void method1908(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1908(var0, var1, var2, var5 - 1);
         method1908(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-93"
   )
   static final void method1903(int var0) {
      short var1 = 256;
      class91.field1353 += var0 * 128;
      int var2;
      if(class91.field1353 > class234.field3220.length) {
         class91.field1353 -= class234.field3220.length;
         var2 = (int)(Math.random() * 12.0D);
         class87.method1753(class272.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class82.field1274[var3 + var2] - var0 * class234.field3220[var2 + class91.field1353 & class234.field3220.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class82.field1274[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class82.field1274[var7 + var6] = 255;
            } else {
               class82.field1274[var7 + var6] = 0;
            }
         }
      }

      if(class91.field1351 > 0) {
         class91.field1351 -= var0 * 4;
      }

      if(class91.field1352 > 0) {
         class91.field1352 -= var0 * 4;
      }

      if(class91.field1351 == 0 && class91.field1352 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class91.field1351 = 1024;
         }

         if(var5 == 1) {
            class91.field1352 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class91.field1349[var5] = class91.field1349[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class91.field1349[var5] = (int)(Math.sin((double)class91.field1370 / 14.0D) * 16.0D + Math.sin((double)class91.field1370 / 15.0D) * 14.0D + Math.sin((double)class91.field1370 / 16.0D) * 12.0D);
         ++class91.field1370;
      }

      class91.field1343 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class91.field1343 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class82.field1274[var7 + (var8 << 7)] = 192;
         }

         class91.field1343 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class82.field1274[var8 + var9 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class82.field1274[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class82.field1275[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class82.field1275[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class82.field1275[var9 + var6 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  class82.field1274[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lel;III)Ldo;",
      garbageValue = "-1424188624"
   )
   public static final AbstractSoundSystem method1906(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class3.soundTaskDataProvider.taskData();
            var3.samples = new int[(AbstractSoundSystem.highMemory?2:1) * 256];
            var3.field1544 = var2;
            var3.vmethod2118();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && class33.task == null) {
               class33.task = new SoundTask();
               Size.field347 = Executors.newScheduledThreadPool(1);
               Size.field347.scheduleAtFixedRate(class33.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class33.task != null) {
               if(class33.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class33.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-26588"
   )
   static void method1909() {
      if(Client.spellSelected) {
         Widget var0 = MilliTimer.getWidgetChild(class37.field489, Client.field917);
         if(var0 != null && var0.field2816 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2816;
            GrandExchangeEvent.method95(var1);
         }

         Client.spellSelected = false;
         class40.method556(var0);
      }
   }
}
