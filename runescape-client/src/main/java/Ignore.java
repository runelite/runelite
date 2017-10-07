import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -680154265
   )
   public static int field858;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("k")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;S)[Ljz;",
      garbageValue = "13983"
   )
   public static IndexedSprite[] method1147(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!class249.method4517(var0, var3, var4)) {
         var5 = null;
      } else {
         IndexedSprite[] var7 = new IndexedSprite[class15.field298];

         for(int var8 = 0; var8 < class15.field298; ++var8) {
            IndexedSprite var9 = var7[var8] = new IndexedSprite();
            var9.width = class287.field3808;
            var9.originalHeight = class164.field2325;
            var9.offsetX = class287.field3807[var8];
            var9.offsetY = World.offsetsY[var8];
            var9.originalWidth = class236.field3238[var8];
            var9.height = FileSystem.field3207[var8];
            var9.palette = class181.field2456;
            var9.pixels = class208.spritePixels[var8];
         }

         Actor.method1605();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "584519671"
   )
   static void method1146(int var0, int var1, int var2, int var3) {
      Widget var4 = class5.method18(var0, var1);
      if(var4 != null && var4.field2749 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.field846 = var4.field2749;
         CollisionData.method3128(var5);
      }

      Client.field1070 = var3;
      Client.spellSelected = true;
      class25.field372 = var0;
      Client.field1069 = var1;
      WorldMapType1.field451 = var2;
      class25.method172(var4);
   }
}
