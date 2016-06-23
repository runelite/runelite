import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class49 extends class204 {
   @ObfuscatedName("u")
   static class193 field1100 = new class193(64);
   @ObfuscatedName("x")
   public boolean field1101 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1987326895
   )
   public static int field1103;
   @ObfuscatedName("f")
   static class167 field1106;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "120"
   )
   void method1044(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1101 = true;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "7"
   )
   static final void method1047(boolean var0) {
      for(int var1 = 0; var1 < client.field494; ++var1) {
         class34 var2 = client.field328[client.field330[var1]];
         int var3 = (client.field330[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod790() && var0 == var2.field782.field898 && var2.field782.method814()) {
            int var4 = var2.field837 >> 7;
            int var5 = var2.field880 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field825 == 1 && (var2.field837 & 127) == 64 && (var2.field880 & 127) == 64) {
                  if(client.field337[var4][var5] == client.field552) {
                     continue;
                  }

                  client.field337[var4][var5] = client.field552;
               }

               if(!var2.field782.field926) {
                  var3 -= Integer.MIN_VALUE;
               }

               class129.field2056.method1986(class14.field212, var2.field837, var2.field880, class74.method1659(var2.field837 + (var2.field825 * 64 - 64), var2.field880 + (var2.field825 * 64 - 64), class14.field212), var2.field825 * 64 - 64 + 60, var2, var2.field883, var3, var2.field858);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "92"
   )
   void method1059(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method1044(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)[Lclass20;",
      garbageValue = "1066458965"
   )
   static class20[] method1062() {
      return new class20[]{class20.field578, class20.field574, class20.field573, class20.field575};
   }
}
