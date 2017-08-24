import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class133 {
   @ObfuscatedName("i")
   public static boolean field2011;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 267327621
   )
   public static int field2002;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1875869747
   )
   public static int field2001;
   @ObfuscatedName("r")
   public static boolean field2004;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1768736045
   )
   public static int field2009;
   @ObfuscatedName("v")
   public static int[] field2003;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1128427415
   )
   static int field2005;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1851955083
   )
   static int field2006;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1739144011
   )
   static int field2008;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -928502333
   )
   static int field2007;

   static {
      field2011 = false;
      field2002 = 0;
      field2001 = 0;
      field2004 = false;
      field2009 = 0;
      field2003 = new int[1000];
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(Lbg;B)V",
      garbageValue = "-123"
   )
   static final void method2612(Actor var0) {
      if(var0.field1282 != 0) {
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
            } else if(var0.field1264) {
               var0.interacting = -1;
               var0.field1264 = false;
            }
         }

         if(var0.field1257 != -1 && (var0.queueSize == 0 || var0.field1287 > 0)) {
            var0.orientation = var0.field1257;
            var0.field1257 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1264) {
            var0.interacting = -1;
            var0.field1264 = false;
         }

         if(var4 != 0) {
            ++var0.field1281;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1282;
               var6 = true;
               if(var4 < var0.field1282 || var4 > 2048 - var0.field1282) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1281 > 25 || var6)) {
                  if(var0.field1253 != -1) {
                     var0.poseAnimation = var0.field1253;
                  } else {
                     var0.poseAnimation = var0.field1268;
                  }
               }
            } else {
               var0.angle += var0.field1282;
               var6 = true;
               if(var4 < var0.field1282 || var4 > 2048 - var0.field1282) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field1281 > 25 || var6)) {
                  if(var0.field1251 != -1) {
                     var0.poseAnimation = var0.field1251;
                  } else {
                     var0.poseAnimation = var0.field1268;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1281 = 0;
         }

      }
   }
}
