import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("UserComparator5")
public class UserComparator5 extends AbstractUserComparator {
   @ObfuscatedName("m")
   @Export("__m")
   final boolean __m;

   public UserComparator5(boolean var1) {
      this.__m = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "-22"
   )
   @Export("__m_272")
   int __m_272(Buddy var1, Buddy var2) {
      if(var1.world0 != 0) {
         if(var2.world0 == 0) {
            return this.__m?-1:1;
         }
      } else if(var2.world0 != 0) {
         return this.__m?1:-1;
      }

      return this.__x_461(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.__m_272((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(IIIILln;Lhp;I)V",
      garbageValue = "1263559944"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.minimapOrientation & 2047;
         int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
         int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.width / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         FaceNormal.__el_gm.__ah_514(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         NetFileRequest.method4554(var0, var1, var2, var3, var4, var5);
      }

   }
}
