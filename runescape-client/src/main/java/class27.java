import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class27 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__aq_k")
   public static AbstractIndexCache __aq_k;
   @ObfuscatedName("f")
   final int[] field225;

   class27() {
      this.field225 = new int[4096];
   }

   class27(int[] var1) {
      this.field225 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-695741813"
   )
   final int method430(int var1, int var2) {
      return this.field225[var1 + var2 * 64];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lge;",
      garbageValue = "37"
   )
   public static ServerPacket[] method429() {
      return new ServerPacket[]{ServerPacket.__ge_m, ServerPacket.__ge_f, ServerPacket.__ge_q, ServerPacket.__ge_w, ServerPacket.__ge_o, ServerPacket.__ge_u, ServerPacket.__ge_g, ServerPacket.__ge_l, ServerPacket.__ge_e, ServerPacket.__ge_x, ServerPacket.__ge_d, ServerPacket.__ge_k, ServerPacket.__ge_n, ServerPacket.__ge_i, ServerPacket.__ge_a, ServerPacket.__ge_z, ServerPacket.__ge_j, ServerPacket.__ge_s, ServerPacket.__ge_t, ServerPacket.__ge_y, ServerPacket.__ge_h, ServerPacket.__ge_b, ServerPacket.__ge_c, ServerPacket.__ge_r, ServerPacket.__ge_p, ServerPacket.__ge_v, ServerPacket.__ge_ag, ServerPacket.__ge_aq, ServerPacket.__ge_aj, ServerPacket.__ge_av, ServerPacket.__ge_ar, ServerPacket.__ge_ac, ServerPacket.__ge_ay, ServerPacket.__ge_ah, ServerPacket.__ge_ak, ServerPacket.__ge_aw, ServerPacket.__ge_al, ServerPacket.__ge_ab, ServerPacket.__ge_ae, ServerPacket.__ge_at, ServerPacket.__ge_ad, ServerPacket.__ge_ap, ServerPacket.__ge_as, ServerPacket.__ge_am, ServerPacket.__ge_an, ServerPacket.__ge_az, ServerPacket.__ge_au, ServerPacket.__ge_ao, ServerPacket.__ge_aa, ServerPacket.__ge_ax, ServerPacket.__ge_af, ServerPacket.__ge_ai, ServerPacket.__ge_ba, ServerPacket.__ge_bb, ServerPacket.__ge_bs, ServerPacket.__ge_bq, ServerPacket.__ge_bn, ServerPacket.__ge_bk, ServerPacket.__ge_bd, ServerPacket.__ge_bc, ServerPacket.__ge_bo, ServerPacket.__ge_bx, ServerPacket.__ge_by, ServerPacket.__ge_bu, ServerPacket.__ge_bm, ServerPacket.__ge_bl, ServerPacket.__ge_br, ServerPacket.__ge_bj, ServerPacket.__ge_bi, ServerPacket.__ge_bz, ServerPacket.__ge_bg, ServerPacket.__ge_bt, ServerPacket.__ge_bp, ServerPacket.__ge_bf, ServerPacket.__ge_bh, ServerPacket.__ge_be, ServerPacket.__ge_bv, ServerPacket.__ge_bw, ServerPacket.__ge_cr, ServerPacket.__ge_cv, ServerPacket.__ge_ce, ServerPacket.__ge_cy, ServerPacket.__ge_cs, ServerPacket.__ge_cm, ServerPacket.__ge_cj};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)Lln;",
      garbageValue = "-143338910"
   )
   public static final Sprite method438(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new Sprite(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new Sprite(0, 0);
   }
}
