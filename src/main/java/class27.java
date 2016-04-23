import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class27 {
   @ObfuscatedName("w")
   static int[] field647;
   @ObfuscatedName("h")
   class35[] field648 = new class35[100];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -714408869
   )
   int field649;
   @ObfuscatedName("ke")
   static class19 field651;
   @ObfuscatedName("le")
   static class130 field653;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "103"
   )
   static void method630() {
      class5.field100 = (byte[][][])null;
      class5.field87 = (byte[][][])null;
      class51.field1138 = (byte[][][])null;
      class5.field88 = (byte[][][])null;
      class59.field1201 = (int[][][])null;
      class186.field3009 = (byte[][][])null;
      class5.field89 = (int[][])null;
      class4.field73 = null;
      class5.field90 = null;
      class94.field1597 = null;
      class109.field1889 = null;
      class109.field1895 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Lclass35;",
      garbageValue = "49"
   )
   class35 method631(int var1, String var2, String var3, String var4) {
      class35 var5 = this.field648[99];

      for(int var6 = this.field649; var6 > 0; --var6) {
         if(100 != var6) {
            this.field648[var6] = this.field648[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new class35(var1, var2, var4, var3);
      } else {
         var5.method3883();
         var5.method3863();
         var5.method729(var1, var2, var4, var3);
      }

      this.field648[0] = var5;
      if(this.field649 < 100) {
         ++this.field649;
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)Lclass35;",
      garbageValue = "-19101"
   )
   class35 method632(int var1) {
      return var1 >= 0 && var1 < this.field649?this.field648[var1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-830052771"
   )
   int method636() {
      return this.field649;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass136;Ljava/lang/Object;B)V",
      garbageValue = "0"
   )
   static void method638(class136 var0, Object var1) {
      if(null != var0.field2077) {
         for(int var2 = 0; var2 < 50 && var0.field2077.peekEvent() != null; ++var2) {
            class14.method170(1L);
         }

         if(null != var1) {
            var0.field2077.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "0"
   )
   public static byte[] method641(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var3;
      } else if(var0 instanceof class125) {
         class125 var2 = (class125)var0;
         return var2.vmethod2773();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
