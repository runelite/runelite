import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("as")
   static GarbageCollectorMXBean field824;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   class219 field819;
   @ObfuscatedName("d")
   Object[] field818;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 337044451
   )
   int field813;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1376404355
   )
   int field814;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Widget field821;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 601167049
   )
   int field820;
   @ObfuscatedName("r")
   String field826;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1337235041
   )
   int field822;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1343817259
   )
   int field817;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 721311099
   )
   int field810;
   @ObfuscatedName("q")
   boolean field811;

   public ScriptEvent() {
      this.field819 = class219.field2767;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-2056416400"
   )
   public void method1115(Object[] var1) {
      this.field818 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhh;I)V",
      garbageValue = "1692707346"
   )
   public void method1116(class219 var1) {
      this.field819 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILiv;II)V",
      garbageValue = "1631557728"
   )
   static void method1124(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1284 = var0;
      var5.field1285 = var1 * 128;
      var5.field1298 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1287 = (var6 + var1) * 128;
      var5.field1292 = (var7 + var2) * 128;
      var5.field1290 = var3.ambientSoundId;
      var5.field1289 = var3.field3460 * 128;
      var5.field1297 = var3.field3461;
      var5.field1293 = var3.field3462;
      var5.field1294 = var3.field3449;
      if(var3.impostorIds != null) {
         var5.field1295 = var3;
         var5.method1610();
      }

      class82.field1286.addFront(var5);
      if(var5.field1294 != null) {
         var5.field1283 = var5.field1297 + (int)(Math.random() * (double)(var5.field1293 - var5.field1297));
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "697926000"
   )
   static int method1125(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class214.field2615:class73.field851;
      if(var0 == 1700) {
         class83.intStack[++class83.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            class83.intStack[++class83.intStackSize - 1] = var3.itemQuantity;
         } else {
            class83.intStack[++class83.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class83.intStack[++class83.intStackSize - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
