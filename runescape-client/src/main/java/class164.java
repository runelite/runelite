import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class164 {
   @ObfuscatedName("dp")
   static int[] field2652;
   @ObfuscatedName("x")
   static final char[] field2654 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("b")
   static final char[] field2658 = new char[]{'[', ']', '#'};

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1599797488"
   )
   static String method3251(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;B)V",
      garbageValue = "-110"
   )
   public static void method3257(class136 var0, Object var1) {
      if(var0.field2096 != null) {
         for(int var2 = 0; var2 < 50 && var0.field2096.peekEvent() != null; ++var2) {
            class98.method2264(1L);
         }

         if(null != var1) {
            var0.field2096.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2125546788"
   )
   static final void method3258(int var0, int var1) {
      if(client.field457 == 2) {
         class98.method2263(client.field316 + (client.field313 - class172.field2734 << 7), (client.field314 - class20.field576 << 7) + client.field317, client.field440 * 2);
         if(client.field395 > -1 && client.field301 % 20 < 10) {
            class9.field164[0].method1763(client.field395 + var0 - 12, client.field396 + var1 - 28);
         }

      }
   }
}
