import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
final class class217 implements Comparator {
   @ObfuscatedName("dv")
   @Export("xteaKeys")
   static int[][] field3163;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;B)I",
      garbageValue = "110"
   )
   int method3964(class214 var1, class214 var2) {
      return var1.field3148.field3172 < var2.field3148.field3172?-1:(var2.field3148.field3172 == var1.field3148.field3172?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method3964((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-653917312"
   )
   @Export("addMenuEntry")
   static final void method3974(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field428) {
         if(client.field429 < 500) {
            client.field434[client.field429] = var0;
            client.field396[client.field429] = var1;
            client.field432[client.field429] = var2;
            client.field433[client.field429] = var3;
            client.field419[client.field429] = var4;
            client.field431[client.field429] = var5;
            ++client.field429;
         }

      }
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "66"
   )
   static void method3975(int var0) {
      for(class201 var1 = (class201)client.field311.method3799(); null != var1; var1 = (class201)client.field311.method3800()) {
         if((long)var0 == (var1.field3113 >> 48 & 65535L)) {
            var1.method3916();
         }
      }

   }
}
