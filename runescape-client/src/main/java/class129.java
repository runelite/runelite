import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class129 {
   @ObfuscatedName("m")
   static SpritePixels field2078;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = -1872272395
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   static void method2805(int var0) {
      if(var0 != -1) {
         if(class174.method3393(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2861 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field5 = var3.field2861;
                  Player.method35(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "-481047992"
   )
   static int method2814(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method648()?(var1.method648()?0:1):(var1.method648()?-1:0)):(var2 == 5?(var0.method608()?(var1.method608()?0:1):(var1.method608()?-1:0)):(var2 == 6?(var0.method609()?(var1.method609()?0:1):(var1.method609()?-1:0)):(var2 == 7?(var0.method607()?(var1.method607()?0:1):(var1.method607()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-833932015"
   )
   static void method2815() {
      FileOnDisk var0 = null;

      try {
         var0 = class47.method945("", Client.field466.field2330, true);
         Buffer var1 = Sequence.field984.method107();
         var0.method4124(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4128();
         }
      } catch (Exception var2) {
         ;
      }

   }
}
