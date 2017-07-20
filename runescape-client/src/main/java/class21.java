import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class21 {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1150675905
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lho;I)V",
      garbageValue = "-643436335"
   )
   static void method156(Widget var0) {
      if(var0.loopCycle == Client.field1108) {
         Client.field1109[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;Lip;I)V",
      garbageValue = "1959060030"
   )
   public static void method152(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
      class254.field3389 = var0;
      class254.field3405 = var1;
      class254.field3388 = var2;
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(Lcm;I)V",
      garbageValue = "-1928522677"
   )
   static final void method154(Actor var0) {
      if(var0.field1232 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1249) {
               var0.interacting = -1;
               var0.field1249 = false;
            }
         }

         if(var0.field1237 != -1 && (var0.queueSize == 0 || var0.field1267 > 0)) {
            var0.orientation = var0.field1237;
            var0.field1237 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1249) {
            var0.interacting = -1;
            var0.field1249 = false;
         }

         if(var4 != 0) {
            ++var0.field1260;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1232;
               var6 = true;
               if(var4 < var0.field1232 || var4 > 2048 - var0.field1232) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1260 > 25 || var6)) {
                  if(var0.field1215 != -1) {
                     var0.poseAnimation = var0.field1215;
                  } else {
                     var0.poseAnimation = var0.field1217;
                  }
               }
            } else {
               var0.angle += var0.field1232;
               var6 = true;
               if(var4 < var0.field1232 || var4 > 2048 - var0.field1232) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1260 > 25 || var6)) {
                  if(var0.field1216 != -1) {
                     var0.poseAnimation = var0.field1216;
                  } else {
                     var0.poseAnimation = var0.field1217;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1260 = 0;
         }

      }
   }
}
