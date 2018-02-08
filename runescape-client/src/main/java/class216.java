import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class216 extends Node {
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = -1398427139
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 763567169
   )
   int field2649;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class218 field2655;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   RawAudioNode field2659;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class213 field2650;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1570140779
   )
   int field2652;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1644969661
   )
   int field2653;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 759950613
   )
   int field2654;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1200858745
   )
   int field2651;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -707144275
   )
   int field2656;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 103458781
   )
   int field2657;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1624698167
   )
   int field2648;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1218959127
   )
   int field2666;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1362607213
   )
   int field2660;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1642872455
   )
   int field2661;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1009528677
   )
   int field2662;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2101130089
   )
   int field2658;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 309246425
   )
   int field2664;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1322888219
   )
   int field2665;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field2667;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1001529139
   )
   int field2669;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1908354851
   )
   int field2668;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1594091269"
   )
   void method4251() {
      this.field2655 = null;
      this.field2659 = null;
      this.field2650 = null;
      this.field2667 = null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lhs;",
      garbageValue = "1666480082"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(ScriptState.widgets[var1] == null || ScriptState.widgets[var1][var2] == null) {
         boolean var3 = ServerPacket.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return ScriptState.widgets[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lld;I)I",
      garbageValue = "-739729441"
   )
   public static final int method4246(JagexLoginType var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3972) {
         case 2:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Lhs;III)V",
      garbageValue = "-2092387026"
   )
   static void method4247(Widget var0, int var1, int var2) {
      if(var0.dynamicX == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.dynamicX == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.dynamicX == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.dynamicX == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.dynamicX == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.dynamicY == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.dynamicY == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.dynamicY == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.dynamicY == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.dynamicY == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1098 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
