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
   @Export("masterDisk")
   static ArchiveDisk masterDisk;
   @ObfuscatedName("o")
   static byte[][][] field350;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("rightTitleSprite")
   static Sprite rightTitleSprite;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   AbstractArchive field351;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   AbstractArchive field352;
   @ObfuscatedName("q")
   @Export("map")
   HashMap map;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;)V"
   )
   public Fonts(AbstractArchive var1, AbstractArchive var2) {
      this.field351 = var1;
      this.field352 = var2;
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

      for (int var4 = 0; var4 < var3.length; ++var4) {
         FontName var5 = var3[var4];
         if (this.map.containsKey(var5)) {
            var2.put(var5, this.map.get(var5));
         } else {
            AbstractArchive var6 = this.field351;
            AbstractArchive var7 = this.field352;
            String var8 = var5.field349;
            int var9 = var6.getGroupId(var8);
            int var10 = var6.getFileId(var9, "");
            Font var11 = GraphicsDefaults.method5823(var6, var7, var9, var10);
            if (var11 != null) {
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
      return World.field987 < World.worldsCount ? ItemContainer.worlds[++World.field987 - 1] : null;
   }
}
