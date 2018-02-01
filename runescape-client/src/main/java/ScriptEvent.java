import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("p")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("i")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1058572423
   )
   int field748;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1616256553
   )
   int field746;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 871347815
   )
   int field750;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   Widget field752;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 54616507
   )
   int field745;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1508896291
   )
   int field753;
   @ObfuscatedName("h")
   @Export("string")
   String string;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -756142497
   )
   int field755;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   class230 field756;

   public ScriptEvent() {
      this.field756 = class230.field2876;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "59"
   )
   public void method1076(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhe;B)V",
      garbageValue = "-119"
   )
   public void method1077(class230 var1) {
      this.field756 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;III)[Lkh;",
      garbageValue = "-128447701"
   )
   static IndexedSprite[] method1075(IndexDataBase var0, int var1, int var2) {
      return !class160.method3147(var0, var1, var2)?null:class268.method4896();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Lbi;II[I[II)V",
      garbageValue = "2003437593"
   )
   static void method1081(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1608()?1:0;
                     var12 = var8.method1608()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1608()?1:0;
                     var12 = var8.method1608()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1081(var0, var1, var6, var3, var4);
         method1081(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "15976"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = BoundingBox2D.font_p12full.method5210(var0, 250);
      int var6 = BoundingBox2D.font_p12full.method5208(var0, 250) * 13;
      Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 16777215);
      BoundingBox2D.font_p12full.method5217(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      OwnWorldComparator.method1182(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         CombatInfo2.rasterProvider.drawFull(0, 0);
      } else {
         int var7 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.widgetCount; ++var11) {
            if(Client.widgetBoundsWidth[var11] + Client.widgetPositionX[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
               Client.field1013[var11] = true;
            }
         }
      }

   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "56"
   )
   static final String method1083(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class1.getColTags(16711680):(var2 < -6?class1.getColTags(16723968):(var2 < -3?class1.getColTags(16740352):(var2 < 0?class1.getColTags(16756736):(var2 > 9?class1.getColTags(65280):(var2 > 6?class1.getColTags(4259584):(var2 > 3?class1.getColTags(8453888):(var2 > 0?class1.getColTags(12648192):class1.getColTags(16776960))))))));
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "3"
   )
   static void method1082(int var0, int var1) {
      Huffman.method3338(class45.topContextMenuRow, var0, var1);
      class45.topContextMenuRow = null;
   }
}
