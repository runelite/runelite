import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("dm")
   static IndexData field693;
   @ObfuscatedName("fv")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("i")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1428636455"
   )
   public static void method804() {
      class251.field3400.reset();
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(IZZZI)LIndexData;",
      garbageValue = "-2044150389"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2259 != null) {
         var4 = new IndexFile(var0, class155.field2259, BaseVarType.field32[var0], 1000000);
      }

      return new IndexData(var4, Ignore.field861, var0, var1, var2, var3);
   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "867468341"
   )
   static final void method809(Actor var0, int var1) {
      if(var0.field1274 > Client.gameCycle) {
         int var2 = var0.field1274 - Client.gameCycle;
         int var3 = var0.field1280 * 128 + var0.field1242 * 64;
         int var4 = var0.field1282 * 128 + var0.field1242 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1275 = 0;
         var0.orientation = var0.field1286;
      } else if(var0.field1285 >= Client.gameCycle) {
         class37.method515(var0);
      } else {
         class14.method75(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1274 = 0;
         var0.field1285 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1242 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1242 * 64;
         var0.method1534();
      }

      if(XItemContainer.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1274 = 0;
         var0.field1285 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1242 * 64;
         var0.y = 128 * var0.pathY[0] + var0.field1242 * 64;
         var0.method1534();
      }

      class1.method5(var0);
      class14.method73(var0);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "16"
   )
   static void method810(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class224.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1247 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1262 = 0;
         }

         if(var3 == 2) {
            var0.field1262 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class224.getAnimation(var1).forcedPriority >= class224.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1247 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1262 = 0;
         var0.field1269 = var0.queueSize;
      }

   }
}
