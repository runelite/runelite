import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class3 implements class0 {
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("v")
   @Export("tt")
   static int[] tt;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1547055431"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class19.field299 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class19.field299.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class19.field299.close();
            } catch (Exception var3) {
               ;
            }

            ++class245.field3324;
            class19.field299 = null;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1087750097"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      Friend.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(IIIILkb;Lhy;I)V",
      garbageValue = "-975270201"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5124(var10 + var5.field2673 / 2 - var4.maxWidth / 2, var5.field2672 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2673, var5.field2672, var5.field2675, var5.field2674);
            } else {
               var4.drawAt(var0 + var10 + var5.field2673 / 2 - var4.maxWidth / 2, var5.field2672 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
