import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("Fonts")
public class Fonts {
   @ObfuscatedName("sc")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore255")
   static IndexStore indexStore255;
   @ObfuscatedName("o")
   @Export("__kz_o")
   static byte[][][] __kz_o;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("__kz_l")
   static Sprite __kz_l;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__m")
   AbstractIndexCache __m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__f")
   AbstractIndexCache __f;
   @ObfuscatedName("q")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;)V"
   )
   public Fonts(AbstractIndexCache var1, AbstractIndexCache var2) {
      this.__m = var1;
      this.__f = var2;
      this.map = new HashMap();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lkx;I)Ljava/util/HashMap;",
      garbageValue = "-1683788995"
   )
   @Export("createMap")
   public HashMap createMap(FontName[] var1) {
      HashMap var2 = new HashMap();
      FontName[] var3 = var1;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         FontName var5 = var3[var4];
         if(this.map.containsKey(var5)) {
            var2.put(var5, this.map.get(var5));
         } else {
            AbstractIndexCache var6 = this.__m;
            AbstractIndexCache var7 = this.__f;
            String var8 = var5.__g;
            int var9 = var6.getArchiveId(var8);
            int var10 = var6.getRecordId(var9, "");
            Font var11 = SpriteIds.method5823(var6, var7, var9, var10);
            if(var11 != null) {
               this.map.put(var5, var11);
               var2.put(var5, var11);
            }
         }
      }

      return var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lbt;",
      garbageValue = "2102006478"
   )
   static World method5647() {
      return World.__bt_g < World.worldsCount?ItemContainer.worlds[++World.__bt_g - 1]:null;
   }
}
