import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class51 implements class105 {
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lck;"
   )
   @Export("chatMessages")
   static Varcs chatMessages;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("ly")
   @ObfuscatedGetter(
      intValue = -314222045
   )
   static int field623;
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   @Export("mapfunctions")
   static SpritePixels[] mapfunctions;
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   static SpritePixels[] field627;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      longValue = 874080582063497731L
   )
   static long field622;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "329030978"
   )
   public AbstractSoundSystem vmethod1989() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-339617724"
   )
   static final void method792() {
      if(CacheFile.rssocket != null) {
         CacheFile.rssocket.close();
         CacheFile.rssocket = null;
      }

      class92.method1760();
      region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class27.method210(2);
      Client.field1069 = -1;
      Client.field1121 = false;

      for(class82 var1 = (class82)class82.field1286.getFront(); var1 != null; var1 = (class82)class82.field1286.getNext()) {
         if(var1.field1291 != null) {
            class2.field18.method1938(var1.field1291);
            var1.field1291 = null;
         }

         if(var1.field1296 != null) {
            class2.field18.method1938(var1.field1296);
            var1.field1296 = null;
         }
      }

      class82.field1286.clear();
      class2.setGameState(10);
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(Lbg;IIB)V",
      garbageValue = "125"
   )
   static void method793(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class40.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1223 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1218 = 0;
         }

         if(var3 == 2) {
            var0.field1218 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class40.getAnimation(var1).forcedPriority >= class40.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1223 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1218 = 0;
         var0.field1248 = var0.queueSize;
      }

   }
}
