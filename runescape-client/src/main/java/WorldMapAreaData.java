import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
   @ObfuscatedName("n")
   @Export("surfaceOffsetY")
   HashSet surfaceOffsetY;
   @ObfuscatedName("i")
   @Export("__i")
   HashSet __i;
   @ObfuscatedName("a")
   @Export("__a")
   List __a;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lgr;Lgr;IZI)V",
      garbageValue = "-1999841505"
   )
   @Export("__ce_76")
   void __ce_76(Buffer var1, Buffer var2, int var3, boolean var4) {
      this.read(var1, var3);
      int var5 = var2.__ag_302();
      this.surfaceOffsetY = new HashSet(var5);

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         class15 var7 = new class15();

         try {
            var7.method173(var2);
         } catch (IllegalStateException var11) {
            continue;
         }

         this.surfaceOffsetY.add(var7);
      }

      var6 = var2.__ag_302();
      this.__i = new HashSet(var6);

      for(int var12 = 0; var12 < var6; ++var12) {
         class39 var8 = new class39();

         try {
            var8.method714(var2);
         } catch (IllegalStateException var10) {
            continue;
         }

         this.__i.add(var8);
      }

      this.__cy_77(var2, var4);
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Lgr;ZB)V",
      garbageValue = "48"
   )
   @Export("__cy_77")
   void __cy_77(Buffer var1, boolean var2) {
      this.__a = new LinkedList();
      int var3 = var1.__ag_302();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.__ap_310();
         TileLocation var6 = new TileLocation(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.__a.add(new WorldMapIcon1((TileLocation)null, var6, var5, (WorldMapLabel)null));
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "1432369110"
   )
   @Export("getSequenceDefinition")
   public static SequenceDefinition getSequenceDefinition(int var0) {
      SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = SequenceDefinition.SequenceDefinition_indexCache.takeRecord(12, var0);
         var1 = new SequenceDefinition();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         var1.init();
         SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1767097678"
   )
   public static boolean method711(int var0) {
      return var0 >= class231.field2810.field2820 && var0 <= class231.field2822.field2820;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "15"
   )
   public static boolean method708(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-714719812"
   )
   static int method710(int var0, Script var1, boolean var2) {
      boolean var3 = true;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
         var3 = false;
      } else {
         var4 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      int var5;
      if(var0 == 1300) {
         var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] - 1;
         if(var5 >= 0 && var5 <= 9) {
            var4.setAction(var5, Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
            return 1;
         } else {
            --Interpreter.Interpreter_stringStackSize;
            return 1;
         }
      } else {
         int var6;
         if(var0 == 1301) {
            class179.Interpreter_intStackSize -= 2;
            var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            var4.parent = class204.getWidgetChild(var5, var6);
            return 1;
         } else if(var0 == 1302) {
            var4.isScrollBar = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            return 1;
         } else if(var0 == 1303) {
            var4.dragZoneSize = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1304) {
            var4.dragThreshold = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            return 1;
         } else if(var0 == 1305) {
            var4.dataText = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            return 1;
         } else if(var0 == 1306) {
            var4.spellActionName = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            return 1;
         } else if(var0 == 1307) {
            var4.actions = null;
            return 1;
         } else if(var0 == 1308) {
            var4.__fz = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
            return 1;
         } else {
            int var7;
            byte[] var8;
            if(var0 != 1350) {
               byte var11;
               if(var0 == 1351) {
                  class179.Interpreter_intStackSize -= 2;
                  var11 = 10;
                  var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize]};
                  byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]};
                  BufferedSink.method3595(var4, var11, var8, var10);
                  return 1;
               } else if(var0 == 1352) {
                  class179.Interpreter_intStackSize -= 3;
                  var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] - 1;
                  var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
                  var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
                  if(var5 >= 0 && var5 <= 9) {
                     Varcs.method2168(var4, var5, var6, var7);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if(var0 == 1353) {
                  var11 = 10;
                  var6 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  Varcs.method2168(var4, var11, var6, var7);
                  return 1;
               } else if(var0 == 1354) {
                  --class179.Interpreter_intStackSize;
                  var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize] - 1;
                  if(var5 >= 0 && var5 <= 9) {
                     WorldMapSection3.method345(var4, var5);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if(var0 == 1355) {
                  var11 = 10;
                  WorldMapSection3.method345(var4, var11);
                  return 1;
               } else {
                  return 2;
               }
            } else {
               byte[] var9 = null;
               var8 = null;
               if(var3) {
                  class179.Interpreter_intStackSize -= 10;

                  for(var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + class179.Interpreter_intStackSize] >= 0; var7 += 2) {
                     ;
                  }

                  if(var7 > 0) {
                     var9 = new byte[var7 / 2];
                     var8 = new byte[var7 / 2];

                     for(var7 -= 2; var7 >= 0; var7 -= 2) {
                        var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class179.Interpreter_intStackSize];
                        var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class179.Interpreter_intStackSize + 1];
                     }
                  }
               } else {
                  class179.Interpreter_intStackSize -= 2;
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize]};
                  var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]};
               }

               var7 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] - 1;
               if(var7 >= 0 && var7 <= 9) {
                  BufferedSink.method3595(var4, var7, var9, var8);
                  return 1;
               } else {
                  throw new RuntimeException();
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1705746695"
   )
   static final int method712(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1746120861"
   )
   static void method705(boolean var0) {
      Client.tapToDrop = var0;
   }
}
