import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class101 extends RuntimeException {
   @ObfuscatedName("d")
   static Applet field1639;
   @ObfuscatedName("p")
   Throwable field1640;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1191139251
   )
   @Export("revision")
   static int revision;
   @ObfuscatedName("q")
   String field1642;
   @ObfuscatedName("c")
   public static String field1648;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "67"
   )
   static final void method1962() {
      Overlay.field3071.reset();
      FloorUnderlayDefinition.field2822.reset();
      class163.method3088();
      class39.method774();
      NPCComposition.field3035.reset();
      NPCComposition.npcModelCache.reset();
      ItemComposition.field2982.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      class179.method3273();
      Spotanim.field2801.reset();
      Spotanim.field2808.reset();
      Buffer.method2392();
      FileOnDisk.method1426();
      class201.field2922.reset();
      class201.spriteCache.reset();
      class201.field2908.reset();
      class191.method3470();
      class199.field2878.reset();
      class7.method91();
      PlayerComposition.field2185.reset();
      Widget.field2258.reset();
      Widget.field2202.reset();
      Widget.field2239.reset();
      Widget.field2204.reset();
      ((TextureProvider)class84.field1437).method1459();
      Script.field944.reset();
      class122.indexInterfaces.method3309();
      class33.indexSoundEffects.method3309();
      class8.field78.method3309();
      class199.field2882.method3309();
      FileOnDisk.indexMaps.method3309();
      class18.indexTrack1.method3309();
      class45.indexModels.method3309();
      WallObject.indexSprites.method3309();
      class214.indexTextures.method3309();
      Client.field312.method3309();
      KitDefinition.indexTrack2.method3309();
      class107.indexScripts.method3309();
   }
}
