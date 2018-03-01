import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
final class class5 implements class0 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static Track1 field36;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2028812366"
   )
   static int method17() {
      return ++class95.field1434 - 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "-809382862"
   )
   @Export("getWidget")
   public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & 65535;
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class18.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;I)V",
      garbageValue = "1764329639"
   )
   public static void method21(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2041370268"
   )
   static void method16() {
      for(class80 var0 = (class80)class80.field1253.getFront(); var0 != null; var0 = (class80)class80.field1253.getNext()) {
         if(var0.field1247 != null) {
            class29.field431.method2129(var0.field1247);
            var0.field1247 = null;
         }

         if(var0.field1252 != null) {
            class29.field431.method2129(var0.field1252);
            var0.field1252 = null;
         }
      }

      class80.field1253.clear();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1686815758"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = Size.method185(var0 - 1, var1 - 1) + Size.method185(var0 + 1, var1 - 1) + Size.method185(var0 - 1, 1 + var1) + Size.method185(1 + var0, 1 + var1);
      int var3 = Size.method185(var0 - 1, var1) + Size.method185(var0 + 1, var1) + Size.method185(var0, var1 - 1) + Size.method185(var0, var1 + 1);
      int var4 = Size.method185(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-122"
   )
   static final void method18() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         if(var0.hitpoints == 0) {
            if(var0.field1128 < 0 || class57.method833(var0.field1128, var0.field1135)) {
               class93.method1987(var0.level, var0.type, var0.x, var0.y, var0.field1128, var0.field1129, var0.field1135);
               var0.unlink();
            }
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102 && (var0.id < 0 || class57.method833(var0.id, var0.field1125))) {
               class93.method1987(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1125);
               var0.delay = -1;
               if(var0.field1128 == var0.id && var0.field1128 == -1) {
                  var0.unlink();
               } else if(var0.field1128 == var0.id && var0.field1129 == var0.orientation && var0.field1125 == var0.field1135) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Liw;IIB)V",
      garbageValue = "-56"
   )
   static final void method20(Widget var0, int var1, int var2) {
      if(Client.field1021 == null && !Client.isMenuOpen) {
         if(var0 != null && Player.method1146(var0) != null) {
            Client.field1021 = var0;
            Client.field1022 = Player.method1146(var0);
            Client.field1023 = var1;
            Client.field1056 = var2;
            class31.field449 = 0;
            Client.field1032 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               WorldMapType1.method264(var3);
            }

         }
      }
   }
}
