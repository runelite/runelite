import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class175 {
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -1859734051
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-410233888"
   )
   static final void method3264() {
      UrlRequest.method2986();
      DecorativeObject.method2960();
      GameCanvas.method774();
      class179.method3303();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      Frames.method2942();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      BaseVarType.method9();
      Varbit.varbits.reset();
      VarPlayerType.varplayers.reset();
      class265.field3506.reset();
      class265.field3500.reset();
      class265.field3501.reset();
      CombatInfo2.field3452.reset();
      CombatInfo2.spriteCache.reset();
      class263.field3485.reset();
      class262.field3480.reset();
      Area.areaSpriteCache.reset();
      class22.method165();
      Widget.field2869.reset();
      Widget.Widget_cachedModels.reset();
      Widget.Widget_cachedFonts.reset();
      Widget.field2759.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1435.reset();
      CombatInfoListHolder.indexInterfaces.reset();
      class139.indexSoundEffects.reset();
      class46.indexCache3.reset();
      class19.indexCache4.reset();
      ScriptState.indexMaps.reset();
      Size.indexTrack1.reset();
      MouseInput.indexModels.reset();
      Renderable.indexSprites.reset();
      class3.indexTextures.reset();
      MouseInput.indexCache10.reset();
      RunException.indexTrack2.reset();
      Timer.indexScripts.reset();
   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1358215527"
   )
   static void method3265(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class89.field1329; ++var4) {
         ItemComposition var5 = class115.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               BoundingBox.field242 = -1;
               class232.field2926 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class232.field2926 = var2;
      class60.field726 = 0;
      BoundingBox.field242 = var3;
      String[] var8 = new String[BoundingBox.field242];

      for(int var9 = 0; var9 < BoundingBox.field242; ++var9) {
         var8[var9] = class115.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = class232.field2926;
      class31.method271(var8, var10, 0, var8.length - 1);
   }
}
