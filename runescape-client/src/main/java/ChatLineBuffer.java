import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = -408614819
   )
   static int field1440;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lbx;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1747566333
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbx;",
      garbageValue = "-500012674"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lbx;",
      garbageValue = "378036039"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1796575714"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Lbe;II)V",
      garbageValue = "1032425359"
   )
   static final void method2040(Actor var0, int var1) {
      if(var0.field1160 > Client.gameCycle) {
         class173.method3412(var0);
      } else if(var0.field1149 >= Client.gameCycle) {
         if(var0.field1149 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1140 + 1 > FileRequest.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
            int var2 = var0.field1149 - var0.field1160;
            int var3 = Client.gameCycle - var0.field1160;
            int var4 = var0.field1162 * 128 + var0.field1127 * 64;
            int var5 = var0.field1158 * 128 + var0.field1127 * 64;
            int var6 = var0.field1157 * 128 + var0.field1127 * 64;
            int var7 = var0.field1159 * 128 + var0.field1127 * 64;
            var0.x = (var6 * var3 + var4 * (var2 - var3)) / var2;
            var0.y = (var3 * var7 + var5 * (var2 - var3)) / var2;
         }

         var0.field1172 = 0;
         var0.orientation = var0.field1118;
         var0.angle = var0.orientation;
      } else {
         class45.method618(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1160 = 0;
         var0.field1149 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1127 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1127 * 64;
         var0.method1602();
      }

      if(GroundObject.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1160 = 0;
         var0.field1149 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1127 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1127 * 64;
         var0.method1602();
      }

      class36.method486(var0);
      Preferences.method1666(var0);
   }
}
