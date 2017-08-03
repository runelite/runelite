import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class67 extends class196 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1349512873
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("ct")
   static boolean field792;
   @ObfuscatedName("lt")
   @ObfuscatedSignature(
      signature = "[Lhn;"
   )
   static Widget[] field797;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1068403625
   )
   static int field794;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("nv")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 551392761
   )
   int field798;
   @ObfuscatedName("q")
   String field800;
   @ObfuscatedName("x")
   short field793;

   class67(String var1, int var2) {
      this.field798 = (int)(BuildType.currentTimeMs() / 1000L);
      this.field800 = var1;
      this.field793 = (short)var2;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Leg;III)Ldu;",
      garbageValue = "1981392773"
   )
   public static final AbstractSoundSystem method1110(Signlink var0, int var1, int var2) {
      if(AbstractSoundSystem.sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         try {
            AbstractSoundSystem var3 = GraphicsObject.field1325.vmethod1989();
            var3.samples = new int[256 * (XClanMember.highMemory?2:1)];
            var3.field1623 = var2;
            var3.vmethod2084();
            var3.offset = (var2 & -1024) + 1024;
            if(var3.offset > 16384) {
               var3.offset = 16384;
            }

            var3.create(var3.offset);
            if(class174.priority > 0 && AbstractSoundSystem.task == null) {
               AbstractSoundSystem.task = new SoundTask();
               AbstractSoundSystem.field1622 = Executors.newScheduledThreadPool(1);
               AbstractSoundSystem.field1622.scheduleAtFixedRate(AbstractSoundSystem.task, 0L, 10L, TimeUnit.MILLISECONDS);
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
