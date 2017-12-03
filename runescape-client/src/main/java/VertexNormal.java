import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("or")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("nn")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 197876021
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -364405127
   )
   @Export("x")
   int x;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -312726173
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -820067941
   )
   @Export("z")
   int z;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1070537593
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lek;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lhz;",
      garbageValue = "1567554923"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = GraphicsObject.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "1580470275"
   )
   static int method2601(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class139.field2008:AttackOption.field1306;
      if(var0 == 1500) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class82.intStack[++class82.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class82.intStack[++class82.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class82.intStack[++class82.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class82.intStack[++class82.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
