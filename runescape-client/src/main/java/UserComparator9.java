import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
   @ObfuscatedName("m")
   @Export("__m")
   final boolean __m;

   public UserComparator9(boolean var1) {
      this.__m = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "1966780392"
   )
   @Export("__m_264")
   int __m_264(Buddy var1, Buddy var2) {
      return Client.worldId == var1.world0 && var2.world0 == Client.worldId?(this.__m?var1.username().compareTo0(var2.username()):var2.username().compareTo0(var1.username())):this.__x_461(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_264((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   public static void method3343(boolean var0) {
      if(NetCache.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.writeByte(var0?2:3);
            var1.writeMedium(0);
            NetCache.NetCache_socket.write(var1.array, 0, 4);
         } catch (IOException var4) {
            try {
               NetCache.NetCache_socket.close();
            } catch (Exception var3) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)[Lln;",
      garbageValue = "-1724028611"
   )
   public static Sprite[] method3344() {
      Sprite[] var0 = new Sprite[class328.indexedSpriteCount];

      for(int var1 = 0; var1 < class328.indexedSpriteCount; ++var1) {
         Sprite var2 = var0[var1] = new Sprite();
         var2.width = class328.indexedSpriteWidth;
         var2.height = class328.indexedSpriteHeight;
         var2.yOffset = class328.indexedSpriteOffsetXs[var1];
         var2.xOffset = class328.indexedSpriteOffsetYs[var1];
         var2.subWidth = VarbitDefinition.indexedSpriteWidths[var1];
         var2.subHeight = SecureRandomCallable.indexedSpriteHeights[var1];
         int var3 = var2.subHeight * var2.subWidth;
         byte[] var4 = class328.spritePixels[var1];
         var2.pixels = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.pixels[var5] = class328.indexedSpritePalette[var4[var5] & 255];
         }
      }

      class328.indexedSpriteOffsetXs = null;
      class328.indexedSpriteOffsetYs = null;
      VarbitDefinition.indexedSpriteWidths = null;
      SecureRandomCallable.indexedSpriteHeights = null;
      class328.indexedSpritePalette = null;
      class328.spritePixels = null;
      return var0;
   }
}
