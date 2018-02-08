import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class37 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   static SpritePixels field483;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-12"
   )
   static void method492(int var0, int var1, int var2, int var3) {
      for(class79 var4 = (class79)class79.field1233.getFront(); var4 != null; var4 = (class79)class79.field1233.getNext()) {
         if(var4.field1227 != -1 || var4.field1228 != null) {
            int var5 = 0;
            if(var1 > var4.field1224) {
               var5 += var1 - var4.field1224;
            } else if(var1 < var4.field1222) {
               var5 += var4.field1222 - var1;
            }

            if(var2 > var4.field1225) {
               var5 += var2 - var4.field1225;
            } else if(var2 < var4.field1235) {
               var5 += var4.field1235 - var2;
            }

            if(var5 - 64 <= var4.field1226 && Client.field878 != 0 && var0 == var4.field1221) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1226 - var5) * Client.field878 / var4.field1226;
               if(var4.field1231 == null) {
                  if(var4.field1227 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class62.indexCache4, var4.field1227, 0);
                     if(var7 != null) {
                        RawAudioNode var8 = var7.method2181().applyResampler(VarPlayerType.field3370);
                        class116 var9 = class116.method2526(var8, 100, var6);
                        var9.method2387(-1);
                        class33.field450.method2129(var9);
                        var4.field1231 = var9;
                     }
                  }
               } else {
                  var4.field1231.method2388(var6);
               }

               if(var4.field1220 == null) {
                  if(var4.field1228 != null && (var4.field1232 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1228.length);
                     SoundEffect var12 = SoundEffect.getTrack(class62.indexCache4, var4.field1228[var11], 0);
                     if(var12 != null) {
                        RawAudioNode var13 = var12.method2181().applyResampler(VarPlayerType.field3370);
                        class116 var10 = class116.method2526(var13, 100, var6);
                        var10.method2387(0);
                        class33.field450.method2129(var10);
                        var4.field1220 = var10;
                        var4.field1232 = var4.field1229 + (int)(Math.random() * (double)(var4.field1230 - var4.field1229));
                     }
                  }
               } else {
                  var4.field1220.method2388(var6);
                  if(!var4.field1220.linked()) {
                     var4.field1220 = null;
                  }
               }
            } else {
               if(var4.field1231 != null) {
                  class33.field450.method2117(var4.field1231);
                  var4.field1231 = null;
               }

               if(var4.field1220 != null) {
                  class33.field450.method2117(var4.field1220);
                  var4.field1220 = null;
               }
            }
         }
      }

   }
}
