import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public final class class80 extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   static Deque field1323;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 603531549
   )
   int field1320;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -826668209
   )
   int field1312;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 465855675
   )
   int field1313;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 30451021
   )
   int field1314;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -356907703
   )
   int field1315;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1574220845
   )
   int field1316;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1897888823
   )
   int field1311;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 412654087
   )
   int field1318;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   class115 field1317;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -670463325
   )
   int field1321;
   @ObfuscatedName("n")
   int[] field1319;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1513890913
   )
   int field1322;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   class115 field1324;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   ObjectComposition field1325;

   static {
      field1323 = new Deque();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "57"
   )
   void method1601() {
      int var1 = this.field1318;
      ObjectComposition var2 = this.field1325.getImpostor();
      if(var2 != null) {
         this.field1318 = var2.ambientSoundId;
         this.field1311 = var2.field3480 * 128;
         this.field1320 = var2.field3443;
         this.field1321 = var2.field3458;
         this.field1319 = var2.field3483;
      } else {
         this.field1318 = -1;
         this.field1311 = 0;
         this.field1320 = 0;
         this.field1321 = 0;
         this.field1319 = null;
      }

      if(var1 != this.field1318 && this.field1317 != null) {
         class11.field278.method1920(this.field1317);
         this.field1317 = null;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Liw;",
      garbageValue = "-9"
   )
   public static class244 method1605(int var0) {
      class244 var1 = (class244)class244.field3315.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3316.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4390(new Buffer(var2));
         }

         class244.field3315.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "1343097181"
   )
   public static void method1606(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-228201330"
   )
   static void method1602(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-849234993"
   )
   public static void method1594() {
      try {
         File var0 = new File(class33.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.field2240 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var4 = 0; var4 < class267.field3671.length; ++var4) {
               for(var2 = 0; var2 < class277.cacheLocations.length; ++var2) {
                  File var3 = new File(class277.cacheLocations[var2] + class267.field3671[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.field2240 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class155.field2240 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class155.field2240 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lem;III)Ldk;",
      garbageValue = "176285986"
   )
   public static final AbstractSoundSystem method1603(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = AbstractSoundSystem.field1618.vmethod1962();
            var3.samples = new int[256 * (AbstractSoundSystem.highMemory?2:1)];
            var3.field1628 = var2;
            var3.vmethod2104();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(FaceNormal.priority > 0 && Varcs.task == null) {
               Varcs.task = new SoundTask();
               class51.field682 = Executors.newScheduledThreadPool(1);
               class51.field682.scheduleAtFixedRate(Varcs.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(Varcs.task != null) {
               if(Varcs.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               Varcs.task.systems[var1] = var3;
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
