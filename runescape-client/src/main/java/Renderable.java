import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 664571155
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cd")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljava/lang/String;Ljava/lang/String;I)Llk;",
      garbageValue = "608926699"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      byte[] var7 = var0.getConfigData(var3, var4);
      boolean var6;
      if(var7 == null) {
         var6 = false;
      } else {
         Widget.decodeSprite(var7);
         var6 = true;
      }

      IndexedSprite var5;
      if(!var6) {
         var5 = null;
      } else {
         var5 = Ignore.method5387();
      }

      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-17915"
   )
   public static boolean method3047(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
