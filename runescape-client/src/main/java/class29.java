import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public final class class29 {
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field410;
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1840628677
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1279813339
   )
   int field404;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -33423579
   )
   int field407;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -995433483
   )
   int field405;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -892777777
   )
   int field406;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Law;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Law;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-967778924"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class245.field3316 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class245.field3316.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class245.field3316.close();
            } catch (Exception var3) {
               ;
            }

            ++class245.field3331;
            class245.field3316 = null;
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   static void method272(int var0) {
      if(var0 != -1) {
         if(CombatInfoListHolder.loadWidget(var0)) {
            Widget[] var1 = class243.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2807 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field791 = var3.field2807;
                  class64.method1147(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Lbf;I)V",
      garbageValue = "-30177101"
   )
   static final void method271(Actor var0) {
      if(var0.field1177 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1179 + 1 > ItemLayer.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1177 - var0.field1164;
         int var2 = Client.gameCycle - var0.field1164;
         int var3 = var0.field1185 * 128 + var0.field1201 * 64;
         int var4 = var0.field1159 * 128 + var0.field1201 * 64;
         int var5 = var0.field1143 * 128 + var0.field1201 * 64;
         int var6 = var0.field1199 * 128 + var0.field1201 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var2 * var6 + var4 * (var1 - var2)) / var1;
      }

      var0.field1157 = 0;
      var0.orientation = var0.field1191;
      var0.angle = var0.orientation;
   }
}
