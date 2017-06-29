import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class40 {
   @ObfuscatedName("t")
   public static final class40 field561;
   @ObfuscatedName("w")
   public static final class40 field562;
   @ObfuscatedName("i")
   public static final class40 field564;
   @ObfuscatedName("s")
   public static final class40 field565;
   @ObfuscatedName("r")
   public final String field566;
   @ObfuscatedName("a")
   public static final class40 field567;
   @ObfuscatedName("rn")
   @ObfuscatedGetter(
      intValue = -2144793827
   )
   static int field569;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -2001387037
   )
   static int field571;

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;B)V",
      garbageValue = "83"
   )
   static final void method560(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class136.SINE[var6];
            int var9 = class136.COSINE[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var2 * var9 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5061(var10 + var5.field2607 / 2 - var4.maxWidth / 2, var5.field2602 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2607, var5.field2602, var5.field2604, var5.field2608);
            } else {
               var4.method5042(var10 + var0 + var5.field2607 / 2 - var4.maxWidth / 2, var5.field2602 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   static {
      field564 = new class40("details");
      field562 = new class40("compositemap");
      field567 = new class40("compositetexture");
      field561 = new class40("area");
      field565 = new class40("labels");
   }

   class40(String var1) {
      this.field566 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1755091516"
   )
   public static File method561(String var0) {
      if(!class157.field2271) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2267.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2268, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2267.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2072375684"
   )
   static final void method562(boolean var0) {
      while(true) {
         if(Client.secretPacketBuffer2.method3390(Client.packetLength) >= 27) {
            int var1 = Client.secretPacketBuffer2.method3388(15);
            if(var1 != 32767) {
               boolean var2 = false;
               if(Client.cachedNPCs[var1] == null) {
                  Client.cachedNPCs[var1] = new NPC();
                  var2 = true;
               }

               NPC var3 = Client.cachedNPCs[var1];
               Client.npcIndices[++Client.field937 - 1] = var1;
               var3.field1287 = Client.gameCycle;
               int var4 = Client.field1123[Client.secretPacketBuffer2.method3388(3)];
               if(var2) {
                  var3.orientation = var3.angle = var4;
               }

               int var5 = Client.secretPacketBuffer2.method3388(1);
               int var6;
               if(var0) {
                  var6 = Client.secretPacketBuffer2.method3388(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = Client.secretPacketBuffer2.method3388(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = Client.secretPacketBuffer2.method3388(1);
               if(var7 == 1) {
                  Client.field1026[++Client.field965 - 1] = var1;
               }

               int var8;
               if(var0) {
                  var8 = Client.secretPacketBuffer2.method3388(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = Client.secretPacketBuffer2.method3388(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               var3.composition = class35.getNpcDefinition(Client.secretPacketBuffer2.method3388(14));
               var3.field1242 = var3.composition.field3561;
               var3.field1291 = var3.composition.field3573;
               if(var3.field1291 == 0) {
                  var3.angle = 0;
               }

               var3.field1246 = var3.composition.field3556;
               var3.field1283 = var3.composition.field3577;
               var3.field1270 = var3.composition.field3575;
               var3.field1249 = var3.composition.field3570;
               var3.idlePoseAnimation = var3.composition.field3564;
               var3.field1290 = var3.composition.field3555;
               var3.field1245 = var3.composition.field3566;
               var3.method1692(XItemContainer.localPlayer.pathX[0] + var6, var8 + XItemContainer.localPlayer.pathY[0], var5 == 1);
               continue;
            }
         }

         Client.secretPacketBuffer2.method3384();
         return;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-2037096754"
   )
   public static int method563(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var4 + var6] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var4 + var6] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var4 + var6] = -124;
         } else if(var7 == 8230) {
            var3[var4 + var6] = -123;
         } else if(var7 == 8224) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var4 + var6] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var4 + var6] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(var7 == 8216) {
            var3[var4 + var6] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(var7 == 8226) {
            var3[var4 + var6] = -107;
         } else if(var7 == 8211) {
            var3[var4 + var6] = -106;
         } else if(var7 == 8212) {
            var3[var4 + var6] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var4 + var6] = -103;
         } else if(var7 == 353) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var4 + var6] = -101;
         } else if(var7 == 339) {
            var3[var4 + var6] = -100;
         } else if(var7 == 382) {
            var3[var4 + var6] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-28"
   )
   public static void method564() {
      ItemComposition.itemSpriteCache.reset();
   }
}
