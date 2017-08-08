import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class89 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "1315693030"
   )
   public static Object method1732(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2401) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2401 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "544110622"
   )
   static void method1730(int var0, int var1, int var2, int var3) {
      for(class82 var4 = (class82)class82.field1314.getFront(); var4 != null; var4 = (class82)class82.field1314.getNext()) {
         if(var4.field1310 != -1 || var4.field1311 != null) {
            int var5 = 0;
            if(var1 > var4.field1307) {
               var5 += var1 - var4.field1307;
            } else if(var1 < var4.field1305) {
               var5 += var4.field1305 - var1;
            }

            if(var2 > var4.field1308) {
               var5 += var2 - var4.field1308;
            } else if(var2 < var4.field1304) {
               var5 += var4.field1304 - var2;
            }

            if(var5 - 64 <= var4.field1306 && Client.field1143 != 0 && var0 == var4.field1315) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1306 - var5) * Client.field1143 / var4.field1306;
               if(var4.field1316 == null) {
                  if(var4.field1310 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(CombatInfo1.field1272, var4.field1310, 0);
                     if(var7 != null) {
                        class108 var8 = var7.method1964().method2011(class228.field3114);
                        class118 var9 = class118.method2147(var8, 100, var6);
                        var9.method2286(-1);
                        class36.field513.method1911(var9);
                        var4.field1316 = var9;
                     }
                  }
               } else {
                  var4.field1316.method2252(var6);
               }

               if(var4.field1312 == null) {
                  if(var4.field1311 != null && (var4.field1309 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1311.length);
                     SoundEffect var12 = SoundEffect.getTrack(CombatInfo1.field1272, var4.field1311[var11], 0);
                     if(var12 != null) {
                        class108 var13 = var12.method1964().method2011(class228.field3114);
                        class118 var10 = class118.method2147(var13, 100, var6);
                        var10.method2286(0);
                        class36.field513.method1911(var10);
                        var4.field1312 = var10;
                        var4.field1309 = var4.field1303 + (int)(Math.random() * (double)(var4.field1313 - var4.field1303));
                     }
                  }
               } else {
                  var4.field1312.method2252(var6);
                  if(!var4.field1312.linked()) {
                     var4.field1312 = null;
                  }
               }
            } else {
               if(var4.field1316 != null) {
                  class36.field513.method1934(var4.field1316);
                  var4.field1316 = null;
               }

               if(var4.field1312 != null) {
                  class36.field513.method1934(var4.field1312);
                  var4.field1312 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-460987978"
   )
   static String method1733(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class72.sessionToken != null) {
         var3 = "/p=" + class72.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + WorldMapType2.field523 + var3 + "/";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-406596920"
   )
   public static boolean method1734(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
