import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("Varps")
public class Varps {
   @ObfuscatedName("m")
   @Export("Varps_masks")
   static int[] Varps_masks;
   @ObfuscatedName("f")
   @Export("Varps_temp")
   public static int[] Varps_temp;
   @ObfuscatedName("q")
   @Export("Varps_main")
   public static int[] Varps_main;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 120772859
   )
   @Export("__hv_h")
   static int __hv_h;

   static {
      Varps_masks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         Varps_masks[var1] = var0 - 1;
         var0 += var0;
      }

      Varps_temp = new int[4000];
      Varps_main = new int[4000];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;I)V",
      garbageValue = "2111080001"
   )
   public static void method4393(AbstractIndexCache var0) {
      UnderlayDefinition.UnderlayDefinition_indexCache = var0;
   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-1714608824"
   )
   static void method4400(Buffer var0) {
      if(Client.__client_ev != null) {
         var0.__s_297(Client.__client_ev, 0, Client.__client_ev.length);
      } else {
         byte[] var1 = AttackOption.method2032();
         var0.__s_297(var1, 0, var1.length);
      }
   }
}
