import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class231 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1502365467
   )
   int field2725;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   class233 field2715;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   RawAudioNode field2716;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   class228 field2717;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 679331173
   )
   int field2718;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1634464667
   )
   int field2719;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1086755291
   )
   int field2720;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -648378935
   )
   int field2721;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1742274145
   )
   int field2722;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 358698043
   )
   int field2723;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -367859909
   )
   int field2724;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 108138415
   )
   int field2731;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1677657369
   )
   int field2726;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1676073617
   )
   int field2727;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1773765779
   )
   int field2728;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1364188571
   )
   int field2729;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1983755585
   )
   int field2733;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1021949373
   )
   int field2730;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field2732;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 804264015
   )
   int field2714;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 597221979
   )
   int field2734;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-115"
   )
   void method4259() {
      this.field2715 = null;
      this.field2716 = null;
      this.field2717 = null;
      this.field2732 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1608218808"
   )
   static void method4261() {
      for(class80 var0 = (class80)class80.field1261.getFront(); var0 != null; var0 = (class80)class80.field1261.getNext()) {
         if(var0.field1260 != null) {
            GameCanvas.field632.method2062(var0.field1260);
            var0.field1260 = null;
         }

         if(var0.field1254 != null) {
            GameCanvas.field632.method2062(var0.field1254);
            var0.field1254 = null;
         }
      }

      class80.field1261.clear();
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-2034954348"
   )
   static final void method4260(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class289.method5205(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1142 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Lib;IIB)V",
      garbageValue = "24"
   )
   static final void method4258(Widget var0, int var1, int var2) {
      if(Client.draggedWidget == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var4 = NetWriter.method2045(var0);
            if(var4 == null) {
               var4 = var0.dragParent;
            }

            if(var4 != null) {
               Client.draggedWidget = var0;
               var4 = NetWriter.method2045(var0);
               if(var4 == null) {
                  var4 = var0.dragParent;
               }

               Client.field1028 = var4;
               Client.field1029 = var1;
               Client.field1030 = var2;
               WorldMapRegion.field453 = 0;
               Client.draggingWidget = false;
               int var5 = class36.method520();
               if(var5 != -1) {
                  BoundingBox3DDrawMode.method68(var5);
               }

               return;
            }
         }

      }
   }
}
