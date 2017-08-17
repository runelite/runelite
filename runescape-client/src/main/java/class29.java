import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public final class class29 {
   @ObfuscatedName("fm")
   static byte[][] field431;
   @ObfuscatedName("kk")
   @ObfuscatedGetter(
      intValue = 1932446681
   )
   static int field434;
   @ObfuscatedName("qw")
   @ObfuscatedGetter(
      longValue = -6984682028476626979L
   )
   static long field429;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lam;"
   )
   final class41 this$0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1348264369
   )
   int field428;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 760801681
   )
   int field427;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -821774811
   )
   int field432;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1888552591
   )
   int field433;

   @ObfuscatedSignature(
      signature = "(Lam;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgd;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1171657639"
   )
   static String method261(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;B)V",
      garbageValue = "22"
   )
   public static void method260(IndexDataBase var0) {
      class253.field3385 = var0;
   }
}
