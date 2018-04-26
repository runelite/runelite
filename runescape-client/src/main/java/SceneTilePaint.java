import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -633667531
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -434915747
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -770950667
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 863508517
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1946772945
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("l")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 876143599
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IS)Lje;",
      garbageValue = "128"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class191.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }
}
