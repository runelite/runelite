import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class80 {
   @ObfuscatedName("o")
   @Export("__ce_o")
   static final BigInteger __ce_o;
   @ObfuscatedName("u")
   @Export("__ce_u")
   static final BigInteger __ce_u;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1844169387"
   )
   static void method2015() {
      if(Login.__cu_f) {
         Login.__cu_o = null;
         IndexCacheLoader.__bd_u = null;
         WorldMapEvent.__ap_w = null;
         Login.__cu_g = null;
         Fonts.__kz_l = null;
         WorldMapSectionType.__h_e = null;
         KeyHandler.__an_x = null;
         Login.__cu_d = null;
         class308.__kw_n = null;
         class30.__ar_bd = null;
         Frames.__en_bc = null;
         AttackOption.__cj_bo = null;
         UrlRequest.__ey_bx = null;
         class277.__jn_by = null;
         class16.field85.method1762();
         AbstractSocket.method3488(2);
         UserComparator9.method3343(true);
         Login.__cu_f = false;
      }

   }

   static {
      __ce_o = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      __ce_u = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }
}
