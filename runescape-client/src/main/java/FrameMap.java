import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1540730737
   )
   int field1455;
   @ObfuscatedName("n")
   int[] field1456;
   @ObfuscatedName("q")
   int[][] field1457;
   @ObfuscatedName("v")
   static int[] field1459;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1812728695
   )
   int field1461;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-111"
   )
   static void method1717(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2774(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "0"
   )
   static final void method1718(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         Actor.method594(var2);
      }

      for(class154 var4 = (class154)Client.widgetFlags.method2776(); var4 != null; var4 = (class154)Client.widgetFlags.method2777()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var5 = class128.method2364(var3);
      if(var5 != null) {
         class124.method2350(var5);
      }

      class16.method190();
      if(Client.widgetRoot != -1) {
         Client.method572(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1657707911"
   )
   static int method1719(int var0, Script var1, boolean var2) {
      Widget var3 = class128.method2364(class32.intStack[--class32.intStackSize]);
      if(var0 == 2500) {
         class32.intStack[++class32.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class32.intStack[++class32.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class32.intStack[++class32.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class32.intStack[++class32.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class32.intStack[++class32.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class32.intStack[++class32.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   FrameMap(int var1, byte[] var2) {
      this.field1455 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1461 = var3.readUnsignedByte();
      this.field1456 = new int[this.field1461];
      this.field1457 = new int[this.field1461][];

      int var4;
      for(var4 = 0; var4 < this.field1461; ++var4) {
         this.field1456[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1461; ++var4) {
         this.field1457[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1461; ++var4) {
         for(int var5 = 0; var5 < this.field1457[var4].length; ++var5) {
            this.field1457[var4][var5] = var3.readUnsignedByte();
         }
      }

   }
}
