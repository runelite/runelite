import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class36 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   static final class36 field480;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   static final class36 field479;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 229746779
   )
   static int field482;
   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "Lcj;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 78031223
   )
   final int field478;

   static {
      field480 = new class36(0);
      field479 = new class36(1);
   }

   class36(int var1) {
      this.field478 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILhj;I)Lcf;",
      garbageValue = "59050678"
   )
   @Export("getScriptByFile")
   static Script getScriptByFile(int var0, class230 var1) {
      Script var2 = (Script)Script.field1424.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class22.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class22.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = CombatInfoListHolder.newScript(var5);
               if(var2 != null) {
                  Script.field1424.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;I)[Lki;",
      garbageValue = "2143382294"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return CombatInfo2.method4796(var0, var3, var4);
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Lbe;I)V",
      garbageValue = "-1160354580"
   )
   static final void method486(Actor var0) {
      if(var0.field1167 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < 32768) {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= 32768) {
               var1 = Client.cachedPlayers[var0.interacting - 32768];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1141) {
               var0.interacting = -1;
               var0.field1141 = false;
            }
         }

         if(var0.field1142 != -1 && (var0.queueSize == 0 || var0.field1172 > 0)) {
            var0.orientation = var0.field1142;
            var0.field1142 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1141) {
            var0.interacting = -1;
            var0.field1141 = false;
         }

         if(var4 != 0) {
            ++var0.field1166;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1167;
               var6 = true;
               if(var4 < var0.field1167 || var4 > 2048 - var0.field1167) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1166 > 25 || var6)) {
                  if(var0.field1120 != -1) {
                     var0.poseAnimation = var0.field1120;
                  } else {
                     var0.poseAnimation = var0.field1156;
                  }
               }
            } else {
               var0.angle += var0.field1167;
               var6 = true;
               if(var4 < var0.field1167 || var4 > 2048 - var0.field1167) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1166 > 25 || var6)) {
                  if(var0.field1121 != -1) {
                     var0.poseAnimation = var0.field1121;
                  } else {
                     var0.poseAnimation = var0.field1156;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1166 = 0;
         }

      }
   }
}
