import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("combatInfo1")
   CombatInfoList combatInfo1;

   @ObfuscatedSignature(
      signature = "(Ljj;)V"
   )
   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "193768036"
   )
   void method1923(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.last(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.previous()) {
         ++var6;
         if(var7.cycle == var1) {
            var7.set(var1, var2, var3, var4);
            return;
         }

         if(var7.cycle <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.addLast(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method4064(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.last().unlink();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Lbv;",
      garbageValue = "64"
   )
   CombatInfo1 method1925(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.last();
      if(var2 != null && var2.cycle <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.previous(); var3 != null && var3.cycle <= var1; var3 = (CombatInfo1)this.combatInfo1.previous()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field3532 + var2.cycle + var2.int2 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-54"
   )
   boolean method1926() {
      return this.combatInfo1.isEmpty();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;I)V",
      garbageValue = "633222779"
   )
   public static void method1937(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3526 = var0;
      CombatInfo2.field3523 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "110"
   )
   static int method1938(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class81.intStack[--class171.intStackSize];
         var4 = UnitPriceComparator.getWidget(var3);
      } else {
         var4 = var2?class49.field604:class81.field1270;
      }

      if(var0 == 1000) {
         class171.intStackSize -= 4;
         var4.originalX = class81.intStack[class171.intStackSize];
         var4.originalY = class81.intStack[class171.intStackSize + 1];
         var4.dynamicX = class81.intStack[class171.intStackSize + 2];
         var4.dynamicY = class81.intStack[class171.intStackSize + 3];
         TotalQuantityComparator.method100(var4);
         InvType.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class33.method372(GZipDecompressor.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class171.intStackSize -= 4;
         var4.originalWidth = class81.intStack[class171.intStackSize];
         var4.originalHeight = class81.intStack[class171.intStackSize + 1];
         var4.dynamicWidth = class81.intStack[class171.intStackSize + 2];
         var4.buttonType = class81.intStack[class171.intStackSize + 3];
         TotalQuantityComparator.method100(var4);
         InvType.clientInstance.widgetMethod0(var4);
         if(var3 != -1 && var4.type == 0) {
            class33.method372(GZipDecompressor.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class81.intStack[--class171.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            TotalQuantityComparator.method100(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class81.intStack[--class171.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = class81.intStack[--class171.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Llh;I)V",
      garbageValue = "-749527234"
   )
   static final void method1931(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class199.field2604.length; ++var2) {
         class199.field2604[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class199.field2604[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class33.field459[var5] = (class199.field2604[var5 - 128] + class199.field2604[var5 + 1] + class199.field2604[var5 + 128] + class199.field2604[var5 - 1]) / 4;
            }
         }

         int[] var8 = class199.field2604;
         class199.field2604 = class33.field459;
         class33.field459 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.width; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class199.field2604[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1900151126"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3379 != 0 && var3 > IndexDataBase.field3379) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3379 == 0 || var6 <= IndexDataBase.field3379)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
