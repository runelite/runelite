import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
final class class44 implements Comparator {
   @ObfuscatedName("z")
   static byte[][][] field882;
   @ObfuscatedName("oq")
   @ObfuscatedGetter(
      intValue = 717140167
   )
   static int field884;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "617378814"
   )
   int method825(class2 var1, class2 var2) {
      if(var1.field22 == var2.field22) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field22) {
               return -1;
            }

            if(var2.field22 == Client.world) {
               return 1;
            }
         }

         return var1.field22 < var2.field22?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method825((class2)var1, (class2)var2);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "889878050"
   )
   static int method834(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class200.field2894:Script.field942;
      if(var0 == 1600) {
         class32.intStack[++class32.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class32.intStack[++class32.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class32.intStack[++class32.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class32.intStack[++class32.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class32.intStack[++class32.intStackSize - 1] = var3.field2244;
         return 1;
      } else if(var0 == 1606) {
         class32.intStack[++class32.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class32.intStack[++class32.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class32.intStack[++class32.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class32.intStack[++class32.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class32.intStack[++class32.intStackSize - 1] = var3.field2248;
         return 1;
      } else if(var0 == 1611) {
         class32.intStack[++class32.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class32.intStack[++class32.intStackSize - 1] = var3.field2279;
         return 1;
      } else if(var0 == 1613) {
         class32.intStack[++class32.intStackSize - 1] = var3.field2238.vmethod4163();
         return 1;
      } else {
         return 2;
      }
   }
}
