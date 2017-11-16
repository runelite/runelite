import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public final class class29 {
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field394;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 620611889
   )
   int field395;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1779791055
   )
   int field389;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1429560037
   )
   int field391;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -275117927
   )
   int field390;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   final class41 this$0;

   @ObfuscatedSignature(
      signature = "(Laj;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-755231269"
   )
   static void method220() {
      Object var0 = class243.field3290;
      synchronized(class243.field3290) {
         if(class243.field3288 == 0) {
            class243.field3287 = new Thread(new class243());
            class243.field3287.setDaemon(true);
            class243.field3287.start();
            class243.field3287.setPriority(5);
         }

         class243.field3288 = 600;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "-3858"
   )
   static void method218(int var0, int var1, int var2, int var3) {
      for(class81 var4 = (class81)class81.field1240.getFront(); var4 != null; var4 = (class81)class81.field1240.getNext()) {
         if(var4.field1243 != -1 || var4.field1247 != null) {
            int var5 = 0;
            if(var1 > var4.field1242) {
               var5 += var1 - var4.field1242;
            } else if(var1 < var4.field1248) {
               var5 += var4.field1248 - var1;
            }

            if(var2 > var4.field1241) {
               var5 += var2 - var4.field1241;
            } else if(var2 < var4.field1252) {
               var5 += var4.field1252 - var2;
            }

            if(var5 - 64 <= var4.field1238 && Client.field1051 != 0 && var0 == var4.field1239) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1238 - var5) * Client.field1051 / var4.field1238;
               if(var4.field1244 == null) {
                  if(var4.field1243 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class23.field326, var4.field1243, 0);
                     if(var7 != null) {
                        class106 var8 = var7.method1936().method1991(class39.field497);
                        class116 var9 = class116.method2145(var8, 100, var6);
                        var9.method2191(-1);
                        Client.field1087.method1914(var9);
                        var4.field1244 = var9;
                     }
                  }
               } else {
                  var4.field1244.method2135(var6);
               }

               if(var4.field1249 == null) {
                  if(var4.field1247 != null && (var4.field1237 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1247.length);
                     SoundEffect var12 = SoundEffect.getTrack(class23.field326, var4.field1247[var11], 0);
                     if(var12 != null) {
                        class106 var13 = var12.method1936().method1991(class39.field497);
                        class116 var10 = class116.method2145(var13, 100, var6);
                        var10.method2191(0);
                        Client.field1087.method1914(var10);
                        var4.field1249 = var10;
                        var4.field1237 = var4.field1245 + (int)(Math.random() * (double)(var4.field1246 - var4.field1245));
                     }
                  }
               } else {
                  var4.field1249.method2135(var6);
                  if(!var4.field1249.linked()) {
                     var4.field1249 = null;
                  }
               }
            } else {
               if(var4.field1244 != null) {
                  Client.field1087.method1880(var4.field1244);
                  var4.field1244 = null;
               }

               if(var4.field1249 != null) {
                  Client.field1087.method1880(var4.field1249);
                  var4.field1249 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-18872"
   )
   public static boolean method219() {
      return class210.field2585 != 0?true:class210.field2587.method3819();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;Ljava/lang/String;I)Lkb;",
      garbageValue = "1920428681"
   )
   public static SpritePixels method221(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class163.method3082(var0, var3, var4);
   }
}
