import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "[Lkr;"
   )
   @Export("mapfunctions")
   static SpritePixels[] mapfunctions;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -852035081
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1464483735
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -546781547
   )
   @Export("z")
   int z;

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIZB)V",
      garbageValue = "49"
   )
   static void method2938(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            TextureProvider.method2478(var6, var2, var3, var4);
            WorldMapType2.method499(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               BaseVarType.method17(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILfr;Lij;B)V",
      garbageValue = "42"
   )
   static void method2939(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3206 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3237;
      synchronized(class236.field3237) {
         class236.field3237.addFront(var3);
      }

      Object var9 = class236.field3236;
      synchronized(class236.field3236) {
         if(class236.field3234 == 0) {
            class236.field3235 = new Thread(new class236());
            class236.field3235.setDaemon(true);
            class236.field3235.start();
            class236.field3235.setPriority(5);
         }

         class236.field3234 = 600;
      }
   }
}
