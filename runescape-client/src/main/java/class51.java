import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class51 implements class104 {
   @ObfuscatedName("s")
   static int[] field661;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 370301669
   )
   static int field664;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Ldc;",
      garbageValue = "1153007829"
   )
   public AbstractSoundSystem vmethod1939() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([Lhi;Lhi;ZI)V",
      garbageValue = "-856989343"
   )
   static void method812(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class23.method183(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class23.method183(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(Ignore.loadWidget(var6)) {
            class23.method183(class176.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lep;III)Ldc;",
      garbageValue = "758013495"
   )
   public static final AbstractSoundSystem method808(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = class294.field3887.vmethod1939();
            var3.samples = new int[256 * (class135.highMemory?2:1)];
            var3.field1633 = var2;
            var3.vmethod2048();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(AbstractSoundSystem.priority > 0 && class66.task == null) {
               class66.task = new SoundTask();
               WidgetNode.field842 = Executors.newScheduledThreadPool(1);
               WidgetNode.field842.scheduleAtFixedRate(class66.task, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(class66.task != null) {
               if(class66.task.systems[var1] != null) {
                  throw new IllegalArgumentException();
               }

               class66.task.systems[var1] = var3;
            }

            return var3;
         } catch (Throwable var4) {
            return new AbstractSoundSystem();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "63"
   )
   public static boolean method813(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
