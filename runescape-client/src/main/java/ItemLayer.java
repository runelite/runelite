import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1966237979
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 843442409
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1199892667
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1082408805
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Leq;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1765039361
   )
   @Export("height")
   int height;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)Z",
      garbageValue = "53"
   )
   static final boolean method2428(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class135.field1998 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class135.field1998 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class135.field1996 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class135.field1996 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Lia;Lia;Lia;I)V",
      garbageValue = "-1571736501"
   )
   public static void method2429(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      SoundTask.widgetIndex = var0;
      class267.field3649 = var1;
      NPC.field1380 = var2;
      Widget.field2666 = var3;
      class176.widgets = new Widget[SoundTask.widgetIndex.size()][];
      BaseVarType.validInterfaces = new boolean[SoundTask.widgetIndex.size()];
   }
}
