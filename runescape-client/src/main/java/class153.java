import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class153 extends class297 {
   @ObfuscatedName("c")
   final boolean field2131;

   public class153(boolean var1) {
      this.field2131 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "-1176040343"
   )
   int method3151(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2131?var1.field3839 - var2.field3839:var2.field3839 - var1.field3839):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3151((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   static void method3155() {
      for(class80 var0 = (class80)class80.field1261.getFront(); var0 != null; var0 = (class80)class80.field1261.getNext()) {
         if(var0.field1252 != null) {
            var0.method1732();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2029250245"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
