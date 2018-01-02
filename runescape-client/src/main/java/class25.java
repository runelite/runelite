import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class25 {
   @ObfuscatedName("s")
   static boolean field347;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1385110915
   )
   int field346;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   Coordinates field345;

   @ObfuscatedSignature(
      signature = "(ILhc;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field346 = var1;
      this.field345 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;B)I",
      garbageValue = "-62"
   )
   public static int method180(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & '?');
         } else {
            var0[var4++] = (byte)(224 | var6 >> '\f');
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & '?');
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IS)Liv;",
      garbageValue = "732"
   )
   public static VarPlayerType method182(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-2066023452"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      AbstractScene.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lbe;I)V",
      garbageValue = "692716377"
   )
   static void method179(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !class34.field455 && MouseInput.mouseLastButton == 4) {
         int var1 = class91.field1351 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(0, 1);
            return;
         }

         int var2 = class91.field1351 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(1, 1);
            return;
         }

         int var3 = class91.field1351 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(2, 1);
            return;
         }

         int var4 = class91.field1351 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            WorldMapType2.method526(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class91.field1351 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class91.field1351 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class91.worldSelectShown = false;
            class91.field1315.method5203(class91.field1351, 0);
            class91.field1319.method5203(class91.field1351 + 382, 0);
            class91.logoSprite.method5176(class91.field1351 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }

         if(class91.field1326 != -1) {
            World var5 = ItemContainer.worldList[class91.field1326];
            Size.method176(var5);
            class91.worldSelectShown = false;
            class91.field1315.method5203(class91.field1351, 0);
            class91.field1319.method5203(class91.field1351 + 382, 0);
            class91.logoSprite.method5176(class91.field1351 + 382 - class91.logoSprite.originalWidth / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2021289068"
   )
   static void method181() {
      if(Client.spellSelected) {
         Widget var0 = TextureProvider.getWidgetChild(JagexGame.field3297, Client.field984);
         if(var0 != null && var0.field2797 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.objs = var0.field2797;
            CacheFile.method2350(var1);
         }

         Client.spellSelected = false;
         class33.method344(var0);
      }
   }
}
